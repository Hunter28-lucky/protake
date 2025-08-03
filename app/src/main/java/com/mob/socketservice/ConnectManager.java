package com.mob.socketservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.proguard.ClassKeeper;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ConnectManager implements ClassKeeper {
    private Handler clientHandler;
    private Messenger clientMessenger;
    private ScheduledExecutorService executor;
    private boolean isBind;
    private HashSet<ServiceConnectionListener> listenerSet;
    public Looper looper;
    private ServiceConnection serviceConnection;
    private Messenger serviceMessenger;

    public interface ServiceConnectionListener extends ClassKeeper {
        void onPushTcpStatus(boolean z);

        void onServiceConnected();

        void onServiceDisconnected();

        void onServiceResponseMessage(Message message);
    }

    public static class a {
        private static final ConnectManager a = new ConnectManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean clientHandleMessage(Message message) {
        if (message == null) {
            return false;
        }
        CLog.getInstance().d("CM clientHandleMessage message:" + message.toString(), new Object[0]);
        int i = message.what;
        if (i != 13) {
            if (i != 15) {
                listenerResponseMsg(message);
            } else {
                CLog.getInstance().d("ConnectManager checkTcpStatus ack", new Object[0]);
                Bundle data = message.getData();
                if (data != null && data.containsKey("tcp_status")) {
                    listenerPushTcpStatus(data.getBoolean("tcp_status", false));
                }
            }
        } else {
            if (!c.a().b()) {
                CLog.getInstance().d("CM clientHandleMessage notInMainProcess", new Object[0]);
                return false;
            }
            this.executor.schedule(new Runnable() { // from class: com.mob.socketservice.ConnectManager.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        HashMap<String, Object> mapE = d.e();
                        ServiceMessageData serviceMessageData = new ServiceMessageData();
                        if (mapE != null && mapE.containsKey("registrationId")) {
                            serviceMessageData.setRid((String) mapE.get("registrationId"));
                        }
                        serviceMessageData.setTokenMap(mapE);
                        CLog.getInstance().d("CM clientHandleMessage SERVICE_GET_RID data:" + serviceMessageData.toString(), new Object[0]);
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 13;
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data", serviceMessageData);
                        messageObtain.setData(bundle);
                        ConnectManager.this.sendMessageToService(messageObtain);
                    } catch (Throwable th) {
                        CLog.getInstance().e(th);
                    }
                }
            }, 1L, TimeUnit.SECONDS);
        }
        return false;
    }

    public static ConnectManager getInstance() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listenerConnected() {
        if (this.listenerSet.size() == 0) {
            return;
        }
        Iterator<ServiceConnectionListener> it = this.listenerSet.iterator();
        while (it.hasNext()) {
            it.next().onServiceConnected();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void listenerDisconnected() {
        if (this.listenerSet.size() == 0) {
            return;
        }
        Iterator<ServiceConnectionListener> it = this.listenerSet.iterator();
        while (it.hasNext()) {
            it.next().onServiceDisconnected();
        }
    }

    private void listenerPushTcpStatus(boolean z) {
        if (this.listenerSet.size() == 0) {
            return;
        }
        Iterator<ServiceConnectionListener> it = this.listenerSet.iterator();
        while (it.hasNext()) {
            it.next().onPushTcpStatus(z);
        }
    }

    private void listenerResponseMsg(Message message) {
        if (this.listenerSet.size() == 0) {
            return;
        }
        Iterator<ServiceConnectionListener> it = this.listenerSet.iterator();
        while (it.hasNext()) {
            it.next().onServiceResponseMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sendMessageToService(Message message) {
        try {
            message.replyTo = this.clientMessenger;
            this.serviceMessenger.send(message);
            return true;
        } catch (Throwable th) {
            CLog.getInstance().e(th);
            return false;
        }
    }

    public final boolean bindService(Context context, final ServiceMessageData serviceMessageData, ServiceConnectionListener serviceConnectionListener) {
        try {
        } catch (Throwable th) {
            CLog.getInstance().d("bind " + context.getPackageName() + " :MobService failed", new Object[0]);
            CLog.getInstance().e(th);
        }
        if (this.clientHandler != null && this.looper != null && serviceMessageData != null) {
            CLog.getInstance().d("pushService bindService:" + this.isBind + ",process:" + Process.myPid() + ",data:" + serviceMessageData.toString(), new Object[0]);
            if (!c.a().b()) {
                return false;
            }
            this.listenerSet.add(serviceConnectionListener);
            this.clientMessenger = new Messenger(this.clientHandler);
            this.serviceConnection = new ServiceConnection() { // from class: com.mob.socketservice.ConnectManager.3
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        CLog.getInstance().d("pushService onServiceConnected Process:" + Process.myPid(), new Object[0]);
                        if (c.a().b()) {
                            ConnectManager.this.isBind = true;
                            ConnectManager.this.serviceMessenger = new Messenger(iBinder);
                            Message message = new Message();
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("data", serviceMessageData);
                            message.setData(bundle);
                            message.what = 10;
                            ConnectManager.this.sendMessageToService(message);
                            ConnectManager.this.listenerConnected();
                        }
                    } catch (Throwable th2) {
                        CLog.getInstance().e(th2);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ConnectManager.this.isBind = false;
                    ConnectManager.this.listenerDisconnected();
                }
            };
            context.bindService(new Intent(context, (Class<?>) MobService.class), this.serviceConnection, 1);
            return true;
        }
        CLog.getInstance().d("pushService bindService has destroyed", new Object[0]);
        if (serviceConnectionListener != null) {
            serviceConnectionListener.onServiceDisconnected();
        }
        return false;
    }

    public void checkTcpStatus() {
        Message message = new Message();
        message.what = 15;
        sendMessageToService(message);
        CLog.getInstance().d("ConnectManager checkTcpStatus", new Object[0]);
    }

    public boolean reconnect(ServiceMessageData serviceMessageData) {
        try {
            CLog.getInstance().d("CM reconnect:" + serviceMessageData.toString(), new Object[0]);
            Message messageObtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", serviceMessageData);
            messageObtain.what = 12;
            messageObtain.setData(bundle);
            return sendMessageToService(messageObtain);
        } catch (Throwable th) {
            CLog.getInstance().e(th);
            return false;
        }
    }

    public void sendGuardAck(int i, String str) {
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        bundle.putString("ack_content", str);
        messageObtain.what = 14;
        messageObtain.setData(bundle);
        sendMessageToService(messageObtain);
    }

    public void setPushServiceCloseStatus(boolean z) {
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putBoolean("close_push", z);
        messageObtain.what = 11;
        messageObtain.setData(bundle);
        sendMessageToService(messageObtain);
    }

    private ConnectManager() {
        this.listenerSet = new HashSet<>();
        this.isBind = false;
        this.executor = Executors.newScheduledThreadPool(1);
        try {
            Handler handlerNewHandler = MobHandlerThread.newHandler(new Handler.Callback() { // from class: com.mob.socketservice.ConnectManager.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    return ConnectManager.this.clientHandleMessage(message);
                }
            });
            this.clientHandler = handlerNewHandler;
            this.looper = handlerNewHandler.getLooper();
        } catch (Throwable th) {
            CLog.getInstance().e(th);
        }
    }
}
