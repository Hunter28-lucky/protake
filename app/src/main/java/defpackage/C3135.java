package defpackage;

import defpackage.C3573;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: FormBody.kt */
/* renamed from: ӿ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3135 extends AbstractC2613 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final List<String> f11139;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<String> f11140;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C3137 f11138 = new C3137(null);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C2314 f11137 = C2314.f8797.m8688("application/x-www-form-urlencoded");

    /* compiled from: FormBody.kt */
    /* renamed from: ӿ$Ԩ, reason: contains not printable characters */
    public static final class C3137 {
        public C3137() {
        }

        public /* synthetic */ C3137(C4184 c4184) {
            this();
        }
    }

    public C3135(List<String> list, List<String> list2) {
        C3921.m12667(list, "encodedNames");
        C3921.m12667(list2, "encodedValues");
        this.f11139 = i5.m6271(list);
        this.f11140 = i5.m6271(list2);
    }

    @Override // defpackage.AbstractC2613
    public long contentLength() {
        return m10729(null, true);
    }

    @Override // defpackage.AbstractC2613
    public C2314 contentType() {
        return f11137;
    }

    @Override // defpackage.AbstractC2613
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C3921.m12667(bufferedSink, "sink");
        m10729(bufferedSink, false);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m10726(int i) {
        return this.f11139.get(i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m10727(int i) {
        return this.f11140.get(i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m10728() {
        return this.f11139.size();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final long m10729(BufferedSink bufferedSink, boolean z) throws EOFException {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            if (bufferedSink == null) {
                C3921.m12675();
            }
            buffer = bufferedSink.getBuffer();
        }
        int size = this.f11139.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f11139.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f11140.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    /* compiled from: FormBody.kt */
    /* renamed from: ӿ$Ϳ, reason: contains not printable characters */
    public static final class C3136 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final List<String> f11141;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final List<String> f11142;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final Charset f11143;

        public C3136() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public C3136(Charset charset) {
            this.f11143 = charset;
            this.f11141 = new ArrayList();
            this.f11142 = new ArrayList();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C3136 m10730(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            List<String> list = this.f11141;
            C3573.C3576 c3576 = C3573.f12453;
            list.add(C3573.C3576.m11578(c3576, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f11143, 91, null));
            this.f11142.add(C3573.C3576.m11578(c3576, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.f11143, 91, null));
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3136 m10731(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            List<String> list = this.f11141;
            C3573.C3576 c3576 = C3573.f12453;
            list.add(C3573.C3576.m11578(c3576, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f11143, 83, null));
            this.f11142.add(C3573.C3576.m11578(c3576, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.f11143, 83, null));
            return this;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C3135 m10732() {
            return new C3135(this.f11141, this.f11142);
        }

        public /* synthetic */ C3136(Charset charset, int i, C4184 c4184) {
            this((i & 1) != 0 ? null : charset);
        }
    }
}
