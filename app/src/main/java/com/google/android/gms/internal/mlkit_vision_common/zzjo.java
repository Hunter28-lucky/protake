package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
public final class zzjo implements zzjs {

    @VisibleForTesting
    public final List zza;

    public zzjo(Context context, zzjn zzjnVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzjnVar.zzc()) {
            arrayList.add(new zzjz(context, zzjnVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzjs
    public final void zza(zzju zzjuVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzjs) it.next()).zza(zzjuVar);
        }
    }
}
