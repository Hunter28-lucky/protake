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
public class BorderView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f1987;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f1988;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1989;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1990;

    public BorderView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f1988;
        canvas.drawRect(f / 2.0f, f / 2.0f, this.f1989 - (f / 2.0f), this.f1990 - (f / 2.0f), this.f1987);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1989 = i;
        this.f1990 = i2;
    }

    public void setStrokeWidth(float f) {
        this.f1988 = f;
        this.f1987.setStrokeWidth(f);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2186() {
        this.f1987 = new Paint(1);
        float fM14476 = C4792.m14375().m14476(4);
        this.f1988 = fM14476;
        this.f1987.setStrokeWidth(fM14476);
        this.f1987.setStyle(Paint.Style.STROKE);
        this.f1987.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public BorderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BorderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2186();
    }
}
