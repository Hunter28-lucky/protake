package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.m.j.c;
import com.umeng.analytics.pro.d;
import defpackage.p9;
import defpackage.pa;
import defpackage.ug;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.jcodec.platform.Platform;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class hg {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Activity f6739;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public volatile IAlixPay f6740;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f6742;

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC1967 f6743;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final pa f6744;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Object f6741 = IAlixPay.class;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f6745 = false;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f6746 = null;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f6747 = null;

    /* renamed from: hg$Ϳ, reason: contains not printable characters */
    public class C1961 implements AlipayResultActivity.InterfaceC0072 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ CountDownLatch f6748;

        public C1961(CountDownLatch countDownLatch) {
            this.f6748 = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.InterfaceC0072
        /* renamed from: Ϳ */
        public void mo308(int i, String str, String str2) {
            hg.this.f6746 = ac.m24(i, str, str2);
            this.f6748.countDown();
        }
    }

    /* renamed from: hg$Ԩ, reason: contains not printable characters */
    public class C1962 implements APayEntranceActivity.InterfaceC0071 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ Object f6750;

        public C1962(Object obj) {
            this.f6750 = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.InterfaceC0071
        public void a(String str) {
            hg.this.f6747 = str;
            synchronized (this.f6750) {
                try {
                    this.f6750.notify();
                } finally {
                }
            }
        }
    }

    /* renamed from: hg$Ԫ, reason: contains not printable characters */
    public class RunnableC1963 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ APayEntranceActivity.InterfaceC0071 f6752;

        public RunnableC1963(APayEntranceActivity.InterfaceC0071 interfaceC0071) {
            this.f6752 = interfaceC0071;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (hg.this.f6744 == null || hg.this.f6744.m7958()) {
                return;
            }
            q9.m8091(hg.this.f6744, "biz", "ErrActNotCreated", "");
            if (p9.m7898().m7933()) {
                hg.this.f6744.m7953(true);
                this.f6752.a(ac.m23());
            }
        }
    }

    /* renamed from: hg$Ԭ, reason: contains not printable characters */
    public class RunnableC1964 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Intent f6754;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ Object f6755;

        public RunnableC1964(Intent intent, Object obj) {
            this.f6754 = intent;
            this.f6755 = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (hg.this.f6739 != null) {
                    hg.this.f6739.startActivity(this.f6754);
                } else {
                    q9.m8091(hg.this.f6744, "biz", "ErrActNull2", "");
                    Context contextM7944 = hg.this.f6744.m7944();
                    if (contextM7944 != null) {
                        contextM7944.startActivity(this.f6754);
                    }
                }
            } finally {
            }
        }
    }

    /* renamed from: hg$Ԯ, reason: contains not printable characters */
    public class BinderC1965 extends IRemoteServiceCallback.Stub {
        public BinderC1965() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            q9.m8086(hg.this.f6744, "wlt", str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (hg.this.f6743 != null) {
                    hg.this.f6743.a();
                }
                if (hg.this.f6744 != null) {
                    hg.this.f6744.m7956(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e2) {
                q9.m8087(hg.this.f6744, "biz", "ErrIntentEx", e2);
            }
            intent.setClassName(str, str2);
            try {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                q9.m8086(hg.this.f6744, "biz", "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
            } catch (Throwable unused) {
            }
            try {
                if (hg.this.f6739 == null) {
                    q9.m8091(hg.this.f6744, "biz", "ErrActNull", "");
                    Context contextM7944 = hg.this.f6744.m7944();
                    if (contextM7944 != null) {
                        contextM7944.startActivity(intent);
                        return;
                    }
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                hg.this.f6739.startActivity(intent);
                q9.m8086(hg.this.f6744, "biz", "stAct2", "" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Throwable th) {
                q9.m8087(hg.this.f6744, "biz", "ErrActEx", th);
                throw th;
            }
        }

        public /* synthetic */ BinderC1965(hg hgVar, C1961 c1961) {
            this();
        }
    }

    /* renamed from: hg$ՠ, reason: contains not printable characters */
    public class ServiceConnectionC1966 implements ServiceConnection {
        public ServiceConnectionC1966() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            q9.m8085(hg.this.f6744, "biz", "srvCon");
            synchronized (hg.this.f6741) {
                hg.this.f6740 = IAlixPay.Stub.asInterface(iBinder);
                hg.this.f6741.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            q9.m8085(hg.this.f6744, "biz", "srvDis");
            hg.this.f6740 = null;
        }

        public /* synthetic */ ServiceConnectionC1966(hg hgVar, C1961 c1961) {
            this();
        }
    }

    /* renamed from: hg$ֈ, reason: contains not printable characters */
    public interface InterfaceC1967 {
        void a();

        void b();
    }

    public hg(Activity activity, pa paVar, InterfaceC1967 interfaceC1967) {
        this.f6739 = activity;
        this.f6744 = paVar;
        this.f6743 = interfaceC1967;
        hf.m6209("mspl", "alipaySdk");
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static boolean m6214(String str, Context context, pa paVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            q9.m8085(paVar, "biz", "BSPDetectFail");
            return false;
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "BSPDetectFail", th);
            return false;
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static boolean m6217(String str, Context context, pa paVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            q9.m8085(paVar, "biz", "BSADetectFail");
            return false;
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "BSADetectFail", th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:198:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: Ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair<java.lang.String, java.lang.Boolean> m6220(java.lang.String r18, java.lang.String r19, defpackage.pa r20) {
        /*
            Method dump skipped, instructions count: 910
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hg.m6220(java.lang.String, java.lang.String, pa):android.util.Pair");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final String m6221(String str, String str2) {
        String str3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String strM8404 = ug.m8404(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        q9.m8086(this.f6744, "biz", "BSPStart", strM8404 + "|" + jElapsedRealtime);
        pa.C2227.m7967(this.f6744, strM8404);
        AlipayResultActivity.f222.put(strM8404, new C1961(countDownLatch));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put("external_info", str);
            jSONObject.put("pkgName", this.f6739.getPackageName());
            jSONObject.put(d.aw, strM8404);
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes(Platform.UTF_8), 2);
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20000125");
            builderAppendQueryParameter.appendQueryParameter("mqpSchemePay", strEncodeToString);
            try {
                HashMap<String, String> mapM7941 = pa.m7941(this.f6744);
                mapM7941.put("ts_scheme", String.valueOf(jElapsedRealtime));
                builderAppendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(mapM7941).toString());
            } catch (Throwable th) {
                q9.m8087(this.f6744, "biz", "BSPLocEx", th);
            }
            String string = builderAppendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(string));
            Activity activity = this.f6739;
            pa paVar = this.f6744;
            q9.m8090(activity, paVar, str, paVar.f8291);
            this.f6739.startActivity(intent);
            hf.m6209("mspl", "pay scheme waiting " + string);
            countDownLatch.await();
            String str4 = this.f6746;
            try {
                str3 = rg.m8199(this.f6744, str4).get("resultStatus");
                if (str3 == null) {
                    str3 = "null";
                }
            } catch (Throwable th2) {
                q9.m8087(this.f6744, "biz", "BSPStatEx", th2);
                str3 = "unknown";
            }
            q9.m8085(this.f6744, "biz", "BSPDone-" + str3);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            q9.m8085(this.f6744, "biz", "BSPEmpty");
            return "scheme_failed";
        } catch (InterruptedException e2) {
            q9.m8087(this.f6744, "biz", "BSPWaiting", e2);
            c cVar = c.PAY_WAITTING;
            return ac.m24(cVar.m342(), cVar.m341(), "");
        } catch (Throwable th3) {
            q9.m8087(this.f6744, "biz", "BSPEx", th3);
            return "scheme_failed";
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m6222(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        hf.m6209("mspl", "pay payInvokeAct");
        q9.m8086(this.f6744, "biz", "PgWltVer", str2 + "|" + str3);
        Activity activity = this.f6739;
        pa paVar = this.f6744;
        q9.m8090(activity, paVar, str, paVar.f8291);
        return m6227(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0189 A[RETURN] */
    /* renamed from: ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m6223(java.lang.String r9, java.lang.String r10, android.content.pm.PackageInfo r11, defpackage.ug.C2298 r12) {
        /*
            Method dump skipped, instructions count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hg.m6223(java.lang.String, java.lang.String, android.content.pm.PackageInfo, ug$Ԫ):java.lang.String");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m6224(String str, boolean z) {
        ug.C2298 c2298M8414;
        String strM8425 = "";
        try {
            List<p9.C2226> listM7922 = p9.m7898().m7922();
            if (!p9.m7898().f8257 || listM7922 == null) {
                listM7922 = ba.f140;
            }
            c2298M8414 = ug.m8414(this.f6744, this.f6739, listM7922);
        } catch (Throwable th) {
            th = th;
            c2298M8414 = null;
        }
        if (c2298M8414 != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                q9.m8087(this.f6744, "biz", "CheckClientSignEx", th);
                boolean zM8430 = ug.m8430(this.f6744);
                return z ? m6222(str, strM8425, packageInfo) : m6222(str, strM8425, packageInfo);
                return m6223(str, strM8425, packageInfo, c2298M8414);
            }
            if (c2298M8414.m8454(this.f6744) || c2298M8414.m8453() || ug.m8423(c2298M8414.f8655)) {
                return "failed";
            }
            PackageInfo packageInfo = c2298M8414.f8655;
            strM8425 = (packageInfo == null || "com.eg.android.AlipayGphone".equals(packageInfo.packageName)) ? ug.m8425() : c2298M8414.f8655.packageName;
            PackageInfo packageInfo2 = c2298M8414.f8655;
            packageInfo = packageInfo2 != null ? packageInfo2 : null;
            String strM7913 = p9.m7898().m7913();
            if (strM7913 != null) {
                if (strM7913.length() > 0) {
                    try {
                        JSONObject jSONObjectOptJSONObject = new JSONObject(strM7913).optJSONObject(strM8425);
                        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                int i = Integer.parseInt(next);
                                if (packageInfo != null && packageInfo.versionCode >= i) {
                                    try {
                                        boolean zM7911 = p9.m7898().m7911(this.f6739, Integer.parseInt(jSONObjectOptJSONObject.getString(next)));
                                        this.f6745 = zM7911;
                                        if (zM7911) {
                                            break;
                                        }
                                    } catch (Exception unused) {
                                        continue;
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            }
            boolean zM84302 = ug.m8430(this.f6744);
            if ((z && !this.f6745) || zM84302 || !m6217(strM8425, this.f6739, this.f6744)) {
                return m6223(str, strM8425, packageInfo, c2298M8414);
            }
        }
        return "failed";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m6225() {
        this.f6739 = null;
        this.f6743 = null;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m6226(ug.C2298 c2298) throws InterruptedException {
        PackageInfo packageInfo;
        if (c2298 == null || (packageInfo = c2298.f8655) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f6739.startActivity(intent);
        } catch (Throwable th) {
            q9.m8087(this.f6744, "biz", "StartLaunchAppTransEx", th);
        }
        Thread.sleep(200L);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final String m6227(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String strM8404 = ug.m8404(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        q9.m8086(this.f6744, "biz", "BSAStart", strM8404 + "|" + jElapsedRealtime);
        pa.C2227.m7967(this.f6744, strM8404);
        C1962 c1962 = new C1962(obj);
        APayEntranceActivity.f218.put(strM8404, c1962);
        try {
            HashMap<String, String> mapM7941 = pa.m7941(this.f6744);
            mapM7941.put("ts_intent", String.valueOf(jElapsedRealtime));
            jSONObject = new JSONObject(mapM7941);
        } catch (Throwable th) {
            try {
                q9.m8087(this.f6744, "biz", "BSALocEx", th);
                jSONObject = null;
            } catch (InterruptedException e2) {
                q9.m8087(this.f6744, "biz", "BSAWaiting", e2);
                c cVar = c.PAY_WAITTING;
                return ac.m24(cVar.m342(), cVar.m341(), "");
            } catch (Throwable th2) {
                q9.m8087(this.f6744, "biz", "BSAEx", th2);
                ug.m8417("alipaySdk", "startActivityEx", this.f6739, this.f6744);
                return "scheme_failed";
            }
        }
        Intent intent = new Intent(this.f6739, (Class<?>) APayEntranceActivity.class);
        intent.putExtra("ap_order_info", str);
        intent.putExtra("ap_target_packagename", str2);
        intent.putExtra("ap_session", strM8404);
        if (jSONObject != null) {
            intent.putExtra("ap_local_info", jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new RunnableC1963(c1962), p9.m7898().m7921());
        Activity activity = this.f6739;
        pa paVar = this.f6744;
        q9.m8090(activity, paVar, str, paVar.f8291);
        if (p9.m7898().m7936()) {
            new Handler(Looper.getMainLooper()).post(new RunnableC1964(intent, obj));
        } else {
            try {
                Activity activity2 = this.f6739;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    q9.m8091(this.f6744, "biz", "ErrActNull", "");
                    Context contextM7944 = this.f6744.m7944();
                    if (contextM7944 != null) {
                        contextM7944.startActivity(intent);
                    }
                }
            } catch (Throwable th3) {
                q9.m8087(this.f6744, "biz", "ErrActEx", th3);
                throw th3;
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        String str3 = this.f6747;
        String str4 = "unknown";
        try {
            String str5 = rg.m8199(this.f6744, str3).get("resultStatus");
            str4 = str5 == null ? "null" : str5;
        } catch (Throwable th4) {
            q9.m8087(this.f6744, "biz", "BSAStatEx", th4);
        }
        q9.m8085(this.f6744, "biz", "BSADone-" + str4);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        q9.m8085(this.f6744, "biz", "BSAEmpty");
        return "scheme_failed";
    }
}
