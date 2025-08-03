package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.efs.sdk.base.core.util.NetworkUtil;
import defpackage.sa;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class sb {

    /* renamed from: sb$Ϳ, reason: contains not printable characters */
    public static class CallableC2264 implements Callable<WifiInfo> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f8519;

        public CallableC2264(Context context) {
            this.f8519 = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public WifiInfo call() {
            return ((WifiManager) this.f8519.getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
        }
    }

    /* renamed from: sb$Ԩ, reason: contains not printable characters */
    public static class C2265 implements sa.InterfaceC2263<Object, Boolean> {
        @Override // defpackage.sa.InterfaceC2263
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* renamed from: sb$Ԫ, reason: contains not printable characters */
    public static class CallableC2266 implements Callable<String> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f8520;

        public CallableC2266(Context context) {
            this.f8520 = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public String call() {
            return vd.m8491(this.f8520);
        }
    }

    /* renamed from: sb$Ԭ, reason: contains not printable characters */
    public static class C2267 implements sa.InterfaceC2263<Object, Boolean> {
        @Override // defpackage.sa.InterfaceC2263
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    /* renamed from: sb$Ԯ, reason: contains not printable characters */
    public static class CallableC2268 implements Callable<NetworkInfo> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f8521;

        public CallableC2268(Context context) {
            this.f8521 = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public NetworkInfo call() {
            return ((ConnectivityManager) this.f8521.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    /* renamed from: sb$ՠ, reason: contains not printable characters */
    public static class C2269 implements sa.InterfaceC2263<Object, Boolean> {
        @Override // defpackage.sa.InterfaceC2263
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* renamed from: sb$ֈ, reason: contains not printable characters */
    public static class CallableC2270 implements Callable<String> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Context f8522;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ pa f8523;

        public CallableC2270(Context context, pa paVar) {
            this.f8522 = context;
            this.f8523 = paVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public String call() {
            try {
                return ia.m6283(this.f8522);
            } catch (Throwable th) {
                q9.m8091(this.f8523, "third", "GetUtdidEx", th.getClass().getName());
                return "";
            }
        }
    }

    /* renamed from: sb$֏, reason: contains not printable characters */
    public static class C2271 implements sa.InterfaceC2263<Object, Boolean> {
        @Override // defpackage.sa.InterfaceC2263
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* renamed from: sb$ׯ, reason: contains not printable characters */
    public static class CallableC2272 implements Callable<String> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f8524;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ String f8525;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ Context f8526;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final /* synthetic */ pa f8527;

        /* renamed from: sb$ׯ$Ϳ, reason: contains not printable characters */
        public class C2273 implements APSecuritySdk.InitResultListener {

            /* renamed from: Ϳ, reason: contains not printable characters */
            public final /* synthetic */ String[] f8528;

            /* renamed from: Ԩ, reason: contains not printable characters */
            public final /* synthetic */ ConditionVariable f8529;

            public C2273(String[] strArr, ConditionVariable conditionVariable) {
                this.f8528 = strArr;
                this.f8529 = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.f8528[0] = tokenResult.apdidToken;
                }
                this.f8529.open();
            }
        }

        public CallableC2272(String str, String str2, Context context, pa paVar) {
            this.f8524 = str;
            this.f8525 = str2;
            this.f8526 = context;
            this.f8527 = paVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public String call() {
            HashMap map = new HashMap();
            map.put("tid", this.f8524);
            map.put("utdid", this.f8525);
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(this.f8526);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, map, new C2273(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                hf.m6205(th);
                q9.m8091(this.f8527, "third", "GetApdidEx", th.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                q9.m8091(this.f8527, "third", "GetApdidNull", "missing token");
            }
            return strArr[0];
        }
    }

    /* renamed from: sb$ؠ, reason: contains not printable characters */
    public static class C2274 implements sa.InterfaceC2263<Object, Boolean> {
        @Override // defpackage.sa.InterfaceC2263
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof WifiInfo) || obj == null);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static NetworkInfo m8222(pa paVar, Context context) {
        Context contextM8218 = sa.m8218(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) sa.m8220(2, 10L, timeUnit, new C2267(), new CallableC2268(contextM8218), false, 10L, timeUnit, paVar, false);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m8223(pa paVar, Context context, String str, String str2) {
        Context contextM8218 = sa.m8218(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) sa.m8220(4, 10L, timeUnit, new C2271(), new CallableC2272(str, str2, contextM8218, paVar), true, 3L, timeUnit, paVar, true);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m8224(pa paVar, Context context) {
        if (!p9.m7898().m7934()) {
            return "";
        }
        return (String) sa.m8220(1, 1L, TimeUnit.DAYS, new C2265(), new CallableC2266(sa.m8218(context)), true, 200L, TimeUnit.MILLISECONDS, paVar, true);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m8225(pa paVar, Context context) {
        return (String) sa.m8220(3, 1L, TimeUnit.DAYS, new C2269(), new CallableC2270(sa.m8218(context), paVar), true, 3L, TimeUnit.SECONDS, paVar, false);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static WifiInfo m8226(pa paVar, Context context) {
        Context contextM8218 = sa.m8218(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (WifiInfo) sa.m8220(5, 10L, timeUnit, new C2274(), new CallableC2264(contextM8218), false, 10L, timeUnit, paVar, false);
    }
}
