package com.google.android.gms.internal.mlkit_vision_face_bundled;

import com.google.android.gms.internal.mlkit_vision_face_bundled.zzms;
import com.google.android.gms.internal.mlkit_vision_face_bundled.zzmt;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public abstract class zzms<MessageType extends zzmt<MessageType, BuilderType>, BuilderType extends zzms<MessageType, BuilderType>> implements zzpr {
    @Override // 
    /* renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public abstract zzms clone();

    public abstract zzms zzm(zzmt zzmtVar);

    @Override // com.google.android.gms.internal.mlkit_vision_face_bundled.zzpr
    public final /* bridge */ /* synthetic */ zzpr zzn(zzps zzpsVar) {
        if (zzt().getClass().isInstance(zzpsVar)) {
            return zzm((zzmt) zzpsVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
