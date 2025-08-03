package com.blink.academy.film.support.sensor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes.dex */
public class RotateImageView extends AppCompatImageView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f1599;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f1600;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1601;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f1602;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f1603;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f1604;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f1605;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f1606;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Bitmap f1607;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Drawable[] f1608;

    /* renamed from: ހ, reason: contains not printable characters */
    public TransitionDrawable f1609;

    public RotateImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1599 = 0;
        this.f1600 = 0;
        this.f1601 = 0;
        this.f1602 = false;
        this.f1603 = true;
        this.f1604 = 0L;
        this.f1605 = 0L;
        this.f1606 = true;
    }

    public int getDegree() {
        return this.f1601;
    }

    public int getTargetDegree() {
        return this.f1601;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Rect bounds = drawable.getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        if (i == 0 || i2 == 0) {
            return;
        }
        if (this.f1599 != this.f1601) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (jCurrentAnimationTimeMillis < this.f1605) {
                int i3 = (int) (jCurrentAnimationTimeMillis - this.f1604);
                int i4 = this.f1600;
                if (!this.f1602) {
                    i3 = -i3;
                }
                int i5 = i4 + ((i3 * 720) / 1000);
                this.f1599 = i5 >= 0 ? i5 % 360 : (i5 % 360) + 360;
                invalidate();
            } else {
                this.f1599 = this.f1601;
            }
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int width = (getWidth() - paddingLeft) - paddingRight;
        int height = (getHeight() - paddingTop) - paddingBottom;
        int saveCount = canvas.getSaveCount();
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER && (width < i || height < i2)) {
            float f = width;
            float f2 = height;
            float fMin = Math.min(f / i, f2 / i2);
            canvas.scale(fMin, fMin, f / 2.0f, f2 / 2.0f);
        }
        canvas.translate(paddingLeft + (width / 2), paddingTop + (height / 2));
        canvas.rotate(-this.f1599);
        canvas.translate((-i) / 2, (-i2) / 2);
        drawable.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public void setBackgroundEnabled(boolean z) {
        if (this.f1606 && z) {
            clearColorFilter();
        }
    }

    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            this.f1607 = null;
            this.f1608 = null;
            setImageDrawable(null);
            setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        this.f1607 = ThumbnailUtils.extractThumbnail(bitmap, (layoutParams.width - getPaddingLeft()) - getPaddingRight(), (layoutParams.height - getPaddingTop()) - getPaddingBottom());
        Drawable[] drawableArr = this.f1608;
        if (drawableArr == null || !this.f1603) {
            Drawable[] drawableArr2 = new Drawable[2];
            this.f1608 = drawableArr2;
            drawableArr2[1] = new BitmapDrawable(getContext().getResources(), this.f1607);
            setImageDrawable(this.f1608[1]);
        } else {
            drawableArr[0] = drawableArr[1];
            drawableArr[1] = new BitmapDrawable(getContext().getResources(), this.f1607);
            TransitionDrawable transitionDrawable = new TransitionDrawable(this.f1608);
            this.f1609 = transitionDrawable;
            setImageDrawable(transitionDrawable);
            this.f1609.startTransition(500);
        }
        setVisibility(0);
    }

    public void setDegree(int i) {
        int i2 = i >= 0 ? i % 360 : (i % 360) + 360;
        if (i2 == this.f1601) {
            return;
        }
        this.f1601 = i2;
        this.f1600 = this.f1599;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f1604 = jCurrentAnimationTimeMillis;
        int i3 = this.f1601 - this.f1599;
        if (i3 < 0) {
            i3 += 360;
        }
        if (i3 > 180) {
            i3 -= 360;
        }
        this.f1602 = i3 >= 0;
        this.f1605 = jCurrentAnimationTimeMillis + ((Math.abs(i3) * 1000) / 720);
        invalidate();
    }

    public void setOrientation(int i) {
        setDegree(i);
    }

    public RotateImageView(Context context) {
        this(context, null);
    }
}
