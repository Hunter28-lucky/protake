package com.blink.academy.film.widgets.looks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class WhiteLineWithStroke extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f3862;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3863;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3864;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3865;

    public WhiteLineWithStroke(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3862.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawRect(0.0f, 0.0f, this.f3864, this.f3865, this.f3862);
        this.f3862.setStyle(Paint.Style.FILL);
        this.f3862.setColor(-1);
        int i = this.f3863;
        canvas.drawRect(i, i, this.f3864 - i, this.f3865 - i, this.f3862);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3864 = i;
        this.f3865 = i2;
        int i5 = (int) (i / 3.0f);
        this.f3863 = i5;
        this.f3862.setStrokeWidth(i5);
        this.f3862.setStyle(Paint.Style.STROKE);
        this.f3862.setAntiAlias(true);
        this.f3862.setStrokeCap(Paint.Cap.ROUND);
        this.f3862.setStrokeJoin(Paint.Join.ROUND);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3868() {
        this.f3862 = new Paint();
    }

    public WhiteLineWithStroke(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WhiteLineWithStroke(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3868();
    }
}
