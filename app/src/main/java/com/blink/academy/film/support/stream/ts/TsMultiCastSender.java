package com.blink.academy.film.support.stream.ts;

import android.os.Handler;
import android.os.HandlerThread;
import com.github.thibaultbee.srtdroid.models.Socket;
import defpackage.C4638;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/* loaded from: classes.dex */
public class TsMultiCastSender implements TsSender {
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public int port = 9876;
    public InetAddress group = null;
    public MulticastSocket mutiSocket = null;

    public TsMultiCastSender() {
        HandlerThread handlerThread = new HandlerThread("TsMultiCastSender");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsMultiCastSender.1
            @Override // java.lang.Runnable
            public void run() throws IOException {
                TsMultiCastSender.this.init();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() throws IOException {
        try {
            this.mutiSocket.leaveGroup(this.group);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.group = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() throws IOException {
        try {
            this.group = InetAddress.getByName("230.198.112.0");
            MulticastSocket multicastSocket = new MulticastSocket(this.port);
            this.mutiSocket = multicastSocket;
            multicastSocket.setTimeToLive(1);
            this.mutiSocket.joinGroup(this.group);
        } catch (Exception e2) {
            e2.printStackTrace();
            C4638.m14098("MulticastDemo error ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBytesToGroup(byte[] bArr) throws IOException {
        try {
            this.mutiSocket.send(new DatagramPacket(bArr, bArr.length, this.group, this.port));
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public Socket getSocket() {
        return null;
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void release() {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsMultiCastSender.3
            @Override // java.lang.Runnable
            public void run() throws IOException {
                TsMultiCastSender.this.destroy();
                TsMultiCastSender.this.mHandlerThread.quitSafely();
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void sendData(final byte[] bArr) {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsMultiCastSender.2
            @Override // java.lang.Runnable
            public void run() throws IOException {
                TsMultiCastSender.this.sendBytesToGroup(bArr);
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void sendInfoData(byte[] bArr) {
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public boolean socketAlive() {
        return false;
    }
}
