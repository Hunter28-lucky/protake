package com.blink.academy.film.widgets.battery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.StrokeLineView;
import com.blink.academy.film.widgets.StrokeTextView;
import com.blink.academy.protake.R;
import defpackage.AbstractC5296;
import defpackage.C4792;

/* loaded from: classes.dex */
public class BatteryStoragePortraitView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public StrokeTextView f2822;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public StrokeLineView f2823;

    /* renamed from: ԭ, reason: contains not printable characters */
    public StrokeTextView f2824;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AbstractC5296 f2825;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2826;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2827;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2828;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2829;

    /* renamed from: ׯ, reason: contains not printable characters */
    public String f2830;

    /* renamed from: ؠ, reason: contains not printable characters */
    public String f2831;

    public BatteryStoragePortraitView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f2828 = i;
        ViewGroup.LayoutParams layoutParams = this.f2823.getLayoutParams();
        float f = i2;
        layoutParams.height = (int) (0.62222224f * f);
        layoutParams.width = (int) ((f * 0.022222223f) + C4792.f16138);
        this.f2823.setLayoutParams(layoutParams);
        this.f2829 = layoutParams.width;
    }

    public void setBattery(int i) {
        int color = i <= 20 ? i <= 10 ? -65536 : getResources().getColor(R.color.colorGold, null) : -1;
        String str = String.format("%s%s %s", String.valueOf(i), "%", getResources().getString(R.string.RECORDING_INFO_Batt));
        if (this.f2830.equals(str)) {
            return;
        }
        this.f2830 = str;
        this.f2822.setCustomText(str);
        this.f2822.setContentTextColor(color);
        this.f2822.m2563();
        this.f2826 = (int) this.f2822.getPaint().measureText(str);
        m2772();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2771() {
        AbstractC5296 abstractC5296 = (AbstractC5296) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_battery_portrait, this, true);
        this.f2825 = abstractC5296;
        this.f2822 = abstractC5296.f17486;
        this.f2823 = abstractC5296.f17488;
        this.f2824 = abstractC5296.f17487;
        m2774();
        this.f2822.m2562(0, C4792.m14375().m14397() / 0.9f);
        this.f2824.m2562(0, C4792.m14375().m14397() / 0.9f);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2772() {
        if (this.f2828 == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2822.getLayoutParams();
        int i = ((int) ((((r0 - this.f2826) - this.f2827) - this.f2829) / 4.0f)) * 2;
        layoutParams.width = this.f2826 + i;
        this.f2822.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2824.getLayoutParams();
        layoutParams2.width = this.f2827 + i;
        this.f2824.setLayoutParams(layoutParams2);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2773(String str, int i) {
        String str2;
        if (i == 0) {
            str2 = String.format("%s " + getResources().getString(R.string.RECORDING_INFO_GB), str);
        } else {
            str2 = String.format("%s " + getResources().getString(R.string.RECORDING_INFO_MIN), str);
        }
        if (this.f2831.equals(str2)) {
            return;
        }
        this.f2831 = str2;
        this.f2824.setCustomText(str2);
        this.f2824.m2563();
        this.f2827 = (int) (this.f2822.getPaint().measureText(str2) + 0.5f);
        m2772();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m2774() {
        this.f2823.setContentColor(-1);
        setBackgroundColor(getResources().getColor(R.color.colorHalfBlack, null));
        this.f2822.setContentTextColor(-1);
        this.f2824.setContentTextColor(-1);
        this.f2822.setAlpha(1.0f);
        this.f2824.setAlpha(1.0f);
        this.f2822.setTypeface(FilmApp.m404());
        this.f2824.setTypeface(FilmApp.m404());
    }

    public BatteryStoragePortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BatteryStoragePortraitView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2830 = "";
        this.f2831 = "";
        m2771();
    }
}
