package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: BitmapDrawableTranscoder.java */
/* renamed from: ˇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2738 implements InterfaceC3462<Bitmap, BitmapDrawable> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Resources f10068;

    public C2738(@NonNull Resources resources) {
        this.f10068 = (Resources) C4513.m13867(resources);
    }

    @Override // defpackage.InterfaceC3462
    @Nullable
    /* renamed from: Ϳ */
    public InterfaceC4536<BitmapDrawable> mo7539(@NonNull InterfaceC4536<Bitmap> interfaceC4536, @NonNull C3475 c3475) {
        return C4341.m13499(this.f10068, interfaceC4536);
    }
}
