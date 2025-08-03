package com.mob.pushsdk.impl;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mob.pushsdk.MobPushNotifyMessage;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class j implements Handler.Callback {
    private static j a;
    private HashSet<String> d;

    /* renamed from: e, reason: collision with root package name */
    private HashSet<String> f17697e;
    private ExecutorService b = Executors.newFixedThreadPool(2);
    private int h = 60;
    private long i = 0;
    private Handler c = MobHandlerThread.newHandler(this);
    private HashMap<String, Integer> f = new HashMap<>();
    private HashSet<String> g = new HashSet<>();

    private j() {
        this.d = com.mob.pushsdk.biz.d.g();
        if (this.d == null) {
            this.d = new HashSet<>();
        } else {
            HashSet<String> hashSet = new HashSet<>();
            this.f17697e = hashSet;
            hashSet.addAll(this.d);
        }
        this.c.sendEmptyMessage(0);
        this.c.sendEmptyMessageDelayed(1, 1800000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        Integer num;
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.f.containsKey(next) && (num = this.f.get(next)) != null && num.intValue() == 1) {
                    arrayList.add(next);
                }
            }
            boolean z = false;
            PLog.getInstance().d("MessageAck offlineMessages = " + arrayList.toString(), new Object[0]);
            if (arrayList.size() != 0) {
                z = com.mob.pushsdk.biz.e.c((String[]) arrayList.toArray(new String[0])) != null;
            }
            if (z) {
                this.f.clear();
            }
        } finally {
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        HashSet<String> hashSet;
        int i = message.what;
        if (i == 0) {
            c();
            return false;
        }
        if (i != 1 || (hashSet = this.f17697e) == null) {
            return false;
        }
        hashSet.clear();
        this.f17697e = null;
        return false;
    }

    private void c() {
        this.b.submit(new Runnable() { // from class: com.mob.pushsdk.impl.j.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0049  */
            /* JADX WARN: Removed duplicated region for block: B:32:0x0074 A[Catch: all -> 0x00b1, PHI: r5
              0x0074: PHI (r5v7 boolean) = (r5v5 boolean), (r5v5 boolean), (r5v5 boolean), (r5v6 boolean), (r5v8 boolean), (r5v8 boolean), (r5v8 boolean) binds: [B:22:0x005d, B:31:0x006d, B:24:0x0060, B:29:0x006a, B:15:0x004a, B:17:0x004d, B:18:0x004f] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {, blocks: (B:4:0x0007, B:32:0x0074, B:34:0x00a2, B:35:0x00af, B:21:0x0056, B:31:0x006d, B:23:0x005f, B:25:0x0062), top: B:40:0x0007, inners: #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:34:0x00a2 A[Catch: all -> 0x00b1, TryCatch #0 {, blocks: (B:4:0x0007, B:32:0x0074, B:34:0x00a2, B:35:0x00af, B:21:0x0056, B:31:0x006d, B:23:0x005f, B:25:0x0062), top: B:40:0x0007, inners: #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:46:0x005f A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r7 = this;
                    com.mob.pushsdk.impl.j r0 = com.mob.pushsdk.impl.j.this
                    java.util.HashSet r0 = com.mob.pushsdk.impl.j.a(r0)
                    monitor-enter(r0)
                    com.mob.pushsdk.impl.j r1 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> Lb1
                    java.util.HashSet r1 = com.mob.pushsdk.impl.j.a(r1)     // Catch: java.lang.Throwable -> Lb1
                    com.mob.pushsdk.impl.j r2 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> Lb1
                    java.util.HashSet r2 = com.mob.pushsdk.impl.j.b(r2)     // Catch: java.lang.Throwable -> Lb1
                    r1.removeAll(r2)     // Catch: java.lang.Throwable -> Lb1
                    com.mob.pushsdk.impl.j r1 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> Lb1
                    java.util.HashSet r1 = com.mob.pushsdk.impl.j.a(r1)     // Catch: java.lang.Throwable -> Lb1
                    r2 = 0
                    java.lang.String[] r3 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lb1
                    java.lang.Object[] r1 = r1.toArray(r3)     // Catch: java.lang.Throwable -> Lb1
                    java.lang.String[] r1 = (java.lang.String[]) r1     // Catch: java.lang.Throwable -> Lb1
                    com.mob.pushsdk.impl.j r3 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> Lb1
                    java.util.HashSet r3 = com.mob.pushsdk.impl.j.b(r3)     // Catch: java.lang.Throwable -> Lb1
                    java.lang.String[] r4 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> Lb1
                    java.lang.Object[] r3 = r3.toArray(r4)     // Catch: java.lang.Throwable -> Lb1
                    java.lang.String[] r3 = (java.lang.String[]) r3     // Catch: java.lang.Throwable -> Lb1
                    r4 = 1
                    if (r1 == 0) goto L49
                    int r5 = r1.length     // Catch: java.lang.Throwable -> L46
                    if (r5 <= 0) goto L49
                    com.mob.pushsdk.impl.j r5 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> L46
                    com.mob.pushsdk.impl.j.c(r5)     // Catch: java.lang.Throwable -> L46
                    java.lang.Object r5 = com.mob.pushsdk.biz.e.b(r1)     // Catch: java.lang.Throwable -> L46
                    if (r5 == 0) goto L49
                    r5 = r4
                    goto L4a
                L46:
                    r3 = move-exception
                    r5 = r2
                    goto L56
                L49:
                    r5 = r2
                L4a:
                    if (r3 == 0) goto L74
                    int r6 = r3.length     // Catch: java.lang.Throwable -> L55
                    if (r6 <= 0) goto L74
                    com.mob.pushsdk.impl.j r6 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> L55
                    com.mob.pushsdk.impl.j.a(r6, r3)     // Catch: java.lang.Throwable -> L55
                    goto L74
                L55:
                    r3 = move-exception
                L56:
                    com.mob.tools.log.NLog r6 = com.mob.pushsdk.base.PLog.getInstance()     // Catch: java.lang.Throwable -> Lb1
                    r6.d(r3)     // Catch: java.lang.Throwable -> Lb1
                    if (r1 == 0) goto L74
                    int r3 = r1.length     // Catch: java.lang.Throwable -> L6c
                    if (r3 <= 0) goto L74
                    java.lang.Object r1 = com.mob.pushsdk.biz.e.b(r1)     // Catch: java.lang.Throwable -> L6c
                    if (r1 == 0) goto L69
                    goto L6a
                L69:
                    r4 = r2
                L6a:
                    r5 = r4
                    goto L74
                L6c:
                    r1 = move-exception
                    com.mob.tools.log.NLog r3 = com.mob.pushsdk.base.PLog.getInstance()     // Catch: java.lang.Throwable -> Lb1
                    r3.d(r1)     // Catch: java.lang.Throwable -> Lb1
                L74:
                    com.mob.tools.log.NLog r1 = com.mob.pushsdk.base.PLog.getInstance()     // Catch: java.lang.Throwable -> Lb1
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1
                    r3.<init>()     // Catch: java.lang.Throwable -> Lb1
                    java.lang.String r4 = "MessageAck send ackSuccess = "
                    r3.append(r4)     // Catch: java.lang.Throwable -> Lb1
                    r3.append(r5)     // Catch: java.lang.Throwable -> Lb1
                    java.lang.String r4 = ", msgList = "
                    r3.append(r4)     // Catch: java.lang.Throwable -> Lb1
                    com.mob.pushsdk.impl.j r4 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> Lb1
                    java.util.HashSet r4 = com.mob.pushsdk.impl.j.a(r4)     // Catch: java.lang.Throwable -> Lb1
                    int r4 = r4.size()     // Catch: java.lang.Throwable -> Lb1
                    r3.append(r4)     // Catch: java.lang.Throwable -> Lb1
                    java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> Lb1
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> Lb1
                    r1.d(r3, r2)     // Catch: java.lang.Throwable -> Lb1
                    if (r5 == 0) goto Laf
                    com.mob.pushsdk.impl.j r1 = com.mob.pushsdk.impl.j.this     // Catch: java.lang.Throwable -> Lb1
                    java.util.HashSet r1 = com.mob.pushsdk.impl.j.a(r1)     // Catch: java.lang.Throwable -> Lb1
                    r1.clear()     // Catch: java.lang.Throwable -> Lb1
                    r1 = 0
                    com.mob.pushsdk.biz.d.a(r1)     // Catch: java.lang.Throwable -> Lb1
                Laf:
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb1
                    return
                Lb1:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb1
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.pushsdk.impl.j.AnonymousClass1.run():void");
            }
        });
    }

    public void b() {
        HashMap<String, Object> mapA = com.mob.pushsdk.biz.a.a(false);
        if (mapA == null) {
            return;
        }
        this.h = ((Integer) ResHelper.forceCast(mapA.get("reportAckTime"), 60)).intValue();
    }

    public static synchronized j a() {
        if (a == null) {
            a = new j();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String[] strArr) {
        try {
            boolean z = false;
            PLog.getInstance().d("MessageAck guard msg = " + Arrays.toString(strArr), new Object[0]);
            if (strArr != null && strArr.length != 0) {
                if (com.mob.pushsdk.biz.e.a(strArr) != null) {
                    z = true;
                }
            }
            if (z) {
                this.g.clear();
            }
        } finally {
        }
    }

    public boolean a(MobPushNotifyMessage mobPushNotifyMessage, boolean z) {
        if (mobPushNotifyMessage == null) {
            return false;
        }
        return a(mobPushNotifyMessage.getMessageId(), mobPushNotifyMessage.getOfflineFlag(), mobPushNotifyMessage.isGuardMsg(), z);
    }

    public boolean a(String str, int i, boolean z, boolean z2) {
        boolean z3;
        HashSet<String> hashSet;
        boolean z4 = true;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        synchronized (this.d) {
            if (!this.d.contains(str) && ((hashSet = this.f17697e) == null || !hashSet.contains(str))) {
                if (z2) {
                    this.d.add(str);
                    com.mob.pushsdk.biz.d.a(this.d);
                    if (i == 1) {
                        this.f.put(str, Integer.valueOf(i));
                    }
                    if (z) {
                        this.g.add(str);
                    }
                    if (this.h == 0) {
                        this.c.sendEmptyMessage(0);
                    } else {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.i;
                        int i2 = this.h;
                        if (jElapsedRealtime >= i2 * 1000) {
                            this.c.sendEmptyMessageDelayed(0, i2 * 1000);
                            this.i = SystemClock.elapsedRealtime();
                        }
                        z3 = false;
                        z4 = false;
                    }
                    z3 = true;
                    z4 = false;
                } else {
                    z3 = false;
                    z4 = false;
                }
            }
            z3 = false;
        }
        PLog.getInstance().d("MessageAck hasPushed = " + z4 + ", msgList = " + this.d.size() + ", reAck = " + z2 + ", send " + z3 + ", msgAckInterval = " + this.h + ",msgOfflineMap = " + this.f + ",msgGuardSet = " + this.g, new Object[0]);
        return z4;
    }
}
