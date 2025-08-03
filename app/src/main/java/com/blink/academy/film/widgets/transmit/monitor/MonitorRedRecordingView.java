package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.blink.academy.protake.R;
import defpackage.C4792;

/* loaded from: classes.dex */
public class MonitorRedRecordingView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f4790;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4791;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Rect f4792;

    public MonitorRedRecordingView(Context context) {
        super(context);
        m4618();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(this.f4792, this.f4790);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4618() {
        this.f4790 = new Paint(1);
        int iM14476 = C4792.m14375().m14476(8);
        this.f4791 = iM14476;
        this.f4790.setStrokeWidth(iM14476);
        this.f4790.setColor(getResources().getColor(R.color.colorRed, null));
        this.f4790.setStyle(Paint.Style.STROKE);
        this.f4792 = new Rect();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4619(int i, int i2) {
        Rect rect = this.f4792;
        int i3 = this.f4791;
        rect.left = (int) ((i3 / 2.0f) - 0.5f);
        rect.right = (int) ((i - (i3 / 2.0f)) + 0.5f);
        rect.top = (int) ((i3 / 2.0f) - 0.5f);
        rect.bottom = (int) ((i2 - (i3 / 2.0f)) + 0.5f);
        postInvalidate();
    }

    public MonitorRedRecordingView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4618();
    }

    public MonitorRedRecordingView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4618();
    }
}
