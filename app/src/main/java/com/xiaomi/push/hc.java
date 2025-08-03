package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class hc implements hr<hc, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public gg f6123a;

    /* renamed from: a, reason: collision with other field name */
    public gt f6124a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6125a;

    /* renamed from: a, reason: collision with other field name */
    public String f6126a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f6127a;

    /* renamed from: b, reason: collision with other field name */
    public String f6130b;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6122a = new ig("XmPushActionContainer");
    private static final hy a = new hy("", (byte) 8, 1);
    private static final hy b = new hy("", (byte) 2, 2);
    private static final hy c = new hy("", (byte) 2, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17883e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 11, 6);
    private static final hy g = new hy("", (byte) 12, 7);
    private static final hy h = new hy("", (byte) 12, 8);

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6128a = new BitSet(2);

    /* renamed from: a, reason: collision with other field name */
    public boolean f6129a = true;

    /* renamed from: b, reason: collision with other field name */
    public boolean f6131b = true;

    public gg a() {
        return this.f6123a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5601b() {
        return this.f6129a;
    }

    public boolean c() {
        return this.f6128a.get(0);
    }

    public boolean d() {
        return this.f6128a.get(1);
    }

    public boolean e() {
        return this.f6127a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return m5598a((hc) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6126a != null;
    }

    public boolean g() {
        return this.f6130b != null;
    }

    public boolean h() {
        return this.f6125a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6124a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        gg ggVar = this.f6123a;
        if (ggVar == null) {
            sb.append("null");
        } else {
            sb.append(ggVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f6129a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f6131b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f6126a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f6130b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        gv gvVar = this.f6125a;
        if (gvVar == null) {
            sb.append("null");
        } else {
            sb.append(gvVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gt gtVar = this.f6124a;
            if (gtVar == null) {
                sb.append("null");
            } else {
                sb.append(gtVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hc a(gg ggVar) {
        this.f6123a = ggVar;
        return this;
    }

    public hc b(boolean z) {
        this.f6131b = z;
        m5600b(true);
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5597a() {
        return this.f6123a != null;
    }

    public hc a(boolean z) {
        this.f6129a = z;
        m5596a(true);
        return this;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5600b(boolean z) {
        this.f6128a.set(1, z);
    }

    public String b() {
        return this.f6130b;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5596a(boolean z) {
        this.f6128a.set(0, z);
    }

    public hc b(String str) {
        this.f6130b = str;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m5599a() {
        a(hs.a(this.f6127a));
        return this.f6127a.array();
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5595a();
        ibVar.a(f6122a);
        if (this.f6123a != null) {
            ibVar.a(a);
            ibVar.mo5676a(this.f6123a.a());
            ibVar.b();
        }
        ibVar.a(b);
        ibVar.a(this.f6129a);
        ibVar.b();
        ibVar.a(c);
        ibVar.a(this.f6131b);
        ibVar.b();
        if (this.f6127a != null) {
            ibVar.a(d);
            ibVar.a(this.f6127a);
            ibVar.b();
        }
        if (this.f6126a != null && f()) {
            ibVar.a(f17883e);
            ibVar.a(this.f6126a);
            ibVar.b();
        }
        if (this.f6130b != null && g()) {
            ibVar.a(f);
            ibVar.a(this.f6130b);
            ibVar.b();
        }
        if (this.f6125a != null) {
            ibVar.a(g);
            this.f6125a.b(ibVar);
            ibVar.b();
        }
        if (this.f6124a != null && i()) {
            ibVar.a(h);
            this.f6124a.b(ibVar);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    public hc a(ByteBuffer byteBuffer) {
        this.f6127a = byteBuffer;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5594a() {
        return this.f6126a;
    }

    public hc a(String str) {
        this.f6126a = str;
        return this;
    }

    public hc a(gv gvVar) {
        this.f6125a = gvVar;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gt m5593a() {
        return this.f6124a;
    }

    public hc a(gt gtVar) {
        this.f6124a = gtVar;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5598a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean zM5597a = m5597a();
        boolean zM5597a2 = hcVar.m5597a();
        if (((zM5597a || zM5597a2) && (!zM5597a || !zM5597a2 || !this.f6123a.equals(hcVar.f6123a))) || this.f6129a != hcVar.f6129a || this.f6131b != hcVar.f6131b) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hcVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6127a.equals(hcVar.f6127a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hcVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6126a.equals(hcVar.f6126a))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hcVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6130b.equals(hcVar.f6130b))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hcVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6125a.m5571a(hcVar.f6125a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hcVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f6124a.m5563a(hcVar.f6124a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(hcVar.getClass())) {
            return getClass().getName().compareTo(hcVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5597a()).compareTo(Boolean.valueOf(hcVar.m5597a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5597a() && (iA8 = hs.a(this.f6123a, hcVar.f6123a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hcVar.c()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (c() && (iA7 = hs.a(this.f6129a, hcVar.f6129a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hcVar.d()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (d() && (iA6 = hs.a(this.f6131b, hcVar.f6131b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hcVar.e()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (e() && (iA5 = hs.a(this.f6127a, hcVar.f6127a)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hcVar.f()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (f() && (iA4 = hs.a(this.f6126a, hcVar.f6126a)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hcVar.g()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (g() && (iA3 = hs.a(this.f6130b, hcVar.f6130b)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hcVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (h() && (iA2 = hs.a(this.f6125a, hcVar.f6125a)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hcVar.i()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!i() || (iA = hs.a(this.f6124a, hcVar.f6124a)) == 0) {
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
                if (c()) {
                    if (d()) {
                        m5595a();
                        return;
                    }
                    throw new ic("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new ic("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 8) {
                        this.f6123a = gg.a(ibVar.mo5665a());
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 2) {
                        this.f6129a = ibVar.mo5677a();
                        m5596a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 2) {
                        this.f6131b = ibVar.mo5677a();
                        m5600b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6127a = ibVar.mo5673a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6126a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 11) {
                        this.f6130b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6125a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 12) {
                        gt gtVar = new gt();
                        this.f6124a = gtVar;
                        gtVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                default:
                    ie.a(ibVar, b2);
                    break;
            }
            ibVar.g();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5595a() throws ic {
        if (this.f6123a != null) {
            if (this.f6127a != null) {
                if (this.f6125a != null) {
                    return;
                }
                throw new ic("Required field 'target' was not present! Struct: " + toString());
            }
            throw new ic("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new ic("Required field 'action' was not present! Struct: " + toString());
    }
}
