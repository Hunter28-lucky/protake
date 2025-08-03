package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.stream.ACUnitView;
import com.blink.academy.film.widgets.GuideView;
import defpackage.AbstractC3080;

/* loaded from: classes.dex */
public class MonitorTextureGroupView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3080 f4800;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorTextureGroupView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1749 implements View.OnClickListener {
        public ViewOnClickListenerC1749() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public MonitorTextureGroupView(@NonNull Context context) {
        this(context, null);
    }

    public ACUnitView getAcUnitView() {
        return this.f4800.f10952;
    }

    public View getCloudBgCover() {
        return this.f4800.f10951;
    }

    public GuideView getRatioCoverView() {
        return this.f4800.f10949;
    }

    public void setCoverRatioVisible(boolean z) {
        this.f4800.f10949.setVisibility(z ? 0 : 4);
    }

    public void setNoSignalVisible(boolean z) {
        this.f4800.f10950.setVisibility(z ? 0 : 4);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m4633(Context context, AttributeSet attributeSet, int i) {
        this.f4800 = AbstractC3080.m10654(LayoutInflater.from(context), this, true);
        setNoSignalVisible(true);
        this.f4800.f10949.setAlpha(0.0f);
        this.f4800.f10949.setCreateByMonitor(true);
        this.f4800.f10951.setOnClickListener(new ViewOnClickListenerC1749());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4634(int i, int i2) {
        this.f4800.f10949.m2417(i, i2, false);
        this.f4800.f10949.m2405();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4635(float f, float f2, boolean z) {
        this.f4800.f10949.m2416(f, f2, z);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4636(int i, int i2) {
        this.f4800.f10949.m2423(i, i2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m4637(int i, boolean z, boolean z2) {
        this.f4800.f10949.m2421((i * 1.0f) / 100.0f);
        this.f4800.f10949.setShowSafeCover(z);
    }

    public MonitorTextureGroupView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MonitorTextureGroupView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4633(context, attributeSet, i);
    }
}
