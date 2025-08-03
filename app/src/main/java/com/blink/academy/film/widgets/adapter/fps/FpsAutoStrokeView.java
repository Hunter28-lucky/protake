package com.blink.academy.film.widgets.adapter.fps;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import defpackage.AbstractC4686;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class FpsAutoStrokeView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4686 f2780;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2781;

    public FpsAutoStrokeView(@NonNull Context context) {
        this(context, null);
    }

    public void setBottomBlockHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.f2780.f15902.getLayoutParams();
        layoutParams.height = i;
        this.f2780.f15902.setLayoutParams(layoutParams);
    }

    public void setBottomBlockMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2780.f15902.getLayoutParams();
        layoutParams.topMargin = i;
        this.f2780.f15902.setLayoutParams(layoutParams);
    }

    public void setBottomStrokeColor(int i) {
        this.f2780.f15902.setStrokeColor(i);
    }

    public void setBottomStrokeWidth(int i) {
        this.f2780.f15902.setLineWidth(i);
    }

    public void setRightImageVisible(int i) {
        this.f2780.f15903.setVisibility(i);
    }

    public void setText(String str) {
        this.f2780.f15905.m2561(str);
        float fMeasureText = this.f2780.f15905.getPaint().measureText(str);
        ViewGroup.LayoutParams layoutParams = this.f2780.f15902.getLayoutParams();
        layoutParams.width = (int) Math.ceil(fMeasureText);
        layoutParams.height = C4792.m14375().m14404();
        this.f2780.f15902.setLayoutParams(layoutParams);
    }

    public void setTextColor(int i) {
        this.f2780.f15905.setContentTextColor(i);
    }

    public void setTextFont(Typeface typeface) {
        this.f2780.f15905.setTypeface(typeface);
    }

    public void setTextForSetting(String str) {
        this.f2780.f15905.m2561(str);
        float fMeasureText = this.f2780.f15905.getPaint().measureText(str);
        ViewGroup.LayoutParams layoutParams = this.f2780.f15902.getLayoutParams();
        layoutParams.width = (int) Math.ceil(fMeasureText);
        layoutParams.height = C4792.m14375().m14467();
        this.f2780.f15902.setLayoutParams(layoutParams);
    }

    public void setTopText(String str) {
        this.f2780.f15906.m2561(str);
    }

    public void setTopTextFont(Typeface typeface) {
        this.f2780.f15906.setTypeface(typeface);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2757() {
        AbstractC4686 abstractC4686M14197 = AbstractC4686.m14197(LayoutInflater.from(getContext()), this, true);
        this.f2780 = abstractC4686M14197;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) abstractC4686M14197.f15904.getLayoutParams();
        layoutParams.topMargin = C4792.m14375().m14476(10);
        this.f2780.f15904.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2780.f15905.getLayoutParams();
        layoutParams2.topMargin = -C4792.m14375().m14476(10);
        this.f2780.f15905.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f2780.f15903.getLayoutParams();
        int iM14476 = C4792.m14375().m14476(50);
        layoutParams3.width = iM14476;
        layoutParams3.height = iM14476;
        layoutParams3.leftMargin = C4792.m14375().m14476(5);
        this.f2780.f15903.setLayoutParams(layoutParams3);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2758(String str) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2780.f15906.getLayoutParams();
        layoutParams.width = (int) (this.f2780.f15906.getPaint().measureText(str.toUpperCase()) + C4792.f16138);
        Paint.FontMetrics fontMetrics = this.f2780.f15906.getPaint().getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2780.f15906.setLayoutParams(layoutParams);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2759(boolean z, int i) {
        this.f2781 = z;
        C4008.m12876(this.f2780.f15902, z ? 1.0f : 0.0f, i, null);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2760(int i, float f) {
        this.f2780.f15905.m2562(i, f);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2761(int i, float f) {
        this.f2780.f15906.m2562(i, f);
    }

    public FpsAutoStrokeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FpsAutoStrokeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2757();
    }
}
