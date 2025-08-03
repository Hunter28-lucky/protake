package kotlinx.coroutines.channels;

import defpackage.AbstractC3759;
import defpackage.AbstractC3778;
import defpackage.AbstractC4669;
import defpackage.AbstractC5189;
import defpackage.C2316;
import defpackage.C2340;
import defpackage.C2351;
import defpackage.C2593;
import defpackage.C2667;
import defpackage.C3172;
import defpackage.C3469;
import defpackage.C3582;
import defpackage.C3921;
import defpackage.C4441;
import defpackage.C4817;
import defpackage.C4922;
import defpackage.C5006;
import defpackage.C5148;
import defpackage.C5199;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC3523;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC5005;
import defpackage.InterfaceC5097;
import defpackage.i4;
import defpackage.r0;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;

/* compiled from: AbstractChannel.kt */
/* loaded from: classes2.dex */
public abstract class AbstractChannel<E> extends AbstractC3778<E> implements InterfaceC3523<E> {

    /* compiled from: AbstractChannel.kt */
    /* renamed from: kotlinx.coroutines.channels.AbstractChannel$Ϳ, reason: contains not printable characters */
    public static class C2149<E> extends AbstractC3759<E> {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final InterfaceC5005<Object> f7864;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final int f7865;

        public C2149(InterfaceC5005<Object> interfaceC5005, int i) {
            this.f7864 = interfaceC5005;
            this.f7865 = i;
        }

        @Override // defpackage.C3469
        public String toString() {
            return "ReceiveElement@" + C2316.m8691(this) + "[receiveMode=" + this.f7865 + ']';
        }

        @Override // defpackage.InterfaceC5097
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo7347(E e2) {
            this.f7864.mo13680(C5006.f16769);
        }

        @Override // defpackage.InterfaceC5097
        /* renamed from: ԭ, reason: contains not printable characters */
        public r0 mo7348(E e2, C3469.C3471 c3471) {
            if (this.f7864.mo13676(m7350(e2), null, mo7351(e2)) == null) {
                return null;
            }
            return C5006.f16769;
        }

        @Override // defpackage.AbstractC3759
        /* renamed from: ތ, reason: contains not printable characters */
        public void mo7349(C2340<?> c2340) {
            if (this.f7865 == 1) {
                this.f7864.resumeWith(Result.m7211(C2351.m8799(C2351.f8892.m8808(c2340.f8870))));
                return;
            }
            InterfaceC5005<Object> interfaceC5005 = this.f7864;
            Throwable thM8758 = c2340.m8758();
            Result.C2137 c2137 = Result.f7828;
            interfaceC5005.resumeWith(Result.m7211(C4817.m14541(thM8758)));
        }

        /* renamed from: ލ, reason: contains not printable characters */
        public final Object m7350(E e2) {
            return this.f7865 == 1 ? C2351.m8799(C2351.f8892.m8809(e2)) : e2;
        }
    }

    /* compiled from: AbstractChannel.kt */
    /* renamed from: kotlinx.coroutines.channels.AbstractChannel$Ԩ, reason: contains not printable characters */
    public static final class C2150<E> extends C2149<E> {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC2392<E, i4> f7866;

        /* JADX WARN: Multi-variable type inference failed */
        public C2150(InterfaceC5005<Object> interfaceC5005, int i, InterfaceC2392<? super E, i4> interfaceC2392) {
            super(interfaceC5005, i);
            this.f7866 = interfaceC2392;
        }

        @Override // defpackage.AbstractC3759
        /* renamed from: ދ, reason: contains not printable characters */
        public InterfaceC2392<Throwable, i4> mo7351(E e2) {
            return OnUndeliveredElementKt.m7366(this.f7866, e2, this.f7864.getContext());
        }
    }

    /* compiled from: AbstractChannel.kt */
    /* renamed from: kotlinx.coroutines.channels.AbstractChannel$Ԫ, reason: contains not printable characters */
    public final class C2151 extends AbstractC5189 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3759<?> f7867;

        public C2151(AbstractC3759<?> abstractC3759) {
            this.f7867 = abstractC3759;
        }

