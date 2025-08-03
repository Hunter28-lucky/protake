package defpackage;

/* compiled from: Ranges.kt */
/* renamed from: ș, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2523 extends C3181 implements InterfaceC3528<Integer> {

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C2524 f9347 = new C2524(null);

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final C2523 f9348 = new C2523(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: ș$Ϳ, reason: contains not printable characters */
    public static final class C2524 {
        public C2524() {
        }

        public /* synthetic */ C2524(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2523 m9332() {
            return C2523.f9348;
        }
    }

    public C2523(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // defpackage.C3181
    public boolean equals(Object obj) {
        if (obj instanceof C2523) {
            if (!isEmpty() || !((C2523) obj).isEmpty()) {
                C2523 c2523 = (C2523) obj;
                if (m10810() != c2523.m10810() || m10811() != c2523.m10811()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.C3181
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m10810() * 31) + m10811();
    }

    @Override // defpackage.C3181
    public boolean isEmpty() {
        return m10810() > m10811();
    }

    @Override // defpackage.C3181
    public String toString() {
        return m10810() + ".." + m10811();
    }

    @Override // defpackage.InterfaceC3528
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(m10811());
    }

    @Override // defpackage.InterfaceC3528
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(m10810());
    }
}
