package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hh implements hr<hh, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f6185a;

    /* renamed from: a, reason: collision with other field name */
    public long f6186a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6187a;

    /* renamed from: a, reason: collision with other field name */
    public String f6188a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f6190a;

    /* renamed from: b, reason: collision with other field name */
    public int f6192b;

    /* renamed from: b, reason: collision with other field name */
    public long f6193b;

    /* renamed from: b, reason: collision with other field name */
    public String f6194b;

    /* renamed from: c, reason: collision with other field name */
    public long f6195c;

    /* renamed from: c, reason: collision with other field name */
    public String f6196c;

    /* renamed from: d, reason: collision with other field name */
    public String f6197d;

    /* renamed from: e, reason: collision with other field name */
    public String f6198e;

    /* renamed from: f, reason: collision with other field name */
    public String f6199f;

    /* renamed from: g, reason: collision with other field name */
    public String f6200g;

    /* renamed from: h, reason: collision with other field name */
    public String f6201h;

    /* renamed from: i, reason: collision with other field name */
    public String f6202i;

    /* renamed from: j, reason: collision with other field name */
    public String f6203j;

    /* renamed from: k, reason: collision with other field name */
    public String f6204k;

    /* renamed from: l, reason: collision with other field name */
    public String f6205l;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6184a = new ig("XmPushActionRegistrationResult");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17886e = new hy("", (byte) 10, 6);
    private static final hy f = new hy("", (byte) 11, 7);
    private static final hy g = new hy("", (byte) 11, 8);
    private static final hy h = new hy("", (byte) 11, 9);
    private static final hy i = new hy("", (byte) 11, 10);
    private static final hy j = new hy("", (byte) 10, 11);
    private static final hy k = new hy("", (byte) 11, 12);
    private static final hy l = new hy("", (byte) 11, 13);
    private static final hy m = new hy("", (byte) 10, 14);
    private static final hy n = new hy("", (byte) 11, 15);
    private static final hy o = new hy("", (byte) 8, 16);
    private static final hy p = new hy("", (byte) 11, 17);
    private static final hy q = new hy("", (byte) 8, 18);
    private static final hy r = new hy("", (byte) 11, 19);
    private static final hy s = new hy("", (byte) 2, 20);
    private static final hy t = new hy("", com.umeng.analytics.pro.cb.m, 21);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6189a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6191a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5626a() {
        return this.f6188a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5628b() {
        return this.f6187a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5629c() {
        return this.f6194b != null;
    }

    public boolean d() {
        return this.f6196c != null;
    }

    public boolean e() {
        return this.f6189a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hh)) {
            return m5627a((hh) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6197d != null;
    }

    public boolean g() {
        return this.f6198e != null;
    }

    public boolean h() {
        return this.f6199f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6200g != null;
    }

    public boolean j() {
        return this.f6189a.get(1);
    }

    public boolean k() {
        return this.f6201h != null;
    }

    public boolean l() {
        return this.f6202i != null;
    }

    public boolean m() {
        return this.f6189a.get(2);
    }

    public boolean n() {
        return this.f6203j != null;
    }

    public boolean o() {
        return this.f6189a.get(3);
    }

    public boolean p() {
        return this.f6204k != null;
    }

    public boolean q() {
        return this.f6189a.get(4);
    }

    public boolean r() {
        return this.f6205l != null;
    }

    public boolean s() {
        return this.f6189a.get(5);
    }

    public boolean t() {
        return this.f6190a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m5626a()) {
            sb.append("debug:");
            String str = this.f6188a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5628b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6187a;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f6194b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6196c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f6186a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6197d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f6198e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6200g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f6193b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f6201h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f6202i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f6195c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f6203j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f6185a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f6204k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f6192b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f6205l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f6191a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f6190a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5623a() {
        return this.f6194b;
    }

    public String b() {
        return this.f6199f;
    }

    public String c() {
        return this.f6200g;
    }

    public void d(boolean z) {
        this.f6189a.set(3, z);
    }

    public void e(boolean z) {
        this.f6189a.set(4, z);
    }

    public void f(boolean z) {
        this.f6189a.set(5, z);
    }

    public long a() {
        return this.f6186a;
    }

    public void b(boolean z) {
        this.f6189a.set(1, z);
    }

    public void c(boolean z) {
        this.f6189a.set(2, z);
    }

    public void a(boolean z) {
        this.f6189a.set(0, z);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5625a();
        ibVar.a(f6184a);
        if (this.f6188a != null && m5626a()) {
            ibVar.a(a);
            ibVar.a(this.f6188a);
            ibVar.b();
        }
        if (this.f6187a != null && m5628b()) {
            ibVar.a(b);
            this.f6187a.b(ibVar);
            ibVar.b();
        }
        if (this.f6194b != null) {
            ibVar.a(c);
            ibVar.a(this.f6194b);
            ibVar.b();
        }
        if (this.f6196c != null) {
            ibVar.a(d);
            ibVar.a(this.f6196c);
            ibVar.b();
        }
        ibVar.a(f17886e);
        ibVar.a(this.f6186a);
        ibVar.b();
        if (this.f6197d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6197d);
            ibVar.b();
        }
        if (this.f6198e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6198e);
            ibVar.b();
        }
        if (this.f6199f != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f6199f);
            ibVar.b();
        }
        if (this.f6200g != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6200g);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(j);
            ibVar.a(this.f6193b);
            ibVar.b();
        }
        if (this.f6201h != null && k()) {
            ibVar.a(k);
            ibVar.a(this.f6201h);
            ibVar.b();
        }
        if (this.f6202i != null && l()) {
            ibVar.a(l);
            ibVar.a(this.f6202i);
            ibVar.b();
        }
        if (m()) {
            ibVar.a(m);
            ibVar.a(this.f6195c);
            ibVar.b();
        }
        if (this.f6203j != null && n()) {
            ibVar.a(n);
            ibVar.a(this.f6203j);
            ibVar.b();
        }
        if (o()) {
            ibVar.a(o);
            ibVar.mo5676a(this.f6185a);
            ibVar.b();
        }
        if (this.f6204k != null && p()) {
            ibVar.a(p);
            ibVar.a(this.f6204k);
            ibVar.b();
        }
        if (q()) {
            ibVar.a(q);
            ibVar.mo5676a(this.f6192b);
            ibVar.b();
        }
        if (this.f6205l != null && r()) {
            ibVar.a(r);
            ibVar.a(this.f6205l);
            ibVar.b();
        }
        if (s()) {
            ibVar.a(s);
            ibVar.a(this.f6191a);
            ibVar.b();
        }
        if (this.f6190a != null && t()) {
            ibVar.a(t);
            ibVar.a(new hz((byte) 11, this.f6190a.size()));
            Iterator<String> it = this.f6190a.iterator();
            while (it.hasNext()) {
                ibVar.a(it.next());
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m5624a() {
        return this.f6190a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5627a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean zM5626a = m5626a();
        boolean zM5626a2 = hhVar.m5626a();
        if ((zM5626a || zM5626a2) && !(zM5626a && zM5626a2 && this.f6188a.equals(hhVar.f6188a))) {
            return false;
        }
        boolean zM5628b = m5628b();
        boolean zM5628b2 = hhVar.m5628b();
        if ((zM5628b || zM5628b2) && !(zM5628b && zM5628b2 && this.f6187a.m5571a(hhVar.f6187a))) {
            return false;
        }
        boolean zM5629c = m5629c();
        boolean zM5629c2 = hhVar.m5629c();
        if ((zM5629c || zM5629c2) && !(zM5629c && zM5629c2 && this.f6194b.equals(hhVar.f6194b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hhVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f6196c.equals(hhVar.f6196c))) || this.f6186a != hhVar.f6186a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hhVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6197d.equals(hhVar.f6197d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hhVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6198e.equals(hhVar.f6198e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hhVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6199f.equals(hhVar.f6199f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hhVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6200g.equals(hhVar.f6200g))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hhVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6193b == hhVar.f6193b)) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hhVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6201h.equals(hhVar.f6201h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hhVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f6202i.equals(hhVar.f6202i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hhVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f6195c == hhVar.f6195c)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hhVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f6203j.equals(hhVar.f6203j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hhVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f6185a == hhVar.f6185a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = hhVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f6204k.equals(hhVar.f6204k))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = hhVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f6192b == hhVar.f6192b)) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = hhVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f6205l.equals(hhVar.f6205l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = hhVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f6191a == hhVar.f6191a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = hhVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f6190a.equals(hhVar.f6190a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hh hhVar) {
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
        if (!getClass().equals(hhVar.getClass())) {
            return getClass().getName().compareTo(hhVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5626a()).compareTo(Boolean.valueOf(hhVar.m5626a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5626a() && (iA20 = hs.a(this.f6188a, hhVar.f6188a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(m5628b()).compareTo(Boolean.valueOf(hhVar.m5628b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5628b() && (iA19 = hs.a(this.f6187a, hhVar.f6187a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(m5629c()).compareTo(Boolean.valueOf(hhVar.m5629c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5629c() && (iA18 = hs.a(this.f6194b, hhVar.f6194b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hhVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = hs.a(this.f6196c, hhVar.f6196c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hhVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = hs.a(this.f6186a, hhVar.f6186a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hhVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = hs.a(this.f6197d, hhVar.f6197d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hhVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = hs.a(this.f6198e, hhVar.f6198e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hhVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = hs.a(this.f6199f, hhVar.f6199f)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hhVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = hs.a(this.f6200g, hhVar.f6200g)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hhVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = hs.a(this.f6193b, hhVar.f6193b)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hhVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = hs.a(this.f6201h, hhVar.f6201h)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hhVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = hs.a(this.f6202i, hhVar.f6202i)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hhVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = hs.a(this.f6195c, hhVar.f6195c)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hhVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = hs.a(this.f6203j, hhVar.f6203j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hhVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = hs.a(this.f6185a, hhVar.f6185a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hhVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = hs.a(this.f6204k, hhVar.f6204k)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hhVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = hs.a(this.f6192b, hhVar.f6192b)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hhVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = hs.a(this.f6205l, hhVar.f6205l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hhVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = hs.a(this.f6191a, hhVar.f6191a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hhVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = hs.a(this.f6190a, hhVar.f6190a)) == 0) {
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
                if (e()) {
                    m5625a();
                    return;
                }
                throw new ic("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6188a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6187a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6194b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6196c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                default:
                    ie.a(ibVar, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f6186a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6197d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6198e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6199f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6200g = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 10) {
                        this.f6193b = ibVar.mo5666a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f6201h = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f6202i = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 10) {
                        this.f6195c = ibVar.mo5666a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 11) {
                        this.f6203j = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 8) {
                        this.f6185a = ibVar.mo5665a();
                        d(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 17:
                    if (b2 == 11) {
                        this.f6204k = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 18:
                    if (b2 == 8) {
                        this.f6192b = ibVar.mo5665a();
                        e(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 19:
                    if (b2 == 11) {
                        this.f6205l = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f6191a = ibVar.mo5677a();
                        f(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 15) {
                        hz hzVarMo5668a = ibVar.mo5668a();
                        this.f6190a = new ArrayList(hzVarMo5668a.f6305a);
                        for (int i2 = 0; i2 < hzVarMo5668a.f6305a; i2++) {
                            this.f6190a.add(ibVar.mo5672a());
                        }
                        ibVar.i();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5625a() throws ic {
        if (this.f6194b != null) {
            if (this.f6196c != null) {
                return;
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
