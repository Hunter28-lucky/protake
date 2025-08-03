package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class RoundButton extends AppCompatTextView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public TextView f2488;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Paint f2489;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f2490;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f2491;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f2492;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f2493;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f2494;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2495;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2496;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f2497;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f2498;

    /* renamed from: ށ, reason: contains not printable characters */
    public Paint f2499;

    /* renamed from: ނ, reason: contains not printable characters */
    public Paint f2500;

    /* renamed from: ރ, reason: contains not printable characters */
    public RectF f2501;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2502;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f2503;

    public RoundButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2494 == null) {
            return;
        }
        RectF rectF = this.f2501;
        float f = this.f2498;
        canvas.drawRoundRect(rectF, f, f, this.f2499);
        if (!this.f2492) {
            RectF rectF2 = this.f2501;
            float f2 = this.f2498;
            canvas.drawRoundRect(rectF2, f2, f2, this.f2500);
        }
        canvas.drawText(this.f2494, this.f2490, this.f2491, this.f2489);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2502 = i;
        this.f2503 = i2;
        m2533(i, i2);
    }

    public void setContentAlpha(float f) {
        this.f2489.setAlpha(Math.round(f * 255.0f));
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2532() {
        this.f2493 = C4792.m14375().m14443();
        Paint paint = new Paint(1);
        this.f2499 = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f2500 = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2500.setStrokeWidth(this.f2493);
        this.f2500.setStyle(Paint.Style.STROKE);
        this.f2488 = new TextView(getContext());
        setGravity(17);
        Paint paint3 = new Paint();
        this.f2489 = paint3;
        paint3.setTypeface(FilmApp.m404());
        this.f2489.setAntiAlias(true);
        this.f2501 = new RectF();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2533(int i, int i2) {
        RectF rectF = this.f2501;
        float f = this.f2493;
        rectF.left = f;
        rectF.right = i - f;
        rectF.top = f;
        float f2 = i2;
        rectF.bottom = f2 - f;
        if (r1.m8143(this.f2494)) {
            this.f2490 = (this.f2502 - this.f2489.measureText(this.f2494.toUpperCase())) / 2.0f;
            Paint.FontMetrics fontMetrics = this.f2489.getFontMetrics();
            float f3 = fontMetrics.bottom;
            this.f2491 = ((f2 / 2.0f) - ((fontMetrics.top + f3) / 2.0f)) - (f3 - fontMetrics.descent);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public RoundButton m2534() {
        postInvalidate();
        return this;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public RoundButton m2535() {
        m2533(this.f2502, this.f2503);
        return this;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public RoundButton m2536(boolean z) {
        this.f2492 = z;
        return this;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RoundButton m2537(String str) {
        if (str == null) {
            str = "";
        }
        this.f2494 = str;
        return this;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public RoundButton m2538(int i) {
        this.f2489.setColor(i);
        return this;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public RoundButton m2539(int i, float f) {
        this.f2489.setTextSize(f);
        return this;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public RoundButton m2540(int i) {
        this.f2497 = i;
        this.f2499.setColor(i);
        return this;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public RoundButton m2541(int i) {
        this.f2496 = i;
        this.f2500.setStrokeWidth(i);
        return this;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public RoundButton m2542(int i) {
        this.f2498 = C2579.m9438(i);
        return this;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public RoundButton m2543(int i) {
        this.f2495 = i;
        this.f2500.setColor(i);
        return this;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public RoundButton m2544(Typeface typeface) {
        this.f2489.setTypeface(typeface);
        return this;
    }

    public RoundButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2498 = C4792.m14375().m14476(60);
        m2532();
    }
}
