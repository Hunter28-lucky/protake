package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ag;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class dc {
    private static volatile dc a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5710a;

    /* renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f5711a;

    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.dc.b, com.xiaomi.push.ag.b
        public void b() {
            dc.this.b();
        }
    }

    public class b extends ag.b {
        public long a = System.currentTimeMillis();

        public b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.ag.b
        public void b() {
        }

        /* renamed from: b, reason: collision with other method in class */
        public final boolean m5329b() {
            return System.currentTimeMillis() - this.a > 172800000;
        }
    }

    private dc(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f5711a = concurrentLinkedQueue;
        this.f5710a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            File file = new File(this.f5710a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f5711a.isEmpty()) {
            b bVarPeek = this.f5711a.peek();
            if (bVarPeek != null) {
                if (!bVarPeek.m5329b() && this.f5711a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f5711a.remove(bVarPeek);
            }
        }
    }

    public static dc a(Context context) {
        if (a == null) {
            synchronized (dc.class) {
                if (a == null) {
                    a = new dc(context);
                }
            }
        }
        a.f5710a = context;
        return a;
    }

    private void b(long j) {
        if (this.f5711a.isEmpty()) {
            return;
        }
        fz.a(new ag.b() { // from class: com.xiaomi.push.dc.2
            public ag.b a;

            @Override // com.xiaomi.push.ag.b
            public void b() {
                b bVar = (b) dc.this.f5711a.peek();
                if (bVar == null || !bVar.a()) {
                    return;
                }
                if (dc.this.f5711a.remove(bVar)) {
                    this.a = bVar;
                }
                ag.b bVar2 = this.a;
                if (bVar2 != null) {
                    bVar2.b();
                }
            }

            @Override // com.xiaomi.push.ag.b
            /* renamed from: c */
            public void mo5330c() {
                ag.b bVar = this.a;
                if (bVar != null) {
                    bVar.mo5330c();
                }
            }
        }, j);
    }

    public class c extends b {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public File f5720a;

        /* renamed from: a, reason: collision with other field name */
        public String f5721a;

        /* renamed from: a, reason: collision with other field name */
        public boolean f5722a;
        public String b;

        /* renamed from: b, reason: collision with other field name */
        public boolean f5723b;

        public c(String str, String str2, File file, boolean z) {
            super();
            this.f5721a = str;
            this.b = str2;
            this.f5720a = file;
            this.f5723b = z;
        }

        private boolean c() throws JSONException {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = dc.this.f5710a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                jCurrentTimeMillis = jSONObject.getLong("time");
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis >= 86400000) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                if (i > 10) {
                    return false;
                }
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", jCurrentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e2.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.dc.b
        public boolean a() {
            return av.d(dc.this.f5710a) || (this.f5723b && av.m5216a(dc.this.f5710a));
        }

        @Override // com.xiaomi.push.dc.b, com.xiaomi.push.ag.b
        public void b() {
            try {
                if (c()) {
                    HashMap map = new HashMap();
                    map.put("uid", com.xiaomi.push.service.ax.m5771a());
                    map.put("token", this.b);
                    map.put("net", av.m5212a(dc.this.f5710a));
                    av.a(this.f5721a, map, this.f5720a, "file");
                }
                this.f5722a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.ag.b
        /* renamed from: c, reason: collision with other method in class */
        public void mo5330c() {
            if (!this.f5722a) {
                int i = this.a + 1;
                this.a = i;
                if (i < 3) {
                    dc.this.f5711a.add(this);
                }
            }
            if (this.f5722a || this.a >= 3) {
                this.f5720a.delete();
            }
            dc.this.a((1 << this.a) * 1000);
        }
    }

    public void a(final String str, final String str2, final Date date, final Date date2, final int i, final boolean z) {
        this.f5711a.add(new b() { // from class: com.xiaomi.push.dc.1

            /* renamed from: a, reason: collision with other field name */
            public File f5713a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // com.xiaomi.push.dc.b, com.xiaomi.push.ag.b
            public void b() {
                try {
                    File file = new File(dc.this.f5710a.getFilesDir() + "/.logcache");
                    if (w.m5830a(file)) {
                        file.mkdirs();
                        if (file.isDirectory()) {
                            db dbVar = new db();
                            dbVar.a(i);
                            this.f5713a = dbVar.a(dc.this.f5710a, date, date2, file);
                        }
                    }
                } catch (NullPointerException unused) {
                }
            }

            @Override // com.xiaomi.push.ag.b
            /* renamed from: c */
            public void mo5330c() {
                File file = this.f5713a;
                if (file != null && file.exists()) {
                    dc.this.f5711a.add(dc.this.new c(str, str2, this.f5713a, z));
                }
                dc.this.a(0L);
            }
        });
        b(0L);
    }

    public void a() {
        c();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b bVarPeek = this.f5711a.peek();
        if (bVarPeek == null || !bVarPeek.a()) {
            return;
        }
        b(j);
    }
}
