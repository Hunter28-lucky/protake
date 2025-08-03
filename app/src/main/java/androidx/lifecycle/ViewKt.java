package androidx.lifecycle;

import android.view.View;
import defpackage.C3921;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class ViewKt {
    public static final LifecycleOwner findViewTreeLifecycleOwner(View view) {
        C3921.m12666(view, "<this>");
        return ViewTreeLifecycleOwner.get(view);
    }
}
