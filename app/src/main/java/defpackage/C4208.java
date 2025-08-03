package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: DrawableTransformation.java */
/* renamed from: হ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4208 implements a3<Drawable> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final a3<Bitmap> f14501;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean f14502;

    public C4208(a3<Bitmap> a3Var, boolean z) {
        this.f14501 = a3Var;
        this.f14502 = z;
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (obj instanceof C4208) {
            return this.f14501.equals(((C4208) obj).f14501);
        }
        return false;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return this.f14501.hashCode();
    }

    @Override // defpackage.a3
    @NonNull
    /* renamed from: Ϳ */
    public InterfaceC4536<Drawable> mo5(@NonNull Context context, @NonNull InterfaceC4536<Drawable> interfaceC4536, int i, int i2) {
        InterfaceC2731 interfaceC2731M11428 = ComponentCallbacks2C3498.m11419(context).m11428();
        Drawable drawable = interfaceC4536.get();
        InterfaceC4536<Bitmap> interfaceC4536M9426 = C2572.m9426(interfaceC2731M11428, drawable, i, i2);
        if (interfaceC4536M9426 != null) {
            InterfaceC4536<Bitmap> interfaceC4536Mo5 = this.f14501.mo5(context, interfaceC4536M9426, i, i2);
            if (!interfaceC4536Mo5.equals(interfaceC4536M9426)) {
                return m13290(context, interfaceC4536Mo5);
            }
            interfaceC4536Mo5.recycle();
            return interfaceC4536;
        }
        if (!this.f14502) {
            return interfaceC4536;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        this.f14501.mo7626(messageDigest);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public a3<BitmapDrawable> m13289() {
        return this;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC4536<Drawable> m13290(Context context, InterfaceC4536<Bitmap> interfaceC4536) {
        return C4341.m13499(context.getResources(), interfaceC4536);
    }
}
