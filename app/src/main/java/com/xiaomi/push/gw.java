package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gw implements hr<gw, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f6059a;

    /* renamed from: a, reason: collision with other field name */
    public long f6060a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6061a;

    /* renamed from: a, reason: collision with other field name */
    public hj f6062a;

    /* renamed from: a, reason: collision with other field name */
    public String f6063a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f6065a;

    /* renamed from: a, reason: collision with other field name */
    public short f6066a;

    /* renamed from: b, reason: collision with other field name */
    public String f6068b;

    /* renamed from: b, reason: collision with other field name */
    public short f6069b;

    /* renamed from: c, reason: collision with other field name */
    public String f6070c;

    /* renamed from: d, reason: collision with other field name */
    public String f6071d;

    /* renamed from: e, reason: collision with other field name */
    public String f6072e;

    /* renamed from: f, reason: collision with other field name */
    public String f6073f;

    /* renamed from: g, reason: collision with other field name */
    public String f6074g;

    /* renamed from: h, reason: collision with other field name */
    public String f6075h;

    /* renamed from: i, reason: collision with other field name */
    public String f6076i;

    /* renamed from: j, reason: collision with other field name */
    public String f6077j;

    /* renamed from: k, reason: collision with other field name */
    public String f6078k;

    /* renamed from: l, reason: collision with other field name */
    public String f6079l;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6058a = new ig("XmPushActionAckMessage");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17879e = new hy("", (byte) 10, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 12, 8);
    private static final hy i = new hy("", (byte) 11, 9);
    private static final hy j = new hy("", (byte) 11, 10);
    private static final hy k = new hy("", (byte) 2, 11);
    private static final hy l = new hy("", (byte) 11, 12);
    private static final hy m = new hy("", (byte) 11, 13);
    private static final hy n = new hy("", (byte) 11, 14);
    private static final hy o = new hy("", (byte) 6, 15);
    private static final hy p = new hy("", (byte) 6, 16);
    private static final hy q = new hy("", (byte) 11, 20);
    private static final hy r = new hy("", (byte) 11, 21);
    private static final hy s = new hy("", (byte) 8, 22);
    private static final hy t = new hy("", com.umeng.analytics.pro.cb.k, 23);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6064a = new BitSet(5);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6067a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5572a() {
        return this.f6063a != null;
    }

    public boolean b() {
        return this.f6061a != null;
    }

    public boolean c() {
        return this.f6068b != null;
    }

    public boolean d() {
        return this.f6070c != null;
    }

    public boolean e() {
        return this.f6064a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gw)) {
            return m5573a((gw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6071d != null;
    }

    public boolean g() {
        return this.f6072e != null;
    }

    public boolean h() {
        return this.f6062a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6073f != null;
    }

    public boolean j() {
        return this.f6074g != null;
    }

    public boolean k() {
        return this.f6064a.get(1);
    }

    public boolean l() {
        return this.f6075h != null;
    }

    public boolean m() {
        return this.f6076i != null;
    }

    public boolean n() {
        return this.f6077j != null;
    }

    public boolean o() {
        return this.f6064a.get(2);
    }

    public boolean p() {
        return this.f6064a.get(3);
    }

    public boolean q() {
        return this.f6078k != null;
    }

    public boolean r() {
        return this.f6079l != null;
    }

    public boolean s() {
        return this.f6064a.get(4);
    }

    public boolean t() {
        return this.f6065a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m5572a()) {
            sb.append("debug:");
            String str = this.f6063a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6061a;
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
        String str2 = this.f6068b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6070c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f6060a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f6071d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f6072e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hj hjVar = this.f6062a;
            if (hjVar == null) {
                sb.append("null");
            } else {
                sb.append(hjVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6073f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6074g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f6067a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f6075h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f6076i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f6077j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f6066a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f6069b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f6078k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f6079l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f6059a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f6065a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gw a(String str) {
        this.f6068b = str;
        return this;
    }

    public gw b(String str) {
        this.f6070c = str;
        return this;
    }

    public gw c(String str) {
        this.f6071d = str;
        return this;
    }

    public gw d(String str) {
        this.f6072e = str;
        return this;
    }

    public void e(boolean z) {
        this.f6064a.set(4, z);
    }

    public gw a(long j2) {
        this.f6060a = j2;
        a(true);
        return this;
    }

    public void b(boolean z) {
        this.f6064a.set(1, z);
    }

    public void c(boolean z) {
        this.f6064a.set(2, z);
    }

    public void d(boolean z) {
        this.f6064a.set(3, z);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f6058a);
        if (this.f6063a != null && m5572a()) {
            ibVar.a(a);
            ibVar.a(this.f6063a);
            ibVar.b();
        }
        if (this.f6061a != null && b()) {
            ibVar.a(b);
            this.f6061a.b(ibVar);
            ibVar.b();
        }
        if (this.f6068b != null) {
            ibVar.a(c);
            ibVar.a(this.f6068b);
            ibVar.b();
        }
        if (this.f6070c != null) {
            ibVar.a(d);
            ibVar.a(this.f6070c);
            ibVar.b();
        }
        ibVar.a(f17879e);
        ibVar.a(this.f6060a);
        ibVar.b();
        if (this.f6071d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6071d);
            ibVar.b();
        }
        if (this.f6072e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6072e);
            ibVar.b();
        }
        if (this.f6062a != null && h()) {
            ibVar.a(h);
            this.f6062a.b(ibVar);
            ibVar.b();
        }
        if (this.f6073f != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6073f);
            ibVar.b();
        }
        if (this.f6074g != null && j()) {
            ibVar.a(j);
            ibVar.a(this.f6074g);
            ibVar.b();
        }
        if (k()) {
            ibVar.a(k);
            ibVar.a(this.f6067a);
            ibVar.b();
        }
        if (this.f6075h != null && l()) {
            ibVar.a(l);
            ibVar.a(this.f6075h);
            ibVar.b();
        }
        if (this.f6076i != null && m()) {
            ibVar.a(m);
            ibVar.a(this.f6076i);
            ibVar.b();
        }
        if (this.f6077j != null && n()) {
            ibVar.a(n);
            ibVar.a(this.f6077j);
            ibVar.b();
        }
        if (o()) {
            ibVar.a(o);
            ibVar.a(this.f6066a);
            ibVar.b();
        }
        if (p()) {
            ibVar.a(p);
            ibVar.a(this.f6069b);
            ibVar.b();
        }
        if (this.f6078k != null && q()) {
            ibVar.a(q);
            ibVar.a(this.f6078k);
            ibVar.b();
        }
        if (this.f6079l != null && r()) {
            ibVar.a(r);
            ibVar.a(this.f6079l);
            ibVar.b();
        }
        if (s()) {
            ibVar.a(s);
            ibVar.mo5676a(this.f6059a);
            ibVar.b();
        }
        if (this.f6065a != null && t()) {
            ibVar.a(t);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6065a.size()));
            for (Map.Entry<String, String> entry : this.f6065a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public void a(boolean z) {
        this.f6064a.set(0, z);
    }

    public gw a(short s2) {
        this.f6066a = s2;
        c(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5573a(gw gwVar) {
        if (gwVar == null) {
            return false;
        }
        boolean zM5572a = m5572a();
        boolean zM5572a2 = gwVar.m5572a();
        if ((zM5572a || zM5572a2) && !(zM5572a && zM5572a2 && this.f6063a.equals(gwVar.f6063a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gwVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6061a.m5571a(gwVar.f6061a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gwVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6068b.equals(gwVar.f6068b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gwVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f6070c.equals(gwVar.f6070c))) || this.f6060a != gwVar.f6060a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gwVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6071d.equals(gwVar.f6071d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gwVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6072e.equals(gwVar.f6072e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gwVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6062a.m5635a(gwVar.f6062a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gwVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6073f.equals(gwVar.f6073f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gwVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6074g.equals(gwVar.f6074g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gwVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6067a == gwVar.f6067a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = gwVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f6075h.equals(gwVar.f6075h))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gwVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f6076i.equals(gwVar.f6076i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gwVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f6077j.equals(gwVar.f6077j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = gwVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f6066a == gwVar.f6066a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = gwVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f6069b == gwVar.f6069b)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = gwVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f6078k.equals(gwVar.f6078k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = gwVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f6079l.equals(gwVar.f6079l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = gwVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f6059a == gwVar.f6059a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = gwVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f6065a.equals(gwVar.f6065a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gw gwVar) {
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
        if (!getClass().equals(gwVar.getClass())) {
            return getClass().getName().compareTo(gwVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5572a()).compareTo(Boolean.valueOf(gwVar.m5572a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5572a() && (iA20 = hs.a(this.f6063a, gwVar.f6063a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gwVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA19 = hs.a(this.f6061a, gwVar.f6061a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gwVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA18 = hs.a(this.f6068b, gwVar.f6068b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gwVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = hs.a(this.f6070c, gwVar.f6070c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gwVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = hs.a(this.f6060a, gwVar.f6060a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gwVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = hs.a(this.f6071d, gwVar.f6071d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gwVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = hs.a(this.f6072e, gwVar.f6072e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gwVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = hs.a(this.f6062a, gwVar.f6062a)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gwVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = hs.a(this.f6073f, gwVar.f6073f)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gwVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = hs.a(this.f6074g, gwVar.f6074g)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gwVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = hs.a(this.f6067a, gwVar.f6067a)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gwVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = hs.a(this.f6075h, gwVar.f6075h)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gwVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = hs.a(this.f6076i, gwVar.f6076i)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gwVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = hs.a(this.f6077j, gwVar.f6077j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gwVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = hs.a(this.f6066a, gwVar.f6066a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gwVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = hs.a(this.f6069b, gwVar.f6069b)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gwVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = hs.a(this.f6078k, gwVar.f6078k)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gwVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = hs.a(this.f6079l, gwVar.f6079l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gwVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = hs.a(this.f6059a, gwVar.f6059a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gwVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = hs.a(this.f6065a, gwVar.f6065a)) == 0) {
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
                    a();
                    return;
                }
                throw new ic("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6063a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6061a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6068b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6070c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f6060a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6071d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6072e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        hj hjVar = new hj();
                        this.f6062a = hjVar;
                        hjVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6073f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6074g = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f6067a = ibVar.mo5677a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f6075h = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f6076i = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f6077j = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 6) {
                        this.f6066a = ibVar.mo5674a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 16:
                    if (b2 == 6) {
                        this.f6069b = ibVar.mo5674a();
                        d(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 17:
                case 18:
                case 19:
                default:
                    ie.a(ibVar, b2);
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f6078k = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 21:
                    if (b2 == 11) {
                        this.f6079l = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 22:
                    if (b2 == 8) {
                        this.f6059a = ibVar.mo5665a();
                        e(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 23:
                    if (b2 == 13) {
                        ia iaVarMo5669a = ibVar.mo5669a();
                        this.f6065a = new HashMap(iaVarMo5669a.f6308a * 2);
                        for (int i2 = 0; i2 < iaVarMo5669a.f6308a; i2++) {
                            this.f6065a.put(ibVar.mo5672a(), ibVar.mo5672a());
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
            }
            ibVar.g();
        }
    }

    public void a() throws ic {
        if (this.f6068b != null) {
            if (this.f6070c != null) {
                return;
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
