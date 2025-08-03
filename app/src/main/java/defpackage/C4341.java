package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: LazyBitmapDrawableResource.java */
/* renamed from: ઝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4341 implements InterfaceC4536<BitmapDrawable>, InterfaceC4190 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Resources f14888;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final InterfaceC4536<Bitmap> f14889;

    public C4341(@NonNull Resources resources, @NonNull InterfaceC4536<Bitmap> interfaceC4536) {
        this.f14888 = (Resources) C4513.m13867(resources);
        this.f14889 = (InterfaceC4536) C4513.m13867(interfaceC4536);
    }

    @Nullable
    /* renamed from: ԫ, reason: contains not printable characters */
    public static InterfaceC4536<BitmapDrawable> m13499(@NonNull Resources resources, @Nullable InterfaceC4536<Bitmap> interfaceC4536) {
        if (interfaceC4536 == null) {
            return null;
        }
        return new C4341(resources, interfaceC4536);
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
        this.f14889.recycle();
    }

    @Override // defpackage.InterfaceC4190
    /* renamed from: Ϳ */
    public void mo9995() {
        InterfaceC4536<Bitmap> interfaceC4536 = this.f14889;
        if (interfaceC4536 instanceof InterfaceC4190) {
            ((InterfaceC4190) interfaceC4536).mo9995();
        }
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public int mo4977() {
        return this.f14889.mo4977();
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<BitmapDrawable> mo4978() {
        return BitmapDrawable.class;
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.f14888, this.f14889.get());
    }
}
