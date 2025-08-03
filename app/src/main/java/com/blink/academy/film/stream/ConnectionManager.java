package com.blink.academy.film.stream;

import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.support.stream.ts.EsPacket;
import com.blink.academy.film.support.stream.ts.PatPacket;
import com.blink.academy.film.support.stream.ts.PmtPacket;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.blink.academy.film.support.stream.ts.TsPacket;
import com.blink.academy.film.support.stream.ts.TsSendFactory;
import com.github.thibaultbee.srtdroid.models.Socket;
import defpackage.C2557;
import defpackage.C4575;
import defpackage.e;

/* loaded from: classes.dex */
public class ConnectionManager {
    private static ConnectionManager instance;
    private int anamorphicState;
    private boolean controllable;
    private boolean isRecording;
    private TsSendFactory mTsSendFactory;
    private boolean previewEncodeEnable;
    private C4575 previewEncoder;
    private e.InterfaceC1958 onEncodeCallback = new e.InterfaceC1958() { // from class: com.blink.academy.film.stream.ConnectionManager.1
        @Override // defpackage.e.InterfaceC1958
        public void onDataIn(DecoderParamsBean decoderParamsBean, C2557 c2557, C2557 c25572) {
            if (c25572 != null && ConnectionManager.this.mTsSendFactory != null) {
                if ("video/avc".equalsIgnoreCase(decoderParamsBean.m474())) {
                    ConnectionManager.this.mTsSendFactory.sendH264EsData(c25572.m9410());
                } else if ("video/hevc".equalsIgnoreCase(decoderParamsBean.m474())) {
                    ConnectionManager.this.mTsSendFactory.sendH265EsData(c25572.m9410());
                }
            }
            if (c2557 == null || ConnectionManager.this.mTsSendFactory == null) {
                return;
            }
            if ("video/avc".equalsIgnoreCase(decoderParamsBean.m474())) {
                ConnectionManager.this.mTsSendFactory.sendH264EsData(c2557.m9410());
            } else if ("video/hevc".equalsIgnoreCase(decoderParamsBean.m474())) {
                ConnectionManager.this.mTsSendFactory.sendH265EsData(c2557.m9410());
            }
        }
    };
    public boolean srtIsNull = true;

