package com.google.android.gms.internal.mlkit_vision_common;

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

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
public final class zzjt {

    @Nullable
    private static zzp zza;
    private static final zzr zzb = zzr.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");
    private final String zzc;
    private final String zzd;
    private final zzjs zze;
    private final SharedPrefManager zzf;
    private final Task zzg;
    private final Task zzh;
    private final String zzi;
    private final int zzj;
    private final Map zzk = new HashMap();
    private final Map zzl = new HashMap();

    public zzjt(Context context, final SharedPrefManager sharedPrefManager, zzjs zzjsVar, String str) {
        this.zzc = context.getPackageName();
        this.zzd = CommonUtils.getAppVersion(context);
        this.zzf = sharedPrefManager;
        this.zze = zzjsVar;
        zzkg.zza();
        this.zzi = str;
        this.zzg = MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzjr
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza();
            }
        });
        MLTaskExecutor mLTaskExecutor = MLTaskExecutor.getInstance();
        sharedPrefManager.getClass();
        this.zzh = mLTaskExecutor.scheduleCallable(new Callable() { // from class: com.google.android.gms.internal.mlkit_vision_common.zzjq
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return sharedPrefManager.getMlSdkInstanceId();
            }
        });
        zzr zzrVar = zzb;
        this.zzj = zzrVar.containsKey(str) ? DynamiteModule.getRemoteVersion(context, (String) zzrVar.get(str)) : -1;
    }

    @NonNull
    private static synchronized zzp zzd() {
        zzp zzpVar = zza;
        if (zzpVar != null) {
            return zzpVar;
        }
        LocaleListCompat locales = ConfigurationCompat.getLocales(Resources.getSystem().getConfiguration());
        zzm zzmVar = new zzm();
        for (int i = 0; i < locales.size(); i++) {
            zzmVar.zzb(CommonUtils.languageTagFromLocale(locales.get(i)));
        }
        zzp zzpVarZzc = zzmVar.zzc();
        zza = zzpVarZzc;
        return zzpVarZzc;
    }

    public final /* synthetic */ String zza() throws Exception {
        return LibraryVersion.getInstance().getVersion(this.zzi);
    }

    public final /* synthetic */ void zzb(zzju zzjuVar, zzgz zzgzVar, String str) {
        zzjuVar.zzd(zzgzVar);
        String strZza = zzjuVar.zza();
        zzil zzilVar = new zzil();
        zzilVar.zzb(this.zzc);
        zzilVar.zzc(this.zzd);
        zzilVar.zzh(zzd());
        zzilVar.zzg(Boolean.TRUE);
        zzilVar.zzl(strZza);
        zzilVar.zzj(str);
        zzilVar.zzi(this.zzh.isSuccessful() ? (String) this.zzh.getResult() : this.zzf.getMlSdkInstanceId());
        zzilVar.zzd(10);
        zzilVar.zzk(Integer.valueOf(this.zzj));
        zzjuVar.zze(zzilVar);
        this.zze.zza(zzjuVar);
    }

    @WorkerThread
    public final void zzc(zzkd zzkdVar, final zzgz zzgzVar) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzk.get(zzgzVar) != null && jElapsedRealtime - ((Long) this.zzk.get(zzgzVar)).longValue() <= TimeUnit.SECONDS.toMillis(30L)) {
            return;
        }
        this.zzk.put(zzgzVar, Long.valueOf(jElapsedRealtime));
        int i = zzkdVar.zza;
        int i2 = zzkdVar.zzb;
        int i3 = zzkdVar.zzc;
        int i4 = zzkdVar.zzd;
        int i5 = zzkdVar.zze;
        long j = zzkdVar.zzf;
        int i6 = zzkdVar.zzg;
        zzgr zzgrVar = new zzgr();
        zzgrVar.zzd(i != -1 ? i != 35 ? i != 842094169 ? i != 16 ? i != 17 ? zzgn.UNKNOWN_FORMAT : zzgn.NV21 : zzgn.NV16 : zzgn.YV12 : zzgn.YUV_420_888 : zzgn.BITMAP);
        zzgrVar.zzf(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? zzgs.ANDROID_MEDIA_IMAGE : zzgs.FILEPATH : zzgs.BYTEBUFFER : zzgs.BYTEARRAY : zzgs.BITMAP);
        zzgrVar.zzc(Integer.valueOf(i3));
        zzgrVar.zze(Integer.valueOf(i4));
        zzgrVar.zzg(Integer.valueOf(i5));
        zzgrVar.zzb(Long.valueOf(j));
        zzgrVar.zzh(Integer.valueOf(i6));
        zzgu zzguVarZzj = zzgrVar.zzj();
        zzha zzhaVar = new zzha();
        zzhaVar.zzd(zzguVarZzj);
        final zzju zzjuVarZzc = zzju.zzc(zzhaVar);
        final String version = this.zzg.isSuccessful() ? (String) this.zzg.getResult() : LibraryVersion.getInstance().getVersion(this.zzi);
        final byte[] bArr = null;
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable(zzjuVarZzc, zzgzVar, version, bArr) { // from class: com.google.android.gms.internal.mlkit_vision_common.zzjp
            public final /* synthetic */ zzgz zzb;
            public final /* synthetic */ String zzc;
            public final /* synthetic */ zzju zzd;

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(this.zzd, this.zzb, this.zzc);
            }
        });
    }
}
