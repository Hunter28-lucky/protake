package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzcn;
import com.google.android.gms.internal.play_billing.zzcs;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
public abstract class zzcs<MessageType extends zzcs<MessageType, BuilderType>, BuilderType extends zzcn<MessageType, BuilderType>> extends zzay<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    public zzfg zzc = zzfg.zzc();

    public static zzcs zzj(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzcs zzcsVar = (zzcs) map.get(cls);
        if (zzcsVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzcsVar = (zzcs) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzcsVar == null) {
            zzcsVar = (zzcs) ((zzcs) zzfp.zze(cls)).zzx(6, null, null);
            if (zzcsVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzcsVar);
        }
        return zzcsVar;
    }

    public static zzcs zzm(zzcs zzcsVar, byte[] bArr, zzcd zzcdVar) throws zzdc {
        zzcs zzcsVarZzz = zzz(zzcsVar, bArr, 0, bArr.length, zzcdVar);
        if (zzcsVarZzz == null || zzcsVarZzz.zzk()) {
            return zzcsVarZzz;
        }
        zzdc zzdcVarZza = new zzfe(zzcsVarZzz).zza();
        zzdcVarZza.zzf(zzcsVarZzz);
        throw zzdcVarZza;
    }

    public static zzcx zzn() {
        return zzct.zzf();
    }

    public static zzcz zzo() {
        return zzem.zze();
    }

    public static Object zzp(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object zzq(zzec zzecVar, String str, Object[] objArr) {
        return new zzen(zzecVar, str, objArr);
    }

    public static void zzt(Class cls, zzcs zzcsVar) {
        zzcsVar.zzs();
        zzb.put(cls, zzcsVar);
    }

    public static final boolean zzv(zzcs zzcsVar, boolean z) {
        byte bByteValue = ((Byte) zzcsVar.zzx(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzel.zza().zzb(zzcsVar.getClass()).zzk(zzcsVar);
        if (z) {
            zzcsVar.zzx(2, true != zZzk ? null : zzcsVar, null);
        }
        return zZzk;
    }

    private final int zzy(zzeo zzeoVar) {
        return zzel.zza().zzb(getClass()).zza(this);
    }

    private static zzcs zzz(zzcs zzcsVar, byte[] bArr, int i, int i2, zzcd zzcdVar) throws zzdc {
        if (i2 == 0) {
            return zzcsVar;
        }
        zzcs zzcsVarZzl = zzcsVar.zzl();
        try {
            zzeo zzeoVarZzb = zzel.zza().zzb(zzcsVarZzl.getClass());
            zzeoVarZzb.zzh(zzcsVarZzl, bArr, 0, i2, new zzbc(zzcdVar));
            zzeoVarZzb.zzf(zzcsVarZzl);
            return zzcsVarZzl;
        } catch (zzdc e2) {
            e2.zzf(zzcsVarZzl);
            throw e2;
        } catch (zzfe e3) {
            zzdc zzdcVarZza = e3.zza();
            zzdcVarZza.zzf(zzcsVarZzl);
            throw zzdcVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzdc) {
                throw ((zzdc) e4.getCause());
            }
            zzdc zzdcVar = new zzdc(e4);
            zzdcVar.zzf(zzcsVarZzl);
            throw zzdcVar;
        } catch (IndexOutOfBoundsException unused) {
            zzdc zzdcVarZzg = zzdc.zzg();
            zzdcVarZzg.zzf(zzcsVarZzl);
            throw zzdcVarZzg;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzel.zza().zzb(getClass()).zzj(this, (zzcs) obj);
    }

    public final int hashCode() {
        if (zzw()) {
            return zzd();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzd = zzd();
        this.zza = iZzd;
        return iZzd;
    }

    public final String toString() {
        return zzee.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final /* synthetic */ zzeb zzE() {
        return (zzcn) zzx(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final /* synthetic */ zzeb zzF() {
        zzcn zzcnVar = (zzcn) zzx(5, null, null);
        zzcnVar.zzc(this);
        return zzcnVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzay
    public final int zza(zzeo zzeoVar) {
        if (zzw()) {
            int iZza = zzeoVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iZza);
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzeoVar.zza(this);
        if (iZza2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
            return iZza2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZza2);
    }

    final int zzd() {
        return zzel.zza().zzb(getClass()).zzb(this);
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final void zze(zzby zzbyVar) throws IOException {
        zzel.zza().zzb(getClass()).zzi(this, zzbz.zza(zzbyVar));
    }

    @Override // com.google.android.gms.internal.play_billing.zzec
    public final int zzf() {
        int iZzy;
        if (zzw()) {
            iZzy = zzy(null);
            if (iZzy < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iZzy);
            }
        } else {
            iZzy = this.zzd & Integer.MAX_VALUE;
            if (iZzy == Integer.MAX_VALUE) {
                iZzy = zzy(null);
                if (iZzy < 0) {
                    throw new IllegalStateException("serialized size must be non-negative, was " + iZzy);
                }
                this.zzd = (this.zzd & Integer.MIN_VALUE) | iZzy;
            }
        }
        return iZzy;
    }

    public final zzcn zzg() {
        return (zzcn) zzx(5, null, null);
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final /* synthetic */ zzec zzh() {
        return (zzcs) zzx(6, null, null);
    }

    public final zzcn zzi() {
        zzcn zzcnVar = (zzcn) zzx(5, null, null);
        zzcnVar.zzc(this);
        return zzcnVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzed
    public final boolean zzk() {
        return zzv(this, true);
    }

    public final zzcs zzl() {
        return (zzcs) zzx(4, null, null);
    }

    public final void zzr() {
        zzel.zza().zzb(getClass()).zzf(this);
        zzs();
    }

    public final void zzs() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzu(int i) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzw() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public abstract Object zzx(int i, Object obj, Object obj2);
}
