package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class fn extends fp {
    private a a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, String> f5930a;

    public static class a {
        public static final a a = new a("get");
        public static final a b = new a("set");
        public static final a c = new a("result");
        public static final a d = new a(com.umeng.analytics.pro.d.O);

        /* renamed from: e, reason: collision with root package name */
        public static final a f17863e = new a("command");

        /* renamed from: a, reason: collision with other field name */
        private String f5931a;

        private a(String str) {
            this.f5931a = str;
        }

        public static a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            a aVar = a;
            if (aVar.toString().equals(lowerCase)) {
                return aVar;
            }
            a aVar2 = b;
            if (aVar2.toString().equals(lowerCase)) {
                return aVar2;
            }
            a aVar3 = d;
            if (aVar3.toString().equals(lowerCase)) {
                return aVar3;
            }
            a aVar4 = c;
            if (aVar4.toString().equals(lowerCase)) {
                return aVar4;
            }
            a aVar5 = f17863e;
            if (aVar5.toString().equals(lowerCase)) {
                return aVar5;
            }
            return null;
        }

        public String toString() {
            return this.f5931a;
        }
    }

    public fn() {
        this.a = a.a;
        this.f5930a = new HashMap();
    }

    public synchronized void a(Map<String, String> map) {
        this.f5930a.putAll(map);
    }

    public String b() {
        return null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m5495a() {
        return this.a;
    }

    public fn(Bundle bundle) {
        super(bundle);
        this.a = a.a;
        this.f5930a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = a.a(bundle.getString("ext_iq_type"));
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            this.a = a.a;
        } else {
            this.a = aVar;
        }
    }

    @Override // com.xiaomi.push.fp
    public Bundle a() {
        Bundle bundleA = super.a();
        a aVar = this.a;
        if (aVar != null) {
            bundleA.putString("ext_iq_type", aVar.toString());
        }
        return bundleA;
    }

    @Override // com.xiaomi.push.fp
    /* renamed from: a, reason: collision with other method in class */
    public String mo5496a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(fy.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(fy.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(fy.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f5930a.entrySet()) {
            sb.append(fy.a(entry.getKey()));
            sb.append("=\"");
            sb.append(fy.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(m5495a());
            sb.append("\">");
        }
        String strB = b();
        if (strB != null) {
            sb.append(strB);
        }
        sb.append(o());
        ft ftVarM5497a = m5497a();
        if (ftVarM5497a != null) {
            sb.append(ftVarM5497a.m5500a());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
