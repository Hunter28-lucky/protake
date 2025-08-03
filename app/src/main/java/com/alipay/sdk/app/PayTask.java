package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.app.PayResultActivity;
import com.alipay.sdk.m.j.c;
import com.alipay.sdk.m.r.a;
import com.google.android.gms.common.internal.ImagesContract;
import defpackage.C4363;
import defpackage.ac;
import defpackage.ba;
import defpackage.hf;
import defpackage.hg;
import defpackage.lc;
import defpackage.lg;
import defpackage.mc;
import defpackage.nc;
import defpackage.o9;
import defpackage.p9;
import defpackage.pa;
import defpackage.q9;
import defpackage.qa;
import defpackage.rg;
import defpackage.ug;
import defpackage.zf;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PayTask {
    public static final Object h = hg.class;
    public static long i;
    public Activity a;
    public o9 b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";

    /* renamed from: e, reason: collision with root package name */
    public final String f17635e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public Map<String, C0078> g = new HashMap();

    /* renamed from: com.alipay.sdk.app.PayTask$Ϳ, reason: contains not printable characters */
    public class RunnableC0076 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ String f242;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ boolean f243;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final /* synthetic */ H5PayCallback f244;

        public RunnableC0076(String str, boolean z, H5PayCallback h5PayCallback) {
            this.f242 = str;
            this.f243 = z;
            this.f244 = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            C4363 c4363H5Pay = PayTask.this.h5Pay(new pa(PayTask.this.a, this.f242, "payInterceptorWithUrl"), this.f242, this.f243);
            hf.m6209("mspl", "inc finished: " + c4363H5Pay.m13523());
            this.f244.onPayResult(c4363H5Pay);
        }
    }

    /* renamed from: com.alipay.sdk.app.PayTask$Ԩ, reason: contains not printable characters */
    public class C0077 implements hg.InterfaceC1967 {
        public C0077() {
        }

        @Override // defpackage.hg.InterfaceC1967
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // defpackage.hg.InterfaceC1967
        public void b() {
        }
    }

    public PayTask(Activity activity) {
        this.a = activity;
        mc.m7550().m7553(this.a);
        this.b = new o9(activity, "去支付宝付款");
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            mc.m7550().m7553(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - i < p9.m7898().m7914()) {
                return false;
            }
            i = jElapsedRealtime;
            p9.m7898().m7907(pa.m7943(), context.getApplicationContext(), false, 4);
            return true;
        } catch (Exception e2) {
            hf.m6205(e2);
            return false;
        }
    }

    public void dismissLoading() {
        o9 o9Var = this.b;
        if (o9Var != null) {
            o9Var.m7701();
            this.b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || strTrim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String strTrim2 = strTrim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + ug.m8409("<request_token>", "</request_token>", ug.m8429(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if (strTrim.startsWith("https://mclient.alipay.com/service/rest.htm") || strTrim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String strTrim3 = strTrim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + ug.m8409("<request_token>", "</request_token>", ug.m8429(strTrim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.a) + "\"";
                    }
                }
                if ((strTrim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || strTrim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((strTrim.contains("alipay.wap.create.direct.pay.by.user") || strTrim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(strTrim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ImagesContract.URL, str);
                    jSONObject.put("bizcontext", a(this.a));
                    return "new_external_info==" + jSONObject.toString();
                }
                RunnableC0076 runnableC0076 = null;
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String strM8409 = ug.m8409("?", "", str);
                    if (!TextUtils.isEmpty(strM8409)) {
                        Map<String, String> mapM8429 = ug.m8429(strM8409);
                        StringBuilder sb = new StringBuilder();
                        if (m332(false, true, "trade_no", sb, mapM8429, "trade_no", "alipay_trade_no")) {
                            m332(true, false, "pay_phase_id", sb, mapM8429, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = mapM8429.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mapM8429.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(mapM8429.get("sid")) || !TextUtils.isEmpty(mapM8429.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!m332(true, true, "extern_token", sb, mapM8429, "extern_token", "cid", "sid", "s_id")) {
                                return "";
                            }
                            m332(true, false, "appenv", sb, mapM8429, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            C0078 c0078 = new C0078(this, runnableC0076);
                            c0078.m336(mapM8429.get("return_url"));
                            c0078.m338(mapM8429.get("show_url"));
                            c0078.m334(mapM8429.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + a(this.a) + "\"";
                            this.g.put(str3, c0078);
                            return str3;
                        }
                    }
                }
                if (!strTrim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !strTrim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.m315() || !strTrim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (p9.m7898().m7918() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim).find()) {
                        Uri uri = Uri.parse(strTrim);
                        String queryParameter = uri.getQueryParameter("return_url");
                        String queryParameter2 = uri.getQueryParameter("show_url");
                        String queryParameter3 = uri.getQueryParameter("pay_order_id");
                        String strA = a(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        String strA2 = a(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = uri.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(uri.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(uri.getQueryParameter("sid")) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(uri.getQueryParameter("s_id")) ? "tb" : "";
                        String strA3 = a(strArr);
                        String strA4 = a(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter("sid"), uri.getQueryParameter("s_id"));
                        String strA5 = a(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strA3) && !TextUtils.isEmpty(strA4)) {
                            String str4 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strA, strA2, strA3, strA4, strA5, a(this.a));
                            C0078 c00782 = new C0078(this, null);
                            c00782.m336(queryParameter);
                            c00782.m338(queryParameter2);
                            c00782.m334(queryParameter3);
                            c00782.m340(strA);
                            this.g.put(str4, c00782);
                            return str4;
                        }
                    }
                }
                String strA6 = a(this.a);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ImagesContract.URL, strTrim);
                jSONObject2.put("bizcontext", strA6);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th) {
            hf.m6205(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return lg.m7508(new pa(this.a, "", "fetchTradeToken"), this.a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.11";
    }

    public synchronized C4363 h5Pay(pa paVar, String str, boolean z) {
        C4363 c4363;
        c4363 = new C4363();
        try {
            String[] strArrSplit = m327(paVar, str, z).split(";");
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, m329(str2, strSubstring));
                }
            }
            if (map.containsKey("resultStatus")) {
                c4363.m13525(map.get("resultStatus"));
            }
            c4363.m13526(m330(str, map));
            if (TextUtils.isEmpty(c4363.m13524())) {
                q9.m8091(paVar, "biz", "H5CbUrlEmpty", "");
            }
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "H5CbEx", th);
            hf.m6205(th);
        }
        return c4363;
    }

    public synchronized String pay(String str, boolean z) {
        if (nc.m7645()) {
            return ac.m27();
        }
        return m327(new pa(this.a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            hf.m6209("mspl", "intercepted: " + strFetchOrderInfoFromH5PayUrl);
            new Thread(new RunnableC0076(strFetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String strM327;
        pa paVar;
        if (nc.m7645()) {
            paVar = null;
            strM327 = ac.m27();
        } else {
            pa paVar2 = new pa(this.a, str, "payV2");
            strM327 = m327(paVar2, str, z);
            paVar = paVar2;
        }
        return rg.m8199(paVar, strM327);
    }

    public void showLoading() {
        o9 o9Var = this.b;
        if (o9Var != null) {
            o9Var.m7702();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final hg.InterfaceC1967 m323() {
        return new C0077();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m324(pa paVar, lc lcVar) {
        String[] strArrM7498 = lcVar.m7498();
        Intent intent = new Intent(this.a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(ImagesContract.URL, strArrM7498[0]);
        if (strArrM7498.length == 2) {
            bundle.putString("cookie", strArrM7498[1]);
        }
        intent.putExtras(bundle);
        pa.C2227.m7966(paVar, intent);
        this.a.startActivity(intent);
        Object obj = h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e2) {
                hf.m6205(e2);
                return ac.m23();
            }
        }
        String strM29 = ac.m29();
        return TextUtils.isEmpty(strM29) ? ac.m23() : strM29;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        r0 = r6.m7498();
        r11 = defpackage.ac.m24(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], defpackage.ug.m8440(r10, r0[2]));
     */
    /* renamed from: ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m325(defpackage.pa r10, defpackage.lc r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.m325(pa, lc, java.lang.String):java.lang.String");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String m326(pa paVar, String str) {
        showLoading();
        c cVarB = null;
        try {
            try {
                try {
                    JSONObject jSONObjectM6289 = new zf().mo7969(paVar, this.a.getApplicationContext(), str).m6289();
                    String strOptString = jSONObjectM6289.optString("end_code", null);
                    List<lc> listM7493 = lc.m7493(jSONObjectM6289.optJSONObject("form").optJSONObject("onload"));
                    for (int i2 = 0; i2 < listM7493.size(); i2++) {
                        if (listM7493.get(i2).m7497() == a.Update) {
                            lc.m7494(listM7493.get(i2));
                        }
                    }
                    m331(paVar, jSONObjectM6289);
                    dismissLoading();
                    q9.m8090(this.a, paVar, str, paVar.f8291);
                    for (int i3 = 0; i3 < listM7493.size(); i3++) {
                        lc lcVar = listM7493.get(i3);
                        if (lcVar.m7497() == a.WapPay) {
                            String strM324 = m324(paVar, lcVar);
                            dismissLoading();
                            q9.m8090(this.a, paVar, str, paVar.f8291);
                            return strM324;
                        }
                        if (lcVar.m7497() == a.OpenWeb) {
                            String strM325 = m325(paVar, lcVar, strOptString);
                            dismissLoading();
                            q9.m8090(this.a, paVar, str, paVar.f8291);
                            return strM325;
                        }
                    }
                    dismissLoading();
                    q9.m8090(this.a, paVar, str, paVar.f8291);
                } catch (Throwable th) {
                    hf.m6205(th);
                    q9.m8087(paVar, "biz", "H5PayDataAnalysisError", th);
                    dismissLoading();
                    q9.m8090(this.a, paVar, str, paVar.f8291);
                }
            } catch (IOException e2) {
                c cVarB2 = c.b(c.NETWORK_ERROR.m342());
                q9.m8089(paVar, "net", e2);
                dismissLoading();
                q9.m8090(this.a, paVar, str, paVar.f8291);
                cVarB = cVarB2;
            }
            if (cVarB == null) {
                cVarB = c.b(c.FAILED.m342());
            }
            return ac.m24(cVarB.m342(), cVarB.m341(), "");
        } catch (Throwable th2) {
            dismissLoading();
            q9.m8090(this.a, paVar, str, paVar.f8291);
            throw th2;
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0057 A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015f A[Catch: all -> 0x01fc, PHI: r9
      0x015f: PHI (r9v18 java.lang.String) = (r9v17 java.lang.String), (r9v20 java.lang.String) binds: [B:34:0x015d, B:29:0x0107] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000f A[Catch: all -> 0x01fc, TryCatch #2 {, blocks: (B:4:0x0003, B:5:0x0006, B:7:0x000f, B:9:0x0023, B:10:0x0027, B:12:0x0048, B:14:0x0050, B:15:0x0053, B:17:0x0057, B:19:0x005f, B:20:0x006c, B:22:0x0074, B:28:0x00bc, B:36:0x016c, B:35:0x015f, B:33:0x0112, B:40:0x0193, B:42:0x01e0, B:43:0x01ed, B:44:0x01fb, B:11:0x0043, B:32:0x010b, B:25:0x0085, B:27:0x009f), top: B:52:0x0003, inners: #0, #1 }] */
    /* renamed from: ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String m327(defpackage.pa r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 511
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.m327(pa, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m328(String str, pa paVar) {
        String strM7945 = paVar.m7945(str);
        if (strM7945.contains("paymethod=\"expressGateway\"")) {
            return m326(paVar, strM7945);
        }
        List<p9.C2226> listM7922 = p9.m7898().m7922();
        if (!p9.m7898().f8257 || listM7922 == null) {
            listM7922 = ba.f140;
        }
        if (!ug.m8419(paVar, this.a, listM7922, true)) {
            q9.m8085(paVar, "biz", "LogCalledH5");
            return m326(paVar, strM7945);
        }
        hg hgVar = new hg(this.a, paVar, m323());
        hf.m6209("mspl", "pay inner started: " + strM7945);
        String strM6224 = hgVar.m6224(strM7945, false);
        if (!TextUtils.isEmpty(strM6224)) {
            StringBuilder sb = new StringBuilder();
            sb.append("resultStatus={");
            c cVar = c.ACTIVITY_NOT_START_EXIT;
            sb.append(cVar.m342());
            sb.append("}");
            if (strM6224.contains(sb.toString())) {
                ug.m8417("alipaySdk", "startActivityEx", this.a, paVar);
                if (p9.m7898().m7901()) {
                    strM6224 = hgVar.m6224(strM7945, true);
                } else {
                    strM6224 = strM6224.replace("resultStatus={" + cVar.m342() + "}", "resultStatus={" + c.CANCELED.m342() + "}");
                }
            }
        }
        hf.m6209("mspl", "pay inner raw result: " + strM6224);
        hgVar.m6225();
        boolean zM7933 = p9.m7898().m7933();
        if (TextUtils.equals(strM6224, "failed") || TextUtils.equals(strM6224, "scheme_failed") || (zM7933 && paVar.m7960())) {
            q9.m8085(paVar, "biz", "LogBindCalledH5");
            return m326(paVar, strM7945);
        }
        if (TextUtils.isEmpty(strM6224)) {
            return ac.m23();
        }
        if (!strM6224.contains("{\"isLogin\":\"false\"}")) {
            return strM6224;
        }
        q9.m8085(paVar, "biz", "LogHkLoginByIntent");
        return a(paVar, strM7945, listM7922, strM6224, this.a);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final String m329(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m330(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get("resultStatus"));
        String str2 = map.get("result");
        C0078 c0078Remove = this.g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = c0078Remove != null ? c0078Remove.m333() : "";
        strArr[1] = c0078Remove != null ? c0078Remove.m339() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strA = a(ug.m8409("&callBackUrl=\"", "\"", str2), ug.m8409("&call_back_url=\"", "\"", str2), ug.m8409("&return_url=\"", "\"", str2), URLDecoder.decode(ug.m8409("&return_url=", "&", str2), "utf-8"), URLDecoder.decode(ug.m8409("&callBackUrl=", "&", str2), "utf-8"), ug.m8409("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (c0078Remove != null) {
            String strM335 = zEquals ? c0078Remove.m335() : c0078Remove.m337();
            if (!TextUtils.isEmpty(strM335)) {
                return strM335;
            }
        }
        return c0078Remove != null ? p9.m7898().m7928() : "";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m331(pa paVar, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString("client_key");
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            qa.m8106(mc.m7550().m7554()).m8108(strOptString, strOptString2);
        } catch (Throwable th) {
            q9.m8087(paVar, "biz", "ParserTidClientKeyEx", th);
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final boolean m332(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (!z) {
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
        sb.append("&");
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: all -> 0x005b, TryCatch #2 {all -> 0x005b, blocks: (B:11:0x001e, B:13:0x0044, B:15:0x0051, B:16:0x0056), top: B:25:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            java.lang.String r0 = "sc"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> L18
            r3 = 0
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r3)     // Catch: java.lang.Exception -> L18
            java.lang.String r2 = r6.versionName     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = r6.packageName     // Catch: java.lang.Exception -> L16
            goto L1e
        L16:
            r6 = move-exception
            goto L1a
        L18:
            r6 = move-exception
            r2 = r1
        L1a:
            defpackage.hf.m6205(r6)
            r6 = r1
        L1e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L5b
            r3.<init>()     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "appkey"
            java.lang.String r5 = "2014052600006128"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "ty"
            java.lang.String r5 = "and_lite"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "sv"
            java.lang.String r5 = "h.a.3.8.11"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r4 = "an"
            r3.put(r4, r6)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "av"
            r3.put(r6, r2)     // Catch: java.lang.Throwable -> L5b
            java.lang.String r6 = "sdk_start_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L5b
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L5b
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L5b
            if (r6 != 0) goto L56
            java.lang.String r6 = "h5tonative"
            r3.put(r0, r6)     // Catch: java.lang.Throwable -> L5b
        L56:
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L5b
            return r6
        L5b:
            r6 = move-exception
            defpackage.hf.m6205(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(android.content.Context):java.lang.String");
    }

    /* renamed from: com.alipay.sdk.app.PayTask$Ԫ, reason: contains not printable characters */
    public class C0078 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String f247;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f248;

        /* renamed from: ԩ, reason: contains not printable characters */
        public String f249;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public String f250;

        public C0078() {
            this.f247 = "";
            this.f248 = "";
            this.f249 = "";
            this.f250 = "";
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public String m333() {
            return this.f249;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m334(String str) {
            this.f249 = str;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public String m335() {
            return this.f247;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public void m336(String str) {
            this.f247 = str;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public String m337() {
            return this.f248;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public void m338(String str) {
            this.f248 = str;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public String m339() {
            return this.f250;
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public void m340(String str) {
            this.f250 = str;
        }

        public /* synthetic */ C0078(PayTask payTask, RunnableC0076 runnableC0076) {
            this();
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String a(pa paVar, String str, List<p9.C2226> list, String str2, Activity activity) {
        ug.C2298 c2298M8414 = ug.m8414(paVar, activity, list);
        if (c2298M8414 == null || c2298M8414.m8454(paVar) || c2298M8414.m8453() || !TextUtils.equals(c2298M8414.f8655.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        hf.m6207("mspl", "PayTask not_login");
        String strValueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> map = PayResultActivity.f237;
        map.put(strValueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra("orderSuffix", str);
        intent.putExtra("externalPkgName", activity.getPackageName());
        intent.putExtra("phonecashier.pay.hash", strValueOf);
        pa.C2227.m7966(paVar, intent);
        activity.startActivity(intent);
        synchronized (map.get(strValueOf)) {
            try {
                hf.m6207("mspl", "PayTask wait");
                map.get(strValueOf).wait();
            } catch (InterruptedException unused) {
                hf.m6207("mspl", "PayTask interrupted");
                return ac.m23();
            }
        }
        String str3 = PayResultActivity.C0075.f241;
        hf.m6207("mspl", "PayTask ret: " + str3);
        return str3;
    }
}
