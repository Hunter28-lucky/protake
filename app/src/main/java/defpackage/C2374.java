package defpackage;

import java.nio.charset.Charset;
import okio.ByteString;

/* compiled from: Credentials.kt */
/* renamed from: ŗ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2374 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C2374 f8924 = new C2374();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String m8841(String str, String str2, Charset charset) {
        C3921.m12667(str, "username");
        C3921.m12667(str2, "password");
        C3921.m12667(charset, "charset");
        return "Basic " + ByteString.Companion.encodeString(str + ':' + str2, charset).base64();
    }
}
