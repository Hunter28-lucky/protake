package com.blink.academy.film.support.socket;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.http.okhttp.utils.Utils;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C4638;

/* loaded from: classes.dex */
public class NSDClient {
    private static final String TAG = "NSDClient";
    private static NSDClient mNSDClient;
    private static Handler mSocketReceiveHandler;
    private static HandlerThread socketReceiveThread;
    private IDiscoveryCallBack discoveryCallBack;
    private NsdManager mNsdManager;
    private NsdManager.DiscoveryListener mNSDDiscoveryListener = null;
    private boolean mStop = false;

    private NSDClient() {
    }

    public static NSDClient getInstance() {
        if (mNSDClient == null) {
            synchronized (NSDClient.class) {
                if (mNSDClient == null) {
                    mNSDClient = new NSDClient();
                }
            }
        }
        return mNSDClient;
    }

    private void initNSDDiscoveryListener() {
        this.mNSDDiscoveryListener = new NsdManager.DiscoveryListener() { // from class: com.blink.academy.film.support.socket.NSDClient.1
            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStarted(String str) {
                C4638.m14101(NSDClient.TAG, "onDiscoveryStarted--> " + str);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onDiscoveryStopped(String str) {
                C4638.m14101(NSDClient.TAG, "onDiscoveryStopped--> " + str);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceFound(NsdServiceInfo nsdServiceInfo) {
                C4638.m14101(NSDClient.TAG, "onServiceFound Info: --> " + nsdServiceInfo);
                NSDClient.this.resoleServer(nsdServiceInfo);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onServiceLost(NsdServiceInfo nsdServiceInfo) {
                C4638.m14101(NSDClient.TAG, "onServiceLost--> " + nsdServiceInfo);
                if (NSDClient.this.discoveryCallBack != null) {
                    if (Utils.isNetworkAvailable(FilmApp.m402())) {
                        NSDClient.this.resoleLostServer(nsdServiceInfo);
                    } else {
                        NSDClient.this.discoveryCallBack.onServiceLost(null);
                    }
                }
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStartDiscoveryFailed(String str, int i) {
                C4638.m14101(NSDClient.TAG, "onStartDiscoveryFailed--> " + str + Constants.COLON_SEPARATOR + i);
            }

            @Override // android.net.nsd.NsdManager.DiscoveryListener
            public void onStopDiscoveryFailed(String str, int i) {
                C4638.m14101(NSDClient.TAG, "onStopDiscoveryFailed--> " + str + Constants.COLON_SEPARATOR + i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resoleLostServer(NsdServiceInfo nsdServiceInfo) {
        try {
            this.mNsdManager.resolveService(nsdServiceInfo, new NsdManager.ResolveListener() { // from class: com.blink.academy.film.support.socket.NSDClient.3
                @Override // android.net.nsd.NsdManager.ResolveListener
                public void onResolveFailed(NsdServiceInfo nsdServiceInfo2, int i) {
                    C4638.m14101(NSDClient.TAG, " lost onResolveFailed--> " + i + " serviceInfo:" + nsdServiceInfo2);
                }

                @Override // android.net.nsd.NsdManager.ResolveListener
                public void onServiceResolved(NsdServiceInfo nsdServiceInfo2) {
                    C4638.m14101(NSDClient.TAG, "resolution : " + nsdServiceInfo2.getServiceName() + " \t host_from_server: " + nsdServiceInfo2.getHost() + "\t port from server: " + nsdServiceInfo2.getPort());
                    String hostAddress = nsdServiceInfo2.getHost().getHostAddress();
                    StringBuilder sb = new StringBuilder();
                    sb.append(" lost hostAddress ip--> ");
                    sb.append(hostAddress);
                    C4638.m14101(NSDClient.TAG, sb.toString());
                    if (NSDClient.this.discoveryCallBack != null) {
                        NSDClient.this.discoveryCallBack.onServiceLost(nsdServiceInfo2);
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resoleServer(final NsdServiceInfo nsdServiceInfo) {
        NsdManager nsdManager = this.mNsdManager;
        if (nsdManager == null) {
            return;
        }
        nsdManager.resolveService(nsdServiceInfo, new NsdManager.ResolveListener() { // from class: com.blink.academy.film.support.socket.NSDClient.2
            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onResolveFailed(NsdServiceInfo nsdServiceInfo2, int i) {
                C4638.m14101(NSDClient.TAG, "onResolveFailed code:" + i + MyUTIL.white_space + nsdServiceInfo2);
                if (NSDClient.this.mNsdManager == null || i != 3 || NSDClient.this.mStop || NSDClient.mSocketReceiveHandler == null) {
                    return;
                }
                C4638.m14099("slimC213", "onResolveFailed retry");
                NSDClient.mSocketReceiveHandler.postDelayed(new Runnable() { // from class: com.blink.academy.film.support.socket.NSDClient.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        NSDClient.this.resoleServer(nsdServiceInfo);
                    }
                }, 30L);
            }

            @Override // android.net.nsd.NsdManager.ResolveListener
            public void onServiceResolved(NsdServiceInfo nsdServiceInfo2) {
                C4638.m14101(NSDClient.TAG, "resolution : " + nsdServiceInfo2.getServiceName() + " \t host_from_server: " + nsdServiceInfo2.getHost() + "\t port from server: " + nsdServiceInfo2.getPort());
                String hostAddress = nsdServiceInfo2.getHost().getHostAddress();
                StringBuilder sb = new StringBuilder();
                sb.append("found hostAddress ip--> ");
                sb.append(hostAddress);
                C4638.m14101(NSDClient.TAG, sb.toString());
                nsdServiceInfo2.getAttributes().get("wme");
                C4638.m14101(NSDClient.TAG, "serviceInfo message--> " + nsdServiceInfo2);
                if (NSDClient.this.discoveryCallBack != null) {
                    NSDClient.this.discoveryCallBack.onServiceFound(nsdServiceInfo2);
                }
            }
        });
    }

    public void discoveryNSDServer(Context context) {
        this.mNsdManager = (NsdManager) context.getSystemService("servicediscovery");
        initNSDDiscoveryListener();
        this.mNsdManager.discoverServices(SocketHelper.SERVER_TYPE, 1, this.mNSDDiscoveryListener);
    }

    public void setOnDiscoverCallBack(IDiscoveryCallBack iDiscoveryCallBack) {
        this.discoveryCallBack = iDiscoveryCallBack;
    }

    public void startDiscovery(final Context context) {
        this.mStop = false;
        HandlerThread handlerThread = new HandlerThread("server");
        socketReceiveThread = handlerThread;
        handlerThread.setPriority(1);
        socketReceiveThread.start();
        Handler handler = new Handler(socketReceiveThread.getLooper());
        mSocketReceiveHandler = handler;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.socket.NSDClient.4
            @Override // java.lang.Runnable
            public void run() {
                NSDClient.this.discoveryNSDServer(context);
            }
        });
    }

    public void stopDiscovery() {
        this.mStop = true;
        NsdManager nsdManager = this.mNsdManager;
        if (nsdManager != null) {
            nsdManager.stopServiceDiscovery(this.mNSDDiscoveryListener);
        }
        Handler handler = mSocketReceiveHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread = socketReceiveThread;
        if (handlerThread != null) {
            this.mNsdManager = null;
            handlerThread.quit();
            socketReceiveThread = null;
            mSocketReceiveHandler = null;
        }
        this.discoveryCallBack = null;
        C4638.m14099("slimC213", "stopDiscovery");
    }
}
