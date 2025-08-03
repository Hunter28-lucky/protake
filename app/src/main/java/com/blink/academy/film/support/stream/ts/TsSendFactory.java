package com.blink.academy.film.support.stream.ts;

import android.os.Handler;
import android.os.HandlerThread;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.support.stream.ts.TsParser;
import com.github.thibaultbee.srtdroid.models.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TsSendFactory {
    private static final int SEND_LIMIT_SIZE = 1316;
    public static boolean VERBOSE = false;
    private static final Object fence = new Object();
    private static final Object fence2 = new Object();
    public byte[] SPSAndPPS;
    private byte[] cacheBytes;
    private byte[] cacheBytesForInfo;
    private boolean destroyed;
    private boolean enablePublicNetTsSender;
    private boolean enableTsSender;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    public ContinuityCounter mMsgContinuityCounter;
    public TsSender mPublicNetTsSender;
    public TsSender mTsSender;
    public ContinuityCounter mVideoContinuityCounter;

    public TsSendFactory() {
        this(true, false, null, 0, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeH264EsToTs(EsPacket esPacket) {
        if (esPacket.getType() == 2) {
            this.SPSAndPPS = esPacket.getData();
            return;
        }
        if (this.SPSAndPPS == null) {
            return;
        }
        PesPacket pesPacket = new PesPacket(esPacket, this.SPSAndPPS);
        if (pesPacket.isI) {
            sendBytes(new TsPacket(PatPacket.PatPacket()).mBytes);
            sendBytes(new TsPacket(PmtPacket.PMTPacket()).mBytes);
        }
        TsParser.PesToTs(pesPacket, this.mVideoContinuityCounter, new TsParser.TsCallback() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.11
            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onFinish() {
            }

            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onTsPacketReady(TsPacket tsPacket) {
                TsSendFactory.this.sendBytes(tsPacket.mBytes);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeH265EsToTs(EsPacket esPacket) {
        if (esPacket.getType() == 2) {
            this.SPSAndPPS = esPacket.getData();
            return;
        }
        if (this.SPSAndPPS == null) {
            return;
        }
        PesPacket pesPacket = new PesPacket(esPacket, this.SPSAndPPS);
        final ArrayList arrayList = new ArrayList();
        if (pesPacket.isI) {
            arrayList.add(new TsPacket(PatPacket.PatPacket()).mBytes);
            arrayList.add(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        }
        TsParser.PesToTs(pesPacket, this.mVideoContinuityCounter, new TsParser.TsCallback() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.9
            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onFinish() {
                if (arrayList.size() > 0) {
                    TsSendFactory tsSendFactory = TsSendFactory.this;
                    tsSendFactory.sendBytes(tsSendFactory.mergeBytes(arrayList));
                    arrayList.clear();
                }
            }

            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onTsPacketReady(TsPacket tsPacket) {
                arrayList.add(tsPacket.mBytes);
                if (arrayList.size() >= 7) {
                    TsSendFactory tsSendFactory = TsSendFactory.this;
                    tsSendFactory.sendBytes(tsSendFactory.mergeBytes(arrayList));
                    arrayList.clear();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeMsgDataToTs(EsPacket esPacket) {
        TsParser.MsgToTs(new PesPacket(esPacket.data), this.mMsgContinuityCounter, new TsParser.TsCallback() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.10
            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onFinish() {
            }

            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onTsPacketReady(TsPacket tsPacket) {
                TsSendFactory.this.sendInfoBytes(tsPacket.mBytes);
            }
        });
    }

    private byte[] combineBytes(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disablePublicNetSender() {
        this.enablePublicNetTsSender = false;
        TsSender tsSender = this.mPublicNetTsSender;
        if (tsSender != null) {
            tsSender.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disableTsSender() {
        this.enableTsSender = false;
        TsSender tsSender = this.mTsSender;
        if (tsSender != null) {
            tsSender.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enablePublicNetSender(String str, int i, String str2, String str3) {
        if (this.enablePublicNetTsSender) {
            this.mPublicNetTsSender.release();
        }
        this.enablePublicNetTsSender = true;
        this.mPublicNetTsSender = new TsPublicNetSrtSender(str, i, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enableTsSender() {
        this.enableTsSender = true;
        this.mTsSender = new TsSrtSender();
    }

    private void init() {
        this.mVideoContinuityCounter = new ContinuityCounter();
        this.mMsgContinuityCounter = new ContinuityCounter();
        HandlerThread handlerThread = new HandlerThread("TsSendFactory");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] mergeBytes(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBytes(byte[] bArr) {
        synchronized (fence) {
            byte[] bArr2 = this.cacheBytes;
            int length = bArr2 == null ? 0 : bArr2.length;
            int length2 = bArr.length;
            byte[] bArr3 = null;
            if (length2 + length >= SEND_LIMIT_SIZE) {
                if (bArr2 == null) {
                    bArr3 = new byte[SEND_LIMIT_SIZE];
                    System.arraycopy(bArr, 0, bArr3, 0, SEND_LIMIT_SIZE);
                    int i = length2 - SEND_LIMIT_SIZE;
                    if (i > 0) {
                        byte[] bArr4 = new byte[i];
                        this.cacheBytes = bArr4;
                        System.arraycopy(bArr, SEND_LIMIT_SIZE, bArr4, 0, bArr4.length);
                    }
                } else {
                    byte[] bArr5 = new byte[SEND_LIMIT_SIZE];
                    System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
                    byte[] bArr6 = this.cacheBytes;
                    System.arraycopy(bArr, 0, bArr5, bArr6.length, 1316 - bArr6.length);
                    this.cacheBytes = null;
                    int i2 = length2 - (SEND_LIMIT_SIZE - length);
                    if (i2 > 0) {
                        byte[] bArr7 = new byte[i2];
                        this.cacheBytes = bArr7;
                        System.arraycopy(bArr, bArr.length - i2, bArr7, 0, bArr7.length);
                    }
                    bArr3 = bArr5;
                }
            } else if (bArr2 == null) {
                this.cacheBytes = bArr;
            } else {
                this.cacheBytes = combineBytes(bArr2, bArr);
            }
            if (bArr3 == null) {
                return;
            }
            if (this.enableTsSender) {
                this.mTsSender.sendData(bArr3);
            }
            if (this.enablePublicNetTsSender && LinkManager.getInstance().canSendVideoData()) {
                this.mPublicNetTsSender.sendData(bArr3);
            }
        }
    }

    public void disableLocalNet() {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.4
            @Override // java.lang.Runnable
            public void run() {
                TsSendFactory.this.disableTsSender();
            }
        });
    }

    public void disablePublicNet() {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.2
            @Override // java.lang.Runnable
            public void run() {
                TsSendFactory.this.disablePublicNetSender();
            }
        });
    }

    public void enableLocalNet() {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.3
            @Override // java.lang.Runnable
            public void run() {
                TsSendFactory.this.enableTsSender();
            }
        });
    }

    public void enablePublicNet(final String str, final int i, final String str2, final String str3) {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.1
            @Override // java.lang.Runnable
            public void run() {
                TsSendFactory.this.enablePublicNetSender(str, i, str2, str3);
            }
        });
    }

    public Socket getPublicSocket() {
        TsSender tsSender = this.mPublicNetTsSender;
        if (tsSender == null) {
            return null;
        }
        return tsSender.getSocket();
    }

    public boolean publicSocketAlive() {
        TsSender tsSender = this.mPublicNetTsSender;
        if (tsSender == null) {
            return false;
        }
        return tsSender.socketAlive();
    }

    public void release() {
        this.destroyed = true;
        this.cacheBytes = null;
        this.cacheBytesForInfo = null;
        if (this.enableTsSender) {
            disableTsSender();
        }
        if (this.enablePublicNetTsSender) {
            disablePublicNetSender();
        }
        this.mHandlerThread.quitSafely();
    }

    public void sendH264EsData(final EsPacket esPacket) {
        if (this.destroyed) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.7
            @Override // java.lang.Runnable
            public void run() {
                if (TsSendFactory.this.destroyed) {
                    return;
                }
                TsSendFactory.this.changeH264EsToTs(esPacket);
            }
        });
    }

    public void sendH265EsData(final EsPacket esPacket) {
        if (this.destroyed) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.8
            @Override // java.lang.Runnable
            public void run() {
                if (TsSendFactory.this.destroyed) {
                    return;
                }
                TsSendFactory.this.changeH265EsToTs(esPacket);
            }
        });
    }

    public void sendInfoBytes(byte[] bArr) {
        synchronized (fence2) {
            byte[] bArr2 = this.cacheBytesForInfo;
            int length = bArr2 == null ? 0 : bArr2.length;
            int length2 = bArr.length;
            byte[] bArr3 = null;
            if (length2 + length >= SEND_LIMIT_SIZE) {
                if (bArr2 == null) {
                    bArr3 = new byte[SEND_LIMIT_SIZE];
                    System.arraycopy(bArr, 0, bArr3, 0, SEND_LIMIT_SIZE);
                    int i = length2 - SEND_LIMIT_SIZE;
                    if (i > 0) {
                        byte[] bArr4 = new byte[i];
                        this.cacheBytesForInfo = bArr4;
                        System.arraycopy(bArr, SEND_LIMIT_SIZE, bArr4, 0, bArr4.length);
                    }
                } else {
                    byte[] bArr5 = new byte[SEND_LIMIT_SIZE];
                    System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
                    byte[] bArr6 = this.cacheBytesForInfo;
                    System.arraycopy(bArr, 0, bArr5, bArr6.length, 1316 - bArr6.length);
                    this.cacheBytesForInfo = null;
                    int i2 = length2 - (SEND_LIMIT_SIZE - length);
                    if (i2 > 0) {
                        byte[] bArr7 = new byte[i2];
                        this.cacheBytesForInfo = bArr7;
                        System.arraycopy(bArr, bArr.length - i2, bArr7, 0, bArr7.length);
                    }
                    bArr3 = bArr5;
                }
            } else if (bArr2 == null) {
                this.cacheBytesForInfo = bArr;
            } else {
                this.cacheBytesForInfo = combineBytes(bArr2, bArr);
            }
            if (bArr3 == null) {
                return;
            }
            if (this.enableTsSender) {
                this.mTsSender.sendInfoData(bArr3);
            }
            if (this.enablePublicNetTsSender) {
                this.mPublicNetTsSender.sendInfoData(bArr3);
            }
        }
    }

    public void sendMsgData(final EsPacket esPacket) {
        if (this.destroyed) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.6
            @Override // java.lang.Runnable
            public void run() {
                if (TsSendFactory.this.destroyed) {
                    return;
                }
                TsSendFactory.this.changeMsgDataToTs(esPacket);
            }
        });
    }

    public void setSPSAndPPS(final byte[] bArr) {
        if (this.destroyed) {
            return;
        }
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsSendFactory.5
            @Override // java.lang.Runnable
            public void run() {
                if (TsSendFactory.this.destroyed) {
                    return;
                }
                TsSendFactory.this.SPSAndPPS = bArr;
            }
        });
    }

    public TsSendFactory(boolean z, boolean z2, String str, int i, String str2, String str3) {
        this.destroyed = false;
        this.SPSAndPPS = new byte[0];
        this.cacheBytes = null;
        this.cacheBytesForInfo = null;
        if (z) {
            enableTsSender();
        }
        if (z2) {
            enablePublicNetSender(str, i, str2, str3);
        }
        init();
    }
}
