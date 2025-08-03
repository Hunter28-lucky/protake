package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import defpackage.AbstractC4201;
import defpackage.C4792;

/* loaded from: classes.dex */
public class MonitorParentView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4201 f4771;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4772;

    public MonitorParentView(@NonNull Context context) {
        super(context);
        this.f4772 = 0;
        m4592();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m4595(i, i2);
        this.f4771.f14487.m4619(i, i2);
        this.f4771.f14485.m4591(i, i2);
    }

    public void setProgress(double d) {
        this.f4771.f14486.setProgress((int) (d * 100.0d));
    }

    public void setProgressBarScale(float f) {
        this.f4771.f14486.setScaleX(f);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4592() {
        this.f4771 = AbstractC4201.m13270(LayoutInflater.from(getContext()), this, true);
        m4593();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4593() {
        m4596(false);
        this.f4771.f14486.setPivotX(0.0f);
        this.f4771.f14486.setPivotY(0.0f);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4594(int i, int i2) {
        this.f4772 = i;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4771.f14486.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = i - C4792.m14375().m14476(2);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = i2;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = C4792.m14375().m14476(1);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C4792.m14375().m14476(1);
        this.f4771.f14486.setLayoutParams(layoutParams);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4595(int i, int i2) {
        this.f4771.f14487.m4619(i, i2);
        this.f4771.f14485.m4591(i, i2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m4596(boolean z) {
        this.f4771.f14487.setVisibility(z ? 0 : 8);
    }

    public MonitorParentView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4772 = 0;
        m4592();
    }

    public MonitorParentView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4772 = 0;
        m4592();
    }
}
