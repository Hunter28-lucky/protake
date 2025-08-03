package com.google.android.gms.internal.mlkit_common;

import com.google.mlkit.common.sdkinternal.LazyInstanceMap;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzlw extends LazyInstanceMap {
    private zzlw() {
    }

    @Override // com.google.mlkit.common.sdkinternal.LazyInstanceMap
    public final /* bridge */ /* synthetic */ Object create(Object obj) {
        zzlf zzlfVar = (zzlf) obj;
        MlKitContext mlKitContext = MlKitContext.getInstance();
        return new zzlm(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class), new zzlg(MlKitContext.getInstance().getApplicationContext(), zzlfVar), zzlfVar.zzb());
    }

    public /* synthetic */ zzlw(zzlv zzlvVar) {
    }
}
