package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4928;
import defpackage.C4792;

/* loaded from: classes.dex */
public class BatteryStorageView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public StrokeTextView f1977;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public StrokeLineView f1978;

    /* renamed from: ԭ, reason: contains not printable characters */
    public StrokeTextView f1979;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AbstractC4928 f1980;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f1981;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1982;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f1983;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f1984;

    /* renamed from: ׯ, reason: contains not printable characters */
    public String f1985;

    /* renamed from: ؠ, reason: contains not printable characters */
    public String f1986;

    public BatteryStorageView(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1983 = i2;
    }

    public void setBattery(int i) {
        int color = i <= 20 ? i <= 10 ? -65536 : getResources().getColor(R.color.colorGold, null) : -1;
        String strValueOf = String.valueOf(i);
        String str = String.format("%s%s\n%s", strValueOf, "%", getResources().getString(R.string.RECORDING_INFO_Batt));
        if (this.f1985.equals(str)) {
            return;
        }
        this.f1985 = str;
        this.f1977.m2561(str);
        this.f1977.setCustomText(str);
        this.f1977.setContentTextColor(color);
        this.f1977.m2563();
        TextPaint paint = this.f1977.getPaint();
        paint.measureText(strValueOf + "%");
        paint.measureText(getResources().getString(R.string.RECORDING_INFO_Batt));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f1981 = (int) ((fontMetrics.descent - fontMetrics.ascent) * 2.0f);
        m2182();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2181() {
        AbstractC4928 abstractC4928 = (AbstractC4928) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_battery, this, true);
        this.f1980 = abstractC4928;
        this.f1977 = abstractC4928.f16615;
        this.f1978 = abstractC4928.f16617;
        this.f1979 = abstractC4928.f16616;
        m2185();
        this.f1977.m2562(0, C4792.m14375().m14397());
        this.f1979.m2562(0, C4792.m14375().m14397());
        m2184("N/A", 0);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m2182() {
        if (this.f1983 == 0) {
            return;
        }
        if (this.f1981 == 0 || this.f1982 == 0) {
            int i = (int) ((r0 - this.f1984) / 2.0f);
            this.f1981 = i;
            this.f1982 = i;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f1977.getLayoutParams();
        int i2 = ((int) ((((r0 - this.f1981) - this.f1982) - this.f1984) / 4.0f)) * 2;
        layoutParams.height = this.f1981 + i2;
        this.f1977.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f1979.getLayoutParams();
        layoutParams2.height = this.f1982 + i2;
        this.f1979.setLayoutParams(layoutParams2);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2183(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f1978.getLayoutParams();
        float f = i;
        layoutParams.width = (int) (0.62222224f * f);
        layoutParams.height = (int) ((f * 0.022222223f) + C4792.f16138);
        this.f1978.setLayoutParams(layoutParams);
        this.f1983 = i2;
        this.f1984 = layoutParams.height;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2184(String str, int i) {
        String str2;
        if (i == 0) {
            str2 = String.format("%s\n" + getResources().getString(R.string.RECORDING_INFO_GB), str);
        } else {
            str2 = String.format("%s\n" + getResources().getString(R.string.RECORDING_INFO_MIN), str);
        }
        if (this.f1986.equals(str2)) {
            return;
        }
        this.f1979.m2561(str2);
        this.f1986 = str2;
        this.f1979.setCustomText(str2);
        this.f1979.m2563();
        TextPaint paint = this.f1979.getPaint();
        paint.measureText(str2);
        paint.measureText(getResources().getString(R.string.RECORDING_INFO_MIN));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        this.f1982 = (int) ((fontMetrics.descent - fontMetrics.ascent) * 2.0f);
        m2182();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2185() {
        this.f1978.setContentColor(-1);
        setBackgroundColor(getResources().getColor(R.color.colorHalfBlack, null));
        this.f1977.setContentTextColor(-1);
        this.f1979.setContentTextColor(-1);
        this.f1977.setAlpha(1.0f);
        this.f1979.setAlpha(1.0f);
        this.f1977.setTypeface(FilmApp.m404());
        this.f1979.setTypeface(FilmApp.m404());
    }

    public BatteryStorageView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BatteryStorageView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1985 = "";
        this.f1986 = "";
        m2181();
    }
}
