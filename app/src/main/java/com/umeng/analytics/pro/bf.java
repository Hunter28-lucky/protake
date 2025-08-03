package com.umeng.analytics.pro;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bf;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TUnion.java */
/* loaded from: classes2.dex */
public abstract class bf<T extends bf<?, ?>, F extends bc> implements av<T, F> {
    private static final Map<Class<? extends cc>, cd> c;
    public Object a;
    public F b;

    /* compiled from: TUnion.java */
    public static class a extends ce<bf> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.a = null;
            buVar.j();
            bp bpVarL = buVar.l();
            Object objA = bfVar.a(buVar, bpVarL);
            bfVar.a = objA;
            if (objA != null) {
                bfVar.b = (F) bfVar.a(bpVarL.c);
            }
            buVar.m();
            buVar.l();
            buVar.k();
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.d());
            buVar.a(bfVar.c(bfVar.b));
            bfVar.a(buVar);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* compiled from: TUnion.java */
    public static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* compiled from: TUnion.java */
    public static class c extends cf<bf> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bu buVar, bf bfVar) throws bb {
            bfVar.b = null;
            bfVar.a = null;
            short sV = buVar.v();
            Object objA = bfVar.a(buVar, sV);
            bfVar.a = objA;
            if (objA != null) {
                bfVar.b = (F) bfVar.a(sV);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bu buVar, bf bfVar) throws bb {
            if (bfVar.a() == null || bfVar.b() == null) {
                throw new bv("Cannot write a TUnion with no set value!");
            }
            buVar.a(bfVar.b.a());
            bfVar.b(buVar);
        }
    }

    /* compiled from: TUnion.java */
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
        c = map;
        map.put(ce.class, new b());
        map.put(cf.class, new d());
    }

    public bf() {
        this.b = null;
        this.a = null;
    }

    private static Object a(Object obj) {
        return obj instanceof av ? ((av) obj).deepCopy() : obj instanceof ByteBuffer ? aw.d((ByteBuffer) obj) : obj instanceof List ? a((List) obj) : obj instanceof Set ? a((Set) obj) : obj instanceof Map ? a((Map<Object, Object>) obj) : obj;
    }

    public abstract F a(short s);

    public abstract Object a(bu buVar, bp bpVar) throws bb;

    public abstract Object a(bu buVar, short s) throws bb;

    public abstract void a(bu buVar) throws bb;

    public Object b() {
        return this.a;
    }

    public abstract void b(F f, Object obj) throws ClassCastException;

    public abstract void b(bu buVar) throws bb;

    public abstract bp c(F f);

    public boolean c() {
        return this.b != null;
    }

    @Override // com.umeng.analytics.pro.av
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    public abstract bz d();

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        c.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(MyUTIL.white_space);
        if (a() != null) {
            Object objB = b();
            sb.append(c(a()).a);
            sb.append(Constants.COLON_SEPARATOR);
            if (objB instanceof ByteBuffer) {
                aw.a((ByteBuffer) objB, sb);
            } else {
                sb.append(objB.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        c.get(buVar.D()).b().a(buVar, this);
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public boolean b(int i) {
        return b((bf<T, F>) a((short) i));
    }

    public bf(F f, Object obj) throws ClassCastException {
        a((bf<T, F>) f, obj);
    }

    public bf(bf<T, F> bfVar) {
        if (bfVar.getClass().equals(getClass())) {
            this.b = bfVar.b;
            this.a = a(bfVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Map a(Map<Object, Object> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            map2.put(a(entry.getKey()), a(entry.getValue()));
        }
        return map2;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(a(it.next()));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
    }

    public Object a(int i) {
        return a((bf<T, F>) a((short) i));
    }

    public void a(F f, Object obj) throws ClassCastException {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public void a(int i, Object obj) throws ClassCastException {
        a((bf<T, F>) a((short) i), obj);
    }
}
