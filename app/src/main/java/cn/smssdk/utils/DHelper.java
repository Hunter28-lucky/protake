package cn.smssdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.mob.MobSDK;
import com.mob.tools.utils.DH;

/* loaded from: classes.dex */
public class DHelper {
    private static String a;
    private static String b;
    private static String c;
    private static String d;

    /* renamed from: e, reason: collision with root package name */
    private static String f17623e;
    private static Object f = new Object();

    public static class a extends d {

        /* renamed from: cn.smssdk.utils.DHelper$a$a, reason: collision with other inner class name */
        public class C0067a implements DH.DHResponder {
            public C0067a(a aVar) {
            }

            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "DH response");
                try {
                    if (TextUtils.isEmpty(DHelper.a)) {
                        String unused = DHelper.a = dHResponse.getSignMD5();
                    }
                } catch (Throwable th) {
                    SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "DH exception, init failure " + th);
                }
                DHelper.f.notifyAll();
            }
        }

        public class b implements DH.DHResponder {
            public b(a aVar) {
            }

            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                try {
                    String unused = DHelper.c = dHResponse.getSimSerialNumber();
                    String unused2 = DHelper.b = dHResponse.getCarrier();
                    String unused3 = DHelper.d = dHResponse.getNetworkTypeForce(new int[0]);
                    String unused4 = DHelper.f17623e = dHResponse.getDeviceId();
                } catch (Throwable th) {
                    SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, th);
                }
            }
        }

        @Override // cn.smssdk.utils.d
        public void a() {
            synchronized (DHelper.f) {
                try {
                    SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "DH request");
                    DH.requester(MobSDK.getContext()).getSignMD5().request(new C0067a(this));
                } finally {
                    DH.requester(MobSDK.getContext()).getSimSerialNumber().getCarrier().getNetworkTypeForce(true).getDeviceId().request(new b(this));
                }
                try {
                    DH.requester(MobSDK.getContext()).getSimSerialNumber().getCarrier().getNetworkTypeForce(true).getDeviceId().request(new b(this));
                } catch (Throwable th) {
                    SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, th);
                }
            }
        }
    }

    public static String getCarrier() {
        return b;
    }

    public static String getDeviceId() {
        return f17623e;
    }

    public static String getNetworkType() {
        return d;
    }

    public static String getSerialNumber() {
        return c;
    }

    public static String getSignMd5() {
        if (TextUtils.isEmpty(a)) {
            a = cn.smssdk.net.b.e();
        }
        return a;
    }

    public static Object init() {
        try {
            new a().start();
        } catch (Throwable th) {
            SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, th);
        }
        return f;
    }

    public static boolean support() {
        try {
            DH.SyncMtd.getBrand();
            return true;
        } catch (Throwable th) {
            if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError) && !(th instanceof NoSuchMethodException) && !(th instanceof NoSuchMethodError)) {
                return false;
            }
            Log.e(SMSLog.FORMAT_SIMPLE, "本产品进行了架构升级优化，为保证正常使用SDK，请确保相关架包升级到了最新版本，或者可至官网联系技术支持");
            return false;
        }
    }
}
