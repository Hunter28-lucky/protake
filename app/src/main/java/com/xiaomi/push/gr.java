package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gr implements hr<gr, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f6005a;

    /* renamed from: a, reason: collision with other field name */
    public long f6006a;

    /* renamed from: a, reason: collision with other field name */
    public String f6007a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6008a = new BitSet(6);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6009a;

    /* renamed from: b, reason: collision with other field name */
    public int f6010b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f6011b;

    /* renamed from: c, reason: collision with other field name */
    public int f6012c;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6004a = new ig("OnlineConfigItem");
    private static final hy a = new hy("", (byte) 8, 1);
    private static final hy b = new hy("", (byte) 8, 2);
    private static final hy c = new hy("", (byte) 2, 3);
    private static final hy d = new hy("", (byte) 8, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17875e = new hy("", (byte) 10, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 2, 7);

    public int a() {
        return this.f6005a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5546a() {
    }

    public int b() {
        return this.f6010b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5550c() {
        return this.f6008a.get(2);
    }

    public boolean d() {
        return this.f6008a.get(3);
    }

    public boolean e() {
        return this.f6008a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gr)) {
            return m5548a((gr) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6007a != null;
    }

    public boolean g() {
        return this.f6011b;
    }

    public boolean h() {
        return this.f6008a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m5547a()) {
            sb.append("key:");
            sb.append(this.f6005a);
            z = false;
        } else {
            z = true;
        }
        if (m5549b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f6010b);
            z = false;
        }
        if (m5550c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f6009a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f6012c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f6006a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f6007a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f6011b);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5547a() {
        return this.f6008a.get(0);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5549b() {
        return this.f6008a.get(1);
    }

    public void c(boolean z) {
        this.f6008a.set(2, z);
    }

    public void d(boolean z) {
        this.f6008a.set(3, z);
    }

    public void e(boolean z) {
        this.f6008a.set(4, z);
    }

    public void f(boolean z) {
        this.f6008a.set(5, z);
    }

    public void a(boolean z) {
        this.f6008a.set(0, z);
    }

    public void b(boolean z) {
        this.f6008a.set(1, z);
    }

    public int c() {
        return this.f6012c;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m5544a() {
        return this.f6006a;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) {
        m5546a();
        ibVar.a(f6004a);
        if (m5547a()) {
            ibVar.a(a);
            ibVar.mo5676a(this.f6005a);
            ibVar.b();
        }
        if (m5549b()) {
            ibVar.a(b);
            ibVar.mo5676a(this.f6010b);
            ibVar.b();
        }
        if (m5550c()) {
            ibVar.a(c);
            ibVar.a(this.f6009a);
            ibVar.b();
        }
        if (d()) {
            ibVar.a(d);
            ibVar.mo5676a(this.f6012c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f17875e);
            ibVar.a(this.f6006a);
            ibVar.b();
        }
        if (this.f6007a != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6007a);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(g);
            ibVar.a(this.f6011b);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5545a() {
        return this.f6007a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5548a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean zM5547a = m5547a();
        boolean zM5547a2 = grVar.m5547a();
        if ((zM5547a || zM5547a2) && !(zM5547a && zM5547a2 && this.f6005a == grVar.f6005a)) {
            return false;
        }
        boolean zM5549b = m5549b();
        boolean zM5549b2 = grVar.m5549b();
        if ((zM5549b || zM5549b2) && !(zM5549b && zM5549b2 && this.f6010b == grVar.f6010b)) {
            return false;
        }
        boolean zM5550c = m5550c();
        boolean zM5550c2 = grVar.m5550c();
        if ((zM5550c || zM5550c2) && !(zM5550c && zM5550c2 && this.f6009a == grVar.f6009a)) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = grVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6012c == grVar.f6012c)) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = grVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6006a == grVar.f6006a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = grVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6007a.equals(grVar.f6007a))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = grVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f6011b == grVar.f6011b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gr grVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5547a()).compareTo(Boolean.valueOf(grVar.m5547a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5547a() && (iA7 = hs.a(this.f6005a, grVar.f6005a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(m5549b()).compareTo(Boolean.valueOf(grVar.m5549b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5549b() && (iA6 = hs.a(this.f6010b, grVar.f6010b)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(m5550c()).compareTo(Boolean.valueOf(grVar.m5550c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5550c() && (iA5 = hs.a(this.f6009a, grVar.f6009a)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(grVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = hs.a(this.f6012c, grVar.f6012c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = hs.a(this.f6006a, grVar.f6006a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = hs.a(this.f6007a, grVar.f6007a)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!h() || (iA = hs.a(this.f6011b, grVar.f6011b)) == 0) {
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
                m5546a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 8) {
                        this.f6005a = ibVar.mo5665a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 8) {
                        this.f6010b = ibVar.mo5665a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f6009a = ibVar.mo5677a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 8) {
                        this.f6012c = ibVar.mo5665a();
                        d(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 10) {
                        this.f6006a = ibVar.mo5666a();
                        e(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6007a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 2) {
                        this.f6011b = ibVar.mo5677a();
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
}
