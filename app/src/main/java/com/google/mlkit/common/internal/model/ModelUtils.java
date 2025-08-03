package com.google.mlkit.common.internal.model;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzad;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
@WorkerThread
/* loaded from: classes2.dex */
public class ModelUtils {
    private static final GmsLogger zza = new GmsLogger("ModelUtils", "");

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public static abstract class AutoMLManifest {
        @NonNull
        @KeepForSdk
        public abstract String getLabelsFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelFile();

        @NonNull
        @KeepForSdk
        public abstract String getModelType();
    }

    /* compiled from: com.google.mlkit:common@@18.1.0 */
    @KeepForSdk
    public static abstract class ModelLoggingInfo {
        public static ModelLoggingInfo zza(long j, @Nullable String str, boolean z) {
            return new AutoValue_ModelUtils_ModelLoggingInfo(j, zzad.zzb(str), z);
        }

        @NonNull
        @KeepForSdk
        public abstract String getHash();

        @KeepForSdk
        public abstract long getSize();

        @KeepForSdk
        public abstract boolean isManifestModel();
    }

    private ModelUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.ModelLoggingInfo getModelLoggingInfo(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.NonNull com.google.mlkit.common.model.LocalModel r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.getModelLoggingInfo(android.content.Context, com.google.mlkit.common.model.LocalModel):com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo");
    }

    @Nullable
    @KeepForSdk
    public static String getSHA256(@NonNull File file) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                String strZzc = zzc(fileInputStream);
                fileInputStream.close();
                return strZzc;
            } finally {
            }
        } catch (IOException e2) {
            zza.e("ModelUtils", "Failed to create FileInputStream for model: ".concat(e2.toString()));
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (new java.io.File(r5).exists() == false) goto L14;
     */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.mlkit.common.internal.model.ModelUtils.AutoMLManifest parseManifestFile(@androidx.annotation.NonNull java.lang.String r5, boolean r6, @androidx.annotation.NonNull android.content.Context r7) throws java.lang.IllegalAccessException, java.io.IOException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            com.google.android.gms.common.internal.GmsLogger r0 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r2 = r1.length()
            java.lang.String r3 = "Manifest file path: "
            if (r2 == 0) goto L13
            java.lang.String r1 = r3.concat(r1)
            goto L18
        L13:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L18:
            java.lang.String r2 = "ModelUtils"
            r0.d(r2, r1)
            r1 = 0
            if (r6 == 0) goto L2e
            android.content.res.AssetManager r3 = r7.getAssets()     // Catch: java.io.IOException -> L39
            java.io.InputStream r3 = r3.open(r5)     // Catch: java.io.IOException -> L39
            if (r3 == 0) goto L41
            r3.close()     // Catch: java.io.IOException -> L39
            goto L41
        L2e:
            java.io.File r3 = new java.io.File
            r3.<init>(r5)
            boolean r3 = r3.exists()
            if (r3 != 0) goto L41
        L39:
            com.google.android.gms.common.internal.GmsLogger r5 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r6 = "Manifest file does not exist."
            r5.e(r2, r6)
            return r1
        L41:
            boolean r3 = r5.isEmpty()     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r4 = 0
            if (r3 == 0) goto L4b
            byte[] r5 = new byte[r4]     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            goto L6e
        L4b:
            if (r6 == 0) goto L56
            android.content.res.AssetManager r6 = r7.getAssets()     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.io.InputStream r5 = r6.open(r5)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            goto L61
        L56:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.io.File r7 = new java.io.File     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r7.<init>(r5)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r6.<init>(r7)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r5 = r6
        L61:
            int r6 = r5.available()     // Catch: java.lang.Throwable -> La8
            byte[] r7 = new byte[r6]     // Catch: java.lang.Throwable -> La8
            r5.read(r7, r4, r6)     // Catch: java.lang.Throwable -> La8
            r5.close()     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r5 = r7
        L6e:
            java.lang.String r6 = new java.lang.String     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.lang.String r5 = "Json string from the manifest file: "
            int r7 = r6.length()     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            if (r7 == 0) goto L82
            java.lang.String r5 = r5.concat(r6)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            goto L88
        L82:
            java.lang.String r7 = new java.lang.String     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r7.<init>(r5)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r5 = r7
        L88:
            r0.d(r2, r5)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r5.<init>(r6)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.lang.String r6 = "modelType"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.lang.String r7 = "modelFile"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            java.lang.String r0 = "labelsFile"
            java.lang.String r5 = r5.getString(r0)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest r0 = new com.google.mlkit.common.internal.model.AutoValue_ModelUtils_AutoMLManifest     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            r0.<init>(r6, r7, r5)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
            return r0
        La8:
            r6 = move-exception
            if (r5 == 0) goto Lb3
            r5.close()     // Catch: java.lang.Throwable -> Laf
            goto Lb3
        Laf:
            r5 = move-exception
            com.google.mlkit.common.internal.model.zzh.zza(r6, r5)     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
        Lb3:
            throw r6     // Catch: java.io.IOException -> Lb4 org.json.JSONException -> Lb6
        Lb4:
            r5 = move-exception
            goto Lb7
        Lb6:
            r5 = move-exception
        Lb7:
            com.google.android.gms.common.internal.GmsLogger r6 = com.google.mlkit.common.internal.model.ModelUtils.zza
            java.lang.String r7 = "Error parsing the manifest file."
            r6.e(r2, r7, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.internal.model.ModelUtils.parseManifestFile(java.lang.String, boolean, android.content.Context):com.google.mlkit.common.internal.model.ModelUtils$AutoMLManifest");
    }

    public static boolean zza(@NonNull File file, @NonNull String str) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        String sha256 = getSHA256(file);
        GmsLogger gmsLogger = zza;
        String strValueOf = String.valueOf(sha256);
        gmsLogger.d("ModelUtils", strValueOf.length() != 0 ? "Calculated hash value is: ".concat(strValueOf) : new String("Calculated hash value is: "));
        return str.equals(sha256);
    }

    @Nullable
    private static String zzb(Context context, String str, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        AutoMLManifest manifestFile = parseManifestFile(str, z, context);
        if (manifestFile != null) {
            return new File(new File(str).getParent(), manifestFile.getModelFile()).toString();
        }
        zza.e("ModelUtils", "Failed to parse manifest file.");
        return null;
    }

    @Nullable
    private static String zzc(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        int i;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bArr = new byte[1048576];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, i2);
            }
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & ExifInterface.MARKER);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (IOException unused) {
            zza.e("ModelUtils", "Failed to read model file");
            return null;
        } catch (NoSuchAlgorithmException unused2) {
            zza.e("ModelUtils", "Do not have SHA-256 algorithm");
            return null;
        }
    }
}
