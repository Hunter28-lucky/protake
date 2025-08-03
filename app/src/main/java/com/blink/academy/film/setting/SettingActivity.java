package com.blink.academy.film.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import com.android.billingclient.api.Purchase;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.base.BaseActivity;
import com.blink.academy.film.bean.camera.QrCodeBean;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.http.okhttp.callback.CallBack;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.CacheHuaweiBean;
import com.blink.academy.film.netbean.CachePlayStoreBean;
import com.blink.academy.film.netbean.UserBean;
import com.blink.academy.film.netbean.store.SubscribeInfoCallback;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.support.controller.PayController;
import com.blink.academy.film.support.pay.google.GooglePayHelper;
import com.blink.academy.film.support.pay.huawei.HuaweiPay;
import com.blink.academy.film.widgets.SubscribeDialog;
import com.blink.academy.film.widgets.dialog.SettingCodeDialog;
import com.blink.academy.film.widgets.dialog.SettingGimbalDialog;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog;
import com.blink.academy.film.widgets.dialog.login.PrivacyWebView;
import com.blink.academy.film.widgets.setting.PresetSettingView;
import com.blink.academy.film.widgets.setting.ProtakeProSettingView;
import com.blink.academy.film.widgets.setting.ProtakeSignInSettingView;
import com.blink.academy.film.widgets.setting.RecordContainerView;
import com.blink.academy.film.widgets.setting.RecordSettingView;
import com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View;
import com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView;
import com.blink.academy.film.zxing.CaptureActivity;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.uc.crashsdk.export.LogType;
import defpackage.AbstractC3964;
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
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes.dex */
public class SettingActivity extends BaseActivity {

    /* renamed from: ބ, reason: contains not printable characters */
    public static final String f1388 = "SettingActivity";

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3964 f1389;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f1390;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f1391;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1392;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f1393;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f1394;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f1395;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f1396;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f1397 = 5;

    /* renamed from: ؠ, reason: contains not printable characters */
    public long[] f1398 = new long[3];

    /* renamed from: ހ, reason: contains not printable characters */
    public int f1399;

    /* renamed from: ށ, reason: contains not printable characters */
    public C3703 f1400;

    /* renamed from: ނ, reason: contains not printable characters */
    public C2772 f1401;

    /* renamed from: ރ, reason: contains not printable characters */
    public boolean f1402;

    /* renamed from: com.blink.academy.film.setting.SettingActivity$Ϳ, reason: contains not printable characters */
    public class C0687 implements C4567.InterfaceC4574 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ϳ$Ϳ, reason: contains not printable characters */
        public class RunnableC0688 implements Runnable {
            public RunnableC0688() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4089();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ϳ$Ԩ, reason: contains not printable characters */
        public class RunnableC0689 implements Runnable {
            public RunnableC0689() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4093();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ϳ$Ԫ, reason: contains not printable characters */
        public class RunnableC0690 implements Runnable {
            public RunnableC0690() {
            }

            @Override // java.lang.Runnable
            public void run() throws Resources.NotFoundException {
                C3891 c3891 = new C3891();
                String string = SettingActivity.this.getResources().getString(R.string.POPUP_TITLE_PROTAKE_FOCUS_UPDATE);
                String string2 = SettingActivity.this.getResources().getString(R.string.POPUP_DESC_PROTAKE_FOCUS_UPDATE);
                String string3 = SettingActivity.this.getResources().getString(R.string.BUTTON_CANCEL);
                String string4 = SettingActivity.this.getResources().getString(R.string.POPUP_DESC_PROTAKE_FOCUS_CONFIRM);
                c3891.m12515(string);
                c3891.m12553(string2);
                c3891.m12516(string3);
                c3891.m12503(string4);
                SettingActivity.this.m1819(33, c3891);
            }
        }

        public C0687() {
        }

        @Override // defpackage.C4567.InterfaceC4574
        /* renamed from: Ϳ */
        public void mo1720() {
            SettingActivity.this.runOnUiThread(new RunnableC0688());
        }

        @Override // defpackage.C4567.InterfaceC4574
        /* renamed from: Ԩ */
        public void mo1721() {
            SettingActivity.this.runOnUiThread(new RunnableC0690());
        }

        @Override // defpackage.C4567.InterfaceC4574
        /* renamed from: ԭ */
        public void mo1722() {
            SettingActivity.this.runOnUiThread(new RunnableC0689());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԩ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0691 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC0692 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1408;

            public RunnableC0692(View view) {
                this.f1408 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1408.isEnabled() && e5.m5988().m5993()) {
                    SettingActivity.this.f1389.f13818.setAlpha(1.0f);
                } else if (SettingActivity.this.f1397 == 2) {
                    SettingActivity.this.f1389.f13818.setAlpha(1.0f);
                } else {
                    SettingActivity.this.f1389.f13818.setAlpha(0.3f);
                }
            }
        }

        public ViewOnTouchListenerC0691() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (SettingActivity.this.f1397 == 2) {
                    return false;
                }
                SettingActivity.this.f1389.f13818.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0692(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԫ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0693 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC0694 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1411;

            public RunnableC0694(View view) {
                this.f1411 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1411.isEnabled() && e5.m5988().m5993()) {
                    SettingActivity.this.f1389.f13817.setAlpha(1.0f);
                } else if (SettingActivity.this.f1397 == 1) {
                    SettingActivity.this.f1389.f13817.setAlpha(1.0f);
                } else {
                    SettingActivity.this.f1389.f13817.setAlpha(0.3f);
                }
            }
        }

