package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import defpackage.AbstractC4232;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* compiled from: ViewGroup.kt */
@InterfaceC3540(c = "androidx.core.view.ViewGroupKt$descendants$1", f = "ViewGroup.kt", l = {118, 120}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ViewGroupKt$descendants$1 extends RestrictedSuspendLambda implements InterfaceC2849<AbstractC4232<? super View>, InterfaceC4355<? super i4>, Object> {
    public final /* synthetic */ ViewGroup $this_descendants;
    public int I$0;
    public int I$1;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGroupKt$descendants$1(ViewGroup viewGroup, InterfaceC4355<? super ViewGroupKt$descendants$1> interfaceC4355) {
        super(2, interfaceC4355);
        this.$this_descendants = viewGroup;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
        ViewGroupKt$descendants$1 viewGroupKt$descendants$1 = new ViewGroupKt$descendants$1(this.$this_descendants, interfaceC4355);
        viewGroupKt$descendants$1.L$0 = obj;
        return viewGroupKt$descendants$1;
    }

    @Override // defpackage.InterfaceC2849
    public final Object invoke(AbstractC4232<? super View> abstractC4232, InterfaceC4355<? super i4> interfaceC4355) {
        return ((ViewGroupKt$descendants$1) create(abstractC4232, interfaceC4355)).invokeSuspend(i4.f6762);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x008e -> B:22:0x0090). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0097 -> B:24:0x009b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = defpackage.C5199.m15170()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L3d
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r11.I$1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$1
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            java.lang.Object r6 = r11.L$0
            ਉ r6 = (defpackage.AbstractC4232) r6
            defpackage.C4817.m14542(r12)
            r12 = r11
            goto L90
        L20:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L28:
            int r1 = r11.I$1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$2
            android.view.View r5 = (android.view.View) r5
            java.lang.Object r6 = r11.L$1
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            java.lang.Object r7 = r11.L$0
            ਉ r7 = (defpackage.AbstractC4232) r7
            defpackage.C4817.m14542(r12)
            r12 = r11
            goto L70
        L3d:
            defpackage.C4817.m14542(r12)
            java.lang.Object r12 = r11.L$0
            ਉ r12 = (defpackage.AbstractC4232) r12
            android.view.ViewGroup r1 = r11.$this_descendants
            r4 = 0
            int r5 = r1.getChildCount()
            r6 = r11
        L4c:
            if (r4 >= r5) goto L9d
            android.view.View r7 = r1.getChildAt(r4)
            java.lang.String r8 = "getChildAt(index)"
            defpackage.C3921.m12665(r7, r8)
            r6.L$0 = r12
            r6.L$1 = r1
            r6.L$2 = r7
            r6.I$0 = r4
            r6.I$1 = r5
            r6.label = r3
            java.lang.Object r8 = r12.mo13328(r7, r6)
            if (r8 != r0) goto L6a
            return r0
        L6a:
            r9 = r7
            r7 = r12
            r12 = r6
            r6 = r1
            r1 = r5
            r5 = r9
        L70:
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto L97
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            ౡ r5 = androidx.core.view.ViewGroupKt.getDescendants(r5)
            r12.L$0 = r7
            r12.L$1 = r6
            r8 = 0
            r12.L$2 = r8
            r12.I$0 = r4
            r12.I$1 = r1
            r12.label = r2
            java.lang.Object r5 = r7.m13329(r5, r12)
            if (r5 != r0) goto L8e
            return r0
        L8e:
            r5 = r6
            r6 = r7
        L90:
            r9 = r6
            r6 = r12
            r12 = r9
            r10 = r5
            r5 = r1
            r1 = r10
            goto L9b
        L97:
            r5 = r1
            r1 = r6
            r6 = r12
            r12 = r7
        L9b:
            int r4 = r4 + r3
            goto L4c
        L9d:
            i4 r12 = defpackage.i4.f6762
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.ViewGroupKt$descendants$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
