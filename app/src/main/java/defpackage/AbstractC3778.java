package defpackage;

import defpackage.C3469;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* compiled from: AbstractChannel.kt */
/* renamed from: ށ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3778<E> implements InterfaceC2529<E> {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f13047 = AtomicReferenceFieldUpdater.newUpdater(AbstractC3778.class, Object.class, "onCloseHandler");

    /* renamed from: ԫ, reason: contains not printable characters */
    public final InterfaceC2392<E, i4> f13048;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final C2667 f13049 = new C2667();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    /* renamed from: ށ$Ϳ, reason: contains not printable characters */
    public static final class C3779<E> extends AbstractC4669 {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final E f13050;

        public C3779(E e2) {
            this.f13050 = e2;
        }

        @Override // defpackage.C3469
        public String toString() {
            return "SendBuffered@" + C2316.m8691(this) + '(' + this.f13050 + ')';
        }

        @Override // defpackage.AbstractC4669
        /* renamed from: ފ */
        public void mo8752() {
        }

        @Override // defpackage.AbstractC4669
        /* renamed from: ދ */
        public Object mo8753() {
            return this.f13050;
        }

        @Override // defpackage.AbstractC4669
        /* renamed from: ތ */
        public void mo8754(C2340<?> c2340) {
        }

        @Override // defpackage.AbstractC4669
        /* renamed from: ލ */
        public r0 mo8755(C3469.C3471 c3471) {
            return C5006.f16769;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: ށ$Ԩ, reason: contains not printable characters */
    public static final class C3780 extends C3469.AbstractC3470 {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3469 f13051;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractC3778 f13052;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C3780(C3469 c3469, AbstractC3778 abstractC3778) {
            super(c3469);
            this.f13051 = c3469;
            this.f13052 = abstractC3778;
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Object mo7353(C3469 c3469) {
            if (this.f13052.mo11837()) {
                return null;
            }
            return C3582.m11606();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AbstractC3778(InterfaceC2392<? super E, i4> interfaceC2392) {
        this.f13048 = interfaceC2392;
    }

    public String toString() {
        return C2316.m8690(this) + '@' + C2316.m8691(this) + '{' + m12090() + '}' + mo11835();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m12085() {
        C2667 c2667 = this.f13049;
        int i = 0;
        for (C3469 c3469M11315 = (C3469) c2667.m11314(); !C3921.m12662(c3469M11315, c2667); c3469M11315 = c3469M11315.m11315()) {
            if (c3469M11315 instanceof C3469) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return defpackage.C3172.f11250;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    /* renamed from: ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo12086(defpackage.AbstractC4669 r5) {
        /*
            r4 = this;
            boolean r0 = r4.mo11836()
            if (r0 == 0) goto L18
            ʐ r0 = r4.f13049
        L8:
            ػ r1 = r0.m11316()
            boolean r2 = r1 instanceof defpackage.InterfaceC5097
            if (r2 == 0) goto L11
            return r1
        L11:
            boolean r1 = r1.m11309(r5, r0)
            if (r1 == 0) goto L8
            goto L39
        L18:
            ʐ r0 = r4.f13049
            ށ$Ԩ r1 = new ށ$Ԩ
            r1.<init>(r5, r4)
        L1f:
            ػ r2 = r0.m11316()
            boolean r3 = r2 instanceof defpackage.InterfaceC5097
            if (r3 == 0) goto L28
            return r2
        L28:
            int r2 = r2.m11322(r5, r0, r1)
            r3 = 1
            if (r2 == r3) goto L34
            r3 = 2
            if (r2 == r3) goto L33
            goto L1f
        L33:
            r3 = 0
        L34:
            if (r3 != 0) goto L39
            r0 r5 = defpackage.C3172.f11250
            return r5
        L39:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC3778.mo12086(അ):java.lang.Object");
    }

    /* renamed from: ԭ */
    public String mo11835() {
        return "";
    }

    @Override // defpackage.InterfaceC2529
    /* renamed from: Ԯ */
    public final Object mo9341(E e2, InterfaceC4355<? super i4> interfaceC4355) throws Throwable {
        if (mo11838(e2) == C3172.f11247) {
            return i4.f6762;
        }
        Object objM12097 = m12097(e2, interfaceC4355);
        return objM12097 == C5199.m15170() ? objM12097 : i4.f6762;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C2340<?> m12087() {
        C3469 c3469M11315 = this.f13049.m11315();
        C2340<?> c2340 = c3469M11315 instanceof C2340 ? (C2340) c3469M11315 : null;
        if (c2340 == null) {
            return null;
        }
        m12091(c2340);
        return c2340;
    }

    @Override // defpackage.InterfaceC2529
    /* renamed from: ՠ */
    public boolean mo9342(Throwable th) {
        boolean z;
        C2340<?> c2340 = new C2340<>(th);
        C3469 c3469 = this.f13049;
        while (true) {
            C3469 c3469M11316 = c3469.m11316();
            z = true;
            if (!(!(c3469M11316 instanceof C2340))) {
                z = false;
                break;
            }
            if (c3469M11316.m11309(c2340, c3469)) {
                break;
            }
        }
        if (!z) {
            c2340 = (C2340) this.f13049.m11316();
        }
        m12091(c2340);
        if (z) {
            m12093(th);
        }
        return z;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C2340<?> m12088() {
        C3469 c3469M11316 = this.f13049.m11316();
        C2340<?> c2340 = c3469M11316 instanceof C2340 ? (C2340) c3469M11316 : null;
        if (c2340 == null) {
            return null;
        }
        m12091(c2340);
        return c2340;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final C2667 m12089() {
        return this.f13049;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final String m12090() {
        C3469 c3469M11315 = this.f13049.m11315();
        if (c3469M11315 == this.f13049) {
            return "EmptyQueue";
        }
        String string = c3469M11315 instanceof C2340 ? c3469M11315.toString() : c3469M11315 instanceof AbstractC3759 ? "ReceiveQueued" : c3469M11315 instanceof AbstractC4669 ? "SendQueued" : C3921.m12673("UNEXPECTED:", c3469M11315);
        C3469 c3469M11316 = this.f13049.m11316();
        if (c3469M11316 == c3469M11315) {
            return string;
        }
        String str = string + ",queueSize=" + m12085();
        if (!(c3469M11316 instanceof C2340)) {
            return str;
        }
        return str + ",closedForSend=" + c3469M11316;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m12091(C2340<?> c2340) {
        Object objM9495 = C2593.m9495(null, 1, null);
        while (true) {
            C3469 c3469M11316 = c2340.m11316();
            AbstractC3759 abstractC3759 = c3469M11316 instanceof AbstractC3759 ? (AbstractC3759) c3469M11316 : null;
            if (abstractC3759 == null) {
                break;
            } else if (abstractC3759.mo9075()) {
                objM9495 = C2593.m9496(objM9495, abstractC3759);
            } else {
                abstractC3759.m11317();
            }
        }
        if (objM9495 != null) {
            if (objM9495 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objM9495;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        ((AbstractC3759) arrayList.get(size)).mo7349(c2340);
                        if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                }
            } else {
                ((AbstractC3759) objM9495).mo7349(c2340);
            }
        }
        m12095(c2340);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m12092(InterfaceC4355<?> interfaceC4355, E e2, C2340<?> c2340) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        UndeliveredElementException undeliveredElementExceptionM7369;
        m12091(c2340);
        Throwable thM8759 = c2340.m8759();
        InterfaceC2392<E, i4> interfaceC2392 = this.f13048;
        if (interfaceC2392 == null || (undeliveredElementExceptionM7369 = OnUndeliveredElementKt.m7369(interfaceC2392, e2, null, 2, null)) == null) {
            Result.C2137 c2137 = Result.f7828;
            interfaceC4355.resumeWith(Result.m7211(C4817.m14541(thM8759)));
        } else {
            C4147.m13130(undeliveredElementExceptionM7369, thM8759);
            Result.C2137 c21372 = Result.f7828;
            interfaceC4355.resumeWith(Result.m7211(C4817.m14541(undeliveredElementExceptionM7369)));
        }
    }

    @Override // defpackage.InterfaceC2529
    /* renamed from: ށ */
    public final boolean mo9343() {
        return m12088() != null;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m12093(Throwable th) {
        r0 r0Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (r0Var = C3172.f11251) || !C3777.m12082(f13047, this, obj, r0Var)) {
            return;
        }
        ((InterfaceC2392) u3.m8339(obj, 1)).invoke(th);
    }

    /* renamed from: ރ */
    public abstract boolean mo11836();

    /* renamed from: ބ */
    public abstract boolean mo11837();

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m12094() {
        return !(this.f13049.m11315() instanceof InterfaceC5097) && mo11837();
    }

    /* renamed from: ކ */
    public Object mo11838(E e2) {
        InterfaceC5097<E> interfaceC5097Mo7333;
        do {
            interfaceC5097Mo7333 = mo7333();
            if (interfaceC5097Mo7333 == null) {
                return C3172.f11248;
            }
        } while (interfaceC5097Mo7333.mo7348(e2, null) == null);
        interfaceC5097Mo7333.mo7347(e2);
        return interfaceC5097Mo7333.mo8751();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m12095(C3469 c3469) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ވ, reason: contains not printable characters */
    public final InterfaceC5097<?> m12096(E e2) {
        C3469 c3469M11316;
        C2667 c2667 = this.f13049;
        C3779 c3779 = new C3779(e2);
        do {
            c3469M11316 = c2667.m11316();
            if (c3469M11316 instanceof InterfaceC5097) {
                return (InterfaceC5097) c3469M11316;
            }
        } while (!c3469M11316.m11309(c3779, c2667));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0055 A[SYNTHETIC] */
    /* renamed from: މ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m12097(E r4, defpackage.InterfaceC4355<? super defpackage.i4> r5) throws java.lang.Throwable {
        /*
            r3 = this;
            ન r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.m7255(r5)
            ଽ r0 = defpackage.C4922.m14650(r0)
        L8:
            boolean r1 = m12084(r3)
            if (r1 == 0) goto L4d
            ŭ<E, i4> r1 = r3.f13048
            if (r1 != 0) goto L18
            ჯ r1 = new ჯ
            r1.<init>(r4, r0)
            goto L1f
        L18:
            ǌ r1 = new ǌ
            ŭ<E, i4> r2 = r3.f13048
            r1.<init>(r4, r0, r2)
        L1f:
            java.lang.Object r2 = r3.mo12086(r1)
            if (r2 != 0) goto L29
            defpackage.C4922.m14651(r0, r1)
            goto L6d
        L29:
            boolean r1 = r2 instanceof defpackage.C2340
            if (r1 == 0) goto L33
            į r2 = (defpackage.C2340) r2
            m12083(r3, r0, r4, r2)
            goto L6d
        L33:
            r0 r1 = defpackage.C3172.f11250
            if (r2 != r1) goto L38
            goto L4d
        L38:
            boolean r1 = r2 instanceof defpackage.AbstractC3759
            if (r1 == 0) goto L3d
            goto L4d
        L3d:
            java.lang.String r4 = "enqueueSend returned "
            java.lang.String r4 = defpackage.C3921.m12673(r4, r2)
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L4d:
            java.lang.Object r1 = r3.mo11838(r4)
            r0 r2 = defpackage.C3172.f11247
            if (r1 != r2) goto L5f
            i4 r4 = defpackage.i4.f6762
            java.lang.Object r4 = kotlin.Result.m7211(r4)
            r0.resumeWith(r4)
            goto L6d
        L5f:
            r0 r2 = defpackage.C3172.f11248
            if (r1 != r2) goto L64
            goto L8
        L64:
            boolean r2 = r1 instanceof defpackage.C2340
            if (r2 == 0) goto L84
            į r1 = (defpackage.C2340) r1
            m12083(r3, r0, r4, r1)
        L6d:
            java.lang.Object r4 = r0.m13684()
            java.lang.Object r0 = defpackage.C5199.m15170()
            if (r4 != r0) goto L7a
            defpackage.C5148.m15061(r5)
        L7a:
            java.lang.Object r5 = defpackage.C5199.m15170()
            if (r4 != r5) goto L81
            return r4
        L81:
            i4 r4 = defpackage.i4.f6762
            return r4
        L84:
            java.lang.String r4 = "offerInternal returned "
            java.lang.String r4 = defpackage.C3921.m12673(r4, r1)
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC3778.m12097(java.lang.Object, ન):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [ػ] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* renamed from: ފ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public defpackage.InterfaceC5097<E> mo7333() {
        /*
            r4 = this;
            ʐ r0 = r4.f13049
        L2:
            java.lang.Object r1 = r0.m11314()
            ػ r1 = (defpackage.C3469) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof defpackage.InterfaceC5097
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            ဋ r2 = (defpackage.InterfaceC5097) r2
            boolean r2 = r2 instanceof defpackage.C2340
            if (r2 == 0) goto L20
            boolean r2 = r1.mo9808()
            if (r2 != 0) goto L20
            goto L26
        L20:
            ػ r2 = r1.m11320()
            if (r2 != 0) goto L29
        L26:
            ဋ r1 = (defpackage.InterfaceC5097) r1
            return r1
        L29:
            r2.m11318()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC3778.mo7333():ဋ");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = null;
     */
    /* renamed from: ދ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final defpackage.AbstractC4669 m12098() {
        /*
            r4 = this;
            ʐ r0 = r4.f13049
        L2:
            java.lang.Object r1 = r0.m11314()
            ػ r1 = (defpackage.C3469) r1
            r2 = 0
            if (r1 != r0) goto Ld
        Lb:
            r1 = r2
            goto L26
        Ld:
            boolean r3 = r1 instanceof defpackage.AbstractC4669
            if (r3 != 0) goto L12
            goto Lb
        L12:
            r2 = r1
            അ r2 = (defpackage.AbstractC4669) r2
            boolean r2 = r2 instanceof defpackage.C2340
            if (r2 == 0) goto L20
            boolean r2 = r1.mo9808()
            if (r2 != 0) goto L20
            goto L26
        L20:
            ػ r2 = r1.m11320()
            if (r2 != 0) goto L29
        L26:
            അ r1 = (defpackage.AbstractC4669) r1
            return r1
        L29:
            r2.m11318()
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC3778.m12098():അ");
    }
}
