package com.blink.academy.film.widgets.setting.portrait;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC3567;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4451;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.C5213;
import defpackage.n;
import defpackage.r1;

/* loaded from: classes.dex */
public class ProtakeSignInPortraitSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3567 f4149;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f4150;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f4151;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC1547 f4152;

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1534 implements View.OnClickListener {
        public ViewOnClickListenerC1534() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1547 interfaceC1547 = ProtakeSignInPortraitSettingView.this.f4152;
            if (interfaceC1547 != null) {
                interfaceC1547.mo1758();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1535 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC1536 implements Runnable {
            public RunnableC1536() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ProtakeSignInPortraitSettingView.this.f4152.mo1756();
            }
        }

        public ViewOnClickListenerC1535() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProtakeSignInPortraitSettingView protakeSignInPortraitSettingView = ProtakeSignInPortraitSettingView.this;
            if (protakeSignInPortraitSettingView.f4152 != null) {
                protakeSignInPortraitSettingView.m4140(true);
                new Handler().postDelayed(new RunnableC1536(), 100L);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1537 implements View.OnClickListener {
        public ViewOnClickListenerC1537() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1547 interfaceC1547 = ProtakeSignInPortraitSettingView.this.f4152;
            if (interfaceC1547 != null) {
                interfaceC1547.mo1757();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1538 implements View.OnClickListener {
        public ViewOnClickListenerC1538() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1547 interfaceC1547 = ProtakeSignInPortraitSettingView.this.f4152;
            if (interfaceC1547 != null) {
                interfaceC1547.mo1760();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1539 implements View.OnClickListener {
        public ViewOnClickListenerC1539() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1547 interfaceC1547 = ProtakeSignInPortraitSettingView.this.f4152;
            if (interfaceC1547 != null) {
                interfaceC1547.mo1759();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1540 implements View.OnClickListener {
        public ViewOnClickListenerC1540() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1547 interfaceC1547 = ProtakeSignInPortraitSettingView.this.f4152;
            if (interfaceC1547 != null) {
                interfaceC1547.mo1755();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1541 implements View.OnClickListener {
        public ViewOnClickListenerC1541() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1547 interfaceC1547 = ProtakeSignInPortraitSettingView.this.f4152;
            if (interfaceC1547 != null) {
                interfaceC1547.mo1754();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$֏, reason: contains not printable characters */
    public class C1542 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4161;

        public C1542(boolean z) {
            this.f4161 = z;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ProtakeSignInPortraitSettingView.this.f4149.f12414.setEnabled(!this.f4161);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ׯ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1543 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public RoundButton f4163;

        /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC1544 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4164;

            public RunnableC1544(View view) {
                this.f4164 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4164.isEnabled()) {
                    ViewOnTouchListenerC1543.this.f4163.setContentAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1543(RoundButton roundButton) {
            this.f4163 = roundButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4163.setContentAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1544(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ؠ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1545 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4166;

        /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ؠ$Ϳ, reason: contains not printable characters */
        public class RunnableC1546 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4167;

            public RunnableC1546(View view) {
                this.f4167 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4167.isEnabled()) {
                    ViewOnTouchListenerC1545.this.f4166.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1545(View view) {
            this.f4166 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4166.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1546(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView$ހ, reason: contains not printable characters */
    public interface InterfaceC1547 {
        /* renamed from: Ϳ */
        void mo1754();

        /* renamed from: Ԩ */
        void mo1755();

        /* renamed from: ԩ */
        void mo1756();

        /* renamed from: Ԫ */
        void mo1757();

        /* renamed from: ԫ */
        void mo1758();

        /* renamed from: Ԭ */
        void mo1759();

        /* renamed from: ԭ */
        void mo1760();
    }

    public ProtakeSignInPortraitSettingView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnClickListener(InterfaceC1547 interfaceC1547) {
        this.f4152 = interfaceC1547;
    }

    public void setSignState(boolean z) {
        if (!z) {
            m4137(this.f4149.f12432, R.string.LABEL_SIGN_IN);
            this.f4149.f12417.setVisibility(8);
            return;
        }
        m4137(this.f4149.f12432, R.string.LABEL_SIGN_OUT);
        if (C5213.m15212()) {
            this.f4149.f12417.setVisibility(0);
        } else {
            this.f4149.f12417.setVisibility(8);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m4131(int i) {
        return C4792.m14375().m14477(i, this.f4150);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4132() {
        this.f4149 = AbstractC3567.m11520(LayoutInflater.from(getContext()), this, true);
        m4133();
        m4134();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4133() {
        this.f4150 = C4792.m14375().m14471();
        this.f4149.f12419.setPadding(C4792.m14375().m14468(), 0, C4792.m14375().m14468(), 0);
        this.f4149.f12398.m2540(C4792.m14375().m14431()).m2536(true).m2542(m4131(60)).m2539(0, C4792.m14375().m14378() * this.f4150).m2538(ViewCompat.MEASURED_STATE_MASK).m2537(getResources().getString(R.string.BUTTON_SUBSCRIBE).toUpperCase()).m2534();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4149.f12398.getLayoutParams();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14378() * this.f4150);
        textPaint.setTypeface(FilmApp.m404());
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (textPaint.measureText(getResources().getString(R.string.BUTTON_SUBSCRIBE).toUpperCase()) + C4792.m14375().m14476(108));
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.m14375().m14476(60));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m4131(50);
        this.f4149.f12398.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4149.f12435.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = m4131(2);
        this.f4149.f12435.setLayoutParams(layoutParams2);
        this.f4149.f12435.setBackgroundColor(-1);
        this.f4149.f12431.setPadding(0, m4131(30), 0, 0);
        this.f4149.f12426.setPadding(0, m4131(30), 0, 0);
        this.f4149.f12433.setPadding(0, m4131(30), 0, 0);
        this.f4149.f12415.setPadding(m4131(40), m4131(50), m4131(40), m4131(50));
        this.f4149.f12417.setPadding(m4131(40), m4131(50), m4131(40), m4131(50));
        this.f4149.f12414.setPadding(m4131(40), m4131(50), m4131(40), m4131(50));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f4149.f12408.getLayoutParams();
        layoutParams3.topMargin = m4131(115);
        this.f4149.f12408.setLayoutParams(layoutParams3);
        m4136();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4149.f12418.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = m4131(60);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = m4131(60);
        this.f4149.f12418.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f4149.f12432.getLayoutParams();
        layoutParams5.leftMargin = m4131(10);
        this.f4149.f12432.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f4149.f12405.getLayoutParams();
        layoutParams6.width = m4131(50);
        layoutParams6.height = m4131(50);
        this.f4149.f12405.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f4149.f12430.getLayoutParams();
        layoutParams7.leftMargin = m4131(10);
        this.f4149.f12430.setLayoutParams(layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f4149.f12404.getLayoutParams();
        layoutParams8.width = m4131(50);
        layoutParams8.height = m4131(50);
        this.f4149.f12404.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f4149.f12403.getLayoutParams();
        layoutParams9.width = m4131(150);
        layoutParams9.height = m4131(150);
        layoutParams9.bottomMargin = m4131(30);
        this.f4149.f12403.setLayoutParams(layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.f4149.f12401.getLayoutParams();
        layoutParams10.width = layoutParams9.width;
        layoutParams10.height = layoutParams9.height;
        layoutParams10.bottomMargin = m4131(30);
        this.f4149.f12401.setLayoutParams(layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.f4149.f12400.getLayoutParams();
        layoutParams11.width = layoutParams9.width;
        layoutParams11.height = layoutParams9.height;
        layoutParams11.bottomMargin = m4131(30);
        this.f4149.f12400.setLayoutParams(layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) this.f4149.f12402.getLayoutParams();
        layoutParams12.width = layoutParams9.width;
        layoutParams12.height = layoutParams9.height;
        layoutParams12.bottomMargin = m4131(30);
        this.f4149.f12402.setLayoutParams(layoutParams9);
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) this.f4149.f12399.getLayoutParams();
        layoutParams13.width = layoutParams9.width;
        layoutParams13.height = layoutParams9.height;
        layoutParams13.bottomMargin = m4131(30);
        this.f4149.f12399.setLayoutParams(layoutParams13);
        LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) this.f4149.f12410.getLayoutParams();
        layoutParams14.leftMargin = m4131(115);
        this.f4149.f12410.setLayoutParams(layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.f4149.f12409.getLayoutParams();
        layoutParams15.leftMargin = m4131(115);
        this.f4149.f12409.setLayoutParams(layoutParams15);
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) this.f4149.f12407.getLayoutParams();
        layoutParams16.leftMargin = m4131(115);
        this.f4149.f12407.setLayoutParams(layoutParams16);
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f4149.f12428.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).topMargin = C2579.m9438(65.0f);
        this.f4149.f12428.setLayoutParams(layoutParams17);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f4149.f12426.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).leftMargin = m4131(50);
        this.f4149.f12426.setLayoutParams(layoutParams18);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f4149.f12433.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams19).leftMargin = m4131(50);
        this.f4149.f12433.setLayoutParams(layoutParams19);
        this.f4149.f12424.setPadding(0, 0, 0, m4131(15));
        m4139(this.f4149.f12429, C4792.m14375().m14482() * this.f4150, R.string.PROTAKE_PLUS_FEATURE_MANUAL);
        m4139(this.f4149.f12425, C4792.m14375().m14482() * this.f4150, R.string.PROTAKE_PLUS_FEATURE_LOOKS);
        m4139(this.f4149.f12423, C4792.m14375().m14482() * this.f4150, R.string.PROTAKE_PLUS_FEATURE_DATA);
        m4139(this.f4149.f12427, C4792.m14375().m14482() * this.f4150, R.string.PROTAKE_PLUS_FEATURE_PRESETS);
        m4139(this.f4149.f12422, C4792.m14375().m14482() * this.f4150, R.string.PROTAKE_PLUS_FEATURE_ACCESSORIES);
        m4139(this.f4149.f12428, C4792.m14375().m14378() * this.f4150, R.string.TEXT_INFO_SUBSCRIPTION_3);
        m4139(this.f4149.f12431, C4792.m14375().m14482() * this.f4150, R.string.BUTTON_TERMS_OF_USE);
        m4139(this.f4149.f12426, C4792.m14375().m14482() * this.f4150, R.string.BUTTON_PRIVACY_POLICY);
        m4139(this.f4149.f12433, C4792.m14375().m14482() * this.f4150, R.string.CONTACT_SUPPORT);
        m4139(this.f4149.f12432, C4792.m14375().m14378() * this.f4150, R.string.LABEL_SIGN_IN);
        m4139(this.f4149.f12430, C4792.m14375().m14378() * this.f4150, R.string.BUTTON_RESTORE_PURCHASE);
        m4139(this.f4149.f12434, C4792.m14375().m14378(), R.string.LABEL_DEACTIVATE_ACCOUNT);
        ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f4149.f12434.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams20).leftMargin = m4131(20);
        this.f4149.f12434.setLayoutParams(layoutParams20);
        m4139(this.f4149.f12424, C4792.m14375().m14482() * this.f4150, R.string.TEXT_INFO_SUBSCRIPTION_5);
        if (C4843.m14569().m14570() != 0) {
            this.f4149.f12424.setVisibility(8);
        } else {
            this.f4149.f12424.setVisibility(8);
        }
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f4149.f12424.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams21).topMargin = m4131(17);
        this.f4149.f12424.setLayoutParams(layoutParams21);
        int iM9438 = C2579.m9438(20.0f);
        ConstraintLayout.LayoutParams layoutParams22 = (ConstraintLayout.LayoutParams) this.f4149.f12437.getLayoutParams();
        TextPaint paint = this.f4149.f12431.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams22).width = (int) (paint.measureText(getResources().getString(R.string.BUTTON_TERMS_OF_USE).toUpperCase()) + (m4131(20) * 2));
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        float f = iM9438;
        ((ViewGroup.MarginLayoutParams) layoutParams22).height = ((int) ((fontMetrics2.bottom - fontMetrics2.top) + f)) * 2;
        this.f4149.f12437.setLayoutParams(layoutParams22);
        ConstraintLayout.LayoutParams layoutParams23 = (ConstraintLayout.LayoutParams) this.f4149.f12436.getLayoutParams();
        TextPaint paint2 = this.f4149.f12426.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams23).width = (int) (paint2.measureText(getResources().getString(R.string.BUTTON_PRIVACY_POLICY).toUpperCase()) + (m4131(20) * 2));
        Paint.FontMetrics fontMetrics3 = paint2.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams23).height = ((int) ((fontMetrics3.bottom - fontMetrics3.top) + f)) * 2;
        this.f4149.f12436.setLayoutParams(layoutParams23);
        ConstraintLayout.LayoutParams layoutParams24 = (ConstraintLayout.LayoutParams) this.f4149.f12438.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams24).width = (int) (this.f4149.f12433.getPaint().measureText(getResources().getString(R.string.CONTACT_SUPPORT).toUpperCase()) + (m4131(20) * 2));
        Paint.FontMetrics fontMetrics4 = paint2.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams24).height = ((int) ((fontMetrics4.bottom - fontMetrics4.top) + f)) * 2;
        this.f4149.f12438.setLayoutParams(layoutParams24);
        ConstraintLayout.LayoutParams layoutParams25 = (ConstraintLayout.LayoutParams) this.f4149.f12406.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams25).width = m4131(30);
        ((ViewGroup.MarginLayoutParams) layoutParams25).height = m4131(30);
        Paint.FontMetrics fontMetrics5 = this.f4149.f12434.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams25).topMargin = (int) (((fontMetrics5.bottom - fontMetrics5.top) - (fontMetrics5.descent - fontMetrics5.ascent)) / 2.0f);
        this.f4149.f12406.setLayoutParams(layoutParams25);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4134() {
        RoundButton roundButton = this.f4149.f12398;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC1543(roundButton));
        this.f4149.f12398.setOnClickListener(new ViewOnClickListenerC1534());
        LinearLayout linearLayout = this.f4149.f12414;
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC1545(linearLayout));
        this.f4149.f12414.setOnClickListener(new ViewOnClickListenerC1535());
        LinearLayout linearLayout2 = this.f4149.f12415;
        linearLayout2.setOnTouchListener(new ViewOnTouchListenerC1545(linearLayout2));
        this.f4149.f12415.setOnClickListener(new ViewOnClickListenerC1537());
        AbstractC3567 abstractC3567 = this.f4149;
        abstractC3567.f12437.setOnTouchListener(new ViewOnTouchListenerC1545(abstractC3567.f12431));
        this.f4149.f12437.setOnClickListener(new ViewOnClickListenerC1538());
        AbstractC3567 abstractC35672 = this.f4149;
        abstractC35672.f12436.setOnTouchListener(new ViewOnTouchListenerC1545(abstractC35672.f12426));
        this.f4149.f12436.setOnClickListener(new ViewOnClickListenerC1539());
        AbstractC3567 abstractC35673 = this.f4149;
        abstractC35673.f12438.setOnTouchListener(new ViewOnTouchListenerC1545(abstractC35673.f12433));
        this.f4149.f12438.setOnClickListener(new ViewOnClickListenerC1540());
        ConstraintLayout constraintLayout = this.f4149.f12417;
        constraintLayout.setOnTouchListener(new ViewOnTouchListenerC1545(constraintLayout));
        this.f4149.f12417.setOnClickListener(new ViewOnClickListenerC1541());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4135() throws Resources.NotFoundException {
        String strM7593 = n.m7588().m7593();
        String strM7606 = n.m7588().m7606();
        n.m7588().m7598();
        if (this.f4149.f12428 != null) {
            String string = getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_3);
            String str = string + getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_3_1);
            if (!r1.m8143(strM7593)) {
                m4138(this.f4149.f12428, String.format(str, strM7606));
                return;
            }
            String str2 = str + getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_2);
            this.f4149.f12428.setText(C4451.m13715(String.format(str2, strM7606, strM7593), string.length(), String.format(str2, strM7606, strM7593).length() - 1));
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4136() {
        boolean z = C4843.m14569().m14570() != 0;
        this.f4151 = z;
        if (z) {
            this.f4149.f12414.setVisibility(0);
            this.f4149.f12418.setVisibility(0);
        } else {
            this.f4149.f12414.setVisibility(8);
            this.f4149.f12418.setVisibility(8);
        }
        m4140(false);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4137(TextView textView, int i) {
        m4138(textView, getResources().getString(i));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4138(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m4139(TextView textView, float f, int i) {
        textView.setTypeface(FilmApp.m404());
        textView.setTextSize(0, f);
        if (i != 0) {
            textView.setText(getResources().getString(i));
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4140(boolean z) {
        C4008.m12877(this.f4149.f12414, z ? 0.0f : 1.0f, 100, null);
        C4008.m12877(this.f4149.f12418, z ? 1.0f : 0.0f, 100, new C1542(z));
    }

    public ProtakeSignInPortraitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtakeSignInPortraitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4132();
    }
}
