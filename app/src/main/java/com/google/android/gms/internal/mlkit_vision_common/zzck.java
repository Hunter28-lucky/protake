package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:vision-common@@17.1.0 */
/* loaded from: classes2.dex */
final class zzck implements ObjectEncoder {
    public static final zzck zza = new zzck();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("maxResults");
        zzad zzadVar = new zzad();
        zzadVar.zza(1);
        zzb = builder.withProperty(zzadVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("modelType");
        zzad zzadVar2 = new zzad();
        zzadVar2.zza(2);
        zzc = builder2.withProperty(zzadVar2.zzb()).build();
    }

    private zzck() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
