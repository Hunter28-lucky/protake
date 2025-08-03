package com.google.android.gms.internal.mlkit_common;

import androidx.core.app.NotificationCompat;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.1.0 */
/* loaded from: classes2.dex */
final class zzev implements ObjectEncoder {
    public static final zzev zza = new zzev();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("name");
        zzbf zzbfVar = new zzbf();
        zzbfVar.zza(1);
        zzb = builder.withProperty(zzbfVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(Constants.VERSION);
        zzbf zzbfVar2 = new zzbf();
        zzbfVar2.zza(2);
        zzc = builder2.withProperty(zzbfVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("source");
        zzbf zzbfVar3 = new zzbf();
        zzbfVar3.zza(3);
        zzd = builder3.withProperty(zzbfVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        zzbf zzbfVar4 = new zzbf();
        zzbfVar4.zza(4);
        zze = builder4.withProperty(zzbfVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("hash");
        zzbf zzbfVar5 = new zzbf();
        zzbfVar5.zza(5);
        zzf = builder5.withProperty(zzbfVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("modelType");
        zzbf zzbfVar6 = new zzbf();
        zzbfVar6.zza(6);
        zzg = builder6.withProperty(zzbfVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("size");
        zzbf zzbfVar7 = new zzbf();
        zzbfVar7.zza(7);
        zzh = builder7.withProperty(zzbfVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("hasLabelMap");
        zzbf zzbfVar8 = new zzbf();
        zzbfVar8.zza(8);
        zzi = builder8.withProperty(zzbfVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("isManifestModel");
        zzbf zzbfVar9 = new zzbf();
        zzbfVar9.zza(9);
        zzj = builder9.withProperty(zzbfVar9.zzb()).build();
    }

    private zzev() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder, com.google.firebase.encoders.Encoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, ObjectEncoderContext objectEncoderContext) throws IOException {
        zzir zzirVar = (zzir) obj;
        ObjectEncoderContext objectEncoderContext2 = objectEncoderContext;
        objectEncoderContext2.add(zzb, zzirVar.zzd());
        objectEncoderContext2.add(zzc, (Object) null);
        objectEncoderContext2.add(zzd, zzirVar.zzb());
        objectEncoderContext2.add(zze, (Object) null);
        objectEncoderContext2.add(zzf, zzirVar.zzc());
        objectEncoderContext2.add(zzg, zzirVar.zza());
        objectEncoderContext2.add(zzh, (Object) null);
        objectEncoderContext2.add(zzi, (Object) null);
        objectEncoderContext2.add(zzj, (Object) null);
    }
}
