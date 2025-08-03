package com.blink.academy.film.widgets.setting;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import com.zhiyun.sdk.util.BTUtil;
import defpackage.AbstractC4067;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2749;
import defpackage.C3637;
import defpackage.C3760;
import defpackage.C4535;
import defpackage.C4567;
import defpackage.c9;
import defpackage.r1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PortraitAccessoriesSettingView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4067 f3939;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1398 f3940;

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1386 implements View.OnClickListener {
        public ViewOnClickListenerC1386() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitAccessoriesSettingView.this.f3940 != null) {
                PortraitAccessoriesSettingView.this.f3940.mo1741();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$Ԩ, reason: contains not printable characters */
    public class C1387 implements CompoundButton.OnCheckedChangeListener {
        public C1387() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C4535.m13880().m13890().m12542(z ? 1 : 0);
            C4535.m13880().m13908(z);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$Ԫ, reason: contains not printable characters */
    public class C1388 implements CompoundButton.OnCheckedChangeListener {
        public C1388() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C2618.m9570("reverse_wheel_focus_sp", z);
            C4535.m13880().m13909(z);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1389 implements View.OnClickListener {
        public ViewOnClickListenerC1389() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (BTUtil.isOpened()) {
                PortraitAccessoriesSettingView.this.f3939.f14144.setVisibility(8);
                PortraitAccessoriesSettingView.this.f3939.f14129.setVisibility(0);
                if (PortraitAccessoriesSettingView.this.f3940 != null) {
                    PortraitAccessoriesSettingView.this.f3940.mo1739();
                    return;
                }
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(PortraitAccessoriesSettingView.this.getContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                defaultAdapter.enable();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1390 implements View.OnClickListener {
        public ViewOnClickListenerC1390() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitAccessoriesSettingView.this.f3940 == null || !PortraitAccessoriesSettingView.this.f3939.f14144.isChecked()) {
                return;
            }
            PortraitAccessoriesSettingView.this.f3940.mo1738();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ՠ, reason: contains not printable characters */
    public class C1391 implements CompoundButton.OnCheckedChangeListener {
        public C1391() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                return;
            }
            c9.m219().m225();
            PortraitAccessoriesSettingView.this.f3939.f14152.setVisibility(0);
            if (compoundButton.isPressed()) {
                C2618.m9573("gimbal_his_sp", "");
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1392 implements View.OnClickListener {
        public ViewOnClickListenerC1392() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C2749.m10010()) {
                PortraitAccessoriesSettingView.this.f3939.f14142.setVisibility(8);
                PortraitAccessoriesSettingView.this.f3939.f14127.setVisibility(0);
                if (PortraitAccessoriesSettingView.this.f3940 != null) {
                    PortraitAccessoriesSettingView.this.f3940.mo1737();
                    return;
                }
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(PortraitAccessoriesSettingView.this.getContext(), "android.permission.BLUETOOTH_CONNECT") == 0) {
                defaultAdapter.enable();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1393 implements View.OnClickListener {
        public ViewOnClickListenerC1393() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitAccessoriesSettingView.this.f3940 == null || !PortraitAccessoriesSettingView.this.f3939.f14142.isChecked()) {
                return;
            }
            PortraitAccessoriesSettingView.this.f3940.mo1740();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ׯ, reason: contains not printable characters */
    public class C1394 implements CompoundButton.OnCheckedChangeListener {
        public C1394() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                return;
            }
            C4567.m14006().m14012();
            PortraitAccessoriesSettingView.this.f3939.f14130.setVisibility(0);
            if (compoundButton.isPressed()) {
                C2618.m9573("protake_focus_his_sp", "");
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ؠ, reason: contains not printable characters */
    public class C1395 implements CompoundButton.OnCheckedChangeListener {
        public C1395() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                PortraitAccessoriesSettingView.this.f3939.f14138.setChecked(false);
            }
            C4535.m13880().m13890().m12545(z ? 1 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ހ, reason: contains not printable characters */
    public class C1396 implements CompoundButton.OnCheckedChangeListener {
        public C1396() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                PortraitAccessoriesSettingView.this.f3939.f14139.setChecked(false);
            }
            C4535.m13880().m13890().m12545(z ? 2 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ށ, reason: contains not printable characters */
    public class C1397 implements CompoundButton.OnCheckedChangeListener {
        public C1397() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C4535.m13880().m13890().m12537(z ? 1 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView$ނ, reason: contains not printable characters */
    public interface InterfaceC1398 {
        /* renamed from: Ϳ */
        void mo1737();

        /* renamed from: Ԩ */
        void mo1738();

        /* renamed from: ԩ */
        void mo1739();

        /* renamed from: Ԫ */
        void mo1740();

        /* renamed from: ԫ */
        void mo1741();
    }

    public PortraitAccessoriesSettingView(Context context) {
        this(context, null);
    }

    public void setOnButtonClick(InterfaceC1398 interfaceC1398) {
        this.f3940 = interfaceC1398;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m3931() {
        C2618.m9570("has_hint_hdmi_sp", true);
        this.f3939.f14141.setChecked(true);
        this.f3939.f14113.setVisibility(8);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m3932() {
        List<C3637> listM14014 = C4567.m14006().m14014();
        if (r1.m8144(listM14014)) {
            Iterator<C3637> it = listM14014.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().m11702().m13774()) {
                    z = true;
                }
            }
            if (z) {
                this.f3939.f14142.setChecked(true);
                this.f3939.f14130.setVisibility(8);
                return;
            }
        }
        this.f3939.f14130.setVisibility(0);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m3933() {
        List<C3760> listM227 = c9.m219().m227();
        if (r1.m8144(listM227)) {
            Iterator<C3760> it = listM227.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().m12042().isConnected()) {
                    z = true;
                }
            }
            if (z) {
                this.f3939.f14144.setChecked(true);
                this.f3939.f14152.setVisibility(8);
                return;
            }
        }
        this.f3939.f14152.setVisibility(0);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m3934() {
        this.f3939 = AbstractC4067.m13004(LayoutInflater.from(getContext()), this, true);
        m3935();
        m3936();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m3935() {
        int iM9438 = C2579.m9438(50.0f);
        int iM94382 = C2579.m9438(18.0f);
        int iM94383 = C2579.m9438(15.0f);
        int iM94384 = C2579.m9438(35.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3939.f14137.getLayoutParams();
        layoutParams.topMargin = iM94384;
        layoutParams.height = iM9438;
        this.f3939.f14137.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3939.f14151.getLayoutParams();
        layoutParams2.leftMargin = iM94383;
        this.f3939.f14151.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3939.f14144.getLayoutParams();
        layoutParams3.rightMargin = iM94383;
        this.f3939.f14144.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3939.f14121.getLayoutParams();
        layoutParams4.leftMargin = iM94383;
        this.f3939.f14121.setLayoutParams(layoutParams4);
        float f = iM94382;
        this.f3939.f14151.setTextSize(0, f);
        this.f3939.f14151.setTypeface(FilmApp.m404());
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3939.f14152.getLayoutParams();
        layoutParams5.height = layoutParams.height;
        layoutParams5.width = layoutParams.height;
        layoutParams5.rightMargin = layoutParams3.rightMargin;
        this.f3939.f14152.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3939.f14129.getLayoutParams();
        layoutParams6.rightMargin = layoutParams3.rightMargin + C2579.m9438(10.0f);
        this.f3939.f14129.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f3939.f14132.getLayoutParams();
        layoutParams7.height = iM9438;
        this.f3939.f14132.setLayoutParams(layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f3939.f14146.getLayoutParams();
        layoutParams8.leftMargin = iM94383;
        this.f3939.f14146.setLayoutParams(layoutParams8);
        RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f3939.f14139.getLayoutParams();
        layoutParams9.rightMargin = iM94383;
        this.f3939.f14139.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f3939.f14115.getLayoutParams();
        layoutParams10.leftMargin = iM94383;
        this.f3939.f14115.setLayoutParams(layoutParams10);
        this.f3939.f14146.setTextSize(0, f);
        this.f3939.f14146.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.f3939.f14131.getLayoutParams();
        layoutParams11.height = iM9438;
        this.f3939.f14131.setLayoutParams(layoutParams11);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f3939.f14145.getLayoutParams();
        layoutParams12.leftMargin = iM94383;
        this.f3939.f14145.setLayoutParams(layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f3939.f14138.getLayoutParams();
        layoutParams13.rightMargin = iM94383;
        this.f3939.f14138.setLayoutParams(layoutParams13);
        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f3939.f14114.getLayoutParams();
        layoutParams14.leftMargin = iM94383;
        this.f3939.f14114.setLayoutParams(layoutParams14);
        this.f3939.f14145.setTextSize(0, f);
        this.f3939.f14145.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.f3939.f14133.getLayoutParams();
        layoutParams15.height = iM9438;
        this.f3939.f14133.setLayoutParams(layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f3939.f14147.getLayoutParams();
        layoutParams16.leftMargin = iM94383;
        this.f3939.f14147.setLayoutParams(layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f3939.f14140.getLayoutParams();
        layoutParams17.rightMargin = iM94383;
        this.f3939.f14140.setLayoutParams(layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f3939.f14116.getLayoutParams();
        layoutParams18.leftMargin = iM94383;
        this.f3939.f14116.setLayoutParams(layoutParams18);
        this.f3939.f14147.setTextSize(0, f);
        this.f3939.f14147.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams19 = (LinearLayout.LayoutParams) this.f3939.f14135.getLayoutParams();
        layoutParams19.height = iM9438;
        this.f3939.f14135.setLayoutParams(layoutParams19);
        RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f3939.f14149.getLayoutParams();
        layoutParams20.leftMargin = iM94383;
        this.f3939.f14149.setLayoutParams(layoutParams20);
        RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) this.f3939.f14142.getLayoutParams();
        layoutParams21.rightMargin = iM94383;
        this.f3939.f14142.setLayoutParams(layoutParams21);
        RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.f3939.f14118.getLayoutParams();
        layoutParams22.leftMargin = iM94383;
        this.f3939.f14118.setLayoutParams(layoutParams22);
        this.f3939.f14149.setTextSize(0, f);
        this.f3939.f14149.setTypeface(FilmApp.m404());
        RelativeLayout.LayoutParams layoutParams23 = (RelativeLayout.LayoutParams) this.f3939.f14130.getLayoutParams();
        layoutParams23.height = layoutParams19.height;
        layoutParams23.width = layoutParams19.height;
        layoutParams23.rightMargin = layoutParams21.rightMargin;
        this.f3939.f14130.setLayoutParams(layoutParams23);
        RelativeLayout.LayoutParams layoutParams24 = (RelativeLayout.LayoutParams) this.f3939.f14127.getLayoutParams();
        layoutParams24.rightMargin = layoutParams21.rightMargin + C2579.m9438(10.0f);
        this.f3939.f14127.setLayoutParams(layoutParams24);
        LinearLayout.LayoutParams layoutParams25 = (LinearLayout.LayoutParams) this.f3939.f14136.getLayoutParams();
        layoutParams25.height = iM9438;
        this.f3939.f14136.setLayoutParams(layoutParams25);
        RelativeLayout.LayoutParams layoutParams26 = (RelativeLayout.LayoutParams) this.f3939.f14150.getLayoutParams();
        layoutParams26.leftMargin = iM94383;
        this.f3939.f14150.setLayoutParams(layoutParams26);
        RelativeLayout.LayoutParams layoutParams27 = (RelativeLayout.LayoutParams) this.f3939.f14143.getLayoutParams();
        layoutParams27.rightMargin = iM94383;
        this.f3939.f14143.setLayoutParams(layoutParams27);
        RelativeLayout.LayoutParams layoutParams28 = (RelativeLayout.LayoutParams) this.f3939.f14120.getLayoutParams();
        layoutParams28.leftMargin = iM94383;
        this.f3939.f14120.setLayoutParams(layoutParams28);
        this.f3939.f14150.setTextSize(0, f);
        this.f3939.f14150.setTypeface(FilmApp.m404());
        LinearLayout.LayoutParams layoutParams29 = (LinearLayout.LayoutParams) this.f3939.f14134.getLayoutParams();
        layoutParams29.height = iM9438;
        this.f3939.f14134.setLayoutParams(layoutParams29);
        RelativeLayout.LayoutParams layoutParams30 = (RelativeLayout.LayoutParams) this.f3939.f14148.getLayoutParams();
        layoutParams30.leftMargin = iM94383;
        this.f3939.f14148.setLayoutParams(layoutParams30);
        RelativeLayout.LayoutParams layoutParams31 = (RelativeLayout.LayoutParams) this.f3939.f14141.getLayoutParams();
        layoutParams31.rightMargin = iM94383;
        this.f3939.f14141.setLayoutParams(layoutParams31);
        this.f3939.f14117.setLayoutParams((RelativeLayout.LayoutParams) this.f3939.f14117.getLayoutParams());
        this.f3939.f14148.setTextSize(0, f);
        this.f3939.f14148.setTypeface(FilmApp.m404());
        int iM12429 = C4535.m13880().m13890().m12429();
        if (C4535.m13880().m13890().m12460() == 1) {
            this.f3939.f14139.setAlpha(0.3f);
            this.f3939.f14138.setAlpha(0.3f);
            this.f3939.f14140.setAlpha(0.3f);
            this.f3939.f14140.setEnabled(false);
            this.f3939.f14139.setEnabled(false);
            this.f3939.f14139.setChecked(false);
            this.f3939.f14138.setEnabled(false);
            this.f3939.f14138.setChecked(false);
            this.f3939.f14140.setChecked(false);
        } else {
            this.f3939.f14139.setAlpha(1.0f);
            this.f3939.f14138.setAlpha(1.0f);
            this.f3939.f14140.setAlpha(1.0f);
            this.f3939.f14140.setEnabled(true);
            this.f3939.f14139.setEnabled(true);
            this.f3939.f14139.setChecked(iM12429 == 1);
            this.f3939.f14138.setEnabled(true);
            this.f3939.f14138.setChecked(iM12429 == 2);
            this.f3939.f14140.setChecked(C4535.m13880().m13890().m12421() == 1);
        }
        this.f3939.f14141.setChecked(C4535.m13880().m13890().m12426() == 1);
        if (C2618.m9565("has_hint_hdmi_sp", false)) {
            this.f3939.f14113.setVisibility(8);
        } else {
            this.f3939.f14113.setVisibility(0);
        }
        this.f3939.f14143.setChecked(C2618.m9565("reverse_wheel_focus_sp", false));
        m3933();
        m3932();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3936() {
        this.f3939.f14152.setOnClickListener(new ViewOnClickListenerC1389());
        this.f3939.f14151.setOnClickListener(new ViewOnClickListenerC1390());
        this.f3939.f14144.setOnCheckedChangeListener(new C1391());
        this.f3939.f14130.setOnClickListener(new ViewOnClickListenerC1392());
        this.f3939.f14149.setOnClickListener(new ViewOnClickListenerC1393());
        this.f3939.f14142.setOnCheckedChangeListener(new C1394());
        this.f3939.f14139.setOnCheckedChangeListener(new C1395());
        this.f3939.f14138.setOnCheckedChangeListener(new C1396());
        this.f3939.f14140.setOnCheckedChangeListener(new C1397());
        this.f3939.f14113.setOnClickListener(new ViewOnClickListenerC1386());
        this.f3939.f14141.setOnCheckedChangeListener(new C1387());
        this.f3939.f14143.setOnCheckedChangeListener(new C1388());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3937() {
        this.f3939.f14152.setVisibility(8);
        this.f3939.f14144.setChecked(true);
        this.f3939.f14144.setVisibility(0);
        this.f3939.f14129.setVisibility(8);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m3938() {
        this.f3939.f14130.setVisibility(8);
        this.f3939.f14142.setChecked(true);
        this.f3939.f14142.setVisibility(0);
        this.f3939.f14127.setVisibility(8);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m3939() {
        this.f3939.f14144.setChecked(false);
        this.f3939.f14152.setVisibility(0);
        this.f3939.f14144.setVisibility(8);
        this.f3939.f14129.setVisibility(0);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m3940() {
        this.f3939.f14142.setChecked(false);
        this.f3939.f14130.setVisibility(0);
        this.f3939.f14142.setVisibility(8);
        this.f3939.f14127.setVisibility(0);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m3941() {
        this.f3939.f14144.setChecked(false);
        this.f3939.f14152.setVisibility(0);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3942() {
        this.f3939.f14142.setChecked(false);
        this.f3939.f14130.setVisibility(0);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m3943() {
        this.f3939.f14144.setVisibility(0);
        this.f3939.f14129.setVisibility(8);
        this.f3939.f14142.setVisibility(0);
        this.f3939.f14127.setVisibility(8);
        int iM12429 = C4535.m13880().m13890().m12429();
        if (C4535.m13880().m13890().m12460() == 1) {
            this.f3939.f14139.setAlpha(0.3f);
            this.f3939.f14138.setAlpha(0.3f);
            this.f3939.f14140.setAlpha(0.3f);
            this.f3939.f14140.setEnabled(false);
            this.f3939.f14139.setEnabled(false);
            this.f3939.f14139.setChecked(false);
            this.f3939.f14138.setEnabled(false);
            this.f3939.f14138.setChecked(false);
            this.f3939.f14140.setChecked(false);
            return;
        }
        this.f3939.f14139.setAlpha(1.0f);
        this.f3939.f14138.setAlpha(1.0f);
        this.f3939.f14140.setAlpha(1.0f);
        this.f3939.f14140.setEnabled(true);
        this.f3939.f14139.setEnabled(true);
        this.f3939.f14139.setChecked(iM12429 == 1);
        this.f3939.f14138.setEnabled(true);
        this.f3939.f14138.setChecked(iM12429 == 2);
        this.f3939.f14140.setChecked(C4535.m13880().m13890().m12421() == 1);
    }

    public PortraitAccessoriesSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitAccessoriesSettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3934();
    }
}
