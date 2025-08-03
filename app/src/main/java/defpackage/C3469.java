package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: LockFreeLinkedList.kt */
/* renamed from: ػ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3469 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11969 = AtomicReferenceFieldUpdater.newUpdater(C3469.class, Object.class, "_next");

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11970 = AtomicReferenceFieldUpdater.newUpdater(C3469.class, Object.class, "_prev");

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f11971 = AtomicReferenceFieldUpdater.newUpdater(C3469.class, Object.class, "_removedRef");
    public volatile /* synthetic */ Object _next = this;
    public volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: ػ$Ϳ, reason: contains not printable characters */
    public static abstract class AbstractC3470 extends AbstractC5074<C3469> {

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C3469 f11972;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C3469 f11973;

        public AbstractC3470(C3469 c3469) {
            this.f11972 = c3469;
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo7421(C3469 c3469, Object obj) {
            boolean z = obj == null;
            C3469 c34692 = z ? this.f11972 : this.f11973;
            if (c34692 != null && C3777.m12082(C3469.f11969, c3469, this, c34692) && z) {
                C3469 c34693 = this.f11972;
                C3469 c34694 = this.f11973;
                C3921.m12664(c34694);
                c34693.m11313(c34694);
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: ػ$Ԩ, reason: contains not printable characters */
    public static final class C3471 extends AbstractC4290 {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final boolean m11309(C3469 c3469, C3469 c34692) {
        f11970.lazySet(c3469, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11969;
        atomicReferenceFieldUpdater.lazySet(c3469, c34692);
        if (!C3777.m12082(atomicReferenceFieldUpdater, this, c34692, c3469)) {
            return false;
        }
        c3469.m11313(c34692);
        return true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean m11310(C3469 c3469) {
        f11970.lazySet(c3469, this);
        f11969.lazySet(c3469, this);
        while (m11314() == this) {
            if (C3777.m12082(f11969, this, this, c3469)) {
                c3469.m11313(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        if (defpackage.C3777.m12082(defpackage.C3469.f11969, r3, r2, ((defpackage.C3461) r4).f11951) != false) goto L30;
     */
    /* renamed from: ֈ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final defpackage.C3469 m11311(defpackage.AbstractC4290 r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            ػ r0 = (defpackage.C3469) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.C3469.f11970
            boolean r0 = defpackage.C3777.m12082(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.mo9808()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof defpackage.AbstractC4290
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            ੳ r0 = (defpackage.AbstractC4290) r0
            boolean r0 = r8.m13404(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            ੳ r4 = (defpackage.AbstractC4290) r4
            r4.mo13405(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof defpackage.C3461
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = defpackage.C3469.f11969
            ص r4 = (defpackage.C3461) r4
            ػ r4 = r4.f11951
            boolean r2 = defpackage.C3777.m12082(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            ػ r2 = (defpackage.C3469) r2
            goto L7
        L52:
            r3 = r4
            ػ r3 = (defpackage.C3469) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3469.m11311(ੳ):ػ");
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final C3469 m11312(C3469 c3469) {
        while (c3469.mo9808()) {
            c3469 = (C3469) c3469._prev;
        }
        return c3469;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m11313(C3469 c3469) {
        C3469 c34692;
        do {
            c34692 = (C3469) c3469._prev;
            if (m11314() != c3469) {
                return;
            }
        } while (!C3777.m12082(f11970, c3469, c34692, this));
        if (mo9808()) {
            c3469.m11311(null);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final Object m11314() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof AbstractC4290)) {
                return obj;
            }
            ((AbstractC4290) obj).mo13405(this);
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final C3469 m11315() {
        return C3582.m11607(m11314());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final C3469 m11316() {
        C3469 c3469M11311 = m11311(null);
        return c3469M11311 == null ? m11312((C3469) this._prev) : c3469M11311;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m11317() {
        ((C3461) m11314()).f11951.m11311(null);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m11318() {
        C3469 c3469 = this;
        while (true) {
            Object objM11314 = c3469.m11314();
            if (!(objM11314 instanceof C3461)) {
                c3469.m11311(null);
                return;
            }
            c3469 = ((C3461) objM11314).f11951;
        }
    }

    /* renamed from: ބ */
    public boolean mo9808() {
        return m11314() instanceof C3461;
    }

    /* renamed from: ޅ */
    public boolean mo9075() {
        return m11320() == null;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final C3469 m11319() {
        while (true) {
            C3469 c3469 = (C3469) m11314();
            if (c3469 == this) {
                return null;
            }
            if (c3469.mo9075()) {
                return c3469;
            }
            c3469.m11317();
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final C3469 m11320() {
        Object objM11314;
        C3469 c3469;
        do {
            objM11314 = m11314();
            if (objM11314 instanceof C3461) {
                return ((C3461) objM11314).f11951;
            }
            if (objM11314 == this) {
                return (C3469) objM11314;
            }
            c3469 = (C3469) objM11314;
        } while (!C3777.m12082(f11969, this, objM11314, c3469.m11321()));
        c3469.m11311(null);
        return null;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final C3461 m11321() {
        C3461 c3461 = (C3461) this._removedRef;
        if (c3461 != null) {
            return c3461;
        }
        C3461 c34612 = new C3461(this);
        f11971.lazySet(this, c34612);
        return c34612;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final int m11322(C3469 c3469, C3469 c34692, AbstractC3470 abstractC3470) {
        f11970.lazySet(c3469, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f11969;
        atomicReferenceFieldUpdater.lazySet(c3469, c34692);
        abstractC3470.f11973 = c34692;
        if (C3777.m12082(atomicReferenceFieldUpdater, this, c34692, abstractC3470)) {
            return abstractC3470.mo13405(this) == null ? 1 : 2;
        }
        return 0;
    }
}
