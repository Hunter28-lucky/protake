package com.blink.academy.film.stream.udp;

import com.blink.academy.film.stream.FinderManager;
import defpackage.C4638;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class ACHeartBeatReceiver extends Thread {
    private static final int BUF_SIZE = 512;
    private InetAddress inetAddress;
    private boolean isRunning = true;
    private int mBackPort;
    private int mPort;
    private DatagramSocket recSocket;

    public ACHeartBeatReceiver(int i, int i2) {
        this.mPort = i;
        this.mBackPort = i2;
    }

    public void close() {
        DatagramSocket datagramSocket = this.recSocket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public void init() throws SocketException {
        try {
            this.recSocket = new DatagramSocket(this.mPort);
        } catch (SocketException unused) {
            this.recSocket = new DatagramSocket(this.mBackPort);
        }
        start();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IOException {
        while (this.isRunning) {
            try {
                DatagramPacket datagramPacket = new DatagramPacket(new byte[512], 512);
                this.recSocket.receive(datagramPacket);
                String hostAddress = datagramPacket.getAddress().getHostAddress();
                String str = new String(datagramPacket.getData(), 0, datagramPacket.getLength(), StandardCharsets.UTF_8);
                C4638.m14099("slimmmmmmm", "ip:" + hostAddress + " str:" + str);
                FinderManager.getInstance().onGetUDPMsg(hostAddress, str);
            } catch (IOException unused) {
                C4638.m14100("Socket was closed.");
                return;
            }
        }
        this.recSocket.close();
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }
}
