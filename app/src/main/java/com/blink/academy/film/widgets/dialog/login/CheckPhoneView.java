package com.blink.academy.film.widgets.dialog.login;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.VerificationCodeEditText;
import defpackage.AbstractC4129;
import defpackage.C2579;
import defpackage.C4792;
import defpackage.m5;

/* loaded from: classes.dex */
public class CheckPhoneView extends CardView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f2982;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC1068 f2983;

    /* renamed from: ԭ, reason: contains not printable characters */
    public AbstractC4129 f2984;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$Ϳ, reason: contains not printable characters */
    public class C1060 implements m5 {
        public C1060() {
        }

        @Override // defpackage.m5
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo2938(CharSequence charSequence) {
            if (CheckPhoneView.this.f2983 != null) {
                CheckPhoneView.this.f2983.mo2944();
            }
        }

        @Override // defpackage.m5
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2939(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // defpackage.m5
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo2940() {
            CheckPhoneView.this.f2984.f14306.setText("");
        }

        @Override // defpackage.m5
        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean mo2941() {
            if (CheckPhoneView.this.f2983 != null) {
                return CheckPhoneView.this.f2983.mo2943();
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$Ԩ, reason: contains not printable characters */
    public class C1061 implements TextWatcher {
        public C1061() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            CheckPhoneView.this.m2928();
            if (CheckPhoneView.this.f2983 != null) {
                CheckPhoneView.this.f2983.mo2945();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1062 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC1063 implements Runnable {
            public RunnableC1063() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (CheckPhoneView.this.f2983 != null) {
                    CheckPhoneView.this.f2983.mo2942();
                }
            }
        }

        public ViewOnClickListenerC1062() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CheckPhoneView.this.f2984.f14306 != null) {
                CheckPhoneView.this.f2984.f14306.setFocusable(false);
                CheckPhoneView.this.f2984.f14306.setFocusableInTouchMode(false);
                CheckPhoneView.this.f2984.f14306.clearFocus();
                InputMethodManager inputMethodManager = (InputMethodManager) CheckPhoneView.this.f2984.f14306.getContext().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(CheckPhoneView.this.f2984.f14306.getWindowToken(), 0);
                }
            }
            FilmApp.m405().m428(new RunnableC1063(), 200L);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$Ԭ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1064 implements View.OnTouchListener {
        public ViewOnTouchListenerC1064() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1065 implements View.OnClickListener {
        public ViewOnClickListenerC1065() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CheckPhoneView.this.f2984.f14302.isEnabled() && CheckPhoneView.this.f2983 != null) {
                CheckPhoneView.this.f2983.mo2944();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1066 implements View.OnTouchListener {
        public ViewOnTouchListenerC1066() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            view.setAlpha(1.0f);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1067 implements View.OnClickListener {
        public ViewOnClickListenerC1067() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.CheckPhoneView$֏, reason: contains not printable characters */
    public interface InterfaceC1068 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo2942();

        /* renamed from: Ԩ, reason: contains not printable characters */
        boolean mo2943();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo2944();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo2945();
    }

    public CheckPhoneView(@NonNull Context context) {
        this(context, null);
    }

    public String getEditContent() {
        return this.f2984.f14306.getText().toString();
    }

    public void setCheckPhoneClickCallback(InterfaceC1068 interfaceC1068) {
        this.f2983 = interfaceC1068;
    }

    public void setClickAble(boolean z) {
        if (z) {
            this.f2984.f14298.setVisibility(8);
        } else {
            this.f2984.f14298.setVisibility(0);
        }
    }

    public void setNeedCheckPhoneNumber(String str) {
        this.f2982 = str;
        this.f2984.f14307.setText(str);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2927() {
        this.f2984.f14306.setText("");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2928() {
        this.f2984.f14302.setEnabled(false);
        this.f2984.f14302.setAlpha(0.3f);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2929() {
        this.f2984.f14306.requestFocus();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2930() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f2984.f14306.getWindowToken(), 0);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2931(Context context, AttributeSet attributeSet, int i) {
        setRadius(0.0f);
        setCardBackgroundColor(Color.parseColor("#ffba00"));
        this.f2984 = AbstractC4129.m13101(LayoutInflater.from(getContext()), this, true);
        m2933();
        m2932();
        this.f2984.f14306.setOnVerificationCodeChangedListener(new C1060());
        this.f2984.f14306.addTextChangedListener(new C1061());
        m2928();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2932() {
        this.f2984.f14301.setOnClickListener(new ViewOnClickListenerC1062());
        this.f2984.f14301.setOnTouchListener(new ViewOnTouchListenerC1064());
        this.f2984.f14302.setOnClickListener(new ViewOnClickListenerC1065());
        this.f2984.f14302.setOnTouchListener(new ViewOnTouchListenerC1066());
        this.f2984.f14300.setOnClickListener(new ViewOnClickListenerC1067());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m2933() {
        this.f2984.f14308.setTypeface(FilmApp.m404());
        this.f2984.f14307.setTypeface(FilmApp.m404());
        this.f2984.f14306.setTypeface(FilmApp.m404());
        this.f2984.f14297.setTypeface(FilmApp.m404());
        this.f2984.f14296.setTypeface(FilmApp.m404());
        this.f2984.f14304.setTypeface(FilmApp.m404());
        this.f2984.f14305.setTypeface(FilmApp.m404());
        this.f2984.f14308.setTextSize(0, C4792.m14375().m14381());
        this.f2984.f14304.setTextSize(0, C4792.m14375().m14381());
        this.f2984.f14305.setTextSize(0, C4792.m14375().m14381());
        this.f2984.f14297.setTextSize(0, C4792.m14375().m14386());
        this.f2984.f14296.setTextSize(0, C4792.m14375().m14386());
        this.f2984.f14306.setTextSize(0, C4792.m14375().m14386());
        this.f2984.f14307.setTextSize(0, C4792.m14375().m14377());
        this.f2984.f14297.setAlpha(0.3f);
        this.f2984.f14296.setAlpha(0.3f);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2934(int i, int i2) {
        float f = i;
        int i3 = (int) (0.084f * f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f2984.f14308.getLayoutParams();
        float f2 = i2;
        layoutParams.topMargin = (int) (0.116f * f2);
        layoutParams.leftMargin = i3;
        this.f2984.f14308.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f2984.f14307.getLayoutParams();
        layoutParams2.topMargin = (int) (0.056f * f2);
        layoutParams2.leftMargin = i3;
        layoutParams2.rightMargin = i3;
        this.f2984.f14307.setLayoutParams(layoutParams2);
        int i4 = (int) (0.19178082f * f2);
        int i5 = (int) (0.15974441f * f);
        ((RelativeLayout.LayoutParams) this.f2984.f14295.getLayoutParams()).topMargin = (int) (0.13013698f * f2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f2984.f14306.getLayoutParams();
        layoutParams3.width = (int) (f * 0.18604651f);
        layoutParams3.height = i4 + i5;
        this.f2984.f14306.setLayoutParams(layoutParams3);
        this.f2984.f14306.setPadding(0, 0, 0, i5);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f2984.f14297.getLayoutParams();
        layoutParams4.height = i4;
        this.f2984.f14297.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f2984.f14296.getLayoutParams();
        layoutParams5.height = i4;
        this.f2984.f14296.setLayoutParams(layoutParams5);
        int i6 = ((int) (f2 * 0.096f)) / 2;
        this.f2984.f14301.setPadding(i3, i6, i3, i6);
        this.f2984.f14302.setPadding(i3, i6, i3, i6);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f2984.f14294.getLayoutParams();
        layoutParams6.bottomMargin = C2579.m9438(20.0f);
        this.f2984.f14294.setLayoutParams(layoutParams6);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2935() {
        this.f2984.f14302.setEnabled(true);
        this.f2984.f14302.setAlpha(1.0f);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2936(String str, String str2) {
        this.f2984.f14297.setText(str);
        this.f2984.f14296.setText(str2);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m2937(Activity activity) {
        VerificationCodeEditText verificationCodeEditText = this.f2984.f14306;
        if (verificationCodeEditText != null) {
            verificationCodeEditText.setFocusable(true);
            this.f2984.f14306.setFocusableInTouchMode(true);
            this.f2984.f14306.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2984.f14306.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(this.f2984.f14306, 0);
            }
        }
    }

    public CheckPhoneView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPhoneView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2931(context, attributeSet, i);
    }
}
