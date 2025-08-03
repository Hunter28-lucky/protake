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
public class BottomBlockView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f1991;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f1992;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1993;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1994;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f1995;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1996;

    public BottomBlockView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0.0f, 0.0f, this.f1995, this.f1996, this.f1992);
        canvas.drawRect(0.0f, 0.0f, this.f1995, this.f1996, this.f1991);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1995 = i;
        this.f1996 = i2;
    }

    public void setBgColor(int i) {
        this.f1994 = i;
        this.f1992.setColor(i);
        postInvalidate();
    }

    public void setLineWidth(float f) {
        this.f1991.setStrokeWidth(f);
    }

    public void setStrokeColor(int i) {
        this.f1993 = i;
        this.f1991.setColor(i);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2187() {
        this.f1991 = new Paint(1);
        this.f1992 = new Paint(1);
        this.f1991.setStrokeWidth(C4792.f16138);
        this.f1993 = ViewCompat.MEASURED_STATE_MASK;
        this.f1991.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1991.setStyle(Paint.Style.STROKE);
        this.f1991.setStrokeCap(Paint.Cap.ROUND);
        this.f1991.setStrokeJoin(Paint.Join.ROUND);
        this.f1994 = -1;
        this.f1992.setColor(-1);
    }

    public BottomBlockView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomBlockView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2187();
    }
}
