package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.protake.R;
import defpackage.AbstractC4890;
import defpackage.C4792;

/* loaded from: classes.dex */
public class ChangeTintLeftImageTextView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4890 f4191;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4192;

    /* renamed from: com.blink.academy.film.widgets.transmit.ChangeTintLeftImageTextView$Ϳ, reason: contains not printable characters */
    public class RunnableC1551 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f4193;

        public RunnableC1551(String str) {
            this.f4193 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = ChangeTintLeftImageTextView.this.f4191.f16523.getPaint().measureText(this.f4193);
            ViewGroup.LayoutParams layoutParams = ChangeTintLeftImageTextView.this.f4191.f16523.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            ChangeTintLeftImageTextView.this.f4191.f16523.setLayoutParams(layoutParams);
        }
    }

    public ChangeTintLeftImageTextView(@NonNull Context context) {
        this(context, null);
    }

    private void setContentTextColor(int i) {
        this.f4191.f16523.setContentTextColor(getResources().getColor(i, null));
    }

    public String getText() {
        return this.f4191.f16523.getText().toString();
    }

    public TextPaint getTvPaint() {
        return this.f4191.f16523.getPaint();
    }

    public void setText(String str) {
        if (str == null) {
            str = "";
        }
        this.f4191.f16523.m2561(str);
        this.f4191.f16523.post(new RunnableC1551(str));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4173() {
        this.f4191 = AbstractC4890.m14613(LayoutInflater.from(getContext()), this, true);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4174(int i) {
        if (this.f4192 == i) {
            return;
        }
        this.f4192 = i;
        int i2 = R.color.colorWhite;
        if (i == 1) {
            i2 = R.color.colorTransmitGreen;
        } else if (i == 2) {
            i2 = R.color.colorTransmitYellow;
        } else if (i == 3) {
            i2 = R.color.colorTransmitButton;
        } else if (i == 4) {
            i2 = R.color.color30White;
        }
        setContentTextColor(i2);
        this.f4191.f16522.setColorFilter(getResources().getColor(i2, null));
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4175(int i, int i2) {
        this.f4191.f16521.setImageResource(i);
        this.f4191.f16522.setImageResource(i2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m4176(int i, int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4191.f16522.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i2;
        this.f4191.f16522.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4191.f16521.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = i;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = i2;
        this.f4191.f16521.setLayoutParams(layoutParams2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4177(int i, int i2, Typeface typeface, int i3) {
        this.f4191.f16523.m2562(i, i2);
        this.f4191.f16523.setContentTypeFace(typeface);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4191.f16523.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i3;
        this.f4191.f16523.setLayoutParams(layoutParams);
    }

    public ChangeTintLeftImageTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChangeTintLeftImageTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4173();
    }
}
