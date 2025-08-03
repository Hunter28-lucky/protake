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
public class StrokePointView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2521;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2522;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2523;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f2524;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2525;

    public StrokePointView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2525 != -1) {
            canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, ((getWidth() * 1.0f) - this.f2523) / 2.0f, this.f2521);
            this.f2522.setColor(this.f2525);
            canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, ((getWidth() * 1.0f) - this.f2523) / 2.0f, this.f2522);
        } else if (this.f2524) {
            this.f2522.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, ((getWidth() * 1.0f) - this.f2523) / 2.0f, this.f2522);
        } else {
            canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, ((getWidth() * 1.0f) - this.f2523) / 2.0f, this.f2521);
            this.f2522.setColor(-1);
            canvas.drawCircle((getWidth() * 1.0f) / 2.0f, (getHeight() * 1.0f) / 2.0f, ((getWidth() * 1.0f) - this.f2523) / 2.0f, this.f2522);
        }
    }

    public void setColor(int i) {
        this.f2525 = i;
    }

    public void setPointStrokeWidth(int i) {
        this.f2523 = i;
        this.f2521.setStrokeWidth(i);
        postInvalidate();
    }

    public void setStyle(boolean z) {
        this.f2524 = z;
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2556() {
        Paint paint = new Paint(1);
        this.f2521 = paint;
        paint.setStrokeWidth(this.f2523);
        this.f2521.setStrokeCap(Paint.Cap.ROUND);
        this.f2521.setStrokeJoin(Paint.Join.ROUND);
        this.f2521.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2521.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.f2522 = paint2;
        paint2.setAntiAlias(true);
        this.f2522.setStyle(Paint.Style.FILL);
    }

    public StrokePointView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokePointView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2523 = C4792.m14375().m14476(5);
        this.f2525 = -1;
        m2556();
    }
}
