package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.push.ag;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class ga {

    /* renamed from: a, reason: collision with other field name */
    private static ag f5951a = new ag(true);
    private static volatile int a = -1;

    /* renamed from: a, reason: collision with other field name */
    private static long f5950a = System.currentTimeMillis();

    /* renamed from: a, reason: collision with other field name */
    private static final Object f5953a = new Object();

    /* renamed from: a, reason: collision with other field name */
    private static List<a> f5955a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a, reason: collision with other field name */
    private static String f5954a = "";

    /* renamed from: a, reason: collision with other field name */
    private static com.xiaomi.push.providers.a f5952a = null;

    public static class a {
        public int a;

        /* renamed from: a, reason: collision with other field name */
        public long f5956a;

        /* renamed from: a, reason: collision with other field name */
        public String f5957a;
        public int b;

        /* renamed from: b, reason: collision with other field name */
        public long f5958b;

        /* renamed from: b, reason: collision with other field name */
        public String f5959b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f5957a = str;
            this.f5956a = j;
            this.a = i;
            this.b = i2;
            this.f5959b = str2;
            this.f5958b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f5957a, this.f5957a) && TextUtils.equals(aVar.f5959b, this.f5959b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f5956a - this.f5956a) <= 5000;
        }
    }

    private static int b(Context context) {
        aw awVarM5209a = av.m5209a();
        if (awVarM5209a == null) {
            return -1;
        }
        return awVarM5209a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f6323a) {
                SQLiteDatabase writableDatabase = m5517a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                try {
                    for (a aVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("package_name", aVar.f5957a);
                        contentValues.put("message_ts", Long.valueOf(aVar.f5956a));
                        contentValues.put(com.umeng.analytics.pro.am.T, Integer.valueOf(aVar.a));
                        contentValues.put("bytes", Long.valueOf(aVar.f5958b));
                        contentValues.put("rcv", Integer.valueOf(aVar.b));
                        contentValues.put("imsi", aVar.f5959b);
                        writableDatabase.insert(com.umeng.analytics.pro.d.F, null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m5520a(Context context) {
        a = b(context);
    }

    public static int a(Context context) {
        if (a == -1) {
            a = b(context);
        }
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static synchronized String m5518a(Context context) {
        if (TextUtils.isEmpty(f5954a)) {
            return "";
        }
        return f5954a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized void m5521a(String str) {
        if (!j.m5696d() && !TextUtils.isEmpty(str)) {
            f5954a = str;
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(final Context context, String str, long j, boolean z, long j2) {
        int iA;
        boolean zIsEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (iA = a(context))) {
            return;
        }
        synchronized (f5953a) {
            zIsEmpty = f5955a.isEmpty();
            a(new a(str, j2, iA, z ? 1 : 0, iA == 0 ? m5518a(context) : "", j));
        }
        if (zIsEmpty) {
            f5951a.a(new ag.b() { // from class: com.xiaomi.push.ga.1
                @Override // com.xiaomi.push.ag.b
                public void b() {
                    ArrayList arrayList;
                    synchronized (ga.f5953a) {
                        arrayList = new ArrayList(ga.f5955a);
                        ga.f5955a.clear();
                    }
                    ga.b(context, arrayList);
                }
            }, 5000L);
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f5950a;
            f5950a = j2;
            if (j2 - j3 > 30000 && j > ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m5517a(Context context) {
        com.xiaomi.push.providers.a aVar = f5952a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f5952a = aVar2;
        return aVar2;
    }

    public static int a(String str) {
        try {
            return str.getBytes(Platform.UTF_8).length;
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : f5955a) {
            if (aVar2.a(aVar)) {
                aVar2.f5958b += aVar.f5958b;
                return;
            }
        }
        f5955a.add(aVar);
    }
}
