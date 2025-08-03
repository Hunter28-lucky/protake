package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzi {
    public static final /* synthetic */ int zza = 0;
    private static final String[] zzb = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze"};
    private static final String[] zzc;
    private static final String[] zzd;

    static {
        String[] strArr = new String[2];
        strArr[0] = "media";
        String str = Build.HARDWARE;
        strArr[1] = true != (str.equals("goldfish") || str.equals("ranchu")) ? "" : "androidx.test.services.storage.runfiles";
        zzc = strArr;
        String[] strArr2 = new String[3];
        int i = Build.VERSION.SDK_INT;
        strArr2[0] = i <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : "";
        strArr2[1] = i <= 25 ? "com.google.android.inputmethod.latin.dev.inputcontent" : "";
        strArr2[2] = "com.google.android.apps.docs.storage.legacy";
        zzd = strArr2;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String str) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        zzh zzhVar = zzh.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriZzc = zzc(uri);
        String scheme = uriZzc.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openAssetFileDescriptor(uriZzc, "r");
        }
        if ("content".equals(scheme)) {
            if (!zzi(context, uriZzc, 1, zzhVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriZzc, "r");
            zzd(assetFileDescriptorOpenAssetFileDescriptor);
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = contentResolver.openAssetFileDescriptor(uriZzc, "r");
        zzd(assetFileDescriptorOpenAssetFileDescriptor2);
        try {
            zzh(context, assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor(), uriZzc, zzhVar);
            return assetFileDescriptorOpenAssetFileDescriptor2;
        } catch (FileNotFoundException e2) {
            zzf(assetFileDescriptorOpenAssetFileDescriptor2, e2);
            throw e2;
        } catch (IOException e3) {
            FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
            fileNotFoundException.initCause(e3);
            zzf(assetFileDescriptorOpenAssetFileDescriptor2, fileNotFoundException);
            throw fileNotFoundException;
        }
    }

    public static InputStream zzb(Context context, Uri uri) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        zzh zzhVar = zzh.zza;
        ContentResolver contentResolver = context.getContentResolver();
        Uri uriZzc = zzc(uri);
        String scheme = uriZzc.getScheme();
        if ("android.resource".equals(scheme)) {
            return contentResolver.openInputStream(uriZzc);
        }
        if ("content".equals(scheme)) {
            if (!zzi(context, uriZzc, 1, zzhVar)) {
                throw new FileNotFoundException("Can't open content uri.");
            }
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uriZzc);
            zzd(inputStreamOpenInputStream);
            return inputStreamOpenInputStream;
        }
        if (!"file".equals(scheme)) {
            throw new FileNotFoundException("Unsupported scheme");
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(Uri.fromFile(new File(uriZzc.getPath()).getCanonicalFile()), "r");
            try {
                zzh(context, parcelFileDescriptorOpenFileDescriptor, uriZzc, zzhVar);
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptorOpenFileDescriptor);
            } catch (FileNotFoundException e2) {
                zzg(parcelFileDescriptorOpenFileDescriptor, e2);
                throw e2;
            } catch (IOException e3) {
                FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                fileNotFoundException.initCause(e3);
                zzg(parcelFileDescriptorOpenFileDescriptor, fileNotFoundException);
                throw fileNotFoundException;
            }
        } catch (IOException e4) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Canonicalization failed.");
            fileNotFoundException2.initCause(e4);
            throw fileNotFoundException2;
        }
    }

    private static Uri zzc(Uri uri) {
        return Build.VERSION.SDK_INT < 30 ? Uri.parse(uri.toString()) : uri;
    }

    private static Object zzd(Object obj) throws FileNotFoundException {
        if (obj != null) {
            return obj;
        }
        throw new FileNotFoundException("Content resolver returned null value.");
    }

    private static String zze(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith("/") ? canonicalPath.concat("/") : canonicalPath;
    }

    private static void zzf(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            assetFileDescriptor.close();
        } catch (IOException e2) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(fileNotFoundException, e2);
        }
    }

    private static void zzg(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            parcelFileDescriptor.close();
        } catch (IOException e2) {
            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(fileNotFoundException, e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x007f A[EDGE_INSN: B:66:0x007f->B:26:0x007f BREAK  A[LOOP:0: B:35:0x00a3->B:41:0x00b4], EDGE_INSN: B:26:0x007f->B:50:0x00d6 BREAK  A[LOOP:1: B:43:0x00c2->B:49:0x00d3]] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dc A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzh(final android.content.Context r7, android.os.ParcelFileDescriptor r8, android.net.Uri r9, com.google.android.gms.internal.mlkit_common.zzh r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_common.zzi.zzh(android.content.Context, android.os.ParcelFileDescriptor, android.net.Uri, com.google.android.gms.internal.mlkit_common.zzh):void");
    }

    private static boolean zzi(Context context, Uri uri, int i, zzh zzhVar) {
        String authority = uri.getAuthority();
        ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
        if (providerInfoResolveContentProvider == null) {
            int iLastIndexOf = authority.lastIndexOf(64);
            if (iLastIndexOf >= 0) {
                authority = authority.substring(iLastIndexOf + 1);
                providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            }
            if (providerInfoResolveContentProvider == null) {
                return !zzhVar.zzc;
            }
        }
        int iZzc = zzh.zzc(zzhVar, context, new zzq(uri, providerInfoResolveContentProvider, authority)) - 1;
        if (iZzc == 0) {
            return true;
        }
        if (iZzc == 1) {
            return false;
        }
        if (context.getPackageName().equals(providerInfoResolveContentProvider.packageName)) {
            return zzhVar.zzc;
        }
        if (zzhVar.zzc) {
            return false;
        }
        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 1) != 0 && providerInfoResolveContentProvider.exported) {
            String[] strArr = zzc;
            int length = strArr.length;
            for (int i2 = 0; i2 < 2; i2++) {
                if (strArr[i2].equals(authority)) {
                    return true;
                }
            }
            String[] strArr2 = zzd;
            int length2 = strArr2.length;
            for (int i3 = 0; i3 < 3; i3++) {
                if (strArr2[i3].equals(authority)) {
                    return true;
                }
            }
            String[] strArr3 = zzb;
            for (int i4 = 0; i4 < 6; i4++) {
                String str = strArr3[i4];
                if (str.charAt(str.length() - 1) == '.') {
                    if (providerInfoResolveContentProvider.packageName.startsWith(str)) {
                        return false;
                    }
                } else if (providerInfoResolveContentProvider.packageName.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static File[] zzj(Callable callable) {
        try {
            return (File[]) callable.call();
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new RuntimeException(e3);
        }
    }
}
