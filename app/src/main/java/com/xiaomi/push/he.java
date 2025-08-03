package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class he implements hr<he, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gp> f6135a;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6134a = new ig("XmPushActionNormalConfig");
    private static final hy a = new hy("", com.umeng.analytics.pro.cb.m, 1);

    public List<gp> a() {
        return this.f6135a;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5605a();
        ibVar.a(f6134a);
        if (this.f6135a != null) {
            ibVar.a(a);
            ibVar.a(new hz((byte) 12, this.f6135a.size()));
            Iterator<gp> it = this.f6135a.iterator();
            while (it.hasNext()) {
                it.next().b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof he)) {
            return m5607a((he) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<gp> list = this.f6135a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5606a() {
        return this.f6135a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5607a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean zM5606a = m5606a();
        boolean zM5606a2 = heVar.m5606a();
        if (zM5606a || zM5606a2) {
            return zM5606a && zM5606a2 && this.f6135a.equals(heVar.f6135a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(he heVar) {
        int iA;
        if (!getClass().equals(heVar.getClass())) {
            return getClass().getName().compareTo(heVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5606a()).compareTo(Boolean.valueOf(heVar.m5606a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m5606a() || (iA = hs.a(this.f6135a, heVar.f6135a)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hr
    public void a(ib ibVar) throws ic {
        ibVar.mo5671a();
        while (true) {
            hy hyVarMo5667a = ibVar.mo5667a();
            byte b = hyVarMo5667a.a;
            if (b == 0) {
                ibVar.f();
                m5605a();
                return;
            }
            if (hyVarMo5667a.f6304a != 1) {
                ie.a(ibVar, b);
            } else if (b == 15) {
                hz hzVarMo5668a = ibVar.mo5668a();
                this.f6135a = new ArrayList(hzVarMo5668a.f6305a);
                for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                    gp gpVar = new gp();
                    gpVar.a(ibVar);
                    this.f6135a.add(gpVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b);
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5605a() throws ic {
        if (this.f6135a != null) {
            return;
        }
        throw new ic("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
