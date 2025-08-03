package defpackage;

import defpackage.C5207;
import java.io.IOException;
import okio.BufferedSource;

/* compiled from: HeadersReader.kt */
/* renamed from: в, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2879 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C2880 f10547 = new C2880(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long f10548;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final BufferedSource f10549;

    /* compiled from: HeadersReader.kt */
    /* renamed from: в$Ϳ, reason: contains not printable characters */
    public static final class C2880 {
        public C2880() {
        }

        public /* synthetic */ C2880(C4184 c4184) {
            this();
        }
    }

    public C2879(BufferedSource bufferedSource) {
        C3921.m12667(bufferedSource, "source");
        this.f10549 = bufferedSource;
        this.f10548 = 262144;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C5207 m10229() throws IOException {
        C5207.C5208 c5208 = new C5207.C5208();
        while (true) {
            String strM10230 = m10230();
            if (strM10230.length() == 0) {
                return c5208.m15191();
            }
            c5208.m15188(strM10230);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m10230() throws IOException {
        String utf8LineStrict = this.f10549.readUtf8LineStrict(this.f10548);
        this.f10548 -= utf8LineStrict.length();
        return utf8LineStrict;
    }
}
