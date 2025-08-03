package com.google.android.gms.internal.mlkit_vision_face;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzmr implements zzmy {

    @VisibleForTesting
    public final List zza;

    public zzmr(Context context, zzmq zzmqVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzmqVar.zzc()) {
            arrayList.add(new zznh(context, zzmqVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face.zzmy
    public final void zza(zznc zzncVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzmy) it.next()).zza(zzncVar);
        }
    }
}
