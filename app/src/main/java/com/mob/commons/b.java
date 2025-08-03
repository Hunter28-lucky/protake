package com.mob.commons;

import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.clt.AtClt;
import com.mob.commons.clt.BSClt;
import com.mob.commons.clt.DEClt;
import com.mob.commons.clt.DEVClt;
import com.mob.commons.clt.DLClt;
import com.mob.commons.clt.LClt;
import com.mob.commons.clt.LOClt;
import com.mob.commons.clt.PClt;
import com.mob.commons.clt.PSClt;
import com.mob.commons.clt.PaClt;
import com.mob.commons.clt.SMClt;
import com.mob.commons.clt.VplClt;
import com.mob.commons.clt.WClt;
import com.mob.commons.clt.WLClt;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class b {
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f17669e = new AtomicBoolean(false);
    private static volatile HashMap<String, Object> f = null;
    public static volatile HashSet<Class<? extends com.mob.commons.a.a>> a = new HashSet<>();
    private static ConcurrentHashMap<String, Object> g = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, Object> h = new ConcurrentHashMap<>();
    private static CountDownLatch i = new CountDownLatch(1);
    private static CountDownLatch j = new CountDownLatch(1);
    public static volatile boolean b = false;
    private static volatile boolean k = false;

    public static boolean c() {
        return (((Integer) a(i.a("002Wfmfj"), 0)).intValue() == 1) || s.a();
    }

    public static boolean d() {
        return c();
    }

    public static ConcurrentHashMap<String, Object> e() {
        return h;
    }

    public static void f() {
        if (a()) {
            c(3);
        }
    }

    private static HashSet<Class<? extends com.mob.commons.a.a>> j() {
        HashSet<Class<? extends com.mob.commons.a.a>> hashSet = new HashSet<>();
        try {
            hashSet.add(AtClt.class);
        } catch (Throwable unused) {
        }
        try {
            hashSet.add(BSClt.class);
        } catch (Throwable unused2) {
        }
        try {
            hashSet.add(DEClt.class);
        } catch (Throwable unused3) {
        }
        try {
            hashSet.add(DEVClt.class);
        } catch (Throwable unused4) {
        }
        try {
            hashSet.add(DLClt.class);
        } catch (Throwable unused5) {
        }
        try {
            hashSet.add(LClt.class);
        } catch (Throwable unused6) {
        }
        try {
            hashSet.add(LOClt.class);
        } catch (Throwable unused7) {
        }
        try {
            hashSet.add(PaClt.class);
        } catch (Throwable unused8) {
        }
        try {
            hashSet.add(com.mob.commons.a.b.class);
        } catch (Throwable unused9) {
        }
        try {
            hashSet.add(PClt.class);
        } catch (Throwable unused10) {
        }
        try {
            hashSet.add(PSClt.class);
        } catch (Throwable unused11) {
        }
        try {
            hashSet.add(com.mob.commons.a.c.class);
        } catch (Throwable unused12) {
        }
        try {
            hashSet.add(SMClt.class);
        } catch (Throwable unused13) {
        }
        try {
            hashSet.add(VplClt.class);
        } catch (Throwable unused14) {
        }
        try {
            hashSet.add(WClt.class);
        } catch (Throwable unused15) {
        }
        try {
            hashSet.add(WLClt.class);
        } catch (Throwable unused16) {
        }
        return hashSet;
    }

    private static void k() {
        Object obj = l.i;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    private static synchronized void d(boolean z) {
        HashSet<Class<? extends com.mob.commons.a.a>> hashSetJ = j();
        try {
            Iterator<Class<? extends com.mob.commons.a.a>> it = hashSetJ.iterator();
            while (it.hasNext()) {
                Class<? extends com.mob.commons.a.a> next = it.next();
                try {
                    if (!a.contains(next)) {
                        com.mob.commons.a.a aVarNewInstance = next.newInstance();
                        if (z || c(aVarNewInstance.b())) {
                            if (aVarNewInstance.e()) {
                                a.add(next);
                            }
                        }
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
            hashSetJ.clear();
            MobLog.getInstance().d("clt(" + z + ") over", new Object[0]);
        } catch (Throwable th2) {
            hashSetJ.clear();
            throw th2;
        }
    }

    public static <T> T b(String str, T t) {
        if (TextUtils.isEmpty(str)) {
            return t;
        }
        if (f != null) {
            return (T) a(f, str, t);
        }
        return (T) a(HashonHelper.fromJson(w.a().b()), str, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(boolean z) {
        if (b()) {
            MobLog.getInstance().d("b db st", new Object[0]);
            e.a((MobProduct) null);
            m.a().b();
            d(z);
        }
    }

    public static void a(CountDownLatch countDownLatch) {
        b(countDownLatch);
    }

    public static <T> T a(String str, T t) {
        if (TextUtils.isEmpty(str) || f == null) {
            return t;
        }
        if (b(f)) {
            f.clear();
            f = new HashMap<>();
            c(2);
        }
        return (T) ResHelper.forceCast(f.get(str), t);
    }

    public static boolean b() {
        return ((Integer) a(i.a("004Sfigefmfm"), 0)).intValue() == 1;
    }

    private static boolean c(String str) {
        List list = (List) a(i.a("002Gfigf"), (Object) null);
        return (list == null || list.size() == 0 || !list.contains(str)) ? false : true;
    }

    private static void b(CountDownLatch countDownLatch) {
        HashMap mapFromJson = HashonHelper.fromJson(w.a().b());
        if (b((HashMap<String, Object>) mapFromJson)) {
            w.a().b(null);
            mapFromJson = null;
        }
        if (a()) {
            a((HashMap<String, Object>) mapFromJson, false);
            if (mapFromJson != null && !mapFromJson.isEmpty()) {
                MobLog.getInstance().d("g ch: y", new Object[0]);
                boolean z = System.currentTimeMillis() - w.a().b(w.u, 0L) < 5000;
                MobLog.getInstance().d("g ch fre: " + z, new Object[0]);
                if (!z) {
                    c(2);
                }
                if (countDownLatch != null) {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        MobLog.getInstance().d("g dhs_w cdl: " + countDownLatch, new Object[0]);
                        countDownLatch.await(3500L, TimeUnit.MILLISECONDS);
                        MobLog.getInstance().d("g dhs_w end, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                }
                a(true, false, z, 2);
                return;
            }
            MobLog.getInstance().d("g ch: n", new Object[0]);
            c(1);
        }
    }

    private static void c(final int i2) {
        if (f17669e.compareAndSet(false, true)) {
            final String str = String.format(i.a("005<iihmjkljhi"), Integer.valueOf(i2));
            if (i2 == 2) {
                u.c.execute(new com.mob.tools.utils.e() { // from class: com.mob.commons.b.4
                    @Override // com.mob.tools.utils.e
                    public void a() {
                        com.mob.tools.b.a.b.set(Boolean.TRUE);
                        if (!TextUtils.isEmpty("M-")) {
                            Thread.currentThread().setName("M-" + str);
                        }
                        try {
                            b.b(new com.mob.tools.utils.b<HashMap<String, Object>>() { // from class: com.mob.commons.b.4.1
                                @Override // com.mob.tools.utils.b
                                public void a(HashMap<String, Object> map) {
                                    try {
                                        b.b(map, i2);
                                    } finally {
                                        com.mob.tools.b.a.b.set(Boolean.FALSE);
                                        b.f17669e.set(false);
                                    }
                                }
                            });
                            com.mob.tools.b.a.b.set(Boolean.FALSE);
                        } catch (Throwable unused) {
                            b.f17669e.set(false);
                        }
                    }
                });
                return;
            }
            if (!TextUtils.isEmpty("M-")) {
                Thread.currentThread().setName("M-" + str);
            }
            try {
                b(new com.mob.tools.utils.b<HashMap<String, Object>>() { // from class: com.mob.commons.b.5
                    @Override // com.mob.tools.utils.b
                    public void a(HashMap<String, Object> map) {
                        try {
                            b.b(map, i2);
                        } finally {
                            com.mob.tools.b.a.b.set(Boolean.FALSE);
                            b.f17669e.set(false);
                        }
                    }
                });
                com.mob.tools.b.a.b.set(Boolean.FALSE);
            } catch (Throwable unused) {
                f17669e.set(false);
            }
        }
    }

    private static <T> T a(HashMap<String, Object> map, String str, T t) {
        return (TextUtils.isEmpty(str) || b(map) || !a(map)) ? t : (T) ResHelper.forceCast(map.get(str), t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(String str) {
        String strB;
        File file;
        File file2 = null;
        try {
            strB = C5340r.b(str);
            file = new File(MobSDK.getContext().getFilesDir(), i.a("003Shihegf"));
        } catch (Throwable unused) {
        }
        try {
            if (!g.a().b() || TextUtils.isEmpty(strB)) {
                ResHelper.deleteFileAndFolder(file);
            } else {
                if (!c()) {
                    k();
                    return;
                }
                HashMap<String, Object> mapF = q.f();
                mapF.put(i.a("007lk]fjhifggefm"), String.valueOf(com.mob.commons.cc.a.a()));
                ArrayList arrayList = (ArrayList) ((HashMap) new NetCommunicator(1024, "9e87e8d4b8f52f2916d0fb4342aa6b54a81a05666d0bdb23cc5ebf3a07440bc3976adff1ce11c64ddcdbfc017920648217196d51e3165e780e58b5460c525ee9", "13bda4b87eb42ab9e64e6b4f3d17cf8005a4ae94af37bc9fd76ebd91a828f017c81bd63cbe2924e361e20003b9e5f47cdac1f5fba5fca05730a32c5c65869590287207e79a604a2aac429e55f0d35c211367bd226dd5e57df7810f036071854aa1061a0f34b418b9178895a531107c652a428cfa6ecfa65333580ae7e0edf0e1").requestSynchronized(mapF, strB, false)).get(i.a("004TgffghiTf"));
                synchronized (l.i) {
                    h.clear();
                    h.put(i.a("0025gf8f"), arrayList);
                }
            }
        } catch (Throwable unused2) {
            file2 = file;
            if (file2 != null) {
                try {
                    ResHelper.deleteFileAndFolder(file2);
                } catch (Throwable unused3) {
                }
            }
            k();
        }
        k();
    }

    private static boolean a(HashMap<String, Object> map) {
        return map == null || ((Integer) ResHelper.forceCast(map.get(i.a("002f1ge")), 0)).intValue() == 0;
    }

    public static boolean a() {
        return ((Integer) a(i.a("002f]ge"), 0)).intValue() == 0;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && a() && b() && ((Integer) a(str, 0)).intValue() != 0;
    }

    private static void a(HashMap<String, Object> map, boolean z) {
        f = new HashMap<>();
        if (map != null) {
            f.putAll(map);
        }
        try {
            if (z) {
                i.countDown();
                j.countDown();
            } else {
                i.countDown();
            }
        } catch (Throwable unused) {
        }
    }

    private static void a(final boolean z, final boolean z2, final boolean z3, final int i2) {
        new com.mob.tools.utils.f("PY-B" + i2) { // from class: com.mob.commons.b.3
            @Override // com.mob.tools.utils.f
            public void a() {
                MobLog.getInstance().d("b enter:" + Process.myPid() + ", lbms: " + b.k + ", fc" + z + ", ol: " + z2 + ", gf: " + z3 + ", in: " + i2, new Object[0]);
                if (!b.k) {
                    MobLog.getInstance().d("b lk st: " + Process.myPid(), new Object[0]);
                    l.a(l.a(l.f), new k() { // from class: com.mob.commons.b.3.1
                        @Override // com.mob.commons.k
                        public boolean a(FileLocker fileLocker) {
                            boolean unused = b.k = true;
                            MobLog.getInstance().d("b lk: " + Process.myPid() + ", proc st", new Object[0]);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            b.c(z2);
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            if (!z || z3) {
                                b.b(i2);
                            }
                            MobLog.getInstance().d("b lk: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", release: n", new Object[0]);
                            Looper.prepare();
                            Looper.loop();
                            return true;
                        }
                    });
                    return;
                }
                MobLog.getInstance().d("b lked already: " + Process.myPid(), new Object[0]);
                b.c(z2);
                if (!z || z3) {
                    b.b(i2);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2) {
        MobLog.getInstance().d("b ob st", new Object[0]);
        if (a() && b()) {
            final String str = (String) a("sbr", (Object) null);
            if (TextUtils.isEmpty(str)) {
                k();
            } else if (i2 == 3 || d.compareAndSet(false, true)) {
                new com.mob.tools.utils.f("DS-" + i2) { // from class: com.mob.commons.b.1
                    @Override // com.mob.tools.utils.f
                    public void a() {
                        l.a(l.a(l.f17681e), false, new k() { // from class: com.mob.commons.b.1.1
                            @Override // com.mob.commons.k
                            public boolean a(FileLocker fileLocker) {
                                try {
                                    synchronized (b.h) {
                                        b.d(str);
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    MobLog.getInstance().d(th);
                                    return false;
                                }
                            }
                        });
                    }
                }.start();
            }
            if (MobSDK.getDomain() != InternationalDomain.DEFAULT || MobSDK.checkV6()) {
                return;
            }
            c.a(new com.mob.tools.utils.b<Void>() { // from class: com.mob.commons.b.2
                @Override // com.mob.tools.utils.b
                public void a(Void r1) {
                }
            });
            return;
        }
        k();
    }

    private static void a(Object obj) {
        try {
            HashMap map = new HashMap();
            map.put(i.a("004Ggffghi8f"), obj);
            File dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), i.a("005JgnGn0figffg"));
            ResHelper.saveObjectToFile(dataCacheFile.getPath(), Data.AES128Encode(i.a("016MinimlelkjgkgkjiljjhgfhhefiIj0hjfg"), HashonHelper.fromHashMap(map)));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(HashMap<String, Object> map, int i2) {
        if (map != null) {
            a(map, true);
            com.mob.tools.b.a.b.set(Boolean.FALSE);
            CountDownLatch countDownLatchA = com.mob.tools.a.d.a(MobSDK.getContext()).a();
            if (countDownLatchA != null) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    MobLog.getInstance().d("ge dhs_w cdl: " + countDownLatchA, new Object[0]);
                    countDownLatchA.await(3500L, TimeUnit.MILLISECONDS);
                    MobLog.getInstance().d("ge dhs_w end, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
            a(false, true, true, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final com.mob.tools.utils.b<HashMap<String, Object>> bVar) {
        com.mob.tools.b.a.b.set(Boolean.TRUE);
        DH.requester(MobSDK.getContext()).checkNetworkAvailable().getDetailNetworkTypeForStatic().isPackageInstalled(i.a("022Efige@nMgnhhgegehhgf!k=gnfhfmKjWfjgefgLj3gnhhYn8hi")).checkUA().usbEnable().devEnable().vpn().isWifiProxy().isRooted().cx().debugable().request(new DH.DHResponder() { // from class: com.mob.commons.b.6
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                com.mob.tools.b.a.b.set(Boolean.TRUE);
                try {
                    HashMap mapB = b.b(dHResponse);
                    long j2 = 2;
                    long j3 = 1;
                    while (true) {
                        if (mapB != null && !mapB.isEmpty()) {
                            break;
                        }
                        try {
                            Thread.sleep(1000 * j3);
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                        }
                        mapB = b.b(dHResponse);
                        if (mapB == null || mapB.isEmpty()) {
                            boolean zCheckNetworkAvailable = dHResponse.checkNetworkAvailable();
                            if (zCheckNetworkAvailable) {
                                if (j2 <= 0) {
                                    break;
                                } else {
                                    j2--;
                                }
                            }
                            j3 *= 2;
                            if (!zCheckNetworkAvailable && j3 < 8) {
                                j3 = 8;
                            }
                            if (j3 > 300) {
                                j3 = 8;
                            }
                        }
                    }
                    bVar.a(mapB);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                    bVar.a(null);
                }
            }
        });
    }

    private static boolean b(HashMap<String, Object> map) {
        if (map == null) {
            return false;
        }
        long jLongValue = ((Long) ResHelper.forceCast(map.get(i.a("010jklAfgfiOkKgkfgHnk")), 0L)).longValue();
        return jLongValue != 0 && SystemClock.elapsedRealtime() - jLongValue >= 86400000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Object> b(DH.DHResponse dHResponse) {
        try {
            if (!dHResponse.checkNetworkAvailable()) {
                return null;
            }
            String packageName = DH.SyncMtd.getPackageName();
            HashMap<String, Object> mapA = q.a(dHResponse.getDetailNetworkTypeForStatic());
            String appkey = MobSDK.getAppkey();
            mapA.put(i.a("006Gfh)gg2flLk^fk"), appkey);
            mapA.put(i.a("006=fh$ggg+flhh"), packageName);
            int i2 = 1;
            mapA.put(i.a("003 fhhhhi"), String.valueOf(dHResponse.isPackageInstalled(new int[0]) ? 1 : -1));
            mapA.put(i.a("002fYhi"), String.valueOf(System.currentTimeMillis()));
            int privacyGrantedStatus = MobSDK.getPrivacyGrantedStatus();
            if (privacyGrantedStatus != -1) {
                mapA.put(i.a("0093fghiglhhfj3kkAijJg"), String.valueOf(privacyGrantedStatus == 1));
            }
            mapA.put(i.a("002l7kg"), String.valueOf(MobSDK.checkV6() ? 1 : -1));
            mapA.put(i.a("002@fefi"), String.valueOf(dHResponse.checkUA() ? 1 : 0));
            mapA.put(i.a("002Hfe5j"), String.valueOf(dHResponse.usbEnable() ? 1 : 0));
            mapA.put(i.a("002jl"), String.valueOf(dHResponse.devEnable() ? 1 : 0));
            mapA.put(i.a("002lg"), String.valueOf(dHResponse.vpn() ? 1 : 0));
            mapA.put(i.a("002MhfUg"), String.valueOf(dHResponse.isWifiProxy() ? 1 : 0));
            mapA.put(i.a("002BfjEf"), String.valueOf(dHResponse.isRooted() ? 1 : 0));
            mapA.put(i.a("002DfnDg"), String.valueOf(dHResponse.cx() ? 1 : 0));
            String strA = i.a("002FfhGj");
            if (!dHResponse.debugable()) {
                i2 = 0;
            }
            mapA.put(strA, String.valueOf(i2));
            String strHttpGet = new NetworkHelper().httpGet(c.a(c.b) + i.a("007ilOjgOiMhhfihj"), mapA, NetCommunicator.getCommonDefaultHeaders());
            HashMap mapFromJson = HashonHelper.fromJson(strHttpGet);
            if (mapFromJson == null) {
                return null;
            }
            if ("200".equals(String.valueOf(mapFromJson.get(i.a("006Jhi(fBfh,fQfehi"))))) {
                byte[] bArrRawMD5 = Data.rawMD5((appkey + Constants.COLON_SEPARATOR + packageName + Constants.COLON_SEPARATOR + mapFromJson.get(i.a("009f=fgCnkChi f8fh<ng"))).getBytes("utf-8"));
                String str = (String) ResHelper.forceCast(mapFromJson.get(i.a("002Yhifi")));
                if (str != null) {
                    String str2 = new String(Data.AES128Decode(bArrRawMD5, Base64.decode(str, 2)), "utf-8");
                    MobLog.getInstance().d("sw: " + str2, new Object[0]);
                    HashMap<String, Object> mapFromJson2 = HashonHelper.fromJson(str2);
                    if (mapFromJson2 != null && !mapFromJson2.isEmpty()) {
                        mapFromJson2.put(i.a("010jkl8fgfi_kRgkfgDnk"), Long.valueOf(SystemClock.elapsedRealtime()));
                        w.a().b(str2);
                        w.a().a(w.u, System.currentTimeMillis());
                        a(mapFromJson2.remove(i.a("0119fggfgf+k]hhfhgfikfhfihi")));
                        return mapFromJson2;
                    }
                    throw new Throwable("RS is illegal: " + strHttpGet);
                }
                throw new Throwable("RS is illegal: " + strHttpGet);
            }
            throw new Throwable("RS is illegal: " + strHttpGet);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            try {
                w.a().b(null);
            } catch (Throwable unused) {
            }
            return null;
        }
    }
}
