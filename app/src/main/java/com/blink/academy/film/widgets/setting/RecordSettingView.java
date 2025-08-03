package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC4876;
import defpackage.C2579;
import defpackage.C2813;
import defpackage.C3444;
import defpackage.C3485;
import defpackage.C3641;
import defpackage.C3891;
import defpackage.C3947;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.v5;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RecordSettingView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4876 f4066;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4067;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4068;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f4069;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4070;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC1508 f4071;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC1509 f4072;

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$Ϳ, reason: contains not printable characters */
    public class C1472 implements SwitchButton.InterfaceC0969 {
        public C1472() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C4792.m14375().m14504(!C4792.m14375().m14498());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1473 implements View.OnClickListener {
        public ViewOnClickListenerC1473() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4071 != null) {
                RecordSettingView.this.f4071.mo1736();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1474 implements View.OnClickListener {
        public ViewOnClickListenerC1474() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16475.m2574()) {
                return;
            }
            RecordSettingView.this.f4070 = 0;
            RecordSettingView.this.m4072(100);
            C4535.m13880().m13890().m12550(RecordSettingView.this.f4070);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1475 implements View.OnClickListener {
        public ViewOnClickListenerC1475() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16477.m2574()) {
                return;
            }
            RecordSettingView.this.f4070 = 1;
            RecordSettingView.this.m4072(100);
            C4535.m13880().m13890().m12550(RecordSettingView.this.f4070);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1476 implements View.OnClickListener {
        public ViewOnClickListenerC1476() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16478.m2574()) {
                return;
            }
            RecordSettingView.this.f4070 = 2;
            RecordSettingView.this.m4072(100);
            C4535.m13880().m13890().m12550(RecordSettingView.this.f4070);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1477 implements View.OnClickListener {
        public ViewOnClickListenerC1477() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16476.m2574()) {
                return;
            }
            RecordSettingView.this.f4070 = 3;
            RecordSettingView.this.m4072(100);
            C4535.m13880().m13890().m12550(RecordSettingView.this.f4070);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ֈ, reason: contains not printable characters */
    public class C1478 implements SwitchButton.InterfaceC0969 {
        public C1478() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12795(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$֏, reason: contains not printable characters */
    public class C1479 implements SwitchButton.InterfaceC0969 {
        public C1479() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12796(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ׯ, reason: contains not printable characters */
    public class C1480 implements SwitchButton.InterfaceC0969 {
        public C1480() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12778(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ؠ, reason: contains not printable characters */
    public class C1481 implements SwitchButton.InterfaceC0969 {
        public C1481() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12799(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC1482 implements View.OnClickListener {
        public ViewOnClickListenerC1482() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16468.m2574()) {
                return;
            }
            C3947.m12727().m12786(50.0f);
            RecordSettingView.this.m4070(true, 100);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1483 implements View.OnClickListener {
        public ViewOnClickListenerC1483() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4072 != null) {
                RecordSettingView.this.f4072.mo4052();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ނ, reason: contains not printable characters */
    public class C1484 implements SwitchButton.InterfaceC0969 {
        public C1484() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C4535.m13880().m13890().m12555(z ? 1 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ރ, reason: contains not printable characters */
    public class RunnableC1485 implements Runnable {
        public RunnableC1485() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16501.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_TITLE_ORIENTATION_VERTICAL).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16501.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16501.setLayoutParams(layoutParams);
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) RecordSettingView.this.f4066.f16479.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = C4792.m14375().m14476(15);
            ((ViewGroup.MarginLayoutParams) layoutParams2).height = C4792.m14375().m14476(15);
            ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = layoutParams.width + C4792.m14375().m14476(15);
            RecordSettingView.this.f4066.f16479.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ބ, reason: contains not printable characters */
    public class RunnableC1486 implements Runnable {
        public RunnableC1486() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16493.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_FRAMEDROP_NOTICE).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16493.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16493.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޅ, reason: contains not printable characters */
    public class RunnableC1487 implements Runnable {
        public RunnableC1487() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16492.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_FLICKER_REDUCTION).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16492.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16492.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ކ, reason: contains not printable characters */
    public class RunnableC1488 implements Runnable {
        public RunnableC1488() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16500.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_STABILIZATION).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16500.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16500.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$އ, reason: contains not printable characters */
    public class RunnableC1489 implements Runnable {
        public RunnableC1489() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16497.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_NOISE_REDUCTION).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16497.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16497.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ވ, reason: contains not printable characters */
    public class RunnableC1490 implements Runnable {
        public RunnableC1490() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16494.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_RECORDING_FRAMEWORK).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16494.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16494.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$މ, reason: contains not printable characters */
    public class RunnableC1491 implements Runnable {
        public RunnableC1491() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16491.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_EDGE_SHARPENING).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16491.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16491.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ފ, reason: contains not printable characters */
    public class RunnableC1492 implements Runnable {
        public RunnableC1492() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            float fMeasureText = RecordSettingView.this.f4066.f16495.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_LEICA_COLOR).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16495.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16495.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ދ, reason: contains not printable characters */
    public class ViewOnClickListenerC1493 implements View.OnClickListener {
        public ViewOnClickListenerC1493() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16469.m2574()) {
                return;
            }
            C3947.m12727().m12786(60.0f);
            RecordSettingView.this.m4070(false, 100);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ތ, reason: contains not printable characters */
    public class RunnableC1494 implements Runnable {
        public RunnableC1494() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16498.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_REC_BEEPER).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16498.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16498.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ލ, reason: contains not printable characters */
    public class RunnableC1495 implements Runnable {
        public RunnableC1495() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16499.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_REC_FLASH).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16499.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16499.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ގ, reason: contains not printable characters */
    public class RunnableC1496 implements Runnable {
        public RunnableC1496() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingView.this.f4066.f16496.getPaint().measureText(RecordSettingView.this.getResources().getString(R.string.SETTINGS_MIRRORED_SELFIE).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingView.this.f4066.f16496.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingView.this.f4066.f16496.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޏ, reason: contains not printable characters */
    public class ViewOnClickListenerC1497 implements View.OnClickListener {
        public ViewOnClickListenerC1497() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16472.m2574()) {
                return;
            }
            C3891 c3891M13890 = C4535.m13880().m13890();
            int iM12485 = c3891M13890.m12485();
            ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
            Iterator<v5> it = arrayListM11248.iterator();
            while (it.hasNext()) {
                v5 next = it.next();
                if (next.isSelected()) {
                    if (iM12485 == 2 && next.getType() != 0) {
                        Iterator<v5> it2 = arrayListM11248.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().m8464() == 30) {
                                c3891M13890.m12395(30);
                                c3891M13890.m12354(30);
                                C4535.m13880().m13915();
                            }
                        }
                    } else if (next.m8464() > 30) {
                        Iterator<v5> it3 = arrayListM11248.iterator();
                        while (it3.hasNext()) {
                            if (it3.next().m8464() == 30) {
                                c3891M13890.m12395(30);
                                c3891M13890.m12354(30);
                                C4535.m13880().m13915();
                            }
                        }
                    }
                }
            }
            C3947.m12727().m12797(0);
            RecordSettingView.this.m4071(0, 100);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ސ, reason: contains not printable characters */
    public class ViewOnClickListenerC1498 implements View.OnClickListener {
        public ViewOnClickListenerC1498() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16470.m2574()) {
                return;
            }
            C3947.m12727().m12797(2);
            RecordSettingView.this.m4071(2, 100);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޑ, reason: contains not printable characters */
    public class ViewOnClickListenerC1499 implements View.OnClickListener {
        public ViewOnClickListenerC1499() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingView.this.f4066.f16471.m2574()) {
                return;
            }
            C3891 c3891M13890 = C4535.m13880().m13890();
            if (c3891M13890.m12485() == 2) {
                ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
                Iterator<v5> it = arrayListM11248.iterator();
                while (it.hasNext()) {
                    v5 next = it.next();
                    if (next.isSelected() && next.getType() == 1) {
                        Iterator<v5> it2 = arrayListM11248.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().m8464() == 30) {
                                c3891M13890.m12395(30);
                                c3891M13890.m12354(30);
                                C4535.m13880().m13915();
                            }
                        }
                    }
                }
            }
            C3947.m12727().m12797(1);
            RecordSettingView.this.m4071(1, 100);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޒ, reason: contains not printable characters */
    public class C1500 implements SwitchButton.InterfaceC0969 {
        public C1500() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12790(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޓ, reason: contains not printable characters */
    public class C1501 implements SwitchButton.InterfaceC0969 {
        public C1501() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12798(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޔ, reason: contains not printable characters */
    public class C1502 implements SwitchButton.InterfaceC0969 {
        public C1502() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12794(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޕ, reason: contains not printable characters */
    public class C1503 implements SwitchButton.InterfaceC0969 {
        public C1503() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C3947.m12727().m12791(z ? 1 : 0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޖ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1504 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4105;

        /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޖ$Ϳ, reason: contains not printable characters */
        public class RunnableC1505 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4106;

            public RunnableC1505(View view) {
                this.f4106 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4106.isEnabled()) {
                    ViewOnTouchListenerC1504.this.f4105.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1504(View view) {
            this.f4105 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4105.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1505(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޗ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1506 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public StrokeTextViewWithBottomBlock f4108;

        /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޗ$Ϳ, reason: contains not printable characters */
        public class RunnableC1507 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4109;

            public RunnableC1507(View view) {
                this.f4109 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4109.isEnabled()) {
                    ViewOnTouchListenerC1506.this.f4108.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1506(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock) {
            this.f4108 = strokeTextViewWithBottomBlock;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.f4108.m2574()) {
                    return false;
                }
                this.f4108.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1507(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޘ, reason: contains not printable characters */
    public interface InterfaceC1508 {
        /* renamed from: Ϳ */
        void mo1735();

        /* renamed from: Ԩ */
        void mo1736();
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingView$ޙ, reason: contains not printable characters */
    public interface InterfaceC1509 {
        /* renamed from: Ϳ */
        void mo4052();
    }

    public RecordSettingView(Context context) {
        this(context, null);
    }

    public void setOnButtonClick(InterfaceC1508 interfaceC1508) {
        this.f4071 = interfaceC1508;
    }

    public void setOnInfoClick(InterfaceC1509 interfaceC1509) {
        this.f4072 = interfaceC1509;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4070(boolean z, int i) {
        if (z) {
            this.f4066.f16468.m2575(true, i);
            this.f4066.f16469.m2575(false, i);
        } else {
            this.f4066.f16468.m2575(false, i);
            this.f4066.f16469.m2575(true, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m4071(int i, int i2) {
        if (i == 0) {
            this.f4066.f16472.m2575(true, i2);
            this.f4066.f16471.m2575(false, i2);
            this.f4066.f16470.m2575(false, i2);
            this.f4066.f16482.setEnabled(true);
            this.f4066.f16482.setAlpha(1.0f);
            this.f4066.f16482.m2630(false, C3947.m12727().m12768() == 1);
            return;
        }
        if (i == 1) {
            this.f4066.f16472.m2575(false, i2);
            this.f4066.f16471.m2575(true, i2);
            this.f4066.f16470.m2575(false, i2);
            this.f4066.f16482.m2630(false, false);
            this.f4066.f16482.setEnabled(false);
            this.f4066.f16482.setAlpha(0.2f);
            return;
        }
        this.f4066.f16472.m2575(false, i2);
        this.f4066.f16471.m2575(false, i2);
        this.f4066.f16470.m2575(true, i2);
        C3891 c3891M13890 = C4535.m13880().m13890();
        boolean z = c3891M13890.m12484() <= 30 ? 1 : 0;
        c3891M13890.m12359(!z);
        C4535.m13880().m13915();
        this.f4066.f16482.setEnabled(z);
        this.f4066.f16482.setAlpha(z == 0 ? 0.2f : 1.0f);
        this.f4066.f16482.m2630(false, C3947.m12727().m12768() == 1);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m4072(int i) {
        int i2 = this.f4070;
        if (i2 == 0) {
            this.f4066.f16475.m2575(true, i);
            this.f4066.f16477.m2575(false, i);
            this.f4066.f16478.m2575(false, i);
            this.f4066.f16476.m2575(false, i);
            return;
        }
        if (i2 == 1) {
            this.f4066.f16475.m2575(false, i);
            this.f4066.f16477.m2575(true, i);
            this.f4066.f16478.m2575(false, i);
            this.f4066.f16476.m2575(false, i);
            return;
        }
        if (i2 == 2) {
            this.f4066.f16475.m2575(false, i);
            this.f4066.f16477.m2575(false, i);
            this.f4066.f16478.m2575(true, i);
            this.f4066.f16476.m2575(false, i);
            return;
        }
        if (i2 != 3) {
            return;
        }
        this.f4066.f16475.m2575(false, i);
        this.f4066.f16477.m2575(false, i);
        this.f4066.f16478.m2575(false, i);
        this.f4066.f16476.m2575(true, i);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m4073() {
        this.f4066 = AbstractC4876.m14598(LayoutInflater.from(getContext()), this, true);
        m4074();
        m4075();
        m4076();
        m4077(false);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4074() {
        this.f4067 = C2579.m9444();
        this.f4068 = C2579.m9440(getContext());
        float fM14471 = C4792.m14375().m14471();
        int iM14468 = C4792.m14375().m14468();
        int i = (this.f4067 - (iM14468 * 2)) / 4;
        int iM14377 = (int) ((C4792.m14375().m14377() * fM14471) + 0.5f);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4066.f16482.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i;
        this.f4066.f16482.setLayoutParams(layoutParams);
        this.f4066.f16482.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4066.f16493.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = 0;
        this.f4066.f16493.setLayoutParams(layoutParams2);
        this.f4066.f16493.setContentTextColor(-1);
        float fM14397 = (int) ((C4792.m14375().m14397() * fM14471) + 0.5f);
        this.f4066.f16493.m2562(0, fM14397);
        this.f4066.f16493.m2561(getResources().getString(R.string.SETTINGS_FRAMEDROP_NOTICE));
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4066.f16488.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = iM14468;
        this.f4066.f16488.setLayoutParams(layoutParams3);
        this.f4066.f16488.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4066.f16501.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f4066.f16501.setLayoutParams(layoutParams4);
        this.f4066.f16501.setContentTextColor(-1);
        this.f4066.f16501.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4066.f16492.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f4066.f16492.setLayoutParams(layoutParams5);
        this.f4066.f16492.setContentTextColor(-1);
        this.f4066.f16492.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4066.f16468.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = C4792.m14375().m14377();
        this.f4066.f16468.setLayoutParams(layoutParams6);
        float fM14384 = (int) ((C4792.m14375().m14384() * fM14471) + 0.5f);
        this.f4066.f16468.m2576(0, fM14384);
        this.f4066.f16468.setTextColor(-1);
        this.f4066.f16468.setTextForSetting("50 Hz");
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4066.f16469.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = C4792.m14375().m14385();
        this.f4066.f16469.setLayoutParams(layoutParams7);
        this.f4066.f16469.m2576(0, fM14384);
        this.f4066.f16469.setTextColor(-1);
        this.f4066.f16469.setTextForSetting("60 Hz");
        Paint paint = new Paint();
        paint.setTypeface(FilmApp.m404());
        paint.setTextSize(fM14384);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4066.f16487.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams8).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin = i;
        this.f4066.f16487.setLayoutParams(layoutParams8);
        this.f4066.f16487.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4066.f16500.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
        this.f4066.f16500.setLayoutParams(layoutParams9);
        this.f4066.f16500.setContentTextColor(-1);
        this.f4066.f16500.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4066.f16484.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams10).leftMargin = i;
        this.f4066.f16484.setLayoutParams(layoutParams10);
        this.f4066.f16484.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f4066.f16497.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
        this.f4066.f16497.setLayoutParams(layoutParams11);
        this.f4066.f16497.setContentTextColor(-1);
        this.f4066.f16497.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f4066.f16494.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f4066.f16494.setLayoutParams(layoutParams12);
        this.f4066.f16494.setContentTextColor(-1);
        this.f4066.f16494.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f4066.f16470.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).topMargin = C4792.m14375().m14377();
        this.f4066.f16470.setLayoutParams(layoutParams13);
        this.f4066.f16470.m2576(0, fM14384);
        this.f4066.f16470.setTextColor(-1);
        this.f4066.f16470.setTextForSetting(getResources().getString(R.string.SETTINGS_CAMERA_AUTO));
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f4066.f16472.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).leftMargin = C4792.m14375().m14385();
        this.f4066.f16472.setLayoutParams(layoutParams14);
        this.f4066.f16472.m2576(0, fM14384);
        this.f4066.f16472.setTextColor(-1);
        this.f4066.f16472.setTextForSetting(getResources().getString(R.string.app_name));
        ConstraintLayout.LayoutParams layoutParams15 = (ConstraintLayout.LayoutParams) this.f4066.f16471.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams15).leftMargin = C4792.m14375().m14385();
        this.f4066.f16471.setLayoutParams(layoutParams15);
        this.f4066.f16471.m2576(0, fM14384);
        this.f4066.f16471.setTextColor(-1);
        this.f4066.f16471.setTextForSetting(getResources().getString(R.string.SETTINGS_CAMERA_DIRECT));
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f4066.f16473.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin = C4792.m14375().m14381();
        int i2 = this.f4068;
        ((ViewGroup.MarginLayoutParams) layoutParams16).width = (int) ((i2 * 0.05227882f * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams16).height = (int) ((i2 * 0.05227882f * fM14471) + 0.5f);
        this.f4066.f16473.setLayoutParams(layoutParams16);
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f4066.f16481.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams17).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams17).leftMargin = i;
        this.f4066.f16481.setLayoutParams(layoutParams17);
        this.f4066.f16481.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f4066.f16491.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams18).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
        this.f4066.f16491.setLayoutParams(layoutParams18);
        this.f4066.f16491.setContentTextColor(-1);
        this.f4066.f16491.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f4066.f16498.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams19).topMargin = 0;
        this.f4066.f16498.setLayoutParams(layoutParams19);
        this.f4066.f16498.setContentTextColor(-1);
        this.f4066.f16498.m2562(0, fM14397);
        this.f4066.f16498.m2561(getResources().getString(R.string.SETTINGS_REC_BEEPER));
        ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f4066.f16485.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams20).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams20).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams20).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams20).leftMargin = iM14468;
        this.f4066.f16485.setLayoutParams(layoutParams20);
        this.f4066.f16485.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f4066.f16486.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams21).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams21).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams21).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams21).leftMargin = i;
        this.f4066.f16486.setLayoutParams(layoutParams21);
        this.f4066.f16486.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams22 = (ConstraintLayout.LayoutParams) this.f4066.f16499.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams22).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams22).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams19).topMargin;
        this.f4066.f16499.setLayoutParams(layoutParams22);
        this.f4066.f16499.setContentTextColor(-1);
        this.f4066.f16499.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams23 = (ConstraintLayout.LayoutParams) this.f4066.f16480.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams23).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams23).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams23).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams23).leftMargin = i;
        this.f4066.f16480.setLayoutParams(layoutParams23);
        this.f4066.f16480.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams24 = (ConstraintLayout.LayoutParams) this.f4066.f16490.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams24).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams24).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams19).topMargin;
        this.f4066.f16490.setLayoutParams(layoutParams24);
        this.f4066.f16490.setContentTextColor(-1);
        this.f4066.f16490.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams25 = (ConstraintLayout.LayoutParams) this.f4066.f16489.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams25).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams25).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams25).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams25).leftMargin = i;
        this.f4066.f16489.setLayoutParams(layoutParams25);
        this.f4066.f16489.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams26 = (ConstraintLayout.LayoutParams) this.f4066.f16502.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams26).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams26).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams19).topMargin;
        this.f4066.f16502.setLayoutParams(layoutParams26);
        this.f4066.f16502.setContentTextColor(-1);
        this.f4066.f16502.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams27 = (ConstraintLayout.LayoutParams) this.f4066.f16495.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams27).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f4066.f16495.setLayoutParams(layoutParams27);
        this.f4066.f16495.setContentTextColor(-1);
        this.f4066.f16495.m2562(0, fM14397);
        this.f4066.f16495.m2561(getResources().getString(R.string.SETTINGS_LEICA_COLOR));
        ConstraintLayout.LayoutParams layoutParams28 = (ConstraintLayout.LayoutParams) this.f4066.f16475.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams28).topMargin = C4792.m14375().m14377();
        this.f4066.f16475.setLayoutParams(layoutParams28);
        this.f4066.f16475.m2576(0, fM14384);
        this.f4066.f16475.setTextColor(-1);
        this.f4066.f16475.setTextForSetting(getResources().getString(R.string.SETTINGS_LEICA_COLOR_OFF));
        ConstraintLayout.LayoutParams layoutParams29 = (ConstraintLayout.LayoutParams) this.f4066.f16477.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams29).leftMargin = C4792.m14375().m14386();
        this.f4066.f16477.setLayoutParams(layoutParams29);
        this.f4066.f16477.m2576(0, fM14384);
        this.f4066.f16477.setTextColor(-1);
        this.f4066.f16477.setTextForSetting(getResources().getString(R.string.SETTINGS_LEICA_COLOR_STANDARD));
        ConstraintLayout.LayoutParams layoutParams30 = (ConstraintLayout.LayoutParams) this.f4066.f16478.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams30).leftMargin = C4792.m14375().m14386();
        this.f4066.f16478.setLayoutParams(layoutParams30);
        this.f4066.f16478.m2576(0, fM14384);
        this.f4066.f16478.setTextColor(-1);
        this.f4066.f16478.setTextForSetting(getResources().getString(R.string.SETTINGS_LEICA_COLOR_VIVID));
        ConstraintLayout.LayoutParams layoutParams31 = (ConstraintLayout.LayoutParams) this.f4066.f16476.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams31).leftMargin = C4792.m14375().m14386();
        this.f4066.f16476.setLayoutParams(layoutParams31);
        this.f4066.f16476.m2576(0, fM14384);
        this.f4066.f16476.setTextColor(-1);
        this.f4066.f16476.setTextForSetting(getResources().getString(R.string.SETTINGS_LEICA_COLOR_SMOOTH));
        ConstraintLayout.LayoutParams layoutParams32 = (ConstraintLayout.LayoutParams) this.f4066.f16474.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams32).leftMargin = (int) ((((ViewGroup.MarginLayoutParams) layoutParams16).leftMargin - this.f4066.f16487.getViewRealPadding()) + C4792.m14375().m14443() + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams32).width = ((ViewGroup.MarginLayoutParams) layoutParams16).width;
        ((ViewGroup.MarginLayoutParams) layoutParams32).height = ((ViewGroup.MarginLayoutParams) layoutParams16).height;
        this.f4066.f16474.setLayoutParams(layoutParams32);
        ConstraintLayout.LayoutParams layoutParams33 = (ConstraintLayout.LayoutParams) this.f4066.f16503.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams33).width = C2579.m9438(30.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams33).height = C2579.m9438(30.0f);
        this.f4066.f16503.setLayoutParams(layoutParams33);
        ConstraintLayout.LayoutParams layoutParams34 = (ConstraintLayout.LayoutParams) this.f4066.f16483.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams34).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams34).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams34).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams34).leftMargin = i;
        this.f4066.f16483.setLayoutParams(layoutParams34);
        this.f4066.f16483.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams35 = (ConstraintLayout.LayoutParams) this.f4066.f16496.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams35).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams35).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin;
        this.f4066.f16496.setLayoutParams(layoutParams35);
        this.f4066.f16496.setContentTextColor(-1);
        this.f4066.f16496.m2562(0, fM14397);
        m4078();
        this.f4066.f16494.setVisibility(8);
        this.f4066.f16470.setVisibility(8);
        this.f4066.f16471.setVisibility(8);
        this.f4066.f16472.setVisibility(8);
        this.f4066.f16473.setVisibility(8);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m4075() {
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock = this.f4066.f16468;
        strokeTextViewWithBottomBlock.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2 = this.f4066.f16469;
        strokeTextViewWithBottomBlock2.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock2));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock3 = this.f4066.f16471;
        strokeTextViewWithBottomBlock3.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock3));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock4 = this.f4066.f16470;
        strokeTextViewWithBottomBlock4.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock4));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock5 = this.f4066.f16472;
        strokeTextViewWithBottomBlock5.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock5));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock6 = this.f4066.f16475;
        strokeTextViewWithBottomBlock6.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock6));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock7 = this.f4066.f16477;
        strokeTextViewWithBottomBlock7.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock7));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock8 = this.f4066.f16478;
        strokeTextViewWithBottomBlock8.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock8));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock9 = this.f4066.f16476;
        strokeTextViewWithBottomBlock9.setOnTouchListener(new ViewOnTouchListenerC1506(strokeTextViewWithBottomBlock9));
        ImageView imageView = this.f4066.f16473;
        imageView.setOnTouchListener(new ViewOnTouchListenerC1504(imageView));
        ImageView imageView2 = this.f4066.f16474;
        imageView2.setOnTouchListener(new ViewOnTouchListenerC1504(imageView2));
        this.f4066.f16468.setOnClickListener(new ViewOnClickListenerC1482());
        this.f4066.f16469.setOnClickListener(new ViewOnClickListenerC1493());
        this.f4066.f16472.setOnClickListener(new ViewOnClickListenerC1497());
        this.f4066.f16470.setOnClickListener(new ViewOnClickListenerC1498());
        this.f4066.f16471.setOnClickListener(new ViewOnClickListenerC1499());
        this.f4066.f16481.setOnCheckedChangeListener(new C1500());
        this.f4066.f16487.setOnCheckedChangeListener(new C1501());
        this.f4066.f16484.setOnCheckedChangeListener(new C1502());
        this.f4066.f16482.setOnCheckedChangeListener(new C1503());
        this.f4066.f16488.setOnCheckedChangeListener(new C1472());
        this.f4066.f16473.setOnClickListener(new ViewOnClickListenerC1473());
        this.f4066.f16475.setOnClickListener(new ViewOnClickListenerC1474());
        this.f4066.f16477.setOnClickListener(new ViewOnClickListenerC1475());
        this.f4066.f16478.setOnClickListener(new ViewOnClickListenerC1476());
        this.f4066.f16476.setOnClickListener(new ViewOnClickListenerC1477());
        this.f4066.f16485.setOnCheckedChangeListener(new C1478());
        this.f4066.f16486.setOnCheckedChangeListener(new C1479());
        this.f4066.f16480.setOnCheckedChangeListener(new C1480());
        this.f4066.f16489.setOnCheckedChangeListener(new C1481());
        this.f4066.f16474.setOnClickListener(new ViewOnClickListenerC1483());
        this.f4066.f16483.setOnCheckedChangeListener(new C1484());
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m4076() {
        this.f4069 = C2813.f10274;
        this.f4070 = C4535.m13880().m13890().m12434();
        m4070(C3947.m12727().m12737() == 50.0f, 0);
        m4071(C4535.m13880().m13890().m12485(), 0);
        this.f4066.f16482.m2630(false, C3947.m12727().m12768() == 1);
        this.f4066.f16488.m2630(false, C4792.m14375().m14498());
        this.f4066.f16485.m2630(false, C3947.m12727().m12758() == 1);
        this.f4066.f16486.m2630(false, C3947.m12727().m12759() == 1);
        this.f4066.f16480.m2630(false, C3947.m12727().m12729() == 1);
        this.f4066.f16489.m2630(false, C3947.m12727().m12761() == 1);
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890.m12460() == 1) {
            this.f4066.f16483.m2630(false, false);
            this.f4066.f16483.setAlpha(0.3f);
            this.f4066.f16483.setEnabled(false);
        } else {
            this.f4066.f16483.setAlpha(1.0f);
            this.f4066.f16483.setEnabled(true);
            this.f4066.f16483.setChecked(c3891M13890.m12443() == 1);
        }
        C3485 c3485M11722 = C3641.m11713(null).m11722(c3891M13890.m12495() ? c3891M13890.m12399() : c3891M13890.m12380());
        if (c3485M11722 != null) {
            if (c3485M11722.m11382()) {
                this.f4066.f16481.setAlpha(1.0f);
                this.f4066.f16481.setEnabled(true);
                this.f4066.f16481.m2630(false, C3947.m12727().m12766() == 1);
            } else {
                this.f4066.f16481.m2630(false, false);
                this.f4066.f16481.setEnabled(false);
                this.f4066.f16481.setAlpha(0.3f);
            }
            if (c3485M11722.m11388()) {
                this.f4066.f16484.setAlpha(1.0f);
                this.f4066.f16484.setEnabled(true);
                this.f4066.f16484.m2630(false, C3947.m12727().m12770() == 1);
            } else {
                this.f4066.f16484.m2630(false, false);
                this.f4066.f16484.setEnabled(false);
                this.f4066.f16484.setAlpha(0.3f);
            }
            if (c3485M11722.m11390()) {
                this.f4066.f16487.setAlpha(1.0f);
                this.f4066.f16487.setEnabled(true);
                this.f4066.f16487.m2630(false, C3947.m12727().m12771() == 1);
            } else {
                this.f4066.f16487.m2630(false, false);
                this.f4066.f16487.setEnabled(false);
                this.f4066.f16487.setAlpha(0.3f);
            }
        } else {
            this.f4066.f16481.setAlpha(1.0f);
            this.f4066.f16481.setEnabled(true);
            this.f4066.f16484.setAlpha(1.0f);
            this.f4066.f16484.setEnabled(true);
            this.f4066.f16487.setAlpha(1.0f);
            this.f4066.f16487.setEnabled(true);
            this.f4066.f16481.m2630(false, C3947.m12727().m12766() == 1);
            this.f4066.f16484.m2630(false, C3947.m12727().m12770() == 1);
            this.f4066.f16487.m2630(false, C3947.m12727().m12771() == 1);
        }
        m4072(0);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m4077(boolean z) {
        if (z) {
            z = this.f4069;
        }
        int i = z ? 0 : 8;
        this.f4066.f16495.setVisibility(i);
        this.f4066.f16475.setVisibility(i);
        this.f4066.f16477.setVisibility(i);
        this.f4066.f16478.setVisibility(i);
        this.f4066.f16476.setVisibility(i);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4078() {
        this.f4066.f16501.setDrawBorder(false);
        this.f4066.f16493.setDrawBorder(false);
        this.f4066.f16492.setDrawBorder(false);
        this.f4066.f16495.setDrawBorder(false);
        this.f4066.f16500.setDrawBorder(false);
        this.f4066.f16497.setDrawBorder(false);
        this.f4066.f16494.setDrawBorder(false);
        this.f4066.f16491.setDrawBorder(false);
        this.f4066.f16468.m2571();
        this.f4066.f16469.m2571();
        this.f4066.f16472.m2571();
        this.f4066.f16471.m2571();
        this.f4066.f16475.m2571();
        this.f4066.f16477.m2571();
        this.f4066.f16478.m2571();
        this.f4066.f16476.m2571();
        this.f4066.f16499.setDrawBorder(false);
        this.f4066.f16498.setDrawBorder(false);
        this.f4066.f16496.setDrawBorder(false);
        this.f4066.f16501.post(new RunnableC1485());
        this.f4066.f16493.post(new RunnableC1486());
        this.f4066.f16492.post(new RunnableC1487());
        this.f4066.f16500.post(new RunnableC1488());
        this.f4066.f16497.post(new RunnableC1489());
        this.f4066.f16494.post(new RunnableC1490());
        this.f4066.f16491.post(new RunnableC1491());
        this.f4066.f16495.post(new RunnableC1492());
        this.f4066.f16498.post(new RunnableC1494());
        this.f4066.f16499.post(new RunnableC1495());
        this.f4066.f16496.post(new RunnableC1496());
    }

    public RecordSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordSettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4073();
    }
}
