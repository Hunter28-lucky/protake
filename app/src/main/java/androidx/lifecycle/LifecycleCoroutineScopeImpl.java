package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import defpackage.C2888;
import defpackage.C3504;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5022;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    /* compiled from: Lifecycle.kt */
    @InterfaceC3540(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public AnonymousClass1(InterfaceC4355<? super AnonymousClass1> interfaceC4355) {
            super(2, interfaceC4355);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            AnonymousClass1 anonymousClass1 = LifecycleCoroutineScopeImpl.this.new AnonymousClass1(interfaceC4355);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
            return ((AnonymousClass1) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C5199.m15170();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4817.m14542(obj);
            InterfaceC3539 interfaceC3539 = (InterfaceC3539) this.L$0;
            if (LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                LifecycleCoroutineScopeImpl.this.getLifecycle$lifecycle_runtime_ktx_release().addObserver(LifecycleCoroutineScopeImpl.this);
            } else {
                C3504.m11442(interfaceC3539.getCoroutineContext(), null, 1, null);
            }
            return i4.f6762;
        }
    }

    public LifecycleCoroutineScopeImpl(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        C3921.m12666(lifecycle, "lifecycle");
        C3921.m12666(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState() == Lifecycle.State.DESTROYED) {
            C3504.m11442(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope, defpackage.InterfaceC3539
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.lifecycle.LifecycleCoroutineScope
    public Lifecycle getLifecycle$lifecycle_runtime_ktx_release() {
        return this.lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        C3921.m12666(lifecycleOwner, "source");
        C3921.m12666(event, NotificationCompat.CATEGORY_EVENT);
        if (getLifecycle$lifecycle_runtime_ktx_release().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle$lifecycle_runtime_ktx_release().removeObserver(this);
            C3504.m11442(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        C5022.m14810(this, C2888.m10244().mo10951(), null, new AnonymousClass1(null), 2, null);
    }
}
