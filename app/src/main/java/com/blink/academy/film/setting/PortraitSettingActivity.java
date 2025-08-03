package com.blink.academy.film.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.base.BaseActivity;
import com.blink.academy.film.bean.camera.QrCodeBean;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.CacheHuaweiBean;
import com.blink.academy.film.netbean.CachePlayStoreBean;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.store.SubscribeInfoCallback;
import com.blink.academy.film.support.controller.PayController;
import com.blink.academy.film.support.pay.google.GooglePayHelper;
import com.blink.academy.film.support.pay.huawei.HuaweiPay;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.dialog.SettingCodeDialog;
import com.blink.academy.film.widgets.dialog.SettingGimbalDialog;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView;
import com.blink.academy.film.widgets.setting.PortraitPresetSettingView;
import com.blink.academy.film.widgets.setting.PortraitRecordSettingView;
import com.blink.academy.film.widgets.setting.RecordSettingView;
import com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView;
import com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView;
import com.blink.academy.film.zxing.CaptureActivity;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import defpackage.AbstractC3960;
import defpackage.AbstractC4012;
import defpackage.C2462;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2749;
import defpackage.C2772;
import defpackage.C3088;
import defpackage.C3108;
import defpackage.C3410;
import defpackage.C3608;
import defpackage.C3617;
import defpackage.C3659;
import defpackage.C3703;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4320;
import defpackage.C4535;
import defpackage.C4567;
import defpackage.C4628;
import defpackage.C4638;
import defpackage.C4689;
import defpackage.C4757;
import defpackage.C4792;
import defpackage.C4843;
import defpackage.C4929;
import defpackage.C5049;
import defpackage.C5213;
import defpackage.InterfaceC4875;
import defpackage.c9;
import defpackage.e5;
import defpackage.j;
import defpackage.n;
import defpackage.r1;
import defpackage.z0;

/* loaded from: classes.dex */
public class PortraitSettingActivity extends BaseActivity {

    /* renamed from: ނ, reason: contains not printable characters */
    public static final String f1264 = "PortraitSettingActivity";

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3960 f1265;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f1266;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f1267;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1268;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f1269;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1270;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f1271 = 5;

    /* renamed from: ֏, reason: contains not printable characters */
    public long[] f1272 = new long[3];

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f1273;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C3703 f1274;

    /* renamed from: ހ, reason: contains not printable characters */
    public C2772 f1275;

    /* renamed from: ށ, reason: contains not printable characters */
    public boolean f1276;

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ϳ, reason: contains not printable characters */
    public class C0594 implements C4567.InterfaceC4574 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0595 implements Runnable {
            public RunnableC0595() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3938();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ϳ$Ԩ, reason: contains not printable characters */
        public class RunnableC0596 implements Runnable {
            public RunnableC0596() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3942();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ϳ$Ԫ, reason: contains not printable characters */
        public class RunnableC0597 implements Runnable {
            public RunnableC0597() {
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                C3891 c3891 = new C3891();
                String string = PortraitSettingActivity.this.getResources().getString(R.string.POPUP_TITLE_PROTAKE_FOCUS_UPDATE);
                String string2 = PortraitSettingActivity.this.getResources().getString(R.string.POPUP_DESC_PROTAKE_FOCUS_UPDATE);
                String string3 = PortraitSettingActivity.this.getResources().getString(R.string.BUTTON_CANCEL);
                String string4 = PortraitSettingActivity.this.getResources().getString(R.string.POPUP_DESC_PROTAKE_FOCUS_CONFIRM);
                c3891.m12515(string);
                c3891.m12553(string2);
                c3891.m12516(string3);
                c3891.m12503(string4);
                PortraitSettingActivity.this.m1709(33, c3891);
            }
        }

        public C0594() {
        }

        @Override // defpackage.C4567.InterfaceC4574
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1720() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0595());
        }

