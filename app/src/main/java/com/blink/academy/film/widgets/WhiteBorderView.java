package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C4792;

/* loaded from: classes.dex */
public class WhiteBorderView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2761;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2762;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2763;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2764;

    public WhiteBorderView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f2762;
        canvas.drawRect(f / 2.0f, f / 2.0f, this.f2763 - (f / 2.0f), this.f2764 - (f / 2.0f), this.f2761);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2763 = i;
        this.f2764 = i2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2740() {
        Paint paint = new Paint(1);
        this.f2761 = paint;
        paint.setColor(-1);
        float fM14446 = C4792.m14375().m14446() - C4792.m14375().m14476(2);
        this.f2762 = fM14446;
        this.f2761.setStrokeWidth(fM14446);
        this.f2761.setStyle(Paint.Style.STROKE);
    }

    public WhiteBorderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WhiteBorderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2740();
    }
}
