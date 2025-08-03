package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.l3;

/* compiled from: ImageViewTarget.java */
/* renamed from: ॺ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4128<Z> extends q7<ImageView, Z> implements l3.InterfaceC2166 {

    /* renamed from: ԯ, reason: contains not printable characters */
    @Nullable
    public Animatable f14293;

    public AbstractC4128(ImageView imageView) {
        super(imageView);
    }

    @Override // defpackage.AbstractC5173, defpackage.InterfaceC2405
    public void onStart() {
        Animatable animatable = this.f14293;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // defpackage.AbstractC5173, defpackage.InterfaceC2405
    public void onStop() {
        Animatable animatable = this.f14293;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // defpackage.AbstractC5173, defpackage.c1
    /* renamed from: Ԫ */
    public void mo178(@Nullable Drawable drawable) {
        super.mo178(drawable);
        m13100(null);
        m13099(drawable);
    }

    @Override // defpackage.c1
    /* renamed from: ԫ */
    public void mo179(@NonNull Z z, @Nullable l3<? super Z> l3Var) {
        if (l3Var == null || !l3Var.mo7483(z, this)) {
            m13100(z);
        } else {
            m13098(z);
        }
    }

    @Override // defpackage.q7, defpackage.AbstractC5173, defpackage.c1
    /* renamed from: Ԭ */
    public void mo180(@Nullable Drawable drawable) {
        super.mo180(drawable);
        m13100(null);
        m13099(drawable);
    }

    @Override // defpackage.q7, defpackage.AbstractC5173, defpackage.c1
    /* renamed from: Ԯ */
    public void mo182(@Nullable Drawable drawable) {
        super.mo182(drawable);
        Animatable animatable = this.f14293;
        if (animatable != null) {
            animatable.stop();
        }
        m13100(null);
        m13099(drawable);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m13098(@Nullable Z z) {
        if (!(z instanceof Animatable)) {
            this.f14293 = null;
            return;
        }
        Animatable animatable = (Animatable) z;
        this.f14293 = animatable;
        animatable.start();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m13099(Drawable drawable) {
        ((ImageView) this.f8429).setImageDrawable(drawable);
    }

    /* renamed from: ށ */
    public abstract void mo9804(@Nullable Z z);

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m13100(@Nullable Z z) {
        mo9804(z);
        m13098(z);
    }
}
