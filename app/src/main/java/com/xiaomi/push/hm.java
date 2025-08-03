package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hm implements hr<hm, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6250a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6251a;

    /* renamed from: a, reason: collision with other field name */
    public String f6252a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6253a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6254a = true;

    /* renamed from: b, reason: collision with other field name */
    public String f6255b;

    /* renamed from: c, reason: collision with other field name */
    public String f6256c;

    /* renamed from: d, reason: collision with other field name */
    public String f6257d;

    /* renamed from: e, reason: collision with other field name */
    public String f6258e;

    /* renamed from: f, reason: collision with other field name */
    public String f6259f;

    /* renamed from: g, reason: collision with other field name */
    public String f6260g;

    /* renamed from: h, reason: collision with other field name */
    public String f6261h;

    /* renamed from: i, reason: collision with other field name */
    public String f6262i;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6249a = new ig("XmPushActionUnRegistration");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17891e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 11, 8);
    private static final hy i = new hy("", (byte) 11, 9);
    private static final hy j = new hy("", (byte) 11, 10);
    private static final hy k = new hy("", (byte) 2, 11);
    private static final hy l = new hy("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5648a() {
        return this.f6252a != null;
    }

    public boolean b() {
        return this.f6251a != null;
    }

    public boolean c() {
        return this.f6255b != null;
    }

    public boolean d() {
        return this.f6256c != null;
    }

    public boolean e() {
        return this.f6257d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return m5649a((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6258e != null;
    }

    public boolean g() {
        return this.f6259f != null;
    }

    public boolean h() {
        return this.f6260g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6261h != null;
    }

    public boolean j() {
        return this.f6262i != null;
    }

    public boolean k() {
        return this.f6253a.get(0);
    }

    public boolean l() {
        return this.f6253a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m5648a()) {
            sb.append("debug:");
            String str = this.f6252a;
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
            gv gvVar = this.f6251a;
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
        String str2 = this.f6255b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6256c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f6257d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f6258e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6259f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f6260g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f6261h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f6262i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f6254a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6250a);
        }
        sb.append(")");
        return sb.toString();
    }

    public hm a(String str) {
        this.f6255b = str;
        return this;
    }

    public hm b(String str) {
        this.f6256c = str;
        return this;
    }

    public hm c(String str) {
        this.f6257d = str;
        return this;
    }

    public hm d(String str) {
        this.f6259f = str;
        return this;
    }

    public hm e(String str) {
        this.f6260g = str;
        return this;
    }

    public void a(boolean z) {
        this.f6253a.set(0, z);
    }

    public void b(boolean z) {
        this.f6253a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5649a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean zM5648a = m5648a();
        boolean zM5648a2 = hmVar.m5648a();
        if ((zM5648a || zM5648a2) && !(zM5648a && zM5648a2 && this.f6252a.equals(hmVar.f6252a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hmVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6251a.m5571a(hmVar.f6251a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hmVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6255b.equals(hmVar.f6255b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hmVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6256c.equals(hmVar.f6256c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hmVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6257d.equals(hmVar.f6257d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hmVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6258e.equals(hmVar.f6258e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hmVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6259f.equals(hmVar.f6259f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hmVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6260g.equals(hmVar.f6260g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hmVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6261h.equals(hmVar.f6261h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hmVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6262i.equals(hmVar.f6262i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hmVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6254a == hmVar.f6254a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hmVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f6250a == hmVar.f6250a;
        }
        return true;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f6249a);
        if (this.f6252a != null && m5648a()) {
            ibVar.a(a);
            ibVar.a(this.f6252a);
            ibVar.b();
        }
        if (this.f6251a != null && b()) {
            ibVar.a(b);
            this.f6251a.b(ibVar);
            ibVar.b();
        }
        if (this.f6255b != null) {
            ibVar.a(c);
            ibVar.a(this.f6255b);
            ibVar.b();
        }
        if (this.f6256c != null) {
            ibVar.a(d);
            ibVar.a(this.f6256c);
            ibVar.b();
        }
        if (this.f6257d != null && e()) {
            ibVar.a(f17891e);
            ibVar.a(this.f6257d);
            ibVar.b();
        }
        if (this.f6258e != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6258e);
            ibVar.b();
        }
        if (this.f6259f != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6259f);
            ibVar.b();
        }
        if (this.f6260g != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f6260g);
            ibVar.b();
        }
        if (this.f6261h != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6261h);
            ibVar.b();
        }
        if (this.f6262i != null && j()) {
            ibVar.a(j);
            ibVar.a(this.f6262i);
            ibVar.b();
        }
        if (k()) {
            ibVar.a(k);
            ibVar.a(this.f6254a);
            ibVar.b();
        }
        if (l()) {
            ibVar.a(l);
            ibVar.a(this.f6250a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hm hmVar) {
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
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5648a()).compareTo(Boolean.valueOf(hmVar.m5648a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5648a() && (iA12 = hs.a(this.f6252a, hmVar.f6252a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA11 = hs.a(this.f6251a, hmVar.f6251a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA10 = hs.a(this.f6255b, hmVar.f6255b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA9 = hs.a(this.f6256c, hmVar.f6256c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA8 = hs.a(this.f6257d, hmVar.f6257d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA7 = hs.a(this.f6258e, hmVar.f6258e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = hs.a(this.f6259f, hmVar.f6259f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = hs.a(this.f6260g, hmVar.f6260g)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = hs.a(this.f6261h, hmVar.f6261h)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hmVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = hs.a(this.f6262i, hmVar.f6262i)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hmVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = hs.a(this.f6254a, hmVar.f6254a)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hmVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = hs.a(this.f6250a, hmVar.f6250a)) == 0) {
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
                a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6252a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6251a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6255b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6256c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6257d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6258e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6259f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6260g = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6261h = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6262i = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f6254a = ibVar.mo5677a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f6250a = ibVar.mo5666a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                default:
                    ie.a(ibVar, b2);
                    break;
            }
            ibVar.g();
        }
    }

    public void a() throws ic {
        if (this.f6255b != null) {
            if (this.f6256c != null) {
                return;
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
