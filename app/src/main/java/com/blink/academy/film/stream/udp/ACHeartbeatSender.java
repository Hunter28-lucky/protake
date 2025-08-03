package com.blink.academy.film.stream.udp;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import defpackage.C4638;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* loaded from: classes.dex */
public class ACHeartbeatSender {
    public Handler handler;
    public boolean isRunning;
    private Object mReadyFence;
    private DatagramSocket sendSock;
    public HandlerThread thread;

    public ACHeartbeatSender() {
        Object obj = new Object();
        this.mReadyFence = obj;
        this.isRunning = true;
        synchronized (obj) {
            HandlerThread handlerThread = new HandlerThread("ACHeartbeatSender");
            this.thread = handlerThread;
            handlerThread.setPriority(4);
            this.thread.start();
            this.handler = new Handler(this.thread.getLooper(), new Handler.Callback() { // from class: com.blink.academy.film.stream.udp.ACHeartbeatSender.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    return true;
                }
            });
        }
    }

    public void close() {
        DatagramSocket datagramSocket = this.sendSock;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public void init() throws SocketException {
        this.sendSock = new DatagramSocket();
    }

    public void send(byte[] bArr, InetAddress inetAddress, int i) throws IOException {
        DatagramSocket datagramSocket;
        if (!this.isRunning || (datagramSocket = this.sendSock) == null || datagramSocket.isClosed()) {
            return;
        }
        try {
            this.sendSock.send(new DatagramPacket(bArr, bArr.length, inetAddress, i));
        } catch (Exception unused) {
            C4638.m14100("Sender: Error occurred while sending packet");
        }
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }
}
