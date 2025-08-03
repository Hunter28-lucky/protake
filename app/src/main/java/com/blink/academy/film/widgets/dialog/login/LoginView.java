package com.blink.academy.film.widgets.dialog.login;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.dialog.login.VerifyView;
import com.blink.academy.protake.R;
import defpackage.AbstractC2714;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C4008;

/* loaded from: classes.dex */
public class LoginView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC2714 f2993;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2994;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2995;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f2996;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2997;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f2998;

    /* renamed from: com.blink.academy.film.widgets.dialog.login.LoginView$Ϳ, reason: contains not printable characters */
    public class C1069 implements VerifyView.InterfaceC1117 {
        public C1069() {
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        public void onClose() {
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo2956() {
            LoginView.this.m2951(0L);
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo2957() throws Resources.NotFoundException {
            LoginView.this.m2951(0L);
            LoginView.this.m2955(0, 200, "", "", false);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.LoginView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1070 implements View.OnClickListener {
        public ViewOnClickListenerC1070() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.LoginView$Ԫ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1071 implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC1071() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (LoginView.this.getVisibility() == 0 && LoginView.this.f2993.f10040.getVisibility() == 0) {
                Rect rect = new Rect();
                ((Activity) LoginView.this.getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int height = ((Activity) LoginView.this.getContext()).getWindow().getDecorView().getRootView().getHeight();
                if (height - rect.bottom > height / 3) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) LoginView.this.f2993.f10040.getLayoutParams();
                    layoutParams.topMargin = LoginView.this.f2995 + rect.bottom + C2579.m9438(30.0f);
                    LoginView.this.f2993.f10040.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) LoginView.this.f2993.f10040.getLayoutParams();
                    layoutParams2.topMargin = LoginView.this.f2995;
                    LoginView.this.f2993.f10040.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.LoginView$Ԭ, reason: contains not printable characters */
    public class C1072 extends AbstractC4012 {
        public C1072() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            LoginView.this.f2993.f10038.setAlpha(1.0f);
            LoginView.this.f2993.f10039.setAlpha(0.5f);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.LoginView$Ԯ, reason: contains not printable characters */
    public class C1073 extends AbstractC4012 {
        public C1073() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            LoginView.this.f2993.f10038.setAlpha(0.5f);
            LoginView.this.f2993.f10039.setAlpha(1.0f);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.login.LoginView$ՠ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1074 implements Animation.AnimationListener {
        public AnimationAnimationListenerC1074() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            LoginView.this.f2993.f10040.setVisibility(8);
            LoginView.this.f2998 = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public LoginView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ԯ, reason: contains not printable characters */
    public /* synthetic */ void m2950(long j) throws Resources.NotFoundException {
        if (j == -1) {
            this.f2993.f10040.setVisibility(8);
        } else if (this.f2993.f10040.getVisibility() == 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.actionbar_translate_exit);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1074());
            this.f2993.f10040.startAnimation(animationLoadAnimation);
        }
    }

    public void setTeleSign(boolean z) {
        this.f2993.f10042.setTeleSign(z);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2951(final long j) {
        if (this.f2993.f10040.getVisibility() != 0 || this.f2998) {
            return;
        }
        this.f2998 = true;
        FilmApp.m405().m428(new Runnable() { // from class: வ
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f15392.m2950(j);
            }
        }, j);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m2952() {
        this.f2993 = AbstractC2714.m9970(LayoutInflater.from(getContext()), this, true);
        m2954();
        m2953();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m2953() {
        this.f2993.f10042.setOnBackClickCallback(new C1069());
        this.f2993.f10035.setOnClickListener(new ViewOnClickListenerC1070());
        this.f2993.f10040.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC1071());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m2954() {
        int i = C2579.f9594;
        int i2 = (int) (i * 0.26078868f);
        int i3 = (int) (i2 * 0.5f);
        int i4 = i - (i2 * 2);
        int i5 = (int) (i4 * 0.5f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2993.f10041.getLayoutParams();
        layoutParams.width = i4;
        layoutParams.height = i5;
        layoutParams.leftMargin = i2;
        this.f2993.f10041.setLayoutParams(layoutParams);
        this.f2993.f10041.m3004(layoutParams.width, layoutParams.height, false);
        this.f2994 = i4 + i3;
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2993.f10042.getLayoutParams();
        layoutParams2.height = i5;
        layoutParams2.width = i4;
        layoutParams2.leftMargin = i3;
        this.f2993.f10042.setLayoutParams(layoutParams2);
        this.f2993.f10042.m3025(layoutParams2.width, layoutParams2.height, false);
        this.f2995 = (((C2579.f9593 - i5) / 2) - C2579.m9438(20.0f)) - C2579.m9438(30.0f);
        ((RelativeLayout.LayoutParams) this.f2993.f10040.getLayoutParams()).topMargin = this.f2995;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public void m2955(int i, int i2, String str, String str2, boolean z) throws Resources.NotFoundException {
        if (i == 0) {
            C4008.m12886(this.f2993.f10041, 0.0f, 0.0f, i2, null);
            C4008.m12886(this.f2993.f10042, 0.0f, 0.0f, i2, null);
            C4008.m12876(this.f2993.f10041, this.f2996, i2, null);
            C4008.m12876(this.f2993.f10042, this.f2997, i2, new C1072());
            this.f2993.f10041.setClickAble(true);
            this.f2993.f10042.setClickAble(false);
            this.f2993.f10041.m2996();
        } else {
            C4008.m12886(this.f2993.f10041, -this.f2994, 0.0f, i2, null);
            C4008.m12886(this.f2993.f10042, -this.f2994, 0.0f, i2, null);
            C4008.m12876(this.f2993.f10041, this.f2997, i2, null);
            C4008.m12876(this.f2993.f10042, this.f2996, i2, new C1073());
            this.f2993.f10041.setClickAble(false);
            this.f2993.f10042.setClickAble(true);
            if (!z) {
                this.f2993.f10042.m3027(str, str2);
                this.f2993.f10042.m3017();
                this.f2993.f10042.m3024();
            }
        }
        this.f2993.f10041.m2995();
    }

    public LoginView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2996 = 1.0f;
        this.f2997 = 1.0f;
        this.f2998 = false;
        m2952();
    }
}
