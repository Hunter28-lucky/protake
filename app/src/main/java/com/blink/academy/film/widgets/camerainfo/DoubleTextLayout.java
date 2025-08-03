package com.blink.academy.film.widgets.camerainfo;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC3615;
import defpackage.C3828;
import defpackage.C4062;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class DoubleTextLayout extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3615 f2880;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2881;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2882;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2883;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2884;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2885;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f2886;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f2887;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f2888;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f2889;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f2890;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f2891;

    /* renamed from: ނ, reason: contains not printable characters */
    public InterfaceC1011 f2892;

    /* renamed from: com.blink.academy.film.widgets.camerainfo.DoubleTextLayout$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1009 implements View.OnClickListener {
        public ViewOnClickListenerC1009() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (DoubleTextLayout.this.f2886 == 0 || jCurrentTimeMillis - DoubleTextLayout.this.f2886 >= C4062.f14091) {
                DoubleTextLayout.this.f2886 = jCurrentTimeMillis;
                if (DoubleTextLayout.this.f2892 != null) {
                    DoubleTextLayout.this.f2892.onClick(view);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.camerainfo.DoubleTextLayout$Ԩ, reason: contains not printable characters */
    public class RunnableC1010 implements Runnable {
        public RunnableC1010() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int measuredHeight = DoubleTextLayout.this.f2880.f12558.getMeasuredHeight();
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) DoubleTextLayout.this.f2880.f12555.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = measuredHeight;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = measuredHeight;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = DoubleTextLayout.this.f2891;
            DoubleTextLayout doubleTextLayout = DoubleTextLayout.this;
            doubleTextLayout.f2882 = Math.max(doubleTextLayout.f2882, measuredHeight);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.camerainfo.DoubleTextLayout$Ԫ, reason: contains not printable characters */
    public interface InterfaceC1011 {
        void onClick(View view);
    }

    public DoubleTextLayout(@NonNull Context context) {
        this(context, null);
    }

    public Paint getBottomPaint() {
        return this.f2880.f12558.getPaint();
    }

    public int getCameraLensWidth() {
        return this.f2889;
    }

    public float getDoubleHeight() {
        return Math.max(this.f2882, this.f2883) + this.f2881;
    }

    public int getFpsContentWidth() {
        return this.f2890;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2880.f12558.post(new RunnableC1010());
    }

    public void setBottomImageResId(int i) {
        this.f2880.f12558.setVisibility(8);
        this.f2880.f12555.setImageResource(i);
        this.f2880.f12555.setVisibility(0);
    }

    public void setBottomTextColor(int i) {
        this.f2880.f12558.setTextColor(i);
    }

    public void setBottomTextContent(int i) {
        setBottomTextContent(FilmApp.m405().getResources().getString(i));
    }

    public void setCameraLensName(C3828 c3828) {
        if (c3828.m12141()) {
            setBottomTextContent(c3828.m12139());
            this.f2889 = (int) this.f2880.f12558.getPaint().measureText(c3828.m12139());
        } else {
            setBottomTextContent(c3828.m12140());
            this.f2889 = (int) this.f2880.f12558.getPaint().measureText(FilmApp.m405().getResources().getString(c3828.m12140()));
        }
        this.f2885 = this.f2889;
    }

    public void setOnUnQuickClickListener(InterfaceC1011 interfaceC1011) {
        this.f2892 = interfaceC1011;
    }

    public void setTopTextColor(int i) {
        this.f2880.f12559.setTextColor(i);
    }

    public void setTopTextContent(String str) {
        this.f2880.f12559.m2561(str);
        float fMeasureText = this.f2880.f12559.getPaint().measureText(str);
        ViewGroup.LayoutParams layoutParams = this.f2880.f12559.getLayoutParams();
        layoutParams.width = (int) (fMeasureText + this.f2891 + this.f2887);
        Paint.FontMetrics fontMetrics = this.f2880.f12559.getPaint().getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + this.f2888);
        this.f2880.f12559.setLayoutParams(layoutParams);
        this.f2885 = layoutParams.width;
    }

    public void setTvsColor(int i) {
        setBottomTextColor(i);
        setTopTextColor(i);
    }

    public void setViewRatio(float f) {
        this.f2880.f12558.m2562(0, C4792.m14375().m14381() * f);
        this.f2880.f12557.m2562(0, C4792.m14375().m14381() * f);
        this.f2880.f12559.m2562(0, C4792.m14375().m14398() * f);
        ViewGroup.LayoutParams layoutParams = this.f2880.f12560.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(39) * f);
        layoutParams.width = iM14476;
        layoutParams.height = iM14476;
        this.f2880.f12560.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f2880.f12556.getLayoutParams();
        int iM144762 = (int) (C4792.m14375().m14476(39) * f);
        layoutParams2.width = iM144762;
        layoutParams2.height = iM144762;
        this.f2880.f12556.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f2880.f12557.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) (this.f2884 * f);
        this.f2880.f12557.setLayoutParams(layoutParams3);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m2842(boolean z) {
        if (z) {
            this.f2880.f12560.setVisibility(0);
        } else {
            this.f2880.f12560.setVisibility(8);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m2843(Context context, AttributeSet attributeSet, int i) {
        setClipChildren(false);
        setClipToPadding(false);
        AbstractC3615 abstractC3615 = (AbstractC3615) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_double_text, this, true);
        this.f2880 = abstractC3615;
        abstractC3615.f12559.m2562(0, C4792.m14375().m14398());
        this.f2880.f12559.setContentTypeFace(FilmApp.m403());
        this.f2880.f12558.setContentTypeFace(FilmApp.m403());
        this.f2880.f12557.setContentTypeFace(FilmApp.m403());
        this.f2880.f12558.m2562(0, C4792.m14375().m14381());
        this.f2880.f12557.m2562(0, C4792.m14375().m14381());
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2880.f12556.getLayoutParams();
        int iM14476 = C4792.m14375().m14476(32);
        ((ViewGroup.MarginLayoutParams) layoutParams).width = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) this.f2888;
        this.f2880.f12556.setLayoutParams(layoutParams);
        this.f2883 = Math.max(this.f2883, ((ViewGroup.MarginLayoutParams) layoutParams).height);
        Paint.FontMetrics fontMetrics = this.f2880.f12559.getPaint().getFontMetrics();
        this.f2881 = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        ViewGroup.LayoutParams layoutParams2 = this.f2880.f12560.getLayoutParams();
        int iM144762 = C4792.m14375().m14476(39);
        layoutParams2.width = iM144762;
        layoutParams2.height = iM144762;
        this.f2880.f12560.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f2880.f12556.getLayoutParams();
        int iM144763 = C4792.m14375().m14476(39);
        layoutParams3.width = iM144763;
        layoutParams3.height = iM144763;
        this.f2880.f12556.setLayoutParams(layoutParams3);
        setOnClickListener(new ViewOnClickListenerC1009());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2844() {
        this.f2880.f12559.m2562(0, C4792.m14375().m14398());
        this.f2880.f12558.m2562(0, C4792.m14375().m14381());
        this.f2880.f12557.m2562(0, C4792.m14375().m14381());
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2845(int i, int i2, int i3, int i4) {
        this.f2891 = i;
        this.f2880.f12559.m2560(i, 0, 0, 0);
        this.f2880.f12558.m2560(this.f2891, 0, 0, 0);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2846(String str, int i, String str2) {
        this.f2890 = 0;
        this.f2880.f12555.setVisibility(8);
        this.f2880.f12558.setVisibility(0);
        if (r1.m8140(i)) {
            this.f2880.f12556.setVisibility(0);
            this.f2880.f12556.setImageResource(i);
            this.f2880.f12558.m2561(str);
            this.f2890 += C4792.m14375().m14476(39);
        } else {
            this.f2880.f12556.setVisibility(8);
            this.f2880.f12558.m2561(str);
        }
        float fMeasureText = this.f2880.f12558.getPaint().measureText(str);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2880.f12558.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (fMeasureText + this.f2891 + this.f2887);
        Paint.FontMetrics fontMetrics = this.f2880.f12558.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (Math.ceil(fontMetrics.bottom - fontMetrics.top) + this.f2888);
        this.f2880.f12558.setLayoutParams(layoutParams);
        int i2 = this.f2890;
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
        this.f2890 = i2 + i3;
        this.f2885 = i3;
        if (!r1.m8143(str2)) {
            this.f2880.f12557.setVisibility(8);
            return;
        }
        this.f2880.f12557.setVisibility(0);
        this.f2880.f12557.m2561(str2);
        float fMeasureText2 = this.f2880.f12557.getPaint().measureText(str2);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2880.f12557.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (fMeasureText2 + this.f2891 + this.f2887);
        Paint.FontMetrics fontMetrics2 = this.f2880.f12557.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) (Math.ceil(fontMetrics2.bottom - fontMetrics2.top) + this.f2888);
        this.f2880.f12557.setLayoutParams(layoutParams2);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams2).width;
        this.f2884 = i4;
        this.f2890 += i4;
    }

    public DoubleTextLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleTextLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2887 = C4792.f16138;
        this.f2888 = 0.0f;
        this.f2890 = 0;
        m2843(context, attributeSet, i);
    }

    public void setBottomTextContent(String str) {
        this.f2880.f12558.getText();
        this.f2880.f12555.setVisibility(8);
        this.f2880.f12558.m2561(str);
        this.f2880.f12558.setVisibility(0);
        this.f2880.f12556.setVisibility(8);
        this.f2880.f12557.setVisibility(8);
        float fMeasureText = this.f2880.f12558.getPaint().measureText(str);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2880.f12558.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (fMeasureText + this.f2891 + this.f2887);
        Paint.FontMetrics fontMetrics = this.f2880.f12558.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (Math.ceil(fontMetrics.bottom - fontMetrics.top) + this.f2888);
        this.f2880.f12558.setLayoutParams(layoutParams);
        this.f2885 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
    }
}
