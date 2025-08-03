package com.blink.academy.film;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Base64;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.custom.WeakHandler;
import com.blink.academy.film.http.okhttp.OkHttpUtils;
import com.blink.academy.film.http.okhttp.cache.converter.SerializableDiskConverter;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.blink.academy.film.http.okhttp.model.HttpParams;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.protake.R;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPush;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.C2363;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C2811;
import defpackage.C2813;
import defpackage.C3184;
import defpackage.C4079;
import defpackage.C4567;
import defpackage.C4638;
import defpackage.C4665;
import defpackage.C4792;
import defpackage.C5069;
import defpackage.C5213;
import defpackage.c9;
import defpackage.e5;
import defpackage.q7;
import defpackage.r1;
import defpackage.x7;
import defpackage.y7;

/* loaded from: classes.dex */
public class FilmApp extends Application {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static Context f336 = null;

    /* renamed from: ֏, reason: contains not printable characters */
    public static FilmApp f337 = null;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static boolean f338 = false;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static Typeface f339;

    /* renamed from: ހ, reason: contains not printable characters */
    public static Typeface f340;

    /* renamed from: ԫ, reason: contains not printable characters */
    public WeakHandler f341;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f342;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f343;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f344;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f345 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f346 = true;

    /* renamed from: com.blink.academy.film.FilmApp$Ϳ, reason: contains not printable characters */
    public class C0098 implements Application.ActivityLifecycleCallbacks {
        public C0098() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            if (activity instanceof Splash2Activity) {
                return;
            }
            if (FilmApp.this.f342 == 0 && FilmApp.this.m406()) {
                if (r1.m8143(C2618.m9569("gimbal_his_sp", ""))) {
                    if (e5.m5988().m5993()) {
                        c9.m219().m237();
                    } else {
                        C2618.m9573("gimbal_his_sp", "");
                    }
                }
                if (r1.m8143(C2618.m9569("protake_focus_his_sp", ""))) {
                    if (e5.m5988().m5993()) {
                        C4567.m14006().m14023();
                    } else {
                        C2618.m9573("protake_focus_his_sp", "");
                    }
                }
            }
            FilmApp.m399(FilmApp.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            if (activity instanceof Splash2Activity) {
                return;
            }
            FilmApp.m400(FilmApp.this);
            if (FilmApp.this.f342 == 0 && FilmApp.this.m406()) {
                c9.m219().m238();
                if (c9.m219().m226() != null) {
                    c9.m219().m225();
                }
                c9.m219().m220();
                C4567.m14006().m14024();
                if (C4567.m14006().m14013() != null) {
                    C4567.m14006().m14012();
                }
                C4567.m14006().m14009();
            }
        }
    }

    /* renamed from: com.blink.academy.film.FilmApp$Ԩ, reason: contains not printable characters */
    public class C0099 implements y7.InterfaceC2307 {
        public C0099() {
        }

        @Override // defpackage.y7.InterfaceC2307
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo433(x7 x7Var) {
            HttpParams commonParams;
            if (x7Var == null) {
                y7.m8624().m8627(new x7(System.currentTimeMillis(), Build.MANUFACTURER, Build.MODEL));
                return;
            }
            if (Build.MODEL.equals(x7Var.m8591()) && Build.MANUFACTURER.equals(x7Var.m8590())) {
                return;
            }
            C2618.m9573("save_still_str_sp", "");
            if (FilmApp.this.f345 && (commonParams = OkHttpUtils.getInstance().getCommonParams()) != null) {
                commonParams.remove("uuid");
                commonParams.put("uuid", e5.m5988().m5991());
            }
            e5.m5988().m5995();
            y7.m8624().m8625();
        }
    }

    /* renamed from: com.blink.academy.film.FilmApp$Ԫ, reason: contains not printable characters */
    public class RunnableC0100 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f349;

