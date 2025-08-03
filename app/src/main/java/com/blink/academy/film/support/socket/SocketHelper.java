package com.blink.academy.film.support.socket;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.util.Base64;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.bean.socket.SocketMessage;
import com.efs.sdk.base.core.util.NetworkUtil;
import defpackage.C3973;
import defpackage.C4638;
import defpackage.r1;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SocketHelper {
    public static final String BROADCAST_IP = "255.255.255.255";
    public static final int DEFAULT_PORT = 2311;
    public static final int DEFAULT_SEARCH_TIME = 0;
    public static final int DEFAULT_SEND_TIME = 200;
    public static final int DEFAULT_TIMEOUT = 3000;
    public static final String LOCAL_GETWAY_IP = "0.0.0.0";
    public static final String MUTICAST_IP = "224.0.0.11";
    public static final String SERVER_TYPE = "_ba-connection._udp";
    public static final int TYPE_BROADCAST = 1;
    public static final int TYPE_BROADCAST_MULTICAST = 0;
    public static final int TYPE_MULTICAST = 2;
    public static final int TYPE_P2P = 3;
    private static String createTime = "createTime";
    private static String host = "host";
    private static String mDevicesName = null;
    private static String mode = "mode";
    private static String name = "name";

    public static String getCanonicalHostName() {
        return C3973.m12821();
    }

    public static String getLocalIP() {
        return C3973.m12823();
    }

    public static String getLocalName() {
        if (r1.m8138(mDevicesName)) {
            mDevicesName = C3973.m12822();
        }
        return mDevicesName;
    }

    public static SocketMessage getReceiveMessage(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            Base64.decode(bArr, 1);
            String str = new String(bArr);
            C4638.m14101("RECEIVE", "message: " + str.trim());
            if (!r1.m8143(str)) {
                return null;
            }
            SocketMessage socketMessage = new SocketMessage();
            JSONObject jSONObject = new JSONObject(str.trim());
            socketMessage.m498(jSONObject.getString(host));
            socketMessage.m501(jSONObject.getString(name));
            socketMessage.m497(jSONObject.getLong(createTime));
            socketMessage.m499(jSONObject.getInt(mode));
            socketMessage.m500(str.trim());
            return socketMessage;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] getSenderMessage(SocketMessage socketMessage) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(mode, socketMessage.m495());
            if (r1.m8143(socketMessage.m494())) {
                jSONObject.put(host, socketMessage.m494());
            }
            if (r1.m8143(socketMessage.m496())) {
                jSONObject.put(name, socketMessage.m496());
            }
            if (socketMessage.m493() != 0) {
                jSONObject.put(createTime, socketMessage.m493());
            }
            String string = jSONObject.toString();
            C4638.m14101("WME", "sendMessage: " + string);
            return string.getBytes();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static DhcpInfo getWifiInfo() {
        WifiManager wifiManager = (WifiManager) FilmApp.m402().getApplicationContext().getSystemService(NetworkUtil.NETWORK_TYPE_WIFI);
        if (wifiManager != null) {
            return wifiManager.getDhcpInfo();
        }
        return null;
    }

    public static String getWifiName() {
        return C3973.m12824();
    }

    public static String intToIp(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i & 255);
        stringBuffer.append(".");
        stringBuffer.append((i >> 8) & 255);
        stringBuffer.append(".");
        stringBuffer.append((i >> 16) & 255);
        stringBuffer.append(".");
        stringBuffer.append((i >> 24) & 255);
        return stringBuffer.toString();
    }
}
