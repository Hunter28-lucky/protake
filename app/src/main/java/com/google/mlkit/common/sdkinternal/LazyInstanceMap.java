package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public abstract class LazyInstanceMap<K, V> {

    @GuardedBy("instances")
    private final Map zza = new HashMap();

    @NonNull
    @KeepForSdk
    public abstract V create(@NonNull K k);

    @NonNull
    @KeepForSdk
    public V get(@NonNull K k) {
        synchronized (this.zza) {
            if (this.zza.containsKey(k)) {
                return (V) this.zza.get(k);
            }
            V vCreate = create(k);
            this.zza.put(k, vCreate);
            return vCreate;
        }
    }
}
