package com.blink.academy.film.widgets.exposure;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C2579;

/* loaded from: classes.dex */
public class TouchSquareView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f3217;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3218;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Path f3219;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f3220;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float[] f3221;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3222;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3223;

    public TouchSquareView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.f3219;
        if (path == null) {
            return;
        }
        canvas.drawPath(path, this.f3217);
        int i = this.f3222;
        canvas.drawLine(i / 2.0f, 0.0f, i / 2.0f, this.f3220, this.f3217);
        int i2 = this.f3223;
        canvas.drawLine(0.0f, i2 / 2.0f, this.f3220, i2 / 2.0f, this.f3217);
        int i3 = this.f3222;
        int i4 = this.f3223;
        canvas.drawLine(i3, i4 / 2.0f, i3 - this.f3220, i4 / 2.0f, this.f3217);
        int i5 = this.f3222;
        int i6 = this.f3223;
        canvas.drawLine(i5 / 2.0f, i6, i5 / 2.0f, i6 - this.f3220, this.f3217);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3223 = i2;
        this.f3222 = i;
        Path path = new Path();
        this.f3219 = path;
        int i5 = this.f3218;
        int i6 = i5 / 2;
        int i7 = this.f3222 - (i5 / 2);
        int i8 = this.f3223 - (i5 / 2);
        float f = i5 / 2;
        float f2 = i6;
        path.moveTo(f, f2);
        float f3 = i7;
        this.f3219.lineTo(f3, f2);
        float f4 = i8;
        this.f3219.lineTo(f3, f4);
        this.f3219.lineTo(f, f4);
        this.f3219.lineTo(f, f2);
        this.f3219.close();
        this.f3220 = this.f3222 * 0.08f;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3173() {
        Paint paint = new Paint(1);
        this.f3217 = paint;
        paint.setColorFilter(new ColorMatrixColorFilter(this.f3221));
        int iM9438 = C2579.m9438(1.0f);
        this.f3218 = iM9438;
        this.f3217.setStrokeWidth(iM9438);
        this.f3217.setStyle(Paint.Style.STROKE);
    }

    public TouchSquareView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TouchSquareView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3221 = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, 1.0f, 0.0f, 0.0f, 186.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        m3173();
    }
}
