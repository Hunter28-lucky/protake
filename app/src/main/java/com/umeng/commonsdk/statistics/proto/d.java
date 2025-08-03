package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Imprint.java */
/* loaded from: classes2.dex */
public class d implements av<d, e>, Serializable, Cloneable {
    public static final Map<e, bh> d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f17822e = 2846460275012375038L;
    private static final bz f = new bz("Imprint");
    private static final bp g = new bp("property", cb.k, 1);
    private static final bp h = new bp(Constants.VERSION, (byte) 8, 2);
    private static final bp i = new bp("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cc>, cd> j;
    private static final int k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;
    public String c;
    private byte l;

    /* compiled from: Imprint.java */
    public static class a extends ce<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, d dVar) throws bb {
            buVar.j();
            while (true) {
                bp bpVarL = buVar.l();
                byte b = bpVarL.b;
                if (b == 0) {
                    break;
                }
                short s = bpVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            dVar.c = buVar.z();
                            dVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = buVar.w();
                        dVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 13) {
                    br brVarN = buVar.n();
                    dVar.a = new HashMap(brVarN.c * 2);
                    for (int i = 0; i < brVarN.c; i++) {
                        String strZ = buVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(buVar);
                        dVar.a.put(strZ, eVar);
                    }
                    buVar.o();
                    dVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, d dVar) throws bb {
            dVar.l();
            buVar.a(d.f);
            if (dVar.a != null) {
                buVar.a(d.g);
                buVar.a(new br((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            buVar.a(d.h);
            buVar.a(dVar.b);
            buVar.c();
            if (dVar.c != null) {
                buVar.a(d.i);
                buVar.a(dVar.c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* compiled from: Imprint.java */
    public static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: Imprint.java */
    public static class c extends cf<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            caVar.a(dVar.b);
            caVar.a(dVar.c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            dVar.a = new HashMap(brVar.c * 2);
            for (int i = 0; i < brVar.c; i++) {
                String strZ = caVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(caVar);
                dVar.a.put(strZ, eVar);
            }
            dVar.a(true);
            dVar.b = caVar.w();
            dVar.b(true);
            dVar.c = caVar.z();
            dVar.c(true);
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d, reason: collision with other inner class name */
    public static class C1932d implements cd {
        private C1932d() {
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
        map.put(cf.class, new C1932d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new bh("property", (byte) 1, new bk(cb.k, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new bh(Constants.VERSION, (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 1, new bi((byte) 11)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bh.a(d.class, mapUnmodifiableMap);
    }

    public d() {
        this.l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.l = as.b(this.l, 0);
    }

    public boolean h() {
        return as.a(this.l, 0);
    }

    public String i() {
        return this.c;
    }

    public void j() {
        this.c = null;
    }

    public boolean k() {
        return this.c != null;
    }

    public void l() throws bb {
        if (this.a == null) {
            throw new bv("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.c != null) {
            return;
        }
        throw new bv("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        j.get(buVar.D()).b().a(buVar, this);
    }

    /* compiled from: Imprint.java */
    public enum e implements bc {
        PROPERTY(1, "property"),
        VERSION(2, Constants.VERSION),
        CHECKSUM(3, "checksum");

        private static final Map<String, e> d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f17823e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f17823e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return PROPERTY;
            }
            if (i == 2) {
                return VERSION;
            }
            if (i != 3) {
                return null;
            }
            return CHECKSUM;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f;
        }

        public static e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f17823e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
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

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.c = str;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.l = (byte) 0;
        this.l = dVar.l;
        if (dVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = map;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.c = dVar.c;
        }
    }

    public d a(String str) {
        this.c = str;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
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
