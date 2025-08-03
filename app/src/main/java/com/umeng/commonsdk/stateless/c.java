package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* compiled from: UMSLNetWorkSenderHelper.java */
/* loaded from: classes2.dex */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public c(Context context) {
        this.c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.i = a.h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f3 A[EXC_TOP_SPLITTER, PHI: r1 r3 r11
      0x00f3: PHI (r1v3 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v4 boolean), (r1v4 boolean) binds: [B:32:0x010a, B:39:0x0119, B:50:0x00f3, B:20:0x00f0] A[DONT_GENERATE, DONT_INLINE]
      0x00f3: PHI (r3v10 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v13 java.io.OutputStream), (r3v13 java.io.OutputStream) binds: [B:32:0x010a, B:39:0x0119, B:50:0x00f3, B:20:0x00f0] A[DONT_GENERATE, DONT_INLINE]
      0x00f3: PHI (r11v8 ??) = (r11v5 ??), (r11v6 ??), (r11v12 ??), (r11v12 ??) binds: [B:32:0x010a, B:39:0x0119, B:50:0x00f3, B:20:0x00f0] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011c A[PHI: r1 r3 r11
      0x011c: PHI (r1v2 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v3 boolean) binds: [B:32:0x010a, B:39:0x0119, B:21:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x011c: PHI (r3v9 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v10 java.io.OutputStream) binds: [B:32:0x010a, B:39:0x0119, B:21:0x00f3] A[DONT_GENERATE, DONT_INLINE]
      0x011c: PHI (r11v7 ??) = (r11v5 ??), (r11v6 ??), (r11v8 ??) binds: [B:32:0x010a, B:39:0x0119, B:21:0x00f3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.net.HttpURLConnection, java.net.URLConnection, javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
