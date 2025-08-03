package io.jsonwebtoken.impl;

import io.jsonwebtoken.ClaimJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecResolver;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.InvalidClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtHandler;
import io.jsonwebtoken.JwtHandlerAdapter;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.PrematureJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.compression.DefaultCompressionCodecResolver;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import io.jsonwebtoken.impl.crypto.JwtSignatureValidator;
import io.jsonwebtoken.impl.io.InstanceLocator;
import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.io.DeserializationException;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.DateFormats;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.SignatureException;
import io.jsonwebtoken.security.WeakKeyException;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class DefaultJwtParser implements JwtParser {
    private static final int MILLISECONDS_PER_SECOND = 1000;
    private Deserializer<Map<String, ?>> deserializer;
    private Key key;
    private byte[] keyBytes;
    private SigningKeyResolver signingKeyResolver;
    private CompressionCodecResolver compressionCodecResolver = new DefaultCompressionCodecResolver();
    private Decoder<String, byte[]> base64UrlDecoder = Decoders.BASE64URL;
    private Claims expectedClaims = new DefaultClaims();
    private Clock clock = DefaultClock.INSTANCE;
    private long allowedClockSkewMillis = 0;

    private static Object normalize(Object obj) {
        return obj instanceof Integer ? Long.valueOf(((Integer) obj).longValue()) : obj;
    }

    private void validateExpectedClaims(Header header, Claims claims) {
        for (String str : this.expectedClaims.keySet()) {
            Object objNormalize = normalize(this.expectedClaims.get(str));
            Object objNormalize2 = normalize(claims.get(str));
            if (objNormalize instanceof Date) {
                try {
                    objNormalize2 = claims.get(str, Date.class);
                } catch (Exception unused) {
                    throw new IncorrectClaimException(header, claims, "JWT Claim '" + str + "' was expected to be a Date, but its value cannot be converted to a Date using current heuristics.  Value: " + objNormalize2);
                }
            }
            InvalidClaimException incorrectClaimException = null;
            if (objNormalize2 == null) {
                incorrectClaimException = new MissingClaimException(header, claims, String.format(ClaimJwtException.MISSING_EXPECTED_CLAIM_MESSAGE_TEMPLATE, str, objNormalize));
            } else if (!objNormalize.equals(objNormalize2)) {
                incorrectClaimException = new IncorrectClaimException(header, claims, String.format(ClaimJwtException.INCORRECT_EXPECTED_CLAIM_MESSAGE_TEMPLATE, str, objNormalize, objNormalize2));
            }
            if (incorrectClaimException != null) {
                incorrectClaimException.setClaimName(str);
                incorrectClaimException.setClaimValue(objNormalize);
                throw incorrectClaimException;
            }
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder) {
        Assert.notNull(decoder, "base64UrlDecoder cannot be null.");
        this.base64UrlDecoder = decoder;
        return this;
    }

    public JwtSignatureValidator createSignatureValidator(SignatureAlgorithm signatureAlgorithm, Key key) {
        return new DefaultJwtSignatureValidator(signatureAlgorithm, key, this.base64UrlDecoder);
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer) {
        Assert.notNull(deserializer, "deserializer cannot be null.");
        this.deserializer = deserializer;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public boolean isSigned(String str) {
        if (str == null) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (i == 2) {
                return (Character.isWhitespace(cCharAt) || cCharAt == '.') ? false : true;
            }
            if (cCharAt == '.') {
                i++;
            }
        }
        return false;
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt parse(String str) throws MalformedJwtException, ExpiredJwtException, DecodingException, CompressionException, SignatureException {
        CompressionCodec compressionCodecResolveCompressionCodec;
        Header defaultJwsHeader;
        Claims claims;
        String str2;
        SigningKeyResolver signingKeyResolver;
        if (this.deserializer == null) {
            this.deserializer = (Deserializer) ((InstanceLocator) Classes.newInstance("io.jsonwebtoken.impl.io.RuntimeClasspathDeserializerLocator")).getInstance2();
        }
        Assert.hasText(str, "JWT String argument cannot be null or empty.");
        StringBuilder sb = new StringBuilder(128);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        SignatureAlgorithm signatureAlgorithmForName = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char c = charArray[i];
            if (c == '.') {
                CharSequence charSequenceClean = Strings.clean(sb);
                String string = charSequenceClean != null ? charSequenceClean.toString() : null;
                if (i2 == 0) {
                    str4 = string;
                } else if (i2 == 1) {
                    str3 = string;
                }
                i2++;
                sb.setLength(0);
            } else {
                sb.append(c);
            }
            i++;
        }
        if (i2 != 2) {
            throw new MalformedJwtException("JWT strings must contain exactly 2 period characters. Found: " + i2);
        }
        String string2 = sb.length() > 0 ? sb.toString() : null;
        if (str3 == null) {
            throw new MalformedJwtException("JWT string '" + str + "' is missing a body/payload.");
        }
        if (str4 != null) {
            Map<String, ?> value = readValue(new String(this.base64UrlDecoder.decode(str4), Strings.UTF_8));
            defaultJwsHeader = string2 != null ? new DefaultJwsHeader(value) : new DefaultHeader(value);
            compressionCodecResolveCompressionCodec = this.compressionCodecResolver.resolveCompressionCodec(defaultJwsHeader);
        } else {
            compressionCodecResolveCompressionCodec = null;
            defaultJwsHeader = null;
        }
        byte[] bArrDecode = this.base64UrlDecoder.decode(str3);
        if (compressionCodecResolveCompressionCodec != null) {
            bArrDecode = compressionCodecResolveCompressionCodec.decompress(bArrDecode);
        }
        String str5 = new String(bArrDecode, Strings.UTF_8);
        DefaultClaims defaultClaims = (str5.charAt(0) == '{' && str5.charAt(str5.length() - 1) == '}') ? new DefaultClaims(readValue(str5)) : null;
        if (string2 != null) {
            JwsHeader jwsHeader = (JwsHeader) defaultJwsHeader;
            if (defaultJwsHeader != null) {
                String algorithm = jwsHeader.getAlgorithm();
                if (Strings.hasText(algorithm)) {
                    signatureAlgorithmForName = SignatureAlgorithm.forName(algorithm);
                }
            }
            if (signatureAlgorithmForName == null || signatureAlgorithmForName == SignatureAlgorithm.NONE) {
                throw new MalformedJwtException("JWT string has a digest/signature, but the header does not reference a valid signature algorithm.");
            }
            Key secretKeySpec = this.key;
            if (secretKeySpec != null && this.keyBytes != null) {
                throw new IllegalStateException("A key object and key bytes cannot both be specified. Choose either.");
            }
            if ((secretKeySpec != null || this.keyBytes != null) && this.signingKeyResolver != null) {
                throw new IllegalStateException("A signing key resolver and " + (secretKeySpec != null ? "a key object" : "key bytes") + " cannot both be specified. Choose either.");
            }
            if (secretKeySpec == null) {
                byte[] bArr = this.keyBytes;
                if (Objects.isEmpty(bArr) && (signingKeyResolver = this.signingKeyResolver) != null) {
                    secretKeySpec = defaultClaims != null ? signingKeyResolver.resolveSigningKey(jwsHeader, defaultClaims) : signingKeyResolver.resolveSigningKey(jwsHeader, str5);
                }
                if (!Objects.isEmpty(bArr)) {
                    Assert.isTrue(signatureAlgorithmForName.isHmac(), "Key bytes can only be specified for HMAC signatures. Please specify a PublicKey or PrivateKey instance.");
                    secretKeySpec = new SecretKeySpec(bArr, signatureAlgorithmForName.getJcaName());
                }
            }
            Assert.notNull(secretKeySpec, "A signing key must be specified if the specified JWT is digitally signed.");
            String str6 = str4 + JwtParser.SEPARATOR_CHAR + str3;
            try {
                signatureAlgorithmForName.assertValidVerificationKey(secretKeySpec);
                if (!createSignatureValidator(signatureAlgorithmForName, secretKeySpec).isValid(str6, string2)) {
                    throw new SignatureException("JWT signature does not match locally computed signature. JWT validity cannot be asserted and should not be trusted.");
                }
            } catch (WeakKeyException e2) {
                throw e2;
            } catch (InvalidKeyException e3) {
                e = e3;
                String value2 = signatureAlgorithmForName.getValue();
                throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the " + value2 + " signature algorithm, but the specified signing key of type " + secretKeySpec.getClass().getName() + " may not be used to validate " + value2 + " signatures.  Because the specified signing key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was configured with the incorrect signing key, but this cannot be assumed for security reasons.", e);
            } catch (IllegalArgumentException e4) {
                e = e4;
                String value22 = signatureAlgorithmForName.getValue();
                throw new UnsupportedJwtException("The parsed JWT indicates it was signed with the " + value22 + " signature algorithm, but the specified signing key of type " + secretKeySpec.getClass().getName() + " may not be used to validate " + value22 + " signatures.  Because the specified signing key reflects a specific and expected algorithm, and the JWT does not reflect this algorithm, it is likely that the JWT was not expected and therefore should not be trusted.  Another possibility is that the parser was configured with the incorrect signing key, but this cannot be assumed for security reasons.", e);
            }
        }
        boolean z = this.allowedClockSkewMillis > 0;
        if (defaultClaims != null) {
            Date dateNow = this.clock.now();
            long time = dateNow.getTime();
            Date expiration = defaultClaims.getExpiration();
            if (expiration != null) {
                DefaultClaims defaultClaims2 = defaultClaims;
                long j = time - this.allowedClockSkewMillis;
                if ((z ? new Date(j) : dateNow).after(expiration)) {
                    throw new ExpiredJwtException(defaultJwsHeader, defaultClaims2, "JWT expired at " + DateFormats.formatIso8601(expiration, false) + ". Current time: " + DateFormats.formatIso8601(dateNow, false) + ", a difference of " + (j - expiration.getTime()) + " milliseconds.  Allowed clock skew: " + this.allowedClockSkewMillis + " milliseconds.");
                }
                claims = defaultClaims2;
            } else {
                claims = defaultClaims;
            }
            Date notBefore = claims.getNotBefore();
            str2 = string2;
            if (notBefore != null) {
                Header header = defaultJwsHeader;
                long j2 = time + this.allowedClockSkewMillis;
                if ((z ? new Date(j2) : dateNow).before(notBefore)) {
                    throw new PrematureJwtException(header, claims, "JWT must not be accepted before " + DateFormats.formatIso8601(notBefore, false) + ". Current time: " + DateFormats.formatIso8601(dateNow, false) + ", a difference of " + (notBefore.getTime() - j2) + " milliseconds.  Allowed clock skew: " + this.allowedClockSkewMillis + " milliseconds.");
                }
                defaultJwsHeader = header;
            }
            validateExpectedClaims(defaultJwsHeader, claims);
        } else {
            claims = defaultClaims;
            str2 = string2;
        }
        if (claims != null) {
            str5 = claims;
        }
        return str2 != null ? new DefaultJws((JwsHeader) defaultJwsHeader, str5, str2) : new DefaultJwt(defaultJwsHeader, str5);
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<Claims> parseClaimsJws(String str) {
        return (Jws) parse(str, new JwtHandlerAdapter<Jws<Claims>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.4
            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public Jws<Claims> onClaimsJws(Jws<Claims> jws) {
                return jws;
            }

            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public /* bridge */ /* synthetic */ Object onClaimsJws(Jws jws) {
                return onClaimsJws((Jws<Claims>) jws);
            }
        });
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, Claims> parseClaimsJwt(String str) {
        try {
            return (Jwt) parse(str, new JwtHandlerAdapter<Jwt<Header, Claims>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.2
                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public Jwt<Header, Claims> onClaimsJwt(Jwt<Header, Claims> jwt) {
                    return jwt;
                }

                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public /* bridge */ /* synthetic */ Object onClaimsJwt(Jwt jwt) {
                    return onClaimsJwt((Jwt<Header, Claims>) jwt);
                }
            });
        } catch (IllegalArgumentException e2) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", e2);
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jws<String> parsePlaintextJws(String str) {
        try {
            return (Jws) parse(str, new JwtHandlerAdapter<Jws<String>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.3
                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public Jws<String> onPlaintextJws(Jws<String> jws) {
                    return jws;
                }

                @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
                public /* bridge */ /* synthetic */ Object onPlaintextJws(Jws jws) {
                    return onPlaintextJws((Jws<String>) jws);
                }
            });
        } catch (IllegalArgumentException e2) {
            throw new UnsupportedJwtException("Signed JWSs are not supported.", e2);
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public Jwt<Header, String> parsePlaintextJwt(String str) {
        return (Jwt) parse(str, new JwtHandlerAdapter<Jwt<Header, String>>() { // from class: io.jsonwebtoken.impl.DefaultJwtParser.1
            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public Jwt<Header, String> onPlaintextJwt(Jwt<Header, String> jwt) {
                return jwt;
            }

            @Override // io.jsonwebtoken.JwtHandlerAdapter, io.jsonwebtoken.JwtHandler
            public /* bridge */ /* synthetic */ Object onPlaintextJwt(Jwt jwt) {
                return onPlaintextJwt((Jwt<Header, String>) jwt);
            }
        });
    }

    public Map<String, ?> readValue(String str) {
        try {
            return this.deserializer.deserialize(str.getBytes(Strings.UTF_8));
        } catch (DeserializationException e2) {
            throw new MalformedJwtException("Unable to read JSON value: " + str, e2);
        }
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser require(String str, Object obj) {
        Assert.hasText(str, "claim name cannot be null or empty.");
        Assert.notNull(obj, "The value cannot be null for claim name: " + str);
        this.expectedClaims.put(str, obj);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireAudience(String str) {
        this.expectedClaims.setAudience(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireExpiration(Date date) {
        this.expectedClaims.setExpiration(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireId(String str) {
        this.expectedClaims.setId(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuedAt(Date date) {
        this.expectedClaims.setIssuedAt(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireIssuer(String str) {
        this.expectedClaims.setIssuer(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireNotBefore(Date date) {
        this.expectedClaims.setNotBefore(date);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser requireSubject(String str) {
        this.expectedClaims.setSubject(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setAllowedClockSkewSeconds(long j) {
        this.allowedClockSkewMillis = Math.max(0L, j * 1000);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setClock(Clock clock) {
        Assert.notNull(clock, "Clock instance cannot be null.");
        this.clock = clock;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver) {
        Assert.notNull(compressionCodecResolver, "compressionCodecResolver cannot be null.");
        this.compressionCodecResolver = compressionCodecResolver;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(byte[] bArr) {
        Assert.notEmpty(bArr, "signing key cannot be null or empty.");
        this.keyBytes = bArr;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver) {
        Assert.notNull(signingKeyResolver, "SigningKeyResolver cannot be null.");
        this.signingKeyResolver = signingKeyResolver;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(String str) {
        Assert.hasText(str, "signing key cannot be null or empty.");
        this.keyBytes = Decoders.BASE64.decode(str);
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public JwtParser setSigningKey(Key key) {
        Assert.notNull(key, "signing key cannot be null.");
        this.key = key;
        return this;
    }

    @Override // io.jsonwebtoken.JwtParser
    public <T> T parse(String str, JwtHandler<T> jwtHandler) throws MalformedJwtException, ExpiredJwtException, DecodingException, CompressionException, SignatureException {
        Assert.notNull(jwtHandler, "JwtHandler argument cannot be null.");
        Assert.hasText(str, "JWT String argument cannot be null or empty.");
        Jwt<Header, String> jwt = parse(str);
        if (jwt instanceof Jws) {
            Jws<String> jws = (Jws) jwt;
            if (jws.getBody() instanceof Claims) {
                return jwtHandler.onClaimsJws(jws);
            }
            return jwtHandler.onPlaintextJws(jws);
        }
        if (jwt.getBody() instanceof Claims) {
            return jwtHandler.onClaimsJwt(jwt);
        }
        return jwtHandler.onPlaintextJwt(jwt);
    }
}
