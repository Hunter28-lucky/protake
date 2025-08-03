package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* compiled from: GifDrawableTransformation.java */
/* renamed from: Ʒ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2465 implements a3<C3465> {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final a3<Bitmap> f9164;

    public C2465(a3<Bitmap> a3Var) {
        this.f9164 = (a3) C4513.m13867(a3Var);
    }

    @Override // defpackage.InterfaceC3773
    public boolean equals(Object obj) {
        if (obj instanceof C2465) {
            return this.f9164.equals(((C2465) obj).f9164);
        }
        return false;
    }

    @Override // defpackage.InterfaceC3773
    public int hashCode() {
        return this.f9164.hashCode();
    }

    @Override // defpackage.a3
    @NonNull
    /* renamed from: Ϳ */
    public InterfaceC4536<C3465> mo5(@NonNull Context context, @NonNull InterfaceC4536<C3465> interfaceC4536, int i, int i2) {
        C3465 c3465 = interfaceC4536.get();
        InterfaceC4536<Bitmap> c2739 = new C2739(c3465.m11288(), ComponentCallbacks2C3498.m11419(context).m11428());
        InterfaceC4536<Bitmap> interfaceC4536Mo5 = this.f9164.mo5(context, c2739, i, i2);
        if (!c2739.equals(interfaceC4536Mo5)) {
            c2739.recycle();
        }
        c3465.m11295(this.f9164, interfaceC4536Mo5.get());
        return interfaceC4536;
    }

    @Override // defpackage.InterfaceC3773
    /* renamed from: Ԩ */
    public void mo7626(@NonNull MessageDigest messageDigest) {
        this.f9164.mo7626(messageDigest);
    }
}
