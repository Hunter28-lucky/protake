package com.google.android.gms.internal.mlkit_vision_face_bundled;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzoz extends zzmv implements RandomAccess, zzpa {
    public static final zzpa zza;
    private static final zzoz zzb;
    private final List zzc;

    static {
        zzoz zzozVar = new zzoz(10);
        zzb = zzozVar;
        zzozVar.zzb();
        zza = zzozVar;
    }

    public zzoz() {
        this(10);
    }

    private static String zzi(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zznl ? ((zznl) obj).zzn(zzot.zzb) : zzot.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i, Object obj) {
        zza();
        this.zzc.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmv, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        zza();
        if (collection instanceof zzpa) {
            collection = ((zzpa) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmv, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i) {
        zza();
        Object objRemove = this.zzc.remove(i);
        ((AbstractList) this).modCount++;
        return zzi(objRemove);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i, Object obj) {
        zza();
        return zzi(this.zzc.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzos
    public final /* bridge */ /* synthetic */ zzos zzd(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzc);
        return new zzoz(arrayList);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpa
    public final zzpa zze() {
        return zzc() ? new zzra(this) : this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpa
    public final Object zzf(int i) {
        return this.zzc.get(i);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i) {
        Object obj = this.zzc.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zznl) {
            zznl zznlVar = (zznl) obj;
            String strZzn = zznlVar.zzn(zzot.zzb);
            if (zznlVar.zzi()) {
                this.zzc.set(i, strZzn);
            }
            return strZzn;
        }
        byte[] bArr = (byte[]) obj;
        String strZzh = zzot.zzh(bArr);
        if (zzot.zzj(bArr)) {
            this.zzc.set(i, strZzh);
        }
        return strZzh;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpa
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzoz(int i) {
        this.zzc = new ArrayList(i);
    }

    private zzoz(ArrayList arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzmv, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
