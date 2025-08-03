package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class dq {

    public static final class a extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5745a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5748b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5751c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f5753d;

        /* renamed from: e, reason: collision with other field name */
        private boolean f5755e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f5756f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private long f5743a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f5744a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f5747b = "";

        /* renamed from: c, reason: collision with other field name */
        private String f5750c = "";

        /* renamed from: d, reason: collision with other field name */
        private String f5752d = "";

        /* renamed from: e, reason: collision with other field name */
        private String f5754e = "";
        private int b = 1;
        private int c = 0;
        private int d = 0;
        private String f = "";

        /* renamed from: b, reason: collision with other field name */
        private long f5746b = 0;

        /* renamed from: c, reason: collision with other field name */
        private long f5749c = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f17850e = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5352b() {
            return this.f5748b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m5357d() {
            return this.f5753d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m5359e() {
            return this.f5755e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m5361f() {
            return this.f5756f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5349a() {
            return this.f5745a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m5351b() {
            return this.f5747b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5355c() {
            return this.f5751c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public String m5356d() {
            return this.f5752d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public String m5358e() {
            return this.f5754e;
        }

        public int f() {
            return this.d;
        }

        public a a(int i) {
            this.f5745a = true;
            this.a = i;
            return this;
        }

        public a b(String str) {
            this.f5753d = true;
            this.f5747b = str;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public String m5354c() {
            return this.f5750c;
        }

        public a d(String str) {
            this.f5756f = true;
            this.f5752d = str;
            return this;
        }

        public a e(String str) {
            this.g = true;
            this.f5754e = str;
            return this;
        }

        /* renamed from: f, reason: collision with other method in class */
        public String m5360f() {
            return this.f;
        }

        public a c(String str) {
            this.f5755e = true;
            this.f5750c = str;
            return this;
        }

        public a f(String str) {
            this.k = true;
            this.f = str;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public long m5346a() {
            return this.f5743a;
        }

        public a b(int i) {
            this.h = true;
            this.b = i;
            return this;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        public a a(long j) {
            this.f5748b = true;
            this.f5743a = j;
            return this;
        }

        public a c(int i) {
            this.i = true;
            this.c = i;
            return this;
        }

        public a d(int i) {
            this.j = true;
            this.d = i;
            return this;
        }

        /* renamed from: b, reason: collision with other method in class */
        public long m5350b() {
            return this.f5746b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5348a() {
            return this.f5744a;
        }

        public a b(long j) {
            this.l = true;
            this.f5746b = j;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public long m5353c() {
            return this.f5749c;
        }

        public a a(String str) {
            this.f5751c = true;
            this.f5744a = str;
            return this;
        }

        public a c(long j) {
            this.m = true;
            this.f5749c = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5349a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m5352b()) {
                iA += com.xiaomi.push.c.b(2, m5346a());
            }
            if (m5355c()) {
                iA += com.xiaomi.push.c.a(3, m5348a());
            }
            if (m5357d()) {
                iA += com.xiaomi.push.c.a(4, m5351b());
            }
            if (m5359e()) {
                iA += com.xiaomi.push.c.a(5, m5354c());
            }
            if (m5361f()) {
                iA += com.xiaomi.push.c.a(6, m5356d());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(7, m5358e());
            }
            if (h()) {
                iA += com.xiaomi.push.c.a(8, d());
            }
            if (i()) {
                iA += com.xiaomi.push.c.a(9, e());
            }
            if (j()) {
                iA += com.xiaomi.push.c.a(10, f());
            }
            if (k()) {
                iA += com.xiaomi.push.c.a(11, m5360f());
            }
            if (l()) {
                iA += com.xiaomi.push.c.b(12, m5350b());
            }
            if (m()) {
                iA += com.xiaomi.push.c.b(13, m5353c());
            }
            this.f17850e = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public a m5347a() {
            this.f5756f = false;
            this.f5752d = "";
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5349a()) {
                cVar.m5263a(1, c());
            }
            if (m5352b()) {
                cVar.m5277b(2, m5346a());
            }
            if (m5355c()) {
                cVar.m5267a(3, m5348a());
            }
            if (m5357d()) {
                cVar.m5267a(4, m5351b());
            }
            if (m5359e()) {
                cVar.m5267a(5, m5354c());
            }
            if (m5361f()) {
                cVar.m5267a(6, m5356d());
            }
            if (g()) {
                cVar.m5267a(7, m5358e());
            }
            if (h()) {
                cVar.m5263a(8, d());
            }
            if (i()) {
                cVar.m5263a(9, e());
            }
            if (j()) {
                cVar.m5263a(10, f());
            }
            if (k()) {
                cVar.m5267a(11, m5360f());
            }
            if (l()) {
                cVar.m5277b(12, m5350b());
            }
            if (m()) {
                cVar.m5277b(13, m5353c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f17850e < 0) {
                b();
            }
            return this.f17850e;
        }

        @Override // com.xiaomi.push.e
        public a a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                switch (iM5227a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.m5236b());
                        break;
                    case 16:
                        a(bVar.m5237b());
                        break;
                    case 26:
                        a(bVar.m5230a());
                        break;
                    case 34:
                        b(bVar.m5230a());
                        break;
                    case 42:
                        c(bVar.m5230a());
                        break;
                    case 50:
                        d(bVar.m5230a());
                        break;
                    case 58:
                        e(bVar.m5230a());
                        break;
                    case 64:
                        b(bVar.m5236b());
                        break;
                    case 72:
                        c(bVar.m5236b());
                        break;
                    case 80:
                        d(bVar.m5236b());
                        break;
                    case 90:
                        f(bVar.m5230a());
                        break;
                    case 96:
                        b(bVar.m5237b());
                        break;
                    case 104:
                        c(bVar.m5237b());
                        break;
                    default:
                        if (!a(bVar, iM5227a)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    public static final class b extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5757a;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5759c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f5760d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17851e;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5758b = false;
        private int a = 0;
        private int b = 0;
        private int c = 0;
        private int d = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5363b() {
            return this.f5757a;
        }

        public int c() {
            return this.a;
        }

        public int d() {
            return this.b;
        }

        public int e() {
            return this.c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5362a() {
            return this.f5758b;
        }

        public b b(int i) {
            this.f5760d = true;
            this.b = i;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5364c() {
            return this.f5759c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m5365d() {
            return this.f5760d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m5366e() {
            return this.f17851e;
        }

        public b a(boolean z) {
            this.f5757a = true;
            this.f5758b = z;
            return this;
        }

        public b c(int i) {
            this.f17851e = true;
            this.c = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5363b() ? 0 + com.xiaomi.push.c.a(1, m5362a()) : 0;
            if (m5364c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m5365d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m5366e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            this.d = iA;
            return iA;
        }

        public b a(int i) {
            this.f5759c = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5363b()) {
                cVar.m5268a(1, m5362a());
            }
            if (m5364c()) {
                cVar.m5263a(3, c());
            }
            if (m5365d()) {
                cVar.m5263a(4, d());
            }
            if (m5366e()) {
                cVar.m5263a(5, e());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.d < 0) {
                b();
            }
            return this.d;
        }

        @Override // com.xiaomi.push.e
        public b a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 8) {
                    a(bVar.m5233a());
                } else if (iM5227a == 24) {
                    a(bVar.m5236b());
                } else if (iM5227a == 32) {
                    b(bVar.m5236b());
                } else if (iM5227a != 40) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    c(bVar.m5236b());
                }
            }
        }

        public static b a(byte[] bArr) {
            return (b) new b().a(bArr);
        }
    }

    public static final class c extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5762a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5763b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5764c;

        /* renamed from: d, reason: collision with other field name */
        private boolean f5765d;

        /* renamed from: e, reason: collision with other field name */
        private boolean f5766e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f5767f;

        /* renamed from: a, reason: collision with other field name */
        private String f5761a = "";
        private String b = "";
        private String c = "";
        private String d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f17852e = "";
        private String f = "";
        private int a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m5369b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.f17852e;
        }

        public String f() {
            return this.f;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5367a() {
            return this.f5761a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5370b() {
            return this.f5763b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5371c() {
            return this.f5764c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m5372d() {
            return this.f5765d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m5373e() {
            return this.f5766e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m5374f() {
            return this.f5767f;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5368a() {
            return this.f5762a;
        }

        public c b(String str) {
            this.f5763b = true;
            this.b = str;
            return this;
        }

        public c c(String str) {
            this.f5764c = true;
            this.c = str;
            return this;
        }

        public c d(String str) {
            this.f5765d = true;
            this.d = str;
            return this;
        }

        public c e(String str) {
            this.f5766e = true;
            this.f17852e = str;
            return this;
        }

        public c f(String str) {
            this.f5767f = true;
            this.f = str;
            return this;
        }

        public c a(String str) {
            this.f5762a = true;
            this.f5761a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5368a() ? 0 + com.xiaomi.push.c.a(1, m5367a()) : 0;
            if (m5370b()) {
                iA += com.xiaomi.push.c.a(2, m5369b());
            }
            if (m5371c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            if (m5372d()) {
                iA += com.xiaomi.push.c.a(4, d());
            }
            if (m5373e()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (m5374f()) {
                iA += com.xiaomi.push.c.a(6, f());
            }
            this.a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5368a()) {
                cVar.m5267a(1, m5367a());
            }
            if (m5370b()) {
                cVar.m5267a(2, m5369b());
            }
            if (m5371c()) {
                cVar.m5267a(3, c());
            }
            if (m5372d()) {
                cVar.m5267a(4, d());
            }
            if (m5373e()) {
                cVar.m5267a(5, e());
            }
            if (m5374f()) {
                cVar.m5267a(6, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public c a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 10) {
                    a(bVar.m5230a());
                } else if (iM5227a == 18) {
                    b(bVar.m5230a());
                } else if (iM5227a == 26) {
                    c(bVar.m5230a());
                } else if (iM5227a == 34) {
                    d(bVar.m5230a());
                } else if (iM5227a == 42) {
                    e(bVar.m5230a());
                } else if (iM5227a != 50) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    f(bVar.m5230a());
                }
            }
        }
    }

    public static final class d extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5769a;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5771c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17853e;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5770b = false;

        /* renamed from: a, reason: collision with other field name */
        private String f5768a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5378b() {
            return this.f5769a;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5379c() {
            return this.f5771c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f17853e;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5376a() {
            return this.f5770b;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m5377b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public d a(boolean z) {
            this.f5769a = true;
            this.f5770b = z;
            return this;
        }

        public d b(String str) {
            this.d = true;
            this.b = str;
            return this;
        }

        public d c(String str) {
            this.f17853e = true;
            this.c = str;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5375a() {
            return this.f5768a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5378b() ? 0 + com.xiaomi.push.c.a(1, m5376a()) : 0;
            if (m5379c()) {
                iA += com.xiaomi.push.c.a(2, m5375a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(3, m5377b());
            }
            if (e()) {
                iA += com.xiaomi.push.c.a(4, c());
            }
            this.a = iA;
            return iA;
        }

        public d a(String str) {
            this.f5771c = true;
            this.f5768a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5378b()) {
                cVar.m5268a(1, m5376a());
            }
            if (m5379c()) {
                cVar.m5267a(2, m5375a());
            }
            if (d()) {
                cVar.m5267a(3, m5377b());
            }
            if (e()) {
                cVar.m5267a(4, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public d a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 8) {
                    a(bVar.m5233a());
                } else if (iM5227a == 18) {
                    a(bVar.m5230a());
                } else if (iM5227a == 26) {
                    b(bVar.m5230a());
                } else if (iM5227a != 34) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    c(bVar.m5230a());
                }
            }
        }

        public static d a(byte[] bArr) {
            return (d) new d().a(bArr);
        }
    }

    public static final class e extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f5772a;

        /* renamed from: a, reason: collision with other field name */
        private boolean f5775a;

        /* renamed from: b, reason: collision with other field name */
        private com.xiaomi.push.a f5776b;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5778b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5780c;
        private int d;

        /* renamed from: d, reason: collision with other field name */
        private boolean f5782d;

        /* renamed from: e, reason: collision with root package name */
        private int f17854e;

        /* renamed from: e, reason: collision with other field name */
        private boolean f5784e;

        /* renamed from: f, reason: collision with other field name */
        private boolean f5785f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private boolean l;
        private boolean m;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f5774a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f5777b = "";

        /* renamed from: c, reason: collision with other field name */
        private String f5779c = "";
        private int b = 0;

        /* renamed from: d, reason: collision with other field name */
        private String f5781d = "";

        /* renamed from: e, reason: collision with other field name */
        private String f5783e = "";
        private String f = "";

        /* renamed from: a, reason: collision with other field name */
        private b f5773a = null;
        private int c = 0;

        public e() {
            com.xiaomi.push.a aVar = com.xiaomi.push.a.a;
            this.f5772a = aVar;
            this.f5776b = aVar;
            this.d = 0;
            this.f17854e = -1;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5386b() {
            return this.f5778b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: d, reason: collision with other method in class */
        public boolean m5390d() {
            return this.f5782d;
        }

        /* renamed from: e, reason: collision with other method in class */
        public boolean m5392e() {
            return this.f5784e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public boolean m5394f() {
            return this.f5785f;
        }

        public boolean g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public boolean j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public boolean l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5383a() {
            return this.f5775a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public String m5385b() {
            return this.f5777b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5388c() {
            return this.f5780c;
        }

        public int d() {
            return this.b;
        }

        /* renamed from: e, reason: collision with other method in class */
        public String m5391e() {
            return this.f5783e;
        }

        /* renamed from: f, reason: collision with other method in class */
        public String m5393f() {
            return this.f;
        }

        public e a(int i) {
            this.f5775a = true;
            this.a = i;
            return this;
        }

        public e b(String str) {
            this.f5780c = true;
            this.f5777b = str;
            return this;
        }

        /* renamed from: c, reason: collision with other method in class */
        public String m5387c() {
            return this.f5779c;
        }

        /* renamed from: d, reason: collision with other method in class */
        public String m5389d() {
            return this.f5781d;
        }

        public e e(String str) {
            this.g = true;
            this.f5783e = str;
            return this;
        }

        public e f(String str) {
            this.h = true;
            this.f = str;
            return this;
        }

        public e c(String str) {
            this.f5782d = true;
            this.f5779c = str;
            return this;
        }

        public e d(String str) {
            this.f5785f = true;
            this.f5781d = str;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5382a() {
            return this.f5774a;
        }

        public e b(int i) {
            this.f5784e = true;
            this.b = i;
            return this;
        }

        public int e() {
            return this.c;
        }

        public int f() {
            return this.d;
        }

        public e a(String str) {
            this.f5778b = true;
            this.f5774a = str;
            return this;
        }

        public e c(int i) {
            this.j = true;
            this.c = i;
            return this;
        }

        public e d(int i) {
            this.m = true;
            this.d = i;
            return this;
        }

        /* renamed from: b, reason: collision with other method in class */
        public com.xiaomi.push.a m5384b() {
            return this.f5776b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m5381a() {
            return this.f5773a;
        }

        public e b(com.xiaomi.push.a aVar) {
            this.l = true;
            this.f5776b = aVar;
            return this;
        }

        public e a(b bVar) {
            bVar.getClass();
            this.i = true;
            this.f5773a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iB = m5383a() ? 0 + com.xiaomi.push.c.b(1, c()) : 0;
            if (m5386b()) {
                iB += com.xiaomi.push.c.a(2, m5382a());
            }
            if (m5388c()) {
                iB += com.xiaomi.push.c.a(3, m5385b());
            }
            if (m5390d()) {
                iB += com.xiaomi.push.c.a(4, m5387c());
            }
            if (m5392e()) {
                iB += com.xiaomi.push.c.a(5, d());
            }
            if (m5394f()) {
                iB += com.xiaomi.push.c.a(6, m5389d());
            }
            if (g()) {
                iB += com.xiaomi.push.c.a(7, m5391e());
            }
            if (h()) {
                iB += com.xiaomi.push.c.a(8, m5393f());
            }
            if (i()) {
                iB += com.xiaomi.push.c.a(9, (com.xiaomi.push.e) m5381a());
            }
            if (j()) {
                iB += com.xiaomi.push.c.a(10, e());
            }
            if (k()) {
                iB += com.xiaomi.push.c.a(11, m5380a());
            }
            if (l()) {
                iB += com.xiaomi.push.c.a(12, m5384b());
            }
            if (m()) {
                iB += com.xiaomi.push.c.a(13, f());
            }
            this.f17854e = iB;
            return iB;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m5380a() {
            return this.f5772a;
        }

        public e a(com.xiaomi.push.a aVar) {
            this.k = true;
            this.f5772a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5383a()) {
                cVar.m5276b(1, c());
            }
            if (m5386b()) {
                cVar.m5267a(2, m5382a());
            }
            if (m5388c()) {
                cVar.m5267a(3, m5385b());
            }
            if (m5390d()) {
                cVar.m5267a(4, m5387c());
            }
            if (m5392e()) {
                cVar.m5263a(5, d());
            }
            if (m5394f()) {
                cVar.m5267a(6, m5389d());
            }
            if (g()) {
                cVar.m5267a(7, m5391e());
            }
            if (h()) {
                cVar.m5267a(8, m5393f());
            }
            if (i()) {
                cVar.m5266a(9, (com.xiaomi.push.e) m5381a());
            }
            if (j()) {
                cVar.m5263a(10, e());
            }
            if (k()) {
                cVar.m5265a(11, m5380a());
            }
            if (l()) {
                cVar.m5265a(12, m5384b());
            }
            if (m()) {
                cVar.m5263a(13, f());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.f17854e < 0) {
                b();
            }
            return this.f17854e;
        }

        @Override // com.xiaomi.push.e
        public e a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                switch (iM5227a) {
                    case 0:
                        return this;
                    case 8:
                        a(bVar.c());
                        break;
                    case 18:
                        a(bVar.m5230a());
                        break;
                    case 26:
                        b(bVar.m5230a());
                        break;
                    case 34:
                        c(bVar.m5230a());
                        break;
                    case 40:
                        b(bVar.m5236b());
                        break;
                    case 50:
                        d(bVar.m5230a());
                        break;
                    case 58:
                        e(bVar.m5230a());
                        break;
                    case 66:
                        f(bVar.m5230a());
                        break;
                    case 74:
                        b bVar2 = new b();
                        bVar.a(bVar2);
                        a(bVar2);
                        break;
                    case 80:
                        c(bVar.m5236b());
                        break;
                    case 90:
                        a(bVar.m5229a());
                        break;
                    case 98:
                        b(bVar.m5229a());
                        break;
                    case 104:
                        d(bVar.m5236b());
                        break;
                    default:
                        if (!a(bVar, iM5227a)) {
                            return this;
                        }
                        break;
                }
            }
        }
    }

    public static final class f extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5788a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5789b;
        private boolean c;

        /* renamed from: a, reason: collision with other field name */
        private String f5787a = "";
        private String b = "";

        /* renamed from: a, reason: collision with other field name */
        private b f5786a = null;
        private int a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m5398b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5396a() {
            return this.f5787a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5399b() {
            return this.f5789b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5397a() {
            return this.f5788a;
        }

        public f b(String str) {
            this.f5789b = true;
            this.b = str;
            return this;
        }

        public f a(String str) {
            this.f5788a = true;
            this.f5787a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5397a() ? 0 + com.xiaomi.push.c.a(1, m5396a()) : 0;
            if (m5399b()) {
                iA += com.xiaomi.push.c.a(2, m5398b());
            }
            if (c()) {
                iA += com.xiaomi.push.c.a(3, (com.xiaomi.push.e) m5395a());
            }
            this.a = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m5395a() {
            return this.f5786a;
        }

        public f a(b bVar) {
            bVar.getClass();
            this.c = true;
            this.f5786a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5397a()) {
                cVar.m5267a(1, m5396a());
            }
            if (m5399b()) {
                cVar.m5267a(2, m5398b());
            }
            if (c()) {
                cVar.m5266a(3, (com.xiaomi.push.e) m5395a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public f a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 10) {
                    a(bVar.m5230a());
                } else if (iM5227a == 18) {
                    b(bVar.m5230a());
                } else if (iM5227a != 26) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static f a(byte[] bArr) {
            return (f) new f().a(bArr);
        }
    }

    public static final class g extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5791a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5792b;

        /* renamed from: c, reason: collision with other field name */
        private boolean f5793c;

        /* renamed from: a, reason: collision with other field name */
        private String f5790a = "";
        private String b = "";
        private String c = "";
        private int a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m5402b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5400a() {
            return this.f5790a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5403b() {
            return this.f5792b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5404c() {
            return this.f5793c;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5401a() {
            return this.f5791a;
        }

        public g b(String str) {
            this.f5792b = true;
            this.b = str;
            return this;
        }

        public g c(String str) {
            this.f5793c = true;
            this.c = str;
            return this;
        }

        public g a(String str) {
            this.f5791a = true;
            this.f5790a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5401a() ? 0 + com.xiaomi.push.c.a(1, m5400a()) : 0;
            if (m5403b()) {
                iA += com.xiaomi.push.c.a(2, m5402b());
            }
            if (m5404c()) {
                iA += com.xiaomi.push.c.a(3, c());
            }
            this.a = iA;
            return iA;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5401a()) {
                cVar.m5267a(1, m5400a());
            }
            if (m5403b()) {
                cVar.m5267a(2, m5402b());
            }
            if (m5404c()) {
                cVar.m5267a(3, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public g a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 10) {
                    a(bVar.m5230a());
                } else if (iM5227a == 18) {
                    b(bVar.m5230a());
                } else if (iM5227a != 26) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    c(bVar.m5230a());
                }
            }
        }

        public static g a(byte[] bArr) {
            return (g) new g().a(bArr);
        }
    }

    public static final class h extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5795a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5796b;
        private int a = 0;

        /* renamed from: a, reason: collision with other field name */
        private String f5794a = "";
        private int b = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5407b() {
            return this.f5796b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5406a() {
            return this.f5795a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5406a() ? 0 + com.xiaomi.push.c.a(1, c()) : 0;
            if (m5407b()) {
                iA += com.xiaomi.push.c.a(2, m5405a());
            }
            this.b = iA;
            return iA;
        }

        public h a(int i) {
            this.f5795a = true;
            this.a = i;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5405a() {
            return this.f5794a;
        }

        public h a(String str) {
            this.f5796b = true;
            this.f5794a = str;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5406a()) {
                cVar.m5263a(1, c());
            }
            if (m5407b()) {
                cVar.m5267a(2, m5405a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public h a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 8) {
                    a(bVar.m5236b());
                } else if (iM5227a != 18) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    a(bVar.m5230a());
                }
            }
        }

        public static h a(byte[] bArr) {
            return (h) new h().a(bArr);
        }
    }

    public static final class i extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5798a;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f5797a = com.xiaomi.push.a.a;
        private int a = -1;

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5409a() ? 0 + com.xiaomi.push.c.a(1, m5408a()) : 0;
            this.a = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m5408a() {
            return this.f5797a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5409a() {
            return this.f5798a;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.f5798a = true;
            this.f5797a = aVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5409a()) {
                cVar.m5265a(1, m5408a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public i a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a != 10) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    a(bVar.m5229a());
                }
            }
        }

        public static i a(byte[] bArr) {
            return (i) new i().a(bArr);
        }
    }

    public static final class j extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5801a;
        private boolean b;

        /* renamed from: a, reason: collision with other field name */
        private com.xiaomi.push.a f5799a = com.xiaomi.push.a.a;

        /* renamed from: a, reason: collision with other field name */
        private b f5800a = null;
        private int a = -1;

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5413b() {
            return this.b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public com.xiaomi.push.a m5410a() {
            return this.f5799a;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5412a() ? 0 + com.xiaomi.push.c.a(1, m5410a()) : 0;
            if (m5413b()) {
                iA += com.xiaomi.push.c.a(2, (com.xiaomi.push.e) m5411a());
            }
            this.a = iA;
            return iA;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5412a() {
            return this.f5801a;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.f5801a = true;
            this.f5799a = aVar;
            return this;
        }

        /* renamed from: a, reason: collision with other method in class */
        public b m5411a() {
            return this.f5800a;
        }

        public j a(b bVar) {
            bVar.getClass();
            this.b = true;
            this.f5800a = bVar;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5412a()) {
                cVar.m5265a(1, m5410a());
            }
            if (m5413b()) {
                cVar.m5266a(2, (com.xiaomi.push.e) m5411a());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.a < 0) {
                b();
            }
            return this.a;
        }

        @Override // com.xiaomi.push.e
        public j a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 10) {
                    a(bVar.m5229a());
                } else if (iM5227a != 18) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    b bVar2 = new b();
                    bVar.a(bVar2);
                    a(bVar2);
                }
            }
        }

        public static j a(byte[] bArr) {
            return (j) new j().a(bArr);
        }
    }

    public static final class k extends com.xiaomi.push.e {

        /* renamed from: a, reason: collision with other field name */
        private boolean f5804a;

        /* renamed from: b, reason: collision with other field name */
        private boolean f5807b;
        private boolean c;
        private boolean d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f17855e;
        private boolean g;

        /* renamed from: a, reason: collision with other field name */
        private String f5803a = "";

        /* renamed from: b, reason: collision with other field name */
        private String f5806b = "";

        /* renamed from: a, reason: collision with other field name */
        private long f5802a = 0;

        /* renamed from: b, reason: collision with other field name */
        private long f5805b = 0;
        private boolean f = false;
        private int a = 0;
        private int b = -1;

        /* renamed from: b, reason: collision with other method in class */
        public String m5418b() {
            return this.f5806b;
        }

        /* renamed from: c, reason: collision with other method in class */
        public boolean m5420c() {
            return this.c;
        }

        public boolean d() {
            return this.d;
        }

        public boolean e() {
            return this.f;
        }

        public boolean f() {
            return this.f17855e;
        }

        public boolean g() {
            return this.g;
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5415a() {
            return this.f5803a;
        }

        /* renamed from: b, reason: collision with other method in class */
        public boolean m5419b() {
            return this.f5807b;
        }

        public int c() {
            return this.a;
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5416a() {
            return this.f5804a;
        }

        public k b(String str) {
            this.f5807b = true;
            this.f5806b = str;
            return this;
        }

        public k a(String str) {
            this.f5804a = true;
            this.f5803a = str;
            return this;
        }

        /* renamed from: b, reason: collision with other method in class */
        public long m5417b() {
            return this.f5805b;
        }

        /* renamed from: a, reason: collision with other method in class */
        public long m5414a() {
            return this.f5802a;
        }

        public k b(long j) {
            this.d = true;
            this.f5805b = j;
            return this;
        }

        public k a(long j) {
            this.c = true;
            this.f5802a = j;
            return this;
        }

        @Override // com.xiaomi.push.e
        public int b() {
            int iA = m5416a() ? 0 + com.xiaomi.push.c.a(1, m5415a()) : 0;
            if (m5419b()) {
                iA += com.xiaomi.push.c.a(2, m5418b());
            }
            if (m5420c()) {
                iA += com.xiaomi.push.c.a(3, m5414a());
            }
            if (d()) {
                iA += com.xiaomi.push.c.a(4, m5417b());
            }
            if (f()) {
                iA += com.xiaomi.push.c.a(5, e());
            }
            if (g()) {
                iA += com.xiaomi.push.c.a(6, c());
            }
            this.b = iA;
            return iA;
        }

        public k a(boolean z) {
            this.f17855e = true;
            this.f = z;
            return this;
        }

        public k a(int i) {
            this.g = true;
            this.a = i;
            return this;
        }

        @Override // com.xiaomi.push.e
        public void a(com.xiaomi.push.c cVar) throws IOException {
            if (m5416a()) {
                cVar.m5267a(1, m5415a());
            }
            if (m5419b()) {
                cVar.m5267a(2, m5418b());
            }
            if (m5420c()) {
                cVar.m5264a(3, m5414a());
            }
            if (d()) {
                cVar.m5264a(4, m5417b());
            }
            if (f()) {
                cVar.m5268a(5, e());
            }
            if (g()) {
                cVar.m5263a(6, c());
            }
        }

        @Override // com.xiaomi.push.e
        public int a() {
            if (this.b < 0) {
                b();
            }
            return this.b;
        }

        @Override // com.xiaomi.push.e
        public k a(com.xiaomi.push.b bVar) throws com.xiaomi.push.d {
            while (true) {
                int iM5227a = bVar.m5227a();
                if (iM5227a == 0) {
                    return this;
                }
                if (iM5227a == 10) {
                    a(bVar.m5230a());
                } else if (iM5227a == 18) {
                    b(bVar.m5230a());
                } else if (iM5227a == 24) {
                    a(bVar.m5228a());
                } else if (iM5227a == 32) {
                    b(bVar.m5228a());
                } else if (iM5227a == 40) {
                    a(bVar.m5233a());
                } else if (iM5227a != 48) {
                    if (!a(bVar, iM5227a)) {
                        return this;
                    }
                } else {
                    a(bVar.m5236b());
                }
            }
        }

        public static k a(byte[] bArr) {
            return (k) new k().a(bArr);
        }
    }
}
