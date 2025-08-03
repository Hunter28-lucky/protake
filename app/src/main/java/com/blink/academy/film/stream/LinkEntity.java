package com.blink.academy.film.stream;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.support.stream.ts.ContinuityCounter;
import com.blink.academy.film.support.stream.ts.EsPacket;
import com.blink.academy.film.support.stream.ts.PatPacket;
import com.blink.academy.film.support.stream.ts.PesPacket;
import com.blink.academy.film.support.stream.ts.PmtPacket;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.blink.academy.film.support.stream.ts.TsPacket;
import com.blink.academy.film.support.stream.ts.TsParser;
import com.blink.academy.film.support.stream.ts.TsProcessFactory;
import com.blink.academy.film.support.stream.ts.TsReceiver;
import com.blink.academy.film.support.stream.ts.TsSrtReceiver;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.film.videotools.C0851;
import com.github.thibaultbee.srtdroid.models.Socket;
import com.github.thibaultbee.srtdroid.models.Stats;
import com.google.gson.Gson;
import com.umeng.analytics.pro.am;
import defpackage.C2377;
import defpackage.C2618;
import defpackage.C3732;
import defpackage.C3947;
import defpackage.C4382;
import defpackage.C4638;
import defpackage.C5159;
import defpackage.e;
import defpackage.e5;
import defpackage.n;
import defpackage.p3;
import defpackage.r1;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class LinkEntity extends C5159 {
    private static final int MSG_HIGH_LOOP = 20003;
    public static final int STATUS_CLOUD_CAMERA_BAN = 12;
    public static final int STATUS_CLOUD_CAMERA_FORBIDDEN = 11;
    public static final int STATUS_CLOUD_CAMERA_NO_VALID = 8;
    public static final int STATUS_CLOUD_CAMERA_PAYMENT_REQURE = 10;
    public static final int STATUS_CLOUD_CAMERA_ROOMID_NO_VALID = 9;
    public static final int STATUS_CLOUD_CREATE_BAN = 13;
    public static final int STATUS_CLOUD_NOT_LOGIN = 14;
    public static final int STATUS_CONNECTED = 2;
    public static final int STATUS_CONNECTING = 1;
    public static final int STATUS_CONNECTING_CLOUD = 6;
    public static final int STATUS_DISCONNECT = 0;
    public static final int STATUS_LOW_VERSION = 5;
    public static final int STATUS_NO_SIGNAL = 4;
    public static final int TYPE_CAMERA = 0;
    public static final int TYPE_CAMERA_REMOTE = 2;
    public static final int TYPE_MONITOR = 1;
    private ACCameraInfoBean acCameraInfoBean;
    private ACLinkFrameInfoBean acLinkFrameInfoBean;
    private ACMonitorInfoBean acMonitorInfoBean;
    private boolean banned;
    private boolean cloudLink;
    private int controlState;
    private boolean controllable;
    public int dataNeedPid;
    public TsProcessFactory.TsPacketMerger dataPacketMerger;
    public TsProcessFactory.TsPacketMerger dataPacketMergerClient;
    public int dataServerNeedPid;
    private boolean firstNoValid;
    public Handler handler;
    private boolean hasReleased;
    private String ip;
    private long lastDrawTime;
    private int linkIndex;
    private int linkStatus;
    private long mCreateTime;
    private C4382 mDecoder;
    private EGLSurface mEGLSurface;
    private C2377 mEglCore;
    private List<C0851.C0854> mFrames;
    private long mLastLoopTime;
    private long mLastRecTime;
    public ContinuityCounter mMsgContinuityCounter;
    private List<C0851.C0854> mNowFrame;
    private String mRRoomId;
    private final Object mReadyFence;
    private String mServerUUID;
    private Socket mSocket;
    private TsSrtReceiver mSrtReceiver;
    private String mSteamId;
    private TsProcessFactory mTsProcessFactory;
    private TsProcessFactory mTsServerFactory;
    private int mType;
    private boolean outRange;
    private int port;
    public RecvThread recvThread;
    private long remoteMonitorLastUpdateTimestamp;
    private e srtReaderHelper;
    public HandlerThread thread;
    private String uuid;
    public int videoNeedPid;
    public TsProcessFactory.TsPacketMerger videoPackerMerger;
    private int wifiLevel;

    public class RecvThread extends Thread {
        private boolean isRunning = false;

        public RecvThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.isRunning = true;
            while (this.isRunning) {
                try {
                    Pair<Integer, byte[]> pairRecv = LinkEntity.this.mSocket.recv(2048);
                    Integer num = (Integer) pairRecv.first;
                    byte[] bArr = (byte[]) pairRecv.second;
                    if (num != null) {
                        if (num.intValue() > 0) {
                            LinkEntity.this.onReceiveInfoBytes(bArr);
                        } else {
                            num.intValue();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public LinkEntity(int i, int i2, String str, int i3, Socket socket, String str2, String str3) {
        this(i, i2, str, i3, socket, str2, str3, false);
    }

    private void changeMsgDataToTs(EsPacket esPacket) {
        PesPacket pesPacket = new PesPacket(esPacket.getData());
        if (this.mMsgContinuityCounter == null) {
            this.mMsgContinuityCounter = new ContinuityCounter();
        }
        TsParser.MsgToTs(pesPacket, this.mMsgContinuityCounter, new TsParser.TsCallback() { // from class: com.blink.academy.film.stream.LinkEntity.11
            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onFinish() {
            }

            @Override // com.blink.academy.film.support.stream.ts.TsParser.TsCallback
            public void onTsPacketReady(TsPacket tsPacket) {
                LinkEntity.this.mSrtReceiver.sendBytes(tsPacket.getBytes());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void exitThread() {
        synchronized (this.mReadyFence) {
            this.handler.removeCallbacksAndMessages(null);
            HandlerThread handlerThread = this.thread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.thread = null;
            this.handler = null;
            this.mReadyFence.notify();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initClientLink() {
        /*
            r4 = this;
            com.blink.academy.film.stream.ACMonitorInfoBean r0 = new com.blink.academy.film.stream.ACMonitorInfoBean
            r0.<init>()
            r4.acMonitorInfoBean = r0
            int r0 = r4.linkIndex
            r1 = -1
            if (r0 == r1) goto L1d
            com.blink.academy.film.support.stream.ts.TsProcessFactory r0 = new com.blink.academy.film.support.stream.ts.TsProcessFactory
            r0.<init>()
            r4.mTsServerFactory = r0
            com.blink.academy.film.stream.LinkEntity$2 r0 = new com.blink.academy.film.stream.LinkEntity$2
            r0.<init>()
            com.blink.academy.film.support.stream.ts.TsProcessFactory r1 = r4.mTsServerFactory
            r1.setDataCallback(r0)
        L1d:
            com.github.thibaultbee.srtdroid.models.Socket r0 = r4.mSocket
            if (r0 == 0) goto L66
            com.github.thibaultbee.srtdroid.enums.SockOpt r1 = com.github.thibaultbee.srtdroid.enums.SockOpt.STREAMID
            java.lang.Object r0 = r0.getSockFlag(r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "sockFlag:"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "slimC213"
            defpackage.C4638.m14099(r2, r1)
            r1 = 0
            boolean r2 = defpackage.r1.m8143(r0)
            r3 = 1
            if (r2 == 0) goto L52
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.Exception -> L4e
            if (r0 >= r3) goto L53
            goto L52
        L4e:
            r0 = move-exception
            r0.printStackTrace()
        L52:
            r1 = r3
        L53:
            if (r1 == 0) goto L5c
            com.blink.academy.film.stream.ACHelper r0 = com.blink.academy.film.stream.ACHelper.getInstance()
            r0.onNeedShowHint(r3, r4)
        L5c:
            com.blink.academy.film.stream.LinkEntity$RecvThread r0 = new com.blink.academy.film.stream.LinkEntity$RecvThread
            r0.<init>()
            r4.recvThread = r0
            r0.start()
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.LinkEntity.initClientLink():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initGlContext(DecoderParamsBean decoderParamsBean) {
        if (this.mEGLSurface == null) {
            int iM475 = decoderParamsBean.m475();
            int iM473 = decoderParamsBean.m473();
            C2377 c2377 = new C2377(C3732.m11945().m11954(), 1);
            this.mEglCore = c2377;
            EGLSurface eGLSurfaceM8850 = c2377.m8850(iM475 - (iM475 % 2), iM473 - (iM473 % 2));
            this.mEGLSurface = eGLSurfaceM8850;
            this.mEglCore.m8853(eGLSurfaceM8850);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initHandler() {
        synchronized (this.mReadyFence) {
            HandlerThread handlerThread = new HandlerThread("LinkEntity");
            this.thread = handlerThread;
            handlerThread.setPriority(4);
            this.thread.start();
            this.handler = new Handler(this.thread.getLooper(), new Handler.Callback() { // from class: com.blink.academy.film.stream.LinkEntity.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    LinkEntity linkEntity;
                    if (message.what == LinkEntity.MSG_HIGH_LOOP) {
                        Message messageObtainMessage = LinkEntity.this.handler.obtainMessage(LinkEntity.MSG_HIGH_LOOP);
                        LinkEntity.this.mLastLoopTime = System.currentTimeMillis();
                        if (LinkEntity.this.mDecoder == null || LinkEntity.this.mDecoder.m13571() <= 0) {
                            linkEntity = LinkEntity.this;
                            if (linkEntity.handler != null && !linkEntity.hasReleased) {
                                LinkEntity.this.handler.sendMessageDelayed(messageObtainMessage, 4L);
                            }
                        } else {
                            C0851.C0854 c0854M13568 = LinkEntity.this.mDecoder.m13568();
                            if (c0854M13568 != null) {
                                LinkEntity.this.mNowFrame.add(c0854M13568);
                            }
                            if (LinkEntity.this.mNowFrame.size() != 0) {
                                if (LinkEntity.this.mNowFrame.size() >= 20) {
                                    Iterator it = LinkEntity.this.mNowFrame.iterator();
                                    while (it.hasNext()) {
                                        LinkEntity.this.mDecoder.m13567(((C0851.C0854) it.next()).f1887);
                                    }
                                    LinkEntity.this.mNowFrame.clear();
                                    LinkEntity linkEntity2 = LinkEntity.this;
                                    if (linkEntity2.handler != null && !linkEntity2.hasReleased) {
                                        LinkEntity.this.handler.sendMessageDelayed(messageObtainMessage, 4L);
                                    }
                                } else {
                                    long jM13572 = LinkEntity.this.mDecoder.m13572();
                                    C0851.C0854 c0854 = (C0851.C0854) LinkEntity.this.mNowFrame.get(0);
                                    if (c0854 != null) {
                                        long jCurrentTimeMillis = (jM13572 + (c0854.f1886 / 1000)) - System.currentTimeMillis();
                                        boolean z = LinkEntity.this.acLinkFrameInfoBean != null && LinkEntity.this.acLinkFrameInfoBean.getPriorityType() + 1 == 3;
                                        if (jCurrentTimeMillis <= 0 || z) {
                                            if (z) {
                                                if (System.currentTimeMillis() - LinkEntity.this.lastDrawTime > 25) {
                                                    LinkEntity.this.onRender();
                                                    LinkEntity.this.lastDrawTime = System.currentTimeMillis();
                                                }
                                            } else {
                                                LinkEntity.this.onRender();
                                            }
                                        } else if (jCurrentTimeMillis > 300) {
                                            LinkEntity.this.mDecoder.m13567(((C0851.C0854) LinkEntity.this.mNowFrame.remove(0)).f1887);
                                        }
                                    }
                                    linkEntity = LinkEntity.this;
                                    if (linkEntity.handler != null) {
                                        LinkEntity.this.handler.sendMessageDelayed(messageObtainMessage, 4L);
                                    }
                                }
                            }
                        }
                    }
                    return true;
                }
            });
        }
    }

    private void initRemoteClientLink() {
        this.acMonitorInfoBean = new ACMonitorInfoBean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initServerLink() {
        if (this.acCameraInfoBean == null) {
            this.acCameraInfoBean = new ACCameraInfoBean();
            this.acLinkFrameInfoBean = new ACLinkFrameInfoBean();
            this.linkStatus = 1;
        }
        if (this.srtReaderHelper == null) {
            e eVar = new e();
            this.srtReaderHelper = eVar;
            eVar.m5964(new e.InterfaceC1957() { // from class: com.blink.academy.film.stream.LinkEntity.6
                @Override // defpackage.e.InterfaceC1957
                public void onHeadIn(final DecoderParamsBean decoderParamsBean) throws InterruptedException {
                    if (LinkEntity.this.mDecoder == null) {
                        LinkEntity.this.mDecoder = new C4382(LinkEntity.this.srtReaderHelper, new C4382.InterfaceC4387() { // from class: com.blink.academy.film.stream.LinkEntity.6.1
                            @Override // defpackage.C4382.InterfaceC4387
                            public void onFail() throws InterruptedException {
                                if (LinkEntity.this.srtReaderHelper != null) {
                                    LinkEntity.this.srtReaderHelper.m5961();
                                }
                                LinkEntity.this.releaseDecoder();
                            }
                        });
                    }
                    LinkEntity.this.handler.post(new Runnable() { // from class: com.blink.academy.film.stream.LinkEntity.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            LinkEntity.this.initGlContext(decoderParamsBean);
                        }
                    });
                    int i = 0;
                    if (LinkEntity.this.mDecoder.m13577()) {
                        LinkEntity.this.srtReaderHelper.m5952();
                        LinkEntity.this.mFrames.clear();
                        LinkEntity.this.mNowFrame.clear();
                        LinkEntity.this.mDecoder.m13580();
                        i = 50;
                    }
                    C4638.m14099("slimC213", "onHeadIn");
                    LinkEntity.this.handler.postDelayed(new Runnable() { // from class: com.blink.academy.film.stream.LinkEntity.6.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (LinkEntity.this.srtReaderHelper.m5955() == null || LinkEntity.this.mDecoder == null) {
                                return;
                            }
                            LinkEntity.this.mDecoder.m13575(decoderParamsBean);
                        }
                    }, i);
                }

                @Override // defpackage.e.InterfaceC1957
                public void onRelease() throws InterruptedException {
                    LinkEntity.this.linkStatus = 0;
                    if (LinkEntity.this.mDecoder == null || !LinkEntity.this.mDecoder.m13577()) {
                        return;
                    }
                    LinkEntity.this.releaseDecoder();
                }
            });
        }
        if (this.mTsProcessFactory == null) {
            this.mTsProcessFactory = new TsProcessFactory();
            this.mTsProcessFactory.setDataCallback(new TsProcessFactory.DataCallback() { // from class: com.blink.academy.film.stream.LinkEntity.7
                @Override // com.blink.academy.film.support.stream.ts.TsProcessFactory.DataCallback
                public void onStreamReceive(List<PmtPacket.Stream> list) {
                    for (PmtPacket.Stream stream : list) {
                        byte b = stream.stream_type;
                        if (b == 36) {
                            LinkEntity.this.setVideoPacketMerger(stream);
                        } else if (b == 64) {
                            LinkEntity.this.setDataPacketMerger(stream);
                        }
                    }
                }
            });
        }
        TsReceiver.DataCallback dataCallback = new TsReceiver.DataCallback() { // from class: com.blink.academy.film.stream.LinkEntity.8
            @Override // com.blink.academy.film.support.stream.ts.TsReceiver.DataCallback
            public void onConnectionClose() {
                LinkEntity.this.linkStatus = 0;
                try {
                    LinkManager.getInstance().removeLinkByLinkIndex(LinkEntity.this.linkIndex);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            @Override // com.blink.academy.film.support.stream.ts.TsReceiver.DataCallback
            public void onDataReceived(byte[] bArr) {
                int length = bArr.length / TsConstants.TS_PACKET_SIZE;
                for (int i = 0; i < length; i++) {
                    byte[] bArr2 = new byte[TsConstants.TS_PACKET_SIZE];
                    System.arraycopy(bArr, i * TsConstants.TS_PACKET_SIZE, bArr2, 0, TsConstants.TS_PACKET_SIZE);
                    LinkEntity.this.mTsProcessFactory.addData(bArr2);
                }
            }

            @Override // com.blink.academy.film.support.stream.ts.TsReceiver.DataCallback
            public void onInitFail(Exception exc) {
                try {
                    if (LinkEntity.this.cloudLink && (exc instanceof ConnectException)) {
                        LinkEntity.this.linkStatus = 8;
                    } else {
                        LinkManager.getInstance().removeLinkByLinkIndex(LinkEntity.this.linkIndex);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        TsSrtReceiver tsSrtReceiver = this.mSrtReceiver;
        if (tsSrtReceiver != null) {
            tsSrtReceiver.release();
        }
        this.mSrtReceiver = new TsSrtReceiver(dataCallback, this.ip, this.port, this.mServerUUID, this.mSteamId, this.cloudLink);
        this.handler.removeCallbacksAndMessages(null);
        this.mCreateTime = System.currentTimeMillis();
        this.handler.sendEmptyMessage(MSG_HIGH_LOOP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetCameraFrameInfoStr(String str) {
        if ("mark!finish".equals(str)) {
            return;
        }
        final String str2 = "";
        String[] strArrSplit = str.replaceAll("\n", "").split("\\{");
        if (strArrSplit.length < 2) {
            return;
        }
        if (strArrSplit.length > 2) {
            for (int i = 1; i <= strArrSplit.length - 1; i++) {
                str2 = str2 + "{" + strArrSplit[i];
            }
        } else {
            str2 = "{" + strArrSplit[1];
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.blink.academy.film.stream.LinkEntity.12
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LinkParamBean linkParamBean = (LinkParamBean) new Gson().fromJson(str2, LinkParamBean.class);
                        LinkEntity.this.acLinkFrameInfoBean.setVideoMode(linkParamBean.getP0());
                        LinkEntity.this.acLinkFrameInfoBean.setVideoTimeCode(linkParamBean.getP1());
                        LinkEntity.this.acLinkFrameInfoBean.setVideoDes(linkParamBean.getP2());
                        LinkEntity.this.acLinkFrameInfoBean.setVideoTag(linkParamBean.getP3());
                        LinkEntity.this.acLinkFrameInfoBean.setVideoPercent(linkParamBean.getP4());
                        LinkEntity.this.acLinkFrameInfoBean.setPixelFormat(linkParamBean.getP5());
                        LinkEntity.this.acLinkFrameInfoBean.setPriorityType(linkParamBean.getP6());
                        Map<String, Object> p7 = linkParamBean.getP7();
                        if (r1.m8142(p7)) {
                            if (p7.containsKey("captureMode")) {
                                LinkEntity.this.acLinkFrameInfoBean.setCaptureMode((int) ((Double) p7.get("captureMode")).doubleValue());
                            }
                            if (p7.containsKey("wheelMode")) {
                                LinkEntity.this.acLinkFrameInfoBean.setWheelMode((int) ((Double) p7.get("wheelMode")).doubleValue());
                            }
                            if (p7.containsKey("zoomValue")) {
                                LinkEntity.this.acLinkFrameInfoBean.setZoomValue(C3947.m12727().m12753((float) (((Double) p7.get("zoomValue")).doubleValue() / 1000.0d)));
                            }
                            if (p7.containsKey("focusValue")) {
                                double dDoubleValue = ((Double) p7.get("focusValue")).doubleValue();
                                LinkEntity.this.acLinkFrameInfoBean.setFocusValue(dDoubleValue == -2000.0d ? -0.25f : dDoubleValue == -1000.0d ? 1.25f : (float) (1.0d - (dDoubleValue / 1000.0d)));
                            }
                            if (p7.containsKey("isTouching")) {
                                LinkEntity.this.acLinkFrameInfoBean.setTouching(((Boolean) p7.get("isTouching")).booleanValue());
                            }
                            if (p7.containsKey("isFocusEnable")) {
                                LinkEntity.this.acLinkFrameInfoBean.setFocusEnable(((Boolean) p7.get("isFocusEnable")).booleanValue());
                            }
                            if (p7.containsKey("isZoomEnable")) {
                                LinkEntity.this.acLinkFrameInfoBean.setZoomEnable(((Boolean) p7.get("isZoomEnable")).booleanValue());
                            }
                            if (p7.containsKey("supportAutoFocus")) {
                                LinkEntity.this.acLinkFrameInfoBean.setFocusHasAuto(((Boolean) p7.get("supportAutoFocus")).booleanValue());
                            }
                        }
                        if (LinkEntity.this.srtReaderHelper != null && LinkEntity.this.srtReaderHelper.m5954() != linkParamBean.getP5()) {
                            LinkEntity.this.srtReaderHelper.m5962(linkParamBean.getP5());
                            LinkEntity.this.srtReaderHelper.m5961();
                        }
                        if (ACHelper.getInstance().getOnMonitorCallback() == null || LinkEntity.this.hasReleased) {
                            return;
                        }
                        ACHelper.getInstance().getOnMonitorCallback().refreshOnGetLinkFrameInfo(LinkEntity.this);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetCameraInfoStr(String str) {
        String str2;
        if ("mark!finish".equals(str)) {
            return;
        }
        String[] strArrSplit = str.replaceAll("\n", "").split("\\{");
        if (strArrSplit.length < 2) {
            return;
        }
        if (strArrSplit.length > 2) {
            str2 = "";
            for (int i = 1; i <= strArrSplit.length - 1; i++) {
                str2 = str2 + "{" + strArrSplit[i];
            }
        } else {
            str2 = "{" + strArrSplit[1];
        }
        try {
            LinkParamBean linkParamBean = (LinkParamBean) new Gson().fromJson(str2, LinkParamBean.class);
            this.acCameraInfoBean.setInit(true);
            this.acCameraInfoBean.setUuid(linkParamBean.getA());
            this.acCameraInfoBean.setWifiStatus(linkParamBean.getD());
            this.acCameraInfoBean.setMachine(linkParamBean.getE() + "");
            this.acCameraInfoBean.setRecording(linkParamBean.isF());
            this.acCameraInfoBean.setControlable(linkParamBean.getG());
            this.acCameraInfoBean.setBlock(linkParamBean.getH());
            this.acCameraInfoBean.setOutRange(linkParamBean.getI());
            this.acCameraInfoBean.setRatio(linkParamBean.getK());
            this.acCameraInfoBean.setCropVideo(linkParamBean.isL());
            this.acCameraInfoBean.setDimension(linkParamBean.getM1());
            this.acCameraInfoBean.setFps(linkParamBean.getM2());
            this.acCameraInfoBean.setPixelFormat(linkParamBean.getM3());
            this.acCameraInfoBean.setCameraType(linkParamBean.getM4());
            this.acCameraInfoBean.setStreamType(linkParamBean.getN());
            this.acCameraInfoBean.setPlaying(linkParamBean.isO());
            this.acCameraInfoBean.setAlbumMode(linkParamBean.isQ());
            this.acCameraInfoBean.setAlbumControlable(linkParamBean.getR());
            this.acCameraInfoBean.setTime(linkParamBean.getV());
            this.acCameraInfoBean.setSafeMap(linkParamBean.getZ());
            this.acCameraInfoBean.setNetType(linkParamBean.getBt());
            this.acCameraInfoBean.setLongitude(linkParamBean.getL1());
            this.acCameraInfoBean.setLatitude(linkParamBean.getL2());
            this.acCameraInfoBean.setCityEN(linkParamBean.getL3());
            this.acCameraInfoBean.setCityCN(linkParamBean.getL4());
            this.acCameraInfoBean.setCityCNT(linkParamBean.getL5());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetMonitorInfoStr(String str) throws NumberFormatException {
        if ("mark!finish".equals(str)) {
            return;
        }
        String[] strArrSplit = str.replaceAll("\n", "").split("\\{");
        if (strArrSplit.length < 2) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean z = true;
        sb.append(strArrSplit[1]);
        String string = sb.toString();
        try {
            LinkParamBean linkParamBean = (LinkParamBean) new Gson().fromJson(string, LinkParamBean.class);
            if (!string.contains("\"j\":") && !string.contains("\"j\" :")) {
                if (!string.contains("\"p\":") && !string.contains("\"p\" :")) {
                    if (!string.contains("\"s\":") && !string.contains("\"s\" :")) {
                        if (!string.contains("\"t\":") && !string.contains("\"t\" :")) {
                            if (!string.contains("\"u\":") && !string.contains("\"u\" :")) {
                                if (!string.contains("\"w\":") && !string.contains("\"w\" :")) {
                                    if (!string.contains("\"x\":") && !string.contains("\"x\" :")) {
                                        if (!string.contains("\"y\":") && !string.contains("\"y\" :")) {
                                            this.acMonitorInfoBean.setInit(true);
                                            if (!r1.m8143(this.uuid)) {
                                                synchronized (ACBanManager.banFence) {
                                                    List<ACBanBean> list = ACBanManager.getInstance().getList();
                                                    if (r1.m8144(list)) {
                                                        Iterator<ACBanBean> it = list.iterator();
                                                        while (true) {
                                                            if (!it.hasNext()) {
                                                                break;
                                                            } else if (it.next().getUuid().equals(linkParamBean.getA())) {
                                                                this.banned = true;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            setUuid(linkParamBean.getA());
                                            this.acMonitorInfoBean.setUuid(linkParamBean.getA());
                                            this.acMonitorInfoBean.setSuffix(linkParamBean.getB());
                                            this.acMonitorInfoBean.setJob(linkParamBean.getC() + "");
                                            this.acMonitorInfoBean.setWifiStatus(linkParamBean.getD());
                                            return;
                                        }
                                        if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                                            ACHelper aCHelper = ACHelper.getInstance();
                                            if (Integer.parseInt(linkParamBean.getY()) != 1) {
                                                z = false;
                                            }
                                            aCHelper.onMonitorChangeWheelMode(z);
                                            return;
                                        }
                                        return;
                                    }
                                    if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                                        ACHelper.getInstance().onMonitorChangeZoom(C3947.m12727().m12753(Integer.parseInt(linkParamBean.getX()) / 1000.0f));
                                        return;
                                    }
                                    return;
                                }
                                if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                                    int i = Integer.parseInt(linkParamBean.getW());
                                    ACHelper.getInstance().onMonitorChangeFocus(i == -2000 ? -0.25f : i == -1000 ? 1.25f : 1.0f - (i / 1000.0f));
                                    return;
                                }
                                return;
                            }
                            if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                                ACHelper.getInstance().onAlbumTagClickControl(Integer.parseInt(linkParamBean.getU()), this);
                                return;
                            }
                            return;
                        }
                        if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                            ACHelper.getInstance().onAlbumModeClickControl("1".equals(linkParamBean.getT()), this);
                            return;
                        }
                        return;
                    }
                    if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                        ACHelper.getInstance().onControlClickControl(linkParamBean.getS(), this);
                        return;
                    }
                    return;
                }
                if (linkParamBean.getE() == Integer.parseInt(FinderManager.getInstance().getSelectMachine())) {
                    ACHelper.getInstance().onMonitorClickPlay(linkParamBean.getP(), this);
                    return;
                }
                return;
            }
            this.acMonitorInfoBean.setCaptureEvent(linkParamBean.getJ());
            ACHelper.getInstance().onMonitorClickRecord(linkParamBean.getJ(), this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRender() {
        if (this.mDecoder != null) {
            final C0851.C0854 c0854Remove = this.mNowFrame.remove(0);
            if (this.banned || c0854Remove == null) {
                return;
            }
            final List<ACUnitView> texturesByLinkIndex = LinkManager.getInstance().getTexturesByLinkIndex(this.linkIndex);
            if (!r1.m8144(texturesByLinkIndex)) {
                if (this.mFrames.size() > 3) {
                    Iterator<C0851.C0854> it = this.mFrames.iterator();
                    while (it.hasNext()) {
                        this.mDecoder.m13567(it.next().f1887);
                    }
                    this.mFrames.clear();
                }
                this.mFrames.add(c0854Remove);
                return;
            }
            if (this.mFrames.size() > 3) {
                Iterator<C0851.C0854> it2 = this.mFrames.iterator();
                while (it2.hasNext()) {
                    this.mDecoder.m13567(it2.next().f1887);
                }
                this.mFrames.clear();
            }
            final int i = c0854Remove.f1887.f1879;
            this.handler.postDelayed(new Runnable() { // from class: com.blink.academy.film.stream.LinkEntity.9
                @Override // java.lang.Runnable
                public void run() {
                    for (ACUnitView aCUnitView : texturesByLinkIndex) {
                        if (LinkEntity.this.mEglCore != null) {
                            LinkEntity.this.mEglCore.m8853(LinkEntity.this.mEGLSurface);
                        }
                        if (LinkEntity.this.mDecoder != null) {
                            aCUnitView.getTextureView().setDecoderSize(LinkEntity.this.mDecoder.m13573(), LinkEntity.this.mDecoder.m13569());
                            aCUnitView.getTextureView().setDrawData(i, LinkEntity.this.linkIndex, null, LinkEntity.this.acCameraInfoBean.getStreamType(), LinkEntity.this.acCameraInfoBean.getPixelFormat());
                        }
                    }
                    if (LinkEntity.this.mFrames.size() <= 3) {
                        LinkEntity.this.mFrames.add(c0854Remove);
                    }
                    LinkEntity.this.linkStatus = 2;
                }
            }, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseDecoder() throws InterruptedException {
        this.mFrames.clear();
        this.mNowFrame.clear();
        C4382 c4382 = this.mDecoder;
        if (c4382 != null) {
            c4382.m13580();
            this.mDecoder = null;
        }
    }

    private void senMsgData(byte[] bArr) {
        changeMsgDataToTs(new EsPacket(0, 0L, bArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataPacketMerger(PmtPacket.Stream stream) {
        int i = this.dataNeedPid;
        int i2 = stream.elementary_PID;
        if (i != i2) {
            this.dataNeedPid = i2;
            TsProcessFactory.TsPacketMerger tsPacketMerger = this.dataPacketMerger;
            if (tsPacketMerger != null) {
                this.mTsProcessFactory.removeTsPacketMerger(tsPacketMerger);
            }
            TsProcessFactory.TsPacketMerger tsPacketMerger2 = new TsProcessFactory.TsPacketMerger(TsConstants.ACESType_data, this.dataNeedPid) { // from class: com.blink.academy.film.stream.LinkEntity.4
                @Override // com.blink.academy.film.support.stream.ts.TsProcessFactory.TsPacketMerger
                public void onPacketProcessFinish(EsPacket esPacket) {
                    LinkEntity.this.onGetCameraInfoStr(new String(esPacket.getData()));
                }
            };
            this.dataPacketMerger = tsPacketMerger2;
            this.mTsProcessFactory.addTsPacketMerger(tsPacketMerger2);
        }
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
            TsProcessFactory.TsPacketMerger tsPacketMerger2 = new TsProcessFactory.TsPacketMerger(TsConstants.ACESType_data, this.dataServerNeedPid) { // from class: com.blink.academy.film.stream.LinkEntity.5
                @Override // com.blink.academy.film.support.stream.ts.TsProcessFactory.TsPacketMerger
                public void onPacketProcessFinish(EsPacket esPacket) throws NumberFormatException {
                    LinkEntity.this.onGetMonitorInfoStr(new String(esPacket.getData()));
                }
            };
            this.dataPacketMergerClient = tsPacketMerger2;
            this.mTsServerFactory.addTsPacketMerger(tsPacketMerger2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVideoPacketMerger(PmtPacket.Stream stream) {
        int i = this.videoNeedPid;
        int i2 = stream.elementary_PID;
        if (i != i2) {
            this.videoNeedPid = i2;
            TsProcessFactory.TsPacketMerger tsPacketMerger = this.videoPackerMerger;
            if (tsPacketMerger != null) {
                this.mTsProcessFactory.removeTsPacketMerger(tsPacketMerger);
            }
            TsProcessFactory.TsPacketMerger tsPacketMerger2 = new TsProcessFactory.TsPacketMerger(TsConstants.ACESType_h265, this.videoNeedPid) { // from class: com.blink.academy.film.stream.LinkEntity.3
                @Override // com.blink.academy.film.support.stream.ts.TsProcessFactory.TsPacketMerger
                public void onPacketProcessFinish(EsPacket esPacket) {
                    if (esPacket.getType() == 11) {
                        LinkEntity.this.onGetCameraFrameInfoStr(new String(esPacket.getData()));
                    } else {
                        LinkEntity.this.mLastRecTime = System.currentTimeMillis();
                        LinkEntity.this.srtReaderHelper.m5951(esPacket);
                    }
                }
            };
            this.videoPackerMerger = tsPacketMerger2;
            this.mTsProcessFactory.addTsPacketMerger(tsPacketMerger2);
        }
    }

    public void changeBanState(boolean z) {
        this.banned = z;
    }

    public ACCameraInfoBean getAcCameraInfoBean() {
        return this.acCameraInfoBean;
    }

    public ACLinkFrameInfoBean getAcLinkFrameInfoBean() {
        return this.acLinkFrameInfoBean;
    }

    public ACMonitorInfoBean getAcMonitorInfoBean() {
        return this.acMonitorInfoBean;
    }

    public int getControlState() {
        return this.controlState;
    }

    public C4382 getDecoder() {
        return this.mDecoder;
    }

    public float getDropPercent() {
        Socket socket = this.mSocket;
        if (socket == null) {
            return 0.0f;
        }
        try {
            Stats statsBistats = socket.bistats(true, true);
            return (statsBistats.getPktSndDropTotal() * 1.0f) / Math.max(1L, statsBistats.getPktSentTotal());
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public int getIndex() {
        return this.linkIndex;
    }

    public String getIp() {
        return this.ip;
    }

    public long getLastLoopTime() {
        return this.mLastLoopTime;
    }

    public int getLinkIndex() {
        return this.linkIndex;
    }

    public int getLinkStatus() {
        if (this.mLastRecTime != 0 && this.linkStatus == 2 && System.currentTimeMillis() - this.mLastRecTime > 3000) {
            return 4;
        }
        if (this.linkStatus != 1 || this.cloudLink || System.currentTimeMillis() - this.mCreateTime <= 3000) {
            return this.linkStatus;
        }
        return 4;
    }

    public int getPort() {
        return this.port;
    }

    public String getRRoomId() {
        return this.mRRoomId;
    }

    public int getRealLinkStatus() {
        return this.linkStatus;
    }

    public long getRemoteMonitorLastUpdateTimestamp() {
        return this.remoteMonitorLastUpdateTimestamp;
    }

    public float getRetranPercent() {
        Socket socket = this.mSocket;
        if (socket == null) {
            return 0.0f;
        }
        try {
            Stats statsBistats = socket.bistats(true, true);
            return (statsBistats.getByteRetransTotal() * 1.0f) / Math.max(1L, statsBistats.getByteSentTotal());
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public Socket getSocket() {
        return this.mSocket;
    }

    public TsProcessFactory getTsProcessFactory() {
        return this.mTsProcessFactory;
    }

    public TsSrtReceiver getTsSrtReceiver() {
        return this.mSrtReceiver;
    }

    public int getType() {
        return this.mType;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getWifiLevel() {
        return this.wifiLevel;
    }

    public long getmCreateTime() {
        return this.mCreateTime;
    }

    public boolean isBanned() {
        return this.banned;
    }

    public boolean isCameraRemotelLink() {
        return this.mType == 2;
    }

    public boolean isCloudCameraLink() {
        return this.cloudLink;
    }

    public boolean isControllable() {
        return this.controllable;
    }

    public boolean isFirstNoValid() {
        return this.firstNoValid;
    }

    public boolean isOutRange() {
        return this.outRange;
    }

    public void onBan() throws InterruptedException {
        releaseDecoder();
        e eVar = this.srtReaderHelper;
        if (eVar != null) {
            eVar.m5961();
        }
    }

    public void onModeChange() {
        e eVar = this.srtReaderHelper;
        if (eVar != null) {
            eVar.m5963(true);
        }
    }

    public void onReceiveInfoBytes(byte[] bArr) {
        int length = bArr.length / TsConstants.TS_PACKET_SIZE;
        for (int i = 0; i < length; i++) {
            byte[] bArr2 = new byte[TsConstants.TS_PACKET_SIZE];
            System.arraycopy(bArr, i * TsConstants.TS_PACKET_SIZE, bArr2, 0, TsConstants.TS_PACKET_SIZE);
            this.mTsServerFactory.addData(bArr2);
        }
    }

    public void release() {
        C4638.m14101("slimC213", "link entity release");
        this.hasReleased = true;
        if (ACHelper.getInstance().getOnMonitorCallback() != null && getType() == 1) {
            ACHelper.getInstance().getOnMonitorCallback().onLinkRelease(this.linkIndex);
        }
        ACMonitorInfoBean aCMonitorInfoBean = this.acMonitorInfoBean;
        if (aCMonitorInfoBean != null) {
            aCMonitorInfoBean.setInit(false);
        }
        ACCameraInfoBean aCCameraInfoBean = this.acCameraInfoBean;
        if (aCCameraInfoBean != null) {
            aCCameraInfoBean.setInit(false);
        }
        TsProcessFactory tsProcessFactory = this.mTsProcessFactory;
        if (tsProcessFactory != null) {
            tsProcessFactory.destroy();
        }
        TsSrtReceiver tsSrtReceiver = this.mSrtReceiver;
        if (tsSrtReceiver != null) {
            tsSrtReceiver.release();
        }
        e eVar = this.srtReaderHelper;
        if (eVar != null) {
            e.InterfaceC1957 interfaceC1957M5956 = eVar.m5956();
            if (interfaceC1957M5956 != null) {
                interfaceC1957M5956.onRelease();
            }
            this.srtReaderHelper.m5960();
        }
        releaseDecoder();
        Socket socket = this.mSocket;
        if (socket != null) {
            socket.close();
        }
        RecvThread recvThread = this.recvThread;
        if (recvThread != null) {
            recvThread.isRunning = false;
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.blink.academy.film.stream.LinkEntity.10
                @Override // java.lang.Runnable
                public void run() {
                    if (LinkEntity.this.mEglCore != null) {
                        if (LinkEntity.this.mEGLSurface != null) {
                            LinkEntity.this.mEglCore.m8855(LinkEntity.this.mEGLSurface);
                            LinkEntity.this.mEGLSurface = EGL14.EGL_NO_SURFACE;
                        }
                        LinkEntity.this.mEglCore.m8854();
                        LinkEntity.this.mEglCore = null;
                    }
                    LinkEntity.this.exitThread();
                }
            });
        }
    }

    public void requestRoomInfo(String str) {
        this.mRRoomId = str;
        if (r1.m8143(str)) {
            n.m7588().m7599(new n.InterfaceC2189() { // from class: com.blink.academy.film.stream.LinkEntity.13
                @Override // defpackage.n.InterfaceC2189
                public void onFail(ApiException apiException) {
                    if (apiException.getCode() == 409) {
                        LinkEntity.this.linkStatus = 9;
                        return;
                    }
                    if (apiException.getCode() == 402) {
                        LinkEntity.this.linkStatus = 10;
                        return;
                    }
                    if (apiException.getCode() == 420) {
                        LinkEntity.this.linkStatus = 11;
                        return;
                    }
                    if (apiException.getCode() == 403) {
                        LinkEntity.this.linkStatus = 12;
                        return;
                    }
                    if (apiException.getCode() == 423) {
                        LinkEntity.this.linkStatus = 13;
                        return;
                    }
                    if (apiException.getCode() == 401) {
                        LinkEntity.this.linkStatus = 14;
                    } else if (LinkEntity.this.firstNoValid) {
                        LinkEntity.this.firstNoValid = false;
                    } else {
                        LinkEntity.this.linkStatus = 8;
                    }
                }

                @Override // defpackage.n.InterfaceC2189
                public void onSuc(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
                    LinkEntity.this.linkStatus = 6;
                    LinkEntity.this.firstNoValid = true;
                    String str2 = "0.1 monitor " + sRTConnectionCallbackEntity.getSrt_room_id() + MyUTIL.white_space + e5.m5988().m5991() + MyUTIL.white_space + sRTConnectionCallbackEntity.getSrt_connection_id();
                    LinkEntity.this.ip = sRTConnectionCallbackEntity.getSrt_server().getIp();
                    LinkEntity.this.port = sRTConnectionCallbackEntity.getSrt_server().getPort();
                    LinkEntity.this.mServerUUID = sRTConnectionCallbackEntity.getSrt_passphrase();
                    LinkEntity.this.mSteamId = str2;
                    LinkEntity linkEntity = LinkEntity.this;
                    if (linkEntity.handler == null) {
                        linkEntity.initHandler();
                    }
                    LinkEntity.this.initServerLink();
                }
            }, false, str);
        }
    }

    public void sendAlbumControlEvent(int i) {
        if (this.mType != 1 || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(am.aB, i + "");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendAlbumModeEvent() {
        if (this.mType != 1 || this.acCameraInfoBean == null || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(am.aI, this.acCameraInfoBean.isAlbumMode() ? "0" : "1");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendAlbumTagEvent(int i) {
        if (this.mType != 1 || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(am.aH, i + "");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendEventMsg() {
        if (this.mType != 1 || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(TsConstants.kLinkParam_captureEvent, Integer.valueOf(ACHelper.getInstance().isMonitorRecording() ? 1 : 0));
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendFocusChangeEvent(float f) {
        if (this.mType != 1 || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("w", (f == -0.25f ? -2000 : f == 1.25f ? -1000 : Math.round((1.0f - f) * 1000.0f)) + "");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendMsg() {
        int i = this.mType;
        if (i != 1) {
            if (i == 0 || i == 2) {
                ConnectionManager.getInstance().sendMsg();
                return;
            }
            return;
        }
        if (this.mSrtReceiver != null) {
            String clientSendString = ACHelper.getInstance().getClientSendString();
            this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
            this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
            byte[] bytes = clientSendString.getBytes();
            byte[] bArr = new byte[bytes.length + 1];
            bArr[0] = 0;
            System.arraycopy(bytes, 0, bArr, 1, bytes.length);
            senMsgData(bArr);
            senMsgData("mark!finish".getBytes());
        }
    }

    public void sendPlayEvent() {
        if (this.mType != 1 || this.acCameraInfoBean == null || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put(am.ax, this.acCameraInfoBean.isPlaying() ? "1" : "0");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendWheelStataChangeEvent(boolean z) {
        if (this.mType != 1 || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("y", z ? 1 : "0");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void sendZoomChangeEvent(float f) {
        if (this.mType != 1 || this.mSrtReceiver == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("x", Math.round(C3947.m12727().m12754(f) * 1000.0f) + "");
        map.put(TsConstants.kLinkParam_machine, this.acCameraInfoBean.getMachine());
        if (isCloudCameraLink()) {
            map.put("at", this.mRRoomId);
            map.put("a", e5.m5988().m5991());
            map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
            map.put("c", Integer.valueOf(p3.m7891().m7893()));
            map.put("d", Integer.valueOf(ACHelper.getInstance().getWIfiStatus()));
            map.put("bt", ACHelper.getInstance().getLocalNetTypeStr());
        }
        String json = new Gson().toJson(map);
        this.mSrtReceiver.sendBytes(new TsPacket(PatPacket.PatPacket()).getBytes());
        this.mSrtReceiver.sendBytes(new TsPacket(PmtPacket.PMTPacket(TsConstants.ACESType_h265)).getBytes());
        byte[] bytes = json.getBytes();
        byte[] bArr = new byte[bytes.length + 1];
        bArr[0] = 0;
        System.arraycopy(bytes, 0, bArr, 1, bytes.length);
        senMsgData(bArr);
        senMsgData("mark!finish".getBytes());
    }

    public void setControlState(int i) {
        this.controlState = i;
    }

    public LinkEntity setIp(String str) {
        this.ip = str;
        return this;
    }

    public void setLinkStatus(int i) {
        this.linkStatus = i;
    }

    public void setOutRange(boolean z) {
        this.outRange = z;
    }

    public LinkEntity setPort(int i) {
        this.port = i;
        return this;
    }

    public void setRemoteMonitorLastUpdateTimestamp(long j) {
        this.remoteMonitorLastUpdateTimestamp = j;
    }

    public void setUuid(String str) {
        Log.d("ccccccc", "set uuid:" + str);
        this.uuid = str;
    }

    public void setWifiLevel(int i) {
        this.wifiLevel = i;
    }

    public LinkEntity(int i, int i2, String str, int i3, Socket socket, String str2, String str3, boolean z) {
        this.mReadyFence = new Object();
        this.controllable = true;
        this.outRange = false;
        this.lastDrawTime = 0L;
        this.videoNeedPid = -1;
        this.dataNeedPid = -1;
        this.videoPackerMerger = null;
        this.dataPacketMerger = null;
        this.dataPacketMergerClient = null;
        this.dataServerNeedPid = -1;
        this.mEGLSurface = null;
        this.mFrames = new ArrayList();
        this.mNowFrame = new ArrayList();
        this.hasReleased = false;
        this.firstNoValid = true;
        this.linkIndex = i2;
        this.ip = str;
        this.port = i3;
        this.mType = i;
        this.mSocket = socket;
        this.mServerUUID = str2;
        this.mSteamId = str3;
        this.cloudLink = z;
        if (i2 != -1 && r1.m8143(str)) {
            initHandler();
        }
        int i4 = this.mType;
        if (i4 == 1) {
            if (r1.m8143(str)) {
                initServerLink();
            }
        } else if (i4 == 2) {
            initRemoteClientLink();
        } else {
            initClientLink();
        }
        this.mCreateTime = System.currentTimeMillis();
    }
}
