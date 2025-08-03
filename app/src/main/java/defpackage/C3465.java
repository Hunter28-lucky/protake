package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import defpackage.C3830;
import java.nio.ByteBuffer;

/* compiled from: GifDrawable.java */
/* renamed from: ع, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3465 extends Drawable implements C3830.InterfaceC3832, Animatable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C3466 f11952;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f11953;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f11954;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f11955;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f11956;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f11957;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f11958;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f11959;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Paint f11960;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Rect f11961;

    /* compiled from: GifDrawable.java */
    /* renamed from: ع$Ϳ, reason: contains not printable characters */
    public static final class C3466 extends Drawable.ConstantState {

        /* renamed from: Ϳ, reason: contains not printable characters */
        @VisibleForTesting
        public final C3830 f11962;

        public C3466(C3830 c3830) {
            this.f11962 = c3830;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new C3465(this);
        }
    }

    public C3465(Context context, InterfaceC3507 interfaceC3507, a3<Bitmap> a3Var, int i, int i2, Bitmap bitmap) {
        this(new C3466(new C3830(ComponentCallbacks2C3498.m11419(context), interfaceC3507, i, i2, a3Var, bitmap)));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.f11955) {
            return;
        }
        if (this.f11959) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), m11287());
            this.f11959 = false;
        }
        canvas.drawBitmap(this.f11952.f11962.m12155(), (Rect) null, m11287(), m11291());
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f11952;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f11952.f11962.m12160();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f11952.f11962.m12162();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f11953;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f11959 = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        m11291().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        m11291().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        C4513.m13864(!this.f11955, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f11956 = z;
        if (!z) {
            m11297();
        } else if (this.f11954) {
            m11296();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f11954 = true;
        m11294();
        if (this.f11956) {
            m11296();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f11954 = false;
        m11297();
    }

    @Override // defpackage.C3830.InterfaceC3832
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo11284() {
        if (m11285() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (m11290() == m11289() - 1) {
            this.f11957++;
        }
        int i = this.f11958;
        if (i == -1 || this.f11957 < i) {
            return;
        }
        stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Drawable.Callback m11285() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public ByteBuffer m11286() {
        return this.f11952.f11962.m12154();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Rect m11287() {
        if (this.f11961 == null) {
            this.f11961 = new Rect();
        }
        return this.f11961;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public Bitmap m11288() {
        return this.f11952.f11962.m12157();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m11289() {
        return this.f11952.f11962.m12158();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public int m11290() {
        return this.f11952.f11962.m12156();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final Paint m11291() {
        if (this.f11960 == null) {
            this.f11960 = new Paint(2);
        }
        return this.f11960;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public int m11292() {
        return this.f11952.f11962.m12161();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m11293() {
        this.f11955 = true;
        this.f11952.f11962.m12153();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m11294() {
        this.f11957 = 0;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m11295(a3<Bitmap> a3Var, Bitmap bitmap) {
        this.f11952.f11962.m12166(a3Var, bitmap);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m11296() {
        C4513.m13864(!this.f11955, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f11952.f11962.m12158() == 1) {
            invalidateSelf();
        } else {
            if (this.f11953) {
                return;
            }
            this.f11953 = true;
            this.f11952.f11962.m12169(this);
            invalidateSelf();
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m11297() {
        this.f11953 = false;
        this.f11952.f11962.m12170(this);
    }

    public C3465(C3466 c3466) {
        this.f11956 = true;
        this.f11958 = -1;
        this.f11952 = (C3466) C4513.m13867(c3466);
    }
}
