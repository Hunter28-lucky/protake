package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.i0.e;

/* loaded from: classes.dex */
public class wf {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static volatile wf f8724 = null;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean f8725 = false;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public BroadcastReceiver f8731;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public aa f8726 = new aa("udid");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public aa f8727 = new aa("oaid");

    /* renamed from: Ԫ, reason: contains not printable characters */
    public aa f8729 = new aa("vaid");

    /* renamed from: ԩ, reason: contains not printable characters */
    public aa f8728 = new aa("aaid");

    /* renamed from: ԫ, reason: contains not printable characters */
    public gd f8730 = new gd();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static ff m8572(Cursor cursor) {
        String str;
        ff ffVar = new ff(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    ffVar.f6639 = cursor.getString(columnIndex);
                } else {
                    m8575("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    ffVar.f6640 = cursor.getInt(columnIndex2);
                } else {
                    m8575("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    ffVar.f6641 = cursor.getLong(columnIndex3);
                } else {
                    m8575("parseExpired fail, index < 0.");
                }
                return ffVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        m8575(str);
        return ffVar;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final wf m8573() {
        if (f8724 == null) {
            synchronized (wf.class) {
                if (f8724 == null) {
                    f8724 = new wf();
                }
            }
        }
        return f8724;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m8574(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m8575(String str) {
        if (f8725) {
            Log.d("OpenIdManager", str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0034  */
    /* renamed from: Ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m8576(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            m8575(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r7 == 0) goto L39
            ff r8 = m8572(r7)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.f6640     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r1 != r2) goto L34
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f6639     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L3c java.lang.Exception -> L3e
            if (r8 == 0) goto L35
        L34:
            r0 = 1
        L35:
            r7.close()
            return r0
        L39:
            if (r7 == 0) goto L59
            goto L56
        L3c:
            r8 = move-exception
            goto L5a
        L3e:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3c
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L3c
            r1.append(r8)     // Catch: java.lang.Throwable -> L3c
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L3c
            m8575(r8)     // Catch: java.lang.Throwable -> L3c
            if (r7 == 0) goto L59
        L56:
            r7.close()
        L59:
            return r0
        L5a:
            if (r7 == 0) goto L5f
            r7.close()
        L5f:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wf.m8576(android.content.Context):boolean");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m8577(PackageManager packageManager, String str) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            m8575("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m8578(Context context, aa aaVar) {
        String str;
        if (aaVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aaVar.m21()) {
                return aaVar.f22;
            }
            if (m8579(context, true)) {
                return m8580(context, aaVar);
            }
            str = "getId, isSupported = false.";
        }
        m8575(str);
        return null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m8579(Context context, boolean z) throws PackageManager.NameNotFoundException {
        if (this.f8730.m6096() && !z) {
            return this.f8730.m6099();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strM8574 = m8574(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strM8574)) {
            return false;
        }
        String strM8577 = m8577(packageManager, strM8574);
        if (this.f8730.m6096() && this.f8730.m6097(strM8577)) {
            m8575("use same version cache, safeVersion : ".concat(String.valueOf(strM8577)));
            return this.f8730.m6099();
        }
        this.f8730.m6098(strM8577);
        boolean zM8576 = m8576(context);
        m8575("query support, result : ".concat(String.valueOf(zM8576)));
        this.f8730.m6095(zM8576);
        return zM8576;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* renamed from: Ԯ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String m8580(android.content.Context r10, defpackage.aa r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f23
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            m8575(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            java.lang.String r6 = r11.f23     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9b
            if (r1 == 0) goto L7b
            ff r2 = m8572(r1)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r0 = r2.f6639     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.m20(r0)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            long r3 = r2.f6641     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.m19(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r3 = r2.f6640     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r11.m18(r3)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.<init>()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r4 = r11.f23     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.append(r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r11 = r11.f24     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r3.append(r11)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            m8575(r11)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            int r11 = r2.f6640     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L8f
            r9.m8581(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            boolean r11 = r9.m8579(r10, r8)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r11 != 0) goto L8f
            boolean r10 = r9.m8579(r10, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L76:
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L8c
        L7b:
            boolean r11 = r9.m8579(r10, r8)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            if (r11 == 0) goto L8f
            boolean r10 = r9.m8579(r10, r7)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
            goto L76
        L8c:
            m8575(r10)     // Catch: java.lang.Throwable -> L92 java.lang.Exception -> L95
        L8f:
            if (r1 == 0) goto Lbb
            goto Lb6
        L92:
            r10 = move-exception
            r0 = r1
            goto Lbc
        L95:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto L9d
        L99:
            r10 = move-exception
            goto Lbc
        L9b:
            r10 = move-exception
            r11 = r0
        L9d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L99
            r1.append(r10)     // Catch: java.lang.Throwable -> L99
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L99
            m8575(r10)     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto Lba
            r1 = r0
            r0 = r11
        Lb6:
            r1.close()
            goto Lbb
        Lba:
            r0 = r11
        Lbb:
            return r0
        Lbc:
            if (r0 == 0) goto Lc1
            r0.close()
        Lc1:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wf.m8580(android.content.Context, aa):java.lang.String");
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final synchronized void m8581(Context context) {
        if (this.f8731 != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f8731 = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
