package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ImprintValue.java */
/* loaded from: classes2.dex */
public class e implements av<e, EnumC1933e>, Serializable, Cloneable {
    public static final Map<EnumC1933e, bh> d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f17824e = 7501688097813630241L;
    private static final bz f = new bz("ImprintValue");
    private static final bp g = new bp("value", (byte) 11, 1);
    private static final bp h = new bp("ts", (byte) 10, 2);
    private static final bp i = new bp("guid", (byte) 11, 3);
    private static final Map<Class<? extends cc>, cd> j;
    private static final int k = 0;
    public String a;
    public long b;
    public String c;
    private byte l;
    private EnumC1933e[] m;

    /* compiled from: ImprintValue.java */
    public static class a extends ce<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, e eVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                byte b = bpVarL.b;
                if (b == 0) {
                    buVar.k();
                    eVar.k();
                    return;
                }
                short s = bpVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            eVar.c = buVar.z();
                            eVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = buVar.x();
                        eVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = buVar.z();
                    eVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, e eVar) throws bb {
            eVar.k();
            buVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                buVar.a(e.g);
                buVar.a(eVar.a);
                buVar.c();
            }
            if (eVar.g()) {
                buVar.a(e.h);
                buVar.a(eVar.b);
                buVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                buVar.a(e.i);
                buVar.a(eVar.c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* compiled from: ImprintValue.java */
    public static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: ImprintValue.java */
    public static class c extends cf<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            caVar.a(bitSet, 3);
            if (eVar.d()) {
                caVar.a(eVar.a);
            }
            if (eVar.g()) {
                caVar.a(eVar.b);
            }
            if (eVar.j()) {
                caVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSetB = caVar.b(3);
            if (bitSetB.get(0)) {
                eVar.a = caVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.b = caVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.c = caVar.z();
                eVar.c(true);
            }
        }
    }

    /* compiled from: ImprintValue.java */
    public static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(ce.class, new b());
        map.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(EnumC1933e.class);
        enumMap.put((EnumMap) EnumC1933e.VALUE, (EnumC1933e) new bh("value", (byte) 2, new bi((byte) 11)));
        enumMap.put((EnumMap) EnumC1933e.TS, (EnumC1933e) new bh("ts", (byte) 2, new bi((byte) 10)));
        enumMap.put((EnumMap) EnumC1933e.GUID, (EnumC1933e) new bh("guid", (byte) 2, new bi((byte) 11)));
        Map<EnumC1933e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bh.a(e.class, mapUnmodifiableMap);
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC1933e[]{EnumC1933e.VALUE, EnumC1933e.TS, EnumC1933e.GUID};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        this.c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.l = as.b(this.l, 0);
    }

    public boolean g() {
        return as.a(this.l, 0);
    }

    public String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void k() throws bb {
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        j.get(buVar.D()).b().a(buVar, this);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    public enum EnumC1933e implements bc {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC1933e> d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f17825e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(EnumC1933e.class).iterator();
            while (it.hasNext()) {
                EnumC1933e enumC1933e = (EnumC1933e) it.next();
                d.put(enumC1933e.b(), enumC1933e);
            }
        }

        EnumC1933e(short s, String str) {
            this.f17825e = s;
            this.f = str;
        }

        public static EnumC1933e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC1933e b(int i) {
            EnumC1933e enumC1933eA = a(i);
            if (enumC1933eA != null) {
                return enumC1933eA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f;
        }

        public static EnumC1933e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f17825e;
        }
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.l = as.a(this.l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC1933e fieldForId(int i2) {
        return EnumC1933e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC1933e[]{EnumC1933e.VALUE, EnumC1933e.TS, EnumC1933e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
