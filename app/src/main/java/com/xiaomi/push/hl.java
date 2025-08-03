package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hl implements hr<hl, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6239a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6240a;

    /* renamed from: a, reason: collision with other field name */
    public String f6241a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6242a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f6243b;

    /* renamed from: c, reason: collision with other field name */
    public String f6244c;

    /* renamed from: d, reason: collision with other field name */
    public String f6245d;

    /* renamed from: e, reason: collision with other field name */
    public String f6246e;

    /* renamed from: f, reason: collision with other field name */
    public String f6247f;

    /* renamed from: g, reason: collision with other field name */
    public String f6248g;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6238a = new ig("XmPushActionSubscriptionResult");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17890e = new hy("", (byte) 10, 6);
    private static final hy f = new hy("", (byte) 11, 7);
    private static final hy g = new hy("", (byte) 11, 8);
    private static final hy h = new hy("", (byte) 11, 9);
    private static final hy i = new hy("", (byte) 11, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5644a() {
        return this.f6241a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5646b() {
        return this.f6240a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5647c() {
        return this.f6243b != null;
    }

    public boolean d() {
        return this.f6244c != null;
    }

    public boolean e() {
        return this.f6242a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m5645a((hl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6245d != null;
    }

    public boolean g() {
        return this.f6246e != null;
    }

    public boolean h() {
        return this.f6247f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6248g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m5644a()) {
            sb.append("debug:");
            String str = this.f6241a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5646b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6240a;
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
        String str2 = this.f6243b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f6244c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6239a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6245d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f6246e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6247f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6248g;
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
        return this.f6243b;
    }

    public String b() {
        return this.f6246e;
    }

    public String c() {
        return this.f6248g;
    }

    public void a(boolean z) {
        this.f6242a.set(0, z);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5643a();
        ibVar.a(f6238a);
        if (this.f6241a != null && m5644a()) {
            ibVar.a(a);
            ibVar.a(this.f6241a);
            ibVar.b();
        }
        if (this.f6240a != null && m5646b()) {
            ibVar.a(b);
            this.f6240a.b(ibVar);
            ibVar.b();
        }
        if (this.f6243b != null) {
            ibVar.a(c);
            ibVar.a(this.f6243b);
            ibVar.b();
        }
        if (this.f6244c != null && d()) {
            ibVar.a(d);
            ibVar.a(this.f6244c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f17890e);
            ibVar.a(this.f6239a);
            ibVar.b();
        }
        if (this.f6245d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6245d);
            ibVar.b();
        }
        if (this.f6246e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6246e);
            ibVar.b();
        }
        if (this.f6247f != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f6247f);
            ibVar.b();
        }
        if (this.f6248g != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6248g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5645a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean zM5644a = m5644a();
        boolean zM5644a2 = hlVar.m5644a();
        if ((zM5644a || zM5644a2) && !(zM5644a && zM5644a2 && this.f6241a.equals(hlVar.f6241a))) {
            return false;
        }
        boolean zM5646b = m5646b();
        boolean zM5646b2 = hlVar.m5646b();
        if ((zM5646b || zM5646b2) && !(zM5646b && zM5646b2 && this.f6240a.m5571a(hlVar.f6240a))) {
            return false;
        }
        boolean zM5647c = m5647c();
        boolean zM5647c2 = hlVar.m5647c();
        if ((zM5647c || zM5647c2) && !(zM5647c && zM5647c2 && this.f6243b.equals(hlVar.f6243b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hlVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6244c.equals(hlVar.f6244c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hlVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6239a == hlVar.f6239a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hlVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6245d.equals(hlVar.f6245d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hlVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6246e.equals(hlVar.f6246e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hlVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6247f.equals(hlVar.f6247f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hlVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f6248g.equals(hlVar.f6248g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hl hlVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5644a()).compareTo(Boolean.valueOf(hlVar.m5644a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5644a() && (iA9 = hs.a(this.f6241a, hlVar.f6241a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m5646b()).compareTo(Boolean.valueOf(hlVar.m5646b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5646b() && (iA8 = hs.a(this.f6240a, hlVar.f6240a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m5647c()).compareTo(Boolean.valueOf(hlVar.m5647c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5647c() && (iA7 = hs.a(this.f6243b, hlVar.f6243b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hs.a(this.f6244c, hlVar.f6244c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hs.a(this.f6239a, hlVar.f6239a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hs.a(this.f6245d, hlVar.f6245d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hs.a(this.f6246e, hlVar.f6246e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hs.a(this.f6247f, hlVar.f6247f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hs.a(this.f6248g, hlVar.f6248g)) == 0) {
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
                m5643a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6241a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6240a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6243b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6244c = ibVar.mo5672a();
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
                        this.f6239a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6245d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6246e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6247f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6248g = ibVar.mo5672a();
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
    public void m5643a() throws ic {
        if (this.f6243b != null) {
            return;
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
