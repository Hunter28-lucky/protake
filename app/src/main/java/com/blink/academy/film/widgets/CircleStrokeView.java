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
public class CircleStrokeView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2064;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2065;

    public CircleStrokeView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, ((getWidth() * 1.0f) - this.f2065) / 2.0f, this.f2064);
    }

    public void setStrokeWidth(int i) {
        float f = i;
        this.f2065 = f;
        this.f2064.setStrokeWidth(f);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2216() {
        this.f2064 = new Paint(1);
        float fM14443 = C4792.m14375().m14443();
        this.f2065 = fM14443;
        this.f2064.setStrokeWidth(fM14443);
        this.f2064.setStrokeCap(Paint.Cap.ROUND);
        this.f2064.setStrokeJoin(Paint.Join.ROUND);
        this.f2064.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2064.setStyle(Paint.Style.STROKE);
    }

    public CircleStrokeView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleStrokeView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2065 = C2579.m9438(1.0f);
        m2216();
    }
}
