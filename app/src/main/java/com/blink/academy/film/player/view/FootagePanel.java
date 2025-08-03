package com.blink.academy.film.player.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.protake.R;
import defpackage.AbstractC3106;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4792;

/* loaded from: classes.dex */
public class FootagePanel extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f1186;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC3106 f1187;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1188;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f1189;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC0573 f1190;

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0567 implements View.OnClickListener {
        public ViewOnClickListenerC0567() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FootagePanel.this.f1186 = 0;
            FootagePanel.this.m1607(100);
            if (FootagePanel.this.f1190 != null) {
                FootagePanel.this.f1190.mo1560(FootagePanel.this.f1186);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC0568 implements View.OnClickListener {
        public ViewOnClickListenerC0568() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC0569 implements View.OnClickListener {
        public ViewOnClickListenerC0569() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FootagePanel.this.f1186 = 3;
            FootagePanel.this.m1607(100);
            if (FootagePanel.this.f1190 != null) {
                FootagePanel.this.f1190.mo1560(FootagePanel.this.f1186);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC0570 implements View.OnClickListener {
        public ViewOnClickListenerC0570() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FootagePanel.this.f1186 = 1;
            FootagePanel.this.m1607(100);
            if (FootagePanel.this.f1190 != null) {
                FootagePanel.this.f1190.mo1560(FootagePanel.this.f1186);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC0571 implements View.OnClickListener {
        public ViewOnClickListenerC0571() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FootagePanel.this.f1186 = 2;
            FootagePanel.this.m1607(100);
            if (FootagePanel.this.f1190 != null) {
                FootagePanel.this.f1190.mo1560(FootagePanel.this.f1186);
            }
        }
    }

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$ՠ, reason: contains not printable characters */
    public class C0572 extends AbstractC4012 {
        public C0572() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
        }
    }

    /* renamed from: com.blink.academy.film.player.view.FootagePanel$ֈ, reason: contains not printable characters */
    public interface InterfaceC0573 {
        /* renamed from: Ϳ */
        void mo1560(int i);
    }

    public FootagePanel(@NonNull Context context) {
        this(context, null);
    }

    public int getFootageState() {
        return this.f1186;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f1188 = (int) (i2 + ((C2579.f9593 - C2579.f9597) / 2.0f));
        if (this.f1189) {
            return;
        }
        m1603(0);
    }

    public void setOnSwitch(InterfaceC0573 interfaceC0573) {
        this.f1190 = interfaceC0573;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m1601() {
        this.f1186 = 0;
        this.f1187.f11056.m2575(true, 0);
        this.f1187.f11055.m2575(false, 0);
        this.f1187.f11053.m2575(false, 0);
        this.f1187.f11054.m2575(false, 0);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m1602(String str) {
        this.f1187.f11056.setText(getResources().getString(R.string.SETTINGS_ORIGIN_FRAME_RATE, str + ""));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m1603(int i) {
        this.f1189 = false;
        C4008.m12886(this, 0.0f, this.f1188, i, null);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m1604(Context context) throws Resources.NotFoundException {
        AbstractC3106 abstractC3106 = (AbstractC3106) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_footage_panel, this, true);
        this.f1187 = abstractC3106;
        this.f1186 = 0;
        abstractC3106.f11050.getLayoutParams().height = C4792.m14375().m14405();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f1187.f11051.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = C4792.m14375().m14408();
        this.f1187.f11051.m2562(0, C4792.m14375().m14381());
        String string = getResources().getString(R.string.SETTINGS_PLAYBACK_FRAME_RATE);
        this.f1187.f11051.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
        this.f1187.f11051.setLayoutParams(layoutParams);
        this.f1187.f11051.m2561(string);
        ViewGroup.LayoutParams layoutParams2 = this.f1187.f11056.getLayoutParams();
        layoutParams2.width = -2;
        layoutParams2.height = (int) (C4792.m14375().m14406() / 2.0f);
        this.f1187.f11056.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f1187.f11053.getLayoutParams();
        layoutParams3.width = -2;
        layoutParams3.height = (int) (C4792.m14375().m14406() / 2.0f);
        this.f1187.f11053.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f1187.f11054.getLayoutParams();
        layoutParams4.width = -2;
        layoutParams4.height = (int) (C4792.m14375().m14406() / 2.0f);
        this.f1187.f11054.setLayoutParams(layoutParams4);
        ViewGroup.LayoutParams layoutParams5 = this.f1187.f11055.getLayoutParams();
        layoutParams5.width = -2;
        layoutParams5.height = (int) (C4792.m14375().m14406() / 2.0f);
        this.f1187.f11055.setLayoutParams(layoutParams5);
        this.f1187.f11056.setPadding(C4792.m14375().m14386(), 0, C4792.m14375().m14386(), 0);
        this.f1187.f11053.setPadding(C4792.m14375().m14386(), 0, C4792.m14375().m14386(), 0);
        this.f1187.f11054.setPadding(C4792.m14375().m14386(), 0, C4792.m14375().m14386(), 0);
        this.f1187.f11055.setPadding(C4792.m14375().m14386(), 0, C4792.m14375().m14386(), 0);
        int iM14386 = C4792.m14375().m14386();
        int iM14476 = C2579.f9594 - (C4792.m14375().m14476(25) * 3);
        float f = iM14386;
        this.f1187.f11056.m2576(0, f);
        this.f1187.f11055.m2576(0, f);
        this.f1187.f11053.m2576(0, f);
        this.f1187.f11054.m2576(0, f);
        this.f1187.f11056.setText(getResources().getString(R.string.SETTINGS_ORIGIN_FRAME_RATE, "24"));
        this.f1187.f11055.setText("30");
        this.f1187.f11053.setText("24");
        this.f1187.f11054.setText("25");
        int iM2572 = this.f1187.f11056.m2572(getResources().getString(R.string.SETTINGS_ORIGIN_FRAME_RATE, "24")) + this.f1187.f11055.m2572("30") + this.f1187.f11053.m2572("24") + this.f1187.f11054.m2572("25") + (C4792.m14375().m14386() * 8);
        if (iM2572 > iM14476) {
            float f2 = (iM14476 * 1.0f) / iM2572;
            int i = (int) (f * f2);
            int iM143862 = (int) (f2 * C4792.m14375().m14386());
            float f3 = i;
            this.f1187.f11056.m2576(0, f3);
            this.f1187.f11055.m2576(0, f3);
            this.f1187.f11053.m2576(0, f3);
            this.f1187.f11054.m2576(0, f3);
            this.f1187.f11056.setText(getResources().getString(R.string.SETTINGS_ORIGIN_FRAME_RATE, "24"));
            this.f1187.f11055.setText("30");
            this.f1187.f11053.setText("24");
            this.f1187.f11054.setText("25");
            this.f1187.f11056.setPadding(iM143862, 0, iM143862, 0);
            this.f1187.f11055.setPadding(iM143862, 0, iM143862, 0);
            this.f1187.f11053.setPadding(iM143862, 0, iM143862, 0);
            this.f1187.f11054.setPadding(iM143862, 0, iM143862, 0);
        }
        m1605();
        m1607(0);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m1605() {
        this.f1187.f11056.setOnClickListener(new ViewOnClickListenerC0567());
        this.f1187.f11052.setOnClickListener(new ViewOnClickListenerC0568());
        this.f1187.f11055.setOnClickListener(new ViewOnClickListenerC0569());
        this.f1187.f11053.setOnClickListener(new ViewOnClickListenerC0570());
        this.f1187.f11054.setOnClickListener(new ViewOnClickListenerC0571());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean m1606() {
        return this.f1189;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m1607(int i) {
        int i2 = this.f1186;
        if (i2 == 1) {
            this.f1187.f11056.m2575(false, i);
            this.f1187.f11055.m2575(false, i);
            this.f1187.f11053.m2575(true, i);
            this.f1187.f11054.m2575(false, i);
            return;
        }
        if (i2 == 2) {
            this.f1187.f11056.m2575(false, i);
            this.f1187.f11055.m2575(false, i);
            this.f1187.f11053.m2575(false, i);
            this.f1187.f11054.m2575(true, i);
            return;
        }
        if (i2 != 3) {
            this.f1187.f11056.m2575(true, i);
            this.f1187.f11055.m2575(false, i);
            this.f1187.f11053.m2575(false, i);
            this.f1187.f11054.m2575(false, i);
            return;
        }
        this.f1187.f11056.m2575(false, i);
        this.f1187.f11055.m2575(true, i);
        this.f1187.f11053.m2575(false, i);
        this.f1187.f11054.m2575(false, i);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m1608(int i) {
        this.f1189 = true;
        C4008.m12886(this, 0.0f, 0.0f, i, new C0572());
    }

    public FootagePanel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FootagePanel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        this.f1186 = 0;
        m1604(context);
    }
}
