package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeRoundView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f2526;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2527;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f2528;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public RectF f2529;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2530;

    public StrokeRoundView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.f2529;
        float f = this.f2530;
        canvas.drawRoundRect(rectF, f, f, this.f2527);
        RectF rectF2 = this.f2529;
        float f2 = this.f2530;
        canvas.drawRoundRect(rectF2, f2, f2, this.f2528);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        RectF rectF = this.f2529;
        float f = this.f2526;
        rectF.left = f;
        rectF.right = i - f;
        rectF.top = f;
        rectF.bottom = i2 - f;
    }

    public void setBgColor(int i) {
        this.f2527.setColor(i);
        invalidate();
    }

    public void setRadius(int i) {
        this.f2530 = C2579.m9438(i);
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2557() {
        this.f2526 = C4792.m14375().m14443();
        Paint paint = new Paint(1);
        this.f2527 = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f2528 = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2528.setStrokeWidth(this.f2526);
        this.f2528.setStyle(Paint.Style.STROKE);
        this.f2529 = new RectF();
    }

    public StrokeRoundView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeRoundView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2530 = C2579.m9438(5.0f);
        m2557();
    }
}
