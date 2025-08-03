package com.blink.academy.film.stream;

import defpackage.C4638;
import defpackage.r1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class PingHelper {
    public static final int NET_NONE = 0;
    public static final int NET_NO_NET = 1;
    public static final int NET_NO_PROTAKE = 2;
    public static final int NET_VALID = 3;
    private static PingHelper instance;
    private String akamaiIp;
    private NetInfoBean mAkamaiNetInfoBean;
    private int mAkamaiWifiStatus;
    private NetInfoBean mProtakeNetInfoBean;
    private int mProtakeWifiStatus;
    private NetInfoBean mRouterNetInfoBean;
    private int mRouterWifiStatus;
    private String protakeIp;
    private String protakeRealIp;
    private List<Long> protakeDelayList = new ArrayList();
    private long lastProtakeDelay = 1000;
    private List<Long> routerDelayList = new ArrayList();
    private long lastRouterDelay = 1000;
    private List<Long> akamaiDelayList = new ArrayList();
    private long lastAkamaiDelay = 1000;

    private PingHelper() {
    }

    public static PingHelper getInstance() {
        if (instance == null) {
            synchronized (PingHelper.class) {
                if (instance == null) {
                    instance = new PingHelper();
                }
            }
        }
        return instance;
    }

    private long getListSum(List<Long> list) {
        if (!r1.m8144(list)) {
            return 0L;
        }
        int iLongValue = 0;
        Iterator<Long> it = list.iterator();
        while (it.hasNext()) {
            iLongValue = (int) (iLongValue + it.next().longValue());
        }
        return iLongValue;
    }

    private int getWifiState(long j) {
        if (j <= 0) {
            return 0;
        }
        return (int) Math.min(Math.max(100.0f - ((((j - 30) * 1.0f) / 179.0f) * 100.0f), 0.0f), 100.0f);
    }

    public void doPingAkamai() {
        if (this.mAkamaiNetInfoBean == null) {
            this.mAkamaiNetInfoBean = new NetInfoBean();
        }
        if (!r1.m8143(this.akamaiIp)) {
            this.mAkamaiWifiStatus = 0;
            this.akamaiDelayList.clear();
            return;
        }
        this.mAkamaiNetInfoBean.setGatewayIP(this.akamaiIp);
        this.lastAkamaiDelay = PingUtil.getRTT(this.mAkamaiNetInfoBean.getGatewayIP());
        if (this.akamaiDelayList.size() >= 5) {
            this.akamaiDelayList.remove(0);
        }
        this.akamaiDelayList.add(Long.valueOf(this.lastAkamaiDelay));
        this.mAkamaiWifiStatus = getWifiState(getListSum(this.akamaiDelayList) / this.akamaiDelayList.size());
        this.mAkamaiNetInfoBean.setWifiLevel(ACHelper.getInstance().wifiLevel(this.mAkamaiWifiStatus));
        this.mAkamaiNetInfoBean.setWifiStatus(this.mAkamaiWifiStatus);
    }

    public void doPingLocalRouter() {
        this.mRouterNetInfoBean = FinderManager.getInstance().getNetInfoBean();
        this.lastRouterDelay = PingUtil.getRTT(r0.getGatewayIP());
        if (this.routerDelayList.size() >= 5) {
            this.routerDelayList.remove(0);
        }
        this.routerDelayList.add(Long.valueOf(this.lastRouterDelay));
        this.mRouterWifiStatus = getWifiState(getListSum(this.routerDelayList) / this.routerDelayList.size());
        this.mRouterNetInfoBean.setWifiLevel(ACHelper.getInstance().wifiLevel(this.mRouterWifiStatus));
        this.mRouterNetInfoBean.setWifiStatus(this.mRouterWifiStatus);
    }

    public void doPingProtake() {
        if (this.mProtakeNetInfoBean == null) {
            this.mProtakeNetInfoBean = new NetInfoBean();
        }
        String protakeRealIp = r1.m8143(this.protakeIp) ? this.protakeIp : getProtakeRealIp();
        if (!r1.m8143(protakeRealIp)) {
            this.mProtakeWifiStatus = 0;
            this.protakeDelayList.clear();
            return;
        }
        this.mProtakeNetInfoBean.setGatewayIP(protakeRealIp);
        this.lastProtakeDelay = PingUtil.getRTT(this.mProtakeNetInfoBean.getGatewayIP());
        if (this.protakeDelayList.size() >= 5) {
            this.protakeDelayList.remove(0);
        }
        this.protakeDelayList.add(Long.valueOf(this.lastProtakeDelay));
        int wifiState = getWifiState(getListSum(this.protakeDelayList) / this.protakeDelayList.size());
        this.mProtakeWifiStatus = wifiState;
        this.mProtakeWifiStatus = Math.max(1, wifiState);
        this.mProtakeNetInfoBean.setWifiLevel(ACHelper.getInstance().wifiLevel(this.mProtakeWifiStatus));
        this.mProtakeNetInfoBean.setWifiStatus(this.mProtakeWifiStatus);
    }

    public NetInfoBean getAkamaiNetInfoBean() {
        return this.mAkamaiNetInfoBean;
    }

    public int getAkamaiWifiStatus() {
        return this.mAkamaiWifiStatus;
    }

    public int getNetState() {
        if (getAkamaiWifiStatus() == 0 && getProtakeWifiStatus() == 0 && getRouterWifiStatus() == 0) {
            return 0;
        }
        if (getProtakeWifiStatus() == 0 && getAkamaiWifiStatus() == 0) {
            return 1;
        }
        return (getAkamaiWifiStatus() == 0 || getProtakeWifiStatus() != 0) ? 3 : 2;
    }

    public NetInfoBean getProtakeNetInfoBean() {
        return this.mProtakeNetInfoBean;
    }

    public String getProtakeRealIp() {
        String hostAddress;
        if (!r1.m8143(this.protakeRealIp)) {
            try {
                hostAddress = InetAddress.getByName("protake.dafork.com").getHostAddress();
            } catch (UnknownHostException e2) {
                e2.printStackTrace();
                hostAddress = "";
            }
            this.protakeRealIp = hostAddress;
        }
        return this.protakeRealIp;
    }

    public int getProtakeWifiStatus() {
        return this.mProtakeWifiStatus;
    }

    public NetInfoBean getRouterNetInfoBean() {
        if (ACHelper.getInstance().isCloudPush()) {
            this.mRouterNetInfoBean.setWifiLevel(this.mProtakeWifiStatus);
        }
        return this.mRouterNetInfoBean;
    }

    public int getRouterWifiStatus() {
        return this.mRouterWifiStatus;
    }

    public void setAkamaiIp(String str) {
        this.akamaiIp = str;
    }

    public void setProtakeIp(String str) {
        this.protakeIp = str;
    }

    public void test() {
        C4638.m14099("PingHelper", "a:" + getAkamaiWifiStatus() + " p:" + getProtakeWifiStatus() + " r:" + getRouterWifiStatus());
    }
}
