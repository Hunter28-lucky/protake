package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hp implements hr<hp, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6284a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6285a;

    /* renamed from: a, reason: collision with other field name */
    public String f6286a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6287a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f6288b;

    /* renamed from: c, reason: collision with other field name */
    public String f6289c;

    /* renamed from: d, reason: collision with other field name */
    public String f6290d;

    /* renamed from: e, reason: collision with other field name */
    public String f6291e;

    /* renamed from: f, reason: collision with other field name */
    public String f6292f;

    /* renamed from: g, reason: collision with other field name */
    public String f6293g;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6283a = new ig("XmPushActionUnSubscriptionResult");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17894e = new hy("", (byte) 10, 6);
    private static final hy f = new hy("", (byte) 11, 7);
    private static final hy g = new hy("", (byte) 11, 8);
    private static final hy h = new hy("", (byte) 11, 9);
    private static final hy i = new hy("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5656a() {
        return this.f6286a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5658b() {
        return this.f6285a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5659c() {
        return this.f6288b != null;
    }

    public boolean d() {
        return this.f6289c != null;
    }

    public boolean e() {
        return this.f6287a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hp)) {
            return m5657a((hp) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6290d != null;
    }

    public boolean g() {
        return this.f6291e != null;
    }

    public boolean h() {
        return this.f6292f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6293g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m5656a()) {
            sb.append("debug:");
            String str = this.f6286a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5658b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6285a;
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
        String str2 = this.f6288b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f6289c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6284a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6290d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f6291e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6292f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6293g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f6288b;
    }

    public String b() {
        return this.f6291e;
    }

    public String c() {
        return this.f6293g;
    }

    public void a(boolean z) {
        this.f6287a.set(0, z);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5655a();
        ibVar.a(f6283a);
        if (this.f6286a != null && m5656a()) {
            ibVar.a(a);
            ibVar.a(this.f6286a);
            ibVar.b();
        }
        if (this.f6285a != null && m5658b()) {
            ibVar.a(b);
            this.f6285a.b(ibVar);
            ibVar.b();
        }
        if (this.f6288b != null) {
            ibVar.a(c);
            ibVar.a(this.f6288b);
            ibVar.b();
        }
        if (this.f6289c != null && d()) {
            ibVar.a(d);
            ibVar.a(this.f6289c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f17894e);
            ibVar.a(this.f6284a);
            ibVar.b();
        }
        if (this.f6290d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6290d);
            ibVar.b();
        }
        if (this.f6291e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6291e);
            ibVar.b();
        }
        if (this.f6292f != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f6292f);
            ibVar.b();
        }
        if (this.f6293g != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6293g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5657a(hp hpVar) {
        if (hpVar == null) {
            return false;
        }
        boolean zM5656a = m5656a();
        boolean zM5656a2 = hpVar.m5656a();
        if ((zM5656a || zM5656a2) && !(zM5656a && zM5656a2 && this.f6286a.equals(hpVar.f6286a))) {
            return false;
        }
        boolean zM5658b = m5658b();
        boolean zM5658b2 = hpVar.m5658b();
        if ((zM5658b || zM5658b2) && !(zM5658b && zM5658b2 && this.f6285a.m5571a(hpVar.f6285a))) {
            return false;
        }
        boolean zM5659c = m5659c();
        boolean zM5659c2 = hpVar.m5659c();
        if ((zM5659c || zM5659c2) && !(zM5659c && zM5659c2 && this.f6288b.equals(hpVar.f6288b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hpVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6289c.equals(hpVar.f6289c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hpVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6284a == hpVar.f6284a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hpVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6290d.equals(hpVar.f6290d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hpVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6291e.equals(hpVar.f6291e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hpVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6292f.equals(hpVar.f6292f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hpVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f6293g.equals(hpVar.f6293g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hp hpVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(hpVar.getClass())) {
            return getClass().getName().compareTo(hpVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5656a()).compareTo(Boolean.valueOf(hpVar.m5656a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5656a() && (iA9 = hs.a(this.f6286a, hpVar.f6286a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m5658b()).compareTo(Boolean.valueOf(hpVar.m5658b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5658b() && (iA8 = hs.a(this.f6285a, hpVar.f6285a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m5659c()).compareTo(Boolean.valueOf(hpVar.m5659c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5659c() && (iA7 = hs.a(this.f6288b, hpVar.f6288b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hpVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hs.a(this.f6289c, hpVar.f6289c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hpVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hs.a(this.f6284a, hpVar.f6284a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hpVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hs.a(this.f6290d, hpVar.f6290d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hpVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hs.a(this.f6291e, hpVar.f6291e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hpVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hs.a(this.f6292f, hpVar.f6292f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hpVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hs.a(this.f6293g, hpVar.f6293g)) == 0) {
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
                m5655a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6286a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6285a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6288b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6289c = ibVar.mo5672a();
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
                        this.f6284a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6290d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6291e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6292f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6293g = ibVar.mo5672a();
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
    public void m5655a() throws ic {
        if (this.f6288b != null) {
            return;
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
