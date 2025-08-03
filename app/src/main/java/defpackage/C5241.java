package defpackage;

import com.google.zxing.qrcode.encoder.Encoder;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

/* compiled from: Charsets.kt */
/* renamed from: Ⴡ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5241 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C5241 f17364 = new C5241();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Charset f17365;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Charset f17366;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Charset f17367;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Charset f17368;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Charset f17369;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Charset f17370;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static Charset f17371;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static Charset f17372;

    static {
        Charset charsetForName = Charset.forName(Platform.UTF_8);
        C3921.m12665(charsetForName, "forName(\"UTF-8\")");
        f17365 = charsetForName;
        Charset charsetForName2 = Charset.forName(Platform.UTF_16);
        C3921.m12665(charsetForName2, "forName(\"UTF-16\")");
        f17366 = charsetForName2;
        Charset charsetForName3 = Charset.forName(Platform.UTF_16BE);
        C3921.m12665(charsetForName3, "forName(\"UTF-16BE\")");
        f17367 = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        C3921.m12665(charsetForName4, "forName(\"UTF-16LE\")");
        f17368 = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        C3921.m12665(charsetForName5, "forName(\"US-ASCII\")");
        f17369 = charsetForName5;
        Charset charsetForName6 = Charset.forName(Encoder.DEFAULT_BYTE_MODE_ENCODING);
        C3921.m12665(charsetForName6, "forName(\"ISO-8859-1\")");
        f17370 = charsetForName6;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Charset m15260() {
        Charset charset = f17372;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        C3921.m12665(charsetForName, "forName(\"UTF-32BE\")");
        f17372 = charsetForName;
        return charsetForName;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Charset m15261() {
        Charset charset = f17371;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        C3921.m12665(charsetForName, "forName(\"UTF-32LE\")");
        f17371 = charsetForName;
        return charsetForName;
    }
}
