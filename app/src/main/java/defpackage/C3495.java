package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: BitmapDrawableDecoder.java */
/* renamed from: ٴ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3495<DataType> implements InterfaceC3907<DataType, BitmapDrawable> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC3907<DataType, Bitmap> f12246;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Resources f12247;

    public C3495(@NonNull Resources resources, @NonNull InterfaceC3907<DataType, Bitmap> interfaceC3907) {
        this.f12247 = (Resources) C4513.m13867(resources);
        this.f12246 = (InterfaceC3907) C4513.m13867(interfaceC3907);
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ϳ */
    public boolean mo5017(@NonNull DataType datatype, @NonNull C3475 c3475) throws IOException {
        return this.f12246.mo5017(datatype, c3475);
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԩ */
    public InterfaceC4536<BitmapDrawable> mo5018(@NonNull DataType datatype, int i, int i2, @NonNull C3475 c3475) throws IOException {
        return C4341.m13499(this.f12247, this.f12246.mo5018(datatype, i, i2, c3475));
    }
}
