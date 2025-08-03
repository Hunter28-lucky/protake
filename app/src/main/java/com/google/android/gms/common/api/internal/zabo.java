package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
final class zabo implements Runnable {
    public final /* synthetic */ zabp zaa;

    public zabo(zabp zabpVar) {
        this.zaa = zabpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zabq zabqVar = this.zaa.zaa;
        zabqVar.zac.disconnect(zabqVar.zac.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
