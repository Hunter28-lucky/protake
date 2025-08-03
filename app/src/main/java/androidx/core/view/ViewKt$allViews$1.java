package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC4232;
import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC4590;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* compiled from: View.kt */
@InterfaceC3540(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {406, 408}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements InterfaceC2849<AbstractC4232<? super View>, InterfaceC4355<? super i4>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, InterfaceC4355<? super ViewKt$allViews$1> interfaceC4355) {
        super(2, interfaceC4355);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, interfaceC4355);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // defpackage.InterfaceC2849
    public final Object invoke(AbstractC4232<? super View> abstractC4232, InterfaceC4355<? super i4> interfaceC4355) {
        return ((ViewKt$allViews$1) create(abstractC4232, interfaceC4355)).invokeSuspend(i4.f6762);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC4232 abstractC4232;
        Object objM15170 = C5199.m15170();
        int i = this.label;
        if (i == 0) {
            C4817.m14542(obj);
            abstractC4232 = (AbstractC4232) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = abstractC4232;
            this.label = 1;
            if (abstractC4232.mo13328(view, this) == objM15170) {
                return objM15170;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4817.m14542(obj);
                return i4.f6762;
            }
            abstractC4232 = (AbstractC4232) this.L$0;
            C4817.m14542(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            InterfaceC4590<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (abstractC4232.m13329(descendants, this) == objM15170) {
                return objM15170;
            }
        }
        return i4.f6762;
    }
}
