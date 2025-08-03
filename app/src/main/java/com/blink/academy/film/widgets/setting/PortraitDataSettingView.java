package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.widgets.setting.PortraitDataSettingView;
import com.blink.academy.film.widgets.setting.RecordSettingView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4324;
import defpackage.C2462;
import defpackage.C2579;
import defpackage.C2813;
import defpackage.C4112;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.C5125;
import defpackage.InterfaceC2539;
import defpackage.InterfaceC3632;
import defpackage.InterfaceC5285;
import defpackage.ViewOnClickListenerC4235;
import java.util.List;

/* loaded from: classes.dex */
public class PortraitDataSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4324 f3953;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ViewOnClickListenerC4235 f3954;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ViewOnClickListenerC4235 f3955;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f3956;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3957;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3958;

    /* renamed from: ֈ, reason: contains not printable characters */
    public List<String> f3959;

    /* renamed from: ֏, reason: contains not printable characters */
    public List<String> f3960;

    /* renamed from: ׯ, reason: contains not printable characters */
    public RecordSettingView.InterfaceC1508 f3961;

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1399 implements View.OnClickListener {
        public ViewOnClickListenerC1399() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitDataSettingView.this.m3962()) {
                PortraitDataSettingView.this.f3953.f14821.setVisibility(8);
                PortraitDataSettingView.this.f3953.f14820.setChecked(true);
            } else if (PortraitDataSettingView.this.f3961 != null) {
                PortraitDataSettingView.this.f3961.mo1736();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$Ԩ, reason: contains not printable characters */
    public class C1400 implements CompoundButton.OnCheckedChangeListener {
        public C1400() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C4535.m13880().m13890().m12551(z ? 1 : 0);
            C4535.m13880().m13915();
            PortraitDataSettingView.this.m3970();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$Ԫ, reason: contains not printable characters */
    public class C1401 implements InterfaceC3632 {
        public C1401() {
        }

        @Override // defpackage.InterfaceC3632
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3975(int i, int i2, int i3) {
            PortraitDataSettingView.this.f3958 = i;
            PortraitDataSettingView.this.f3953.f14841.setText((CharSequence) PortraitDataSettingView.this.f3960.get(PortraitDataSettingView.this.f3958));
            PortraitDataSettingView.this.m3974();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$Ԭ, reason: contains not printable characters */
    public class C1402 implements InterfaceC5285 {
        public C1402() {
        }

        @Override // defpackage.InterfaceC5285
        /* renamed from: Ϳ */
        public void mo3091(int i, int i2, int i3, View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$Ԯ, reason: contains not printable characters */
    public class C1403 implements InterfaceC3632 {
        public C1403() {
        }

        @Override // defpackage.InterfaceC3632
        /* renamed from: Ϳ */
        public void mo3975(int i, int i2, int i3) {
            C4638.m14099("sllllll", "" + i + MyUTIL.white_space + i2 + MyUTIL.white_space + i3);
            PortraitDataSettingView.this.f3957 = i;
            PortraitDataSettingView.this.f3953.f14843.setText((CharSequence) PortraitDataSettingView.this.f3959.get(PortraitDataSettingView.this.f3957));
            PortraitDataSettingView.this.m3974();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$ՠ, reason: contains not printable characters */
    public class C1404 implements InterfaceC5285 {
        public C1404() {
        }

        @Override // defpackage.InterfaceC5285
        /* renamed from: Ϳ */
        public void mo3091(int i, int i2, int i3, View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1405 implements View.OnClickListener {
        public ViewOnClickListenerC1405() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitDataSettingView.this.m3973();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1406 implements View.OnClickListener {
        public ViewOnClickListenerC1406() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PortraitDataSettingView.this.m3972();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1407 implements View.OnClickListener {
        public ViewOnClickListenerC1407() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitDataSettingView.this.f3961 != null) {
                PortraitDataSettingView.this.f3961.mo1735();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1408 implements View.OnClickListener {
        public ViewOnClickListenerC1408() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitDataSettingView.this.f3953.f14844.getVisibility() != 0) {
                PortraitDataSettingView.this.m3961(true);
                C4535.m13880().m13890().m12343(0);
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitDataSettingView$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC1409 implements View.OnClickListener {
        public ViewOnClickListenerC1409() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitDataSettingView.this.f3953.f14845.getVisibility() != 0) {
                PortraitDataSettingView.this.m3961(false);
                C4535.m13880().m13890().m12343(1);
                C4535.m13880().m13915();
            }
        }
    }

    public PortraitDataSettingView(@NonNull Context context) {
        this(context, null);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static /* synthetic */ void m3959(View view) {
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static /* synthetic */ void m3960(View view) {
    }

    public void setOnButtonClick(RecordSettingView.InterfaceC1508 interfaceC1508) {
        this.f3961 = interfaceC1508;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m3961(boolean z) {
        if (z) {
            this.f3953.f14844.setVisibility(0);
            this.f3953.f14845.setVisibility(8);
        } else {
            this.f3953.f14844.setVisibility(8);
            this.f3953.f14845.setVisibility(0);
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final boolean m3962() {
        return C4112.m13054();
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m3963() {
        C2462.m9035().m9065();
        C4535.m13880().m13890().m12524(1001);
        C4535.m13880().m13915();
        m3971();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m3964() {
        this.f3953 = AbstractC4324.m13468(LayoutInflater.from(getContext()), this, true);
        m3965();
        m3966();
        m3971();
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m3965() {
        int iM9438 = C2579.m9438(50.0f);
        int iM94382 = C2579.m9438(18.0f);
        int iM94383 = C2579.m9438(12.0f);
        int iM94384 = C2579.m9438(15.0f);
        int iM94385 = C2579.m9438(35.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3953.f14829.getLayoutParams();
        layoutParams.topMargin = iM94385;
        layoutParams.height = iM9438;
        this.f3953.f14829.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3953.f14837.getLayoutParams();
        layoutParams2.leftMargin = iM94384;
        this.f3953.f14837.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3953.f14843.getLayoutParams();
        int i = iM94384 / 2;
        layoutParams3.rightMargin = i;
        this.f3953.f14843.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3953.f14809.getLayoutParams();
        layoutParams4.width = C2579.m9438(15.0f);
        layoutParams4.height = C2579.m9438(15.0f);
        layoutParams4.rightMargin = iM94384;
        this.f3953.f14809.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3953.f14818.getLayoutParams();
        layoutParams5.leftMargin = iM94384;
        this.f3953.f14818.setLayoutParams(layoutParams5);
        float f = iM94382;
        this.f3953.f14843.setTextSize(0, f);
        this.f3953.f14843.setTypeface(FilmApp.m404());
        this.f3953.f14837.setTypeface(FilmApp.m404());
        this.f3953.f14837.setTextSize(0, f);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f3953.f14826.getLayoutParams();
        layoutParams6.height = iM9438;
        this.f3953.f14826.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f3953.f14834.getLayoutParams();
        layoutParams7.leftMargin = iM94384;
        this.f3953.f14834.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f3953.f14841.getLayoutParams();
        layoutParams8.rightMargin = i;
        this.f3953.f14841.setLayoutParams(layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f3953.f14808.getLayoutParams();
        layoutParams9.width = C2579.m9438(15.0f);
        layoutParams9.height = C2579.m9438(15.0f);
        layoutParams9.rightMargin = iM94384;
        this.f3953.f14808.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f3953.f14816.getLayoutParams();
        layoutParams10.leftMargin = iM94384;
        this.f3953.f14816.setLayoutParams(layoutParams10);
        this.f3953.f14841.setTextSize(0, f);
        this.f3953.f14841.setTypeface(FilmApp.m404());
        this.f3953.f14834.setTypeface(FilmApp.m404());
        this.f3953.f14834.setTextSize(0, f);
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.f3953.f14824.getLayoutParams();
        layoutParams11.height = iM9438;
        this.f3953.f14824.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f3953.f14833.getLayoutParams();
        layoutParams12.leftMargin = iM94384;
        this.f3953.f14833.setLayoutParams(layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f3953.f14838.getLayoutParams();
        layoutParams13.rightMargin = iM94384;
        this.f3953.f14838.setLayoutParams(layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f3953.f14813.getLayoutParams();
        layoutParams14.leftMargin = iM94384;
        this.f3953.f14816.setLayoutParams(layoutParams14);
        this.f3953.f14838.setTextSize(0, f);
        this.f3953.f14838.setTypeface(FilmApp.m404());
        this.f3953.f14833.setTypeface(FilmApp.m404());
        this.f3953.f14833.setTextSize(0, f);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.f3953.f14828.getLayoutParams();
        layoutParams15.height = iM9438;
        this.f3953.f14828.setLayoutParams(layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f3953.f14836.getLayoutParams();
        layoutParams16.leftMargin = iM94384;
        this.f3953.f14836.setLayoutParams(layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f3953.f14842.getLayoutParams();
        layoutParams17.rightMargin = iM94384;
        this.f3953.f14842.setLayoutParams(layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f3953.f14817.getLayoutParams();
        layoutParams18.leftMargin = iM94384;
        this.f3953.f14817.setLayoutParams(layoutParams18);
        this.f3953.f14842.setTextSize(0, f);
        this.f3953.f14842.setTypeface(FilmApp.m404());
        this.f3953.f14836.setTypeface(FilmApp.m404());
        this.f3953.f14836.setTextSize(0, f);
        LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) this.f3953.f14827.getLayoutParams();
        layoutParams19.height = iM9438;
        this.f3953.f14827.setLayoutParams(layoutParams19);
        RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f3953.f14835.getLayoutParams();
        layoutParams20.leftMargin = iM94384;
        this.f3953.f14835.setLayoutParams(layoutParams20);
        this.f3953.f14835.setTypeface(FilmApp.m404());
        this.f3953.f14835.setTextSize(0, f);
        LinearLayout.LayoutParams layoutParams21 = (LinearLayout.LayoutParams) this.f3953.f14839.getLayoutParams();
        layoutParams21.leftMargin = iM94384;
        layoutParams21.topMargin = iM94385;
        this.f3953.f14839.setLayoutParams(layoutParams21);
        this.f3953.f14839.setTextSize(0, iM94383);
        this.f3953.f14839.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) this.f3953.f14822.getLayoutParams();
        layoutParams22.topMargin = C2579.m9438(5.0f);
        layoutParams22.height = iM9438;
        this.f3953.f14822.setLayoutParams(layoutParams22);
        RelativeLayout.LayoutParams layoutParams23 = (RelativeLayout.LayoutParams) this.f3953.f14831.getLayoutParams();
        layoutParams23.leftMargin = iM94384;
        this.f3953.f14831.setLayoutParams(layoutParams23);
        RelativeLayout.LayoutParams layoutParams24 = (RelativeLayout.LayoutParams) this.f3953.f14844.getLayoutParams();
        layoutParams24.rightMargin = iM94384;
        layoutParams24.width = C4792.m14375().m14448();
        layoutParams24.height = C4792.m14375().m14448();
        this.f3953.f14844.setLayoutParams(layoutParams24);
        RelativeLayout.LayoutParams layoutParams25 = (RelativeLayout.LayoutParams) this.f3953.f14810.getLayoutParams();
        layoutParams25.leftMargin = iM94384;
        this.f3953.f14810.setLayoutParams(layoutParams25);
        this.f3953.f14831.setTextSize(0, f);
        this.f3953.f14831.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams26 = (LinearLayout.LayoutParams) this.f3953.f14823.getLayoutParams();
        layoutParams26.height = iM9438;
        this.f3953.f14823.setLayoutParams(layoutParams26);
        RelativeLayout.LayoutParams layoutParams27 = (RelativeLayout.LayoutParams) this.f3953.f14832.getLayoutParams();
        layoutParams27.leftMargin = iM94384;
        this.f3953.f14832.setLayoutParams(layoutParams27);
        RelativeLayout.LayoutParams layoutParams28 = (RelativeLayout.LayoutParams) this.f3953.f14845.getLayoutParams();
        layoutParams28.rightMargin = iM94384;
        layoutParams28.width = C4792.m14375().m14448();
        layoutParams28.height = C4792.m14375().m14448();
        this.f3953.f14845.setLayoutParams(layoutParams28);
        this.f3953.f14832.setTextSize(0, f);
        this.f3953.f14832.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams29 = (LinearLayout.LayoutParams) this.f3953.f14825.getLayoutParams();
        layoutParams29.topMargin = iM94385;
        layoutParams29.height = iM9438;
        this.f3953.f14825.setLayoutParams(layoutParams29);
        RelativeLayout.LayoutParams layoutParams30 = (RelativeLayout.LayoutParams) this.f3953.f14840.getLayoutParams();
        layoutParams30.leftMargin = iM94384;
        this.f3953.f14840.setLayoutParams(layoutParams30);
        RelativeLayout.LayoutParams layoutParams31 = (RelativeLayout.LayoutParams) this.f3953.f14820.getLayoutParams();
        layoutParams31.rightMargin = iM94384;
        this.f3953.f14820.setLayoutParams(layoutParams31);
        this.f3953.f14840.setTextSize(0, f);
        this.f3953.f14840.setTypeface(FilmApp.m404());
        RelativeLayout.LayoutParams layoutParams32 = (RelativeLayout.LayoutParams) this.f3953.f14821.getLayoutParams();
        layoutParams32.width = iM9438;
        layoutParams32.height = iM9438;
        layoutParams32.rightMargin = layoutParams31.rightMargin;
        this.f3953.f14821.setLayoutParams(layoutParams32);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m3966() {
        this.f3953.f14829.setOnClickListener(new ViewOnClickListenerC1405());
        this.f3953.f14826.setOnClickListener(new ViewOnClickListenerC1406());
        this.f3953.f14827.setOnClickListener(new ViewOnClickListenerC1407());
        this.f3953.f14822.setOnClickListener(new ViewOnClickListenerC1408());
        this.f3953.f14823.setOnClickListener(new ViewOnClickListenerC1409());
        this.f3953.f14821.setOnClickListener(new ViewOnClickListenerC1399());
        this.f3953.f14820.setOnCheckedChangeListener(new C1400());
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m3967() {
        m3969();
        m3968();
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final void m3968() {
        if (this.f3955 != null) {
            return;
        }
        ViewOnClickListenerC4235 viewOnClickListenerC4235M15032 = new C5125(getContext(), new C1402()).m15040(R.layout.area_picker_content, new InterfaceC2539() { // from class: ૱
            @Override // defpackage.InterfaceC2539
            /* renamed from: Ϳ */
            public final void mo9357(View view) {
                PortraitDataSettingView.m3959(view);
            }
        }).m15041(new C1401()).m15039(0).m15037(15).m15035(Color.parseColor("#161616")).m15042(-1).m15043(C4792.m14375().m14450()).m15036(C4792.m14375().m14450()).m15033(false).m15038(this.f3953.f14830).m15034(Color.parseColor("#80000000")).m15032();
        this.f3955 = viewOnClickListenerC4235M15032;
        viewOnClickListenerC4235M15032.m13337(this.f3960);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final void m3969() {
        if (this.f3954 != null) {
            return;
        }
        ViewOnClickListenerC4235 viewOnClickListenerC4235M15032 = new C5125(getContext(), new C1404()).m15040(R.layout.area_picker_content, new InterfaceC2539() { // from class: ఫ
            @Override // defpackage.InterfaceC2539
            /* renamed from: Ϳ */
            public final void mo9357(View view) {
                PortraitDataSettingView.m3960(view);
            }
        }).m15041(new C1403()).m15039(0).m15037(15).m15035(Color.parseColor("#161616")).m15042(-1).m15043(C4792.m14375().m14450()).m15036(C4792.m14375().m14450()).m15038(this.f3953.f14830).m15033(false).m15034(Color.parseColor("#80000000")).m15032();
        this.f3954 = viewOnClickListenerC4235M15032;
        viewOnClickListenerC4235M15032.m13337(this.f3959);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m3970() {
        if (m3962() && C4535.m13880().m13890().m12437() == 1) {
            this.f3953.f14820.setChecked(true);
            this.f3953.f14821.setVisibility(8);
        } else {
            this.f3953.f14820.setChecked(false);
            this.f3953.f14821.setVisibility(0);
        }
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m3971() {
        this.f3956 = C2813.f10275;
        this.f3959 = C2462.m9035().m9040();
        this.f3960 = C2462.m9035().m9058();
        m3967();
        int iM12408 = C4535.m13880().m13890().m12408();
        int i = iM12408 / 1000;
        int i2 = i - 1;
        this.f3957 = i2;
        this.f3958 = (iM12408 - (i * 1000)) - 1;
        this.f3953.f14843.setText(this.f3959.get(i2));
        this.f3953.f14841.setText(this.f3960.get(this.f3958));
        this.f3953.f14842.setText(C2462.m9035().m9064());
        m3961(C4535.m13880().m13890().m12478() == 0);
        if (this.f3956) {
            this.f3953.f14839.setVisibility(0);
            this.f3953.f14822.setVisibility(0);
            this.f3953.f14823.setVisibility(0);
        } else {
            this.f3953.f14839.setVisibility(8);
            this.f3953.f14822.setVisibility(8);
            this.f3953.f14823.setVisibility(8);
        }
        m3974();
        m3970();
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m3972() {
        if (this.f3955.m15109()) {
            return;
        }
        this.f3955.m13336(this.f3958);
        this.f3955.m15115();
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final void m3973() {
        if (this.f3954.m15109()) {
            return;
        }
        this.f3954.m13336(this.f3957);
        this.f3954.m15115();
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final void m3974() {
        int i = ((this.f3957 + 1) * 1000) + this.f3958 + 1;
        this.f3953.f14838.setText(C2462.m9035().m9042(i));
        C4535.m13880().m13890().m12524(i);
        C4535.m13880().m13915();
        if (C2462.m9035().m9037()) {
            this.f3953.f14838.setText(C2462.m9035().m9042(i));
        }
    }

    public PortraitDataSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitDataSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3964();
    }
}
