package com.google.android.gms.internal.base;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
final class zan {
    @ChecksSdkIntAtLeast(api = 33)
    public static boolean zaa() {
        return Build.VERSION.SDK_INT >= 33;
    }
}
