package com.blink.academy.film.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C2579;

/* loaded from: classes.dex */
public class CircleBgView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2058;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2059;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2060;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Paint f2061;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2062;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f2063;

    public CircleBgView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = this.f2059;
        if (i2 == 0 || (i = this.f2060) == 0) {
            return;
        }
        if (!this.f2063) {
            canvas.drawCircle(i2 / 2.0f, i / 2.0f, i2 / 2.0f, this.f2061);
            return;
        }
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        int i3 = this.f2059;
        canvas.drawCircle(i3 / 2.0f, this.f2060 / 2.0f, (i3 - this.f2062) / 2.0f, this.f2058);
        int i4 = this.f2059;
        canvas.drawCircle(i4 / 2.0f, this.f2060 / 2.0f, (i4 - this.f2062) / 2.0f, this.f2061);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2059 = i;
        this.f2060 = i2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2213() {
        Paint paint = new Paint(1);
        this.f2061 = paint;
        paint.setColor(Color.parseColor("#80000000"));
        Paint paint2 = new Paint(1);
        this.f2058 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f2058.setColor(-1);
        this.f2058.setAlpha(51);
        this.f2058.setStrokeWidth(this.f2062);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2214(boolean z) {
        this.f2063 = z;
        postInvalidate();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2215(int i, int i2) {
        this.f2059 = i;
        this.f2060 = i2;
        postInvalidate();
    }

    public CircleBgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleBgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2062 = C2579.m9438(1.0f);
        m2213();
    }
}