        @Override // defpackage.C4567.InterfaceC4574
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1721() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0597());
        }

        @Override // defpackage.C4567.InterfaceC4574
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1722() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0596());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԩ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0598 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC0599 implements Runnable {
            public RunnableC0599() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13750.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC0598() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (PortraitSettingActivity.this.f1271 == 2) {
                    return false;
                }
                PortraitSettingActivity.this.f1265.f13750.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0599(), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0600 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC0601 implements Runnable {
            public RunnableC0601() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13749.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC0600() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (PortraitSettingActivity.this.f1271 == 1) {
                    return false;
                }
                PortraitSettingActivity.this.f1265.f13749.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0601(), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԭ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0602 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC0603 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1286;

            public RunnableC0603(View view) {
                this.f1286 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1286.isEnabled()) {
                    PortraitSettingActivity.this.f1265.f13774.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0602() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (PortraitSettingActivity.this.f1271 == 0) {
                    return false;
                }
                PortraitSettingActivity.this.f1265.f13774.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0603(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0604 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0605 implements Runnable {
            public RunnableC0605() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13747.setAlpha(1.0f);
            }
        }

        public ViewOnTouchListenerC0604() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (PortraitSettingActivity.this.f1271 == 3) {
                    return false;
                }
                PortraitSettingActivity.this.f1265.f13747.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0605(), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0606 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ՠ$Ϳ, reason: contains not printable characters */
        public class RunnableC0607 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1291;

            public RunnableC0607(View view) {
                this.f1291 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1291.isEnabled()) {
                    PortraitSettingActivity.this.f1265.f13773.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0606() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (PortraitSettingActivity.this.f1271 == 4) {
                    return false;
                }
                PortraitSettingActivity.this.f1265.f13773.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0607(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ֈ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0608 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ֈ$Ϳ, reason: contains not printable characters */
        public class RunnableC0609 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1294;

            public RunnableC0609(View view) {
                this.f1294 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1294.isEnabled()) {
                    PortraitSettingActivity.this.f1265.f13776.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0608() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (PortraitSettingActivity.this.f1271 == 5) {
                    return false;
                }
                PortraitSettingActivity.this.f1265.f13776.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0609(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$֏, reason: contains not printable characters */
    public class C0610 implements SettingCodeDialog.InterfaceC1025 {
        public C0610() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingCodeDialog.InterfaceC1025
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1723() {
            PortraitSettingActivity.this.m1697();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ׯ, reason: contains not printable characters */
    public class C0611 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ׯ$Ϳ, reason: contains not printable characters */
        public class C0612 extends AbstractC4012 {
            public C0612() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13752.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ׯ$Ԩ, reason: contains not printable characters */
        public class C0613 extends AbstractC4012 {
            public C0613() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13752.setVisibility(8);
            }
        }

        public C0611() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (i == 28) {
                PortraitSettingActivity.this.m1716(false);
            }
            C4008.m12876(PortraitSettingActivity.this.f1265.f13752, 0.0f, 100, new C0613());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            if (i == 29) {
                PortraitSettingActivity.this.m1703();
                return;
            }
            C4008.m12876(PortraitSettingActivity.this.f1265.f13752, 0.0f, 100, new C0612());
            if (i == 1) {
                PortraitSettingActivity.this.f1265.f13746.m3963();
                return;
            }
            if (i == 2) {
                if (c3891 != null) {
                    C4535.m13880().m13887(c3891);
                    PortraitSettingActivity.this.f1265.f13765.m3984(2);
                    j.m7063();
                    return;
                }
                return;
            }
            if (i == 3) {
                if (c3891 != null) {
                    C4535.m13880().m13886(c3891, C4535.m13880().m13890(), false);
                    c3891.m12345(System.currentTimeMillis());
                    StringBuilder sb = new StringBuilder();
                    sb.append(C5049.m14852().m14857(Math.min(c3891.m12463(), c3891.m12462())));
                    sb.append(" / ");
                    sb.append(c3891.m12456());
                    sb.append("FPS / ");
                    sb.append(PortraitSettingActivity.this.m1694(c3891));
                    sb.append(" / ");
                    sb.append(PortraitSettingActivity.this.m1695(c3891));
                    int iM12442 = c3891.m12442();
                    if (iM12442 != 0) {
                        sb.append(" / ");
                        sb.append(C2462.m9035().m9060(iM12442));
                    }
                    c3891.m12516(sb.toString());
                    C4535.m13880().m13913(c3891);
                    PortraitSettingActivity.this.f1265.f13765.m3984(3);
                    j.m7065();
                    return;
                }
                return;
            }
            if (i == 4) {
                if (c3891 != null) {
                    if (c3891.m12411() == 0.0f && c3891.m12484() != 0) {
                        c3891.m12527((c3891.m12416() * 1.0f) / (c3891.m12484() * 360));
                    }
                    float fM12407 = c3891.m12407();
                    C3410.C3411 c3411 = C3410.InterfaceC3412.f11765;
                    if (fM12407 < c3411.m11187()) {
                        C3410.C3411 c34112 = C3410.InterfaceC3412.f11764;
                        if (!c34112.m11188()) {
                            fM12407 = c3411.m11187();
                        } else if (fM12407 < c34112.m11187()) {
                            fM12407 = c34112.m11187();
                        }
                    } else if (fM12407 > c3411.m11187() * 2.0f) {
                        C3410.C3411 c34113 = C3410.InterfaceC3412.f11766;
                        if (!c34113.m11188()) {
                            fM12407 = c3411.m11187();
                        } else if (fM12407 > c34113.m11187() * 2.0f) {
                            C3410.C3411 c34114 = C3410.InterfaceC3412.f11767;
                            if (!c34114.m11188() || fM12407 > c34114.m11187() * 2.0f) {
                                fM12407 = c3411.m11187();
                            }
                        }
                    }
                    c3891.m12523(fM12407);
                    C4535.m13880().m13886(C4535.m13880().m13890(), c3891, false);
                    C4535.m13880().m13915();
                    PortraitSettingActivity.this.f1266 = true;
                    j.m7064();
                    PortraitSettingActivity.this.m1692();
                    return;
                }
                return;
            }
            if (i == 11) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", PortraitSettingActivity.this.getPackageName(), null));
                intent.addFlags(65536);
                PortraitSettingActivity.this.startActivity(intent);
                return;
            }
            if (i == 12) {
                if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(PortraitSettingActivity.this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.ACCESS_FINE_LOCATION"}, 102);
                    return;
                } else {
                    ActivityCompat.requestPermissions(PortraitSettingActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
                    return;
                }
            }
            if (i == 31) {
                if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(PortraitSettingActivity.this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.ACCESS_FINE_LOCATION"}, 103);
                    return;
                } else {
                    ActivityCompat.requestPermissions(PortraitSettingActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 103);
                    return;
                }
            }
            if (i == 18) {
                PortraitSettingActivity.this.m1702(false);
                return;
            }
            if (i != 28) {
                if (i == 30) {
                    PortraitSettingActivity.this.f1265.f13741.m3931();
                    return;
                } else {
                    if (i == 37) {
                        ActivityCompat.requestPermissions(PortraitSettingActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 101);
                        return;
                    }
                    return;
                }
            }
            PortraitSettingActivity.this.m1716(true);
            if (c3891.m12493()) {
                PortraitSettingActivity.this.f1270 = 2;
                PortraitSettingActivity.this.f1274.m11880(true);
            } else {
                PortraitSettingActivity.this.f1270 = 1;
                PortraitSettingActivity.this.f1274.m11880(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ؠ, reason: contains not printable characters */
    public class C0614 implements SettingGimbalDialog.InterfaceC1036 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ؠ$Ϳ, reason: contains not printable characters */
        public class C0615 extends AbstractC4012 {
            public C0615() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13751.m2888();
                PortraitSettingActivity.this.f1265.f13751.setVisibility(8);
                PortraitSettingActivity.this.f1265.f13741.m3943();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ؠ$Ԩ, reason: contains not printable characters */
        public class C0616 extends AbstractC4012 {
            public C0616() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13751.m2888();
                PortraitSettingActivity.this.f1265.f13751.setVisibility(8);
                PortraitSettingActivity.this.f1265.f13741.m3943();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ؠ$Ԫ, reason: contains not printable characters */
        public class RunnableC0617 implements Runnable {
            public RunnableC0617() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3941();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ؠ$Ԭ, reason: contains not printable characters */
        public class RunnableC0618 implements Runnable {
            public RunnableC0618() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3939();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ؠ$Ԯ, reason: contains not printable characters */
        public class RunnableC0619 implements Runnable {
            public RunnableC0619() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3937();
            }
        }

        public C0614() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1724() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0619());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1725() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0617());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1726() {
            C4008.m12876(PortraitSettingActivity.this.f1265.f13751, 0.0f, 100, new C0615());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1727() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0618());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1728() {
            C4008.m12876(PortraitSettingActivity.this.f1265.f13751, 0.0f, 100, new C0616());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ހ, reason: contains not printable characters */
    public class C0620 implements SettingProtakeFocusDialog.InterfaceC1059 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ހ$Ϳ, reason: contains not printable characters */
        public class C0621 extends AbstractC4012 {
            public C0621() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13768.m2914();
                PortraitSettingActivity.this.f1265.f13768.setVisibility(8);
                PortraitSettingActivity.this.f1265.f13741.m3943();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ހ$Ԩ, reason: contains not printable characters */
        public class C0622 extends AbstractC4012 {
            public C0622() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13768.m2914();
                PortraitSettingActivity.this.f1265.f13768.setVisibility(8);
                PortraitSettingActivity.this.f1265.f13741.m3943();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ހ$Ԫ, reason: contains not printable characters */
        public class RunnableC0623 implements Runnable {
            public RunnableC0623() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3942();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ހ$Ԭ, reason: contains not printable characters */
        public class RunnableC0624 implements Runnable {
            public RunnableC0624() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3940();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ހ$Ԯ, reason: contains not printable characters */
        public class RunnableC0625 implements Runnable {
            public RunnableC0625() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3938();
            }
        }

        public C0620() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1729() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0625());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1730() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0623());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1731() {
            C4008.m12876(PortraitSettingActivity.this.f1265.f13768, 0.0f, 100, new C0621());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1732() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0624());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1733() {
            C4008.m12876(PortraitSettingActivity.this.f1265.f13768, 0.0f, 100, new C0622());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ށ, reason: contains not printable characters */
    public class C0626 implements c9.InterfaceC0058 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC0627 implements Runnable {
            public RunnableC0627() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13743.performClick();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ށ$Ԩ, reason: contains not printable characters */
        public class RunnableC0628 implements Runnable {

            /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ށ$Ԩ$Ϳ, reason: contains not printable characters */
            public class C0629 extends AbstractC4012 {
                public C0629() {
                }

                @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    super.onAnimationEnd(view);
                    PortraitSettingActivity.this.f1265.f13751.m2888();
                    PortraitSettingActivity.this.f1265.f13751.setVisibility(8);
                    PortraitSettingActivity.this.f1265.f13741.m3943();
                }
            }

            public RunnableC0628() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4008.m12876(PortraitSettingActivity.this.f1265.f13751, 0.0f, 100, new C0629());
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ށ$Ԫ, reason: contains not printable characters */
        public class RunnableC0630 implements Runnable {
            public RunnableC0630() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3941();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ށ$Ԭ, reason: contains not printable characters */
        public class RunnableC0631 implements Runnable {
            public RunnableC0631() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13741.m3937();
            }
        }

        public C0626() {
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: Ϳ */
        public void mo270() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0627());
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: Ԩ */
        public void mo271() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0630());
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: ԩ */
        public void mo272() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0631());
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: Ԫ */
        public void mo273() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0628());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ނ, reason: contains not printable characters */
    public class C0632 implements PortraitRecordSettingView.InterfaceC1425 {
        public C0632() {
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitRecordSettingView.InterfaceC1425
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1734(int i, C3891 c3891) {
            PortraitSettingActivity.this.m1709(i, c3891);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ރ, reason: contains not printable characters */
    public class C0633 implements RecordSettingView.InterfaceC1508 {
        public C0633() {
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1508
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1735() {
            PortraitSettingActivity.this.m1709(1, null);
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1508
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1736() {
            PortraitSettingActivity.this.m1709(37, null);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ބ, reason: contains not printable characters */
    public class C0634 implements PortraitAccessoriesSettingView.InterfaceC1398 {
        public C0634() {
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView.InterfaceC1398
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1737() {
            if (PortraitSettingActivity.this.f1265.f13768.getVisibility() != 0) {
                PortraitSettingActivity.this.m1712();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView.InterfaceC1398
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1738() {
            if (PortraitSettingActivity.this.f1265.f13751.getVisibility() != 0) {
                PortraitSettingActivity.this.m1708();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView.InterfaceC1398
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1739() {
            if (PortraitSettingActivity.this.f1265.f13751.getVisibility() != 0) {
                PortraitSettingActivity.this.m1708();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView.InterfaceC1398
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1740() {
            if (PortraitSettingActivity.this.f1265.f13768.getVisibility() != 0) {
                PortraitSettingActivity.this.m1712();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitAccessoriesSettingView.InterfaceC1398
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1741() throws Resources.NotFoundException {
            C3891 c3891 = new C3891();
            String string = PortraitSettingActivity.this.getResources().getString(R.string.SETTINGS_ACCESORRIES_HDMI_POP_TITLE);
            String string2 = PortraitSettingActivity.this.getResources().getString(R.string.SETTINGS_ACCESORRIES_HDMI_POP_CONTENT);
            String string3 = PortraitSettingActivity.this.getResources().getString(R.string.BUTTON_OK);
            c3891.m12515(string);
            c3891.m12553(string2);
            c3891.m12516("");
            c3891.m12503(string3);
            PortraitSettingActivity.this.m1709(30, c3891);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޅ, reason: contains not printable characters */
    public class ViewOnClickListenerC0635 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޅ$Ϳ, reason: contains not printable characters */
        public class RunnableC0636 implements Runnable {
            public RunnableC0636() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13765.m3979();
            }
        }

        public ViewOnClickListenerC0635() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980()) {
                return;
            }
            C3891 c3891M13890 = C4535.m13880().m13890();
            StringBuilder sb = new StringBuilder();
            sb.append(C5049.m14852().m14857(Math.min(c3891M13890.m12463(), c3891M13890.m12462())));
            sb.append(" / ");
            sb.append(c3891M13890.m12456());
            sb.append("FPS / ");
            sb.append(PortraitSettingActivity.this.m1694(c3891M13890));
            sb.append(" / ");
            sb.append(PortraitSettingActivity.this.m1695(c3891M13890));
            int iM12442 = c3891M13890.m12442();
            if (iM12442 != 0) {
                sb.append(" / ");
                sb.append(C2462.m9035().m9060(iM12442));
            }
            C4535.m13880().m13882(sb.toString());
            PortraitSettingActivity.this.f1265.f13765.m3984(1);
            PortraitSettingActivity.this.f1265.f13765.postDelayed(new RunnableC0636(), 100L);
            j.m7062();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ކ, reason: contains not printable characters */
    public class ViewOnClickListenerC0637 implements View.OnClickListener {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ކ$Ϳ, reason: contains not printable characters */
        public class C0638 extends AbstractC4012 {
            public C0638() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                Intent intent = new Intent(PortraitSettingActivity.this, (Class<?>) CaptureActivity.class);
                intent.addFlags(65536);
                intent.putExtra("isPortrait", true);
                PortraitSettingActivity.this.startActivityForResult(intent, 101);
                PortraitSettingActivity.this.overridePendingTransition(0, 0);
            }
        }

        public ViewOnClickListenerC0637() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980() || PortraitSettingActivity.this.f1267) {
                return;
            }
            j.m7066();
            PortraitSettingActivity.this.f1267 = true;
            C4008.m12876(PortraitSettingActivity.this.f1265.f13779, 0.0f, 100, new C0638());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$އ, reason: contains not printable characters */
    public class C0639 implements PortraitPresetSettingView.InterfaceC1411 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1325;

        public C0639(int i) {
            this.f1325 = i;
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitPresetSettingView.InterfaceC1411
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1742(C3891 c3891, String str) {
            c3891.m12345(System.currentTimeMillis());
            C4535.m13880().m13914(c3891);
            PortraitSettingActivity.this.f1265.f13765.m3984(3);
            PortraitSettingActivity.this.m1693();
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitPresetSettingView.InterfaceC1411
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1743(C3891 c3891) {
            PortraitSettingActivity.this.m1709(2, c3891);
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitPresetSettingView.InterfaceC1411
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1744(C3891 c3891) {
            PortraitSettingActivity.this.m1709(4, c3891);
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitPresetSettingView.InterfaceC1411
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1745(C3891 c3891) {
            try {
                Bitmap bitmapM10699 = new C3108(PortraitSettingActivity.this, this.f1325).m10699(C4929.m14660(C4535.m13880().m13904(c3891)));
                if (bitmapM10699 != null) {
                    PortraitSettingActivity.this.f1265.f13745.setVisibility(0);
                    PortraitSettingActivity.this.f1265.f13745.setBitmap(bitmapM10699);
                    PortraitSettingActivity.this.f1265.f13745.setAlpha(0.0f);
                    C4008.m12876(PortraitSettingActivity.this.f1265.f13745, 1.0f, 100, null);
                    j.m7067();
                } else {
                    C4638.m14101("onShowQR", "onShowQR: encodeAsBitmap error");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.PortraitPresetSettingView.InterfaceC1411
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1746(C3891 c3891) {
            PortraitSettingActivity.this.m1709(3, c3891);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ވ, reason: contains not printable characters */
    public class C0640 implements SubscribeDialog.InterfaceC0965 {
        public C0640() {
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ϳ */
        public boolean mo1341() {
            return false;
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԩ */
        public void mo1342() throws Resources.NotFoundException {
            C4320.m13462(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԩ */
        public void mo1343() {
            PortraitSettingActivity.this.m1699(true);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԫ */
        public void mo1344() {
            if (r1.m8142(e5.m5988().m5990())) {
                PortraitSettingActivity.this.m1715();
            } else {
                if (FilmApp.m405().m430()) {
                    PortraitSettingActivity.this.m1714(false);
                    return;
                }
                PortraitSettingActivity.this.m1716(true);
                PortraitSettingActivity.this.f1270 = 1;
                PortraitSettingActivity.this.f1274.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԫ */
        public void mo1345() {
            PortraitSettingActivity.this.m1717();
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԭ */
        public void mo1346() {
            C4320.m13460(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԭ */
        public void mo1347() {
            C4320.m13461(PortraitSettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$މ, reason: contains not printable characters */
    public class C0641 implements ProtakeProPortraitSettingView.InterfaceC1533 {
        public C0641() {
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1747() {
            PortraitSettingActivity.this.m1719();
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1748() {
            if (PortraitSettingActivity.this.f1274 != null) {
                if (FilmApp.m405().m430()) {
                    PortraitSettingActivity.this.m1714(false);
                    return;
                }
                PortraitSettingActivity.this.m1716(true);
                PortraitSettingActivity.this.f1270 = 1;
                PortraitSettingActivity.this.f1274.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1749() throws Resources.NotFoundException {
            if (r1.m8142(e5.m5988().m5990())) {
                PortraitSettingActivity.this.m1688();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1750() {
            C4320.m13461(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1751() {
            C4320.m13460(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1752() throws Resources.NotFoundException {
            C4320.m13462(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeProPortraitSettingView.InterfaceC1533
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1753() {
            if (r1.m8142(e5.m5988().m5990())) {
                PortraitSettingActivity.this.m1715();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ފ, reason: contains not printable characters */
    public class C0642 implements ProtakeSignInPortraitSettingView.InterfaceC1547 {
        public C0642() {
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1754() {
            PortraitSettingActivity.this.m1719();
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1755() throws Resources.NotFoundException {
            C4320.m13462(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1756() {
            PortraitSettingActivity.this.m1699(false);
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1757() {
            if (r1.m8142(e5.m5988().m5990())) {
                PortraitSettingActivity.this.m1715();
            } else {
                if (FilmApp.m405().m430()) {
                    PortraitSettingActivity.this.m1714(false);
                    return;
                }
                PortraitSettingActivity.this.m1716(true);
                PortraitSettingActivity.this.f1270 = 1;
                PortraitSettingActivity.this.f1274.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1758() {
            PortraitSettingActivity.this.m1717();
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1759() {
            C4320.m13460(PortraitSettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.portrait.ProtakeSignInPortraitSettingView.InterfaceC1547
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1760() {
            C4320.m13461(PortraitSettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ދ, reason: contains not printable characters */
    public class ViewOnClickListenerC0643 implements View.OnClickListener {
        public ViewOnClickListenerC0643() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ތ, reason: contains not printable characters */
    public class C0644 implements InterfaceC4875 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SubscribeInfoCallback f1331;

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ތ$Ϳ, reason: contains not printable characters */
        public class RunnableC0645 implements Runnable {
            public RunnableC0645() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13770.m4140(false);
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ތ$Ԩ, reason: contains not printable characters */
        public class RunnableC0646 implements Runnable {
            public RunnableC0646() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13780.m2594(false);
                PortraitSettingActivity.this.f1265.f13770.m4140(false);
            }
        }

        public C0644(SubscribeInfoCallback subscribeInfoCallback) {
            this.f1331 = subscribeInfoCallback;
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ϳ */
        public void mo1309(int i) {
            FilmApp.m405().m427(new RunnableC0646());
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ԩ */
        public void mo1310(Purchase purchase) {
            C2618.m9573("local_sub_pus_sp", new Gson().toJson(purchase));
            C2618.m9573("local_sub_id_sp", this.f1331.getSub_gplay_id());
            C3659.m11744().m11751(0);
            PortraitSettingActivity.this.m1700(true);
            FilmApp.m405().m427(new RunnableC0645());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ލ, reason: contains not printable characters */
    public class C0647 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1335;

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ލ$Ϳ, reason: contains not printable characters */
        public class RunnableC0648 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f1337;

            public RunnableC0648(ApiException apiException) {
                this.f1337 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0647 c0647 = C0647.this;
                if (c0647.f1335) {
                    PortraitSettingActivity.this.f1265.f13780.m2594(false);
                } else {
                    PortraitSettingActivity.this.f1265.f13770.m4140(false);
                }
                if (C3703.m11871(this.f1337.getCode())) {
                    C3659.m11744().m11745(0);
                }
                PortraitSettingActivity.this.m1705();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ލ$Ԩ, reason: contains not printable characters */
        public class RunnableC0649 implements Runnable {
            public RunnableC0649() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0647 c0647 = C0647.this;
                if (c0647.f1335) {
                    PortraitSettingActivity.this.f1265.f13780.m2594(false);
                } else {
                    PortraitSettingActivity.this.f1265.f13770.m4140(false);
                }
                C3659.m11744().m11745(0);
                PortraitSettingActivity.this.m1705();
            }
        }

        public C0647(boolean z) {
            this.f1335 = z;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            FilmApp.m405().m427(new RunnableC0648(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            FilmApp.m405().m427(new RunnableC0649());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ގ, reason: contains not printable characters */
    public class C0650 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1340;

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ގ$Ϳ, reason: contains not printable characters */
        public class RunnableC0651 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f1342;

            public RunnableC0651(ApiException apiException) {
                this.f1342 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0650 c0650 = C0650.this;
                if (c0650.f1340) {
                    PortraitSettingActivity.this.f1265.f13780.m2594(false);
                } else {
                    PortraitSettingActivity.this.f1265.f13770.m4140(false);
                }
                if (C3703.m11871(this.f1342.getCode())) {
                    C3659.m11744().m11745(0);
                }
                PortraitSettingActivity.this.m1705();
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ގ$Ԩ, reason: contains not printable characters */
        public class RunnableC0652 implements Runnable {
            public RunnableC0652() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0650 c0650 = C0650.this;
                if (c0650.f1340) {
                    PortraitSettingActivity.this.f1265.f13780.m2594(false);
                } else {
                    PortraitSettingActivity.this.f1265.f13770.m4140(false);
                }
                C3659.m11744().m11745(0);
                PortraitSettingActivity.this.m1705();
            }
        }

        public C0650(boolean z) {
            this.f1340 = z;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            FilmApp.m405().m427(new RunnableC0651(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            FilmApp.m405().m427(new RunnableC0652());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޏ, reason: contains not printable characters */
    public class RunnableC0653 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1345;

        public RunnableC0653(boolean z) {
            this.f1345 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1345) {
                PortraitSettingActivity.this.f1265.f13780.m2594(false);
            } else {
                PortraitSettingActivity.this.f1265.f13770.m4140(false);
            }
            PortraitSettingActivity.this.m1705();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ސ, reason: contains not printable characters */
    public class C0654 implements PrivacyWebView.InterfaceC1095 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1347;

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ސ$Ϳ, reason: contains not printable characters */
        public class C0655 extends AbstractC4012 {
            public C0655() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13766.setAlpha(0.0f);
                PortraitSettingActivity.this.f1265.f13766.setVisibility(8);
                C0654 c0654 = C0654.this;
                if (c0654.f1347) {
                    PortraitSettingActivity.this.f1270 = 2;
                    PortraitSettingActivity.this.f1274.m11880(true);
                } else {
                    PortraitSettingActivity.this.f1270 = 1;
                    PortraitSettingActivity.this.f1274.m11880(false);
                }
            }
        }

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ސ$Ԩ, reason: contains not printable characters */
        public class C0656 extends AbstractC4012 {
            public C0656() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13766.setVisibility(8);
            }
        }

        public C0654(boolean z) {
            this.f1347 = z;
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        public void onDisagree() {
            PortraitSettingActivity.this.f1265.f13742.setVisibility(8);
            PortraitSettingActivity.this.m1716(false);
            C4008.m12876(PortraitSettingActivity.this.f1265.f13766, 0.0f, 100, new C0656());
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        /* renamed from: Ϳ */
        public void mo1314(boolean z) {
            PortraitSettingActivity.this.f1265.f13742.setVisibility(8);
            PortraitSettingActivity.this.m1716(true);
            if (z) {
                C2618.m9571("privacy_alert_v_sp2", C2618.m9566("privacy_remote_v_sp", 1));
            } else {
                C2618.m9571("terms_alert_v_sp2", C2618.m9566("terms_remote_v_sp", 1));
            }
            C4008.m12876(PortraitSettingActivity.this.f1265.f13766, 0.0f, 100, new C0655());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޑ, reason: contains not printable characters */
    public class C0657 implements C4689.InterfaceC4697 {
        public C0657() {
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            PortraitSettingActivity.this.m1691(i);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޒ, reason: contains not printable characters */
    public class C0658 implements C4689.InterfaceC4697 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1352;

        public C0658(boolean z) {
            this.f1352 = z;
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            if (this.f1352) {
                C4689.m14213(PortraitSettingActivity.this).m14222();
                PortraitSettingActivity.this.m1701(i == 2 ? 1 : 2);
            } else if (i == 2) {
                PortraitSettingActivity.this.m1691(2);
            } else if (i == 4) {
                PortraitSettingActivity.this.m1691(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޓ, reason: contains not printable characters */
    public class C0659 implements C4689.InterfaceC4696 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1354;

        public C0659(boolean z) {
            this.f1354 = z;
        }

        @Override // defpackage.C4689.InterfaceC4696
        /* renamed from: Ϳ */
        public void mo1332() {
            if (this.f1354) {
                PortraitSettingActivity.this.f1265.f13780.m2594(false);
            } else {
                PortraitSettingActivity.this.f1265.f13770.m4140(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޔ, reason: contains not printable characters */
    public class C0660 implements C4757.InterfaceC4768 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1356;

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޔ$Ϳ, reason: contains not printable characters */
        public class RunnableC0661 implements Runnable {
            public RunnableC0661() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.m7057(C0660.this.f1356);
            }
        }

        public C0660(int i) {
            this.f1356 = i;
        }

        @Override // defpackage.C4757.InterfaceC4768
        public void onFail() {
            C3617.m11671(PortraitSettingActivity.this).m11673();
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ϳ */
        public void mo437() {
            C3617.m11671(PortraitSettingActivity.this).m11673();
            PortraitSettingActivity.this.m1702(false);
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ԩ */
        public void mo438() {
            FilmApp.m405().m427(new RunnableC0661());
            C3617.m11671(PortraitSettingActivity.this).m11673();
            C4689.m14213(PortraitSettingActivity.this).m14222();
            PortraitSettingActivity.this.m1705();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޕ, reason: contains not printable characters */
    public class ViewOnClickListenerC0662 implements View.OnClickListener {
        public ViewOnClickListenerC0662() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980()) {
                return;
            }
            if (PortraitSettingActivity.this.f1271 != 0) {
                PortraitSettingActivity.this.f1271 = 0;
                C2618.m9571("setting_tab_state_sp", PortraitSettingActivity.this.f1271);
                PortraitSettingActivity.this.m1718();
                PortraitSettingActivity.this.changeContent();
                return;
            }
            long[] jArr = PortraitSettingActivity.this.f1272;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = PortraitSettingActivity.this.f1272;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (PortraitSettingActivity.this.f1272[0] >= SystemClock.uptimeMillis() - 500) {
                PortraitSettingActivity portraitSettingActivity = PortraitSettingActivity.this;
                portraitSettingActivity.f1272 = null;
                portraitSettingActivity.f1272 = new long[3];
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޖ, reason: contains not printable characters */
    public class C0663 implements C3608.InterfaceC3610 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޖ$Ϳ, reason: contains not printable characters */
        public class RunnableC0664 implements Runnable {
            public RunnableC0664() {
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.m1718();
                PortraitSettingActivity.this.changeContent();
                PortraitSettingActivity.this.m1706();
            }
        }

        public C0663() {
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ϳ */
        public void mo1336() {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0664());
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ԩ */
        public void mo1337() {
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: ԩ */
        public void mo1338(int i) {
            C3659.m11744().m11745(0);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޗ, reason: contains not printable characters */
    public class C0665 implements C3703.InterfaceC3720 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޗ$Ϳ, reason: contains not printable characters */
        public class C0666 extends AbstractC4012 {
            public C0666() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                PortraitSettingActivity.this.f1265.f13752.setVisibility(8);
                PortraitSettingActivity.this.m1702(true);
            }
        }

        public C0665() {
        }

        @Override // defpackage.C3703.InterfaceC3720
        public void onFail() {
        }

        @Override // defpackage.C3703.InterfaceC3720
        public void onSuc() {
            C4008.m12876(PortraitSettingActivity.this.f1265.f13752, 0.0f, 100, new C0666());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޘ, reason: contains not printable characters */
    public class C0667 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1364;

        public C0667(boolean z) {
            this.f1364 = z;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            if (this.f1364) {
                C3617.m11671(PortraitSettingActivity.this).m11673();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            if (this.f1364) {
                C3617.m11671(PortraitSettingActivity.this).m11673();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޙ, reason: contains not printable characters */
    public class C0668 extends AbstractC4012 {
        public C0668() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            PortraitSettingActivity.this.f1265.f13745.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޚ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC0669 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0669() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޛ, reason: contains not printable characters */
    public class C0670 extends CallBack<UserBean> {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޛ$Ϳ, reason: contains not printable characters */
        public class RunnableC0671 implements Runnable {
            public RunnableC0671() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zM5993 = e5.m5988().m5993();
                if (zM5993 && PortraitSettingActivity.this.f1274 != null) {
                    PortraitSettingActivity.this.f1274.m11877();
                }
                if (PortraitSettingActivity.this.f1270 == 2 && !zM5993) {
                    PortraitSettingActivity.this.m1710();
                }
                PortraitSettingActivity.this.m1718();
                PortraitSettingActivity.this.changeContent();
                PortraitSettingActivity.this.m1706();
            }
        }

        public C0670() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onSuccess(UserBean userBean) {
            PortraitSettingActivity.this.runOnUiThread(new RunnableC0671());
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޜ, reason: contains not printable characters */
    public class C0672 implements C3703.InterfaceC3719 {
        public C0672() {
        }

        @Override // defpackage.C3703.InterfaceC3719
        /* renamed from: Ϳ */
        public void mo1355() {
            if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
                PortraitSettingActivity.this.m1711(false, false);
            } else if (C4843.m14569().m14570() == 1) {
                PortraitSettingActivity.this.m1691(2);
            } else if (C4843.m14569().m14570() == 2) {
                PortraitSettingActivity.this.m1691(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޝ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC0673 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0673() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޞ, reason: contains not printable characters */
    public class C0674 implements C2772.InterfaceC2787 {

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޞ$Ϳ, reason: contains not printable characters */
        public class RunnableC0675 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ UserBean f1373;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ String f1374;

            public RunnableC0675(UserBean userBean, String str) {
                this.f1373 = userBean;
                this.f1374 = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                PortraitSettingActivity.this.f1265.f13769.m4126(this.f1373.getUser_phone_zone(), this.f1374, this.f1373.getSubscription_expire_time());
            }
        }

        public C0674() {
        }

        @Override // defpackage.C2772.InterfaceC2787
        public void onChange() {
            if (PortraitSettingActivity.this.f1265.f13769 != null) {
                UserBean userBeanM5990 = e5.m5988().m5990();
                String strM9569 = C2618.m9569("user_login_phone_sp", "");
                if (r1.m8142(userBeanM5990)) {
                    PortraitSettingActivity.this.runOnUiThread(new RunnableC0675(userBeanM5990, strM9569));
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޟ, reason: contains not printable characters */
    public class RunnableC0676 implements Runnable {
        public RunnableC0676() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4008.m12876(PortraitSettingActivity.this.f1265.f13779, 1.0f, 200, null);
            z0.m8635(PortraitSettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0677 implements View.OnClickListener {
        public ViewOnClickListenerC0677() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980() || PortraitSettingActivity.this.f1271 == 1) {
                return;
            }
            PortraitSettingActivity.this.f1271 = 1;
            C2618.m9571("setting_tab_state_sp", PortraitSettingActivity.this.f1271);
            PortraitSettingActivity.this.m1718();
            PortraitSettingActivity.this.changeContent();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޡ, reason: contains not printable characters */
    public class C0678 extends AbstractC4012 {
        public C0678() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            PortraitSettingActivity.this.finish();
            PortraitSettingActivity.this.overridePendingTransition(0, 0);
            if (HomeActivity.m700() != null) {
                HomeActivity.m700().m1021(PortraitSettingActivity.this.f1266);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޢ, reason: contains not printable characters */
    public class C0679 extends OperationCallback<Void> {
        public C0679() {
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }

        @Override // com.mob.OperationCallback
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onComplete(Void r1) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޣ, reason: contains not printable characters */
    public class ViewOnClickListenerC0680 implements View.OnClickListener {
        public ViewOnClickListenerC0680() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1271 != 2) {
                PortraitSettingActivity.this.f1271 = 2;
                C2618.m9571("setting_tab_state_sp", PortraitSettingActivity.this.f1271);
                PortraitSettingActivity.this.m1718();
                PortraitSettingActivity.this.changeContent();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޤ, reason: contains not printable characters */
    public class ViewOnClickListenerC0681 implements View.OnClickListener {
        public ViewOnClickListenerC0681() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980() || PortraitSettingActivity.this.f1271 == 3) {
                return;
            }
            PortraitSettingActivity.this.f1271 = 3;
            C2618.m9571("setting_tab_state_sp", PortraitSettingActivity.this.f1271);
            PortraitSettingActivity.this.m1718();
            PortraitSettingActivity.this.changeContent();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޥ, reason: contains not printable characters */
    public class ViewOnClickListenerC0682 implements View.OnClickListener {
        public ViewOnClickListenerC0682() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980() || PortraitSettingActivity.this.f1271 == 4) {
                return;
            }
            PortraitSettingActivity.this.f1271 = 4;
            C2618.m9571("setting_tab_state_sp", PortraitSettingActivity.this.f1271);
            PortraitSettingActivity.this.m1718();
            PortraitSettingActivity.this.changeContent();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$ޱ, reason: contains not printable characters */
    public class ViewOnClickListenerC0683 implements View.OnClickListener {
        public ViewOnClickListenerC0683() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1271 != 5) {
                PortraitSettingActivity.this.f1271 = 5;
                C2618.m9571("setting_tab_state_sp", PortraitSettingActivity.this.f1271);
                PortraitSettingActivity.this.m1718();
                PortraitSettingActivity.this.changeContent();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$߾, reason: contains not printable characters */
    public class ViewOnClickListenerC0684 implements View.OnClickListener {
        public ViewOnClickListenerC0684() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PortraitSettingActivity.this.f1265.f13765.m3980()) {
                return;
            }
            PortraitSettingActivity.this.m1692();
        }
    }

    /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$߿, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0685 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f1385;

        /* renamed from: com.blink.academy.film.setting.PortraitSettingActivity$߿$Ϳ, reason: contains not printable characters */
        public class RunnableC0686 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1386;

            public RunnableC0686(View view) {
                this.f1386 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1386.isEnabled()) {
                    ViewOnTouchListenerC0685.this.f1385.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0685(View view) {
            this.f1385 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f1385.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0686(view), 100L);
            return false;
        }
    }

    public final void changeContent() {
        int i = this.f1271;
        if (i == 0) {
            this.f1265.f13782.setText(R.string.SETTINGS_TAB_RECORD);
            this.f1265.f13771.m3993();
            this.f1265.f13771.setVisibility(0);
            this.f1265.f13765.setVisibility(8);
            this.f1265.f13746.setVisibility(8);
            this.f1265.f13741.setVisibility(8);
            this.f1265.f13770.setVisibility(8);
            this.f1265.f13769.setVisibility(8);
            this.f1265.f13755.setVisibility(8);
            this.f1265.f13762.setVisibility(8);
            this.f1265.f13775.setVisibility(8);
            this.f1265.f13772.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.f1265.f13782.setText(R.string.SETTINGS_TAB_DATA);
            this.f1265.f13746.m3971();
            this.f1265.f13746.setVisibility(0);
            this.f1265.f13765.setVisibility(8);
            this.f1265.f13771.setVisibility(8);
            this.f1265.f13741.setVisibility(8);
            this.f1265.f13770.setVisibility(8);
            this.f1265.f13769.setVisibility(8);
            this.f1265.f13755.setVisibility(8);
            this.f1265.f13762.setVisibility(8);
            this.f1265.f13775.setVisibility(8);
            this.f1265.f13772.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.f1265.f13782.setText(R.string.SETTINGS_TAB_PRESETS);
            this.f1265.f13765.setVisibility(0);
            this.f1265.f13771.setVisibility(8);
            this.f1265.f13746.setVisibility(8);
            this.f1265.f13741.setVisibility(8);
            this.f1265.f13770.setVisibility(8);
            this.f1265.f13769.setVisibility(8);
            this.f1265.f13755.setVisibility(0);
            this.f1265.f13762.setVisibility(0);
            this.f1265.f13775.setVisibility(0);
            this.f1265.f13772.setVisibility(0);
            return;
        }
        if (i == 3) {
            this.f1265.f13782.setText(R.string.SETTINGS_TAB_ACCESSORIES);
            this.f1265.f13741.m3943();
            this.f1265.f13741.setVisibility(0);
            this.f1265.f13765.setVisibility(8);
            this.f1265.f13771.setVisibility(8);
            this.f1265.f13746.setVisibility(8);
            this.f1265.f13770.setVisibility(8);
            this.f1265.f13769.setVisibility(8);
            this.f1265.f13755.setVisibility(8);
            this.f1265.f13762.setVisibility(8);
            this.f1265.f13775.setVisibility(8);
            this.f1265.f13772.setVisibility(8);
            return;
        }
        if (i == 4) {
            this.f1265.f13782.setText(R.string.SETTINGS_TAB_PRO);
            this.f1265.f13765.setVisibility(8);
            this.f1265.f13771.setVisibility(8);
            this.f1265.f13746.setVisibility(8);
            this.f1265.f13741.setVisibility(8);
            this.f1265.f13770.setVisibility(8);
            this.f1265.f13769.setVisibility(0);
            this.f1265.f13755.setVisibility(8);
            this.f1265.f13762.setVisibility(8);
            this.f1265.f13775.setVisibility(8);
            this.f1265.f13772.setVisibility(8);
            return;
        }
        if (i != 5) {
            return;
        }
        this.f1265.f13782.setText(R.string.SETTINGS_TAB_PRO);
        this.f1265.f13765.setVisibility(8);
        this.f1265.f13771.setVisibility(8);
        this.f1265.f13746.setVisibility(8);
        this.f1265.f13741.setVisibility(8);
        this.f1265.f13770.setVisibility(0);
        this.f1265.f13769.setVisibility(8);
        this.f1265.f13755.setVisibility(8);
        this.f1265.f13762.setVisibility(8);
        this.f1265.f13775.setVisibility(8);
        this.f1265.f13772.setVisibility(8);
        m1706();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public final void initListener() {
        this.f1265.f13774.setOnClickListener(new ViewOnClickListenerC0662());
        this.f1265.f13749.setOnClickListener(new ViewOnClickListenerC0677());
        this.f1265.f13750.setOnClickListener(new ViewOnClickListenerC0680());
        this.f1265.f13747.setOnClickListener(new ViewOnClickListenerC0681());
        this.f1265.f13773.setOnClickListener(new ViewOnClickListenerC0682());
        this.f1265.f13776.setOnClickListener(new ViewOnClickListenerC0683());
        this.f1265.f13743.setOnClickListener(new ViewOnClickListenerC0684());
        AbstractC3960 abstractC3960 = this.f1265;
        abstractC3960.f13743.setOnTouchListener(new ViewOnTouchListenerC0685(abstractC3960.f13744));
        AbstractC3960 abstractC39602 = this.f1265;
        abstractC39602.f13772.setOnTouchListener(new ViewOnTouchListenerC0685(abstractC39602.f13755));
        AbstractC3960 abstractC39603 = this.f1265;
        abstractC39603.f13775.setOnTouchListener(new ViewOnTouchListenerC0685(abstractC39603.f13762));
        this.f1265.f13750.setOnTouchListener(new ViewOnTouchListenerC0598());
        this.f1265.f13749.setOnTouchListener(new ViewOnTouchListenerC0600());
        this.f1265.f13774.setOnTouchListener(new ViewOnTouchListenerC0602());
        this.f1265.f13747.setOnTouchListener(new ViewOnTouchListenerC0604());
        this.f1265.f13773.setOnTouchListener(new ViewOnTouchListenerC0606());
        this.f1265.f13776.setOnTouchListener(new ViewOnTouchListenerC0608());
        this.f1265.f13745.setOnButtonClick(new C0610());
        this.f1265.f13752.setOnButtonClick(new C0611());
        this.f1265.f13751.setOnClickEvent(new C0614());
        this.f1265.f13768.setOnCallback(new C0620());
        this.f1265.f13771.setOnCallback(new C0632());
        this.f1265.f13746.setOnButtonClick(new C0633());
        this.f1265.f13741.setOnButtonClick(new C0634());
        this.f1265.f13772.setOnClickListener(new ViewOnClickListenerC0635());
        this.f1265.f13775.setOnClickListener(new ViewOnClickListenerC0637());
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f1265.f13765.setOnButtonClick(new C0639(Math.min(point.x, point.y)));
        this.f1265.f13780.setPortrait(true);
        C4689.m14213(this).m14230(true);
        this.f1265.f13780.setOnSubscribeDialogListener(new C0640());
        this.f1265.f13769.setOnClickListener(new C0641());
        this.f1265.f13770.setOnClickListener(new C0642());
        this.f1265.f13742.setOnClickListener(new ViewOnClickListenerC0643());
        this.f1265.f13742.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f1267 = false;
        if (i2 == -1 && i == 101) {
            m1707(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1265.f13745.getAlpha() == 1.0f) {
            m1697();
        } else {
            m1692();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1266 = false;
        C3088.m10679().mo10680(this);
        C4567.m14006().m14021(new C0594());
        c9.m219().m235(new C0626());
        C4792.m14375().m14466(getWindow().getDecorView(), this);
        this.f1265 = (AbstractC3960) DataBindingUtil.setContentView(this, R.layout.activity_portrait_setting);
        this.f1271 = C2618.m9566("setting_tab_state_sp", 5);
        m1698();
        initListener();
        m1718();
        changeContent();
        this.f1265.f13751.m2894(true);
        this.f1265.f13768.m2920(true);
        C4628.m14086().m14088();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c9.m219().m235(null);
        C4567.m14006().m14021(null);
        C3703 c3703 = this.f1274;
        if (c3703 != null) {
            c3703.m11873();
        }
        C2772 c2772 = this.f1275;
        if (c2772 != null) {
            c2772.m10061();
        }
        C4757.m14304().m14309();
        C4689.m14213(this).m14221();
        C3617.m11671(this).m11672();
        C4628.m14086().m14090();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int i2 = 0;
        if (i == 101) {
            while (i2 < strArr.length) {
                if (iArr[i2] == -1) {
                    this.f1268++;
                    if (strArr[i2].equals("android.permission.ACCESS_FINE_LOCATION")) {
                        m1709(11, null);
                        return;
                    }
                    return;
                }
                i2++;
            }
            return;
        }
        if (i == 102 || i == 103) {
            while (i2 < strArr.length) {
                if (iArr[i2] == -1) {
                    this.f1268++;
                    return;
                }
                i2++;
            }
            if (this.f1268 == 0) {
                if (i == 102) {
                    m1708();
                    this.f1265.f13741.m3939();
                } else if (i == 103) {
                    m1712();
                    this.f1265.f13741.m3940();
                }
            }
        }
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m1704();
        m1706();
        C3617.m11670();
        SubscribeDialog subscribeDialog = this.f1265.f13780;
        if (subscribeDialog != null) {
            subscribeDialog.m2589();
        }
        ProtakeSignInPortraitSettingView protakeSignInPortraitSettingView = this.f1265.f13770;
        if (protakeSignInPortraitSettingView != null) {
            protakeSignInPortraitSettingView.m4135();
        }
        if (e5.m5988().m5993()) {
            return;
        }
        C4628.m14086().m14089(this);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m462();
            m1713();
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m1688() throws Resources.NotFoundException {
        this.f1275.m10064();
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m1689(boolean z, ImageView imageView) {
        if (z) {
            imageView.setAlpha(1.0f);
        } else {
            imageView.setAlpha(0.3f);
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final boolean m1690() {
        return e5.m5988().m5993() && C2618.m9565("location__bool_info_sp", false);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m1691(int i) {
        String str;
        String access_token;
        SubscribeInfoCallback subscribeInfoCallbackM7605 = n.m7588().m7605();
        if (r1.m8137(subscribeInfoCallbackM7605)) {
            return;
        }
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (r1.m8142(userBeanM5990)) {
            String str2 = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
            str = str2;
        } else {
            if (i != 2 && i != 4) {
                return;
            }
            str = "";
            access_token = str;
        }
        C3617.m11671(this).m11675();
        C4757.m14304().m14315(this, i, str, access_token, subscribeInfoCallbackM7605.getSubscription_product_id(), subscribeInfoCallbackM7605.getSub_gplay_id(), subscribeInfoCallbackM7605.getSub_hms_id(), new C0660(i));
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m1692() {
        if (this.f1276) {
            return;
        }
        this.f1276 = true;
        C4008.m12876(this.f1265.f13779, 0.0f, 200, new C0678());
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m1693() {
        m462();
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final String m1694(C3891 c3891) {
        return (!c3891.m12495() || c3891.m12381()) ? "AE" : "ME";
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final String m1695(C3891 c3891) {
        return (!c3891.m12495() || c3891.m12412() < 0.0f || c3891.m12412() > 1.0f) ? "AF" : "MF";
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public int m1696(int i) {
        return C4792.m14375().m14477(i, this.f1269);
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m1697() {
        C4008.m12876(this.f1265.f13745, 0.0f, 100, new C0668());
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m1698() {
        this.f1273 = C2579.m9444();
        int iM9445 = C2579.m9445();
        ViewGroup.LayoutParams layoutParams = this.f1265.f13778.getLayoutParams();
        layoutParams.width = iM9445;
        layoutParams.height = this.f1273;
        this.f1265.f13778.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1265.f13777.getLayoutParams();
        layoutParams2.height = C4792.m14375().m14451();
        layoutParams2.topMargin = (int) C4792.m14375().m14442();
        this.f1265.f13777.setLayoutParams(layoutParams2);
        int i = layoutParams2.height + layoutParams2.topMargin;
        ViewGroup.LayoutParams layoutParams3 = this.f1265.f13764.getLayoutParams();
        this.f1269 = C4792.m14375().m14471();
        layoutParams3.height = C2579.m9438(50.0f);
        this.f1265.f13764.setLayoutParams(layoutParams3);
        ViewGroup.LayoutParams layoutParams4 = this.f1265.f13748.getLayoutParams();
        layoutParams4.height = (this.f1273 - i) - layoutParams3.height;
        this.f1265.f13748.setLayoutParams(layoutParams4);
        int iM9438 = C2579.m9438(30.0f);
        ViewGroup.LayoutParams layoutParams5 = this.f1265.f13763.getLayoutParams();
        layoutParams5.width = iM9438;
        layoutParams5.height = iM9438;
        this.f1265.f13763.setLayoutParams(layoutParams5);
        ViewGroup.LayoutParams layoutParams6 = this.f1265.f13761.getLayoutParams();
        layoutParams6.width = iM9438;
        layoutParams6.height = iM9438;
        this.f1265.f13761.setLayoutParams(layoutParams6);
        ViewGroup.LayoutParams layoutParams7 = this.f1265.f13756.getLayoutParams();
        layoutParams7.width = iM9438;
        layoutParams7.height = iM9438;
        this.f1265.f13756.setLayoutParams(layoutParams7);
        ViewGroup.LayoutParams layoutParams8 = this.f1265.f13758.getLayoutParams();
        layoutParams8.width = iM9438;
        layoutParams8.height = iM9438;
        this.f1265.f13758.setLayoutParams(layoutParams8);
        ViewGroup.LayoutParams layoutParams9 = this.f1265.f13754.getLayoutParams();
        layoutParams9.width = iM9438;
        layoutParams9.height = iM9438;
        this.f1265.f13754.setLayoutParams(layoutParams9);
        ViewGroup.LayoutParams layoutParams10 = this.f1265.f13760.getLayoutParams();
        layoutParams10.width = iM9438;
        layoutParams10.height = iM9438;
        this.f1265.f13760.setLayoutParams(layoutParams10);
        this.f1265.f13782.setTypeface(FilmApp.m404());
        this.f1265.f13782.setTextSize(0, C4792.m14375().m14383());
        C4792.m14375().m14386();
        FrameLayout.LayoutParams layoutParams11 = (FrameLayout.LayoutParams) this.f1265.f13757.getLayoutParams();
        layoutParams11.width = (int) (m1696(60) * this.f1269);
        layoutParams11.height = (int) (m1696(60) * this.f1269);
        int i2 = layoutParams11.width;
        layoutParams11.rightMargin = ((int) ((C2579.m9445() * 1.0f) / 10.0f)) - i2;
        layoutParams11.topMargin = (int) (i2 / 3.0f);
        this.f1265.f13757.setLayoutParams(layoutParams11);
        this.f1265.f13759.setLayoutParams(layoutParams11);
        this.f1265.f13753.setLayoutParams(layoutParams11);
        int iM14476 = C4792.m14375().m14476(54);
        RelativeLayout.LayoutParams layoutParams12 = (RelativeLayout.LayoutParams) this.f1265.f13744.getLayoutParams();
        layoutParams12.width = iM14476;
        layoutParams12.height = iM14476;
        layoutParams12.rightMargin = C4792.m14375().m14449();
        this.f1265.f13744.setLayoutParams(layoutParams12);
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f1265.f13743.getLayoutParams();
        layoutParams13.width = i;
        layoutParams13.height = i;
        layoutParams13.rightMargin = layoutParams12.rightMargin - ((i - layoutParams12.width) / 2);
        this.f1265.f13743.setLayoutParams(layoutParams13);
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f1265.f13780.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).topMargin = i;
        ((ViewGroup.MarginLayoutParams) layoutParams14).bottomMargin = layoutParams3.height;
        this.f1265.f13780.setLayoutParams(layoutParams14);
        this.f1265.f13780.setVertical(0);
        RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.f1265.f13755.getLayoutParams();
        layoutParams15.width = iM14476;
        layoutParams15.height = iM14476;
        layoutParams15.leftMargin = C2579.m9438(30.0f) / 2;
        this.f1265.f13755.setLayoutParams(layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f1265.f13772.getLayoutParams();
        layoutParams16.width = C2579.m9438(44.0f);
        layoutParams16.height = C2579.m9438(44.0f);
        layoutParams16.rightMargin = layoutParams15.rightMargin - ((layoutParams16.width - layoutParams15.width) / 2);
        this.f1265.f13772.setLayoutParams(layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f1265.f13762.getLayoutParams();
        layoutParams17.width = iM14476;
        layoutParams17.height = iM14476;
        layoutParams17.leftMargin = C2579.m9438(30.0f);
        this.f1265.f13762.setLayoutParams(layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f1265.f13775.getLayoutParams();
        layoutParams18.width = C2579.m9438(44.0f);
        layoutParams18.height = C2579.m9438(44.0f);
        layoutParams18.leftMargin = layoutParams17.leftMargin - ((layoutParams18.width - layoutParams17.width) / 2);
        this.f1265.f13775.setLayoutParams(layoutParams18);
        this.f1274 = new C3703(this, new DialogInterfaceOnDismissListenerC0669(), new C0670(), true, false, new C0672());
        this.f1275 = new C2772(this, new DialogInterfaceOnDismissListenerC0673(), new C0674(), true);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m1699(boolean z) {
        if (n.m7588().m7605() == null) {
            if (z) {
                this.f1265.f13780.m2594(false);
                return;
            } else {
                this.f1265.f13770.m4140(false);
                return;
            }
        }
        if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
            m1711(true, z);
        } else {
            m1701(C4843.m14569().m14570() != 1 ? 2 : 1);
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m1700(boolean z) {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 == null || userBeanM5990.getIs_subscription_user()) {
            FilmApp.m405().m427(new RunnableC0653(z));
            return;
        }
        CachePlayStoreBean cachePlayStoreBeanM11747 = C3659.m11744().m11747();
        CacheHuaweiBean cacheHuaweiBeanM11746 = C3659.m11744().m11746();
        if (cachePlayStoreBeanM11747 == null) {
            if (cacheHuaweiBeanM11746 != null) {
                PayController.queryHuaweiOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), HuaweiPay.generateHuaweiJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), cacheHuaweiBeanM11746.getInAppPurchaseData(), cacheHuaweiBeanM11746.getInAppSignature()), new C0650(z));
                return;
            }
            return;
        }
        Purchase purchase = cachePlayStoreBeanM11747.getPurchase();
        PayController.queryPlayStoreOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), GooglePayHelper.generateGoogleJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), purchase.getOriginalJson(), purchase.getSignature()), new C0647(z));
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m1701(int i) {
        SubscribeInfoCallback subscribeInfoCallbackM7605 = n.m7588().m7605();
        C4757.m14304().m14323(i, this, subscribeInfoCallbackM7605.getSub_gplay_id(), subscribeInfoCallbackM7605.getSub_hms_id(), new C0644(subscribeInfoCallbackM7605));
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m1702(boolean z) {
        String str;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str2 = "";
        if (userBeanM5990 != null) {
            String str3 = userBeanM5990.getId() + "";
            str = userBeanM5990.getAccess_token() + "";
            str2 = str3;
        } else {
            str = "";
        }
        C3608.m11650().m11653(str2, str, new C0667(z));
        e5.m5988().m5995();
        this.f1266 = true;
        m1718();
        changeContent();
        m1706();
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public final void m1703() {
        if (this.f1274 != null) {
            C3617.m11671(this).m11675();
            this.f1274.m11874(new C0665());
        }
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public void m1704() {
        if (m1690()) {
            this.f1265.f13757.setVisibility(8);
            this.f1265.f13759.setVisibility(8);
            this.f1265.f13753.setVisibility(8);
            this.f1265.f13780.setVisibility(8);
            if (this.f1271 == 5) {
                this.f1271 = 4;
                changeContent();
            }
            this.f1265.f13776.setVisibility(8);
            this.f1265.f13773.setVisibility(0);
            this.f1265.f13775.setEnabled(true);
            this.f1265.f13772.setEnabled(true);
            this.f1265.f13762.setAlpha(1.0f);
            this.f1265.f13755.setAlpha(1.0f);
            return;
        }
        this.f1265.f13757.setVisibility(0);
        this.f1265.f13759.setVisibility(0);
        this.f1265.f13753.setVisibility(0);
        this.f1265.f13775.setEnabled(false);
        this.f1265.f13772.setEnabled(false);
        this.f1265.f13762.setAlpha(0.3f);
        this.f1265.f13755.setAlpha(0.3f);
        if (this.f1271 == 4) {
            this.f1271 = 5;
            changeContent();
        }
        this.f1265.f13776.setVisibility(0);
        this.f1265.f13773.setVisibility(8);
        int i = this.f1271;
        if (i == 1) {
            this.f1265.f13780.setVisibility(0);
            this.f1265.f13780.m2588();
            this.f1265.f13756.setAlpha(1.0f);
            this.f1265.f13758.setAlpha(0.3f);
            this.f1265.f13754.setAlpha(0.3f);
            return;
        }
        if (i == 2) {
            this.f1265.f13780.setVisibility(0);
            this.f1265.f13780.m2588();
            this.f1265.f13756.setAlpha(0.3f);
            this.f1265.f13758.setAlpha(1.0f);
            this.f1265.f13754.setAlpha(0.3f);
            return;
        }
        if (i != 3) {
            this.f1265.f13780.setVisibility(8);
            this.f1265.f13756.setAlpha(0.3f);
            this.f1265.f13758.setAlpha(0.3f);
            this.f1265.f13754.setAlpha(0.3f);
            return;
        }
        this.f1265.f13780.setVisibility(0);
        this.f1265.f13780.m2588();
        this.f1265.f13756.setAlpha(0.3f);
        this.f1265.f13758.setAlpha(0.3f);
        this.f1265.f13754.setAlpha(1.0f);
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m1705() {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        C3608.m11650().m11659(str, access_token, new C0663());
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public final void m1706() {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (r1.m8142(userBeanM5990)) {
            this.f1265.f13769.m4126(userBeanM5990.getUser_phone_zone(), C2618.m9569("user_login_phone_sp", ""), userBeanM5990.getSubscription_expire_time());
        } else if (e5.m5988().m5993()) {
            this.f1265.f13769.m4126("", "", C3659.m11744().m11748());
        } else {
            this.f1265.f13769.m4126("", "", 0L);
        }
        SubscribeDialog subscribeDialog = this.f1265.f13780;
        if (subscribeDialog != null) {
            subscribeDialog.setSignState(e5.m5988().m5994());
        }
        ProtakeSignInPortraitSettingView protakeSignInPortraitSettingView = this.f1265.f13770;
        if (protakeSignInPortraitSettingView != null) {
            protakeSignInPortraitSettingView.setSignState(e5.m5988().m5994());
        }
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public final void m1707(@Nullable Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            C4535.m13880().m13883(C4535.m13880().m13884((QrCodeBean) intent.getParcelableExtra("qr_result")));
            this.f1265.f13765.m3984(1);
        } catch (Exception e2) {
            C4638.m14100("setPresetFromQrCode: " + e2.getMessage());
        }
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m1708() {
        if (!C2749.m10008(FilmApp.m402())) {
            m1709(12, null);
            this.f1265.f13741.m3943();
            C4638.m14099(f1264, "Please grant location permissions ");
        } else {
            this.f1265.f13751.setAlpha(0.0f);
            this.f1265.f13751.setVisibility(0);
            this.f1265.f13751.m2895();
            C4008.m12876(this.f1265.f13751, 1.0f, 100, null);
        }
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public final void m1709(int i, C3891 c3891) {
        this.f1265.f13752.setVisibility(0);
        this.f1265.f13752.setAlpha(0.0f);
        this.f1265.f13752.m2908(i, c3891);
        C4008.m12876(this.f1265.f13752, 1.0f, 100, null);
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public final void m1710() {
        C4689.m14213(this).m14232(this, new C0657());
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public final void m1711(boolean z, boolean z2) {
        C4689.m14213(this).m14233(new C0658(z), new C0659(z2));
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public final void m1712() {
        if (!C2749.m10008(FilmApp.m402())) {
            m1709(31, null);
            this.f1265.f13741.m3943();
            C4638.m14099(f1264, "Please grant location permissions ");
        } else {
            this.f1265.f13768.setAlpha(0.0f);
            this.f1265.f13768.setVisibility(0);
            this.f1265.f13768.m2921();
            C4008.m12876(this.f1265.f13768, 1.0f, 100, null);
        }
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public final void m1713() {
        this.f1265.f13778.postDelayed(new RunnableC0676(), 300L);
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public final void m1714(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.f1265.f13766.getLayoutParams();
        if (C4792.m14375().m14498()) {
            int iM9438 = C2579.f9600 - C2579.m9438(50.0f);
            layoutParams.width = iM9438;
            int i = (int) (iM9438 * 1.2f);
            layoutParams.height = i;
            if (i > C2579.f9599 - C2579.m9438(20.0f)) {
                layoutParams.height = C2579.f9599 - C2579.m9438(20.0f);
            }
        } else {
            layoutParams.height = ((int) (C2579.f9600 * 0.7f)) + C2579.m9438(45.0f);
            int i2 = C2579.f9599;
            int i3 = (int) (i2 * 0.6f);
            layoutParams.width = i3;
            if (i3 > i2 - C2579.m9438(20.0f)) {
                layoutParams.width = C2579.f9599 - C2579.m9438(20.0f);
            }
        }
        this.f1265.f13766.setLayoutParams(layoutParams);
        this.f1265.f13767.m2984(layoutParams.width, layoutParams.height);
        this.f1265.f13767.setShowType(C5213.m15215() ? 1 : 0);
        this.f1265.f13767.m2985(new C0654(z));
        this.f1265.f13742.setVisibility(0);
        this.f1265.f13766.setAlpha(0.0f);
        this.f1265.f13766.setVisibility(0);
        C4008.m12876(this.f1265.f13766, 1.0f, 100, null);
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public final void m1715() {
        m1709(18, null);
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public final void m1716(boolean z) {
        MobSDK.submitPolicyGrantResult(z, new C0679());
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public final void m1717() {
        boolean zM5994 = e5.m5988().m5994();
        if (zM5994) {
            if (!zM5994 || r1.m8137(n.m7588().m7605())) {
                return;
            }
            m1710();
            return;
        }
        if (FilmApp.m405().m430()) {
            m1714(true);
            return;
        }
        m1716(true);
        this.f1270 = 2;
        this.f1274.m11880(true);
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public final void m1718() {
        m1704();
        int i = this.f1271;
        if (i == 0) {
            m1689(true, this.f1265.f13761);
            m1689(false, this.f1265.f13756);
            m1689(false, this.f1265.f13758);
            m1689(false, this.f1265.f13754);
            m1689(false, this.f1265.f13760);
            m1689(false, this.f1265.f13763);
            return;
        }
        if (i == 1) {
            m1689(false, this.f1265.f13761);
            m1689(true, this.f1265.f13756);
            m1689(false, this.f1265.f13758);
            m1689(false, this.f1265.f13754);
            m1689(false, this.f1265.f13760);
            m1689(false, this.f1265.f13763);
            return;
        }
        if (i == 2) {
            m1689(false, this.f1265.f13761);
            m1689(false, this.f1265.f13756);
            m1689(true, this.f1265.f13758);
            m1689(false, this.f1265.f13754);
            m1689(false, this.f1265.f13760);
            m1689(false, this.f1265.f13763);
            return;
        }
        if (i == 3) {
            m1689(false, this.f1265.f13761);
            m1689(false, this.f1265.f13756);
            m1689(false, this.f1265.f13758);
            m1689(true, this.f1265.f13754);
            m1689(false, this.f1265.f13760);
            m1689(false, this.f1265.f13763);
            return;
        }
        if (i == 4) {
            m1689(false, this.f1265.f13761);
            m1689(false, this.f1265.f13756);
            m1689(false, this.f1265.f13758);
            m1689(false, this.f1265.f13754);
            m1689(true, this.f1265.f13760);
            m1689(false, this.f1265.f13763);
            return;
        }
        if (i != 5) {
            return;
        }
        m1689(false, this.f1265.f13761);
        m1689(false, this.f1265.f13756);
        m1689(false, this.f1265.f13758);
        m1689(false, this.f1265.f13754);
        m1689(false, this.f1265.f13760);
        m1689(true, this.f1265.f13763);
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public final void m1719() {
        m1709(29, null);
    }
}
