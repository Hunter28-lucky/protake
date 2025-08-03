package com.google.mlkit.common.internal.model;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzhl;
import com.google.android.gms.internal.mlkit_common.zzhv;
import com.google.android.gms.internal.mlkit_common.zzif;
import com.google.android.gms.internal.mlkit_common.zzig;
import com.google.android.gms.internal.mlkit_common.zzio;
import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzlp;
import com.google.android.gms.internal.mlkit_common.zzlx;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.CustomRemoteModel;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.MLTaskExecutor;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.ModelType;
import com.google.mlkit.common.sdkinternal.model.ModelFileHelper;
import com.google.mlkit.common.sdkinternal.model.ModelInfoRetrieverInterop;
import com.google.mlkit.common.sdkinternal.model.RemoteModelDownloadManager;
import com.google.mlkit.common.sdkinternal.model.RemoteModelFileManager;
import com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzg implements RemoteModelManagerInterface {
    private final MlKitContext zza;
    private final zzlm zzb;

    public zzg(MlKitContext mlKitContext) {
        zzlm zzlmVarZzb = zzlx.zzb("common");
        this.zza = mlKitContext;
        this.zzb = zzlmVarZzb;
    }

    private final RemoteModelDownloadManager zze(CustomRemoteModel customRemoteModel) {
        RemoteModelFileManager remoteModelFileManager = new RemoteModelFileManager(this.zza, customRemoteModel, null, new ModelFileHelper(this.zza), new zza(this.zza, customRemoteModel.getUniqueModelNameForPersist()));
        MlKitContext mlKitContext = this.zza;
        return RemoteModelDownloadManager.getInstance(mlKitContext, customRemoteModel, new ModelFileHelper(mlKitContext), remoteModelFileManager, (ModelInfoRetrieverInterop) mlKitContext.get(ModelInfoRetrieverInterop.class));
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task deleteDownloadedModel(RemoteModel remoteModel) {
        final CustomRemoteModel customRemoteModel = (CustomRemoteModel) remoteModel;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        MLTaskExecutor.workerThreadExecutor().execute(new Runnable() { // from class: com.google.mlkit.common.internal.model.zze
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzb(customRemoteModel, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.mlkit.common.internal.model.zzb
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzc(task);
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task download(RemoteModel remoteModel, DownloadConditions downloadConditions) {
        final RemoteModelDownloadManager remoteModelDownloadManagerZze = zze((CustomRemoteModel) remoteModel);
        remoteModelDownloadManagerZze.setDownloadConditions(downloadConditions);
        return Tasks.forResult(null).onSuccessTask(MLTaskExecutor.workerThreadExecutor(), new SuccessContinuation() { // from class: com.google.mlkit.common.internal.model.zzd
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return remoteModelDownloadManagerZze.ensureModelDownloaded();
            }
        });
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final Task<Set<CustomRemoteModel>> getDownloadedModels() {
        return Tasks.forException(new MlKitException("Custom Remote model does not support listing downloaded models", 12));
    }

    @Override // com.google.mlkit.common.sdkinternal.model.RemoteModelManagerInterface
    public final /* bridge */ /* synthetic */ Task isModelDownloaded(RemoteModel remoteModel) {
        final CustomRemoteModel customRemoteModel = (CustomRemoteModel) remoteModel;
        return MLTaskExecutor.getInstance().scheduleCallable(new Callable() { // from class: com.google.mlkit.common.internal.model.zzf
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zza(customRemoteModel);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.mlkit.common.internal.model.zzc
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.zza.zzd(task);
            }
        });
    }

    public final /* synthetic */ Boolean zza(CustomRemoteModel customRemoteModel) throws Exception {
        return Boolean.valueOf(zze(customRemoteModel).isModelDownloadedAndValid());
    }

    public final /* synthetic */ void zzb(CustomRemoteModel customRemoteModel, TaskCompletionSource taskCompletionSource) {
        try {
            new ModelFileHelper(this.zza).deleteAllModels(ModelType.CUSTOM, (String) Preconditions.checkNotNull(customRemoteModel.getModelName()));
            taskCompletionSource.setResult(null);
        } catch (RuntimeException e2) {
            taskCompletionSource.setException(new MlKitException("Internal error has occurred when executing ML Kit tasks", 13, e2));
        }
    }

    public final /* synthetic */ void zzc(Task task) {
        boolean zIsSuccessful = task.isSuccessful();
        zzlm zzlmVar = this.zzb;
        zzig zzigVar = new zzig();
        zzhl zzhlVar = new zzhl();
        zzhlVar.zzb(zzio.CUSTOM);
        zzhlVar.zza(Boolean.valueOf(zIsSuccessful));
        zzigVar.zze(zzhlVar.zzc());
        zzlmVar.zzd(zzlp.zzf(zzigVar), zzif.REMOTE_MODEL_DELETE_ON_DEVICE);
    }

    public final /* synthetic */ void zzd(Task task) {
        boolean zBooleanValue = ((Boolean) task.getResult()).booleanValue();
        zzlm zzlmVar = this.zzb;
        zzig zzigVar = new zzig();
        zzhv zzhvVar = new zzhv();
        zzhvVar.zzb(zzio.CUSTOM);
        zzhvVar.zza(Boolean.valueOf(zBooleanValue));
        zzigVar.zzg(zzhvVar.zzc());
        zzlmVar.zzd(zzlp.zzf(zzigVar), zzif.REMOTE_MODEL_IS_DOWNLOADED);
    }
}
