package androidx.lifecycle;

import android.view.View;
import defpackage.C3921;

/* compiled from: ViewTreeViewModel.kt */
/* loaded from: classes.dex */
public final class ViewTreeViewModelKt {
    public static final ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        C3921.m12666(view, "<this>");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
