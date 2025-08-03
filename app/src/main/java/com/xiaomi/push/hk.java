package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hk implements hr<hk, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gv f6230a;

    /* renamed from: a, reason: collision with other field name */
    public String f6231a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f6232a;

    /* renamed from: b, reason: collision with other field name */
    public String f6233b;

    /* renamed from: c, reason: collision with other field name */
    public String f6234c;

    /* renamed from: d, reason: collision with other field name */
    public String f6235d;

    /* renamed from: e, reason: collision with other field name */
    public String f6236e;

    /* renamed from: f, reason: collision with other field name */
    public String f6237f;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6229a = new ig("XmPushActionSubscription");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17889e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", com.umeng.analytics.pro.cb.m, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5641a() {
        return this.f6231a != null;
    }

    public boolean b() {
        return this.f6230a != null;
    }

    public boolean c() {
        return this.f6233b != null;
    }

    public boolean d() {
        return this.f6234c != null;
    }

    public boolean e() {
        return this.f6235d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m5642a((hk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6236e != null;
    }

    public boolean g() {
        return this.f6237f != null;
    }

    public boolean h() {
        return this.f6232a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m5641a()) {
            sb.append("debug:");
            String str = this.f6231a;
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
            gv gvVar = this.f6230a;
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
        String str2 = this.f6233b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6234c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f6235d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6236e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f6237f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f6232a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hk a(String str) {
        this.f6233b = str;
        return this;
    }

    public hk b(String str) {
        this.f6234c = str;
        return this;
    }

    public hk c(String str) {
        this.f6235d = str;
        return this;
    }

    public hk d(String str) {
        this.f6236e = str;
        return this;
    }

    public hk e(String str) {
        this.f6237f = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5642a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean zM5641a = m5641a();
        boolean zM5641a2 = hkVar.m5641a();
        if ((zM5641a || zM5641a2) && !(zM5641a && zM5641a2 && this.f6231a.equals(hkVar.f6231a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hkVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6230a.m5571a(hkVar.f6230a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hkVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6233b.equals(hkVar.f6233b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hkVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6234c.equals(hkVar.f6234c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hkVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6235d.equals(hkVar.f6235d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hkVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6236e.equals(hkVar.f6236e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hkVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6237f.equals(hkVar.f6237f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hkVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f6232a.equals(hkVar.f6232a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f6229a);
        if (this.f6231a != null && m5641a()) {
            ibVar.a(a);
            ibVar.a(this.f6231a);
            ibVar.b();
        }
        if (this.f6230a != null && b()) {
            ibVar.a(b);
            this.f6230a.b(ibVar);
            ibVar.b();
        }
        if (this.f6233b != null) {
            ibVar.a(c);
            ibVar.a(this.f6233b);
            ibVar.b();
        }
        if (this.f6234c != null) {
            ibVar.a(d);
            ibVar.a(this.f6234c);
            ibVar.b();
        }
        if (this.f6235d != null) {
            ibVar.a(f17889e);
            ibVar.a(this.f6235d);
            ibVar.b();
        }
        if (this.f6236e != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6236e);
            ibVar.b();
        }
        if (this.f6237f != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6237f);
            ibVar.b();
        }
        if (this.f6232a != null && h()) {
            ibVar.a(h);
            ibVar.a(new hz((byte) 11, this.f6232a.size()));
            Iterator<String> it = this.f6232a.iterator();
            while (it.hasNext()) {
                ibVar.a(it.next());
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hk hkVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5641a()).compareTo(Boolean.valueOf(hkVar.m5641a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5641a() && (iA8 = hs.a(this.f6231a, hkVar.f6231a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hkVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hs.a(this.f6230a, hkVar.f6230a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hkVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hs.a(this.f6233b, hkVar.f6233b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hs.a(this.f6234c, hkVar.f6234c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hs.a(this.f6235d, hkVar.f6235d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hs.a(this.f6236e, hkVar.f6236e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hs.a(this.f6237f, hkVar.f6237f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hs.a(this.f6232a, hkVar.f6232a)) == 0) {
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
                        this.f6231a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6230a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6233b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6234c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6235d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6236e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6237f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        hz hzVarMo5668a = ibVar.mo5668a();
                        this.f6232a = new ArrayList(hzVarMo5668a.f6305a);
                        for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                            this.f6232a.add(ibVar.mo5672a());
                        }
                        ibVar.i();
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
        if (this.f6233b != null) {
            if (this.f6234c != null) {
                if (this.f6235d != null) {
                    return;
                }
                throw new ic("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
