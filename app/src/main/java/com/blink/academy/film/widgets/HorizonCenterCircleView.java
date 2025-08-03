package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C4792;

/* loaded from: classes.dex */
public class HorizonCenterCircleView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2344;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2345;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2346;

    public HorizonCenterCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f2346;
        canvas.drawCircle((i * 1.0f) / 2.0f, (i * 1.0f) / 2.0f, (((i - C4792.m14375().m14476(8)) * 1.0f) / 2.0f) - this.f2345, this.f2344);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2346 = i;
    }

    public void setPaintColor(int i) {
        if (i == C4792.m14375().m14431()) {
            this.f2344.setStrokeWidth(C4792.m14375().m14435());
        } else {
            this.f2344.setStrokeWidth(this.f2345);
        }
        this.f2344.setColor(i);
        invalidate();
    }

    public void setPaintWidth(int i) {
        this.f2345 = i;
        this.f2344.setStrokeWidth(i);
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2427() {
        Paint paint = new Paint();
        this.f2344 = paint;
        paint.setStyle(Paint.Style.STROKE);
        int iM14489 = C4792.m14375().m14489();
        this.f2345 = iM14489;
        this.f2344.setStrokeWidth(iM14489);
        this.f2344.setColor(C4792.m14375().m14417());
        this.f2344.setAntiAlias(true);
        this.f2344.setStrokeCap(Paint.Cap.ROUND);
        this.f2344.setStrokeJoin(Paint.Join.ROUND);
    }

    public HorizonCenterCircleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizonCenterCircleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2427();
    }
}
