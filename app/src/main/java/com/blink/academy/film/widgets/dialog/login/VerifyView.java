package com.blink.academy.film.widgets.dialog.login;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.protake.R;
import defpackage.AbstractC2689;
import defpackage.C2579;
import defpackage.C4451;
import defpackage.C4792;
import defpackage.InterfaceC4926;
import defpackage.m5;

/* loaded from: classes.dex */
public class VerifyView extends CardView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f3056;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public WeakHandler f3057;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f3058;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public AbstractC2689 f3059;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC1117 f3060;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f3061;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f3062;

    /* renamed from: ֏, reason: contains not printable characters */
    public String f3063;

    /* renamed from: ׯ, reason: contains not printable characters */
    public InterfaceC4926 f3064;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$Ϳ, reason: contains not printable characters */
    public class C1108 implements m5 {
        public C1108() {
        }

        @Override // defpackage.m5
        /* renamed from: Ϳ */
        public void mo2938(CharSequence charSequence) {
            if (VerifyView.this.f3064 != null) {
                VerifyView.this.f3064.mo10068(VerifyView.this.f3062, charSequence.toString());
            }
        }

        @Override // defpackage.m5
        /* renamed from: Ԩ */
        public void mo2939(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // defpackage.m5
        /* renamed from: ԩ */
        public void mo2940() {
            VerifyView.this.f3059.f9974.setText("");
        }

        @Override // defpackage.m5
        /* renamed from: Ԫ */
        public boolean mo2941() {
            return VerifyView.this.f3059.f9974.getText() != null && VerifyView.this.f3059.f9974.getText().toString().length() == 4;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$Ԩ, reason: contains not printable characters */
    public class C1109 implements TextWatcher {
        public C1109() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (VerifyView.this.f3060 != null) {
                VerifyView.this.f3060.mo2956();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1110 implements View.OnClickListener {
        public ViewOnClickListenerC1110() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1111 implements View.OnClickListener {
        public ViewOnClickListenerC1111() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1112 implements View.OnClickListener {
        public ViewOnClickListenerC1112() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerifyView.this.f3060 != null) {
                VerifyView.this.f3060.onClose();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1113 implements View.OnTouchListener {
        public ViewOnTouchListenerC1113() {
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

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$ֈ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1114 implements View.OnTouchListener {
        public ViewOnTouchListenerC1114() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (VerifyView.this.f3056 != 0) {
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

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$֏, reason: contains not printable characters */
    public class ViewOnClickListenerC1115 implements View.OnClickListener {
        public ViewOnClickListenerC1115() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!VerifyView.this.f3059.f9978.getText().toString().equals(VerifyView.this.getResources().getString(R.string.LABEL_CALL_ME))) {
                VerifyView.this.f3059.f9980.setText(VerifyView.this.getResources().getString(R.string.BUTTON_RESEND));
                VerifyView.this.f3059.f9978.setText(VerifyView.this.getResources().getString(R.string.LABEL_CALL_ME));
                VerifyView.this.f3059.f9978.setRotation(0.0f);
                VerifyView.this.f3059.f9975.setVisibility(8);
                return;
            }
            VerifyView.this.f3059.f9970.setVisibility(0);
            VerifyView.this.f3059.f9980.setVisibility(8);
            VerifyView.this.f3059.f9975.setVisibility(0);
            if (VerifyView.this.f3064 != null) {
                VerifyView.this.f3064.mo10067();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$ׯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1116 implements View.OnClickListener {
        public ViewOnClickListenerC1116() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!VerifyView.this.f3059.f9978.getText().toString().equals(VerifyView.this.getResources().getString(R.string.LABEL_CALL_ME))) {
                if (VerifyView.this.f3060 != null) {
                    VerifyView.this.f3060.mo2957();
                }
            } else {
                VerifyView.this.f3059.f9966.setVisibility(0);
                VerifyView.this.f3059.f9975.setVisibility(8);
                VerifyView.this.f3059.f9978.setVisibility(8);
                if (VerifyView.this.f3064 != null) {
                    VerifyView.this.f3064.mo10066();
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.VerifyView$ؠ, reason: contains not printable characters */
    public interface InterfaceC1117 {
        void onClose();

        /* renamed from: Ԩ */
        void mo2956();

        /* renamed from: ԩ */
        void mo2957();
    }

    public VerifyView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ހ, reason: contains not printable characters */
    public /* synthetic */ boolean m3015(Message message) {
        if (message.what != 1) {
            return false;
        }
        m3022();
        return false;
    }

    public String getAreaCode() {
        return this.f3063;
    }

    public String getPhoneStr() {
        return this.f3062;
    }

    public void setClickAble(boolean z) {
        if (z) {
            this.f3059.f9967.setVisibility(8);
        } else {
            this.f3059.f9967.setVisibility(0);
        }
    }

    public void setOnBackClickCallback(InterfaceC1117 interfaceC1117) {
        this.f3060 = interfaceC1117;
    }

    public void setOnVerifyClickCallback(InterfaceC4926 interfaceC4926) {
        this.f3064 = interfaceC4926;
    }

    public void setTeleSign(boolean z) {
        this.f3058 = z;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m3016() {
        this.f3059.f9974.setText("");
        this.f3059.f9977.setVisibility(8);
        this.f3059.f9966.setVisibility(8);
        this.f3059.f9970.setVisibility(8);
        this.f3059.f9980.setVisibility(0);
        this.f3059.f9978.setVisibility(0);
        this.f3059.f9975.setVisibility(0);
        this.f3059.f9980.setText(getResources().getString(R.string.BUTTON_RESEND));
        this.f3059.f9978.setText(getResources().getString(R.string.BUTTON_BACK));
        this.f3059.f9975.setRotation(180.0f);
        this.f3059.f9975.setImageResource(R.drawable.icon_10_next);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m3017() {
        this.f3059.f9974.requestFocus();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m3018() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f3059.f9974.getWindowToken(), 0);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m3019() {
        this.f3059 = AbstractC2689.m9909(LayoutInflater.from(getContext()), this, true);
        m3021();
        m3020();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m3020() {
        this.f3059.f9974.setOnVerificationCodeChangedListener(new C1108());
        this.f3059.f9974.addTextChangedListener(new C1109());
        this.f3059.f9967.setOnClickListener(new ViewOnClickListenerC1110());
        this.f3059.f9972.setOnClickListener(new ViewOnClickListenerC1111());
        this.f3059.f9968.setOnClickListener(new ViewOnClickListenerC1112());
        this.f3059.f9973.setOnTouchListener(new ViewOnTouchListenerC1113());
        this.f3059.f9976.setOnTouchListener(new ViewOnTouchListenerC1114());
        this.f3059.f9976.setOnClickListener(new ViewOnClickListenerC1115());
        this.f3059.f9973.setOnClickListener(new ViewOnClickListenerC1116());
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m3021() {
        setRadius(0.0f);
        this.f3059.f9981.setTypeface(FilmApp.m404());
        this.f3059.f9974.setTypeface(FilmApp.m404());
        this.f3059.f9980.setTypeface(FilmApp.m404());
        this.f3059.f9978.setTypeface(FilmApp.m404());
        this.f3059.f9979.setTypeface(FilmApp.m404());
        this.f3059.f9981.setTextSize(0, C4792.m14375().m14381());
        this.f3059.f9980.setTextSize(0, C4792.m14375().m14381());
        this.f3059.f9978.setTextSize(0, C4792.m14375().m14381());
        this.f3059.f9979.setTextSize(0, C4792.m14375().m14377());
        this.f3059.f9974.setTextSize(0, C4792.m14375().m14386());
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m3022() {
        int i = this.f3056;
        if (i <= 0) {
            this.f3061 = true;
            this.f3059.f9980.setAlpha(1.0f);
            this.f3059.f9976.setClickable(true);
            this.f3059.f9980.setText(getResources().getString(R.string.BUTTON_NOT_RECEIVE));
            return;
        }
        int i2 = i - 1;
        this.f3056 = i2;
        if (i2 <= 0) {
            this.f3061 = true;
            this.f3059.f9980.setAlpha(1.0f);
            this.f3059.f9976.setClickable(true);
            this.f3059.f9980.setText(getResources().getString(R.string.BUTTON_NOT_RECEIVE));
            return;
        }
        this.f3061 = false;
        this.f3059.f9980.setAlpha(0.3f);
        this.f3059.f9976.setClickable(false);
        this.f3059.f9980.setText(getResources().getString(R.string.BUTTON_WAIT_FOR_SMS, Integer.valueOf(this.f3056)));
        this.f3057.sendEmptyMessageDelayed(1, 1000L);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m3023() {
        return this.f3061;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m3024() {
        m3028();
        this.f3056 = 61;
        m3022();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m3025(int i, int i2, boolean z) {
        float f = i;
        int i3 = (int) (0.084f * f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3059.f9981.getLayoutParams();
        float f2 = i2;
        layoutParams.topMargin = (int) (0.116f * f2);
        layoutParams.leftMargin = i3;
        this.f3059.f9981.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3059.f9979.getLayoutParams();
        layoutParams2.topMargin = (int) (0.056f * f2);
        layoutParams2.leftMargin = i3;
        layoutParams2.rightMargin = i3;
        this.f3059.f9979.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3059.f9968.getLayoutParams();
        layoutParams3.topMargin = layoutParams.topMargin - C2579.m9438(15.5f);
        this.f3059.f9968.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f3059.f9971.getLayoutParams();
        layoutParams4.width = i3 - C2579.m9438(15.5f);
        this.f3059.f9971.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f3059.f9974.getLayoutParams();
        layoutParams5.topMargin = (int) (0.031948883f * f);
        if (z) {
            layoutParams5.topMargin = (int) (0.079872206f * f);
        }
        layoutParams5.width = (int) (0.45f * f);
        layoutParams5.height = (int) (f * 0.111821085f);
        this.f3059.f9974.setLayoutParams(layoutParams5);
        int i4 = ((int) (f2 * 0.096f)) / 2;
        this.f3059.f9973.setPadding(i3, i4, i3, i4);
        this.f3059.f9976.setPadding(i3, i4, i3, i4);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f3059.f9965.getLayoutParams();
        layoutParams6.bottomMargin = C2579.m9438(20.0f);
        this.f3059.f9965.setLayoutParams(layoutParams6);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m3026() {
        m3016();
        m3024();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m3027(String str, String str2) throws Resources.NotFoundException {
        this.f3062 = str2;
        this.f3063 = str;
        String str3 = "+" + str + MyUTIL.white_space + str2;
        String string = getResources().getString(R.string.TEXT_VERIFY, str3);
        this.f3059.f9979.setText(C4451.m13715(string, string.indexOf(str3), string.indexOf(str3) + str3.length()));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m3028() {
        this.f3057.removeMessages(1);
    }

    public VerifyView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerifyView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3057 = new WeakHandler(new Handler.Callback() { // from class: n5
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f8048.m3015(message);
            }
        });
        this.f3061 = true;
        m3019();
    }
}
