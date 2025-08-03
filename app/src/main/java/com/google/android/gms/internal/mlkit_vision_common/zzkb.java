package com.google.android.gms.internal.mlkit_vision_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
final class zzkb extends LazyInstanceMap {
    private zzkb() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzjn zzjnVar = (zzjn) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzjt(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzjo(MlKitContext.getInstance().getApplicationContext(), zzjnVar), zzjnVar.zzb());
    }

    public /* synthetic */ zzkb(zzka zzkaVar) {
    }
}
