package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class hd implements hr<hd, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<gr> f6133a;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6132a = new ig("XmPushActionCustomConfig");
    private static final hy a = new hy("", com.umeng.analytics.pro.cb.m, 1);

    public List<gr> a() {
        return this.f6133a;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5602a();
        ibVar.a(f6132a);
        if (this.f6133a != null) {
            ibVar.a(a);
            ibVar.a(new hz((byte) 12, this.f6133a.size()));
            Iterator<gr> it = this.f6133a.iterator();
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
        if (obj != null && (obj instanceof hd)) {
            return m5604a((hd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<gr> list = this.f6133a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5603a() {
        return this.f6133a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5604a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean zM5603a = m5603a();
        boolean zM5603a2 = hdVar.m5603a();
        if (zM5603a || zM5603a2) {
            return zM5603a && zM5603a2 && this.f6133a.equals(hdVar.f6133a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hd hdVar) {
        int iA;
        if (!getClass().equals(hdVar.getClass())) {
            return getClass().getName().compareTo(hdVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5603a()).compareTo(Boolean.valueOf(hdVar.m5603a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m5603a() || (iA = hs.a(this.f6133a, hdVar.f6133a)) == 0) {
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
                m5602a();
                return;
            }
            if (hyVarMo5667a.f6304a != 1) {
                ie.a(ibVar, b);
            } else if (b == 15) {
                hz hzVarMo5668a = ibVar.mo5668a();
                this.f6133a = new ArrayList(hzVarMo5668a.f6305a);
                for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                    gr grVar = new gr();
                    grVar.a(ibVar);
                    this.f6133a.add(grVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b);
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5602a() throws ic {
        if (this.f6133a != null) {
            return;
        }
        throw new ic("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
