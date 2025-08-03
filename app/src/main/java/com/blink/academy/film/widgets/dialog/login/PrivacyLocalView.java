package com.blink.academy.film.widgets.dialog.login;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blink.academy.film.FilmApp;
import defpackage.AbstractC4304;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C4320;
import defpackage.C4451;

/* loaded from: classes.dex */
public class PrivacyLocalView extends CardView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC4304 f3005;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3006;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC1081 f3007;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f3008;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC1075 implements View.OnClickListener {
        public ViewOnClickListenerC1075() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyLocalView.this.f3007 != null) {
                PrivacyLocalView.this.f3007.onDisagree();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$Ԩ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1076 implements View.OnTouchListener {
        public ViewOnTouchListenerC1076() {
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

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC1077 implements View.OnTouchListener {
        public ViewOnTouchListenerC1077() {
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

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1078 implements View.OnClickListener {
        public ViewOnClickListenerC1078() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PrivacyLocalView.this.f3006 == 1) {
                C2618.m9570("terms_alert_sp", true);
            }
            if (PrivacyLocalView.this.f3007 != null) {
                PrivacyLocalView.this.f3007.mo460(PrivacyLocalView.this.f3006 == 0);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$Ԯ, reason: contains not printable characters */
    public class ViewOnClickListenerC1079 implements View.OnClickListener {
        public ViewOnClickListenerC1079() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4320.m13464(PrivacyLocalView.this.getContext(), C4320.m13457(""));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1080 implements View.OnClickListener {
        public ViewOnClickListenerC1080() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4320.m13464(PrivacyLocalView.this.getContext(), C4320.m13455(""));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.PrivacyLocalView$ֈ, reason: contains not printable characters */
    public interface InterfaceC1081 {
        void onDisagree();

        /* renamed from: Ϳ */
        void mo460(boolean z);
    }

    public PrivacyLocalView(@NonNull Context context) {
        this(context, null);
    }

    public void setShowType(int i) {
        this.f3006 = i;
    }

    public void setSplash(boolean z) {
        this.f3005.f14749.setText("温馨提示");
        StringBuilder sb = new StringBuilder();
        sb.append("欢迎您使用 Protake ！\n\n");
        sb.append("我们依据最新的监管要求准备了");
        int length = sb.length();
        sb.append("《隐私权政策》");
        int length2 = sb.length();
        sb.append("以及");
        int length3 = sb.length();
        sb.append("《用户服务协议》");
        int length4 = sb.length();
        sb.append("（点击了解更新后的详细内容），特向您说明如下：");
        SpannableString spannableString = new SpannableString(sb.toString());
        C4451.m13718(spannableString, new ViewOnClickListenerC1079(), length, length2);
        C4451.m13718(spannableString, new ViewOnClickListenerC1080(), length3, length4);
        this.f3005.f14753.setText(spannableString);
        this.f3005.f14754.setText("\t\t\t\t1.为向您提供录像相关基本功能，我们会收集、使用必要的信息；\n\t\t\t\t2.基于您的明示授权，我们可能会获取您的位置（为您的视频添加位置信息）等信息，您有权拒绝或取消授权；\n\t\t\t\t3.我们会采取业界先进的安全措施保护您的信息安全；\n\t\t\t\t4.未经您同意，我们不会从第三方处获取、共享或向其提供您的信息；\n\t\t\t\t5.您可以查询、更正、删除您的个人信息，我们也提供账户注销的渠道。\n");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2960() {
        setVisibility(8);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m2961() {
        this.f3005 = AbstractC4304.m13423(LayoutInflater.from(getContext()), this, true);
        m2963();
        m2962();
        setRadius(C2579.m9438(0.0f));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m2962() {
        this.f3005.f14746.setOnClickListener(new ViewOnClickListenerC1075());
        this.f3005.f14746.setOnTouchListener(new ViewOnTouchListenerC1076());
        this.f3005.f14745.setOnTouchListener(new ViewOnTouchListenerC1077());
        this.f3005.f14745.setOnClickListener(new ViewOnClickListenerC1078());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2963() {
        this.f3005.f14749.getPaint().setFakeBoldText(true);
        this.f3005.f14748.setTypeface(FilmApp.m404());
        this.f3005.f14747.setTypeface(FilmApp.m404());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m2964(int i, int i2) {
        int iM9438 = C2579.m9438(35.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f3005.f14752.getLayoutParams();
        layoutParams.width = i;
        this.f3005.f14752.setLayoutParams(layoutParams);
        int iM94382 = C2579.m9438(15.0f);
        this.f3005.f14745.setPadding(iM9438, iM94382, iM9438, iM94382);
        this.f3005.f14746.setPadding(iM9438, iM94382, iM9438, iM94382);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3005.f14750.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = ((int) this.f3005.f14747.getPaint().measureText(this.f3005.f14747.getText().toString())) + C2579.m9438(12.0f);
        this.f3005.f14750.setLayoutParams(layoutParams2);
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f3005.f14751.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams3).width = ((int) this.f3005.f14748.getPaint().measureText(this.f3005.f14748.getText().toString())) + C2579.m9438(12.0f);
        this.f3005.f14751.setLayoutParams(layoutParams3);
        this.f3005.f14753.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public PrivacyLocalView m2965(InterfaceC1081 interfaceC1081, boolean z) {
        this.f3007 = interfaceC1081;
        setSplash(z);
        return this;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2966() {
        setVisibility(0);
    }

    public PrivacyLocalView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PrivacyLocalView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3006 = 0;
        this.f3008 = false;
        m2961();
    }
}
