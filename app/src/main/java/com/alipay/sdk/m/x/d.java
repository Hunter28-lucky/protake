package com.alipay.sdk.m.x;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.x.e;
import com.google.android.gms.common.internal.ImagesContract;
import defpackage.ac;
import defpackage.ag;
import defpackage.je;
import defpackage.pa;
import defpackage.q9;
import defpackage.tb;
import defpackage.ug;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends c implements e.InterfaceC0093, e.InterfaceC0094, e.InterfaceC0095 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f287;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f288;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f289;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final pa f290;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f291;

    /* renamed from: ֏, reason: contains not printable characters */
    public e f292;

    /* renamed from: ׯ, reason: contains not printable characters */
    public ag f293;

    /* renamed from: com.alipay.sdk.m.x.d$Ϳ, reason: contains not printable characters */
    public class RunnableC0079 implements Runnable {
        public RunnableC0079() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f285.finish();
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$Ԩ, reason: contains not printable characters */
    public class C0080 extends AbstractAnimationAnimationListenerC0084 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ e f295;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0080(e eVar) {
            super(null);
            this.f295 = eVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f295.m386();
            d.this.f289 = false;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$Ԫ, reason: contains not printable characters */
    public class C0081 extends AbstractAnimationAnimationListenerC0084 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ e f297;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final /* synthetic */ String f298;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0081(e eVar, String str) {
            super(null);
            this.f297 = eVar;
            this.f298 = str;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            d.this.removeView(this.f297);
            d.this.f292.m389(this.f298);
            d.this.f289 = false;
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$Ԭ, reason: contains not printable characters */
    public class RunnableC0082 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ Activity f300;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final /* synthetic */ SslErrorHandler f301;

        /* renamed from: com.alipay.sdk.m.x.d$Ԭ$Ϳ, reason: contains not printable characters */
        public class DialogInterfaceOnClickListenerC0083 implements DialogInterface.OnClickListener {
            public DialogInterfaceOnClickListenerC0083() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                RunnableC0082.this.f301.cancel();
                q9.m8091(d.this.f290, "net", "SSLDenied", "2");
                ac.m25(ac.m23());
                RunnableC0082.this.f300.finish();
            }
        }

        public RunnableC0082(Activity activity, SslErrorHandler sslErrorHandler) {
            this.f300 = activity;
            this.f301 = sslErrorHandler;
        }

        @Override // java.lang.Runnable
        public void run() {
            tb.m8300(this.f300, "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，请安装支付宝后重试。", "确定", new DialogInterfaceOnClickListenerC0083(), null, null);
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$Ԯ, reason: contains not printable characters */
    public static abstract class AbstractAnimationAnimationListenerC0084 implements Animation.AnimationListener {
        public AbstractAnimationAnimationListenerC0084() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        public /* synthetic */ AbstractAnimationAnimationListenerC0084(RunnableC0079 runnableC0079) {
            this();
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$ՠ, reason: contains not printable characters */
    public static class C0085 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final WeakReference<e> f304;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String f305;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final String f306;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public final JSONObject f307;

        /* renamed from: ԫ, reason: contains not printable characters */
        public boolean f308 = false;

        public C0085(e eVar, String str, String str2, JSONObject jSONObject) {
            this.f304 = new WeakReference<>(eVar);
            this.f305 = str;
            this.f306 = str2;
            this.f307 = jSONObject;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static String m374(String str) {
            return TextUtils.isEmpty(str) ? "" : str.replace("'", "");
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m375(JSONObject jSONObject) {
            e eVar;
            if (this.f308 || (eVar = (e) ug.m8403(this.f304)) == null) {
                return;
            }
            this.f308 = true;
            eVar.m389(String.format("javascript:window.AlipayJSBridge.callBackFromNativeFunc('%s','%s');", m374(this.f306), m374(jSONObject.toString())));
        }
    }

    /* renamed from: com.alipay.sdk.m.x.d$ֈ, reason: contains not printable characters */
    public static class C0086 implements je.InterfaceC2125 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C0085 f309;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final String f310;

        public C0086(C0085 c0085, String str) {
            this.f309 = c0085;
            this.f310 = str;
        }

        @Override // defpackage.je.InterfaceC2125
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo376(boolean z, JSONObject jSONObject, String str) throws JSONException {
            try {
                this.f309.m375(new JSONObject().put("success", z).put("random", this.f310).put("code", jSONObject).put(NotificationCompat.CATEGORY_STATUS, str));
            } catch (JSONException unused) {
            }
        }
    }

    public d(Activity activity, pa paVar, String str) {
        super(activity, str);
        this.f287 = true;
        this.f288 = "GET";
        this.f289 = false;
        this.f292 = null;
        this.f293 = new ag();
        this.f290 = paVar;
        m371();
    }

    @Override // android.view.ViewGroup
    public synchronized boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f289 ? true : super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0094
    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized boolean mo353(e eVar, String str) {
        q9.m8086(this.f290, "biz", "h5ldd", SystemClock.elapsedRealtime() + "|" + ug.m8451(str));
        m372();
        eVar.getRefreshButton().setVisibility(0);
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0093
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized boolean mo354(e eVar, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str2.startsWith("<head>") && str2.contains("sdk_result_code:")) {
            this.f285.runOnUiThread(new RunnableC0079());
        }
        jsPromptResult.cancel();
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0094
    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized boolean mo355(e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Activity activity = this.f285;
        if (activity == null) {
            return true;
        }
        if (ug.m8422(this.f290, str, activity)) {
            return true;
        }
        if (str.startsWith("alipayjsbridge://")) {
            m366(str.substring(17));
        } else if (TextUtils.equals(str, "sdklite://h5quit")) {
            m365(false);
        } else if (str.startsWith("http://") || str.startsWith("https://")) {
            this.f292.m389(str);
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                activity.startActivity(intent);
            } catch (Throwable th) {
                q9.m8089(this.f290, "biz", th);
            }
        }
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0094
    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized boolean mo356(e eVar, String str) {
        q9.m8086(this.f290, "biz", "h5ld", SystemClock.elapsedRealtime() + "|" + ug.m8451(str));
        if (!TextUtils.isEmpty(str) && !str.endsWith(".apk")) {
            m372();
        }
        return false;
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0094
    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized boolean mo357(e eVar, SslErrorHandler sslErrorHandler, SslError sslError) {
        Activity activity = this.f285;
        if (activity == null) {
            return true;
        }
        q9.m8091(this.f290, "net", "SSLError", "2-" + sslError);
        activity.runOnUiThread(new RunnableC0082(activity, sslErrorHandler));
        return true;
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0093
    /* renamed from: Ԭ, reason: contains not printable characters */
    public synchronized void mo358(e eVar, String str) {
        if (!str.startsWith("http") && !eVar.getUrl().endsWith(str)) {
            this.f292.getTitle().setText(str);
        }
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0094
    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized boolean mo359(e eVar, int i, String str, String str2) {
        this.f291 = true;
        q9.m8091(this.f290, "net", "webError", "onReceivedError:" + i + "|" + str2);
        eVar.getRefreshButton().setVisibility(0);
        return false;
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0095
    /* renamed from: Ԯ, reason: contains not printable characters */
    public synchronized void mo360(e eVar) {
        eVar.getWebView().reload();
        eVar.getRefreshButton().setVisibility(4);
    }

    @Override // com.alipay.sdk.m.x.e.InterfaceC0095
    /* renamed from: ԯ, reason: contains not printable characters */
    public synchronized void mo361(e eVar) {
        m370();
    }

    @Override // com.alipay.sdk.m.x.c
    /* renamed from: ׯ */
    public synchronized boolean mo348() {
        Activity activity = this.f285;
        if (activity == null) {
            return true;
        }
        if (!m347()) {
            if (!this.f289) {
                m370();
            }
            return true;
        }
        e eVar = this.f292;
        if (eVar != null && eVar.getWebView() != null) {
            if (!eVar.getWebView().canGoBack()) {
                ac.m25(ac.m23());
                activity.finish();
            } else if (m368()) {
                com.alipay.sdk.m.j.c cVarB = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.NETWORK_ERROR.m342());
                ac.m25(ac.m24(cVarB.m342(), cVarB.m341(), ""));
                activity.finish();
            }
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.alipay.sdk.m.x.c
    /* renamed from: ؠ */
    public synchronized void mo349() {
        this.f292.m386();
        this.f293.m41();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public synchronized void m362(String str) {
        if ("POST".equals(this.f288)) {
            this.f292.m390(str, null);
        } else {
            this.f292.m389(str);
        }
        c.m345(this.f292.getWebView());
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final synchronized void m363(String str, String str2, String str3) {
        e eVar = this.f292;
        if (eVar == null) {
            return;
        }
        JSONObject jSONObjectM8448 = ug.m8448(str3);
        C0085 c0085 = new C0085(eVar, str, str2, jSONObjectM8448);
        Context context = eVar.getContext();
        try {
            switch (c0085.f305) {
                case "title":
                    if (jSONObjectM8448.has("title")) {
                        eVar.getTitle().setText(jSONObjectM8448.optString("title", ""));
                        break;
                    }
                    break;
                case "refresh":
                    eVar.getWebView().reload();
                    break;
                case "back":
                    m373();
                    break;
                case "exit":
                    ac.m25(jSONObjectM8448.optString("result", null));
                    m365(jSONObjectM8448.optBoolean("success", false));
                    break;
                case "backButton":
                    eVar.getBackButton().setVisibility(jSONObjectM8448.optBoolean("show", true) ? 0 : 4);
                    break;
                case "refreshButton":
                    eVar.getRefreshButton().setVisibility(jSONObjectM8448.optBoolean("show", true) ? 0 : 4);
                    break;
                case "pushWindow":
                    m367(jSONObjectM8448.optString(ImagesContract.URL), jSONObjectM8448.optString("title", ""));
                    break;
                case "sdkInfo":
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdk_version", "15.8.11");
                    jSONObject.put("app_name", this.f290.m7950());
                    jSONObject.put("app_version", this.f290.m7954());
                    c0085.m375(jSONObject);
                    break;
                case "canUseTaoLogin":
                    String url = eVar.getUrl();
                    if (!ug.m8421(this.f290, url)) {
                        q9.m8091(this.f290, "biz", "jsUrlErr", url);
                        break;
                    } else {
                        JSONObject jSONObject2 = new JSONObject();
                        boolean zM7117 = je.m7117(this.f290, context);
                        jSONObject2.put("enabled", zM7117);
                        q9.m8086(this.f290, "biz", "TbChk", String.valueOf(zM7117));
                        c0085.m375(jSONObject2);
                        break;
                    }
                case "taoLogin":
                    String url2 = eVar.getUrl();
                    if (!ug.m8421(this.f290, url2)) {
                        q9.m8091(this.f290, "biz", "jsUrlErr", url2);
                        break;
                    } else {
                        String strOptString = jSONObjectM8448.optString("random");
                        JSONObject jSONObjectOptJSONObject = jSONObjectM8448.optJSONObject("options");
                        if (!TextUtils.isEmpty("random") && jSONObjectOptJSONObject != null) {
                            String strOptString2 = jSONObjectOptJSONObject.optString(ImagesContract.URL);
                            String strOptString3 = jSONObjectOptJSONObject.optString("action");
                            if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && (context instanceof Activity)) {
                                je.m7116(this.f290, (Activity) context, 1010, strOptString2, strOptString3, new C0086(c0085, strOptString));
                                break;
                            }
                        }
                    }
                    break;
            }
        } catch (Throwable th) {
            q9.m8088(this.f290, "biz", "jInfoErr", th, str);
        }
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public synchronized void m364(String str, String str2, boolean z) {
        this.f288 = str2;
        this.f292.getTitle().setText(str);
        this.f287 = z;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final synchronized void m365(boolean z) {
        ac.m26(z);
        this.f285.finish();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final synchronized void m366(String str) {
        Map<String, String> mapM8428 = ug.m8428(this.f290, str);
        if (str.startsWith("callNativeFunc")) {
            m363(mapM8428.get("func"), mapM8428.get("cbId"), mapM8428.get("data"));
        } else if (str.startsWith("onBack")) {
            m373();
        } else if (str.startsWith("setTitle") && mapM8428.containsKey("title")) {
            this.f292.getTitle().setText(mapM8428.get("title"));
        } else if (str.startsWith("onRefresh")) {
            this.f292.getWebView().reload();
        } else if (str.startsWith("showBackButton") && mapM8428.containsKey("bshow")) {
            this.f292.getBackButton().setVisibility(TextUtils.equals("true", mapM8428.get("bshow")) ? 0 : 4);
        } else if (str.startsWith("onExit")) {
            ac.m25(mapM8428.get("result"));
            m365(TextUtils.equals("true", mapM8428.get("bsucc")));
        } else if (str.startsWith("onLoadJs")) {
            this.f292.m389("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n");
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final synchronized boolean m367(String str, String str2) {
        e eVar = this.f292;
        try {
            e eVar2 = new e(this.f285, this.f290, new e.C0092(!m347(), !m347()));
            this.f292 = eVar2;
            eVar2.setChromeProxy(this);
            this.f292.setWebClientProxy(this);
            this.f292.setWebEventProxy(this);
            if (!TextUtils.isEmpty(str2)) {
                this.f292.getTitle().setText(str2);
            }
            this.f289 = true;
            this.f293.m42(eVar);
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new C0081(eVar, str));
            this.f292.setAnimation(translateAnimation);
            addView(this.f292);
        } catch (Throwable unused) {
            return false;
        }
        return true;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public boolean m368() {
        return this.f291;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final synchronized boolean m369() {
        if (this.f293.m43()) {
            this.f285.finish();
        } else {
            this.f289 = true;
            e eVar = this.f292;
            this.f292 = this.f293.m44();
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(400L);
            translateAnimation.setFillAfter(false);
            translateAnimation.setAnimationListener(new C0080(eVar));
            eVar.setAnimation(translateAnimation);
            removeView(eVar);
            addView(this.f292);
        }
        return true;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final synchronized void m370() {
        Activity activity = this.f285;
        e eVar = this.f292;
        if (activity != null && eVar != null) {
            if (this.f287) {
                activity.finish();
            } else {
                eVar.m389("javascript:window.AlipayJSBridge.callListener('h5BackAction');");
            }
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final synchronized boolean m371() {
        try {
            e eVar = new e(this.f285, this.f290, new e.C0092(!m347(), !m347()));
            this.f292 = eVar;
            eVar.setChromeProxy(this);
            this.f292.setWebClientProxy(this);
            this.f292.setWebEventProxy(this);
            addView(this.f292);
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m372() {
        e eVar = this.f292;
        if (eVar != null) {
            eVar.getWebView().loadUrl("javascript:(function() {\n    if (window.AlipayJSBridge) {\n        return\n    }\n\n    function alipayjsbridgeFunc(url) {\n        var iframe = document.createElement(\"iframe\");\n        iframe.style.width = \"1px\";\n        iframe.style.height = \"1px\";\n        iframe.style.display = \"none\";\n        iframe.src = url;\n        document.body.appendChild(iframe);\n        setTimeout(function() {\n            document.body.removeChild(iframe)\n        }, 100)\n    }\n    window.alipayjsbridgeSetTitle = function(title) {\n        document.title = title;\n        alipayjsbridgeFunc(\"alipayjsbridge://setTitle?title=\" + encodeURIComponent(title))\n    };\n    window.alipayjsbridgeRefresh = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onRefresh?\")\n    };\n    window.alipayjsbridgeBack = function() {\n        alipayjsbridgeFunc(\"alipayjsbridge://onBack?\")\n    };\n    window.alipayjsbridgeExit = function(bsucc) {\n        alipayjsbridgeFunc(\"alipayjsbridge://onExit?bsucc=\" + bsucc)\n    };\n    window.alipayjsbridgeShowBackButton = function(bshow) {\n        alipayjsbridgeFunc(\"alipayjsbridge://showBackButton?bshow=\" + bshow)\n    };\n    window.AlipayJSBridge = {\n        version: \"2.0\",\n        addListener: addListener,\n        hasListener: hasListener,\n        callListener: callListener,\n        callNativeFunc: callNativeFunc,\n        callBackFromNativeFunc: callBackFromNativeFunc\n    };\n    var uniqueId = 1;\n    var h5JsCallbackMap = {};\n\n    function iframeCall(paramStr) {\n        setTimeout(function() {\n        \tvar iframe = document.createElement(\"iframe\");\n        \tiframe.style.width = \"1px\";\n        \tiframe.style.height = \"1px\";\n        \tiframe.style.display = \"none\";\n        \tiframe.src = \"alipayjsbridge://callNativeFunc?\" + paramStr;\n        \tvar parent = document.body || document.documentElement;\n        \tparent.appendChild(iframe);\n        \tsetTimeout(function() {\n            \tparent.removeChild(iframe)\n        \t}, 0)\n        }, 0)\n    }\n\n    function callNativeFunc(nativeFuncName, data, h5JsCallback) {\n        var h5JsCallbackId = \"\";\n        if (h5JsCallback) {\n            h5JsCallbackId = \"cb_\" + (uniqueId++) + \"_\" + new Date().getTime();\n            h5JsCallbackMap[h5JsCallbackId] = h5JsCallback\n        }\n        var dataStr = \"\";\n        if (data) {\n            dataStr = encodeURIComponent(JSON.stringify(data))\n        }\n        var paramStr = \"func=\" + nativeFuncName + \"&cbId=\" + h5JsCallbackId + \"&data=\" + dataStr;\n        iframeCall(paramStr)\n    }\n\n    function callBackFromNativeFunc(h5JsCallbackId, data) {\n        var h5JsCallback = h5JsCallbackMap[h5JsCallbackId];\n        if (h5JsCallback) {\n            h5JsCallback(data);\n            delete h5JsCallbackMap[h5JsCallbackId]\n        }\n    }\n    var h5ListenerMap = {};\n\n    function addListener(jsFuncName, jsFunc) {\n        h5ListenerMap[jsFuncName] = jsFunc\n    }\n\n    function hasListener(jsFuncName) {\n        var jsFunc = h5ListenerMap[jsFuncName];\n        if (!jsFunc) {\n            return false\n        }\n        return true\n    }\n\n    function callListener(h5JsFuncName, data, nativeCallbackId) {\n        var responseCallback;\n        if (nativeCallbackId) {\n            responseCallback = function(responseData) {\n                var dataStr = \"\";\n                if (responseData) {\n                    dataStr = encodeURIComponent(JSON.stringify(responseData))\n                }\n                var paramStr = \"func=h5JsFuncCallback\" + \"&cbId=\" + nativeCallbackId + \"&data=\" + dataStr;\n                iframeCall(paramStr)\n            }\n        }\n        var h5JsFunc = h5ListenerMap[h5JsFuncName];\n        if (h5JsFunc) {\n            h5JsFunc(data, responseCallback)\n        } else if (h5JsFuncName == \"h5BackAction\") {\n            if (!window.alipayjsbridgeH5BackAction || !alipayjsbridgeH5BackAction()) {\n                var paramStr = \"func=back\";\n                iframeCall(paramStr)\n            }\n        } else {\n            console.log(\"AlipayJSBridge: no h5JsFunc \" + h5JsFuncName + data)\n        }\n    }\n    var event;\n    if (window.CustomEvent) {\n        event = new CustomEvent(\"alipayjsbridgeready\")\n    } else {\n        event = document.createEvent(\"Event\");\n        event.initEvent(\"alipayjsbridgeready\", true, true)\n    }\n    document.dispatchEvent(event);\n    setTimeout(excuteH5InitFuncs, 0);\n\n    function excuteH5InitFuncs() {\n        if (window.AlipayJSBridgeInitArray) {\n            var h5InitFuncs = window.AlipayJSBridgeInitArray;\n            delete window.AlipayJSBridgeInitArray;\n            for (var i = 0; i < h5InitFuncs.length; i++) {\n                try {\n                    h5InitFuncs[i](AlipayJSBridge)\n                } catch (e) {\n                    setTimeout(function() {\n                        throw e\n                    })\n                }\n            }\n        }\n    }\n})();\n;window.AlipayJSBridge.callListener('h5PageFinished');");
        }
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final synchronized void m373() {
        WebView webView = this.f292.getWebView();
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            ag agVar = this.f293;
            if (agVar == null || agVar.m43()) {
                m365(false);
            } else {
                m369();
            }
        }
    }
}
