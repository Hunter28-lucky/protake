package com.blink.academy.film;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.base.BaseActivity;
import com.blink.academy.film.home.HomeActivity;
import com.blink.academy.film.netbean.store.FilterBean;
import com.blink.academy.film.netbean.store.FilterGroupBean;
import com.blink.academy.film.netbean.store.FilterGroupCollectionBean;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.dialog.login.PrivacyLocalView;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import defpackage.AbstractC3966;
import defpackage.C2531;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2735;
import defpackage.C2813;
import defpackage.C3088;
import defpackage.C3180;
import defpackage.C3444;
import defpackage.C3641;
import defpackage.C3688;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4062;
import defpackage.C4112;
import defpackage.C4151;
import defpackage.C4450;
import defpackage.C4511;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.C5244;
import defpackage.r1;
import defpackage.x7;
import defpackage.y7;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.jcodec.codecs.mjpeg.JpegConst;

/* loaded from: classes.dex */
public class Splash2Activity extends BaseActivity {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3966 f363;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public RelativeLayout.LayoutParams f364;

    /* renamed from: ԭ, reason: contains not printable characters */
    public RelativeLayout f365;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f366;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f368;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f369;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f370;

    /* renamed from: ׯ, reason: contains not printable characters */
    public float f371;

    /* renamed from: ؠ, reason: contains not printable characters */
    public float f372;

    /* renamed from: އ, reason: contains not printable characters */
    public PrivacyLocalView f380;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f367 = false;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f373 = 45;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f374 = JpegConst.RST2;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f375 = 124;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f376 = 124;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f377 = 47;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f378 = 35;

    /* renamed from: ކ, reason: contains not printable characters */
    public String f379 = "permissionHasRequest";

    /* renamed from: com.blink.academy.film.Splash2Activity$Ϳ, reason: contains not printable characters */
    public class ViewTreeObserverOnGlobalLayoutListenerC0103 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ ViewTreeObserver f381;

        public ViewTreeObserverOnGlobalLayoutListenerC0103(ViewTreeObserver viewTreeObserver) {
            this.f381 = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f381.isAlive()) {
                this.f381.removeOnGlobalLayoutListener(this);
            }
            Splash2Activity.this.m456();
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$Ԩ, reason: contains not printable characters */
    public class C0104 implements ACHelper.OnDeviceInit {

