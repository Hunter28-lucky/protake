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
public class StrokeBorderView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2506;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2507;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2508;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2509;

    public StrokeBorderView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, this.f2508, C4792.m14375().m14446(), this.f2507);
        canvas.drawRect(0.0f, 0.0f, C4792.m14375().m14446(), this.f2509, this.f2507);
        canvas.drawRect(this.f2508 - C4792.m14375().m14446(), 0.0f, this.f2508, this.f2509, this.f2507);
        canvas.drawRect(0.0f, this.f2509 - C4792.m14375().m14446(), this.f2508, this.f2509, this.f2507);
        canvas.drawRect(0.0f, 0.0f, this.f2508, this.f2509, this.f2506);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2508 = i;
        this.f2509 = i2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2546() {
        Paint paint = new Paint(1);
        this.f2506 = paint;
        paint.setStrokeWidth(4.0f);
        this.f2506.setStyle(Paint.Style.STROKE);
        this.f2506.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint2 = new Paint(1);
        this.f2507 = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.f2507.setColor(-1);
    }

    public StrokeBorderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeBorderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2546();
    }
}
