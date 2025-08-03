package com.xiaomi.push;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class dp {

    public static final class a extends e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5740a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5741b;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17849e;
        private int a = 0;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5742c = false;
        private int b = 0;
        private boolean f = false;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f5739a = Collections.emptyList();
        private int c = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5342b() {
            return this.f5742c;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m5345e() {
            return this.f;
        }

        public boolean f() {
            return this.f17849e;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5341a() {
            return this.f5740a;
        }

        public a b(int i) {
            this.d = true;
            this.b = i;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5343c() {
            return this.f5741b;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m5344d() {
            return this.d;
        }

        public int e() {
            return this.f5739a.size();
        }

        public a a(int i) {
            this.f5740a = true;
            this.a = i;
            return this;
        }

        public a b(boolean z) {
            this.f17849e = true;
            this.f = z;
            return this;
        }

        public a a(boolean z) {
            this.f5741b = true;
            this.f5742c = z;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = 0;
            int iB = m5341a() ? c.b(1, c()) + 0 : 0;
            if (m5343c()) {
                iB += c.a(2, m5342b());
            }
            if (m5344d()) {
                iB += c.a(3, d());
            }
            if (f()) {
                iB += c.a(4, m5345e());
            }
            Iterator<String> it = m5340a().iterator();
            while (it.hasNext()) {
                iA += c.a(it.next());
            }
            int size = iB + iA + (m5340a().size() * 1);
            this.c = size;
            return size;
        }

        /* renamed from: a, reason: collision with other method in class */
        public List<String> m5340a() {
            return this.f5739a;
        }

        public a a(String str) {
            str.getClass();
            if (this.f5739a.isEmpty()) {
                this.f5739a = new ArrayList();
            }
            this.f5739a.add(str);
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(c cVar) throws IOException {
            if (m5341a()) {
                cVar.m5276b(1, c());
            }
            if (m5343c()) {
                cVar.m5268a(2, m5342b());
            }
            if (m5344d()) {
                cVar.m5263a(3, d());
            }
            if (f()) {
                cVar.m5268a(4, m5345e());
            }
            Iterator<String> it = m5340a().iterator();
            while (it.hasNext()) {
                cVar.m5267a(5, it.next());
            }
        }

        public static a b(b bVar) {
            return new a().a(bVar);
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.c < 0) {
                b();
            }
            return this.c;
        }

        @Override // com.xiaomi.push.e
        public a a(b bVar) throws d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 8) {
                    a(bVar.c());
                } else if (iM5227a == 16) {
                    a(bVar.m5233a());
                } else if (iM5227a == 24) {
                    b(bVar.m5236b());
                } else if (iM5227a == 32) {
                    b(bVar.m5233a());
                } else if (iM5227a != 42) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    a(bVar.m5230a());
                }
            }
        }

        public static a a(byte[] bArr) {
            return (a) new a().a(bArr);
        }
    }
}
