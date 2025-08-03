package com.google.android.gms.internal.mlkit_vision_face;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-mlkit-face-detection@@17.0.1 */
/* loaded from: classes2.dex */
public final class zzcj {
    public static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    public static boolean zzb(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzcb) {
            collection = ((zzcb) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzc(set, collection.iterator());
        }
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean zzc(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }
}
