package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class el implements hr<el, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public String f5847a;

    /* renamed from: a, reason: collision with other field name */
    public List<ek> f5848a;

    /* renamed from: b, reason: collision with other field name */
    public String f5849b;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f5846a = new ig("StatsEvents");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 11, 2);
    private static final hy c = new hy("", com.umeng.analytics.pro.cb.m, 3);

    public el() {
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5442a() {
        return this.f5847a != null;
    }

    public boolean b() {
        return this.f5849b != null;
    }

    public boolean c() {
        return this.f5848a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof el)) {
            return m5443a((el) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f5847a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f5849b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ek> list = this.f5848a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public el(String str, List<ek> list) {
        this();
        this.f5847a = str;
        this.f5848a = list;
    }

    public el a(String str) {
        this.f5849b = str;
        return this;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        a();
        ibVar.a(f5846a);
        if (this.f5847a != null) {
            ibVar.a(a);
            ibVar.a(this.f5847a);
            ibVar.b();
        }
        if (this.f5849b != null && b()) {
            ibVar.a(b);
            ibVar.a(this.f5849b);
            ibVar.b();
        }
        if (this.f5848a != null) {
            ibVar.a(c);
            ibVar.a(new hz((byte) 12, this.f5848a.size()));
            Iterator<ek> it = this.f5848a.iterator();
            while (it.hasNext()) {
                it.next().b(ibVar);
            }
            ibVar.e();
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5443a(el elVar) {
        if (elVar == null) {
            return false;
        }
        boolean zM5442a = m5442a();
        boolean zM5442a2 = elVar.m5442a();
        if ((zM5442a || zM5442a2) && !(zM5442a && zM5442a2 && this.f5847a.equals(elVar.f5847a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = elVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f5849b.equals(elVar.f5849b))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = elVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f5848a.equals(elVar.f5848a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(el elVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(elVar.getClass())) {
            return getClass().getName().compareTo(elVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5442a()).compareTo(Boolean.valueOf(elVar.m5442a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5442a() && (iA3 = hs.a(this.f5847a, elVar.f5847a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(elVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hs.a(this.f5849b, elVar.f5849b)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(elVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hs.a(this.f5848a, elVar.f5848a)) == 0) {
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
            short s = hyVarMo5667a.f6304a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        ie.a(ibVar, b2);
                    } else if (b2 == 15) {
                        hz hzVarMo5668a = ibVar.mo5668a();
                        this.f5848a = new ArrayList(hzVarMo5668a.f6305a);
                        for (int i = 0; i < hzVarMo5668a.f6305a; i++) {
                            ek ekVar = new ek();
                            ekVar.a(ibVar);
                            this.f5848a.add(ekVar);
                        }
                        ibVar.i();
                    } else {
                        ie.a(ibVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f5849b = ibVar.mo5672a();
                } else {
                    ie.a(ibVar, b2);
                }
            } else if (b2 == 11) {
                this.f5847a = ibVar.mo5672a();
            } else {
                ie.a(ibVar, b2);
            }
            ibVar.g();
        }
    }

    public void a() throws ic {
        if (this.f5847a != null) {
            if (this.f5848a != null) {
                return;
            }
            throw new ic("Required field 'events' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'uuid' was not present! Struct: " + toString());
    }
}
