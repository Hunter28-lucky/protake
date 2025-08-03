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
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
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

/* compiled from: IdSnapshot.java */
/* loaded from: classes2.dex */
public class b implements av<b, e>, Serializable, Cloneable {
    public static final Map<e, bh> d;

    /* renamed from: e, reason: collision with root package name */
    private static final long f17818e = -6496538196005191531L;
    private static final bz f = new bz("IdSnapshot");
    private static final bp g = new bp("identity", (byte) 11, 1);
    private static final bp h = new bp("ts", (byte) 10, 2);
    private static final bp i = new bp(Constants.VERSION, (byte) 8, 3);
    private static final Map<Class<? extends cc>, cd> j;
    private static final int k = 0;
    private static final int l = 1;
    public String a;
    public long b;
    public int c;
    private byte m;

    /* compiled from: IdSnapshot.java */
    public static class a extends ce<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, b bVar) throws bb {
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
                        } else if (b == 8) {
                            bVar.c = buVar.w();
                            bVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = buVar.x();
                        bVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    bVar.a = buVar.z();
                    bVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (!bVar.g()) {
                throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, b bVar) throws bb {
            bVar.k();
            buVar.a(b.f);
            if (bVar.a != null) {
                buVar.a(b.g);
                buVar.a(bVar.a);
                buVar.c();
            }
            buVar.a(b.h);
            buVar.a(bVar.b);
            buVar.c();
            buVar.a(b.i);
            buVar.a(bVar.c);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    public static class C1930b implements cd {
        private C1930b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: IdSnapshot.java */
    public static class c extends cf<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(bVar.a);
            caVar.a(bVar.b);
            caVar.a(bVar.c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            bVar.a = caVar.z();
            bVar.a(true);
            bVar.b = caVar.x();
            bVar.b(true);
            bVar.c = caVar.w();
            bVar.c(true);
        }
    }

    /* compiled from: IdSnapshot.java */
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
        map.put(ce.class, new C1930b());
        map.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new bh("identity", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bh("ts", (byte) 1, new bi((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new bh(Constants.VERSION, (byte) 1, new bi((byte) 8)));
        Map<e, bh> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        bh.a(b.class, mapUnmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
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
        c(false);
        this.c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = as.b(this.m, 0);
    }

    public boolean g() {
        return as.a(this.m, 0);
    }

    public int h() {
        return this.c;
    }

    public void i() {
        this.m = as.b(this.m, 1);
    }

    public boolean j() {
        return as.a(this.m, 1);
    }

    public void k() throws bb {
        if (this.a != null) {
            return;
        }
        throw new bv("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        j.get(buVar.D()).b().a(buVar, this);
    }

    /* compiled from: IdSnapshot.java */
    public enum e implements bc {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, Constants.VERSION);

        private static final Map<String, e> d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private final short f17819e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f17819e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
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
            return this.f17819e;
        }
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = as.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = as.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
