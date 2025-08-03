package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class gz implements hr<gz, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public List<go> f6097a;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6096a = new ig("XmPushActionCollectData");
    private static final hy a = new hy("", com.umeng.analytics.pro.cb.m, 1);

    public gz a(List<go> list) {
        this.f6097a = list;
        return this;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f6096a);
        if (this.f6097a != null) {
            ibVar.a(a);
            ibVar.a(new hz((byte) 12, this.f6097a.size()));
            Iterator<go> it = this.f6097a.iterator();
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
        if (obj != null && (obj instanceof gz)) {
            return m5582a((gz) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<go> list = this.f6097a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5581a() {
        return this.f6097a != null;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5582a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean zM5581a = m5581a();
        boolean zM5581a2 = gzVar.m5581a();
        if (zM5581a || zM5581a2) {
            return zM5581a && zM5581a2 && this.f6097a.equals(gzVar.f6097a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
        int iA;
        if (!getClass().equals(gzVar.getClass())) {
            return getClass().getName().compareTo(gzVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5581a()).compareTo(Boolean.valueOf(gzVar.m5581a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m5581a() || (iA = hs.a(this.f6097a, gzVar.f6097a)) == 0) {
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
                a();
                return;
            }
            if (hyVarMo5667a.f6304a != 1) {
                ie.a(ibVar, b);
            } else if (b == 15) {
                hz hzVarMo5668a = ibVar.mo5668a();
                this.f6097a = new ArrayList(hzVarMo5668a.f6305a);
                for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                    go goVar = new go();
                    goVar.a(ibVar);
                    this.f6097a.add(goVar);
                }
                ibVar.i();
            } else {
                ie.a(ibVar, b);
            }
            ibVar.g();
        }
    }

    public void a() throws ic {
        if (this.f6097a != null) {
            return;
        }
        throw new ic("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