        /* renamed from: com.blink.academy.film.FilmApp$Ԫ$Ϳ, reason: contains not printable characters */
        public class RunnableC0101 implements Runnable {
            public RunnableC0101() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e5.m5988().m5990();
                MobPush.addTags(e5.m5988().m5993() ? new String[]{RunnableC0100.this.f349, "vip"} : new String[]{RunnableC0100.this.f349});
            }
        }

        public RunnableC0100(String str) {
            this.f349 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            MobPush.cleanTags();
            FilmApp.this.m428(new RunnableC0101(), 2000L);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ int m399(FilmApp filmApp) {
        int i = filmApp.f342;
        filmApp.f342 = i + 1;
        return i;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static /* synthetic */ int m400(FilmApp filmApp) {
        int i = filmApp.f342;
        filmApp.f342 = i - 1;
        return i;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static Context m402() {
        return f336;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static Typeface m403() {
        if (f340 == null) {
            f340 = C5069.m14883(m402());
        }
        return f340;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static Typeface m404() {
        if (f339 == null) {
            f339 = C5069.m14884(m402());
        }
        return f339;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static FilmApp m405() {
        return f337;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f337 = this;
        f336 = getApplicationContext();
        C4638.m14105(false);
        C4792.m14375().m14495();
        int iM9566 = C2618.m9566("transmit_is_first_int", 0);
        if (iM9566 < 5) {
            C2618.m9571("transmit_is_first_int", iM9566 + 1);
        }
        if (m432()) {
            m417();
            q7.m8068(R.id.glide_tag);
            this.f341 = new WeakHandler();
            long jLongValue = C2618.m9567("last_net_time_sp", 0L).longValue();
            boolean zM9565 = C2618.m9565("open_camera_sp", false);
            if (jLongValue != 0 || zM9565) {
                f338 = false;
            } else {
                boolean z = !C2618.m9565("agree_first_use_sp", false);
                f338 = z;
                if (z) {
                    f338 = false;
                    if (C5213.m15215()) {
                        f338 = true;
                    }
                }
            }
            m412();
            m413();
            m411();
            m415();
            m418();
            m414();
            registerActivityLifecycleCallbacks(new C0098());
            C4079.m13018(this, false);
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m406() {
        boolean zM9565 = C2618.m9565("agree_first_use_sp", false);
        if (f338) {
            return zM9565;
        }
        return true;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m407() {
        return m420();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m408() {
        return m423() || m424() || m420() || m422() || m421() || m419();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m409() {
        return this.f343;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public String m410() {
        return this.f344;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public void m411() {
        if (m406()) {
            C2811.m10140();
            ACHelper.getInstance().initCheck265();
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public void m412() {
        if (m406()) {
            C3184.m10827().m10849(this);
            y7.m8624().m8626(new C0099());
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public void m413() {
        if (m406()) {
            C2813.m10148();
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public void m414() {
        if (m406()) {
            MobSDK.init(this);
            m416();
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m415() {
        if (m406()) {
            OkHttpUtils.init(this);
            this.f345 = true;
            String strEncodeToString = "";
            if (System.currentTimeMillis() - C2618.m9567("temp_host_time_sp", 0L).longValue() > 2592000000L) {
                C2618.m9573("temp_host_sp", "");
                C2618.m9572("temp_host_time_sp", 0L);
            }
            String strM9569 = C2618.m9569("temp_host_sp", "");
            if (!r1.m8143(strM9569)) {
                strM9569 = "https://protake.dafork.com";
            }
            m429(strM9569);
            HttpHeaders httpHeaders = new HttpHeaders();
            this.f343 = C4665.m14153(this, "com.blink.academy.protake", "SHA1");
            HttpParams httpParams = new HttpParams();
            httpParams.put("platform_type", AnalyticsConstants.SDK_TYPE);
            httpParams.put("platform_version", Build.VERSION.RELEASE);
            httpParams.put("platform_locale", C5213.m15206());
            httpParams.put("app_version", "3.0.17");
            httpParams.put("app_build", String.valueOf(130));
            httpParams.put(am.H, Build.MANUFACTURER);
            httpParams.put("device_model", Build.MODEL);
            httpParams.put("uuid", e5.m5988().m5991());
            httpParams.put("a_sha", this.f343);
            try {
                String installerPackageName = getPackageManager().getInstallerPackageName(getPackageName());
                if (r1.m8143(installerPackageName)) {
                    strEncodeToString = Base64.encodeToString(installerPackageName.getBytes(), 2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            httpParams.put("distributor", strEncodeToString);
            try {
                String uMIDString = UMConfigure.getUMIDString(this);
                if (r1.m8143(uMIDString)) {
                    this.f346 = true;
                    httpParams.put(am.g, uMIDString);
                } else {
                    this.f346 = false;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            OkHttpUtils.getInstance().debug("RxEasyHttp", false).setReadTimeOut(15000L).setWriteTimeOut(15000L).setConnectTimeout(15000L).setRetryCount(3).setRetryDelay(500).setRetryIncreaseDelay(500).setBaseUrl(strM9569).setCacheDiskConverter(new SerializableDiskConverter()).setCacheMaxSize(52428800L).setCacheVersion(1).addCommonHeaders(httpHeaders).addCommonParams(httpParams);
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m416() {
        if (m406()) {
            new Thread(new RunnableC0100(C5213.m15210() ? C5213.m15219() ? "language_cnt" : "language_cn" : C5213.m15213() ? "language_ja" : C5213.m15216() ? "language_ko" : C5213.m15217() ? "language_th" : "language_en")).start();
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m417() {
        int iWidth;
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = ((WindowManager) getSystemService(WindowManager.class)).getCurrentWindowMetrics();
            iWidth = currentWindowMetrics.getBounds().width();
            currentWindowMetrics.getBounds().height();
        } else {
            Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            iWidth = point.x;
        }
        C2579.f9594 = iWidth;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m418() {
        if (m406()) {
            String appkeyByXML = UMUtils.getAppkeyByXML(f336);
            UMConfigure.preInit(f336, appkeyByXML, "google");
            UMConfigure.init(f336, appkeyByXML, "google", 1, null);
            if (!this.f346) {
                try {
                    String uMIDString = UMConfigure.getUMIDString(this);
                    if (r1.m8143(uMIDString)) {
                        this.f346 = true;
                        HttpParams httpParams = new HttpParams();
                        httpParams.put(am.g, uMIDString);
                        OkHttpUtils.getInstance().addCommonParams(httpParams);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            UMConfigure.setLogEnabled(false);
            UMConfigure.setEncryptEnabled(true);
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final boolean m419() {
        return true;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final boolean m420() {
        return false;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final boolean m421() {
        return false;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final boolean m422() {
        return false;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final boolean m423() {
        return false;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final boolean m424() {
        return false;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean m425() {
        return m423() || m422() || m424() || m420() || m421() || m419();
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean m426() {
        return m420() || m423() || m422() || m424() || m421() || m419();
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m427(Runnable runnable) {
        this.f341.post(runnable);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public void m428(Runnable runnable, long j) {
        this.f341.postDelayed(runnable, j);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public FilmApp m429(String str) {
        this.f344 = C2363.m8830(str);
        return this;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean m430() {
        return m431(false);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public boolean m431(boolean z) {
        int iM9566 = C2618.m9566("privacy_alert_v_sp2", 0);
        if (iM9566 == 0 && C2618.m9565("agree_first_use_sp", false)) {
            C2618.m9571("privacy_alert_v_sp2", 1);
            iM9566 = 1;
        }
        boolean z2 = C2618.m9566("privacy_remote_v_sp", 1) > iM9566;
        if (!z) {
            return C5213.m15215() && !C2618.m9565("terms_alert_sp", false);
        }
        if (z2) {
            return C5213.m15215();
        }
        return false;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final boolean m432() {
        return true;
    }
}
