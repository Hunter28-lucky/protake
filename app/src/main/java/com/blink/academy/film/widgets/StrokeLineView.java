package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeLineView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2515;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2516;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2517;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2518;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2519;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2520;

    public StrokeLineView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f2517;
        canvas.drawRect(0.0f, i / 2.0f, this.f2519, this.f2520 - (i / 2.0f), this.f2515);
        int i2 = this.f2517;
        canvas.drawRect(i2 / 2.0f, i2 / 2.0f, this.f2519 - (i2 / 2.0f), this.f2520 - (i2 / 2.0f), this.f2516);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2519 = i;
        this.f2520 = i2;
    }

    public void setContentColor(int i) {
        this.f2516.setColor(i);
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2555() {
        Paint paint = new Paint();
        this.f2515 = paint;
        int i = (int) C4792.f16138;
        this.f2517 = i;
        paint.setStrokeWidth(i);
        this.f2515.setStyle(Paint.Style.STROKE);
        this.f2515.setStrokeJoin(Paint.Join.ROUND);
        this.f2515.setStrokeCap(Paint.Cap.ROUND);
        this.f2515.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2516 = new Paint();
        int iM14476 = C4792.m14375().m14476(2);
        this.f2518 = iM14476;
        this.f2516.setStrokeWidth(iM14476);
        this.f2516.setColor(-1);
    }

    public StrokeLineView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2555();
    }
}
