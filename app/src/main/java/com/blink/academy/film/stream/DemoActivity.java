package com.blink.academy.film.stream;

import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.blink.academy.film.bean.socket.DecoderParamsBean;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.support.socket.IDiscoveryCallBack;
import com.blink.academy.protake.R;
import com.google.gson.Gson;
import com.uc.crashsdk.export.LogType;
import defpackage.AbstractC3816;
import defpackage.C2375;
import defpackage.C4638;
import defpackage.r1;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jcodec.containers.dpx.DPXReader;

/* loaded from: classes.dex */
public class DemoActivity extends AppCompatActivity {
    private static final int MSG_REFRESH_INFO = 30001;
    private DecoderParamsBean bean1;
    private DecoderParamsBean bean2;
    public HandlerThread handlerThread;
    private boolean isPushing;
    private boolean isReceiving;
    public AbstractC3816 mBinding;
    private DecoderParamsBean mCurrentDecoderParamsBean;
    private Handler mHandler;
    public Handler mThreadHandler;
    private List<ACUnitView> mUnitViews;
    private final Object mReadyFence = new Object();
    private String lastInfoString = "";
    private boolean pushMode = true;
    private boolean configFast = true;
    private int mDevicePos = 0;
    private int VIEW_STATE_DISABLE = 0;
    private int VIEW_STATE_ENABLE = 1;
    private int VIEW_STATE_SELECT = 2;

