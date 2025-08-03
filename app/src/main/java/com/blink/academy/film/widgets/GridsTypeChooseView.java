package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC2522;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class GridsTypeChooseView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2522 f2252;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2253;

    public GridsTypeChooseView(Context context) {
        this(context, null);
    }

    public void setText(String str) {
        this.f2252.f9346.m2561(str);
        this.f2252.f9345.setText(str);
    }

    public void setViewPadding(int i) {
        this.f2252.f9346.setPadding(i, 0, i, 0);
        this.f2252.f9345.setPadding(i, 0, i, 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2374() {
        this.f2252 = (AbstractC2522) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_grids_choose, this, true);
        this.f2253 = C4792.m14375().m14434();
        int iM14386 = (int) (C4792.m14375().m14386() * this.f2253);
        this.f2252.f9346.setPadding(iM14386, 0, iM14386, 0);
        this.f2252.f9346.setContentTextColor(-1);
        this.f2252.f9345.setPadding(iM14386, 0, iM14386, 0);
        this.f2252.f9345.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2252.f9345.setTypeface(FilmApp.m404());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2375(boolean z, int i) {
        float f = z ? 1.0f : 0.0f;
        if (z) {
            C4008.m12876(this.f2252.f9345, f, i, null);
        } else {
            C4008.m12876(this.f2252.f9345, f, i, null);
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2376(int i, float f) {
        this.f2252.f9346.m2562(i, f);
        this.f2252.f9345.setTextSize(i, f);
    }

    public GridsTypeChooseView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GridsTypeChooseView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2374();
    }

    public void setText(int i) {
        this.f2252.f9346.m2561(getResources().getString(i).toUpperCase());
        this.f2252.f9345.setText(getResources().getString(i).toUpperCase());
    }
}
