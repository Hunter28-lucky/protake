package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAKey;

/* loaded from: classes2.dex */
public class RsaSigner extends RsaProvider implements Signer {
    public RsaSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        if ((key instanceof PrivateKey) && (key instanceof RSAKey)) {
            return;
        }
        throw new IllegalArgumentException("RSA signatures must be computed using an RSA PrivateKey.  The specified key of type " + key.getClass().getName() + " is not an RSA PrivateKey.");
    }

    public byte[] doSign(byte[] bArr) throws SignatureException, InvalidKeyException {
        PrivateKey privateKey = (PrivateKey) this.key;
        Signature signatureCreateSignatureInstance = createSignatureInstance();
        signatureCreateSignatureInstance.initSign(privateKey);
        signatureCreateSignatureInstance.update(bArr);
        return signatureCreateSignatureInstance.sign();
    }

    @Override // io.jsonwebtoken.impl.crypto.Signer
    public byte[] sign(byte[] bArr) {
        try {
            return doSign(bArr);
        } catch (InvalidKeyException e2) {
            throw new io.jsonwebtoken.security.SignatureException("Invalid RSA PrivateKey. " + e2.getMessage(), e2);
        } catch (SignatureException e3) {
            throw new io.jsonwebtoken.security.SignatureException("Unable to calculate signature using RSA PrivateKey. " + e3.getMessage(), e3);
        }
    }
}
