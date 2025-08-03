package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.blink.academy.protake.R;
import defpackage.C2579;
import defpackage.C4792;

/* loaded from: classes.dex */
public class WheelBorderView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f3440;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f3441;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3442;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3443;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f3444;

    public WheelBorderView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = this.f3442;
        if (i2 == 0 || (i = this.f3443) == 0) {
            return;
        }
        float f = this.f3444;
        if (f == 0.0f) {
            return;
        }
        canvas.drawCircle(i2 / 2.0f, i / 2.0f, f, this.f3440);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3442 = i;
        this.f3443 = i2;
        if (this.f3444 == 0.0f) {
            this.f3444 = ((r2 - r1) / 2.0f) * 0.89375f * ((this.f3442 * 1.0f) / C4792.m14375().m14476((C4792.m14375().m14476(C4792.m14375().m14488()) * 2) + 628));
        }
    }

    public void setStrokeWidth(float f) {
        this.f3441 = f;
        this.f3440.setStrokeWidth(f);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m3444() {
        this.f3440 = new Paint(1);
        float fM9438 = C2579.m9438(2.0f);
        this.f3441 = fM9438;
        this.f3440.setStrokeWidth(fM9438);
        this.f3440.setStyle(Paint.Style.STROKE);
        this.f3440.setColor(getResources().getColor(R.color.colorGold, null));
    }

    public WheelBorderView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelBorderView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3444();
    }
}
