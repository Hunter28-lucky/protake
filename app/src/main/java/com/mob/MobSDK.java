package com.mob;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mob.commons.C5340r;
import com.mob.commons.InternationalDomain;
import com.mob.commons.MobProduct;
import com.mob.commons.n;
import com.mob.commons.o;
import com.mob.commons.q;
import com.mob.commons.s;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class MobSDK implements PublicMemberKeeper {
    public static final int CHANNEL_APICLOUD = 5;
    public static final int CHANNEL_COCOS = 1;
    public static final int CHANNEL_FLUTTER = 4;
    public static final int CHANNEL_JS = 3;
    public static final int CHANNEL_NATIVE = 0;
    public static final int CHANNEL_QUICKSDK = 6;
    public static final int CHANNEL_REACT_NATIVE = 8;
    public static final int CHANNEL_UNIAPP = 7;
    public static final int CHANNEL_UNITY = 2;
    public static final int SDK_VERSION_CODE;
    public static final String SDK_VERSION_NAME;
    private static volatile Context a;

    static {
        int i;
        String strReplace = "1.0.0";
        try {
            strReplace = "2024-08-26".replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ".");
            i = Integer.parseInt("2024-08-26".replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, ""));
        } catch (Throwable unused) {
            i = 1;
        }
        SDK_VERSION_CODE = i;
        SDK_VERSION_NAME = strReplace;
    }

    @Deprecated
    public static void canIContinueBusiness(final MobProduct mobProduct, Object obj, final Object obj2) {
        if (obj2 == null) {
            throw new IllegalArgumentException("callback can not be null");
        }
        new Thread(new Runnable() { // from class: com.mob.MobSDK.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (mobProduct == null) {
                        ReflectHelper.invokeInstanceMethod(obj2, "onFailure", new Throwable("MobProduct can not be null"));
                    } else {
                        ReflectHelper.invokeInstanceMethod(obj2, "onComplete", Boolean.TRUE);
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().e(th);
                    try {
                        ReflectHelper.invokeInstanceMethod(obj2, "onFailure", th);
                    } catch (Throwable unused) {
                    }
                }
            }
        }).start();
    }

    public static boolean checkForceHttps() {
        n.d = true;
        return n.d;
    }

    @Deprecated
    public static String checkRequestUrl(String str) {
        return C5340r.a(str);
    }

    public static boolean checkV6() {
        return n.f;
    }

    public static final void disableAds() {
        q.a = true;
    }

    @Deprecated
    public static String dynamicModifyUrl(String str) {
        return C5340r.a(str);
    }

    public static String getAppSecret() {
        return n.b;
    }

    public static String getAppkey() {
        if (TextUtils.isEmpty(n.a) && a != null) {
            n.a(a);
        }
        return n.a;
    }

    public static Context getContext() {
        if (a == null) {
            try {
                Context contextA = C5340r.a();
                if (contextA != null) {
                    init(contextA);
                }
            } catch (Throwable unused) {
            }
        }
        return a;
    }

    public static Context getContextSafely() {
        return a;
    }

    public static boolean getDefaultPrivacy() {
        return n.f17685e;
    }

    public static InternationalDomain getDomain() {
        return n.c == null ? InternationalDomain.DEFAULT : n.c;
    }

    public static int getPrivacyGrantedStatus() {
        return s.c();
    }

    public static synchronized void init(Context context) {
        init(context, null, null);
    }

    public static final int isAuth() {
        return q.c();
    }

    public static final boolean isForb() {
        return q.e();
    }

    public static final Boolean isGpAvailable() {
        try {
            return DH.SyncMtd.isGooglePlayServicesAvailable() ? Boolean.TRUE : Boolean.FALSE;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public static final boolean isGppVer() {
        n.h = true;
        return n.h;
    }

    public static final boolean isMob() {
        return q.d();
    }

    public static void setChannel(MobProduct mobProduct, int i) {
        o.a().a(mobProduct, i);
    }

    public static void submitPolicyGrantResult(boolean z) {
        s.a(z, (OperationCallback<Void>) null);
    }

    @Deprecated
    public static void submitPolicyGrantResult(boolean z, OperationCallback<Void> operationCallback) {
        s.a(z, operationCallback);
    }

    public static synchronized void init(Context context, String str) {
        init(context, str, null);
    }

    public static synchronized void init(Context context, String str, String str2) {
        if (context == null) {
            Log.e("MobSDK", "MobSDK init error, context is null");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
            n.a = str;
            n.b = str2;
            q.a();
        } else if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(n.a)) {
            n.a = str;
            n.b = str2;
            q.b();
        }
    }
}
