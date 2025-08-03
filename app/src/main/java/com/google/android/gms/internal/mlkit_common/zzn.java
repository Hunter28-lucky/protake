package com.google.android.gms.internal.mlkit_common;

import android.util.Log;
import com.umeng.analytics.pro.am;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzn {
    private static final Method zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Field zzd;
    private static final Field zze;
    private static final Field zzf;
    private static final Object zzg;
    private static final Throwable zzh;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.reflect.AccessibleObject, java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.reflect.Field] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    static {
        Throwable th;
        Object obj;
        Field field;
        Method declaredMethod;
        Method declaredMethod2;
        Method declaredMethod3;
        ?? field2;
        Field field3;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        try {
            cls = Class.forName("libcore.io.Libcore");
            cls2 = Class.forName("libcore.io.StructStat");
            Class<?> cls4 = Class.forName("libcore.io.OsConstants");
            cls3 = Class.forName("libcore.io.ForwardingOs");
            declaredMethod = cls4.getDeclaredMethod("S_ISLNK", Integer.TYPE);
        } catch (Throwable th2) {
            th = th2;
            obj = null;
            field = null;
            declaredMethod = null;
            declaredMethod2 = null;
        }
        try {
            declaredMethod.setAccessible(true);
            declaredMethod3 = cls3.getDeclaredMethod("lstat", String.class);
            try {
                declaredMethod2 = cls3.getDeclaredMethod("fstat", FileDescriptor.class);
                try {
                    Field declaredField = cls.getDeclaredField(am.x);
                    declaredField.setAccessible(true);
                    obj = declaredField.get(cls);
                } catch (Throwable th3) {
                    th = th3;
                    obj = null;
                    field = null;
                }
                try {
                    field2 = cls2.getField("st_dev");
                    try {
                        field3 = cls2.getField("st_ino");
                        try {
                            field = cls2.getField("st_mode");
                        } catch (Throwable th4) {
                            th = th4;
                            field = null;
                        }
                        try {
                            field2.setAccessible(true);
                            field3.setAccessible(true);
                            field.setAccessible(true);
                        } catch (Throwable th5) {
                            th = th5;
                            try {
                                Log.d("StructStatHelper", "Reflection failed", th);
                                zza = declaredMethod;
                                zzb = declaredMethod3;
                                zzc = declaredMethod2;
                                zzd = field2;
                                zze = field3;
                                zzf = field;
                                zzg = obj;
                                zzh = th;
                            } finally {
                                zza = declaredMethod;
                                zzb = declaredMethod3;
                                zzc = declaredMethod2;
                                zzd = field2;
                                zze = field3;
                                zzf = field;
                                zzg = obj;
                                zzh = null;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        field = null;
                        field3 = null;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    field = null;
                    field2 = field;
                    field3 = field2;
                    Log.d("StructStatHelper", "Reflection failed", th);
                    zza = declaredMethod;
                    zzb = declaredMethod3;
                    zzc = declaredMethod2;
                    zzd = field2;
                    zze = field3;
                    zzf = field;
                    zzg = obj;
                    zzh = th;
                }
            } catch (Throwable th8) {
                th = th8;
                obj = null;
                field = null;
                declaredMethod2 = null;
                field2 = 0;
            }
        } catch (Throwable th9) {
            th = th9;
            obj = null;
            field = null;
            declaredMethod2 = null;
            declaredMethod3 = declaredMethod2;
            field2 = declaredMethod3;
            field3 = field2;
            Log.d("StructStatHelper", "Reflection failed", th);
            zza = declaredMethod;
            zzb = declaredMethod3;
            zzc = declaredMethod2;
            zzd = field2;
            zze = field3;
            zzf = field;
            zzg = obj;
            zzh = th;
        }
    }

    public static zzp zza(final FileDescriptor fileDescriptor) throws IOException {
        return (zzp) zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzl
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzn.zze(zzn.zzc.invoke(zzn.zzg, fileDescriptor));
            }
        });
    }

    public static zzp zzd(final String str) throws IOException {
        return (zzp) zzf(new Callable() { // from class: com.google.android.gms.internal.mlkit_common.zzm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzn.zze(zzn.zzb.invoke(zzn.zzg, str));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzp zze(Object obj) throws Exception {
        return new zzp(((Long) zzd.get(obj)).longValue(), ((Long) zze.get(obj)).longValue(), ((Boolean) zza.invoke(null, Integer.valueOf(((Integer) zzf.get(obj)).intValue()))).booleanValue());
    }

    private static Object zzf(Callable callable) throws IOException {
        try {
            Throwable th = zzh;
            if (th == null) {
                return callable.call();
            }
            throw new IOException(th);
        } catch (Throwable th2) {
            throw new IOException(th2);
        }
    }
}
