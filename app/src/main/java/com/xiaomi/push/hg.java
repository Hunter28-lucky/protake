package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class hg implements hr<hg, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f6154a;

    /* renamed from: a, reason: collision with other field name */
    public long f6155a;

    /* renamed from: a, reason: collision with other field name */
    public gu f6156a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6157a;

    /* renamed from: a, reason: collision with other field name */
    public String f6158a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f6160a;

    /* renamed from: b, reason: collision with other field name */
    public int f6162b;

    /* renamed from: b, reason: collision with other field name */
    public long f6163b;

    /* renamed from: b, reason: collision with other field name */
    public String f6164b;

    /* renamed from: c, reason: collision with other field name */
    public int f6166c;

    /* renamed from: c, reason: collision with other field name */
    public String f6167c;

    /* renamed from: d, reason: collision with other field name */
    public String f6169d;

    /* renamed from: e, reason: collision with other field name */
    public String f6170e;

    /* renamed from: f, reason: collision with other field name */
    public String f6171f;

    /* renamed from: g, reason: collision with other field name */
    public String f6172g;

    /* renamed from: h, reason: collision with other field name */
    public String f6173h;

    /* renamed from: i, reason: collision with other field name */
    public String f6174i;

    /* renamed from: j, reason: collision with other field name */
    public String f6175j;

    /* renamed from: k, reason: collision with other field name */
    public String f6176k;

    /* renamed from: l, reason: collision with other field name */
    public String f6177l;

    /* renamed from: m, reason: collision with other field name */
    public String f6178m;

    /* renamed from: n, reason: collision with other field name */
    public String f6179n;

    /* renamed from: o, reason: collision with other field name */
    public String f6180o;

    /* renamed from: p, reason: collision with other field name */
    public String f6181p;

    /* renamed from: q, reason: collision with other field name */
    public String f6182q;

    /* renamed from: r, reason: collision with other field name */
    public String f6183r;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6153a = new ig("XmPushActionRegistration");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17885e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 11, 8);
    private static final hy i = new hy("", (byte) 11, 9);
    private static final hy j = new hy("", (byte) 11, 10);
    private static final hy k = new hy("", (byte) 11, 11);
    private static final hy l = new hy("", (byte) 11, 12);
    private static final hy m = new hy("", (byte) 8, 13);
    private static final hy n = new hy("", (byte) 8, 14);
    private static final hy o = new hy("", (byte) 11, 15);
    private static final hy p = new hy("", (byte) 11, 16);
    private static final hy q = new hy("", (byte) 11, 17);
    private static final hy r = new hy("", (byte) 11, 18);
    private static final hy s = new hy("", (byte) 8, 19);
    private static final hy t = new hy("", (byte) 8, 20);
    private static final hy u = new hy("", (byte) 2, 21);
    private static final hy v = new hy("", (byte) 10, 22);
    private static final hy w = new hy("", (byte) 10, 23);
    private static final hy x = new hy("", (byte) 11, 24);
    private static final hy y = new hy("", (byte) 11, 25);
    private static final hy z = new hy("", (byte) 2, 26);
    private static final hy A = new hy("", com.umeng.analytics.pro.cb.k, 100);
    private static final hy B = new hy("", (byte) 2, 101);
    private static final hy C = new hy("", (byte) 11, 102);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6159a = new BitSet(8);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6161a = true;

    /* renamed from: c, reason: collision with other field name */
    public boolean f6168c = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f6165b = false;

    public boolean A() {
        return this.f6160a != null;
    }

    public boolean B() {
        return this.f6159a.get(7);
    }

    public boolean C() {
        return this.f6183r != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5619a() {
        return this.f6158a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5621b() {
        return this.f6157a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5622c() {
        return this.f6164b != null;
    }

    public boolean d() {
        return this.f6167c != null;
    }

    public boolean e() {
        return this.f6169d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return m5620a((hg) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6170e != null;
    }

    public boolean g() {
        return this.f6171f != null;
    }

    public boolean h() {
        return this.f6172g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6173h != null;
    }

    public boolean j() {
        return this.f6174i != null;
    }

    public boolean k() {
        return this.f6175j != null;
    }

    public boolean l() {
        return this.f6176k != null;
    }

    public boolean m() {
        return this.f6159a.get(0);
    }

    public boolean n() {
        return this.f6159a.get(1);
    }

    public boolean o() {
        return this.f6177l != null;
    }

    public boolean p() {
        return this.f6178m != null;
    }

    public boolean q() {
        return this.f6179n != null;
    }

    public boolean r() {
        return this.f6180o != null;
    }

    public boolean s() {
        return this.f6159a.get(2);
    }

    public boolean t() {
        return this.f6156a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m5619a()) {
            sb.append("debug:");
            String str = this.f6158a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m5621b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6157a;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f6164b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6167c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f6169d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6170e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f6171f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f6172g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f6173h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f6174i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f6175j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f6176k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f6154a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f6162b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f6177l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f6178m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f6179n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f6180o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f6166c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            gu guVar = this.f6156a;
            if (guVar == null) {
                sb.append("null");
            } else {
                sb.append(guVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f6161a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f6155a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6163b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f6181p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f6182q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f6165b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f6160a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f6168c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f6183r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f6159a.get(3);
    }

    public boolean v() {
        return this.f6159a.get(4);
    }

    public boolean w() {
        return this.f6159a.get(5);
    }

    public boolean x() {
        return this.f6181p != null;
    }

    public boolean y() {
        return this.f6182q != null;
    }

    public boolean z() {
        return this.f6159a.get(6);
    }

    public String a() {
        return this.f6164b;
    }

    public String b() {
        return this.f6167c;
    }

    public hg c(String str) {
        this.f6169d = str;
        return this;
    }

    public hg d(String str) {
        this.f6170e = str;
        return this;
    }

    public hg e(String str) {
        this.f6171f = str;
        return this;
    }

    public hg f(String str) {
        this.f6172g = str;
        return this;
    }

    public hg g(String str) {
        this.f6173h = str;
        return this;
    }

    public hg h(String str) {
        this.f6176k = str;
        return this;
    }

    public hg i(String str) {
        this.f6180o = str;
        return this;
    }

    public hg a(String str) {
        this.f6164b = str;
        return this;
    }

    public hg b(String str) {
        this.f6167c = str;
        return this;
    }

    public String c() {
        return this.f6171f;
    }

    public void d(boolean z2) {
        this.f6159a.set(3, z2);
    }

    public void e(boolean z2) {
        this.f6159a.set(4, z2);
    }

    public void f(boolean z2) {
        this.f6159a.set(5, z2);
    }

    public void g(boolean z2) {
        this.f6159a.set(6, z2);
    }

    public void h(boolean z2) {
        this.f6159a.set(7, z2);
    }

    public hg a(int i2) {
        this.f6154a = i2;
        a(true);
        return this;
    }

    public hg b(int i2) {
        this.f6162b = i2;
        b(true);
        return this;
    }

    public hg c(int i2) {
        this.f6166c = i2;
        c(true);
        return this;
    }

    public void a(boolean z2) {
        this.f6159a.set(0, z2);
    }

    public void b(boolean z2) {
        this.f6159a.set(1, z2);
    }

    public void c(boolean z2) {
        this.f6159a.set(2, z2);
    }

    public hg a(gu guVar) {
        this.f6156a = guVar;
        return this;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5618a();
        ibVar.a(f6153a);
        if (this.f6158a != null && m5619a()) {
            ibVar.a(a);
            ibVar.a(this.f6158a);
            ibVar.b();
        }
        if (this.f6157a != null && m5621b()) {
            ibVar.a(b);
            this.f6157a.b(ibVar);
            ibVar.b();
        }
        if (this.f6164b != null) {
            ibVar.a(c);
            ibVar.a(this.f6164b);
            ibVar.b();
        }
        if (this.f6167c != null) {
            ibVar.a(d);
            ibVar.a(this.f6167c);
            ibVar.b();
        }
        if (this.f6169d != null && e()) {
            ibVar.a(f17885e);
            ibVar.a(this.f6169d);
            ibVar.b();
        }
        if (this.f6170e != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6170e);
            ibVar.b();
        }
        if (this.f6171f != null) {
            ibVar.a(g);
            ibVar.a(this.f6171f);
            ibVar.b();
        }
        if (this.f6172g != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f6172g);
            ibVar.b();
        }
        if (this.f6173h != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6173h);
            ibVar.b();
        }
        if (this.f6174i != null && j()) {
            ibVar.a(j);
            ibVar.a(this.f6174i);
            ibVar.b();
        }
        if (this.f6175j != null && k()) {
            ibVar.a(k);
            ibVar.a(this.f6175j);
            ibVar.b();
        }
        if (this.f6176k != null && l()) {
            ibVar.a(l);
            ibVar.a(this.f6176k);
            ibVar.b();
        }
        if (m()) {
            ibVar.a(m);
            ibVar.mo5676a(this.f6154a);
            ibVar.b();
        }
        if (n()) {
            ibVar.a(n);
            ibVar.mo5676a(this.f6162b);
            ibVar.b();
        }
        if (this.f6177l != null && o()) {
            ibVar.a(o);
            ibVar.a(this.f6177l);
            ibVar.b();
        }
        if (this.f6178m != null && p()) {
            ibVar.a(p);
            ibVar.a(this.f6178m);
            ibVar.b();
        }
        if (this.f6179n != null && q()) {
            ibVar.a(q);
            ibVar.a(this.f6179n);
            ibVar.b();
        }
        if (this.f6180o != null && r()) {
            ibVar.a(r);
            ibVar.a(this.f6180o);
            ibVar.b();
        }
        if (s()) {
            ibVar.a(s);
            ibVar.mo5676a(this.f6166c);
            ibVar.b();
        }
        if (this.f6156a != null && t()) {
            ibVar.a(t);
            ibVar.mo5676a(this.f6156a.a());
            ibVar.b();
        }
        if (u()) {
            ibVar.a(u);
            ibVar.a(this.f6161a);
            ibVar.b();
        }
        if (v()) {
            ibVar.a(v);
            ibVar.a(this.f6155a);
            ibVar.b();
        }
        if (w()) {
            ibVar.a(w);
            ibVar.a(this.f6163b);
            ibVar.b();
        }
        if (this.f6181p != null && x()) {
            ibVar.a(x);
            ibVar.a(this.f6181p);
            ibVar.b();
        }
        if (this.f6182q != null && y()) {
            ibVar.a(y);
            ibVar.a(this.f6182q);
            ibVar.b();
        }
        if (z()) {
            ibVar.a(z);
            ibVar.a(this.f6165b);
            ibVar.b();
        }
        if (this.f6160a != null && A()) {
            ibVar.a(A);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6160a.size()));
            for (Map.Entry<String, String> entry : this.f6160a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (B()) {
            ibVar.a(B);
            ibVar.a(this.f6168c);
            ibVar.b();
        }
        if (this.f6183r != null && C()) {
            ibVar.a(C);
            ibVar.a(this.f6183r);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5620a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean zM5619a = m5619a();
        boolean zM5619a2 = hgVar.m5619a();
        if ((zM5619a || zM5619a2) && !(zM5619a && zM5619a2 && this.f6158a.equals(hgVar.f6158a))) {
            return false;
        }
        boolean zM5621b = m5621b();
        boolean zM5621b2 = hgVar.m5621b();
        if ((zM5621b || zM5621b2) && !(zM5621b && zM5621b2 && this.f6157a.m5571a(hgVar.f6157a))) {
            return false;
        }
        boolean zM5622c = m5622c();
        boolean zM5622c2 = hgVar.m5622c();
        if ((zM5622c || zM5622c2) && !(zM5622c && zM5622c2 && this.f6164b.equals(hgVar.f6164b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hgVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6167c.equals(hgVar.f6167c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hgVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6169d.equals(hgVar.f6169d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hgVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6170e.equals(hgVar.f6170e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hgVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6171f.equals(hgVar.f6171f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hgVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6172g.equals(hgVar.f6172g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hgVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6173h.equals(hgVar.f6173h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hgVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6174i.equals(hgVar.f6174i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hgVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6175j.equals(hgVar.f6175j))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hgVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f6176k.equals(hgVar.f6176k))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hgVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f6154a == hgVar.f6154a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hgVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f6162b == hgVar.f6162b)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hgVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f6177l.equals(hgVar.f6177l))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = hgVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f6178m.equals(hgVar.f6178m))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = hgVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f6179n.equals(hgVar.f6179n))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = hgVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f6180o.equals(hgVar.f6180o))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = hgVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f6166c == hgVar.f6166c)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = hgVar.t();
        if ((zT || zT2) && !(zT && zT2 && this.f6156a.equals(hgVar.f6156a))) {
            return false;
        }
        boolean zU = u();
        boolean zU2 = hgVar.u();
        if ((zU || zU2) && !(zU && zU2 && this.f6161a == hgVar.f6161a)) {
            return false;
        }
        boolean zV = v();
        boolean zV2 = hgVar.v();
        if ((zV || zV2) && !(zV && zV2 && this.f6155a == hgVar.f6155a)) {
            return false;
        }
        boolean zW = w();
        boolean zW2 = hgVar.w();
        if ((zW || zW2) && !(zW && zW2 && this.f6163b == hgVar.f6163b)) {
            return false;
        }
        boolean zX = x();
        boolean zX2 = hgVar.x();
        if ((zX || zX2) && !(zX && zX2 && this.f6181p.equals(hgVar.f6181p))) {
            return false;
        }
        boolean zY = y();
        boolean zY2 = hgVar.y();
        if ((zY || zY2) && !(zY && zY2 && this.f6182q.equals(hgVar.f6182q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = hgVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f6165b == hgVar.f6165b)) {
            return false;
        }
        boolean zA = A();
        boolean zA2 = hgVar.A();
        if ((zA || zA2) && !(zA && zA2 && this.f6160a.equals(hgVar.f6160a))) {
            return false;
        }
        boolean zB = B();
        boolean zB2 = hgVar.B();
        if ((zB || zB2) && !(zB && zB2 && this.f6168c == hgVar.f6168c)) {
            return false;
        }
        boolean zC = C();
        boolean zC2 = hgVar.C();
        if (zC || zC2) {
            return zC && zC2 && this.f6183r.equals(hgVar.f6183r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hg hgVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        int iA15;
        int iA16;
        int iA17;
        int iA18;
        int iA19;
        int iA20;
        int iA21;
        int iA22;
        int iA23;
        int iA24;
        int iA25;
        int iA26;
        int iA27;
        int iA28;
        int iA29;
        if (!getClass().equals(hgVar.getClass())) {
            return getClass().getName().compareTo(hgVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5619a()).compareTo(Boolean.valueOf(hgVar.m5619a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5619a() && (iA29 = hs.a(this.f6158a, hgVar.f6158a)) != 0) {
            return iA29;
        }
        int iCompareTo2 = Boolean.valueOf(m5621b()).compareTo(Boolean.valueOf(hgVar.m5621b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5621b() && (iA28 = hs.a(this.f6157a, hgVar.f6157a)) != 0) {
            return iA28;
        }
        int iCompareTo3 = Boolean.valueOf(m5622c()).compareTo(Boolean.valueOf(hgVar.m5622c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5622c() && (iA27 = hs.a(this.f6164b, hgVar.f6164b)) != 0) {
            return iA27;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA26 = hs.a(this.f6167c, hgVar.f6167c)) != 0) {
            return iA26;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA25 = hs.a(this.f6169d, hgVar.f6169d)) != 0) {
            return iA25;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA24 = hs.a(this.f6170e, hgVar.f6170e)) != 0) {
            return iA24;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA23 = hs.a(this.f6171f, hgVar.f6171f)) != 0) {
            return iA23;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA22 = hs.a(this.f6172g, hgVar.f6172g)) != 0) {
            return iA22;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA21 = hs.a(this.f6173h, hgVar.f6173h)) != 0) {
            return iA21;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA20 = hs.a(this.f6174i, hgVar.f6174i)) != 0) {
            return iA20;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA19 = hs.a(this.f6175j, hgVar.f6175j)) != 0) {
            return iA19;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hgVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA18 = hs.a(this.f6176k, hgVar.f6176k)) != 0) {
            return iA18;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hgVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA17 = hs.a(this.f6154a, hgVar.f6154a)) != 0) {
            return iA17;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hgVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA16 = hs.a(this.f6162b, hgVar.f6162b)) != 0) {
            return iA16;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hgVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA15 = hs.a(this.f6177l, hgVar.f6177l)) != 0) {
            return iA15;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hgVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA14 = hs.a(this.f6178m, hgVar.f6178m)) != 0) {
            return iA14;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hgVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA13 = hs.a(this.f6179n, hgVar.f6179n)) != 0) {
            return iA13;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hgVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA12 = hs.a(this.f6180o, hgVar.f6180o)) != 0) {
            return iA12;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hgVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA11 = hs.a(this.f6166c, hgVar.f6166c)) != 0) {
            return iA11;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hgVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (t() && (iA10 = hs.a(this.f6156a, hgVar.f6156a)) != 0) {
            return iA10;
        }
        int iCompareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hgVar.u()));
        if (iCompareTo21 != 0) {
            return iCompareTo21;
        }
        if (u() && (iA9 = hs.a(this.f6161a, hgVar.f6161a)) != 0) {
            return iA9;
        }
        int iCompareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hgVar.v()));
        if (iCompareTo22 != 0) {
            return iCompareTo22;
        }
        if (v() && (iA8 = hs.a(this.f6155a, hgVar.f6155a)) != 0) {
            return iA8;
        }
        int iCompareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hgVar.w()));
        if (iCompareTo23 != 0) {
            return iCompareTo23;
        }
        if (w() && (iA7 = hs.a(this.f6163b, hgVar.f6163b)) != 0) {
            return iA7;
        }
        int iCompareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hgVar.x()));
        if (iCompareTo24 != 0) {
            return iCompareTo24;
        }
        if (x() && (iA6 = hs.a(this.f6181p, hgVar.f6181p)) != 0) {
            return iA6;
        }
        int iCompareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hgVar.y()));
        if (iCompareTo25 != 0) {
            return iCompareTo25;
        }
        if (y() && (iA5 = hs.a(this.f6182q, hgVar.f6182q)) != 0) {
            return iA5;
        }
        int iCompareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hgVar.z()));
        if (iCompareTo26 != 0) {
            return iCompareTo26;
        }
        if (z() && (iA4 = hs.a(this.f6165b, hgVar.f6165b)) != 0) {
            return iA4;
        }
        int iCompareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hgVar.A()));
        if (iCompareTo27 != 0) {
            return iCompareTo27;
        }
        if (A() && (iA3 = hs.a(this.f6160a, hgVar.f6160a)) != 0) {
            return iA3;
        }
        int iCompareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hgVar.B()));
        if (iCompareTo28 != 0) {
            return iCompareTo28;
        }
        if (B() && (iA2 = hs.a(this.f6168c, hgVar.f6168c)) != 0) {
            return iA2;
        }
        int iCompareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hgVar.C()));
        if (iCompareTo29 != 0) {
            return iCompareTo29;
        }
        if (!C() || (iA = hs.a(this.f6183r, hgVar.f6183r)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hr
    public void a(ib ibVar) throws ic {
        ibVar.mo5671a();
        while (true) {
            hy hyVarMo5667a = ibVar.mo5667a();
            byte b2 = hyVarMo5667a.a;
            if (b2 == 0) {
                ibVar.f();
                m5618a();
                return;
            }
            short s2 = hyVarMo5667a.f6304a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f6158a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6157a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6164b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6167c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6169d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6170e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6171f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6172g = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6173h = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6174i = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f6175j = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f6176k = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 8) {
                        this.f6154a = ibVar.mo5665a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 8) {
                        this.f6162b = ibVar.mo5665a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f6177l = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 11) {
                        this.f6178m = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f6179n = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 11) {
                        this.f6180o = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 8) {
                        this.f6166c = ibVar.mo5665a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 8) {
                        this.f6156a = gu.a(ibVar.mo5665a());
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 2) {
                        this.f6161a = ibVar.mo5677a();
                        d(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 10) {
                        this.f6155a = ibVar.mo5666a();
                        e(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 10) {
                        this.f6163b = ibVar.mo5666a();
                        f(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 24:
                    if (b2 == 11) {
                        this.f6181p = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 25:
                    if (b2 == 11) {
                        this.f6182q = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 26:
                    if (b2 == 2) {
                        this.f6165b = ibVar.mo5677a();
                        g(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                ia iaVarMo5669a = ibVar.mo5669a();
                                this.f6160a = new HashMap(iaVarMo5669a.f6308a * 2);
                                for (int i2 = 0; i2 < iaVarMo5669a.f6308a; i2++) {
                                    this.f6160a.put(ibVar.mo5672a(), ibVar.mo5672a());
                                }
                                ibVar.h();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 101:
                            if (b2 == 2) {
                                this.f6168c = ibVar.mo5677a();
                                h(true);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 102:
                            if (b2 == 11) {
                                this.f6183r = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        default:
                            ie.a(ibVar, b2);
                            break;
                    }
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5618a() throws ic {
        if (this.f6164b != null) {
            if (this.f6167c != null) {
                if (this.f6171f != null) {
                    return;
                }
                throw new ic("Required field 'token' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