    /* JADX INFO: Access modifiers changed from: private */
    public void changeConfig() {
        if (this.configFast) {
            changeTextColor(this.mBinding.f13060, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13061, this.VIEW_STATE_SELECT);
        } else {
            changeTextColor(this.mBinding.f13060, this.VIEW_STATE_SELECT);
            changeTextColor(this.mBinding.f13061, this.VIEW_STATE_ENABLE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeContent() {
        if (this.pushMode) {
            changeTextColor(this.mBinding.f13059, this.VIEW_STATE_SELECT);
            changeTextColor(this.mBinding.f13071, this.VIEW_STATE_ENABLE);
            this.mBinding.f13073.setVisibility(0);
            this.mBinding.f13085.setVisibility(8);
            this.mBinding.f13076.setVisibility(0);
            return;
        }
        changeTextColor(this.mBinding.f13059, this.VIEW_STATE_ENABLE);
        changeTextColor(this.mBinding.f13071, this.VIEW_STATE_SELECT);
        this.mBinding.f13073.setVisibility(8);
        this.mBinding.f13085.setVisibility(0);
        this.mBinding.f13076.setVisibility(8);
    }

    private void changeDeviceBtState() {
        int i = this.mDevicePos;
        if (i == 0) {
            changeTextColor(this.mBinding.f13062, this.VIEW_STATE_SELECT);
            changeTextColor(this.mBinding.f13063, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13064, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13065, this.VIEW_STATE_ENABLE);
            return;
        }
        if (i == 1) {
            changeTextColor(this.mBinding.f13062, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13063, this.VIEW_STATE_SELECT);
            changeTextColor(this.mBinding.f13064, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13065, this.VIEW_STATE_ENABLE);
            return;
        }
        if (i != 2) {
            changeTextColor(this.mBinding.f13062, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13063, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13064, this.VIEW_STATE_ENABLE);
            changeTextColor(this.mBinding.f13065, this.VIEW_STATE_SELECT);
            return;
        }
        changeTextColor(this.mBinding.f13062, this.VIEW_STATE_ENABLE);
        changeTextColor(this.mBinding.f13063, this.VIEW_STATE_ENABLE);
        changeTextColor(this.mBinding.f13064, this.VIEW_STATE_SELECT);
        changeTextColor(this.mBinding.f13065, this.VIEW_STATE_ENABLE);
    }

    private void changeTextColor(TextView textView, int i) {
        if (i == this.VIEW_STATE_ENABLE) {
            textView.setEnabled(true);
            textView.setTextColor(-1);
        } else if (i == this.VIEW_STATE_DISABLE) {
            textView.setEnabled(false);
            textView.setTextColor(-65536);
        } else {
            textView.setEnabled(true);
            textView.setTextColor(-16711936);
        }
    }

    private void initListener() {
        this.mBinding.f13059.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DemoActivity.this.isPushing) {
                    return;
                }
                DemoActivity.this.pushMode = true;
                DemoActivity.this.changeContent();
                DemoActivity.this.mBinding.f13072.m1987(true);
            }
        });
        this.mBinding.f13071.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DemoActivity.this.isPushing) {
                    return;
                }
                DemoActivity.this.pushMode = false;
                DemoActivity.this.changeContent();
                DemoActivity.this.mBinding.f13072.m1976();
            }
        });
        this.mBinding.f13060.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DemoActivity.this.configFast = false;
                DemoActivity.this.changeConfig();
            }
        });
        this.mBinding.f13061.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DemoActivity.this.configFast = true;
                DemoActivity.this.changeConfig();
            }
        });
        this.mBinding.f13070.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!DemoActivity.this.pushMode) {
                    if (DemoActivity.this.isReceiving) {
                        DemoActivity.this.stopReceiveUI();
                        return;
                    } else {
                        DemoActivity.this.startReceiveUI();
                        return;
                    }
                }
                if (DemoActivity.this.isPushing) {
                    DemoActivity.this.stopPush();
                } else {
                    if (FinderManager.MACHINE_NOT_VALID.equals(FinderManager.getInstance().getSelectMachine())) {
                        return;
                    }
                    DemoActivity.this.startPush();
                }
            }
        });
        this.mBinding.f13066.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FinderManager.getInstance().getSelectMachine().equals("1") || !FinderManager.getInstance().machineCanUse("1")) {
                    return;
                }
                FinderManager.getInstance().setSelectMachine("1");
                DemoActivity.this.refreshMachineViews();
            }
        });
        this.mBinding.f13067.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FinderManager.getInstance().getSelectMachine().equals("2") || !FinderManager.getInstance().machineCanUse("2")) {
                    return;
                }
                FinderManager.getInstance().setSelectMachine("2");
                DemoActivity.this.refreshMachineViews();
            }
        });
        this.mBinding.f13068.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FinderManager.getInstance().getSelectMachine().equals(FinderManager.MACHINE_C) || !FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_C)) {
                    return;
                }
                FinderManager.getInstance().setSelectMachine(FinderManager.MACHINE_C);
                DemoActivity.this.refreshMachineViews();
            }
        });
        this.mBinding.f13069.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FinderManager.getInstance().getSelectMachine().equals(FinderManager.MACHINE_D) || !FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_D)) {
                    return;
                }
                FinderManager.getInstance().setSelectMachine(FinderManager.MACHINE_D);
                DemoActivity.this.refreshMachineViews();
            }
        });
        this.mBinding.f13080.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DemoActivity.this.isPushing) {
                    if (DemoActivity.this.mCurrentDecoderParamsBean == DemoActivity.this.bean1) {
                        DemoActivity demoActivity = DemoActivity.this;
                        demoActivity.mCurrentDecoderParamsBean = demoActivity.bean2;
                    } else {
                        DemoActivity demoActivity2 = DemoActivity.this;
                        demoActivity2.mCurrentDecoderParamsBean = demoActivity2.bean1;
                    }
                    ConnectionManager.getInstance().rePreviewEncode(DemoActivity.this.mCurrentDecoderParamsBean);
                }
            }
        });
        this.mBinding.f13055.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                List<LinkEntity> clientList = LinkManager.getInstance().getClientList();
                if (r1.m8144(clientList)) {
                    LinkEntity linkEntity = clientList.get(0);
                    if (r1.m8143(linkEntity.getUuid())) {
                        List<ACBanBean> list = ACBanManager.getInstance().getList();
                        if (r1.m8144(list)) {
                            Iterator<ACBanBean> it = list.iterator();
                            z = false;
                            while (it.hasNext()) {
                                if (it.next().getUuid().equals(linkEntity.getUuid())) {
                                    z = true;
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (z) {
                            linkEntity.changeBanState(false);
                            ACBanManager.getInstance().removeFromBanList(linkEntity.getUuid());
                        } else {
                            linkEntity.changeBanState(true);
                            ACBanManager.getInstance().addToBanList(linkEntity.getUuid(), linkEntity.getAcMonitorInfoBean().getJob(), linkEntity.getAcMonitorInfoBean().getSuffix());
                        }
                    }
                }
            }
        });
        this.mBinding.f13056.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                List<LinkEntity> clientList = LinkManager.getInstance().getClientList();
                if (!r1.m8144(clientList) || clientList.size() <= 1) {
                    return;
                }
                LinkEntity linkEntity = clientList.get(1);
                if (r1.m8143(linkEntity.getUuid())) {
                    List<ACBanBean> list = ACBanManager.getInstance().getList();
                    if (r1.m8144(list)) {
                        Iterator<ACBanBean> it = list.iterator();
                        z = false;
                        while (it.hasNext()) {
                            if (it.next().getUuid().equals(linkEntity.getUuid())) {
                                z = true;
                            }
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        linkEntity.changeBanState(false);
                        ACBanManager.getInstance().removeFromBanList(linkEntity.getUuid());
                    } else {
                        linkEntity.changeBanState(true);
                        ACBanManager.getInstance().addToBanList(linkEntity.getUuid(), linkEntity.getAcMonitorInfoBean().getJob(), linkEntity.getAcMonitorInfoBean().getSuffix());
                    }
                }
            }
        });
        this.mBinding.f13057.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mBinding.f13058.setOnClickListener(new View.OnClickListener() { // from class: com.blink.academy.film.stream.DemoActivity.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initUnitViews() {
        ArrayList arrayList = new ArrayList();
        this.mUnitViews = arrayList;
        arrayList.add(this.mBinding.f13081);
        this.mUnitViews.add(this.mBinding.f13082);
        this.mUnitViews.add(this.mBinding.f13083);
        this.mUnitViews.add(this.mBinding.f13084);
        this.mBinding.f13081.changeToTestMode();
        this.mBinding.f13082.changeToTestMode();
        this.mBinding.f13083.changeToTestMode();
        this.mBinding.f13084.changeToTestMode();
    }

    private void initView() {
        changeContent();
        changeConfig();
        changeTextColor(this.mBinding.f13070, this.VIEW_STATE_ENABLE);
        changeDeviceBtState();
        changeTextColor(this.mBinding.f13080, this.VIEW_STATE_ENABLE);
        setCameraSettings();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshMachineViews() {
        ACMonitorInfoBean acMonitorInfoBean;
        this.mBinding.f13066.setTextColor(FinderManager.getInstance().machineCanUse("1") ? -1 : -65536);
        this.mBinding.f13067.setTextColor(FinderManager.getInstance().machineCanUse("2") ? -1 : -65536);
        this.mBinding.f13068.setTextColor(FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_C) ? -1 : -65536);
        this.mBinding.f13069.setTextColor(FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_D) ? -1 : -65536);
        String selectMachine = FinderManager.getInstance().getSelectMachine();
        selectMachine.hashCode();
        switch (selectMachine) {
            case "1":
                this.mBinding.f13066.setTextColor(-16711936);
                break;
            case "2":
                this.mBinding.f13067.setTextColor(-16711936);
                break;
            case "4":
                this.mBinding.f13068.setTextColor(-16711936);
                break;
            case "8":
                this.mBinding.f13069.setTextColor(-16711936);
                break;
        }
        if (this.isPushing) {
            List<LinkEntity> links = LinkManager.getInstance().getLinks();
            StringBuilder sb = new StringBuilder();
            if (r1.m8144(links)) {
                for (LinkEntity linkEntity : links) {
                    if (linkEntity.getType() == 0 && (acMonitorInfoBean = linkEntity.getAcMonitorInfoBean()) != null && acMonitorInfoBean.isInit()) {
                        sb.append("uuid:");
                        sb.append(acMonitorInfoBean.getUuid());
                        sb.append(" job:");
                        sb.append(acMonitorInfoBean.getJob());
                        sb.append(" suffix:");
                        sb.append(acMonitorInfoBean.getSuffix());
                        sb.append(" WiFi-Level:");
                        sb.append(ACHelper.getInstance().wifiLevel(acMonitorInfoBean.getWifiStatus()));
                        sb.append("\n\n");
                    }
                }
            }
            this.mBinding.f13079.setText(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshUnitViews() {
        this.mBinding.f13081.refreshConnBtnState();
        this.mBinding.f13082.refreshConnBtnState();
        this.mBinding.f13083.refreshConnBtnState();
        this.mBinding.f13084.refreshConnBtnState();
    }

    private void setCameraSettings() {
        this.mBinding.f13072.m2026(this.mCurrentDecoderParamsBean.m472());
        this.mBinding.f13072.m2027(this.mCurrentDecoderParamsBean.m472());
        this.mBinding.f13072.m2029(0);
        this.mBinding.f13072.setTargetVideoSize(new C2375(this.mCurrentDecoderParamsBean.m475(), this.mCurrentDecoderParamsBean.m473()));
        this.mBinding.f13072.m1987(false);
    }

    private void startNSDFinder() {
        FinderManager.getInstance().startNSDFinder(this, new IDiscoveryCallBack() { // from class: com.blink.academy.film.stream.DemoActivity.3
            @Override // com.blink.academy.film.support.socket.IDiscoveryCallBack
            public void onServiceFound(final NsdServiceInfo nsdServiceInfo) {
                DemoActivity.this.runOnUiThread(new Runnable() { // from class: com.blink.academy.film.stream.DemoActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() throws NumberFormatException {
                        C4638.m14099("slimC213", "serviceInfo:" + nsdServiceInfo);
                        Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
                        Set<String> setKeySet = attributes.keySet();
                        ServiceInfoBean serviceInfoBean = null;
                        if (r1.m8144(setKeySet)) {
                            for (String str : setKeySet) {
                                if ("info".equals(str)) {
                                    serviceInfoBean = (ServiceInfoBean) new Gson().fromJson(new String(attributes.get(str), StandardCharsets.UTF_8), ServiceInfoBean.class);
                                }
                            }
                        }
                        if (serviceInfoBean == null) {
                            return;
                        }
                        NsdServiceInfoEntity nsdServiceInfoEntity = new NsdServiceInfoEntity();
                        nsdServiceInfoEntity.setNsdServiceInfo(nsdServiceInfo);
                        nsdServiceInfoEntity.setServiceInfoBean(serviceInfoBean);
                        FinderManager.getInstance().addNsdServiceInfo(nsdServiceInfoEntity);
                    }
                });
            }

            @Override // com.blink.academy.film.support.socket.IDiscoveryCallBack
            public void onServiceLost(NsdServiceInfo nsdServiceInfo) throws NumberFormatException {
                Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
                Set<String> setKeySet = attributes.keySet();
                ServiceInfoBean serviceInfoBean = null;
                if (r1.m8144(setKeySet)) {
                    for (String str : setKeySet) {
                        if ("info".equals(str)) {
                            serviceInfoBean = (ServiceInfoBean) new Gson().fromJson(new String(attributes.get(str), StandardCharsets.UTF_8), ServiceInfoBean.class);
                        }
                    }
                }
                NsdServiceInfoEntity nsdServiceInfoEntity = new NsdServiceInfoEntity();
                nsdServiceInfoEntity.setNsdServiceInfo(nsdServiceInfo);
                nsdServiceInfoEntity.setServiceInfoBean(serviceInfoBean);
                FinderManager.getInstance().removeNsdServiceInfo(nsdServiceInfoEntity);
                LinkManager.getInstance().removeLinkByIP(nsdServiceInfo.getHost().getHostAddress());
                C4638.m14099("slimC213", "onServiceLost");
            }
        }, new FinderManager.OnFinderCallback() { // from class: com.blink.academy.film.stream.DemoActivity.4
            @Override // com.blink.academy.film.stream.FinderManager.OnFinderCallback
            public void needStopPush() {
                DemoActivity.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.DemoActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DemoActivity.this.isPushing) {
                            DemoActivity.this.stopPush();
                        }
                    }
                });
            }
        });
    }

    private void startNSDServer() {
        FinderManager.getInstance().startNSDServer(this, new FinderManager.OnNSDServerCallback() { // from class: com.blink.academy.film.stream.DemoActivity.5
            @Override // com.blink.academy.film.stream.FinderManager.OnNSDServerCallback
            public void onStartFail() {
                DemoActivity.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.DemoActivity.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DemoActivity.this.stopPush();
                    }
                });
            }

            @Override // com.blink.academy.film.stream.FinderManager.OnNSDServerCallback
            public void onStartSuc() {
                ConnectionManager.getInstance().startPush(DemoActivity.this.mCurrentDecoderParamsBean);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPush() {
        this.isPushing = true;
        this.mBinding.f13070.setText("停止");
        startNSDServer();
        this.mBinding.f13079.setText("");
        this.mBinding.f13079.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReceiveUI() {
        this.isReceiving = true;
        this.mBinding.f13070.setText("停止");
        this.mBinding.f13077.setVisibility(0);
        LinkManager.getInstance().startLoop(new LinkManager.OnCheckViewState() { // from class: com.blink.academy.film.stream.DemoActivity.20
            @Override // com.blink.academy.film.stream.LinkManager.OnCheckViewState
            public List<ACUnitView> getViews() {
                return DemoActivity.this.mUnitViews;
            }
        });
    }

    private void stopNSDFinder() {
        FinderManager.getInstance().stopNSDFinder();
    }

    private void stopNSDServer() {
        FinderManager.getInstance().releaseServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopPush() {
        this.isPushing = false;
        this.mBinding.f13070.setText("启动");
        stopNSDServer();
        ConnectionManager.getInstance().stopPush();
        this.mBinding.f13079.setVisibility(8);
        this.mBinding.f13079.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopReceiveUI() {
        this.isReceiving = false;
        this.mBinding.f13070.setText("启动");
        this.mBinding.f13077.setVisibility(8);
        LinkManager.getInstance().release();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_demo);
        this.mBinding = (AbstractC3816) DataBindingUtil.setContentView(this, R.layout.activity_demo);
        this.bean1 = new DecoderParamsBean(2130708361, 1500000, 30, 1, LogType.UNEXP_ANR, 720, "video/hevc");
        this.bean2 = new DecoderParamsBean(2130708361, 3000000, 30, 1, DPXReader.TVINFO_OFFSET, 1080, "video/hevc");
        this.mCurrentDecoderParamsBean = this.bean1;
        initView();
        initListener();
        initUnitViews();
        this.mBinding.f13072.m2022(2);
        startNSDFinder();
        this.mHandler = new Handler();
        synchronized (this.mReadyFence) {
            HandlerThread handlerThread = new HandlerThread("DemoActivity");
            this.handlerThread = handlerThread;
            handlerThread.setPriority(4);
            this.handlerThread.start();
            Handler handler = new Handler(this.handlerThread.getLooper(), new Handler.Callback() { // from class: com.blink.academy.film.stream.DemoActivity.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(@NonNull Message message) {
                    int i = message.what;
                    return true;
                }
            });
            this.mThreadHandler = handler;
            handler.sendEmptyMessage(MSG_REFRESH_INFO);
        }
        ConnectionManager.getInstance().initSrt();
        ACHelper.getInstance().setOnCameraCallback(new ACHelper.OnCameraCallback() { // from class: com.blink.academy.film.stream.DemoActivity.2
            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void needShowHintText(int i, LinkEntity linkEntity) {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onAlbumModeClickByClient(boolean z, LinkEntity linkEntity) {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onBitrateScaleChange(float f) {
                if (DemoActivity.this.isPushing) {
                    DemoActivity.this.bean1.m478((int) (1500000.0f * f));
                    DemoActivity.this.bean2.m478((int) (f * 3000000.0f));
                    if (DemoActivity.this.mCurrentDecoderParamsBean == DemoActivity.this.bean1) {
                        ConnectionManager.getInstance().updateBitrate(DemoActivity.this.bean1.m470());
                    } else {
                        ConnectionManager.getInstance().updateBitrate(DemoActivity.this.bean2.m470());
                    }
                }
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onCheckRefreshRoomId() {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onFocusChange(float f) {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onRecordClickByClient(boolean z, LinkEntity linkEntity) {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onWheelModeChange(boolean z) {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void onZoomChange(float f) {
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void refreshMachineViews() {
                DemoActivity.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.DemoActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DemoActivity.this.refreshMachineViews();
                    }
                });
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void refreshViewsLow() {
                DemoActivity.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.DemoActivity.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DemoActivity.this.refreshUnitViews();
                    }
                });
            }

            @Override // com.blink.academy.film.stream.ACHelper.OnCameraCallback
            public void updateLocalWifiInfo(NetInfoBean netInfoBean) {
                final String str = "ip:" + netInfoBean.getLocalIP() + " gatewayIP:" + netInfoBean.getGatewayIP() + " ssid:" + netInfoBean.getSsid() + " bssid:" + netInfoBean.getBssid() + " wifiStatus:" + netInfoBean.getWifiStatus() + " wifiLevel:" + netInfoBean.getWifiLevel();
                if (!DemoActivity.this.lastInfoString.equals(str)) {
                    DemoActivity.this.mHandler.post(new Runnable() { // from class: com.blink.academy.film.stream.DemoActivity.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            DemoActivity.this.mBinding.f13080.setText(str);
                        }
                    });
                }
                DemoActivity.this.lastInfoString = str;
            }
        });
        ACHelper.getInstance().startLoop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ConnectionManager.getInstance().releaseSrt();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mThreadHandler.removeCallbacksAndMessages(null);
        FinderManager.getInstance().release();
        ACHelper.getInstance().stopLoop();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        stopNSDFinder();
        stopPush();
        stopReceiveUI();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mBinding.f13072.mo1968();
        this.mBinding.f13072.setVisibility(0);
    }
}
