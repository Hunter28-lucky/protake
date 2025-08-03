package com.blink.academy.film.support.stream.ts;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.support.stream.ts.PmtPacket;
import com.blink.academy.film.support.stream.ts.TsProcessFactory;
import com.github.thibaultbee.srtdroid.models.Socket;
import defpackage.C4638;
import defpackage.C4672;
import defpackage.C4682;
import defpackage.C4806;
import defpackage.InterfaceC4493;
import java.net.SocketException;
import java.util.List;

/* loaded from: classes.dex */
public class TsPublicNetSrtSender implements TsSender {
    private static final String TAG = "TsPublicNetSrtSender";
    public TsProcessFactory.TsPacketMerger dataPacketMergerClient = null;
    public int dataServerNeedPid = -1;
    public Handler mHandler;
    public HandlerThread mHandlerThread;
    private final String mIp;
    private final String mPassphrase;
    private final int mPort;
    private final String mStreamId;
    private TsProcessFactory mTsServerFactory;
    public C4672 socketClient;

    public interface OnNetSenderRec {
        void onRecvBytes(byte[] bArr);
    }

    public TsPublicNetSrtSender(String str, int i, String str2, String str3) {
        this.mIp = str;
        this.mPort = i;
        this.mPassphrase = str2;
        this.mStreamId = str3;
        HandlerThread handlerThread = new HandlerThread("TsSrtSender");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.mHandlerThread.getLooper());
        this.mHandler = handler;
        handler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.1
            @Override // java.lang.Runnable
            public void run() throws SocketException {
                TsPublicNetSrtSender.this.init();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() throws SocketException {
        C4672 c4672M14523 = C4806.m14521().m14523();
        this.socketClient = c4672M14523;
        c4672M14523.m14174(new InterfaceC4493() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.2
            @Override // defpackage.InterfaceC4493
            public void onConnectionClose(@NonNull String str) {
            }

            @Override // defpackage.InterfaceC4493
            public void onRecvBytes(@NonNull byte[] bArr) {
                TsPublicNetSrtSender.this.onReceiveInfoBytes(bArr);
            }

            public void onRecvMsg(@NonNull String str) {
            }
        });
        C4682 c4682 = new C4682(this.mIp, this.mPort, this.mPassphrase, this.mStreamId);
        c4682.m14192(200);
        c4682.m14191(200);
        try {
            this.socketClient.m14167(c4682);
        } catch (Exception e2) {
            e2.printStackTrace();
            this.socketClient.m14166();
            this.socketClient = null;
            release();
        }
        this.mTsServerFactory = new TsProcessFactory();
        this.mTsServerFactory.setDataCallback(new TsProcessFactory.DataCallback() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.3
            @Override // com.blink.academy.film.support.stream.ts.TsProcessFactory.DataCallback
            public void onStreamReceive(List<PmtPacket.Stream> list) {
                for (PmtPacket.Stream stream : list) {
                    if (stream.stream_type == 64) {
                        TsPublicNetSrtSender.this.setDataPacketMergerForClient(stream);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void optOnGetMsg(final String str) {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.5
            @Override // java.lang.Runnable
            public void run() throws NumberFormatException {
                LinkManager.getInstance().onGetRemoteLinkInfo(str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataPacketMergerForClient(PmtPacket.Stream stream) {
        int i = this.dataServerNeedPid;
        int i2 = stream.elementary_PID;
        if (i != i2) {
            this.dataServerNeedPid = i2;
            TsProcessFactory.TsPacketMerger tsPacketMerger = this.dataPacketMergerClient;
            if (tsPacketMerger != null) {
                this.mTsServerFactory.removeTsPacketMerger(tsPacketMerger);
            }
            TsProcessFactory.TsPacketMerger tsPacketMerger2 = new TsProcessFactory.TsPacketMerger(TsConstants.ACESType_data, this.dataServerNeedPid) { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.4
                @Override // com.blink.academy.film.support.stream.ts.TsProcessFactory.TsPacketMerger
                public void onPacketProcessFinish(EsPacket esPacket) {
                    TsPublicNetSrtSender.this.optOnGetMsg(new String(esPacket.getData()));
                    C4638.m14099(TsPublicNetSrtSender.TAG, "remote link size:" + LinkManager.getInstance().getRemoteLinks().size());
                }
            };
            this.dataPacketMergerClient = tsPacketMerger2;
            this.mTsServerFactory.addTsPacketMerger(tsPacketMerger2);
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public Socket getSocket() {
        C4672 c4672 = this.socketClient;
        if (c4672 != null) {
            return c4672.m14168();
        }
        return null;
    }

    public void onReceiveInfoBytes(byte[] bArr) {
        int length = bArr.length / TsConstants.TS_PACKET_SIZE;
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = new byte[TsConstants.TS_PACKET_SIZE];
            System.arraycopy(bArr, i * TsConstants.TS_PACKET_SIZE, bArr2, 0, TsConstants.TS_PACKET_SIZE);
            this.mTsServerFactory.addData(bArr2);
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void release() {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.8
            @Override // java.lang.Runnable
            public void run() throws SocketException {
                C4672 c4672 = TsPublicNetSrtSender.this.socketClient;
                if (c4672 != null) {
                    c4672.m14166();
                    TsPublicNetSrtSender.this.socketClient = null;
                }
                TsPublicNetSrtSender.this.mHandlerThread.quitSafely();
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void sendData(final byte[] bArr) {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.6
            @Override // java.lang.Runnable
            public void run() throws SocketException {
                C4672 c4672 = TsPublicNetSrtSender.this.socketClient;
                if (c4672 != null) {
                    c4672.m14173(bArr);
                }
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public void sendInfoData(final byte[] bArr) {
        this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.support.stream.ts.TsPublicNetSrtSender.7
            @Override // java.lang.Runnable
            public void run() throws SocketException {
                C4672 c4672 = TsPublicNetSrtSender.this.socketClient;
                if (c4672 != null) {
                    c4672.m14172(bArr);
                }
            }
        });
    }

    @Override // com.blink.academy.film.support.stream.ts.TsSender
    public boolean socketAlive() {
        C4672 c4672 = this.socketClient;
        if (c4672 == null) {
            return false;
        }
        return c4672.m14165();
    }
}
