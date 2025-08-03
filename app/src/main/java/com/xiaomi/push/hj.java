package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class hj implements hr<hj, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gs f6216a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6217a;

    /* renamed from: a, reason: collision with other field name */
    public String f6218a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f6220a;

    /* renamed from: b, reason: collision with other field name */
    public String f6222b;

    /* renamed from: c, reason: collision with other field name */
    public String f6223c;

    /* renamed from: d, reason: collision with other field name */
    public String f6224d;

    /* renamed from: e, reason: collision with other field name */
    public String f6225e;

    /* renamed from: f, reason: collision with other field name */
    public String f6226f;

    /* renamed from: g, reason: collision with other field name */
    public String f6227g;

    /* renamed from: h, reason: collision with other field name */
    public String f6228h;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6215a = new ig("XmPushActionSendMessage");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17888e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 12, 8);
    private static final hy i = new hy("", (byte) 2, 9);
    private static final hy j = new hy("", com.umeng.analytics.pro.cb.k, 10);
    private static final hy k = new hy("", (byte) 11, 11);
    private static final hy l = new hy("", (byte) 11, 12);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6219a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6221a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5634a() {
        return this.f6218a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5636b() {
        return this.f6217a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5637c() {
        return this.f6222b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m5638d() {
        return this.f6223c != null;
    }

    /* renamed from: e, reason: collision with other method in class */
    public boolean m5639e() {
        return this.f6224d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m5635a((hj) obj);
        }
        return false;
    }

    /* renamed from: f, reason: collision with other method in class */
    public boolean m5640f() {
        return this.f6225e != null;
    }

    public boolean g() {
        return this.f6226f != null;
    }

    public boolean h() {
        return this.f6216a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6219a.get(0);
    }

    public boolean j() {
        return this.f6220a != null;
    }

    public boolean k() {
        return this.f6227g != null;
    }

    public boolean l() {
        return this.f6228h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m5634a()) {
            sb.append("debug:");
            String str = this.f6218a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5636b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6217a;
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
        String str2 = this.f6222b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6223c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m5639e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f6224d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m5640f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f6225e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f6226f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            gs gsVar = this.f6216a;
            if (gsVar == null) {
                sb.append("null");
            } else {
                sb.append(gsVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f6221a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f6220a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6227g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f6228h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5632a() {
        return this.f6222b;
    }

    public String b() {
        return this.f6223c;
    }

    public String c() {
        return this.f6225e;
    }

    public String d() {
        return this.f6226f;
    }

    public String e() {
        return this.f6227g;
    }

    public String f() {
        return this.f6228h;
    }

    public gs a() {
        return this.f6216a;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5633a();
        ibVar.a(f6215a);
        if (this.f6218a != null && m5634a()) {
            ibVar.a(a);
            ibVar.a(this.f6218a);
            ibVar.b();
        }
        if (this.f6217a != null && m5636b()) {
            ibVar.a(b);
            this.f6217a.b(ibVar);
            ibVar.b();
        }
        if (this.f6222b != null) {
            ibVar.a(c);
            ibVar.a(this.f6222b);
            ibVar.b();
        }
        if (this.f6223c != null) {
            ibVar.a(d);
            ibVar.a(this.f6223c);
            ibVar.b();
        }
        if (this.f6224d != null && m5639e()) {
            ibVar.a(f17888e);
            ibVar.a(this.f6224d);
            ibVar.b();
        }
        if (this.f6225e != null && m5640f()) {
            ibVar.a(f);
            ibVar.a(this.f6225e);
            ibVar.b();
        }
        if (this.f6226f != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6226f);
            ibVar.b();
        }
        if (this.f6216a != null && h()) {
            ibVar.a(h);
            this.f6216a.b(ibVar);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(i);
            ibVar.a(this.f6221a);
            ibVar.b();
        }
        if (this.f6220a != null && j()) {
            ibVar.a(j);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6220a.size()));
            for (Map.Entry<String, String> entry : this.f6220a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f6227g != null && k()) {
            ibVar.a(k);
            ibVar.a(this.f6227g);
            ibVar.b();
        }
        if (this.f6228h != null && l()) {
            ibVar.a(l);
            ibVar.a(this.f6228h);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public void a(boolean z) {
        this.f6219a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5635a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean zM5634a = m5634a();
        boolean zM5634a2 = hjVar.m5634a();
        if ((zM5634a || zM5634a2) && !(zM5634a && zM5634a2 && this.f6218a.equals(hjVar.f6218a))) {
            return false;
        }
        boolean zM5636b = m5636b();
        boolean zM5636b2 = hjVar.m5636b();
        if ((zM5636b || zM5636b2) && !(zM5636b && zM5636b2 && this.f6217a.m5571a(hjVar.f6217a))) {
            return false;
        }
        boolean zM5637c = m5637c();
        boolean zM5637c2 = hjVar.m5637c();
        if ((zM5637c || zM5637c2) && !(zM5637c && zM5637c2 && this.f6222b.equals(hjVar.f6222b))) {
            return false;
        }
        boolean zM5638d = m5638d();
        boolean zM5638d2 = hjVar.m5638d();
        if ((zM5638d || zM5638d2) && !(zM5638d && zM5638d2 && this.f6223c.equals(hjVar.f6223c))) {
            return false;
        }
        boolean zM5639e = m5639e();
        boolean zM5639e2 = hjVar.m5639e();
        if ((zM5639e || zM5639e2) && !(zM5639e && zM5639e2 && this.f6224d.equals(hjVar.f6224d))) {
            return false;
        }
        boolean zM5640f = m5640f();
        boolean zM5640f2 = hjVar.m5640f();
        if ((zM5640f || zM5640f2) && !(zM5640f && zM5640f2 && this.f6225e.equals(hjVar.f6225e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hjVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6226f.equals(hjVar.f6226f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hjVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6216a.m5554a(hjVar.f6216a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hjVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6221a == hjVar.f6221a)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hjVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6220a.equals(hjVar.f6220a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hjVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6227g.equals(hjVar.f6227g))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hjVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f6228h.equals(hjVar.f6228h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hj hjVar) {
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
        if (!getClass().equals(hjVar.getClass())) {
            return getClass().getName().compareTo(hjVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5634a()).compareTo(Boolean.valueOf(hjVar.m5634a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5634a() && (iA12 = hs.a(this.f6218a, hjVar.f6218a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(m5636b()).compareTo(Boolean.valueOf(hjVar.m5636b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5636b() && (iA11 = hs.a(this.f6217a, hjVar.f6217a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(m5637c()).compareTo(Boolean.valueOf(hjVar.m5637c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5637c() && (iA10 = hs.a(this.f6222b, hjVar.f6222b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(m5638d()).compareTo(Boolean.valueOf(hjVar.m5638d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m5638d() && (iA9 = hs.a(this.f6223c, hjVar.f6223c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(m5639e()).compareTo(Boolean.valueOf(hjVar.m5639e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m5639e() && (iA8 = hs.a(this.f6224d, hjVar.f6224d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(m5640f()).compareTo(Boolean.valueOf(hjVar.m5640f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (m5640f() && (iA7 = hs.a(this.f6225e, hjVar.f6225e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = hs.a(this.f6226f, hjVar.f6226f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = hs.a(this.f6216a, hjVar.f6216a)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hjVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = hs.a(this.f6221a, hjVar.f6221a)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hjVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = hs.a(this.f6220a, hjVar.f6220a)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hjVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = hs.a(this.f6227g, hjVar.f6227g)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hjVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = hs.a(this.f6228h, hjVar.f6228h)) == 0) {
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
                m5633a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6218a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6217a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6222b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6223c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6224d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6225e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6226f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        gs gsVar = new gs();
                        this.f6216a = gsVar;
                        gsVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 2) {
                        this.f6221a = ibVar.mo5677a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        ia iaVarMo5669a = ibVar.mo5669a();
                        this.f6220a = new HashMap(iaVarMo5669a.f6308a * 2);
                        for (int i2 = 0; i2 < iaVarMo5669a.f6308a; i2++) {
                            this.f6220a.put(ibVar.mo5672a(), ibVar.mo5672a());
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 11) {
                        this.f6227g = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f6228h = ibVar.mo5672a();
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

    /* renamed from: a, reason: collision with other method in class */
    public void m5633a() throws ic {
        if (this.f6222b != null) {
            if (this.f6223c != null) {
                return;
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
