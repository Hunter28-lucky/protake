package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: ResourceBitmapDecoder.java */
/* renamed from: ഝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4708 implements InterfaceC3907<Uri, Bitmap> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3673 f15974;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2731 f15975;

    public C4708(C3673 c3673, InterfaceC2731 interfaceC2731) {
        this.f15974 = c3673;
        this.f15975 = interfaceC2731;
    }

    @Override // defpackage.InterfaceC3907
    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4536<Bitmap> mo5018(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) throws NumberFormatException {
        InterfaceC4536<Drawable> interfaceC4536Mo5018 = this.f15974.mo5018(uri, i, i2, c3475);
        if (interfaceC4536Mo5018 == null) {
            return null;
        }
        return C2572.m9426(this.f15975, interfaceC4536Mo5018.get(), i, i2);
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull Uri uri, @NonNull C3475 c3475) {
        return "android.resource".equals(uri.getScheme());
    }
}
