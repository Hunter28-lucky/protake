package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4534;
import defpackage.C4792;

/* loaded from: classes.dex */
public class StyleHintView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4534 f2545;

    public StyleHintView(@NonNull Context context) {
        this(context, null);
    }

    public void setStyleText(String str) {
        m2580(str, true);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2579() {
        AbstractC4534 abstractC4534M13878 = AbstractC4534.m13878(LayoutInflater.from(getContext()), this, true);
        this.f2545 = abstractC4534M13878;
        abstractC4534M13878.f15514.setContentTextColor(-1);
        this.f2545.f15514.setTypeface(FilmApp.m404());
        float fM14434 = C4792.m14375().m14434();
        this.f2545.f15514.m2562(0, C4792.m14375().m14381() * fM14434);
        this.f2545.f15513.setBackgroundColor(getContext().getColor(R.color.colorHalfBlack));
        float fM14476 = C4792.m14375().m14476(40) * fM14434;
        int i = (int) fM14476;
        int i2 = (int) (fM14476 / 2.0f);
        this.f2545.f15513.setPadding(i, i2, i, i2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2580(String str, boolean z) {
        if (z) {
            str = String.format("%s: %s", getContext().getString(R.string.RECORDING_SETTINGS_LOOKS_STYLE).toUpperCase(), str);
        }
        this.f2545.f15514.setText(str);
        ViewGroup.LayoutParams layoutParams = this.f2545.f15514.getLayoutParams();
        TextPaint paint = this.f2545.f15514.getPaint();
        layoutParams.width = (int) (paint.measureText(str) + C4792.f16138);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        layoutParams.height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.f16138);
        this.f2545.f15514.setLayoutParams(layoutParams);
    }

    public StyleHintView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyleHintView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2579();
    }
}
