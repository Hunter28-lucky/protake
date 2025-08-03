package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: DrawableBytesTranscoder.java */
/* renamed from: ž, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2403 implements InterfaceC3462<Drawable, byte[]> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2731 f8978;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC3462<Bitmap, byte[]> f8979;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3462<C3465, byte[]> f8980;

    public C2403(@NonNull InterfaceC2731 interfaceC2731, @NonNull InterfaceC3462<Bitmap, byte[]> interfaceC3462, @NonNull InterfaceC3462<C3465, byte[]> interfaceC34622) {
        this.f8978 = interfaceC2731;
        this.f8979 = interfaceC3462;
        this.f8980 = interfaceC34622;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static InterfaceC4536<C3465> m8896(@NonNull InterfaceC4536<Drawable> interfaceC4536) {
        return interfaceC4536;
    }

    @Override // defpackage.InterfaceC3462
    @Nullable
    /* renamed from: Ϳ */
    public InterfaceC4536<byte[]> mo7539(@NonNull InterfaceC4536<Drawable> interfaceC4536, @NonNull C3475 c3475) {
        Drawable drawable = interfaceC4536.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f8979.mo7539(C2739.m9994(((BitmapDrawable) drawable).getBitmap(), this.f8978), c3475);
        }
        if (drawable instanceof C3465) {
            return this.f8980.mo7539(m8896(interfaceC4536), c3475);
        }
        return null;
    }
}
