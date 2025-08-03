package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzln implements zzlr {

    @VisibleForTesting
    public final List zza;

    public zzln(Context context, zzlm zzlmVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzlmVar.zzc()) {
            arrayList.add(new zzma(context, zzlmVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzlr
    public final void zza(zzlv zzlvVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzlr) it.next()).zza(zzlvVar);
        }
    }
}
