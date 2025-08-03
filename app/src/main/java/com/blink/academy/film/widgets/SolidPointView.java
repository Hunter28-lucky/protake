package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C4792;

/* loaded from: classes.dex */
public class SolidPointView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2504;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2505;

    public SolidPointView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, (getWidth() * 1.0f) / 2.0f, this.f2504);
    }

    public void setPointColor(int i) {
        this.f2504.setColor(i);
        postInvalidate();
    }

    public void setStyle(boolean z) {
        this.f2505 = z;
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2545() {
        Paint paint = new Paint(1);
        this.f2504 = paint;
        paint.setAntiAlias(true);
        this.f2504.setStyle(Paint.Style.FILL);
        this.f2504.setColor(C4792.m14375().m14431());
    }

    public SolidPointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SolidPointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2545();
    }
}
