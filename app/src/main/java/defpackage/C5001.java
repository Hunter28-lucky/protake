package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import defpackage.C4770;
import defpackage.C5207;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: CacheStrategy.kt */
/* renamed from: ເ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5001 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C5002 f16754 = new C5002(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4539 f16755;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4770 f16756;

    /* compiled from: CacheStrategy.kt */
    /* renamed from: ເ$Ϳ, reason: contains not printable characters */
    public static final class C5002 {
        public C5002() {
        }

        public /* synthetic */ C5002(C4184 c4184) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x003b  */
        /* renamed from: Ϳ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean m14790(defpackage.C4770 r5, defpackage.C4539 r6) {
            /*
                r4 = this;
                java.lang.String r0 = "response"
                defpackage.C3921.m12667(r5, r0)
                java.lang.String r0 = "request"
                defpackage.C3921.m12667(r6, r0)
                int r0 = r5.m14334()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L65
                r1 = 410(0x19a, float:5.75E-43)
                if (r0 == r1) goto L65
                r1 = 414(0x19e, float:5.8E-43)
                if (r0 == r1) goto L65
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L65
                r1 = 203(0xcb, float:2.84E-43)
                if (r0 == r1) goto L65
                r1 = 204(0xcc, float:2.86E-43)
                if (r0 == r1) goto L65
                r1 = 307(0x133, float:4.3E-43)
                if (r0 == r1) goto L3b
                r1 = 308(0x134, float:4.32E-43)
                if (r0 == r1) goto L65
                r1 = 404(0x194, float:5.66E-43)
                if (r0 == r1) goto L65
                r1 = 405(0x195, float:5.68E-43)
                if (r0 == r1) goto L65
                switch(r0) {
                    case 300: goto L65;
                    case 301: goto L65;
                    case 302: goto L3b;
                    default: goto L3a;
                }
            L3a:
                return r2
            L3b:
                r0 = 2
                java.lang.String r1 = "Expires"
                r3 = 0
                java.lang.String r0 = defpackage.C4770.m14329(r5, r1, r3, r0, r3)
                if (r0 != 0) goto L65
                Γ r0 = r5.m14331()
                int r0 = r0.m10084()
                r1 = -1
                if (r0 != r1) goto L65
                Γ r0 = r5.m14331()
                boolean r0 = r0.m10083()
                if (r0 != 0) goto L65
                Γ r0 = r5.m14331()
                boolean r0 = r0.m10082()
                if (r0 != 0) goto L65
                return r2
            L65:
                Γ r5 = r5.m14331()
                boolean r5 = r5.m10089()
                if (r5 != 0) goto L7a
                Γ r5 = r6.m13917()
                boolean r5 = r5.m10089()
                if (r5 != 0) goto L7a
                r2 = 1
            L7a:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C5001.C5002.m14790(අ, థ):boolean");
        }
    }

    /* compiled from: CacheStrategy.kt */
    /* renamed from: ເ$Ԩ, reason: contains not printable characters */
    public static final class C5003 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public Date f16757;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f16758;

        /* renamed from: ԩ, reason: contains not printable characters */
        public Date f16759;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public String f16760;

        /* renamed from: ԫ, reason: contains not printable characters */
        public Date f16761;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public long f16762;

        /* renamed from: ԭ, reason: contains not printable characters */
        public long f16763;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public String f16764;

        /* renamed from: ԯ, reason: contains not printable characters */
        public int f16765;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final long f16766;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final C4539 f16767;

        /* renamed from: ֏, reason: contains not printable characters */
        public final C4770 f16768;

        public C5003(long j, C4539 c4539, C4770 c4770) {
            C3921.m12667(c4539, "request");
            this.f16766 = j;
            this.f16767 = c4539;
            this.f16768 = c4770;
            this.f16765 = -1;
            if (c4770 != null) {
                this.f16762 = c4770.m14348();
                this.f16763 = c4770.m14346();
                C5207 c5207M14339 = c4770.m14339();
                int size = c5207M14339.size();
                for (int i = 0; i < size; i++) {
                    String strM15183 = c5207M14339.m15183(i);
                    String strM15185 = c5207M14339.m15185(i);
                    if (e0.m5967(strM15183, HttpHeaders.HEAD_KEY_DATE, true)) {
                        this.f16757 = C4711.m14249(strM15185);
                        this.f16758 = strM15185;
                    } else if (e0.m5967(strM15183, HttpHeaders.HEAD_KEY_EXPIRES, true)) {
                        this.f16761 = C4711.m14249(strM15185);
                    } else if (e0.m5967(strM15183, HttpHeaders.HEAD_KEY_LAST_MODIFIED, true)) {
                        this.f16759 = C4711.m14249(strM15185);
                        this.f16760 = strM15185;
                    } else if (e0.m5967(strM15183, HttpHeaders.HEAD_KEY_E_TAG, true)) {
                        this.f16764 = strM15185;
                    } else if (e0.m5967(strM15183, "Age", true)) {
                        this.f16765 = i5.m6274(strM15185, -1);
                    }
                }
            }
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final long m14791() {
            Date date = this.f16757;
            long jMax = date != null ? Math.max(0L, this.f16763 - date.getTime()) : 0L;
            int i = this.f16765;
            if (i != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.f16763;
            return jMax + (j - this.f16762) + (this.f16766 - j);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C5001 m14792() {
            C5001 c5001M14793 = m14793();
            return (c5001M14793.m14789() == null || !this.f16767.m13917().m10090()) ? c5001M14793 : new C5001(null, null);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C5001 m14793() {
            if (this.f16768 == null) {
                return new C5001(this.f16767, null);
            }
            if (this.f16767.m13922() && this.f16768.m14336() == null) {
                return new C5001(this.f16767, null);
            }
            if (!C5001.f16754.m14790(this.f16768, this.f16767)) {
                return new C5001(this.f16767, null);
            }
            C2789 c2789M13917 = this.f16767.m13917();
            if (c2789M13917.m10088() || m14795(this.f16767)) {
                return new C5001(this.f16767, null);
            }
            C2789 c2789M14331 = this.f16768.m14331();
            long jM14791 = m14791();
            long jM14794 = m14794();
            if (c2789M13917.m10084() != -1) {
                jM14794 = Math.min(jM14794, TimeUnit.SECONDS.toMillis(c2789M13917.m10084()));
            }
            long millis = 0;
            long millis2 = c2789M13917.m10086() != -1 ? TimeUnit.SECONDS.toMillis(c2789M13917.m10086()) : 0L;
            if (!c2789M14331.m10087() && c2789M13917.m10085() != -1) {
                millis = TimeUnit.SECONDS.toMillis(c2789M13917.m10085());
            }
            if (!c2789M14331.m10088()) {
                long j = millis2 + jM14791;
                if (j < millis + jM14794) {
                    C4770.C4771 c4771M14343 = this.f16768.m14343();
                    if (j >= jM14794) {
                        c4771M14343.m14349("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jM14791 > 86400000 && m14796()) {
                        c4771M14343.m14349("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new C5001(null, c4771M14343.m14351());
                }
            }
            String str = this.f16764;
            String str2 = HttpHeaders.HEAD_KEY_IF_MODIFIED_SINCE;
            if (str != null) {
                str2 = HttpHeaders.HEAD_KEY_IF_NONE_MATCH;
            } else if (this.f16759 != null) {
                str = this.f16760;
            } else {
                if (this.f16757 == null) {
                    return new C5001(this.f16767, null);
                }
                str = this.f16758;
            }
            C5207.C5208 c5208M15184 = this.f16767.m13920().m15184();
            if (str == null) {
                C3921.m12675();
            }
            c5208M15184.m15189(str2, str);
            return new C5001(this.f16767.m13924().m13930(c5208M15184.m15191()).m13927(), this.f16768);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final long m14794() {
            C4770 c4770 = this.f16768;
            if (c4770 == null) {
                C3921.m12675();
            }
            if (c4770.m14331().m10084() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m10084());
            }
            Date date = this.f16761;
            if (date != null) {
                Date date2 = this.f16757;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f16763);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f16759 == null || this.f16768.m14347().m13925().m11538() != null) {
                return 0L;
            }
            Date date3 = this.f16757;
            long time2 = date3 != null ? date3.getTime() : this.f16762;
            Date date4 = this.f16759;
            if (date4 == null) {
                C3921.m12675();
            }
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final boolean m14795(C4539 c4539) {
            return (c4539.m13919(HttpHeaders.HEAD_KEY_IF_MODIFIED_SINCE) == null && c4539.m13919(HttpHeaders.HEAD_KEY_IF_NONE_MATCH) == null) ? false : true;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final boolean m14796() {
            C4770 c4770 = this.f16768;
            if (c4770 == null) {
                C3921.m12675();
            }
            return c4770.m14331().m10084() == -1 && this.f16761 == null;
        }
    }

    public C5001(C4539 c4539, C4770 c4770) {
        this.f16755 = c4539;
        this.f16756 = c4770;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4770 m14788() {
        return this.f16756;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4539 m14789() {
        return this.f16755;
    }
}
