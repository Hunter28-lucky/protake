package com.mob.socketservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blink.academy.film.support.socket.SocketHelper;
import com.mob.MobSDK;
import com.mob.socketservice.g;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes2.dex */
public class f implements g.a {
    private HashMap<String, Object> A;
    private BroadcastReceiver a;
    private int b;
    private String c;
    private int d;

    /* renamed from: e, reason: collision with root package name */
    private String f17708e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Handler n;
    private boolean o;
    private Lock p;
    private PendingIntent q;
    private PendingIntent r;
    private g s;
    private boolean t;
    private Messenger u;
    private String v;
    private String w;
    private String x;
    private String y;
    private HashMap<Integer, String> z;

    public static class a {
        private static final f a = new f();
    }

    private Handler.Callback m() {
        return new Handler.Callback() { // from class: com.mob.socketservice.f.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                try {
                    int i = message.what;
                    if (i == 3) {
                        CLog.getInstance().d("pushService receive ping action", new Object[0]);
                        if (f.this.s != null) {
                            f.this.s.c();
                        }
                    } else if (i == 8 && f.this.s != null && !f.this.s.b()) {
                        f.this.o();
                    }
                } catch (Throwable th) {
                    CLog.getInstance().e(th);
                }
                return false;
            }
        };
    }

    private void n() {
        if (this.o) {
            CLog.getInstance().d("pushService startSocket stop", new Object[0]);
            return;
        }
        int iG = d.g();
        this.b = iG;
        if (iG == 0) {
            return;
        }
        new Thread() { // from class: com.mob.socketservice.f.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    if (f.this.p.tryLock(120L, TimeUnit.SECONDS)) {
                        try {
                            CLog.getInstance().d("pushService start new tcp socket", new Object[0]);
                            f.this.p();
                            f.this.p.unlock();
                        } catch (Throwable th) {
                            f.this.p.unlock();
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    CLog.getInstance().d("pushService start new tcp socket error:" + th2.getMessage(), new Object[0]);
                }
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        CLog.getInstance().d("pushService restartSocket tcp", new Object[0]);
        this.h = 0;
        AlarmManager alarmManager = (AlarmManager) MobSDK.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent("com.mob.push.intent.PING");
        intent.setPackage(MobSDK.getContext().getPackageName());
        alarmManager.cancel(b.a(MobSDK.getContext(), 0, intent, 134217728));
        this.k = 0;
        if (this.t) {
            this.s.a();
        } else {
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.o) {
            CLog.getInstance().d("pushService newTcpSocket isStopped", new Object[0]);
            return;
        }
        if (this.t) {
            return;
        }
        int iG = d.g();
        this.b = iG;
        if (iG == 0) {
            CLog.getInstance().d("pushService lastNetworkType is 0", new Object[0]);
            return;
        }
        HashMap<String, Object> mapQ = q();
        if (mapQ == null) {
            CLog.getInstance().d("pushService newTcpSocket tokenMap is null", new Object[0]);
        } else {
            a(mapQ);
            a((String) null);
        }
    }

    private HashMap<String, Object> q() {
        HashMap<String, Object> map = this.A;
        return (map == null || map.size() == 0) ? d.c() : this.A;
    }

    private void r() {
        CLog.getInstance().d("pushService ip = " + this.f17708e + Constants.COLON_SEPARATOR + this.d + ", pingInterval = " + this.f + ", pingTimeoutCounts = " + this.g + ", linkSoTimeout = " + this.l + ", appKey = " + this.x, new Object[0]);
        if (this.s == null) {
            this.s = new g(this);
        }
        this.s.a(this.v);
        this.s.b(this.w);
        this.s.a(this.l);
        this.s.c(this.x);
        this.s.d(this.y);
        this.s.a(this.f17708e, this.d);
    }

    private void s() {
        if (this.k >= 14 || d.g() == 0 || this.o) {
            CLog.getInstance().d("pushService tryReconnect finish", new Object[0]);
            return;
        }
        try {
            long jPow = ((int) Math.pow(2.0d, this.k)) * 1000;
            if (jPow < 2000) {
                jPow = 2000;
            }
            if (jPow > 256000) {
                jPow = 256000;
            }
            Thread.sleep(jPow);
            this.k++;
            CLog.getInstance().d("pushService tryReconnect, reconnectCount:" + this.k + ",time:" + jPow, new Object[0]);
            CLog.getInstance().d("pushService tryReconnect, current server:" + this.f17708e + Constants.COLON_SEPARATOR + this.d, new Object[0]);
            int i = this.k;
            if (i <= 4) {
                a(this.f17708e + Constants.COLON_SEPARATOR + this.d);
            } else if (i <= 8) {
                a((String) null);
            } else if (i <= 14) {
                p();
            }
        } catch (Throwable th) {
            CLog.getInstance().d("pushService tryReconnect failed,  connect error:" + th.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        String iPAddress = DeviceHelper.getInstance(MobSDK.getContext()).getIPAddress();
        String str = this.c;
        if (str == null || SocketHelper.LOCAL_GETWAY_IP.equals(str)) {
            this.c = iPAddress;
            return;
        }
        CLog.getInstance().d("pushService checkIpChanged lastIp = " + this.c + ", now = " + iPAddress, new Object[0]);
        if (this.c.equals(iPAddress)) {
            return;
        }
        this.c = iPAddress;
        o();
    }

    private BroadcastReceiver u() {
        return new BroadcastReceiver() { // from class: com.mob.socketservice.f.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent != null) {
                    if (MobSDK.getContext() == null || MobSDK.getContext().getPackageName().equals(intent.getPackage())) {
                        String action = intent.getAction();
                        CLog.getInstance().d("pushService tcp receiver PING Broadcast action", new Object[0]);
                        if ("com.mob.push.intent.PING".equals(action)) {
                            f.this.n.sendEmptyMessage(3);
                        } else if ("com.mob.push.intent.CHECK_IP".equals(action)) {
                            f.this.t();
                            f.this.w();
                        }
                    }
                }
            }
        };
    }

    private void v() {
        CLog.getInstance().d("pushService tcp schedule NextPing", new Object[0]);
        AlarmManager alarmManager = (AlarmManager) MobSDK.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = this.q;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
        Intent intent = new Intent("com.mob.push.intent.PING");
        intent.setPackage(MobSDK.getContext().getPackageName());
        this.q = b.a(MobSDK.getContext(), 0, intent, 134217728);
        alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + (this.f * 1000), this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        AlarmManager alarmManager = (AlarmManager) MobSDK.getContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
        PendingIntent pendingIntent = this.r;
        if (pendingIntent != null) {
            alarmManager.cancel(pendingIntent);
        }
        Intent intent = new Intent("com.mob.push.intent.CHECK_IP");
        intent.setPackage(MobSDK.getContext().getPackageName());
        this.r = b.a(MobSDK.getContext(), 0, intent, 134217728);
        alarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + (this.i * 1000), this.r);
    }

    @Override // com.mob.socketservice.g.a
    public void h() {
        if (this.a != null && this.t) {
            try {
                MobSDK.getContext().unregisterReceiver(this.a);
            } catch (Throwable th) {
                CLog.getInstance().e(th);
            }
        }
        this.t = false;
        s();
    }

    @Override // com.mob.socketservice.g.a
    public void i() {
        this.t = true;
    }

    @Override // com.mob.socketservice.g.a
    public void j() {
        if (this.a == null) {
            this.a = u();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.mob.push.intent.PING");
        intentFilter.addAction("com.mob.push.intent.CHECK_IP");
        try {
            ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), "registerReceiver", this.a, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        v();
        w();
    }

    @Override // com.mob.socketservice.g.a
    public void k() {
        v();
    }

    public boolean l() {
        g gVar = this.s;
        return gVar != null && gVar.b();
    }

    private f() {
        this.b = -1;
        this.c = null;
        this.d = 9999;
        this.f17708e = null;
        this.f = MPEGConst.SEQUENCE_ERROR_CODE;
        this.g = 11;
        this.h = 0;
        this.i = 3600;
        this.j = 60;
        this.k = 0;
        this.l = 30;
        this.m = 0;
        this.o = false;
        this.p = new ReentrantLock();
        this.t = false;
        this.z = new HashMap<>();
        this.A = new HashMap<>();
        this.n = MobHandlerThread.newHandler(m());
    }

    public static f a() {
        return a.a;
    }

    public HashMap<Integer, String> b() {
        return this.z;
    }

    public void c() {
        if (this.o) {
            return;
        }
        this.o = true;
        g gVar = this.s;
        if (gVar != null) {
            gVar.a();
        }
    }

    public void d() {
        this.o = false;
        this.t = false;
        n();
    }

    public void e() {
        n();
        this.m = 0;
    }

    public void f() {
        o();
    }

    public void g() {
        this.n.sendEmptyMessage(8);
    }

    public void a(Messenger messenger) {
        this.u = messenger;
    }

    public void a(int i, String str) {
        g gVar = this.s;
        if (gVar == null || !gVar.b()) {
            return;
        }
        CLog.getInstance().d("ServiceManager sendGuardAck content:" + str + " ,type:" + i, new Object[0]);
        this.s.a(i, str);
    }

    public void a(ServiceMessageData serviceMessageData, boolean z) {
        if (serviceMessageData == null) {
            return;
        }
        if (serviceMessageData.getTypeMap() != null) {
            this.z.putAll(serviceMessageData.getTypeMap());
        }
        CLog.getInstance().d("pushService executeConnect getMsgTypeMap:" + this.z.toString(), new Object[0]);
        if (serviceMessageData.getRid() != null) {
            this.v = serviceMessageData.getRid();
        }
        if (serviceMessageData.getGuardId() != null) {
            this.w = serviceMessageData.getGuardId();
        }
        if (serviceMessageData.getAppKey() != null) {
            this.x = serviceMessageData.getAppKey();
        }
        if (serviceMessageData.getAppSecret() != null) {
            this.y = serviceMessageData.getAppSecret();
        }
        if (serviceMessageData.getTokenMap() != null) {
            this.A.clear();
            this.A.putAll(serviceMessageData.getTokenMap());
        }
        if (z) {
            if (TextUtils.isEmpty(this.v)) {
                int i = this.m;
                if (i < 200) {
                    this.m = i + 1;
                    a(13, new Bundle());
                    return;
                } else {
                    CLog.getInstance().e("pushService executeConnect get rid  null", new Object[0]);
                    return;
                }
            }
            e();
        }
    }

    public void a(int i, Bundle bundle) {
        if (this.u == null) {
            CLog.getInstance().e("pushService clientMessenger is null", new Object[0]);
            return;
        }
        try {
            Message messageObtain = Message.obtain();
            if (i != -1) {
                messageObtain.what = i;
            }
            messageObtain.setData(bundle);
            this.u.send(messageObtain);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
        }
    }

    public void a(int i) {
        if (i == this.b) {
            g();
            return;
        }
        this.c = DeviceHelper.getInstance(MobSDK.getContext()).getIPAddress();
        CLog.getInstance().d("pushService onNetworkChanged type = " + i + ", lastNetworkType = " + this.b, new Object[0]);
        int i2 = this.b;
        if (i2 == -1) {
            this.b = i;
            return;
        }
        if (i != 0 && i2 != 1 && i != 1 && i2 != 2 && i2 == 3) {
        }
        this.b = i;
        o();
    }

    private void a(String str) {
        String str2;
        HashMap<String, Object> mapQ = q();
        if (mapQ != null && !mapQ.isEmpty() && mapQ.containsKey("domainList")) {
            ArrayList arrayList = (ArrayList) mapQ.get("domainList");
            if (arrayList != null && arrayList.size() != 0) {
                if (TextUtils.isEmpty(str)) {
                    str2 = (String) arrayList.get(new Random().nextInt(arrayList.size()));
                } else {
                    int iIndexOf = arrayList.indexOf(str);
                    if (iIndexOf >= arrayList.size() - 1) {
                        str2 = (String) arrayList.get(0);
                    } else {
                        str2 = (String) arrayList.get(iIndexOf + 1);
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    CLog.getInstance().d("pushService Socket serverIp is null", new Object[0]);
                    return;
                }
                if (str2.contains(Constants.COLON_SEPARATOR)) {
                    this.f17708e = str2.substring(0, str2.indexOf(Constants.COLON_SEPARATOR));
                    this.d = Integer.valueOf(str2.substring(str2.indexOf(Constants.COLON_SEPARATOR) + 1)).intValue();
                } else {
                    this.f17708e = str2;
                    this.d = 80;
                }
                if (TextUtils.isEmpty(this.f17708e)) {
                    CLog.getInstance().d("pushService Socket serverIp is null", new Object[0]);
                    return;
                } else {
                    r();
                    return;
                }
            }
            CLog.getInstance().d("pushService tokenconfig domainList is null", new Object[0]);
            return;
        }
        CLog.getInstance().d("pushService tokenconfig domainList is null", new Object[0]);
    }

    private void a(HashMap<String, Object> map) {
        if (map != null) {
            try {
                this.f = ((Integer) ResHelper.forceCast(map.get("heartSpaceTime"), Integer.valueOf(MPEGConst.SEQUENCE_ERROR_CODE))).intValue();
                this.g = ((Integer) ResHelper.forceCast(map.get("serverCloseSpace"), 11)).intValue();
                this.j = ((Integer) ResHelper.forceCast(map.get("reportAckTime"), 60)).intValue();
                this.l = ((Integer) ResHelper.forceCast(map.get("reConnectTime"), 30)).intValue();
            } catch (Throwable th) {
                CLog.getInstance().d("pushService parseConfig failed, error:" + th.getMessage(), new Object[0]);
            }
        }
    }
}
