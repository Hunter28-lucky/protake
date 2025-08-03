package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class FilmPointView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f2156;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2157;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f2158;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2159;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2160;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2161;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2162;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f2163;

    public FilmPointView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2156) {
            if (this.f2163) {
                this.f2157.setStyle(Paint.Style.FILL_AND_STROKE);
                int i = this.f2160;
                canvas.drawCircle((i * 1.0f) / 2.0f, (i * 1.0f) / 2.0f, ((this.f2159 * 1.0f) - this.f2161) / 2.0f, this.f2157);
            }
            this.f2158.setStyle(Paint.Style.FILL_AND_STROKE);
            int i2 = this.f2160;
            canvas.drawCircle((i2 * 1.0f) / 2.0f, (i2 * 1.0f) / 2.0f, ((this.f2159 * 1.0f) - this.f2161) / 2.0f, this.f2158);
            return;
        }
        if (this.f2163) {
            this.f2157.setStyle(Paint.Style.STROKE);
            int i3 = this.f2160;
            canvas.drawCircle((i3 * 1.0f) / 2.0f, (i3 * 1.0f) / 2.0f, ((this.f2159 * 1.0f) - this.f2161) / 2.0f, this.f2157);
        }
        this.f2158.setStyle(Paint.Style.STROKE);
        int i4 = this.f2160;
        canvas.drawCircle((i4 * 1.0f) / 2.0f, (i4 * 1.0f) / 2.0f, ((this.f2159 * 1.0f) - this.f2161) / 2.0f, this.f2158);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2159 = i;
        this.f2160 = i2;
    }

    public void setStrokeScale(float f) {
        this.f2161 = (int) (((int) (this.f2162 + C4792.f16138)) * f);
    }

    public void setWhiteLinWidth(float f) {
        this.f2162 = (int) (this.f2162 * f);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2291(Context context, AttributeSet attributeSet, int i) {
        int iM9438 = C2579.m9438(1.0f);
        this.f2162 = iM9438;
        this.f2161 = (int) (iM9438 + C4792.f16138);
        Paint paint = new Paint(1);
        this.f2157 = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f2157.setStrokeCap(Paint.Cap.ROUND);
        this.f2157.setStrokeJoin(Paint.Join.ROUND);
        this.f2157.setStrokeWidth(this.f2161);
        this.f2157.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint2 = new Paint(1);
        this.f2158 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f2158.setStrokeCap(Paint.Cap.ROUND);
        this.f2158.setStrokeJoin(Paint.Join.ROUND);
        this.f2158.setStrokeWidth(this.f2162);
        this.f2158.setColor(-1);
        m2292(this.f2156);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2292(boolean z) {
        this.f2156 = z;
        postInvalidate();
    }

    public FilmPointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilmPointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2156 = false;
        this.f2163 = true;
        m2291(context, attributeSet, i);
    }
}
