package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzlg implements zzll {

    @VisibleForTesting
    public final List zza;

    public zzlg(Context context, zzlf zzlfVar) {
        ArrayList arrayList = new ArrayList();
        this.zza = arrayList;
        if (zzlfVar.zzc()) {
            arrayList.add(new zzlu(context, zzlfVar));
        }
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzll
    public final void zza(zzld zzldVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzll) it.next()).zza(zzldVar);
        }
    }
}
