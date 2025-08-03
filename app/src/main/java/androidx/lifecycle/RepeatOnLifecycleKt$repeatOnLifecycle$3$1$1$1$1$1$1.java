package androidx.lifecycle;

import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: RepeatOnLifecycle.kt */
@InterfaceC3540(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
    public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> $block;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1> interfaceC4355) {
        super(2, interfaceC4355);
        this.$block = interfaceC2849;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, interfaceC4355);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // defpackage.InterfaceC2849
    public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM15170 = C5199.m15170();
        int i = this.label;
        if (i == 0) {
            C4817.m14542(obj);
            InterfaceC3539 interfaceC3539 = (InterfaceC3539) this.L$0;
            InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> interfaceC2849 = this.$block;
            this.label = 1;
            if (interfaceC2849.invoke(interfaceC3539, this) == objM15170) {
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
