package com.google.android.gms.internal.mlkit_common;

import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzp {
    public final long zza;
    public final long zzb;
    public final boolean zzc;

    private zzp(long j, long j2, boolean z) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = z;
    }

    public static zzp zza(final FileDescriptor fileDescriptor) throws IOException {
        StructStat structStat = (StructStat) zzc(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzj
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Os.fstat(fileDescriptor);
            }
        });
        return new zzp(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    public static zzp zzb(final String str) throws IOException {
        StructStat structStat = (StructStat) zzc(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzk
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Os.lstat(str);
            }
        });
        return new zzp(structStat.st_dev, structStat.st_ino, OsConstants.S_ISLNK(structStat.st_mode));
    }

    private static Object zzc(Callable callable) throws IOException {
        try {
            return callable.call();
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }
}
