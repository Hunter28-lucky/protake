package com.blink.academy.film.widgets.dialog.login;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.C2579;

/* loaded from: classes.dex */
public class VerificationTextView extends AppCompatTextView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f3052;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3053;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3054;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3055;

    public VerificationTextView(Context context) {
        super(context);
        this.f3052 = 0;
        this.f3053 = 0;
        this.f3054 = C2579.m9438(2.0f);
        this.f3055 = 1;
    }

    public static int getScreenWidth() {
        return C2579.f9594;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f3052 = getText().length();
        int paddingLeft = (this.f3053 - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        String string = getText().toString();
        for (int i = 0; i < string.length(); i++) {
            canvas.save();
            float f = (paddingLeft * i) + (this.f3054 * i) + (paddingLeft / 2);
            TextPaint paint = getPaint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f2 = measuredHeight - fontMetrics.bottom;
            float f3 = fontMetrics.top;
            canvas.drawText(String.valueOf(string.charAt(i)), f, ((f2 + f3) / 2.0f) - f3, paint);
            canvas.restore();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = getScreenWidth();
        }
        if (getText() != null) {
            String string = getText().toString();
            if (string.length() > 0) {
                size = (int) (getPaint().measureText(string) + ((string.length() - 1) * this.f3054) + 1.0f);
            }
        }
        int i3 = this.f3054;
        int i4 = this.f3055;
        this.f3053 = (size - (i3 * (i4 - 1))) / i4;
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            size2 = this.f3053;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.f3055 = charSequence.length();
    }

    public VerificationTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3052 = 0;
        this.f3053 = 0;
        this.f3054 = C2579.m9438(2.0f);
        this.f3055 = 1;
    }

    public VerificationTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3052 = 0;
        this.f3053 = 0;
        this.f3054 = C2579.m9438(2.0f);
        this.f3055 = 1;
    }
}
