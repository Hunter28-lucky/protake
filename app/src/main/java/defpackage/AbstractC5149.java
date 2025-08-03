package defpackage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* compiled from: DrawableResource.java */
/* renamed from: ၓ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC5149<T extends Drawable> implements InterfaceC4536<T>, InterfaceC4190 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final T f17081;

    public AbstractC5149(T t) {
        this.f17081 = (T) C4513.m13867(t);
    }

    /* renamed from: Ϳ */
    public void mo9995() {
        T t = this.f17081;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof C3465) {
            ((C3465) t).m11288().prepareToDraw();
        }
    }

    @Override // defpackage.InterfaceC4536
    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public final T get() {
        Drawable.ConstantState constantState = this.f17081.getConstantState();
        return constantState == null ? this.f17081 : (T) constantState.newDrawable();
    }
}
