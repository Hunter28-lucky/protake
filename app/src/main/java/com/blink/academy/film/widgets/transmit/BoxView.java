package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.protake.R;
import defpackage.C4792;

/* loaded from: classes.dex */
public class BoxView extends View {

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f4175;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f4176;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f4177;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f4178;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f4179;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f4180;

    public BoxView(Context context) {
        super(context);
        m4153();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = this.f4180;
        float f2 = this.f4177 - (f / 2.0f);
        float f3 = this.f4178 - f;
        float f4 = this.f4179;
        canvas.drawRoundRect(f / 2.0f, f / 2.0f, f2, f3, f4, f4, this.f4176);
        float f5 = this.f4180;
        float f6 = this.f4177 - (f5 / 2.0f);
        float f7 = this.f4178 - f5;
        float f8 = this.f4179;
        canvas.drawRoundRect(f5 / 2.0f, f5 / 2.0f, f6, f7, f8, f8, this.f4175);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4153() {
        Paint paint = new Paint();
        this.f4175 = paint;
        paint.setColor(getResources().getColor(R.color.colorGold, null));
        this.f4175.setAntiAlias(true);
        Paint paint2 = new Paint(1);
        this.f4176 = paint2;
        float f = C4792.f16138;
        this.f4180 = f;
        paint2.setStrokeWidth(f);
        this.f4176.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4176.setColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4154(float f, float f2, float f3) {
        this.f4177 = f;
        this.f4178 = f2;
        this.f4179 = f3;
        postInvalidate();
    }

    public BoxView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4153();
    }

    public BoxView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4153();
    }
}
