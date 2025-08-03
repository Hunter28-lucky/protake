package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
@SafeParcelable.Class(creator = "FaceParcelCreator")
/* loaded from: classes2.dex */
public final class zzf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();

    @SafeParcelable.VersionField(id = 1)
    public final int zza;

    @SafeParcelable.Field(id = 2)
    public final int zzb;

    @SafeParcelable.Field(id = 3)
    public final float zzc;

    @SafeParcelable.Field(id = 4)
    public final float zzd;

    @SafeParcelable.Field(id = 5)
    public final float zze;

    @SafeParcelable.Field(id = 6)
    public final float zzf;

    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 7)
    public final float zzg;

    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 8)
    public final float zzh;

    @SafeParcelable.Field(defaultValue = "3.4028235E38f", id = 14)
    public final float zzi;

    @SafeParcelable.Field(id = 9)
    public final zzn[] zzj;

    @SafeParcelable.Field(id = 10)
    public final float zzk;

    @SafeParcelable.Field(id = 11)
    public final float zzl;

    @SafeParcelable.Field(id = 12)
    public final float zzm;

    @SafeParcelable.Field(id = 13)
    public final zzd[] zzn;

    @SafeParcelable.Field(defaultValue = "-1.0f", id = 15)
    public final float zzo;

    @SafeParcelable.Constructor
    public zzf(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) float f, @SafeParcelable.Param(id = 4) float f2, @SafeParcelable.Param(id = 5) float f3, @SafeParcelable.Param(id = 6) float f4, @SafeParcelable.Param(id = 7) float f5, @SafeParcelable.Param(id = 8) float f6, @SafeParcelable.Param(id = 14) float f7, @SafeParcelable.Param(id = 9) zzn[] zznVarArr, @SafeParcelable.Param(id = 10) float f8, @SafeParcelable.Param(id = 11) float f9, @SafeParcelable.Param(id = 12) float f10, @SafeParcelable.Param(id = 13) zzd[] zzdVarArr, @SafeParcelable.Param(id = 15) float f11) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = f;
        this.zzd = f2;
        this.zze = f3;
        this.zzf = f4;
        this.zzg = f5;
        this.zzh = f6;
        this.zzi = f7;
        this.zzj = zznVarArr;
        this.zzk = f8;
        this.zzl = f9;
        this.zzm = f10;
        this.zzn = zzdVarArr;
        this.zzo = f11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeFloat(parcel, 3, this.zzc);
        SafeParcelWriter.writeFloat(parcel, 4, this.zzd);
        SafeParcelWriter.writeFloat(parcel, 5, this.zze);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzg);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.writeTypedArray(parcel, 9, this.zzj, i, false);
        SafeParcelWriter.writeFloat(parcel, 10, this.zzk);
        SafeParcelWriter.writeFloat(parcel, 11, this.zzl);
        SafeParcelWriter.writeFloat(parcel, 12, this.zzm);
        SafeParcelWriter.writeTypedArray(parcel, 13, this.zzn, i, false);
        SafeParcelWriter.writeFloat(parcel, 14, this.zzi);
        SafeParcelWriter.writeFloat(parcel, 15, this.zzo);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
