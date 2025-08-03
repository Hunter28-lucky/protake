package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import defpackage.C4792;

/* loaded from: classes.dex */
public class WheelIndicatorView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f3445;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f3446;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Path f3447;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Path f3448;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3449;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3450;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3451;

    public WheelIndicatorView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3447.moveTo(C4792.m14375().m14443(), this.f3449);
        this.f3447.lineTo(this.f3450 - C4792.m14375().m14443(), C4792.m14375().m14443());
        this.f3447.lineTo(this.f3450 - C4792.m14375().m14443(), this.f3451 - C4792.m14375().m14443());
        this.f3447.close();
        this.f3448.moveTo(0.0f, this.f3449);
        this.f3448.lineTo(this.f3450, 0.0f);
        this.f3448.lineTo(this.f3450, this.f3451);
        this.f3448.close();
        canvas.drawPath(this.f3447, this.f3445);
        canvas.drawPath(this.f3448, this.f3446);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3450 = i;
        this.f3451 = i2;
        this.f3449 = i2 / 2;
        invalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3445() {
        Paint paint = new Paint(1);
        this.f3445 = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3445.setColor(Color.parseColor("#ffba00"));
        Paint paint2 = new Paint(1);
        this.f3446 = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f3446.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3446.setStrokeWidth(C4792.m14375().m14443());
        this.f3446.setStrokeCap(Paint.Cap.ROUND);
        this.f3446.setStrokeJoin(Paint.Join.ROUND);
        this.f3447 = new Path();
        this.f3448 = new Path();
    }

    public WheelIndicatorView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelIndicatorView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3445();
    }
}
