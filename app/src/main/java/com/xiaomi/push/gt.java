package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class gt implements hr<gt, Object>, Serializable, Cloneable {

    /* renamed from: a, reason: collision with other field name */
    public int f6034a;

    /* renamed from: a, reason: collision with other field name */
    public long f6035a;

    /* renamed from: a, reason: collision with other field name */
    public String f6036a;

    /* renamed from: a, reason: collision with other field name */
    private BitSet f6037a;

    /* renamed from: a, reason: collision with other field name */
    public Map<String, String> f6038a;

    /* renamed from: a, reason: collision with other field name */
    public boolean f6039a;

    /* renamed from: b, reason: collision with other field name */
    public int f6040b;

    /* renamed from: b, reason: collision with other field name */
    public String f6041b;

    /* renamed from: b, reason: collision with other field name */
    public Map<String, String> f6042b;

    /* renamed from: c, reason: collision with other field name */
    public int f6043c;

    /* renamed from: c, reason: collision with other field name */
    public String f6044c;

    /* renamed from: c, reason: collision with other field name */
    public Map<String, String> f6045c;

    /* renamed from: d, reason: collision with other field name */
    public String f6046d;

    /* renamed from: e, reason: collision with other field name */
    public String f6047e;

    /* renamed from: a, reason: collision with other field name */
    private static final ig f6033a = new ig("PushMetaInfo");
    private static final hy a = new hy("", (byte) 11, 1);
    private static final hy b = new hy("", (byte) 10, 2);
    private static final hy c = new hy("", (byte) 11, 3);
    private static final hy d = new hy("", (byte) 11, 4);

    /* renamed from: e, reason: collision with root package name */
    private static final hy f17877e = new hy("", (byte) 11, 5);
    private static final hy f = new hy("", (byte) 8, 6);
    private static final hy g = new hy("", (byte) 11, 7);
    private static final hy h = new hy("", (byte) 8, 8);
    private static final hy i = new hy("", (byte) 8, 9);
    private static final hy j = new hy("", com.umeng.analytics.pro.cb.k, 10);
    private static final hy k = new hy("", com.umeng.analytics.pro.cb.k, 11);
    private static final hy l = new hy("", (byte) 2, 12);
    private static final hy m = new hy("", com.umeng.analytics.pro.cb.k, 13);

    public gt() {
        this.f6037a = new BitSet(5);
        this.f6039a = false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public gt m5558a() {
        return new gt(this);
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m5566b() {
        return this.f6037a.get(0);
    }

    /* renamed from: c, reason: collision with other method in class */
    public boolean m5568c() {
        return this.f6041b != null;
    }

    /* renamed from: d, reason: collision with other method in class */
    public boolean m5569d() {
        return this.f6044c != null;
    }

    public boolean e() {
        return this.f6046d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gt)) {
            return m5563a((gt) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f6037a.get(1);
    }

    public boolean g() {
        return this.f6047e != null;
    }

    public boolean h() {
        return this.f6037a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f6037a.get(3);
    }

    public boolean j() {
        return this.f6038a != null;
    }

    public boolean k() {
        return this.f6042b != null;
    }

    public boolean l() {
        return this.f6039a;
    }

    public boolean m() {
        return this.f6037a.get(4);
    }

    public boolean n() {
        return this.f6045c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f6036a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f6035a);
        if (m5568c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f6041b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m5569d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f6044c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f6046d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f6034a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f6047e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f6040b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f6043c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f6038a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f6042b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f6039a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f6045c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5559a() {
        return this.f6036a;
    }

    /* renamed from: b, reason: collision with other method in class */
    public String m5564b() {
        return this.f6041b;
    }

    /* renamed from: c, reason: collision with other method in class */
    public String m5567c() {
        return this.f6044c;
    }

    public String d() {
        return this.f6046d;
    }

    public void e(boolean z) {
        this.f6037a.set(4, z);
    }

    public gt a(String str) {
        this.f6036a = str;
        return this;
    }

    public gt b(String str) {
        this.f6041b = str;
        return this;
    }

    public gt c(String str) {
        this.f6044c = str;
        return this;
    }

    public gt d(String str) {
        this.f6046d = str;
        return this;
    }

    public gt(gt gtVar) {
        BitSet bitSet = new BitSet(5);
        this.f6037a = bitSet;
        bitSet.clear();
        this.f6037a.or(gtVar.f6037a);
        if (gtVar.m5562a()) {
            this.f6036a = gtVar.f6036a;
        }
        this.f6035a = gtVar.f6035a;
        if (gtVar.m5568c()) {
            this.f6041b = gtVar.f6041b;
        }
        if (gtVar.m5569d()) {
            this.f6044c = gtVar.f6044c;
        }
        if (gtVar.e()) {
            this.f6046d = gtVar.f6046d;
        }
        this.f6034a = gtVar.f6034a;
        if (gtVar.g()) {
            this.f6047e = gtVar.f6047e;
        }
        this.f6040b = gtVar.f6040b;
        this.f6043c = gtVar.f6043c;
        if (gtVar.j()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, String> entry : gtVar.f6038a.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            this.f6038a = map;
        }
        if (gtVar.k()) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, String> entry2 : gtVar.f6042b.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue());
            }
            this.f6042b = map2;
        }
        this.f6039a = gtVar.f6039a;
        if (gtVar.n()) {
            HashMap map3 = new HashMap();
            for (Map.Entry<String, String> entry3 : gtVar.f6045c.entrySet()) {
                map3.put(entry3.getKey(), entry3.getValue());
            }
            this.f6045c = map3;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5562a() {
        return this.f6036a != null;
    }

    public void b(boolean z) {
        this.f6037a.set(1, z);
    }

    public void c(boolean z) {
        this.f6037a.set(2, z);
    }

    public void d(boolean z) {
        this.f6037a.set(3, z);
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m5557a() {
        return this.f6035a;
    }

    public int b() {
        return this.f6040b;
    }

    public int c() {
        return this.f6043c;
    }

    public void a(boolean z) {
        this.f6037a.set(0, z);
    }

    public gt b(int i2) {
        this.f6040b = i2;
        c(true);
        return this;
    }

    public gt c(int i2) {
        this.f6043c = i2;
        d(true);
        return this;
    }

    public int a() {
        return this.f6034a;
    }

    public gt a(int i2) {
        this.f6034a = i2;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f6042b == null) {
            this.f6042b = new HashMap();
        }
        this.f6042b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f6038a == null) {
            this.f6038a = new HashMap();
        }
        this.f6038a.put(str, str2);
    }

    /* renamed from: b, reason: collision with other method in class */
    public Map<String, String> m5565b() {
        return this.f6042b;
    }

    @Override // com.xiaomi.push.hr
    public void b(ib ibVar) throws ic {
        m5561a();
        ibVar.a(f6033a);
        if (this.f6036a != null) {
            ibVar.a(a);
            ibVar.a(this.f6036a);
            ibVar.b();
        }
        ibVar.a(b);
        ibVar.a(this.f6035a);
        ibVar.b();
        if (this.f6041b != null && m5568c()) {
            ibVar.a(c);
            ibVar.a(this.f6041b);
            ibVar.b();
        }
        if (this.f6044c != null && m5569d()) {
            ibVar.a(d);
            ibVar.a(this.f6044c);
            ibVar.b();
        }
        if (this.f6046d != null && e()) {
            ibVar.a(f17877e);
            ibVar.a(this.f6046d);
            ibVar.b();
        }
        if (f()) {
            ibVar.a(f);
            ibVar.mo5676a(this.f6034a);
            ibVar.b();
        }
        if (this.f6047e != null && g()) {
            ibVar.a(g);
            ibVar.a(this.f6047e);
            ibVar.b();
        }
        if (h()) {
            ibVar.a(h);
            ibVar.mo5676a(this.f6040b);
            ibVar.b();
        }
        if (i()) {
            ibVar.a(i);
            ibVar.mo5676a(this.f6043c);
            ibVar.b();
        }
        if (this.f6038a != null && j()) {
            ibVar.a(j);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6038a.size()));
            for (Map.Entry<String, String> entry : this.f6038a.entrySet()) {
                ibVar.a(entry.getKey());
                ibVar.a(entry.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (this.f6042b != null && k()) {
            ibVar.a(k);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6042b.size()));
            for (Map.Entry<String, String> entry2 : this.f6042b.entrySet()) {
                ibVar.a(entry2.getKey());
                ibVar.a(entry2.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        if (m()) {
            ibVar.a(l);
            ibVar.a(this.f6039a);
            ibVar.b();
        }
        if (this.f6045c != null && n()) {
            ibVar.a(m);
            ibVar.a(new ia((byte) 11, (byte) 11, this.f6045c.size()));
            for (Map.Entry<String, String> entry3 : this.f6045c.entrySet()) {
                ibVar.a(entry3.getKey());
                ibVar.a(entry3.getValue());
            }
            ibVar.d();
            ibVar.b();
        }
        ibVar.c();
        ibVar.mo5675a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public Map<String, String> m5560a() {
        return this.f6038a;
    }

    public gt a(Map<String, String> map) {
        this.f6038a = map;
        return this;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5563a(gt gtVar) {
        if (gtVar == null) {
            return false;
        }
        boolean zM5562a = m5562a();
        boolean zM5562a2 = gtVar.m5562a();
        if (((zM5562a || zM5562a2) && !(zM5562a && zM5562a2 && this.f6036a.equals(gtVar.f6036a))) || this.f6035a != gtVar.f6035a) {
            return false;
        }
        boolean zM5568c = m5568c();
        boolean zM5568c2 = gtVar.m5568c();
        if ((zM5568c || zM5568c2) && !(zM5568c && zM5568c2 && this.f6041b.equals(gtVar.f6041b))) {
            return false;
        }
        boolean zM5569d = m5569d();
        boolean zM5569d2 = gtVar.m5569d();
        if ((zM5569d || zM5569d2) && !(zM5569d && zM5569d2 && this.f6044c.equals(gtVar.f6044c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gtVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f6046d.equals(gtVar.f6046d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gtVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f6034a == gtVar.f6034a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gtVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f6047e.equals(gtVar.f6047e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gtVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f6040b == gtVar.f6040b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gtVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f6043c == gtVar.f6043c)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gtVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f6038a.equals(gtVar.f6038a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gtVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f6042b.equals(gtVar.f6042b))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gtVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f6039a == gtVar.f6039a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gtVar.n();
        if (zN || zN2) {
            return zN && zN2 && this.f6045c.equals(gtVar.f6045c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gt gtVar) {
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
        if (!getClass().equals(gtVar.getClass())) {
            return getClass().getName().compareTo(gtVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m5562a()).compareTo(Boolean.valueOf(gtVar.m5562a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m5562a() && (iA13 = hs.a(this.f6036a, gtVar.f6036a)) != 0) {
            return iA13;
        }
        int iCompareTo2 = Boolean.valueOf(m5566b()).compareTo(Boolean.valueOf(gtVar.m5566b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m5566b() && (iA12 = hs.a(this.f6035a, gtVar.f6035a)) != 0) {
            return iA12;
        }
        int iCompareTo3 = Boolean.valueOf(m5568c()).compareTo(Boolean.valueOf(gtVar.m5568c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m5568c() && (iA11 = hs.a(this.f6041b, gtVar.f6041b)) != 0) {
            return iA11;
        }
        int iCompareTo4 = Boolean.valueOf(m5569d()).compareTo(Boolean.valueOf(gtVar.m5569d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m5569d() && (iA10 = hs.a(this.f6044c, gtVar.f6044c)) != 0) {
            return iA10;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gtVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA9 = hs.a(this.f6046d, gtVar.f6046d)) != 0) {
            return iA9;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gtVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA8 = hs.a(this.f6034a, gtVar.f6034a)) != 0) {
            return iA8;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gtVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA7 = hs.a(this.f6047e, gtVar.f6047e)) != 0) {
            return iA7;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gtVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA6 = hs.a(this.f6040b, gtVar.f6040b)) != 0) {
            return iA6;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gtVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA5 = hs.a(this.f6043c, gtVar.f6043c)) != 0) {
            return iA5;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gtVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA4 = hs.a(this.f6038a, gtVar.f6038a)) != 0) {
            return iA4;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gtVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA3 = hs.a(this.f6042b, gtVar.f6042b)) != 0) {
            return iA3;
        }
        int iCompareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gtVar.m()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (m() && (iA2 = hs.a(this.f6039a, gtVar.f6039a)) != 0) {
            return iA2;
        }
        int iCompareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gtVar.n()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (!n() || (iA = hs.a(this.f6045c, gtVar.f6045c)) == 0) {
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
                if (m5566b()) {
                    m5561a();
                    return;
                }
                throw new ic("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (hyVarMo5667a.f6304a) {
                case 1:
                    if (b2 == 11) {
                        this.f6036a = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 2:
                    if (b2 == 10) {
                        this.f6035a = ibVar.mo5666a();
                        a(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 3:
                    if (b2 == 11) {
                        this.f6041b = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 4:
                    if (b2 == 11) {
                        this.f6044c = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 5:
                    if (b2 == 11) {
                        this.f6046d = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 6:
                    if (b2 == 8) {
                        this.f6034a = ibVar.mo5665a();
                        b(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 7:
                    if (b2 == 11) {
                        this.f6047e = ibVar.mo5672a();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 8:
                    if (b2 == 8) {
                        this.f6040b = ibVar.mo5665a();
                        c(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 9:
                    if (b2 == 8) {
                        this.f6043c = ibVar.mo5665a();
                        d(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 10:
                    if (b2 == 13) {
                        ia iaVarMo5669a = ibVar.mo5669a();
                        this.f6038a = new HashMap(iaVarMo5669a.f6308a * 2);
                        while (i2 < iaVarMo5669a.f6308a) {
                            this.f6038a.put(ibVar.mo5672a(), ibVar.mo5672a());
                            i2++;
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 11:
                    if (b2 == 13) {
                        ia iaVarMo5669a2 = ibVar.mo5669a();
                        this.f6042b = new HashMap(iaVarMo5669a2.f6308a * 2);
                        while (i2 < iaVarMo5669a2.f6308a) {
                            this.f6042b.put(ibVar.mo5672a(), ibVar.mo5672a());
                            i2++;
                        }
                        ibVar.h();
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 12:
                    if (b2 == 2) {
                        this.f6039a = ibVar.mo5677a();
                        e(true);
                        break;
                    } else {
                        ie.a(ibVar, b2);
                        break;
                    }
                case 13:
                    if (b2 == 13) {
                        ia iaVarMo5669a3 = ibVar.mo5669a();
                        this.f6045c = new HashMap(iaVarMo5669a3.f6308a * 2);
                        while (i2 < iaVarMo5669a3.f6308a) {
                            this.f6045c.put(ibVar.mo5672a(), ibVar.mo5672a());
                            i2++;
                        }
                        ibVar.h();
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
    public void m5561a() throws ic {
        if (this.f6036a != null) {
            return;
        }
        throw new ic("Required field 'id' was not present! Struct: " + toString());
    }
}
