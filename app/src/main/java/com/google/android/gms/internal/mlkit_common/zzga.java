package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzga implements ObjectEncoder {
    public static final zzga zza = new zzga();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("languageOption");
        zzbf zzbfVar = new zzbf();
        zzbfVar.zza(3);
        zzb = builder.withProperty(zzbfVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("isUsingLegacyApi");
        zzbf zzbfVar2 = new zzbf();
        zzbfVar2.zza(4);
        zzc = builder2.withProperty(zzbfVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("sdkVersion");
        zzbf zzbfVar3 = new zzbf();
        zzbfVar3.zza(5);
        zzd = builder3.withProperty(zzbfVar3.zzb()).build();
    }

    private zzga() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        throw null;
    }
}
