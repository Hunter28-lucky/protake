package com.blink.academy.film.widgets.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.protake.R;
import defpackage.AbstractC4442;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.C5213;
import defpackage.e5;
import defpackage.n2;
import defpackage.r1;

/* loaded from: classes.dex */
public class ProtakeProSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4442 f4011;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f4012;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1444 f4013;

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1435 implements View.OnClickListener {
        public ViewOnClickListenerC1435() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1444 interfaceC1444 = ProtakeProSettingView.this.f4013;
            if (interfaceC1444 != null) {
                interfaceC1444.mo1847();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1436 implements View.OnClickListener {
        public ViewOnClickListenerC1436() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ProtakeProSettingView.this.f4013 != null) {
                if (e5.m5988().m5994()) {
                    ProtakeProSettingView.this.f4013.mo1851();
                } else {
                    ProtakeProSettingView.this.f4013.mo1846();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1437 implements View.OnClickListener {
        public ViewOnClickListenerC1437() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1444 interfaceC1444 = ProtakeProSettingView.this.f4013;
            if (interfaceC1444 != null) {
                interfaceC1444.mo1850();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1438 implements View.OnClickListener {
        public ViewOnClickListenerC1438() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1444 interfaceC1444 = ProtakeProSettingView.this.f4013;
            if (interfaceC1444 != null) {
                interfaceC1444.mo1845();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1439 implements View.OnClickListener {
        public ViewOnClickListenerC1439() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1444 interfaceC1444 = ProtakeProSettingView.this.f4013;
            if (interfaceC1444 != null) {
                interfaceC1444.mo1848();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1440 implements View.OnClickListener {
        public ViewOnClickListenerC1440() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1444 interfaceC1444 = ProtakeProSettingView.this.f4013;
            if (interfaceC1444 != null) {
                interfaceC1444.mo1849();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1441 implements View.OnClickListener {
        public ViewOnClickListenerC1441() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1444 interfaceC1444 = ProtakeProSettingView.this.f4013;
            if (interfaceC1444 != null) {
                interfaceC1444.mo1852();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$֏, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1442 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4021;

        /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$֏$Ϳ, reason: contains not printable characters */
        public class RunnableC1443 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4022;

            public RunnableC1443(View view) {
                this.f4022 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4022.isEnabled()) {
                    ViewOnTouchListenerC1442.this.f4021.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1442(View view) {
            this.f4021 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4021.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1443(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.ProtakeProSettingView$ׯ, reason: contains not printable characters */
    public interface InterfaceC1444 {
        /* renamed from: Ϳ */
        void mo1845();

        /* renamed from: Ԩ */
        void mo1846();

        /* renamed from: ԩ */
        void mo1847();

        /* renamed from: Ԫ */
        void mo1848();

        /* renamed from: ԫ */
        void mo1849();

        /* renamed from: Ԭ */
        void mo1850();

        /* renamed from: ԭ */
        void mo1851();

        /* renamed from: Ԯ */
        void mo1852();
    }

    public ProtakeProSettingView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnClickListener(InterfaceC1444 interfaceC1444) {
        this.f4013 = interfaceC1444;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m4019(int i) {
        return C4792.m14375().m14477(i, this.f4012);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4020() {
        this.f4011 = AbstractC4442.m13702(LayoutInflater.from(getContext()), this, true);
        m4021();
        m4022();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4021() {
        this.f4012 = C4792.m14375().m14471();
        this.f4011.f15314.setPadding(C4792.m14375().m14468(), 0, C4792.m14375().m14468(), 0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4011.f15311.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = m4019(300);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = m4019(54);
        this.f4011.f15311.setLayoutParams(layoutParams);
        m4027(this.f4011.f15319, C4792.m14375().m14381(), R.string.LABEL_PHONE_NUMBER);
        m4027(this.f4011.f15320, C4792.m14375().m14381(), 0);
        m4027(this.f4011.f15316, C4792.m14375().m14381(), R.string.LABEL_EXPIRATION_DATE);
        m4027(this.f4011.f15317, C4792.m14375().m14381(), 0);
        m4027(this.f4011.f15315, C4792.m14375().m14381(), R.string.BUTTON_CHANGE_PHONE_NUMBER);
        m4027(this.f4011.f15323, C4792.m14375().m14381(), R.string.LABEL_DEACTIVATE_ACCOUNT);
        this.f4011.f15315.setTextColor(C4792.m14375().m14431());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4011.f15319.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = m4019(170);
        this.f4011.f15319.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4011.f15316.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = m4019(50);
        this.f4011.f15316.setLayoutParams(layoutParams3);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f4011.f15320.getLayoutParams())).leftMargin = m4019(50);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4011.f15315.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).leftMargin = m4019(50);
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14381());
        textPaint.setTypeface(FilmApp.m404());
        float fMeasureText = textPaint.measureText(getResources().getString(R.string.BUTTON_CHANGE_PHONE_NUMBER));
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4011.f15308.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = ((int) fMeasureText) + (m4019(40) * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = C2579.m9438(44.0f);
        this.f4011.f15308.setLayoutParams(layoutParams5);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f4011.f15317.getLayoutParams())).leftMargin = m4019(50);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4011.f15307.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = m4019(356);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = m4019(138);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = m4019(176);
        this.f4011.f15307.setLayoutParams(layoutParams6);
        this.f4011.f15307.m2542(m4019(60)).m2540(0).m2539(0, C4792.m14375().m14381() * this.f4012).m2538(-1).m2543(-1).m2541(m4019(6) - (m4019(6) % 2));
        m4024();
        this.f4011.f15312.setPadding(m4019(25), m4019(50), m4019(25), 0);
        m4027(this.f4011.f15312, C4792.m14375().m14381(), R.string.CONTACT_SUPPORT);
        this.f4011.f15322.setPadding(m4019(25), m4019(50), m4019(25), 0);
        m4027(this.f4011.f15322, C4792.m14375().m14381(), R.string.BUTTON_TERMS_OF_USE);
        this.f4011.f15321.setPadding(m4019(25), m4019(50), m4019(25), 0);
        m4027(this.f4011.f15321, C4792.m14375().m14381(), R.string.BUTTON_PRIVACY_POLICY);
        this.f4011.f15323.setPadding(m4019(25), m4019(50), m4019(25), 0);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4011.f15323.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).leftMargin = m4019(25) * 4;
        this.f4011.f15323.setLayoutParams(layoutParams7);
        m4027(this.f4011.f15323, C4792.m14375().m14381(), R.string.LABEL_DEACTIVATE_ACCOUNT);
        this.f4011.f15310.setPadding(0, 0, C4792.m14375().m14468(), 0);
        this.f4011.f15318.setTypeface(FilmApp.m404());
        this.f4011.f15310.setVisibility(C5213.m15210() ? 0 : 8);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4022() {
        AbstractC4442 abstractC4442 = this.f4011;
        abstractC4442.f15308.setOnTouchListener(new ViewOnTouchListenerC1442(abstractC4442.f15315));
        this.f4011.f15308.setOnClickListener(new ViewOnClickListenerC1435());
        RoundButton roundButton = this.f4011.f15307;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC1442(roundButton));
        this.f4011.f15307.setOnClickListener(new ViewOnClickListenerC1436());
        TextView textView = this.f4011.f15312;
        textView.setOnTouchListener(new ViewOnTouchListenerC1442(textView));
        this.f4011.f15312.setOnClickListener(new ViewOnClickListenerC1437());
        TextView textView2 = this.f4011.f15323;
        textView2.setOnTouchListener(new ViewOnTouchListenerC1442(textView2));
        this.f4011.f15323.setOnClickListener(new ViewOnClickListenerC1438());
        TextView textView3 = this.f4011.f15322;
        textView3.setOnTouchListener(new ViewOnTouchListenerC1442(textView3));
        this.f4011.f15322.setOnClickListener(new ViewOnClickListenerC1439());
        TextView textView4 = this.f4011.f15321;
        textView4.setOnTouchListener(new ViewOnTouchListenerC1442(textView4));
        this.f4011.f15321.setOnClickListener(new ViewOnClickListenerC1440());
        ConstraintLayout constraintLayout = this.f4011.f15310;
        constraintLayout.setOnTouchListener(new ViewOnTouchListenerC1442(constraintLayout));
        this.f4011.f15310.setOnClickListener(new ViewOnClickListenerC1441());
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4023() {
        this.f4011.f15322.setVisibility(0);
        this.f4011.f15321.setVisibility(0);
        this.f4011.f15312.setVisibility(0);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4024() {
        if (e5.m5988().m5994()) {
            this.f4011.f15307.m2537(getResources().getString(R.string.LABEL_SIGN_OUT).toUpperCase()).m2534();
        } else {
            this.f4011.f15307.m2537(getResources().getString(R.string.LABEL_SIGN_IN).toUpperCase()).m2534();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4025(String str, String str2, long j) {
        String str3;
        if (r1.m8143(str2)) {
            int length = str2.length();
            int i = length - 1;
            int i2 = i - 2;
            int i3 = i - 5;
            String strSubstring = str2.substring(0, i3);
            int i4 = i2 + 1;
            str2.substring(i3, i4);
            String str4 = String.format("%s****%s", strSubstring, str2.substring(i4, length));
            if (e5.m5988().m5994()) {
                TextView textView = this.f4011.f15320;
                Object[] objArr = new Object[2];
                if (r1.m8138(str)) {
                    str3 = "";
                } else {
                    str3 = "+" + str;
                }
                objArr[0] = str3;
                objArr[1] = str4;
                m4026(textView, String.format("%s %s", objArr));
                this.f4011.f15315.setVisibility(0);
                this.f4011.f15308.setVisibility(0);
                if (C5213.m15212()) {
                    this.f4011.f15323.setVisibility(0);
                } else {
                    this.f4011.f15323.setVisibility(8);
                }
            } else {
                m4026(this.f4011.f15320, String.format("%s", "N/A"));
                this.f4011.f15315.setVisibility(8);
                this.f4011.f15308.setVisibility(8);
                this.f4011.f15323.setVisibility(8);
            }
        } else {
            m4026(this.f4011.f15320, String.format("%s", "N/A"));
            this.f4011.f15315.setVisibility(8);
            this.f4011.f15308.setVisibility(8);
            this.f4011.f15323.setVisibility(8);
        }
        m4023();
        if (j != 0) {
            if (String.valueOf(j).length() == 10) {
                j *= 1000;
            }
            m4026(this.f4011.f15317, n2.m7622(j));
        }
        m4024();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4026(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4027(TextView textView, float f, int i) {
        textView.setTypeface(FilmApp.m404());
        textView.setTextSize(0, f);
        if (i != 0) {
            textView.setText(getResources().getString(i));
        }
    }

    public ProtakeProSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtakeProSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4020();
    }
}