        @Override // defpackage.InterfaceC2392
        public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
            mo7352(th);
            return i4.f6762;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f7867 + ']';
        }

        @Override // defpackage.AbstractC3825
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo7352(Throwable th) {
            if (this.f7867.mo9075()) {
                AbstractChannel.this.m7342();
            }
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: kotlinx.coroutines.channels.AbstractChannel$Ԭ, reason: contains not printable characters */
    public static final class C2152 extends C3469.AbstractC3470 {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3469 f7869;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ AbstractChannel f7870;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2152(C3469 c3469, AbstractChannel abstractChannel) {
            super(c3469);
            this.f7869 = c3469;
            this.f7870 = abstractChannel;
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Object mo7353(C3469 c3469) {
            if (this.f7870.mo7338()) {
                return null;
            }
            return C3582.m11606();
        }
    }

    public AbstractChannel(InterfaceC2392<? super E, i4> interfaceC2392) {
        super(interfaceC2392);
    }

    @Override // defpackage.InterfaceC4230
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void mo7331(CancellationException cancellationException) {
        if (mo7339()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new CancellationException(C3921.m12673(C2316.m8690(this), " was cancelled"));
        }
        m7334(cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.InterfaceC4230
    /* renamed from: Ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo7332(defpackage.InterfaceC4355<? super defpackage.C2351<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = defpackage.C5199.m15170()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            defpackage.C4817.m14542(r5)
            goto L5b
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            defpackage.C4817.m14542(r5)
            java.lang.Object r5 = r4.mo7344()
            r0 r2 = defpackage.C3172.f11249
            if (r5 == r2) goto L52
            boolean r0 = r5 instanceof defpackage.C2340
            if (r0 == 0) goto L4b
            ļ$Ԩ r0 = defpackage.C2351.f8892
            į r5 = (defpackage.C2340) r5
            java.lang.Throwable r5 = r5.f8870
            java.lang.Object r5 = r0.m8808(r5)
            goto L51
        L4b:
            ļ$Ԩ r0 = defpackage.C2351.f8892
            java.lang.Object r5 = r0.m8809(r5)
        L51:
            return r5
        L52:
            r0.label = r3
            java.lang.Object r5 = r4.m7345(r3, r0)
            if (r5 != r1) goto L5b
            return r1
        L5b:
            ļ r5 = (defpackage.C2351) r5
            java.lang.Object r5 = r5.m8807()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.mo7332(ન):java.lang.Object");
    }

    @Override // defpackage.AbstractC3778
    /* renamed from: ފ, reason: contains not printable characters */
    public InterfaceC5097<E> mo7333() {
        InterfaceC5097<E> interfaceC5097Mo7333 = super.mo7333();
        if (interfaceC5097Mo7333 != null && !(interfaceC5097Mo7333 instanceof C2340)) {
            m7342();
        }
        return interfaceC5097Mo7333;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final boolean m7334(Throwable th) {
        boolean zMo9342 = mo9342(th);
        mo7340(zMo9342);
        return zMo9342;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final boolean m7335(AbstractC3759<? super E> abstractC3759) {
        boolean zMo7336 = mo7336(abstractC3759);
        if (zMo7336) {
            m7343();
        }
        return zMo7336;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public boolean mo7336(AbstractC3759<? super E> abstractC3759) {
        int iM11322;
        C3469 c3469M11316;
        if (!mo7337()) {
            C3469 c3469M12089 = m12089();
            C2152 c2152 = new C2152(abstractC3759, this);
            do {
                C3469 c3469M113162 = c3469M12089.m11316();
                if (!(!(c3469M113162 instanceof AbstractC4669))) {
                    return false;
                }
                iM11322 = c3469M113162.m11322(abstractC3759, c3469M12089, c2152);
                if (iM11322 != 1) {
                }
            } while (iM11322 != 2);
            return false;
        }
        C3469 c3469M120892 = m12089();
        do {
            c3469M11316 = c3469M120892.m11316();
            if (!(!(c3469M11316 instanceof AbstractC4669))) {
                return false;
            }
        } while (!c3469M11316.m11309(abstractC3759, c3469M120892));
        return true;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public abstract boolean mo7337();

    /* renamed from: ޒ, reason: contains not printable characters */
    public abstract boolean mo7338();

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean mo7339() {
        return m12087() != null && mo7338();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void mo7340(boolean z) {
        C2340<?> c2340M12088 = m12088();
        if (c2340M12088 == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objM9495 = C2593.m9495(null, 1, null);
        while (true) {
            C3469 c3469M11316 = c2340M12088.m11316();
            if (c3469M11316 instanceof C2667) {
                mo7341(objM9495, c2340M12088);
                return;
            } else if (c3469M11316.mo9075()) {
                objM9495 = C2593.m9496(objM9495, (AbstractC4669) c3469M11316);
            } else {
                c3469M11316.m11317();
            }
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void mo7341(Object obj, C2340<?> c2340) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((AbstractC4669) obj).mo8754(c2340);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            ((AbstractC4669) arrayList.get(size)).mo8754(c2340);
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m7342() {
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m7343() {
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public Object mo7344() {
        while (true) {
            AbstractC4669 abstractC4669M12098 = m12098();
            if (abstractC4669M12098 == null) {
                return C3172.f11249;
            }
            if (abstractC4669M12098.mo8755(null) != null) {
                abstractC4669M12098.mo8752();
                return abstractC4669M12098.mo8753();
            }
            abstractC4669M12098.mo9076();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ޙ, reason: contains not printable characters */
    public final <R> Object m7345(int i, InterfaceC4355<? super R> interfaceC4355) throws Throwable {
        C4441 c4441M14650 = C4922.m14650(IntrinsicsKt__IntrinsicsJvmKt.m7255(interfaceC4355));
        C2149 c2149 = this.f13048 == null ? new C2149(c4441M14650, i) : new C2150(c4441M14650, i, this.f13048);
        while (true) {
            if (m7335(c2149)) {
                m7346(c4441M14650, c2149);
                break;
            }
            Object objMo7344 = mo7344();
            if (objMo7344 instanceof C2340) {
                c2149.mo7349((C2340) objMo7344);
                break;
            }
            if (objMo7344 != C3172.f11249) {
                c4441M14650.mo13671(c2149.m7350(objMo7344), c2149.mo7351(objMo7344));
                break;
            }
        }
        Object objM13684 = c4441M14650.m13684();
        if (objM13684 == C5199.m15170()) {
            C5148.m15061(interfaceC4355);
        }
        return objM13684;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final void m7346(InterfaceC5005<?> interfaceC5005, AbstractC3759<?> abstractC3759) {
        interfaceC5005.mo13670(new C2151(abstractC3759));
    }
}
