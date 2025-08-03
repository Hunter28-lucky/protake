package com.blink.academy.film.support.socket;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.NsdServiceInfoEntity;
import com.blink.academy.film.stream.ServiceInfoBean;
import com.google.gson.Gson;
import defpackage.C4638;
import defpackage.e5;
import defpackage.r1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NSDServer implements Runnable {
    public static final String TAG = "NSDServer";
    private static NSDServer mNSDServer;
    private static Handler mSocketSendHandler;
    private static HandlerThread socketSendThread;
    private NsdManager mNsdManager;
    private NsdManager.RegistrationListener mRegistrationListener;
    private NsdManager.RegistrationListener mRestartRegistrationListener;
    private String mServerName;
    private FinderManager.OnNSDServerCallback onNSDServerCallback;
    private IRegisterCallBack registerCallBack;
    private NsdServiceInfo serviceInfo;
    private final String mServerType = SocketHelper.SERVER_TYPE;
    private boolean mHasRegistered = false;

    public interface IRegisterCallBack {
        void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i);

        void onServiceRegistered(NsdServiceInfo nsdServiceInfo);

        void onServiceUnregistered(NsdServiceInfo nsdServiceInfo);

        void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i);
    }

    private NSDServer() {
    }

    public static NSDServer getInstance() {
        if (mNSDServer == null) {
            synchronized (NSDServer.class) {
                if (mNSDServer == null) {
                    mNSDServer = new NSDServer();
                }
            }
        }
        return mNSDServer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeRegistrationListener() {
        this.mRegistrationListener = new NsdManager.RegistrationListener() { // from class: com.blink.academy.film.support.socket.NSDServer.3
            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                C4638.m14101(NSDServer.TAG, "NsdServiceInfo onRegistrationFailed");
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onRegistrationFailed(nsdServiceInfo, i);
                }
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) throws NumberFormatException {
                ServiceInfoBean serviceInfoBean;
                NSDServer.this.mServerName = nsdServiceInfo.getServiceName();
                C4638.m14101(NSDServer.TAG, "onServiceRegistered: " + nsdServiceInfo);
                C4638.m14101(NSDServer.TAG, "mServerName onServiceRegistered: " + NSDServer.this.mServerName);
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onServiceRegistered(nsdServiceInfo);
                }
                NsdServiceInfoEntity localNsdServiceInfoEntity = FinderManager.getInstance().getLocalNsdServiceInfoEntity();
                if (localNsdServiceInfoEntity != null && (serviceInfoBean = localNsdServiceInfoEntity.getServiceInfoBean()) != null) {
                    String time = serviceInfoBean.getTime();
                    if (r1.m8143(time)) {
                        double d = Double.parseDouble(time);
                        List<NsdServiceInfoEntity> remoteNsdServiceInfoList = FinderManager.getInstance().getRemoteNsdServiceInfoList();
                        boolean z = true;
                        if (r1.m8144(remoteNsdServiceInfoList)) {
                            Iterator<NsdServiceInfoEntity> it = remoteNsdServiceInfoList.iterator();
                            while (it.hasNext()) {
                                ServiceInfoBean serviceInfoBean2 = it.next().getServiceInfoBean();
                                if (serviceInfoBean2.getMachine().equals(serviceInfoBean.getMachine())) {
                                    String time2 = serviceInfoBean2.getTime();
                                    if (r1.m8143(time2) && Double.parseDouble(time2.split("\\.")[0]) < d) {
                                        z = false;
                                    }
                                }
                            }
                        }
                        if (!z || NSDServer.this.onNSDServerCallback == null) {
                            return;
                        }
                        C4638.m14101(NSDServer.TAG, "onStartSuc");
                        NSDServer.this.onNSDServerCallback.onStartSuc();
                        return;
                    }
                }
                if (NSDServer.this.onNSDServerCallback != null) {
                    NSDServer.this.onNSDServerCallback.onStartFail();
                }
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                C4638.m14101(NSDServer.TAG, "onServiceUnregistered serviceInfo: " + nsdServiceInfo);
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onServiceUnregistered(nsdServiceInfo);
                }
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                C4638.m14101(NSDServer.TAG, "onUnregistrationFailed serviceInfo: " + nsdServiceInfo + " ,errorCode:" + i);
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onUnregistrationFailed(nsdServiceInfo, i);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeRestartRegistrationListener() {
        this.mRestartRegistrationListener = new NsdManager.RegistrationListener() { // from class: com.blink.academy.film.support.socket.NSDServer.4
            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onRegistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                C4638.m14101(NSDServer.TAG, "NsdServiceInfo onRegistrationFailed");
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onRegistrationFailed(nsdServiceInfo, i);
                }
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceRegistered(NsdServiceInfo nsdServiceInfo) throws NumberFormatException {
                ServiceInfoBean serviceInfoBean;
                NSDServer.this.mServerName = nsdServiceInfo.getServiceName();
                C4638.m14101(NSDServer.TAG, "onServiceRegistered: " + nsdServiceInfo);
                C4638.m14101(NSDServer.TAG, "mServerName onServiceRegistered: " + NSDServer.this.mServerName);
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onServiceRegistered(nsdServiceInfo);
                }
                NsdServiceInfoEntity localNsdServiceInfoEntity = FinderManager.getInstance().getLocalNsdServiceInfoEntity();
                if (localNsdServiceInfoEntity == null || (serviceInfoBean = localNsdServiceInfoEntity.getServiceInfoBean()) == null) {
                    return;
                }
                String time = serviceInfoBean.getTime();
                if (r1.m8143(time)) {
                    Double.parseDouble(time);
                    List<NsdServiceInfoEntity> remoteNsdServiceInfoList = FinderManager.getInstance().getRemoteNsdServiceInfoList();
                    if (r1.m8144(remoteNsdServiceInfoList)) {
                        Iterator<NsdServiceInfoEntity> it = remoteNsdServiceInfoList.iterator();
                        while (it.hasNext()) {
                            ServiceInfoBean serviceInfoBean2 = it.next().getServiceInfoBean();
                            if (serviceInfoBean2.getMachine().equals(serviceInfoBean.getMachine())) {
                                String time2 = serviceInfoBean2.getTime();
                                if (r1.m8143(time2)) {
                                    Double.parseDouble(time2.split("\\.")[0]);
                                }
                            }
                        }
                    }
                }
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onServiceUnregistered(NsdServiceInfo nsdServiceInfo) {
                C4638.m14101(NSDServer.TAG, "onServiceUnregistered serviceInfo: " + nsdServiceInfo);
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onServiceUnregistered(nsdServiceInfo);
                }
            }

            @Override // android.net.nsd.NsdManager.RegistrationListener
            public void onUnregistrationFailed(NsdServiceInfo nsdServiceInfo, int i) {
                C4638.m14101(NSDServer.TAG, "onUnregistrationFailed serviceInfo: " + nsdServiceInfo + " ,errorCode:" + i);
                if (NSDServer.this.registerCallBack != null) {
                    NSDServer.this.registerCallBack.onUnregistrationFailed(nsdServiceInfo, i);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerService(Context context, String str, int i) {
        this.mNsdManager = (NsdManager) context.getSystemService("servicediscovery");
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        this.serviceInfo = nsdServiceInfo;
        nsdServiceInfo.setServiceName(str);
        this.serviceInfo.setPort(i);
        this.serviceInfo.setServiceType(SocketHelper.SERVER_TYPE);
        NsdServiceInfoEntity nsdServiceInfoEntity = new NsdServiceInfoEntity();
        nsdServiceInfoEntity.setNsdServiceInfo(this.serviceInfo);
        ServiceInfoBean serviceInfoBean = new ServiceInfoBean();
        serviceInfoBean.setMachine(FinderManager.getInstance().getSelectMachine());
        serviceInfoBean.setTime(((System.currentTimeMillis() / 1000.0d) - 9.783072E8d) + "");
        serviceInfoBean.setUuid(e5.m5988().m5991());
        serviceInfoBean.setV("1");
        serviceInfoBean.setSv("1");
        nsdServiceInfoEntity.setServiceInfoBean(serviceInfoBean);
        this.serviceInfo.setAttribute("info", new Gson().toJson(serviceInfoBean));
        FinderManager.getInstance().updateLocalNsdServiceInfo(nsdServiceInfoEntity);
        this.mNsdManager.registerService(this.serviceInfo, 1, this.mRegistrationListener);
        this.mHasRegistered = true;
    }

    public void restartNSDServer(final String str, FinderManager.OnNSDServerCallback onNSDServerCallback) {
        if (this.mHasRegistered) {
            try {
                mSocketSendHandler.post(new Runnable() { // from class: com.blink.academy.film.support.socket.NSDServer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (NSDServer.this.mRegistrationListener != null) {
                            try {
                                NSDServer.this.mNsdManager.unregisterService(NSDServer.this.mRegistrationListener);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            NSDServer.this.mRegistrationListener = null;
                        }
                        if (NSDServer.this.mRestartRegistrationListener != null) {
                            try {
                                NSDServer.this.mNsdManager.unregisterService(NSDServer.this.mRestartRegistrationListener);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            NSDServer.this.mRestartRegistrationListener = null;
                        }
                        NSDServer.this.serviceInfo.setServiceName(str);
                        NSDServer.this.initializeRestartRegistrationListener();
                        NSDServer.this.mNsdManager.registerService(NSDServer.this.serviceInfo, 1, NSDServer.this.mRestartRegistrationListener);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
    }

    public void setRegisterCallBack(IRegisterCallBack iRegisterCallBack) {
        this.registerCallBack = iRegisterCallBack;
    }

    public void startNSDServer(Context context, String str, int i) {
        startNSDServer(context, str, i, null);
    }

    public void stopNSDServer() {
        NsdManager nsdManager = this.mNsdManager;
        if (nsdManager != null) {
            try {
                if (this.mHasRegistered) {
                    NsdManager.RegistrationListener registrationListener = this.mRegistrationListener;
                    if (registrationListener != null) {
                        nsdManager.unregisterService(registrationListener);
                    }
                    NsdManager.RegistrationListener registrationListener2 = this.mRestartRegistrationListener;
                    if (registrationListener2 != null) {
                        this.mNsdManager.unregisterService(registrationListener2);
                    }
                    this.mHasRegistered = false;
                    FinderManager.getInstance().updateLocalNsdServiceInfo(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        HandlerThread handlerThread = socketSendThread;
        if (handlerThread != null) {
            handlerThread.quit();
            socketSendThread = null;
            mSocketSendHandler = null;
        }
    }

    public void startNSDServer(final Context context, final String str, final int i, FinderManager.OnNSDServerCallback onNSDServerCallback) {
        HandlerThread handlerThread = new HandlerThread("server");
        socketSendThread = handlerThread;
        handlerThread.setPriority(1);
        socketSendThread.start();
        Handler handler = new Handler(socketSendThread.getLooper());
        mSocketSendHandler = handler;
        this.onNSDServerCallback = onNSDServerCallback;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.socket.NSDServer.1
            @Override // java.lang.Runnable
            public void run() {
                NSDServer.this.initializeRegistrationListener();
                NSDServer.this.registerService(context, str, i);
            }
        });
    }
}
