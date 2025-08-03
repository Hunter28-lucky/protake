package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* loaded from: classes2.dex */
class ar implements aj {
    private static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String b = a + "OAID";
    private static String c = a + "VAID_";
    private static String d = a + "AAID_";

    /* renamed from: e, reason: collision with root package name */
    private static String f17838e = a + "OAIDSTATUS";
    private static String f = "persist.sys.identifierid.supported";

    /* renamed from: a, reason: collision with other field name */
    private Context f5600a;

    public ar(Context context) {
        this.f5600a = context;
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public boolean mo5202a() {
        return "1".equals(q.a(f, "0"));
    }

    @Override // com.xiaomi.push.aj
    /* renamed from: a */
    public String mo5201a() {
        return a(b);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002a A[PHI: r0 r10
      0x002a: PHI (r0v5 java.lang.String) = (r0v0 java.lang.String), (r0v9 java.lang.String) binds: [B:19:0x0039, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r10v6 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v7 android.database.Cursor) binds: [B:19:0x0039, B:11:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r10) throws java.lang.Throwable {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f5600a     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L38
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L38
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L38
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L38
            if (r10 == 0) goto L28
            boolean r1 = r10.moveToNext()     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L39
            if (r1 == 0) goto L28
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L39
            java.lang.String r0 = r10.getString(r1)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L39
            goto L28
        L26:
            r0 = move-exception
            goto L32
        L28:
            if (r10 == 0) goto L3c
        L2a:
            r10.close()
            goto L3c
        L2e:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L32:
            if (r10 == 0) goto L37
            r10.close()
        L37:
            throw r0
        L38:
            r10 = r0
        L39:
            if (r10 == 0) goto L3c
            goto L2a
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ar.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (providerInfoResolveContentProvider != null) {
                if ((providerInfoResolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
