package com.google.android.gms.dynamic;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
final class zag implements zah {
    public final /* synthetic */ DeferredLifecycleHelper zaa;

    public zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zaa = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 5;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void zab(LifecycleDelegate lifecycleDelegate) {
        this.zaa.zaa.onResume();
    }
}
