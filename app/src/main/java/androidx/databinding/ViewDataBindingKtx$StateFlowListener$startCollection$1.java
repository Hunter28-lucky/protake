package androidx.databinding;

import androidx.databinding.ViewDataBindingKtx;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2715;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3421;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: ViewDataBindingKtx.kt */
@InterfaceC3540(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1", f = "ViewDataBindingKtx.kt", l = {95}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewDataBindingKtx$StateFlowListener$startCollection$1 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
    public final /* synthetic */ InterfaceC2715<Object> $flow;
    public final /* synthetic */ LifecycleOwner $owner;
    public int label;
    public final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

    /* compiled from: ViewDataBindingKtx.kt */
    @InterfaceC3540(c = "androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1", f = "ViewDataBindingKtx.kt", l = {123}, m = "invokeSuspend")
    /* renamed from: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
        public final /* synthetic */ InterfaceC2715<Object> $flow;
        public int label;
        public final /* synthetic */ ViewDataBindingKtx.StateFlowListener this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InterfaceC2715<? extends Object> interfaceC2715, ViewDataBindingKtx.StateFlowListener stateFlowListener, InterfaceC4355<? super AnonymousClass1> interfaceC4355) {
            super(2, interfaceC4355);
            this.$flow = interfaceC2715;
            this.this$0 = stateFlowListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            return new AnonymousClass1(this.$flow, this.this$0, interfaceC4355);
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
            return ((AnonymousClass1) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i == 0) {
                C4817.m14542(obj);
                InterfaceC2715<Object> interfaceC2715 = this.$flow;
                final ViewDataBindingKtx.StateFlowListener stateFlowListener = this.this$0;
                InterfaceC3421<? super Object> interfaceC3421 = new InterfaceC3421<Object>() { // from class: androidx.databinding.ViewDataBindingKtx$StateFlowListener$startCollection$1$1$invokeSuspend$$inlined$collect$1
                    @Override // defpackage.InterfaceC3421
                    public Object emit(Object obj2, InterfaceC4355<? super i4> interfaceC4355) {
                        i4 i4Var;
                        ViewDataBinding binder = stateFlowListener.listener.getBinder();
                        if (binder == null) {
                            i4Var = null;
                        } else {
                            binder.handleFieldChange(stateFlowListener.listener.mLocalFieldId, stateFlowListener.listener.getTarget(), 0);
                            i4Var = i4.f6762;
                        }
                        return i4Var == C5199.m15170() ? i4Var : i4.f6762;
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
    public ViewDataBindingKtx$StateFlowListener$startCollection$1(LifecycleOwner lifecycleOwner, InterfaceC2715<? extends Object> interfaceC2715, ViewDataBindingKtx.StateFlowListener stateFlowListener, InterfaceC4355<? super ViewDataBindingKtx$StateFlowListener$startCollection$1> interfaceC4355) {
        super(2, interfaceC4355);
        this.$owner = lifecycleOwner;
        this.$flow = interfaceC2715;
        this.this$0 = stateFlowListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        return new ViewDataBindingKtx$StateFlowListener$startCollection$1(this.$owner, this.$flow, this.this$0, interfaceC4355);
    }

    @Override // defpackage.InterfaceC2849
    public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
        return ((ViewDataBindingKtx$StateFlowListener$startCollection$1) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM15170 = C5199.m15170();
        int i = this.label;
        if (i == 0) {
            C4817.m14542(obj);
            Lifecycle lifecycle = this.$owner.getLifecycle();
            C3921.m12665(lifecycle, "owner.lifecycle");
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flow, this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, anonymousClass1, this) == objM15170) {
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
