package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzoh;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzon;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public abstract class zzon<MessageType extends zzon<MessageType, BuilderType>, BuilderType extends zzoh<MessageType, BuilderType>> extends zzmt<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    public zzqw zzc = zzqw.zzc();
    public int zzd = -1;

    public static zzos zzA() {
        return zzqc.zze();
    }

    public static Object zzB(Method method, Object obj, Object... objArr) {
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

    public static Object zzC(zzps zzpsVar, String str, Object[] objArr) {
        return new zzqd(zzpsVar, str, objArr);
    }

    public static void zzD(Class cls, zzon zzonVar) {
        zzb.put(cls, zzonVar);
    }

    public static final boolean zzE(zzon zzonVar, boolean z) {
        byte bByteValue = ((Byte) zzonVar.zzf(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzj = zzqb.zza().zzb(zzonVar.getClass()).zzj(zzonVar);
        if (z) {
            zzonVar.zzf(2, true != zZzj ? null : zzonVar, null);
        }
        return zZzj;
    }

    private static zzon zzc(zzon zzonVar, byte[] bArr, int i, int i2, zzny zznyVar) throws zzov {
        zzon zzonVar2 = (zzon) zzonVar.zzf(4, null, null);
        try {
            zzqe zzqeVarZzb = zzqb.zza().zzb(zzonVar2.getClass());
            zzqeVarZzb.zzh(zzonVar2, bArr, 0, i2, new zzmx(zznyVar));
            zzqeVarZzb.zzf(zzonVar2);
            if (zzonVar2.zza == 0) {
                return zzonVar2;
            }
            throw new RuntimeException();
        } catch (zzov e2) {
            e2.zzf(zzonVar2);
            throw e2;
        } catch (zzqu e3) {
            zzov zzovVarZza = e3.zza();
            zzovVarZza.zzf(zzonVar2);
            throw zzovVarZza;
        } catch (IOException e4) {
            if (e4.getCause() instanceof zzov) {
                throw ((zzov) e4.getCause());
            }
            zzov zzovVar = new zzov(e4);
            zzovVar.zzf(zzonVar2);
            throw zzovVar;
        } catch (IndexOutOfBoundsException unused) {
            zzov zzovVarZzg = zzov.zzg();
            zzovVarZzg.zzf(zzonVar2);
            throw zzovVarZzg;
        }
    }

    public static zzol zzx(zzps zzpsVar, zzps zzpsVar2, zzoq zzoqVar, int i, zzrl zzrlVar, boolean z, Class cls) {
        return new zzol(zzpsVar, Collections.emptyList(), zzpsVar2, new zzok(null, 202056002, zzrlVar, true, false), cls);
    }

    public static zzon zzy(Class cls) throws ClassNotFoundException {
        Map map = zzb;
        zzon zzonVar = (zzon) map.get(cls);
        if (zzonVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzonVar = (zzon) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzonVar == null) {
            zzonVar = (zzon) ((zzon) zzrf.zze(cls)).zzf(6, null, null);
            if (zzonVar == null) {
                throw new IllegalStateException();
            }
            map.put(cls, zzonVar);
        }
        return zzonVar;
    }

    public static zzon zzz(zzon zzonVar, byte[] bArr, zzny zznyVar) throws zzov {
        zzon zzonVarZzc = zzc(zzonVar, bArr, 0, bArr.length, zznyVar);
        if (zzonVarZzc == null || zzonVarZzc.zzv()) {
            return zzonVarZzc;
        }
        zzov zzovVarZza = new zzqu(zzonVarZzc).zza();
        zzovVarZza.zzf(zzonVarZzc);
        throw zzovVarZza;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzqb.zza().zzb(getClass()).zzi(this, (zzon) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzb = zzqb.zza().zzb(getClass()).zzb(this);
        this.zza = iZzb;
        return iZzb;
    }

    public final String toString() {
        return zzpu.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzps
    public final /* synthetic */ zzpr zzH() {
        return (zzoh) zzf(5, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzps
    public final /* synthetic */ zzpr zzI() {
        zzoh zzohVar = (zzoh) zzf(5, null, null);
        zzohVar.zzp(this);
        return zzohVar;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzps
    public final void zzJ(zznt zzntVar) throws IOException {
        zzqb.zza().zzb(getClass()).zzm(this, zznu.zza(zzntVar));
    }

    public abstract Object zzf(int i, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmt
    public final int zzp() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmt
    public final void zzr(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpt
    public final /* synthetic */ zzps zzt() {
        return (zzon) zzf(6, null, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzps
    public final int zzu() {
        int i = this.zzd;
        if (i != -1) {
            return i;
        }
        int iZza = zzqb.zza().zzb(getClass()).zza(this);
        this.zzd = iZza;
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpt
    public final boolean zzv() {
        return zzE(this, true);
    }

    public final zzoh zzw() {
        return (zzoh) zzf(5, null, null);
    }
}
