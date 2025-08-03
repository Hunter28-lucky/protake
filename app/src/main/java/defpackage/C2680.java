package defpackage;

import defpackage.C3469;
import defpackage.InterfaceC5238;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletionHandlerException;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.TimeoutCancellationException;

/* compiled from: JobSupport.kt */
/* renamed from: ʚ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2680 implements InterfaceC5238, InterfaceC4999, InterfaceC5119 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9946 = AtomicReferenceFieldUpdater.newUpdater(C2680.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    /* compiled from: JobSupport.kt */
    /* renamed from: ʚ$Ϳ, reason: contains not printable characters */
    public static final class C2681 extends AbstractC3751 {

        /* renamed from: ԯ, reason: contains not printable characters */
        public final C2680 f9947;

        /* renamed from: ՠ, reason: contains not printable characters */
        public final C2682 f9948;

        /* renamed from: ֈ, reason: contains not printable characters */
        public final C3931 f9949;

        /* renamed from: ֏, reason: contains not printable characters */
        public final Object f9950;

        public C2681(C2680 c2680, C2682 c2682, C3931 c3931, Object obj) {
            this.f9947 = c2680;
            this.f9948 = c2682;
            this.f9949 = c3931;
            this.f9950 = obj;
        }

        @Override // defpackage.InterfaceC2392
        public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
            mo9888(th);
            return i4.f6762;
        }

        @Override // defpackage.AbstractC5076
        /* renamed from: ފ, reason: contains not printable characters */
        public void mo9888(Throwable th) {
            this.f9947.m9848(this.f9948, this.f9949, this.f9950);
        }
    }

    /* compiled from: JobSupport.kt */
    /* renamed from: ʚ$Ԩ, reason: contains not printable characters */
    public static final class C2682 implements InterfaceC2528 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final C4268 f9951;

        public C2682(C4268 c4268, boolean z, Throwable th) {
            this.f9951 = c4268;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + m9893() + ", completing=" + m9894() + ", rootCause=" + m9892() + ", exceptions=" + m9891() + ", list=" + mo9340() + ']';
        }

        @Override // defpackage.InterfaceC2528
        /* renamed from: Ϳ */
        public boolean mo9339() {
            return m9892() == null;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final void m9889(Throwable th) {
            Throwable thM9892 = m9892();
            if (thM9892 == null) {
                m9899(th);
                return;
            }
            if (th == thM9892) {
                return;
            }
            Object objM9891 = m9891();
            if (objM9891 == null) {
                m9898(th);
                return;
            }
            if (!(objM9891 instanceof Throwable)) {
                if (!(objM9891 instanceof ArrayList)) {
                    throw new IllegalStateException(C3921.m12673("State is ", objM9891).toString());
                }
                ((ArrayList) objM9891).add(th);
            } else {
                if (th == objM9891) {
                    return;
                }
                ArrayList<Throwable> arrayListM9890 = m9890();
                arrayListM9890.add(objM9891);
                arrayListM9890.add(th);
                i4 i4Var = i4.f6762;
                m9898(arrayListM9890);
            }
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final ArrayList<Throwable> m9890() {
            return new ArrayList<>(4);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final Object m9891() {
            return this._exceptionsHolder;
        }

        @Override // defpackage.InterfaceC2528
        /* renamed from: ԫ */
        public C4268 mo9340() {
            return this.f9951;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Throwable m9892() {
            return (Throwable) this._rootCause;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public final boolean m9893() {
            return m9892() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        /* renamed from: Ԯ, reason: contains not printable characters */
        public final boolean m9894() {
            return this._isCompleting;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public final boolean m9895() {
            return m9891() == C4479.f15384;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public final List<Throwable> m9896(Throwable th) {
            ArrayList<Throwable> arrayListM9890;
            Object objM9891 = m9891();
            if (objM9891 == null) {
                arrayListM9890 = m9890();
            } else if (objM9891 instanceof Throwable) {
                ArrayList<Throwable> arrayListM98902 = m9890();
                arrayListM98902.add(objM9891);
                arrayListM9890 = arrayListM98902;
            } else {
                if (!(objM9891 instanceof ArrayList)) {
                    throw new IllegalStateException(C3921.m12673("State is ", objM9891).toString());
                }
                arrayListM9890 = (ArrayList) objM9891;
            }
            Throwable thM9892 = m9892();
            if (thM9892 != null) {
                arrayListM9890.add(0, thM9892);
            }
            if (th != null && !C3921.m12662(th, thM9892)) {
                arrayListM9890.add(th);
            }
            m9898(C4479.f15384);
            return arrayListM9890;
        }

        /* renamed from: ֈ, reason: contains not printable characters */
        public final void m9897(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        /* renamed from: ֏, reason: contains not printable characters */
        public final void m9898(Object obj) {
            this._exceptionsHolder = obj;
        }

        /* renamed from: ׯ, reason: contains not printable characters */
        public final void m9899(Throwable th) {
            this._rootCause = th;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* renamed from: ʚ$Ԫ, reason: contains not printable characters */
    public static final class C2683 extends C3469.AbstractC3470 {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final /* synthetic */ C3469 f9952;

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ C2680 f9953;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Object f9954;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2683(C3469 c3469, C2680 c2680, Object obj) {
            super(c3469);
            this.f9952 = c3469;
            this.f9953 = c2680;
            this.f9954 = obj;
        }

        @Override // defpackage.AbstractC5074
        /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Object mo7353(C3469 c3469) {
            if (this.f9953.m9858() == this.f9954) {
                return null;
            }
            return C3582.m11606();
        }
    }

    public C2680(boolean z) {
        this._state = z ? C4479.f15386 : C4479.f15385;
        this._parentHandle = null;
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public static /* synthetic */ CancellationException m9830(C2680 c2680, Throwable th, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i & 1) != 0) {
            str = null;
        }
        return c2680.m9881(th, str);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, InterfaceC2849<? super R, ? super CoroutineContext.InterfaceC2140, ? extends R> interfaceC2849) {
        return (R) InterfaceC5238.C5239.m15255(this, r, interfaceC2849);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC2140, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.InterfaceC2140> E get(CoroutineContext.InterfaceC2142<E> interfaceC2142) {
        return (E) InterfaceC5238.C5239.m15256(this, interfaceC2142);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC2140
    public final CoroutineContext.InterfaceC2142<?> getKey() {
        return InterfaceC5238.f17362;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.InterfaceC2142<?> interfaceC2142) {
        return InterfaceC5238.C5239.m15258(this, interfaceC2142);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return InterfaceC5238.C5239.m15259(this, coroutineContext);
    }

    @Override // defpackage.InterfaceC5238
    public final boolean start() {
        int iM9879;
        do {
            iM9879 = m9879(m9858());
            if (iM9879 == 0) {
                return false;
            }
        } while (iM9879 != 1);
        return true;
    }

    public String toString() {
        return m9882() + '@' + C2316.m8691(this);
    }

    @Override // defpackage.InterfaceC5238
    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean mo9831() {
        Object objM9858 = m9858();
        return (objM9858 instanceof InterfaceC2528) && ((InterfaceC2528) objM9858).mo9339();
    }

    @Override // defpackage.InterfaceC5238
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo9832(CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(mo9846(), null, this);
        }
        mo9843(cancellationException);
    }

    @Override // defpackage.InterfaceC5238
    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC2645 mo9833(boolean z, boolean z2, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        AbstractC3751 abstractC3751M9867 = m9867(interfaceC2392, z);
        while (true) {
            Object objM9858 = m9858();
            if (objM9858 instanceof C4343) {
                C4343 c4343 = (C4343) objM9858;
                if (!c4343.mo9339()) {
                    m9875(c4343);
                } else if (C3777.m12082(f9946, this, objM9858, abstractC3751M9867)) {
                    return abstractC3751M9867;
                }
            } else {
                if (!(objM9858 instanceof InterfaceC2528)) {
                    if (z2) {
                        C2823 c2823 = objM9858 instanceof C2823 ? (C2823) objM9858 : null;
                        interfaceC2392.invoke(c2823 != null ? c2823.f10293 : null);
                    }
                    return C3555.f12368;
                }
                C4268 c4268Mo9340 = ((InterfaceC2528) objM9858).mo9340();
                if (c4268Mo9340 != null) {
                    InterfaceC2645 interfaceC2645 = C3555.f12368;
                    if (z && (objM9858 instanceof C2682)) {
                        synchronized (objM9858) {
                            thM9892 = ((C2682) objM9858).m9892();
                            if (thM9892 == null || ((interfaceC2392 instanceof C3931) && !((C2682) objM9858).m9894())) {
                                if (m9838(objM9858, c4268Mo9340, abstractC3751M9867)) {
                                    if (thM9892 == null) {
                                        return abstractC3751M9867;
                                    }
                                    interfaceC2645 = abstractC3751M9867;
                                }
                            }
                            i4 i4Var = i4.f6762;
                        }
                    }
                    if (thM9892 != null) {
                        if (z2) {
                            interfaceC2392.invoke(thM9892);
                        }
                        return interfaceC2645;
                    }
                    if (m9838(objM9858, c4268Mo9340, abstractC3751M9867)) {
                        return abstractC3751M9867;
                    }
                } else {
                    if (objM9858 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    m9876((AbstractC3751) objM9858);
                }
            }
        }
    }

    @Override // defpackage.InterfaceC5238
    /* renamed from: ԭ, reason: contains not printable characters */
    public final CancellationException mo9834() {
        Object objM9858 = m9858();
        if (!(objM9858 instanceof C2682)) {
            if (objM9858 instanceof InterfaceC2528) {
                throw new IllegalStateException(C3921.m12673("Job is still new or active: ", this).toString());
            }
            return objM9858 instanceof C2823 ? m9830(this, ((C2823) objM9858).f10293, null, 1, null) : new JobCancellationException(C3921.m12673(C2316.m8690(this), " has completed normally"), null, this);
        }
        Throwable thM9892 = ((C2682) objM9858).m9892();
        if (thM9892 != null) {
            return m9881(thM9892, C3921.m12673(C2316.m8690(this), " is cancelling"));
        }
        throw new IllegalStateException(C3921.m12673("Job is still new or active: ", this).toString());
    }

    @Override // defpackage.InterfaceC4999
    /* renamed from: ֈ, reason: contains not printable characters */
    public final void mo9835(InterfaceC5119 interfaceC5119) throws Throwable {
        m9842(interfaceC5119);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Throwable] */
    @Override // defpackage.InterfaceC5119
    /* renamed from: ׯ, reason: contains not printable characters */
    public CancellationException mo9836() {
        CancellationException cancellationExceptionM9892;
        Object objM9858 = m9858();
        if (objM9858 instanceof C2682) {
            cancellationExceptionM9892 = ((C2682) objM9858).m9892();
        } else if (objM9858 instanceof C2823) {
            cancellationExceptionM9892 = ((C2823) objM9858).f10293;
        } else {
            if (objM9858 instanceof InterfaceC2528) {
                throw new IllegalStateException(C3921.m12673("Cannot be cancelling child in this state: ", objM9858).toString());
            }
            cancellationExceptionM9892 = null;
        }
        CancellationException cancellationException = cancellationExceptionM9892 instanceof CancellationException ? cancellationExceptionM9892 : null;
        return cancellationException == null ? new JobCancellationException(C3921.m12673("Parent job is ", m9880(objM9858)), cancellationExceptionM9892, this) : cancellationException;
    }

    @Override // defpackage.InterfaceC5238
    /* renamed from: ހ, reason: contains not printable characters */
    public final InterfaceC3243 mo9837(InterfaceC4999 interfaceC4999) {
        return (InterfaceC3243) InterfaceC5238.C5239.m15257(this, true, false, new C3931(interfaceC4999), 2, null);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final boolean m9838(Object obj, C4268 c4268, AbstractC3751 abstractC3751) {
        int iM11322;
        C2683 c2683 = new C2683(abstractC3751, this, obj);
        do {
            iM11322 = c4268.m11316().m11322(abstractC3751, c4268, c2683);
            if (iM11322 == 1) {
                return true;
            }
        } while (iM11322 != 2);
        return false;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m9839(Throwable th, List<? extends Throwable> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                C4147.m13130(th, th2);
            }
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void mo9840(Object obj) {
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m9841(Throwable th) {
        return m9842(th);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m9842(Object obj) throws Throwable {
        Object objM9865 = C4479.f15380;
        if (mo9855() && (objM9865 = m9844(obj)) == C4479.f15381) {
            return true;
        }
        if (objM9865 == C4479.f15380) {
            objM9865 = m9865(obj);
        }
        if (objM9865 == C4479.f15380 || objM9865 == C4479.f15381) {
            return true;
        }
        if (objM9865 == C4479.f15383) {
            return false;
        }
        mo9840(objM9865);
        return true;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void mo9843(Throwable th) throws Throwable {
        m9842(th);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final Object m9844(Object obj) {
        Object objM9885;
        do {
            Object objM9858 = m9858();
            if (!(objM9858 instanceof InterfaceC2528) || ((objM9858 instanceof C2682) && ((C2682) objM9858).m9894())) {
                return C4479.f15380;
            }
            objM9885 = m9885(objM9858, new C2823(m9849(obj), false, 2, null));
        } while (objM9885 == C4479.f15382);
        return objM9885;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m9845(Throwable th) {
        if (mo9864()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        InterfaceC3243 interfaceC3243M9857 = m9857();
        return (interfaceC3243M9857 == null || interfaceC3243M9857 == C3555.f12368) ? z : interfaceC3243M9857.mo10905(th) || z;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public String mo9846() {
        return "Job was cancelled";
    }

    /* renamed from: ޏ */
    public boolean mo7621(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return m9842(th) && mo9854();
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m9847(InterfaceC2528 interfaceC2528, Object obj) throws Throwable {
        InterfaceC3243 interfaceC3243M9857 = m9857();
        if (interfaceC3243M9857 != null) {
            interfaceC3243M9857.dispose();
            m9878(C3555.f12368);
        }
        C2823 c2823 = obj instanceof C2823 ? (C2823) obj : null;
        Throwable th = c2823 != null ? c2823.f10293 : null;
        if (!(interfaceC2528 instanceof AbstractC3751)) {
            C4268 c4268Mo9340 = interfaceC2528.mo9340();
            if (c4268Mo9340 == null) {
                return;
            }
            m9871(c4268Mo9340, th);
            return;
        }
        try {
            ((AbstractC3751) interfaceC2528).mo9888(th);
        } catch (Throwable th2) {
            mo9859(new CompletionHandlerException("Exception in completion handler " + interfaceC2528 + " for " + this, th2));
        }
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m9848(C2682 c2682, C3931 c3931, Object obj) {
        C3931 c3931M9869 = m9869(c3931);
        if (c3931M9869 == null || !m9887(c2682, c3931M9869, obj)) {
            mo9840(m9850(c2682, obj));
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final Throwable m9849(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new JobCancellationException(mo9846(), null, this) : th;
        }
        if (obj != null) {
            return ((InterfaceC5119) obj).mo9836();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final Object m9850(C2682 c2682, Object obj) throws Throwable {
        boolean zM9893;
        Throwable thM9853;
        C2823 c2823 = obj instanceof C2823 ? (C2823) obj : null;
        Throwable th = c2823 == null ? null : c2823.f10293;
        synchronized (c2682) {
            zM9893 = c2682.m9893();
            List<Throwable> listM9896 = c2682.m9896(th);
            thM9853 = m9853(c2682, listM9896);
            if (thM9853 != null) {
                m9839(thM9853, listM9896);
            }
        }
        if (thM9853 != null && thM9853 != th) {
            obj = new C2823(thM9853, false, 2, null);
        }
        if (thM9853 != null) {
            if (m9845(thM9853) || mo6028(thM9853)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((C2823) obj).m10168();
            }
        }
        if (!zM9893) {
            m9872(thM9853);
        }
        mo9873(obj);
        C3777.m12082(f9946, this, c2682, C4479.m13734(obj));
        m9847(c2682, obj);
        return obj;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final C3931 m9851(InterfaceC2528 interfaceC2528) {
        C3931 c3931 = interfaceC2528 instanceof C3931 ? (C3931) interfaceC2528 : null;
        if (c3931 != null) {
            return c3931;
        }
        C4268 c4268Mo9340 = interfaceC2528.mo9340();
        if (c4268Mo9340 == null) {
            return null;
        }
        return m9869(c4268Mo9340);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final Throwable m9852(Object obj) {
        C2823 c2823 = obj instanceof C2823 ? (C2823) obj : null;
        if (c2823 == null) {
            return null;
        }
        return c2823.f10293;
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final Throwable m9853(C2682 c2682, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (c2682.m9893()) {
                return new JobCancellationException(mo9846(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof TimeoutCancellationException) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof TimeoutCancellationException)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public boolean mo9854() {
        return true;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean mo9855() {
        return false;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final C4268 m9856(InterfaceC2528 interfaceC2528) {
        C4268 c4268Mo9340 = interfaceC2528.mo9340();
        if (c4268Mo9340 != null) {
            return c4268Mo9340;
        }
        if (interfaceC2528 instanceof C4343) {
            return new C4268();
        }
        if (!(interfaceC2528 instanceof AbstractC3751)) {
            throw new IllegalStateException(C3921.m12673("State should have list: ", interfaceC2528).toString());
        }
        m9876((AbstractC3751) interfaceC2528);
        return null;
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public final InterfaceC3243 m9857() {
        return (InterfaceC3243) this._parentHandle;
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final Object m9858() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof AbstractC4290)) {
                return obj;
            }
            ((AbstractC4290) obj).mo13405(this);
        }
    }

    /* renamed from: ޜ */
    public boolean mo6028(Throwable th) {
        return false;
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m9860(InterfaceC5238 interfaceC5238) {
        if (interfaceC5238 == null) {
            m9878(C3555.f12368);
            return;
        }
        interfaceC5238.start();
        InterfaceC3243 interfaceC3243Mo9837 = interfaceC5238.mo9837(this);
        m9878(interfaceC3243Mo9837);
        if (m9863()) {
            interfaceC3243Mo9837.dispose();
            m9878(C3555.f12368);
        }
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final InterfaceC2645 m9861(InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        return mo9833(false, true, interfaceC2392);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final boolean m9862() {
        Object objM9858 = m9858();
        return (objM9858 instanceof C2823) || ((objM9858 instanceof C2682) && ((C2682) objM9858).m9893());
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final boolean m9863() {
        return !(m9858() instanceof InterfaceC2528);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public boolean mo9864() {
        return false;
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final Object m9865(Object obj) throws Throwable {
        Throwable thM9849 = null;
        while (true) {
            Object objM9858 = m9858();
            if (objM9858 instanceof C2682) {
                synchronized (objM9858) {
                    if (((C2682) objM9858).m9895()) {
                        return C4479.f15383;
                    }
                    boolean zM9893 = ((C2682) objM9858).m9893();
                    if (obj != null || !zM9893) {
                        if (thM9849 == null) {
                            thM9849 = m9849(obj);
                        }
                        ((C2682) objM9858).m9889(thM9849);
                    }
                    Throwable thM9892 = zM9893 ^ true ? ((C2682) objM9858).m9892() : null;
                    if (thM9892 != null) {
                        m9870(((C2682) objM9858).mo9340(), thM9892);
                    }
                    return C4479.f15380;
                }
            }
            if (!(objM9858 instanceof InterfaceC2528)) {
                return C4479.f15383;
            }
            if (thM9849 == null) {
                thM9849 = m9849(obj);
            }
            InterfaceC2528 interfaceC2528 = (InterfaceC2528) objM9858;
            if (!interfaceC2528.mo9339()) {
                Object objM9885 = m9885(objM9858, new C2823(thM9849, false, 2, null));
                if (objM9885 == C4479.f15380) {
                    throw new IllegalStateException(C3921.m12673("Cannot happen in ", objM9858).toString());
                }
                if (objM9885 != C4479.f15382) {
                    return objM9885;
                }
            } else if (m9884(interfaceC2528, thM9849)) {
                return C4479.f15380;
            }
        }
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public final Object m9866(Object obj) {
        Object objM9885;
        do {
            objM9885 = m9885(m9858(), obj);
            if (objM9885 == C4479.f15380) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, m9852(obj));
            }
        } while (objM9885 == C4479.f15382);
        return objM9885;
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final AbstractC3751 m9867(InterfaceC2392<? super Throwable, i4> interfaceC2392, boolean z) {
        AbstractC3751 c3290;
        if (z) {
            c3290 = interfaceC2392 instanceof AbstractC4027 ? (AbstractC4027) interfaceC2392 : null;
            if (c3290 == null) {
                c3290 = new C3111(interfaceC2392);
            }
        } else {
            AbstractC3751 abstractC3751 = interfaceC2392 instanceof AbstractC3751 ? (AbstractC3751) interfaceC2392 : null;
            c3290 = abstractC3751 != null ? abstractC3751 : null;
            if (c3290 == null) {
                c3290 = new C3290(interfaceC2392);
            }
        }
        c3290.m12028(this);
        return c3290;
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public String mo9868() {
        return C2316.m8690(this);
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public final C3931 m9869(C3469 c3469) {
        while (c3469.mo9808()) {
            c3469 = c3469.m11316();
        }
        while (true) {
            c3469 = c3469.m11315();
            if (!c3469.mo9808()) {
                if (c3469 instanceof C3931) {
                    return (C3931) c3469;
                }
                if (c3469 instanceof C4268) {
                    return null;
                }
            }
        }
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public final void m9870(C4268 c4268, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException;
        m9872(th);
        CompletionHandlerException completionHandlerException2 = null;
        for (C3469 c3469M11315 = (C3469) c4268.m11314(); !C3921.m12662(c3469M11315, c4268); c3469M11315 = c3469M11315.m11315()) {
            if (c3469M11315 instanceof AbstractC4027) {
                AbstractC3751 abstractC3751 = (AbstractC3751) c3469M11315;
                try {
                    abstractC3751.mo9888(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        C4147.m13130(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + abstractC3751 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 != null) {
            mo9859(completionHandlerException2);
        }
        m9845(th);
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m9871(C4268 c4268, Throwable th) throws Throwable {
        CompletionHandlerException completionHandlerException;
        CompletionHandlerException completionHandlerException2 = null;
        for (C3469 c3469M11315 = (C3469) c4268.m11314(); !C3921.m12662(c3469M11315, c4268); c3469M11315 = c3469M11315.m11315()) {
            if (c3469M11315 instanceof AbstractC3751) {
                AbstractC3751 abstractC3751 = (AbstractC3751) c3469M11315;
                try {
                    abstractC3751.mo9888(th);
                } catch (Throwable th2) {
                    if (completionHandlerException2 == null) {
                        completionHandlerException = null;
                    } else {
                        C4147.m13130(completionHandlerException2, th2);
                        completionHandlerException = completionHandlerException2;
                    }
                    if (completionHandlerException == null) {
                        completionHandlerException2 = new CompletionHandlerException("Exception in completion handler " + abstractC3751 + " for " + this, th2);
                    }
                }
            }
        }
        if (completionHandlerException2 == null) {
            return;
        }
        mo9859(completionHandlerException2);
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public void m9872(Throwable th) {
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public void mo9873(Object obj) {
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public void mo9874() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [བྷ] */
    /* renamed from: ࡤ, reason: contains not printable characters */
    public final void m9875(C4343 c4343) {
        C4268 c4268 = new C4268();
        if (!c4343.mo9339()) {
            c4268 = new C5045(c4268);
        }
        C3777.m12082(f9946, this, c4343, c4268);
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public final void m9876(AbstractC3751 abstractC3751) {
        abstractC3751.m11310(new C4268());
        C3777.m12082(f9946, this, abstractC3751, abstractC3751.m11315());
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public final void m9877(AbstractC3751 abstractC3751) {
        Object objM9858;
        do {
            objM9858 = m9858();
            if (!(objM9858 instanceof AbstractC3751)) {
                if (!(objM9858 instanceof InterfaceC2528) || ((InterfaceC2528) objM9858).mo9340() == null) {
                    return;
                }
                abstractC3751.mo9075();
                return;
            }
            if (objM9858 != abstractC3751) {
                return;
            }
        } while (!C3777.m12082(f9946, this, objM9858, C4479.f15386));
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public final void m9878(InterfaceC3243 interfaceC3243) {
        this._parentHandle = interfaceC3243;
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public final int m9879(Object obj) {
        if (obj instanceof C4343) {
            if (((C4343) obj).mo9339()) {
                return 0;
            }
            if (!C3777.m12082(f9946, this, obj, C4479.f15386)) {
                return -1;
            }
            mo9874();
            return 1;
        }
        if (!(obj instanceof C5045)) {
            return 0;
        }
        if (!C3777.m12082(f9946, this, obj, ((C5045) obj).mo9340())) {
            return -1;
        }
        mo9874();
        return 1;
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public final String m9880(Object obj) {
        if (!(obj instanceof C2682)) {
            return obj instanceof InterfaceC2528 ? ((InterfaceC2528) obj).mo9339() ? "Active" : "New" : obj instanceof C2823 ? "Cancelled" : "Completed";
        }
        C2682 c2682 = (C2682) obj;
        return c2682.m9893() ? "Cancelling" : c2682.m9894() ? "Completing" : "Active";
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public final CancellationException m9881(Throwable th, String str) {
        CancellationException jobCancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (jobCancellationException == null) {
            if (str == null) {
                str = mo9846();
            }
            jobCancellationException = new JobCancellationException(str, th, this);
        }
        return jobCancellationException;
    }

    /* renamed from: ࢡ, reason: contains not printable characters */
    public final String m9882() {
        return mo9868() + '{' + m9880(m9858()) + '}';
    }

    /* renamed from: ࢢ, reason: contains not printable characters */
    public final boolean m9883(InterfaceC2528 interfaceC2528, Object obj) throws Throwable {
        if (!C3777.m12082(f9946, this, interfaceC2528, C4479.m13734(obj))) {
            return false;
        }
        m9872(null);
        mo9873(obj);
        m9847(interfaceC2528, obj);
        return true;
    }

    /* renamed from: ࢣ, reason: contains not printable characters */
    public final boolean m9884(InterfaceC2528 interfaceC2528, Throwable th) throws Throwable {
        C4268 c4268M9856 = m9856(interfaceC2528);
        if (c4268M9856 == null) {
            return false;
        }
        if (!C3777.m12082(f9946, this, interfaceC2528, new C2682(c4268M9856, false, th))) {
            return false;
        }
        m9870(c4268M9856, th);
        return true;
    }

    /* renamed from: ࢤ, reason: contains not printable characters */
    public final Object m9885(Object obj, Object obj2) {
        return !(obj instanceof InterfaceC2528) ? C4479.f15380 : ((!(obj instanceof C4343) && !(obj instanceof AbstractC3751)) || (obj instanceof C3931) || (obj2 instanceof C2823)) ? m9886((InterfaceC2528) obj, obj2) : m9883((InterfaceC2528) obj, obj2) ? obj2 : C4479.f15382;
    }

    /* renamed from: ࢥ, reason: contains not printable characters */
    public final Object m9886(InterfaceC2528 interfaceC2528, Object obj) throws Throwable {
        C4268 c4268M9856 = m9856(interfaceC2528);
        if (c4268M9856 == null) {
            return C4479.f15382;
        }
        C2682 c2682 = interfaceC2528 instanceof C2682 ? (C2682) interfaceC2528 : null;
        if (c2682 == null) {
            c2682 = new C2682(c4268M9856, false, null);
        }
        synchronized (c2682) {
            if (c2682.m9894()) {
                return C4479.f15380;
            }
            c2682.m9897(true);
            if (c2682 != interfaceC2528 && !C3777.m12082(f9946, this, interfaceC2528, c2682)) {
                return C4479.f15382;
            }
            boolean zM9893 = c2682.m9893();
            C2823 c2823 = obj instanceof C2823 ? (C2823) obj : null;
            if (c2823 != null) {
                c2682.m9889(c2823.f10293);
            }
            Throwable thM9892 = true ^ zM9893 ? c2682.m9892() : null;
            i4 i4Var = i4.f6762;
            if (thM9892 != null) {
                m9870(c4268M9856, thM9892);
            }
            C3931 c3931M9851 = m9851(interfaceC2528);
            return (c3931M9851 == null || !m9887(c2682, c3931M9851, obj)) ? m9850(c2682, obj) : C4479.f15381;
        }
    }

    /* renamed from: ࢦ, reason: contains not printable characters */
    public final boolean m9887(C2682 c2682, C3931 c3931, Object obj) {
        while (InterfaceC5238.C5239.m15257(c3931.f13565, false, false, new C2681(this, c2682, c3931, obj), 1, null) == C3555.f12368) {
            c3931 = m9869(c3931);
            if (c3931 == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void mo9859(Throwable th) throws Throwable {
        throw th;
    }
}
