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
import defpackage.AbstractC4903;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2749;
import defpackage.C3637;
import defpackage.C4535;
import defpackage.C4567;
import defpackage.C4792;
import defpackage.r1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class AccessoriesPage2View extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4903 f4119;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1516 f4120;

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View$Ϳ, reason: contains not printable characters */
    public class C1511 implements SwitchButton2.InterfaceC0976 {
        public C1511() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0976
        /* renamed from: Ϳ */
        public void mo2675() {
            if (C2749.m10010()) {
                AccessoriesPage2View.this.f4119.f16551.setVisibility(8);
                AccessoriesPage2View.this.f4119.f16546.setVisibility(0);
                if (AccessoriesPage2View.this.f4120 != null) {
                    AccessoriesPage2View.this.f4120.mo1834();
                    return;
                }
                return;
            }
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (Build.VERSION.SDK_INT < 31 || (ContextCompat.checkSelfPermission(AccessoriesPage2View.this.getContext(), "android.permission.BLUETOOTH_SCAN") == 0 && ContextCompat.checkSelfPermission(AccessoriesPage2View.this.getContext(), "android.permission.BLUETOOTH_CONNECT") == 0)) {
                defaultAdapter.enable();
            } else {
                AccessoriesPage2View.this.f4120.mo1835();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1512 implements View.OnClickListener {
        public ViewOnClickListenerC1512() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (AccessoriesPage2View.this.f4120 == null || !AccessoriesPage2View.this.f4119.f16551.isChecked()) {
                return;
            }
            AccessoriesPage2View.this.f4120.mo1837();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View$Ԫ, reason: contains not printable characters */
    public class C1513 implements SwitchButton2.InterfaceC0975 {
        public C1513() {
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
            C4567.m14006().m14012();
            AccessoriesPage2View.this.f4119.f16551.setEnabled(false);
            if (z2) {
                C2618.m9573("protake_focus_his_sp", "");
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View$Ԭ, reason: contains not printable characters */
    public class C1514 implements SwitchButton2.InterfaceC0975 {
        public C1514() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ϳ */
        public boolean mo2673() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ԩ */
        public void mo2674(SwitchButton2 switchButton2, boolean z, boolean z2) {
            C2618.m9570("reverse_wheel_focus_sp", z);
            C4535.m13880().m13909(z);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View$Ԯ, reason: contains not printable characters */
    public class C1515 implements SwitchButton.InterfaceC0969 {
        public C1515() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C4535.m13880().m13890().m12537(z ? 1 : 0);
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View$ՠ, reason: contains not printable characters */
    public interface InterfaceC1516 {
        /* renamed from: Ϳ */
        void mo1834();

        /* renamed from: Ԩ */
        void mo1835();

        /* renamed from: ԩ */
        void mo1836();

        /* renamed from: Ԫ */
        void mo1837();
    }

    public AccessoriesPage2View(Context context) {
        this(context, null);
    }

    public void setOnPageCallback(InterfaceC1516 interfaceC1516) {
        this.f4120 = interfaceC1516;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4098() {
        this.f4119 = AbstractC4903.m14627(LayoutInflater.from(getContext()), this, true);
        m4099();
        m4100();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4099() {
        int iM9440 = C2579.m9440(getContext());
        C2579.m9439(getContext());
        float fM14471 = C4792.m14375().m14471();
        int iM14468 = C4792.m14375().m14468();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4119.f16547.getLayoutParams();
        float f = iM9440;
        int i = (int) (0.16487935f * f);
        layoutParams.height = i;
        layoutParams.leftMargin = iM14468;
        layoutParams.rightMargin = iM14468;
        layoutParams.topMargin = (int) (f * 0.079322636f);
        this.f4119.f16547.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f4119.f16550.getLayoutParams();
        layoutParams2.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams2.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4119.f16550.setLayoutParams(layoutParams2);
        this.f4119.f16553.setTypeface(FilmApp.m404());
        this.f4119.f16553.setTextSize(0, C4792.m14375().m14381());
        this.f4119.f16550.setTextSize(C4792.m14375().m14481() * fM14471);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f4119.f16548.getLayoutParams();
        layoutParams3.height = i;
        layoutParams3.leftMargin = iM14468;
        layoutParams3.rightMargin = iM14468;
        this.f4119.f16548.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f4119.f16549.getLayoutParams();
        layoutParams4.height = layoutParams3.height;
        layoutParams4.leftMargin = iM14468;
        layoutParams4.rightMargin = iM14468;
        this.f4119.f16549.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f4119.f16556.getLayoutParams();
        layoutParams5.leftMargin = iM14468;
        layoutParams5.rightMargin = iM14468;
        this.f4119.f16556.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f4119.f16557.getLayoutParams();
        layoutParams6.leftMargin = iM14468;
        layoutParams6.rightMargin = iM14468;
        this.f4119.f16557.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f4119.f16558.getLayoutParams();
        layoutParams7.leftMargin = iM14468;
        layoutParams7.rightMargin = iM14468;
        this.f4119.f16558.setLayoutParams(layoutParams7);
        ViewGroup.LayoutParams layoutParams8 = this.f4119.f16552.getLayoutParams();
        layoutParams8.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams8.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4119.f16552.setLayoutParams(layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = this.f4119.f16551.getLayoutParams();
        layoutParams9.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams9.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4119.f16551.setLayoutParams(layoutParams9);
        RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f4119.f16546.getLayoutParams();
        layoutParams10.rightMargin = (layoutParams9.width - C2579.m9438(30.0f)) / 2;
        this.f4119.f16546.setLayoutParams(layoutParams10);
        this.f4119.f16554.setTypeface(FilmApp.m404());
        this.f4119.f16554.setTextSize(0, C4792.m14375().m14381());
        this.f4119.f16554.setTypeface(FilmApp.m404());
        this.f4119.f16554.setTextSize(0, C4792.m14375().m14381());
        this.f4119.f16551.setTextSize(C4792.m14375().m14481() * fM14471);
        this.f4119.f16552.setTextSize(C4792.m14375().m14481() * fM14471);
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
                this.f4119.f16551.setEnabled(true);
                this.f4119.f16551.m2670(false, true);
                return;
            }
        }
        this.f4119.f16551.setEnabled(false);
        this.f4119.f16552.setChecked(C4535.m13880().m13903());
        if (C4535.m13880().m13890().m12460() == 1) {
            this.f4119.f16550.setAlpha(0.3f);
            this.f4119.f16550.setEnabled(false);
            this.f4119.f16550.m2630(false, false);
        } else {
            this.f4119.f16550.setAlpha(1.0f);
            this.f4119.f16550.setEnabled(true);
            this.f4119.f16550.m2630(false, C4535.m13880().m13890().m12421() == 1);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4100() {
        this.f4119.f16551.setOnInterceptToggle(new C1511());
        this.f4119.f16554.setOnClickListener(new ViewOnClickListenerC1512());
        this.f4119.f16551.setOnCheckedChangeListener(new C1513());
        this.f4119.f16552.setOnCheckedChangeListener(new C1514());
        this.f4119.f16550.setOnCheckedChangeListener(new C1515());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4101() {
        this.f4119.f16551.setEnabled(true);
        this.f4119.f16551.m2670(true, true);
        this.f4119.f16551.setVisibility(0);
        this.f4119.f16546.setVisibility(8);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4102() {
        this.f4119.f16551.setEnabled(true);
        this.f4119.f16551.m2670(false, false);
        this.f4119.f16551.setEnabled(false);
        this.f4119.f16551.setVisibility(8);
        this.f4119.f16546.setVisibility(0);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4103() {
        this.f4119.f16551.setEnabled(true);
        this.f4119.f16551.m2670(true, false);
        this.f4119.f16551.setEnabled(false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4104() {
        this.f4119.f16551.setVisibility(0);
        this.f4119.f16546.setVisibility(8);
        this.f4119.f16552.setChecked(C4535.m13880().m13903());
        if (C4535.m13880().m13890().m12460() == 1) {
            this.f4119.f16550.setAlpha(0.3f);
            this.f4119.f16550.setEnabled(false);
            this.f4119.f16550.m2630(false, false);
        } else {
            this.f4119.f16550.setAlpha(1.0f);
            this.f4119.f16550.setEnabled(true);
            this.f4119.f16550.m2630(false, C4535.m13880().m13890().m12421() == 1);
        }
    }

    public AccessoriesPage2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccessoriesPage2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4098();
    }
}
