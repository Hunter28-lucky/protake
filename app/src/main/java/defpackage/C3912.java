package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapPoolAdapter.java */
/* renamed from: ࠚ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3912 implements InterfaceC2731 {
    @Override // defpackage.InterfaceC2731
    /* renamed from: Ϳ */
    public void mo9980(int i) {
    }

    @Override // defpackage.InterfaceC2731
    /* renamed from: Ԩ */
    public void mo9981() {
    }

    @Override // defpackage.InterfaceC2731
    /* renamed from: ԩ */
    public void mo9428(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // defpackage.InterfaceC2731
    @NonNull
    /* renamed from: Ԫ */
    public Bitmap mo9982(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.InterfaceC2731
    @NonNull
    /* renamed from: ԫ */
    public Bitmap mo9983(int i, int i2, Bitmap.Config config) {
        return mo9982(i, i2, config);
    }
}
