package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.protake.R;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class TriangleView2 extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Path f4352;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f4353;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f4354;

    public TriangleView2(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f4352, this.f4354);
        canvas.drawPath(this.f4352, this.f4353);
    }

    public void setColor(int i) {
        this.f4353.setColor(i);
        invalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4388() {
        this.f4353 = new Paint();
        this.f4352 = new Path();
        this.f4353.setColor(getResources().getColor(R.color.colorGold, null));
        this.f4353.setAntiAlias(true);
        Paint paint = new Paint(1);
        this.f4354 = paint;
        paint.setStrokeWidth(C4792.f16138);
        this.f4354.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4354.setColor(ViewCompat.MEASURED_STATE_MASK);
        int iM9438 = C2579.m9438(12.0f);
        this.f4352.moveTo(0.0f, 0.0f);
        float f = iM9438 * iM9438;
        float f2 = iM9438;
        float f3 = f2 / 2.0f;
        Math.sqrt(f - ((f3 * f2) / 2.0f));
        this.f4352.lineTo(f3, f3);
        this.f4352.lineTo(f2, 0.0f);
    }

    public TriangleView2(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TriangleView2(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4388();
    }
}
