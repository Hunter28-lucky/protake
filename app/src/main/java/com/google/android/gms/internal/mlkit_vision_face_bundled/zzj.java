package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzj {
    public static final /* synthetic */ int zza = 0;

    @Nullable
    private static volatile zzi zzc = null;
    private static volatile boolean zzd = false;
    private static final Object zzb = new Object();
    private static final AtomicReference zze = new AtomicReference();
    private static final zzl zzf = new zzl(zzg.zza, null);
    private static final AtomicInteger zzg = new AtomicInteger();

    public static void zza(final Context context) {
        if (zzc == null) {
            Object obj = zzb;
            synchronized (obj) {
                if (zzc == null) {
                    synchronized (obj) {
                        zzi zziVar = zzc;
                        Context applicationContext = context.getApplicationContext();
                        if (applicationContext != null) {
                            context = applicationContext;
                        }
                        if (zziVar == null || zziVar.zza() != context) {
                            zzf.zza();
                            zzk.zza();
                            zzc = new zze(context, zzbc.zza(new zzba() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzh
                            }));
                            zzg.incrementAndGet();
                        }
                    }
                }
            }
        }
    }
}
