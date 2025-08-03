package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gx implements hr<gx, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gv f6082a;

    /* renamed from: a, reason: collision with other field name */
    public String f6083a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f6085a;

    /* renamed from: b, reason: collision with other field name */
    public String f6086b;

    /* renamed from: c, reason: collision with other field name */
    public String f6087c;

    /* renamed from: d, reason: collision with other field name */
    public String f6088d;

    /* renamed from: e, reason: collision with other field name */
    public String f6089e;

    /* renamed from: f, reason: collision with other field name */
    public String f6090f;

    /* renamed from: g, reason: collision with other field name */
    public String f6091g;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6080a = new ig("XmPushActionAckNotification");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17880e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 10, 7);
    private static final hy g = new hy("", (byte) 11, 8);
    private static final hy h = new hy("", com.umeng.analytics.pro.cb.k, 9);
    private static final hy i = new hy("", (byte) 11, 10);
    private static final hy j = new hy("", (byte) 11, 11);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6084a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public long f6081a = 0;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5576a() {
        return this.f6083a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5578b() {
        return this.f6082a != null;
    }

    public boolean c() {
        return this.f6086b != null;
    }

    public boolean d() {
        return this.f6087c != null;
    }

    public boolean e() {
        return this.f6088d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gx)) {
            return m5577a((gx) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6084a.get(0);
    }

    public boolean g() {
        return this.f6089e != null;
    }

    public boolean h() {
        return this.f6085a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6090f != null;
    }

    public boolean j() {
        return this.f6091g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m5576a()) {
            sb.append("debug:");
            String str = this.f6083a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5578b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6082a;
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
        String str2 = this.f6086b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f6087c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f6088d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f6081a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f6089e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f6085a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6090f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6091g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gx a(gv gvVar) {
        this.f6082a = gvVar;
        return this;
    }

    public gx b(String str) {
        this.f6087c = str;
        return this;
    }

    public gx c(String str) {
        this.f6088d = str;
        return this;
    }

    public gx d(String str) {
        this.f6089e = str;
        return this;
    }

    public gx e(String str) {
        this.f6090f = str;
        return this;
    }

    public String a() {
        return this.f6086b;
    }

    public String b() {
        return this.f6088d;
    }

    public gx a(String str) {
        this.f6086b = str;
        return this;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5575a();
        ibVar.a(f6080a);
        if (this.f6083a != null && m5576a()) {
            ibVar.a(a);
            ibVar.a(this.f6083a);
            ibVar.b();
        }
        if (this.f6082a != null && m5578b()) {
            ibVar.a(b);
            this.f6082a.b(ibVar);
            ibVar.b();
        }
        if (this.f6086b != null) {
            ibVar.a(c);
            ibVar.a(this.f6086b);
            ibVar.b();
        }
        if (this.f6087c != null && d()) {
            ibVar.a(d);
            ibVar.a(this.f6087c);
            ibVar.b();
        }
        if (this.f6088d != null && e()) {
            ibVar.a(f17880e);
            ibVar.a(this.f6088d);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f);
            ibVar.a(this.f6081a);
            ibVar.b();
        }
        if (this.f6089e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6089e);
            ibVar.b();
        }
        if (this.f6085a != null && h()) {
            ibVar.a(h);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6085a.size()));
            for (Map.Entry<String, String> entry : this.f6085a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f6090f != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6090f);
            ibVar.b();
        }
        if (this.f6091g != null && j()) {
            ibVar.a(j);
            ibVar.a(this.f6091g);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public gx a(long j2) {
        this.f6081a = j2;
        a(true);
        return this;
    }

    public void a(boolean z) {
        this.f6084a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m5574a() {
        return this.f6085a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5577a(gx gxVar) {
        if (gxVar == null) {
            return false;
        }
        boolean zM5576a = m5576a();
        boolean zM5576a2 = gxVar.m5576a();
        if ((zM5576a || zM5576a2) && !(zM5576a && zM5576a2 && this.f6083a.equals(gxVar.f6083a))) {
            return false;
        }
        boolean zM5578b = m5578b();
        boolean zM5578b2 = gxVar.m5578b();
        if ((zM5578b || zM5578b2) && !(zM5578b && zM5578b2 && this.f6082a.m5571a(gxVar.f6082a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gxVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6086b.equals(gxVar.f6086b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gxVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6087c.equals(gxVar.f6087c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gxVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6088d.equals(gxVar.f6088d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gxVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6081a == gxVar.f6081a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gxVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6089e.equals(gxVar.f6089e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gxVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6085a.equals(gxVar.f6085a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gxVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6090f.equals(gxVar.f6090f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gxVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f6091g.equals(gxVar.f6091g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gx gxVar) {
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
        if (!getClass().equals(gxVar.getClass())) {
            return getClass().getName().compareTo(gxVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5576a()).compareTo(Boolean.valueOf(gxVar.m5576a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5576a() && (iA10 = hs.a(this.f6083a, gxVar.f6083a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m5578b()).compareTo(Boolean.valueOf(gxVar.m5578b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5578b() && (iA9 = hs.a(this.f6082a, gxVar.f6082a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gxVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hs.a(this.f6086b, gxVar.f6086b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gxVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hs.a(this.f6087c, gxVar.f6087c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gxVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hs.a(this.f6088d, gxVar.f6088d)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gxVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hs.a(this.f6081a, gxVar.f6081a)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gxVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hs.a(this.f6089e, gxVar.f6089e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gxVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hs.a(this.f6085a, gxVar.f6085a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gxVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hs.a(this.f6090f, gxVar.f6090f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gxVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hs.a(this.f6091g, gxVar.f6091g)) == 0) {
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
                m5575a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6083a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6082a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6086b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6087c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6088d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                default:
                    ie.a(ibVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f6081a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6089e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 13) {
                        ia iaVarMo5669a = ibVar.mo5669a();
                        this.f6085a = new HashMap(iaVarMo5669a.f6308a * 2);
                        for (int i2 = 0; i2 < iaVarMo5669a.f6308a; i2++) {
                            this.f6085a.put(ibVar.mo5672a(), ibVar.mo5672a());
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6090f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f6091g = ibVar.mo5672a();
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
    public void m5575a() throws ic {
        if (this.f6086b != null) {
            return;
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
