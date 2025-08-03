package com.blink.academy.film.widgets.dialog.login;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC4030;
import defpackage.C2579;
import defpackage.C4066;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.InterfaceC3655;

/* loaded from: classes.dex */
public class SignInView extends CardView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4030 f3035;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f3036;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC3655 f3037;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f3038;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f3039;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$Ϳ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1096 implements View.OnTouchListener {
        public ViewOnTouchListenerC1096() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (SignInView.this.f3035.f13999.getVisibility() == 0) {
                view.setAlpha(1.0f);
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                view.setAlpha(0.3f);
            } else if (action == 1 || action == 3) {
                view.setAlpha(1.0f);
            }
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$Ԩ, reason: contains not printable characters */
    public class C1097 implements TextView.OnEditorActionListener {
        public C1097() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 5) {
                return false;
            }
            SignInView.this.f3035.f13998.performClick();
            return true;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1098 implements View.OnClickListener {
        public ViewOnClickListenerC1098() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SignInView.this.f3037 != null) {
                SignInView.this.f3037.mo3088();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$Ԭ, reason: contains not printable characters */
    public class C1099 implements TextWatcher {
        public C1099() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (SignInView.this.f3039 || SignInView.this.f3036.length() == editable.length()) {
                return;
            }
            SignInView.this.f3035.f13994.setText(SignInView.this.f3036);
            SignInView.this.f3035.f13994.setSelection(SignInView.this.f3036.length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (SignInView.this.f3037 != null) {
                SignInView.this.f3037.mo3087();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1100 implements View.OnClickListener {
        public ViewOnClickListenerC1100() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1101 implements View.OnClickListener {
        public ViewOnClickListenerC1101() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1102 implements View.OnClickListener {
        public ViewOnClickListenerC1102() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SignInView.this.f3037 != null) {
                SignInView.this.f3037.mo3086();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1103 implements View.OnClickListener {
        public ViewOnClickListenerC1103() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SignInView.this.f3037 != null) {
                SignInView.this.f3037.mo3088();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1104 implements View.OnClickListener {
        public ViewOnClickListenerC1104() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SignInView.this.f3039 && SignInView.this.f3037 != null) {
                SignInView.this.f3037.mo3090();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$ؠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1105 implements View.OnClickListener {
        public ViewOnClickListenerC1105() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SignInView.this.f3037 != null) {
                SignInView.this.f3037.mo3086();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$ހ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1106 implements View.OnTouchListener {
        public ViewOnTouchListenerC1106() {
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

    /* renamed from: com.blink.academy.film.widgets.dialog.login.SignInView$ށ, reason: contains not printable characters */
    public class ViewOnClickListenerC1107 implements View.OnClickListener {
        public ViewOnClickListenerC1107() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SignInView.this.f3035.f13999.getVisibility() == 0 || SignInView.this.f3037 == null) {
                return;
            }
            SignInView.this.f3039 = false;
            SignInView signInView = SignInView.this;
            signInView.f3036 = signInView.f3035.f13994.getText().toString();
            SignInView.this.f3037.mo3089(SignInView.this.f3038, SignInView.this.f3035.f13994.getText().toString());
        }
    }

    public SignInView(@NonNull Context context) {
        this(context, null);
    }

    public void setClickAble(boolean z) {
        if (z) {
            this.f3035.f13990.setVisibility(8);
        } else {
            this.f3035.f13990.setVisibility(0);
        }
    }

    public void setOnNextCallback(InterfaceC3655 interfaceC3655) {
        this.f3037 = interfaceC3655;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m2994() {
        this.f3035.f13994.setText("");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2995() {
        this.f3039 = true;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2996() {
        this.f3035.f13994.requestFocus();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2997(boolean z) {
        if (z) {
            this.f3035.f14002.setVisibility(0);
        } else {
            this.f3035.f14002.setVisibility(8);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2998(boolean z) {
        this.f3035.f14006.setVisibility(8);
        if (!z || C4843.m14569().m14570() == 0) {
            return;
        }
        this.f3035.f14006.setVisibility(0);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m2999() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f3035.f13994.getWindowToken(), 0);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m3000() {
        this.f3035.f13999.setVisibility(8);
        this.f3035.f13998.setVisibility(0);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m3001() {
        this.f3035 = AbstractC4030.m12911(LayoutInflater.from(getContext()), this, true);
        m3003();
        m3002();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m3002() {
        this.f3035.f13994.addTextChangedListener(new C1099());
        this.f3035.f13990.setOnClickListener(new ViewOnClickListenerC1100());
        this.f3035.f13993.setOnClickListener(new ViewOnClickListenerC1101());
        this.f3035.f14006.setOnClickListener(new ViewOnClickListenerC1102());
        this.f3035.f14002.setOnClickListener(new ViewOnClickListenerC1103());
        this.f3035.f13997.setOnClickListener(new ViewOnClickListenerC1104());
        this.f3035.f13996.setOnClickListener(new ViewOnClickListenerC1105());
        this.f3035.f13996.setOnTouchListener(new ViewOnTouchListenerC1106());
        this.f3035.f13998.setOnClickListener(new ViewOnClickListenerC1107());
        this.f3035.f13998.setOnTouchListener(new ViewOnTouchListenerC1096());
        this.f3035.f13994.setOnEditorActionListener(new C1097());
        this.f3035.f13991.setOnClickListener(new ViewOnClickListenerC1098());
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m3003() {
        setRadius(0.0f);
        this.f3035.f14003.setTypeface(FilmApp.m404());
        this.f3035.f13994.setTypeface(FilmApp.m404());
        this.f3035.f14007.setTypeface(FilmApp.m404());
        this.f3035.f14006.setTypeface(FilmApp.m404());
        this.f3035.f14002.setTypeface(FilmApp.m404());
        this.f3035.f14005.setTypeface(FilmApp.m404());
        this.f3035.f14001.setTypeface(FilmApp.m404());
        this.f3035.f14004.setTypeface(FilmApp.m404());
        this.f3035.f14000.setTypeface(FilmApp.m404());
        this.f3035.f13994.setLongClickable(false);
        this.f3035.f13994.setTextIsSelectable(false);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m3004(int i, int i2, boolean z) {
        float f = i;
        int i3 = (int) (0.084f * f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3035.f14007.getLayoutParams();
        float f2 = i2;
        layoutParams.topMargin = (int) (0.116f * f2);
        layoutParams.leftMargin = i3;
        this.f3035.f14007.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3035.f13991.getLayoutParams();
        layoutParams2.topMargin = layoutParams.topMargin - C2579.m9438(15.5f);
        layoutParams2.rightMargin = layoutParams.leftMargin - C2579.m9438(15.5f);
        this.f3035.f13991.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3035.f14004.getLayoutParams();
        layoutParams3.topMargin = (int) (0.056f * f2);
        layoutParams3.leftMargin = i3;
        layoutParams3.rightMargin = i3;
        this.f3035.f14004.setLayoutParams(layoutParams3);
        this.f3035.f14007.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f14006.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f14002.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f14005.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f14001.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f13994.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f14003.setTextSize(0, C4792.m14375().m14381());
        this.f3035.f14004.setTextSize(0, C4792.m14375().m14377());
        this.f3035.f14004.setTextSize(0, C4792.m14375().m14377());
        TextView textView = this.f3035.f14004;
        textView.setText(textView.getText());
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3035.f14000.getLayoutParams();
        layoutParams4.topMargin = (int) (0.099f * f2);
        this.f3035.f14000.setLayoutParams(layoutParams4);
        this.f3035.f14000.setPadding(i3, 0, i3, (int) (0.051f * f2));
        int i4 = ((int) (f2 * 0.096f)) / 2;
        this.f3035.f13996.setPadding(i3, i4, i3, i4);
        this.f3035.f13998.setPadding(i3, i4, i3, i4);
        this.f3035.f14006.setPadding(i3, i4, i3, i4);
        this.f3035.f14002.setPadding(i3, i4, i3, i4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3035.f13989.getLayoutParams();
        layoutParams5.bottomMargin = C2579.m9438(20.0f);
        this.f3035.f13989.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3035.f13999.getLayoutParams();
        layoutParams6.rightMargin = i3;
        this.f3035.f13999.setLayoutParams(layoutParams6);
        int i5 = (int) (0.16693291f * f);
        int i6 = (int) (0.067891374f * f);
        int i7 = (int) (0.07827476f * f);
        int i8 = (int) (0.053514376f * f);
        int i9 = (int) (0.15974441f * f);
        RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f3035.f13994.getLayoutParams();
        layoutParams7.rightMargin = i5;
        layoutParams7.width = (int) (0.49121407f * f);
        layoutParams7.height = i7 + i9;
        if (z) {
            i8 = (int) (f * 0.079872206f);
        }
        layoutParams7.topMargin = i8;
        this.f3035.f13994.setLayoutParams(layoutParams7);
        this.f3035.f13994.setPadding(0, 0, 0, i9);
        RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f3035.f13997.getLayoutParams();
        layoutParams8.leftMargin = i5 - i6;
        layoutParams8.height = i7;
        layoutParams8.topMargin = i8;
        layoutParams8.width = (int) (C2579.m9438(15.0f) + this.f3035.f14003.getPaint().measureText("+999") + (i6 * 2));
        this.f3035.f13997.setLayoutParams(layoutParams8);
        this.f3035.f13997.setPadding(i6, 0, i6, 0);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m3005(String str, String str2) {
        this.f3038 = str;
        this.f3035.f14003.setText("+" + str);
        this.f3035.f14000.setText("");
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m3006(int i, int i2) {
        this.f3035.f14007.setText(i);
        this.f3035.f14004.setText(i2);
        this.f3035.f13996.setVisibility(0);
        this.f3035.f14006.setVisibility(8);
        this.f3035.f14002.setVisibility(8);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m3007() {
        this.f3035.f13998.setVisibility(4);
        this.f3035.f13999.setVisibility(0);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m3008(Activity activity) {
        this.f3035.f13994.requestFocus();
        C4066.m13003(activity);
    }

    public SignInView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3039 = true;
        m3001();
    }
}
