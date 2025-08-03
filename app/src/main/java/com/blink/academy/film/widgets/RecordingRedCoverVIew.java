package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import defpackage.C2579;

/* loaded from: classes.dex */
public class RecordingRedCoverVIew extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2467;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Rect f2468;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2469;

    public RecordingRedCoverVIew(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f2468, this.f2467);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2514() {
        this.f2467 = new Paint();
        int iM9438 = C2579.m9438(2.0f);
        this.f2469 = iM9438;
        this.f2467.setStrokeWidth(iM9438);
        this.f2467.setColor(-65536);
        this.f2467.setAntiAlias(true);
        this.f2467.setStyle(Paint.Style.STROKE);
        this.f2468 = new Rect();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2515(float f, float f2) {
        this.f2468.left = (int) (((C2579.m9450(getContext()) - f) + this.f2469) / 2.0f);
        Rect rect = this.f2468;
        int iM9450 = C2579.m9450(getContext());
        Rect rect2 = this.f2468;
        rect.right = iM9450 - rect2.left;
        rect2.top = (int) (((C2579.m9449(getContext()) - f2) + this.f2469) / 2.0f);
        this.f2468.bottom = C2579.m9449(getContext()) - this.f2468.top;
        postInvalidate();
    }

    public RecordingRedCoverVIew(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordingRedCoverVIew(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2514();
    }
}
