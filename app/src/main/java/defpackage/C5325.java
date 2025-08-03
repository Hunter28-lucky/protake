package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;

/* compiled from: BitmapBytesTranscoder.java */
/* renamed from: ჾ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5325 implements InterfaceC3462<Bitmap, byte[]> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Bitmap.CompressFormat f17614;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f17615;

    public C5325() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // defpackage.InterfaceC3462
    @Nullable
    /* renamed from: Ϳ */
    public InterfaceC4536<byte[]> mo7539(@NonNull InterfaceC4536<Bitmap> interfaceC4536, @NonNull C3475 c3475) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        interfaceC4536.get().compress(this.f17614, this.f17615, byteArrayOutputStream);
        interfaceC4536.recycle();
        return new C2637(byteArrayOutputStream.toByteArray());
    }

    public C5325(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.f17614 = compressFormat;
        this.f17615 = i;
    }
}
