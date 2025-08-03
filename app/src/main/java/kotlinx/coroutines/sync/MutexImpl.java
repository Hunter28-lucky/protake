package kotlinx.coroutines.sync;

import defpackage.AbstractC4290;
import defpackage.AbstractC5074;
import defpackage.C2667;
import defpackage.C3469;
import defpackage.C3582;
import defpackage.C3660;
import defpackage.C3777;
import defpackage.C3921;
import defpackage.C4357;
import defpackage.C5199;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC2645;
import defpackage.InterfaceC3750;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC5005;
import defpackage.i4;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Mutex.kt */
/* loaded from: classes2.dex */
public final class MutexImpl implements InterfaceC3750 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f7913 = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    public volatile /* synthetic */ Object _state;

    /* compiled from: Mutex.kt */
    public final class LockCont extends AbstractC2156 {

        /* renamed from: ՠ, reason: contains not printable characters */
        public final InterfaceC5005<i4> f7914;

        /* JADX WARN: Multi-variable type inference failed */
        public LockCont(Object obj, InterfaceC5005<? super i4> interfaceC5005) {
            super(obj);
            this.f7914 = interfaceC5005;
        }

        @Override // defpackage.C3469
        public String toString() {
            return "LockCont[" + this.f7916 + ", " + this.f7914 + "] for " + MutexImpl.this;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.AbstractC2156
        /* renamed from: ފ, reason: contains not printable characters */
        public void mo7419(Object obj) {
            this.f7914.mo13680(obj);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.AbstractC2156
        /* renamed from: ދ, reason: contains not printable characters */
        public Object mo7420() {
            InterfaceC5005<i4> interfaceC5005 = this.f7914;
            i4 i4Var = i4.f6762;
            final MutexImpl mutexImpl = MutexImpl.this;
            return interfaceC5005.mo13676(i4Var, null, new InterfaceC2392<Throwable, i4>() { // from class: kotlinx.coroutines.sync.MutexImpl$LockCont$tryResumeLockWaiter$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
                    invoke2(th);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    mutexImpl.mo7415(this.f7916);
                }
            });
        }
    }

    /* compiled from: Mutex.kt */
    /* renamed from: kotlinx.coroutines.sync.MutexImpl$Ϳ, reason: contains not printable characters */
    public abstract class AbstractC2156 extends C3469 implements InterfaceC2645 {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final Object f7916;

        public AbstractC2156(Object obj) {
            this.f7916 = obj;
        }

        @Override // defpackage.InterfaceC2645
        public final void dispose() {
            mo9075();
        }

        /* renamed from: ފ */
        public abstract void mo7419(Object obj);

        /* renamed from: ދ */
        public abstract Object mo7420();
    }

    /* compiled from: Mutex.kt */
    /* renamed from: kotlinx.coroutines.sync.MutexImpl$Ԩ, reason: contains not printable characters */
    public static final class C2157 extends C2667 {

        /* renamed from: Ԯ, reason: contains not printable characters */
        public Object f7918;

        public C2157(Object obj) {
            this.f7918 = obj;
        }

        @Override // defpackage.C3469
        public String toString() {
            return "LockedQueue[" + this.f7918 + ']';
        }
    }

    /* compiled from: Mutex.kt */
    /* renamed from: kotlinx.coroutines.sync.MutexImpl$Ԫ, reason: contains not printable characters */
    public static final class C2158 extends AbstractC5074<MutexImpl> {

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C2157 f7919;

        public C2158(C2157 c2157) {
            this.f7919 = c2157;
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo7421(MutexImpl mutexImpl, Object obj) {
            C3777.m12082(MutexImpl.f7913, mutexImpl, this, obj == null ? C4357.f14919 : this.f7919);
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Object mo7353(MutexImpl mutexImpl) {
            if (this.f7919.m9809()) {
                return null;
            }
            return C4357.f14914;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: kotlinx.coroutines.sync.MutexImpl$Ԭ, reason: contains not printable characters */
    public static final class C2159 extends C3469.AbstractC3470 {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3469 f7920;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ MutexImpl f7921;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Object f7922;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2159(C3469 c3469, MutexImpl mutexImpl, Object obj) {
            super(c3469);
            this.f7920 = c3469;
            this.f7921 = mutexImpl;
            this.f7922 = obj;
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Object mo7353(C3469 c3469) {
            if (this.f7921._state == this.f7922) {
                return null;
            }
            return C3582.m11606();
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? C4357.f14918 : C4357.f14919;
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof C3660) {
                return "Mutex[" + ((C3660) obj).f12679 + ']';
            }
            if (!(obj instanceof AbstractC4290)) {
                if (!(obj instanceof C2157)) {
                    throw new IllegalStateException(C3921.m12673("Illegal state ", obj).toString());
                }
                return "Mutex[" + ((C2157) obj).f7918 + ']';
            }
            ((AbstractC4290) obj).mo13405(this);
        }
    }

    @Override // defpackage.InterfaceC3750
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo7415(Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C3660) {
                if (obj == null) {
                    if (!(((C3660) obj2).f12679 != C4357.f14917)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    C3660 c3660 = (C3660) obj2;
                    if (!(c3660.f12679 == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + c3660.f12679 + " but expected " + obj).toString());
                    }
                }
                if (C3777.m12082(f7913, this, obj2, C4357.f14919)) {
                    return;
                }
            } else if (obj2 instanceof AbstractC4290) {
                ((AbstractC4290) obj2).mo13405(this);
            } else {
                if (!(obj2 instanceof C2157)) {
                    throw new IllegalStateException(C3921.m12673("Illegal state ", obj2).toString());
                }
                if (obj != null) {
                    C2157 c2157 = (C2157) obj2;
                    if (!(c2157.f7918 == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + c2157.f7918 + " but expected " + obj).toString());
                    }
                }
                C2157 c21572 = (C2157) obj2;
                C3469 c3469M11319 = c21572.m11319();
                if (c3469M11319 == null) {
                    C2158 c2158 = new C2158(c21572);
                    if (C3777.m12082(f7913, this, obj2, c2158) && c2158.mo13405(this) == null) {
                        return;
                    }
                } else {
                    AbstractC2156 abstractC2156 = (AbstractC2156) c3469M11319;
                    Object objMo7420 = abstractC2156.mo7420();
                    if (objMo7420 != null) {
                        Object obj3 = abstractC2156.f7916;
                        if (obj3 == null) {
                            obj3 = C4357.f14916;
                        }
                        c21572.f7918 = obj3;
                        abstractC2156.mo7419(objMo7420);
                        return;
                    }
                }
            }
        }
    }

    @Override // defpackage.InterfaceC3750
    /* renamed from: Ԩ, reason: contains not printable characters */
    public Object mo7416(Object obj, InterfaceC4355<? super i4> interfaceC4355) throws Throwable {
        if (m7418(obj)) {
            return i4.f6762;
        }
        Object objM7417 = m7417(obj, interfaceC4355);
        return objM7417 == C5199.m15170() ? objM7417 : i4.f6762;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
    
        r9 = r0.m13684();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        if (r9 != defpackage.C5199.m15170()) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        defpackage.C5148.m15061(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0089, code lost:
    
        if (r9 != defpackage.C5199.m15170()) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x008b, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008e, code lost:
    
        return defpackage.i4.f6762;
     */
    /* renamed from: ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m7417(final java.lang.Object r9, defpackage.InterfaceC4355<? super defpackage.i4> r10) throws java.lang.Throwable {
        /*
            r8 = this;
            ન r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.m7255(r10)
            ଽ r0 = defpackage.C4922.m14650(r0)
            kotlinx.coroutines.sync.MutexImpl$LockCont r1 = new kotlinx.coroutines.sync.MutexImpl$LockCont
            r1.<init>(r9, r0)
        Ld:
            java.lang.Object r2 = r8._state
            boolean r3 = r2 instanceof defpackage.C3660
            if (r3 == 0) goto L4a
            r3 = r2
            ܘ r3 = (defpackage.C3660) r3
            java.lang.Object r4 = r3.f12679
            r0 r5 = defpackage.C4357.m13517()
            if (r4 == r5) goto L2b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f7913
            kotlinx.coroutines.sync.MutexImpl$Ԩ r5 = new kotlinx.coroutines.sync.MutexImpl$Ԩ
            java.lang.Object r3 = r3.f12679
            r5.<init>(r3)
            defpackage.C3777.m12082(r4, r8, r2, r5)
            goto Ld
        L2b:
            if (r9 != 0) goto L32
            ܘ r3 = defpackage.C4357.m13514()
            goto L37
        L32:
            ܘ r3 = new ܘ
            r3.<init>(r9)
        L37:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = kotlinx.coroutines.sync.MutexImpl.f7913
            boolean r2 = defpackage.C3777.m12082(r4, r8, r2, r3)
            if (r2 == 0) goto Ld
            i4 r1 = defpackage.i4.f6762
            kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1 r2 = new kotlinx.coroutines.sync.MutexImpl$lockSuspend$2$1$1
            r2.<init>()
            r0.mo13671(r1, r2)
            goto L78
        L4a:
            boolean r3 = r2 instanceof kotlinx.coroutines.sync.MutexImpl.C2157
            if (r3 == 0) goto L9f
            r3 = r2
            kotlinx.coroutines.sync.MutexImpl$Ԩ r3 = (kotlinx.coroutines.sync.MutexImpl.C2157) r3
            java.lang.Object r3 = r3.f7918
            r4 = 0
            r5 = 1
            if (r3 == r9) goto L59
            r3 = r5
            goto L5a
        L59:
            r3 = r4
        L5a:
            if (r3 == 0) goto L8f
            r3 = r2
            ػ r3 = (defpackage.C3469) r3
            kotlinx.coroutines.sync.MutexImpl$Ԭ r6 = new kotlinx.coroutines.sync.MutexImpl$Ԭ
            r6.<init>(r1, r8, r2)
        L64:
            ػ r2 = r3.m11316()
            int r2 = r2.m11322(r1, r3, r6)
            if (r2 == r5) goto L72
            r7 = 2
            if (r2 == r7) goto L73
            goto L64
        L72:
            r4 = r5
        L73:
            if (r4 == 0) goto Ld
            defpackage.C4922.m14651(r0, r1)
        L78:
            java.lang.Object r9 = r0.m13684()
            java.lang.Object r0 = defpackage.C5199.m15170()
            if (r9 != r0) goto L85
            defpackage.C5148.m15061(r10)
        L85:
            java.lang.Object r10 = defpackage.C5199.m15170()
            if (r9 != r10) goto L8c
            return r9
        L8c:
            i4 r9 = defpackage.i4.f6762
            return r9
        L8f:
            java.lang.String r10 = "Already locked by "
            java.lang.String r9 = defpackage.C3921.m12673(r10, r9)
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        L9f:
            boolean r3 = r2 instanceof defpackage.AbstractC4290
            if (r3 == 0) goto Laa
            ੳ r2 = (defpackage.AbstractC4290) r2
            r2.mo13405(r8)
            goto Ld
        Laa:
            java.lang.String r9 = "Illegal state "
            java.lang.String r9 = defpackage.C3921.m12673(r9, r2)
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexImpl.m7417(java.lang.Object, ન):java.lang.Object");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean m7418(Object obj) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof C3660) {
                if (((C3660) obj2).f12679 != C4357.f14917) {
                    return false;
                }
                if (C3777.m12082(f7913, this, obj2, obj == null ? C4357.f14918 : new C3660(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof C2157) {
                    if (((C2157) obj2).f7918 != obj) {
                        return false;
                    }
                    throw new IllegalStateException(C3921.m12673("Already locked by ", obj).toString());
                }
                if (!(obj2 instanceof AbstractC4290)) {
                    throw new IllegalStateException(C3921.m12673("Illegal state ", obj2).toString());
                }
                ((AbstractC4290) obj2).mo13405(this);
            }
        }
    }
}
