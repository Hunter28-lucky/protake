package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.blink.academy.protake.R;
import defpackage.C4792;

/* loaded from: classes.dex */
public class WaveformBottomLineView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f2726;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2727;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2728;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2729;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2730;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Paint f2731;

    public WaveformBottomLineView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < this.f2728; i++) {
            int i2 = this.f2729;
            int i3 = this.f2730;
            canvas.drawLine(0.0f, (i3 * i) + i2, this.f2726, i2 + (i3 * i), this.f2731);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2726 = i;
        this.f2727 = i2;
        int iM14476 = C4792.m14375().m14476(3);
        this.f2729 = iM14476;
        this.f2730 = (this.f2727 - (iM14476 * 2)) / 4;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2688(Context context, AttributeSet attributeSet, int i) {
        Paint paint = new Paint();
        this.f2731 = paint;
        paint.setAntiAlias(true);
        this.f2731.setColor(ContextCompat.getColor(context, R.color.colorhalfWhite));
    }

    public WaveformBottomLineView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveformBottomLineView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2728 = 5;
        this.f2729 = 3;
        m2688(context, attributeSet, i);
    }
}
