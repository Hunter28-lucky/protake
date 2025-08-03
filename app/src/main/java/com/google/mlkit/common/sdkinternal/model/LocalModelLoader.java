package com.google.mlkit.common.sdkinternal.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_common.zzi;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.model.LocalModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* compiled from: com.google.mlkit:common@@18.1.0 */
@KeepForSdk
/* loaded from: classes2.dex */
public class LocalModelLoader {
    private MappedByteBuffer zza;
    private final Context zzb;
    private final LocalModel zzc;

    @KeepForSdk
    public LocalModelLoader(@NonNull Context context, @NonNull LocalModel localModel) {
        this.zzb = context;
        this.zzc = localModel;
    }

    @NonNull
    @KeepForSdk
    public LocalModel getLocalModel() {
        return this.zzc;
    }

    @NonNull
    @KeepForSdk
    @WorkerThread
    public MappedByteBuffer load() throws MlKitException, IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        FileChannel channel;
        Preconditions.checkNotNull(this.zzb, "Context can not be null");
        Preconditions.checkNotNull(this.zzc, "Model source can not be null");
        MappedByteBuffer mappedByteBuffer = this.zza;
        if (mappedByteBuffer != null) {
            return mappedByteBuffer;
        }
        String absoluteFilePath = this.zzc.getAbsoluteFilePath();
        String assetFilePath = this.zzc.getAssetFilePath();
        Uri uri = this.zzc.getUri();
        if (absoluteFilePath != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(absoluteFilePath, "r");
                try {
                    FileChannel channel2 = randomAccessFile.getChannel();
                    try {
                        this.zza = channel2.map(FileChannel.MapMode.READ_ONLY, 0L, channel2.size());
                        channel2.close();
                        randomAccessFile.close();
                        return this.zza;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e2) {
                String strValueOf = String.valueOf(this.zzc.getAbsoluteFilePath());
                throw new MlKitException(strValueOf.length() != 0 ? "Can not open the local file: ".concat(strValueOf) : new String("Can not open the local file: "), 14, e2);
            }
        }
        if (assetFilePath != null) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenFd = this.zzb.getAssets().openFd(assetFilePath);
                try {
                    channel = new FileInputStream(assetFileDescriptorOpenFd.getFileDescriptor()).getChannel();
                    try {
                        this.zza = channel.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorOpenFd.getStartOffset(), assetFileDescriptorOpenFd.getDeclaredLength());
                        channel.close();
                        assetFileDescriptorOpenFd.close();
                        return this.zza;
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e3) {
                StringBuilder sb = new StringBuilder(assetFilePath.length() + 186);
                sb.append("Can not load the file from asset: ");
                sb.append(assetFilePath);
                sb.append(". Please double check your asset file name and ensure it's not compressed. See documentation for details how to use aaptOptions to skip file compression");
                throw new MlKitException(sb.toString(), 14, e3);
            }
        }
        if (uri == null) {
            throw new MlKitException("Can not load the model. One of filePath, assetFilePath or URI must be set for the model.", 14);
        }
        try {
            AssetFileDescriptor assetFileDescriptorZza = zzi.zza(this.zzb, uri, "r");
            try {
                channel = assetFileDescriptorZza.createInputStream().getChannel();
                try {
                    this.zza = channel.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptorZza.getStartOffset(), assetFileDescriptorZza.getLength());
                    channel.close();
                    assetFileDescriptorZza.close();
                    return this.zza;
                } finally {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (Throwable th) {
                            Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th);
                        }
                    }
                }
            } finally {
            }
        } catch (IOException e4) {
            throw new MlKitException("Can not load the file from URI: ".concat(uri.toString()), 14, e4);
        }
    }
}
