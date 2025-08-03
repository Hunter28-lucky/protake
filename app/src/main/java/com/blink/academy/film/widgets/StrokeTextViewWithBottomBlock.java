package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC4251;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class StrokeTextViewWithBottomBlock extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4251 f2543;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f2544;

    public StrokeTextViewWithBottomBlock(@NonNull Context context) {
        this(context, null);
    }

    public void setBottomBgColor(int i) {
        this.f2543.f14581.setBgColor(i);
    }

    public void setBottomBlockHeight(int i) {
        ViewGroup.LayoutParams layoutParams = this.f2543.f14581.getLayoutParams();
        layoutParams.height = i;
        this.f2543.f14581.setLayoutParams(layoutParams);
    }

    public void setBottomBlockMargin(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2543.f14581.getLayoutParams();
        layoutParams.topMargin = i;
        this.f2543.f14581.setLayoutParams(layoutParams);
    }

    public void setBottomStrokeColor(int i) {
        this.f2543.f14581.setStrokeColor(i);
    }

    public void setBottomStrokeWidth(int i) {
        this.f2543.f14581.setLineWidth(i);
    }

    public void setText(int i) {
        setText(FilmApp.m405().getResources().getString(i));
    }

    public void setTextColor(int i) {
        this.f2543.f14583.setContentTextColor(i);
    }

    public void setTextFont(Typeface typeface) {
        this.f2543.f14583.setTypeface(typeface);
    }

    public void setTextForSetting(String str) {
        this.f2543.f14583.m2561(str);
        TextPaint paint = this.f2543.f14583.getPaint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float fMeasureText = paint.measureText(str) + C4792.f16138;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2543.f14581.getLayoutParams();
        layoutParams.width = (int) Math.ceil(fMeasureText);
        layoutParams.height = C4792.m14375().m14467();
        layoutParams.topMargin = (int) ((C4792.m14375().m14476(13) * C4792.m14375().m14455(1125.0f)) - (fontMetrics.bottom - fontMetrics.descent));
        this.f2543.f14581.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f2543.f14583.getLayoutParams();
        layoutParams2.width = (int) fMeasureText;
        layoutParams2.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2543.f14583.setLayoutParams(layoutParams2);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2571() {
        this.f2543.f14583.setDrawBorder(false);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m2572(String str) {
        if (r1.m8138(str)) {
            return 0;
        }
        return (int) Math.ceil(this.f2543.f14583.getPaint().measureText(str));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m2573() {
        this.f2543 = AbstractC4251.m13363(LayoutInflater.from(getContext()), this, true);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean m2574() {
        return this.f2544;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2575(boolean z, int i) {
        this.f2544 = z;
        C4008.m12876(this.f2543.f14581, z ? 1.0f : 0.0f, i, null);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2576(int i, float f) {
        this.f2543.f14583.m2562(i, f);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m2577(String str, int i) {
        this.f2543.f14583.m2561(str);
        this.f2543.f14582.setVisibility(0);
        TextPaint paint = this.f2543.f14583.getPaint();
        float fMeasureText = paint.measureText(str) + C4792.f16138;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        int i2 = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2543.f14582.getLayoutParams();
        int iM9438 = (int) (C2579.m9438(17.6f) * C4792.m14375().m14471());
        layoutParams.width = iM9438;
        layoutParams.height = iM9438;
        layoutParams.topMargin = (int) ((i2 - iM9438) * 0.6f);
        layoutParams.leftMargin = C4792.m14375().m14479(25.6f, C4792.m14375().m14471());
        this.f2543.f14582.setLayoutParams(layoutParams);
        this.f2543.f14582.setImageResource(i);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2543.f14581.getLayoutParams();
        layoutParams2.width = ((int) Math.ceil(fMeasureText)) + layoutParams.width + layoutParams.leftMargin;
        layoutParams2.height = C4792.m14375().m14404();
        layoutParams2.topMargin = (int) (((C4792.m14375().m14476(13) * C4792.m14375().m14455(1125.0f)) - (fontMetrics.bottom - fontMetrics.descent)) - C4792.f16138);
        this.f2543.f14581.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f2543.f14583.getLayoutParams();
        layoutParams3.width = (int) fMeasureText;
        layoutParams3.height = i2;
        this.f2543.f14583.setLayoutParams(layoutParams3);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float[] m2578(String str) {
        this.f2543.f14583.m2561(str);
        TextPaint paint = this.f2543.f14583.getPaint();
        float fMeasureText = paint.measureText(str) + C4792.f16138;
        ViewGroup.LayoutParams layoutParams = this.f2543.f14583.getLayoutParams();
        layoutParams.width = (int) fMeasureText;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2543.f14583.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2543.f14581.getLayoutParams();
        layoutParams2.width = (int) Math.ceil(fMeasureText);
        layoutParams2.height = C4792.m14375().m14404();
        layoutParams2.topMargin = (int) (((C4792.m14375().m14476(13) * C4792.m14375().m14455(1125.0f)) - (fontMetrics.bottom - fontMetrics.descent)) - C4792.f16138);
        this.f2543.f14581.setLayoutParams(layoutParams2);
        return new float[]{layoutParams2.width, layoutParams.height + layoutParams2.height + layoutParams2.topMargin};
    }

    public StrokeTextViewWithBottomBlock(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StrokeTextViewWithBottomBlock(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2573();
    }

    public void setText(String str) {
        this.f2543.f14583.m2561(str);
        TextPaint paint = this.f2543.f14583.getPaint();
        float fMeasureText = paint.measureText(str) + C4792.f16138;
        ViewGroup.LayoutParams layoutParams = this.f2543.f14583.getLayoutParams();
        layoutParams.width = (int) fMeasureText;
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2543.f14583.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2543.f14581.getLayoutParams();
        layoutParams2.width = (int) Math.ceil(fMeasureText);
        layoutParams2.height = C4792.m14375().m14404();
        layoutParams2.topMargin = (int) (((C4792.m14375().m14476(13) * C4792.m14375().m14455(1125.0f)) - (fontMetrics.bottom - fontMetrics.descent)) - C4792.f16138);
        this.f2543.f14581.setLayoutParams(layoutParams2);
    }
}
