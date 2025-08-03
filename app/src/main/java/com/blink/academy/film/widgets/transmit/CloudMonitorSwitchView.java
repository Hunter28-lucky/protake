package com.blink.academy.film.widgets.transmit;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.protake.R;
import defpackage.AbstractC4961;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.C5213;
import defpackage.r1;

/* loaded from: classes.dex */
public class CloudMonitorSwitchView extends ConstraintLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4961 f4233;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4234;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4235;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4236;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4237;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f4238;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f4239;

    /* renamed from: ֏, reason: contains not printable characters */
    public String f4240;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f4241;

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudMonitorSwitchView$Ϳ, reason: contains not printable characters */
    public class RunnableC1577 implements Runnable {
        public RunnableC1577() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = CloudMonitorSwitchView.this.f4233.f16685.getPaint().measureText(CloudMonitorSwitchView.this.f4238);
            ViewGroup.LayoutParams layoutParams = CloudMonitorSwitchView.this.f4233.f16685.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            CloudMonitorSwitchView.this.f4233.f16685.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudMonitorSwitchView$Ԩ, reason: contains not printable characters */
    public class RunnableC1578 implements Runnable {
        public RunnableC1578() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = CloudMonitorSwitchView.this.f4233.f16687.getPaint().measureText(CloudMonitorSwitchView.this.f4239);
            ViewGroup.LayoutParams layoutParams = CloudMonitorSwitchView.this.f4233.f16687.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            CloudMonitorSwitchView.this.f4233.f16687.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.CloudMonitorSwitchView$Ԫ, reason: contains not printable characters */
    public class RunnableC1579 implements Runnable {
        public RunnableC1579() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = CloudMonitorSwitchView.this.f4233.f16686.getPaint().measureText(CloudMonitorSwitchView.this.f4240);
            ViewGroup.LayoutParams layoutParams = CloudMonitorSwitchView.this.f4233.f16686.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138 + 10.0f);
            CloudMonitorSwitchView.this.f4233.f16686.setLayoutParams(layoutParams);
        }
    }

    public CloudMonitorSwitchView(@NonNull Context context) {
        this(context, null);
    }

    public int getLeftMarginOffset() {
        return this.f4241;
    }

    public int getViewHeight() {
        return this.f4235;
    }

    public int getViewWidth() {
        return this.f4236;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4218() {
        this.f4233 = AbstractC4961.m14736(LayoutInflater.from(getContext()), this, true);
        this.f4234 = getResources().getColor(R.color.colorTransmitBlue, null);
        m4219();
        m4221(0);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4219() {
        int iM14476 = C4792.m14375().m14476(75);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4233.f16683.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams).width = iM14476;
        this.f4233.f16683.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4233.f16684.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = iM14476;
        this.f4233.f16684.setLayoutParams(layoutParams2);
        this.f4233.f16687.setContentTypeFace(FilmApp.m403());
        this.f4233.f16685.setContentTypeFace(FilmApp.m403());
        this.f4233.f16686.setContentTypeFace(FilmApp.m403());
        this.f4233.f16685.m2562(0, C4792.m14375().m14396());
        this.f4233.f16687.m2562(0, C4792.m14375().m14394());
        this.f4233.f16686.m2562(0, C4792.m14375().m14394());
        TextPaint paint = this.f4233.f16685.getPaint();
        float fMeasureText = paint.measureText("WWWWWW") + C4792.f16138;
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4233.f16685.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = (int) (i + (r7 / 2) + ((((ViewGroup.MarginLayoutParams) layoutParams).height * 15.0f) / 60.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) fMeasureText;
        this.f4233.f16685.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4233.f16686.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = C2579.m9438(0.0f);
        this.f4233.f16686.setLayoutParams(layoutParams4);
        float fMeasureText2 = this.f4233.f16687.getPaint().measureText("Wi-Fi") + C4792.f16138;
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4233.f16687.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = iM14476;
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) fMeasureText2;
        this.f4233.f16687.setLayoutParams(layoutParams5);
        this.f4235 = (int) (((((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + paint.descent()) - paint.ascent()) + C4792.f16138);
        int i2 = ((ViewGroup.MarginLayoutParams) layoutParams3).width;
        this.f4236 = i2;
        int i3 = (i2 - ((ViewGroup.MarginLayoutParams) layoutParams).width) / 2;
        this.f4241 = i3;
        this.f4241 = Math.max(0, i3);
        this.f4233.f16686.setContentTextColor(-1);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4220() {
        if (r1.m8143(this.f4240)) {
            this.f4233.f16686.post(new RunnableC1579());
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4221(int i) {
        if (i == this.f4237) {
            return;
        }
        if (i == 1) {
            this.f4233.f16685.setContentTextColor(-1);
            this.f4233.f16687.setContentTextColor(-1);
            this.f4233.f16684.setVisibility(0);
            this.f4233.f16683.setVisibility(4);
            this.f4233.f16686.setVisibility(4);
            this.f4237 = 1;
            return;
        }
        this.f4233.f16685.setContentTextColor(this.f4234);
        this.f4233.f16687.setContentTextColor(this.f4234);
        this.f4233.f16684.setVisibility(4);
        this.f4233.f16683.setVisibility(0);
        this.f4233.f16686.setVisibility(0);
        this.f4237 = 0;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4222(String str, String str2, int i, String str3, String str4, String str5) {
        if (!this.f4238.equals(str)) {
            this.f4238 = str;
            if (str == null) {
                this.f4238 = "";
            }
            this.f4233.f16685.m2561(this.f4238);
            if (r1.m8143(this.f4238)) {
                this.f4233.f16685.post(new RunnableC1577());
            }
        }
        if (!this.f4239.equals(str2)) {
            this.f4239 = str2;
            if (str2 == null) {
                this.f4239 = "";
            }
            this.f4233.f16687.m2561(this.f4239);
            if (r1.m8143(this.f4239)) {
                this.f4233.f16687.post(new RunnableC1578());
            }
        }
        if (C5213.m15219()) {
            str3 = str5;
        } else if (C5213.m15210()) {
            str3 = str4;
        }
        String str6 = str3 != null ? str3 : "";
        if (str6.equals(this.f4240)) {
            return;
        }
        this.f4240 = str6;
        this.f4233.f16686.setContentTextColor(-1);
        this.f4233.f16686.m2561(str6);
        m4220();
    }

    public CloudMonitorSwitchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CloudMonitorSwitchView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4237 = -1;
        this.f4238 = "";
        this.f4239 = "";
        this.f4240 = "";
        m4218();
    }
}
