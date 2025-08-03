package com.mob.tools.a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.C5340r;
import com.mob.commons.o;
import com.mob.commons.u;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class d {
    private static d a = null;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f17713e = false;
    private Context b;
    private volatile String c;
    private HashMap<String, Object> d;
    private volatile File h;
    private byte[] f = new byte[0];
    private AtomicBoolean g = new AtomicBoolean(false);
    private ConcurrentLinkedQueue<CountDownLatch> i = new ConcurrentLinkedQueue<>();
    private volatile String j = null;

    private d(Context context) {
        this.b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        try {
            String str = (String) com.mob.commons.b.b(o.a("002$fgfg"), (Object) null);
            return str == null ? (String) com.mob.commons.b.b(o.a("009=fgfcdhehfddeBdOdg1c"), (Object) null) : str;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public CountDownLatch c() {
        ConcurrentLinkedQueue<CountDownLatch> concurrentLinkedQueue = this.i;
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return null;
        }
        try {
            return this.i.peek();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public static boolean b() {
        return f17713e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(String str) {
        return (TextUtils.isEmpty(a(str)) || TextUtils.isEmpty(b(str))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("#")) == null || strArrSplit.length != 2) {
            return null;
        }
        return strArrSplit[1];
    }

    public static d a(Context context) {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d(context);
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ResHelper.getDataCacheFile(this.b, str);
    }

    public CountDownLatch a() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            MobLog.getInstance().d("dhs ofr: " + countDownLatch, new Object[0]);
            this.i.offer(countDownLatch);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        u.f.execute(new Runnable() { // from class: com.mob.tools.a.d.1
            @Override // java.lang.Runnable
            public void run() {
                NLog mobLog;
                d dVar;
                String str;
                boolean zA;
                synchronized (d.this.f) {
                    com.mob.tools.b.a.c.set(Boolean.TRUE);
                    try {
                        d dVar2 = d.this;
                        dVar2.c = dVar2.e();
                        NLog mobLog2 = MobLog.getInstance();
                        StringBuilder sb = new StringBuilder();
                        sb.append("dhs stch: ");
                        d dVar3 = d.this;
                        sb.append(dVar3.d(dVar3.c));
                        mobLog2.d(sb.toString(), new Object[0]);
                        dVar = d.this;
                    } catch (Throwable th2) {
                        try {
                            MobLog.getInstance().d("dhs oops: " + th2.getMessage(), new Object[0]);
                            MobLog.getInstance().d(th2);
                            MobLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                            countDownLatch.countDown();
                            try {
                                d.this.i.remove(countDownLatch);
                            } catch (Throwable th3) {
                                th = th3;
                                mobLog = MobLog.getInstance();
                                mobLog.d(th);
                                com.mob.tools.b.a.c.set(Boolean.FALSE);
                                return;
                            }
                        } finally {
                        }
                    }
                    if (!dVar.d(dVar.c)) {
                        boolean unused = d.f17713e = false;
                        MobLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                        countDownLatch.countDown();
                        try {
                            d.this.i.remove(countDownLatch);
                        } catch (Throwable th4) {
                            MobLog.getInstance().d(th4);
                        }
                        return;
                    }
                    d dVar4 = d.this;
                    String strA = dVar4.a(dVar4.c);
                    if (DH.SyncMtd.isInMainProcess()) {
                        str = strA;
                    } else {
                        String strReplace = DH.SyncMtd.getCurrentProcessName() + "";
                        String packageName = DH.SyncMtd.getPackageName();
                        if (strReplace.contains(packageName)) {
                            strReplace = strReplace.replace(packageName, "");
                        }
                        str = strA + "_" + strReplace.replace(Constants.COLON_SEPARATOR, "");
                        try {
                            MobLog.getInstance().d("dhs cld nm " + str, new Object[0]);
                        } catch (Throwable unused2) {
                        }
                    }
                    File fileC = d.this.c(str);
                    boolean z = fileC != null && fileC.exists() && fileC.isFile();
                    MobLog.getInstance().d("dhs cac: " + z, new Object[0]);
                    String strMD5 = Data.MD5(fileC);
                    if (z) {
                        boolean zEquals = strA.equals(strMD5);
                        MobLog.getInstance().d("dhs m5: " + zEquals, new Object[0]);
                        if (zEquals) {
                            MobLog.getInstance().d("dhs tbm: " + d.this.g.get(), new Object[0]);
                            zA = d.this.g.compareAndSet(false, true);
                        } else {
                            d dVar5 = d.this;
                            zA = dVar5.a(dVar5.b(dVar5.c), fileC);
                        }
                    } else {
                        d dVar6 = d.this;
                        zA = dVar6.a(dVar6.b(dVar6.c), fileC);
                        strMD5 = Data.MD5(fileC);
                    }
                    MobLog.getInstance().d("dhs cl: " + zA + ", tm5: " + strMD5 + ", cm5: " + d.this.j, new Object[0]);
                    if (!zA || TextUtils.isEmpty(strMD5) || strMD5.equals(d.this.j)) {
                        MobLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                        countDownLatch.countDown();
                        try {
                            d.this.i.remove(countDownLatch);
                        } catch (Throwable th5) {
                            th = th5;
                            mobLog = MobLog.getInstance();
                            mobLog.d(th);
                            com.mob.tools.b.a.c.set(Boolean.FALSE);
                            return;
                        }
                    } else {
                        HashMap mapA = d.this.a(fileC);
                        if (mapA == null || mapA.isEmpty()) {
                            MobLog.getInstance().d("dhs l fail", new Object[0]);
                        } else {
                            MobLog.getInstance().d("dhs l succ", new Object[0]);
                            f fVar = new f(mapA);
                            if (d.f17713e && d.this.h != null && d.this.h.exists()) {
                                try {
                                    if (d.this.h.delete()) {
                                        MobLog.getInstance().d("dhs dof succ", new Object[0]);
                                    } else {
                                        MobLog.getInstance().d("dhs dof fail", new Object[0]);
                                    }
                                } catch (Throwable th6) {
                                    MobLog.getInstance().d(th6);
                                    MobLog.getInstance().d("dhs dof fail-e", new Object[0]);
                                }
                            }
                            d.this.h = fileC;
                            d.this.j = Data.MD5(fileC);
                            boolean unused3 = d.f17713e = c.a(d.this.b).b(fVar);
                            MobLog.getInstance().d("dhs fin", new Object[0]);
                        }
                        MobLog.getInstance().d("dhs ctd: " + countDownLatch, new Object[0]);
                        countDownLatch.countDown();
                        d.this.i.remove(countDownLatch);
                    }
                    com.mob.tools.b.a.c.set(Boolean.FALSE);
                    return;
                }
            }
        });
        return countDownLatch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> a(File file) {
        String strFromHashMap = HashonHelper.fromHashMap(new HashMap());
        HashMap<String, Object> map = new HashMap<>();
        if (this.d == null) {
            HashMap<String, Object> map2 = new HashMap<>();
            this.d = map2;
            map2.put("cacheMap", new ConcurrentHashMap());
            this.d.put("invokeTimesMap", new ConcurrentHashMap());
            this.d.put("expireTimeMap", new ConcurrentHashMap());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            com.mob.commons.cc.a.a(MobSDK.getContext(), file.getAbsolutePath(), strFromHashMap, map, this.d);
            MobLog.getInstance().d(TextUtils.isEmpty(null) ? String.format("dhs l %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)) : null, new Object[0]);
        } catch (Throwable th) {
            try {
                str = "dhs l e: " + th.getMessage();
                com.mob.commons.f.a().a(6, th);
                MobLog.getInstance().d(th);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                str = String.format("dhs l %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            }
            MobLog.getInstance().d(str, new Object[0]);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str) || (strArrSplit = str.split("#")) == null || strArrSplit.length != 2) {
            return null;
        }
        return strArrSplit[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, File file) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str) && file != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                if (file.exists()) {
                    file.delete();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                MobLog.getInstance().d("dhs d...", new Object[0]);
                new NetworkHelper().download(str, fileOutputStream, null);
                MobLog.getInstance().d(TextUtils.isEmpty(null) ? String.format("dhs d %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)) : null, new Object[0]);
                C5340r.a(fileOutputStream);
                return true;
            } catch (Throwable th2) {
                th = th2;
                try {
                    str = "dhs d e: " + th.getMessage();
                    MobLog.getInstance().d(th);
                    if (TextUtils.isEmpty(str)) {
                        str = String.format("dhs d %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                    MobLog.getInstance().d(str, new Object[0]);
                    C5340r.a(fileOutputStream);
                    return false;
                } catch (Throwable th3) {
                    if (TextUtils.isEmpty(str)) {
                        str = String.format("dhs d %d", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
                    }
                    MobLog.getInstance().d(str, new Object[0]);
                    C5340r.a(fileOutputStream);
                    throw th3;
                }
            }
        }
        return false;
    }
}
