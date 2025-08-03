package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeTextView2 extends FilmTextView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public TextPaint f2535;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public TextPaint f2536;

    /* renamed from: ԭ, reason: contains not printable characters */
    public StaticLayout f2537;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public StaticLayout f2538;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2539;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f2540;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2541;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2542;

    public StrokeTextView2(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(4.0f, 0.0f);
        StaticLayout staticLayout = this.f2537;
        if (staticLayout != null) {
            staticLayout.draw(canvas);
        }
        canvas.save();
        StaticLayout staticLayout2 = this.f2538;
        if (staticLayout2 != null) {
            staticLayout2.draw(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2541 = i;
        String str = this.f2540;
        TextPaint textPaint = this.f2535;
        int i5 = this.f2541;
        this.f2537 = new StaticLayout(str, textPaint, i5 + (-4) > 0 ? i5 - 4 : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, this.f2539, true);
        String str2 = this.f2540;
        TextPaint textPaint2 = this.f2536;
        int i6 = this.f2541;
        this.f2538 = new StaticLayout(str2, textPaint2, i6 + (-4) > 0 ? i6 - 4 : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, this.f2539, true);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2564() {
        TextPaint textPaint = new TextPaint();
        this.f2535 = textPaint;
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2535.setStrokeWidth(C4792.f16138);
        this.f2535.setStyle(Paint.Style.STROKE);
        this.f2535.setStrokeJoin(Paint.Join.ROUND);
        this.f2535.setStrokeCap(Paint.Cap.ROUND);
        this.f2535.setTypeface(FilmApp.m404());
        this.f2535.setAntiAlias(true);
        TextPaint textPaint2 = new TextPaint();
        this.f2536 = textPaint2;
        textPaint2.setStyle(Paint.Style.FILL);
        this.f2536.setAntiAlias(true);
        this.f2536.setTypeface(FilmApp.m404());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2565() {
        postInvalidate();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public StrokeTextView2 m2566(int i) {
        this.f2536.setColor(i);
        return this;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public StrokeTextView2 m2567(int i) {
        this.f2542 = i;
        float f = i;
        this.f2536.setTextSize(f);
        this.f2535.setTextSize(f);
        return this;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public StrokeTextView2 m2568(Typeface typeface) {
        this.f2535.setTypeface(typeface);
        this.f2536.setTypeface(typeface);
        return this;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public StrokeTextView2 m2569(float f) {
        this.f2539 = f;
        return this;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public StrokeTextView2 m2570(String str) {
        this.f2540 = str;
        return this;
    }

    public StrokeTextView2(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextView2(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2539 = 1.0f;
        this.f2540 = "";
        m2564();
        setClipToOutline(false);
    }
}
