package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.umcrash.UMCrash;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class qa {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static Context f8443;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static qa f8444;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f8445;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f8446;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f8447;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f8448;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f8449;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f8450 = false;

    /* renamed from: qa$Ϳ, reason: contains not printable characters */
    public static class C2254 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static String m8119() {
            String packageName;
            try {
                packageName = qa.f8443.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                hf.m6205(th);
                packageName = "";
            }
            return (packageName + "0000000000000000000000000000").substring(0, 24);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static String m8120(String str, String str2, boolean z) {
            if (qa.f8443 == null) {
                return null;
            }
            String string = qa.f8443.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = nf.m7653(m8119(), string, string);
                if (TextUtils.isEmpty(string)) {
                    hf.m6207("mspl", "tid_str: pref failed");
                }
            }
            hf.m6207("mspl", "tid_str: from local");
            return string;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public static void m8121(String str, String str2, String str3, boolean z) {
            if (qa.f8443 == null) {
                return;
            }
            SharedPreferences sharedPreferences = qa.f8443.getSharedPreferences(str, 0);
            if (z) {
                String strM8119 = m8119();
                String strM7655 = nf.m7655(strM8119, str3, str3);
                if (TextUtils.isEmpty(strM7655)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strM8119);
                }
                str3 = strM7655;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static void m8122(String str, String str2) {
            if (qa.f8443 == null) {
                return;
            }
            qa.f8443.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static synchronized qa m8106(Context context) {
        if (f8444 == null) {
            f8444 = new qa();
        }
        if (f8443 == null) {
            f8444.m8111(context);
        }
        return f8444;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8108(String str, String str2) throws JSONException {
        hf.m6207("mspl", "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f8445 = str;
        this.f8446 = str2;
        this.f8447 = System.currentTimeMillis();
        m8117();
        m8118();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m8109(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m8110() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m8111(Context context) {
        if (context != null) {
            f8443 = context.getApplicationContext();
        }
        if (this.f8450) {
            return;
        }
        this.f8450 = true;
        m8115();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String m8112() {
        return this.f8446;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public String m8113() {
        return this.f8445;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final String m8114() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* renamed from: ՠ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m8115() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = defpackage.qa.C2254.m8120(r3, r4, r5)     // Catch: java.lang.Exception -> L52
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L52
            if (r4 != 0) goto L4e
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L52
            r4.<init>(r3)     // Catch: java.lang.Exception -> L52
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L52
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L4b
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L48
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L48
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L48
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L46
            goto L59
        L46:
            r0 = move-exception
            goto L56
        L48:
            r0 = move-exception
            r6 = r2
            goto L56
        L4b:
            r0 = move-exception
            r5 = r2
            goto L55
        L4e:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L5b
        L52:
            r0 = move-exception
            r3 = r2
            r5 = r3
        L55:
            r6 = r5
        L56:
            defpackage.hf.m6205(r0)
        L59:
            r0 = r2
            r2 = r3
        L5b:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            defpackage.hf.m6207(r3, r4)
            boolean r3 = r9.m8109(r2, r5, r6, r0)
            if (r3 == 0) goto L6c
            r9.m8116()
            goto L7a
        L6c:
            r9.f8445 = r2
            r9.f8446 = r5
            long r1 = r1.longValue()
            r9.f8447 = r1
            r9.f8448 = r6
            r9.f8449 = r0
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qa.m8115():void");
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m8116() {
        this.f8445 = "";
        this.f8446 = m8110();
        this.f8447 = System.currentTimeMillis();
        this.f8448 = m8114();
        this.f8449 = m8114();
        C2254.m8122("alipay_tid_storage", "tidinfo");
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m8117() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.f8445);
            jSONObject.put("client_key", this.f8446);
            jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, this.f8447);
            jSONObject.put("vimei", this.f8448);
            jSONObject.put("vimsi", this.f8449);
            C2254.m8121("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
        } catch (Exception e2) {
            hf.m6205(e2);
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m8118() {
    }
}
