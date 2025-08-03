package com.blink.academy.film.stream;

import android.net.nsd.NsdServiceInfo;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.github.thibaultbee.srtdroid.models.Socket;
import com.google.gson.Gson;
import defpackage.C3688;
import defpackage.C3947;
import defpackage.C4638;
import defpackage.r1;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class LinkManager {
    private static LinkManager instance;
    public static final Object linkFence = new Object();
    public static final Object remoteLinkFence = new Object();
    private boolean controllable;
    private String mRemoteFirstIp;
    private OnCheckViewState onCheckViewState;
    private final List<LinkEntity> mClientList = new ArrayList();
    private final List<LinkEntity> mAvailableClientList = new ArrayList();
    private final List<LinkEntity> mBannedClientList = new ArrayList();
    private final List<LinkEntity> mServerList = new ArrayList();
    private final List<LinkEntity> mCacheBannedList = new ArrayList();
    private int mClientListSize = 0;
    public String[] controllableStrs = null;
    private boolean hasCloudLinkCelForMonitorCheck = false;
    private boolean hasCloudLinkForMonitorCheck = false;
    private boolean request = false;
    private float mTargetBitrateScale = 1.0f;
    private List<LinkEntity> mLinks = new ArrayList();
    private List<LinkEntity> mRemoteLinks = new ArrayList();
    private Map<Integer, List<ACUnitView>> mTextureMap = new HashMap();

    public interface OnCheckViewState {
        List<ACUnitView> getViews();
    }

    private LinkManager() {
        resetTextureMap();
    }

    private void addLink(LinkEntity linkEntity) {
        removeLink(linkEntity);
        synchronized (linkFence) {
            this.mLinks.add(linkEntity);
        }
    }

    private void addRemoteLink(LinkEntity linkEntity) {
        removeLink(linkEntity);
        synchronized (remoteLinkFence) {
            if (ACBanManager.getInstance().banned(linkEntity.getUuid())) {
                linkEntity.changeBanState(true);
            }
            this.mRemoteLinks.add(linkEntity);
        }
    }

    private LinkEntity checkNeedAddLink(LinkParamBean linkParamBean) {
        boolean z;
        String a = linkParamBean.getA();
        LinkEntity linkEntity = null;
        if (!r1.m8143(a)) {
            return null;
        }
        synchronized (remoteLinkFence) {
            if (r1.m8144(this.mRemoteLinks)) {
                for (LinkEntity linkEntity2 : this.mRemoteLinks) {
                    if (a.equals(linkEntity2.getUuid())) {
                        z = false;
                        linkEntity = linkEntity2;
                        break;
                    }
                }
                z = true;
            } else {
                z = true;
            }
        }
        if (z) {
            linkEntity = new LinkEntity(2, -1, "", 0, null, "", "1");
        }
        String a2 = linkParamBean.getA();
        if (r1.m8143(a2)) {
            linkEntity.setUuid(a2);
        }
        ACMonitorInfoBean acMonitorInfoBean = linkEntity.getAcMonitorInfoBean();
        if (r1.m8143(a2)) {
            acMonitorInfoBean.setUuid(a2);
        }
        acMonitorInfoBean.setSuffix(linkParamBean.getB());
        acMonitorInfoBean.setJob(linkParamBean.getC() + "");
        acMonitorInfoBean.setWifiStatus(linkParamBean.getD());
        String bt = linkParamBean.getBt();
        if (r1.m8143(bt)) {
            acMonitorInfoBean.setNetType(bt);
        }
        linkEntity.setRemoteMonitorLastUpdateTimestamp(System.currentTimeMillis());
        if (z) {
            addRemoteLink(linkEntity);
        }
        return linkEntity;
    }

    private void connectLinkIfNot() {
        if (r1.m8142(this.mTextureMap)) {
            Iterator<Integer> it = this.mTextureMap.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (r1.m8144(this.mTextureMap.get(Integer.valueOf(iIntValue))) && !checkLinkIndexIsConn(iIntValue)) {
                    String machineByLinkIndex = FinderManager.getInstance().getMachineByLinkIndex(iIntValue);
                    String remoteRoomIdByMachine = FinderManager.getInstance().getRemoteRoomIdByMachine(machineByLinkIndex);
                    if (r1.m8143(remoteRoomIdByMachine)) {
                        C4638.m14099("xcvvxcv", "to connect roomId:" + remoteRoomIdByMachine);
                        LinkEntity linkEntity = new LinkEntity(1, iIntValue, "", 0, null, "", "", true);
                        linkEntity.requestRoomInfo(remoteRoomIdByMachine);
                        addLink(linkEntity);
                    } else {
                        NsdServiceInfoEntity nsdServiceInfoEntityByMachine = FinderManager.getInstance().getNsdServiceInfoEntityByMachine(machineByLinkIndex);
                        if (nsdServiceInfoEntityByMachine != null) {
                            NsdServiceInfo nsdServiceInfo = nsdServiceInfoEntityByMachine.getNsdServiceInfo();
                            ServiceInfoBean serviceInfoBean = nsdServiceInfoEntityByMachine.getServiceInfoBean();
                            String v = serviceInfoBean.getV();
                            if (r1.m8143(v)) {
                                try {
                                    if (Integer.parseInt(v) >= 1) {
                                        startReceive(iIntValue, nsdServiceInfo.getHost().getHostAddress(), 2311, serviceInfoBean.getUuid(), "1", false);
                                        return;
                                    }
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                LinkEntity linkEntity2 = new LinkEntity(1, iIntValue, "", 0, null, "", "1");
                                linkEntity2.setLinkStatus(5);
                                addLink(linkEntity2);
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    private void disconnectLinkWithoutTextures() {
        if (r1.m8142(this.mTextureMap)) {
            Set<Integer> setKeySet = this.mTextureMap.keySet();
            if (r1.m8144(setKeySet)) {
                Iterator<Integer> it = setKeySet.iterator();
                while (it.hasNext()) {
                    int iIntValue = it.next().intValue();
                    if (r1.m8144(this.mTextureMap.get(Integer.valueOf(iIntValue)))) {
                        String machineByLinkIndex = FinderManager.getInstance().getMachineByLinkIndex(iIntValue);
                        int iMachineCanConnect = FinderManager.getInstance().machineCanConnect(machineByLinkIndex);
                        if (iMachineCanConnect < 0) {
                            removeLinkByLinkIndex(iIntValue);
                        } else {
                            LinkEntity linkEntityByLinkIndex = getLinkEntityByLinkIndex(iIntValue);
                            if (linkEntityByLinkIndex != null) {
                                boolean z = false;
                                if (iMachineCanConnect == 3 && !linkEntityByLinkIndex.isCloudCameraLink()) {
                                    z = true;
                                }
                                if ((z || !linkEntityByLinkIndex.isCloudCameraLink() || FinderManager.getInstance().machineCanConnRemote(machineByLinkIndex)) ? z : true) {
                                    removeLinkByLinkIndex(iIntValue);
                                }
                            }
                        }
                    } else {
                        removeLinkByLinkIndex(iIntValue);
                    }
                }
            }
        }
    }

    public static LinkManager getInstance() {
        if (instance == null) {
            synchronized (LinkManager.class) {
                if (instance == null) {
                    instance = new LinkManager();
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loopLinks() {
        /*
            Method dump skipped, instructions count: 1113
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.LinkManager.loopLinks():void");
    }

    private void refreshTextureMapData() {
        OnCheckViewState onCheckViewState = this.onCheckViewState;
        if (onCheckViewState != null) {
            List<ACUnitView> views = onCheckViewState.getViews();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            if (!r1.m8144(views)) {
                resetTextureMap();
                return;
            }
            for (ACUnitView aCUnitView : views) {
                int linkIndex = aCUnitView.getLinkIndex();
                if (linkIndex == 0) {
                    arrayList.add(aCUnitView);
                } else if (linkIndex == 1) {
                    arrayList2.add(aCUnitView);
                } else if (linkIndex == 2) {
                    arrayList3.add(aCUnitView);
                } else if (linkIndex == 3) {
                    arrayList4.add(aCUnitView);
                }
            }
            this.mTextureMap.put(0, arrayList);
            this.mTextureMap.put(1, arrayList2);
            this.mTextureMap.put(2, arrayList3);
            this.mTextureMap.put(3, arrayList4);
        }
    }

    private void releaseLink(LinkEntity linkEntity) {
        linkEntity.release();
    }

    private void removeLink(LinkEntity linkEntity) {
        if (r1.m8144(this.mLinks)) {
            synchronized (linkFence) {
                Iterator<LinkEntity> it = this.mLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (next.getIp().equals(linkEntity.getIp()) && linkEntity.getPort() == next.getPort() && linkEntity.getIndex() == next.getIndex()) {
                        releaseLink(linkEntity);
                        it.remove();
                    }
                }
            }
        }
    }

    private void removeRemoteLink(LinkEntity linkEntity) {
        if (r1.m8144(this.mRemoteLinks)) {
            synchronized (remoteLinkFence) {
                Iterator<LinkEntity> it = this.mRemoteLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (next.getIp().equals(linkEntity.getIp()) && linkEntity.getPort() == next.getPort() && linkEntity.getIndex() == next.getIndex()) {
                        releaseLink(linkEntity);
                        it.remove();
                    }
                }
            }
        }
    }

    private void resetTextureMap() {
        this.mTextureMap.clear();
        this.mTextureMap.put(0, new ArrayList());
        this.mTextureMap.put(1, new ArrayList());
        this.mTextureMap.put(2, new ArrayList());
        this.mTextureMap.put(3, new ArrayList());
    }

    public void addClient(Socket socket) {
        InetSocketAddress peerName = socket.getPeerName();
        if (peerName != null) {
            addLink(new LinkEntity(0, -2, peerName.getAddress().getHostAddress(), peerName.getPort(), socket, "", "1"));
        }
    }

    public boolean canSendVideoData() {
        synchronized (remoteLinkFence) {
            if (!r1.m8144(this.mRemoteLinks)) {
                return false;
            }
            Iterator<LinkEntity> it = this.mRemoteLinks.iterator();
            while (it.hasNext()) {
                if (!it.next().isBanned()) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean checkLinkIndexIsConn(int i) {
        if (r1.m8144(this.mLinks)) {
            Iterator<LinkEntity> it = this.mLinks.iterator();
            while (it.hasNext()) {
                if (it.next().getIndex() == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkReconnectLinkForCloudMonitor() {
        if (r1.m8144(this.mLinks)) {
            synchronized (linkFence) {
                for (LinkEntity linkEntity : this.mLinks) {
                    if (linkEntity.isCloudCameraLink() && (linkEntity.getLinkStatus() == 8 || linkEntity.getLinkStatus() == 9 || linkEntity.getLinkStatus() == 12 || linkEntity.getLinkStatus() == 13 || linkEntity.getLinkStatus() == 14 || !linkEntity.isFirstNoValid())) {
                        if (PingHelper.getInstance().getNetState() == 3) {
                            linkEntity.requestRoomInfo(FinderManager.getInstance().getRemoteRoomIdByMachine(FinderManager.getInstance().getMachineByLinkIndex(linkEntity.getLinkIndex())));
                        } else if (!linkEntity.isFirstNoValid()) {
                            linkEntity.setLinkStatus(8);
                        }
                    }
                }
            }
        }
    }

    public boolean checkRemoteLinkIndexIsConn(int i) {
        boolean z;
        synchronized (remoteLinkFence) {
            z = false;
            if (r1.m8144(this.mRemoteLinks)) {
                Iterator<LinkEntity> it = this.mRemoteLinks.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getIndex() == i) {
                        z = true;
                        break;
                    }
                }
            }
        }
        return z;
    }

    public void clearClientLinks() {
        if (r1.m8144(this.mLinks)) {
            synchronized (linkFence) {
                Iterator<LinkEntity> it = this.mLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (next.getType() == 0) {
                        releaseLink(next);
                        it.remove();
                    }
                }
            }
        }
    }

    public ACCameraInfoBean getACCameraInfoBeanByLinkIndex(int i) {
        if (!r1.m8144(this.mLinks)) {
            return null;
        }
        for (LinkEntity linkEntity : this.mLinks) {
            if (linkEntity.getLinkIndex() == i) {
                return linkEntity.getAcCameraInfoBean();
            }
        }
        return null;
    }

    public List<LinkEntity> getAvailableClientList() {
        return this.mAvailableClientList;
    }

    public List<LinkEntity> getCacheBannedList() {
        return this.mCacheBannedList;
    }

    public List<LinkEntity> getClientList() {
        return this.mClientList;
    }

    public int getClientListSize() {
        return this.mClientListSize;
    }

    public String[] getControllableStrs() {
        return this.controllableStrs;
    }

    public LinkEntity getLinkEntityByLinkIndex(int i) {
        synchronized (linkFence) {
            if (r1.m8144(this.mLinks)) {
                for (LinkEntity linkEntity : this.mLinks) {
                    if (linkEntity != null && linkEntity.getLinkIndex() == i) {
                        return linkEntity;
                    }
                }
            }
            return null;
        }
    }

    public int getLinkStatusByLinkIndex(int i) {
        if (!r1.m8144(this.mLinks)) {
            return 0;
        }
        for (LinkEntity linkEntity : this.mLinks) {
            if (linkEntity.getLinkIndex() == i) {
                return linkEntity.getLinkStatus();
            }
        }
        return 0;
    }

    public List<LinkEntity> getLinks() {
        return this.mLinks;
    }

    public String getMonitorSignalNetType() {
        return C3688.m11833(FilmApp.m402());
    }

    public String getRemoteFirstIp() {
        return this.mRemoteFirstIp;
    }

    public List<LinkEntity> getRemoteLinks() {
        return this.mRemoteLinks;
    }

    public List<LinkEntity> getServerList() {
        return this.mServerList;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float getTargetBitrateScale() {
        /*
            r9 = this;
            r0 = 0
            java.util.List<com.blink.academy.film.stream.LinkEntity> r1 = r9.mLinks     // Catch: java.lang.Exception -> L84
            boolean r1 = defpackage.r1.m8144(r1)     // Catch: java.lang.Exception -> L84
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            if (r1 == 0) goto L2f
            java.util.List<com.blink.academy.film.stream.LinkEntity> r1 = r9.mLinks     // Catch: java.lang.Exception -> L84
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Exception -> L84
            r4 = r2
        L13:
            boolean r5 = r1.hasNext()     // Catch: java.lang.Exception -> L84
            if (r5 == 0) goto L30
            java.lang.Object r5 = r1.next()     // Catch: java.lang.Exception -> L84
            com.blink.academy.film.stream.LinkEntity r5 = (com.blink.academy.film.stream.LinkEntity) r5     // Catch: java.lang.Exception -> L84
            int r6 = r5.getType()     // Catch: java.lang.Exception -> L84
            if (r6 != 0) goto L13
            float r0 = r5.getDropPercent()     // Catch: java.lang.Exception -> L84
            float r4 = java.lang.Math.min(r0, r4)     // Catch: java.lang.Exception -> L84
            r0 = r3
            goto L13
        L2f:
            r4 = r2
        L30:
            java.util.List<com.blink.academy.film.stream.LinkEntity> r1 = r9.mRemoteLinks     // Catch: java.lang.Exception -> L84
            boolean r1 = defpackage.r1.m8144(r1)     // Catch: java.lang.Exception -> L84
            if (r1 == 0) goto L5e
            com.blink.academy.film.stream.ConnectionManager r1 = com.blink.academy.film.stream.ConnectionManager.getInstance()     // Catch: java.lang.Exception -> L84
            com.github.thibaultbee.srtdroid.models.Socket r1 = r1.getPublicSocket()     // Catch: java.lang.Exception -> L84
            if (r1 == 0) goto L5e
            com.github.thibaultbee.srtdroid.models.Stats r1 = r1.bistats(r3, r3)     // Catch: java.lang.Exception -> L5e
            int r5 = r1.getPktSndDropTotal()     // Catch: java.lang.Exception -> L5e
            long r5 = (long) r5     // Catch: java.lang.Exception -> L5e
            long r7 = r1.getPktSentTotal()     // Catch: java.lang.Exception -> L5e
            float r1 = (float) r5     // Catch: java.lang.Exception -> L5e
            float r1 = r1 * r2
            r5 = 1
            long r5 = java.lang.Math.max(r5, r7)     // Catch: java.lang.Exception -> L5e
            float r5 = (float) r5     // Catch: java.lang.Exception -> L5e
            float r1 = r1 / r5
            float r4 = java.lang.Math.min(r1, r4)     // Catch: java.lang.Exception -> L5e
            goto L5f
        L5e:
            r3 = r0
        L5f:
            if (r3 == 0) goto L88
            double r0 = (double) r4
            r3 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L72
            float r0 = r9.mTargetBitrateScale     // Catch: java.lang.Exception -> L84
            r1 = 1045220557(0x3e4ccccd, float:0.2)
            float r0 = r0 - r1
            goto L78
        L72:
            float r0 = r9.mTargetBitrateScale     // Catch: java.lang.Exception -> L84
            r1 = 1008981770(0x3c23d70a, float:0.01)
            float r0 = r0 + r1
        L78:
            r1 = 0
            float r0 = java.lang.Math.max(r0, r1)     // Catch: java.lang.Exception -> L84
            float r0 = java.lang.Math.min(r0, r2)     // Catch: java.lang.Exception -> L84
            r9.mTargetBitrateScale = r0     // Catch: java.lang.Exception -> L84
            goto L88
        L84:
            r0 = move-exception
            r0.printStackTrace()
        L88:
            float r0 = r9.mTargetBitrateScale
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.stream.LinkManager.getTargetBitrateScale():float");
    }

    public List<ACUnitView> getTexturesByLinkIndex(int i) {
        return this.mTextureMap.get(Integer.valueOf(i));
    }

    public boolean hasLinks() {
        return r1.m8144(this.mLinks);
    }

    public boolean isControllable() {
        return this.controllable;
    }

    public boolean isHasCloudLinkCelForMonitorCheck() {
        return this.hasCloudLinkCelForMonitorCheck;
    }

    public boolean isHasCloudLinkForMonitorCheck() {
        return this.hasCloudLinkForMonitorCheck;
    }

    public void onGetRemoteLinkInfo(String str) throws NumberFormatException {
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
            LinkEntity linkEntityCheckNeedAddLink = checkNeedAddLink(linkParamBean);
            if (linkEntityCheckNeedAddLink == null) {
                return;
            }
            ACMonitorInfoBean acMonitorInfoBean = linkEntityCheckNeedAddLink.getAcMonitorInfoBean();
            if (!string.contains("\"j\":") && !string.contains("\"j\" :")) {
                if (!string.contains("\"p\":") && !string.contains("\"p\" :")) {
                    if (!string.contains("\"s\":") && !string.contains("\"s\" :")) {
                        if (!string.contains("\"t\":") && !string.contains("\"t\" :")) {
                            if (!string.contains("\"u\":") && !string.contains("\"u\" :")) {
                                if (!string.contains("\"w\":") && !string.contains("\"w\" :")) {
                                    if (!string.contains("\"x\":") && !string.contains("\"x\" :")) {
                                        if (!string.contains("\"y\":") && !string.contains("\"y\" :")) {
                                            acMonitorInfoBean.setInit(true);
                                            if (r1.m8143(linkEntityCheckNeedAddLink.getUuid())) {
                                                return;
                                            }
                                            List<ACBanBean> list = ACBanManager.getInstance().getList();
                                            if (r1.m8144(list)) {
                                                Iterator<ACBanBean> it = list.iterator();
                                                while (it.hasNext()) {
                                                    if (it.next().getUuid().equals(linkParamBean.getA())) {
                                                        linkEntityCheckNeedAddLink.changeBanState(true);
                                                        return;
                                                    }
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                                            ACHelper aCHelper = ACHelper.getInstance();
                                            if (Integer.parseInt(linkParamBean.getY()) != 1) {
                                                z = false;
                                            }
                                            aCHelper.onMonitorChangeWheelMode(z);
                                            return;
                                        }
                                        return;
                                    }
                                    if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                                        ACHelper.getInstance().onMonitorChangeZoom(C3947.m12727().m12753(Integer.parseInt(linkParamBean.getX()) / 1000.0f));
                                        return;
                                    }
                                    return;
                                }
                                if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                                    int i = Integer.parseInt(linkParamBean.getW());
                                    ACHelper.getInstance().onMonitorChangeFocus(i == -2000 ? -0.25f : i == -1000 ? 1.25f : 1.0f - (i / 1000.0f));
                                    return;
                                }
                                return;
                            }
                            if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                                ACHelper.getInstance().onAlbumTagClickControl(Integer.parseInt(linkParamBean.getU()), linkEntityCheckNeedAddLink);
                                return;
                            }
                            return;
                        }
                        if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                            ACHelper.getInstance().onAlbumModeClickControl("1".equals(linkParamBean.getT()), linkEntityCheckNeedAddLink);
                            return;
                        }
                        return;
                    }
                    if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                        ACHelper.getInstance().onControlClickControl(linkParamBean.getS(), linkEntityCheckNeedAddLink);
                        return;
                    }
                    return;
                }
                if ((string.contains("\"at\":") || string.contains("\"at\" :")) && ACHelper.getInstance().getRoomId().equals(linkParamBean.getAt())) {
                    ACHelper.getInstance().onMonitorClickPlay(linkParamBean.getP(), linkEntityCheckNeedAddLink);
                    return;
                }
                return;
            }
            acMonitorInfoBean.setCaptureEvent(linkParamBean.getJ());
            ACHelper.getInstance().onMonitorClickRecord(linkParamBean.getJ(), linkEntityCheckNeedAddLink);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onLoopCheck() {
        if (this.onCheckViewState != null) {
            refreshTextureMapData();
            disconnectLinkWithoutTextures();
            connectLinkIfNot();
        }
        loopLinks();
    }

    public void release() {
        if (r1.m8144(this.mLinks)) {
            synchronized (linkFence) {
                Iterator<LinkEntity> it = this.mLinks.iterator();
                while (it.hasNext()) {
                    releaseLink(it.next());
                }
                this.mLinks.clear();
            }
        }
        if (r1.m8144(this.mRemoteLinks)) {
            synchronized (remoteLinkFence) {
                Iterator<LinkEntity> it2 = this.mRemoteLinks.iterator();
                while (it2.hasNext()) {
                    releaseLink(it2.next());
                }
                this.mRemoteLinks.clear();
            }
        }
        setOnCheckViewState(null);
        this.mTargetBitrateScale = 1.0f;
        this.hasCloudLinkCelForMonitorCheck = false;
        this.hasCloudLinkForMonitorCheck = false;
    }

    public void removeClient(Socket socket) throws SocketException {
        InetSocketAddress peerName = socket.getPeerName();
        if (peerName != null) {
            removeLinkByIP(peerName.getHostName());
        }
    }

    public void removeClientLinks(List<LinkEntity> list) {
        if (r1.m8144(this.mLinks) && r1.m8144(list)) {
            synchronized (linkFence) {
                Iterator<LinkEntity> it = this.mLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (next.getType() == 0) {
                        for (LinkEntity linkEntity : list) {
                            if (linkEntity.getIp().equals(next.getIp()) && linkEntity.getPort() == next.getPort()) {
                                releaseLink(next);
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    public void removeLinkByIP(String str) {
        if (r1.m8144(this.mLinks)) {
            synchronized (linkFence) {
                Iterator<LinkEntity> it = this.mLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (str.equals(next.getIp())) {
                        releaseLink(next);
                        it.remove();
                    }
                }
            }
        }
    }

    public void removeLinkByLinkIndex(int i) {
        if (r1.m8144(this.mLinks)) {
            synchronized (linkFence) {
                Iterator<LinkEntity> it = this.mLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (i == next.getIndex()) {
                        releaseLink(next);
                        it.remove();
                    }
                }
            }
        }
    }

    public void removeRemoteLinkByLinkIndex(int i) {
        if (r1.m8144(this.mRemoteLinks)) {
            synchronized (remoteLinkFence) {
                Iterator<LinkEntity> it = this.mRemoteLinks.iterator();
                while (it.hasNext()) {
                    LinkEntity next = it.next();
                    if (i == next.getIndex()) {
                        releaseLink(next);
                        it.remove();
                    }
                }
            }
        }
    }

    public void setControllable(boolean z) {
        this.controllable = z;
    }

    public void setOnCheckViewState(OnCheckViewState onCheckViewState) {
        this.onCheckViewState = onCheckViewState;
    }

    public void startLoop(OnCheckViewState onCheckViewState) {
        setOnCheckViewState(onCheckViewState);
    }

    public void startReceive(int i, String str, int i2, String str2, String str3, boolean z) {
        addLink(new LinkEntity(1, i, str, i2, null, str2, str3, z));
    }
}
