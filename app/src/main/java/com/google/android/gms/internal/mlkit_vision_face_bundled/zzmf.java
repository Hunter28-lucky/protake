package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
@SafeParcelable.Class(creator = "ContourParcelCreator")
/* loaded from: classes2.dex */
public final class zzmf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmf> CREATOR = new zzmg();

    @SafeParcelable.Field(getter = "getType", id = 1)
    private final int zza;

    @SafeParcelable.Field(getter = "getPointList", id = 2)
    private final List zzb;

    @SafeParcelable.Constructor
    public zzmf(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) List list) {
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
}
