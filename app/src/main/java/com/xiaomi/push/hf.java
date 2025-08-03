package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class hf implements hr<hf, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public long f6137a;

    /* renamed from: a, reason: collision with other field name */
    public gv f6138a;

    /* renamed from: a, reason: collision with other field name */
    public String f6139a;

    /* renamed from: a, reason: collision with other field name */
    public ByteBuffer f6140a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6141a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f6142a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f6143a;

    /* renamed from: b, reason: collision with other field name */
    public String f6144b;

    /* renamed from: b, reason: collision with other field name */
    public boolean f6145b;

    /* renamed from: c, reason: collision with other field name */
    public String f6146c;

    /* renamed from: d, reason: collision with other field name */
    public String f6147d;

    /* renamed from: e, reason: collision with other field name */
    public String f6148e;

    /* renamed from: f, reason: collision with other field name */
    public String f6149f;

    /* renamed from: g, reason: collision with other field name */
    public String f6150g;

    /* renamed from: h, reason: collision with other field name */
    public String f6151h;

    /* renamed from: i, reason: collision with other field name */
    public String f6152i;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6136a = new ig("XmPushActionNotification");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 12, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17884e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 2, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", com.umeng.analytics.pro.cb.k, 8);
    private static final hy i = new hy("", (byte) 11, 9);
    private static final hy j = new hy("", (byte) 11, 10);
    private static final hy k = new hy("", (byte) 11, 12);
    private static final hy l = new hy("", (byte) 11, 13);
    private static final hy m = new hy("", (byte) 11, 14);
    private static final hy n = new hy("", (byte) 10, 15);
    private static final hy o = new hy("", (byte) 2, 20);

    public hf() {
        this.f6141a = new BitSet(3);
        this.f6143a = true;
        this.f6145b = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5612a() {
        return this.f6139a != null;
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5615b() {
        return this.f6138a != null;
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5616c() {
        return this.f6144b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m5617d() {
        return this.f6146c != null;
    }

    public boolean e() {
        return this.f6147d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return m5613a((hf) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6141a.get(0);
    }

    public boolean g() {
        return this.f6148e != null;
    }

    public boolean h() {
        return this.f6142a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6149f != null;
    }

    public boolean j() {
        return this.f6150g != null;
    }

    public boolean k() {
        return this.f6151h != null;
    }

    public boolean l() {
        return this.f6152i != null;
    }

    public boolean m() {
        return this.f6140a != null;
    }

    public boolean n() {
        return this.f6141a.get(1);
    }

    public boolean o() {
        return this.f6141a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m5612a()) {
            sb.append("debug:");
            String str = this.f6139a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m5615b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gv gvVar = this.f6138a;
            if (gvVar == null) {
                sb.append("null");
            } else {
                sb.append(gvVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f6144b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (m5617d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f6146c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f6147d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f6143a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f6148e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f6142a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f6149f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f6150g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f6151h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f6152i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f6140a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                hs.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f6137a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f6145b);
        }
        sb.append(")");
        return sb.toString();
    }

    public gv a() {
        return this.f6138a;
    }

    public String b() {
        return this.f6146c;
    }

    public String c() {
        return this.f6147d;
    }

    public String d() {
        return this.f6149f;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5608a() {
        return this.f6144b;
    }

    public hf b(String str) {
        this.f6146c = str;
        return this;
    }

    public hf c(String str) {
        this.f6147d = str;
        return this;
    }

    public hf d(String str) {
        this.f6149f = str;
        return this;
    }

    public hf a(String str) {
        this.f6144b = str;
        return this;
    }

    public void b(boolean z) {
        this.f6141a.set(1, z);
    }

    public void c(boolean z) {
        this.f6141a.set(2, z);
    }

    public hf(String str, boolean z) {
        this();
        this.f6144b = str;
        this.f6143a = z;
        m5611a(true);
    }

    public hf a(boolean z) {
        this.f6143a = z;
        m5611a(true);
        return this;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5610a();
        ibVar.a(f6136a);
        if (this.f6139a != null && m5612a()) {
            ibVar.a(a);
            ibVar.a(this.f6139a);
            ibVar.b();
        }
        if (this.f6138a != null && m5615b()) {
            ibVar.a(b);
            this.f6138a.b(ibVar);
            ibVar.b();
        }
        if (this.f6144b != null) {
            ibVar.a(c);
            ibVar.a(this.f6144b);
            ibVar.b();
        }
        if (this.f6146c != null && m5617d()) {
            ibVar.a(d);
            ibVar.a(this.f6146c);
            ibVar.b();
        }
        if (this.f6147d != null && e()) {
            ibVar.a(f17884e);
            ibVar.a(this.f6147d);
            ibVar.b();
        }
        ibVar.a(f);
        ibVar.a(this.f6143a);
        ibVar.b();
        if (this.f6148e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6148e);
            ibVar.b();
        }
        if (this.f6142a != null && h()) {
            ibVar.a(h);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6142a.size()));
            for (Map.Entry<String, String> entry : this.f6142a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f6149f != null && i()) {
            ibVar.a(i);
            ibVar.a(this.f6149f);
            ibVar.b();
        }
        if (this.f6150g != null && j()) {
            ibVar.a(j);
            ibVar.a(this.f6150g);
            ibVar.b();
        }
        if (this.f6151h != null && k()) {
            ibVar.a(k);
            ibVar.a(this.f6151h);
            ibVar.b();
        }
        if (this.f6152i != null && l()) {
            ibVar.a(l);
            ibVar.a(this.f6152i);
            ibVar.b();
        }
        if (this.f6140a != null && m()) {
            ibVar.a(m);
            ibVar.a(this.f6140a);
            ibVar.b();
        }
        if (n()) {
            ibVar.a(n);
            ibVar.a(this.f6137a);
            ibVar.b();
        }
        if (o()) {
            ibVar.a(o);
            ibVar.a(this.f6145b);
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5611a(boolean z) {
        this.f6141a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f6142a == null) {
            this.f6142a = new HashMap();
        }
        this.f6142a.put(str, str2);
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m5609a() {
        return this.f6142a;
    }

    public hf a(Map<String, String> map) {
        this.f6142a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m5614a() {
        a(hs.a(this.f6140a));
        return this.f6140a.array();
    }

    public hf a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public hf a(ByteBuffer byteBuffer) {
        this.f6140a = byteBuffer;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5613a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean zM5612a = m5612a();
        boolean zM5612a2 = hfVar.m5612a();
        if ((zM5612a || zM5612a2) && !(zM5612a && zM5612a2 && this.f6139a.equals(hfVar.f6139a))) {
            return false;
        }
        boolean zM5615b = m5615b();
        boolean zM5615b2 = hfVar.m5615b();
        if ((zM5615b || zM5615b2) && !(zM5615b && zM5615b2 && this.f6138a.m5571a(hfVar.f6138a))) {
            return false;
        }
        boolean zM5616c = m5616c();
        boolean zM5616c2 = hfVar.m5616c();
        if ((zM5616c || zM5616c2) && !(zM5616c && zM5616c2 && this.f6144b.equals(hfVar.f6144b))) {
            return false;
        }
        boolean zM5617d = m5617d();
        boolean zM5617d2 = hfVar.m5617d();
        if ((zM5617d || zM5617d2) && !(zM5617d && zM5617d2 && this.f6146c.equals(hfVar.f6146c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hfVar.e();
        if (((zE || zE2) && !(zE && zE2 && this.f6147d.equals(hfVar.f6147d))) || this.f6143a != hfVar.f6143a) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hfVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6148e.equals(hfVar.f6148e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hfVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6142a.equals(hfVar.f6142a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hfVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6149f.equals(hfVar.f6149f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hfVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6150g.equals(hfVar.f6150g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hfVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6151h.equals(hfVar.f6151h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hfVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f6152i.equals(hfVar.f6152i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hfVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f6140a.equals(hfVar.f6140a))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hfVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f6137a == hfVar.f6137a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hfVar.o();
        if (zO || zO2) {
            return zO && zO2 && this.f6145b == hfVar.f6145b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hf hfVar) {
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
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        int iA15;
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5612a()).compareTo(Boolean.valueOf(hfVar.m5612a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5612a() && (iA15 = hs.a(this.f6139a, hfVar.f6139a)) != 0) {
            return iA15;
        }
        int iCompareTo2 = Boolean.valueOf(m5615b()).compareTo(Boolean.valueOf(hfVar.m5615b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5615b() && (iA14 = hs.a(this.f6138a, hfVar.f6138a)) != 0) {
            return iA14;
        }
        int iCompareTo3 = Boolean.valueOf(m5616c()).compareTo(Boolean.valueOf(hfVar.m5616c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5616c() && (iA13 = hs.a(this.f6144b, hfVar.f6144b)) != 0) {
            return iA13;
        }
        int iCompareTo4 = Boolean.valueOf(m5617d()).compareTo(Boolean.valueOf(hfVar.m5617d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m5617d() && (iA12 = hs.a(this.f6146c, hfVar.f6146c)) != 0) {
            return iA12;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA11 = hs.a(this.f6147d, hfVar.f6147d)) != 0) {
            return iA11;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA10 = hs.a(this.f6143a, hfVar.f6143a)) != 0) {
            return iA10;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA9 = hs.a(this.f6148e, hfVar.f6148e)) != 0) {
            return iA9;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA8 = hs.a(this.f6142a, hfVar.f6142a)) != 0) {
            return iA8;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA7 = hs.a(this.f6149f, hfVar.f6149f)) != 0) {
            return iA7;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA6 = hs.a(this.f6150g, hfVar.f6150g)) != 0) {
            return iA6;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA5 = hs.a(this.f6151h, hfVar.f6151h)) != 0) {
            return iA5;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA4 = hs.a(this.f6152i, hfVar.f6152i)) != 0) {
            return iA4;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA3 = hs.a(this.f6140a, hfVar.f6140a)) != 0) {
            return iA3;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA2 = hs.a(this.f6137a, hfVar.f6137a)) != 0) {
            return iA2;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (!o() || (iA = hs.a(this.f6145b, hfVar.f6145b)) == 0) {
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
                if (f()) {
                    m5610a();
                    return;
                }
                throw new ic("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6139a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 12) {
                        gv gvVar = new gv();
                        this.f6138a = gvVar;
                        gvVar.a(ibVar);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6144b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6146c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6147d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 2) {
                        this.f6143a = ibVar.mo5677a();
                        m5611a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6148e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 13) {
                        ia iaVarMo5669a = ibVar.mo5669a();
                        this.f6142a = new HashMap(iaVarMo5669a.f6308a * 2);
                        for (int i2 = 0; i2 < iaVarMo5669a.f6308a; i2++) {
                            this.f6142a.put(ibVar.mo5672a(), ibVar.mo5672a());
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 11) {
                        this.f6149f = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 11) {
                        this.f6150g = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    ie.a(ibVar, b2);
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f6151h = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 11) {
                        this.f6152i = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 14:
                    if (b2 == 11) {
                        this.f6140a = ibVar.mo5673a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 15:
                    if (b2 == 10) {
                        this.f6137a = ibVar.mo5666a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 20:
                    if (b2 == 2) {
                        this.f6145b = ibVar.mo5677a();
                        c(true);
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
    public void m5610a() throws ic {
        if (this.f6144b != null) {
            return;
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
