package com.blink.academy.film.support.stream.ts;

import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.support.socket.SocketHelper;
import com.github.thibaultbee.srtdroid.models.Socket;
import defpackage.C2701;
import defpackage.C4806;

/* loaded from: classes.dex */
public class TsSrtSender implements TsSender {
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    public boolean released = false;
    public C2701 socketServer;

    public TsSrtSender() {
        HandlerThread handlerThread = new HandlerThread("TsSrtSender");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtSender.1
            @Override // java.lang.Runnable
            public void run() {
                TsSrtSender.this.init();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        C2701 c2701M14524 = C4806.m14521().m14524();
        this.socketServer = c2701M14524;
        c2701M14524.m9937(SocketHelper.LOCAL_GETWAY_IP, 2311);
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public Socket getSocket() {
        return null;
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void release() {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtSender.4
            @Override // java.lang.Runnable
            public void run() {
                TsSrtSender tsSrtSender = TsSrtSender.this;
                tsSrtSender.released = true;
                tsSrtSender.socketServer.m9936();
                TsSrtSender tsSrtSender2 = TsSrtSender.this;
                tsSrtSender2.socketServer = null;
                tsSrtSender2.mHandler.removeCallbacksAndMessages(null);
                TsSrtSender.this.mHandlerThread.quitSafely();
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void sendData(final byte[] bArr) {
        if (this.released) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtSender.2
            @Override // java.lang.Runnable
            public void run() {
                TsSrtSender.this.socketServer.m9940(bArr);
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void sendInfoData(final byte[] bArr) {
        if (this.released) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtSender.3
            @Override // java.lang.Runnable
            public void run() {
                TsSrtSender.this.socketServer.m9939(bArr);
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public boolean socketAlive() {
        return false;
    }
}
