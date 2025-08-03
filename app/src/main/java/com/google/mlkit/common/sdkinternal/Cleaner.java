package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public class Cleaner {
    private final ReferenceQueue zza = new ReferenceQueue();
    private final Set zzb = Collections.synchronizedSet(new HashSet());

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    public interface Cleanable {
        @KeepForSdk
        void clean();
    }

    private Cleaner() {
    }

    @NonNull
    @KeepForSdk
    public static Cleaner create() {
        Cleaner cleaner = new Cleaner();
        cleaner.register(cleaner, new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zzb
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        final ReferenceQueue referenceQueue = cleaner.zza;
        final Set set = cleaner.zzb;
        Thread thread = new Thread(new Runnable() { // from class: com.google.mlkit.common.sdkinternal.zza
            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = referenceQueue;
                Set set2 = set;
                while (!set2.isEmpty()) {
                    try {
                        ((zzd) referenceQueue2.remove()).clean();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return cleaner;
    }

    @NonNull
    @KeepForSdk
    public Cleanable register(@NonNull Object obj, @NonNull Runnable runnable) {
        zzd zzdVar = new zzd(obj, this.zza, this.zzb, runnable, null);
        this.zzb.add(zzdVar);
        return zzdVar;
    }
}
