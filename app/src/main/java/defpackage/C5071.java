package defpackage;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.C1835;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitmapDecoder.java */
/* renamed from: ཪ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5071 implements InterfaceC3907<ByteBuffer, Bitmap> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C1835 f16846;

    public C5071(C1835 c1835) {
        this.f16846 = c1835;
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4536<Bitmap> mo5018(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull C3475 c3475) throws IOException {
        return this.f16846.m5009(C2360.m8829(byteBuffer), i, i2, c3475);
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull ByteBuffer byteBuffer, @NonNull C3475 c3475) {
        return this.f16846.m5013(byteBuffer);
    }
}
