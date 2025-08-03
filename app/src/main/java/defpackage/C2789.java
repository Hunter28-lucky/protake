package defpackage;

import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: CacheControl.kt */
/* renamed from: Γ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2789 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f10163;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f10164;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f10165;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f10166;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final boolean f10167;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean f10168;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f10169;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f10170;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f10171;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean f10172;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final boolean f10173;

    /* renamed from: ֏, reason: contains not printable characters */
    public final boolean f10174;

    /* renamed from: ׯ, reason: contains not printable characters */
    public String f10175;

    /* renamed from: ށ, reason: contains not printable characters */
    public static final C2791 f10162 = new C2791(null);

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final C2789 f10160 = new C2790().m10094().m10091();

    /* renamed from: ހ, reason: contains not printable characters */
    public static final C2789 f10161 = new C2790().m10095().m10093(Integer.MAX_VALUE, TimeUnit.SECONDS).m10091();

    /* compiled from: CacheControl.kt */
    /* renamed from: Γ$Ϳ, reason: contains not printable characters */
    public static final class C2790 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f10176;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean f10177;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f10178 = -1;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f10179 = -1;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f10180 = -1;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public boolean f10181;

        /* renamed from: ԭ, reason: contains not printable characters */
        public boolean f10182;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public boolean f10183;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2789 m10091() {
            return new C2789(this.f10176, this.f10177, this.f10178, -1, false, false, false, this.f10179, this.f10180, this.f10181, this.f10182, this.f10183, null, null);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int m10092(long j) {
            if (j > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int) j;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final C2790 m10093(int i, TimeUnit timeUnit) {
            C3921.m12667(timeUnit, "timeUnit");
            if (i >= 0) {
                this.f10179 = m10092(timeUnit.toSeconds(i));
                return this;
            }
            throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final C2790 m10094() {
            this.f10176 = true;
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C2790 m10095() {
            this.f10181 = true;
            return this;
        }
    }

    /* compiled from: CacheControl.kt */
    /* renamed from: Γ$Ԩ, reason: contains not printable characters */
    public static final class C2791 {
        public C2791() {
        }

        public /* synthetic */ C2791(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int m10096(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (StringsKt__StringsKt.m7274(str2, str.charAt(i), false, 2, null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
        /* renamed from: Ԩ, reason: contains not printable characters */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final defpackage.C2789 m10097(defpackage.C5207 r32) {
            /*
                Method dump skipped, instructions count: 406
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C2789.C2791.m10097(Ⴌ):Γ");
        }
    }

    public C2789(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f10163 = z;
        this.f10164 = z2;
        this.f10165 = i;
        this.f10166 = i2;
        this.f10167 = z3;
        this.f10168 = z4;
        this.f10169 = z5;
        this.f10170 = i3;
        this.f10171 = i4;
        this.f10172 = z6;
        this.f10173 = z7;
        this.f10174 = z8;
        this.f10175 = str;
    }

    public String toString() {
        String str = this.f10175;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10163) {
            sb.append("no-cache, ");
        }
        if (this.f10164) {
            sb.append("no-store, ");
        }
        if (this.f10165 != -1) {
            sb.append("max-age=");
            sb.append(this.f10165);
            sb.append(", ");
        }
        if (this.f10166 != -1) {
            sb.append("s-maxage=");
            sb.append(this.f10166);
            sb.append(", ");
        }
        if (this.f10167) {
            sb.append("private, ");
        }
        if (this.f10168) {
            sb.append("public, ");
        }
        if (this.f10169) {
            sb.append("must-revalidate, ");
        }
        if (this.f10170 != -1) {
            sb.append("max-stale=");
            sb.append(this.f10170);
            sb.append(", ");
        }
        if (this.f10171 != -1) {
            sb.append("min-fresh=");
            sb.append(this.f10171);
            sb.append(", ");
        }
        if (this.f10172) {
            sb.append("only-if-cached, ");
        }
        if (this.f10173) {
            sb.append("no-transform, ");
        }
        if (this.f10174) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        this.f10175 = string;
        return string;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m10082() {
        return this.f10167;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m10083() {
        return this.f10168;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m10084() {
        return this.f10165;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m10085() {
        return this.f10170;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m10086() {
        return this.f10171;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m10087() {
        return this.f10169;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m10088() {
        return this.f10163;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m10089() {
        return this.f10164;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m10090() {
        return this.f10172;
    }

    public /* synthetic */ C2789(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str, C4184 c4184) {
        this(z, z2, i, i2, z3, z4, z5, i3, i4, z6, z7, z8, str);
    }
}
