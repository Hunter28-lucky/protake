package io.jsonwebtoken;

import io.jsonwebtoken.io.Decoder;
import io.jsonwebtoken.io.Deserializer;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/* loaded from: classes2.dex */
public interface JwtParser {
    public static final char SEPARATOR_CHAR = '.';

    JwtParser base64UrlDecodeWith(Decoder<String, byte[]> decoder);

    JwtParser deserializeJsonWith(Deserializer<Map<String, ?>> deserializer);

    boolean isSigned(String str);

    Jwt parse(String str) throws MalformedJwtException, ExpiredJwtException, IllegalArgumentException, io.jsonwebtoken.security.SignatureException;

    <T> T parse(String str, JwtHandler<T> jwtHandler) throws UnsupportedJwtException, MalformedJwtException, ExpiredJwtException, IllegalArgumentException, io.jsonwebtoken.security.SignatureException;

    Jws<Claims> parseClaimsJws(String str) throws UnsupportedJwtException, MalformedJwtException, ExpiredJwtException, IllegalArgumentException, io.jsonwebtoken.security.SignatureException;

    Jwt<Header, Claims> parseClaimsJwt(String str) throws UnsupportedJwtException, MalformedJwtException, ExpiredJwtException, IllegalArgumentException, io.jsonwebtoken.security.SignatureException;

    Jws<String> parsePlaintextJws(String str) throws UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, io.jsonwebtoken.security.SignatureException;

    Jwt<Header, String> parsePlaintextJwt(String str) throws UnsupportedJwtException, MalformedJwtException, IllegalArgumentException, io.jsonwebtoken.security.SignatureException;

    JwtParser require(String str, Object obj);

    JwtParser requireAudience(String str);

    JwtParser requireExpiration(Date date);

    JwtParser requireId(String str);

    JwtParser requireIssuedAt(Date date);

    JwtParser requireIssuer(String str);

    JwtParser requireNotBefore(Date date);

    JwtParser requireSubject(String str);

    JwtParser setAllowedClockSkewSeconds(long j);

    JwtParser setClock(Clock clock);

    JwtParser setCompressionCodecResolver(CompressionCodecResolver compressionCodecResolver);

    JwtParser setSigningKey(String str);

    JwtParser setSigningKey(Key key);

    JwtParser setSigningKey(byte[] bArr);

    JwtParser setSigningKeyResolver(SigningKeyResolver signingKeyResolver);
}
