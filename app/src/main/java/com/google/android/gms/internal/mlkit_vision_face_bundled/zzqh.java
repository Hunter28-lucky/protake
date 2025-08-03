package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
final class zzqh extends zzqr {
    public zzqh(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzqr
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzb(); i++) {
                Map.Entry entryZzg = zzg(i);
                ((zzoc) entryZzg.getKey()).zze();
                entryZzg.setValue(Collections.unmodifiableList((List) entryZzg.getValue()));
            }
            for (Map.Entry entry : zzc()) {
                ((zzoc) entry.getKey()).zze();
                entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
            }
        }
        super.zza();
    }
}
