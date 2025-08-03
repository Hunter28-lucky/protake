package defpackage;

/* compiled from: Settings.kt */
/* renamed from: ත, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4825 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C4826 f16322 = new C4826(null);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f16323;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int[] f16324 = new int[10];

    /* compiled from: Settings.kt */
    /* renamed from: ත$Ϳ, reason: contains not printable characters */
    public static final class C4826 {
        public C4826() {
        }

        public /* synthetic */ C4826(C4184 c4184) {
            this();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m14552(int i) {
        return this.f16324[i];
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int m14553() {
        if ((this.f16323 & 2) != 0) {
            return this.f16324[1];
        }
        return -1;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m14554() {
        if ((this.f16323 & 128) != 0) {
            return this.f16324[7];
        }
        return 65535;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m14555() {
        if ((this.f16323 & 16) != 0) {
            return this.f16324[4];
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m14556(int i) {
        return (this.f16323 & 32) != 0 ? this.f16324[5] : i;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final boolean m14557(int i) {
        return ((1 << i) & this.f16323) != 0;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m14558(C4825 c4825) {
        C3921.m12667(c4825, "other");
        for (int i = 0; i < 10; i++) {
            if (c4825.m14557(i)) {
                m14559(i, c4825.m14552(i));
            }
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C4825 m14559(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f16324;
            if (i < iArr.length) {
                this.f16323 = (1 << i) | this.f16323;
                iArr[i] = i2;
            }
        }
        return this;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int m14560() {
        return Integer.bitCount(this.f16323);
    }
}
