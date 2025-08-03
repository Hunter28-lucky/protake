package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzlx;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import java.io.File;
import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class RemoteModelLoader {
    private static final GmsLogger zza = new GmsLogger("RemoteModelLoader", "");

    @GuardedBy("RemoteModelLoader.class")
    private static final Map zzb = new HashMap();
    private final MlKitContext zzc;
    private final RemoteModel zzd;
    private final RemoteModelDownloadManager zze;
    private final RemoteModelFileManager zzf;
    private final RemoteModelLoaderHelper zzg;
    private final zzlm zzh;
    private boolean zzi;

    private RemoteModelLoader(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(mlKitContext, remoteModel, modelValidator, new ModelFileHelper(mlKitContext), remoteModelFileMover);
        this.zzf = remoteModelFileManager;
        this.zzi = true;
        this.zze = RemoteModelDownloadManager.getInstance(mlKitContext, remoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
        this.zzg = remoteModelLoaderHelper;
        this.zzc = mlKitContext;
        this.zzd = remoteModel;
        this.zzh = zzlx.zzb("common");
    }

    @NonNull
    @KeepForSdk
    public static synchronized RemoteModelLoader getInstance(@NonNull MlKitContext mlKitContext, @NonNull RemoteModel remoteModel, @NonNull ModelValidator modelValidator, @NonNull RemoteModelLoaderHelper remoteModelLoaderHelper, @NonNull RemoteModelFileMover remoteModelFileMover) {
        String uniqueModelNameForPersist;
        Map map;
        uniqueModelNameForPersist = remoteModel.getUniqueModelNameForPersist();
        map = zzb;
        if (!map.containsKey(uniqueModelNameForPersist)) {
            map.put(uniqueModelNameForPersist, new RemoteModelLoader(mlKitContext, remoteModel, modelValidator, remoteModelLoaderHelper, remoteModelFileMover));
        }
        return (RemoteModelLoader) map.get(uniqueModelNameForPersist);
    }

    @NonNull
    @WorkerThread
    private final MappedByteBuffer zza(@NonNull String str) throws MlKitException {
        return this.zzg.loadModelAtPath(str);
    }

    private final MappedByteBuffer zzb(File file) throws MlKitException {
        try {
            return zza(file.getAbsolutePath());
        } catch (Exception e2) {
            this.zzf.zzc(file);
            throw new MlKitException("Failed to load newly downloaded model.", 14, e2);
        }
    }

    @NonNull
    @KeepForSdk
    public RemoteModel getRemoteModel() {
        return this.zzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[Catch: all -> 0x0102, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00c1, B:32:0x00d0, B:34:0x00d8, B:37:0x00de, B:38:0x00fc, B:39:0x00fd, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x0063, B:19:0x006d, B:21:0x0079, B:23:0x0081, B:18:0x0068, B:24:0x0093, B:26:0x009b, B:27:0x00b2), top: B:46:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd A[Catch: all -> 0x0102, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:7:0x0020, B:9:0x0028, B:30:0x00c1, B:32:0x00d0, B:34:0x00d8, B:37:0x00de, B:38:0x00fc, B:39:0x00fd, B:10:0x002f, B:12:0x0046, B:15:0x004f, B:17:0x0063, B:19:0x006d, B:21:0x0079, B:23:0x0081, B:18:0x0068, B:24:0x0093, B:26:0x009b, B:27:0x00b2), top: B:46:0x0001, inners: #1 }] */
    @androidx.annotation.Nullable
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.nio.MappedByteBuffer load() throws com.google.mlkit.common.MlKitException {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.mlkit.common.sdkinternal.model.RemoteModelLoader.load():java.nio.MappedByteBuffer");
    }
}
