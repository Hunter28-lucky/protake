package com.blink.academy.film.widgets.iso.portrait;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.GravityCompat;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.widgets.iso.portrait.PortraitABPointView;
import com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4861;
import defpackage.C2579;
import defpackage.C3947;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;

/* loaded from: classes.dex */
public class PortraitFocusZoomWheel extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4861 f3637;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3638;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3639;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3640;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3641;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3642;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3643;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3644;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f3645;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3646;

    /* renamed from: ހ, reason: contains not printable characters */
    public InterfaceC1291 f3647;

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$Ϳ, reason: contains not printable characters */
    public class C1280 implements PortraitWheelProgressView.InterfaceC1314 {
        public C1280() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onAnimChange(boolean z) {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onAnimChange(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onDown() {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onTouchChange(true);
                PortraitFocusZoomWheel.this.f3647.onTouchChange2(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onUp() {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onTouchChange(false);
                PortraitFocusZoomWheel.this.f3647.onTouchChange2(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$Ԩ, reason: contains not printable characters */
    public class C1281 implements PortraitWheelProgressView.InterfaceC1314 {
        public C1281() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onAnimChange(boolean z) {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onAnimChange(z);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onDown() {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onTouchChange2(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onUp() {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onTouchChange2(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$Ԫ, reason: contains not printable characters */
    public class C1282 implements PortraitABPointView.InterfaceC1279 {
        public C1282() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        public void onFocusChange(float f) {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        public void onZoomChange(float f) {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.m3569(f);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        /* renamed from: Ϳ */
        public boolean mo3549() {
            if (PortraitFocusZoomWheel.this.f3647 == null) {
                return false;
            }
            return PortraitFocusZoomWheel.this.f3647.m3568();
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        /* renamed from: Ԩ */
        public void mo3550(int i) {
            if (i == 1) {
                PortraitFocusZoomWheel.this.f3637.f16384.setStartMargin(PortraitFocusZoomWheel.this.f3637.f16396.getNowMargin());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$Ԭ, reason: contains not printable characters */
    public class C1283 implements PortraitABPointView.InterfaceC1279 {
        public C1283() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        public void onFocusChange(float f) {
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.m3570(f);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        public void onZoomChange(float f) {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        /* renamed from: Ϳ */
        public boolean mo3549() {
            if (PortraitFocusZoomWheel.this.f3647 == null) {
                return false;
            }
            return PortraitFocusZoomWheel.this.f3647.m3568();
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitABPointView.InterfaceC1279
        /* renamed from: Ԩ */
        public void mo3550(int i) {
            if (i == 1) {
                PortraitFocusZoomWheel.this.f3637.f16383.setStartMargin(PortraitFocusZoomWheel.this.f3637.f16385.getNowMargin());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$Ԯ, reason: contains not printable characters */
    public class RunnableC1284 implements Runnable {
        public RunnableC1284() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = PortraitFocusZoomWheel.this.f3637.f16394.getPaint().measureText("0".toUpperCase());
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PortraitFocusZoomWheel.this.f3637.f16394.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138 + 0.5f + 2.0f);
            layoutParams.topMargin = PortraitFocusZoomWheel.this.f3640;
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) PortraitFocusZoomWheel.this.f3637.f16385.getLayoutParams();
            layoutParams.rightMargin = layoutParams2.rightMargin + ((layoutParams2.width - layoutParams.width) / 2);
            PortraitFocusZoomWheel.this.f3637.f16394.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$ՠ, reason: contains not printable characters */
    public class RunnableC1285 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3653;

        public RunnableC1285(String str) {
            this.f3653 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = PortraitFocusZoomWheel.this.f3637.f16392.getPaint().measureText(this.f3653);
            int iMeasureText = ((int) PortraitFocusZoomWheel.this.f3637.f16395.getPaint().measureText(PortraitFocusZoomWheel.this.getResources().getString(R.string.RECORDING_WHEELS_ZOOM).toUpperCase())) / 2;
            int i = ((int) fMeasureText) / 2;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PortraitFocusZoomWheel.this.f3637.f16393.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) PortraitFocusZoomWheel.this.f3637.f16395.getLayoutParams();
            layoutParams2.width = (int) (C4792.f16138 + fMeasureText);
            layoutParams2.height = layoutParams.width;
            layoutParams2.rightMargin = (int) ((PortraitFocusZoomWheel.this.f3638 - ((layoutParams2.width - layoutParams2.height) / 2.0f)) + 0.5f);
            int i2 = (iMeasureText - i) / 2;
            layoutParams2.topMargin = ((-iMeasureText) + i2) - C4792.m14375().m14476(30);
            PortraitFocusZoomWheel.this.f3637.f16395.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) PortraitFocusZoomWheel.this.f3637.f16392.getLayoutParams();
            layoutParams3.width = (int) (fMeasureText + C4792.f16138);
            layoutParams3.rightMargin = layoutParams2.rightMargin;
            layoutParams3.height = layoutParams.width;
            layoutParams3.topMargin = i + i2 + C4792.m14375().m14476(30);
            PortraitFocusZoomWheel.this.f3637.f16392.setLayoutParams(layoutParams3);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$ֈ, reason: contains not printable characters */
    public class C1286 implements PortraitWheelProgressView.InterfaceC1313 {
        public C1286() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        public void onChange(float f) {
            float f2 = 1.0f - f;
            C4638.m14099("slimabpoint", "zoom p:" + f2);
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onZoomChange(f2);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3566(int i, int i2) {
            PortraitFocusZoomWheel.this.m3560(i, i2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$֏, reason: contains not printable characters */
    public class C1287 implements PortraitWheelProgressView.InterfaceC1313 {
        public C1287() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        public void onChange(float f) {
            float f2 = 1.0f - f;
            C4638.m14099("cccccccc", "focus p:" + f2);
            System.currentTimeMillis();
            if (PortraitFocusZoomWheel.this.f3647 != null) {
                PortraitFocusZoomWheel.this.f3647.onFocusChange(f2);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        /* renamed from: Ϳ */
        public void mo3566(int i, int i2) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$ׯ, reason: contains not printable characters */
    public class C1288 implements PortraitWheelProgressView.InterfaceC1312 {
        public C1288() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1312
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3567() {
            PortraitFocusZoomWheel.this.f3637.f16383.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1289 implements View.OnClickListener {
        public ViewOnClickListenerC1289() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitFocusZoomWheel.this.f3645) {
                PortraitFocusZoomWheel.this.f3645 = false;
                C3947.m12727().m12800(PortraitFocusZoomWheel.this.f3645, false);
                PortraitFocusZoomWheel.this.m3559();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC1290 implements View.OnClickListener {
        public ViewOnClickListenerC1290() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitFocusZoomWheel.this.f3645) {
                return;
            }
            PortraitFocusZoomWheel.this.f3645 = true;
            C3947.m12727().m12800(PortraitFocusZoomWheel.this.f3645, false);
            PortraitFocusZoomWheel.this.m3559();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitFocusZoomWheel$ށ, reason: contains not printable characters */
    public interface InterfaceC1291 {
        void onAnimChange(boolean z);

        void onFocusChange(float f);

        void onTouchChange(boolean z);

        void onTouchChange2(boolean z);

        void onZoomChange(float f);

        void onZoomEnableChange(boolean z);

        /* renamed from: Ϳ, reason: contains not printable characters */
        boolean m3568();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void m3569(float f);

        /* renamed from: ԩ, reason: contains not printable characters */
        void m3570(float f);
    }

    public PortraitFocusZoomWheel(@NonNull Context context) {
        this(context, null);
    }

    public void setCardWidth(int i) {
        this.f3646 = i;
    }

    public void setFocusEnable(boolean z) {
        this.f3637.f16385.setEnabled(z);
        this.f3637.f16390.setEnabled(z);
        if (z) {
            this.f3637.f16392.setAlpha(1.0f);
            this.f3637.f16386.setAlpha(1.0f);
            this.f3637.f16383.setEnabled(true);
        } else {
            if (!this.f3645) {
                this.f3645 = true;
                C3947.m12727().m12800(this.f3645, true);
                m3559();
            }
            this.f3637.f16392.setAlpha(0.2f);
            this.f3637.f16383.setEnabled(false);
        }
    }

    public void setHandler(WeakHandler weakHandler) {
        this.f3637.f16385.setHandler(weakHandler);
        this.f3637.f16396.setHandler(weakHandler);
        this.f3637.f16384.setHandler(weakHandler);
        this.f3637.f16383.setHandler(weakHandler);
    }

    public void setOnValueChange(InterfaceC1291 interfaceC1291) {
        this.f3647 = interfaceC1291;
    }

    public void setZoomEnable(boolean z) {
        this.f3637.f16396.setEnabled(z);
        this.f3637.f16391.setEnabled(z);
        if (z) {
            this.f3637.f16395.setAlpha(1.0f);
            this.f3637.f16386.setAlpha(1.0f);
            this.f3637.f16396.setAlpha(1.0f);
            this.f3637.f16384.setEnabled(true);
        } else {
            if (!this.f3637.f16385.isEnabled()) {
                this.f3637.f16396.setAlpha(0.2f);
                this.f3637.f16386.setAlpha(0.2f);
            } else if (this.f3645) {
                this.f3645 = false;
                C3947.m12727().m12800(this.f3645, true);
                m3559();
            }
            this.f3637.f16395.setAlpha(0.2f);
            this.f3637.f16384.setEnabled(false);
        }
        InterfaceC1291 interfaceC1291 = this.f3647;
        if (interfaceC1291 != null) {
            interfaceC1291.onZoomEnableChange(this.f3637.f16396.isEnabled());
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m3559() {
        if (this.f3645) {
            this.f3637.f16395.setContentTextColor(C4792.m14375().m14431());
            this.f3637.f16392.setContentTextColor(this.f3644);
            this.f3637.f16385.setVisibility(8);
            this.f3637.f16396.setVisibility(0);
            this.f3637.f16387.setVisibility(0);
            this.f3637.f16389.setVisibility(0);
            this.f3637.f16384.setVisibility(0);
            this.f3637.f16388.setVisibility(8);
            this.f3637.f16394.setVisibility(8);
            this.f3637.f16383.setVisibility(8);
            return;
        }
        this.f3637.f16392.setContentTextColor(C4792.m14375().m14431());
        this.f3637.f16395.setContentTextColor(this.f3644);
        this.f3637.f16385.setVisibility(0);
        this.f3637.f16396.setVisibility(8);
        this.f3637.f16389.setVisibility(8);
        this.f3637.f16387.setVisibility(8);
        this.f3637.f16384.setVisibility(8);
        this.f3637.f16388.setVisibility(0);
        this.f3637.f16394.setVisibility(0);
        this.f3637.f16383.setVisibility(0);
        m3565(C3947.m12727().m12736());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m3560(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f3637.f16389.getLayoutParams());
        layoutParams.topMargin = this.f3640 + i;
        layoutParams.rightMargin = this.f3642;
        layoutParams.gravity = GravityCompat.END;
        this.f3637.f16389.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f3637.f16387.getLayoutParams());
        layoutParams2.topMargin = this.f3641 - i2;
        layoutParams2.rightMargin = this.f3642;
        layoutParams2.gravity = GravityCompat.END;
        this.f3637.f16387.setLayoutParams(layoutParams2);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3561() {
        this.f3637 = AbstractC4861.m14583(LayoutInflater.from(getContext()), this, true);
        m3562();
        m3564();
        m3563();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m3562() {
        float fM14434 = C4792.m14375().m14434();
        C2579.m9443(getContext());
        this.f3638 = (int) (this.f3639 * C4792.m14375().m14455(1125.0f));
        this.f3643 = (int) ((C4792.m14375().m14476(23) * fM14434) + 0.5f);
        int iM14476 = (int) ((C4792.m14375().m14476(TypedValues.PositionType.TYPE_TRANSITION_EASING) * fM14434) + 0.5f);
        int iM144762 = (int) ((C4792.m14375().m14476(110) * fM14434) + 0.5f);
        int iM144763 = (int) ((C4792.m14375().m14476(680) * fM14434) + 0.5f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3637.f16385.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3637.f16396.getLayoutParams();
        int iM144764 = (int) (((int) ((C4792.m14375().m14476(37) * fM14434) + 0.5f)) + (C4792.m14375().m14476(100) * fM14434) + 0.5f);
        layoutParams.width = iM144764;
        layoutParams.height = iM14476;
        layoutParams.rightMargin = iM144762;
        layoutParams2.width = iM144764;
        layoutParams2.height = iM14476;
        layoutParams2.rightMargin = iM144762;
        this.f3637.f16396.setLayoutParams(layoutParams2);
        this.f3637.f16385.setLayoutParams(layoutParams);
        this.f3637.f16396.m3642(layoutParams2.width, layoutParams2.height, 4, 3);
        this.f3637.f16385.m3642(layoutParams.width, layoutParams.height, 4, 4);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f3637.f16386.getLayoutParams();
        layoutParams3.height = (int) (((C4792.m14375().m14476(30) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams3.width = (int) (((C4792.m14375().m14476(15) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams3.rightMargin = (int) ((C4792.m14375().m14476(126) * fM14434) + 0.5f);
        int i = layoutParams3.height;
        layoutParams3.height = i + (i % 2);
        this.f3637.f16386.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f3637.f16393.getLayoutParams();
        layoutParams4.width = (int) ((C4792.m14375().m14476(108) * fM14434) + 0.5f);
        layoutParams4.height = (int) ((C4792.m14375().m14476(325) * fM14434) + 0.5f);
        this.f3637.f16393.setLayoutParams(layoutParams4);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.f3637.f16389.getLayoutParams();
        layoutParams5.width = (int) ((C4792.m14375().m14476(37) * fM14434) + 0.5f);
        int iM144765 = (int) ((C4792.m14375().m14476(37) * fM14434) + 0.5f);
        layoutParams5.height = iM144765;
        layoutParams5.rightMargin = layoutParams.rightMargin + ((layoutParams.width - layoutParams5.width) / 2);
        layoutParams5.topMargin = (((iM144763 - layoutParams.height) / 2) - iM144765) - this.f3643;
        this.f3637.f16389.setLayoutParams(layoutParams5);
        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.f3637.f16387.getLayoutParams();
        layoutParams6.width = layoutParams5.width;
        layoutParams6.height = layoutParams5.height;
        layoutParams6.rightMargin = layoutParams5.rightMargin;
        int i2 = layoutParams.height;
        layoutParams6.topMargin = ((iM144763 - i2) / 2) + i2 + this.f3643;
        this.f3637.f16387.setLayoutParams(layoutParams6);
        FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) this.f3637.f16388.getLayoutParams();
        layoutParams7.width = layoutParams5.width;
        layoutParams7.height = layoutParams5.height;
        layoutParams7.rightMargin = layoutParams5.rightMargin;
        int i3 = layoutParams.height;
        layoutParams7.topMargin = ((iM144763 - i3) / 2) + i3 + this.f3643;
        this.f3637.f16388.setLayoutParams(layoutParams7);
        this.f3640 = layoutParams5.topMargin;
        this.f3641 = layoutParams6.topMargin;
        this.f3642 = layoutParams5.rightMargin;
        this.f3637.f16384.m3547(layoutParams.height, fM14434);
        this.f3637.f16384.setZoom(true);
        this.f3637.f16384.setOnABStateChange(new C1282());
        this.f3637.f16383.m3547(layoutParams.height, fM14434);
        this.f3637.f16383.setZoom(false);
        this.f3637.f16383.setOnABStateChange(new C1283());
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m3563() {
        this.f3637.f16396.setOnProChange(new C1286());
        this.f3637.f16385.setOnProChange(new C1287());
        this.f3637.f16385.setOnHideAB(new C1288());
        this.f3637.f16390.setOnClickListener(new ViewOnClickListenerC1289());
        this.f3637.f16391.setOnClickListener(new ViewOnClickListenerC1290());
        this.f3637.f16385.setOnTouchStateChange(new C1280());
        this.f3637.f16396.setOnTouchStateChange(new C1281());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m3564() {
        float fM14434 = C4792.m14375().m14434();
        this.f3637.f16394.setText("0".toUpperCase());
        this.f3637.f16394.setContentTextColor(-1);
        this.f3637.f16394.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3637.f16394.post(new RunnableC1284());
        String upperCase = getResources().getString(R.string.RECORDING_WHEELS_FOCUS).toUpperCase();
        this.f3637.f16395.setText(R.string.RECORDING_WHEELS_ZOOM);
        this.f3637.f16392.setText(upperCase);
        this.f3637.f16392.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3637.f16395.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3637.f16392.post(new RunnableC1285(upperCase));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m3565(float f) {
        if (f >= 0.0f && f <= 1.0f) {
            this.f3637.f16383.setVisibility(0);
            return;
        }
        this.f3637.f16383.setVisibility(8);
        this.f3637.f16383.m3546();
        this.f3637.f16383.m3545();
    }

    public PortraitFocusZoomWheel(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitFocusZoomWheel(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3639 = 47;
        this.f3644 = Color.parseColor("#ffffff");
        m3561();
    }
}
