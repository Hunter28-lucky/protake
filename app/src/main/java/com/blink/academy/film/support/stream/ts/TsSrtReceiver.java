package com.blink.academy.film.support.stream.ts;

import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.support.stream.ts.TsReceiver;
import defpackage.C4672;
import defpackage.C4682;
import defpackage.C4806;
import defpackage.InterfaceC4493;

/* loaded from: classes.dex */
public class TsSrtReceiver implements TsReceiver {
    private static final int SEND_LIMIT_SIZE = 1316;
    private static final Object fence = new Object();
    private byte[] cacheBytes = null;
    private final boolean mCloudLink;
    public TsReceiver.DataCallback mDataCallback;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    private final String mIp;
    private final String mPassphrase;
    private final int mPort;
    public C4672 mSocketClient;
    private final String mStreamId;

    public TsSrtReceiver(TsReceiver.DataCallback dataCallback, String str, int i, String str2, String str3, boolean z) {
        this.mIp = str;
        this.mPort = i;
        this.mPassphrase = str2;
        this.mStreamId = str3;
        this.mCloudLink = z;
        this.mDataCallback = dataCallback;
        HandlerThread handlerThread = new HandlerThread("SrtReceiver");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                TsSrtReceiver.this.init();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] combineBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.mSocketClient = C4806.m14521().m14523();
        C4682 c4682 = new C4682(this.mIp, this.mPort, this.mPassphrase, this.mStreamId);
        if (this.mCloudLink) {
            c4682.m14192(200);
            c4682.m14191(200);
        }
        try {
            this.mSocketClient.m14167(c4682);
            this.mSocketClient.m14174(new InterfaceC4493() { // from class: com.blink.academy.film.support.stream.ts.TsSrtReceiver.2
                @Override // defpackage.InterfaceC4493
                public void onConnectionClose(String str) {
                    TsReceiver.DataCallback dataCallback = TsSrtReceiver.this.mDataCallback;
                    if (dataCallback != null) {
                        dataCallback.onConnectionClose();
                    }
                }

                @Override // defpackage.InterfaceC4493
                public void onRecvBytes(byte[] bArr) {
                    TsReceiver.DataCallback dataCallback = TsSrtReceiver.this.mDataCallback;
                    if (dataCallback != null) {
                        dataCallback.onDataReceived(bArr);
                    }
                }

                public void onRecvMsg(String str) {
                }
            });
        } catch (Exception e2) {
            TsReceiver.DataCallback dataCallback = this.mDataCallback;
            if (dataCallback != null) {
                dataCallback.onInitFail(e2);
            }
            e2.printStackTrace();
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.TsReceiver
    public void release() {
        Handler handler = this.mHandler;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtReceiver.3
            @Override // java.lang.Runnable
            public void run() {
                C4672 c4672 = TsSrtReceiver.this.mSocketClient;
                if (c4672 != null) {
                    try {
                        c4672.m14166();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                TsSrtReceiver.this.mHandlerThread.quitSafely();
            }
        });
    }

    public void sendBytes(final byte[] bArr) {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSrtReceiver.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (TsSrtReceiver.fence) {
                    int length = TsSrtReceiver.this.cacheBytes == null ? 0 : TsSrtReceiver.this.cacheBytes.length;
                    int length2 = bArr.length;
                    byte[] bArr2 = null;
                    if (length2 + length >= TsSrtReceiver.SEND_LIMIT_SIZE) {
                        if (TsSrtReceiver.this.cacheBytes == null) {
                            bArr2 = new byte[TsSrtReceiver.SEND_LIMIT_SIZE];
                            System.arraycopy(bArr, 0, bArr2, 0, TsSrtReceiver.SEND_LIMIT_SIZE);
                            int i = length2 - TsSrtReceiver.SEND_LIMIT_SIZE;
                            if (i > 0) {
                                TsSrtReceiver.this.cacheBytes = new byte[i];
                                System.arraycopy(bArr, TsSrtReceiver.SEND_LIMIT_SIZE, TsSrtReceiver.this.cacheBytes, 0, TsSrtReceiver.this.cacheBytes.length);
                            }
                        } else {
                            byte[] bArr3 = new byte[TsSrtReceiver.SEND_LIMIT_SIZE];
                            System.arraycopy(TsSrtReceiver.this.cacheBytes, 0, bArr3, 0, TsSrtReceiver.this.cacheBytes.length);
                            System.arraycopy(bArr, 0, bArr3, TsSrtReceiver.this.cacheBytes.length, 1316 - TsSrtReceiver.this.cacheBytes.length);
                            TsSrtReceiver.this.cacheBytes = null;
                            int i2 = length2 - (TsSrtReceiver.SEND_LIMIT_SIZE - length);
                            if (i2 > 0) {
                                TsSrtReceiver.this.cacheBytes = new byte[i2];
                                byte[] bArr4 = bArr;
                                System.arraycopy(bArr4, bArr4.length - i2, TsSrtReceiver.this.cacheBytes, 0, TsSrtReceiver.this.cacheBytes.length);
                            }
                            bArr2 = bArr3;
                        }
                    } else if (TsSrtReceiver.this.cacheBytes == null) {
                        TsSrtReceiver.this.cacheBytes = bArr;
                    } else {
                        TsSrtReceiver tsSrtReceiver = TsSrtReceiver.this;
                        tsSrtReceiver.cacheBytes = tsSrtReceiver.combineBytes(tsSrtReceiver.cacheBytes, bArr);
                    }
                    if (bArr2 == null) {
                        return;
                    }
                    TsSrtReceiver.this.mSocketClient.m14171(bArr2);
                }
            }
        });
    }
}
