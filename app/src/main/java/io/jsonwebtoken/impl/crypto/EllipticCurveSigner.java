package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.ECKey;

/* loaded from: classes2.dex */
public class EllipticCurveSigner extends EllipticCurveProvider implements Signer {
    public EllipticCurveSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        if ((key instanceof PrivateKey) && (key instanceof ECKey)) {
            return;
        }
        throw new IllegalArgumentException("Elliptic Curve signatures must be computed using an EC PrivateKey.  The specified key of type " + key.getClass().getName() + " is not an EC PrivateKey.");
    }

    public byte[] doSign(byte[] bArr) throws SignatureException, InvalidKeyException, JwtException {
        PrivateKey privateKey = (PrivateKey) this.key;
        Signature signatureCreateSignatureInstance = createSignatureInstance();
        signatureCreateSignatureInstance.initSign(privateKey);
        signatureCreateSignatureInstance.update(bArr);
        return EllipticCurveProvider.transcodeSignatureToConcat(signatureCreateSignatureInstance.sign(), EllipticCurveProvider.getSignatureByteArrayLength(this.alg));
    }

    @Override // io.jsonwebtoken.impl.crypto.Signer
    public byte[] sign(byte[] bArr) {
        try {
            return doSign(bArr);
        } catch (JwtException e2) {
            throw new io.jsonwebtoken.security.SignatureException("Unable to convert signature to JOSE format. " + e2.getMessage(), e2);
        } catch (InvalidKeyException e3) {
            throw new io.jsonwebtoken.security.SignatureException("Invalid Elliptic Curve PrivateKey. " + e3.getMessage(), e3);
        } catch (SignatureException e4) {
            throw new io.jsonwebtoken.security.SignatureException("Unable to calculate signature using Elliptic Curve PrivateKey. " + e4.getMessage(), e4);
        }
    }
}
