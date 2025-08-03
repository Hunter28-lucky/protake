package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager.java */
/* loaded from: classes2.dex */
class c {
    private static c a;
    private ConcurrentHashMap<String, a> b = new ConcurrentHashMap<>();
    private Context c;

    private c() {
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        c cVar = a;
        cVar.c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.b.get(str) != null) {
            return this.b.get(str);
        }
        a aVarA = a.a(this.c, str);
        this.b.put(str, aVarA);
        return aVarA;
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    /* compiled from: UMProcessDBManager.java */
    public static class a {
        private AtomicInteger a = new AtomicInteger();
        private SQLiteOpenHelper b;
        private SQLiteDatabase c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.a.decrementAndGet() == 0) {
                    this.c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            if (this.a.incrementAndGet() == 1) {
                this.c = this.b.getWritableDatabase();
            }
            return this.c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
