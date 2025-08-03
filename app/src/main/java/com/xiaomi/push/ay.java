package com.xiaomi.push;

import java.util.LinkedList;

/* loaded from: classes2.dex */
public class ay {
    private LinkedList<a> a = new LinkedList<>();

    public static class a {
        private static final ay a = new ay();

        /* renamed from: a, reason: collision with other field name */
        public int f5607a;

        /* renamed from: a, reason: collision with other field name */
        public Object f5608a;

        /* renamed from: a, reason: collision with other field name */
        public String f5609a;

        public a(int i, Object obj) {
            this.f5607a = i;
            this.f5608a = obj;
        }
    }

    public static ay a() {
        return a.a;
    }

    public synchronized void a(Object obj) {
        this.a.add(new a(0, obj));
        m5223a();
    }

    /* renamed from: a, reason: collision with other method in class */
    private void m5223a() {
        if (this.a.size() > 100) {
            this.a.removeFirst();
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized int m5224a() {
        return this.a.size();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized LinkedList<a> m5225a() {
        LinkedList<a> linkedList;
        linkedList = this.a;
        this.a = new LinkedList<>();
        return linkedList;
    }
}
