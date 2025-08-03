package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class ek implements hr<ek, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public byte f5835a;

    /* renamed from: a, reason: collision with other field name */
    public int f5836a;

    /* renamed from: a, reason: collision with other field name */
    public String f5837a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f5838a = new BitSet(6);

    /* renamed from: b, reason: collision with other field name */
    public int f5839b;

    /* renamed from: b, reason: collision with other field name */
    public String f5840b;

    /* renamed from: c, reason: collision with other field name */
    public int f5841c;

    /* renamed from: c, reason: collision with other field name */
    public String f5842c;

    /* renamed from: d, reason: collision with other field name */
    public int f5843d;

    /* renamed from: d, reason: collision with other field name */
    public String f5844d;

    /* renamed from: e, reason: collision with other field name */
    public int f5845e;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f5834a = new ig("StatsEvent");
    private static final hy a = new hy("", (byte) 3, 1);
    private static final hy b = new hy("", (byte) 8, 2);
    private static final hy c = new hy("", (byte) 8, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17858e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 8, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 11, 8);
    private static final hy i = new hy("", (byte) 8, 9);
    private static final hy j = new hy("", (byte) 8, 10);

    public ek a(byte b2) {
        this.f5835a = b2;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f5838a.get(1);
    }

    public boolean c() {
        return this.f5838a.get(2);
    }

    public boolean d() {
        return this.f5837a != null;
    }

    public boolean e() {
        return this.f5840b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ek)) {
            return m5441a((ek) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f5838a.get(3);
    }

    public boolean g() {
        return this.f5842c != null;
    }

    public boolean h() {
        return this.f5844d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f5838a.get(4);
    }

    public boolean j() {
        return this.f5838a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f5835a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f5836a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f5839b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f5837a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f5840b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f5841c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f5842c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f5844d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f5843d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f5845e);
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f5838a.set(1, z);
    }

    public void c(boolean z) {
        this.f5838a.set(2, z);
    }

    public void d(boolean z) {
        this.f5838a.set(3, z);
    }

    public void e(boolean z) {
        this.f5838a.set(4, z);
    }

    public void f(boolean z) {
        this.f5838a.set(5, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5440a() {
        return this.f5838a.get(0);
    }

    public ek b(int i2) {
        this.f5839b = i2;
        c(true);
        return this;
    }

    public ek c(int i2) {
        this.f5841c = i2;
        d(true);
        return this;
    }

    public ek d(String str) {
        this.f5844d = str;
        return this;
    }

    public void a(boolean z) {
        this.f5838a.set(0, z);
    }

    public ek d(int i2) {
        this.f5843d = i2;
        e(true);
        return this;
    }

    public ek a(int i2) {
        this.f5836a = i2;
        b(true);
        return this;
    }

    public ek b(String str) {
        this.f5840b = str;
        return this;
    }

    public ek c(String str) {
        this.f5842c = str;
        return this;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f5834a);
        ibVar.a(a);
        ibVar.a(this.f5835a);
        ibVar.b();
        ibVar.a(b);
        ibVar.mo5676a(this.f5836a);
        ibVar.b();
        ibVar.a(c);
        ibVar.mo5676a(this.f5839b);
        ibVar.b();
        if (this.f5837a != null) {
            ibVar.a(d);
            ibVar.a(this.f5837a);
            ibVar.b();
        }
        if (this.f5840b != null && e()) {
            ibVar.a(f17858e);
            ibVar.a(this.f5840b);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f);
            ibVar.mo5676a(this.f5841c);
            ibVar.b();
        }
        if (this.f5842c != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f5842c);
            ibVar.b();
        }
        if (this.f5844d != null && h()) {
            ibVar.a(h);
            ibVar.a(this.f5844d);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(i);
            ibVar.mo5676a(this.f5843d);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(j);
            ibVar.mo5676a(this.f5845e);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public ek a(String str) {
        this.f5837a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5441a(ek ekVar) {
        if (ekVar == null || this.f5835a != ekVar.f5835a || this.f5836a != ekVar.f5836a || this.f5839b != ekVar.f5839b) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ekVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f5837a.equals(ekVar.f5837a))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ekVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f5840b.equals(ekVar.f5840b))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ekVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f5841c == ekVar.f5841c)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ekVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f5842c.equals(ekVar.f5842c))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ekVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f5844d.equals(ekVar.f5844d))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ekVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f5843d == ekVar.f5843d)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ekVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f5845e == ekVar.f5845e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ek ekVar) {
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
        if (!getClass().equals(ekVar.getClass())) {
            return getClass().getName().compareTo(ekVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5440a()).compareTo(Boolean.valueOf(ekVar.m5440a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5440a() && (iA10 = hs.a(this.f5835a, ekVar.f5835a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ekVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = hs.a(this.f5836a, ekVar.f5836a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ekVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hs.a(this.f5839b, ekVar.f5839b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ekVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hs.a(this.f5837a, ekVar.f5837a)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ekVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hs.a(this.f5840b, ekVar.f5840b)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ekVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hs.a(this.f5841c, ekVar.f5841c)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ekVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hs.a(this.f5842c, ekVar.f5842c)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ekVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hs.a(this.f5844d, ekVar.f5844d)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ekVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hs.a(this.f5843d, ekVar.f5843d)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ekVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hs.a(this.f5845e, ekVar.f5845e)) == 0) {
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
                if (m5440a()) {
                    if (b()) {
                        if (c()) {
                            a();
                            return;
                        }
                        throw new ic("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new ic("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new ic("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 3) {
                        this.f5835a = ibVar.a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f5836a = ibVar.mo5665a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 8) {
                        this.f5839b = ibVar.mo5665a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f5837a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f5840b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 8) {
                        this.f5841c = ibVar.mo5665a();
                        d(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f5842c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f5844d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f5843d = ibVar.mo5665a();
                        e(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 8) {
                        this.f5845e = ibVar.mo5665a();
                        f(true);
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
        if (this.f5837a != null) {
            return;
        }
        throw new ic("Required field 'connpt' was not present! Struct: " + toString());
    }
}
