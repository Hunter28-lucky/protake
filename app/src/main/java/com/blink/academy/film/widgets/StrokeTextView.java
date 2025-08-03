package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StrokeTextView extends FilmTextView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public TextView f2533;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2534;

    public StrokeTextView(Context context) {
        this(context, null);
    }

    public TextPaint getBorderPaint() {
        return this.f2533.getPaint();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f2534) {
            this.f2533.draw(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2533.layout(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        CharSequence text = this.f2533.getText();
        if (text == null || !text.equals(getText())) {
            this.f2533.setText(getText());
            postInvalidate();
        }
        super.onMeasure(i, i2);
        this.f2533.measure(i, i2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setContentTextColor(int i) {
        setTextColor(i);
    }

    public void setContentTypeFace(Typeface typeface) {
        setTypeface(typeface);
        this.f2533.setTypeface(typeface);
    }

    public void setDrawBorder(boolean z) {
        this.f2534 = z;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f2533.setLayoutParams(layoutParams);
    }

    public void setStrokeTextColor(int i) {
        TextView textView = this.f2533;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2559() {
        TextPaint paint = this.f2533.getPaint();
        paint.setStrokeWidth(C4792.f16138);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        this.f2533.setTextColor(getResources().getColor(R.color.border_text));
        this.f2533.setGravity(getGravity());
        setTypeface(FilmApp.m404());
        this.f2533.setTypeface(FilmApp.m404());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2560(int i, int i2, int i3, int i4) {
        setPadding(i, i2, i3, i4);
        this.f2533.setPadding(i, i2, i3, i4);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2561(CharSequence charSequence) {
        setText(charSequence);
        this.f2533.setText(charSequence);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2562(int i, float f) {
        setTextSize(i, f);
        TextView textView = this.f2533;
        if (textView != null) {
            textView.setTextSize(i, f);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2563() {
        this.f2533.setLineSpacing(((getTextSize() * 1.0f) / C4792.m14375().m14378()) * C4792.m14375().m14441(), 1.0f);
    }

    public StrokeTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2533 = null;
        this.f2534 = true;
        this.f2533 = new TextView(context, attributeSet);
        m2559();
        setClipToOutline(false);
    }
}
