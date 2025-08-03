package com.blink.academy.film.widgets.setting;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.widgets.SwitchButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC5308;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4792;

/* loaded from: classes.dex */
public class RecordSettingPage2View extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC5308 f4055;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f4056;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f4057;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1470 f4058;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC1471 f4059;

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$Ϳ, reason: contains not printable characters */
    public class C1465 implements SwitchButton.InterfaceC0969 {
        public C1465() {
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ϳ */
        public boolean mo2143() {
            return true;
        }

        @Override // com.blink.academy.film.widgets.SwitchButton.InterfaceC0969
        /* renamed from: Ԩ */
        public void mo2144(SwitchButton switchButton, boolean z) {
            C2618.m9570("hdmi_performance_sp", z);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1466 implements View.OnClickListener {
        public ViewOnClickListenerC1466() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RecordSettingPage2View.this.f4059 != null) {
                RecordSettingPage2View.this.f4059.mo4053();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$Ԫ, reason: contains not printable characters */
    public class RunnableC1467 implements Runnable {
        public RunnableC1467() {
        }

        @Override // java.lang.Runnable
        public void run() {
            float fMeasureText = RecordSettingPage2View.this.f4055.f17559.getPaint().measureText(RecordSettingPage2View.this.getResources().getString(R.string.SETTINGS_PERFORMANCE_MODE).toUpperCase());
            ViewGroup.LayoutParams layoutParams = RecordSettingPage2View.this.f4055.f17559.getLayoutParams();
            layoutParams.width = (int) (fMeasureText + C4792.f16138);
            RecordSettingPage2View.this.f4055.f17559.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$Ԭ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1468 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4063;

        /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC1469 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4064;

            public RunnableC1469(View view) {
                this.f4064 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4064.isEnabled()) {
                    ViewOnTouchListenerC1468.this.f4063.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1468(View view) {
            this.f4063 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4063.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1469(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1470 {
    }

    /* renamed from: com.blink.academy.film.widgets.setting.RecordSettingPage2View$ՠ, reason: contains not printable characters */
    public interface InterfaceC1471 {
        /* renamed from: Ϳ */
        void mo4053();
    }

    public RecordSettingPage2View(Context context) {
        this(context, null);
    }

    public void setOnButtonClick(InterfaceC1470 interfaceC1470) {
        this.f4058 = interfaceC1470;
    }

    public void setOnInfoClick(InterfaceC1471 interfaceC1471) {
        this.f4059 = interfaceC1471;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4056() {
        this.f4055 = AbstractC5308.m15362(LayoutInflater.from(getContext()), this, true);
        m4057();
        m4058();
        m4059();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4057() {
        this.f4056 = C2579.m9444();
        this.f4057 = C2579.m9440(getContext());
        float fM14471 = C4792.m14375().m14471();
        int iM14468 = C4792.m14375().m14468();
        int i = (this.f4056 - (iM14468 * 2)) / 4;
        int iM14377 = (int) ((C4792.m14375().m14377() * fM14471) + 0.5f);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4055.f17559.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 0;
        this.f4055.f17559.setLayoutParams(layoutParams);
        this.f4055.f17559.setContentTextColor(-1);
        float fM14397 = (int) ((C4792.m14375().m14397() * fM14471) + 0.5f);
        this.f4055.f17559.m2562(0, fM14397);
        this.f4055.f17559.m2561(getResources().getString(R.string.SETTINGS_PERFORMANCE_MODE));
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4055.f17556.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = iM14468;
        this.f4055.f17556.setLayoutParams(layoutParams2);
        this.f4055.f17556.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4055.f17554.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = (int) ((C4792.m14375().m14381() - this.f4055.f17556.getViewRealPadding()) + C4792.m14375().m14443() + 0.5f);
        int i2 = this.f4057;
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = (int) ((i2 * 0.05227882f * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = (int) ((i2 * 0.05227882f * fM14471) + 0.5f);
        this.f4055.f17554.setLayoutParams(layoutParams3);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4055.f17562.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = C2579.m9438(30.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = C2579.m9438(30.0f);
        this.f4055.f17562.setLayoutParams(layoutParams4);
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4055.f17557.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = iM14468;
        this.f4055.f17557.setLayoutParams(layoutParams5);
        this.f4055.f17557.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4055.f17561.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f4055.f17561.setLayoutParams(layoutParams6);
        this.f4055.f17561.setContentTextColor(-1);
        this.f4055.f17561.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4055.f17558.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = (int) (C4792.m14375().m14389() - (C2579.m9438(2.5f) + C4792.m14375().m14443()));
        this.f4055.f17558.setLayoutParams(layoutParams7);
        this.f4055.f17558.setContentTextColor(-1);
        this.f4055.f17558.m2562(0, fM14397);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4055.f17552.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = C4792.m14375().m14377();
        this.f4055.f17552.setLayoutParams(layoutParams8);
        float fM14384 = (int) ((C4792.m14375().m14384() * fM14471) + 0.5f);
        this.f4055.f17552.m2576(0, fM14384);
        this.f4055.f17552.setTextColor(-1);
        this.f4055.f17552.setTextForSetting("50 Hz");
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4055.f17553.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin = C4792.m14375().m14385();
        this.f4055.f17553.setLayoutParams(layoutParams9);
        this.f4055.f17553.m2576(0, fM14384);
        this.f4055.f17553.setTextColor(-1);
        this.f4055.f17553.setTextForSetting("60 Hz");
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f4055.f17555.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams10).width = (int) ((C4792.m14375().m14410() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams10).height = (int) ((C4792.m14375().m14409() * fM14471) + 0.5f);
        ((ViewGroup.MarginLayoutParams) layoutParams10).topMargin = iM14377;
        ((ViewGroup.MarginLayoutParams) layoutParams10).leftMargin = i;
        this.f4055.f17555.setLayoutParams(layoutParams10);
        this.f4055.f17555.setTextSize(C4792.m14375().m14481() * fM14471);
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f4055.f17560.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).leftMargin = (int) (C2579.m9438(2.5f) + C4792.m14375().m14443());
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin;
        this.f4055.f17560.setLayoutParams(layoutParams11);
        this.f4055.f17560.setContentTextColor(-1);
        this.f4055.f17560.m2562(0, fM14397);
        m4060();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4058() {
        ImageView imageView = this.f4055.f17554;
        imageView.setOnTouchListener(new ViewOnTouchListenerC1468(imageView));
        this.f4055.f17556.setOnCheckedChangeListener(new C1465());
        this.f4055.f17554.setOnClickListener(new ViewOnClickListenerC1466());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4059() {
        this.f4055.f17556.m2630(false, C2618.m9565("hdmi_performance_sp", true));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4060() {
        this.f4055.f17559.setDrawBorder(false);
        this.f4055.f17559.post(new RunnableC1467());
    }

    public RecordSettingPage2View(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordSettingPage2View(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4056();
    }
}
