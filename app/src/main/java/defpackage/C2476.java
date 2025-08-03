package defpackage;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: NonOwnedDrawableResource.java */
/* renamed from: ǉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2476 extends AbstractC5149<Drawable> {
    public C2476(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    /* renamed from: ԫ, reason: contains not printable characters */
    public static InterfaceC4536<Drawable> m9074(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new C2476(drawable);
        }
        return null;
    }

    @Override // defpackage.InterfaceC4536
    public void recycle() {
    }

    @Override // defpackage.InterfaceC4536
    /* renamed from: Ԩ */
    public int mo4977() {
        return Math.max(1, this.f17081.getIntrinsicWidth() * this.f17081.getIntrinsicHeight() * 4);
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: ԩ */
    public Class<Drawable> mo4978() {
        return this.f17081.getClass();
    }
}
