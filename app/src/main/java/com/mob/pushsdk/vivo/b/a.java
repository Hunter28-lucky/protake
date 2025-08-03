package com.mob.pushsdk.vivo.b;

import android.text.TextUtils;
import com.mob.pushsdk.vivo.c.d;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class a {
    private int A;
    private String B;
    private int a;
    private String b;
    private boolean c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private int f17706e;
    private int f;
    private int g;
    private int h;
    private int j;
    private String k;
    private int l;
    private String m;
    private String n;
    private String o;
    private int p;
    private String q;
    private String r;
    private String s;
    private String t;
    private int u;
    private boolean v;
    private int x;
    private String y;
    private int z;
    private boolean i = false;
    private Map<String, String> w = new HashMap();

    public static a m(String str) {
        if (TextUtils.isEmpty(str)) {
            d.a().a("notify msg pack to obj is null", new Object[0]);
        }
        try {
            a aVar = new a();
            JSONArray jSONArray = new JSONArray(str);
            aVar.a(jSONArray.getInt(0));
            aVar.a(jSONArray.getString(1));
            aVar.b(jSONArray.getString(2));
            aVar.c(jSONArray.getString(3));
            aVar.b(jSONArray.getInt(4));
            aVar.d(jSONArray.getString(5));
            aVar.e(jSONArray.getString(6));
            aVar.f(jSONArray.getString(7));
            aVar.g(jSONArray.getString(8));
            aVar.c(jSONArray.getInt(9));
            aVar.a(jSONArray.getBoolean(10));
            if (jSONArray.length() > 11) {
                aVar.a(new Hashon().fromJson(jSONArray.getString(11)));
            }
            if (jSONArray.length() > 15) {
                aVar.g(jSONArray.getInt(12));
                aVar.j(jSONArray.getString(13));
                aVar.b(jSONArray.getBoolean(14));
                aVar.k(jSONArray.getString(15));
            }
            if (jSONArray.length() > 16) {
                aVar.h(jSONArray.getInt(16));
            }
            if (jSONArray.length() > 18) {
                aVar.d(jSONArray.getInt(17));
                aVar.h(jSONArray.getString(18));
            }
            if (jSONArray.length() > 19) {
                aVar.e(jSONArray.getInt(19));
            }
            if (jSONArray.length() > 20) {
                aVar.i(jSONArray.getInt(20));
            }
            if (jSONArray.length() > 21) {
                aVar.j(jSONArray.getInt(21));
            }
            if (jSONArray.length() > 22 && jSONArray.getBoolean(22)) {
                aVar.d();
            }
            if (jSONArray.length() > 24) {
                aVar.f(jSONArray.getInt(23));
                aVar.i(jSONArray.getString(24));
            }
            if (jSONArray.length() > 26) {
                aVar.k(jSONArray.getInt(25));
                aVar.l(jSONArray.getString(26));
            }
            return aVar;
        } catch (Throwable th) {
            d.a().a(th);
            return null;
        }
    }

    public void a(int i) {
        this.l = i;
    }

    public void b(String str) {
        this.n = str;
    }

    public void c(String str) {
        this.o = str;
    }

    public void d(String str) {
        this.q = str;
    }

    public void e(String str) {
        this.r = str;
    }

    public void f(String str) {
        this.s = str;
    }

    public void g(String str) {
        this.t = str;
    }

    public void h(String str) {
        this.y = str;
    }

    public void i(String str) {
        this.B = str;
    }

    public void j(String str) {
        this.b = str;
    }

    public void k(String str) {
        this.d = str;
    }

    public void l(String str) {
        this.k = str;
    }

    public void a(String str) {
        this.m = str;
    }

    public void b(int i) {
        this.p = i;
    }

    public void c(int i) {
        this.u = i;
    }

    public void d(int i) {
        this.x = i;
    }

    public void e(int i) {
        this.z = i;
    }

    public void f(int i) {
        this.A = i;
    }

    public void g(int i) {
        this.a = i;
    }

    public void h(int i) {
        this.f17706e = i;
    }

    public void i(int i) {
        this.f = i;
    }

    public void j(int i) {
        this.g = i;
        this.h = e();
    }

    public void k(int i) {
        this.j = i;
    }

    private int e() {
        int i = this.g;
        return ((i & 32) != 0 || (i & 16) == 0) ? 0 : 1;
    }

    public String a() {
        return this.t;
    }

    public int b() {
        return this.u;
    }

    public Map<String, String> c() {
        return this.w;
    }

    public void d() {
        this.i = true;
    }

    public void a(boolean z) {
        this.v = z;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void a(Map<String, String> map) {
        this.w = map;
    }
}
