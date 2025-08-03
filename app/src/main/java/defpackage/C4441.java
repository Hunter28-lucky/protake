package defpackage;

import defpackage.InterfaceC5238;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CompletionHandlerException;

/* compiled from: CancellableContinuationImpl.kt */
/* renamed from: ଽ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4441<T> extends AbstractC2893<T> implements InterfaceC5005<T>, InterfaceC4472 {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15302 = AtomicIntegerFieldUpdater.newUpdater(C4441.class, "_decision");

    /* renamed from: ֏, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15303 = AtomicReferenceFieldUpdater.newUpdater(C4441.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InterfaceC4355<T> f15304;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final CoroutineContext f15305;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC2645 f15306;

    /* JADX WARN: Multi-variable type inference failed */
    public C4441(InterfaceC4355<? super T> interfaceC4355, int i) {
        super(i);
        this.f15304 = interfaceC4355;
        this.f15305 = interfaceC4355.getContext();
        this._decision = 0;
        this._state = C3810.f13053;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ޕ, reason: contains not printable characters */
    public static /* synthetic */ void m13668(C4441 c4441, Object obj, int i, InterfaceC2392 interfaceC2392, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            interfaceC2392 = null;
        }
        c4441.m13697(obj, i, interfaceC2392);
    }

    @Override // defpackage.InterfaceC4472
    public InterfaceC4472 getCallerFrame() {
        InterfaceC4355<T> interfaceC4355 = this.f15304;
        if (interfaceC4355 instanceof InterfaceC4472) {
            return (InterfaceC4472) interfaceC4355;
        }
        return null;
    }

    @Override // defpackage.InterfaceC4355
    public CoroutineContext getContext() {
        return this.f15305;
    }

    @Override // defpackage.InterfaceC4355
    public void resumeWith(Object obj) {
        m13668(this, C2609.m9542(obj, this), this.f10568, null, 4, null);
    }

    public String toString() {
        return m13693() + '(' + C2316.m8692(this.f15304) + "){" + m13686() + "}@" + C2316.m8691(this);
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ϳ */
    public void mo8693(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof InterfaceC4270) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof C2823) {
                return;
            }
            if (obj2 instanceof C5018) {
                C5018 c5018 = (C5018) obj2;
                if (!(!c5018.m14806())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (C3777.m12082(f15303, this, obj2, C5018.m14804(c5018, null, null, null, null, th, 15, null))) {
                    c5018.m14807(this, th);
                    return;
                }
            } else if (C3777.m12082(f15303, this, obj2, new C5018(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ԩ */
    public final InterfaceC4355<T> mo8694() {
        return this.f15304;
    }

    @Override // defpackage.InterfaceC5005
    /* renamed from: ԩ, reason: contains not printable characters */
    public Object mo13669(T t, Object obj) {
        return m13700(t, obj, null);
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ԫ */
    public Throwable mo10261(Object obj) {
        Throwable thMo10261 = super.mo10261(obj);
        if (thMo10261 == null) {
            return null;
        }
        mo8694();
        return thMo10261;
    }

    @Override // defpackage.InterfaceC5005
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo13670(InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        AbstractC3820 abstractC3820M13691 = m13691(interfaceC2392);
        while (true) {
            Object obj = this._state;
            if (obj instanceof C3810) {
                if (C3777.m12082(f15303, this, obj, abstractC3820M13691)) {
                    return;
                }
            } else if (obj instanceof AbstractC3820) {
                m13692(interfaceC2392, obj);
            } else {
                boolean z = obj instanceof C2823;
                if (z) {
                    C2823 c2823 = (C2823) obj;
                    if (!c2823.m10168()) {
                        m13692(interfaceC2392, obj);
                    }
                    if (obj instanceof C4221) {
                        if (!z) {
                            c2823 = null;
                        }
                        m13674(interfaceC2392, c2823 != null ? c2823.f10293 : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof C5018) {
                    C5018 c5018 = (C5018) obj;
                    if (c5018.f16780 != null) {
                        m13692(interfaceC2392, obj);
                    }
                    if (abstractC3820M13691 instanceof AbstractC5189) {
                        return;
                    }
                    if (c5018.m14806()) {
                        m13674(interfaceC2392, c5018.f16783);
                        return;
                    } else {
                        if (C3777.m12082(f15303, this, obj, C5018.m14804(c5018, null, abstractC3820M13691, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (abstractC3820M13691 instanceof AbstractC5189) {
                        return;
                    }
                    if (C3777.m12082(f15303, this, obj, new C5018(obj, abstractC3820M13691, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC2893
    /* renamed from: Ԭ */
    public <T> T mo10262(Object obj) {
        return obj instanceof C5018 ? (T) ((C5018) obj).f16779 : obj;
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ԯ */
    public Object mo8695() {
        return m13685();
    }

    @Override // defpackage.InterfaceC5005
    /* renamed from: ԯ, reason: contains not printable characters */
    public void mo13671(T t, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        m13697(t, this.f10568, interfaceC2392);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Void m13672(Object obj) {
        throw new IllegalStateException(C3921.m12673("Already resumed, but proposed with update ", obj).toString());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m13673(AbstractC3820 abstractC3820, Throwable th) {
        try {
            abstractC3820.mo7352(th);
        } catch (Throwable th2) {
            C4084.m13020(getContext(), new CompletionHandlerException(C3921.m12673("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m13674(InterfaceC2392<? super Throwable, i4> interfaceC2392, Throwable th) {
        try {
            interfaceC2392.invoke(th);
        } catch (Throwable th2) {
            C4084.m13020(getContext(), new CompletionHandlerException(C3921.m12673("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m13675(InterfaceC2392<? super Throwable, i4> interfaceC2392, Throwable th) {
        try {
            interfaceC2392.invoke(th);
        } catch (Throwable th2) {
            C4084.m13020(getContext(), new CompletionHandlerException(C3921.m12673("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    @Override // defpackage.InterfaceC5005
    /* renamed from: ؠ, reason: contains not printable characters */
    public Object mo13676(T t, Object obj, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        return m13700(t, obj, interfaceC2392);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public boolean m13677(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof InterfaceC4270)) {
                return false;
            }
            z = obj instanceof AbstractC3820;
        } while (!C3777.m12082(f15303, this, obj, new C4221(this, th, z)));
        AbstractC3820 abstractC3820 = z ? (AbstractC3820) obj : null;
        if (abstractC3820 != null) {
            m13673(abstractC3820, th);
        }
        m13681();
        m13682(this.f10568);
        return true;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final boolean m13678(Throwable th) {
        if (C3490.m11407(this.f10568) && m13690()) {
            return ((C2317) this.f15304).m8700(th);
        }
        return false;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m13679() {
        InterfaceC2645 interfaceC2645 = this.f15306;
        if (interfaceC2645 == null) {
            return;
        }
        interfaceC2645.dispose();
        this.f15306 = C3555.f12368;
    }

    @Override // defpackage.InterfaceC5005
    /* renamed from: ރ, reason: contains not printable characters */
    public void mo13680(Object obj) {
        m13682(this.f10568);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m13681() {
        if (m13690()) {
            return;
        }
        m13679();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m13682(int i) {
        if (m13699()) {
            return;
        }
        C3490.m11405(this, i);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public Throwable m13683(InterfaceC5238 interfaceC5238) {
        return interfaceC5238.mo9834();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final Object m13684() throws Throwable {
        InterfaceC5238 interfaceC5238;
        boolean zM13690 = m13690();
        if (m13701()) {
            if (this.f15306 == null) {
                m13688();
            }
            if (zM13690) {
                m13695();
            }
            return C5199.m15170();
        }
        if (zM13690) {
            m13695();
        }
        Object objM13685 = m13685();
        if (objM13685 instanceof C2823) {
            throw ((C2823) objM13685).f10293;
        }
        if (!C3490.m11406(this.f10568) || (interfaceC5238 = (InterfaceC5238) getContext().get(InterfaceC5238.f17362)) == null || interfaceC5238.mo9831()) {
            return mo10262(objM13685);
        }
        CancellationException cancellationExceptionMo9834 = interfaceC5238.mo9834();
        mo8693(objM13685, cancellationExceptionMo9834);
        throw cancellationExceptionMo9834;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final Object m13685() {
        return this._state;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final String m13686() {
        Object objM13685 = m13685();
        return objM13685 instanceof InterfaceC4270 ? "Active" : objM13685 instanceof C4221 ? "Cancelled" : "Completed";
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public void m13687() {
        InterfaceC2645 interfaceC2645M13688 = m13688();
        if (interfaceC2645M13688 != null && m13689()) {
            interfaceC2645M13688.dispose();
            this.f15306 = C3555.f12368;
        }
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final InterfaceC2645 m13688() {
        InterfaceC5238 interfaceC5238 = (InterfaceC5238) getContext().get(InterfaceC5238.f17362);
        if (interfaceC5238 == null) {
            return null;
        }
        InterfaceC2645 interfaceC2645M15257 = InterfaceC5238.C5239.m15257(interfaceC5238, true, false, new C4660(this), 2, null);
        this.f15306 = interfaceC2645M15257;
        return interfaceC2645M15257;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean m13689() {
        return !(m13685() instanceof InterfaceC4270);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final boolean m13690() {
        InterfaceC4355<T> interfaceC4355 = this.f15304;
        return (interfaceC4355 instanceof C2317) && ((C2317) interfaceC4355).m8699(this);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final AbstractC3820 m13691(InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        return interfaceC2392 instanceof AbstractC3820 ? (AbstractC3820) interfaceC2392 : new C4108(interfaceC2392);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m13692(InterfaceC2392<? super Throwable, i4> interfaceC2392, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + interfaceC2392 + ", already has " + obj).toString());
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public String m13693() {
        return "CancellableContinuation";
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m13694(Throwable th) {
        if (m13678(th)) {
            return;
        }
        m13677(th);
        m13681();
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m13695() {
        InterfaceC4355<T> interfaceC4355 = this.f15304;
        C2317 c2317 = interfaceC4355 instanceof C2317 ? (C2317) interfaceC4355 : null;
        Throwable thM8702 = c2317 != null ? c2317.m8702(this) : null;
        if (thM8702 == null) {
            return;
        }
        m13679();
        m13677(thM8702);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final boolean m13696() {
        Object obj = this._state;
        if ((obj instanceof C5018) && ((C5018) obj).f16782 != null) {
            m13679();
            return false;
        }
        this._decision = 0;
        this._state = C3810.f13053;
        return true;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m13697(Object obj, int i, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof InterfaceC4270)) {
                if (obj2 instanceof C4221) {
                    C4221 c4221 = (C4221) obj2;
                    if (c4221.m13309()) {
                        if (interfaceC2392 == null) {
                            return;
                        }
                        m13675(interfaceC2392, c4221.f10293);
                        return;
                    }
                }
                m13672(obj);
                throw new KotlinNothingValueException();
            }
        } while (!C3777.m12082(f15303, this, obj2, m13698((InterfaceC4270) obj2, obj, i, interfaceC2392, null)));
        m13681();
        m13682(i);
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final Object m13698(InterfaceC4270 interfaceC4270, Object obj, int i, InterfaceC2392<? super Throwable, i4> interfaceC2392, Object obj2) {
        if (obj instanceof C2823) {
            return obj;
        }
        if (!C3490.m11406(i) && obj2 == null) {
            return obj;
        }
        if (interfaceC2392 != null || (((interfaceC4270 instanceof AbstractC3820) && !(interfaceC4270 instanceof AbstractC5189)) || obj2 != null)) {
            return new C5018(obj, interfaceC4270 instanceof AbstractC3820 ? (AbstractC3820) interfaceC4270 : null, interfaceC2392, obj2, null, 16, null);
        }
        return obj;
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final boolean m13699() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f15302.compareAndSet(this, 0, 2));
        return true;
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final r0 m13700(Object obj, Object obj2, InterfaceC2392<? super Throwable, i4> interfaceC2392) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof InterfaceC4270)) {
                if ((obj3 instanceof C5018) && obj2 != null && ((C5018) obj3).f16782 == obj2) {
                    return C5006.f16769;
                }
                return null;
            }
        } while (!C3777.m12082(f15303, this, obj3, m13698((InterfaceC4270) obj3, obj, this.f10568, interfaceC2392, obj2)));
        m13681();
        return C5006.f16769;
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final boolean m13701() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f15302.compareAndSet(this, 0, 1));
        return true;
    }
}
