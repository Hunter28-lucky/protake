package com.google.android.gms.common;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.blink.academy.film.stream.FinderManager;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@CheckReturnValue
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests.*/com/google/android/gms/common/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes2.dex */
public class PackageSignatureVerifier {

    @Nullable
    @VisibleForTesting
    public static volatile zzac zza;

    @Nullable
    private static zzad zzb;

    private static zzad zza(Context context) {
        zzad zzadVar;
        synchronized (PackageSignatureVerifier.class) {
            if (zzb == null) {
                zzb = new zzad(context);
            }
            zzadVar = zzb;
        }
        return zzadVar;
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerified(@NonNull Context context, @NonNull String str) {
        boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(context);
        zza(context);
        if (!zzn.zzf()) {
            throw new zzae();
        }
        String strConcat = String.valueOf(str).concat(true != zHonorsDebugCertificates ? "-0" : FinderManager.MACHINE_NOT_VALID);
        if (zza != null && zza.zza.equals(strConcat)) {
            return zza.zzb;
        }
        zza(context);
        zzx zzxVarZzc = zzn.zzc(str, zHonorsDebugCertificates, false, false);
        if (zzxVarZzc.zza) {
            zza = new zzac(strConcat, PackageVerificationResult.zzd(str, zzxVarZzc.zzd));
            return zza.zzb;
        }
        Preconditions.checkNotNull(zzxVarZzc.zzb);
        return PackageVerificationResult.zza(str, zzxVarZzc.zzb, zzxVarZzc.zzc);
    }

    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public PackageVerificationResult queryPackageSignatureVerifiedWithRetry(@NonNull Context context, @NonNull String str) {
        try {
            PackageVerificationResult packageVerificationResultQueryPackageSignatureVerified = queryPackageSignatureVerified(context, str);
            packageVerificationResultQueryPackageSignatureVerified.zzb();
            return packageVerificationResultQueryPackageSignatureVerified;
        } catch (SecurityException e2) {
            PackageVerificationResult packageVerificationResultQueryPackageSignatureVerified2 = queryPackageSignatureVerified(context, str);
            if (!packageVerificationResultQueryPackageSignatureVerified2.zzc()) {
                return packageVerificationResultQueryPackageSignatureVerified2;
            }
            Log.e("PkgSignatureVerifier", "Got flaky result during package signature verification", e2);
            return packageVerificationResultQueryPackageSignatureVerified2;
        }
    }
}
