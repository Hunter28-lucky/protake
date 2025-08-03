package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes2.dex */
public class q {
    private static p a;

    /* renamed from: a, reason: collision with other field name */
    private static a f6474a;

    public interface a {
        void a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized p m5807a(Context context) {
        p pVar = a;
        if (pVar != null) {
            return pVar;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
        String string = sharedPreferences.getString("uuid", null);
        String string2 = sharedPreferences.getString("token", null);
        String string3 = sharedPreferences.getString("security", null);
        String string4 = sharedPreferences.getString(Constants.APP_ID, null);
        String string5 = sharedPreferences.getString("app_token", null);
        String string6 = sharedPreferences.getString("package_name", null);
        int i = sharedPreferences.getInt("env_type", 1);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            return null;
        }
        p pVar2 = new p(string, string2, string3, string4, string5, string6, i);
        a = pVar2;
        return pVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0319 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0085), top: B:120:0x0005, inners: #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0085), top: B:120:0x0005, inners: #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0085), top: B:120:0x0005, inners: #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0085), top: B:120:0x0005, inners: #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0179 A[Catch: all -> 0x032e, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0022, B:10:0x0038, B:12:0x0044, B:16:0x0057, B:20:0x0063, B:24:0x006f, B:25:0x0079, B:31:0x008d, B:33:0x0096, B:35:0x00c0, B:37:0x00cc, B:38:0x00df, B:40:0x00e9, B:42:0x00ef, B:43:0x0103, B:45:0x0109, B:46:0x010e, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0085), top: B:120:0x0005, inners: #3, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.p a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.q.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.p");
    }

    private static String a(Context context, boolean z) {
        String strA = b.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.y.b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (!com.xiaomi.push.n.China.name().equals(strA)) {
            return null;
        }
        return "https://cn.register.xmpush.xiaomi.com" + str;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m5810a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putInt("enc_req_fail_count", i);
        editorEdit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putString("uuid", pVar.f6473a);
        editorEdit.putString("security", pVar.c);
        editorEdit.putString("token", pVar.b);
        editorEdit.putString(Constants.APP_ID, pVar.d);
        editorEdit.putString("package_name", pVar.f);
        editorEdit.putString("app_token", pVar.f17903e);
        editorEdit.putInt("env_type", pVar.a);
        editorEdit.commit();
        a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5809a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    public static void a(a aVar) {
        f6474a = aVar;
    }

    public static void a() {
        a aVar = f6474a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5808a(Context context) {
        p pVarM5807a = m5807a(context);
        if (pVarM5807a != null && !TextUtils.isEmpty(pVarM5807a.f6473a)) {
            String[] strArrSplit = pVarM5807a.f6473a.split("@");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        }
        return null;
    }
}
