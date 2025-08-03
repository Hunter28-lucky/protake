package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;
import com.google.android.gms.common.internal.LibraryVersion;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.sdkinternal.CommonUtils;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzls {

    @Nullable
    private static zzbl zza;
    private static final zzbn zzb = zzbn.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzlr zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzls(Context context, final SharedPrefManager sharedPrefManager, zzlr zzlrVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzlrVar;
        zzmb.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzlq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza();
            }
        });
        this.zzh = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzlp
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzbn zzbnVar = zzb;
        this.zzj = zzbnVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzbnVar.get(str)) : -1;
    }

    @NonNull
    private static synchronized zzbl zzd() {
        zzbl zzblVar = zza;
        if (zzblVar != null) {
            return zzblVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzbi zzbiVar = new zzbi();
        for (int i = 0; i < locales.size(); i++) {
            zzbiVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzbl zzblVarZzc = zzbiVar.zzc();
        zza = zzblVarZzc;
        return zzblVarZzc;
    }

    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ void zzb(zzlv zzlvVar, zzjb zzjbVar, String str) {
        zzlvVar.zze(zzjbVar);
        String strZzb = zzlvVar.zzb();
        zzkn zzknVar = new zzkn();
        zzknVar.zzb(this.zzc);
        zzknVar.zzc(this.zzd);
        zzknVar.zzh(zzd());
        zzknVar.zzg(Boolean.TRUE);
        zzknVar.zzl(strZzb);
        zzknVar.zzj(str);
        zzknVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzknVar.zzd(10);
        zzknVar.zzk(Integer.valueOf(this.zzj));
        zzlvVar.zzf(zzknVar);
        this.zze.zza(zzlvVar);
    }

    @WorkerThread
    public final void zzc(com.google.android.gms.vision.face.mlkit.zzc zzcVar, final zzjb zzjbVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzk.get(zzjbVar) != null && jElapsedRealtime - ((Long) this.zzk.get(zzjbVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzk.put(zzjbVar, Long.valueOf(jElapsedRealtime));
        zzmh zzmhVar = zzcVar.zza;
        zzja zzjaVar = zzcVar.zzb;
        int i = zzcVar.zzc;
        zzjc zzjcVar = new zzjc();
        zzjcVar.zzd(zziz.TYPE_THICK);
        zzih zzihVar = new zzih();
        zzik zzikVar = new zzik();
        if (zzmhVar.zzb() == 2) {
            zzikVar.zza(zzil.ALL_CLASSIFICATIONS);
        } else {
            zzikVar.zza(zzil.NO_CLASSIFICATIONS);
        }
        if (zzmhVar.zzd() == 2) {
            zzikVar.zzd(zzin.ALL_LANDMARKS);
        } else {
            zzikVar.zzd(zzin.NO_LANDMARKS);
        }
        if (zzmhVar.zzc() == 2) {
            zzikVar.zzb(zzim.ALL_CONTOURS);
        } else {
            zzikVar.zzb(zzim.NO_CONTOURS);
        }
        if (zzmhVar.zze() == 2) {
            zzikVar.zzf(zzio.ACCURATE);
        } else {
            zzikVar.zzf(zzio.FAST);
        }
        zzikVar.zze(Float.valueOf(zzmhVar.zza()));
        zzikVar.zzc(Boolean.valueOf(zzmhVar.zzf()));
        zzihVar.zzb(zzikVar.zzk());
        zzihVar.zza(zzjaVar);
        zzjcVar.zzf(zzihVar.zzc());
        final zzlv zzlvVarZzd = zzlv.zzd(zzjcVar, i);
        final String version = this.zzg.isSuccessful() ? (String) this.zzg.getResult() : LibraryVersion.getInstance().getVersion(this.zzi);
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(zzlvVarZzd, zzjbVar, version, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_face_bundled.zzlo
            public final /* synthetic */ zzjb zzb;
            public final /* synthetic */ String zzc;
            public final /* synthetic */ zzlv zzd;

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(this.zzd, this.zzb, this.zzc);
            }
        });
    }
}
