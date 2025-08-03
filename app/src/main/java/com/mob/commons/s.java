package com.mob.commons;

import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.OperationCallback;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.UIHandler;
import io.jsonwebtoken.Claims;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class s {
    private static volatile boolean a = true;
    private static volatile int b = -1;
    private static AtomicBoolean c = new AtomicBoolean(false);
    private static AtomicBoolean d = new AtomicBoolean(false);

    public static int c() {
        MobLog.getInstance().d("get py grtd status: " + b, new Object[0]);
        return b;
    }

    public static int d() {
        MobLog.getInstance().d("get py grtd status mem: " + b, new Object[0]);
        if (b != -1) {
            return b;
        }
        int iB = w.a().b(w.i, -1);
        MobLog.getInstance().d("get py grtd status cache: " + iB, new Object[0]);
        return iB;
    }

    public static String e() {
        return "jvr<1fgxsowakcet{mpzqnWPKUVCN0dy2iuhFDHQ|GTXERO:43YJ7lZ;/MI>\"@8A?9[)_]5=.(S'6~盺朼L\\-";
    }

    public static CountDownLatch f() {
        if (d.getAndSet(true)) {
            return new CountDownLatch(0);
        }
        com.mob.tools.a.k.a(MobSDK.getContext()).a(com.mob.tools.a.k.a(MobSDK.getContext()).b());
        return com.mob.tools.a.c.a(MobSDK.getContext()).a(com.mob.tools.a.c.a(MobSDK.getContext()).d());
    }

    private static void h() {
        try {
            ReflectHelper.invokeStaticMethod(ReflectHelper.importClass("com.mob.mgs.impl.GuardImpl"), o.a("004Ndedkde)d"), new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    private static void i() {
        try {
            ServerSocketChannel serverSocketChannelOpen = ServerSocketChannel.open();
            serverSocketChannelOpen.configureBlocking(false);
            try {
                serverSocketChannelOpen.socket().bind(new InetSocketAddress(37926));
                m.a = false;
                serverSocketChannelOpen.close();
            } catch (Throwable unused) {
                m.a = true;
            }
        } catch (Throwable unused2) {
        }
    }

    private static void j() {
        i.a().a(new h() { // from class: com.mob.commons.s.3
            @Override // com.mob.commons.h
            public void a(boolean z, boolean z2, long j) {
                if (z) {
                    MobLog.getInstance().d("fg.", new Object[0]);
                    boolean unused = s.a = true;
                } else {
                    MobLog.getInstance().d("bg.", new Object[0]);
                    boolean unused2 = s.a = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, boolean z2) {
        if (z) {
            CountDownLatch countDownLatchF = f();
            MobLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? "main" : Claims.SUBJECT, new Object[0]);
            if (z2) {
                b.f();
            } else {
                b(countDownLatchF);
            }
        }
    }

    public static void a(final boolean z) {
        u.c.execute(new com.mob.tools.utils.e() { // from class: com.mob.commons.s.1
            @Override // com.mob.tools.utils.e
            public void a() {
                com.mob.tools.b.a.b.set(Boolean.TRUE);
                if (!TextUtils.isEmpty("M-")) {
                    Thread.currentThread().setName("M-" + o.a("0045ghiihigl"));
                }
                boolean zA = w.a().a(w.h, n.f17685e);
                int iB = w.a().b(w.i, -1);
                if (iB != -1) {
                    int unused = s.b = iB;
                }
                Boolean boolIsGpAvailable = MobSDK.isGpAvailable();
                if ((!zA || s.b == 1) && boolIsGpAvailable != null && boolIsGpAvailable.booleanValue()) {
                    s.b(true, z);
                } else {
                    s.b(false, z);
                }
                NLog mobLog = MobLog.getInstance();
                StringBuilder sb = new StringBuilder();
                sb.append(z ? o.a("0021dh+i") : "");
                sb.append("init cfg over. py ");
                sb.append(s.b);
                mobLog.d(sb.toString(), new Object[0]);
                com.mob.tools.b.a.b.set(Boolean.FALSE);
            }
        });
    }

    public static boolean a() {
        return a;
    }

    public static void a(final boolean z, final OperationCallback<Void> operationCallback) {
        b = z ? 1 : 0;
        MobLog.getInstance().d("submit py: " + z, new Object[0]);
        new com.mob.tools.utils.f(o.a("004Jghiihigk")) { // from class: com.mob.commons.s.4
            @Override // com.mob.tools.utils.f
            public void a() {
                w.a().a(w.i, z ? 1 : 0);
                if (!z) {
                    if (operationCallback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.s.4.4
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                operationCallback.onComplete(null);
                                return false;
                            }
                        });
                        return;
                    }
                    return;
                }
                CountDownLatch countDownLatchF = s.f();
                Boolean boolIsGpAvailable = MobSDK.isGpAvailable();
                if (boolIsGpAvailable == null || !boolIsGpAvailable.booleanValue()) {
                    MobLog.getInstance().w("Service unavailable due to Google Play Services is unavailable!");
                    if (operationCallback != null) {
                        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.s.4.1
                            @Override // android.os.Handler.Callback
                            public boolean handleMessage(Message message) {
                                operationCallback.onFailure(ForbThrowable.obtainGpThrowable());
                                return false;
                            }
                        });
                        return;
                    }
                    return;
                }
                if (operationCallback != null) {
                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.commons.s.4.2
                        @Override // android.os.Handler.Callback
                        public boolean handleMessage(Message message) {
                            operationCallback.onComplete(null);
                            return false;
                        }
                    });
                }
                MobLog.getInstance().d(DH.SyncMtd.isInMainProcess() ? "main" : Claims.SUBJECT, new Object[0]);
                s.b(countDownLatchF);
                DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: com.mob.commons.s.4.3
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        try {
                            s.b(z, dHResponse.getDetailNetworkTypeForStatic());
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                            try {
                                s.b(z, dHResponse.getDetailNetworkTypeForStatic());
                            } catch (Throwable th2) {
                                MobLog.getInstance().d(th2);
                            }
                        }
                    }
                });
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final CountDownLatch countDownLatch) {
        if (c.compareAndSet(false, true)) {
            n.a(MobSDK.getContext());
            i();
            v.a();
            j();
            h();
            new com.mob.tools.utils.f("PY-C") { // from class: com.mob.commons.s.2
                @Override // com.mob.tools.utils.f
                public void a() {
                    com.mob.tools.b.a.b.set(Boolean.TRUE);
                    MobLog.getInstance().d("g lk st: " + Process.myPid(), new Object[0]);
                    boolean zA = l.a(l.a(l.g), new k() { // from class: com.mob.commons.s.2.1
                        @Override // com.mob.commons.k
                        public boolean a(FileLocker fileLocker) {
                            MobLog.getInstance().d("g lk pd: " + Process.myPid() + ", proc st", new Object[0]);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            w.f();
                            b.a(countDownLatch);
                            MobLog.getInstance().d("g lk pd: " + Process.myPid() + ", proc ed, dur: " + (System.currentTimeMillis() - jCurrentTimeMillis) + ", release: y", new Object[0]);
                            return false;
                        }
                    });
                    MobLog.getInstance().d("g lk res: " + zA + Process.myPid(), new Object[0]);
                    com.mob.tools.b.a.b.set(Boolean.FALSE);
                }
            }.start();
        }
    }

    public static boolean b() {
        return !w.a().a(w.h, n.f17685e) || b == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(boolean z, String str) throws Throwable {
        HashMap<String, Object> mapA = q.a(str);
        mapA.put(o.a("009%defgejffdhSiiHghEe"), String.valueOf(z));
        String strHttpGet = new NetworkHelper().httpGet(c.a(c.c) + o.a("036geVdhdeWj+dfdgdiUge<eceddedgdi_g4dfdcDdc4ecdhdegcdfJdCdeecdkPg.fgHd1dfXdFdcfg"), mapA, NetCommunicator.getCommonDefaultHeaders());
        MobLog.getInstance().d("RS sp: " + strHttpGet, new Object[0]);
        HashMap mapFromJson = HashonHelper.fromJson(strHttpGet);
        if (mapFromJson != null) {
            if ("200".equals(String.valueOf(mapFromJson.get(o.a("0047dgecThi"))))) {
                return;
            }
            throw new Throwable("RS code is not 200: " + strHttpGet);
        }
        throw new Throwable("RS is illegal: " + strHttpGet);
    }
}
