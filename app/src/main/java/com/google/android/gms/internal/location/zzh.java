package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
final class zzh implements zzbg<zzam> {
    public final /* synthetic */ zzi zza;

    public zzh(zzi zziVar) {
        this.zza = zziVar;
    }

    public final zzam zza() throws DeadObjectException {
        return (zzam) this.zza.getService();
    }
}
