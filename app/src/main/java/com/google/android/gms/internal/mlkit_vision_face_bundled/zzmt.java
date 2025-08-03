package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzms;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmt;
import java.io.IOException;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public abstract class zzmt<MessageType extends zzmt<MessageType, BuilderType>, BuilderType extends zzms<MessageType, BuilderType>> implements zzps {
    public int zza = 0;

    public int zzp() {
        throw null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzps
    public final zznl zzq() {
        try {
            int iZzu = zzu();
            zznl zznlVar = zznl.zzb;
            byte[] bArr = new byte[iZzu];
            zznt zzntVarZzF = zznt.zzF(bArr);
            zzJ(zzntVarZzF);
            zzntVarZzF.zzG();
            return new zzni(bArr);
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public void zzr(int i) {
        throw null;
    }

    public final byte[] zzs() {
        try {
            byte[] bArr = new byte[zzu()];
            zznt zzntVarZzF = zznt.zzF(bArr);
            zzJ(zzntVarZzF);
            zzntVarZzF.zzG();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }
}
