package com.blink.academy.film.widgets.setting;

import android.content.Context;
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
import defpackage.AbstractC4862;
import defpackage.C2579;
import defpackage.C3485;
import defpackage.C3641;
import defpackage.C3891;
import defpackage.C3947;
import defpackage.C4535;
import defpackage.C4792;

/* loaded from: classes.dex */
public class PortraitRecordSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4862 f3979;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1425 f3980;

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$Ϳ, reason: contains not printable characters */
    public class C1412 implements CompoundButton.OnCheckedChangeListener {
        public C1412() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12799(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1413 implements View.OnClickListener {
        public ViewOnClickListenerC1413() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitRecordSettingView.this.f3980 != null) {
                PortraitRecordSettingView.this.f3980.mo1734(24, null);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$Ԫ, reason: contains not printable characters */
    public class C1414 implements CompoundButton.OnCheckedChangeListener {
        public C1414() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                C4535.m13880().m13890().m12555(z ? 1 : 0);
                C4535.m13880().m13915();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1415 implements View.OnClickListener {
        public ViewOnClickListenerC1415() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitRecordSettingView.this.f3980 != null) {
                PortraitRecordSettingView.this.f3980.mo1734(32, null);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1416 implements View.OnClickListener {
        public ViewOnClickListenerC1416() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (50.0f != C3947.m12727().m12737()) {
                C3947.m12727().m12786(50.0f);
                PortraitRecordSettingView.this.m3989(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1417 implements View.OnClickListener {
        public ViewOnClickListenerC1417() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (60.0f != C3947.m12727().m12737()) {
                C3947.m12727().m12786(60.0f);
                PortraitRecordSettingView.this.m3989(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ֈ, reason: contains not printable characters */
    public class C1418 implements CompoundButton.OnCheckedChangeListener {
        public C1418() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12790(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$֏, reason: contains not printable characters */
    public class C1419 implements CompoundButton.OnCheckedChangeListener {
        public C1419() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12798(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ׯ, reason: contains not printable characters */
    public class C1420 implements CompoundButton.OnCheckedChangeListener {
        public C1420() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12794(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ؠ, reason: contains not printable characters */
    public class C1421 implements CompoundButton.OnCheckedChangeListener {
        public C1421() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12791(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ހ, reason: contains not printable characters */
    public class C1422 implements CompoundButton.OnCheckedChangeListener {
        public C1422() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (C4792.m14375().m14498() != z) {
                C4792.m14375().m14504(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ށ, reason: contains not printable characters */
    public class C1423 implements CompoundButton.OnCheckedChangeListener {
        public C1423() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12795(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ނ, reason: contains not printable characters */
    public class C1424 implements CompoundButton.OnCheckedChangeListener {
        public C1424() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C3947.m12727().m12796(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitRecordSettingView$ރ, reason: contains not printable characters */
    public interface InterfaceC1425 {
        /* renamed from: Ϳ */
        void mo1734(int i, C3891 c3891);
    }

    public PortraitRecordSettingView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnCallback(InterfaceC1425 interfaceC1425) {
        this.f3980 = interfaceC1425;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m3989(boolean z) {
        this.f3979.f16451.setVisibility(z ? 0 : 8);
        this.f3979.f16452.setVisibility(z ? 8 : 0);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m3990() {
        this.f3979 = AbstractC4862.m14585(LayoutInflater.from(getContext()), this, true);
        m3991();
        m3992();
        m3993();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m3991() {
        int iM9438 = C2579.m9438(50.0f);
        int iM94382 = C2579.m9438(18.0f);
        int iM94383 = C2579.m9438(12.0f);
        int iM94384 = C2579.m9438(15.0f);
        int iM94385 = C2579.m9438(35.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3979.f16420.getLayoutParams();
        layoutParams.topMargin = iM94385;
        layoutParams.height = iM9438;
        this.f3979.f16420.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3979.f16438.getLayoutParams();
        layoutParams2.leftMargin = iM94384;
        this.f3979.f16438.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3979.f16397.getLayoutParams();
        layoutParams3.rightMargin = iM94384;
        this.f3979.f16397.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3979.f16406.getLayoutParams();
        layoutParams4.leftMargin = iM94384;
        this.f3979.f16406.setLayoutParams(layoutParams4);
        float f = iM94382;
        this.f3979.f16438.setTextSize(0, f);
        this.f3979.f16438.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f3979.f16421.getLayoutParams();
        layoutParams5.height = iM9438;
        this.f3979.f16421.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3979.f16439.getLayoutParams();
        layoutParams6.leftMargin = iM94384;
        this.f3979.f16439.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f3979.f16398.getLayoutParams();
        layoutParams7.rightMargin = iM94384;
        this.f3979.f16398.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f3979.f16408.getLayoutParams();
        layoutParams8.leftMargin = iM94384;
        this.f3979.f16408.setLayoutParams(layoutParams8);
        this.f3979.f16439.setTextSize(0, f);
        this.f3979.f16439.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f3979.f16431.getLayoutParams();
        layoutParams9.height = iM9438;
        this.f3979.f16431.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f3979.f16450.getLayoutParams();
        layoutParams10.leftMargin = iM94384;
        this.f3979.f16450.setLayoutParams(layoutParams10);
        RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f3979.f16454.getLayoutParams();
        layoutParams11.rightMargin = iM94384;
        this.f3979.f16454.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f3979.f16453.getLayoutParams();
        layoutParams12.leftMargin = iM94384;
        this.f3979.f16453.setLayoutParams(layoutParams12);
        this.f3979.f16450.setTextSize(0, f);
        this.f3979.f16450.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) this.f3979.f16422.getLayoutParams();
        layoutParams13.height = iM9438;
        this.f3979.f16422.setLayoutParams(layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f3979.f16440.getLayoutParams();
        layoutParams14.leftMargin = iM94384;
        this.f3979.f16440.setLayoutParams(layoutParams14);
        RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.f3979.f16400.getLayoutParams();
        layoutParams15.rightMargin = iM94384;
        this.f3979.f16400.setLayoutParams(layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f3979.f16399.getLayoutParams();
        layoutParams16.leftMargin = iM94384;
        this.f3979.f16399.setLayoutParams(layoutParams16);
        this.f3979.f16440.setTextSize(0, f);
        this.f3979.f16440.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) this.f3979.f16430.getLayoutParams();
        layoutParams17.height = iM9438;
        this.f3979.f16430.setLayoutParams(layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f3979.f16449.getLayoutParams();
        layoutParams18.leftMargin = iM94384;
        this.f3979.f16449.setLayoutParams(layoutParams18);
        RelativeLayout.LayoutParams layoutParams19 = (RelativeLayout.LayoutParams) this.f3979.f16437.getLayoutParams();
        layoutParams19.rightMargin = iM94384;
        this.f3979.f16437.setLayoutParams(layoutParams19);
        RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f3979.f16405.getLayoutParams();
        layoutParams20.height = C2579.m9438(15.0f);
        layoutParams20.width = C2579.m9438(15.0f);
        layoutParams20.leftMargin = C2579.m9438(10.0f);
        this.f3979.f16405.setLayoutParams(layoutParams20);
        RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) this.f3979.f16436.getLayoutParams();
        layoutParams21.height = C2579.m9438(44.0f);
        int iM94386 = C2579.m9438(44.0f);
        layoutParams21.width = iM94386;
        layoutParams21.leftMargin = layoutParams20.leftMargin - ((iM94386 - layoutParams20.width) / 2);
        this.f3979.f16436.setLayoutParams(layoutParams21);
        RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.f3979.f16435.getLayoutParams();
        layoutParams22.leftMargin = iM94384;
        this.f3979.f16435.setLayoutParams(layoutParams22);
        this.f3979.f16449.setTextSize(0, f);
        this.f3979.f16449.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams23 = (LinearLayout.LayoutParams) this.f3979.f16427.getLayoutParams();
        layoutParams23.height = iM9438;
        this.f3979.f16427.setLayoutParams(layoutParams23);
        RelativeLayout.LayoutParams layoutParams24 = (RelativeLayout.LayoutParams) this.f3979.f16446.getLayoutParams();
        layoutParams24.leftMargin = iM94384;
        this.f3979.f16446.setLayoutParams(layoutParams24);
        RelativeLayout.LayoutParams layoutParams25 = (RelativeLayout.LayoutParams) this.f3979.f16418.getLayoutParams();
        layoutParams25.rightMargin = iM94384;
        this.f3979.f16418.setLayoutParams(layoutParams25);
        RelativeLayout.LayoutParams layoutParams26 = (RelativeLayout.LayoutParams) this.f3979.f16417.getLayoutParams();
        layoutParams26.leftMargin = iM94384;
        this.f3979.f16417.setLayoutParams(layoutParams26);
        this.f3979.f16446.setTextSize(0, f);
        this.f3979.f16446.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams27 = (LinearLayout.LayoutParams) this.f3979.f16429.getLayoutParams();
        layoutParams27.height = iM9438;
        this.f3979.f16429.setLayoutParams(layoutParams27);
        RelativeLayout.LayoutParams layoutParams28 = (RelativeLayout.LayoutParams) this.f3979.f16448.getLayoutParams();
        layoutParams28.leftMargin = iM94384;
        this.f3979.f16448.setLayoutParams(layoutParams28);
        RelativeLayout.LayoutParams layoutParams29 = (RelativeLayout.LayoutParams) this.f3979.f16434.getLayoutParams();
        layoutParams29.rightMargin = iM94384;
        this.f3979.f16434.setLayoutParams(layoutParams29);
        this.f3979.f16448.setTextSize(0, f);
        this.f3979.f16448.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams30 = (LinearLayout.LayoutParams) this.f3979.f16428.getLayoutParams();
        layoutParams30.topMargin = iM94385;
        layoutParams30.height = iM9438;
        this.f3979.f16428.setLayoutParams(layoutParams30);
        RelativeLayout.LayoutParams layoutParams31 = (RelativeLayout.LayoutParams) this.f3979.f16447.getLayoutParams();
        layoutParams31.leftMargin = iM94384;
        this.f3979.f16447.setLayoutParams(layoutParams31);
        RelativeLayout.LayoutParams layoutParams32 = (RelativeLayout.LayoutParams) this.f3979.f16432.getLayoutParams();
        layoutParams32.rightMargin = iM94384;
        this.f3979.f16432.setLayoutParams(layoutParams32);
        this.f3979.f16447.setTextSize(0, f);
        this.f3979.f16447.setTypeface(FilmApp.m404());
        RelativeLayout.LayoutParams layoutParams33 = (RelativeLayout.LayoutParams) this.f3979.f16419.getLayoutParams();
        layoutParams33.width = C2579.m9438(6.0f);
        layoutParams33.height = C2579.m9438(6.0f);
        layoutParams33.leftMargin = C4792.m14375().m14476(15);
        layoutParams33.topMargin = (int) ((iM9438 - layoutParams33.height) / 2.0f);
        this.f3979.f16419.setLayoutParams(layoutParams33);
        LinearLayout.LayoutParams layoutParams34 = (LinearLayout.LayoutParams) this.f3979.f16442.getLayoutParams();
        layoutParams34.leftMargin = iM94384;
        layoutParams34.topMargin = iM94385;
        this.f3979.f16442.setLayoutParams(layoutParams34);
        this.f3979.f16442.setTextSize(0, iM94383);
        this.f3979.f16442.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams35 = (LinearLayout.LayoutParams) this.f3979.f16424.getLayoutParams();
        layoutParams35.topMargin = C2579.m9438(5.0f);
        layoutParams35.height = iM9438;
        this.f3979.f16424.setLayoutParams(layoutParams35);
        RelativeLayout.LayoutParams layoutParams36 = (RelativeLayout.LayoutParams) this.f3979.f16443.getLayoutParams();
        layoutParams36.leftMargin = iM94384;
        this.f3979.f16443.setLayoutParams(layoutParams36);
        RelativeLayout.LayoutParams layoutParams37 = (RelativeLayout.LayoutParams) this.f3979.f16451.getLayoutParams();
        layoutParams37.rightMargin = iM94384;
        layoutParams37.width = C4792.m14375().m14448();
        layoutParams37.height = C4792.m14375().m14448();
        this.f3979.f16451.setLayoutParams(layoutParams37);
        RelativeLayout.LayoutParams layoutParams38 = (RelativeLayout.LayoutParams) this.f3979.f16409.getLayoutParams();
        layoutParams38.leftMargin = iM94384;
        this.f3979.f16409.setLayoutParams(layoutParams38);
        this.f3979.f16443.setTextSize(0, f);
        this.f3979.f16443.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams39 = (LinearLayout.LayoutParams) this.f3979.f16425.getLayoutParams();
        layoutParams39.height = iM9438;
        this.f3979.f16425.setLayoutParams(layoutParams39);
        RelativeLayout.LayoutParams layoutParams40 = (RelativeLayout.LayoutParams) this.f3979.f16444.getLayoutParams();
        layoutParams40.leftMargin = iM94384;
        this.f3979.f16444.setLayoutParams(layoutParams40);
        RelativeLayout.LayoutParams layoutParams41 = (RelativeLayout.LayoutParams) this.f3979.f16452.getLayoutParams();
        layoutParams41.rightMargin = iM94384;
        layoutParams41.width = C4792.m14375().m14448();
        layoutParams41.height = C4792.m14375().m14448();
        this.f3979.f16452.setLayoutParams(layoutParams41);
        this.f3979.f16444.setTextSize(0, f);
        this.f3979.f16444.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams42 = (LinearLayout.LayoutParams) this.f3979.f16426.getLayoutParams();
        layoutParams42.topMargin = iM94385;
        layoutParams42.bottomMargin = iM94385;
        layoutParams42.height = iM9438;
        this.f3979.f16426.setLayoutParams(layoutParams42);
        RelativeLayout.LayoutParams layoutParams43 = (RelativeLayout.LayoutParams) this.f3979.f16445.getLayoutParams();
        layoutParams43.leftMargin = iM94384;
        this.f3979.f16445.setLayoutParams(layoutParams43);
        RelativeLayout.LayoutParams layoutParams44 = (RelativeLayout.LayoutParams) this.f3979.f16416.getLayoutParams();
        layoutParams44.rightMargin = iM94384;
        this.f3979.f16416.setLayoutParams(layoutParams44);
        this.f3979.f16445.setTextSize(0, f);
        this.f3979.f16445.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams45 = (LinearLayout.LayoutParams) this.f3979.f16423.getLayoutParams();
        layoutParams45.bottomMargin = iM94385;
        layoutParams45.height = iM9438;
        this.f3979.f16423.setLayoutParams(layoutParams45);
        RelativeLayout.LayoutParams layoutParams46 = (RelativeLayout.LayoutParams) this.f3979.f16441.getLayoutParams();
        layoutParams46.leftMargin = iM94384;
        this.f3979.f16441.setLayoutParams(layoutParams46);
        RelativeLayout.LayoutParams layoutParams47 = (RelativeLayout.LayoutParams) this.f3979.f16403.getLayoutParams();
        layoutParams47.rightMargin = iM94384;
        this.f3979.f16403.setLayoutParams(layoutParams47);
        RelativeLayout.LayoutParams layoutParams48 = (RelativeLayout.LayoutParams) this.f3979.f16404.getLayoutParams();
        layoutParams48.height = C2579.m9438(15.0f);
        layoutParams48.width = C2579.m9438(15.0f);
        layoutParams48.leftMargin = C2579.m9438(10.0f);
        this.f3979.f16404.setLayoutParams(layoutParams48);
        RelativeLayout.LayoutParams layoutParams49 = (RelativeLayout.LayoutParams) this.f3979.f16402.getLayoutParams();
        layoutParams49.height = C2579.m9438(44.0f);
        int iM94387 = C2579.m9438(44.0f);
        layoutParams49.width = iM94387;
        layoutParams49.leftMargin = layoutParams48.leftMargin - ((iM94387 - layoutParams48.width) / 2);
        this.f3979.f16402.setLayoutParams(layoutParams49);
        this.f3979.f16441.setTextSize(0, f);
        this.f3979.f16441.setTypeface(FilmApp.m404());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m3992() {
        this.f3979.f16424.setOnClickListener(new ViewOnClickListenerC1416());
        this.f3979.f16425.setOnClickListener(new ViewOnClickListenerC1417());
        this.f3979.f16434.setOnCheckedChangeListener(new C1418());
        this.f3979.f16437.setOnCheckedChangeListener(new C1419());
        this.f3979.f16418.setOnCheckedChangeListener(new C1420());
        this.f3979.f16400.setOnCheckedChangeListener(new C1421());
        this.f3979.f16432.setOnCheckedChangeListener(new C1422());
        this.f3979.f16397.setOnCheckedChangeListener(new C1423());
        this.f3979.f16398.setOnCheckedChangeListener(new C1424());
        this.f3979.f16454.setOnCheckedChangeListener(new C1412());
        this.f3979.f16436.setOnClickListener(new ViewOnClickListenerC1413());
        this.f3979.f16416.setOnCheckedChangeListener(new C1414());
        this.f3979.f16402.setOnClickListener(new ViewOnClickListenerC1415());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m3993() {
        m3989(C3947.m12727().m12737() == 50.0f);
        this.f3979.f16400.setChecked(C3947.m12727().m12768() == 1);
        this.f3979.f16432.setChecked(C4792.m14375().m14498());
        this.f3979.f16397.setChecked(C3947.m12727().m12758() == 1);
        this.f3979.f16398.setChecked(C3947.m12727().m12759() == 1);
        this.f3979.f16454.setChecked(C3947.m12727().m12761() == 1);
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890.m12460() == 1) {
            this.f3979.f16416.setChecked(false);
            this.f3979.f16416.setAlpha(0.3f);
            this.f3979.f16416.setEnabled(false);
        } else {
            this.f3979.f16416.setAlpha(1.0f);
            this.f3979.f16416.setEnabled(true);
            this.f3979.f16416.setChecked(c3891M13890.m12443() == 1);
        }
        C3485 c3485M11722 = C3641.m11713(null).m11722(c3891M13890.m12495() ? c3891M13890.m12399() : c3891M13890.m12380());
        if (c3485M11722 == null) {
            this.f3979.f16434.setAlpha(1.0f);
            this.f3979.f16434.setEnabled(true);
            this.f3979.f16418.setAlpha(1.0f);
            this.f3979.f16418.setEnabled(true);
            this.f3979.f16437.setAlpha(1.0f);
            this.f3979.f16437.setEnabled(true);
            this.f3979.f16434.setChecked(C3947.m12727().m12766() == 1);
            this.f3979.f16418.setChecked(C3947.m12727().m12770() == 1);
            this.f3979.f16437.setChecked(C3947.m12727().m12771() == 1);
            return;
        }
        if (c3485M11722.m11382()) {
            this.f3979.f16434.setAlpha(1.0f);
            this.f3979.f16434.setEnabled(true);
            this.f3979.f16434.setChecked(C3947.m12727().m12766() == 1);
        } else {
            this.f3979.f16434.setChecked(false);
            this.f3979.f16434.setEnabled(false);
            this.f3979.f16434.setAlpha(0.3f);
        }
        if (c3485M11722.m11388()) {
            this.f3979.f16418.setAlpha(1.0f);
            this.f3979.f16418.setEnabled(true);
            this.f3979.f16418.setChecked(C3947.m12727().m12770() == 1);
        } else {
            this.f3979.f16418.setChecked(false);
            this.f3979.f16418.setEnabled(false);
            this.f3979.f16418.setAlpha(0.3f);
        }
        if (c3485M11722.m11390()) {
            this.f3979.f16437.setAlpha(1.0f);
            this.f3979.f16437.setEnabled(true);
            this.f3979.f16437.setChecked(C3947.m12727().m12771() == 1);
        } else {
            this.f3979.f16437.setChecked(false);
            this.f3979.f16437.setEnabled(false);
            this.f3979.f16437.setAlpha(0.3f);
        }
    }

    public PortraitRecordSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitRecordSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3990();
    }
}
