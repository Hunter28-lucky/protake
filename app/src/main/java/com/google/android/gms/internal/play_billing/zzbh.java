package com.google.android.gms.internal.play_billing;

import androidx.exifinterface.media.ExifInterface;
import java.util.Comparator;

/* compiled from: com.android.billingclient:billing@@7.0.0 */
/* loaded from: classes2.dex */
final class zzbh implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzbq zzbqVar = (zzbq) obj;
        zzbq zzbqVar2 = (zzbq) obj2;
        zzbg zzbgVar = new zzbg(zzbqVar);
        zzbg zzbgVar2 = new zzbg(zzbqVar2);
        while (zzbgVar.hasNext() && zzbgVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzbgVar.zza() & ExifInterface.MARKER).compareTo(Integer.valueOf(zzbgVar2.zza() & ExifInterface.MARKER));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzbqVar.zzd()).compareTo(Integer.valueOf(zzbqVar2.zzd()));
    }
}
