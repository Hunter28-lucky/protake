package defpackage;

import defpackage.C5207;
import java.io.Closeable;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;

/* compiled from: Response.kt */
/* renamed from: අ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4770 implements Closeable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public C2789 f16071;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C4539 f16072;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Protocol f16073;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String f16074;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f16075;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Handshake f16076;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C5207 f16077;

    /* renamed from: ֏, reason: contains not printable characters */
    public final AbstractC4809 f16078;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final C4770 f16079;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final C4770 f16080;

    /* renamed from: ހ, reason: contains not printable characters */
    public final C4770 f16081;

    /* renamed from: ށ, reason: contains not printable characters */
    public final long f16082;

    /* renamed from: ނ, reason: contains not printable characters */
    public final long f16083;

    /* renamed from: ރ, reason: contains not printable characters */
    public final C3282 f16084;

    public C4770(C4539 c4539, Protocol protocol, String str, int i, Handshake handshake, C5207 c5207, AbstractC4809 abstractC4809, C4770 c4770, C4770 c47702, C4770 c47703, long j, long j2, C3282 c3282) {
        C3921.m12667(c4539, "request");
        C3921.m12667(protocol, "protocol");
        C3921.m12667(str, "message");
        C3921.m12667(c5207, "headers");
        this.f16072 = c4539;
        this.f16073 = protocol;
        this.f16074 = str;
        this.f16075 = i;
        this.f16076 = handshake;
        this.f16077 = c5207;
        this.f16078 = abstractC4809;
        this.f16079 = c4770;
        this.f16080 = c47702;
        this.f16081 = c47703;
        this.f16082 = j;
        this.f16083 = j2;
        this.f16084 = c3282;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static /* synthetic */ String m14329(C4770 c4770, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return c4770.m14338(str, str2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        AbstractC4809 abstractC4809 = this.f16078;
        if (abstractC4809 == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        abstractC4809.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f16073 + ", code=" + this.f16075 + ", message=" + this.f16074 + ", url=" + this.f16072.m13925() + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AbstractC4809 m14330() {
        return this.f16078;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2789 m14331() {
        C2789 c2789 = this.f16071;
        if (c2789 != null) {
            return c2789;
        }
        C2789 c2789M10097 = C2789.f10162.m10097(this.f16077);
        this.f16071 = c2789M10097;
        return c2789M10097;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C4770 m14332() {
        return this.f16080;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<C2671> m14333() {
        String str;
        C5207 c5207 = this.f16077;
        int i = this.f16075;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return C3131.m10712();
            }
            str = "Proxy-Authenticate";
        }
        return C4186.m13204(c5207, str);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m14334() {
        return this.f16075;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C3282 m14335() {
        return this.f16084;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Handshake m14336() {
        return this.f16076;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m14337(String str) {
        return m14329(this, str, null, 2, null);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String m14338(String str, String str2) {
        C3921.m12667(str, "name");
        String strM15182 = this.f16077.m15182(str);
        return strM15182 != null ? strM15182 : str2;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C5207 m14339() {
        return this.f16077;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean m14340() {
        int i = this.f16075;
        return 200 <= i && 299 >= i;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final String m14341() {
        return this.f16074;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final C4770 m14342() {
        return this.f16079;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final C4771 m14343() {
        return new C4771(this);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final C4770 m14344() {
        return this.f16081;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final Protocol m14345() {
        return this.f16073;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final long m14346() {
        return this.f16083;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final C4539 m14347() {
        return this.f16072;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final long m14348() {
        return this.f16082;
    }

    /* compiled from: Response.kt */
    /* renamed from: අ$Ϳ, reason: contains not printable characters */
    public static class C4771 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C4539 f16085;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public Protocol f16086;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f16087;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public String f16088;

        /* renamed from: ԫ, reason: contains not printable characters */
        public Handshake f16089;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C5207.C5208 f16090;

        /* renamed from: ԭ, reason: contains not printable characters */
        public AbstractC4809 f16091;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C4770 f16092;

        /* renamed from: ԯ, reason: contains not printable characters */
        public C4770 f16093;

        /* renamed from: ՠ, reason: contains not printable characters */
        public C4770 f16094;

        /* renamed from: ֈ, reason: contains not printable characters */
        public long f16095;

        /* renamed from: ֏, reason: contains not printable characters */
        public long f16096;

        /* renamed from: ׯ, reason: contains not printable characters */
        public C3282 f16097;

        public C4771() {
            this.f16087 = -1;
            this.f16090 = new C5207.C5208();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C4771 m14349(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            this.f16090.m15187(str, str2);
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C4771 m14350(AbstractC4809 abstractC4809) {
            this.f16091 = abstractC4809;
            return this;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public C4770 m14351() {
            int i = this.f16087;
            if (!(i >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.f16087).toString());
            }
            C4539 c4539 = this.f16085;
            if (c4539 == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol protocol = this.f16086;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f16088;
            if (str != null) {
                return new C4770(c4539, protocol, str, i, this.f16089, this.f16090.m15191(), this.f16091, this.f16092, this.f16093, this.f16094, this.f16095, this.f16096, this.f16097);
            }
            throw new IllegalStateException("message == null".toString());
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C4771 m14352(C4770 c4770) {
            m14354("cacheResponse", c4770);
            this.f16093 = c4770;
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final void m14353(C4770 c4770) {
            if (c4770 != null) {
                if (!(c4770.m14330() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final void m14354(String str, C4770 c4770) {
            if (c4770 != null) {
                if (!(c4770.m14330() == null)) {
                    throw new IllegalArgumentException((str + ".body != null").toString());
                }
                if (!(c4770.m14342() == null)) {
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                if (!(c4770.m14332() == null)) {
                    throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                }
                if (c4770.m14344() == null) {
                    return;
                }
                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
            }
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public C4771 m14355(int i) {
            this.f16087 = i;
            return this;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final int m14356() {
            return this.f16087;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public C4771 m14357(Handshake handshake) {
            this.f16089 = handshake;
            return this;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public C4771 m14358(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            this.f16090.m15195(str, str2);
            return this;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public C4771 m14359(C5207 c5207) {
            C3921.m12667(c5207, "headers");
            this.f16090 = c5207.m15184();
            return this;
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final void m14360(C3282 c3282) {
            C3921.m12667(c3282, "deferredTrailers");
            this.f16097 = c3282;
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public C4771 m14361(String str) {
            C3921.m12667(str, "message");
            this.f16088 = str;
            return this;
        }

        /* renamed from: ؠ, reason: contains not printable characters */
        public C4771 m14362(C4770 c4770) {
            m14354("networkResponse", c4770);
            this.f16092 = c4770;
            return this;
        }

        /* renamed from: ހ, reason: contains not printable characters */
        public C4771 m14363(C4770 c4770) {
            m14353(c4770);
            this.f16094 = c4770;
            return this;
        }

        /* renamed from: ށ, reason: contains not printable characters */
        public C4771 m14364(Protocol protocol) {
            C3921.m12667(protocol, "protocol");
            this.f16086 = protocol;
            return this;
        }

        /* renamed from: ނ, reason: contains not printable characters */
        public C4771 m14365(long j) {
            this.f16096 = j;
            return this;
        }

        /* renamed from: ރ, reason: contains not printable characters */
        public C4771 m14366(String str) {
            C3921.m12667(str, "name");
            this.f16090.m15194(str);
            return this;
        }

        /* renamed from: ބ, reason: contains not printable characters */
        public C4771 m14367(C4539 c4539) {
            C3921.m12667(c4539, "request");
            this.f16085 = c4539;
            return this;
        }

        /* renamed from: ޅ, reason: contains not printable characters */
        public C4771 m14368(long j) {
            this.f16095 = j;
            return this;
        }

        public C4771(C4770 c4770) {
            C3921.m12667(c4770, "response");
            this.f16087 = -1;
            this.f16085 = c4770.m14347();
            this.f16086 = c4770.m14345();
            this.f16087 = c4770.m14334();
            this.f16088 = c4770.m14341();
            this.f16089 = c4770.m14336();
            this.f16090 = c4770.m14339().m15184();
            this.f16091 = c4770.m14330();
            this.f16092 = c4770.m14342();
            this.f16093 = c4770.m14332();
            this.f16094 = c4770.m14344();
            this.f16095 = c4770.m14348();
            this.f16096 = c4770.m14346();
            this.f16097 = c4770.m14335();
        }
    }
}
