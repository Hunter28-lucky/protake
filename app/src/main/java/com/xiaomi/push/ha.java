package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ha implements hr<ha, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6099a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6100a;

    /* renamed from: a, reason: collision with other field name */
    public String f6101a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f6103a;

    /* renamed from: b, reason: collision with other field name */
    public String f6105b;

    /* renamed from: c, reason: collision with other field name */
    public String f6107c;

    /* renamed from: d, reason: collision with other field name */
    public String f6108d;

    /* renamed from: e, reason: collision with other field name */
    public String f6109e;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6098a = new ig("XmPushActionCommand");
    private static final hy a = new hy("", (byte) 12, 2);
    private static final hy b = new hy("", (byte) 11, 3);
    private static final hy c = new hy("", (byte) 11, 4);
    private static final hy d = new hy("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17881e = new hy("", com.umeng.analytics.pro.cb.m, 6);
    private static final hy f = new hy("", (byte) 11, 7);
    private static final hy g = new hy("", (byte) 11, 9);
    private static final hy h = new hy("", (byte) 2, 10);
    private static final hy i = new hy("", (byte) 2, 11);
    private static final hy j = new hy("", (byte) 10, 12);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6102a = new BitSet(3);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6104a = false;

    /* renamed from: b, reason: collision with other field name */
    public boolean f6106b = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5585a() {
        return this.f6100a != null;
    }

    public boolean b() {
        return this.f6101a != null;
    }

    public boolean c() {
        return this.f6105b != null;
    }

    public boolean d() {
        return this.f6107c != null;
    }

    public boolean e() {
        return this.f6103a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ha)) {
            return m5586a((ha) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6108d != null;
    }

    public boolean g() {
        return this.f6109e != null;
    }

    public boolean h() {
        return this.f6102a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6102a.get(1);
    }

    public boolean j() {
        return this.f6102a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m5585a()) {
            sb.append("target:");
            gv gvVar = this.f6100a;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f6101a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f6105b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f6107c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f6103a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f6108d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f6109e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f6104a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f6106b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6099a);
        }
        sb.append(")");
        return sb.toString();
    }

    public ha a(String str) {
        this.f6101a = str;
        return this;
    }

    public ha b(String str) {
        this.f6105b = str;
        return this;
    }

    public ha c(String str) {
        this.f6107c = str;
        return this;
    }

    public ha d(String str) {
        this.f6108d = str;
        return this;
    }

    public ha e(String str) {
        this.f6109e = str;
        return this;
    }

    public String a() {
        return this.f6107c;
    }

    public void b(boolean z) {
        this.f6102a.set(1, z);
    }

    public void c(boolean z) {
        this.f6102a.set(2, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5584a(String str) {
        if (this.f6103a == null) {
            this.f6103a = new ArrayList();
        }
        this.f6103a.add(str);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5583a();
        ibVar.a(f6098a);
        if (this.f6100a != null && m5585a()) {
            ibVar.a(a);
            this.f6100a.b(ibVar);
            ibVar.b();
        }
        if (this.f6101a != null) {
            ibVar.a(b);
            ibVar.a(this.f6101a);
            ibVar.b();
        }
        if (this.f6105b != null) {
            ibVar.a(c);
            ibVar.a(this.f6105b);
            ibVar.b();
        }
        if (this.f6107c != null) {
            ibVar.a(d);
            ibVar.a(this.f6107c);
            ibVar.b();
        }
        if (this.f6103a != null && e()) {
            ibVar.a(f17881e);
            ibVar.a(new hz((byte) 11, this.f6103a.size()));
            Iterator<String> it = this.f6103a.iterator();
            while (it.hasNext()) {
                ibVar.a(it.next());
            }
            ibVar.e();
            ibVar.b();
        }
        if (this.f6108d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6108d);
            ibVar.b();
        }
        if (this.f6109e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6109e);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(h);
            ibVar.a(this.f6104a);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(i);
            ibVar.a(this.f6106b);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(j);
            ibVar.a(this.f6099a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public void a(boolean z) {
        this.f6102a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5586a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean zM5585a = m5585a();
        boolean zM5585a2 = haVar.m5585a();
        if ((zM5585a || zM5585a2) && !(zM5585a && zM5585a2 && this.f6100a.m5571a(haVar.f6100a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = haVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6101a.equals(haVar.f6101a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = haVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6105b.equals(haVar.f6105b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = haVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6107c.equals(haVar.f6107c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = haVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6103a.equals(haVar.f6103a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = haVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6108d.equals(haVar.f6108d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = haVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6109e.equals(haVar.f6109e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = haVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6104a == haVar.f6104a)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = haVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6106b == haVar.f6106b)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = haVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f6099a == haVar.f6099a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
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
        if (!getClass().equals(haVar.getClass())) {
            return getClass().getName().compareTo(haVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5585a()).compareTo(Boolean.valueOf(haVar.m5585a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5585a() && (iA10 = hs.a(this.f6100a, haVar.f6100a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(haVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = hs.a(this.f6101a, haVar.f6101a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(haVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hs.a(this.f6105b, haVar.f6105b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hs.a(this.f6107c, haVar.f6107c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hs.a(this.f6103a, haVar.f6103a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hs.a(this.f6108d, haVar.f6108d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hs.a(this.f6109e, haVar.f6109e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hs.a(this.f6104a, haVar.f6104a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hs.a(this.f6106b, haVar.f6106b)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hs.a(this.f6099a, haVar.f6099a)) == 0) {
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
                m5583a();
                return;
            }
            switch (hyVarMo5667a.f6304a) {
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6100a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6101a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6105b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6107c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 15) {
                        hz hzVarMo5668a = ibVar.mo5668a();
                        this.f6103a = new ArrayList(hzVarMo5668a.f6305a);
                        for (int i2 = 0; i2 < hzVarMo5668a.f6305a; i2++) {
                            this.f6103a.add(ibVar.mo5672a());
                        }
                        ibVar.i();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6108d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                default:
                    ie.a(ibVar, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f6109e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 2) {
                        this.f6104a = ibVar.mo5677a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 2) {
                        this.f6106b = ibVar.mo5677a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 10) {
                        this.f6099a = ibVar.mo5666a();
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
    public void m5583a() throws ic {
        if (this.f6101a != null) {
            if (this.f6105b != null) {
                if (this.f6107c != null) {
                    return;
                }
                throw new ic("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
