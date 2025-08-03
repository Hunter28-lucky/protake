package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class MacSigner extends MacProvider implements Signer {
    public MacSigner(SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this(signatureAlgorithm, new SecretKeySpec(bArr, signatureAlgorithm.getJcaName()));
    }

    public Mac doGetMacInstance() throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(this.alg.getJcaName());
        mac.init(this.key);
        return mac;
    }

    public Mac getMacInstance() throws SignatureException {
        try {
            return doGetMacInstance();
        } catch (InvalidKeyException e2) {
            throw new SignatureException("The specified signing key is not a valid " + this.alg.name() + " key: " + e2.getMessage(), e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new SignatureException("Unable to obtain JCA MAC algorithm '" + this.alg.getJcaName() + "': " + e3.getMessage(), e3);
        }
    }

    @Override // io.jsonwebtoken.impl.crypto.Signer
    public byte[] sign(byte[] bArr) {
        return getMacInstance().doFinal(bArr);
    }

    public MacSigner(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isHmac(), "The MacSigner only supports HMAC signature algorithms.");
        if (key instanceof SecretKey) {
            return;
        }
        throw new IllegalArgumentException("MAC signatures must be computed and verified using a SecretKey.  The specified key of type " + key.getClass().getName() + " is not a SecretKey.");
    }
}
