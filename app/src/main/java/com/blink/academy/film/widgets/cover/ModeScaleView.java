package com.blink.academy.film.widgets.cover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C4792;

/* loaded from: classes.dex */
public class ModeScaleView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f2901;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2902;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f2903;

    public ModeScaleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.f2901;
        canvas.drawCircle(i / 2, this.f2902 / 2, i / 2, this.f2903);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2858() {
        Paint paint = new Paint();
        this.f2903 = paint;
        paint.setColor(C4792.m14375().m14431());
        this.f2903.setAntiAlias(true);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2859(int i, int i2) {
        this.f2901 = i;
        this.f2902 = i2;
    }

    public ModeScaleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ModeScaleView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2858();
    }
}