        public ViewOnTouchListenerC0693() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (SettingActivity.this.f1397 == 1) {
                    return false;
                }
                SettingActivity.this.f1389.f13817.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0694(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԭ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0695 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC0696 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1414;

            public RunnableC0696(View view) {
                this.f1414 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1414.isEnabled()) {
                    SettingActivity.this.f1389.f13820.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0695() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (SettingActivity.this.f1397 == 0) {
                    return false;
                }
                SettingActivity.this.f1389.f13820.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0696(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0697 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0698 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1417;

            public RunnableC0698(View view) {
                this.f1417 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1417.isEnabled() && e5.m5988().m5993()) {
                    SettingActivity.this.f1389.f13816.setAlpha(1.0f);
                } else if (SettingActivity.this.f1397 == 3) {
                    SettingActivity.this.f1389.f13816.setAlpha(1.0f);
                } else {
                    SettingActivity.this.f1389.f13816.setAlpha(0.3f);
                }
            }
        }

        public ViewOnTouchListenerC0697() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (SettingActivity.this.f1397 == 3) {
                    return false;
                }
                SettingActivity.this.f1389.f13816.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0698(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ՠ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0699 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ՠ$Ϳ, reason: contains not printable characters */
        public class RunnableC0700 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1420;

            public RunnableC0700(View view) {
                this.f1420 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1420.isEnabled()) {
                    SettingActivity.this.f1389.f13819.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0699() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (SettingActivity.this.f1397 == 4) {
                    return false;
                }
                SettingActivity.this.f1389.f13819.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0700(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ֈ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0701 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ֈ$Ϳ, reason: contains not printable characters */
        public class RunnableC0702 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1423;

            public RunnableC0702(View view) {
                this.f1423 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1423.isEnabled()) {
                    SettingActivity.this.f1389.f13821.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0701() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                if (SettingActivity.this.f1397 == 5) {
                    return false;
                }
                SettingActivity.this.f1389.f13821.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0702(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$֏, reason: contains not printable characters */
    public class C0703 implements SettingCodeDialog.InterfaceC1025 {
        public C0703() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingCodeDialog.InterfaceC1025
        /* renamed from: Ϳ */
        public void mo1723() {
            SettingActivity.this.m1807();
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ׯ, reason: contains not printable characters */
    public class C0704 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ׯ$Ϳ, reason: contains not printable characters */
        public class C0705 extends AbstractC4012 {
            public C0705() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13801.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ׯ$Ԩ, reason: contains not printable characters */
        public class C0706 extends AbstractC4012 {
            public C0706() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13801.setVisibility(8);
            }
        }

        public C0704() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (i == 28) {
                SettingActivity.this.m1826(false);
            }
            C4008.m12876(SettingActivity.this.f1389.f13801, 0.0f, 100, new C0706());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            if (i == 29) {
                SettingActivity.this.m1813();
                return;
            }
            C4008.m12876(SettingActivity.this.f1389.f13801, 0.0f, 100, new C0705());
            if (i == 1) {
                SettingActivity.this.f1389.f13799.m3919();
                return;
            }
            if (i == 2) {
                if (c3891 != null) {
                    C4535.m13880().m13887(c3891);
                    SettingActivity.this.f1389.f13806.m4013(2);
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
                    sb.append(SettingActivity.this.m1804(c3891));
                    sb.append(" / ");
                    sb.append(SettingActivity.this.m1805(c3891));
                    int iM12442 = c3891.m12442();
                    if (iM12442 != 0) {
                        sb.append(" / ");
                        sb.append(C2462.m9035().m9060(iM12442));
                    }
                    c3891.m12516(sb.toString());
                    C4535.m13880().m13913(c3891);
                    SettingActivity.this.f1389.f13806.m4013(3);
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
                    C4535.m13880().m13910(C4535.m13880().m13890().m12462());
                    C4535.m13880().m13911(C4535.m13880().m13890().m12463());
                    C4535.m13880().m13915();
                    SettingActivity.this.f1390 = true;
                    j.m7064();
                    SettingActivity.this.m1802();
                    return;
                }
                return;
            }
            if (i == 11) {
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", SettingActivity.this.getPackageName(), null));
                intent.addFlags(65536);
                SettingActivity.this.startActivity(intent);
                return;
            }
            if (i == 12) {
                if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(SettingActivity.this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.ACCESS_FINE_LOCATION"}, 102);
                    return;
                } else {
                    ActivityCompat.requestPermissions(SettingActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 102);
                    return;
                }
            }
            if (i == 31) {
                if (Build.VERSION.SDK_INT >= 31) {
                    ActivityCompat.requestPermissions(SettingActivity.this, new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.ACCESS_FINE_LOCATION"}, 103);
                    return;
                } else {
                    ActivityCompat.requestPermissions(SettingActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 103);
                    return;
                }
            }
            if (i == 18) {
                SettingActivity.this.m1812(false);
                return;
            }
            if (i == 28) {
                SettingActivity.this.m1826(true);
                if (c3891.m12493()) {
                    SettingActivity.this.f1394 = 2;
                    SettingActivity.this.f1400.m11880(true);
                    return;
                } else {
                    SettingActivity.this.f1394 = 1;
                    SettingActivity.this.f1400.m11880(false);
                    return;
                }
            }
            if (i == 30) {
                SettingActivity.this.f1389.f13794.m4083();
            } else if (i == 37) {
                ActivityCompat.requestPermissions(SettingActivity.this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 101);
            } else if (i == 38) {
                ActivityCompat.requestPermissions(SettingActivity.this, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"}, 10001);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ؠ, reason: contains not printable characters */
    public class C0707 implements SettingGimbalDialog.InterfaceC1036 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ؠ$Ϳ, reason: contains not printable characters */
        public class C0708 extends AbstractC4012 {
            public C0708() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13800.m2888();
                SettingActivity.this.f1389.f13800.setVisibility(8);
                SettingActivity.this.f1389.f13794.m4095();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ؠ$Ԩ, reason: contains not printable characters */
        public class C0709 extends AbstractC4012 {
            public C0709() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13800.m2888();
                SettingActivity.this.f1389.f13800.setVisibility(8);
                SettingActivity.this.f1389.f13794.m4095();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ؠ$Ԫ, reason: contains not printable characters */
        public class RunnableC0710 implements Runnable {
            public RunnableC0710() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4092();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ؠ$Ԭ, reason: contains not printable characters */
        public class RunnableC0711 implements Runnable {
            public RunnableC0711() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4090();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ؠ$Ԯ, reason: contains not printable characters */
        public class RunnableC0712 implements Runnable {
            public RunnableC0712() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4088();
            }
        }

        public C0707() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: Ϳ */
        public void mo1724() {
            SettingActivity.this.runOnUiThread(new RunnableC0712());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: Ԩ */
        public void mo1725() {
            SettingActivity.this.runOnUiThread(new RunnableC0710());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: ԩ */
        public void mo1726() {
            C4008.m12876(SettingActivity.this.f1389.f13800, 0.0f, 100, new C0708());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: Ԫ */
        public void mo1727() {
            SettingActivity.this.runOnUiThread(new RunnableC0711());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingGimbalDialog.InterfaceC1036
        /* renamed from: ԫ */
        public void mo1728() {
            C4008.m12876(SettingActivity.this.f1389.f13800, 0.0f, 100, new C0709());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ހ, reason: contains not printable characters */
    public class C0713 implements SettingProtakeFocusDialog.InterfaceC1059 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ހ$Ϳ, reason: contains not printable characters */
        public class C0714 extends AbstractC4012 {
            public C0714() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13809.m2914();
                SettingActivity.this.f1389.f13809.setVisibility(8);
                SettingActivity.this.f1389.f13794.m4094();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ހ$Ԩ, reason: contains not printable characters */
        public class C0715 extends AbstractC4012 {
            public C0715() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13809.m2914();
                SettingActivity.this.f1389.f13809.setVisibility(8);
                SettingActivity.this.f1389.f13794.m4094();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ހ$Ԫ, reason: contains not printable characters */
        public class RunnableC0716 implements Runnable {
            public RunnableC0716() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4093();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ހ$Ԭ, reason: contains not printable characters */
        public class RunnableC0717 implements Runnable {
            public RunnableC0717() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4091();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ހ$Ԯ, reason: contains not printable characters */
        public class RunnableC0718 implements Runnable {
            public RunnableC0718() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4089();
            }
        }

        public C0713() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: Ϳ */
        public void mo1729() {
            SettingActivity.this.runOnUiThread(new RunnableC0718());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: Ԩ */
        public void mo1730() {
            SettingActivity.this.runOnUiThread(new RunnableC0716());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: ԩ */
        public void mo1731() {
            C4008.m12876(SettingActivity.this.f1389.f13809, 0.0f, 100, new C0714());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: Ԫ */
        public void mo1732() {
            SettingActivity.this.runOnUiThread(new RunnableC0717());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingProtakeFocusDialog.InterfaceC1059
        /* renamed from: ԫ */
        public void mo1733() {
            C4008.m12876(SettingActivity.this.f1389.f13809, 0.0f, 100, new C0715());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ށ, reason: contains not printable characters */
    public class C0719 implements c9.InterfaceC0058 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC0720 implements Runnable {
            public RunnableC0720() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13796.performClick();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ށ$Ԩ, reason: contains not printable characters */
        public class RunnableC0721 implements Runnable {

            /* renamed from: com.blink.academy.film.setting.SettingActivity$ށ$Ԩ$Ϳ, reason: contains not printable characters */
            public class C0722 extends AbstractC4012 {
                public C0722() {
                }

                @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
                public void onAnimationEnd(View view) {
                    super.onAnimationEnd(view);
                    SettingActivity.this.f1389.f13800.m2888();
                    SettingActivity.this.f1389.f13800.setVisibility(8);
                    SettingActivity.this.f1389.f13794.m4095();
                }
            }

            public RunnableC0721() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C4008.m12876(SettingActivity.this.f1389.f13800, 0.0f, 100, new C0722());
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ށ$Ԫ, reason: contains not printable characters */
        public class RunnableC0723 implements Runnable {
            public RunnableC0723() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4092();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ށ$Ԭ, reason: contains not printable characters */
        public class RunnableC0724 implements Runnable {
            public RunnableC0724() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13794.m4088();
            }
        }

        public C0719() {
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: Ϳ */
        public void mo270() {
            SettingActivity.this.runOnUiThread(new RunnableC0720());
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: Ԩ */
        public void mo271() {
            SettingActivity.this.runOnUiThread(new RunnableC0723());
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: ԩ */
        public void mo272() {
            SettingActivity.this.runOnUiThread(new RunnableC0724());
        }

        @Override // defpackage.c9.InterfaceC0058
        /* renamed from: Ԫ */
        public void mo273() {
            SettingActivity.this.runOnUiThread(new RunnableC0721());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ނ, reason: contains not printable characters */
    public class C0725 implements RecordContainerView.InterfaceC1464 {
        public C0725() {
        }

        @Override // com.blink.academy.film.widgets.setting.RecordContainerView.InterfaceC1464
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1830(int i, C3891 c3891) {
            SettingActivity.this.m1819(i, c3891);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ރ, reason: contains not printable characters */
    public class C0726 implements RecordSettingView.InterfaceC1508 {
        public C0726() {
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1508
        /* renamed from: Ϳ */
        public void mo1735() {
            SettingActivity.this.m1819(1, null);
        }

        @Override // com.blink.academy.film.widgets.setting.RecordSettingView.InterfaceC1508
        /* renamed from: Ԩ */
        public void mo1736() {
            SettingActivity.this.m1819(37, null);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ބ, reason: contains not printable characters */
    public class C0727 implements AccessoriesSettingView.InterfaceC1524 {
        public C0727() {
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView.InterfaceC1524
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1831() {
            SettingActivity.this.m1819(38, null);
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView.InterfaceC1524
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1832() {
            if (SettingActivity.this.f1389.f13800.getVisibility() != 0) {
                SettingActivity.this.m1818();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesSettingView.InterfaceC1524
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1833() {
            if (SettingActivity.this.f1389.f13800.getVisibility() != 0) {
                SettingActivity.this.m1818();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޅ, reason: contains not printable characters */
    public class C0728 implements AccessoriesPage2View.InterfaceC1516 {
        public C0728() {
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View.InterfaceC1516
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1834() {
            if (SettingActivity.this.f1389.f13809.getVisibility() != 0) {
                SettingActivity.this.m1822();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View.InterfaceC1516
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1835() {
            SettingActivity.this.m1819(38, null);
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View.InterfaceC1516
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1836() throws Resources.NotFoundException {
            C3891 c3891 = new C3891();
            String string = SettingActivity.this.getResources().getString(R.string.SETTINGS_ACCESORRIES_HDMI_POP_TITLE);
            String string2 = SettingActivity.this.getResources().getString(R.string.SETTINGS_ACCESORRIES_HDMI_POP_CONTENT);
            String string3 = SettingActivity.this.getResources().getString(R.string.BUTTON_OK);
            c3891.m12515(string);
            c3891.m12553(string2);
            c3891.m12516("");
            c3891.m12503(string3);
            SettingActivity.this.m1819(30, c3891);
        }

        @Override // com.blink.academy.film.widgets.setting.accessories.AccessoriesPage2View.InterfaceC1516
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1837() {
            if (SettingActivity.this.f1389.f13809.getVisibility() != 0) {
                SettingActivity.this.m1822();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ކ, reason: contains not printable characters */
    public class C0729 implements PresetSettingView.InterfaceC1434 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1451;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ކ$Ϳ, reason: contains not printable characters */
        public class RunnableC0730 implements Runnable {
            public RunnableC0730() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13806.m4005();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ކ$Ԩ, reason: contains not printable characters */
        public class C0731 extends AbstractC4012 {
            public C0731() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                Intent intent = new Intent(SettingActivity.this, (Class<?>) CaptureActivity.class);
                intent.addFlags(65536);
                intent.putExtra("isPortrait", false);
                SettingActivity.this.startActivityForResult(intent, 101);
                SettingActivity.this.overridePendingTransition(0, 0);
            }
        }

        public C0729(int i) {
            this.f1451 = i;
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1838(C3891 c3891, String str) {
            c3891.m12345(System.currentTimeMillis());
            C4535.m13880().m13914(c3891);
            SettingActivity.this.f1389.f13806.m4013(3);
            SettingActivity.this.m1803();
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1839(C3891 c3891) {
            SettingActivity.this.m1819(2, c3891);
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1840(C3891 c3891) {
            SettingActivity.this.m1819(4, c3891);
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1841(C3891 c3891) {
            try {
                Bitmap bitmapM10699 = new C3108(SettingActivity.this, this.f1451).m10699(C4929.m14660(C4535.m13880().m13904(c3891)));
                if (bitmapM10699 != null) {
                    SettingActivity.this.f1389.f13798.setVisibility(0);
                    SettingActivity.this.f1389.f13798.setBitmap(bitmapM10699);
                    SettingActivity.this.f1389.f13798.setAlpha(0.0f);
                    C4008.m12876(SettingActivity.this.f1389.f13798, 1.0f, 100, null);
                    j.m7067();
                } else {
                    C4638.m14101("onShowQR", "onShowQR: encodeAsBitmap error");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1842(C3891 c3891) {
            SettingActivity.this.m1819(3, c3891);
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1843() {
            if (SettingActivity.this.f1389.f13806.m4006()) {
                return;
            }
            C3891 c3891M13890 = C4535.m13880().m13890();
            StringBuilder sb = new StringBuilder();
            sb.append(C5049.m14852().m14857(Math.min(c3891M13890.m12463(), c3891M13890.m12462())));
            sb.append(" / ");
            sb.append(c3891M13890.m12456());
            sb.append("FPS / ");
            sb.append(SettingActivity.this.m1804(c3891M13890));
            sb.append(" / ");
            sb.append(SettingActivity.this.m1805(c3891M13890));
            int iM12442 = c3891M13890.m12442();
            if (iM12442 != 0) {
                sb.append(" / ");
                sb.append(C2462.m9035().m9060(iM12442));
            }
            C4535.m13880().m13882(sb.toString());
            SettingActivity.this.f1389.f13806.m4013(1);
            SettingActivity.this.f1389.f13806.postDelayed(new RunnableC0730(), 100L);
            j.m7062();
        }

        @Override // com.blink.academy.film.widgets.setting.PresetSettingView.InterfaceC1434
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1844() {
            if (SettingActivity.this.f1389.f13806.m4006() || SettingActivity.this.f1391) {
                return;
            }
            j.m7066();
            SettingActivity.this.f1391 = true;
            C4008.m12876(SettingActivity.this.f1389.f13814, 0.0f, 100, new C0731());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$އ, reason: contains not printable characters */
    public class C0732 implements SubscribeDialog.InterfaceC0965 {
        public C0732() {
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ϳ */
        public boolean mo1341() {
            return false;
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԩ */
        public void mo1342() throws Resources.NotFoundException {
            C4320.m13462(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԩ */
        public void mo1343() {
            SettingActivity.this.m1809(true);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԫ */
        public void mo1344() {
            if (r1.m8142(e5.m5988().m5990())) {
                SettingActivity.this.m1825();
            } else {
                if (FilmApp.m405().m430()) {
                    SettingActivity.this.m1824(false);
                    return;
                }
                SettingActivity.this.m1826(true);
                SettingActivity.this.f1394 = 1;
                SettingActivity.this.f1400.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԫ */
        public void mo1345() {
            SettingActivity.this.m1827();
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: Ԭ */
        public void mo1346() {
            C4320.m13460(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.SubscribeDialog.InterfaceC0965
        /* renamed from: ԭ */
        public void mo1347() {
            C4320.m13461(SettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ވ, reason: contains not printable characters */
    public class C0733 implements ProtakeProSettingView.InterfaceC1444 {
        public C0733() {
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1845() {
            SettingActivity.this.m1829();
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1846() {
            if (SettingActivity.this.f1400 != null) {
                if (FilmApp.m405().m430()) {
                    SettingActivity.this.m1824(false);
                    return;
                }
                SettingActivity.this.m1826(true);
                SettingActivity.this.f1394 = 1;
                SettingActivity.this.f1400.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1847() throws Resources.NotFoundException {
            if (r1.m8142(e5.m5988().m5990())) {
                SettingActivity.this.m1798();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1848() {
            C4320.m13461(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1849() {
            C4320.m13460(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1850() throws Resources.NotFoundException {
            C4320.m13462(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1851() {
            if (r1.m8142(e5.m5988().m5990())) {
                SettingActivity.this.m1825();
            }
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeProSettingView.InterfaceC1444
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo1852() {
            C4320.m13459(SettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$މ, reason: contains not printable characters */
    public class C0734 implements ProtakeSignInSettingView.InterfaceC1459 {
        public C0734() {
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo1853() {
            SettingActivity.this.m1829();
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo1854() throws Resources.NotFoundException {
            C4320.m13462(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: ԩ, reason: contains not printable characters */
        public void mo1855() {
            SettingActivity.this.m1809(false);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: Ԫ, reason: contains not printable characters */
        public void mo1856() {
            if (r1.m8142(e5.m5988().m5990())) {
                SettingActivity.this.m1825();
            } else {
                if (FilmApp.m405().m430()) {
                    SettingActivity.this.m1824(false);
                    return;
                }
                SettingActivity.this.m1826(true);
                SettingActivity.this.f1394 = 1;
                SettingActivity.this.f1400.m11880(false);
            }
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: ԫ, reason: contains not printable characters */
        public void mo1857() {
            SettingActivity.this.m1827();
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: Ԭ, reason: contains not printable characters */
        public void mo1858() {
            C4320.m13460(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: ԭ, reason: contains not printable characters */
        public void mo1859() {
            C4320.m13461(SettingActivity.this);
        }

        @Override // com.blink.academy.film.widgets.setting.ProtakeSignInSettingView.InterfaceC1459
        /* renamed from: Ԯ, reason: contains not printable characters */
        public void mo1860() {
            C4320.m13459(SettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ފ, reason: contains not printable characters */
    public class ViewOnClickListenerC0735 implements View.OnClickListener {
        public ViewOnClickListenerC0735() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ދ, reason: contains not printable characters */
    public class C0736 implements InterfaceC4875 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SubscribeInfoCallback f1459;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ދ$Ϳ, reason: contains not printable characters */
        public class RunnableC0737 implements Runnable {
            public RunnableC0737() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13811.m4039(false);
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ދ$Ԩ, reason: contains not printable characters */
        public class RunnableC0738 implements Runnable {
            public RunnableC0738() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13815.m2594(false);
                SettingActivity.this.f1389.f13811.m4039(false);
            }
        }

        public C0736(SubscribeInfoCallback subscribeInfoCallback) {
            this.f1459 = subscribeInfoCallback;
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ϳ */
        public void mo1309(int i) {
            FilmApp.m405().m427(new RunnableC0738());
        }

        @Override // defpackage.InterfaceC4875
        /* renamed from: Ԩ */
        public void mo1310(Purchase purchase) {
            C2618.m9573("local_sub_pus_sp", new Gson().toJson(purchase));
            C2618.m9573("local_sub_id_sp", this.f1459.getSub_gplay_id());
            C3659.m11744().m11751(0);
            SettingActivity.this.m1810(true);
            FilmApp.m405().m427(new RunnableC0737());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ތ, reason: contains not printable characters */
    public class C0739 implements PrivacyWebView.InterfaceC1095 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1463;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ތ$Ϳ, reason: contains not printable characters */
        public class C0740 extends AbstractC4012 {
            public C0740() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13807.setAlpha(0.0f);
                SettingActivity.this.f1389.f13807.setVisibility(8);
                C0739 c0739 = C0739.this;
                if (c0739.f1463) {
                    SettingActivity.this.f1394 = 2;
                    SettingActivity.this.f1400.m11880(true);
                } else {
                    SettingActivity.this.f1394 = 1;
                    SettingActivity.this.f1400.m11880(false);
                }
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ތ$Ԩ, reason: contains not printable characters */
        public class C0741 extends AbstractC4012 {
            public C0741() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13807.setVisibility(8);
            }
        }

        public C0739(boolean z) {
            this.f1463 = z;
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        public void onDisagree() {
            SettingActivity.this.f1389.f13795.setVisibility(8);
            SettingActivity.this.m1826(false);
            C4008.m12876(SettingActivity.this.f1389.f13807, 0.0f, 100, new C0741());
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyWebView.InterfaceC1095
        /* renamed from: Ϳ */
        public void mo1314(boolean z) {
            SettingActivity.this.f1389.f13795.setVisibility(8);
            if (z) {
                C2618.m9571("privacy_alert_v_sp2", C2618.m9566("privacy_remote_v_sp", 1));
            } else {
                C2618.m9571("terms_alert_v_sp2", C2618.m9566("terms_remote_v_sp", 1));
            }
            SettingActivity.this.m1826(true);
            C4008.m12876(SettingActivity.this.f1389.f13807, 0.0f, 100, new C0740());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ލ, reason: contains not printable characters */
    public class C0742 implements C4689.InterfaceC4697 {
        public C0742() {
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            SettingActivity.this.m1801(i);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ގ, reason: contains not printable characters */
    public class C0743 implements C4689.InterfaceC4697 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1468;

        public C0743(boolean z) {
            this.f1468 = z;
        }

        @Override // defpackage.C4689.InterfaceC4697
        /* renamed from: Ϳ */
        public void mo1331(int i) {
            if (this.f1468) {
                C4689.m14213(SettingActivity.this).m14222();
                SettingActivity.this.m1811(i == 2 ? 1 : 2);
            } else if (i == 2) {
                SettingActivity.this.m1801(2);
            } else if (i == 4) {
                SettingActivity.this.m1801(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޏ, reason: contains not printable characters */
    public class C0744 implements C4689.InterfaceC4696 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1470;

        public C0744(boolean z) {
            this.f1470 = z;
        }

        @Override // defpackage.C4689.InterfaceC4696
        /* renamed from: Ϳ */
        public void mo1332() {
            if (this.f1470) {
                SettingActivity.this.f1389.f13815.m2594(false);
            } else {
                SettingActivity.this.f1389.f13811.m4039(false);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ސ, reason: contains not printable characters */
    public class C0745 implements C4757.InterfaceC4768 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f1472;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ސ$Ϳ, reason: contains not printable characters */
        public class RunnableC0746 implements Runnable {
            public RunnableC0746() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.m7057(C0745.this.f1472);
                C3617.m11671(SettingActivity.this).m11673();
                C4689.m14213(SettingActivity.this).m14222();
                SettingActivity.this.m1815();
            }
        }

        public C0745(int i) {
            this.f1472 = i;
        }

        @Override // defpackage.C4757.InterfaceC4768
        public void onFail() {
            C3617.m11671(SettingActivity.this).m11673();
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ϳ */
        public void mo437() {
            C3617.m11671(SettingActivity.this).m11673();
            SettingActivity.this.m1812(false);
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ԩ */
        public void mo438() {
            FilmApp.m405().m427(new RunnableC0746());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޑ, reason: contains not printable characters */
    public class C0747 implements C3608.InterfaceC3610 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޑ$Ϳ, reason: contains not printable characters */
        public class RunnableC0748 implements Runnable {
            public RunnableC0748() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.m1828();
                SettingActivity.this.changeContent();
                SettingActivity.this.m1816();
            }
        }

        public C0747() {
        }

        @Override // defpackage.C3608.InterfaceC3610
        /* renamed from: Ϳ */
        public void mo1336() {
            SettingActivity.this.runOnUiThread(new RunnableC0748());
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

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޒ, reason: contains not printable characters */
    public class C0749 implements C3703.InterfaceC3720 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޒ$Ϳ, reason: contains not printable characters */
        public class C0750 extends AbstractC4012 {
            public C0750() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                SettingActivity.this.f1389.f13801.setVisibility(8);
                SettingActivity.this.m1812(true);
            }
        }

        public C0749() {
        }

        @Override // defpackage.C3703.InterfaceC3720
        public void onFail() {
            C3617.m11671(SettingActivity.this).m11673();
        }

        @Override // defpackage.C3703.InterfaceC3720
        public void onSuc() {
            C4008.m12876(SettingActivity.this.f1389.f13801, 0.0f, 100, new C0750());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޓ, reason: contains not printable characters */
    public class C0751 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1479;

        public C0751(boolean z) {
            this.f1479 = z;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            if (this.f1479) {
                C3617.m11671(SettingActivity.this).m11673();
            }
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            if (this.f1479) {
                C3617.m11671(SettingActivity.this).m11673();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޔ, reason: contains not printable characters */
    public class C0752 extends AbstractC4012 {
        public C0752() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            SettingActivity.this.f1389.f13798.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޕ, reason: contains not printable characters */
    public class ViewOnClickListenerC0753 implements View.OnClickListener {
        public ViewOnClickListenerC0753() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1389.f13806.m4006()) {
                return;
            }
            if (SettingActivity.this.f1397 != 0) {
                SettingActivity.this.f1397 = 0;
                C2618.m9571("setting_tab_state_sp", SettingActivity.this.f1397);
                SettingActivity.this.m1828();
                SettingActivity.this.changeContent();
                return;
            }
            long[] jArr = SettingActivity.this.f1398;
            System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
            long[] jArr2 = SettingActivity.this.f1398;
            jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
            if (SettingActivity.this.f1398[0] >= SystemClock.uptimeMillis() - 500) {
                SettingActivity settingActivity = SettingActivity.this;
                settingActivity.f1398 = null;
                settingActivity.f1398 = new long[3];
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޖ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC0754 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0754() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޗ, reason: contains not printable characters */
    public class C0755 extends CallBack<UserBean> {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޗ$Ϳ, reason: contains not printable characters */
        public class RunnableC0756 implements Runnable {
            public RunnableC0756() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean zM5993 = e5.m5988().m5993();
                if (zM5993 && SettingActivity.this.f1400 != null) {
                    SettingActivity.this.f1400.m11877();
                }
                if (SettingActivity.this.f1394 == 2 && !zM5993) {
                    SettingActivity.this.m1820();
                }
                SettingActivity.this.m1828();
                SettingActivity.this.changeContent();
                SettingActivity.this.m1816();
            }
        }

        public C0755() {
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
            SettingActivity.this.runOnUiThread(new RunnableC0756());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޘ, reason: contains not printable characters */
    public class C0757 implements C3703.InterfaceC3719 {
        public C0757() {
        }

        @Override // defpackage.C3703.InterfaceC3719
        /* renamed from: Ϳ */
        public void mo1355() {
            if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
                SettingActivity.this.m1821(false, false);
            } else if (C4843.m14569().m14570() == 1) {
                SettingActivity.this.m1801(2);
            } else if (C4843.m14569().m14570() == 2) {
                SettingActivity.this.m1801(4);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޙ, reason: contains not printable characters */
    public class DialogInterfaceOnDismissListenerC0758 implements DialogInterface.OnDismissListener {
        public DialogInterfaceOnDismissListenerC0758() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޚ, reason: contains not printable characters */
    public class C0759 implements C2772.InterfaceC2787 {

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޚ$Ϳ, reason: contains not printable characters */
        public class RunnableC0760 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ UserBean f1489;

            /* renamed from: Ԭ, reason: contains not printable characters */
            public final /* synthetic */ String f1490;

            public RunnableC0760(UserBean userBean, String str) {
                this.f1489 = userBean;
                this.f1490 = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                SettingActivity.this.f1389.f13810.m4025(this.f1489.getUser_phone_zone(), this.f1490, this.f1489.getSubscription_expire_time());
            }
        }

        public C0759() {
        }

        @Override // defpackage.C2772.InterfaceC2787
        public void onChange() {
            if (SettingActivity.this.f1389.f13810 != null) {
                UserBean userBeanM5990 = e5.m5988().m5990();
                String strM9569 = C2618.m9569("user_login_phone_sp", "");
                if (r1.m8142(userBeanM5990)) {
                    SettingActivity.this.runOnUiThread(new RunnableC0760(userBeanM5990, strM9569));
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޛ, reason: contains not printable characters */
    public class RunnableC0761 implements Runnable {
        public RunnableC0761() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4008.m12876(SettingActivity.this.f1389.f13814, 1.0f, 200, null);
            z0.m8635(SettingActivity.this);
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޜ, reason: contains not printable characters */
    public class C0762 extends AbstractC4012 {
        public C0762() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            SettingActivity.this.finish();
            SettingActivity.this.overridePendingTransition(0, 0);
            if (HomeActivity.m700() != null) {
                HomeActivity.m700().m1021(SettingActivity.this.f1390);
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޝ, reason: contains not printable characters */
    public class C0763 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1494;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޝ$Ϳ, reason: contains not printable characters */
        public class RunnableC0764 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f1496;

            public RunnableC0764(ApiException apiException) {
                this.f1496 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0763 c0763 = C0763.this;
                if (c0763.f1494) {
                    SettingActivity.this.f1389.f13815.m2594(false);
                } else {
                    SettingActivity.this.f1389.f13811.m4039(false);
                }
                if (C3703.m11871(this.f1496.getCode())) {
                    C3659.m11744().m11745(0);
                }
                SettingActivity.this.m1815();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޝ$Ԩ, reason: contains not printable characters */
        public class RunnableC0765 implements Runnable {
            public RunnableC0765() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0763 c0763 = C0763.this;
                if (c0763.f1494) {
                    SettingActivity.this.f1389.f13815.m2594(false);
                } else {
                    SettingActivity.this.f1389.f13811.m4039(false);
                }
                C3659.m11744().m11745(0);
                SettingActivity.this.m1815();
            }
        }

        public C0763(boolean z) {
            this.f1494 = z;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            FilmApp.m405().m427(new RunnableC0764(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            FilmApp.m405().m427(new RunnableC0765());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޞ, reason: contains not printable characters */
    public class C0766 extends CallBack<String> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1499;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޞ$Ϳ, reason: contains not printable characters */
        public class RunnableC0767 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ ApiException f1501;

            public RunnableC0767(ApiException apiException) {
                this.f1501 = apiException;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0766 c0766 = C0766.this;
                if (c0766.f1499) {
                    SettingActivity.this.f1389.f13815.m2594(false);
                } else {
                    SettingActivity.this.f1389.f13811.m4039(false);
                }
                if (C3703.m11871(this.f1501.getCode())) {
                    C3659.m11744().m11745(0);
                }
                SettingActivity.this.m1815();
            }
        }

        /* renamed from: com.blink.academy.film.setting.SettingActivity$ޞ$Ԩ, reason: contains not printable characters */
        public class RunnableC0768 implements Runnable {
            public RunnableC0768() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0766 c0766 = C0766.this;
                if (c0766.f1499) {
                    SettingActivity.this.f1389.f13815.m2594(false);
                } else {
                    SettingActivity.this.f1389.f13811.m4039(false);
                }
                C3659.m11744().m11745(0);
                SettingActivity.this.m1815();
            }
        }

        public C0766(boolean z) {
            this.f1499 = z;
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onCompleted() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onError(ApiException apiException) {
            FilmApp.m405().m427(new RunnableC0767(apiException));
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onStart() {
        }

        @Override // com.blink.academy.film.http.okhttp.callback.CallBack
        public void onSuccess(String str) {
            FilmApp.m405().m427(new RunnableC0768());
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޟ, reason: contains not printable characters */
    public class RunnableC0769 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ boolean f1504;

        public RunnableC0769(boolean z) {
            this.f1504 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1504) {
                SettingActivity.this.f1389.f13815.m2594(false);
            } else {
                SettingActivity.this.f1389.f13811.m4039(false);
            }
            SettingActivity.this.m1815();
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޠ, reason: contains not printable characters */
    public class ViewOnClickListenerC0770 implements View.OnClickListener {
        public ViewOnClickListenerC0770() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1389.f13806.m4006() || SettingActivity.this.f1397 == 1) {
                return;
            }
            SettingActivity.this.f1397 = 1;
            C2618.m9571("setting_tab_state_sp", SettingActivity.this.f1397);
            SettingActivity.this.m1828();
            SettingActivity.this.changeContent();
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޡ, reason: contains not printable characters */
    public class C0771 extends OperationCallback<Void> {
        public C0771() {
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }

        @Override // com.mob.OperationCallback
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onComplete(Void r1) {
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޢ, reason: contains not printable characters */
    public class ViewOnClickListenerC0772 implements View.OnClickListener {
        public ViewOnClickListenerC0772() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1397 != 2) {
                SettingActivity.this.f1397 = 2;
                C2618.m9571("setting_tab_state_sp", SettingActivity.this.f1397);
                SettingActivity.this.m1828();
                SettingActivity.this.changeContent();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޣ, reason: contains not printable characters */
    public class ViewOnClickListenerC0773 implements View.OnClickListener {
        public ViewOnClickListenerC0773() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1389.f13806.m4006() || SettingActivity.this.f1397 == 3) {
                return;
            }
            SettingActivity.this.f1397 = 3;
            C2618.m9571("setting_tab_state_sp", SettingActivity.this.f1397);
            SettingActivity.this.m1828();
            SettingActivity.this.changeContent();
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޤ, reason: contains not printable characters */
    public class ViewOnClickListenerC0774 implements View.OnClickListener {
        public ViewOnClickListenerC0774() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1389.f13806.m4006() || SettingActivity.this.f1397 == 4) {
                return;
            }
            SettingActivity.this.f1397 = 4;
            C2618.m9571("setting_tab_state_sp", SettingActivity.this.f1397);
            SettingActivity.this.m1828();
            SettingActivity.this.changeContent();
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޥ, reason: contains not printable characters */
    public class ViewOnClickListenerC0775 implements View.OnClickListener {
        public ViewOnClickListenerC0775() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1397 != 5) {
                SettingActivity.this.f1397 = 5;
                C2618.m9571("setting_tab_state_sp", SettingActivity.this.f1397);
                SettingActivity.this.m1828();
                SettingActivity.this.changeContent();
            }
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$ޱ, reason: contains not printable characters */
    public class ViewOnClickListenerC0776 implements View.OnClickListener {
        public ViewOnClickListenerC0776() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingActivity.this.f1389.f13806.m4006()) {
                return;
            }
            SettingActivity.this.m1802();
        }
    }

    /* renamed from: com.blink.academy.film.setting.SettingActivity$߾, reason: contains not printable characters */
    public static class ViewOnTouchListenerC0777 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f1513;

        /* renamed from: com.blink.academy.film.setting.SettingActivity$߾$Ϳ, reason: contains not printable characters */
        public class RunnableC0778 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f1514;

            public RunnableC0778(View view) {
                this.f1514 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f1514.isEnabled()) {
                    ViewOnTouchListenerC0777.this.f1513.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0777(View view) {
            this.f1513 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f1513.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0778(view), 100L);
            return false;
        }
    }

    public final void changeContent() {
        int i = this.f1397;
        if (i == 0) {
            this.f1389.f13812.m4051();
            this.f1389.f13812.setVisibility(0);
            this.f1389.f13806.setVisibility(8);
            this.f1389.f13799.setVisibility(8);
            this.f1389.f13794.setVisibility(8);
            this.f1389.f13811.setVisibility(8);
            this.f1389.f13810.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.f1389.f13799.m3924();
            this.f1389.f13799.setVisibility(0);
            this.f1389.f13806.setVisibility(8);
            this.f1389.f13812.setVisibility(8);
            this.f1389.f13794.setVisibility(8);
            this.f1389.f13811.setVisibility(8);
            this.f1389.f13810.setVisibility(8);
            return;
        }
        if (i == 2) {
            this.f1389.f13806.setVisibility(0);
            this.f1389.f13812.setVisibility(8);
            this.f1389.f13799.setVisibility(8);
            this.f1389.f13794.setVisibility(8);
            this.f1389.f13811.setVisibility(8);
            this.f1389.f13810.setVisibility(8);
            return;
        }
        if (i == 3) {
            this.f1389.f13794.m4095();
            this.f1389.f13794.setVisibility(0);
            this.f1389.f13806.setVisibility(8);
            this.f1389.f13812.setVisibility(8);
            this.f1389.f13799.setVisibility(8);
            this.f1389.f13811.setVisibility(8);
            this.f1389.f13810.setVisibility(8);
            return;
        }
        if (i == 4) {
            this.f1389.f13806.setVisibility(8);
            this.f1389.f13812.setVisibility(8);
            this.f1389.f13799.setVisibility(8);
            this.f1389.f13794.setVisibility(8);
            this.f1389.f13811.setVisibility(8);
            this.f1389.f13810.setVisibility(0);
            return;
        }
        if (i != 5) {
            return;
        }
        this.f1389.f13806.setVisibility(8);
        this.f1389.f13812.setVisibility(8);
        this.f1389.f13799.setVisibility(8);
        this.f1389.f13794.setVisibility(8);
        this.f1389.f13811.setVisibility(0);
        this.f1389.f13810.setVisibility(8);
        m1816();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public final void initListener() {
        this.f1389.f13820.setOnClickListener(new ViewOnClickListenerC0753());
        this.f1389.f13817.setOnClickListener(new ViewOnClickListenerC0770());
        this.f1389.f13818.setOnClickListener(new ViewOnClickListenerC0772());
        this.f1389.f13816.setOnClickListener(new ViewOnClickListenerC0773());
        this.f1389.f13819.setOnClickListener(new ViewOnClickListenerC0774());
        this.f1389.f13821.setOnClickListener(new ViewOnClickListenerC0775());
        this.f1389.f13796.setOnClickListener(new ViewOnClickListenerC0776());
        AbstractC3964 abstractC3964 = this.f1389;
        abstractC3964.f13796.setOnTouchListener(new ViewOnTouchListenerC0777(abstractC3964.f13797));
        this.f1389.f13818.setOnTouchListener(new ViewOnTouchListenerC0691());
        this.f1389.f13817.setOnTouchListener(new ViewOnTouchListenerC0693());
        this.f1389.f13820.setOnTouchListener(new ViewOnTouchListenerC0695());
        this.f1389.f13816.setOnTouchListener(new ViewOnTouchListenerC0697());
        this.f1389.f13819.setOnTouchListener(new ViewOnTouchListenerC0699());
        this.f1389.f13821.setOnTouchListener(new ViewOnTouchListenerC0701());
        this.f1389.f13798.setOnButtonClick(new C0703());
        this.f1389.f13801.setOnButtonClick(new C0704());
        this.f1389.f13800.setOnClickEvent(new C0707());
        this.f1389.f13809.setOnCallback(new C0713());
        this.f1389.f13812.setOnCallback(new C0725());
        this.f1389.f13799.setOnButtonClick(new C0726());
        this.f1389.f13794.setOnButtonClick(new C0727());
        this.f1389.f13794.setOnPageCallback(new C0728());
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.f1389.f13806.setOnButtonClick(new C0729(Math.min(point.x, point.y)));
        this.f1389.f13815.setPortrait(false);
        C4689.m14213(this).m14230(false);
        this.f1389.f13815.setOnSubscribeDialogListener(new C0732());
        this.f1389.f13810.setOnClickListener(new C0733());
        this.f1389.f13811.setOnClickListener(new C0734());
        this.f1389.f13795.setOnClickListener(new ViewOnClickListenerC0735());
        this.f1389.f13795.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f1391 = false;
        if (i2 == -1 && i == 101) {
            m1817(intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f1389.f13798.getAlpha() == 1.0f) {
            m1807();
        } else {
            m1802();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1390 = false;
        C3088.m10679().mo10680(this);
        C4567.m14006().m14021(new C0687());
        c9.m219().m235(new C0719());
        C4792.m14375().m14466(getWindow().getDecorView(), this);
        this.f1389 = (AbstractC3964) DataBindingUtil.setContentView(this, R.layout.activity_setting);
        this.f1397 = C2618.m9566("setting_tab_state_sp", 5);
        m1808();
        initListener();
        m1828();
        changeContent();
        C4628.m14086().m14088();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c9.m219().m235(null);
        C4567.m14006().m14021(null);
        C3703 c3703 = this.f1400;
        if (c3703 != null) {
            c3703.m11873();
        }
        C2772 c2772 = this.f1401;
        if (c2772 != null) {
            c2772.m10061();
        }
        C4757.m14304().m14309();
        C4689.m14213(this).m14221();
        C3617.m11671(this).m11672();
        C4628.m14086().m14090();
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (HomeActivity.m700() == null || this.f1396) {
            return;
        }
        HomeActivity.m700().m1046();
        this.f1395 = true;
        HomeActivity.m700().m1100();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        int i2 = 0;
        if (i == 101) {
            while (i2 < strArr.length) {
                if (iArr[i2] == -1) {
                    this.f1392++;
                    if (strArr[i2].equals("android.permission.ACCESS_FINE_LOCATION")) {
                        m1819(11, null);
                        return;
                    }
                    return;
                }
                i2++;
            }
            return;
        }
        if (i != 102 && i != 103) {
            if (i != 10001 || iArr[0] == 0 || ActivityCompat.shouldShowRequestPermissionRationale(this, strArr[0])) {
                return;
            }
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            intent.addFlags(65536);
            startActivity(intent);
            return;
        }
        while (i2 < strArr.length) {
            if (iArr[i2] == -1) {
                this.f1392++;
                return;
            }
            i2++;
        }
        if (this.f1392 == 0) {
            if (i == 102) {
                m1818();
                this.f1389.f13794.m4090();
            } else if (i == 103) {
                m1822();
                this.f1389.f13794.m4091();
            }
        }
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() throws Resources.NotFoundException {
        super.onResume();
        m1814();
        m1816();
        C3617.m11670();
        SubscribeDialog subscribeDialog = this.f1389.f13815;
        if (subscribeDialog != null) {
            subscribeDialog.m2589();
        }
        ProtakeSignInSettingView protakeSignInSettingView = this.f1389.f13811;
        if (protakeSignInSettingView != null) {
            protakeSignInSettingView.m4034();
        }
        if (!e5.m5988().m5993()) {
            C4628.m14086().m14089(this);
        }
        this.f1396 = false;
        if (HomeActivity.m700() == null || !this.f1395) {
            return;
        }
        DecoderParamsBean decoderParamsBean = new DecoderParamsBean();
        if (ACHelper.getInstance().getSelectDecoderParamsBean() != null) {
            ACHelper.getInstance().copyDecodeParamBean(ACHelper.getInstance().getSelectDecoderParamsBean(), decoderParamsBean);
        } else {
            DecoderParamsBean decoderParamsBean2 = new DecoderParamsBean(2130708361, 2000000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
            DecoderParamsBean decoderParamsBean3 = new DecoderParamsBean(2130708361, 3000000, 30, 1, DPXReader.TVINFO_OFFSET, 1080, "video/hevc");
            if (C2618.m9566("transmit_quality_type", 1) == 1) {
                ACHelper.getInstance().copyDecodeParamBean(decoderParamsBean2, decoderParamsBean);
            } else {
                ACHelper.getInstance().copyDecodeParamBean(decoderParamsBean3, decoderParamsBean);
            }
        }
        HomeActivity.m700().m1043(decoderParamsBean);
        this.f1395 = false;
        HomeActivity.m700().m1161();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m462();
            m1823();
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public final void m1798() throws Resources.NotFoundException {
        this.f1401.m10064();
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m1799(boolean z, TextView textView) {
        if (z) {
            textView.setBackgroundColor(Color.parseColor("#ffffff"));
            textView.setTextColor(Color.parseColor("#000000"));
        } else {
            textView.setBackgroundColor(Color.parseColor("#000000"));
            textView.setTextColor(Color.parseColor("#ffffff"));
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public final boolean m1800() {
        return e5.m5988().m5993() && C2618.m9565("location__bool_info_sp", false);
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public final void m1801(int i) {
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
        C4757.m14304().m14315(this, i, str, access_token, subscribeInfoCallbackM7605.getSubscription_product_id(), subscribeInfoCallbackM7605.getSub_gplay_id(), subscribeInfoCallbackM7605.getSub_hms_id(), new C0745(i));
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m1802() {
        if (this.f1402) {
            return;
        }
        this.f1402 = true;
        this.f1396 = true;
        C4008.m12876(this.f1389.f13814, 0.0f, 200, new C0762());
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m1803() {
        m462();
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public final String m1804(C3891 c3891) {
        return (!c3891.m12495() || c3891.m12381()) ? "AE" : "ME";
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final String m1805(C3891 c3891) {
        return (!c3891.m12495() || c3891.m12412() < 0.0f || c3891.m12412() > 1.0f) ? "AF" : "MF";
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public int m1806(int i) {
        return C4792.m14375().m14477(i, this.f1393);
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public final void m1807() {
        C4008.m12876(this.f1389.f13798, 0.0f, 100, new C0752());
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public final void m1808() {
        this.f1399 = C2579.m9440(this);
        int iM9444 = C2579.m9444();
        ViewGroup.LayoutParams layoutParams = this.f1389.f13813.getLayoutParams();
        layoutParams.width = iM9444;
        layoutParams.height = C2579.m9445();
        this.f1389.f13813.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f1389.f13823.getLayoutParams();
        layoutParams2.width = C2579.m9444();
        layoutParams2.height = (int) ((C2579.m9445() - C2579.m9440(this)) / 2.0f);
        this.f1389.f13823.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f1389.f13805.getLayoutParams();
        float fM14471 = C4792.m14375().m14471();
        this.f1393 = fM14471;
        layoutParams3.height = (int) (this.f1399 * 0.14477211f * fM14471);
        this.f1389.f13805.setLayoutParams(layoutParams3);
        this.f1389.f13818.setTypeface(FilmApp.m404());
        this.f1389.f13820.setTypeface(FilmApp.m404());
        this.f1389.f13817.setTypeface(FilmApp.m404());
        this.f1389.f13816.setTypeface(FilmApp.m404());
        this.f1389.f13819.setTypeface(FilmApp.m404());
        this.f1389.f13821.setTypeface(FilmApp.m404());
        this.f1389.f13820.setTextSize(0, C4792.m14375().m14381());
        this.f1389.f13818.setTextSize(0, C4792.m14375().m14381());
        this.f1389.f13817.setTextSize(0, C4792.m14375().m14381());
        this.f1389.f13816.setTextSize(0, C4792.m14375().m14381());
        this.f1389.f13819.setTextSize(0, C4792.m14375().m14381());
        this.f1389.f13821.setTextSize(0, C4792.m14375().m14381());
        int iM14386 = (int) ((C4792.m14375().m14386() * this.f1393) + 0.5f);
        this.f1389.f13818.setPadding(iM14386, 0, iM14386, 0);
        this.f1389.f13820.setPadding(iM14386, 0, iM14386, 0);
        this.f1389.f13817.setPadding(iM14386, 0, iM14386, 0);
        this.f1389.f13816.setPadding(iM14386, 0, iM14386, 0);
        this.f1389.f13819.setPadding(iM14386, 0, iM14386, 0);
        this.f1389.f13821.setPadding(iM14386, 0, iM14386, 0);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) this.f1389.f13803.getLayoutParams();
        layoutParams4.width = (int) (m1806(60) * this.f1393);
        layoutParams4.height = (int) (m1806(60) * this.f1393);
        layoutParams4.rightMargin = (int) ((iM14386 - layoutParams4.width) / 2.0f);
        this.f1389.f13803.setLayoutParams(layoutParams4);
        this.f1389.f13804.setLayoutParams(layoutParams4);
        this.f1389.f13802.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f1389.f13797.getLayoutParams();
        int i = this.f1399;
        layoutParams5.width = (int) (i * 0.044235926f);
        layoutParams5.height = (int) (i * 0.044235926f);
        layoutParams5.rightMargin = C4792.m14375().m14468();
        this.f1389.f13797.setLayoutParams(layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f1389.f13796.getLayoutParams();
        int i2 = layoutParams3.height;
        layoutParams6.width = i2;
        layoutParams6.height = i2;
        layoutParams6.rightMargin = layoutParams5.rightMargin - ((i2 - layoutParams5.width) / 2);
        this.f1389.f13796.setLayoutParams(layoutParams6);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f1389.f13822.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = (int) ((C2579.f9594 - C2579.m9440(this)) / 2.0f);
        this.f1389.f13822.setLayoutParams(layoutParams7);
        int iM9440 = C2579.f9593 - C2579.m9440(this);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f1389.f13815.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = layoutParams3.height + layoutParams2.height;
        this.f1389.f13815.setLayoutParams(layoutParams8);
        this.f1389.f13815.setVertical(iM9440);
        this.f1400 = new C3703(this, new DialogInterfaceOnDismissListenerC0754(), new C0755(), false, true, new C0757());
        this.f1401 = new C2772(this, new DialogInterfaceOnDismissListenerC0758(), new C0759(), false);
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m1809(boolean z) {
        if (n.m7588().m7605() == null) {
            if (z) {
                this.f1389.f13815.m2594(false);
                return;
            } else {
                this.f1389.f13811.m4039(false);
                return;
            }
        }
        if (C4843.m14569().m14572() && C4843.m14569().m14571()) {
            m1821(true, z);
        } else {
            m1811(C4843.m14569().m14570() != 1 ? 2 : 1);
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m1810(boolean z) {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (userBeanM5990 == null || userBeanM5990.getIs_subscription_user()) {
            FilmApp.m405().m427(new RunnableC0769(z));
            return;
        }
        CachePlayStoreBean cachePlayStoreBeanM11747 = C3659.m11744().m11747();
        CacheHuaweiBean cacheHuaweiBeanM11746 = C3659.m11744().m11746();
        if (cachePlayStoreBeanM11747 == null) {
            if (cacheHuaweiBeanM11746 != null) {
                PayController.queryHuaweiOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), HuaweiPay.generateHuaweiJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), cacheHuaweiBeanM11746.getInAppPurchaseData(), cacheHuaweiBeanM11746.getInAppSignature()), new C0766(z));
                return;
            }
            return;
        }
        Purchase purchase = cachePlayStoreBeanM11747.getPurchase();
        PayController.queryPlayStoreOrder(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), GooglePayHelper.generateGoogleJson(userBeanM5990.getId() + "", userBeanM5990.getAccess_token(), purchase.getOriginalJson(), purchase.getSignature()), new C0763(z));
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m1811(int i) {
        SubscribeInfoCallback subscribeInfoCallbackM7605 = n.m7588().m7605();
        C4757.m14304().m14323(i, this, subscribeInfoCallbackM7605.getSub_gplay_id(), subscribeInfoCallbackM7605.getSub_hms_id(), new C0736(subscribeInfoCallbackM7605));
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m1812(boolean z) {
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
        C3608.m11650().m11653(str2, str, new C0751(z));
        e5.m5988().m5995();
        this.f1390 = true;
        m1828();
        changeContent();
        m1816();
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public final void m1813() {
        if (this.f1400 != null) {
            C3617.m11671(this).m11675();
            this.f1400.m11874(new C0749());
        }
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public void m1814() {
        if (m1800()) {
            this.f1389.f13803.setVisibility(8);
            this.f1389.f13804.setVisibility(8);
            this.f1389.f13802.setVisibility(8);
            this.f1389.f13817.setAlpha(1.0f);
            this.f1389.f13818.setAlpha(1.0f);
            this.f1389.f13816.setAlpha(1.0f);
            this.f1389.f13815.setVisibility(8);
            if (this.f1397 == 5) {
                this.f1397 = 4;
                changeContent();
            }
            this.f1389.f13821.setVisibility(8);
            this.f1389.f13819.setVisibility(0);
            return;
        }
        this.f1389.f13803.setVisibility(0);
        this.f1389.f13804.setVisibility(0);
        this.f1389.f13802.setVisibility(0);
        if (this.f1397 == 4) {
            this.f1397 = 5;
            changeContent();
        }
        this.f1389.f13821.setVisibility(0);
        this.f1389.f13819.setVisibility(8);
        int i = this.f1397;
        if (i == 1) {
            this.f1389.f13815.setVisibility(0);
            this.f1389.f13815.m2588();
            this.f1389.f13817.setAlpha(1.0f);
            this.f1389.f13818.setAlpha(0.3f);
            this.f1389.f13816.setAlpha(0.3f);
            return;
        }
        if (i == 2) {
            this.f1389.f13815.setVisibility(0);
            this.f1389.f13815.m2588();
            this.f1389.f13817.setAlpha(0.3f);
            this.f1389.f13818.setAlpha(1.0f);
            this.f1389.f13816.setAlpha(0.3f);
            return;
        }
        if (i != 3) {
            this.f1389.f13815.setVisibility(8);
            this.f1389.f13817.setAlpha(0.3f);
            this.f1389.f13818.setAlpha(0.3f);
            this.f1389.f13816.setAlpha(0.3f);
            return;
        }
        this.f1389.f13815.setVisibility(0);
        this.f1389.f13815.m2588();
        this.f1389.f13817.setAlpha(0.3f);
        this.f1389.f13818.setAlpha(0.3f);
        this.f1389.f13816.setAlpha(1.0f);
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m1815() {
        String access_token;
        UserBean userBeanM5990 = e5.m5988().m5990();
        String str = "";
        if (userBeanM5990 != null) {
            str = userBeanM5990.getId() + "";
            access_token = userBeanM5990.getAccess_token();
        } else {
            access_token = "";
        }
        C3608.m11650().m11659(str, access_token, new C0747());
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public final void m1816() {
        UserBean userBeanM5990 = e5.m5988().m5990();
        if (r1.m8142(userBeanM5990)) {
            this.f1389.f13810.m4025(userBeanM5990.getUser_phone_zone(), C2618.m9569("user_login_phone_sp", ""), userBeanM5990.getSubscription_expire_time());
        } else if (e5.m5988().m5993()) {
            this.f1389.f13810.m4025("", "", C3659.m11744().m11748());
        } else {
            this.f1389.f13810.m4025("", "", 0L);
        }
        SubscribeDialog subscribeDialog = this.f1389.f13815;
        if (subscribeDialog != null) {
            subscribeDialog.setSignState(e5.m5988().m5994());
            this.f1389.f13815.m2590();
        }
        ProtakeSignInSettingView protakeSignInSettingView = this.f1389.f13811;
        if (protakeSignInSettingView != null) {
            protakeSignInSettingView.setSignState(e5.m5988().m5994());
            this.f1389.f13811.m4035();
        }
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public final void m1817(@Nullable Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            C4535.m13880().m13883(C4535.m13880().m13884((QrCodeBean) intent.getParcelableExtra("qr_result")));
            this.f1389.f13806.m4013(1);
        } catch (Exception e2) {
            C4638.m14100("setPresetFromQrCode: " + e2.getMessage());
        }
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m1818() {
        if (!C2749.m10008(FilmApp.m402())) {
            m1819(12, null);
            this.f1389.f13794.m4095();
            C4638.m14099(f1388, "Please grant location permissions ");
        } else {
            this.f1389.f13800.setAlpha(0.0f);
            this.f1389.f13800.setVisibility(0);
            this.f1389.f13800.m2895();
            C4008.m12876(this.f1389.f13800, 1.0f, 100, null);
        }
    }

    /* renamed from: ࡡ, reason: contains not printable characters */
    public final void m1819(int i, C3891 c3891) {
        this.f1389.f13801.setVisibility(0);
        this.f1389.f13801.setAlpha(0.0f);
        this.f1389.f13801.m2908(i, c3891);
        C4008.m12876(this.f1389.f13801, 1.0f, 100, null);
    }

    /* renamed from: ࡢ, reason: contains not printable characters */
    public final void m1820() {
        C4689.m14213(this).m14232(this, new C0742());
    }

    /* renamed from: ࡣ, reason: contains not printable characters */
    public final void m1821(boolean z, boolean z2) {
        C4689.m14213(this).m14233(new C0743(z), new C0744(z2));
    }

    /* renamed from: ࡤ, reason: contains not printable characters */
    public final void m1822() {
        if (!C2749.m10008(FilmApp.m402())) {
            m1819(31, null);
            this.f1389.f13794.m4094();
        } else {
            this.f1389.f13809.setAlpha(0.0f);
            this.f1389.f13809.setVisibility(0);
            this.f1389.f13809.m2921();
            C4008.m12876(this.f1389.f13809, 1.0f, 100, null);
        }
    }

    /* renamed from: ࡥ, reason: contains not printable characters */
    public final void m1823() {
        this.f1389.f13813.postDelayed(new RunnableC0761(), 300L);
    }

    /* renamed from: ࡦ, reason: contains not printable characters */
    public final void m1824(boolean z) {
        ViewGroup.LayoutParams layoutParams = this.f1389.f13807.getLayoutParams();
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
        this.f1389.f13807.setLayoutParams(layoutParams);
        this.f1389.f13808.m2984(layoutParams.width, layoutParams.height);
        this.f1389.f13808.setShowType(C5213.m15215() ? 1 : 0);
        this.f1389.f13808.m2985(new C0739(z));
        this.f1389.f13795.setVisibility(0);
        this.f1389.f13807.setAlpha(0.0f);
        this.f1389.f13807.setVisibility(0);
        C4008.m12876(this.f1389.f13807, 1.0f, 100, null);
    }

    /* renamed from: ࡧ, reason: contains not printable characters */
    public final void m1825() {
        m1819(18, null);
    }

    /* renamed from: ࡨ, reason: contains not printable characters */
    public final void m1826(boolean z) {
        MobSDK.submitPolicyGrantResult(z, new C0771());
    }

    /* renamed from: ࡩ, reason: contains not printable characters */
    public final void m1827() {
        boolean zM5994 = e5.m5988().m5994();
        if (zM5994) {
            if (!zM5994 || r1.m8137(n.m7588().m7605())) {
                return;
            }
            m1820();
            return;
        }
        if (FilmApp.m405().m430()) {
            m1824(true);
            return;
        }
        m1826(true);
        this.f1394 = 2;
        this.f1400.m11880(true);
    }

    /* renamed from: ࡪ, reason: contains not printable characters */
    public final void m1828() {
        m1814();
        int i = this.f1397;
        if (i == 0) {
            m1799(true, this.f1389.f13820);
            m1799(false, this.f1389.f13817);
            m1799(false, this.f1389.f13818);
            m1799(false, this.f1389.f13816);
            m1799(false, this.f1389.f13819);
            m1799(false, this.f1389.f13821);
            return;
        }
        if (i == 1) {
            m1799(false, this.f1389.f13820);
            m1799(true, this.f1389.f13817);
            m1799(false, this.f1389.f13818);
            m1799(false, this.f1389.f13816);
            m1799(false, this.f1389.f13819);
            m1799(false, this.f1389.f13821);
            return;
        }
        if (i == 2) {
            m1799(false, this.f1389.f13820);
            m1799(false, this.f1389.f13817);
            m1799(true, this.f1389.f13818);
            m1799(false, this.f1389.f13816);
            m1799(false, this.f1389.f13819);
            m1799(false, this.f1389.f13821);
            return;
        }
        if (i == 3) {
            m1799(false, this.f1389.f13820);
            m1799(false, this.f1389.f13817);
            m1799(false, this.f1389.f13818);
            m1799(true, this.f1389.f13816);
            m1799(false, this.f1389.f13819);
            m1799(false, this.f1389.f13821);
            return;
        }
        if (i == 4) {
            m1799(false, this.f1389.f13820);
            m1799(false, this.f1389.f13817);
            m1799(false, this.f1389.f13818);
            m1799(false, this.f1389.f13816);
            m1799(true, this.f1389.f13819);
            m1799(false, this.f1389.f13821);
            return;
        }
        if (i != 5) {
            return;
        }
        m1799(false, this.f1389.f13820);
        m1799(false, this.f1389.f13817);
        m1799(false, this.f1389.f13818);
        m1799(false, this.f1389.f13816);
        m1799(false, this.f1389.f13819);
        m1799(true, this.f1389.f13821);
    }

    /* renamed from: ࢠ, reason: contains not printable characters */
    public final void m1829() {
        m1819(29, null);
    }
}
