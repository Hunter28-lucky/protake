package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gj implements hr<gj, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gk> f5972a;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f5971a = new ig("ClientUploadData");
    private static final hy a = new hy("", com.umeng.analytics.pro.cb.m, 1);

    public int a() {
        List<gk> list = this.f5972a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5524a();
        ibVar.a(f5971a);
        if (this.f5972a != null) {
            ibVar.a(a);
            ibVar.a(new hz((byte) 12, this.f5972a.size()));
            Iterator<gk> it = this.f5972a.iterator();
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
        if (obj != null && (obj instanceof gj)) {
            return m5526a((gj) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gk> list = this.f5972a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(gk gkVar) {
        if (this.f5972a == null) {
            this.f5972a = new ArrayList();
        }
        this.f5972a.add(gkVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5525a() {
        return this.f5972a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5526a(gj gjVar) {
        if (gjVar == null) {
            return false;
        }
        boolean zM5525a = m5525a();
        boolean zM5525a2 = gjVar.m5525a();
        if (zM5525a || zM5525a2) {
            return zM5525a && zM5525a2 && this.f5972a.equals(gjVar.f5972a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gj gjVar) {
        int iA;
        if (!getClass().equals(gjVar.getClass())) {
            return getClass().getName().compareTo(gjVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5525a()).compareTo(Boolean.valueOf(gjVar.m5525a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m5525a() || (iA = hs.a(this.f5972a, gjVar.f5972a)) == 0) {
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
                m5524a();
                return;
            }
            if (hyVarMo5667a.f6304a != 1) {
                ie.a(ibVar, b);
            } else if (b == 15) {
                hz hzVarMo5668a = ibVar.mo5668a();
                this.f5972a = new ArrayList(hzVarMo5668a.f6305a);
                for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                    gk gkVar = new gk();
                    gkVar.a(ibVar);
                    this.f5972a.add(gkVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b);
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5524a() throws ic {
        if (this.f5972a != null) {
            return;
        }
        throw new ic("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