    private ConnectionManager() {
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            synchronized (ConnectionManager.class) {
                if (instance == null) {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    public void destroyTsSend() {
        TsSendFactory tsSendFactory = this.mTsSendFactory;
        if (tsSendFactory != null) {
            tsSendFactory.release();
            this.mTsSendFactory = null;
        }
    }

    public void disableNet() {
        if (this.mTsSendFactory != null) {
            ACHelper.getInstance().setCloudPush(false);
            this.mTsSendFactory.disablePublicNet();
        }
    }

    public int getAnamorphicState() {
        return this.anamorphicState;
    }

    public e.InterfaceC1958 getOnEncodeCallback() {
        return this.onEncodeCallback;
    }

    public C4575 getPreviewEncoder() {
        return this.previewEncoder;
    }

    public Socket getPublicSocket() {
        TsSendFactory tsSendFactory = this.mTsSendFactory;
        if (tsSendFactory == null) {
            return null;
        }
        return tsSendFactory.getPublicSocket();
    }

    public void initPreviewEncoder(final DecoderParamsBean decoderParamsBean) {
        this.previewEncoder = new C4575(decoderParamsBean, this.onEncodeCallback, new C4575.InterfaceC4583() { // from class: com.blink.academy.film.stream.ConnectionManager.2
            @Override // defpackage.C4575.InterfaceC4583
            public void onSuc() {
                if (ConnectionManager.this.previewEncoder != null) {
                    ConnectionManager.this.previewEncoder.m14048(new C4575.InterfaceC4584() { // from class: com.blink.academy.film.stream.ConnectionManager.2.1
                        @Override // defpackage.C4575.InterfaceC4584
                        public void onFail() {
                            try {
                                ConnectionManager.this.releasePreviewEncoder();
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                ConnectionManager.this.initPreviewEncoder(decoderParamsBean);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }

                        @Override // defpackage.C4575.InterfaceC4584
                        public void onStart() {
                            ConnectionManager.this.previewEncodeEnable = true;
                        }
                    });
                }
            }
        });
    }

    public boolean initSrt() {
        try {
            this.srtIsNull = false;
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void initTsSendFactory() {
        this.mTsSendFactory = new TsSendFactory();
    }

    public boolean isControllable() {
        return this.controllable;
    }

    public boolean isRecording() {
        return this.isRecording;
    }

    public boolean publicSocketAlive() {
        TsSendFactory tsSendFactory = this.mTsSendFactory;
        if (tsSendFactory == null) {
            return false;
        }
        return tsSendFactory.publicSocketAlive();
    }

    public void rePreviewEncode(DecoderParamsBean decoderParamsBean) {
        startPreviewEncode(decoderParamsBean, this.onEncodeCallback);
    }

    public void release() {
        destroyTsSend();
        releaseSrt();
        releasePreviewEncoder();
        LinkManager.getInstance().release();
    }

    public void releasePreviewEncoder() {
        C4575 c4575 = this.previewEncoder;
        if (c4575 != null) {
            this.previewEncodeEnable = false;
            c4575.m14047();
            this.previewEncoder = null;
        }
    }

    public void releaseSrt() {
        this.srtIsNull = true;
    }

    public void renderFrameEncoder(int i, int i2) {
        if (this.previewEncodeEnable) {
            this.anamorphicState = i2;
            C4575 c4575 = this.previewEncoder;
            if (c4575 != null) {
                c4575.m14039(i, i2);
            }
        }
    }

    public void sendMsg() {
        if (this.mTsSendFactory != null) {
            this.mTsSendFactory.sendInfoBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
            this.mTsSendFactory.sendInfoBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
            byte[] bytes = ACHelper.getInstance().getServerSendString().getBytes();
            byte[] bArr = new byte[bytes.length + 1];
            bArr[0] = 0;
            System.arraycopy(bytes, 0, bArr, 1, bytes.length);
            EsPacket esPacket = new EsPacket(0, 0L, bArr);
            TsSendFactory tsSendFactory = this.mTsSendFactory;
            if (tsSendFactory != null) {
                tsSendFactory.sendMsgData(esPacket);
            }
            EsPacket esPacket2 = new EsPacket(0, 0L, "mark!finish".getBytes());
            TsSendFactory tsSendFactory2 = this.mTsSendFactory;
            if (tsSendFactory2 != null) {
                tsSendFactory2.sendMsgData(esPacket2);
            }
        }
    }

    public void setControllable(boolean z) {
        this.controllable = z;
    }

    public void setRecording(boolean z) {
        this.isRecording = z;
    }

    public boolean srtNull() {
        return this.srtIsNull;
    }

    public void startNet(String str, int i, String str2, String str3, SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
        if (this.mTsSendFactory != null) {
            ACHelper.getInstance().setCloudPush(true);
            ACHelper.getInstance().setSrtConnectionCallbackEntity(sRTConnectionCallbackEntity);
            this.mTsSendFactory.enablePublicNet(str, i, str2, str3);
        }
    }

    public void startPreviewEncode(DecoderParamsBean decoderParamsBean, e.InterfaceC1958 interfaceC1958) {
        if (this.previewEncoder == null) {
            initPreviewEncoder(decoderParamsBean);
        } else {
            releasePreviewEncoder();
            startPreviewEncode(decoderParamsBean, interfaceC1958);
        }
    }

    public void startPush(DecoderParamsBean decoderParamsBean) {
        initTsSendFactory();
        startPreviewEncode(decoderParamsBean, this.onEncodeCallback);
    }

    public void stopPush() {
        destroyTsSend();
        releasePreviewEncoder();
        ACHelper.getInstance().setSrtConnectionCallbackEntity(null);
        LinkManager.getInstance().release();
    }

    public void updateBitrate(int i) {
        C4575 c4575 = this.previewEncoder;
        if (c4575 != null) {
            c4575.m14049(i);
        }
    }
}
