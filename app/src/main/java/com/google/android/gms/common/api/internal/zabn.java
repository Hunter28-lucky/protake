package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
final class zabn implements Runnable {
    public final /* synthetic */ int zaa;
    public final /* synthetic */ zabq zab;

    public zabn(zabq zabqVar, int i) {
        this.zab = zabqVar;
        this.zaa = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zab.zaI(this.zaa);
    }
}
