package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
@SafeParcelable.Class(creator = "FaceDetectorOptionsParcelCreator")
/* loaded from: classes2.dex */
public final class zznr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznr> CREATOR = new zzns();

    @SafeParcelable.Field(getter = "getPerformanceMode", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getLandmarkMode", id = 2)
    private final int zzb;

    @SafeParcelable.Field(getter = "getClassificationMode", id = 3)
    private final int zzc;

    @SafeParcelable.Field(getter = "getContourMode", id = 4)
    private final int zzd;

    @SafeParcelable.Field(getter = "isTrackingEnabled", id = 5)
    private final boolean zze;

    @SafeParcelable.Field(getter = "getProportionalMinFaceSize", id = 6)
    private final float zzf;

    @SafeParcelable.Constructor
    public zznr(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) float f) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = z;
        this.zzf = f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
