package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzcy implements EncoderConfig {
    public static final /* synthetic */ int zza = 0;
    private static final ObjectEncoder zzb = new ObjectEncoder() { // from class: com.google.android.gms.internal.mlkit_vision_face.zzcx
        @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
        public final void encode(Object obj, ObjectEncoderContext objectEncoderContext) {
            int i = zzcy.zza;
            String strValueOf = String.valueOf(obj.getClass().getCanonicalName());
            throw new EncodingException(strValueOf.length() != 0 ? "Couldn't find encoder for type ".concat(strValueOf) : new String("Couldn't find encoder for type "));
        }
    };
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final ObjectEncoder zze = zzb;

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public final /* bridge */ /* synthetic */ EncoderConfig registerEncoder(@NonNull Class cls, @NonNull ObjectEncoder objectEncoder) {
        this.zzc.put(cls, objectEncoder);
        this.zzd.remove(cls);
        return this;
    }

    public final zzcz zza() {
        return new zzcz(new HashMap(this.zzc), new HashMap(this.zzd), this.zze);
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    @NonNull
    public final /* bridge */ /* synthetic */ EncoderConfig registerEncoder(@NonNull Class cls, @NonNull ValueEncoder valueEncoder) {
        this.zzd.put(cls, valueEncoder);
        this.zzc.remove(cls);
        return this;
    }
}
