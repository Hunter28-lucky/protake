package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b {
    private static volatile b a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5514a;

    /* renamed from: a, reason: collision with other field name */
    private a f5515a;

    /* renamed from: a, reason: collision with other field name */
    public String f5516a;

    /* renamed from: a, reason: collision with other field name */
    private Map<String, a> f5517a;

    private b(Context context) {
        this.f5514a = context;
        c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static b m5140a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f5515a = new a(this.f5514a);
        this.f5517a = new HashMap();
        SharedPreferences sharedPreferencesA = a(this.f5514a);
        this.f5515a.f5519a = sharedPreferencesA.getString("appId", null);
        this.f5515a.b = sharedPreferencesA.getString("appToken", null);
        this.f5515a.c = sharedPreferencesA.getString("regId", null);
        this.f5515a.d = sharedPreferencesA.getString("regSec", null);
        this.f5515a.f17834e = sharedPreferencesA.getString("vName", null);
        this.f5515a.f5520a = sharedPreferencesA.getBoolean("valid", true);
        this.f5515a.f5521b = sharedPreferencesA.getBoolean("paused", false);
        this.f5515a.a = sharedPreferencesA.getInt("envType", 1);
        this.f5515a.f = sharedPreferencesA.getString("regResource", null);
        this.f5515a.g = sharedPreferencesA.getString("appRegion", null);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5147b() {
        if (this.f5515a.m5154a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("Don't send message before initialization succeeded!");
        return false;
    }

    public String d() {
        return this.f5515a.d;
    }

    public String e() {
        return this.f5515a.f;
    }

    public String f() {
        return this.f5515a.g;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m5150d() {
        return (TextUtils.isEmpty(this.f5515a.f5519a) || TextUtils.isEmpty(this.f5515a.b) || TextUtils.isEmpty(this.f5515a.c) || TextUtils.isEmpty(this.f5515a.d)) ? false : true;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m5151e() {
        return this.f5515a.f5521b;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m5152f() {
        return !this.f5515a.f5520a;
    }

    public String b() {
        return this.f5515a.b;
    }

    public void b(String str, String str2, String str3) {
        this.f5515a.b(str, str2, str3);
    }

    public void b(String str) {
        this.f5517a.remove(str);
        a(this.f5514a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5144a() {
        Context context = this.f5514a;
        return !TextUtils.equals(com.xiaomi.push.g.m5511a(context, context.getPackageName()), this.f5515a.f17834e);
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5146b() {
        this.f5515a.b();
    }

    public static class a {

        /* renamed from: a, reason: collision with other field name */
        private Context f5518a;

        /* renamed from: a, reason: collision with other field name */
        public String f5519a;
        public String b;
        public String c;
        public String d;

        /* renamed from: e, reason: collision with root package name */
        public String f17834e;
        public String f;
        public String g;

        /* renamed from: a, reason: collision with other field name */
        public boolean f5520a = true;

        /* renamed from: b, reason: collision with other field name */
        public boolean f5521b = false;
        public int a = 1;

        public a(Context context) {
            this.f5518a = context;
        }

        public void a(String str, String str2, String str3) {
            this.f5519a = str;
            this.b = str2;
            this.f = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f5518a).edit();
            editorEdit.putString("appId", this.f5519a);
            editorEdit.putString("appToken", str2);
            editorEdit.putString("regResource", str3);
            editorEdit.commit();
        }

        public void b(String str, String str2, String str3) {
            this.c = str;
            this.d = str2;
            this.f17834e = a();
            this.f5520a = true;
            this.g = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f5518a).edit();
            editorEdit.putString("regId", str);
            editorEdit.putString("regSec", str2);
            editorEdit.putString("vName", a());
            editorEdit.putBoolean("valid", true);
            editorEdit.putString("appRegion", str3);
            editorEdit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f5519a = str;
            this.b = str2;
            this.f = str3;
        }

        public void a(String str, String str2) {
            this.c = str;
            this.d = str2;
            this.f17834e = a();
            this.f5520a = true;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5155a(String str, String str2) {
            boolean zEquals = TextUtils.equals(this.f5519a, str);
            boolean zEquals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.c);
            boolean z2 = !TextUtils.isEmpty(this.d);
            boolean z3 = zEquals && zEquals2 && z && z2;
            if (!z3) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s", Boolean.valueOf(zEquals), Boolean.valueOf(zEquals2), Boolean.valueOf(z), Boolean.valueOf(z2)));
            }
            return z3;
        }

        public void b() {
            this.f5520a = false;
            b.a(this.f5518a).edit().putBoolean("valid", this.f5520a).commit();
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5154a() {
            return m5155a(this.f5519a, this.b);
        }

        private String a() {
            Context context = this.f5518a;
            return com.xiaomi.push.g.m5511a(context, context.getPackageName());
        }

        /* renamed from: a, reason: collision with other method in class */
        public void m5153a() {
            b.a(this.f5518a).edit().clear().commit();
            this.f5519a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.f17834e = null;
            this.f5520a = false;
            this.f5521b = false;
            this.g = null;
            this.a = 1;
        }

        public void a(boolean z) {
            this.f5521b = z;
        }

        public void a(int i) {
            this.a = i;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f5519a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.c = jSONObject.getString("regId");
                aVar.d = jSONObject.getString("regSec");
                aVar.f17834e = jSONObject.getString("vName");
                aVar.f5520a = jSONObject.getBoolean("valid");
                aVar.f5521b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.f = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f5519a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.c);
                jSONObject.put("regSec", aVar.d);
                jSONObject.put("vName", aVar.f17834e);
                jSONObject.put("valid", aVar.f5520a);
                jSONObject.put("paused", aVar.f5521b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.f);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5143a(String str) {
        SharedPreferences.Editor editorEdit = a(this.f5514a).edit();
        editorEdit.putString("vName", str);
        editorEdit.commit();
        this.f5515a.f17834e = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5141a() {
        return this.f5515a.f5519a;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m5148c() {
        return this.f5515a.c;
    }

    public boolean a(String str, String str2) {
        return this.f5515a.m5155a(str, str2);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5149c() {
        return this.f5515a.m5154a();
    }

    public void a(String str, String str2, String str3) {
        this.f5515a.a(str, str2, str3);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5142a() {
        this.f5515a.m5153a();
    }

    public a a(String str) {
        if (this.f5517a.containsKey(str)) {
            return this.f5517a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences sharedPreferencesA = a(this.f5514a);
        if (!sharedPreferencesA.contains(str2)) {
            return null;
        }
        a aVarA = a.a(this.f5514a, sharedPreferencesA.getString(str2, ""));
        this.f5517a.put(str2, aVarA);
        return aVarA;
    }

    public void a(String str, a aVar) {
        this.f5517a.put(str, aVar);
        a(this.f5514a).edit().putString("hybrid_app_info_" + str, a.a(aVar)).commit();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5145a(String str, String str2, String str3) {
        a aVarA = a(str3);
        return aVarA != null && TextUtils.equals(str, aVarA.f5519a) && TextUtils.equals(str2, aVarA.b);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public int a() {
        return this.f5515a.a;
    }

    public void a(boolean z) {
        this.f5515a.a(z);
        a(this.f5514a).edit().putBoolean("paused", z).commit();
    }

    public void a(int i) {
        this.f5515a.a(i);
        a(this.f5514a).edit().putInt("envType", i).commit();
    }
}
