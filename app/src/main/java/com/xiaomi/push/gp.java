package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gp implements hr<gp, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f5998a;

    /* renamed from: a, reason: collision with other field name */
    public gm f5999a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6000a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    public List<gr> f6001a;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f5997a = new ig("NormalConfig");
    private static final hy a = new hy("", (byte) 8, 1);
    private static final hy b = new hy("", com.umeng.analytics.pro.cb.m, 2);
    private static final hy c = new hy("", (byte) 8, 3);

    public int a() {
        return this.f5998a;
    }

    public boolean b() {
        return this.f6001a != null;
    }

    public boolean c() {
        return this.f5999a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gp)) {
            return m5543a((gp) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f5998a);
        sb.append(", ");
        sb.append("configItems:");
        List<gr> list = this.f6001a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            gm gmVar = this.f5999a;
            if (gmVar == null) {
                sb.append("null");
            } else {
                sb.append(gmVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5542a() {
        return this.f6000a.get(0);
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5541a();
        ibVar.a(f5997a);
        ibVar.a(a);
        ibVar.mo5676a(this.f5998a);
        ibVar.b();
        if (this.f6001a != null) {
            ibVar.a(b);
            ibVar.a(new hz((byte) 12, this.f6001a.size()));
            Iterator<gr> it = this.f6001a.iterator();
            while (it.hasNext()) {
                it.next().b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        if (this.f5999a != null && c()) {
            ibVar.a(c);
            ibVar.mo5676a(this.f5999a.a());
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public void a(boolean z) {
        this.f6000a.set(0, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public gm m5540a() {
        return this.f5999a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5543a(gp gpVar) {
        if (gpVar == null || this.f5998a != gpVar.f5998a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gpVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f6001a.equals(gpVar.f6001a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gpVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f5999a.equals(gpVar.f5999a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gp gpVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(gpVar.getClass())) {
            return getClass().getName().compareTo(gpVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5542a()).compareTo(Boolean.valueOf(gpVar.m5542a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5542a() && (iA3 = hs.a(this.f5998a, gpVar.f5998a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gpVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hs.a(this.f6001a, gpVar.f6001a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gpVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hs.a(this.f5999a, gpVar.f5999a)) == 0) {
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
                break;
            }
            short s = hyVarMo5667a.f6304a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        ie.a(ibVar, b2);
                    } else if (b2 == 8) {
                        this.f5999a = gm.a(ibVar.mo5665a());
                    } else {
                        ie.a(ibVar, b2);
                    }
                } else if (b2 == 15) {
                    hz hzVarMo5668a = ibVar.mo5668a();
                    this.f6001a = new ArrayList(hzVarMo5668a.f6305a);
                    for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                        gr grVar = new gr();
                        grVar.a(ibVar);
                        this.f6001a.add(grVar);
                    }
                    ibVar.i();
                } else {
                    ie.a(ibVar, b2);
                }
            } else if (b2 == 8) {
                this.f5998a = ibVar.mo5665a();
                a(true);
            } else {
                ie.a(ibVar, b2);
            }
            ibVar.g();
        }
        ibVar.f();
        if (m5542a()) {
            m5541a();
            return;
        }
        throw new ic("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5541a() throws ic {
        if (this.f6001a != null) {
            return;
        }
        throw new ic("Required field 'configItems' was not present! Struct: " + toString());
    }
}
