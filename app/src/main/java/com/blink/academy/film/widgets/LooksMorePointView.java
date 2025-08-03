package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class LooksMorePointView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2415;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2416;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2417;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2418;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2419;

    public LooksMorePointView(Context context) {
        super(context);
        m2462();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f2419;
        canvas.drawCircle(i + r1, i + r1, this.f2418, this.f2415);
        int i2 = this.f2419;
        canvas.drawCircle((i2 + r1) * 3, i2 + r1, this.f2418, this.f2415);
        int i3 = this.f2419;
        canvas.drawCircle((i3 + r1) * 5, i3 + r1, this.f2418, this.f2415);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2416 = i;
        this.f2417 = i2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2462() {
        Paint paint = new Paint();
        this.f2415 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f2415.setColor(-1);
        this.f2415.setAntiAlias(true);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2463(int i, int i2) {
        this.f2418 = i;
        this.f2419 = i2;
        postInvalidate();
    }

    public LooksMorePointView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2462();
    }

    public LooksMorePointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2462();
    }
}
