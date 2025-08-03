package com.blink.academy.film.widgets;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.ColorRes;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.R$styleable;
import defpackage.C2579;
import defpackage.m5;

/* loaded from: classes.dex */
public class VerificationCodeEditText extends AppCompatEditText implements TextWatcher, View.OnKeyListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f2711;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2712;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2713;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2714;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2715;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2716;

    /* renamed from: ֈ, reason: contains not printable characters */
    public m5 f2717;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2718;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2719;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Paint f2720;

    /* renamed from: ހ, reason: contains not printable characters */
    public Paint f2721;

    /* renamed from: ށ, reason: contains not printable characters */
    public Paint f2722;

    /* renamed from: ނ, reason: contains not printable characters */
    public Paint f2723;

    /* renamed from: ރ, reason: contains not printable characters */
    public Paint f2724;

    /* renamed from: ބ, reason: contains not printable characters */
    public boolean f2725;

    public VerificationCodeEditText(Context context) {
        this(context, null);
    }

    public static int getScreenWidth() {
        return C2579.f9594;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f2718 = getText().length();
        postInvalidate();
        if (getText().length() != this.f2711) {
            if (getText().length() > this.f2711) {
                getText().delete(this.f2711, getText().length());
            }
        } else {
            m5 m5Var = this.f2717;
            if (m5Var != null) {
                m5Var.mo2938(getText());
            }
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f2718 = getText().length();
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f2718 = getText().length();
        int paddingLeft = (this.f2719 - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        for (int i = 0; i < this.f2711; i++) {
            canvas.save();
            int i2 = (paddingLeft * i) + (this.f2712 * i);
            int i3 = paddingLeft + i2;
            if (i == this.f2718) {
                canvas.drawRect(i2, 0.0f, i3, measuredHeight, this.f2720);
            } else {
                canvas.drawRect(i2, 0.0f, i3, measuredHeight, this.f2721);
            }
            canvas.restore();
        }
        String string = getText().toString();
        for (int i4 = 0; i4 < string.length(); i4++) {
            canvas.save();
            float f = (paddingLeft * i4) + (this.f2712 * i4) + (paddingLeft / 2);
            TextPaint paint = getPaint();
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setColor(getCurrentTextColor());
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f2 = measuredHeight - fontMetrics.bottom;
            float f3 = fontMetrics.top;
            canvas.drawText(String.valueOf(string.charAt(i4)), f, ((f2 + f3) / 2.0f) - f3, paint);
            canvas.restore();
        }
        for (int i5 = 0; i5 < this.f2711; i5++) {
            canvas.save();
            float f4 = measuredHeight - (this.f2715 / 2.0f);
            int i6 = (paddingLeft * i5) + (this.f2712 * i5);
            int i7 = paddingLeft + i6;
            if (i5 < this.f2718) {
                canvas.drawLine(i6, f4, i7, f4, this.f2722);
            } else {
                canvas.drawLine(i6, f4, i7, f4, this.f2723);
            }
            canvas.restore();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        m5 m5Var;
        if (i != 67 || (m5Var = this.f2717) == null || !m5Var.mo2941()) {
            return false;
        }
        this.f2717.mo2940();
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = getScreenWidth();
        }
        int i3 = this.f2712;
        int i4 = this.f2711;
        this.f2719 = (size - (i3 * (i4 - 1))) / i4;
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 != 1073741824) {
            size2 = this.f2719;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.widget.TextView, android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f2718 = getText().length();
        postInvalidate();
        m5 m5Var = this.f2717;
        if (m5Var != null) {
            m5Var.mo2939(getText(), i, i2, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return super.onTouchEvent(motionEvent);
        }
        requestFocus();
        Editable text = getText();
        if (text != null) {
            setSelection(text.length());
        }
        m2687(getContext());
        return true;
    }

    public void setBottomLineHeight(int i) {
        this.f2715 = i;
        postInvalidate();
    }

    public void setBottomNormalColor(@ColorRes int i) {
        this.f2713 = m2684(i);
        postInvalidate();
    }

    public void setBottomSelectedColor(@ColorRes int i) {
        this.f2713 = m2684(i);
        postInvalidate();
    }

    @Override // android.widget.TextView
    public final void setCursorVisible(boolean z) {
        super.setCursorVisible(false);
    }

    public void setFigures(int i) {
        this.f2711 = i;
        postInvalidate();
    }

    public void setOnVerificationCodeChangedListener(m5 m5Var) {
        this.f2717 = m5Var;
    }

    public void setSelectedBackgroundColor(@ColorRes int i) {
        this.f2716 = m2684(i);
        postInvalidate();
    }

    public void setVerCodeMargin(int i) {
        this.f2712 = i;
        postInvalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m2684(@ColorRes int i) {
        return ContextCompat.getColor(getContext(), i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2685(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.VerificationCodeEditText);
        this.f2711 = typedArrayObtainStyledAttributes.getInteger(3, 4);
        this.f2712 = (int) typedArrayObtainStyledAttributes.getDimension(5, 0.0f);
        this.f2713 = typedArrayObtainStyledAttributes.getColor(2, getCurrentTextColor());
        this.f2714 = typedArrayObtainStyledAttributes.getColor(1, ViewCompat.MEASURED_STATE_MASK);
        this.f2715 = typedArrayObtainStyledAttributes.getDimension(0, C2579.m9438(2.0f));
        this.f2716 = typedArrayObtainStyledAttributes.getColor(4, ViewCompat.MEASURED_STATE_MASK);
        typedArrayObtainStyledAttributes.recycle();
        setLayoutDirection(0);
        setOnKeyListener(this);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2686() {
        Paint paint = new Paint();
        this.f2720 = paint;
        paint.setColor(this.f2716);
        Paint paint2 = new Paint();
        this.f2721 = paint2;
        paint2.setColor(m2684(R.color.transparent));
        this.f2722 = new Paint();
        this.f2723 = new Paint();
        this.f2722.setColor(this.f2713);
        this.f2723.setColor(this.f2714);
        this.f2722.setStrokeWidth(this.f2715);
        this.f2723.setStrokeWidth(this.f2715);
        Paint paint3 = new Paint();
        this.f2724 = paint3;
        paint3.setColor(-7829368);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2687(Context context) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(this, 2);
    }

    public VerificationCodeEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerificationCodeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2718 = 0;
        this.f2719 = 0;
        this.f2725 = false;
        m2685(attributeSet);
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
        m2686();
        setFocusableInTouchMode(true);
        super.addTextChangedListener(this);
    }
}
