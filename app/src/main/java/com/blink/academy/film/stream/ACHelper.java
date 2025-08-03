package com.blink.academy.film.stream;

import android.location.Location;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.NonNull;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.http.okhttp.exception.ApiException;
import com.blink.academy.film.netbean.srt.SRTConnectionCallbackEntity;
import com.blink.academy.film.netbean.srt.SRTConnectionServerBean;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.blink.academy.protake.R;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.gson.Gson;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C2618;
import defpackage.C2813;
import defpackage.C2949;
import defpackage.C3151;
import defpackage.C3444;
import defpackage.C3688;
import defpackage.C3891;
import defpackage.C3902;
import defpackage.C3947;
import defpackage.C3952;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4792;
import defpackage.C5049;
import defpackage.e5;
import defpackage.n;
import defpackage.p3;
import defpackage.r1;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class ACHelper {
    private static final int MSG_LOOP_3S = 20005;
    private static final int MSG_LOOP_HIGH = 20003;
    private static final int MSG_LOOP_LOW = 20004;
    public static final int NEED_UPDATE_CLIENT = 1;
    public static final boolean SHOW_LOG = false;
    public static final int S_VERSION = 1;
    public static final int VERSION = 1;
    private static ACHelper instance;
    private String albumDesStr;
    private String albumHomeDesStr;
    private String albumHomeTimelapseStr;
    private float albumPercent;
    private String albumTagStr;
    private String albumTimelapseStr;
    private FilmAlbumCallback filmAlbumCallback;
    public Handler handler;
    private boolean isCloudPush;
    private boolean isFocusZoomWheelTouching;
    private boolean isReConnecting;
    private boolean isSpeed;
    private int mCameraQualityType;
    private String mCurrentMonitorRoomId;
    private boolean mFocusEnable;
    private String mRoomId;
    private DecoderParamsBean mSelectDecoderParamsBean;
    private boolean mZoomEnable;
    private boolean monitorRecording;
    private OnCameraCallback onCameraCallback;
    private OnDeviceInit onDeviceInit;
    private OnMonitorCallback onMonitorCallback;
    public PlayerDeviceIconChangeListener playerDeviceIconChangeListener;
    private SRTConnectionCallbackEntity srtConnectionCallbackEntity;
    public HandlerThread thread;
    private Object mReadyFence = new Object();
    private float mBitrateScale = 1.0f;
    private FloatBuffer mGLCubeBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private FloatBuffer mGLTextureBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
    private boolean done265Check = false;
    private boolean loopStart = false;
    private int albumControllState = 0;
    private String timeLapseValue = "";
    private boolean cameraIsAlbumMode = false;

    public interface FilmAlbumCallback {
        void onAlbumTagClickByClient(int i, LinkEntity linkEntity);

        void onControlClickByClient(int i, LinkEntity linkEntity);

        void onModeChange(boolean z, LinkEntity linkEntity);

        void onPlayClickByClient(boolean z, LinkEntity linkEntity);

        boolean playing();
    }

    public interface OnCameraCallback {
        void needShowHintText(int i, LinkEntity linkEntity);

        void onAlbumModeClickByClient(boolean z, LinkEntity linkEntity);

        void onBitrateScaleChange(float f);

        void onCheckRefreshRoomId();

        void onFocusChange(float f);

        void onRecordClickByClient(boolean z, LinkEntity linkEntity);

        void onWheelModeChange(boolean z);

        void onZoomChange(float f);

        void refreshMachineViews();

        void refreshViewsLow();

        void updateLocalWifiInfo(NetInfoBean netInfoBean);
    }

    public interface OnDeviceInit {
        void onInit();
    }

    public interface OnMonitorCallback {
        void onLinkRelease(int i);

        void refreshOnGetLinkFrameInfo(LinkEntity linkEntity);
    }

    public interface PlayerDeviceIconChangeListener {
        void onChange();
    }

    private ACHelper() {
        this.mGLCubeBuffer.clear();
        this.mGLCubeBuffer.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f}).position(0);
        this.mGLTextureBuffer.clear();
        this.mGLTextureBuffer.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}).position(0);
        synchronized (this.mReadyFence) {
            HandlerThread handlerThread = new HandlerThread("LinkEntity");
            this.thread = handlerThread;
            handlerThread.setPriority(4);
            this.thread.start();
            this.handler = new Handler(this.thread.getLooper(), new Handler.Callback() { // from class: com.blink.academy.film.stream.ACHelper.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) throws NumberFormatException, UnknownHostException {
                    switch (message.what) {
                        case ACHelper.MSG_LOOP_HIGH /* 20003 */:
                            Message messageObtainMessage = ACHelper.this.handler.obtainMessage(ACHelper.MSG_LOOP_HIGH);
                            FinderManager.getInstance().updateOnRemoteNsdServiceInfoListChange();
                            LinkManager.getInstance().onLoopCheck();
                            if (ACHelper.this.onCameraCallback != null) {
                                ACHelper.this.onCameraCallback.refreshMachineViews();
                            }
                            ACHelper.this.handler.sendMessageDelayed(messageObtainMessage, 200L);
                            break;
                        case ACHelper.MSG_LOOP_LOW /* 20004 */:
                            Message messageObtainMessage2 = ACHelper.this.handler.obtainMessage(ACHelper.MSG_LOOP_LOW);
                            ACHelper.this.doPingRouter();
                            ACHelper.this.doPingProtake();
                            ACHelper.this.doPingAkamai();
                            float targetBitrateScale = LinkManager.getInstance().getTargetBitrateScale();
                            if (targetBitrateScale != ACHelper.this.mBitrateScale) {
                                ACHelper.this.mBitrateScale = targetBitrateScale;
                                if (ACHelper.this.onCameraCallback != null) {
                                    ACHelper.this.onCameraCallback.onBitrateScaleChange(ACHelper.this.mBitrateScale);
                                }
                            }
                            if (ACHelper.this.onCameraCallback != null) {
                                ACHelper.this.onCameraCallback.refreshViewsLow();
                            }
                            ACHelper.this.handler.sendMessageDelayed(messageObtainMessage2, 1000L);
                            break;
                        case ACHelper.MSG_LOOP_3S /* 20005 */:
                            Message messageObtainMessage3 = ACHelper.this.handler.obtainMessage(ACHelper.MSG_LOOP_3S);
                            ACHelper.this.checkAkamaiIp();
                            ACHelper.this.checkReConnectForCamera();
                            ACHelper.this.checkReConnectForMonitor();
                            ACHelper.this.checkRefreshRoomId();
                            ACHelper.this.handler.sendMessageDelayed(messageObtainMessage3, 3000L);
                            break;
                    }
                    return true;
                }
            });
        }
    }

    private int changeInfoCameraIdToPresetId(int i) {
        if (i == 0) {
            return 1;
        }
        if (i != 1) {
            return i != 3 ? 3 : 4;
        }
        return 2;
    }

    private int changePresetIdToInfoCameraId(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 0;
        }
        if (i != 6) {
            return i != 7 ? 2 : 0;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAkamaiIp() throws UnknownHostException {
        String str = "";
        try {
            InetAddress[] allByName = InetAddress.getAllByName("www.akamai.com");
            if (allByName != null && allByName.length > 0) {
                int length = allByName.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String hostAddress = allByName[i].getHostAddress();
                    if (r1.m8143(hostAddress) && isCorrectIp2(hostAddress)) {
                        str = hostAddress;
                        break;
                    }
                    i++;
                }
            }
        } catch (UnknownHostException e2) {
            e2.printStackTrace();
        }
        PingHelper.getInstance().setAkamaiIp(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkReConnectForCamera() {
        if (!this.isReConnecting && TransmitHelper.getInstance().isStartCameraTransmit() && getInstance().isCloudPush() && !ConnectionManager.getInstance().publicSocketAlive()) {
            this.isReConnecting = true;
            n.m7588().m7599(new n.InterfaceC2189() { // from class: com.blink.academy.film.stream.ACHelper.2
                @Override // defpackage.n.InterfaceC2189
                public void onFail(ApiException apiException) {
                    ACHelper.this.isReConnecting = false;
                }

                @Override // defpackage.n.InterfaceC2189
                public void onSuc(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
                    ACHelper.this.isReConnecting = false;
                    SRTConnectionServerBean srt_server = sRTConnectionCallbackEntity.getSrt_server();
                    ConnectionManager.getInstance().startNet(srt_server.getIp(), srt_server.getPort(), sRTConnectionCallbackEntity.getSrt_passphrase(), "0.1 camera " + sRTConnectionCallbackEntity.getSrt_room_id() + MyUTIL.white_space + e5.m5988().m5991() + MyUTIL.white_space + sRTConnectionCallbackEntity.getSrt_connection_id(), sRTConnectionCallbackEntity);
                }
            }, true, getInstance().getRoomId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkReConnectForMonitor() {
        LinkManager.getInstance().checkReconnectLinkForCloudMonitor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRefreshRoomId() {
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.onCheckRefreshRoomId();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPingAkamai() {
        PingHelper.getInstance().doPingAkamai();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPingProtake() {
        if (TransmitHelper.getInstance().isStartCameraTransmit()) {
            SRTConnectionCallbackEntity sRTConnectionCallbackEntity = this.srtConnectionCallbackEntity;
            if (sRTConnectionCallbackEntity != null) {
                PingHelper.getInstance().setProtakeIp(sRTConnectionCallbackEntity.getSrt_server().getIp());
            } else {
                PingHelper.getInstance().setProtakeIp("");
            }
        } else if (LinkManager.getInstance().isHasCloudLinkForMonitorCheck()) {
            PingHelper.getInstance().setProtakeIp(LinkManager.getInstance().getRemoteFirstIp());
        } else {
            PingHelper.getInstance().setProtakeIp("");
        }
        PingHelper.getInstance().doPingProtake();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPingRouter() {
        PingHelper.getInstance().doPingLocalRouter();
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.updateLocalWifiInfo(PingHelper.getInstance().getRouterNetInfoBean());
        }
    }

    private int getCameraId() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (c3891M13890.m12495()) {
            return changePresetIdToInfoCameraId(Integer.parseInt(c3891M13890.m12399()));
        }
        return -1;
    }

    private int getCameraTypeStr() {
        return -1;
    }

    private String[] getControlDisableList() {
        List<String> banControlUUidList = ACBanManager.getInstance().getBanControlUUidList();
        return r1.m8144(banControlUUidList) ? (String[]) banControlUUidList.toArray() : new String[0];
    }

    private String getFpsString() {
        int iM12484 = C4535.m13880().m13890().m12484();
        if (!r1.m8143(this.timeLapseValue)) {
            return iM12484 + "";
        }
        return iM12484 + MyUTIL.white_space + this.timeLapseValue;
    }

    public static ACHelper getInstance() {
        if (instance == null) {
            synchronized (ACHelper.class) {
                if (instance == null) {
                    instance = new ACHelper();
                }
            }
        }
        return instance;
    }

    private String[] getOutRangeList() {
        ArrayList arrayList = new ArrayList();
        List<LinkEntity> links = LinkManager.getInstance().getLinks();
        if (r1.m8144(links)) {
            for (LinkEntity linkEntity : links) {
                if (linkEntity.isOutRange() && r1.m8143(linkEntity.getUuid())) {
                    arrayList.add(linkEntity.getUuid());
                }
            }
            if (r1.m8144(arrayList) && r1.m8144(arrayList)) {
                String[] strArr = new String[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    strArr[i] = (String) arrayList.get(i);
                }
                return strArr;
            }
        }
        return new String[0];
    }

    private int getRatio() {
        String str;
        String str2;
        C3891 c3891M13890 = C4535.m13880().m13890();
        float fM12404 = c3891M13890.m12404();
        float fM12403 = c3891M13890.m12403();
        int i = (int) fM12404;
        if (fM12404 == i) {
            str = i + "";
        } else {
            str = fM12404 + "";
        }
        int i2 = (int) fM12403;
        if (fM12403 == i2) {
            str2 = i2 + "";
        } else {
            str2 = fM12403 + "";
        }
        String str3 = str + Constants.COLON_SEPARATOR + str2;
        str3.hashCode();
        switch (str3) {
            case "1:1":
                return 7;
            case "4:3":
                return 6;
            case "16:9":
                return 4;
            case "2.2:1":
                return 2;
            case "1.37:1":
                return 5;
            case "1.85:1":
                return 3;
            case "2.39:1":
                return 1;
            default:
                return 0;
        }
    }

    private String getRatioStr() {
        String str;
        String str2;
        C3891 c3891M13890 = C4535.m13880().m13890();
        if (!c3891M13890.m12444()) {
            return "0";
        }
        float fM12404 = c3891M13890.m12404();
        float fM12403 = c3891M13890.m12403();
        int i = (int) fM12404;
        if (fM12404 == i) {
            str = i + "";
        } else {
            str = fM12404 + "";
        }
        int i2 = (int) fM12403;
        if (fM12403 == i2) {
            str2 = i2 + "";
        } else {
            str2 = fM12403 + "";
        }
        if (C4792.m14375().m14498()) {
            return str2 + Constants.COLON_SEPARATOR + str;
        }
        return str + Constants.COLON_SEPARATOR + str2;
    }

    private String getResString() {
        int iM12463;
        int iM10354;
        C3891 c3891M13890 = C4535.m13880().m13890();
        C2949 c2949M12803 = c3891M13890.m12457() ? C3952.m12801().m12803(c3891M13890.m12399()) : C3952.m12801().m12803(c3891M13890.m12380());
        if (c2949M12803 != null) {
            iM10354 = c2949M12803.m10354();
            iM12463 = c2949M12803.m10355();
        } else {
            int iM12462 = c3891M13890.m12462();
            iM12463 = c3891M13890.m12463();
            iM10354 = iM12462;
        }
        return C5049.m14852().m14857(Math.min(iM10354, iM12463));
    }

    public void copyDecodeParamBean(DecoderParamsBean decoderParamsBean, DecoderParamsBean decoderParamsBean2) {
        decoderParamsBean2.m478(decoderParamsBean.m470());
        decoderParamsBean2.m481(decoderParamsBean.m473());
        decoderParamsBean2.m482(decoderParamsBean.m474());
        decoderParamsBean2.m483(decoderParamsBean.m475());
        decoderParamsBean2.m479(decoderParamsBean.m471());
        decoderParamsBean2.m480(decoderParamsBean.m472());
        decoderParamsBean2.m484(decoderParamsBean.m476());
        decoderParamsBean2.m485(decoderParamsBean.m477());
    }

    public int getAlbumControllState() {
        return this.albumControllState;
    }

    public String getAlbumTagStr() {
        return this.albumTagStr;
    }

    public String[] getBannedList() {
        synchronized (ACBanManager.banFence) {
            List<ACBanBean> list = ACBanManager.getInstance().getList();
            if (!r1.m8144(list)) {
                return new String[0];
            }
            String[] strArr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                strArr[i] = list.get(i).getUuid();
            }
            return strArr;
        }
    }

    public String getCameraAlbumSendString() {
        HashMap map = new HashMap();
        boolean zIsCameraIsAlbumMode = getInstance().isCameraIsAlbumMode();
        map.put("p0", Integer.valueOf(zIsCameraIsAlbumMode ? 1 : 0));
        if (zIsCameraIsAlbumMode) {
            map.put("p1", this.albumTimelapseStr);
            map.put("p2", this.albumDesStr);
            map.put("p3", Integer.valueOf(Integer.parseInt(this.albumTagStr)));
            map.put("p4", Float.valueOf(this.albumPercent));
        } else {
            map.put("p1", this.albumHomeTimelapseStr);
            map.put("p2", this.albumHomeDesStr);
            map.put("p3", 99);
            map.put("p4", 1);
        }
        map.put("p5", 0);
        map.put("p6", Integer.valueOf(getInstance().getCameraQualityType() - 1));
        C3891 c3891M13890 = C4535.m13880().m13890();
        boolean zM12495 = c3891M13890.m12495();
        HashMap map2 = new HashMap();
        map2.put("captureMode", Integer.valueOf(zM12495 ? 1 : 0));
        map2.put("wheelMode", Integer.valueOf(C3947.m12727().m12772() ? 1 : 0));
        float fM12412 = c3891M13890.m12412();
        int iRound = fM12412 == -0.25f ? -2000 : fM12412 == 1.25f ? -1000 : Math.round((1.0f - fM12412) * 1000.0f);
        map2.put("zoomValue", Integer.valueOf(Math.round(C3947.m12727().m12754(c3891M13890.m12417()) * 1000.0f)));
        map2.put("focusValue", Integer.valueOf(iRound));
        map2.put("isTouching", Boolean.valueOf(this.isFocusZoomWheelTouching));
        map2.put("isZoomEnable", Boolean.valueOf(this.mZoomEnable));
        map2.put("isFocusEnable", Boolean.valueOf(this.mFocusEnable));
        map2.put("supportAutoFocus", Boolean.TRUE);
        map.put("p7", map2);
        return new Gson().toJson(map);
    }

    public String getCameraNameStr(int i) {
        if (i == -1) {
            return FilmApp.m405().getResources().getString(R.string.MONITOR_LABEL_ZOOM_LENS);
        }
        return C3444.m11224(changeInfoCameraIdToPresetId(i) + "").m12139();
    }

    public int getCameraQualityType() {
        return this.mCameraQualityType;
    }

    public String getClientSendString() {
        HashMap map = new HashMap();
        map.put("a", e5.m5988().m5991());
        map.put(TsConstants.kLinkParam_suffix, C2618.m9569("suffix_sp", ""));
        map.put("c", Integer.valueOf(p3.m7891().m7893()));
        map.put("d", Integer.valueOf(getInstance().getWIfiStatus()));
        map.put("bt", getLocalNetTypeStr());
        return new Gson().toJson(map);
    }

    public String[] getControllableList() {
        String[] controllableStrs = LinkManager.getInstance().getControllableStrs();
        return (controllableStrs == null || controllableStrs.length <= 0) ? new String[0] : controllableStrs;
    }

    public String getCurrentMonitorRoomId() {
        return this.mCurrentMonitorRoomId;
    }

    public FloatBuffer getGLCubeBuffer() {
        return this.mGLCubeBuffer;
    }

    public FloatBuffer getGLTextureBuffer() {
        return this.mGLTextureBuffer;
    }

    public String getLocalNetTypeStr() {
        return C3688.m11833(FilmApp.m402());
    }

    public NetInfoBean getNetInfoBean() {
        return PingHelper.getInstance().getRouterNetInfoBean();
    }

    public OnMonitorCallback getOnMonitorCallback() {
        return this.onMonitorCallback;
    }

    public String getPixelFormatStr(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "" : "HDR" : "SDR 10-Bit" : "SDR 8-Bit";
    }

    public float getRealRatioByRatioIndex(int i, int i2) {
        if (i == 0) {
            if (i2 == 1) {
                return 2.37f;
            }
            return i2 == 2 ? 2.76f : 1.7777778f;
        }
        if (i == 1) {
            return 2.39f;
        }
        if (i == 2) {
            return 2.2f;
        }
        if (i == 3) {
            return 1.85f;
        }
        if (i == 5) {
            return 1.37f;
        }
        if (i != 6) {
            return i != 7 ? 1.7777778f : 1.0f;
        }
        return 1.3333334f;
    }

    public String getRoomId() {
        if (this.mRoomId == null) {
            this.mRoomId = "";
        }
        return this.mRoomId;
    }

    public DecoderParamsBean getSelectDecoderParamsBean() {
        return this.mSelectDecoderParamsBean;
    }

    public String getServerSendString() {
        C3891 c3891M13890 = C4535.m13880().m13890();
        HashMap map = new HashMap();
        map.put("a", e5.m5988().m5991());
        map.put("d", Integer.valueOf(getInstance().getWIfiStatus()));
        map.put(TsConstants.kLinkParam_machine, Integer.valueOf(Integer.parseInt(FinderManager.getInstance().getSelectMachine())));
        map.put(TsConstants.kLinkParam_recording, Boolean.valueOf(ConnectionManager.getInstance().isRecording()));
        map.put(TsConstants.kLinkParam_controlable, getControllableList());
        map.put("h", getBannedList());
        map.put("i", getOutRangeList());
        map.put("bt", getLocalNetTypeStr());
        FilmAlbumCallback filmAlbumCallback = this.filmAlbumCallback;
        boolean zPlaying = false;
        if (filmAlbumCallback != null) {
            zPlaying = filmAlbumCallback.playing();
            map.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, 0);
            map.put(TsConstants.kLinkParam_cropVideo, Boolean.FALSE);
            map.put(TsConstants.kLinkParam_ratio, 0);
        } else {
            map.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, Integer.valueOf(ConnectionManager.getInstance().getAnamorphicState()));
            map.put(TsConstants.kLinkParam_cropVideo, Boolean.valueOf(c3891M13890.m12444()));
            map.put(TsConstants.kLinkParam_ratio, Integer.valueOf(getRatio()));
        }
        map.put("o", Boolean.valueOf(zPlaying));
        map.put("q", Boolean.valueOf(this.cameraIsAlbumMode));
        map.put("r", Integer.valueOf(this.albumControllState));
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append("");
        sb.append(System.currentTimeMillis());
        map.put("time", sb.toString());
        HashMap map2 = new HashMap();
        map2.put("safeArea", Integer.valueOf(c3891M13890.m12464()));
        map2.put("safeCrop", Integer.valueOf(C3444.m11227().m11257() ? 1 : 0));
        map.put(am.aD, map2);
        map.put(TsConstants.kLinkParam_dimension, getResString());
        map.put(TsConstants.kLinkParam_fps, getFpsString());
        map.put(TsConstants.kLinkParam_pixelFormat, 0);
        map.put(TsConstants.kLinkParam_cameraType, Integer.valueOf(getCameraId()));
        Location locationM10756 = C3151.m10755(FilmApp.m402(), true).m10756();
        if (locationM10756 != null) {
            map.put("l1", locationM10756.getLongitude() + "");
            map.put("l2", locationM10756.getLatitude() + "");
        }
        String strM12639 = C3902.m12637().m12639();
        String strM12638 = C3902.m12637().m12638();
        String strM12640 = C3902.m12637().m12640();
        if (r1.m8143(strM12639)) {
            str = strM12639;
        } else if (r1.m8143(strM12638)) {
            str = strM12638;
        } else if (r1.m8143(strM12640)) {
            str = strM12640;
        }
        if (!r1.m8143(strM12640)) {
            strM12640 = str;
        }
        if (!r1.m8143(strM12638)) {
            strM12638 = str;
        }
        map.put("l3", strM12638);
        map.put("l4", str);
        map.put("l5", strM12640);
        return new Gson().toJson(map);
    }

    public SRTConnectionCallbackEntity getSrtConnectionCallbackEntity() {
        return this.srtConnectionCallbackEntity;
    }

    public int getWIfiStatus() {
        if (getInstance().isCloudPush()) {
            return PingHelper.getInstance().getProtakeWifiStatus();
        }
        if (!LinkManager.getInstance().isHasCloudLinkForMonitorCheck()) {
            return PingHelper.getInstance().getRouterWifiStatus();
        }
        int protakeWifiStatus = PingHelper.getInstance().getProtakeWifiStatus();
        return protakeWifiStatus <= 0 ? PingHelper.getInstance().getAkamaiWifiStatus() : protakeWifiStatus;
    }

    public int getWifiViewLevel(int i) {
        return getWifiViewLevelByLevel(wifiLevel(i));
    }

    public int getWifiViewLevelByLevel(int i) {
        if (i == 1) {
            return 3;
        }
        return i == 2 ? 2 : 1;
    }

    public void initCheck265() {
        new Thread(new Runnable() { // from class: com.blink.academy.film.stream.ACHelper.3
            @Override // java.lang.Runnable
            public void run() throws IOException {
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType("video/hevc");
                    C4638.m14099("slimC213", "cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                    mediaCodecCreateDecoderByType.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    C2813.f10275 = false;
                    C4638.m14099("slimC213", "cost2:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
                ACHelper.this.done265Check = true;
                if (ACHelper.this.onDeviceInit != null) {
                    ACHelper.this.onDeviceInit.onInit();
                }
            }
        }).start();
    }

    public boolean isCameraIsAlbumMode() {
        return this.cameraIsAlbumMode;
    }

    public boolean isCloudPush() {
        return this.isCloudPush;
    }

    public boolean isCorrectIp2(String str) throws NumberFormatException {
        if (!str.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
            return false;
        }
        for (String str2 : str.split("\\.")) {
            int i = Integer.parseInt(str2);
            if (i < 0 || i > 255) {
                return false;
            }
        }
        return true;
    }

    public boolean isFocusZoomWheelTouching() {
        return this.isFocusZoomWheelTouching;
    }

    public boolean isMonitorRecording() {
        return this.monitorRecording;
    }

    public boolean isNeedCloudPush() {
        return C2618.m9565("cloud_camera_sp", false) && r1.m8143(this.mRoomId);
    }

    public boolean isSpeed() {
        return this.isSpeed;
    }

    public void onAlbumModeClickControl(boolean z, LinkEntity linkEntity) {
        FilmAlbumCallback filmAlbumCallback = this.filmAlbumCallback;
        if (filmAlbumCallback != null) {
            filmAlbumCallback.onModeChange(z, linkEntity);
            return;
        }
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.onAlbumModeClickByClient(z, linkEntity);
        }
    }

    public void onAlbumTagClickControl(int i, LinkEntity linkEntity) {
        FilmAlbumCallback filmAlbumCallback = this.filmAlbumCallback;
        if (filmAlbumCallback != null) {
            filmAlbumCallback.onAlbumTagClickByClient(i, linkEntity);
        }
    }

    public void onCheck265Done(@NonNull OnDeviceInit onDeviceInit) {
        if (this.done265Check) {
            onDeviceInit.onInit();
        } else {
            this.onDeviceInit = onDeviceInit;
        }
    }

    public void onControlClickControl(String str, LinkEntity linkEntity) {
        FilmAlbumCallback filmAlbumCallback = this.filmAlbumCallback;
        if (filmAlbumCallback != null) {
            filmAlbumCallback.onControlClickByClient(Integer.parseInt(str), linkEntity);
        }
    }

    public void onMonitorChangeFocus(float f) {
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.onFocusChange(f);
        }
    }

    public void onMonitorChangeWheelMode(boolean z) {
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.onWheelModeChange(z);
        }
    }

    public void onMonitorChangeZoom(float f) {
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.onZoomChange(f);
        }
    }

    public void onMonitorClickPlay(String str, LinkEntity linkEntity) {
        if (this.filmAlbumCallback != null) {
            this.filmAlbumCallback.onPlayClickByClient("1".equals(str), linkEntity);
        }
    }

    public void onMonitorClickRecord(String str, LinkEntity linkEntity) {
        if (this.onCameraCallback == null || getInstance().isCameraIsAlbumMode()) {
            return;
        }
        this.onCameraCallback.onRecordClickByClient("1".equals(str), linkEntity);
    }

    public void onNeedRefreshTime() {
    }

    public void onNeedShowHint(int i, LinkEntity linkEntity) {
        OnCameraCallback onCameraCallback = this.onCameraCallback;
        if (onCameraCallback != null) {
            onCameraCallback.needShowHintText(i, linkEntity);
        }
    }

    public void sendCaptureEventMsg() {
        ACCameraInfoBean acCameraInfoBean;
        List<LinkEntity> links = LinkManager.getInstance().getLinks();
        if (r1.m8144(links)) {
            for (LinkEntity linkEntity : links) {
                if (linkEntity.getType() == 1 && (acCameraInfoBean = linkEntity.getAcCameraInfoBean()) != null) {
                    String[] controlable = acCameraInfoBean.getControlable();
                    if (r1.m8142(controlable)) {
                        for (String str : controlable) {
                            if (e5.m5988().m5991().equals(str)) {
                                linkEntity.sendEventMsg();
                            }
                        }
                    }
                }
            }
        }
    }

    public void setAlbumControllState(int i) {
        this.albumControllState = i;
    }

    public void setAlbumDesStr(String str) {
        this.albumDesStr = str;
    }

    public void setAlbumHomeDesStr(String str) {
        this.albumHomeDesStr = str;
    }

    public void setAlbumHomeTimelapseStr(String str) {
        this.albumHomeTimelapseStr = str;
    }

    public void setAlbumPercent(float f) {
        this.albumPercent = f;
    }

    public void setAlbumTagStr(String str) {
        this.albumTagStr = str;
    }

    public void setAlbumTimelapseStr(String str) {
        this.albumTimelapseStr = str;
    }

    public void setCameraIsAlbumMode(boolean z) {
        this.cameraIsAlbumMode = z;
    }

    public void setCameraQualityType(int i) {
        this.mCameraQualityType = i;
    }

    public void setCloudPush(boolean z) {
        this.isCloudPush = z;
    }

    public void setCurrentMonitorRoomId(String str) {
        this.mCurrentMonitorRoomId = str;
    }

    public void setFilmAlbumCallback(FilmAlbumCallback filmAlbumCallback) {
        this.filmAlbumCallback = filmAlbumCallback;
    }

    public void setFocusEnable(boolean z) {
        this.mFocusEnable = z;
    }

    public void setFocusZoomWheelTouching(boolean z) {
        this.isFocusZoomWheelTouching = z;
    }

    public void setFpsTimeLapseValue(String str) {
        this.timeLapseValue = str;
    }

    public void setMonitorRecording(boolean z) {
        this.monitorRecording = z;
    }

    public void setOnCameraCallback(OnCameraCallback onCameraCallback) {
        this.onCameraCallback = onCameraCallback;
    }

    public void setOnMonitorCallback(OnMonitorCallback onMonitorCallback) {
        this.onMonitorCallback = onMonitorCallback;
    }

    public void setPlayerDeviceIconChangeListener(PlayerDeviceIconChangeListener playerDeviceIconChangeListener) {
        this.playerDeviceIconChangeListener = playerDeviceIconChangeListener;
    }

    public void setRoomId(String str) {
        this.mRoomId = str;
        C2618.m9573("cloud_camera_room_id_sp", str);
    }

    public void setSelectDecoderParamsBean(DecoderParamsBean decoderParamsBean) {
        this.mSelectDecoderParamsBean = decoderParamsBean;
    }

    public void setSpeed(boolean z) {
        this.isSpeed = z;
    }

    public void setSrtConnectionCallbackEntity(SRTConnectionCallbackEntity sRTConnectionCallbackEntity) {
        this.srtConnectionCallbackEntity = sRTConnectionCallbackEntity;
    }

    public void setZoomEnable(boolean z) {
        this.mZoomEnable = z;
    }

    public void startLoop() {
        if (this.loopStart) {
            return;
        }
        this.loopStart = true;
        this.handler.sendEmptyMessage(MSG_LOOP_HIGH);
        this.handler.sendEmptyMessage(MSG_LOOP_LOW);
        this.handler.sendEmptyMessage(MSG_LOOP_3S);
    }

    public void stopLoop() {
        this.loopStart = false;
        getInstance().setCloudPush(false);
        this.handler.removeCallbacksAndMessages(null);
    }

    public int wifiLevel(int i) {
        float f = i;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return Math.min((int) Math.ceil(f / 33.3f), 3);
    }
}
