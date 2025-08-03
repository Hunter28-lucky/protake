package androidx.lifecycle;

import defpackage.C3921;

/* compiled from: LifecycleOwner.kt */
/* loaded from: classes.dex */
public final class LifecycleOwnerKt {
    public static final LifecycleCoroutineScope getLifecycleScope(LifecycleOwner lifecycleOwner) {
        C3921.m12666(lifecycleOwner, "<this>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        return LifecycleKt.getCoroutineScope(lifecycle);
    }
}
