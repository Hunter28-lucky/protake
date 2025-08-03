package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class gy implements hr<gy, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f6093a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6094a = new BitSet(2);

    /* renamed from: b, reason: collision with other field name */
    public int f6095b;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6092a = new ig("XmPushActionCheckClientInfo");
    private static final hy a = new hy("", (byte) 8, 1);
    private static final hy b = new hy("", (byte) 8, 2);

    public gy a(int i) {
        this.f6093a = i;
        a(true);
        return this;
    }

    public void a() {
    }

    public gy b(int i) {
        this.f6095b = i;
        b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gy)) {
            return m5580a((gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f6093a + ", pluginConfigVersion:" + this.f6095b + ")";
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5579a() {
        return this.f6094a.get(0);
    }

    public boolean b() {
        return this.f6094a.get(1);
    }

    public void a(boolean z) {
        this.f6094a.set(0, z);
    }

    public void b(boolean z) {
        this.f6094a.set(1, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5580a(gy gyVar) {
        return gyVar != null && this.f6093a == gyVar.f6093a && this.f6095b == gyVar.f6095b;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) {
        a();
        ibVar.a(f6092a);
        ibVar.a(a);
        ibVar.mo5676a(this.f6093a);
        ibVar.b();
        ibVar.a(b);
        ibVar.mo5676a(this.f6095b);
        ibVar.b();
        ibVar.c();
        ibVar.mo5675a();
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gy gyVar) {
        int iA;
        int iA2;
        if (!getClass().equals(gyVar.getClass())) {
            return getClass().getName().compareTo(gyVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5579a()).compareTo(Boolean.valueOf(gyVar.m5579a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5579a() && (iA2 = hs.a(this.f6093a, gyVar.f6093a)) != 0) {
            return iA2;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gyVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (!b() || (iA = hs.a(this.f6095b, gyVar.f6095b)) == 0) {
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
                    ie.a(ibVar, b2);
                } else if (b2 == 8) {
                    this.f6095b = ibVar.mo5665a();
                    b(true);
                } else {
                    ie.a(ibVar, b2);
                }
            } else if (b2 == 8) {
                this.f6093a = ibVar.mo5665a();
                a(true);
            } else {
                ie.a(ibVar, b2);
            }
            ibVar.g();
        }
        ibVar.f();
        if (m5579a()) {
            if (b()) {
                a();
                return;
            }
            throw new ic("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new ic("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
