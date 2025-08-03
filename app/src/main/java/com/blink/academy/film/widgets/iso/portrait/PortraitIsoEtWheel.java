package com.blink.academy.film.widgets.iso.portrait;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView;
import com.blink.academy.protake.R;
import defpackage.AbstractC3552;
import defpackage.C2579;
import defpackage.C3947;
import defpackage.C4535;
import defpackage.C4792;
import defpackage.r1;
import java.util.List;

/* loaded from: classes.dex */
public class PortraitIsoEtWheel extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3552 f3660;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1302 f3661;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f3662;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f3663;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f3664;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f3665;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f3666;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f3667;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f3668;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f3669;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3670;

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$Ϳ, reason: contains not printable characters */
    public class RunnableC1292 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f3671;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f3672;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f3673;

        public RunnableC1292(String str, String str2, String str3) {
            this.f3671 = str;
            this.f3672 = str2;
            this.f3673 = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PortraitIsoEtWheel.this.f3660.f12357.getLayoutParams();
            int iMeasureText = (int) PortraitIsoEtWheel.this.f3660.f12356.getPaint().measureText(this.f3671);
            int iMeasureText2 = (int) PortraitIsoEtWheel.this.f3660.f12358.getPaint().measureText(this.f3672);
            float fMax = Math.max(PortraitIsoEtWheel.this.f3660.f12355.getPaint().measureText(this.f3673), iMeasureText);
            int i = iMeasureText2 / 2;
            int i2 = iMeasureText / 2;
            float fMax2 = Math.max(fMax, iMeasureText2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) PortraitIsoEtWheel.this.f3660.f12355.getLayoutParams();
            layoutParams2.width = (int) (C4792.f16138 + fMax2);
            layoutParams2.height = layoutParams.width;
            layoutParams2.leftMargin = (int) ((PortraitIsoEtWheel.this.f3664 - ((layoutParams2.width - layoutParams2.height) / 2.0f)) + 0.5f);
            PortraitIsoEtWheel.this.f3660.f12355.setLayoutParams(layoutParams2);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) PortraitIsoEtWheel.this.f3660.f12356.getLayoutParams();
            layoutParams3.width = (int) (C4792.f16138 + fMax2);
            layoutParams3.leftMargin = layoutParams2.leftMargin;
            layoutParams3.height = layoutParams.width;
            int i3 = (i - i2) / 2;
            layoutParams3.topMargin = i2 + i3 + C4792.m14375().m14476(30);
            PortraitIsoEtWheel.this.f3660.f12356.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) PortraitIsoEtWheel.this.f3660.f12358.getLayoutParams();
            layoutParams4.width = (int) (fMax2 + C4792.f16138);
            layoutParams4.leftMargin = layoutParams2.leftMargin;
            layoutParams4.height = layoutParams.width;
            layoutParams4.topMargin = ((-i) + i3) - C4792.m14375().m14476(30);
            PortraitIsoEtWheel.this.f3660.f12358.setLayoutParams(layoutParams4);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$Ԩ, reason: contains not printable characters */
    public class C1293 implements PortraitWheelProgressView.InterfaceC1313 {
        public C1293() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        public void onChange(float f) {
            if (r1.m8144(C3947.m12727().m12748())) {
                int iM12751 = C3947.m12727().m12751();
                int iM12752 = C3947.m12727().m12752();
                C3947.m12727().m12787((int) (iM12752 + ((iM12751 - iM12752) * C3947.m12727().m12757(f))));
                if (PortraitIsoEtWheel.this.f3661 != null) {
                    PortraitIsoEtWheel.this.f3661.m3590();
                }
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        /* renamed from: Ϳ */
        public void mo3566(int i, int i2) {
            if (C3947.m12727().m12765() || !PortraitIsoEtWheel.this.f3662) {
                return;
            }
            PortraitIsoEtWheel.this.m3579(i, i2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$Ԫ, reason: contains not printable characters */
    public class C1294 implements PortraitWheelProgressView.InterfaceC1313 {
        public C1294() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        public void onChange(float f) {
            float fM12755;
            int iM12747;
            List<Float> listM12740 = C3947.m12727().m12740();
            if (r1.m8144(listM12740)) {
                float fFloatValue = listM12740.get(0).floatValue();
                float fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
                float f2 = fFloatValue - fFloatValue2;
                if (C3947.m12727().m12764()) {
                    fM12755 = fFloatValue2 + (f2 * f);
                    iM12747 = C3947.m12727().m12747();
                } else {
                    fM12755 = fFloatValue2 + (f2 * C3947.m12727().m12755(f));
                    iM12747 = C3947.m12727().m12747();
                }
                C3947.m12727().m12784(fM12755 / (iM12747 * 360));
                C3947.m12727().m12788(fM12755);
                if (PortraitIsoEtWheel.this.f3661 != null) {
                    PortraitIsoEtWheel.this.f3661.m3589(f);
                }
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        /* renamed from: Ϳ */
        public void mo3566(int i, int i2) {
            if (C3947.m12727().m12765() || PortraitIsoEtWheel.this.f3662) {
                return;
            }
            PortraitIsoEtWheel.this.m3579(i, i2);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$Ԭ, reason: contains not printable characters */
    public class C1295 implements PortraitWheelProgressView.InterfaceC1313 {
        public C1295() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        public void onChange(float f) {
            C3947.m12727().m12783(f);
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.m3588();
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1313
        /* renamed from: Ϳ */
        public void mo3566(int i, int i2) {
            if (C3947.m12727().m12765()) {
                PortraitIsoEtWheel.this.m3579(i, i2);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$Ԯ, reason: contains not printable characters */
    public class C1296 implements PortraitWheelProgressView.InterfaceC1314 {
        public C1296() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onDown() {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onUp() {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.onTouchChange(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$ՠ, reason: contains not printable characters */
    public class C1297 implements PortraitWheelProgressView.InterfaceC1314 {
        public C1297() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onDown() {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onUp() {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.onTouchChange(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$ֈ, reason: contains not printable characters */
    public class C1298 implements PortraitWheelProgressView.InterfaceC1314 {
        public C1298() {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onAnimChange(boolean z) {
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onDown() {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.onTouchChange(true);
            }
        }

        @Override // com.blink.academy.film.widgets.iso.portrait.PortraitWheelProgressView.InterfaceC1314
        public void onUp() {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.onTouchChange(false);
            }
            C4535.m13880().m13915();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1299 implements View.OnClickListener {
        public ViewOnClickListenerC1299() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3947.m12727().m12765() || PortraitIsoEtWheel.this.f3662) {
                return;
            }
            PortraitIsoEtWheel.this.f3662 = true;
            C3947.m12727().m12792(PortraitIsoEtWheel.this.f3662);
            PortraitIsoEtWheel.this.m3578();
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.m3587();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1300 implements View.OnClickListener {
        public ViewOnClickListenerC1300() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C3947.m12727().m12765() || !PortraitIsoEtWheel.this.f3662) {
                return;
            }
            PortraitIsoEtWheel.this.f3662 = false;
            C3947.m12727().m12792(PortraitIsoEtWheel.this.f3662);
            PortraitIsoEtWheel.this.m3578();
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.m3587();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1301 implements View.OnClickListener {
        public ViewOnClickListenerC1301() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitIsoEtWheel.this.f3661 != null) {
                PortraitIsoEtWheel.this.f3661.m3591();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.iso.portrait.PortraitIsoEtWheel$ހ, reason: contains not printable characters */
    public interface InterfaceC1302 {
        void onTouchChange(boolean z);

        /* renamed from: Ϳ, reason: contains not printable characters */
        void m3587();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void m3588();

        /* renamed from: ԩ, reason: contains not printable characters */
        void m3589(float f);

        /* renamed from: Ԫ, reason: contains not printable characters */
        void m3590();

        /* renamed from: ԭ, reason: contains not printable characters */
        void m3591();
    }

    public PortraitIsoEtWheel(Context context) {
        this(context, null);
    }

    public void setCardWidth(int i) {
        this.f3670 = i;
    }

    public void setEtWheelEnable(boolean z) {
        this.f3660.f12346.setEnabled(z);
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            m3584();
            if (zM12765) {
                this.f3660.f12346.setAlpha(1.0f);
                this.f3660.f12355.setAlpha(1.0f);
                this.f3660.f12347.setAlpha(1.0f);
                return;
            }
            return;
        }
        this.f3660.f12346.setPro(0.0f);
        if (zM12765) {
            this.f3660.f12346.setAlpha(0.2f);
            this.f3660.f12355.setAlpha(0.2f);
            this.f3660.f12347.setAlpha(0.2f);
        }
    }

    public void setIconEnable(boolean z) {
        this.f3660.f12351.setEnabled(z);
    }

    public void setIsoWheelEnable(boolean z) {
        this.f3660.f12348.setEnabled(z);
        this.f3660.f12352.setEnabled(z);
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            m3585();
            if (zM12765) {
                return;
            }
            this.f3660.f12348.setAlpha(1.0f);
            this.f3660.f12356.setAlpha(1.0f);
            this.f3660.f12347.setAlpha(1.0f);
            return;
        }
        this.f3660.f12348.setPro(0.0f);
        if (zM12765) {
            return;
        }
        if (this.f3660.f12354.isEnabled()) {
            this.f3662 = false;
            C3947.m12727().m12792(this.f3662);
            m3578();
        } else {
            this.f3660.f12348.setAlpha(0.2f);
            this.f3660.f12356.setAlpha(0.2f);
            this.f3660.f12347.setAlpha(0.2f);
        }
    }

    public void setOnChange(InterfaceC1302 interfaceC1302) {
        this.f3661 = interfaceC1302;
    }

    public void setShutterWheelEnable(boolean z) {
        this.f3660.f12354.setEnabled(z);
        this.f3660.f12353.setEnabled(z);
        boolean zM12765 = C3947.m12727().m12765();
        if (z) {
            m3586();
            if (zM12765) {
                return;
            }
            this.f3660.f12354.setAlpha(1.0f);
            this.f3660.f12356.setAlpha(1.0f);
            this.f3660.f12347.setAlpha(1.0f);
            return;
        }
        this.f3660.f12354.setPro(0.0f);
        if (zM12765) {
            return;
        }
        this.f3662 = true;
        C3947.m12727().m12792(this.f3662);
        m3578();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m3578() {
        if (this.f3662) {
            this.f3660.f12356.setContentTextColor(C4792.m14375().m14431());
            this.f3660.f12358.setContentTextColor(this.f3669);
            this.f3660.f12354.setVisibility(8);
            this.f3660.f12348.setVisibility(0);
            this.f3660.f12348.m3639();
            return;
        }
        this.f3660.f12358.setContentTextColor(C4792.m14375().m14431());
        this.f3660.f12356.setContentTextColor(this.f3669);
        this.f3660.f12354.setVisibility(0);
        this.f3660.f12348.setVisibility(8);
        this.f3660.f12354.m3639();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m3579(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f3660.f12350.getLayoutParams());
        layoutParams.topMargin = this.f3666 + i;
        layoutParams.leftMargin = this.f3668;
        this.f3660.f12350.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(this.f3660.f12349.getLayoutParams());
        layoutParams2.topMargin = this.f3667 - i2;
        layoutParams2.leftMargin = this.f3668;
        this.f3660.f12349.setLayoutParams(layoutParams2);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public float m3580(float f, float f2, float f3) {
        return (f - f2) / f3;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3581() {
        float fM14434 = C4792.m14375().m14434();
        C2579.m9443(getContext());
        this.f3664 = (int) (this.f3663 * C4792.m14375().m14455(1125.0f));
        this.f3665 = (int) ((C4792.m14375().m14476(23) * fM14434) + 0.5f);
        int iM14476 = (int) ((C4792.m14375().m14476(TypedValues.PositionType.TYPE_TRANSITION_EASING) * fM14434) + 0.5f);
        int iM144762 = (int) ((C4792.m14375().m14476(110) * fM14434) + 0.5f);
        int iM144763 = (int) ((C4792.m14375().m14476(680) * fM14434) + 0.5f);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f3660.f12346.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f3660.f12348.getLayoutParams();
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f3660.f12354.getLayoutParams();
        int iM144764 = (int) (((int) ((C4792.m14375().m14476(37) * fM14434) + 0.5f)) + (C4792.m14375().m14476(100) * fM14434) + 0.5f);
        layoutParams.width = iM144764;
        layoutParams.height = iM14476;
        layoutParams.leftMargin = iM144762;
        layoutParams2.width = iM144764;
        layoutParams2.height = iM14476;
        layoutParams2.leftMargin = iM144762;
        layoutParams3.width = layoutParams.width;
        layoutParams3.height = layoutParams.height;
        layoutParams3.leftMargin = layoutParams.leftMargin;
        this.f3660.f12346.setLayoutParams(layoutParams);
        this.f3660.f12348.setLayoutParams(layoutParams2);
        this.f3660.f12354.setLayoutParams(layoutParams3);
        this.f3660.f12346.m3642(layoutParams.width, layoutParams.height, 4, 2);
        this.f3660.f12348.m3642(layoutParams2.width, layoutParams2.height, 4, 0);
        this.f3660.f12354.m3642(layoutParams3.width, layoutParams3.height, 4, 1);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f3660.f12347.getLayoutParams();
        layoutParams4.height = (int) (((C4792.m14375().m14476(30) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams4.width = (int) (((C4792.m14375().m14476(15) + (C4792.m14375().m14443() * 2.0f)) * fM14434) + 0.5f);
        layoutParams4.leftMargin = (int) ((C4792.m14375().m14476(126) * fM14434) + 0.5f);
        int i = layoutParams4.height;
        layoutParams4.height = i + (i % 2);
        this.f3660.f12347.setLayoutParams(layoutParams4);
        this.f3660.f12356.setAlpha(1.0f);
        this.f3660.f12355.setAlpha(0.0f);
        FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) this.f3660.f12357.getLayoutParams();
        layoutParams5.width = (int) ((C4792.m14375().m14476(108) * fM14434) + 0.5f);
        layoutParams5.height = (int) ((C4792.m14375().m14476(325) * fM14434) + 0.5f);
        this.f3660.f12357.setLayoutParams(layoutParams5);
        int iM144765 = (int) ((C4792.m14375().m14476(C4792.m14375().m14401()) * fM14434) + 0.5f);
        FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) this.f3660.f12351.getLayoutParams();
        float f = iM144765 * 2;
        layoutParams6.width = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * fM14434) + 0.5f + f);
        layoutParams6.height = (int) ((C4792.m14375().m14476(C4792.m14375().m14399()) * fM14434) + 0.5f + f);
        this.f3660.f12351.setLayoutParams(layoutParams6);
        this.f3660.f12351.setPadding(iM144765, 0, iM144765, 0);
        FrameLayout.LayoutParams layoutParams7 = (FrameLayout.LayoutParams) this.f3660.f12350.getLayoutParams();
        layoutParams7.width = (int) ((C4792.m14375().m14476(37) * fM14434) + 0.5f);
        int iM144766 = (int) ((C4792.m14375().m14476(37) * fM14434) + 0.5f);
        layoutParams7.height = iM144766;
        layoutParams7.leftMargin = layoutParams.leftMargin + ((layoutParams.width - layoutParams7.width) / 2);
        layoutParams7.topMargin = (((iM144763 - layoutParams.height) / 2) - iM144766) - this.f3665;
        this.f3660.f12350.setLayoutParams(layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.f3660.f12349.getLayoutParams();
        layoutParams8.width = layoutParams7.width;
        layoutParams8.height = layoutParams7.height;
        layoutParams8.leftMargin = layoutParams7.leftMargin;
        int i2 = layoutParams.height;
        layoutParams8.topMargin = ((iM144763 - i2) / 2) + i2 + this.f3665;
        this.f3660.f12349.setLayoutParams(layoutParams8);
        this.f3666 = layoutParams7.topMargin;
        this.f3667 = layoutParams8.topMargin;
        this.f3668 = layoutParams7.leftMargin;
        this.f3662 = C3947.m12727().m12749();
        InterfaceC1302 interfaceC1302 = this.f3661;
        if (interfaceC1302 != null) {
            interfaceC1302.m3587();
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m3582() {
        this.f3660.f12348.setOnProChange(new C1293());
        this.f3660.f12354.setOnProChange(new C1294());
        this.f3660.f12346.setOnProChange(new C1295());
        this.f3660.f12348.setOnTouchStateChange(new C1296());
        this.f3660.f12354.setOnTouchStateChange(new C1297());
        this.f3660.f12346.setOnTouchStateChange(new C1298());
        this.f3660.f12352.setOnClickListener(new ViewOnClickListenerC1299());
        this.f3660.f12353.setOnClickListener(new ViewOnClickListenerC1300());
        this.f3660.f12351.setOnClickListener(new ViewOnClickListenerC1301());
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m3583() {
        float fM14434 = C4792.m14375().m14434();
        String upperCase = getResources().getString(R.string.RECORDING_WHEELS_ISO).toUpperCase();
        this.f3660.f12356.setText(upperCase);
        this.f3660.f12356.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3660.f12356.setContentTextColor(C4792.m14375().m14431());
        String upperCase2 = getResources().getString(R.string.RECORDING_WHEELS_EXPOSURE).toUpperCase();
        this.f3660.f12355.setText(upperCase2);
        this.f3660.f12355.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3660.f12355.setContentTextColor(-1);
        String upperCase3 = getResources().getString(R.string.RECORDING_INFO_SHUTTER).toUpperCase();
        this.f3660.f12358.setText(upperCase3);
        this.f3660.f12358.m2562(0, C4792.m14375().m14377() * fM14434);
        this.f3660.f12358.setContentTextColor(-1);
        this.f3660.f12355.setAlpha(0.0f);
        this.f3660.f12356.setAlpha(1.0f);
        this.f3660.f12355.post(new RunnableC1292(upperCase, upperCase3, upperCase2));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3584() {
        if (this.f3660.f12346.isEnabled()) {
            this.f3660.f12346.setPro(C3947.m12727().m12734());
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m3585() {
        if (this.f3660.f12348.isEnabled()) {
            float fM12738 = C3947.m12727().m12738();
            if (r1.m8144(C3947.m12727().m12748())) {
                int iM12751 = C3947.m12727().m12751();
                int iM12752 = C3947.m12727().m12752();
                int i = iM12751 - iM12752;
                float f = fM12738 - iM12752;
                float f2 = 1.0f;
                float f3 = (f * 1.0f) / i;
                if (f3 < 0.0f) {
                    f2 = 0.0f;
                } else if (f3 <= 1.0f) {
                    f2 = f3;
                }
                this.f3660.f12348.setPro(C3947.m12727().m12750(f2));
            }
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m3586() {
        if (this.f3660.f12354.isEnabled()) {
            float fM12739 = C3947.m12727().m12739();
            List<Float> listM12740 = C3947.m12727().m12740();
            if (r1.m8144(listM12740)) {
                float fFloatValue = listM12740.get(0).floatValue();
                float fFloatValue2 = listM12740.get(listM12740.size() - 1).floatValue();
                float fM3580 = m3580(fM12739, fFloatValue2, fFloatValue - fFloatValue2);
                if (fM3580 < 0.0f) {
                    fM3580 = 0.0f;
                } else if (fM3580 > 1.0f) {
                    fM3580 = 1.0f;
                }
                if (!C3947.m12727().m12764()) {
                    fM3580 = C3947.m12727().m12743(fM3580);
                }
                this.f3660.f12354.setPro(fM3580);
            }
        }
    }

    public PortraitIsoEtWheel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PortraitIsoEtWheel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3663 = 47;
        this.f3669 = -1;
        this.f3660 = AbstractC3552.m11493(LayoutInflater.from(getContext()), this, true);
        m3581();
        m3583();
        m3582();
        m3578();
    }
}
