package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gk implements hr<gk, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f5974a;

    /* renamed from: a, reason: collision with other field name */
    public String f5975a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f5976a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f5977a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f5978a;

    /* renamed from: b, reason: collision with other field name */
    public long f5979b;

    /* renamed from: b, reason: collision with other field name */
    public String f5980b;

    /* renamed from: c, reason: collision with other field name */
    public String f5981c;

    /* renamed from: d, reason: collision with other field name */
    public String f5982d;

    /* renamed from: e, reason: collision with other field name */
    public String f5983e;

    /* renamed from: f, reason: collision with other field name */
    public String f5984f;

    /* renamed from: g, reason: collision with other field name */
    public String f5985g;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f5973a = new ig("ClientUploadDataItem");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 11, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 10, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17872e = new hy("", (byte) 10, 5);
    private static final hy f = new hy("", (byte) 2, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 11, 8);
    private static final hy i = new hy("", (byte) 11, 9);
    private static final hy j = new hy("", com.umeng.analytics.pro.cb.k, 10);
    private static final hy k = new hy("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other method in class */
    public String m5527a() {
        return this.f5975a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5529a() {
    }

    public gk b(String str) {
        this.f5980b = str;
        return this;
    }

    public gk c(String str) {
        this.f5981c = str;
        return this;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m5535d() {
        return this.f5976a.get(0);
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m5536e() {
        return this.f5976a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gk)) {
            return m5532a((gk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f5976a.get(2);
    }

    public boolean g() {
        return this.f5982d != null;
    }

    public boolean h() {
        return this.f5983e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f5984f != null;
    }

    public boolean j() {
        return this.f5977a != null;
    }

    public boolean k() {
        return this.f5985g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m5531a()) {
            sb.append("channel:");
            String str = this.f5975a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5533b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f5980b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m5534c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f5981c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m5535d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f5974a);
            z = false;
        }
        if (m5536e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f5979b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f5978a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f5982d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f5983e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f5984f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f5977a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f5985g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gk a(String str) {
        this.f5975a = str;
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5533b() {
        return this.f5980b != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5534c() {
        return this.f5981c != null;
    }

    public gk d(String str) {
        this.f5982d = str;
        return this;
    }

    public gk e(String str) {
        this.f5983e = str;
        return this;
    }

    public gk f(String str) {
        this.f5984f = str;
        return this;
    }

    public gk g(String str) {
        this.f5985g = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5531a() {
        return this.f5975a != null;
    }

    public String b() {
        return this.f5981c;
    }

    public void c(boolean z) {
        this.f5976a.set(2, z);
    }

    public String d() {
        return this.f5984f;
    }

    public String e() {
        return this.f5985g;
    }

    public gk a(long j2) {
        this.f5974a = j2;
        m5530a(true);
        return this;
    }

    public gk b(long j2) {
        this.f5979b = j2;
        b(true);
        return this;
    }

    public String c() {
        return this.f5983e;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5530a(boolean z) {
        this.f5976a.set(0, z);
    }

    public void b(boolean z) {
        this.f5976a.set(1, z);
    }

    public long a() {
        return this.f5979b;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) {
        m5529a();
        ibVar.a(f5973a);
        if (this.f5975a != null && m5531a()) {
            ibVar.a(a);
            ibVar.a(this.f5975a);
            ibVar.b();
        }
        if (this.f5980b != null && m5533b()) {
            ibVar.a(b);
            ibVar.a(this.f5980b);
            ibVar.b();
        }
        if (this.f5981c != null && m5534c()) {
            ibVar.a(c);
            ibVar.a(this.f5981c);
            ibVar.b();
        }
        if (m5535d()) {
            ibVar.a(d);
            ibVar.a(this.f5974a);
            ibVar.b();
        }
        if (m5536e()) {
            ibVar.a(f17872e);
            ibVar.a(this.f5979b);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f);
            ibVar.a(this.f5978a);
            ibVar.b();
        }
        if (this.f5982d != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f5982d);
            ibVar.b();
        }
        if (this.f5983e != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f5983e);
            ibVar.b();
        }
        if (this.f5984f != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f5984f);
            ibVar.b();
        }
        if (this.f5977a != null && j()) {
            ibVar.a(j);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f5977a.size()));
            for (Map.Entry<String, String> entry : this.f5977a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f5985g != null && k()) {
            ibVar.a(k);
            ibVar.a(this.f5985g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public gk a(boolean z) {
        this.f5978a = z;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f5977a == null) {
            this.f5977a = new HashMap();
        }
        this.f5977a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m5528a() {
        return this.f5977a;
    }

    public gk a(Map<String, String> map) {
        this.f5977a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5532a(gk gkVar) {
        if (gkVar == null) {
            return false;
        }
        boolean zM5531a = m5531a();
        boolean zM5531a2 = gkVar.m5531a();
        if ((zM5531a || zM5531a2) && !(zM5531a && zM5531a2 && this.f5975a.equals(gkVar.f5975a))) {
            return false;
        }
        boolean zM5533b = m5533b();
        boolean zM5533b2 = gkVar.m5533b();
        if ((zM5533b || zM5533b2) && !(zM5533b && zM5533b2 && this.f5980b.equals(gkVar.f5980b))) {
            return false;
        }
        boolean zM5534c = m5534c();
        boolean zM5534c2 = gkVar.m5534c();
        if ((zM5534c || zM5534c2) && !(zM5534c && zM5534c2 && this.f5981c.equals(gkVar.f5981c))) {
            return false;
        }
        boolean zM5535d = m5535d();
        boolean zM5535d2 = gkVar.m5535d();
        if ((zM5535d || zM5535d2) && !(zM5535d && zM5535d2 && this.f5974a == gkVar.f5974a)) {
            return false;
        }
        boolean zM5536e = m5536e();
        boolean zM5536e2 = gkVar.m5536e();
        if ((zM5536e || zM5536e2) && !(zM5536e && zM5536e2 && this.f5979b == gkVar.f5979b)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gkVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f5978a == gkVar.f5978a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gkVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f5982d.equals(gkVar.f5982d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gkVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f5983e.equals(gkVar.f5983e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gkVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f5984f.equals(gkVar.f5984f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gkVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f5977a.equals(gkVar.f5977a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gkVar.k();
        if (zK || zK2) {
            return zK && zK2 && this.f5985g.equals(gkVar.f5985g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gk gkVar) {
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
        if (!getClass().equals(gkVar.getClass())) {
            return getClass().getName().compareTo(gkVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5531a()).compareTo(Boolean.valueOf(gkVar.m5531a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5531a() && (iA11 = hs.a(this.f5975a, gkVar.f5975a)) != 0) {
            return iA11;
        }
        int iCompareTo2 = Boolean.valueOf(m5533b()).compareTo(Boolean.valueOf(gkVar.m5533b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5533b() && (iA10 = hs.a(this.f5980b, gkVar.f5980b)) != 0) {
            return iA10;
        }
        int iCompareTo3 = Boolean.valueOf(m5534c()).compareTo(Boolean.valueOf(gkVar.m5534c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5534c() && (iA9 = hs.a(this.f5981c, gkVar.f5981c)) != 0) {
            return iA9;
        }
        int iCompareTo4 = Boolean.valueOf(m5535d()).compareTo(Boolean.valueOf(gkVar.m5535d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m5535d() && (iA8 = hs.a(this.f5974a, gkVar.f5974a)) != 0) {
            return iA8;
        }
        int iCompareTo5 = Boolean.valueOf(m5536e()).compareTo(Boolean.valueOf(gkVar.m5536e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m5536e() && (iA7 = hs.a(this.f5979b, gkVar.f5979b)) != 0) {
            return iA7;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gkVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA6 = hs.a(this.f5978a, gkVar.f5978a)) != 0) {
            return iA6;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gkVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA5 = hs.a(this.f5982d, gkVar.f5982d)) != 0) {
            return iA5;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gkVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA4 = hs.a(this.f5983e, gkVar.f5983e)) != 0) {
            return iA4;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gkVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA3 = hs.a(this.f5984f, gkVar.f5984f)) != 0) {
            return iA3;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gkVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA2 = hs.a(this.f5977a, gkVar.f5977a)) != 0) {
            return iA2;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gkVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (!k() || (iA = hs.a(this.f5985g, gkVar.f5985g)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hr
    public void a(ib ibVar) {
        ibVar.mo5671a();
        while (true) {
            hy hyVarMo5667a = ibVar.mo5667a();
            byte b2 = hyVarMo5667a.a;
            if (b2 == 0) {
                ibVar.f();
                m5529a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f5975a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 11) {
                        this.f5980b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f5981c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 10) {
                        this.f5974a = ibVar.mo5666a();
                        m5530a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f5979b = ibVar.mo5666a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 2) {
                        this.f5978a = ibVar.mo5677a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f5982d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f5983e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f5984f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        ia iaVarMo5669a = ibVar.mo5669a();
                        this.f5977a = new HashMap(iaVarMo5669a.f6308a * 2);
                        for (int i2 = 0; i2 < iaVarMo5669a.f6308a; i2++) {
                            this.f5977a.put(ibVar.mo5672a(), ibVar.mo5672a());
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f5985g = ibVar.mo5672a();
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
}
