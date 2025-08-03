package com.blink.academy.film.support.socket.receiver;

import defpackage.C4638;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/* loaded from: classes.dex */
public class Receiver extends Thread {
    private static final int BUF_SIZE = 512;
    private DatagramSocket datagramSocket;
    private InetAddress inetAddress;
    public boolean isRunning = true;
    private MulticastSocket multicastSocket;

    public Receiver(MulticastSocket multicastSocket, InetAddress inetAddress) {
        this.multicastSocket = multicastSocket;
        this.inetAddress = inetAddress;
    }

    public boolean handlePacket(DatagramPacket datagramPacket) {
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws IOException {
        try {
            MulticastSocket multicastSocket = this.multicastSocket;
            if (multicastSocket == null) {
                while (this.isRunning) {
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[512], 512);
                    this.datagramSocket.receive(datagramPacket);
                    if (!handlePacket(datagramPacket)) {
                        break;
                    }
                }
                this.datagramSocket.close();
                return;
            }
            multicastSocket.joinGroup(this.inetAddress);
            while (this.isRunning) {
                DatagramPacket datagramPacket2 = new DatagramPacket(new byte[512], 512);
                this.multicastSocket.receive(datagramPacket2);
                if (!handlePacket(datagramPacket2)) {
                    break;
                }
            }
            this.multicastSocket.leaveGroup(this.inetAddress);
            this.multicastSocket.close();
        } catch (IOException unused) {
            C4638.m14100("Socket was closed.");
        }
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }

    public Receiver(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }
}
