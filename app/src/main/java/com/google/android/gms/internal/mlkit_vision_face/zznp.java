package com.google.android.gms.internal.mlkit_vision_face;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
@SafeParcelable.Class(creator = "ContourParcelCreator")
/* loaded from: classes2.dex */
public final class zznp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznp> CREATOR = new zznq();

    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getPointList", id = 2)
    private final List zzb;

    @SafeParcelable.Constructor
    public zznp(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) List list) {
        this.zza = i;
        this.zzb = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final int zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzb;
    }
}
