package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hi implements hr<hi, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6207a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6208a;

    /* renamed from: a, reason: collision with other field name */
    public String f6209a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6210a = new BitSet(1);

    /* renamed from: b, reason: collision with other field name */
    public String f6211b;

    /* renamed from: c, reason: collision with other field name */
    public String f6212c;

    /* renamed from: d, reason: collision with other field name */
    public String f6213d;

    /* renamed from: e, reason: collision with other field name */
    public String f6214e;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6206a = new ig("XmPushActionSendFeedbackResult");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17887e = new hy("", (byte) 10, 6);
    private static final hy f = new hy("", (byte) 11, 7);
    private static final hy g = new hy("", (byte) 11, 8);

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5630a() {
        return this.f6209a != null;
    }

    public boolean b() {
        return this.f6208a != null;
    }

    public boolean c() {
        return this.f6211b != null;
    }

    public boolean d() {
        return this.f6212c != null;
    }

    public boolean e() {
        return this.f6210a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return m5631a((hi) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6213d != null;
    }

    public boolean g() {
        return this.f6214e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m5630a()) {
            sb.append("debug:");
            String str = this.f6209a;
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
            gv gvVar = this.f6208a;
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
        String str2 = this.f6211b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f6212c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f6207a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6213d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f6214e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f6210a.set(0, z);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f6206a);
        if (this.f6209a != null && m5630a()) {
            ibVar.a(a);
            ibVar.a(this.f6209a);
            ibVar.b();
        }
        if (this.f6208a != null && b()) {
            ibVar.a(b);
            this.f6208a.b(ibVar);
            ibVar.b();
        }
        if (this.f6211b != null) {
            ibVar.a(c);
            ibVar.a(this.f6211b);
            ibVar.b();
        }
        if (this.f6212c != null) {
            ibVar.a(d);
            ibVar.a(this.f6212c);
            ibVar.b();
        }
        ibVar.a(f17887e);
        ibVar.a(this.f6207a);
        ibVar.b();
        if (this.f6213d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6213d);
            ibVar.b();
        }
        if (this.f6214e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6214e);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5631a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean zM5630a = m5630a();
        boolean zM5630a2 = hiVar.m5630a();
        if ((zM5630a || zM5630a2) && !(zM5630a && zM5630a2 && this.f6209a.equals(hiVar.f6209a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hiVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6208a.m5571a(hiVar.f6208a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hiVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f6211b.equals(hiVar.f6211b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hiVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f6212c.equals(hiVar.f6212c))) || this.f6207a != hiVar.f6207a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hiVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6213d.equals(hiVar.f6213d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hiVar.g();
        if (zG || zG2) {
            return zG && zG2 && this.f6214e.equals(hiVar.f6214e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hi hiVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!getClass().equals(hiVar.getClass())) {
            return getClass().getName().compareTo(hiVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5630a()).compareTo(Boolean.valueOf(hiVar.m5630a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5630a() && (iA7 = hs.a(this.f6209a, hiVar.f6209a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hiVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA6 = hs.a(this.f6208a, hiVar.f6208a)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hiVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA5 = hs.a(this.f6211b, hiVar.f6211b)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hiVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = hs.a(this.f6212c, hiVar.f6212c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hiVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = hs.a(this.f6207a, hiVar.f6207a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hiVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = hs.a(this.f6213d, hiVar.f6213d)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!g() || (iA = hs.a(this.f6214e, hiVar.f6214e)) == 0) {
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
                    a();
                    return;
                }
                throw new ic("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6209a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6208a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6211b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6212c = ibVar.mo5672a();
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
                        this.f6207a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6213d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6214e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
            }
            ibVar.g();
        }
    }

    public void a() throws ic {
        if (this.f6211b != null) {
            if (this.f6212c != null) {
                return;
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
