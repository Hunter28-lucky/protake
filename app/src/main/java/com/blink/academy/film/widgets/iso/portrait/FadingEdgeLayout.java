package com.blink.academy.film.widgets.iso.portrait;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.R$styleable;

/* loaded from: classes.dex */
public class FadingEdgeLayout extends FrameLayout {

    /* renamed from: އ, reason: contains not printable characters */
    public static final int[] f3597 = {0, ViewCompat.MEASURED_STATE_MASK};

    /* renamed from: ވ, reason: contains not printable characters */
    public static final int[] f3598 = {ViewCompat.MEASURED_STATE_MASK, 0};

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f3599;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f3600;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f3601;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f3602;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3603;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3604;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3605;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3606;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Paint f3607;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Paint f3608;

    /* renamed from: ހ, reason: contains not printable characters */
    public Paint f3609;

    /* renamed from: ށ, reason: contains not printable characters */
    public Paint f3610;

    /* renamed from: ނ, reason: contains not printable characters */
    public Rect f3611;

    /* renamed from: ރ, reason: contains not printable characters */
    public Rect f3612;

    /* renamed from: ބ, reason: contains not printable characters */
    public Rect f3613;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Rect f3614;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f3615;

    public FadingEdgeLayout(Context context) {
        super(context);
        m3528(null, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        boolean z = this.f3599 || this.f3600 || this.f3601 || this.f3602;
        if (getVisibility() == 8 || width == 0 || height == 0 || !z) {
            super.dispatchDraw(canvas);
            return;
        }
        int i = this.f3615;
        if ((i & 1) == 1) {
            this.f3615 = i & (-2);
            m3532();
        }
        int i2 = this.f3615;
        if ((i2 & 4) == 4) {
            this.f3615 = i2 & (-5);
            m3530();
        }
        int i3 = this.f3615;
        if ((i3 & 2) == 2) {
            this.f3615 = i3 & (-3);
            m3529();
        }
        int i4 = this.f3615;
        if ((i4 & 8) == 8) {
            this.f3615 = i4 & (-9);
            m3531();
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        super.dispatchDraw(canvas);
        if (this.f3599 && this.f3603 > 0) {
            canvas.drawRect(this.f3611, this.f3607);
        }
        if (this.f3600 && this.f3604 > 0) {
            canvas.drawRect(this.f3612, this.f3608);
        }
        if (this.f3601 && this.f3605 > 0) {
            canvas.drawRect(this.f3613, this.f3609);
        }
        if (this.f3602 && this.f3606 > 0) {
            canvas.drawRect(this.f3614, this.f3610);
        }
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f3615 = this.f3615 | 4 | 8;
        }
        if (i2 != i4) {
            this.f3615 = this.f3615 | 1 | 2;
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        if (getPaddingLeft() != i) {
            this.f3615 |= 4;
        }
        if (getPaddingTop() != i2) {
            this.f3615 |= 1;
        }
        if (getPaddingRight() != i3) {
            this.f3615 |= 8;
        }
        if (getPaddingBottom() != i4) {
            this.f3615 |= 2;
        }
        super.setPadding(i, i2, i3, i4);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3528(AttributeSet attributeSet, int i) {
        int iApplyDimension = (int) TypedValue.applyDimension(1, 80.0f, getResources().getDisplayMetrics());
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.FadingEdgeLayout, i, 0);
            int i2 = typedArrayObtainStyledAttributes.getInt(0, 0);
            this.f3599 = (i2 & 1) == 1;
            this.f3600 = (i2 & 2) == 2;
            this.f3601 = (i2 & 4) == 4;
            this.f3602 = (i2 & 8) == 8;
            this.f3603 = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, iApplyDimension);
            this.f3604 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, iApplyDimension);
            this.f3605 = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, iApplyDimension);
            int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, iApplyDimension);
            this.f3606 = dimensionPixelSize;
            if (this.f3599 && this.f3603 > 0) {
                this.f3615 |= 1;
            }
            if (this.f3601 && this.f3605 > 0) {
                this.f3615 |= 4;
            }
            if (this.f3600 && this.f3604 > 0) {
                this.f3615 |= 2;
            }
            if (this.f3602 && dimensionPixelSize > 0) {
                this.f3615 |= 8;
            }
            typedArrayObtainStyledAttributes.recycle();
        } else {
            this.f3606 = iApplyDimension;
            this.f3605 = iApplyDimension;
            this.f3604 = iApplyDimension;
            this.f3603 = iApplyDimension;
        }
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        Paint paint = new Paint(1);
        this.f3607 = paint;
        paint.setXfermode(porterDuffXfermode);
        Paint paint2 = new Paint(1);
        this.f3608 = paint2;
        paint2.setXfermode(porterDuffXfermode);
        Paint paint3 = new Paint(1);
        this.f3609 = paint3;
        paint3.setXfermode(porterDuffXfermode);
        Paint paint4 = new Paint(1);
        this.f3610 = paint4;
        paint4.setXfermode(porterDuffXfermode);
        this.f3611 = new Rect();
        this.f3613 = new Rect();
        this.f3612 = new Rect();
        this.f3614 = new Rect();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m3529() {
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        int iMin = Math.min(this.f3604, height);
        int paddingLeft = getPaddingLeft();
        int paddingTop = (getPaddingTop() + height) - iMin;
        int i = iMin + paddingTop;
        this.f3612.set(paddingLeft, paddingTop, getWidth() - getPaddingRight(), i);
        float f = paddingLeft;
        this.f3608.setShader(new LinearGradient(f, paddingTop, f, i, f3598, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m3530() {
        int iMin = Math.min(this.f3605, (getWidth() - getPaddingLeft()) - getPaddingRight());
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = iMin + paddingLeft;
        this.f3613.set(paddingLeft, paddingTop, i, getHeight() - getPaddingBottom());
        float f = paddingTop;
        this.f3609.setShader(new LinearGradient(paddingLeft, f, i, f, f3597, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m3531() {
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int iMin = Math.min(this.f3606, width);
        int paddingLeft = (getPaddingLeft() + width) - iMin;
        int paddingTop = getPaddingTop();
        int i = iMin + paddingLeft;
        this.f3614.set(paddingLeft, paddingTop, i, getHeight() - getPaddingBottom());
        float f = paddingTop;
        this.f3610.setShader(new LinearGradient(paddingLeft, f, i, f, f3598, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m3532() {
        int iMin = Math.min(this.f3603, (getHeight() - getPaddingTop()) - getPaddingBottom());
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = iMin + paddingTop;
        this.f3611.set(paddingLeft, paddingTop, getWidth() - getPaddingRight(), i);
        float f = paddingLeft;
        this.f3607.setShader(new LinearGradient(f, paddingTop, f, i, f3597, (float[]) null, Shader.TileMode.CLAMP));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m3533(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.f3599 != z) {
            this.f3599 = z;
            this.f3615 |= 1;
        }
        if (this.f3601 != z2) {
            this.f3601 = z2;
            this.f3615 |= 4;
        }
        if (this.f3600 != z3) {
            this.f3600 = z3;
            this.f3615 |= 2;
        }
        if (this.f3602 != z4) {
            this.f3602 = z4;
            this.f3615 |= 8;
        }
        if (this.f3615 != 0) {
            invalidate();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m3534(int i, int i2, int i3, int i4) {
        if (this.f3603 != i) {
            this.f3603 = i;
            this.f3615 |= 1;
        }
        if (this.f3605 != i2) {
            this.f3605 = i2;
            this.f3615 |= 4;
        }
        if (this.f3604 != i3) {
            this.f3604 = i3;
            this.f3615 |= 2;
        }
        if (this.f3606 != i4) {
            this.f3606 = i4;
            this.f3615 |= 8;
        }
        if (this.f3615 != 0) {
            invalidate();
        }
    }

    public FadingEdgeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3528(attributeSet, 0);
    }

    public FadingEdgeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3528(attributeSet, 0);
    }
}
