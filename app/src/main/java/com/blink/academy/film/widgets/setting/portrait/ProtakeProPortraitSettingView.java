package com.blink.academy.film.widgets.setting.portrait;

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
import defpackage.AbstractC2395;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.C5213;
import defpackage.e5;
import defpackage.n2;
import defpackage.r1;

/* loaded from: classes.dex */
public class ProtakeProPortraitSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2395 f4137;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f4138;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1533 f4139;

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1525 implements View.OnClickListener {
        public ViewOnClickListenerC1525() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1533 interfaceC1533 = ProtakeProPortraitSettingView.this.f4139;
            if (interfaceC1533 != null) {
                interfaceC1533.mo1749();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1526 implements View.OnClickListener {
        public ViewOnClickListenerC1526() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ProtakeProPortraitSettingView.this.f4139 != null) {
                if (e5.m5988().m5994()) {
                    ProtakeProPortraitSettingView.this.f4139.mo1753();
                } else {
                    ProtakeProPortraitSettingView.this.f4139.mo1748();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1527 implements View.OnClickListener {
        public ViewOnClickListenerC1527() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1533 interfaceC1533 = ProtakeProPortraitSettingView.this.f4139;
            if (interfaceC1533 != null) {
                interfaceC1533.mo1752();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1528 implements View.OnClickListener {
        public ViewOnClickListenerC1528() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1533 interfaceC1533 = ProtakeProPortraitSettingView.this.f4139;
            if (interfaceC1533 != null) {
                interfaceC1533.mo1747();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1529 implements View.OnClickListener {
        public ViewOnClickListenerC1529() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1533 interfaceC1533 = ProtakeProPortraitSettingView.this.f4139;
            if (interfaceC1533 != null) {
                interfaceC1533.mo1750();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1530 implements View.OnClickListener {
        public ViewOnClickListenerC1530() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC1533 interfaceC1533 = ProtakeProPortraitSettingView.this.f4139;
            if (interfaceC1533 != null) {
                interfaceC1533.mo1751();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$ֈ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1531 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4146;

        /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$ֈ$Ϳ, reason: contains not printable characters */
        public class RunnableC1532 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4147;

            public RunnableC1532(View view) {
                this.f4147 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4147.isEnabled()) {
                    ViewOnTouchListenerC1531.this.f4146.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1531(View view) {
            this.f4146 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4146.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1532(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView$֏, reason: contains not printable characters */
    public interface InterfaceC1533 {
        /* renamed from: Ϳ */
        void mo1747();

        /* renamed from: Ԩ */
        void mo1748();

        /* renamed from: ԩ */
        void mo1749();

        /* renamed from: Ԫ */
        void mo1750();

        /* renamed from: ԫ */
        void mo1751();

        /* renamed from: Ԭ */
        void mo1752();

        /* renamed from: ԭ */
        void mo1753();
    }

    public ProtakeProPortraitSettingView(@NonNull Context context) {
        this(context, null);
    }

    public void setOnClickListener(InterfaceC1533 interfaceC1533) {
        this.f4139 = interfaceC1533;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m4120(int i) {
        return C4792.m14375().m14477(i, this.f4138);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4121() {
        this.f4137 = AbstractC2395.m8885(LayoutInflater.from(getContext()), this, true);
        m4122();
        m4123();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m4122() {
        this.f4138 = C4792.m14375().m14471();
        this.f4137.f8957.setPadding(C4792.m14375().m14468(), 0, C4792.m14375().m14468(), 0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4137.f8954.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = m4120(300);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = m4120(54);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = m4120(170);
        this.f4137.f8954.setLayoutParams(layoutParams);
        m4128(this.f4137.f8962, C4792.m14375().m14381(), R.string.LABEL_PHONE_NUMBER);
        m4128(this.f4137.f8963, C4792.m14375().m14381(), 0);
        m4128(this.f4137.f8960, C4792.m14375().m14381(), R.string.LABEL_EXPIRATION_DATE);
        m4128(this.f4137.f8961, C4792.m14375().m14381(), 0);
        m4128(this.f4137.f8959, C4792.m14375().m14381(), R.string.BUTTON_CHANGE_PHONE_NUMBER);
        m4128(this.f4137.f8966, C4792.m14375().m14381(), R.string.LABEL_DEACTIVATE_ACCOUNT);
        this.f4137.f8959.setTextColor(C4792.m14375().m14431());
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f4137.f8962.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = m4120(170);
        this.f4137.f8962.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f4137.f8960.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = m4120(50);
        this.f4137.f8960.setLayoutParams(layoutParams3);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f4137.f8963.getLayoutParams())).leftMargin = m4120(50);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f4137.f8959.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin;
        this.f4137.f8959.setLayoutParams(layoutParams4);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14381());
        textPaint.setTypeface(FilmApp.m404());
        float fMeasureText = textPaint.measureText(getResources().getString(R.string.BUTTON_CHANGE_PHONE_NUMBER));
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f4137.f8953.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = ((int) fMeasureText) + (m4120(40) * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = C2579.m9438(44.0f);
        this.f4137.f8953.setLayoutParams(layoutParams5);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) this.f4137.f8961.getLayoutParams())).leftMargin = m4120(50);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f4137.f8952.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = m4120(356);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = m4120(138);
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = m4120(176);
        this.f4137.f8952.setLayoutParams(layoutParams6);
        this.f4137.f8952.m2542(m4120(60)).m2540(0).m2539(0, C4792.m14375().m14381() * this.f4138).m2538(-1).m2543(-1).m2541(m4120(6) - (m4120(6) % 2));
        m4125();
        this.f4137.f8955.setPadding(m4120(25), m4120(50), m4120(25), m4120(50));
        m4128(this.f4137.f8955, C4792.m14375().m14381(), R.string.CONTACT_SUPPORT);
        this.f4137.f8965.setPadding(m4120(25), m4120(50), m4120(25), m4120(50));
        m4128(this.f4137.f8965, C4792.m14375().m14381(), R.string.BUTTON_TERMS_OF_USE);
        this.f4137.f8964.setPadding(m4120(25), m4120(50), m4120(25), m4120(50));
        m4128(this.f4137.f8964, C4792.m14375().m14381(), R.string.BUTTON_PRIVACY_POLICY);
        this.f4137.f8966.setPadding(m4120(25), m4120(50), m4120(25), m4120(50));
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f4137.f8966.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).topMargin = m4120(50);
        this.f4137.f8966.setLayoutParams(layoutParams7);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4123() {
        AbstractC2395 abstractC2395 = this.f4137;
        abstractC2395.f8953.setOnTouchListener(new ViewOnTouchListenerC1531(abstractC2395.f8959));
        this.f4137.f8953.setOnClickListener(new ViewOnClickListenerC1525());
        RoundButton roundButton = this.f4137.f8952;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC1531(roundButton));
        this.f4137.f8952.setOnClickListener(new ViewOnClickListenerC1526());
        TextView textView = this.f4137.f8955;
        textView.setOnTouchListener(new ViewOnTouchListenerC1531(textView));
        this.f4137.f8955.setOnClickListener(new ViewOnClickListenerC1527());
        TextView textView2 = this.f4137.f8966;
        textView2.setOnTouchListener(new ViewOnTouchListenerC1531(textView2));
        this.f4137.f8966.setOnClickListener(new ViewOnClickListenerC1528());
        TextView textView3 = this.f4137.f8965;
        textView3.setOnTouchListener(new ViewOnTouchListenerC1531(textView3));
        this.f4137.f8965.setOnClickListener(new ViewOnClickListenerC1529());
        TextView textView4 = this.f4137.f8964;
        textView4.setOnTouchListener(new ViewOnTouchListenerC1531(textView4));
        this.f4137.f8964.setOnClickListener(new ViewOnClickListenerC1530());
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4124() {
        this.f4137.f8965.setVisibility(0);
        this.f4137.f8964.setVisibility(0);
        this.f4137.f8955.setVisibility(0);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m4125() {
        if (e5.m5988().m5994()) {
            this.f4137.f8952.m2537(getResources().getString(R.string.LABEL_SIGN_OUT).toUpperCase()).m2534();
        } else {
            this.f4137.f8952.m2537(getResources().getString(R.string.LABEL_SIGN_IN).toUpperCase()).m2534();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4126(String str, String str2, long j) {
        if (r1.m8143(str2)) {
            int length = str2.length();
            int i = length - 1;
            int i2 = i - 2;
            int i3 = i - 5;
            String strSubstring = str2.substring(0, i3);
            int i4 = i2 + 1;
            str2.substring(i3, i4);
            String str3 = String.format("%s****%s", strSubstring, str2.substring(i4, length));
            if (e5.m5988().m5994()) {
                m4127(this.f4137.f8963, String.format("+%s %s", str, str3));
                this.f4137.f8959.setVisibility(0);
                this.f4137.f8953.setVisibility(0);
                if (C5213.m15212()) {
                    this.f4137.f8966.setVisibility(0);
                } else {
                    this.f4137.f8966.setVisibility(8);
                }
            } else {
                m4127(this.f4137.f8963, String.format("%s", "N/A"));
                this.f4137.f8959.setVisibility(8);
                this.f4137.f8953.setVisibility(8);
                this.f4137.f8966.setVisibility(8);
            }
        } else {
            m4127(this.f4137.f8963, String.format("%s", "N/A"));
            this.f4137.f8959.setVisibility(8);
            this.f4137.f8953.setVisibility(8);
            this.f4137.f8966.setVisibility(8);
        }
        m4124();
        if (j != 0) {
            if (String.valueOf(j).length() == 10) {
                j *= 1000;
            }
            m4127(this.f4137.f8961, n2.m7622(j));
        }
        m4125();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m4127(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m4128(TextView textView, float f, int i) {
        textView.setTypeface(FilmApp.m404());
        textView.setTextSize(0, f);
        if (i != 0) {
            textView.setText(getResources().getString(i));
        }
    }

    public ProtakeProPortraitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtakeProPortraitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4121();
    }
}
