package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeTaskQueue.kt */
/* renamed from: ݘ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3727<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f12922;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean f12923;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f12924;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public /* synthetic */ AtomicReferenceArray f12925;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C3728 f12918 = new C3728(null);

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final r0 f12921 = new r0("REMOVE_FROZEN");

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f12919 = AtomicReferenceFieldUpdater.newUpdater(C3727.class, Object.class, "_next");

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicLongFieldUpdater f12920 = AtomicLongFieldUpdater.newUpdater(C3727.class, "_state");

    /* compiled from: LockFreeTaskQueue.kt */
    /* renamed from: ݘ$Ϳ, reason: contains not printable characters */
    public static final class C3728 {
        public C3728() {
        }

        public /* synthetic */ C3728(C4184 c4184) {
            this();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int m11934(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final long m11935(long j, int i) {
            return m11937(j, 1073741823L) | (i << 0);
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final long m11936(long j, int i) {
            return m11937(j, 1152921503533105152L) | (i << 30);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final long m11937(long j, long j2) {
            return j & (~j2);
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* renamed from: ݘ$Ԩ, reason: contains not printable characters */
    public static final class C3729 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f12926;

        public C3729(int i) {
            this.f12926 = i;
        }
    }

    public C3727(int i, boolean z) {
        this.f12922 = i;
        this.f12923 = z;
        int i2 = i - 1;
        this.f12924 = i2;
        this.f12925 = new AtomicReferenceArray(i);
        if (!(i2 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i & i2) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004c, code lost:
    
        return 1;
     */
    /* renamed from: Ϳ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m11923(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 == 0) goto L12
            ݘ$Ϳ r13 = defpackage.C3727.f12918
            int r13 = r13.m11934(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r0 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r1 = 30
            long r4 = r4 >> r1
            int r9 = (int) r4
            int r10 = r12.f12924
            int r1 = r9 + 2
            r1 = r1 & r10
            r4 = r0 & r10
            r5 = 1
            if (r1 != r4) goto L2e
            return r5
        L2e:
            boolean r1 = r12.f12923
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r1 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r12.f12925
            r11 = r9 & r10
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L4d
            int r1 = r12.f12922
            r2 = 1024(0x400, float:1.435E-42)
            if (r1 < r2) goto L4c
            int r9 = r9 - r0
            r0 = r9 & r4
            int r1 = r1 >> 1
            if (r0 <= r1) goto L0
        L4c:
            return r5
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = defpackage.C3727.f12920
            ݘ$Ϳ r4 = defpackage.C3727.f12918
            long r4 = r4.m11936(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f12925
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L68:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 != 0) goto L72
            goto L7c
        L72:
            ݘ r0 = r0.m11931()
            ݘ r0 = r0.m11927(r9, r13)
            if (r0 != 0) goto L68
        L7c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3727.m11923(java.lang.Object):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3727<E> m11924(long j) {
        C3727<E> c3727 = new C3727<>(this.f12922 * 2, this.f12923);
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.f12924;
            if ((i & i3) == (i2 & i3)) {
                c3727._state = f12918.m11937(j, 1152921504606846976L);
                return c3727;
            }
            Object c3729 = this.f12925.get(i3 & i);
            if (c3729 == null) {
                c3729 = new C3729(i);
            }
            c3727.f12925.set(c3727.f12924 & i, c3729);
            i++;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C3727<E> m11925(long j) {
        while (true) {
            C3727<E> c3727 = (C3727) this._next;
            if (c3727 != null) {
                return c3727;
            }
            C3777.m12082(f12919, this, null, m11924(j));
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m11926() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!f12920.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3727<E> m11927(int i, E e2) {
        Object obj = this.f12925.get(this.f12924 & i);
        if (!(obj instanceof C3729) || ((C3729) obj).f12926 != i) {
            return null;
        }
        this.f12925.set(i & this.f12924, e2);
        return this;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m11928() {
        long j = this._state;
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0))) & 1073741823;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m11929() {
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final long m11930() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!f12920.compareAndSet(this, j, j2));
        return j2;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C3727<E> m11931() {
        return m11925(m11930());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Object m11932() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return f12921;
            }
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = this.f12924;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == (i & i2)) {
                return null;
            }
            Object obj = this.f12925.get(i2 & i);
            if (obj == null) {
                if (this.f12923) {
                    return null;
                }
            } else {
                if (obj instanceof C3729) {
                    return null;
                }
                int i3 = (i + 1) & 1073741823;
                if (f12920.compareAndSet(this, j, f12918.m11935(j, i3))) {
                    this.f12925.set(this.f12924 & i, null);
                    return obj;
                }
                if (this.f12923) {
                    C3727<E> c3727M11933 = this;
                    do {
                        c3727M11933 = c3727M11933.m11933(i, i3);
                    } while (c3727M11933 != null);
                    return obj;
                }
            }
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C3727<E> m11933(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            i3 = (int) ((1073741823 & j) >> 0);
            if ((1152921504606846976L & j) != 0) {
                return m11931();
            }
        } while (!f12920.compareAndSet(this, j, f12918.m11935(j, i2)));
        this.f12925.set(i3 & this.f12924, null);
        return null;
    }
}
