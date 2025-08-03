package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C2579;

/* loaded from: classes.dex */
public class MonitorNormalCoverView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f4768;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Rect f4769;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f4770;

    public MonitorNormalCoverView(Context context) {
        super(context);
        m4590();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f4769, this.f4770);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m4591(i, i2);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4590() {
        this.f4770 = new Paint(1);
        int iM9441 = C2579.m9441();
        this.f4768 = iM9441;
        this.f4770.setStrokeWidth(iM9441);
        this.f4770.setColor(-1);
        this.f4770.setAlpha(51);
        this.f4770.setStyle(Paint.Style.STROKE);
        this.f4769 = new Rect();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4591(int i, int i2) {
        Rect rect = this.f4769;
        int i3 = this.f4768;
        rect.left = (int) (i3 / 2.0f);
        rect.right = (int) (i - (i3 / 2.0f));
        rect.top = (int) (i3 / 2.0f);
        rect.bottom = (int) (i2 - (i3 / 2.0f));
        postInvalidate();
    }

    public MonitorNormalCoverView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4590();
    }

    public MonitorNormalCoverView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4590();
    }
}
