package com.blink.academy.film.widgets.camerainfo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.blink.academy.protake.R;

/* loaded from: classes.dex */
public class StrokeTextView extends AppCompatTextView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public TextView f2895;

    public StrokeTextView(Context context) {
        super(context);
        this.f2895 = null;
        this.f2895 = new TextView(context);
        m2848();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        this.f2895.draw(canvas);
        super.onDraw(canvas);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f2895.layout(i, i2, i3, i4);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        CharSequence text = this.f2895.getText();
        if (text == null || !text.equals(getText())) {
            this.f2895.setText(getText());
            postInvalidate();
        }
        this.f2895.measure(i, i2);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        this.f2895.setLayoutParams(layoutParams);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2848() {
        TextPaint paint = this.f2895.getPaint();
        paint.setStrokeWidth(4.0f);
        paint.setStyle(Paint.Style.STROKE);
        this.f2895.setTextColor(ContextCompat.getColor(getContext(), R.color.colorBlack));
        this.f2895.setGravity(getGravity());
    }

    public StrokeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2895 = null;
        this.f2895 = new TextView(context, attributeSet);
        m2848();
    }

    public StrokeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2895 = null;
        this.f2895 = new TextView(context, attributeSet, i);
        m2848();
    }
}