        /* renamed from: com.blink.academy.film.Splash2Activity$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC0105 implements Runnable {
            public RunnableC0105() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C2813.f10275) {
                    Splash2Activity.this.f363.f13844.setAlpha(1.0f);
                } else {
                    Splash2Activity.this.f363.f13844.setAlpha(0.3f);
                }
            }
        }

        public C0104() {
        }

        @Override // com.blink.academy.film.stream.ACHelper.OnDeviceInit
        public void onInit() {
            FilmApp.m405().m427(new RunnableC0105());
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$Ԫ, reason: contains not printable characters */
    public class C0106 implements PrivacyLocalView.InterfaceC1081 {
        public C0106() {
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyLocalView.InterfaceC1081
        public void onDisagree() {
            Splash2Activity.this.m459(false);
            Splash2Activity.this.finish();
        }

        @Override // com.blink.academy.film.widgets.dialog.login.PrivacyLocalView.InterfaceC1081
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo460(boolean z) {
            Splash2Activity.this.f380.m2960();
            Splash2Activity.this.f365.setBackgroundColor(Splash2Activity.this.getColor(R.color.transparent));
            C2618.m9570("agree_first_use_sp", true);
            if (z) {
                C2618.m9571("privacy_alert_v_sp2", C2618.m9566("privacy_remote_v_sp", 1));
            } else {
                C2618.m9571("terms_alert_v_sp2", C2618.m9566("terms_remote_v_sp", 1));
            }
            FilmApp.f338 = false;
            FilmApp.m405().m412();
            FilmApp.m405().m413();
            FilmApp.m405().m411();
            FilmApp.m405().m415();
            FilmApp.m405().m414();
            FilmApp.m405().m418();
            x7 x7Var = new x7(System.currentTimeMillis(), Build.MANUFACTURER, Build.MODEL);
            y7.m8624().m8625();
            y7.m8624().m8627(x7Var);
            Splash2Activity.this.m459(true);
            Splash2Activity.this.m446();
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$Ԭ, reason: contains not printable characters */
    public class C0107 extends OperationCallback<Void> {
        public C0107() {
        }

        @Override // com.mob.OperationCallback
        public void onFailure(Throwable th) {
        }

        @Override // com.mob.OperationCallback
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void onComplete(Void r1) {
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$Ԯ, reason: contains not printable characters */
    public class RunnableC0108 implements Runnable {

        /* renamed from: com.blink.academy.film.Splash2Activity$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0109 implements Runnable {
            public RunnableC0109() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Splash2Activity.this.m457();
                Intent intent = new Intent(Splash2Activity.this, (Class<?>) HomeActivity.class);
                intent.addFlags(65536);
                Splash2Activity.this.startActivity(intent);
                Splash2Activity.this.finish();
                Splash2Activity.this.overridePendingTransition(0, 0);
            }
        }

        public RunnableC0108() {
        }

        @Override // java.lang.Runnable
        public void run() throws Resources.NotFoundException {
            long jCurrentTimeMillis = System.currentTimeMillis();
            C3641.m11713((CameraManager) FilmApp.m405().getSystemService("camera"));
            C3444.m11233("0");
            if (C4450.m13713(FilmApp.m405(), 390)) {
                C3180.m10790(new File(FilmApp.m405().getExternalFilesDir("assets"), "resource"));
                C4450.m13714(FilmApp.m405(), false, 390);
            }
            Splash2Activity.this.m450();
            long jCurrentTimeMillis2 = 300 - (System.currentTimeMillis() - jCurrentTimeMillis);
            if (jCurrentTimeMillis2 < 0) {
                jCurrentTimeMillis2 = 0;
            }
            FilmApp.m405().f341.postDelayed(new RunnableC0109(), jCurrentTimeMillis2);
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$ՠ, reason: contains not printable characters */
    public class C0110 extends TypeToken<List<FilterGroupBean>> {
        public C0110() {
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$ֈ, reason: contains not printable characters */
    public class C0111 extends TypeToken<List<FilterBean>> {
        public C0111() {
        }
    }

    /* renamed from: com.blink.academy.film.Splash2Activity$֏, reason: contains not printable characters */
    public class C0112 extends TypeToken<List<FilterGroupCollectionBean>> {
        public C0112() {
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        SplashScreen.installSplashScreen(this);
        super.onCreate(bundle);
        C3088.m10679().mo10680(this);
        C4792.m14375().m14466(getWindow().getDecorView(), this);
        this.f365 = new RelativeLayout(this);
        this.f364 = new RelativeLayout.LayoutParams(-1, -1);
        if (!FilmApp.m405().m431(true) || C2618.m9566("privacy_alert_v_sp2", 0) >= 1) {
            setContentView(this.f365, this.f364);
        } else {
            this.f363 = (AbstractC3966) DataBindingUtil.setContentView(this, R.layout.activity_splash);
            this.f365.setId(View.generateViewId());
            this.f363.f13861.addView(this.f365, this.f364);
            this.f365.setBackgroundColor(getColor(R.color.colorDiaBg));
        }
        ACHelper.getInstance().initCheck265();
        if (this.f363 != null) {
            m452();
            if (Build.VERSION.SDK_INT < 28 || C4792.m14375().m14497()) {
                return;
            }
            ViewTreeObserver viewTreeObserver = getWindow().getDecorView().getViewTreeObserver();
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserverOnGlobalLayoutListenerC0103(viewTreeObserver));
        }
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f366 = false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f366 = true;
        if (i == 101) {
            for (int i2 = 0; i2 < strArr.length && iArr[i2] != -1; i2++) {
            }
        }
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        int iWidth;
        int iM14444;
        super.onResume();
        C4638.m14099("slimmm", "isFirst:" + FilmApp.f338);
        if (!FilmApp.m405().m431(true) || C2618.m9566("privacy_alert_v_sp2", 0) >= 1) {
            m459(true);
            m446();
            return;
        }
        if (this.f380 == null) {
            PrivacyLocalView privacyLocalView = new PrivacyLocalView(this);
            this.f380 = privacyLocalView;
            privacyLocalView.setId(View.generateViewId());
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = ((WindowManager) getSystemService(WindowManager.class)).getCurrentWindowMetrics();
                iWidth = currentWindowMetrics.getBounds().width();
                iM14444 = currentWindowMetrics.getBounds().height();
            } else {
                Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                int i = point.x;
                int i2 = point.y;
                iWidth = i;
                iM14444 = i2;
            }
            if (C2579.m9451(FilmApp.m402())) {
                iM14444 = (int) (iWidth / C4792.m14375().m14444());
            }
            int i3 = (((int) ((iM14444 * 16.0f) / 9.0f)) >> 1) << 1;
            if (i3 > iWidth) {
                iM14444 = (((int) ((iWidth * 9.0f) / 16.0f)) >> 1) << 1;
            } else {
                iWidth = i3;
            }
            int iM9438 = ((int) (iM14444 * 0.7f)) + C2579.m9438(45.0f);
            int iM94382 = (int) (iWidth * 0.6f);
            if (iM94382 > iWidth - C2579.m9438(20.0f)) {
                iM94382 = iWidth - C2579.m9438(20.0f);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iM94382, iM9438);
            layoutParams.addRule(13);
            this.f380.setLayoutParams(layoutParams);
            this.f380.m2964(iM94382, iM9438);
            this.f365.addView(this.f380);
            this.f380.setShowType(0);
            this.f380.m2965(new C0106(), true);
            this.f380.m2960();
        }
        this.f380.m2966();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m462();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m446() {
        ArrayList arrayList = new ArrayList();
        if (!C4112.m13056()) {
            arrayList.add("android.permission.CAMERA");
        }
        if (!C4112.m13057()) {
            if (Build.VERSION.SDK_INT >= 33) {
                arrayList.add("android.permission.READ_MEDIA_IMAGES");
                arrayList.add("android.permission.READ_MEDIA_VIDEO");
            } else {
                arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            }
        }
        if (!C4112.m13055()) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        int size = arrayList.size();
        this.f366 = C2618.m9565(this.f379, false);
        if (size <= 0) {
            m453();
            return;
        }
        if (FilmApp.m405().m425()) {
            m453();
        } else if (this.f366) {
            m453();
        } else {
            ActivityCompat.requestPermissions(this, (String[]) arrayList.toArray(new String[size]), 101);
            C2618.m9570(this.f379, true);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean m447() {
        if (C2579.m9451(this)) {
            this.f368 = true;
        } else {
            this.f368 = C4792.m14375().m14484() >= 2.0f;
        }
        return this.f368;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final float m448() {
        float fM14476 = C2579.f9597 + (C4792.m14375().m14476(70) * 2);
        float fM9444 = C2579.m9444() - (C4792.m14375().m14442() * 2.0f);
        if (fM9444 < fM14476) {
            return fM9444 / fM14476;
        }
        return 1.0f;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public String m449(int i) {
        return getString(i).toUpperCase(Locale.US);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m450() {
        long jCurrentTimeMillis = this.f367 ? System.currentTimeMillis() : 0L;
        C5244 c5244M13180 = C4151.m13162().m13180();
        List<C2531> listM13179 = C4151.m13162().m13179();
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c5244M13180 != null) {
            String strM15270 = c5244M13180.m15270();
            String strM15267 = c5244M13180.m15267();
            String strM15269 = c5244M13180.m15269();
            Gson gson = new Gson();
            List<FilterGroupBean> list = (List) gson.fromJson(strM15270, new C0110().getType());
            List<FilterBean> list2 = (List) gson.fromJson(strM15267, new C0111().getType());
            List<FilterGroupCollectionBean> list3 = (List) gson.fromJson(strM15269, new C0112().getType());
            if (r1.m8144(list3)) {
                C4511.m13838().m13850(listM13179, c3891M13890, list, list2, list3, 0);
            }
        }
        if (this.f367) {
            C4638.m14101("WME", "time: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m451() {
        if (this.f363 == null) {
            return;
        }
        int iM14461 = C4792.m14375().m14461();
        if (iM14461 == 0) {
            float fM14462 = C4792.m14375().m14462();
            float f = this.f371;
            int i = (int) (fM14462 * f);
            int iM9438 = (int) ((this.f378 * this.f372 * f) + C2579.m9438(1.0f) + ((((int) ((this.f376 * this.f372) * this.f371)) - i) / 2));
            int iM14476 = C4792.m14375().m14476(70);
            iM14461 = (int) (((C2579.f9597 - (((int) (iM9438 + ((i - iM14476) / 2.0f))) * 2)) - (iM14476 * 2)) / 3.0f);
            C4792.m14375().m14510(iM14461);
        }
        if (!C2579.m9451(this)) {
            this.f363.f13853.setEnabled(true);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f363.f13851.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) ((this.f369 - C2579.m9439(this)) / 2.0f);
            ((ViewGroup.MarginLayoutParams) layoutParams).height = C2579.m9440(this);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this.f363.f13860);
            constraintSet.connect(this.f363.f13851.getId(), 2, 0, 2);
            constraintSet.applyTo(this.f363.f13860);
            this.f363.f13851.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f363.f13845.getLayoutParams();
            layoutParams2.width = C4792.m14375().m14476(70);
            layoutParams2.height = C4792.m14375().m14476(70);
            int iM14462 = (int) (C4792.m14375().m14462() * this.f371);
            layoutParams2.topMargin = (int) (((int) ((this.f378 * this.f372 * r6) + C2579.m9438(1.0f) + ((((int) ((this.f376 * this.f372) * this.f371)) - iM14462) / 2))) + ((iM14462 - layoutParams2.height) / 2.0f));
            this.f363.f13845.setLayoutParams(layoutParams2);
            int iM94382 = (int) ((C2579.m9438(44.0f) - layoutParams2.height) / 2.0f);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f363.f13846.getLayoutParams();
            layoutParams3.topMargin = layoutParams2.topMargin - iM94382;
            int iM94383 = C2579.m9438(44.0f);
            layoutParams3.width = iM94383;
            layoutParams3.height = iM94383;
            this.f363.f13846.setLayoutParams(layoutParams3);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f363.f13847.getLayoutParams();
            layoutParams4.width = layoutParams2.width;
            layoutParams4.height = layoutParams2.height;
            layoutParams4.bottomMargin = (int) ((C2579.f9597 / 2.0f) + (((r8 - (layoutParams2.topMargin * 2)) - (layoutParams2.height * 2)) / 6.0f));
            this.f363.f13847.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f363.f13848.getLayoutParams();
            layoutParams5.bottomMargin = layoutParams4.bottomMargin - iM94382;
            layoutParams5.width = layoutParams3.width;
            layoutParams5.height = layoutParams3.height;
            this.f363.f13848.setLayoutParams(layoutParams5);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.f363.f13841.getLayoutParams();
            layoutParams6.width = layoutParams2.width;
            layoutParams6.height = layoutParams2.height;
            layoutParams6.topMargin = layoutParams5.bottomMargin;
            this.f363.f13841.setLayoutParams(layoutParams6);
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.f363.f13854.getLayoutParams();
            layoutParams7.topMargin = layoutParams6.topMargin - iM94382;
            layoutParams7.width = layoutParams3.width;
            layoutParams7.height = layoutParams3.height;
            this.f363.f13854.setLayoutParams(layoutParams7);
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.f363.f13840.getLayoutParams();
            layoutParams8.width = layoutParams2.width;
            layoutParams8.height = layoutParams2.height;
            layoutParams8.bottomMargin = layoutParams2.topMargin;
            this.f363.f13840.setLayoutParams(layoutParams8);
            RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) this.f363.f13843.getLayoutParams();
            layoutParams9.bottomMargin = layoutParams8.bottomMargin - iM94382;
            layoutParams9.width = layoutParams3.width;
            layoutParams9.height = layoutParams3.height;
            this.f363.f13843.setLayoutParams(layoutParams9);
            RelativeLayout.LayoutParams layoutParams10 = (RelativeLayout.LayoutParams) this.f363.f13852.getLayoutParams();
            layoutParams10.width = C4792.m14375().m14476(70);
            layoutParams10.height = C4792.m14375().m14476(70);
            layoutParams10.bottomMargin = (int) (layoutParams2.topMargin + ((layoutParams2.height - r2) / 2.0f));
            this.f363.f13852.setLayoutParams(layoutParams10);
            RelativeLayout.LayoutParams layoutParams11 = (RelativeLayout.LayoutParams) this.f363.f13853.getLayoutParams();
            layoutParams11.bottomMargin = (int) (layoutParams10.bottomMargin - ((C2579.m9438(44.0f) - layoutParams10.height) / 2.0f));
            layoutParams11.width = layoutParams3.width;
            layoutParams11.height = layoutParams3.height;
            this.f363.f13853.setLayoutParams(layoutParams11);
            return;
        }
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f363.f13851.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = C2579.f9594;
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (((this.f370 - C2579.m9440(this)) / 2.0f) - 0);
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(this.f363.f13860);
        constraintSet2.connect(this.f363.f13851.getId(), 4, 0, 4);
        constraintSet2.applyTo(this.f363.f13860);
        this.f363.f13851.setLayoutParams(layoutParams12);
        int iM144762 = (int) (C4792.m14375().m14476(70) * 1.0f);
        RelativeLayout.LayoutParams layoutParams13 = (RelativeLayout.LayoutParams) this.f363.f13845.getLayoutParams();
        layoutParams13.width = iM144762;
        layoutParams13.height = iM144762;
        layoutParams13.leftMargin = (int) (((C2579.m9444() - (iM144762 * 4)) - (iM14461 * 3)) / 2.0f);
        layoutParams13.addRule(9);
        layoutParams13.addRule(15);
        layoutParams13.removeRule(10);
        this.f363.f13845.setLayoutParams(layoutParams13);
        int iM94384 = (int) ((C2579.m9438(44.0f) - layoutParams13.width) / 2.0f);
        RelativeLayout.LayoutParams layoutParams14 = (RelativeLayout.LayoutParams) this.f363.f13846.getLayoutParams();
        layoutParams14.leftMargin = layoutParams13.leftMargin - iM94384;
        int iM94385 = C2579.m9438(44.0f);
        layoutParams14.width = iM94385;
        layoutParams14.height = iM94385;
        layoutParams14.addRule(9);
        layoutParams14.addRule(15);
        layoutParams14.removeRule(10);
        this.f363.f13846.setLayoutParams(layoutParams14);
        RelativeLayout.LayoutParams layoutParams15 = (RelativeLayout.LayoutParams) this.f363.f13847.getLayoutParams();
        layoutParams15.width = layoutParams13.width;
        layoutParams15.height = layoutParams13.height;
        layoutParams15.leftMargin = layoutParams13.leftMargin + layoutParams13.width + iM14461;
        layoutParams15.addRule(9);
        layoutParams15.addRule(15);
        layoutParams15.removeRule(12);
        this.f363.f13847.setLayoutParams(layoutParams15);
        RelativeLayout.LayoutParams layoutParams16 = (RelativeLayout.LayoutParams) this.f363.f13848.getLayoutParams();
        layoutParams16.leftMargin = layoutParams15.leftMargin - iM94384;
        layoutParams16.width = layoutParams14.width;
        layoutParams16.height = layoutParams14.height;
        layoutParams16.addRule(9);
        layoutParams16.addRule(15);
        layoutParams16.removeRule(12);
        this.f363.f13848.setLayoutParams(layoutParams16);
        RelativeLayout.LayoutParams layoutParams17 = (RelativeLayout.LayoutParams) this.f363.f13841.getLayoutParams();
        layoutParams17.width = layoutParams13.width;
        layoutParams17.height = layoutParams13.height;
        layoutParams17.rightMargin = layoutParams15.leftMargin;
        layoutParams17.addRule(11);
        layoutParams17.addRule(15);
        layoutParams17.removeRule(10);
        this.f363.f13841.setLayoutParams(layoutParams17);
        RelativeLayout.LayoutParams layoutParams18 = (RelativeLayout.LayoutParams) this.f363.f13854.getLayoutParams();
        layoutParams18.rightMargin = layoutParams17.rightMargin - iM94384;
        layoutParams18.width = layoutParams14.width;
        layoutParams18.height = layoutParams14.height;
        layoutParams18.addRule(11);
        layoutParams18.addRule(15);
        layoutParams18.removeRule(10);
        this.f363.f13854.setLayoutParams(layoutParams18);
        RelativeLayout.LayoutParams layoutParams19 = (RelativeLayout.LayoutParams) this.f363.f13840.getLayoutParams();
        layoutParams19.width = layoutParams13.width;
        layoutParams19.height = layoutParams13.height;
        layoutParams19.rightMargin = layoutParams13.leftMargin;
        layoutParams19.addRule(11);
        layoutParams19.addRule(15);
        layoutParams19.removeRule(12);
        this.f363.f13840.setLayoutParams(layoutParams19);
        RelativeLayout.LayoutParams layoutParams20 = (RelativeLayout.LayoutParams) this.f363.f13843.getLayoutParams();
        layoutParams20.rightMargin = layoutParams19.rightMargin - iM94384;
        layoutParams20.width = layoutParams14.width;
        layoutParams20.height = layoutParams14.height;
        layoutParams20.addRule(11);
        layoutParams20.addRule(15);
        layoutParams20.removeRule(12);
        this.f363.f13843.setLayoutParams(layoutParams20);
        RelativeLayout.LayoutParams layoutParams21 = (RelativeLayout.LayoutParams) this.f363.f13852.getLayoutParams();
        layoutParams21.width = iM144762;
        layoutParams21.height = iM144762;
        layoutParams21.rightMargin = layoutParams13.leftMargin;
        layoutParams21.addRule(11);
        layoutParams21.addRule(15);
        layoutParams21.removeRule(12);
        this.f363.f13852.setLayoutParams(layoutParams21);
        RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) this.f363.f13853.getLayoutParams();
        layoutParams22.rightMargin = (int) (layoutParams21.rightMargin - ((C2579.m9438(44.0f) - layoutParams21.width) / 2.0f));
        layoutParams22.width = layoutParams14.width;
        layoutParams22.height = layoutParams14.height;
        layoutParams22.addRule(11);
        layoutParams22.addRule(15);
        layoutParams22.removeRule(12);
        this.f363.f13853.setLayoutParams(layoutParams22);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m452() {
        if (this.f363 == null) {
            return;
        }
        this.f369 = C2579.m9443(this);
        this.f370 = C2579.m9442(this);
        this.f371 = C4792.m14375().m14434();
        this.f372 = C4792.m14375().m14455(1125.0f);
        int iM9439 = C2579.m9439(this);
        int iM9440 = C2579.m9440(this);
        int i = this.f369;
        if (iM9439 > i) {
            iM9440 = (((int) ((i * 9.0f) / 16.0f)) >> 1) << 1;
            iM9439 = i;
        }
        C2579.f9597 = iM9440;
        C2579.f9598 = iM9439;
        ViewGroup.LayoutParams layoutParams = this.f363.f13839.getLayoutParams();
        layoutParams.width = iM9439;
        layoutParams.height = iM9440;
        this.f363.f13839.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f363.f13831.getLayoutParams();
        layoutParams2.width = this.f369;
        layoutParams2.height = this.f370;
        this.f363.f13831.setLayoutParams(layoutParams2);
        this.f363.f13831.setAlpha(1.0f);
        ViewGroup.LayoutParams layoutParams3 = this.f363.f13842.getLayoutParams();
        layoutParams3.width = iM9439;
        layoutParams3.height = iM9440;
        this.f363.f13842.setLayoutParams(layoutParams3);
        this.f363.f13855.m2852();
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f363.f13857.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (C4792.m14375().m14453() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (C4792.m14375().m14453() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams4).rightMargin = (int) (C4792.m14375().m14454() * this.f371);
        layoutParams4.topToTop = this.f363.f13850.getId();
        layoutParams4.bottomToBottom = this.f363.f13850.getId();
        ((ViewGroup.MarginLayoutParams) layoutParams4).width = (int) (C4792.m14375().m14476(113) * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams4).height = (int) (C4792.m14375().m14476(113) * this.f371);
        int i2 = this.f374;
        ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f363.f13835.getLayoutParams();
        int iM14476 = (int) (C4792.m14375().m14476(i2) * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams5).height = iM14476;
        float f = i2;
        float f2 = 90.0f / f;
        ((ViewGroup.MarginLayoutParams) layoutParams5).width = (int) (iM14476 * f2);
        float f3 = 17.0f / f;
        int i3 = (int) (iM14476 * f3);
        ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = ((int) (this.f373 * this.f372)) + i3;
        float f4 = 35.0f / f;
        ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = (int) (iM14476 * f4);
        this.f363.f13835.setLayoutParams(layoutParams5);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams5).height;
        int i5 = (int) ((18.0f / f) * i4);
        int i6 = (int) ((4.0f / f) * i4);
        int iM144762 = (int) (((((ViewGroup.MarginLayoutParams) layoutParams5).width - (i5 * 2)) - C4792.m14375().m14476(12)) / 2.0f);
        float f5 = 13.0f / f;
        int i7 = ((ViewGroup.MarginLayoutParams) layoutParams5).height;
        int i8 = (int) (f5 * i7);
        this.f363.f13835.m2113(iM144762, i8, ((ViewGroup.MarginLayoutParams) layoutParams5).width - iM144762, i7 - i8, i5, i6);
        this.f363.f13835.m2114(-1.0f, -1.0f, false);
        ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f363.f13838.getLayoutParams();
        int i9 = ((ViewGroup.MarginLayoutParams) layoutParams5).height;
        ((ViewGroup.MarginLayoutParams) layoutParams6).height = i9;
        ((ViewGroup.MarginLayoutParams) layoutParams6).width = (int) (f2 * i9);
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = (int) (f3 * i9);
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = (int) (f4 * i9);
        this.f363.f13838.setLayoutParams(layoutParams6);
        this.f363.f13838.m2183(((ViewGroup.MarginLayoutParams) layoutParams6).width, ((ViewGroup.MarginLayoutParams) layoutParams6).height);
        this.f363.f13838.m2184("N/A", 0);
        this.f363.f13838.setBattery(100);
        ConstraintLayout.LayoutParams layoutParams7 = (ConstraintLayout.LayoutParams) this.f363.f13858.getLayoutParams();
        float f6 = this.f375;
        float f7 = this.f372;
        float f8 = this.f371;
        ((ViewGroup.MarginLayoutParams) layoutParams7).width = (int) (f6 * f7 * f8);
        ((ViewGroup.MarginLayoutParams) layoutParams7).height = (int) (this.f376 * f7 * f8);
        ((ViewGroup.MarginLayoutParams) layoutParams7).bottomMargin = (int) (this.f378 * f7 * f8);
        ((ViewGroup.MarginLayoutParams) layoutParams7).rightMargin = (int) (this.f377 * f7 * f8);
        this.f363.f13858.setLayoutParams(layoutParams7);
        this.f363.f13858.m2505(((ViewGroup.MarginLayoutParams) layoutParams7).width, ((ViewGroup.MarginLayoutParams) layoutParams7).height);
        FrameLayout.LayoutParams layoutParams8 = (FrameLayout.LayoutParams) this.f363.f13864.getLayoutParams();
        layoutParams8.width = (int) (C4792.m14375().m14462() * this.f371 * 0.9f);
        layoutParams8.height = (int) (C4792.m14375().m14462() * this.f371 * 0.9f);
        this.f363.f13864.setLayoutParams(layoutParams8);
        FrameLayout.LayoutParams layoutParams9 = (FrameLayout.LayoutParams) this.f363.f13863.getLayoutParams();
        layoutParams9.width = (int) (C4792.m14375().m14462() * this.f371 * 0.9f);
        layoutParams9.height = (int) (C4792.m14375().m14462() * this.f371 * 0.9f);
        this.f363.f13863.setLayoutParams(layoutParams9);
        int iM144763 = (int) (C4792.m14375().m14476(120) * this.f371);
        this.f363.f13849.setContentTextColor(-1);
        this.f363.f13849.m2562(0, C4792.m14375().m14384());
        this.f363.f13849.setContentTypeFace(FilmApp.m404());
        ConstraintLayout.LayoutParams layoutParams10 = (ConstraintLayout.LayoutParams) this.f363.f13849.getLayoutParams();
        TextPaint borderPaint = this.f363.f13849.getBorderPaint();
        float fMeasureText = borderPaint.measureText("00:00:00:00") + C4792.f16138;
        ((ViewGroup.MarginLayoutParams) layoutParams10).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin + ((int) ((iM144763 / 2.0f) - ((borderPaint.descent() - borderPaint.ascent()) / 2.0f)));
        this.f363.f13849.setLayoutParams(layoutParams10);
        this.f363.f13849.m2561("00:00:00:00");
        ConstraintLayout.LayoutParams layoutParams11 = (ConstraintLayout.LayoutParams) this.f363.f13850.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams11).height = iM144763;
        ((ViewGroup.MarginLayoutParams) layoutParams11).bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin;
        this.f363.f13850.setLayoutParams(layoutParams11);
        ConstraintLayout.LayoutParams layoutParams12 = (ConstraintLayout.LayoutParams) this.f363.f13834.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams12).width = (int) (C4792.m14375().m14432() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams12).height = (int) (C4792.m14375().m14432() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams12).rightMargin = (int) (C4792.m14375().m14433() * this.f371);
        layoutParams12.topToTop = this.f363.f13850.getId();
        layoutParams12.bottomToBottom = this.f363.f13850.getId();
        this.f363.f13834.setLayoutParams(layoutParams12);
        int iM14432 = C4792.m14375().m14432();
        int i10 = ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin + (((ViewGroup.MarginLayoutParams) layoutParams5).width * 2) + i3;
        ConstraintLayout.LayoutParams layoutParams13 = (ConstraintLayout.LayoutParams) this.f363.f13844.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams13).width = C2579.m9438(this.f371 * 50.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams13).height = iM14432;
        ((ViewGroup.MarginLayoutParams) layoutParams13).leftMargin = (int) (((i10 + ((((iM9439 - ((int) fMeasureText)) / 2) - i10) / 2)) - (r9 / 2)) + (C4792.f16138 / 2.0f));
        ((ViewGroup.MarginLayoutParams) layoutParams13).bottomMargin = (int) (((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin + ((iM144763 - C4792.m14375().m14476(63)) / 2.0f));
        this.f363.f13844.setLayoutParams(layoutParams13);
        float f9 = iM14432;
        this.f363.f13844.m4170(f9, f9);
        int i11 = !"Wi-Fi".equals(C3688.m11833(FilmApp.m402())) ? 1 : 0;
        if (!TransmitHelper.getInstance().isStartCameraTransmit()) {
            i11 = 0;
        }
        this.f363.f13844.m4159(i11);
        m455(false, 0, "", 5);
        ACHelper.getInstance().onCheck265Done(new C0104());
        ConstraintLayout.LayoutParams layoutParams14 = (ConstraintLayout.LayoutParams) this.f363.f13836.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams14).width = ((int) ((this.f375 * this.f372) * this.f371)) - C2579.m9438(2.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams14).height = ((int) ((this.f376 * this.f372) * this.f371)) - C2579.m9438(2.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams14).topMargin = ((int) (this.f378 * this.f372 * this.f371)) + C2579.m9438(1.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams14).rightMargin = ((int) (this.f377 * this.f372 * this.f371)) + C2579.m9438(1.0f);
        this.f363.f13836.setLayoutParams(layoutParams14);
        ViewGroup.LayoutParams layoutParams15 = this.f363.f13837.getLayoutParams();
        layoutParams15.width = (int) (((ViewGroup.MarginLayoutParams) layoutParams14).width * 0.6917293f);
        layoutParams15.height = (int) (((ViewGroup.MarginLayoutParams) layoutParams14).width * 0.6917293f);
        this.f363.f13837.setLayoutParams(layoutParams15);
        ConstraintLayout.LayoutParams layoutParams16 = (ConstraintLayout.LayoutParams) this.f363.f13862.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams16).width = (int) (C4792.m14375().m14462() * this.f371);
        float fM14462 = C4792.m14375().m14462();
        float f10 = this.f371;
        ((ViewGroup.MarginLayoutParams) layoutParams16).height = (int) (fM14462 * f10);
        ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin = (int) ((this.f378 * this.f372 * f10) + C2579.m9438(1.0f) + ((((int) ((this.f376 * this.f372) * this.f371)) - ((ViewGroup.MarginLayoutParams) layoutParams16).height) / 2));
        ((ViewGroup.MarginLayoutParams) layoutParams16).rightMargin = (int) (C4792.m14375().m14472() * this.f371);
        ConstraintLayout.LayoutParams layoutParams17 = (ConstraintLayout.LayoutParams) this.f363.f13856.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams17).width = (int) (C4792.m14375().m14462() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams17).height = (int) (C4792.m14375().m14462() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams17).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams17).rightMargin = (int) (C4792.m14375().m14445() * this.f371);
        this.f363.f13856.setLayoutParams(layoutParams17);
        this.f363.f13856.setAlpha(0.3f);
        ConstraintLayout.LayoutParams layoutParams18 = (ConstraintLayout.LayoutParams) this.f363.f13832.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams18).width = (int) (C4792.m14375().m14462() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams18).height = (int) (C4792.m14375().m14462() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams18).topMargin = ((ViewGroup.MarginLayoutParams) layoutParams16).topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams18).rightMargin = (int) (C4792.m14375().m14418() * this.f371);
        this.f363.f13832.setLayoutParams(layoutParams18);
        ConstraintLayout.LayoutParams layoutParams19 = (ConstraintLayout.LayoutParams) this.f363.f13829.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams19).width = (int) (C4792.m14375().m14403() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams19).height = (int) (C4792.m14375().m14403() * this.f371);
        ((ViewGroup.MarginLayoutParams) layoutParams19).rightMargin = (int) (C4792.m14375().m14418() + (((C4792.m14375().m14462() * this.f371) - ((ViewGroup.MarginLayoutParams) layoutParams19).width) / 2.0f));
        this.f363.f13829.setLayoutParams(layoutParams19);
        this.f363.f13829.setImageResource(R.drawable.icon_60_beauty_default);
        this.f363.f13829.setAlpha(0.3f);
        int i12 = ((ViewGroup.MarginLayoutParams) layoutParams18).rightMargin;
        int i13 = ((ViewGroup.MarginLayoutParams) layoutParams16).rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams16).rightMargin = i13 + i12 + (i12 - i13) + (((ViewGroup.MarginLayoutParams) layoutParams14).width / 2);
        this.f363.f13862.setLayoutParams(layoutParams16);
        ConstraintLayout.LayoutParams layoutParams20 = (ConstraintLayout.LayoutParams) this.f363.f13859.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams20).topMargin = C4792.m14375().m14460() - 10;
        ((ViewGroup.MarginLayoutParams) layoutParams20).leftMargin = C4792.m14375().m14459();
        int iM14420 = C4792.m14375().m14420();
        int iM14464 = C4792.m14375().m14464();
        this.f363.f13859.m2845(iM14420, 0, 0, 0);
        this.f363.f13859.setPadding(0, 10, iM14464, 10);
        this.f363.f13859.setTopTextContent(m449(R.string.RECORDING_INFO_RES));
        this.f363.f13859.setBottomTextContent("N/A");
        this.f363.f13833.m2845(iM14420, 0, 0, 0);
        this.f363.f13833.setPadding(0, 10, iM14464, 10);
        this.f363.f13833.setTopTextContent(m449(R.string.RECORDING_INFO_FPS));
        this.f363.f13833.setBottomTextContent("N/A");
        int iM144764 = C4792.m14375().m14476(50);
        int i14 = (this.f369 - iM9439) / 2;
        ConstraintLayout.LayoutParams layoutParams21 = (ConstraintLayout.LayoutParams) this.f363.f13830.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams21).height = this.f370;
        ((ViewGroup.MarginLayoutParams) layoutParams21).width = ((int) (C4792.m14375().m14476(C4792.m14375().m14488() + 262) * this.f371 * 1.3f)) + iM144764 + i14;
        this.f363.f13830.setLayoutParams(layoutParams21);
        FrameLayout.LayoutParams layoutParams22 = (FrameLayout.LayoutParams) this.f363.f13828.getLayoutParams();
        int iM144765 = (int) (C4792.m14375().m14476((C4792.m14375().m14488() * 2) + 620) * this.f371);
        int i15 = (int) (((iM144765 + (iM144765 % 2)) * 1.2f) + 0.5f);
        layoutParams22.width = i15;
        layoutParams22.height = i15;
        layoutParams22.leftMargin = iM144764 + ((int) (C4792.m14375().m14476(70) * 1.2f * this.f371));
        this.f363.f13828.setLayoutParams(layoutParams22);
        this.f363.f13828.setCardWidth(((ViewGroup.MarginLayoutParams) layoutParams21).width);
        this.f363.f13828.m3222(((ViewGroup.MarginLayoutParams) layoutParams21).width - layoutParams22.leftMargin, (C2579.f9594 - iM9439) / 2, (int) (this.f375 * this.f372 * this.f371));
        this.f363.f13828.setNeedCheckMag(true);
        this.f363.f13828.m3224();
        this.f363.f13828.m3226(0);
        C4008.m12884(this.f363.f13828, 1.3f, 1.3f, 0, null);
        if (!m447()) {
            this.f363.f13851.setVisibility(8);
            return;
        }
        this.f363.f13851.setVisibility(0);
        m451();
        m454();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m453() {
        new Thread(new RunnableC0108()).start();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m454() {
        AbstractC3966 abstractC3966 = this.f363;
        if (abstractC3966 == null) {
            return;
        }
        m458(abstractC3966.f13841, abstractC3966.f13854, false);
        AbstractC3966 abstractC39662 = this.f363;
        m458(abstractC39662.f13845, abstractC39662.f13846, false);
        AbstractC3966 abstractC39663 = this.f363;
        m458(abstractC39663.f13847, abstractC39663.f13848, false);
        AbstractC3966 abstractC39664 = this.f363;
        m458(abstractC39664.f13852, abstractC39664.f13853, false);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m455(boolean z, int i, String str, int i2) {
        AbstractC3966 abstractC3966 = this.f363;
        if (abstractC3966 == null || z) {
            return;
        }
        abstractC3966.f13844.m4159(0);
        this.f363.f13844.m4168(5);
        this.f363.f13844.setCenterState(1);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m456() {
        if (!m447()) {
            this.f363.f13865.setVisibility(8);
            return;
        }
        float fM448 = m448();
        this.f363.f13865.setVisibility(0);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f363.f13865.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).width = (int) (C4792.m14375().m14476(70) * fM448);
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) (C4792.m14375().m14476(70) * fM448);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = (int) (((((this.f369 - C2579.m9450(this)) / 2.0f) - ((ViewGroup.MarginLayoutParams) layoutParams).width) - C4792.m14375().m14442()) / 2.0f);
        this.f363.f13865.setLayoutParams(layoutParams);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m457() {
        AbstractC3966 abstractC3966 = this.f363;
        if (abstractC3966 != null) {
            CardView cardView = abstractC3966.f13831;
            cardView.setDrawingCacheEnabled(true);
            cardView.buildDrawingCache();
            Bitmap drawingCache = cardView.getDrawingCache();
            C4062.f14100 = Bitmap.createBitmap(drawingCache);
            cardView.destroyDrawingCache();
            cardView.setDrawingCacheEnabled(false);
            C2735.m9988(drawingCache);
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m458(ImageView imageView, View view, boolean z) {
        AbstractC3966 abstractC3966 = this.f363;
        if (abstractC3966 == null) {
            return;
        }
        if (imageView == abstractC3966.f13852) {
            z = true;
        }
        C4008.m12876(imageView, z ? C4792.m14375().m14402() : 0.3f, 100, null);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m459(boolean z) {
        MobSDK.submitPolicyGrantResult(z, new C0107());
    }
}
