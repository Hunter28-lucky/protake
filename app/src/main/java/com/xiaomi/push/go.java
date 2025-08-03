package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class go implements hr<go, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f5993a;

    /* renamed from: a, reason: collision with other field name */
    public gi f5994a;

    /* renamed from: a, reason: collision with other field name */
    public String f5995a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f5996a = new BitSet(1);

    /* renamed from: a, reason: collision with other field name */
    private static final ig f5992a = new ig("DataCollectionItem");
    private static final hy a = new hy("", (byte) 10, 1);
    private static final hy b = new hy("", (byte) 8, 2);
    private static final hy c = new hy("", (byte) 11, 3);

    public go a(long j) {
        this.f5993a = j;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f5994a != null;
    }

    public boolean c() {
        return this.f5995a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof go)) {
            return m5539a((go) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f5993a);
        sb.append(", ");
        sb.append("collectionType:");
        gi giVar = this.f5994a;
        if (giVar == null) {
            sb.append("null");
        } else {
            sb.append(giVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f5995a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5537a();
        ibVar.a(f5992a);
        ibVar.a(a);
        ibVar.a(this.f5993a);
        ibVar.b();
        if (this.f5994a != null) {
            ibVar.a(b);
            ibVar.mo5676a(this.f5994a.a());
            ibVar.b();
        }
        if (this.f5995a != null) {
            ibVar.a(c);
            ibVar.a(this.f5995a);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5538a() {
        return this.f5996a.get(0);
    }

    public void a(boolean z) {
        this.f5996a.set(0, z);
    }

    public go a(gi giVar) {
        this.f5994a = giVar;
        return this;
    }

    public String a() {
        return this.f5995a;
    }

    public go a(String str) {
        this.f5995a = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5539a(go goVar) {
        if (goVar == null || this.f5993a != goVar.f5993a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = goVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f5994a.equals(goVar.f5994a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = goVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f5995a.equals(goVar.f5995a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(go goVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(goVar.getClass())) {
            return getClass().getName().compareTo(goVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5538a()).compareTo(Boolean.valueOf(goVar.m5538a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5538a() && (iA3 = hs.a(this.f5993a, goVar.f5993a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(goVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hs.a(this.f5994a, goVar.f5994a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(goVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hs.a(this.f5995a, goVar.f5995a)) == 0) {
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
                    } else if (b2 == 11) {
                        this.f5995a = ibVar.mo5672a();
                    } else {
                        ie.a(ibVar, b2);
                    }
                } else if (b2 == 8) {
                    this.f5994a = gi.a(ibVar.mo5665a());
                } else {
                    ie.a(ibVar, b2);
                }
            } else if (b2 == 10) {
                this.f5993a = ibVar.mo5666a();
                a(true);
            } else {
                ie.a(ibVar, b2);
            }
            ibVar.g();
        }
        ibVar.f();
        if (m5538a()) {
            m5537a();
            return;
        }
        throw new ic("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5537a() throws ic {
        if (this.f5994a != null) {
            if (this.f5995a != null) {
                return;
            }
            throw new ic("Required field 'content' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'collectionType' was not present! Struct: " + toString());
    }
}
