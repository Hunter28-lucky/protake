package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
@SafeParcelable.Class(creator = "LandmarkParcelCreator")
/* loaded from: classes2.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();

    @SafeParcelable.VersionField(id = 1)
    public final int zza;

    @SafeParcelable.Field(id = 2)
    public final float zzb;

    @SafeParcelable.Field(id = 3)
    public final float zzc;

    @SafeParcelable.Field(id = 4)
    public final int zzd;

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) float f, @SafeParcelable.Param(id = 3) float f2, @SafeParcelable.Param(id = 4) int i2) {
        this.zza = i;
        this.zzb = f;
        this.zzc = f2;
        this.zzd = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzb);
        SafeParcelWriter.writeFloat(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
