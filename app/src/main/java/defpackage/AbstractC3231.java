package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* compiled from: BitmapTransformation.java */
/* renamed from: ՙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3231 implements a3<Bitmap> {
    @Override // defpackage.a3
    @NonNull
    /* renamed from: Ϳ */
    public final InterfaceC4536<Bitmap> mo5(@NonNull Context context, @NonNull InterfaceC4536<Bitmap> interfaceC4536, int i, int i2) {
        if (!j5.m7101(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        InterfaceC2731 interfaceC2731M11428 = ComponentCallbacks2C3498.m11419(context).m11428();
        Bitmap bitmap = interfaceC4536.get();
        if (i == Integer.MIN_VALUE) {
            i = bitmap.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getHeight();
        }
        Bitmap bitmapMo9540 = mo9540(interfaceC2731M11428, bitmap, i, i2);
        return bitmap.equals(bitmapMo9540) ? interfaceC4536 : C2739.m9994(bitmapMo9540, interfaceC2731M11428);
    }

    /* renamed from: ԩ */
    public abstract Bitmap mo9540(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2);
}
