package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import defpackage.C3743;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2529;
import defpackage.InterfaceC2715;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3167;
import defpackage.InterfaceC3421;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: FlowExt.kt */
/* loaded from: classes.dex */
public final class FlowExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FlowExt.kt */
    @InterfaceC3540(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", l = {91}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends SuspendLambda implements InterfaceC2849<InterfaceC3167<? super T>, InterfaceC4355<? super i4>, Object> {
        public final /* synthetic */ Lifecycle $lifecycle;
        public final /* synthetic */ Lifecycle.State $minActiveState;
        public final /* synthetic */ InterfaceC2715<T> $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        public int label;

        /* compiled from: FlowExt.kt */
        @InterfaceC3540(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", l = {99}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00401 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
            public final /* synthetic */ InterfaceC3167<T> $$this$callbackFlow;
            public final /* synthetic */ InterfaceC2715<T> $this_flowWithLifecycle;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C00401(InterfaceC2715<? extends T> interfaceC2715, InterfaceC3167<? super T> interfaceC3167, InterfaceC4355<? super C00401> interfaceC4355) {
                super(2, interfaceC4355);
                this.$this_flowWithLifecycle = interfaceC2715;
                this.$$this$callbackFlow = interfaceC3167;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
                return new C00401(this.$this_flowWithLifecycle, this.$$this$callbackFlow, interfaceC4355);
            }

            @Override // defpackage.InterfaceC2849
            public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
                return ((C00401) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objM15170 = C5199.m15170();
                int i = this.label;
                if (i == 0) {
                    C4817.m14542(obj);
                    InterfaceC2715<T> interfaceC2715 = this.$this_flowWithLifecycle;
                    final InterfaceC3167<T> interfaceC3167 = this.$$this$callbackFlow;
                    InterfaceC3421<T> interfaceC3421 = new InterfaceC3421<T>() { // from class: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1$invokeSuspend$$inlined$collect$1
                        @Override // defpackage.InterfaceC3421
                        public Object emit(T t, InterfaceC4355<? super i4> interfaceC4355) {
                            Object objMo9341 = interfaceC3167.mo9341(t, interfaceC4355);
                            return objMo9341 == C5199.m15170() ? objMo9341 : i4.f6762;
                        }
                    };
                    this.label = 1;
                    if (interfaceC2715.mo7361(interfaceC3421, this) == objM15170) {
                        return objM15170;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    C4817.m14542(obj);
                }
                return i4.f6762;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, InterfaceC2715<? extends T> interfaceC2715, InterfaceC4355<? super AnonymousClass1> interfaceC4355) {
            super(2, interfaceC4355);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$this_flowWithLifecycle = interfaceC2715;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, interfaceC4355);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3167<? super T> interfaceC3167, InterfaceC4355<? super i4> interfaceC4355) {
            return ((AnonymousClass1) create(interfaceC3167, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            InterfaceC3167 interfaceC3167;
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i == 0) {
                C4817.m14542(obj);
                InterfaceC3167 interfaceC31672 = (InterfaceC3167) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C00401 c00401 = new C00401(this.$this_flowWithLifecycle, interfaceC31672, null);
                this.L$0 = interfaceC31672;
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c00401, this) == objM15170) {
                    return objM15170;
                }
                interfaceC3167 = interfaceC31672;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                interfaceC3167 = (InterfaceC3167) this.L$0;
                C4817.m14542(obj);
            }
            InterfaceC2529.C2530.m9344(interfaceC3167, null, 1, null);
            return i4.f6762;
        }
    }

    public static final <T> InterfaceC2715<T> flowWithLifecycle(InterfaceC2715<? extends T> interfaceC2715, Lifecycle lifecycle, Lifecycle.State state) {
        C3921.m12666(interfaceC2715, "<this>");
        C3921.m12666(lifecycle, "lifecycle");
        C3921.m12666(state, "minActiveState");
        return C3743.m11990(new AnonymousClass1(lifecycle, state, interfaceC2715, null));
    }

    public static /* synthetic */ InterfaceC2715 flowWithLifecycle$default(InterfaceC2715 interfaceC2715, Lifecycle lifecycle, Lifecycle.State state, int i, Object obj) {
        if ((i & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        return flowWithLifecycle(interfaceC2715, lifecycle, state);
    }
}
