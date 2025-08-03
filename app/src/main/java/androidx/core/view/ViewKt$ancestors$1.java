package androidx.core.view;

import android.view.ViewParent;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements InterfaceC2392<ViewParent, ViewParent> {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // defpackage.InterfaceC2392
    public final ViewParent invoke(ViewParent viewParent) {
        C3921.m12666(viewParent, "p0");
        return viewParent.getParent();
    }
}
