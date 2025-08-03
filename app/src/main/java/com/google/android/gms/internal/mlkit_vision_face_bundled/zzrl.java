package com.google.android.gms.internal.mlkit_vision_face_bundled;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzrl {
    public static final zzrl zza;
    public static final zzrl zzb;
    public static final zzrl zzc;
    public static final zzrl zzd;
    public static final zzrl zze;
    public static final zzrl zzf;
    public static final zzrl zzg;
    public static final zzrl zzh;
    public static final zzrl zzi;
    public static final zzrl zzj;
    public static final zzrl zzk;
    public static final zzrl zzl;
    public static final zzrl zzm;
    public static final zzrl zzn;
    public static final zzrl zzo;
    public static final zzrl zzp;
    public static final zzrl zzq;
    public static final zzrl zzr;
    private static final /* synthetic */ zzrl[] zzs;
    private final zzrm zzt;

    static {
        zzrl zzrlVar = new zzrl("DOUBLE", 0, zzrm.DOUBLE, 1);
        zza = zzrlVar;
        zzrl zzrlVar2 = new zzrl("FLOAT", 1, zzrm.FLOAT, 5);
        zzb = zzrlVar2;
        zzrm zzrmVar = zzrm.LONG;
        zzrl zzrlVar3 = new zzrl("INT64", 2, zzrmVar, 0);
        zzc = zzrlVar3;
        zzrl zzrlVar4 = new zzrl("UINT64", 3, zzrmVar, 0);
        zzd = zzrlVar4;
        zzrm zzrmVar2 = zzrm.INT;
        zzrl zzrlVar5 = new zzrl("INT32", 4, zzrmVar2, 0);
        zze = zzrlVar5;
        zzrl zzrlVar6 = new zzrl("FIXED64", 5, zzrmVar, 1);
        zzf = zzrlVar6;
        zzrl zzrlVar7 = new zzrl("FIXED32", 6, zzrmVar2, 5);
        zzg = zzrlVar7;
        zzrl zzrlVar8 = new zzrl("BOOL", 7, zzrm.BOOLEAN, 0);
        zzh = zzrlVar8;
        zzrl zzrlVar9 = new zzrl("STRING", 8, zzrm.STRING, 2);
        zzi = zzrlVar9;
        zzrm zzrmVar3 = zzrm.MESSAGE;
        zzrl zzrlVar10 = new zzrl("GROUP", 9, zzrmVar3, 3);
        zzj = zzrlVar10;
        zzrl zzrlVar11 = new zzrl("MESSAGE", 10, zzrmVar3, 2);
        zzk = zzrlVar11;
        zzrl zzrlVar12 = new zzrl("BYTES", 11, zzrm.BYTE_STRING, 2);
        zzl = zzrlVar12;
        zzrl zzrlVar13 = new zzrl("UINT32", 12, zzrmVar2, 0);
        zzm = zzrlVar13;
        zzrl zzrlVar14 = new zzrl("ENUM", 13, zzrm.ENUM, 0);
        zzn = zzrlVar14;
        zzrl zzrlVar15 = new zzrl("SFIXED32", 14, zzrmVar2, 5);
        zzo = zzrlVar15;
        zzrl zzrlVar16 = new zzrl("SFIXED64", 15, zzrmVar, 1);
        zzp = zzrlVar16;
        zzrl zzrlVar17 = new zzrl("SINT32", 16, zzrmVar2, 0);
        zzq = zzrlVar17;
        zzrl zzrlVar18 = new zzrl("SINT64", 17, zzrmVar, 0);
        zzr = zzrlVar18;
        zzs = new zzrl[]{zzrlVar, zzrlVar2, zzrlVar3, zzrlVar4, zzrlVar5, zzrlVar6, zzrlVar7, zzrlVar8, zzrlVar9, zzrlVar10, zzrlVar11, zzrlVar12, zzrlVar13, zzrlVar14, zzrlVar15, zzrlVar16, zzrlVar17, zzrlVar18};
    }

    private zzrl(String str, int i, zzrm zzrmVar, int i2) {
        this.zzt = zzrmVar;
    }

    public static zzrl[] values() {
        return (zzrl[]) zzs.clone();
    }

    public final zzrm zza() {
        return this.zzt;
    }
}
