package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import defpackage.ac;
import defpackage.ba;
import defpackage.hg;
import defpackage.lc;
import defpackage.mc;
import defpackage.o9;
import defpackage.p9;
import defpackage.pa;
import defpackage.q9;
import defpackage.rg;
import defpackage.ug;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AuthTask {
    public static final Object c = hg.class;
    public Activity a;
    public o9 b;

    /* renamed from: com.alipay.sdk.app.AuthTask$Ϳ, reason: contains not printable characters */
    public class C0073 implements hg.InterfaceC1967 {
        public C0073() {
        }

        @Override // defpackage.hg.InterfaceC1967
        public void a() {
            AuthTask.this.m311();
        }

        @Override // defpackage.hg.InterfaceC1967
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.a = activity;
        mc.m7550().m7553(this.a);
        this.b = new o9(activity, "去支付宝授权");
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new pa(this.a, str, "auth"), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        pa paVar;
        paVar = new pa(this.a, str, "authV2");
        return rg.m8199(paVar, innerAuth(paVar, str, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1 A[Catch: all -> 0x0137, DONT_GENERATE, PHI: r9
      0x00c1: PHI (r9v11 java.lang.String) = (r9v2 java.lang.String), (r9v13 java.lang.String) binds: [B:16:0x00bf, B:9:0x006b] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x0006, B:8:0x0020, B:18:0x00ca, B:17:0x00c1, B:21:0x00d6, B:23:0x0123, B:24:0x012c, B:25:0x0136, B:15:0x0074, B:7:0x001a, B:14:0x0071), top: B:31:0x0003, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String innerAuth(defpackage.pa r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(pa, java.lang.String, boolean):java.lang.String");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m309(pa paVar, lc lcVar) {
        String[] strArrM7498 = lcVar.m7498();
        Bundle bundle = new Bundle();
        bundle.putString(ImagesContract.URL, strArrM7498[0]);
        Intent intent = new Intent(this.a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        pa.C2227.m7966(paVar, intent);
        this.a.startActivity(intent);
        Object obj = c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return ac.m23();
            }
        }
        String strM29 = ac.m29();
        return TextUtils.isEmpty(strM29) ? ac.m23() : strM29;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m310(Activity activity, String str, pa paVar) {
        String strM7945 = paVar.m7945(str);
        List<p9.C2226> listM7922 = p9.m7898().m7922();
        if (!p9.m7898().f8257 || listM7922 == null) {
            listM7922 = ba.f140;
        }
        if (!ug.m8419(paVar, this.a, listM7922, true)) {
            q9.m8085(paVar, "biz", "LogCalledH5");
            return m313(activity, strM7945, paVar);
        }
        hg hgVar = new hg(activity, paVar, m312());
        String strM6224 = hgVar.m6224(strM7945, false);
        hgVar.m6225();
        if (!TextUtils.equals(strM6224, "failed") && !TextUtils.equals(strM6224, "scheme_failed")) {
            return TextUtils.isEmpty(strM6224) ? ac.m23() : strM6224;
        }
        q9.m8085(paVar, "biz", "LogBindCalledH5");
        return m313(activity, strM7945, paVar);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m311() {
        o9 o9Var = this.b;
        if (o9Var != null) {
            o9Var.m7701();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final hg.InterfaceC1967 m312() {
        return new C0073();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* renamed from: ԫ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m313(android.app.Activity r4, java.lang.String r5, defpackage.pa r6) {
        /*
            r3 = this;
            r3.m314()
            r0 = 0
            la r1 = new la     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r1.<init>()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            ic r4 = r1.mo7969(r6, r4, r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            org.json.JSONObject r4 = r4.m6289()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.util.List r4 = defpackage.lc.m7493(r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.m311()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r5 = 0
        L25:
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r5 >= r1) goto L4a
            java.lang.Object r1 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            lc r1 = (defpackage.lc) r1     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.a r1 = r1.m7497()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.a r2 = com.alipay.sdk.m.r.a.WapPay     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r1 != r2) goto L47
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            lc r4 = (defpackage.lc) r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r4 = r3.m309(r6, r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.m311()
            return r4
        L47:
            int r5 = r5 + 1
            goto L25
        L4a:
            r3.m311()
            goto L6b
        L4e:
            r4 = move-exception
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            defpackage.q9.m8087(r6, r5, r1, r4)     // Catch: java.lang.Throwable -> L86
            goto L68
        L57:
            r4 = move-exception
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch: java.lang.Throwable -> L86
            int r5 = r5.m342()     // Catch: java.lang.Throwable -> L86
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.b(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "net"
            defpackage.q9.m8089(r6, r0, r4)     // Catch: java.lang.Throwable -> L86
            r0 = r5
        L68:
            r3.m311()
        L6b:
            if (r0 != 0) goto L77
            com.alipay.sdk.m.j.c r4 = com.alipay.sdk.m.j.c.FAILED
            int r4 = r4.m342()
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r4)
        L77:
            int r4 = r0.m342()
            java.lang.String r5 = r0.m341()
            java.lang.String r6 = ""
            java.lang.String r4 = defpackage.ac.m24(r4, r5, r6)
            return r4
        L86:
            r4 = move-exception
            r3.m311()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.m313(android.app.Activity, java.lang.String, pa):java.lang.String");
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m314() {
        o9 o9Var = this.b;
        if (o9Var != null) {
            o9Var.m7702();
        }
    }
}
