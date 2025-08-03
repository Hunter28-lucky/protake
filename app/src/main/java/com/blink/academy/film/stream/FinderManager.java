package com.blink.academy.film.stream;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.nsd.NsdServiceInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.udp.ACHeartbeatHelper;
import com.blink.academy.film.support.socket.IDiscoveryCallBack;
import com.blink.academy.film.support.socket.NSDClient;
import com.blink.academy.film.support.socket.NSDServer;
import com.blink.academy.film.support.socket.SocketHelper;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.google.gson.Gson;
import com.umeng.analytics.pro.am;
import defpackage.C2618;
import defpackage.e5;
import defpackage.r1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class FinderManager {
    public static final int BOTH = 3;
    private static final int LOOP_NOT_VALID_DURATION = 3000;
    public static final String MACHINE_A = "1";
    public static final String MACHINE_B = "2";
    public static final String MACHINE_C = "4";
    public static final String MACHINE_D = "8";
    public static final String MACHINE_NOT_VALID = "-1";
    private static final int MSG_SERVER_LOOPER = 500;
    public static final int NO_VALID = -1;
    public static final int ONLY_LOCAL = 1;
    public static final int ONLY_REMOTE = 2;
    private static final int SERVER_LOOP_DELAY = 500;
    private static FinderManager instance;
    public Handler handler;
    private LocalWifiInfoEntity localWifiInfoEntity;
    private NsdServiceInfoEntity mLocalNsdServiceInfoEntity;
    private List<NsdServiceInfoEntity> mLostServiceInfoList;
    private List<NsdServiceInfoEntity> mOriginRemoteNsdServiceInfoList;
    private Map<String, String> mRemoteMap;
    private List<NsdServiceInfoEntity> mRemoteNsdServiceInfoList;
    private OnFinderCallback onFinderCallback;
    private OnNSDServerCallback onNSDServerCallback;
    private boolean start;
    public HandlerThread thread;
    private static final Object remoteMapFence = new Object();
    private static final Object lostFence = new Object();
    private Object mReadyFence = new Object();
    private List<String> validMachineList = new ArrayList();
    private boolean startFinder = false;
    private boolean machineACanUse = true;
    private boolean machineBCanUse = true;
    private boolean machineCCanUse = true;
    private boolean machineDCanUse = true;
    public NetInfoBean netInfoBean = new NetInfoBean();
    private String mSelectMachine = "1";

    public interface OnFinderCallback {
        void needStopPush();
    }

    public interface OnNSDServerCallback {
        void onStartFail();

        void onStartSuc();
    }

    private FinderManager() {
        initRemoteMap();
        this.localWifiInfoEntity = new LocalWifiInfoEntity();
        updateLocalWifiInfo();
        this.mRemoteNsdServiceInfoList = new ArrayList();
        this.mOriginRemoteNsdServiceInfoList = new ArrayList();
        this.mLostServiceInfoList = new ArrayList();
        resetMachineList();
        synchronized (this.mReadyFence) {
            HandlerThread handlerThread = new HandlerThread("LinkEntity");
            this.thread = handlerThread;
            handlerThread.setPriority(4);
            this.thread.start();
            this.handler = new Handler(this.thread.getLooper(), new Handler.Callback() { // from class: com.blink.academy.film.stream.FinderManager.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    if (message.what == 500) {
                        if (r1.m8144(FinderManager.this.mOriginRemoteNsdServiceInfoList)) {
                            try {
                                for (NsdServiceInfoEntity nsdServiceInfoEntity : FinderManager.this.mOriginRemoteNsdServiceInfoList) {
                                    String sv = nsdServiceInfoEntity.getServiceInfoBean().getSv();
                                    if (r1.m8143(sv) && Integer.parseInt(sv) >= 1) {
                                        if (System.currentTimeMillis() - nsdServiceInfoEntity.getTimestamp() <= 3000) {
                                            nsdServiceInfoEntity.setState(0);
                                            FinderManager.this.addToRemote(nsdServiceInfoEntity);
                                        } else if (FinderManager.this.lostNsdContain(nsdServiceInfoEntity)) {
                                            nsdServiceInfoEntity.setState(-1);
                                            LinkManager.getInstance().removeLinkByIP(nsdServiceInfoEntity.getNsdServiceInfo().getHost().getHostAddress());
                                            FinderManager.this.removeNsdServiceInfo(nsdServiceInfoEntity);
                                            FinderManager.this.removeFromLost(nsdServiceInfoEntity);
                                        } else {
                                            FinderManager.this.removeNsdServiceInfo(nsdServiceInfoEntity);
                                        }
                                        if (!FinderManager.this.start) {
                                            HashMap map = new HashMap();
                                            map.put("uuid", nsdServiceInfoEntity.getServiceInfoBean().getUuid());
                                            map.put("time", System.currentTimeMillis() + "");
                                            map.put(am.aE, "1");
                                            map.put("sv", "1");
                                            ACHeartbeatHelper.getInstance().send(new Gson().toJson(map).getBytes(), nsdServiceInfoEntity.getNsdServiceInfo().getHost());
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (FinderManager.this.startFinder) {
                            FinderManager.this.handler.sendEmptyMessageDelayed(500, 500L);
                        }
                    }
                    return true;
                }
            });
        }
    }

    private void addOrUpdarteNsdServiceInfo(NsdServiceInfoEntity nsdServiceInfoEntity) {
        int i = -1;
        if (r1.m8144(this.mRemoteNsdServiceInfoList)) {
            int i2 = -1;
            boolean z = false;
            for (int i3 = 0; i3 < this.mRemoteNsdServiceInfoList.size(); i3++) {
                NsdServiceInfoEntity nsdServiceInfoEntity2 = this.mRemoteNsdServiceInfoList.get(i3);
                if (nsdServiceInfoEntity2.getNsdServiceInfo().getHost().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost())) {
                    nsdServiceInfoEntity2.setServiceInfoBean(nsdServiceInfoEntity.getServiceInfoBean());
                    nsdServiceInfoEntity2.setNsdServiceInfo(nsdServiceInfoEntity.getNsdServiceInfo());
                    z = true;
                } else {
                    ServiceInfoBean serviceInfoBean = nsdServiceInfoEntity2.getServiceInfoBean();
                    ServiceInfoBean serviceInfoBean2 = nsdServiceInfoEntity.getServiceInfoBean();
                    if (serviceInfoBean != null && serviceInfoBean2 != null && serviceInfoBean.getMachine().equals(serviceInfoBean2.getMachine())) {
                        i2 = i3;
                    }
                }
            }
            if (!z) {
                onFindDevice(nsdServiceInfoEntity.getNsdServiceInfo().getHost());
                this.mRemoteNsdServiceInfoList.add(nsdServiceInfoEntity);
            }
            if (i2 >= 0) {
                this.mRemoteNsdServiceInfoList.remove(i2);
            }
        } else {
            onFindDevice(nsdServiceInfoEntity.getNsdServiceInfo().getHost());
            this.mRemoteNsdServiceInfoList.add(nsdServiceInfoEntity);
        }
        if (!r1.m8144(this.mOriginRemoteNsdServiceInfoList)) {
            nsdServiceInfoEntity.setTimestamp(System.currentTimeMillis());
            this.mOriginRemoteNsdServiceInfoList.add(nsdServiceInfoEntity);
            return;
        }
        boolean z2 = false;
        for (int i4 = 0; i4 < this.mOriginRemoteNsdServiceInfoList.size(); i4++) {
            NsdServiceInfoEntity nsdServiceInfoEntity3 = this.mOriginRemoteNsdServiceInfoList.get(i4);
            if (nsdServiceInfoEntity3.getNsdServiceInfo().getHost().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost())) {
                nsdServiceInfoEntity3.setServiceInfoBean(nsdServiceInfoEntity.getServiceInfoBean());
                nsdServiceInfoEntity3.setNsdServiceInfo(nsdServiceInfoEntity.getNsdServiceInfo());
                z2 = true;
            } else {
                ServiceInfoBean serviceInfoBean3 = nsdServiceInfoEntity3.getServiceInfoBean();
                ServiceInfoBean serviceInfoBean4 = nsdServiceInfoEntity.getServiceInfoBean();
                if (serviceInfoBean3 != null && serviceInfoBean4 != null && serviceInfoBean3.getMachine().equals(serviceInfoBean4.getMachine())) {
                    i = i4;
                }
            }
        }
        if (!z2) {
            nsdServiceInfoEntity.setTimestamp(System.currentTimeMillis());
            this.mOriginRemoteNsdServiceInfoList.add(nsdServiceInfoEntity);
        }
        if (i >= 0) {
            this.mOriginRemoteNsdServiceInfoList.remove(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addToRemote(NsdServiceInfoEntity nsdServiceInfoEntity) {
        if (!r1.m8144(this.mRemoteNsdServiceInfoList)) {
            this.mRemoteNsdServiceInfoList.add(nsdServiceInfoEntity);
            return;
        }
        int i = -1;
        boolean z = false;
        for (int i2 = 0; i2 < this.mRemoteNsdServiceInfoList.size(); i2++) {
            NsdServiceInfoEntity nsdServiceInfoEntity2 = this.mRemoteNsdServiceInfoList.get(i2);
            if (nsdServiceInfoEntity2.getNsdServiceInfo().getHost().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost())) {
                nsdServiceInfoEntity2.setServiceInfoBean(nsdServiceInfoEntity.getServiceInfoBean());
                nsdServiceInfoEntity2.setNsdServiceInfo(nsdServiceInfoEntity.getNsdServiceInfo());
                z = true;
            } else {
                ServiceInfoBean serviceInfoBean = nsdServiceInfoEntity2.getServiceInfoBean();
                ServiceInfoBean serviceInfoBean2 = nsdServiceInfoEntity.getServiceInfoBean();
                if (serviceInfoBean != null && serviceInfoBean2 != null && serviceInfoBean.getMachine().equals(serviceInfoBean2.getMachine())) {
                    i = i2;
                }
            }
        }
        if (!z) {
            this.mRemoteNsdServiceInfoList.add(nsdServiceInfoEntity);
        }
        if (i >= 0) {
            this.mRemoteNsdServiceInfoList.remove(i);
        }
    }

    public static FinderManager getInstance() {
        if (instance == null) {
            synchronized (FinderManager.class) {
                if (instance == null) {
                    instance = new FinderManager();
                }
            }
        }
        return instance;
    }

    private void initRemoteMap() {
        HashMap map = new HashMap();
        this.mRemoteMap = map;
        map.put("1", C2618.m9569("remote_map_a_sp", ""));
        this.mRemoteMap.put("2", C2618.m9569("remote_map_b_sp", ""));
        this.mRemoteMap.put(MACHINE_C, C2618.m9569("remote_map_c_sp", ""));
        this.mRemoteMap.put(MACHINE_D, C2618.m9569("remote_map_d_sp", ""));
    }

    private boolean isLocalNsdServiceInfo(NsdServiceInfoEntity nsdServiceInfoEntity) {
        return SocketHelper.getLocalIP().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost().getHostAddress()) && 2311 == nsdServiceInfoEntity.getNsdServiceInfo().getPort();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean lostNsdContain(NsdServiceInfoEntity nsdServiceInfoEntity) {
        if (!r1.m8144(this.mLostServiceInfoList)) {
            return false;
        }
        Iterator<NsdServiceInfoEntity> it = this.mLostServiceInfoList.iterator();
        while (it.hasNext()) {
            NsdServiceInfo nsdServiceInfo = it.next().getNsdServiceInfo();
            NsdServiceInfo nsdServiceInfo2 = nsdServiceInfoEntity.getNsdServiceInfo();
            if (nsdServiceInfo2 != null && nsdServiceInfo != null) {
                return nsdServiceInfo2.getHost().getHostAddress().equals(nsdServiceInfo.getHost().getHostAddress());
            }
        }
        return false;
    }

    private void resetMachineList() {
        this.validMachineList.clear();
        this.validMachineList.add("1");
        this.validMachineList.add("2");
        this.validMachineList.add(MACHINE_C);
        this.validMachineList.add(MACHINE_D);
    }

    private void updateLocalWifiInfo() {
        String localIP = SocketHelper.getLocalIP();
        String localName = SocketHelper.getLocalName();
        WifiInfo connectionInfo = ((WifiManager) FilmApp.m405().getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
        int rssi = connectionInfo.getRssi();
        String ssid = connectionInfo.getSSID();
        String bssid = connectionInfo.getBSSID();
        this.localWifiInfoEntity.setIp(localIP);
        this.localWifiInfoEntity.setDeviceName(localName);
        this.localWifiInfoEntity.setBssid(bssid);
        this.localWifiInfoEntity.setSsid(ssid);
        this.localWifiInfoEntity.setRssi(rssi);
    }

    public void addNsdServiceInfo(NsdServiceInfoEntity nsdServiceInfoEntity) throws NumberFormatException {
        if (isLocalNsdServiceInfo(nsdServiceInfoEntity)) {
            return;
        }
        addOrUpdarteNsdServiceInfo(nsdServiceInfoEntity);
        updateOnRemoteNsdServiceInfoListChange();
        if (lostNsdContain(nsdServiceInfoEntity)) {
            removeFromLost(nsdServiceInfoEntity);
        }
    }

    public void addToLost(NsdServiceInfoEntity nsdServiceInfoEntity) {
        synchronized (lostFence) {
            if (!lostNsdContain(nsdServiceInfoEntity)) {
                this.mLostServiceInfoList.add(nsdServiceInfoEntity);
            }
        }
    }

    public NsdServiceInfoEntity getLocalNsdServiceInfoEntity() {
        return this.mLocalNsdServiceInfoEntity;
    }

    public LocalWifiInfoEntity getLocalWifiInfoEntity(boolean z) {
        if (z) {
            updateLocalWifiInfo();
        }
        return this.localWifiInfoEntity;
    }

    public String getMachineByLinkIndex(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : MACHINE_D : MACHINE_C : "2" : "1";
    }

    public NetInfoBean getNetInfoBean() {
        DhcpInfo wifiInfo = SocketHelper.getWifiInfo();
        WifiInfo connectionInfo = ((WifiManager) FilmApp.m405().getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI)).getConnectionInfo();
        this.netInfoBean.setLocalIP(SocketHelper.getLocalIP());
        this.netInfoBean.setLocalName(SocketHelper.getLocalName());
        this.netInfoBean.setGatewayIP(SocketHelper.intToIp(wifiInfo.gateway));
        this.netInfoBean.setBssid(connectionInfo.getBSSID());
        this.netInfoBean.setSsid(connectionInfo.getSSID());
        return this.netInfoBean;
    }

    public NsdServiceInfoEntity getNsdServiceInfoEntityByMachine(String str) {
        if (!r1.m8144(this.mRemoteNsdServiceInfoList)) {
            return null;
        }
        for (NsdServiceInfoEntity nsdServiceInfoEntity : this.mRemoteNsdServiceInfoList) {
            if (str.equals(nsdServiceInfoEntity.getServiceInfoBean().getMachine())) {
                return nsdServiceInfoEntity;
            }
        }
        return null;
    }

    public List<NsdServiceInfoEntity> getRemoteNsdServiceInfoList() {
        return this.mRemoteNsdServiceInfoList;
    }

    public String getRemoteRoomIdByMachine(String str) {
        String str2;
        synchronized (remoteMapFence) {
            str2 = this.mRemoteMap.get(str);
        }
        return str2;
    }

    public String getSelectMachine() {
        return this.mSelectMachine;
    }

    public boolean isStart() {
        return this.start;
    }

    public boolean machineCanConn(String str) {
        if (!r1.m8144(this.mRemoteNsdServiceInfoList)) {
            return false;
        }
        Iterator<NsdServiceInfoEntity> it = this.mRemoteNsdServiceInfoList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().getServiceInfoBean().getMachine())) {
                return true;
            }
        }
        return false;
    }

    public boolean machineCanConnRemote(String str) {
        boolean zM8143;
        synchronized (remoteMapFence) {
            zM8143 = r1.m8143(this.mRemoteMap.get(str));
        }
        return zM8143;
    }

    public int machineCanConnect(String str) {
        boolean zMachineCanConn = machineCanConn(str);
        boolean zMachineCanConnRemote = machineCanConnRemote(str);
        if (zMachineCanConn && zMachineCanConnRemote) {
            return 3;
        }
        if (zMachineCanConn) {
            return 1;
        }
        return zMachineCanConnRemote ? 2 : -1;
    }

    public boolean machineCanUse(String str) {
        str.hashCode();
        switch (str) {
            case "1":
                return this.machineACanUse;
            case "2":
                return this.machineBCanUse;
            case "4":
                return this.machineCCanUse;
            case "8":
                return this.machineDCanUse;
            default:
                return false;
        }
    }

    public void onFindDevice(InetAddress inetAddress) {
        try {
            HashMap map = new HashMap();
            map.put("uuid", e5.m5988().m5991());
            map.put("time", System.currentTimeMillis() + "");
            map.put(am.aE, "1");
            map.put("sv", "1");
            ACHeartbeatHelper.getInstance().send(new Gson().toJson(map).getBytes(), inetAddress);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onGetUDPMsg(String str, String str2) throws UnknownHostException {
        Map map = (Map) new Gson().fromJson(str2, Map.class);
        if (map == null || !map.containsKey("uuid")) {
            return;
        }
        String str3 = (String) map.get("uuid");
        if (r1.m8144(this.mOriginRemoteNsdServiceInfoList)) {
            Iterator<NsdServiceInfoEntity> it = this.mOriginRemoteNsdServiceInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                NsdServiceInfoEntity next = it.next();
                if (next.getServiceInfoBean().getUuid().equals(str3)) {
                    next.setTimestamp(System.currentTimeMillis());
                    break;
                }
            }
        }
        if (this.start && e5.m5988().m5991().equals(str3)) {
            try {
                ACHeartbeatHelper.getInstance().send(str2.getBytes(), InetAddress.getByName(str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void onNetClose() {
        this.mRemoteNsdServiceInfoList.clear();
    }

    public void release() {
        releaseServer();
        stopNSDFinder();
        this.mRemoteNsdServiceInfoList.clear();
        this.mOriginRemoteNsdServiceInfoList.clear();
        this.mLostServiceInfoList.clear();
        this.onFinderCallback = null;
    }

    public void releaseServer() {
        NSDServer.getInstance().stopNSDServer();
        this.start = false;
        this.mLocalNsdServiceInfoEntity = null;
    }

    public void removeFromLost(NsdServiceInfoEntity nsdServiceInfoEntity) {
        synchronized (lostFence) {
            if (r1.m8144(this.mLostServiceInfoList)) {
                Iterator<NsdServiceInfoEntity> it = this.mLostServiceInfoList.iterator();
                while (it.hasNext()) {
                    if (it.next().getNsdServiceInfo().getHost().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost())) {
                        it.remove();
                    }
                }
            }
        }
    }

    public void removeNsdOriginServiceInfo(NsdServiceInfoEntity nsdServiceInfoEntity) {
        if (r1.m8144(this.mOriginRemoteNsdServiceInfoList)) {
            Iterator<NsdServiceInfoEntity> it = this.mOriginRemoteNsdServiceInfoList.iterator();
            while (it.hasNext()) {
                if (it.next().getNsdServiceInfo().getHost().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost())) {
                    it.remove();
                }
            }
        }
    }

    public void removeNsdServiceInfo(NsdServiceInfoEntity nsdServiceInfoEntity) throws NumberFormatException {
        if (r1.m8144(this.mRemoteNsdServiceInfoList)) {
            Iterator<NsdServiceInfoEntity> it = this.mRemoteNsdServiceInfoList.iterator();
            while (it.hasNext()) {
                if (it.next().getNsdServiceInfo().getHost().equals(nsdServiceInfoEntity.getNsdServiceInfo().getHost())) {
                    it.remove();
                }
            }
        }
        updateOnRemoteNsdServiceInfoListChange();
    }

    public void restartNSDServer() {
        if (this.start) {
            NSDServer.getInstance().restartNSDServer(SocketHelper.getLocalName() + System.currentTimeMillis(), this.onNSDServerCallback);
        }
    }

    public void setOnFinderCallback(OnFinderCallback onFinderCallback) {
        this.onFinderCallback = onFinderCallback;
    }

    public void setSelectMachine(String str) {
        this.mSelectMachine = str;
    }

    public void startNSDFinder(Context context, IDiscoveryCallBack iDiscoveryCallBack, OnFinderCallback onFinderCallback) {
        this.onFinderCallback = onFinderCallback;
        this.startFinder = true;
        ACHeartbeatHelper.getInstance().start();
        if (r1.m8144(this.mOriginRemoteNsdServiceInfoList)) {
            Iterator<NsdServiceInfoEntity> it = this.mOriginRemoteNsdServiceInfoList.iterator();
            while (it.hasNext()) {
                onFindDevice(it.next().getNsdServiceInfo().getHost());
            }
        }
        NSDClient.getInstance().startDiscovery(context);
        NSDClient.getInstance().setOnDiscoverCallBack(iDiscoveryCallBack);
        this.handler.sendEmptyMessageDelayed(500, 500L);
    }

    public void startNSDServer(Context context, OnNSDServerCallback onNSDServerCallback) {
        this.onNSDServerCallback = onNSDServerCallback;
        NSDServer.getInstance().stopNSDServer();
        NSDServer.getInstance().startNSDServer(context, SocketHelper.getLocalName(), 2311, onNSDServerCallback);
        this.start = true;
    }

    public void stopNSDFinder() {
        ACHeartbeatHelper.getInstance().stop();
        NSDClient.getInstance().stopDiscovery();
        this.startFinder = false;
    }

    public void updateLocalNsdServiceInfo(NsdServiceInfoEntity nsdServiceInfoEntity) {
        this.mLocalNsdServiceInfoEntity = nsdServiceInfoEntity;
    }

    public void updateOnRemoteNsdServiceInfoListChange() throws NumberFormatException {
        ServiceInfoBean serviceInfoBean;
        resetMachineList();
        if (r1.m8144(this.mRemoteNsdServiceInfoList)) {
            for (NsdServiceInfoEntity nsdServiceInfoEntity : this.mRemoteNsdServiceInfoList) {
                ServiceInfoBean serviceInfoBean2 = nsdServiceInfoEntity.getServiceInfoBean();
                if (serviceInfoBean2 != null) {
                    String machine = serviceInfoBean2.getMachine();
                    NsdServiceInfoEntity nsdServiceInfoEntity2 = this.mLocalNsdServiceInfoEntity;
                    boolean z = true;
                    if (nsdServiceInfoEntity2 != null && (serviceInfoBean = nsdServiceInfoEntity2.getServiceInfoBean()) != null && machine.equals(serviceInfoBean.getMachine())) {
                        String time = serviceInfoBean.getTime();
                        if (r1.m8143(time)) {
                            double d = Double.parseDouble(time);
                            ServiceInfoBean serviceInfoBean3 = nsdServiceInfoEntity.getServiceInfoBean();
                            if (serviceInfoBean3 != null) {
                                String time2 = serviceInfoBean3.getTime();
                                if (r1.m8143(time2) && Double.parseDouble(time2) >= d) {
                                    z = false;
                                }
                            }
                        }
                    }
                    if (z) {
                        this.validMachineList.remove(machine);
                        if (this.mSelectMachine.equals(machine)) {
                            if (r1.m8144(this.validMachineList)) {
                                this.mSelectMachine = this.validMachineList.get(0);
                                OnFinderCallback onFinderCallback = this.onFinderCallback;
                                if (onFinderCallback != null) {
                                    onFinderCallback.needStopPush();
                                }
                            } else {
                                this.mSelectMachine = MACHINE_NOT_VALID;
                                OnFinderCallback onFinderCallback2 = this.onFinderCallback;
                                if (onFinderCallback2 != null) {
                                    onFinderCallback2.needStopPush();
                                }
                            }
                        }
                    }
                }
            }
            if (this.mSelectMachine.equals(MACHINE_NOT_VALID) && r1.m8144(this.validMachineList)) {
                this.mSelectMachine = this.validMachineList.get(0);
            }
        }
        this.machineACanUse = this.validMachineList.contains("1");
        this.machineBCanUse = this.validMachineList.contains("2");
        this.machineCCanUse = this.validMachineList.contains(MACHINE_C);
        this.machineDCanUse = this.validMachineList.contains(MACHINE_D);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7 A[Catch: all -> 0x00fe, TryCatch #0 {, blocks: (B:4:0x0009, B:5:0x0013, B:7:0x0025, B:9:0x0039, B:33:0x007f, B:34:0x0087, B:35:0x008f, B:36:0x0098, B:15:0x004d, B:18:0x0057, B:21:0x0061, B:24:0x006b, B:37:0x00a1, B:65:0x00fc, B:61:0x00e5, B:62:0x00eb, B:63:0x00f1, B:64:0x00f7, B:43:0x00b3, B:46:0x00bd, B:49:0x00c7, B:52:0x00d1), top: B:70:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0078 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateRemoteMap(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.FinderManager.updateRemoteMap(java.lang.String, java.lang.String):void");
    }
}
