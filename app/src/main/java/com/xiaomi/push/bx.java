package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.af;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class bx {
    private static volatile bx a;

    /* renamed from: a, reason: collision with other field name */
    private Context f5634a;

    /* renamed from: a, reason: collision with other field name */
    private bw f5635a;

    /* renamed from: a, reason: collision with other field name */
    private final HashMap<String, bv> f5637a = new HashMap<>();

    /* renamed from: a, reason: collision with other field name */
    private ThreadPoolExecutor f5638a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a, reason: collision with other field name */
    private final ArrayList<a> f5636a = new ArrayList<>();

    public static class d extends a {
        private String a;

        /* renamed from: a, reason: collision with other field name */
        public String[] f5648a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f5648a = strArr;
        }

        @Override // com.xiaomi.push.bx.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f5648a);
        }
    }

    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.bx.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private bx(Context context) {
        this.f5634a = context;
    }

    public void b(a aVar) {
        bv bvVarA;
        if (aVar == null) {
            return;
        }
        if (this.f5635a == null) {
            throw new IllegalStateException("should exec init method first!");
        }
        String strM5259a = aVar.m5259a();
        synchronized (this.f5637a) {
            bvVarA = this.f5637a.get(strM5259a);
            if (bvVarA == null) {
                bvVarA = this.f5635a.a(this.f5634a, strM5259a);
                this.f5637a.put(strM5259a, bvVarA);
            }
        }
        if (this.f5638a.isShutdown()) {
            return;
        }
        aVar.a(bvVarA, this.f5634a);
        a((Runnable) aVar);
    }

    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.bx.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }

        @Override // com.xiaomi.push.bx.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it = this.a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }
    }

    public static bx a(Context context) {
        if (a == null) {
            synchronized (bx.class) {
                if (a == null) {
                    a = new bx(context);
                }
            }
        }
        return a;
    }

    public static abstract class a implements Runnable {

        /* renamed from: a, reason: collision with other field name */
        private a f5640a;

        /* renamed from: a, reason: collision with other field name */
        private String f5641a;

        /* renamed from: a, reason: collision with other field name */
        private WeakReference<Context> f5642a;
        public String b;

        /* renamed from: a, reason: collision with other field name */
        public bv f5639a = null;

        /* renamed from: a, reason: collision with other field name */
        private Random f5643a = new Random();
        private int a = 0;

        public a(String str) {
            this.f5641a = str;
        }

        /* renamed from: a, reason: collision with other method in class */
        public Object mo5258a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(bv bvVar, Context context) {
            this.f5639a = bvVar;
            this.b = bvVar.a();
            this.f5642a = new WeakReference<>(context);
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() throws IOException {
            final Context context;
            WeakReference<Context> weakReference = this.f5642a;
            if (weakReference == null || (context = weakReference.get()) == null || context.getFilesDir() == null || this.f5639a == null || TextUtils.isEmpty(this.f5641a)) {
                return;
            }
            File file = new File(this.f5641a);
            v.a(context, new File(file.getParentFile(), bb.b(file.getAbsolutePath())), new Runnable() { // from class: com.xiaomi.push.bx.a.1
                @Override // java.lang.Runnable
                public void run() {
                    SQLiteDatabase sQLiteDatabaseA = null;
                    try {
                        try {
                            sQLiteDatabaseA = a.this.a();
                            if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                                sQLiteDatabaseA.beginTransaction();
                                a.this.a(context, sQLiteDatabaseA);
                                sQLiteDatabaseA.setTransactionSuccessful();
                            }
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e2) {
                                    e = e2;
                                    com.xiaomi.channel.commonutils.logger.b.a(e);
                                    a.this.a(context);
                                }
                            }
                            bv bvVar = a.this.f5639a;
                            if (bvVar != null) {
                                bvVar.close();
                            }
                        } catch (Throwable th) {
                            if (sQLiteDatabaseA != null) {
                                try {
                                    sQLiteDatabaseA.endTransaction();
                                } catch (Exception e3) {
                                    com.xiaomi.channel.commonutils.logger.b.a(e3);
                                    a.this.a(context);
                                    throw th;
                                }
                            }
                            bv bvVar2 = a.this.f5639a;
                            if (bvVar2 != null) {
                                bvVar2.close();
                            }
                            a.this.a(context);
                            throw th;
                        }
                    } catch (Exception e4) {
                        com.xiaomi.channel.commonutils.logger.b.a(e4);
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Exception e5) {
                                e = e5;
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                                a.this.a(context);
                            }
                        }
                        bv bvVar3 = a.this.f5639a;
                        if (bvVar3 != null) {
                            bvVar3.close();
                        }
                    }
                    a.this.a(context);
                }
            });
        }

        /* renamed from: a, reason: collision with other method in class */
        public boolean m5260a() {
            return this.f5639a == null || TextUtils.isEmpty(this.b) || this.f5642a == null;
        }

        public void a(a aVar) {
            this.f5640a = aVar;
        }

        public void a(Context context, Object obj) {
            bx.a(context).a(this);
        }

        /* renamed from: a, reason: collision with other method in class */
        public String m5259a() {
            return this.f5641a;
        }

        public SQLiteDatabase a() {
            return this.f5639a.getWritableDatabase();
        }

        public void a(Context context) {
            a aVar = this.f5640a;
            if (aVar != null) {
                aVar.a(context, mo5258a());
            }
            b(context);
        }
    }

    private void a() {
        af.a(this.f5634a).b(new af.a() { // from class: com.xiaomi.push.bx.1
            @Override // com.xiaomi.push.af.a
            /* renamed from: a */
            public String mo5248a() {
                return "100957";
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (bx.this.f5636a) {
                    if (bx.this.f5636a.size() > 0) {
                        if (bx.this.f5636a.size() > 1) {
                            bx bxVar = bx.this;
                            bxVar.a(bxVar.f5636a);
                        } else {
                            bx bxVar2 = bx.this;
                            bxVar2.b((a) bxVar2.f5636a.get(0));
                        }
                        bx.this.f5636a.clear();
                        System.gc();
                    }
                }
            }
        }, com.xiaomi.push.service.ah.a(this.f5634a).a(gl.StatDataProcessFrequency.a(), 5));
    }

    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a, reason: collision with other field name */
        private String f5645a;

        /* renamed from: a, reason: collision with other field name */
        private List<String> f5646a;

        /* renamed from: a, reason: collision with other field name */
        private String[] f5647a;
        private List<T> b;
        private String c;
        private String d;

        /* renamed from: e, reason: collision with root package name */
        private String f17843e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.b = new ArrayList();
            this.f5646a = list;
            this.f5645a = str2;
            this.f5647a = strArr;
            this.c = str3;
            this.d = str4;
            this.f17843e = str5;
            this.a = i;
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.bx.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f5646a;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f5646a.size()];
                this.f5646a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.a;
            Cursor cursorQuery = sQLiteDatabase.query(super.b, strArr, this.f5645a, this.f5647a, this.c, this.d, this.f17843e, i > 0 ? String.valueOf(i) : null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    T tA = a(context, cursorQuery);
                    if (tA != null) {
                        this.b.add(tA);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);

        @Override // com.xiaomi.push.bx.a
        public SQLiteDatabase a() {
            return ((a) this).f5639a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        bv bvVarA;
        if (aVar == null) {
            return;
        }
        if (this.f5635a != null) {
            String strM5259a = aVar.m5259a();
            synchronized (this.f5637a) {
                bvVarA = this.f5637a.get(strM5259a);
                if (bvVarA == null) {
                    bvVarA = this.f5635a.a(this.f5634a, strM5259a);
                    this.f5637a.put(strM5259a, bvVarA);
                }
            }
            if (this.f5638a.isShutdown()) {
                return;
            }
            aVar.a(bvVarA, this.f5634a);
            synchronized (this.f5636a) {
                this.f5636a.add(aVar);
                a();
            }
            return;
        }
        throw new IllegalStateException("should exec init method first!");
    }

    public void a(Runnable runnable) {
        if (this.f5638a.isShutdown()) {
            return;
        }
        this.f5638a.execute(runnable);
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5257a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f5635a != null) {
            HashMap map = new HashMap();
            if (this.f5638a.isShutdown()) {
                return;
            }
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.m5260a()) {
                    next.a(a(next.m5259a()), this.f5634a);
                }
                ArrayList arrayList2 = (ArrayList) map.get(next.m5259a());
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(next.m5259a(), arrayList2);
                }
                arrayList2.add(next);
            }
            for (String str : map.keySet()) {
                ArrayList arrayList3 = (ArrayList) map.get(str);
                if (arrayList3 != null && arrayList3.size() > 0) {
                    c cVar = new c(str, arrayList3);
                    cVar.a(((a) arrayList3.get(0)).f5639a, this.f5634a);
                    this.f5638a.execute(cVar);
                }
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private bv a(String str) {
        bv bvVarA = this.f5637a.get(str);
        if (bvVarA == null) {
            synchronized (this.f5637a) {
                if (bvVarA == null) {
                    bvVarA = this.f5635a.a(this.f5634a, str);
                    this.f5637a.put(str, bvVarA);
                }
            }
        }
        return bvVarA;
    }
}
