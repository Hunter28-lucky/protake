package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hn implements hr<hn, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6264a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6265a;

    /* renamed from: a, reason: collision with other field name */
    public String f6266a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6267a = new BitSet(3);

    /* renamed from: b, reason: collision with other field name */
    public long f6268b;

    /* renamed from: b, reason: collision with other field name */
    public String f6269b;

    /* renamed from: c, reason: collision with other field name */
    public long f6270c;

    /* renamed from: c, reason: collision with other field name */
    public String f6271c;

    /* renamed from: d, reason: collision with other field name */
    public String f6272d;

    /* renamed from: e, reason: collision with other field name */
    public String f6273e;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6263a = new ig("XmPushActionUnRegistrationResult");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17892e = new hy("", (byte) 10, 6);
    private static final hy f = new hy("", (byte) 11, 7);
    private static final hy g = new hy("", (byte) 11, 8);
    private static final hy h = new hy("", (byte) 10, 9);
    private static final hy i = new hy("", (byte) 10, 10);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5651a() {
        return this.f6266a != null;
    }

    public boolean b() {
        return this.f6265a != null;
    }

    public boolean c() {
        return this.f6269b != null;
    }

    public boolean d() {
        return this.f6271c != null;
    }

    public boolean e() {
        return this.f6267a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m5652a((hn) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6272d != null;
    }

    public boolean g() {
        return this.f6273e != null;
    }

    public boolean h() {
        return this.f6267a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6267a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m5651a()) {
            sb.append("debug:");
            String str = this.f6266a;
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
            gv gvVar = this.f6265a;
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
        String str2 = this.f6269b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6271c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f6264a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6272d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6273e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f6268b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f6270c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f6267a.set(0, z);
    }

    public void b(boolean z) {
        this.f6267a.set(1, z);
    }

    public void c(boolean z) {
        this.f6267a.set(2, z);
    }

    public String a() {
        return this.f6273e;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5650a();
        ibVar.a(f6263a);
        if (this.f6266a != null && m5651a()) {
            ibVar.a(a);
            ibVar.a(this.f6266a);
            ibVar.b();
        }
        if (this.f6265a != null && b()) {
            ibVar.a(b);
            this.f6265a.b(ibVar);
            ibVar.b();
        }
        if (this.f6269b != null) {
            ibVar.a(c);
            ibVar.a(this.f6269b);
            ibVar.b();
        }
        if (this.f6271c != null) {
            ibVar.a(d);
            ibVar.a(this.f6271c);
            ibVar.b();
        }
        ibVar.a(f17892e);
        ibVar.a(this.f6264a);
        ibVar.b();
        if (this.f6272d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6272d);
            ibVar.b();
        }
        if (this.f6273e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6273e);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(h);
            ibVar.a(this.f6268b);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(i);
            ibVar.a(this.f6270c);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5652a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean zM5651a = m5651a();
        boolean zM5651a2 = hnVar.m5651a();
        if ((zM5651a || zM5651a2) && !(zM5651a && zM5651a2 && this.f6266a.equals(hnVar.f6266a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hnVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6265a.m5571a(hnVar.f6265a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hnVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6269b.equals(hnVar.f6269b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hnVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f6271c.equals(hnVar.f6271c))) || this.f6264a != hnVar.f6264a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hnVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6272d.equals(hnVar.f6272d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hnVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6273e.equals(hnVar.f6273e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hnVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6268b == hnVar.f6268b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hnVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f6270c == hnVar.f6270c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hn hnVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(hnVar.getClass())) {
            return getClass().getName().compareTo(hnVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5651a()).compareTo(Boolean.valueOf(hnVar.m5651a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5651a() && (iA9 = hs.a(this.f6266a, hnVar.f6266a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA8 = hs.a(this.f6265a, hnVar.f6265a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA7 = hs.a(this.f6269b, hnVar.f6269b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hs.a(this.f6271c, hnVar.f6271c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hs.a(this.f6264a, hnVar.f6264a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hs.a(this.f6272d, hnVar.f6272d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hs.a(this.f6273e, hnVar.f6273e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hs.a(this.f6268b, hnVar.f6268b)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hnVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hs.a(this.f6270c, hnVar.f6270c)) == 0) {
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
                    m5650a();
                    return;
                }
                throw new ic("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6266a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6265a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6269b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6271c = ibVar.mo5672a();
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
                        this.f6264a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6272d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6273e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 10) {
                        this.f6268b = ibVar.mo5666a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 10) {
                        this.f6270c = ibVar.mo5666a();
                        c(true);
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
    public void m5650a() throws ic {
        if (this.f6269b != null) {
            if (this.f6271c != null) {
                return;
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
