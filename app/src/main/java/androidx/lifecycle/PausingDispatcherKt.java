package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import defpackage.C2404;
import defpackage.C2888;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC5238;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: PausingDispatcher.kt */
/* loaded from: classes.dex */
public final class PausingDispatcherKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: PausingDispatcher.kt */
    @InterfaceC3540(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {162}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super T>, Object> {
        public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super T>, Object> $block;
        public final /* synthetic */ Lifecycle.State $minState;
        public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Lifecycle lifecycle, Lifecycle.State state, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super AnonymousClass2> interfaceC4355) {
            super(2, interfaceC4355);
            this.$this_whenStateAtLeast = lifecycle;
            this.$minState = state;
            this.$block = interfaceC2849;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, interfaceC4355);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super T> interfaceC4355) {
            return ((AnonymousClass2) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            LifecycleController lifecycleController;
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                lifecycleController = (LifecycleController) this.L$0;
                try {
                    C4817.m14542(obj);
                    lifecycleController.finish();
                    return obj;
                } catch (Throwable th) {
                    th = th;
                    lifecycleController.finish();
                    throw th;
                }
            }
            C4817.m14542(obj);
            InterfaceC5238 interfaceC5238 = (InterfaceC5238) ((InterfaceC3539) this.L$0).getCoroutineContext().get(InterfaceC5238.f17362);
            if (interfaceC5238 == null) {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, interfaceC5238);
            try {
                InterfaceC2849<InterfaceC3539, InterfaceC4355<? super T>, Object> interfaceC2849 = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = C2404.m8899(pausingDispatcher, interfaceC2849, this);
                if (obj == objM15170) {
                    return objM15170;
                }
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                return obj;
            } catch (Throwable th2) {
                th = th2;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        }
    }

    public static final <T> Object whenCreated(LifecycleOwner lifecycleOwner, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        return whenCreated(lifecycle, interfaceC2849, interfaceC4355);
    }

    public static final <T> Object whenResumed(LifecycleOwner lifecycleOwner, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        return whenResumed(lifecycle, interfaceC2849, interfaceC4355);
    }

    public static final <T> Object whenStarted(LifecycleOwner lifecycleOwner, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        return whenStarted(lifecycle, interfaceC2849, interfaceC4355);
    }

    public static final <T> Object whenStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        return C2404.m8899(C2888.m10244().mo10951(), new AnonymousClass2(lifecycle, state, interfaceC2849, null), interfaceC4355);
    }

    public static final <T> Object whenCreated(Lifecycle lifecycle, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.CREATED, interfaceC2849, interfaceC4355);
    }

    public static final <T> Object whenResumed(Lifecycle lifecycle, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.RESUMED, interfaceC2849, interfaceC4355);
    }

    public static final <T> Object whenStarted(Lifecycle lifecycle, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super T>, ? extends Object> interfaceC2849, InterfaceC4355<? super T> interfaceC4355) {
        return whenStateAtLeast(lifecycle, Lifecycle.State.STARTED, interfaceC2849, interfaceC4355);
    }
}
