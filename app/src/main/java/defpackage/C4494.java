package defpackage;

import android.util.Base64;
import com.blink.academy.film.http.okhttp.utils.HttpUtil;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* compiled from: Security.java */
/* renamed from: ௐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4494 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static PublicKey m13783(String str) throws IOException {
        try {
            return KeyFactory.getInstance(HttpUtil.RSA).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            throw new IOException("Invalid key specification: " + e3);
        }
    }
}
