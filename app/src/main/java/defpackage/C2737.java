package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* compiled from: BitmapDrawableEncoder.java */
/* renamed from: ˆ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2737 implements InterfaceC4797<BitmapDrawable> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2731 f10066;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4797<Bitmap> f10067;

    public C2737(InterfaceC2731 interfaceC2731, InterfaceC4797<Bitmap> interfaceC4797) {
        this.f10066 = interfaceC2731;
        this.f10067 = interfaceC4797;
    }

    @Override // defpackage.InterfaceC4797
    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public EncodeStrategy mo9992(@NonNull C3475 c3475) {
        return this.f10067.mo9992(c3475);
    }

    @Override // defpackage.InterfaceC3823
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7881(@NonNull InterfaceC4536<BitmapDrawable> interfaceC4536, @NonNull File file, @NonNull C3475 c3475) {
        return this.f10067.mo7881(new C2739(interfaceC4536.get().getBitmap(), this.f10066), file, c3475);
    }
}
