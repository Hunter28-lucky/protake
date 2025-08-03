package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ho implements hr<ho, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gv f6275a;

    /* renamed from: a, reason: collision with other field name */
    public String f6276a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f6277a;

    /* renamed from: b, reason: collision with other field name */
    public String f6278b;

    /* renamed from: c, reason: collision with other field name */
    public String f6279c;

    /* renamed from: d, reason: collision with other field name */
    public String f6280d;

    /* renamed from: e, reason: collision with other field name */
    public String f6281e;

    /* renamed from: f, reason: collision with other field name */
    public String f6282f;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6274a = new ig("XmPushActionUnSubscription");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17893e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", com.umeng.analytics.pro.cb.m, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5653a() {
        return this.f6276a != null;
    }

    public boolean b() {
        return this.f6275a != null;
    }

    public boolean c() {
        return this.f6278b != null;
    }

    public boolean d() {
        return this.f6279c != null;
    }

    public boolean e() {
        return this.f6280d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m5654a((ho) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6281e != null;
    }

    public boolean g() {
        return this.f6282f != null;
    }

    public boolean h() {
        return this.f6277a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m5653a()) {
            sb.append("debug:");
            String str = this.f6276a;
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
            gv gvVar = this.f6275a;
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
        String str2 = this.f6278b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6279c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f6280d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6281e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f6282f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f6277a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public ho a(String str) {
        this.f6278b = str;
        return this;
    }

    public ho b(String str) {
        this.f6279c = str;
        return this;
    }

    public ho c(String str) {
        this.f6280d = str;
        return this;
    }

    public ho d(String str) {
        this.f6281e = str;
        return this;
    }

    public ho e(String str) {
        this.f6282f = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5654a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean zM5653a = m5653a();
        boolean zM5653a2 = hoVar.m5653a();
        if ((zM5653a || zM5653a2) && !(zM5653a && zM5653a2 && this.f6276a.equals(hoVar.f6276a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hoVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6275a.m5571a(hoVar.f6275a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hoVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6278b.equals(hoVar.f6278b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hoVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6279c.equals(hoVar.f6279c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hoVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6280d.equals(hoVar.f6280d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hoVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6281e.equals(hoVar.f6281e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hoVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6282f.equals(hoVar.f6282f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hoVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f6277a.equals(hoVar.f6277a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f6274a);
        if (this.f6276a != null && m5653a()) {
            ibVar.a(a);
            ibVar.a(this.f6276a);
            ibVar.b();
        }
        if (this.f6275a != null && b()) {
            ibVar.a(b);
            this.f6275a.b(ibVar);
            ibVar.b();
        }
        if (this.f6278b != null) {
            ibVar.a(c);
            ibVar.a(this.f6278b);
            ibVar.b();
        }
        if (this.f6279c != null) {
            ibVar.a(d);
            ibVar.a(this.f6279c);
            ibVar.b();
        }
        if (this.f6280d != null) {
            ibVar.a(f17893e);
            ibVar.a(this.f6280d);
            ibVar.b();
        }
        if (this.f6281e != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6281e);
            ibVar.b();
        }
        if (this.f6282f != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6282f);
            ibVar.b();
        }
        if (this.f6277a != null && h()) {
            ibVar.a(h);
            ibVar.a(new hz((byte) 11, this.f6277a.size()));
            Iterator<String> it = this.f6277a.iterator();
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
    public int compareTo(ho hoVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(hoVar.getClass())) {
            return getClass().getName().compareTo(hoVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5653a()).compareTo(Boolean.valueOf(hoVar.m5653a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5653a() && (iA8 = hs.a(this.f6276a, hoVar.f6276a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hoVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hs.a(this.f6275a, hoVar.f6275a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hoVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hs.a(this.f6278b, hoVar.f6278b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hs.a(this.f6279c, hoVar.f6279c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hs.a(this.f6280d, hoVar.f6280d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hs.a(this.f6281e, hoVar.f6281e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hs.a(this.f6282f, hoVar.f6282f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hs.a(this.f6277a, hoVar.f6277a)) == 0) {
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
                        this.f6276a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6275a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6278b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6279c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6280d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6281e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6282f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 15) {
                        hz hzVarMo5668a = ibVar.mo5668a();
                        this.f6277a = new ArrayList(hzVarMo5668a.f6305a);
                        for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                            this.f6277a.add(ibVar.mo5672a());
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
        if (this.f6278b != null) {
            if (this.f6279c != null) {
                if (this.f6280d != null) {
                    return;
                }
                throw new ic("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
