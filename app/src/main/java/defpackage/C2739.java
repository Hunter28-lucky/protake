package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapResource.java */
/* renamed from: ˈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2739 implements InterfaceC4536<Bitmap>, InterfaceC4190 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Bitmap f10069;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC2731 f10070;

    public C2739(@NonNull Bitmap bitmap, @NonNull InterfaceC2731 interfaceC2731) {
        this.f10069 = (Bitmap) C4513.m13868(bitmap, "Bitmap must not be null");
        this.f10070 = (InterfaceC2731) C4513.m13868(interfaceC2731, "BitmapPool must not be null");
    }

    @Nullable
    /* renamed from: ԫ, reason: contains not printable characters */
    public static C2739 m9994(@Nullable Bitmap bitmap, @NonNull InterfaceC2731 interfaceC2731) {
        if (bitmap == null) {
            return null;
        }
        return new C2739(bitmap, interfaceC2731);
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
        this.f10070.mo9428(this.f10069);
    }

    @Override // defpackage.InterfaceC4190
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo9995() {
        this.f10069.prepareToDraw();
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public int mo4977() {
        return j5.m7090(this.f10069);
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<Bitmap> mo4978() {
        return Bitmap.class;
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Bitmap get() {
        return this.f10069;
    }
}
