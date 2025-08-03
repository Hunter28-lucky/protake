package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC2472;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class TextWithPointChooseView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2472 f2710;

    public TextWithPointChooseView(Context context) {
        this(context, null);
    }

    public void setPointSelect(boolean z) {
        this.f2710.f9173.setVisibility(z ? 0 : 8);
        this.f2710.f9175.setVisibility(z ? 8 : 0);
    }

    public void setShowPoint(boolean z) {
        this.f2710.f9175.setVisibility(z ? 0 : 8);
        this.f2710.f9173.setVisibility(z ? 0 : 8);
    }

    public void setShowPointParent(boolean z) {
        this.f2710.f9174.setVisibility(z ? 0 : 8);
    }

    public void setText(String str) {
        this.f2710.f9172.m2561(str);
        this.f2710.f9171.setText(str);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2681() {
        this.f2710 = (AbstractC2472) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_looks_choose, this, true);
        int iM14386 = C4792.m14375().m14386();
        this.f2710.f9172.setPadding(iM14386, 0, iM14386, 0);
        this.f2710.f9172.setContentTextColor(-1);
        this.f2710.f9171.setPadding(iM14386, 0, iM14386, 0);
        this.f2710.f9171.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2710.f9171.setTypeface(FilmApp.m404());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2710.f9173.getLayoutParams();
        layoutParams.width = C4792.m14375().m14476(22);
        layoutParams.height = C4792.m14375().m14476(22);
        layoutParams.bottomMargin = C4792.m14375().m14476(32);
        this.f2710.f9173.setLayoutParams(layoutParams);
        this.f2710.f9173.setStyle(true);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2710.f9175.getLayoutParams();
        layoutParams2.width = C4792.m14375().m14476(22);
        layoutParams2.height = C4792.m14375().m14476(22);
        layoutParams2.bottomMargin = C4792.m14375().m14476(32);
        this.f2710.f9175.setLayoutParams(layoutParams2);
        this.f2710.f9175.setStyle(false);
        setShowPoint(false);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2682(boolean z, int i) {
        float f = z ? 1.0f : 0.0f;
        if (z) {
            C4008.m12876(this.f2710.f9171, f, i, null);
        } else {
            C4008.m12876(this.f2710.f9171, f, i, null);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2683(int i, int i2) {
        float f = i2;
        this.f2710.f9172.m2562(i, f);
        this.f2710.f9171.setTextSize(i, f);
    }

    public TextWithPointChooseView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextWithPointChooseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2681();
    }

    public void setText(int i) {
        this.f2710.f9172.m2561(getResources().getString(i));
        this.f2710.f9171.setText(getResources().getString(i));
    }
}
