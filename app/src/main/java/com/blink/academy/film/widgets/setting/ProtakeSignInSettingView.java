package com.blink.academy.film.widgets.setting;

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
import defpackage.AbstractC2860;
import defpackage.AbstractC4012;
import defpackage.C4008;
import defpackage.C4451;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.C5213;
import defpackage.n;
import defpackage.r1;

/* loaded from: classes.dex */
public class ProtakeSignInSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2860 f4024;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f4025;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1459 f4026;

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1445 implements View.OnClickListener {
        public ViewOnClickListenerC1445() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1857();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1446 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC1447 implements Runnable {
            public RunnableC1447() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ProtakeSignInSettingView.this.f4026.mo1855();
            }
        }

        public ViewOnClickListenerC1446() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ProtakeSignInSettingView protakeSignInSettingView = ProtakeSignInSettingView.this;
            if (protakeSignInSettingView.f4026 != null) {
                protakeSignInSettingView.m4039(true);
                new Handler().postDelayed(new RunnableC1447(), 100L);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1448 implements View.OnClickListener {
        public ViewOnClickListenerC1448() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1856();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1449 implements View.OnClickListener {
        public ViewOnClickListenerC1449() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1859();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1450 implements View.OnClickListener {
        public ViewOnClickListenerC1450() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1858();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1451 implements View.OnClickListener {
        public ViewOnClickListenerC1451() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1854();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1452 implements View.OnClickListener {
        public ViewOnClickListenerC1452() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1853();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1453 implements View.OnClickListener {
        public ViewOnClickListenerC1453() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1459 interfaceC1459 = ProtakeSignInSettingView.this.f4026;
            if (interfaceC1459 != null) {
                interfaceC1459.mo1860();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ׯ, reason: contains not printable characters */
    public class C1454 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f4036;

        public C1454(boolean z) {
            this.f4036 = z;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ProtakeSignInSettingView.this.f4024.f10464.setEnabled(!this.f4036);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ؠ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1455 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public RoundButton f4038;

        /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ؠ$Ϳ, reason: contains not printable characters */
        public class RunnableC1456 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4039;

            public RunnableC1456(View view) {
                this.f4039 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4039.isEnabled()) {
                    ViewOnTouchListenerC1455.this.f4038.setContentAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1455(RoundButton roundButton) {
            this.f4038 = roundButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4038.setContentAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1456(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ހ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1457 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4041;

        /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ހ$Ϳ, reason: contains not printable characters */
        public class RunnableC1458 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4042;

            public RunnableC1458(View view) {
                this.f4042 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4042.isEnabled()) {
                    ViewOnTouchListenerC1457.this.f4041.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1457(View view) {
            this.f4041 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4041.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1458(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeSignInSettingView$ށ, reason: contains not printable characters */
    public interface InterfaceC1459 {
        /* renamed from: Ϳ */
        void mo1853();

        /* renamed from: Ԩ */
        void mo1854();

        /* renamed from: ԩ */
        void mo1855();

        /* renamed from: Ԫ */
        void mo1856();

        /* renamed from: ԫ */
        void mo1857();

        /* renamed from: Ԭ */
        void mo1858();

        /* renamed from: ԭ */
        void mo1859();

        /* renamed from: Ԯ */
        void mo1860();
    }

    public ProtakeSignInSettingView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnClickListener(InterfaceC1459 interfaceC1459) {
        this.f4026 = interfaceC1459;
    }

    public void setSignState(boolean z) {
        if (!z) {
            m4036(this.f4024.f10482, R.string.LABEL_SIGN_IN);
            this.f4024.f10467.setVisibility(8);
            return;
        }
        m4036(this.f4024.f10482, R.string.LABEL_SIGN_OUT);
        if (C5213.m15212()) {
            this.f4024.f10467.setVisibility(0);
        } else {
            this.f4024.f10467.setVisibility(8);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m4030(int i) {
        return C4792.m14375().m14477(i, this.f4025);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4031() {
        this.f4024 = AbstractC2860.m10196(LayoutInflater.from(getContext()), this, true);
        m4032();
        m4033();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4032() {
        this.f4025 = C4792.m14375().m14471();
        this.f4024.f10469.setPadding(C4792.m14375().m14468(), 0, C4792.m14375().m14468(), 0);
        this.f4024.f10447.m2540(C4792.m14375().m14431()).m2536(true).m2542(m4030(60)).m2539(0, C4792.m14375().m14378() * this.f4025).m2538(ViewCompat.MEASURED_STATE_MASK).m2537(getResources().getString(R.string.BUTTON_SUBSCRIBE).toUpperCase()).m2534();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4024.f10447.getLayoutParams();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14378() * this.f4025);
        textPaint.setTypeface(FilmApp.m404());
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (textPaint.measureText(getResources().getString(R.string.BUTTON_SUBSCRIBE).toUpperCase()) + C4792.m14375().m14476(108));
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.m14375().m14476(60));
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m4030(50);
        this.f4024.f10447.setLayoutParams(layoutParams);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4024.f10485.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = m4030(2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = m4030(50);
        this.f4024.f10485.setLayoutParams(layoutParams2);
        this.f4024.f10485.setBackgroundColor(-1);
        this.f4024.f10481.setPadding(0, m4030(30), 0, 0);
        this.f4024.f10476.setPadding(0, m4030(30), 0, 0);
        this.f4024.f10483.setPadding(0, m4030(30), 0, 0);
        this.f4024.f10465.setPadding(m4030(40), m4030(50), m4030(40), m4030(50));
        this.f4024.f10467.setPadding(m4030(40), m4030(50), m4030(40), m4030(50));
        this.f4024.f10464.setPadding(m4030(40), m4030(50), m4030(40), m4030(50));
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4024.f10466.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).height = m4030(150);
        this.f4024.f10466.setLayoutParams(layoutParams3);
        m4035();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4024.f10468.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = m4030(60);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = m4030(60);
        this.f4024.f10468.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f4024.f10482.getLayoutParams();
        layoutParams5.leftMargin = m4030(10);
        this.f4024.f10482.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f4024.f10456.getLayoutParams();
        layoutParams6.width = m4030(50);
        layoutParams6.height = m4030(50);
        this.f4024.f10456.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f4024.f10480.getLayoutParams();
        layoutParams7.leftMargin = m4030(10);
        this.f4024.f10480.setLayoutParams(layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f4024.f10455.getLayoutParams();
        layoutParams8.width = m4030(50);
        layoutParams8.height = m4030(50);
        this.f4024.f10455.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f4024.f10454.getLayoutParams();
        layoutParams9.width = m4030(150);
        layoutParams9.height = m4030(150);
        layoutParams9.bottomMargin = m4030(30);
        this.f4024.f10454.setLayoutParams(layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.f4024.f10452.getLayoutParams();
        layoutParams10.width = layoutParams9.width;
        layoutParams10.height = layoutParams9.height;
        layoutParams10.bottomMargin = m4030(30);
        this.f4024.f10452.setLayoutParams(layoutParams10);
        LinearLayout.LayoutParams layoutParams11 = (LinearLayout.LayoutParams) this.f4024.f10451.getLayoutParams();
        layoutParams11.width = layoutParams9.width;
        layoutParams11.height = layoutParams9.height;
        layoutParams11.bottomMargin = m4030(30);
        this.f4024.f10451.setLayoutParams(layoutParams11);
        LinearLayout.LayoutParams layoutParams12 = (LinearLayout.LayoutParams) this.f4024.f10453.getLayoutParams();
        layoutParams12.width = layoutParams9.width;
        layoutParams12.height = layoutParams9.height;
        layoutParams12.bottomMargin = m4030(30);
        this.f4024.f10453.setLayoutParams(layoutParams9);
        LinearLayout.LayoutParams layoutParams13 = (LinearLayout.LayoutParams) this.f4024.f10450.getLayoutParams();
        layoutParams13.width = layoutParams9.width;
        layoutParams13.height = layoutParams9.height;
        layoutParams13.bottomMargin = m4030(30);
        this.f4024.f10450.setLayoutParams(layoutParams13);
        LinearLayout.LayoutParams layoutParams14 = (LinearLayout.LayoutParams) this.f4024.f10460.getLayoutParams();
        layoutParams14.leftMargin = m4030(115);
        this.f4024.f10460.setLayoutParams(layoutParams14);
        LinearLayout.LayoutParams layoutParams15 = (LinearLayout.LayoutParams) this.f4024.f10459.getLayoutParams();
        layoutParams15.leftMargin = m4030(115);
        this.f4024.f10459.setLayoutParams(layoutParams15);
        LinearLayout.LayoutParams layoutParams16 = (LinearLayout.LayoutParams) this.f4024.f10462.getLayoutParams();
        layoutParams16.leftMargin = m4030(115);
        this.f4024.f10462.setLayoutParams(layoutParams16);
        LinearLayout.LayoutParams layoutParams17 = (LinearLayout.LayoutParams) this.f4024.f10458.getLayoutParams();
        layoutParams17.leftMargin = m4030(115);
        this.f4024.f10458.setLayoutParams(layoutParams17);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f4024.f10478.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).topMargin = m4030(110);
        this.f4024.f10478.setLayoutParams(layoutParams18);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f4024.f10476.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams19).leftMargin = m4030(50);
        this.f4024.f10476.setLayoutParams(layoutParams19);
        ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f4024.f10483.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams20).leftMargin = m4030(50);
        this.f4024.f10483.setLayoutParams(layoutParams20);
        this.f4024.f10474.setPadding(0, 0, 0, m4030(15));
        m4038(this.f4024.f10479, C4792.m14375().m14482() * this.f4025, R.string.PROTAKE_PLUS_FEATURE_MANUAL);
        m4038(this.f4024.f10475, C4792.m14375().m14482() * this.f4025, R.string.PROTAKE_PLUS_FEATURE_LOOKS);
        m4038(this.f4024.f10472, C4792.m14375().m14482() * this.f4025, R.string.PROTAKE_PLUS_FEATURE_DATA);
        m4038(this.f4024.f10477, C4792.m14375().m14482() * this.f4025, R.string.PROTAKE_PLUS_FEATURE_PRESETS);
        m4038(this.f4024.f10471, C4792.m14375().m14482() * this.f4025, R.string.PROTAKE_PLUS_FEATURE_ACCESSORIES);
        m4038(this.f4024.f10478, C4792.m14375().m14378() * this.f4025, R.string.TEXT_INFO_SUBSCRIPTION_3);
        m4038(this.f4024.f10481, C4792.m14375().m14482() * this.f4025, R.string.BUTTON_TERMS_OF_USE);
        m4038(this.f4024.f10476, C4792.m14375().m14482() * this.f4025, R.string.BUTTON_PRIVACY_POLICY);
        m4038(this.f4024.f10483, C4792.m14375().m14482() * this.f4025, R.string.CONTACT_SUPPORT);
        m4038(this.f4024.f10482, C4792.m14375().m14378() * this.f4025, R.string.LABEL_SIGN_IN);
        m4038(this.f4024.f10480, C4792.m14375().m14378() * this.f4025, R.string.BUTTON_RESTORE_PURCHASE);
        m4038(this.f4024.f10484, C4792.m14375().m14378(), R.string.LABEL_DEACTIVATE_ACCOUNT);
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f4024.f10467.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams21).leftMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + (m4030(40) * 4);
        this.f4024.f10467.setLayoutParams(layoutParams21);
        ConstraintLayout.LayoutParams layoutParams22 = (ConstraintLayout.LayoutParams) this.f4024.f10484.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams22).leftMargin = m4030(20);
        this.f4024.f10484.setLayoutParams(layoutParams22);
        m4038(this.f4024.f10474, C4792.m14375().m14482() * this.f4025, R.string.TEXT_INFO_SUBSCRIPTION_5);
        if (C4843.m14569().m14570() != 0) {
            this.f4024.f10474.setVisibility(8);
        } else {
            this.f4024.f10474.setVisibility(8);
        }
        ConstraintLayout.LayoutParams layoutParams23 = (ConstraintLayout.LayoutParams) this.f4024.f10474.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams23).topMargin = m4030(17);
        this.f4024.f10474.setLayoutParams(layoutParams23);
        ConstraintLayout.LayoutParams layoutParams24 = (ConstraintLayout.LayoutParams) this.f4024.f10487.getLayoutParams();
        TextPaint paint = this.f4024.f10481.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams24).width = (int) (paint.measureText(getResources().getString(R.string.BUTTON_TERMS_OF_USE).toUpperCase()) + (m4030(20) * 2));
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams24).height = (int) ((fontMetrics2.bottom - fontMetrics2.top) + (m4030(40) * 2));
        this.f4024.f10487.setLayoutParams(layoutParams24);
        ConstraintLayout.LayoutParams layoutParams25 = (ConstraintLayout.LayoutParams) this.f4024.f10486.getLayoutParams();
        TextPaint paint2 = this.f4024.f10476.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams25).width = (int) (paint2.measureText(getResources().getString(R.string.BUTTON_PRIVACY_POLICY).toUpperCase()) + (m4030(20) * 2));
        Paint.FontMetrics fontMetrics3 = paint2.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams25).height = (int) ((fontMetrics3.bottom - fontMetrics3.top) + (m4030(40) * 2));
        this.f4024.f10486.setLayoutParams(layoutParams25);
        ConstraintLayout.LayoutParams layoutParams26 = (ConstraintLayout.LayoutParams) this.f4024.f10488.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams26).width = (int) (this.f4024.f10483.getPaint().measureText(getResources().getString(R.string.CONTACT_SUPPORT).toUpperCase()) + (m4030(20) * 2));
        Paint.FontMetrics fontMetrics4 = paint2.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams26).height = (int) ((fontMetrics4.bottom - fontMetrics4.top) + (m4030(40) * 2));
        this.f4024.f10488.setLayoutParams(layoutParams26);
        ConstraintLayout.LayoutParams layoutParams27 = (ConstraintLayout.LayoutParams) this.f4024.f10457.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams27).width = m4030(30);
        ((ViewGroup.MarginLayoutParams) layoutParams27).height = m4030(30);
        Paint.FontMetrics fontMetrics5 = this.f4024.f10484.getPaint().getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams27).topMargin = (int) ((((fontMetrics5.bottom - fontMetrics5.top) - fontMetrics5.descent) + fontMetrics5.ascent) / 2.0f);
        this.f4024.f10457.setLayoutParams(layoutParams27);
        this.f4024.f10473.setTypeface(FilmApp.m404());
        this.f4024.f10449.setPadding(0, 0, C4792.m14375().m14468(), 0);
        this.f4024.f10449.setVisibility(C5213.m15210() ? 0 : 8);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4033() {
        RoundButton roundButton = this.f4024.f10447;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC1455(roundButton));
        this.f4024.f10447.setOnClickListener(new ViewOnClickListenerC1445());
        LinearLayout linearLayout = this.f4024.f10464;
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC1457(linearLayout));
        this.f4024.f10464.setOnClickListener(new ViewOnClickListenerC1446());
        LinearLayout linearLayout2 = this.f4024.f10465;
        linearLayout2.setOnTouchListener(new ViewOnTouchListenerC1457(linearLayout2));
        this.f4024.f10465.setOnClickListener(new ViewOnClickListenerC1448());
        AbstractC2860 abstractC2860 = this.f4024;
        abstractC2860.f10487.setOnTouchListener(new ViewOnTouchListenerC1457(abstractC2860.f10481));
        this.f4024.f10487.setOnClickListener(new ViewOnClickListenerC1449());
        AbstractC2860 abstractC28602 = this.f4024;
        abstractC28602.f10486.setOnTouchListener(new ViewOnTouchListenerC1457(abstractC28602.f10476));
        this.f4024.f10486.setOnClickListener(new ViewOnClickListenerC1450());
        AbstractC2860 abstractC28603 = this.f4024;
        abstractC28603.f10488.setOnTouchListener(new ViewOnTouchListenerC1457(abstractC28603.f10483));
        this.f4024.f10488.setOnClickListener(new ViewOnClickListenerC1451());
        ConstraintLayout constraintLayout = this.f4024.f10467;
        constraintLayout.setOnTouchListener(new ViewOnTouchListenerC1457(constraintLayout));
        this.f4024.f10467.setOnClickListener(new ViewOnClickListenerC1452());
        ConstraintLayout constraintLayout2 = this.f4024.f10449;
        constraintLayout2.setOnTouchListener(new ViewOnTouchListenerC1457(constraintLayout2));
        this.f4024.f10449.setOnClickListener(new ViewOnClickListenerC1453());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4034() throws Resources.NotFoundException {
        String strM7593 = n.m7588().m7593();
        String strM7606 = n.m7588().m7606();
        n.m7588().m7598();
        if (this.f4024.f10478 != null) {
            String string = getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_3);
            String str = string + getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_3_1);
            if (!r1.m8143(strM7593)) {
                m4037(this.f4024.f10478, String.format(str, strM7606));
                return;
            }
            String str2 = str + getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_2);
            this.f4024.f10478.setText(C4451.m13715(String.format(str2, strM7606, strM7593), string.length(), String.format(str2, strM7606, strM7593).length() - 1));
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4035() {
        if (C4843.m14569().m14570() != 0) {
            this.f4024.f10464.setVisibility(0);
            this.f4024.f10468.setVisibility(0);
        } else {
            this.f4024.f10464.setVisibility(8);
            this.f4024.f10468.setVisibility(8);
        }
        m4039(false);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4036(TextView textView, int i) {
        m4037(textView, getResources().getString(i));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4037(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m4038(TextView textView, float f, int i) {
        textView.setTypeface(FilmApp.m404());
        textView.setTextSize(0, f);
        if (i != 0) {
            textView.setText(getResources().getString(i));
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4039(boolean z) {
        C4008.m12877(this.f4024.f10464, z ? 0.0f : 1.0f, 100, null);
        C4008.m12877(this.f4024.f10468, z ? 1.0f : 0.0f, 100, new C1454(z));
    }

    public ProtakeSignInSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtakeSignInSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4031();
    }
}
