package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class CheckView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2054;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2055;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2056;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2057;

    public CheckView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        super.onDraw(canvas);
        Paint paint = this.f2054;
        if (paint == null || (i = this.f2056) == 0 || (i2 = this.f2057) == 0) {
            return;
        }
        int i3 = this.f2055;
        canvas.drawLine(i3 / 2.0f, i2 / 2.0f, i * 0.375f, i2 - (i3 / 2.0f), paint);
        int i4 = this.f2056;
        float f = this.f2057;
        int i5 = this.f2055;
        canvas.drawLine(i4 * 0.375f, f - (i5 / 2.0f), i4 - (i5 / 2.0f), i5 / 2.0f, this.f2054);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2056 = i;
        this.f2057 = i2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2212() {
        this.f2054 = new Paint(1);
        int iM9438 = C2579.m9438(2.0f);
        this.f2055 = iM9438;
        this.f2054.setStrokeWidth(iM9438);
        this.f2054.setStyle(Paint.Style.STROKE);
        this.f2054.setStrokeCap(Paint.Cap.ROUND);
        this.f2054.setStrokeJoin(Paint.Join.ROUND);
        this.f2054.setColor(C4792.m14375().m14431());
    }

    public CheckView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2212();
    }
}
