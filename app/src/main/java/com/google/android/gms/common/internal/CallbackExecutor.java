package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public final class CallbackExecutor {
    private CallbackExecutor() {
    }

    @NonNull
    @KeepForSdk
    public static ExecutorService executorService() {
        return zzj.zza;
    }
}
