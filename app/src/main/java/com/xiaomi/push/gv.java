package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gv implements hr<gv, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public String f6052a;

    /* renamed from: d, reason: collision with other field name */
    public String f6057d;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6050a = new ig("Target");
    private static final hy a = new hy("", (byte) 10, 1);
    private static final hy b = new hy("", (byte) 11, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17878e = new hy("", (byte) 2, 5);
    private static final hy f = new hy("", (byte) 11, 7);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6053a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public long f6051a = 5;

    /* renamed from: b, reason: collision with other field name */
    public String f6055b = "xiaomi.com";

    /* renamed from: c, reason: collision with other field name */
    public String f6056c = "";

    /* renamed from: a, reason: collision with other field name */
    public boolean f6054a = false;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5570a() {
        return this.f6053a.get(0);
    }

    public boolean b() {
        return this.f6052a != null;
    }

    public boolean c() {
        return this.f6055b != null;
    }

    public boolean d() {
        return this.f6056c != null;
    }

    public boolean e() {
        return this.f6053a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gv)) {
            return m5571a((gv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6057d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f6051a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f6052a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f6055b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f6056c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f6054a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f6057d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f6053a.set(0, z);
    }

    public void b(boolean z) {
        this.f6053a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5571a(gv gvVar) {
        if (gvVar == null || this.f6051a != gvVar.f6051a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gvVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6052a.equals(gvVar.f6052a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gvVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6055b.equals(gvVar.f6055b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gvVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f6056c.equals(gvVar.f6056c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gvVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6054a == gvVar.f6054a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gvVar.f();
        if (zF || zF2) {
            return zF && zF2 && this.f6057d.equals(gvVar.f6057d);
        }
        return true;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) {
        a();
        ibVar.a(f6050a);
        ibVar.a(a);
        ibVar.a(this.f6051a);
        ibVar.b();
        if (this.f6052a != null) {
            ibVar.a(b);
            ibVar.a(this.f6052a);
            ibVar.b();
        }
        if (this.f6055b != null && c()) {
            ibVar.a(c);
            ibVar.a(this.f6055b);
            ibVar.b();
        }
        if (this.f6056c != null && d()) {
            ibVar.a(d);
            ibVar.a(this.f6056c);
            ibVar.b();
        }
        if (e()) {
            ibVar.a(f17878e);
            ibVar.a(this.f6054a);
            ibVar.b();
        }
        if (this.f6057d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6057d);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gv gvVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        if (!getClass().equals(gvVar.getClass())) {
            return getClass().getName().compareTo(gvVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5570a()).compareTo(Boolean.valueOf(gvVar.m5570a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5570a() && (iA6 = hs.a(this.f6051a, gvVar.f6051a)) != 0) {
            return iA6;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gvVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA5 = hs.a(this.f6052a, gvVar.f6052a)) != 0) {
            return iA5;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA4 = hs.a(this.f6055b, gvVar.f6055b)) != 0) {
            return iA4;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA3 = hs.a(this.f6056c, gvVar.f6056c)) != 0) {
            return iA3;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA2 = hs.a(this.f6054a, gvVar.f6054a)) != 0) {
            return iA2;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (!f() || (iA = hs.a(this.f6057d, gvVar.f6057d)) == 0) {
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
                break;
            }
            short s = hyVarMo5667a.f6304a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s != 7) {
                                    ie.a(ibVar, b2);
                                } else if (b2 == 11) {
                                    this.f6057d = ibVar.mo5672a();
                                } else {
                                    ie.a(ibVar, b2);
                                }
                            } else if (b2 == 2) {
                                this.f6054a = ibVar.mo5677a();
                                b(true);
                            } else {
                                ie.a(ibVar, b2);
                            }
                        } else if (b2 == 11) {
                            this.f6056c = ibVar.mo5672a();
                        } else {
                            ie.a(ibVar, b2);
                        }
                    } else if (b2 == 11) {
                        this.f6055b = ibVar.mo5672a();
                    } else {
                        ie.a(ibVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f6052a = ibVar.mo5672a();
                } else {
                    ie.a(ibVar, b2);
                }
            } else if (b2 == 10) {
                this.f6051a = ibVar.mo5666a();
                a(true);
            } else {
                ie.a(ibVar, b2);
            }
            ibVar.g();
        }
        ibVar.f();
        if (m5570a()) {
            a();
            return;
        }
        throw new ic("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a() throws ic {
        if (this.f6052a != null) {
            return;
        }
        throw new ic("Required field 'userId' was not present! Struct: " + toString());
    }
}
