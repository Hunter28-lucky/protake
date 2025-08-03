package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.ContentResolver;
import android.database.ContentObserver;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzf {
    private final ContentResolver zzc;
    private final ContentObserver zzd;

    @GuardedBy("ConfigurationContentLoader.class")
    private static final Map zzb = new ArrayMap();
    public static final String[] zza = {"key", "value"};

    public static synchronized void zza() {
        Map map = zzb;
        Iterator it = map.values().iterator();
        if (it.hasNext()) {
            ContentResolver contentResolver = ((zzf) it.next()).zzc;
            throw null;
        }
        map.clear();
    }
}
