package com.blink.academy.film.widgets.dialog.login;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
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
import com.blink.academy.film.widgets.dialog.login.C1118;
import com.blink.academy.film.widgets.dialog.login.CheckPhoneView;
import com.blink.academy.film.widgets.dialog.login.VerifyView;
import com.blink.academy.protake.R;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2813;
import defpackage.C4008;
import defpackage.C4066;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.C5125;
import defpackage.DialogC4116;
import defpackage.InterfaceC2539;
import defpackage.InterfaceC3632;
import defpackage.InterfaceC3655;
import defpackage.InterfaceC4926;
import defpackage.InterfaceC5285;
import defpackage.ViewOnClickListenerC4235;
import defpackage.r1;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChangePhoneNumberDialog.java */
/* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1118 {

    /* renamed from: ޏ, reason: contains not printable characters */
    public static C1118 f3074;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public DialogC4116 f3075;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Context f3076;

    /* renamed from: ԩ, reason: contains not printable characters */
    public TextView f3077;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public View f3078;

    /* renamed from: ԫ, reason: contains not printable characters */
    public View f3079;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public View f3080;

    /* renamed from: ԭ, reason: contains not printable characters */
    public View f3081;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public View f3082;

    /* renamed from: ԯ, reason: contains not printable characters */
    public CheckPhoneView f3083;

    /* renamed from: ՠ, reason: contains not printable characters */
    public SignInView f3084;

    /* renamed from: ֈ, reason: contains not printable characters */
    public VerifyView f3085;

    /* renamed from: ֏, reason: contains not printable characters */
    public View f3086;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ImageView f3087;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ImageView f3088;

    /* renamed from: ހ, reason: contains not printable characters */
    public ImageView f3089;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f3091;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f3092;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f3093;

    /* renamed from: ޅ, reason: contains not printable characters */
    public boolean f3094;

    /* renamed from: މ, reason: contains not printable characters */
    public ViewOnClickListenerC4235 f3098;

    /* renamed from: ތ, reason: contains not printable characters */
    public int f3101;

    /* renamed from: ގ, reason: contains not printable characters */
    public List<AreaItem> f3103;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f3090 = 0;

    /* renamed from: ކ, reason: contains not printable characters */
    public Rect f3095 = new Rect();

    /* renamed from: އ, reason: contains not printable characters */
    public int f3096 = 0;

    /* renamed from: ވ, reason: contains not printable characters */
    public ViewTreeObserver.OnGlobalLayoutListener f3097 = new ViewTreeObserverOnGlobalLayoutListenerC1123();

    /* renamed from: ފ, reason: contains not printable characters */
    public float f3099 = 1.0f;

    /* renamed from: ދ, reason: contains not printable characters */
    public float f3100 = 1.0f;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f3102 = false;

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$Ϳ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1119 implements Animation.AnimationListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f3104;

        public AnimationAnimationListenerC1119(boolean z) {
            this.f3104 = z;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f3104) {
                C1118.this.m3070(3000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$Ԩ, reason: contains not printable characters */
    public class AnimationAnimationListenerC1120 implements Animation.AnimationListener {
        public AnimationAnimationListenerC1120() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C1118.this.f3077.setVisibility(8);
            C1118.this.f3102 = false;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$Ԫ, reason: contains not printable characters */
    public class C1121 implements VerifyView.InterfaceC1117 {
        public C1121() {
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        public void onClose() {
            C1118.this.m3070(0L);
            C1118.this.m3068();
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        /* renamed from: Ԩ */
        public void mo2956() {
            C1118.this.m3070(0L);
        }

        @Override // com.blink.academy.film.widgets.dialog.login.VerifyView.InterfaceC1117
        /* renamed from: ԩ */
        public void mo2957() throws Resources.NotFoundException {
            C1118.this.m3070(0L);
            C1118.this.m3077(0, 200, "", "", false);
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$Ԭ, reason: contains not printable characters */
    public class ViewOnClickListenerC1122 implements View.OnClickListener {
        public ViewOnClickListenerC1122() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws Resources.NotFoundException {
            if (C1118.this.f3101 == 0) {
                C1118.this.m3070(0L);
                C1118.this.m3077(2, 200, "", "", false);
            } else if (C1118.this.f3101 != 1) {
                C1118.this.m3068();
            } else {
                C1118.this.m3070(0L);
                C1118.this.m3077(0, 200, "", "", false);
            }
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$Ԯ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC1123 implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserverOnGlobalLayoutListenerC1123() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (C1118.this.f3075.isShowing()) {
                C1118.this.f3079.getWindowVisibleDisplayFrame(C1118.this.f3095);
                if (C1118.this.f3079.getRootView().getHeight() - C1118.this.f3095.bottom <= 100) {
                    if (!C1118.this.f3094) {
                        if (C1118.this.f3096 != 0) {
                            C1118.this.f3096 = 0;
                            C4008.m12886(C1118.this.f3082, 0.0f, 0.0f, 0, null);
                            C4008.m12886(C1118.this.f3081, 0.0f, 0.0f, 0, null);
                            return;
                        }
                        return;
                    }
                    if (C1118.this.f3096 != 0) {
                        C1118.this.f3096 = 0;
                        C4008.m12886(C1118.this.f3082, 0.0f, 0.0f, 0, null);
                        C4008.m12886(C1118.this.f3081, 0.0f, 0.0f, 0, null);
                        C4008.m12886(C1118.this.f3077, 0.0f, 0.0f, 0, null);
                        return;
                    }
                    return;
                }
                if (!C1118.this.f3094) {
                    int i = (int) ((-(C1118.this.f3093 - C1118.this.f3095.height())) / 2.0f);
                    if (i != C1118.this.f3096) {
                        C1118.this.f3096 = i;
                        C4008.m12886(C1118.this.f3082, 0.0f, C1118.this.f3096, 0, null);
                        C4008.m12886(C1118.this.f3081, 0.0f, C1118.this.f3096, 0, null);
                        return;
                    }
                    return;
                }
                int i2 = (int) ((-(C1118.this.f3093 - C1118.this.f3095.height())) / 3.0f);
                if (i2 != C1118.this.f3096) {
                    C1118.this.f3096 = i2;
                    C4008.m12886(C1118.this.f3082, 0.0f, C1118.this.f3096, 0, null);
                    C4008.m12886(C1118.this.f3081, 0.0f, C1118.this.f3096, 0, null);
                    C4008.m12886(C1118.this.f3077, 0.0f, C1118.this.f3096, 0, null);
                }
            }
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$ՠ, reason: contains not printable characters */
    public class C1124 implements CheckPhoneView.InterfaceC1068 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String f3110;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f3111;

        public C1124(String str) {
            this.f3111 = str;
        }

        @Override // com.blink.academy.film.widgets.dialog.login.CheckPhoneView.InterfaceC1068
        /* renamed from: Ϳ */
        public void mo2942() {
            C1118.this.m3068();
        }

        @Override // com.blink.academy.film.widgets.dialog.login.CheckPhoneView.InterfaceC1068
        /* renamed from: Ԩ */
        public boolean mo2943() {
            if (!C1118.this.f3092) {
                return false;
            }
            C1118.this.f3092 = false;
            return true;
        }

        @Override // com.blink.academy.film.widgets.dialog.login.CheckPhoneView.InterfaceC1068
        /* renamed from: ԩ */
        public void mo2944() throws Resources.NotFoundException {
            if (C1118.this.m3067()) {
                String editContent = C1118.this.f3083.getEditContent();
                if (TextUtils.equals(this.f3111, editContent)) {
                    C1118.this.f3083.m2935();
                    C1118.this.m3077(0, 200, "", "", false);
                } else {
                    if (TextUtils.equals(editContent, this.f3110)) {
                        return;
                    }
                    C1118.this.f3092 = true;
                    C1118.m3042(C1118.this);
                    if (C1118.this.f3077.getVisibility() == 0) {
                        C1118.this.m3069();
                    }
                    if (C1118.this.f3090 >= 3) {
                        C1118 c1118 = C1118.this;
                        c1118.m3081(c1118.f3076.getString(R.string.ALERT_TRIED_TOO_MANY));
                        C1118.this.f3083.m2928();
                        C2618.m9572("check_phone_invalid_time", System.currentTimeMillis());
                        C1118.this.f3090 = 0;
                    } else {
                        C1118 c11182 = C1118.this;
                        c11182.m3081(c11182.f3076.getString(R.string.ALERT_WRONG_NUMBER));
                    }
                }
                this.f3110 = editContent;
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.login.CheckPhoneView.InterfaceC1068
        /* renamed from: Ԫ */
        public void mo2945() {
            C1118.this.m3070(0L);
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$ֈ, reason: contains not printable characters */
    public class C1125 implements InterfaceC3655 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ InterfaceC3655 f3113;

        public C1125(InterfaceC3655 interfaceC3655) {
            this.f3113 = interfaceC3655;
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3086() throws Resources.NotFoundException {
            C1118.this.m3077(2, 200, "", "", false);
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo3087() {
            C1118.this.m3070(0L);
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo3088() {
            C1118.this.m3068();
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo3089(String str, String str2) {
            InterfaceC3655 interfaceC3655 = this.f3113;
            if (interfaceC3655 != null) {
                interfaceC3655.mo3089(str, str2);
            }
        }

        @Override // defpackage.InterfaceC3655
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo3090() {
            if (Math.abs(C1118.this.f3093 - C1118.this.f3086.getBottom()) > 200) {
                C4066.m13003(C1118.this.f3076);
            }
            C1118.this.m3072();
            C1118.this.m3073();
            C1118.this.m3080();
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$֏, reason: contains not printable characters */
    public class C1126 implements InterfaceC5285 {
        public C1126() {
        }

        @Override // defpackage.InterfaceC5285
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo3091(int i, int i2, int i3, View view) {
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$ׯ, reason: contains not printable characters */
    public class C1127 extends AbstractC4012 {

        /* compiled from: ChangePhoneNumberDialog.java */
        /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$ׯ$Ϳ, reason: contains not printable characters */
        public class RunnableC1128 implements Runnable {
            public RunnableC1128() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1118.this.f3083.m2937((Activity) C1118.this.f3076);
            }
        }

        public C1127() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C1118.this.f3087.setAlpha(1.0f);
            C1118.this.f3088.setAlpha(0.5f);
            C1118.this.f3089.setAlpha(0.5f);
            FilmApp.m405().m428(new RunnableC1128(), 50L);
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$ؠ, reason: contains not printable characters */
    public class C1129 extends AbstractC4012 {
        public C1129() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C1118.this.f3087.setAlpha(0.5f);
            C1118.this.f3088.setAlpha(1.0f);
            C1118.this.f3089.setAlpha(0.5f);
        }
    }

    /* compiled from: ChangePhoneNumberDialog.java */
    /* renamed from: com.blink.academy.film.widgets.dialog.login.Ϳ$ހ, reason: contains not printable characters */
    public class C1130 extends AbstractC4012 {
        public C1130() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            C1118.this.f3087.setAlpha(0.5f);
            C1118.this.f3088.setAlpha(0.5f);
            C1118.this.f3089.setAlpha(1.0f);
        }
    }

    public C1118(Context context, boolean z) {
        this.f3076 = context;
        m3071(z);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static /* synthetic */ int m3042(C1118 c1118) {
        int i = c1118.f3090;
        c1118.f3090 = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޚ, reason: contains not printable characters */
    public /* synthetic */ void m3062(long j) throws Resources.NotFoundException {
        if (j == -1) {
            this.f3077.setVisibility(8);
        } else if (this.f3102 && this.f3077.getVisibility() == 0) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f3076, R.anim.actionbar_translate_exit);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1120());
            this.f3077.startAnimation(animationLoadAnimation);
        }
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public static /* synthetic */ void m3063(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޜ, reason: contains not printable characters */
    public /* synthetic */ void m3064(int i, int i2, int i3) {
        AreaItem areaItem = this.f3103.get(i);
        m3076(areaItem.m465(), areaItem.m464());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޝ, reason: contains not printable characters */
    public /* synthetic */ void m3065(DialogInterface.OnDismissListener onDismissListener, DialogInterface dialogInterface) {
        C4638.m14099("slimmm", "onDismiss");
        SMSSDK.unregisterAllEventHandler();
        C4066.m13001((Activity) this.f3076);
        m3070(-1L);
        this.f3079.getViewTreeObserver().removeOnGlobalLayoutListener(this.f3097);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ޞ, reason: contains not printable characters */
    public /* synthetic */ void m3066(boolean z) {
        if (z) {
            this.f3084.m3007();
        } else {
            this.f3084.m3000();
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public final boolean m3067() {
        return System.currentTimeMillis() - C2618.m9567("check_phone_invalid_time", 0L).longValue() >= ((long) 20000);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m3068() {
        DialogC4116 dialogC4116 = this.f3075;
        if (dialogC4116 == null || !dialogC4116.isShowing()) {
            return;
        }
        this.f3085.m3018();
        this.f3084.m2999();
        this.f3083.m2930();
        this.f3075.dismiss();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m3069() {
        this.f3102 = false;
        if (this.f3077.getVisibility() == 0) {
            this.f3077.setVisibility(8);
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m3070(final long j) {
        if (this.f3077.getVisibility() != 0 || this.f3102) {
            return;
        }
        this.f3102 = true;
        FilmApp.m405().m428(new Runnable() { // from class: ߔ
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                this.f13115.m3062(j);
            }
        }, j);
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final void m3071(boolean z) {
        this.f3094 = z;
        this.f3075 = new DialogC4116(this.f3076);
        View viewInflate = View.inflate(this.f3076, R.layout.layout_changephone_dialog_content, null);
        this.f3079 = viewInflate;
        this.f3080 = viewInflate.findViewById(R.id.click_view);
        this.f3081 = this.f3079.findViewById(R.id.login_dialog_vp);
        this.f3082 = this.f3079.findViewById(R.id.indicator_parent);
        this.f3077 = (TextView) this.f3079.findViewById(R.id.login_dialog_msg_tv);
        this.f3083 = (CheckPhoneView) this.f3079.findViewById(R.id.login_dialog_checkphone);
        this.f3084 = (SignInView) this.f3079.findViewById(R.id.login_dialog_signin);
        this.f3085 = (VerifyView) this.f3079.findViewById(R.id.login_dialog_verify);
        this.f3078 = this.f3079.findViewById(R.id.center_view);
        this.f3084.m3006(R.string.TITLE_NEW_PHONE_NUMBER, R.string.DESC_NEW_PHONE_NUMBER);
        this.f3086 = this.f3079.findViewById(R.id.login_dialog_bottom_view);
        this.f3087 = (ImageView) this.f3079.findViewById(R.id.login_dialog_indicator1);
        this.f3088 = (ImageView) this.f3079.findViewById(R.id.login_dialog_indicator2);
        this.f3089 = (ImageView) this.f3079.findViewById(R.id.login_dialog_indicator3);
        this.f3077.setTypeface(FilmApp.m404());
        this.f3093 = C2579.f9593;
        int i = C2579.f9594;
        int iM14438 = C4792.m14375().m14438();
        int iM14437 = C4792.m14375().m14437();
        int i2 = (i - iM14438) / 2;
        int i3 = (int) (i2 * 0.5f);
        if (z) {
            iM14438 = C2579.m9440(this.f3076) - C2579.m9438(50.0f);
            iM14437 = (int) ((iM14438 * 2.0f) / 3.0f);
            i2 = (i - iM14438) / 2;
            i3 = (int) (i2 * 0.5f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3083.getLayoutParams();
        layoutParams.width = iM14438;
        layoutParams.height = iM14437;
        layoutParams.leftMargin = i2;
        this.f3083.setLayoutParams(layoutParams);
        this.f3083.m2934(layoutParams.width, layoutParams.height);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f3077.getLayoutParams();
        int iM14473 = C4792.m14375().m14473();
        C4792.m14375().m14462();
        layoutParams2.topMargin = iM14473;
        if (this.f3094) {
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(2, R.id.login_dialog_vp);
            layoutParams2.bottomMargin = C2579.m9438(20.0f);
        }
        this.f3077.setLayoutParams(layoutParams2);
        this.f3091 = iM14438 + i3;
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f3084.getLayoutParams();
        layoutParams3.width = iM14438;
        layoutParams3.height = iM14437;
        layoutParams3.leftMargin = i3;
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f3082.getLayoutParams();
        int iM9438 = (i - C2579.m9438(35.0f)) / 2;
        layoutParams4.leftMargin = iM9438;
        if (C2813.f10260 && Build.VERSION.SDK_INT < 28) {
            layoutParams.leftMargin = (int) ((i2 - C4792.m14375().m14442()) + 0.5f);
            layoutParams4.leftMargin = (int) ((iM9438 - C4792.m14375().m14442()) + 0.5f);
        }
        this.f3082.setLayoutParams(layoutParams4);
        this.f3084.setLayoutParams(layoutParams3);
        this.f3084.m3004(layoutParams3.width, layoutParams3.height, this.f3094);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f3085.getLayoutParams();
        layoutParams5.height = iM14437;
        layoutParams5.width = iM14438;
        layoutParams5.leftMargin = i3;
        this.f3085.setLayoutParams(layoutParams5);
        this.f3085.m3025(layoutParams5.width, layoutParams5.height, this.f3094);
        this.f3075.requestWindowFeature(1);
        this.f3075.setContentView(this.f3079);
        WindowManager.LayoutParams attributes = this.f3075.getWindow().getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        attributes.gravity = 17;
        attributes.width = i;
        attributes.height = this.f3093;
        this.f3075.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.f3075.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        this.f3075.getWindow().setAttributes(attributes);
        this.f3075.getWindow().setSoftInputMode(20);
        this.f3075.getWindow().getDecorView().setSystemUiVisibility(2);
        this.f3075.getWindow().getDecorView().setSystemUiVisibility(5894);
        this.f3085.setOnBackClickCallback(new C1121());
        this.f3080.setOnClickListener(new ViewOnClickListenerC1122());
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m3072() {
        if (r1.m8144(this.f3103)) {
            return;
        }
        String[][] strArr = {this.f3076.getResources().getStringArray(R.array.hashtag), this.f3076.getResources().getStringArray(R.array.a_letter), this.f3076.getResources().getStringArray(R.array.b_letter), this.f3076.getResources().getStringArray(R.array.c_letter), this.f3076.getResources().getStringArray(R.array.d_letter), this.f3076.getResources().getStringArray(R.array.e_letter), this.f3076.getResources().getStringArray(R.array.f_letter), this.f3076.getResources().getStringArray(R.array.g_letter), this.f3076.getResources().getStringArray(R.array.h_letter), this.f3076.getResources().getStringArray(R.array.i_letter), this.f3076.getResources().getStringArray(R.array.j_letter), this.f3076.getResources().getStringArray(R.array.k_letter), this.f3076.getResources().getStringArray(R.array.l_letter), this.f3076.getResources().getStringArray(R.array.m_letter), this.f3076.getResources().getStringArray(R.array.n_letter), this.f3076.getResources().getStringArray(R.array.o_letter), this.f3076.getResources().getStringArray(R.array.p_letter), this.f3076.getResources().getStringArray(R.array.q_letter), this.f3076.getResources().getStringArray(R.array.r_letter), this.f3076.getResources().getStringArray(R.array.s_letter), this.f3076.getResources().getStringArray(R.array.t_letter), this.f3076.getResources().getStringArray(R.array.u_letter), this.f3076.getResources().getStringArray(R.array.v_letter), this.f3076.getResources().getStringArray(R.array.w_letter), this.f3076.getResources().getStringArray(R.array.x_letter), this.f3076.getResources().getStringArray(R.array.y_letter), this.f3076.getResources().getStringArray(R.array.z_letter)};
        this.f3103 = new ArrayList();
        for (int i = 0; i < 27; i++) {
            for (String str : strArr[i]) {
                String[] strArrSplit = str.split("\\+");
                this.f3103.add(new AreaItem(strArrSplit[0], strArrSplit[1]));
            }
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m3073() {
        if (this.f3098 != null) {
            return;
        }
        ViewOnClickListenerC4235 viewOnClickListenerC4235M15032 = new C5125(this.f3076, new C1126()).m15040(R.layout.area_picker_content, new InterfaceC2539() { // from class: ґ
            @Override // defpackage.InterfaceC2539
            /* renamed from: Ϳ */
            public final void mo9357(View view) {
                C1118.m3063(view);
            }
        }).m15041(new InterfaceC3632() { // from class: ǀ
            @Override // defpackage.InterfaceC3632
            /* renamed from: Ϳ */
            public final void mo3975(int i, int i2, int i3) {
                this.f9170.m3064(i, i2, i3);
            }
        }).m15039(0).m15037(15).m15033(true).m15032();
        this.f3098 = viewOnClickListenerC4235M15032;
        Dialog dialogM15102 = viewOnClickListenerC4235M15032.m15102();
        if (dialogM15102 != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            this.f3098.m15103().setLayoutParams(layoutParams);
            Window window = dialogM15102.getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = dialogM15102.getWindow().getAttributes();
                attributes.gravity = 17;
                attributes.width = -1;
                attributes.height = -2;
                dialogM15102.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                dialogM15102.getWindow().setAttributes(attributes);
                dialogM15102.getWindow().setSoftInputMode(18);
                if (!this.f3094) {
                    dialogM15102.getWindow().getDecorView().setSystemUiVisibility(2);
                    dialogM15102.getWindow().getDecorView().setSystemUiVisibility(5894);
                }
                window.setWindowAnimations(R.style.picker_view_slide_anim);
                window.setGravity(80);
            }
        }
        this.f3098.m13337(this.f3103);
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m3074() {
        if (m3067()) {
            return;
        }
        this.f3083.m2928();
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public void m3075() {
        this.f3085.m3016();
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public void m3076(String str, String str2) {
        this.f3084.m3005(str, str2);
        m3070(0L);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public void m3077(int i, int i2, String str, String str2, boolean z) throws Resources.NotFoundException {
        this.f3101 = i;
        if (i == 2) {
            m3074();
            float f = 0;
            C4008.m12886(this.f3083, f, 0.0f, i2, null);
            C4008.m12886(this.f3084, f, 0.0f, i2, null);
            C4008.m12886(this.f3085, f, 0.0f, i2, null);
            C4008.m12876(this.f3083, this.f3099, i2, null);
            C4008.m12876(this.f3085, this.f3100, i2, null);
            C4008.m12876(this.f3084, this.f3100, i2, new C1127());
            this.f3083.setClickAble(true);
            this.f3084.setClickAble(false);
            this.f3085.setClickAble(false);
            this.f3083.m2929();
            return;
        }
        if (i == 0) {
            float f2 = -this.f3091;
            C4008.m12886(this.f3083, f2, 0.0f, i2, null);
            C4008.m12886(this.f3084, f2, 0.0f, i2, null);
            C4008.m12886(this.f3085, f2, 0.0f, i2, null);
            C4008.m12876(this.f3083, this.f3100, i2, null);
            C4008.m12876(this.f3084, this.f3099, i2, null);
            C4008.m12876(this.f3085, this.f3100, i2, new C1129());
            this.f3083.setClickAble(false);
            this.f3084.setClickAble(true);
            this.f3085.setClickAble(false);
            this.f3084.m2996();
            this.f3084.m2995();
            return;
        }
        if (i == 1) {
            float f3 = (-this.f3091) * 2;
            C4008.m12886(this.f3083, f3, 0.0f, i2, null);
            C4008.m12886(this.f3084, f3, 0.0f, i2, null);
            C4008.m12886(this.f3085, f3, 0.0f, i2, null);
            C4008.m12876(this.f3083, this.f3100, i2, null);
            C4008.m12876(this.f3084, this.f3100, i2, null);
            C4008.m12876(this.f3085, this.f3099, i2, new C1130());
            this.f3083.setClickAble(false);
            this.f3084.setClickAble(false);
            this.f3085.setClickAble(true);
            if (z) {
                return;
            }
            this.f3085.m3027(str, str2);
            this.f3085.m3017();
            this.f3085.m3024();
        }
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public void m3078(InterfaceC3655 interfaceC3655, InterfaceC4926 interfaceC4926, final DialogInterface.OnDismissListener onDismissListener, String str, String str2) throws Resources.NotFoundException {
        Context context = this.f3076;
        if (context == null || ((Activity) context).isDestroyed()) {
            f3074 = null;
            return;
        }
        DialogC4116 dialogC4116 = this.f3075;
        if (dialogC4116 == null || dialogC4116.isShowing()) {
            return;
        }
        this.f3085.m3016();
        this.f3084.m2994();
        this.f3083.m2927();
        String strM9569 = C2618.m9569("user_login_phone_sp", "");
        int length = strM9569.length();
        int i = length - 1;
        int i2 = i - 2;
        int i3 = i - 5;
        String strSubstring = strM9569.substring(0, i3);
        int i4 = i2 + 1;
        String strSubstring2 = strM9569.substring(i3, i4);
        String strSubstring3 = strM9569.substring(i4, length);
        this.f3083.setNeedCheckPhoneNumber(this.f3076.getResources().getString(R.string.DESC_VERIFY_PHONE_NUMBER));
        this.f3083.m2936(strSubstring, strSubstring3);
        this.f3083.setCheckPhoneClickCallback(new C1124(strSubstring2));
        m3074();
        m3077(2, 0, "", "", false);
        this.f3075.show();
        this.f3075.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ۀ
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f12566.m3065(onDismissListener, dialogInterface);
            }
        });
        this.f3084.setOnNextCallback(new C1125(interfaceC3655));
        this.f3084.m3005(str, str2);
        this.f3085.setOnVerifyClickCallback(interfaceC4926);
        this.f3079.getViewTreeObserver().addOnGlobalLayoutListener(this.f3097);
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public final void m3079(@NonNull String str, boolean z) throws Resources.NotFoundException {
        this.f3084.m2995();
        this.f3077.setText(str.toUpperCase());
        if (this.f3077.getVisibility() == 8) {
            this.f3077.setVisibility(0);
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f3076, R.anim.actionbar_translate_enter);
            animationLoadAnimation.setAnimationListener(new AnimationAnimationListenerC1119(z));
            this.f3077.startAnimation(animationLoadAnimation);
        }
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final void m3080() {
        if (this.f3098.m15109()) {
            return;
        }
        this.f3098.m15115();
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public void m3081(String str) throws Resources.NotFoundException {
        m3082(str, true);
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public void m3082(String str, boolean z) throws Resources.NotFoundException {
        m3079(str, z);
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public void m3083(final boolean z) {
        FilmApp.m405().m427(new Runnable() { // from class: ཇ
            @Override // java.lang.Runnable
            public final void run() {
                this.f16788.m3066(z);
            }
        });
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public boolean m3084(String str, String str2) {
        return str.equals(this.f3085.getAreaCode()) && str2.equals(this.f3085.getPhoneStr()) && !this.f3085.m3023();
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public void m3085() {
        this.f3085.m3026();
    }
}
