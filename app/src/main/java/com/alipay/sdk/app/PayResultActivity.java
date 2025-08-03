package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import defpackage.ac;
import defpackage.hf;
import defpackage.pa;
import defpackage.q9;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.jcodec.platform.Platform;

/* loaded from: classes.dex */
public final class PayResultActivity extends Activity {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final HashMap<String, Object> f237 = new HashMap<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public pa f238 = null;

    /* renamed from: com.alipay.sdk.app.PayResultActivity$Ϳ, reason: contains not printable characters */
    public static class RunnableC0074 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Activity f239;

        public RunnableC0074(Activity activity) {
            this.f239 = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f239.finish();
        }
    }

    /* renamed from: com.alipay.sdk.app.PayResultActivity$Ԩ, reason: contains not printable characters */
    public static final class C0075 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static volatile String f240;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static volatile String f241;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m318(Activity activity, int i) {
        new Handler().postDelayed(new RunnableC0074(activity), i);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m319(Activity activity, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        Intent intent = new Intent();
        try {
            intent.setPackage("hk.alipay.wallet");
            intent.setData(Uri.parse("alipayhk://platformapi/startApp?appId=20000125&schemePaySession=" + URLEncoder.encode(str, Platform.UTF_8) + "&orderSuffix=" + URLEncoder.encode(str2, Platform.UTF_8) + "&packageName=" + URLEncoder.encode(str3, Platform.UTF_8) + "&externalPkgName=" + URLEncoder.encode(str3, Platform.UTF_8)));
        } catch (UnsupportedEncodingException e2) {
            hf.m6205(e2);
        }
        if (activity != null) {
            try {
                activity.startActivity(intent);
            } catch (Throwable unused) {
                activity.finish();
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m320(String str) {
        C0075.f241 = ac.m23();
        m322(f237, str);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m321(String str, String str2) {
        C0075.f241 = str;
        m322(f237, str2);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m322(HashMap<String, Object> map, String str) {
        Object obj;
        if (map == null || str == null || (obj = map.get(str)) == null) {
            return false;
        }
        synchronized (obj) {
            obj.notifyAll();
        }
        return true;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            if (!TextUtils.isEmpty(intent.getStringExtra("orderSuffix"))) {
                C0075.f240 = intent.getStringExtra("phonecashier.pay.hash");
                String stringExtra = intent.getStringExtra("orderSuffix");
                String stringExtra2 = intent.getStringExtra("externalPkgName");
                pa paVarM7964 = pa.C2227.m7964(intent);
                this.f238 = paVarM7964;
                if (paVarM7964 == null) {
                    finish();
                }
                m319(this, C0075.f240, stringExtra, stringExtra2);
                m318(this, 300);
                return;
            }
            if (this.f238 == null) {
                finish();
            }
            String stringExtra3 = intent.getStringExtra("phonecashier.pay.result");
            int intExtra = intent.getIntExtra("phonecashier.pay.resultOrderHash", 0);
            if (intExtra != 0 && TextUtils.equals(C0075.f240, String.valueOf(intExtra))) {
                if (TextUtils.isEmpty(stringExtra3)) {
                    m320(C0075.f240);
                } else {
                    m321(stringExtra3, C0075.f240);
                }
                C0075.f240 = "";
                m318(this, 300);
                return;
            }
            q9.m8091(this.f238, "biz", "SchemePayWrongHashEx", "Expected " + C0075.f240 + ", got " + intExtra);
            m320(C0075.f240);
            m318(this, 300);
        } catch (Throwable unused) {
            finish();
        }
    }
}
