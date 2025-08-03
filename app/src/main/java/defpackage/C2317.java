package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: DispatchedContinuation.kt */
/* renamed from: ĉ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2317<T> extends AbstractC2893<T> implements InterfaceC4472, InterfaceC4355<T> {

    /* renamed from: ֏, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f8802 = AtomicReferenceFieldUpdater.newUpdater(C2317.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final CoroutineDispatcher f8803;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final InterfaceC4355<T> f8804;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Object f8805;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final Object f8806;

    /* JADX WARN: Multi-variable type inference failed */
    public C2317(CoroutineDispatcher coroutineDispatcher, InterfaceC4355<? super T> interfaceC4355) {
        super(-1);
        this.f8803 = coroutineDispatcher;
        this.f8804 = interfaceC4355;
        this.f8805 = C2946.f10662;
        this.f8806 = ThreadContextKt.m7371(getContext());
        this._reusableCancellableContinuation = null;
    }

    @Override // defpackage.InterfaceC4472
    public InterfaceC4472 getCallerFrame() {
        InterfaceC4355<T> interfaceC4355 = this.f8804;
        if (interfaceC4355 instanceof InterfaceC4472) {
            return (InterfaceC4472) interfaceC4355;
        }
        return null;
    }

    @Override // defpackage.InterfaceC4355
    public CoroutineContext getContext() {
        return this.f8804.getContext();
    }

    @Override // defpackage.InterfaceC4355
    public void resumeWith(Object obj) {
        CoroutineContext context = this.f8804.getContext();
        Object objM9544 = C2609.m9544(obj, null, 1, null);
        if (this.f8803.isDispatchNeeded(context)) {
            this.f8805 = objM9544;
            this.f10568 = 0;
            this.f8803.dispatch(context, this);
            return;
        }
        AbstractC2333 abstractC2333M5985 = e2.f6600.m5985();
        if (abstractC2333M5985.m8743()) {
            this.f8805 = objM9544;
            this.f10568 = 0;
            abstractC2333M5985.m8741(this);
            return;
        }
        abstractC2333M5985.m8742(true);
        try {
            CoroutineContext context2 = getContext();
            Object objM7372 = ThreadContextKt.m7372(context2, this.f8806);
            try {
                this.f8804.resumeWith(obj);
                i4 i4Var = i4.f6762;
                while (abstractC2333M5985.m8745()) {
                }
            } finally {
                ThreadContextKt.m7370(context2, objM7372);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f8803 + ", " + C2316.m8692(this.f8804) + ']';
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo8693(Object obj, Throwable th) {
        if (obj instanceof C3183) {
            ((C3183) obj).f11265.invoke(th);
        }
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ԩ, reason: contains not printable characters */
    public InterfaceC4355<T> mo8694() {
        return this;
    }

    @Override // defpackage.AbstractC2893
    /* renamed from: Ԯ, reason: contains not printable characters */
    public Object mo8695() {
        Object obj = this.f8805;
        this.f8805 = C2946.f10662;
        return obj;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m8696() {
        while (this._reusableCancellableContinuation == C2946.f10663) {
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final C4441<T> m8697() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = C2946.f10663;
                return null;
            }
            if (obj instanceof C4441) {
                if (C3777.m12082(f8802, this, obj, C2946.f10663)) {
                    return (C4441) obj;
                }
            } else if (obj != C2946.f10663 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(C3921.m12673("Inconsistent state ", obj).toString());
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final C4441<?> m8698() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof C4441) {
            return (C4441) obj;
        }
        return null;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean m8699(C4441<?> c4441) {
        Object obj = this._reusableCancellableContinuation;
        if (obj == null) {
            return false;
        }
        return !(obj instanceof C4441) || obj == c4441;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final boolean m8700(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            r0 r0Var = C2946.f10663;
            if (C3921.m12662(obj, r0Var)) {
                if (C3777.m12082(f8802, this, r0Var, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (C3777.m12082(f8802, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m8701() {
        m8696();
        C4441<?> c4441M8698 = m8698();
        if (c4441M8698 == null) {
            return;
        }
        c4441M8698.m13679();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final Throwable m8702(InterfaceC5005<?> interfaceC5005) {
        r0 r0Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            r0Var = C2946.f10663;
            if (obj != r0Var) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(C3921.m12673("Inconsistent state ", obj).toString());
                }
                if (C3777.m12082(f8802, this, obj, null)) {
                    return (Throwable) obj;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } while (!C3777.m12082(f8802, this, r0Var, interfaceC5005));
        return null;
    }
}
