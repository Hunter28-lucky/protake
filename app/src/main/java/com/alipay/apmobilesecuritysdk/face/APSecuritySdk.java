package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.blink.academy.film.stream.FinderManager;
import defpackage.ua;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class APSecuritySdk {
    public static APSecuritySdk a;
    public static Object c = new Object();
    public Context b;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    public APSecuritySdk(Context context) {
        this.b = context;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (a == null) {
            synchronized (c) {
                if (a == null) {
                    a = new APSecuritySdk(context);
                }
            }
        }
        return a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public String getApdidToken() {
        String strA = a.a(this.b, "");
        if (ua.m8370(strA)) {
            initToken(0, new HashMap(), null);
        }
        return strA;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202206130311";
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.b, "");
            tokenResult.clientKey = h.f(this.b);
            tokenResult.apdid = a.a(this.b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.b);
            if (ua.m8370(tokenResult.apdid) || ua.m8370(tokenResult.apdidToken) || ua.m8370(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i);
        String strB = h.b(this.b);
        String strC = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (ua.m8373(strB) && !ua.m8371(strB, strC)) {
            com.alipay.apmobilesecuritysdk.e.a.a(this.b);
            d.a(this.b);
            g.a(this.b);
            i.h();
        }
        if (!ua.m8371(strB, strC)) {
            h.c(this.b, strC);
        }
        String strM8369 = ua.m8369(map, "utdid", "");
        String strM83692 = ua.m8369(map, "tid", "");
        String strM83693 = ua.m8369(map, "userId", "");
        if (ua.m8370(strM8369)) {
            strM8369 = UtdidWrapper.getUtdid(this.b);
        }
        final HashMap map2 = new HashMap();
        map2.put("utdid", strM8369);
        map2.put("tid", strM83692);
        map2.put("userId", strM83693);
        map2.put("appName", "");
        map2.put("appKeyClient", "");
        map2.put("appchannel", "");
        map2.put("rpcVersion", FinderManager.MACHINE_D);
        b.a().a(new Runnable() { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            @Override // java.lang.Runnable
            public void run() {
                new a(APSecuritySdk.this.b).a(map2);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(APSecuritySdk.this.getTokenResult());
                }
            }
        });
    }
}
