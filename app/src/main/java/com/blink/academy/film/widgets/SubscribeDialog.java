package com.blink.academy.film.widgets;

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
import com.blink.academy.protake.R;
import defpackage.AbstractC3120;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4451;
import defpackage.C4628;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.n;
import defpackage.r1;

/* loaded from: classes.dex */
public class SubscribeDialog extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3120 f2546;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2547;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2548;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC0965 f2549;

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0948 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ϳ$Ϳ, reason: contains not printable characters */
        public class C0949 extends AbstractC4012 {
            public C0949() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SubscribeDialog.this.setVisibility(8);
                SubscribeDialog.this.m2594(false);
            }
        }

        public ViewOnClickListenerC0948() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0965 interfaceC0965 = SubscribeDialog.this.f2549;
            if (interfaceC0965 != null && interfaceC0965.mo1341()) {
                SubscribeDialog.this.m2584(new C0949());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ԩ, reason: contains not printable characters */
    public class C0950 extends AbstractC4012 {
        public C0950() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            SubscribeDialog.this.setVisibility(8);
            SubscribeDialog.this.m2594(false);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ԫ, reason: contains not printable characters */
    public class C0951 extends AbstractC4012 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f2553;

        public C0951(boolean z) {
            this.f2553 = z;
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            SubscribeDialog.this.f2546.f11090.setEnabled(!this.f2553);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC0952 implements View.OnClickListener {
        public ViewOnClickListenerC0952() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0965 interfaceC0965 = SubscribeDialog.this.f2549;
            if (interfaceC0965 != null) {
                interfaceC0965.mo1345();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC0953 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0954 implements Runnable {
            public RunnableC0954() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SubscribeDialog.this.f2549.mo1343();
            }
        }

        public ViewOnClickListenerC0953() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SubscribeDialog subscribeDialog = SubscribeDialog.this;
            if (subscribeDialog.f2549 != null) {
                subscribeDialog.m2594(true);
                new Handler().postDelayed(new RunnableC0954(), 100L);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0955 implements View.OnClickListener {
        public ViewOnClickListenerC0955() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0965 interfaceC0965 = SubscribeDialog.this.f2549;
            if (interfaceC0965 != null) {
                interfaceC0965.mo1344();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC0956 implements View.OnClickListener {
        public ViewOnClickListenerC0956() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0965 interfaceC0965 = SubscribeDialog.this.f2549;
            if (interfaceC0965 != null) {
                interfaceC0965.mo1347();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC0957 implements View.OnClickListener {
        public ViewOnClickListenerC0957() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0965 interfaceC0965 = SubscribeDialog.this.f2549;
            if (interfaceC0965 != null) {
                interfaceC0965.mo1346();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC0958 implements View.OnClickListener {
        public ViewOnClickListenerC0958() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC0965 interfaceC0965 = SubscribeDialog.this.f2549;
            if (interfaceC0965 != null) {
                interfaceC0965.mo1342();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0959 implements View.OnClickListener {
        public ViewOnClickListenerC0959() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ހ, reason: contains not printable characters */
    public class ViewOnClickListenerC0960 implements View.OnClickListener {
        public ViewOnClickListenerC0960() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SubscribeDialog.this.m2583();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ށ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0961 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public RoundButton f2564;

        /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC0962 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2565;

            public RunnableC0962(View view) {
                this.f2565 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2565.isEnabled()) {
                    ViewOnTouchListenerC0961.this.f2564.setContentAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0961(RoundButton roundButton) {
            this.f2564 = roundButton;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2564.setContentAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0962(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ނ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0963 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f2567;

        /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ނ$Ϳ, reason: contains not printable characters */
        public class RunnableC0964 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2568;

            public RunnableC0964(View view) {
                this.f2568 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2568.isEnabled()) {
                    ViewOnTouchListenerC0963.this.f2567.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0963(View view) {
            this.f2567 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2567.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0964(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.SubscribeDialog$ރ, reason: contains not printable characters */
    public interface InterfaceC0965 {
        /* renamed from: Ϳ */
        boolean mo1341();

        /* renamed from: Ԩ */
        void mo1342();

        /* renamed from: ԩ */
        void mo1343();

        /* renamed from: Ԫ */
        void mo1344();

        /* renamed from: ԫ */
        void mo1345();

        /* renamed from: Ԭ */
        void mo1346();

        /* renamed from: ԭ */
        void mo1347();
    }

    public SubscribeDialog(@NonNull Context context) {
        this(context, null);
    }

    public void setOnSubscribeDialogListener(InterfaceC0965 interfaceC0965) {
        this.f2549 = interfaceC0965;
    }

    public void setPortrait(boolean z) {
        m2586(z);
    }

    public void setRatio(float f) {
        this.f2547 = f;
    }

    public void setSignState(boolean z) {
        if (z) {
            m2591(this.f2546.f11101, R.string.LABEL_SIGN_OUT);
        } else {
            m2591(this.f2546.f11101, R.string.LABEL_SIGN_IN);
        }
    }

    public void setVertical(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2546.f11094.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i;
        this.f2546.f11094.setLayoutParams(layoutParams);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m2582(int i) {
        return C4792.m14375().m14477(i, this.f2547);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2583() {
        C4008.m12876(this, 0.0f, 100, new C0950());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2584(AbstractC4012 abstractC4012) {
        C4008.m12876(this, 0.0f, 100, abstractC4012);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2585() {
        this.f2546 = AbstractC3120.m10707(LayoutInflater.from(getContext()), this, true);
        this.f2547 = C4792.m14375().m14434();
        m2587();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2586(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.f2546.f11094.getLayoutParams();
        layoutParams.width = C4792.m14375().m14438();
        if (z) {
            layoutParams.width = C2579.f9600 - C2579.m9438(50.0f);
        }
        this.f2546.f11094.setLayoutParams(layoutParams);
        this.f2546.f11094.setBackgroundColor(C4792.m14375().m14431());
        this.f2546.f11094.setPadding(m2582(58), m2582(70), m2582(58), m2582(40));
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2546.f11085.getLayoutParams();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14378() * this.f2547);
        textPaint.setTypeface(FilmApp.m404());
        ViewGroup.LayoutParams layoutParams3 = this.f2546.f11087.getLayoutParams();
        layoutParams3.width = m2582(300);
        layoutParams3.height = m2582(54);
        this.f2546.f11087.setLayoutParams(layoutParams3);
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = (int) (textPaint.measureText(getResources().getString(R.string.BUTTON_SUBSCRIBE).toUpperCase()) + C4792.m14375().m14476(108));
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) ((fontMetrics.bottom - fontMetrics.top) + C4792.m14375().m14476(60));
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = m2582(50);
        this.f2546.f11085.setLayoutParams(layoutParams2);
        this.f2546.f11085.m2540(ViewCompat.MEASURED_STATE_MASK).m2542(m2582(43)).m2539(0, C4792.m14375().m14378() * this.f2547).m2538(C4792.m14375().m14431()).m2537(getResources().getString(R.string.BUTTON_SUBSCRIBE).toUpperCase()).m2534();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f2546.f11104.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = m2582(3);
        this.f2546.f11104.setLayoutParams(layoutParams4);
        this.f2546.f11104.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.f2546.f11100.setPadding(0, m2582(35), 0, 0);
        this.f2546.f11097.setPadding(0, m2582(35), 0, 0);
        this.f2546.f11102.setPadding(0, m2582(35), 0, 0);
        this.f2546.f11091.setPadding(m2582(40), m2582(40), m2582(40), m2582(50));
        this.f2546.f11090.setPadding(m2582(40), m2582(40), m2582(40), m2582(50));
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f2546.f11092.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = m2582(150);
        this.f2546.f11092.setLayoutParams(layoutParams5);
        m2590();
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f2546.f11093.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = m2582(60);
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = m2582(60);
        this.f2546.f11093.setLayoutParams(layoutParams6);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f2546.f11101.getLayoutParams();
        layoutParams7.leftMargin = m2582(10);
        this.f2546.f11101.setLayoutParams(layoutParams7);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) this.f2546.f11089.getLayoutParams();
        layoutParams8.width = m2582(50);
        layoutParams8.height = m2582(50);
        this.f2546.f11089.setLayoutParams(layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = (LinearLayout.LayoutParams) this.f2546.f11099.getLayoutParams();
        layoutParams9.leftMargin = m2582(10);
        this.f2546.f11099.setLayoutParams(layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = (LinearLayout.LayoutParams) this.f2546.f11088.getLayoutParams();
        layoutParams10.width = m2582(50);
        layoutParams10.height = m2582(50);
        this.f2546.f11088.setLayoutParams(layoutParams8);
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f2546.f11098.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).topMargin = m2582(50);
        this.f2546.f11098.setLayoutParams(layoutParams11);
        m2593(this.f2546.f11098, C4792.m14375().m14378() * this.f2547, R.string.TEXT_INFO_SUBSCRIPTION_1);
        this.f2546.f11098.setCustomText(getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_1));
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f2546.f11097.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).leftMargin = m2582(50);
        this.f2546.f11097.setLayoutParams(layoutParams12);
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f2546.f11102.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).leftMargin = m2582(50);
        this.f2546.f11102.setLayoutParams(layoutParams13);
        m2593(this.f2546.f11100, C4792.m14375().m14482() * this.f2547, R.string.BUTTON_TERMS_OF_USE);
        m2593(this.f2546.f11097, C4792.m14375().m14482() * this.f2547, R.string.BUTTON_PRIVACY_POLICY);
        m2593(this.f2546.f11102, C4792.m14375().m14482() * this.f2547, R.string.CONTACT_SUPPORT);
        m2593(this.f2546.f11101, C4792.m14375().m14378() * this.f2547, R.string.LABEL_SIGN_IN);
        m2593(this.f2546.f11099, C4792.m14375().m14378() * this.f2547, R.string.BUTTON_RESTORE_PURCHASE);
        m2593(this.f2546.f11096, C4792.m14375().m14482() * this.f2547, R.string.TEXT_INFO_SUBSCRIPTION_5);
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f2546.f11096.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).topMargin = m2582(17);
        this.f2546.f11096.setLayoutParams(layoutParams14);
        this.f2546.f11096.setPadding(0, 0, 0, m2582(25));
        ConstraintLayout.LayoutParams layoutParams15 = (ConstraintLayout.LayoutParams) this.f2546.f11106.getLayoutParams();
        TextPaint paint = this.f2546.f11100.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams15).width = (int) (paint.measureText(getResources().getString(R.string.BUTTON_TERMS_OF_USE).toUpperCase()) + (m2582(20) * 2));
        Paint.FontMetrics fontMetrics2 = paint.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams15).height = (int) ((fontMetrics2.bottom - fontMetrics2.top) + (m2582(40) * 2));
        this.f2546.f11106.setLayoutParams(layoutParams15);
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f2546.f11105.getLayoutParams();
        TextPaint paint2 = this.f2546.f11097.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams16).width = (int) (paint2.measureText(getResources().getString(R.string.BUTTON_PRIVACY_POLICY).toUpperCase()) + (m2582(20) * 2));
        Paint.FontMetrics fontMetrics3 = paint2.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams16).height = (int) ((fontMetrics3.bottom - fontMetrics3.top) + (m2582(40) * 2));
        this.f2546.f11105.setLayoutParams(layoutParams16);
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f2546.f11107.getLayoutParams();
        TextPaint paint3 = this.f2546.f11097.getPaint();
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = (int) (paint3.measureText(getResources().getString(R.string.BUTTON_PRIVACY_POLICY).toUpperCase()) + (m2582(20) * 2));
        Paint.FontMetrics fontMetrics4 = paint3.getFontMetrics();
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = (int) ((fontMetrics4.bottom - fontMetrics4.top) + (m2582(40) * 2));
        this.f2546.f11107.setLayoutParams(layoutParams17);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f2546.f11086.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).width = C4792.m14375().m14476(36);
        ((ViewGroup.MarginLayoutParams) layoutParams18).height = C4792.m14375().m14476(36);
        this.f2546.f11086.setLayoutParams(layoutParams18);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f2546.f11103.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams19).width = ((ViewGroup.MarginLayoutParams) layoutParams18).width + (m2582(40) * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams19).height = ((ViewGroup.MarginLayoutParams) layoutParams18).height + (m2582(40) * 2);
        ((ViewGroup.MarginLayoutParams) layoutParams19).topMargin = m2582(30);
        ((ViewGroup.MarginLayoutParams) layoutParams19).rightMargin = m2582(18);
        this.f2546.f11103.setLayoutParams(layoutParams19);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2587() {
        this.f2546.f11095.setOnClickListener(new ViewOnClickListenerC0948());
        RoundButton roundButton = this.f2546.f11085;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC0961(roundButton));
        this.f2546.f11085.setOnClickListener(new ViewOnClickListenerC0952());
        LinearLayout linearLayout = this.f2546.f11090;
        linearLayout.setOnTouchListener(new ViewOnTouchListenerC0963(linearLayout));
        this.f2546.f11090.setOnClickListener(new ViewOnClickListenerC0953());
        LinearLayout linearLayout2 = this.f2546.f11091;
        linearLayout2.setOnTouchListener(new ViewOnTouchListenerC0963(linearLayout2));
        this.f2546.f11091.setOnClickListener(new ViewOnClickListenerC0955());
        AbstractC3120 abstractC3120 = this.f2546;
        abstractC3120.f11106.setOnTouchListener(new ViewOnTouchListenerC0963(abstractC3120.f11100));
        this.f2546.f11106.setOnClickListener(new ViewOnClickListenerC0956());
        AbstractC3120 abstractC31202 = this.f2546;
        abstractC31202.f11105.setOnTouchListener(new ViewOnTouchListenerC0963(abstractC31202.f11097));
        this.f2546.f11105.setOnClickListener(new ViewOnClickListenerC0957());
        AbstractC3120 abstractC31203 = this.f2546;
        abstractC31203.f11107.setOnTouchListener(new ViewOnTouchListenerC0963(abstractC31203.f11102));
        this.f2546.f11107.setOnClickListener(new ViewOnClickListenerC0958());
        this.f2546.f11094.setOnClickListener(new ViewOnClickListenerC0959());
        AbstractC3120 abstractC31204 = this.f2546;
        abstractC31204.f11103.setOnTouchListener(new ViewOnTouchListenerC0963(abstractC31204.f11086));
        this.f2546.f11103.setOnClickListener(new ViewOnClickListenerC0960());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m2588() {
        if (C4843.m14569().m14570() != 0) {
            this.f2546.f11096.setVisibility(8);
        } else {
            this.f2546.f11096.setVisibility(8);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2589() throws Resources.NotFoundException {
        String strM7593 = n.m7588().m7593();
        String strM7606 = n.m7588().m7606();
        n.m7588().m7598();
        if (this.f2546.f11098 != null) {
            String string = getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_1);
            String str = string + getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_1_1);
            if (!r1.m8143(strM7593)) {
                m2592(this.f2546.f11098, String.format(str, strM7606));
                return;
            }
            String str2 = str.substring(0, str.length() - 1) + getResources().getString(R.string.TEXT_INFO_SUBSCRIPTION_2);
            this.f2546.f11098.setText(C4451.m13715(String.format(str2, strM7606, strM7593), string.length(), String.format(str2, strM7606, strM7593).length() - 1));
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2590() {
        if (C4843.m14569().m14570() != 0) {
            this.f2546.f11090.setVisibility(0);
            this.f2546.f11093.setVisibility(0);
        } else {
            this.f2546.f11090.setVisibility(8);
            this.f2546.f11093.setVisibility(8);
        }
        m2594(false);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m2591(TextView textView, int i) {
        m2592(textView, getResources().getString(i));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2592(TextView textView, String str) {
        textView.setText(str);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m2593(TextView textView, float f, int i) {
        textView.setTypeface(FilmApp.m404());
        textView.setTextSize(0, f);
        if (i != 0) {
            textView.setText(getResources().getString(i));
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m2594(boolean z) {
        C4008.m12877(this.f2546.f11090, z ? 0.0f : 1.0f, 100, null);
        C4008.m12877(this.f2546.f11093, z ? 1.0f : 0.0f, 100, new C0951(z));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m2595(AbstractC4012 abstractC4012, int i) {
        this.f2548 = i;
        setAlpha(0.0f);
        setVisibility(0);
        if (C4843.m14569().m14570() != 0) {
            this.f2546.f11096.setVisibility(8);
        } else {
            this.f2546.f11096.setVisibility(8);
        }
        m2590();
        if (i == 1) {
            this.f2546.f11103.setVisibility(0);
            this.f2546.f11086.setVisibility(0);
            this.f2546.f11095.setBackgroundColor(getResources().getColor(R.color.transparent, null));
        } else {
            this.f2546.f11103.setVisibility(8);
            this.f2546.f11086.setVisibility(8);
            this.f2546.f11095.setBackgroundColor(getResources().getColor(R.color.colorHalfBlack, null));
        }
        m2589();
        C4008.m12876(this, 1.0f, 100, abstractC4012);
        C4628.m14086().m14089(getContext());
    }

    public SubscribeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SubscribeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2547 = 1.0f;
        m2585();
    }
}
