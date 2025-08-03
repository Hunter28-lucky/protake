package com.blink.academy.film.widgets.setting.accessories;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.SwitchButton2;
import com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View;
import defpackage.AbstractC3149;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4535;
import defpackage.C4792;

/* loaded from: classes.dex */
public class AccessoriesPage3View extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3149 f4126;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AccessoriesPage2View.InterfaceC1516 f4127;

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage3View$Ϳ, reason: contains not printable characters */
    public class C1517 implements SwitchButton2.InterfaceC0976 {
        public C1517() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0976
        /* renamed from: Ϳ */
        public void mo2675() {
            if (AccessoriesPage3View.this.f4127 != null) {
                AccessoriesPage3View.this.f4127.mo1836();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.accessories.AccessoriesPage3View$Ԩ, reason: contains not printable characters */
    public class C1518 implements SwitchButton2.InterfaceC0975 {
        public C1518() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ϳ */
        public boolean mo2673() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton2.InterfaceC0975
        /* renamed from: Ԩ */
        public void mo2674(SwitchButton2 switchButton2, boolean z, boolean z2) {
            C4535.m13880().m13890().m12542(z ? 1 : 0);
            C4535.m13880().m13908(z);
            C4535.m13880().m13915();
        }
    }

    public AccessoriesPage3View(Context context) {
        this(context, null);
    }

    public void setOnPageCallback(AccessoriesPage2View.InterfaceC1516 interfaceC1516) {
        this.f4127 = interfaceC1516;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4106() {
        C2618.m9570("has_hint_hdmi_sp", true);
        this.f4126.f11180.setEnabled(true);
        this.f4126.f11180.setChecked(true);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4107() {
        this.f4126 = AbstractC3149.m10753(LayoutInflater.from(getContext()), this, true);
        m4108();
        m4109();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4108() {
        int iM9440 = C2579.m9440(getContext());
        C2579.m9439(getContext());
        float fM14471 = C4792.m14375().m14471();
        int iM14468 = C4792.m14375().m14468();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4126.f11179.getLayoutParams();
        float f = iM9440;
        layoutParams.height = (int) (0.16487935f * f);
        layoutParams.leftMargin = iM14468;
        layoutParams.rightMargin = iM14468;
        layoutParams.topMargin = (int) (f * 0.079322636f);
        this.f4126.f11179.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f4126.f11182.getLayoutParams();
        layoutParams2.leftMargin = iM14468;
        layoutParams2.rightMargin = iM14468;
        this.f4126.f11182.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f4126.f11180.getLayoutParams();
        layoutParams3.width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        layoutParams3.height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        this.f4126.f11180.setLayoutParams(layoutParams3);
        this.f4126.f11181.setTypeface(FilmApp.m404());
        this.f4126.f11181.setTextSize(0, C4792.m14375().m14381());
        this.f4126.f11180.setTextSize(C4792.m14375().m14481() * fM14471);
        this.f4126.f11180.setEnabled(true);
        this.f4126.f11180.setChecked(C4535.m13880().m13890().m12426() == 1);
        this.f4126.f11180.setEnabled(C2618.m9565("has_hint_hdmi_sp", false));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4109() {
        this.f4126.f11180.setOnInterceptToggle(new C1517());
        this.f4126.f11180.setOnCheckedChangeListener(new C1518());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4110() {
        this.f4126.f11180.setChecked(C4535.m13880().m13890().m12426() == 1);
    }

    public AccessoriesPage3View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AccessoriesPage3View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4107();
    }
}
