package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.StrokeTextViewWithBottomBlock;
import com.blink.academy.protake.R;
import defpackage.AbstractC3117;
import defpackage.C4792;

/* loaded from: classes.dex */
public class MonitorUnitView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3117 f4802;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4803;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4804;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f4805;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4806;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f4807;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f4808;

    /* renamed from: ֏, reason: contains not printable characters */
    public InterfaceC1755 f4809;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1750 implements View.OnClickListener {
        public ViewOnClickListenerC1750() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorUnitView.this.f4803 = 1;
            MonitorUnitView.this.m4643();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1751 implements View.OnClickListener {
        public ViewOnClickListenerC1751() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorUnitView.this.f4803 = 2;
            MonitorUnitView.this.m4643();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1752 implements View.OnClickListener {
        public ViewOnClickListenerC1752() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorUnitView.this.f4803 = 3;
            MonitorUnitView.this.m4643();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1753 implements View.OnClickListener {
        public ViewOnClickListenerC1753() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorUnitView.this.f4803 = 4;
            MonitorUnitView.this.m4643();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1754 implements View.OnClickListener {
        public ViewOnClickListenerC1754() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MonitorUnitView.this.f4803 = 5;
            MonitorUnitView.this.m4643();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$ՠ, reason: contains not printable characters */
    public interface InterfaceC1755 {
        /* renamed from: Ϳ */
        void mo4547(int i, boolean z);

        /* renamed from: Ԩ */
        void mo4548(boolean z, boolean z2);

        /* renamed from: ԩ */
        int mo4549();
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$ֈ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1756 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public StrokeTextViewWithBottomBlock f4815;

        /* renamed from: com.blink.academy.film.widgets.transmit.monitor.MonitorUnitView$ֈ$Ϳ, reason: contains not printable characters */
        public class RunnableC1757 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4816;

            public RunnableC1757(View view) {
                this.f4816 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4816.isEnabled()) {
                    ViewOnTouchListenerC1756.this.f4815.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1756(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock) {
            this.f4815 = strokeTextViewWithBottomBlock;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (this.f4815.m2574()) {
                    return false;
                }
                this.f4815.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler(Looper.myLooper()).postDelayed(new RunnableC1757(view), 100L);
            return false;
        }
    }

    public MonitorUnitView(@NonNull Context context) {
        super(context);
        m4640();
    }

    public float getBottomLineHeight() {
        return C4792.m14375().m14467();
    }

    public int getTotalHeight() {
        return this.f4808;
    }

    public int getTotalWidth() {
        return this.f4807;
    }

    public void setOnChangeListener(InterfaceC1755 interfaceC1755) {
        this.f4809 = interfaceC1755;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4639(int i) {
        if (i == -1) {
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            m4644(this.f4802.f11075, true);
            m4646(this.f4802.f11075, true);
            return;
        }
        if (i == 0) {
            m4644(this.f4802.f11072, true);
            m4646(this.f4802.f11072, true);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            m4646(this.f4802.f11075, false);
            return;
        }
        if (i == 1) {
            m4644(this.f4802.f11073, true);
            m4646(this.f4802.f11073, true);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11076, false);
            m4646(this.f4802.f11075, false);
            return;
        }
        if (i == 2) {
            m4644(this.f4802.f11074, true);
            m4646(this.f4802.f11074, true);
            m4646(this.f4802.f11076, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11075, false);
            return;
        }
        if (i != 3) {
            return;
        }
        m4644(this.f4802.f11076, true);
        m4646(this.f4802.f11076, true);
        m4646(this.f4802.f11072, false);
        m4646(this.f4802.f11073, false);
        m4646(this.f4802.f11074, false);
        m4646(this.f4802.f11075, false);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4640() {
        this.f4802 = AbstractC3117.m10705(LayoutInflater.from(getContext()), this, true);
        m4641();
        m4642();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4641() {
        Typeface typefaceM404 = FilmApp.m404();
        int iM14381 = C4792.m14375().m14381();
        float fM14434 = C4792.m14375().m14434();
        this.f4804 = C4792.m14375().m14420() + ((int) (C4792.m14375().m14464() / 2.0f));
        int iM14459 = C4792.m14375().m14459();
        this.f4805 = (int) ((C4792.m14375().m14476(100) * fM14434) - this.f4804);
        this.f4806 = C4792.m14375().m14480(10.0f, fM14434);
        int iM14480 = C4792.m14375().m14480(15.0f, fM14434);
        float f = iM14381;
        this.f4802.f11072.m2576(0, f);
        this.f4802.f11072.setPadding(iM14459, this.f4806, this.f4805, iM14480);
        float[] fArrM2578 = this.f4802.f11072.m2578("A");
        float f2 = fArrM2578[0];
        float f3 = fArrM2578[1];
        this.f4802.f11072.m2575(false, 0);
        this.f4802.f11072.setTextFont(typefaceM404);
        m4644(this.f4802.f11072, false);
        this.f4802.f11073.m2576(0, f);
        this.f4802.f11073.setPadding(this.f4804, this.f4806, this.f4805, iM14480);
        float f4 = this.f4802.f11073.m2578(TransmitHelper.CAMERA_UNIT_B_CONTENT)[0];
        this.f4802.f11073.m2575(false, 0);
        this.f4802.f11073.setTextFont(typefaceM404);
        m4644(this.f4802.f11073, false);
        this.f4802.f11074.m2576(0, f);
        this.f4802.f11074.setPadding(this.f4804, this.f4806, this.f4805, iM14480);
        float f5 = this.f4802.f11074.m2578(TransmitHelper.CAMERA_UNIT_C_CONTENT)[0];
        this.f4802.f11074.m2575(false, 0);
        this.f4802.f11074.setTextFont(typefaceM404);
        m4644(this.f4802.f11074, false);
        this.f4802.f11076.m2576(0, f);
        this.f4802.f11076.setPadding(this.f4804, this.f4806, this.f4805, iM14480);
        float f6 = this.f4802.f11076.m2578(TransmitHelper.CAMERA_UNIT_D_CONTENT)[0];
        this.f4802.f11076.m2575(false, 0);
        this.f4802.f11076.setTextFont(typefaceM404);
        m4644(this.f4802.f11076, false);
        this.f4802.f11075.m2576(0, f);
        this.f4802.f11075.setPadding(this.f4804, this.f4806, 0, iM14480);
        float f7 = this.f4802.f11075.m2578(getResources().getString(R.string.MONITOR_BUTTON_CLOSE))[0];
        this.f4802.f11075.setTextFont(typefaceM404);
        this.f4802.f11075.m2575(true, 0);
        this.f4807 = (int) (iM14459 + (this.f4804 * 4) + (this.f4805 * 4) + f7 + f2 + f4 + f5 + f6);
        int i = this.f4806;
        this.f4808 = (int) (f3 + i + i + 0.5f);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4642() {
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock = this.f4802.f11072;
        strokeTextViewWithBottomBlock.setOnTouchListener(new ViewOnTouchListenerC1756(strokeTextViewWithBottomBlock));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock2 = this.f4802.f11073;
        strokeTextViewWithBottomBlock2.setOnTouchListener(new ViewOnTouchListenerC1756(strokeTextViewWithBottomBlock2));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock3 = this.f4802.f11074;
        strokeTextViewWithBottomBlock3.setOnTouchListener(new ViewOnTouchListenerC1756(strokeTextViewWithBottomBlock3));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock4 = this.f4802.f11076;
        strokeTextViewWithBottomBlock4.setOnTouchListener(new ViewOnTouchListenerC1756(strokeTextViewWithBottomBlock4));
        StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock5 = this.f4802.f11075;
        strokeTextViewWithBottomBlock5.setOnTouchListener(new ViewOnTouchListenerC1756(strokeTextViewWithBottomBlock5));
        this.f4802.f11072.setOnClickListener(new ViewOnClickListenerC1750());
        this.f4802.f11073.setOnClickListener(new ViewOnClickListenerC1751());
        this.f4802.f11074.setOnClickListener(new ViewOnClickListenerC1752());
        this.f4802.f11076.setOnClickListener(new ViewOnClickListenerC1753());
        this.f4802.f11075.setOnClickListener(new ViewOnClickListenerC1754());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4643() {
        InterfaceC1755 interfaceC1755 = this.f4809;
        if (interfaceC1755 == null) {
            return;
        }
        int i = this.f4803;
        if (i == 1) {
            interfaceC1755.mo4547(0, true);
            this.f4809.mo4548(true, false);
            m4646(this.f4802.f11072, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            return;
        }
        if (i == 2) {
            interfaceC1755.mo4547(1, true);
            this.f4809.mo4548(true, false);
            m4646(this.f4802.f11073, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            return;
        }
        if (i == 3) {
            interfaceC1755.mo4547(2, true);
            this.f4809.mo4548(true, false);
            m4646(this.f4802.f11074, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11076, false);
            return;
        }
        if (i == 4) {
            interfaceC1755.mo4547(3, true);
            this.f4809.mo4548(true, false);
            m4646(this.f4802.f11076, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11074, false);
            return;
        }
        if (i != 5) {
            return;
        }
        interfaceC1755.mo4547(-1, true);
        this.f4809.mo4548(false, true);
        m4646(this.f4802.f11072, false);
        m4646(this.f4802.f11073, false);
        m4646(this.f4802.f11074, false);
        m4646(this.f4802.f11076, false);
        m4646(this.f4802.f11075, true);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4644(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, boolean z) {
        float f = z ? 1.0f : 0.2f;
        strokeTextViewWithBottomBlock.setEnabled(z);
        strokeTextViewWithBottomBlock.setAlpha(f);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4645(int i) {
        if (i == 0) {
            m4646(this.f4802.f11072, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            return;
        }
        if (i == 1) {
            m4646(this.f4802.f11073, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            return;
        }
        if (i == 2) {
            m4646(this.f4802.f11074, true);
            m4646(this.f4802.f11075, false);
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11076, false);
            return;
        }
        if (i != 3) {
            m4646(this.f4802.f11072, false);
            m4646(this.f4802.f11073, false);
            m4646(this.f4802.f11074, false);
            m4646(this.f4802.f11076, false);
            m4646(this.f4802.f11075, true);
            return;
        }
        m4646(this.f4802.f11076, true);
        m4646(this.f4802.f11075, false);
        m4646(this.f4802.f11072, false);
        m4646(this.f4802.f11073, false);
        m4646(this.f4802.f11074, false);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4646(StrokeTextViewWithBottomBlock strokeTextViewWithBottomBlock, boolean z) {
        strokeTextViewWithBottomBlock.m2575(z, 100);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m4647() {
        if (this.f4809 == null) {
            return;
        }
        int iMachineCanConnect = FinderManager.getInstance().machineCanConnect("1");
        if (iMachineCanConnect > 0) {
            if (iMachineCanConnect > 1) {
                this.f4802.f11072.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
                this.f4802.f11072.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            } else {
                this.f4802.f11072.setTextColor(-1);
                this.f4802.f11072.setBottomBgColor(-1);
            }
            if (!this.f4802.f11072.isEnabled()) {
                m4644(this.f4802.f11072, true);
            }
            if (this.f4809.mo4549() == 0) {
                this.f4809.mo4548(true, false);
                if (!this.f4802.f11072.m2574()) {
                    m4645(0);
                }
            } else if (this.f4802.f11072.m2574()) {
                m4646(this.f4802.f11072, false);
            }
        } else {
            this.f4802.f11072.setTextColor(-1);
            this.f4802.f11072.setBottomBgColor(-1);
            if (this.f4802.f11072.m2574()) {
                m4646(this.f4802.f11072, false);
            }
            if (this.f4802.f11072.isEnabled()) {
                m4644(this.f4802.f11072, false);
            }
        }
        int iMachineCanConnect2 = FinderManager.getInstance().machineCanConnect("2");
        if (iMachineCanConnect2 > 0) {
            if (iMachineCanConnect2 > 1) {
                this.f4802.f11073.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
                this.f4802.f11073.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            } else {
                this.f4802.f11073.setTextColor(-1);
                this.f4802.f11073.setBottomBgColor(-1);
            }
            if (!this.f4802.f11073.isEnabled()) {
                m4644(this.f4802.f11073, true);
            }
            if (this.f4809.mo4549() == 1) {
                this.f4809.mo4548(true, false);
                if (!this.f4802.f11073.m2574()) {
                    m4645(1);
                }
            } else if (this.f4802.f11073.m2574()) {
                m4646(this.f4802.f11073, false);
            }
        } else {
            this.f4802.f11073.setTextColor(-1);
            this.f4802.f11073.setBottomBgColor(-1);
            if (this.f4802.f11073.m2574()) {
                m4646(this.f4802.f11073, false);
            }
            if (this.f4802.f11073.isEnabled()) {
                m4644(this.f4802.f11073, false);
            }
        }
        int iMachineCanConnect3 = FinderManager.getInstance().machineCanConnect(FinderManager.MACHINE_C);
        if (iMachineCanConnect3 > 0) {
            if (iMachineCanConnect3 > 1) {
                this.f4802.f11074.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
                this.f4802.f11074.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            } else {
                this.f4802.f11074.setTextColor(-1);
                this.f4802.f11074.setBottomBgColor(-1);
            }
            if (!this.f4802.f11074.isEnabled()) {
                m4644(this.f4802.f11074, true);
            }
            if (this.f4809.mo4549() == 2) {
                this.f4809.mo4548(true, false);
                if (!this.f4802.f11074.m2574()) {
                    m4645(2);
                }
            } else if (this.f4802.f11074.m2574()) {
                m4646(this.f4802.f11074, false);
            }
        } else {
            this.f4802.f11074.setTextColor(-1);
            this.f4802.f11074.setBottomBgColor(-1);
            if (this.f4802.f11074.m2574()) {
                this.f4802.f11074.m2575(false, 0);
            }
            if (this.f4802.f11074.isEnabled()) {
                m4644(this.f4802.f11074, false);
            }
        }
        int iMachineCanConnect4 = FinderManager.getInstance().machineCanConnect(FinderManager.MACHINE_D);
        if (iMachineCanConnect4 > 0) {
            if (iMachineCanConnect4 > 1) {
                this.f4802.f11076.setTextColor(getResources().getColor(R.color.colorTransmitBlue, null));
                this.f4802.f11076.setBottomBgColor(getResources().getColor(R.color.colorTransmitBlue, null));
            } else {
                this.f4802.f11076.setTextColor(-1);
                this.f4802.f11076.setBottomBgColor(-1);
            }
            if (!this.f4802.f11076.isEnabled()) {
                m4644(this.f4802.f11076, true);
            }
            if (this.f4809.mo4549() == 3) {
                this.f4809.mo4548(true, false);
                if (!this.f4802.f11076.m2574()) {
                    m4645(3);
                }
            } else if (this.f4802.f11076.m2574()) {
                m4646(this.f4802.f11076, false);
            }
        } else {
            this.f4802.f11076.setTextColor(-1);
            this.f4802.f11076.setBottomBgColor(-1);
            if (this.f4802.f11076.m2574()) {
                m4646(this.f4802.f11076, false);
            }
            if (this.f4802.f11076.isEnabled()) {
                m4644(this.f4802.f11076, false);
            }
        }
        if (this.f4809.mo4549() != -1) {
            if (this.f4802.f11075.isEnabled()) {
                return;
            }
            m4644(this.f4802.f11075, true);
        } else {
            this.f4809.mo4548(false, true);
            if (this.f4802.f11075.m2574()) {
                return;
            }
            m4645(-1);
        }
    }

    public MonitorUnitView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m4640();
    }

    public MonitorUnitView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4640();
    }
}
