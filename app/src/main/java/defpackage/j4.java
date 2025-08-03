package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: UnitBitmapDecoder.java */
/* loaded from: classes.dex */
public final class j4 implements InterfaceC3907<Bitmap, Bitmap> {

    /* compiled from: UnitBitmapDecoder.java */
    /* renamed from: j4$Ϳ, reason: contains not printable characters */
    public static final class C2121 implements InterfaceC4536<Bitmap> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Bitmap f7736;

        public C2121(@NonNull Bitmap bitmap) {
            this.f7736 = bitmap;
        }

        @Override // defpackage.InterfaceC4536
        public void recycle() {
        }

        @Override // defpackage.InterfaceC4536
        @NonNull
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Bitmap get() {
            return this.f7736;
        }

        @Override // defpackage.InterfaceC4536
        /* renamed from: Ԩ */
        public int mo4977() {
            return j5.m7090(this.f7736);
        }

        @Override // defpackage.InterfaceC4536
        @NonNull
        /* renamed from: ԩ */
        public Class<Bitmap> mo4978() {
            return Bitmap.class;
        }
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4536<Bitmap> mo5018(@NonNull Bitmap bitmap, int i, int i2, @NonNull C3475 c3475) {
        return new C2121(bitmap);
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull Bitmap bitmap, @NonNull C3475 c3475) {
        return true;
    }
}
