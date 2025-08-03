package com.blink.academy.film.widgets.setting.accessories;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.film.widgets.SwitchButton2;
import com.zhiyun.sdk.util.BTUtil;
import defpackage.AbstractC3702;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C3760;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.c9;
import defpackage.r1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AccessoriesSettingView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3702 f4130;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1524 f4131;

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView$Ϳ, reason: contains not printable characters */
    public class C1519 implements SwitchButton2.InterfaceC0976 {
        public C1519() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0976
        /* renamed from: Ϳ */
        public void mo2675() {
            if (BTUtil.isOpened()) {
                AccessoriesSettingView.this.f4130.f12844.setVisibility(8);
                AccessoriesSettingView.this.f4130.f12838.setVisibility(0);
                if (AccessoriesSettingView.this.f4131 != null) {
                    AccessoriesSettingView.this.f4131.mo1833();
                    return;
                }
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (Build.VERSION.SDK_INT < 31 || (ContextCompat.checkSelfPermission(AccessoriesSettingView.this.getContext(), "android.permission.BLUETOOTH_SCAN") == 0 && ContextCompat.checkSelfPermission(AccessoriesSettingView.this.getContext(), "android.permission.BLUETOOTH_CONNECT") == 0)) {
                defaultAdapter.enable();
            } else {
                AccessoriesSettingView.this.f4131.mo1831();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1520 implements View.OnClickListener {
        public ViewOnClickListenerC1520() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AccessoriesSettingView.this.f4131 == null || !AccessoriesSettingView.this.f4130.f12844.isChecked()) {
                return;
            }
            AccessoriesSettingView.this.f4131.mo1832();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView$Ԫ, reason: contains not printable characters */
    public class C1521 implements SwitchButton2.InterfaceC0975 {
        public C1521() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ϳ */
        public boolean mo2673() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ԩ */
        public void mo2674(SwitchButton2 switchButton2, boolean z, boolean z2) {
            if (z) {
                return;
            }
            c9.m219().m225();
            AccessoriesSettingView.this.f4130.f12844.setEnabled(false);
            if (z2) {
                C2618.m9573("gimbal_his_sp", "");
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView$Ԭ, reason: contains not printable characters */
    public class C1522 implements SwitchButton.InterfaceC0969 {
        public C1522() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (z) {
                AccessoriesSettingView.this.f4130.f12842.m2630(false, false);
            }
            C4535.m13880().m13890().m12545(z ? 1 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView$Ԯ, reason: contains not printable characters */
    public class C1523 implements SwitchButton.InterfaceC0969 {
        public C1523() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            if (z) {
                AccessoriesSettingView.this.f4130.f12843.m2630(false, false);
            }
            C4535.m13880().m13890().m12545(z ? 2 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView$ՠ, reason: contains not printable characters */
    public interface InterfaceC1524 {
        /* renamed from: Ϳ */
        void mo1831();

        /* renamed from: Ԩ */
        void mo1832();

        /* renamed from: ԩ */
        void mo1833();
    }

    public AccessoriesSettingView(Context context) {
        this(context, null);
    }

    public void setOnButtonClick(InterfaceC1524 interfaceC1524) {
        this.f4131 = interfaceC1524;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4113() {
        this.f4130 = AbstractC3702.m11852(LayoutInflater.from(getContext()), this, true);
        m4114();
        m4115();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4114() {
        int iM9440 = C2579.m9440(getContext());
        C2579.m9439(getContext());
        float fM14471 = C4792.m14375().m14471();
        int iM14468 = C4792.m14375().m14468();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4130.f12841.getLayoutParams();
        float f = iM9440;
        layoutParams.height = (int) (0.16487935f * f);
        layoutParams.leftMargin = iM14468;
        layoutParams.rightMargin = iM14468;
        layoutParams.topMargin = (int) (f * 0.079322636f);
        this.f4130.f12841.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4130.f12840.getLayoutParams();
        layoutParams2.height = layoutParams.height;
        layoutParams2.leftMargin = iM14468;
        layoutParams2.rightMargin = iM14468;
        this.f4130.f12840.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f4130.f12839.getLayoutParams();
        layoutParams3.height = layoutParams.height;
        layoutParams3.leftMargin = iM14468;
        layoutParams3.rightMargin = iM14468;
        this.f4130.f12839.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f4130.f12848.getLayoutParams();
        layoutParams4.leftMargin = iM14468;
        layoutParams4.rightMargin = iM14468;
        this.f4130.f12848.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f4130.f12849.getLayoutParams();
        layoutParams5.leftMargin = iM14468;
        layoutParams5.rightMargin = iM14468;
        this.f4130.f12849.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f4130.f12850.getLayoutParams();
        layoutParams6.leftMargin = iM14468;
        layoutParams6.rightMargin = iM14468;
        this.f4130.f12850.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = this.f4130.f12843.getLayoutParams();
        layoutParams7.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams7.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4130.f12843.setLayoutParams(layoutParams7);
        ViewGroup.LayoutParams layoutParams8 = this.f4130.f12842.getLayoutParams();
        layoutParams8.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams8.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4130.f12842.setLayoutParams(layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = this.f4130.f12844.getLayoutParams();
        layoutParams9.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams9.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4130.f12844.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f4130.f12838.getLayoutParams();
        layoutParams10.rightMargin = (layoutParams9.width - C2579.m9438(30.0f)) / 2;
        this.f4130.f12838.setLayoutParams(layoutParams10);
        this.f4130.f12846.setTypeface(FilmApp.m404());
        this.f4130.f12846.setTextSize(0, C4792.m14375().m14381());
        this.f4130.f12845.setTypeface(FilmApp.m404());
        this.f4130.f12845.setTextSize(0, C4792.m14375().m14381());
        this.f4130.f12847.setTypeface(FilmApp.m404());
        this.f4130.f12847.setTextSize(0, C4792.m14375().m14381());
        this.f4130.f12844.setTextSize(C4792.m14375().m14481() * fM14471);
        this.f4130.f12843.setTextSize(C4792.m14375().m14481() * fM14471);
        this.f4130.f12842.setTextSize(C4792.m14375().m14481() * fM14471);
        int iM12429 = C4535.m13880().m13890().m12429();
        if (C4535.m13880().m13890().m12460() == 1) {
            this.f4130.f12843.setAlpha(0.3f);
            this.f4130.f12843.setEnabled(false);
            this.f4130.f12843.m2630(false, false);
            this.f4130.f12842.setAlpha(0.3f);
            this.f4130.f12842.setEnabled(false);
            this.f4130.f12842.m2630(false, false);
        } else {
            this.f4130.f12843.setAlpha(1.0f);
            this.f4130.f12843.setEnabled(true);
            this.f4130.f12843.m2630(false, iM12429 == 1);
            this.f4130.f12842.setAlpha(1.0f);
            this.f4130.f12842.setEnabled(true);
            this.f4130.f12842.m2630(false, iM12429 == 2);
        }
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
                this.f4130.f12844.setEnabled(true);
                this.f4130.f12844.m2670(false, true);
                return;
            }
        }
        this.f4130.f12844.setEnabled(false);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4115() {
        this.f4130.f12844.setOnInterceptToggle(new C1519());
        this.f4130.f12847.setOnClickListener(new ViewOnClickListenerC1520());
        this.f4130.f12844.setOnCheckedChangeListener(new C1521());
        this.f4130.f12843.setOnCheckedChangeListener(new C1522());
        this.f4130.f12842.setOnCheckedChangeListener(new C1523());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4116() {
        this.f4130.f12844.setEnabled(true);
        this.f4130.f12844.m2670(true, true);
        this.f4130.f12844.setVisibility(0);
        this.f4130.f12838.setVisibility(8);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4117() {
        this.f4130.f12844.setEnabled(true);
        this.f4130.f12844.m2670(false, false);
        this.f4130.f12844.setEnabled(false);
        this.f4130.f12844.setVisibility(8);
        this.f4130.f12838.setVisibility(0);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4118() {
        this.f4130.f12844.setEnabled(true);
        this.f4130.f12844.m2670(true, false);
        this.f4130.f12844.setEnabled(false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4119() {
        this.f4130.f12844.setVisibility(0);
        this.f4130.f12838.setVisibility(8);
        int iM12429 = C4535.m13880().m13890().m12429();
        if (C4535.m13880().m13890().m12460() == 1) {
            this.f4130.f12843.setAlpha(0.3f);
            this.f4130.f12843.setEnabled(false);
            this.f4130.f12843.m2630(false, false);
            this.f4130.f12842.setAlpha(0.3f);
            this.f4130.f12842.setEnabled(false);
            this.f4130.f12842.m2630(false, false);
            return;
        }
        this.f4130.f12843.setAlpha(1.0f);
        this.f4130.f12843.setEnabled(true);
        this.f4130.f12843.m2630(false, iM12429 == 1);
        this.f4130.f12842.setAlpha(1.0f);
        this.f4130.f12842.setEnabled(true);
        this.f4130.f12842.m2630(false, iM12429 == 2);
    }

    public AccessoriesSettingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccessoriesSettingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4113();
    }
}
