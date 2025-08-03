package com.blink.academy.film.support.socket.sender;

import defpackage.C4638;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

/* loaded from: classes.dex */
public class Sender implements Runnable {
    private static final byte[] EMPTY_DATA = new byte[0];
    private DatagramSocket datagramSocket;
    public boolean isRunning = true;
    private InetAddress multiCastAddress;
    private MulticastSocket multicastSocket;
    private InetAddress p2pInetAddress;
    private int port;
    private final long sendingInterval;
    private SocketAddress socketAddress;

    public Sender(DatagramSocket datagramSocket, SocketAddress socketAddress, int i) {
        this.datagramSocket = datagramSocket;
        this.socketAddress = socketAddress;
        this.sendingInterval = i;
    }

    public byte[] getNextData() {
        return EMPTY_DATA;
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException, IOException {
        if (this.multiCastAddress != null) {
            while (this.isRunning) {
                try {
                    byte[] nextData = getNextData();
                    this.multicastSocket.send(new DatagramPacket(nextData, nextData.length, this.multiCastAddress, this.port));
                    Thread.sleep(this.sendingInterval);
                } catch (IOException | InterruptedException unused) {
                    C4638.m14100("Sender: Error occurred while sending packet");
                    return;
                }
            }
            return;
        }
        if (this.socketAddress != null) {
            while (this.isRunning) {
                try {
                    byte[] nextData2 = getNextData();
                    this.datagramSocket.send(new DatagramPacket(nextData2, nextData2.length, this.socketAddress));
                    Thread.sleep(this.sendingInterval);
                } catch (IOException | InterruptedException unused2) {
                    C4638.m14100("Sender: Error occurred while sending packet");
                    return;
                }
            }
            return;
        }
        if (this.p2pInetAddress != null) {
            while (this.isRunning) {
                try {
                    byte[] nextData3 = getNextData();
                    this.datagramSocket.send(new DatagramPacket(nextData3, nextData3.length, this.p2pInetAddress, this.port));
                    Thread.sleep(this.sendingInterval);
                } catch (IOException | InterruptedException unused3) {
                    C4638.m14100("Sender: Error occurred while sending packet");
                    return;
                }
            }
        }
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }

    public Sender(MulticastSocket multicastSocket, InetAddress inetAddress, int i, int i2) {
        this.multicastSocket = multicastSocket;
        this.multiCastAddress = inetAddress;
        this.sendingInterval = i;
        this.port = i2;
    }

    public Sender(DatagramSocket datagramSocket, InetAddress inetAddress, int i, int i2) {
        this.datagramSocket = datagramSocket;
        this.p2pInetAddress = inetAddress;
        this.sendingInterval = i;
        this.port = i2;
    }
}
