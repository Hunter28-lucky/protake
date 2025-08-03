package com.blink.academy.film.widgets.dialog.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.smssdk.SMSSDK;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.bean.AreaItem;
import com.blink.academy.film.widgets.dialog.login.C1131;
import com.blink.academy.film.widgets.dialog.login.VerifyView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C2813;
import defpackage.C4008;
import defpackage.C4066;
import defpackage.C4792;
import defpackage.C5125;
import defpackage.InterfaceC2539;
import defpackage.InterfaceC2717;
import defpackage.InterfaceC3632;
import defpackage.InterfaceC3655;
import defpackage.InterfaceC4926;
import defpackage.InterfaceC5285;
import defpackage.ViewOnClickListenerC4235;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LoginDialog.java */
/* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1131 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Dialog f3120;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Context f3121;

    /* renamed from: ԩ, reason: contains not printable characters */
    public View f3122;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public View f3123;

    /* renamed from: ԫ, reason: contains not printable characters */
    public TextView f3124;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public View f3125;

    /* renamed from: ԭ, reason: contains not printable characters */
    public View f3126;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public SignInView f3127;

    /* renamed from: ԯ, reason: contains not printable characters */
    public VerifyView f3128;

    /* renamed from: ՠ, reason: contains not printable characters */
    public View f3129;

    /* renamed from: ֈ, reason: contains not printable characters */
    public ImageView f3130;

    /* renamed from: ֏, reason: contains not printable characters */
    public ImageView f3131;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f3132;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f3133;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f3134;

    /* renamed from: ބ, reason: contains not printable characters */
    public ViewOnClickListenerC4235 f3138;

    /* renamed from: އ, reason: contains not printable characters */
    public int f3141;

    /* renamed from: މ, reason: contains not printable characters */
    public List<AreaItem> f3143;

    /* renamed from: ށ, reason: contains not printable characters */
    public Rect f3135 = new Rect();

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3136 = 0;

    /* renamed from: ރ, reason: contains not printable characters */
    public ViewTreeObserver.OnGlobalLayoutListener f3137 = new ViewTreeObserverOnGlobalLayoutListenerC1136();

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f3139 = 1.0f;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f3140 = 1.0f;

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean f3142 = false;

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$Ϳ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1132 implements Animation.AnimationListener {
        public AnimationAnimationListenerC1132() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C1131.this.f3124.setVisibility(8);
            C1131.this.f3142 = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$Ԩ, reason: contains not printable characters */
    public class C1133 implements VerifyView.InterfaceC1117 {
        public C1133() {
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        public void onClose() {
            C1131.this.m3131(0L);
            C1131.this.m3130();
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        /* renamed from: Ԩ */
        public void mo2956() {
            C1131.this.m3131(0L);
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        /* renamed from: ԩ */
        public void mo2957() throws Resources.NotFoundException {
            C1131.this.m3131(0L);
            C1131.this.m3137(0, 200, "", "", false);
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC1134 implements View.OnClickListener {
        public ViewOnClickListenerC1134() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (C1131.this.f3141 != 1) {
                C1131.this.m3130();
            } else {
                C1131.this.m3131(0L);
                C1131.this.m3137(0, 200, "", "", false);
            }
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$Ԭ, reason: contains not printable characters */
    public class C1135 implements InterfaceC3655 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3655 f3147;

        public C1135(InterfaceC3655 interfaceC3655) {
            this.f3147 = interfaceC3655;
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ϳ */
        public void mo3086() {
            C1131.this.m3130();
            InterfaceC3655 interfaceC3655 = this.f3147;
            if (interfaceC3655 != null) {
                interfaceC3655.mo3086();
            }
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ԩ */
        public void mo3087() {
            C1131.this.m3131(0L);
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԩ */
        public void mo3088() {
            C1131.this.m3130();
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ԫ */
        public void mo3089(String str, String str2) {
            InterfaceC3655 interfaceC3655 = this.f3147;
            if (interfaceC3655 != null) {
                interfaceC3655.mo3089(str, str2);
            }
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԫ */
        public void mo3090() {
            if (Math.abs(C1131.this.f3134 - C1131.this.f3129.getBottom()) > 200) {
                C4066.m13003(C1131.this.f3121);
            }
            C1131.this.m3133();
            C1131.this.m3134();
            C1131.this.m3140();
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$Ԯ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1136 implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC1136() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (C1131.this.f3120.isShowing()) {
                C1131.this.f3122.getWindowVisibleDisplayFrame(C1131.this.f3135);
                if (C1131.this.f3122.getRootView().getHeight() - C1131.this.f3135.bottom <= 100) {
                    if (!C1131.this.f3133) {
                        if (C1131.this.f3136 != 0) {
                            C1131.this.f3136 = 0;
                            C4008.m12886(C1131.this.f3125, 0.0f, 0.0f, 0, null);
                            C4008.m12886(C1131.this.f3126, 0.0f, 0.0f, 0, null);
                            return;
                        }
                        return;
                    }
                    if (C1131.this.f3136 != 0) {
                        C1131.this.f3136 = 0;
                        C4008.m12886(C1131.this.f3125, 0.0f, 0.0f, 0, null);
                        C4008.m12886(C1131.this.f3126, 0.0f, 0.0f, 0, null);
                        C4008.m12886(C1131.this.f3124, 0.0f, 0.0f, 0, null);
                        return;
                    }
                    return;
                }
                if (!C1131.this.f3133) {
                    int i = (int) ((-(C1131.this.f3134 - C1131.this.f3135.height())) / 2.0f);
                    if (i != C1131.this.f3136) {
                        C1131.this.f3136 = i;
                        C4008.m12886(C1131.this.f3125, 0.0f, C1131.this.f3136, 0, null);
                        C4008.m12886(C1131.this.f3126, 0.0f, C1131.this.f3136, 0, null);
                        return;
                    }
                    return;
                }
                int i2 = (int) ((-(C1131.this.f3134 - C1131.this.f3135.height())) / 3.0f);
                if (i2 != C1131.this.f3136) {
                    C1131.this.f3136 = i2;
                    C4008.m12886(C1131.this.f3125, 0.0f, C1131.this.f3136, 0, null);
                    C4008.m12886(C1131.this.f3126, 0.0f, C1131.this.f3136, 0, null);
                    C4008.m12886(C1131.this.f3124, 0.0f, C1131.this.f3136, 0, null);
                }
            }
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$ՠ, reason: contains not printable characters */
    public class C1137 implements InterfaceC5285 {
        public C1137() {
        }

        @Override // defpackage.InterfaceC5285
        /* renamed from: Ϳ */
        public void mo3091(int i, int i2, int i3, View view) {
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$ֈ, reason: contains not printable characters */
    public class RunnableC1138 implements Runnable {
        public RunnableC1138() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C1131.this.f3120.dismiss();
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$֏, reason: contains not printable characters */
    public class C1139 extends AbstractC4012 {
        public C1139() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C1131.this.f3130.setAlpha(1.0f);
            C1131.this.f3131.setAlpha(0.5f);
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$ׯ, reason: contains not printable characters */
    public class C1140 extends AbstractC4012 {
        public C1140() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C1131.this.f3130.setAlpha(0.5f);
            C1131.this.f3131.setAlpha(1.0f);
        }
    }

    /* compiled from: LoginDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ԩ$ؠ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1141 implements Animation.AnimationListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f3154;

        public AnimationAnimationListenerC1141(boolean z) {
            this.f3154 = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f3154) {
                C1131.this.m3131(3000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public C1131(Context context, boolean z, boolean z2) {
        this.f3121 = context;
        m3132(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޔ, reason: contains not printable characters */
    public /* synthetic */ void m3120(long j) throws Resources.NotFoundException {
        if (j == -1) {
            this.f3124.setVisibility(8);
        } else if (this.f3124.getVisibility() == 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f3121, R.anim.actionbar_translate_exit);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1132());
            this.f3124.startAnimation(animationLoadAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޕ, reason: contains not printable characters */
    public /* synthetic */ void m3121() {
        this.f3127.m3008((Activity) this.f3121);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޖ, reason: contains not printable characters */
    public /* synthetic */ void m3122(DialogInterface dialogInterface) {
        FilmApp.m405().m428(new Runnable() { // from class: ǫ
            @Override // java.lang.Runnable
            public final void run() {
                this.f9192.m3121();
            }
        }, 50L);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static /* synthetic */ void m3123(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޘ, reason: contains not printable characters */
    public /* synthetic */ void m3124(int i, int i2, int i3) {
        AreaItem areaItem = this.f3143.get(i);
        m3136(areaItem.m465(), areaItem.m464());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޙ, reason: contains not printable characters */
    public /* synthetic */ void m3125() {
        this.f3127.m3008((Activity) this.f3121);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޚ, reason: contains not printable characters */
    public /* synthetic */ void m3126(Object obj) {
        FilmApp.m405().m428(new Runnable() { // from class: ଢ଼
            @Override // java.lang.Runnable
            public final void run() {
                this.f15324.m3125();
            }
        }, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޛ, reason: contains not printable characters */
    public /* synthetic */ void m3127(DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        SMSSDK.unregisterAllEventHandler();
        this.f3122.getViewTreeObserver().removeOnGlobalLayoutListener(this.f3137);
        m3131(-1L);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޜ, reason: contains not printable characters */
    public /* synthetic */ void m3128(boolean z) {
        if (z) {
            this.f3127.m3007();
        } else {
            this.f3127.m3000();
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m3129() {
        this.f3121 = null;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m3130() {
        Dialog dialog = this.f3120;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f3128.m3018();
        this.f3127.m2999();
        FilmApp.m405().m428(new RunnableC1138(), 50L);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m3131(final long j) {
        if (this.f3124.getVisibility() != 0 || this.f3142) {
            this.f3124.setVisibility(8);
        } else {
            this.f3142 = true;
            FilmApp.m405().m428(new Runnable() { // from class: ಪ
                @Override // java.lang.Runnable
                public final void run() throws Resources.NotFoundException {
                    this.f15768.m3120(j);
                }
            }, j);
        }
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final void m3132(boolean z, boolean z2) {
        this.f3120 = new Dialog(this.f3121);
        this.f3133 = z;
        View viewInflate = View.inflate(this.f3121, R.layout.layout_login_dialog, null);
        this.f3122 = viewInflate;
        this.f3123 = viewInflate.findViewById(R.id.click_view);
        this.f3124 = (TextView) this.f3122.findViewById(R.id.login_dialog_msg_tv);
        this.f3125 = this.f3122.findViewById(R.id.indicator_parent);
        this.f3126 = this.f3122.findViewById(R.id.login_dialog_vp);
        this.f3128 = (VerifyView) this.f3122.findViewById(R.id.login_dialog_verify);
        this.f3127 = (SignInView) this.f3122.findViewById(R.id.login_dialog_signin);
        this.f3129 = this.f3122.findViewById(R.id.login_dialog_bottom_view);
        this.f3130 = (ImageView) this.f3122.findViewById(R.id.login_dialog_indicator1);
        this.f3131 = (ImageView) this.f3122.findViewById(R.id.login_dialog_indicator2);
        this.f3124.setTypeface(FilmApp.m404());
        this.f3134 = z2 ? C2579.m9440(this.f3121) : C2579.f9593;
        int i = (z2 && this.f3133) ? C2579.f9593 : C2579.f9594;
        int iM14438 = C4792.m14375().m14438();
        int iM14437 = C4792.m14375().m14437();
        int i2 = (i - iM14438) / 2;
        int i3 = (int) (i2 * 0.5f);
        if (z) {
            iM14438 = C2579.m9440(this.f3121) - C2579.m9438(50.0f);
            iM14437 = (int) ((iM14438 * 2.0f) / 3.0f);
            i2 = (i - iM14438) / 2;
            i3 = (int) (i2 * 0.5f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3127.getLayoutParams();
        layoutParams.width = iM14438;
        layoutParams.height = iM14437;
        layoutParams.leftMargin = i2;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3125.getLayoutParams();
        int iM9438 = (i - C2579.m9438(20.0f)) / 2;
        layoutParams2.leftMargin = iM9438;
        if (C2813.f10260 && Build.VERSION.SDK_INT < 28) {
            layoutParams.leftMargin = (int) ((i2 - C4792.m14375().m14442()) + 0.5f);
            layoutParams2.leftMargin = (int) ((iM9438 - C4792.m14375().m14442()) + 0.5f);
        }
        this.f3125.setLayoutParams(layoutParams2);
        this.f3127.setLayoutParams(layoutParams);
        this.f3127.m3004(layoutParams.width, layoutParams.height, this.f3133);
        this.f3132 = iM14438 + i3;
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f3124.getLayoutParams();
        int iM14473 = C4792.m14375().m14473();
        C4792.m14375().m14462();
        layoutParams3.topMargin = iM14473;
        if (this.f3133) {
            layoutParams3.topMargin = 0;
            layoutParams3.addRule(2, R.id.login_dialog_vp);
            layoutParams3.bottomMargin = C2579.m9438(20.0f);
        }
        this.f3124.setLayoutParams(layoutParams3);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f3128.getLayoutParams();
        layoutParams4.height = iM14437;
        layoutParams4.width = iM14438;
        layoutParams4.leftMargin = i3;
        this.f3128.setLayoutParams(layoutParams4);
        this.f3128.m3025(layoutParams4.width, layoutParams4.height, this.f3133);
        this.f3120.requestWindowFeature(1);
        this.f3120.getWindow().setSoftInputMode(18);
        this.f3120.setContentView(this.f3122);
        WindowManager.LayoutParams attributes = this.f3120.getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        attributes.gravity = 17;
        attributes.width = i;
        attributes.height = this.f3134;
        this.f3120.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f3120.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        this.f3120.getWindow().setAttributes(attributes);
        this.f3120.getWindow().getDecorView().setSystemUiVisibility(2);
        this.f3120.getWindow().getDecorView().setSystemUiVisibility(5894);
        this.f3120.setOnShowListener(new DialogInterface.OnShowListener() { // from class: ڼ
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f12554.m3122(dialogInterface);
            }
        });
        this.f3128.setOnBackClickCallback(new C1133());
        this.f3123.setOnClickListener(new ViewOnClickListenerC1134());
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public final void m3133() {
        if (r1.m8144(this.f3143)) {
            return;
        }
        String[][] strArr = {this.f3121.getResources().getStringArray(R.array.hashtag), this.f3121.getResources().getStringArray(R.array.a_letter), this.f3121.getResources().getStringArray(R.array.b_letter), this.f3121.getResources().getStringArray(R.array.c_letter), this.f3121.getResources().getStringArray(R.array.d_letter), this.f3121.getResources().getStringArray(R.array.e_letter), this.f3121.getResources().getStringArray(R.array.f_letter), this.f3121.getResources().getStringArray(R.array.g_letter), this.f3121.getResources().getStringArray(R.array.h_letter), this.f3121.getResources().getStringArray(R.array.i_letter), this.f3121.getResources().getStringArray(R.array.j_letter), this.f3121.getResources().getStringArray(R.array.k_letter), this.f3121.getResources().getStringArray(R.array.l_letter), this.f3121.getResources().getStringArray(R.array.m_letter), this.f3121.getResources().getStringArray(R.array.n_letter), this.f3121.getResources().getStringArray(R.array.o_letter), this.f3121.getResources().getStringArray(R.array.p_letter), this.f3121.getResources().getStringArray(R.array.q_letter), this.f3121.getResources().getStringArray(R.array.r_letter), this.f3121.getResources().getStringArray(R.array.s_letter), this.f3121.getResources().getStringArray(R.array.t_letter), this.f3121.getResources().getStringArray(R.array.u_letter), this.f3121.getResources().getStringArray(R.array.v_letter), this.f3121.getResources().getStringArray(R.array.w_letter), this.f3121.getResources().getStringArray(R.array.x_letter), this.f3121.getResources().getStringArray(R.array.y_letter), this.f3121.getResources().getStringArray(R.array.z_letter)};
        this.f3143 = new ArrayList();
        for (int i = 0; i < 27; i++) {
            for (String str : strArr[i]) {
                String[] strArrSplit = str.split("\\+");
                this.f3143.add(new AreaItem(strArrSplit[0], strArrSplit[1]));
            }
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final void m3134() {
        if (this.f3138 != null) {
            return;
        }
        ViewOnClickListenerC4235 viewOnClickListenerC4235M15032 = new C5125(this.f3121, new C1137()).m15040(R.layout.area_picker_content, new InterfaceC2539() { // from class: ȥ
            @Override // defpackage.InterfaceC2539
            /* renamed from: Ϳ, reason: contains not printable characters */
            public final void mo9357(View view) {
                C1131.m3123(view);
            }
        }).m15041(new InterfaceC3632() { // from class: ॳ
            @Override // defpackage.InterfaceC3632
            /* renamed from: Ϳ */
            public final void mo3975(int i, int i2, int i3) {
                this.f14260.m3124(i, i2, i3);
            }
        }).m15039(0).m15037(15).m15033(true).m15032();
        this.f3138 = viewOnClickListenerC4235M15032;
        Dialog dialogM15102 = viewOnClickListenerC4235M15032.m15102();
        if (dialogM15102 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.f3138.m15103().setLayoutParams(layoutParams);
            Window window = dialogM15102.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = dialogM15102.getWindow().getAttributes();
                attributes.gravity = 17;
                attributes.width = -1;
                attributes.height = -2;
                dialogM15102.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                dialogM15102.getWindow().setAttributes(attributes);
                dialogM15102.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                dialogM15102.getWindow().setSoftInputMode(34);
                if (!this.f3133) {
                    dialogM15102.getWindow().getDecorView().setSystemUiVisibility(2);
                    dialogM15102.getWindow().getDecorView().setSystemUiVisibility(5894);
                }
                window.setWindowAnimations(R.style.picker_view_slide_anim);
                window.setGravity(80);
            }
        }
        this.f3138.m15113(new InterfaceC2717() { // from class: Ά
            @Override // defpackage.InterfaceC2717
            /* renamed from: Ϳ */
            public final void mo9973(Object obj) {
                this.f10127.m3126(obj);
            }
        });
        this.f3138.m13337(this.f3143);
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void m3135() {
        this.f3128.m3016();
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m3136(String str, String str2) {
        this.f3127.m3005(str, str2);
        m3131(0L);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public void m3137(int i, int i2, String str, String str2, boolean z) throws Resources.NotFoundException {
        this.f3141 = i;
        if (i == 0) {
            C4008.m12886(this.f3127, 0.0f, 0.0f, i2, null);
            C4008.m12886(this.f3128, 0.0f, 0.0f, i2, null);
            C4008.m12876(this.f3127, this.f3139, i2, null);
            C4008.m12876(this.f3128, this.f3140, i2, new C1139());
            this.f3127.setClickAble(true);
            this.f3128.setClickAble(false);
            this.f3127.m2996();
        } else {
            C4008.m12886(this.f3127, -this.f3132, 0.0f, i2, null);
            C4008.m12886(this.f3128, -this.f3132, 0.0f, i2, null);
            C4008.m12876(this.f3127, this.f3140, i2, null);
            C4008.m12876(this.f3128, this.f3139, i2, new C1140());
            this.f3127.setClickAble(false);
            this.f3128.setClickAble(true);
            if (!z) {
                this.f3128.m3027(str, str2);
                this.f3128.m3024();
            }
            this.f3128.m3017();
        }
        this.f3127.m2995();
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m3138(InterfaceC3655 interfaceC3655, InterfaceC4926 interfaceC4926, final DialogInterface.OnDismissListener onDismissListener, String str, String str2, boolean z) throws Resources.NotFoundException {
        Dialog dialog;
        Context context = this.f3121;
        if (context == null || ((Activity) context).isDestroyed() || (dialog = this.f3120) == null || dialog.isShowing()) {
            return;
        }
        this.f3128.m3016();
        this.f3127.m2994();
        if (z) {
            this.f3127.m2998(true);
            this.f3127.m2997(false);
        } else {
            this.f3127.m2998(false);
            this.f3127.m2997(true);
        }
        m3137(0, 0, "", "", false);
        this.f3120.show();
        this.f3120.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ӊ
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f11041.m3127(onDismissListener, dialogInterface);
            }
        });
        this.f3127.setOnNextCallback(new C1135(interfaceC3655));
        this.f3127.m3005(str, str2);
        this.f3128.setOnVerifyClickCallback(interfaceC4926);
        this.f3122.getViewTreeObserver().addOnGlobalLayoutListener(this.f3137);
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m3139(@NonNull String str, boolean z) throws Resources.NotFoundException {
        this.f3127.m2995();
        this.f3124.setText(str.toUpperCase());
        if (this.f3124.getVisibility() == 8) {
            this.f3124.setVisibility(0);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f3121, R.anim.actionbar_translate_enter);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1141(z));
            this.f3124.startAnimation(animationLoadAnimation);
        }
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m3140() {
        if (this.f3138.m15109()) {
            return;
        }
        this.f3138.m15115();
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public void m3141(String str) throws Resources.NotFoundException {
        m3142(str, true);
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m3142(String str, boolean z) throws Resources.NotFoundException {
        m3139(str, z);
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public void m3143(final boolean z) {
        FilmApp.m405().m427(new Runnable() { // from class: Փ
            @Override // java.lang.Runnable
            public final void run() {
                this.f11376.m3128(z);
            }
        });
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public boolean m3144(String str, String str2) {
        return str.equals(this.f3128.getAreaCode()) && str2.equals(this.f3128.getPhoneStr()) && !this.f3128.m3023();
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public void m3145() {
        this.f3128.m3026();
    }
}
