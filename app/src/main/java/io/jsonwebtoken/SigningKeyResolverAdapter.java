package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class SigningKeyResolverAdapter implements SigningKeyResolver {
    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) throws io.jsonwebtoken.security.SignatureException {
        SignatureAlgorithm signatureAlgorithmForName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        Assert.isTrue(signatureAlgorithmForName.isHmac(), "The default resolveSigningKey(JwsHeader, Claims) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, Claims) method instead and return a Key instance appropriate for the " + signatureAlgorithmForName.name() + " algorithm.");
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, claims), signatureAlgorithmForName.getJcaName());
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, Claims claims) {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support Claims JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, Claims) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, Claims) method.");
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, String str) {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support plaintext JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, String) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, String) method.");
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(JwsHeader jwsHeader, String str) throws io.jsonwebtoken.security.SignatureException {
        SignatureAlgorithm signatureAlgorithmForName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        Assert.isTrue(signatureAlgorithmForName.isHmac(), "The default resolveSigningKey(JwsHeader, String) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, String) method instead and return a Key instance appropriate for the " + signatureAlgorithmForName.name() + " algorithm.");
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, str), signatureAlgorithmForName.getJcaName());
    }
}
