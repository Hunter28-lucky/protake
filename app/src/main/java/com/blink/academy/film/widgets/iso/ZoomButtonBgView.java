package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class ZoomButtonBgView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f3553;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3554;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f3555;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f3556;

    /* renamed from: ԯ, reason: contains not printable characters */
    public RectF f3557;

    public ZoomButtonBgView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3553 == 0 || this.f3554 == 0) {
            return;
        }
        RectF rectF = this.f3557;
        float f = this.f3556;
        canvas.drawRoundRect(rectF, f, f, this.f3555);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3517() {
        Paint paint = new Paint(1);
        this.f3555 = paint;
        paint.setColor(Color.parseColor("#80000000"));
        this.f3557 = new RectF();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m3518(int i, int i2) {
        this.f3553 = i;
        this.f3554 = i2;
        this.f3556 = (i * 1.0f) / 2.0f;
        RectF rectF = this.f3557;
        rectF.left = 0.0f;
        rectF.right = i;
        rectF.top = 0.0f;
        rectF.bottom = i2;
    }

    public ZoomButtonBgView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomButtonBgView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3517();
    }
}
