package io.jsonwebtoken.impl.crypto;

import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.RuntimeEnvironment;
import io.jsonwebtoken.security.SignatureException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class RsaProvider extends SignatureProvider {
    private static final Map<SignatureAlgorithm, PSSParameterSpec> PSS_PARAMETER_SPECS = createPssParameterSpecs();

    /* renamed from: io.jsonwebtoken.impl.crypto.RsaProvider$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$jsonwebtoken$SignatureAlgorithm;

        static {
            int[] iArr = new int[SignatureAlgorithm.values().length];
            $SwitchMap$io$jsonwebtoken$SignatureAlgorithm = iArr;
            try {
                iArr[SignatureAlgorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.RS384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$jsonwebtoken$SignatureAlgorithm[SignatureAlgorithm.PS384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        RuntimeEnvironment.enableBouncyCastleIfPossible();
    }

    public RsaProvider(SignatureAlgorithm signatureAlgorithm, Key key) {
        super(signatureAlgorithm, key);
        Assert.isTrue(signatureAlgorithm.isRsa(), "SignatureAlgorithm must be an RSASSA or RSASSA-PSS algorithm.");
    }

    private static Map<SignatureAlgorithm, PSSParameterSpec> createPssParameterSpecs() {
        HashMap map = new HashMap();
        MGF1ParameterSpec mGF1ParameterSpec = MGF1ParameterSpec.SHA256;
        map.put(SignatureAlgorithm.PS256, new PSSParameterSpec(mGF1ParameterSpec.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec, 32, 1));
        MGF1ParameterSpec mGF1ParameterSpec2 = MGF1ParameterSpec.SHA384;
        map.put(SignatureAlgorithm.PS384, new PSSParameterSpec(mGF1ParameterSpec2.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec2, 48, 1));
        MGF1ParameterSpec mGF1ParameterSpec3 = MGF1ParameterSpec.SHA512;
        map.put(SignatureAlgorithm.PS512, new PSSParameterSpec(mGF1ParameterSpec3.getDigestAlgorithm(), "MGF1", mGF1ParameterSpec3, 64, 1));
        return map;
    }

    public static KeyPair generateKeyPair() {
        return generateKeyPair(4096);
    }

    @Override // io.jsonwebtoken.impl.crypto.SignatureProvider
    public Signature createSignatureInstance() {
        Signature signatureCreateSignatureInstance = super.createSignatureInstance();
        PSSParameterSpec pSSParameterSpec = PSS_PARAMETER_SPECS.get(this.alg);
        if (pSSParameterSpec != null) {
            setParameter(signatureCreateSignatureInstance, pSSParameterSpec);
        }
        return signatureCreateSignatureInstance;
    }

    public void doSetParameter(Signature signature, PSSParameterSpec pSSParameterSpec) throws InvalidAlgorithmParameterException {
        signature.setParameter(pSSParameterSpec);
    }

    public void setParameter(Signature signature, PSSParameterSpec pSSParameterSpec) {
        try {
            doSetParameter(signature, pSSParameterSpec);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new SignatureException("Unsupported RSASSA-PSS parameter '" + pSSParameterSpec + "': " + e2.getMessage(), e2);
        }
    }

    public static KeyPair generateKeyPair(int i) {
        return generateKeyPair(i, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(SignatureAlgorithm signatureAlgorithm) {
        Assert.isTrue(signatureAlgorithm.isRsa(), "Only RSA algorithms are supported by this method.");
        int i = AnonymousClass1.$SwitchMap$io$jsonwebtoken$SignatureAlgorithm[signatureAlgorithm.ordinal()];
        return generateKeyPair((i == 1 || i == 2) ? 2048 : (i == 3 || i == 4) ? 3072 : 4096, SignatureProvider.DEFAULT_SECURE_RANDOM);
    }

    public static KeyPair generateKeyPair(int i, SecureRandom secureRandom) {
        return generateKeyPair(HttpUtil.RSA, i, secureRandom);
    }

    public static KeyPair generateKeyPair(String str, int i, SecureRandom secureRandom) throws NoSuchAlgorithmException {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str);
            keyPairGenerator.initialize(i, secureRandom);
            return keyPairGenerator.genKeyPair();
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("Unable to obtain an RSA KeyPairGenerator: " + e2.getMessage(), e2);
        }
    }
}
