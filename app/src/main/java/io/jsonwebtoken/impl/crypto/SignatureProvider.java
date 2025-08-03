package io.jsonwebtoken.impl.crypto;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;

/* loaded from: classes2.dex */
abstract class SignatureProvider {
    public static final SecureRandom DEFAULT_SECURE_RANDOM;
    public final SignatureAlgorithm alg;
    public final Key key;

    static {
        SecureRandom secureRandom = new SecureRandom();
        DEFAULT_SECURE_RANDOM = secureRandom;
        secureRandom.nextBytes(new byte[64]);
    }

    public SignatureProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        Assert.notNull(signatureAlgorithm, "SignatureAlgorithm cannot be null.");
        Assert.notNull(key, "Key cannot be null.");
        this.alg = signatureAlgorithm;
        this.key = key;
    }

    public Signature createSignatureInstance() {
        try {
            return getSignatureInstance();
        } catch (NoSuchAlgorithmException e2) {
            String str = "Unavailable " + this.alg.getFamilyName() + " Signature algorithm '" + this.alg.getJcaName() + "'.";
            if (!this.alg.isJdkStandard() && !isBouncyCastleAvailable()) {
                str = str + " This is not a standard JDK algorithm. Try including BouncyCastle in the runtime classpath.";
            }
            throw new SignatureException(str, e2);
        }
    }

    public Signature getSignatureInstance() throws NoSuchAlgorithmException {
        return Signature.getInstance(this.alg.getJcaName());
    }

    public boolean isBouncyCastleAvailable() {
        return RuntimeEnvironment.BOUNCY_CASTLE_AVAILABLE;
    }
}
