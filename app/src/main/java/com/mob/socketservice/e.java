package com.mob.socketservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import com.mob.MobSDK;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;

/* loaded from: classes2.dex */
public class e {
    private Context a;
    private Messenger b;
    private BroadcastReceiver c;
    private Messenger d;

    /* renamed from: e, reason: collision with root package name */
    private MobService f17707e;

    public e(MobService mobService) {
        try {
            this.f17707e = mobService;
            this.a = mobService.getApplicationContext();
            c();
            Handler handlerNewHandler = MobHandlerThread.newHandler(new Handler.Callback() { // from class: com.mob.socketservice.e.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    return e.this.a(message);
                }
            });
            if (handlerNewHandler != null) {
                this.b = new Messenger(handlerNewHandler);
            }
            this.c = d();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.mob.action.S_DESTROY");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            mobService.registerReceiver(this.c, intentFilter);
        } catch (Throwable th) {
            CLog.getInstance().e(th.getMessage(), new Object[0]);
        }
    }

    private void c() {
        if (this.f17707e != null && "yes".equals(d.a(this.a, "mob_foreground_notification"))) {
            this.f17707e.startForeground(1001, d.a(this.a, "foregroud", "前台通知"));
        }
    }

    private BroadcastReceiver d() {
        return new BroadcastReceiver() { // from class: com.mob.socketservice.e.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int iG = d.g();
                        CLog.getInstance().d("ServiceInit receiver network " + iG, new Object[0]);
                        f.a().a(iG);
                    }
                } catch (Throwable th) {
                    CLog.getInstance().e(th);
                }
            }
        };
    }

    public int a(Intent intent, int i, int i2) {
        return 1;
    }

    public void b(Intent intent) {
        CLog.getInstance().d("ServiceInit onTaskRemoved", new Object[0]);
    }

    public void b() {
        CLog.getInstance().d("ServiceInit onLowMemory", new Object[0]);
    }

    public void d(Intent intent) {
        CLog.getInstance().d("ServiceInit onRebind", new Object[0]);
    }

    public IBinder a(Intent intent) {
        Messenger messenger = this.b;
        if (messenger == null) {
            return null;
        }
        return messenger.getBinder();
    }

    public boolean a(final Message message) {
        MobSDK.isForb();
        a(this.a, new Runnable() { // from class: com.mob.socketservice.e.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CLog.getInstance().d("ServiceInit serviceHandleMessage msg:" + message.toString(), new Object[0]);
                    Message message2 = message;
                    switch (message2.what) {
                        case 10:
                            e.this.d = message2.replyTo;
                            f.a().a(e.this.d);
                            f.a().a((ServiceMessageData) message.getData().getSerializable("data"), true);
                            break;
                        case 11:
                            Bundle data = message2.getData();
                            if (data != null) {
                                if (!data.getBoolean("close_push", false)) {
                                    f.a().d();
                                    break;
                                } else {
                                    f.a().c();
                                    break;
                                }
                            }
                            break;
                        case 12:
                            ServiceMessageData serviceMessageData = (ServiceMessageData) message2.getData().getSerializable("data");
                            NLog cLog = CLog.getInstance();
                            StringBuilder sb = new StringBuilder();
                            sb.append("ServiceInit serviceHandleMessage reconnect guardId:");
                            sb.append(serviceMessageData != null ? serviceMessageData.getGuardId() : null);
                            cLog.d(sb.toString(), new Object[0]);
                            f.a().a(serviceMessageData, false);
                            f.a().f();
                            break;
                        case 13:
                            f.a().a((ServiceMessageData) message2.getData().getSerializable("data"), true);
                            break;
                        case 14:
                            Bundle data2 = message2.getData();
                            f.a().a(data2.getInt("type"), data2.getString("ack_content"));
                            break;
                        case 15:
                            Bundle bundle = new Bundle();
                            boolean zL = f.a().l();
                            bundle.putBoolean("tcp_status", zL);
                            f.a().a(15, bundle);
                            CLog.getInstance().d("ServiceInit check tcp status :" + zL, new Object[0]);
                            break;
                    }
                } catch (Throwable th) {
                    CLog.getInstance().e(th);
                }
            }
        });
        return false;
    }

    public void a() {
        CLog.getInstance().d("ServiceInit onDestroy", new Object[0]);
        MobService mobService = this.f17707e;
        if (mobService != null) {
            mobService.unregisterReceiver(this.c);
        }
    }

    public boolean c(Intent intent) {
        CLog.getInstance().d("ServiceInit onUnbind", new Object[0]);
        return true;
    }

    public void a(Configuration configuration) {
        CLog.getInstance().d("ServiceInit onConfigurationChanged", new Object[0]);
    }

    public void a(int i) {
        CLog.getInstance().d("ServiceInit onTrimMemory level = " + i, new Object[0]);
    }

    private void a(Context context, Runnable runnable) {
        PowerManager powerManager;
        PowerManager.WakeLock wakeLockNewWakeLock = null;
        try {
            if (DeviceHelper.getInstance(MobSDK.getContext()).checkPermission("android.permission.WAKE_LOCK") && (powerManager = (PowerManager) context.getSystemService("power")) != null) {
                wakeLockNewWakeLock = powerManager.newWakeLock(1, "mob:wake-lock");
            }
        } catch (Throwable th) {
            CLog.getInstance().e(th);
        }
        if (wakeLockNewWakeLock != null) {
            try {
                try {
                    wakeLockNewWakeLock.acquire(600000L);
                } catch (Throwable th2) {
                    CLog.getInstance().e(th2);
                }
            } catch (Throwable th3) {
                try {
                    CLog.getInstance().e(th3);
                    if (wakeLockNewWakeLock == null) {
                        return;
                    }
                } finally {
                    if (wakeLockNewWakeLock != null) {
                        wakeLockNewWakeLock.release();
                    }
                }
            }
        }
        runnable.run();
    }
}
