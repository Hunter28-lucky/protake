package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.d;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C4716;
import defpackage.pa;
import defpackage.q9;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.jcodec.platform.Platform;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AlipayResultActivity extends Activity {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final ConcurrentHashMap<String, InterfaceC0072> f222 = new ConcurrentHashMap<>();

    /* renamed from: com.alipay.sdk.app.AlipayResultActivity$Ϳ, reason: contains not printable characters */
    public interface InterfaceC0072 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo308(int i, String str, String str2);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th;
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra(d.aw);
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                pa paVarM7965 = pa.C2227.m7965(stringExtra);
                if (paVarM7965 == null) {
                    finish();
                    return;
                }
                q9.m8086(paVarM7965, "biz", "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    m307(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), Platform.UTF_8));
                        jSONObject = jSONObject2.getJSONObject("result");
                        stringExtra = jSONObject2.getString(d.aw);
                        q9.m8086(paVarM7965, "biz", "BSPUriSession", stringExtra);
                        bundle2 = new Bundle();
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            bundle2.putString(next, jSONObject.getString(next));
                        }
                        bundleExtra = bundle2;
                    } catch (Throwable th3) {
                        th = th3;
                        bundleExtra = bundle2;
                        q9.m8087(paVarM7965, "biz", "BSPResEx", th);
                        q9.m8087(paVarM7965, "biz", "ParseSchemeQueryError", th);
                        if (TextUtils.isEmpty(stringExtra)) {
                        }
                        q9.m8092(this, paVarM7965, "", paVarM7965.f8291);
                        finish();
                        return;
                    }
                }
                if (!TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    q9.m8092(this, paVarM7965, "", paVarM7965.f8291);
                    finish();
                    return;
                }
                try {
                    q9.m8086(paVarM7965, "biz", "PgReturn", "" + SystemClock.elapsedRealtime());
                    q9.m8086(paVarM7965, "biz", "PgReturnV", bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString("memo", Constants.ACCEPT_TIME_SEPARATOR_SERVER));
                    C4716.m14254(stringExtra, 9000, "OK", bundleExtra);
                    q9.m8092(this, paVarM7965, "", paVarM7965.f8291);
                    finish();
                } catch (Throwable th4) {
                    q9.m8092(this, paVarM7965, "", paVarM7965.f8291);
                    finish();
                    throw th4;
                }
            } catch (Throwable th5) {
                q9.m8087(null, "biz", "BSPSerError", th5);
                q9.m8087(null, "biz", "ParseBundleSerializableError", th5);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m307(String str, Bundle bundle) {
        InterfaceC0072 interfaceC0072Remove = f222.remove(str);
        if (interfaceC0072Remove == null) {
            return;
        }
        try {
            interfaceC0072Remove.mo308(bundle.getInt("endCode"), bundle.getString("memo"), bundle.getString("result"));
        } finally {
            finish();
        }
    }
}
