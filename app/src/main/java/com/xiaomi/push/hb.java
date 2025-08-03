package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hb implements hr<hb, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6111a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6112a;

    /* renamed from: a, reason: collision with other field name */
    public String f6113a;

    /* renamed from: a, reason: collision with other field name */
    public List<String> f6115a;

    /* renamed from: b, reason: collision with other field name */
    public String f6117b;

    /* renamed from: c, reason: collision with other field name */
    public String f6118c;

    /* renamed from: d, reason: collision with other field name */
    public String f6119d;

    /* renamed from: e, reason: collision with other field name */
    public String f6120e;

    /* renamed from: f, reason: collision with other field name */
    public String f6121f;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6110a = new ig("XmPushActionCommandResult");
    private static final hy a = new hy("", (byte) 12, 2);
    private static final hy b = new hy("", (byte) 11, 3);
    private static final hy c = new hy("", (byte) 11, 4);
    private static final hy d = new hy("", (byte) 11, 5);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17882e = new hy("", (byte) 10, 7);
    private static final hy f = new hy("", (byte) 11, 8);
    private static final hy g = new hy("", (byte) 11, 9);
    private static final hy h = new hy("", com.umeng.analytics.pro.cb.m, 10);
    private static final hy i = new hy("", (byte) 11, 12);
    private static final hy j = new hy("", (byte) 2, 13);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6114a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6116a = true;

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5589a() {
        return this.f6112a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5591b() {
        return this.f6113a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5592c() {
        return this.f6117b != null;
    }

    public boolean d() {
        return this.f6118c != null;
    }

    public boolean e() {
        return this.f6114a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return m5590a((hb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6119d != null;
    }

    public boolean g() {
        return this.f6120e != null;
    }

    public boolean h() {
        return this.f6115a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6121f != null;
    }

    public boolean j() {
        return this.f6114a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m5589a()) {
            sb.append("target:");
            gv gvVar = this.f6112a;
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
        String str = this.f6113a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f6117b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f6118c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f6111a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f6119d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f6120e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f6115a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f6121f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f6116a);
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f6113a;
    }

    public String b() {
        return this.f6118c;
    }

    public String c() {
        return this.f6121f;
    }

    public void a(boolean z) {
        this.f6114a.set(0, z);
    }

    public void b(boolean z) {
        this.f6114a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public List<String> m5587a() {
        return this.f6115a;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5588a();
        ibVar.a(f6110a);
        if (this.f6112a != null && m5589a()) {
            ibVar.a(a);
            this.f6112a.b(ibVar);
            ibVar.b();
        }
        if (this.f6113a != null) {
            ibVar.a(b);
            ibVar.a(this.f6113a);
            ibVar.b();
        }
        if (this.f6117b != null) {
            ibVar.a(c);
            ibVar.a(this.f6117b);
            ibVar.b();
        }
        if (this.f6118c != null) {
            ibVar.a(d);
            ibVar.a(this.f6118c);
            ibVar.b();
        }
        ibVar.a(f17882e);
        ibVar.a(this.f6111a);
        ibVar.b();
        if (this.f6119d != null && f()) {
            ibVar.a(f);
            ibVar.a(this.f6119d);
            ibVar.b();
        }
        if (this.f6120e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6120e);
            ibVar.b();
        }
        if (this.f6115a != null && h()) {
            ibVar.a(h);
            ibVar.a(new hz((byte) 11, this.f6115a.size()));
            Iterator<String> it = this.f6115a.iterator();
            while (it.hasNext()) {
                ibVar.a(it.next());
            }
            ibVar.e();
            ibVar.b();
        }
        if (this.f6121f != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6121f);
            ibVar.b();
        }
        if (j()) {
            ibVar.a(j);
            ibVar.a(this.f6116a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5590a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean zM5589a = m5589a();
        boolean zM5589a2 = hbVar.m5589a();
        if ((zM5589a || zM5589a2) && !(zM5589a && zM5589a2 && this.f6112a.m5571a(hbVar.f6112a))) {
            return false;
        }
        boolean zM5591b = m5591b();
        boolean zM5591b2 = hbVar.m5591b();
        if ((zM5591b || zM5591b2) && !(zM5591b && zM5591b2 && this.f6113a.equals(hbVar.f6113a))) {
            return false;
        }
        boolean zM5592c = m5592c();
        boolean zM5592c2 = hbVar.m5592c();
        if ((zM5592c || zM5592c2) && !(zM5592c && zM5592c2 && this.f6117b.equals(hbVar.f6117b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hbVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f6118c.equals(hbVar.f6118c))) || this.f6111a != hbVar.f6111a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hbVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6119d.equals(hbVar.f6119d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hbVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6120e.equals(hbVar.f6120e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hbVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6115a.equals(hbVar.f6115a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hbVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6121f.equals(hbVar.f6121f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hbVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f6116a == hbVar.f6116a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hb hbVar) {
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
        if (!getClass().equals(hbVar.getClass())) {
            return getClass().getName().compareTo(hbVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5589a()).compareTo(Boolean.valueOf(hbVar.m5589a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5589a() && (iA10 = hs.a(this.f6112a, hbVar.f6112a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m5591b()).compareTo(Boolean.valueOf(hbVar.m5591b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5591b() && (iA9 = hs.a(this.f6113a, hbVar.f6113a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(m5592c()).compareTo(Boolean.valueOf(hbVar.m5592c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5592c() && (iA8 = hs.a(this.f6117b, hbVar.f6117b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hs.a(this.f6118c, hbVar.f6118c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hs.a(this.f6111a, hbVar.f6111a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hbVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hs.a(this.f6119d, hbVar.f6119d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hs.a(this.f6120e, hbVar.f6120e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hbVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hs.a(this.f6115a, hbVar.f6115a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hs.a(this.f6121f, hbVar.f6121f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hbVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hs.a(this.f6116a, hbVar.f6116a)) == 0) {
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
                    m5588a();
                    return;
                }
                throw new ic("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6112a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6113a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6117b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6118c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                case 11:
                default:
                    ie.a(ibVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f6111a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 11) {
                        this.f6119d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6120e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 15) {
                        hz hzVarMo5668a = ibVar.mo5668a();
                        this.f6115a = new ArrayList(hzVarMo5668a.f6305a);
                        for (int i2 = 0; i2 < hzVarMo5668a.f6305a; i2++) {
                            this.f6115a.add(ibVar.mo5672a());
                        }
                        ibVar.i();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 11) {
                        this.f6121f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 2) {
                        this.f6116a = ibVar.mo5677a();
                        b(true);
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
    public void m5588a() throws ic {
        if (this.f6113a != null) {
            if (this.f6117b != null) {
                if (this.f6118c != null) {
                    return;
                }
                throw new ic("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
