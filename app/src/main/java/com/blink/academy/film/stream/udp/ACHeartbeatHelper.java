package com.blink.academy.film.stream.udp;

import java.net.InetAddress;

/* loaded from: classes.dex */
public class ACHeartbeatHelper {
    public static final long HEART_BEAT_TIME = 1000;
    private static final int PORT = 2312;
    private static final int PORT_BACK = 1993;
    private static ACHeartbeatHelper instance;
    private ACHeartBeatReceiver receiver;
    private ACHeartbeatSender sender = new ACHeartbeatSender();

    private ACHeartbeatHelper() {
    }

    public static ACHeartbeatHelper getInstance() {
        if (instance == null) {
            synchronized (ACHeartbeatHelper.class) {
                if (instance == null) {
                    instance = new ACHeartbeatHelper();
                }
            }
        }
        return instance;
    }

    public void send(byte[] bArr, InetAddress inetAddress) {
        this.sender.send(bArr, inetAddress, PORT);
        this.sender.send(bArr, inetAddress, PORT_BACK);
    }

    public void start() {
        try {
            ACHeartBeatReceiver aCHeartBeatReceiver = new ACHeartBeatReceiver(PORT, PORT_BACK);
            this.receiver = aCHeartBeatReceiver;
            aCHeartBeatReceiver.setRunning(true);
            this.receiver.init();
            this.sender.setRunning(true);
            this.sender.init();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void stop() {
        ACHeartBeatReceiver aCHeartBeatReceiver = this.receiver;
        if (aCHeartBeatReceiver != null) {
            aCHeartBeatReceiver.setRunning(false);
            this.receiver.close();
        }
        ACHeartbeatSender aCHeartbeatSender = this.sender;
        if (aCHeartbeatSender != null) {
            aCHeartbeatSender.setRunning(false);
            this.sender.close();
        }
    }
}
