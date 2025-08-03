package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gs implements hr<gs, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6014a;

    /* renamed from: a, reason: collision with other field name */
    public gt f6015a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6016a;

    /* renamed from: a, reason: collision with other field name */
    public String f6017a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6018a = new BitSet(4);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6019a = false;

    /* renamed from: b, reason: collision with other field name */
    public long f6020b;

    /* renamed from: b, reason: collision with other field name */
    public String f6021b;

    /* renamed from: c, reason: collision with other field name */
    public long f6022c;

    /* renamed from: c, reason: collision with other field name */
    public String f6023c;

    /* renamed from: d, reason: collision with other field name */
    public String f6024d;

    /* renamed from: e, reason: collision with other field name */
    public String f6025e;

    /* renamed from: f, reason: collision with other field name */
    public String f6026f;

    /* renamed from: g, reason: collision with other field name */
    public String f6027g;

    /* renamed from: h, reason: collision with other field name */
    public String f6028h;

    /* renamed from: i, reason: collision with other field name */
    public String f6029i;

    /* renamed from: j, reason: collision with other field name */
    public String f6030j;

    /* renamed from: k, reason: collision with other field name */
    public String f6031k;

    /* renamed from: l, reason: collision with other field name */
    public String f6032l;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6013a = new ig("PushMessage");
    private static final hy a = new hy("", (byte) 12, 1);
    private static final hy b = new hy("", (byte) 11, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17876e = new hy("", (byte) 10, 5);
    private static final hy f = new hy("", (byte) 10, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 11, 8);
    private static final hy i = new hy("", (byte) 11, 9);
    private static final hy j = new hy("", (byte) 11, 10);
    private static final hy k = new hy("", (byte) 11, 11);
    private static final hy l = new hy("", (byte) 12, 12);
    private static final hy m = new hy("", (byte) 11, 13);
    private static final hy n = new hy("", (byte) 2, 14);
    private static final hy o = new hy("", (byte) 11, 15);
    private static final hy p = new hy("", (byte) 10, 16);
    private static final hy q = new hy("", (byte) 11, 20);
    private static final hy r = new hy("", (byte) 11, 21);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5553a() {
        return this.f6016a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5555b() {
        return this.f6017a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5556c() {
        return this.f6021b != null;
    }

    public boolean d() {
        return this.f6023c != null;
    }

    public boolean e() {
        return this.f6018a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gs)) {
            return m5554a((gs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6018a.get(1);
    }

    public boolean g() {
        return this.f6024d != null;
    }

    public boolean h() {
        return this.f6025e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6026f != null;
    }

    public boolean j() {
        return this.f6027g != null;
    }

    public boolean k() {
        return this.f6028h != null;
    }

    public boolean l() {
        return this.f6015a != null;
    }

    public boolean m() {
        return this.f6029i != null;
    }

    public boolean n() {
        return this.f6018a.get(2);
    }

    public boolean o() {
        return this.f6030j != null;
    }

    public boolean p() {
        return this.f6018a.get(3);
    }

    public boolean q() {
        return this.f6031k != null;
    }

    public boolean r() {
        return this.f6032l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m5553a()) {
            sb.append("to:");
            gv gvVar = this.f6016a;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f6017a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f6021b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f6023c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f6014a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f6020b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f6024d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6025e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f6026f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6027g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f6028h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gt gtVar = this.f6015a;
            if (gtVar == null) {
                sb.append("null");
            } else {
                sb.append(gtVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f6029i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f6019a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f6030j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f6022c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f6031k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f6032l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5551a() {
        return this.f6017a;
    }

    public String b() {
        return this.f6021b;
    }

    public String c() {
        return this.f6023c;
    }

    public void d(boolean z) {
        this.f6018a.set(3, z);
    }

    public long a() {
        return this.f6014a;
    }

    public void b(boolean z) {
        this.f6018a.set(1, z);
    }

    public void c(boolean z) {
        this.f6018a.set(2, z);
    }

    public void a(boolean z) {
        this.f6018a.set(0, z);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5552a();
        ibVar.a(f6013a);
        if (this.f6016a != null && m5553a()) {
            ibVar.a(a);
            this.f6016a.b(ibVar);
            ibVar.b();
        }
        if (this.f6017a != null) {
            ibVar.a(b);
            ibVar.a(this.f6017a);
            ibVar.b();
        }
        if (this.f6021b != null) {
            ibVar.a(c);
            ibVar.a(this.f6021b);
            ibVar.b();
        }
        if (this.f6023c != null) {
            ibVar.a(d);
            ibVar.a(this.f6023c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f17876e);
            ibVar.a(this.f6014a);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f);
            ibVar.a(this.f6020b);
            ibVar.b();
        }
        if (this.f6024d != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6024d);
            ibVar.b();
        }
        if (this.f6025e != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f6025e);
            ibVar.b();
        }
        if (this.f6026f != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6026f);
            ibVar.b();
        }
        if (this.f6027g != null && j()) {
            ibVar.a(j);
            ibVar.a(this.f6027g);
            ibVar.b();
        }
        if (this.f6028h != null && k()) {
            ibVar.a(k);
            ibVar.a(this.f6028h);
            ibVar.b();
        }
        if (this.f6015a != null && l()) {
            ibVar.a(l);
            this.f6015a.b(ibVar);
            ibVar.b();
        }
        if (this.f6029i != null && m()) {
            ibVar.a(m);
            ibVar.a(this.f6029i);
            ibVar.b();
        }
        if (n()) {
            ibVar.a(n);
            ibVar.a(this.f6019a);
            ibVar.b();
        }
        if (this.f6030j != null && o()) {
            ibVar.a(o);
            ibVar.a(this.f6030j);
            ibVar.b();
        }
        if (p()) {
            ibVar.a(p);
            ibVar.a(this.f6022c);
            ibVar.b();
        }
        if (this.f6031k != null && q()) {
            ibVar.a(q);
            ibVar.a(this.f6031k);
            ibVar.b();
        }
        if (this.f6032l != null && r()) {
            ibVar.a(r);
            ibVar.a(this.f6032l);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5554a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        boolean zM5553a = m5553a();
        boolean zM5553a2 = gsVar.m5553a();
        if ((zM5553a || zM5553a2) && !(zM5553a && zM5553a2 && this.f6016a.m5571a(gsVar.f6016a))) {
            return false;
        }
        boolean zM5555b = m5555b();
        boolean zM5555b2 = gsVar.m5555b();
        if ((zM5555b || zM5555b2) && !(zM5555b && zM5555b2 && this.f6017a.equals(gsVar.f6017a))) {
            return false;
        }
        boolean zM5556c = m5556c();
        boolean zM5556c2 = gsVar.m5556c();
        if ((zM5556c || zM5556c2) && !(zM5556c && zM5556c2 && this.f6021b.equals(gsVar.f6021b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gsVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6023c.equals(gsVar.f6023c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gsVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6014a == gsVar.f6014a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gsVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6020b == gsVar.f6020b)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gsVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6024d.equals(gsVar.f6024d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gsVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6025e.equals(gsVar.f6025e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gsVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6026f.equals(gsVar.f6026f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gsVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6027g.equals(gsVar.f6027g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gsVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6028h.equals(gsVar.f6028h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = gsVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f6015a.m5563a(gsVar.f6015a))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gsVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f6029i.equals(gsVar.f6029i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gsVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f6019a == gsVar.f6019a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = gsVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f6030j.equals(gsVar.f6030j))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = gsVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f6022c == gsVar.f6022c)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = gsVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f6031k.equals(gsVar.f6031k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = gsVar.r();
        if (zR || zR2) {
            return zR && zR2 && this.f6032l.equals(gsVar.f6032l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gs gsVar) {
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
        if (!getClass().equals(gsVar.getClass())) {
            return getClass().getName().compareTo(gsVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5553a()).compareTo(Boolean.valueOf(gsVar.m5553a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5553a() && (iA18 = hs.a(this.f6016a, gsVar.f6016a)) != 0) {
            return iA18;
        }
        int iCompareTo2 = Boolean.valueOf(m5555b()).compareTo(Boolean.valueOf(gsVar.m5555b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5555b() && (iA17 = hs.a(this.f6017a, gsVar.f6017a)) != 0) {
            return iA17;
        }
        int iCompareTo3 = Boolean.valueOf(m5556c()).compareTo(Boolean.valueOf(gsVar.m5556c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5556c() && (iA16 = hs.a(this.f6021b, gsVar.f6021b)) != 0) {
            return iA16;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gsVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA15 = hs.a(this.f6023c, gsVar.f6023c)) != 0) {
            return iA15;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gsVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA14 = hs.a(this.f6014a, gsVar.f6014a)) != 0) {
            return iA14;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gsVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA13 = hs.a(this.f6020b, gsVar.f6020b)) != 0) {
            return iA13;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gsVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA12 = hs.a(this.f6024d, gsVar.f6024d)) != 0) {
            return iA12;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gsVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA11 = hs.a(this.f6025e, gsVar.f6025e)) != 0) {
            return iA11;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gsVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA10 = hs.a(this.f6026f, gsVar.f6026f)) != 0) {
            return iA10;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gsVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA9 = hs.a(this.f6027g, gsVar.f6027g)) != 0) {
            return iA9;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gsVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA8 = hs.a(this.f6028h, gsVar.f6028h)) != 0) {
            return iA8;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gsVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA7 = hs.a(this.f6015a, gsVar.f6015a)) != 0) {
            return iA7;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gsVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA6 = hs.a(this.f6029i, gsVar.f6029i)) != 0) {
            return iA6;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gsVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA5 = hs.a(this.f6019a, gsVar.f6019a)) != 0) {
            return iA5;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gsVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA4 = hs.a(this.f6030j, gsVar.f6030j)) != 0) {
            return iA4;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gsVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA3 = hs.a(this.f6022c, gsVar.f6022c)) != 0) {
            return iA3;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gsVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA2 = hs.a(this.f6031k, gsVar.f6031k)) != 0) {
            return iA2;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gsVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (!r() || (iA = hs.a(this.f6032l, gsVar.f6032l)) == 0) {
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
                m5552a();
                return;
            }
            short s = hyVarMo5667a.f6304a;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (b2 == 12) {
                                gv gvVar = new gv();
                                this.f6016a = gvVar;
                                gvVar.a(ibVar);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 2:
                            if (b2 == 11) {
                                this.f6017a = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 3:
                            if (b2 == 11) {
                                this.f6021b = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 4:
                            if (b2 == 11) {
                                this.f6023c = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 5:
                            if (b2 == 10) {
                                this.f6014a = ibVar.mo5666a();
                                a(true);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 6:
                            if (b2 == 10) {
                                this.f6020b = ibVar.mo5666a();
                                b(true);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 7:
                            if (b2 == 11) {
                                this.f6024d = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 8:
                            if (b2 == 11) {
                                this.f6025e = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 9:
                            if (b2 == 11) {
                                this.f6026f = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 10:
                            if (b2 == 11) {
                                this.f6027g = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 11:
                            if (b2 == 11) {
                                this.f6028h = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 12:
                            if (b2 == 12) {
                                gt gtVar = new gt();
                                this.f6015a = gtVar;
                                gtVar.a(ibVar);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 13:
                            if (b2 == 11) {
                                this.f6029i = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 14:
                            if (b2 == 2) {
                                this.f6019a = ibVar.mo5677a();
                                c(true);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 15:
                            if (b2 == 11) {
                                this.f6030j = ibVar.mo5672a();
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        case 16:
                            if (b2 == 10) {
                                this.f6022c = ibVar.mo5666a();
                                d(true);
                                break;
                            } else {
                                ie.a(ibVar, b2);
                                break;
                            }
                        default:
                            ie.a(ibVar, b2);
                            break;
                    }
                } else if (b2 == 11) {
                    this.f6032l = ibVar.mo5672a();
                } else {
                    ie.a(ibVar, b2);
                }
            } else if (b2 == 11) {
                this.f6031k = ibVar.mo5672a();
            } else {
                ie.a(ibVar, b2);
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5552a() throws ic {
        if (this.f6017a != null) {
            if (this.f6021b != null) {
                if (this.f6023c != null) {
                    return;
                }
                throw new ic("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
