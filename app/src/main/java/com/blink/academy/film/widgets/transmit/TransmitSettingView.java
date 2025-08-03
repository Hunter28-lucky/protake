package com.blink.academy.film.widgets.transmit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.stream.LinkEntity;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.film.stream.NetInfoBean;
import com.blink.academy.film.stream.ban.ACBanBean;
import com.blink.academy.film.stream.ban.ACBanManager;
import com.blink.academy.film.support.socket.TransmitHelper;
import com.blink.academy.film.widgets.FilmPointView;
import com.blink.academy.film.widgets.dialog.SettingHintDialog;
import com.blink.academy.film.widgets.transmit.TransmitSettingPag1;
import com.blink.academy.protake.R;
import defpackage.AbstractC3516;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C2618;
import defpackage.C3891;
import defpackage.C4008;
import defpackage.C4792;
import defpackage.C5092;
import defpackage.o3;
import defpackage.r1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TransmitSettingView extends FrameLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3516 f4319;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f4320;

    /* renamed from: ԭ, reason: contains not printable characters */
    public TransmitSettingPag1 f4321;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public TransmitSettingPage2 f4322;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f4323;

    /* renamed from: ՠ, reason: contains not printable characters */
    public long f4324;

    /* renamed from: ֈ, reason: contains not printable characters */
    public NetInfoBean f4325;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f4326;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f4327;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C5092 f4328;

    /* renamed from: ހ, reason: contains not printable characters */
    public List<View> f4329;

    /* renamed from: ށ, reason: contains not printable characters */
    public List<LinkEntity> f4330;

    /* renamed from: ނ, reason: contains not printable characters */
    public InterfaceC1640 f4331;

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$Ϳ, reason: contains not printable characters */
    public class C1623 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f4332;

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$Ϳ$Ϳ, reason: contains not printable characters */
        public class C1624 extends AbstractC4012 {
            public C1624() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                TransmitSettingView.this.f4319.f12292.setVisibility(8);
            }
        }

        public C1623(SettingHintDialog settingHintDialog) {
            this.f4332 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (FilmApp.m405().m426()) {
                C4008.m12876(this.f4332, 0.0f, 100, new C1624());
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", TransmitSettingView.this.getContext().getPackageName(), null));
            TransmitSettingView.this.getContext().startActivity(intent);
            TransmitSettingView.this.f4319.f12292.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$Ԩ, reason: contains not printable characters */
    public class C1625 extends AbstractC4012 {
        public C1625() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            TransmitSettingView.this.f4319.f12292.setVisibility(0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$Ԫ, reason: contains not printable characters */
    public class C1626 extends AbstractC4012 {
        public C1626() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            TransmitSettingView.this.f4327 = false;
            if (TransmitSettingView.this.f4331 != null) {
                TransmitSettingView.this.f4331.mo4382(o3.m7669().m7672());
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$Ԭ, reason: contains not printable characters */
    public class RunnableC1627 implements Runnable {
        public RunnableC1627() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TransmitSettingView.this.setVisibility(8);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$Ԯ, reason: contains not printable characters */
    public class C1628 implements ViewPager.OnPageChangeListener {
        public C1628() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TransmitSettingView.this.f4323 = i;
            o3.m7669().m7674(i);
            TransmitSettingView.this.m4339();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ՠ, reason: contains not printable characters */
    public class ViewOnClickListenerC1629 implements View.OnClickListener {
        public ViewOnClickListenerC1629() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TransmitSettingView.this.m4352();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ֈ, reason: contains not printable characters */
    public class ViewOnClickListenerC1630 implements View.OnClickListener {
        public ViewOnClickListenerC1630() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (Build.VERSION.SDK_INT >= 31 && ContextCompat.checkSelfPermission(TransmitSettingView.this.getContext(), "android.permission.BLUETOOTH_CONNECT") != 0) {
                TransmitSettingView.this.m4373();
                return;
            }
            if (TransmitSettingView.this.f4324 == 0) {
                TransmitSettingView.this.f4324 = System.currentTimeMillis();
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - TransmitSettingView.this.f4324 < 500) {
                    return;
                } else {
                    TransmitSettingView.this.f4324 = jCurrentTimeMillis;
                }
            }
            if (TransmitSettingView.this.f4331 == null || TransmitSettingView.this.f4321 == null) {
                return;
            }
            if (TransmitSettingView.this.f4321.getEquipmentType() != 1) {
                if (o3.m7669().m7673()) {
                    o3.m7669().m7676(false);
                } else {
                    o3.m7669().m7676(true);
                }
                TransmitSettingView.this.m4367();
                TransmitSettingView.this.f4321.m4298(o3.m7669().m7673());
                if (o3.m7669().m7673()) {
                    TransmitSettingView.this.f4331.mo4386(TransmitSettingView.this.f4321.getJobType(), TransmitSettingView.this.f4321.getCameraDevice(), TransmitSettingView.this.f4321.m4281());
                    return;
                } else {
                    TransmitSettingView.this.f4331.mo4387();
                    return;
                }
            }
            if (TransmitSettingView.this.f4331.mo4381()) {
                if (o3.m7669().m7672()) {
                    o3.m7669().m7675(false);
                } else {
                    o3.m7669().m7675(true);
                }
                if (!o3.m7669().m7672()) {
                    TransmitSettingView.this.f4331.mo4385();
                    TransmitSettingView.this.m4357();
                    return;
                }
                TransmitSettingView.this.f4323 = 0;
                o3.m7669().m7674(TransmitSettingView.this.f4323);
                TransmitSettingView.this.f4319.f12295.setCurrentItem(TransmitSettingView.this.f4323);
                TransmitSettingView transmitSettingView = TransmitSettingView.this;
                transmitSettingView.m4376(transmitSettingView.f4321.getCameraUnitType());
                TransmitSettingView.this.f4331.mo4384(TransmitSettingView.this.f4321.getQualityType(), TransmitSettingView.this.f4321.getCameraUnitType(), TransmitSettingView.this.f4321.m4280());
                TransmitSettingView.this.m4342();
                TransmitSettingView.this.m4338();
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$֏, reason: contains not printable characters */
    public class C1631 implements TransmitSettingPag1.InterfaceC1616 {
        public C1631() {
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingPag1.InterfaceC1616
        /* renamed from: Ϳ */
        public void mo4306() {
            if (TransmitSettingView.this.f4331 != null) {
                TransmitSettingView.this.f4331.mo4378();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingPag1.InterfaceC1616
        /* renamed from: Ԩ */
        public void mo4307(int i) {
            if (TransmitSettingView.this.f4331 != null) {
                TransmitSettingView.this.f4331.mo4379(i);
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingPag1.InterfaceC1616
        /* renamed from: ԩ */
        public void mo4308() {
            if (TransmitSettingView.this.f4331 != null) {
                TransmitSettingView.this.f4331.mo4380();
            }
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingPag1.InterfaceC1616
        /* renamed from: Ԫ */
        public void mo4309() {
            TransmitSettingView.this.m4372(1, null);
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingPag1.InterfaceC1616
        /* renamed from: ԫ */
        public void mo4310() {
            TransmitSettingView.this.m4369();
            TransmitSettingView.this.m4368();
        }

        @Override // com.blink.academy.film.widgets.transmit.TransmitSettingPag1.InterfaceC1616
        /* renamed from: Ԯ */
        public void mo4311(boolean z) {
            if (TransmitSettingView.this.f4331 != null) {
                TransmitSettingView.this.f4331.mo4383(z);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ׯ, reason: contains not printable characters */
    public class C1632 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ׯ$Ϳ, reason: contains not printable characters */
        public class C1633 extends AbstractC4012 {
            public C1633() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                TransmitSettingView.this.f4319.f12292.setVisibility(8);
            }
        }

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ׯ$Ԩ, reason: contains not printable characters */
        public class C1634 extends AbstractC4012 {
            public C1634() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                TransmitSettingView.this.f4319.f12292.setVisibility(8);
            }
        }

        public C1632() {
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            C4008.m12876(TransmitSettingView.this.f4319.f12292, 0.0f, 100, new C1634());
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            TransmitSettingView.this.m4371();
            C4008.m12876(TransmitSettingView.this.f4319.f12292, 0.0f, 100, new C1633());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ؠ, reason: contains not printable characters */
    public class C1635 implements SettingHintDialog.InterfaceC1048 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ SettingHintDialog f4345;

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ؠ$Ϳ, reason: contains not printable characters */
        public class C1636 extends AbstractC4012 {
            public C1636() {
            }

            @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                super.onAnimationEnd(view);
                TransmitSettingView.this.f4319.f12292.setVisibility(8);
            }
        }

        public C1635(SettingHintDialog settingHintDialog) {
            this.f4345 = settingHintDialog;
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ϳ */
        public void mo1311(int i) {
            if (FilmApp.m405().m426()) {
                C4008.m12876(this.f4345, 0.0f, 100, new C1636());
            }
        }

        @Override // com.blink.academy.film.widgets.dialog.SettingHintDialog.InterfaceC1048
        /* renamed from: Ԩ */
        public void mo1312(int i, C3891 c3891) {
            ActivityCompat.requestPermissions((Activity) TransmitSettingView.this.getContext(), new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"}, 10001);
            TransmitSettingView.this.f4319.f12292.setVisibility(8);
            C2618.m9570("permission_has_check_bluetooth", true);
            TransmitHelper.setHasCheckBluetoothPermission(true);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ހ, reason: contains not printable characters */
    public class C1637 extends AbstractC4012 {
        public C1637() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            TransmitSettingView.this.f4319.f12292.setVisibility(0);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ށ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1638 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public View f4349;

        /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ށ$Ϳ, reason: contains not printable characters */
        public class RunnableC1639 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f4350;

            public RunnableC1639(View view) {
                this.f4350 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f4350.isEnabled()) {
                    ViewOnTouchListenerC1638.this.f4349.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1638(View view) {
            this.f4349 = view;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4349.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler(Looper.myLooper()).postDelayed(new RunnableC1639(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.TransmitSettingView$ނ, reason: contains not printable characters */
    public interface InterfaceC1640 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo4378();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo4379(int i);

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo4380();

        /* renamed from: Ԫ, reason: contains not printable characters */
        boolean mo4381();

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo4382(boolean z);

        /* renamed from: Ԯ, reason: contains not printable characters */
        void mo4383(boolean z);

        /* renamed from: ֏, reason: contains not printable characters */
        void mo4384(int i, int i2, boolean z);

        /* renamed from: ފ, reason: contains not printable characters */
        void mo4385();

        /* renamed from: ދ, reason: contains not printable characters */
        void mo4386(int i, String str, boolean z);

        /* renamed from: ތ, reason: contains not printable characters */
        void mo4387();
    }

    public TransmitSettingView(@NonNull Context context) {
        super(context);
        this.f4325 = new NetInfoBean();
        this.f4330 = new ArrayList();
        m4345();
    }

    private String getWifiInfoOffline() {
        return this.f4321.getEquipmentType() == 1 ? getResources().getString(R.string.MONITOR_LABEL_JOIN_WIFI_CAMERA) : getResources().getString(R.string.MONITOR_LABEL_JOIN_WIFI_MONITOR);
    }

    public int getQualityType() {
        return this.f4321.getQualityType();
    }

    public void setOnTransmitStateChangeListener(InterfaceC1640 interfaceC1640) {
        this.f4331 = interfaceC1640;
    }

    public void setWifiInfo(NetInfoBean netInfoBean) {
        this.f4326 = r1.m8143(netInfoBean.getLocalIP());
        if (m4351(netInfoBean, this.f4325)) {
            return;
        }
        m4341(netInfoBean, this.f4325);
        String strM4343 = m4343(netInfoBean);
        if (!r1.m8143(strM4343) || strM4343.equals(this.f4319.f12305.getText().toString())) {
            return;
        }
        this.f4319.f12305.setText(strM4343);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4338() {
        this.f4329.add(this.f4322);
        this.f4319.f12293.setVisibility(0);
        this.f4328.notifyDataSetChanged();
        m4339();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m4339() {
        int childCount = this.f4319.f12293.getChildCount();
        if (TransmitHelper.getInstance().isStartCameraTransmit() && childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                FilmPointView filmPointView = (FilmPointView) this.f4319.f12293.getChildAt(i);
                filmPointView.m2292(false);
                if (i == this.f4323) {
                    filmPointView.m2292(true);
                }
            }
            this.f4319.f12293.setVisibility(0);
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final boolean m4340(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m4341(NetInfoBean netInfoBean, NetInfoBean netInfoBean2) {
        netInfoBean2.setBssid(netInfoBean.getBssid());
        netInfoBean2.setGatewayIP(netInfoBean.getGatewayIP());
        netInfoBean2.setLocalIP(netInfoBean.getLocalIP());
        netInfoBean2.setLocalName(netInfoBean.getLocalName());
        netInfoBean2.setSsid(netInfoBean.getSsid());
        netInfoBean2.setWifiLevel(netInfoBean.getWifiLevel());
        netInfoBean2.setWifiStatus(netInfoBean.getWifiStatus());
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m4342() {
        if (this.f4320) {
            return;
        }
        this.f4320 = true;
        C4008.m12876(this.f4319.f12299, 1.0f, 200, new C1626());
        this.f4319.f12299.postDelayed(new RunnableC1627(), 300L);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public final String m4343(NetInfoBean netInfoBean) {
        String ssid = netInfoBean.getSsid();
        if (ssid.startsWith("\"")) {
            ssid = ssid.substring(1, ssid.length() - 1);
        }
        String bssid = netInfoBean.getBssid();
        String localIP = netInfoBean.getLocalIP();
        int wifiStatus = netInfoBean.getWifiStatus();
        StringBuilder sb = new StringBuilder();
        if (r1.m8143(ssid) && !ssid.equals(NetInfoBean.UNKNOWN_SSID)) {
            sb.append(getResources().getString(R.string.MONITOR_LABEL_WIFI_SSID));
            sb.append("：");
            sb.append(ssid);
            sb.append("  /  ");
        }
        if (r1.m8143(bssid) && !bssid.equals(NetInfoBean.DEFAULT_MAC_ADDRESS)) {
            sb.append(getResources().getString(R.string.MONITOR_LABEL_ROUTER_MAC));
            sb.append("：");
            sb.append(bssid);
            sb.append("  /  ");
        }
        if (r1.m8143(localIP)) {
            sb.append(getResources().getString(R.string.MONITOR_LABEL_DEVICE_IP));
            sb.append("：");
            sb.append(localIP);
            sb.append("  /  ");
            sb.append(getResources().getString(R.string.MONITOR_LABEL_SIGNAL_STRENGTH));
            sb.append("：");
            sb.append(wifiStatus);
            sb.append("%");
        } else {
            sb.append(getWifiInfoOffline());
        }
        return sb.toString();
    }

    /* renamed from: މ, reason: contains not printable characters */
    public final List<LinkEntity> m4344(List<LinkEntity> list, int i) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        List<ACBanBean> list2 = ACBanManager.getInstance().getList();
        if (list != null) {
            for (int i2 = i * 4; i2 < Math.min(list.size(), (i + 1) * 4); i2++) {
                LinkEntity linkEntity = list.get(i2);
                if (linkEntity != null) {
                    String[] controllableList = ACHelper.getInstance().getControllableList();
                    if ((controllableList == null || controllableList.length <= 0) ? false : Arrays.asList(controllableList).contains(linkEntity.getAcMonitorInfoBean().getUuid())) {
                        linkEntity.setControlState(5);
                    } else {
                        linkEntity.setControlState(4);
                    }
                    if (r1.m8144(list2)) {
                        Iterator<ACBanBean> it = list2.iterator();
                        while (it.hasNext()) {
                            if (it.next().getUuid().equals(linkEntity.getUuid())) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        linkEntity.changeBanState(z);
                        arrayList.add(linkEntity);
                    } else {
                        z = false;
                        linkEntity.changeBanState(z);
                        arrayList.add(linkEntity);
                    }
                }
            }
        }
        if (arrayList.size() < 4 && r1.m8144(list2)) {
            int size = 4 - arrayList.size();
            for (ACBanBean aCBanBean : list2) {
                String uuid = aCBanBean.getUuid();
                Iterator<LinkEntity> it2 = list.iterator();
                boolean z2 = false;
                while (it2.hasNext()) {
                    String uuid2 = it2.next().getUuid();
                    if (r1.m8143(uuid2) && uuid2.equals(uuid)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    LinkEntity linkEntity2 = new LinkEntity(0, -1, "", 0, null, "", "1");
                    linkEntity2.setUuid(aCBanBean.getUuid());
                    linkEntity2.getAcMonitorInfoBean().setJob(aCBanBean.getName());
                    linkEntity2.getAcMonitorInfoBean().setSuffix(aCBanBean.getSuffix());
                    linkEntity2.changeBanState(true);
                    arrayList.add(linkEntity2);
                    size--;
                }
                if (size <= 0) {
                    break;
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public final void m4345() {
        this.f4319 = (AbstractC3516) DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.layout_transmit_view, this, true);
        m4346();
        m4348();
        m4347();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public final void m4346() {
        int iM9440 = C2579.m9440(getContext());
        int i = C2579.f9594;
        int iM14468 = C4792.m14375().m14468();
        C4792.m14375().m14471();
        C4792.m14375().m14397();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f4319.f12306.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).height = (int) ((C2579.f9594 - C2579.m9440(getContext())) / 2.0f);
        this.f4319.f12306.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f4319.f12298.getLayoutParams();
        layoutParams2.width = i;
        layoutParams2.height = C2579.m9440(getContext());
        this.f4319.f12298.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f4319.f12294.getLayoutParams();
        float fM14471 = C4792.m14375().m14471();
        float f = iM9440;
        layoutParams3.height = (int) (0.14477211f * f * fM14471);
        this.f4319.f12294.setLayoutParams(layoutParams3);
        this.f4319.f12301.setTypeface(FilmApp.m404());
        this.f4319.f12301.setTextSize(0, C4792.m14375().m14381());
        ((LinearLayout.LayoutParams) this.f4319.f12301.getLayoutParams()).leftMargin = C4792.m14375().m14468();
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f4319.f12291.getLayoutParams();
        int i2 = (int) (0.044235926f * f);
        layoutParams4.width = i2;
        layoutParams4.height = i2;
        layoutParams4.rightMargin = C4792.m14375().m14468();
        this.f4319.f12291.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f4319.f12290.getLayoutParams();
        int i3 = layoutParams3.height;
        layoutParams5.width = i3;
        layoutParams5.height = i3;
        layoutParams5.rightMargin = layoutParams4.rightMargin - ((i3 - layoutParams4.width) / 2);
        this.f4319.f12290.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f4319.f12296.getLayoutParams();
        layoutParams6.height = C4792.m14375().m14478(544.0f, fM14471);
        this.f4319.f12296.setLayoutParams(layoutParams6);
        this.f4321 = new TransmitSettingPag1(getContext());
        this.f4321.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f4322 = new TransmitSettingPage2(getContext());
        this.f4322.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) this.f4319.f12297.getLayoutParams();
        layoutParams7.height = (int) (0.09919571f * f);
        layoutParams7.topMargin = (int) (f * 0.04021448f);
        this.f4319.f12297.setLayoutParams(layoutParams7);
        this.f4319.f12302.setState(false);
        this.f4319.f12304.setState(true);
        this.f4319.f12304.setAlpha(0.0f);
        ConstraintLayout.LayoutParams layoutParams8 = (ConstraintLayout.LayoutParams) this.f4319.f12305.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams8).leftMargin = iM14468;
        ((ViewGroup.MarginLayoutParams) layoutParams8).topMargin = layoutParams6.height + layoutParams7.height + layoutParams7.topMargin + C4792.m14375().m14478(28.0f, fM14471) + layoutParams3.height;
        this.f4319.f12305.setLayoutParams(layoutParams8);
        this.f4319.f12305.setContentTextColor(getResources().getColor(R.color.colorWhite, null));
        this.f4319.f12305.setAlpha(0.5f);
        this.f4319.f12305.m2562(0, C4792.m14375().m14482() * fM14471);
        this.f4319.f12305.setDrawBorder(false);
        ConstraintLayout.LayoutParams layoutParams9 = (ConstraintLayout.LayoutParams) this.f4319.f12303.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams9).height = C4792.m14375().m14476(125);
        ((ViewGroup.MarginLayoutParams) layoutParams9).leftMargin = iM14468;
        ((ViewGroup.MarginLayoutParams) layoutParams9).rightMargin = iM14468;
        ((ViewGroup.MarginLayoutParams) layoutParams9).topMargin = C4792.m14375().m14478(25.0f, fM14471);
        this.f4319.f12303.setLayoutParams(layoutParams9);
        View filmPointView = new FilmPointView(getContext());
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(C2579.m9438(9.0f), C2579.m9438(9.0f));
        layoutParams10.leftMargin = C2579.m9438(2.0f);
        layoutParams10.rightMargin = C2579.m9438(2.0f);
        filmPointView.setLayoutParams(layoutParams10);
        this.f4319.f12293.addView(filmPointView);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m4347() {
        AbstractC3516 abstractC3516 = this.f4319;
        abstractC3516.f12290.setOnTouchListener(new ViewOnTouchListenerC1638(abstractC3516.f12291));
        this.f4319.f12290.setOnClickListener(new ViewOnClickListenerC1629());
        ConstraintLayout constraintLayout = this.f4319.f12303;
        constraintLayout.setOnTouchListener(new ViewOnTouchListenerC1638(constraintLayout));
        this.f4319.f12303.setOnClickListener(new ViewOnClickListenerC1630());
        this.f4321.setOnChangeListener(new C1631());
        this.f4319.f12292.setOnButtonClick(new C1632());
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public final void m4348() {
        m4349();
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public final void m4349() {
        this.f4329 = new ArrayList();
        C5092 c5092 = new C5092();
        this.f4328 = c5092;
        c5092.m14921(this.f4329);
        this.f4329.add(this.f4321);
        this.f4319.f12293.setVisibility(8);
        this.f4319.f12295.setAdapter(this.f4328);
        this.f4319.f12295.setOverScrollMode(2);
        this.f4319.f12295.addOnPageChangeListener(new C1628());
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean m4350() {
        return this.f4327;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final boolean m4351(NetInfoBean netInfoBean, NetInfoBean netInfoBean2) {
        return m4340(netInfoBean.getBssid(), netInfoBean2.getBssid()) && m4340(netInfoBean.getGatewayIP(), netInfoBean2.getGatewayIP()) && m4340(netInfoBean.getLocalIP(), netInfoBean2.getLocalIP()) && m4340(netInfoBean.getSsid(), netInfoBean2.getSsid()) && m4340(netInfoBean.getLocalName(), netInfoBean2.getLocalName()) && netInfoBean.getWifiLevel() == netInfoBean2.getWifiLevel() && netInfoBean.getWifiStatus() == netInfoBean2.getWifiStatus();
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m4352() {
        if (!o3.m7669().m7673()) {
            m4342();
            return;
        }
        InterfaceC1640 interfaceC1640 = this.f4331;
        if (interfaceC1640 != null) {
            interfaceC1640.mo4386(this.f4321.getJobType(), this.f4321.getCameraDevice(), this.f4321.m4281());
        }
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m4353(int i) {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4283(i);
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m4354(boolean z) {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4285(z);
        }
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m4355() {
        if (this.f4321.getEquipmentType() == 1) {
            m4367();
            m4338();
            this.f4321.m4298(o3.m7669().m7672());
        }
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m4356(boolean z) {
        o3.m7669().m7675(z);
        if (z) {
            m4355();
        } else {
            m4357();
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m4357() {
        if (this.f4321.getEquipmentType() == 1) {
            m4367();
            m4370();
            this.f4321.m4298(o3.m7669().m7672());
        }
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public void m4358(int i) {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4293(i);
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public void m4359() {
        this.f4319.f12293.removeAllViews();
        for (int i = 0; i < this.f4329.size(); i++) {
            View filmPointView = new FilmPointView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(C2579.m9438(9.0f), C2579.m9438(9.0f));
            layoutParams.leftMargin = C2579.m9438(2.0f);
            layoutParams.rightMargin = C2579.m9438(2.0f);
            filmPointView.setLayoutParams(layoutParams);
            this.f4319.f12293.addView(filmPointView);
        }
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public final void m4360() {
        if (this.f4321.getEquipmentType() == 2) {
            m4367();
            boolean zM7673 = o3.m7669().m7673();
            this.f4321.m4298(zM7673);
            InterfaceC1640 interfaceC1640 = this.f4331;
            if (interfaceC1640 == null || !zM7673) {
                return;
            }
            interfaceC1640.mo4386(this.f4321.getJobType(), this.f4321.getCameraDevice(), this.f4321.m4281());
        }
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public void m4361(boolean z) {
        o3.m7669().m7676(z);
        m4360();
    }

    /* renamed from: ޛ, reason: contains not printable characters */
    public void m4362() {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4288();
            this.f4321.m4298(o3.m7669().m7673());
        }
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public void m4363() {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4300(o3.m7669().m7672());
            this.f4321.m4286();
            m4368();
        }
    }

    /* renamed from: ޝ, reason: contains not printable characters */
    public void m4364() {
        if (o3.m7669().m7672()) {
            this.f4329.clear();
            this.f4329.add(this.f4321);
            this.f4329.add(this.f4322);
            this.f4330.clear();
            List<LinkEntity> clientList = LinkManager.getInstance().getClientList();
            List<LinkEntity> remoteLinks = LinkManager.getInstance().getRemoteLinks();
            List<LinkEntity> cacheBannedList = LinkManager.getInstance().getCacheBannedList();
            if (r1.m8144(clientList) || r1.m8144(remoteLinks)) {
                this.f4330.addAll(clientList);
                this.f4330.addAll(remoteLinks);
                this.f4330.addAll(cacheBannedList);
            } else if (r1.m8144(cacheBannedList)) {
                this.f4330.addAll(cacheBannedList);
            }
            List<LinkEntity> list = this.f4330;
            if (list == null || list.size() <= 0) {
                this.f4322.setData(m4344(this.f4330, 0));
            } else {
                int size = this.f4330.size() / 4;
                if (this.f4330.size() % 4 > 0) {
                    size++;
                }
                for (int i = 0; i < size; i++) {
                    if (i == 0) {
                        this.f4322.setData(m4344(this.f4330, i));
                    } else {
                        TransmitSettingPage2 transmitSettingPage2 = new TransmitSettingPage2(getContext());
                        transmitSettingPage2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        this.f4329.add(transmitSettingPage2);
                        transmitSettingPage2.setData(m4344(this.f4330, i));
                    }
                }
            }
            this.f4328.notifyDataSetChanged();
            m4359();
            m4339();
        }
    }

    /* renamed from: ޞ, reason: contains not printable characters */
    public void m4365(String str) {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4290(str);
        }
    }

    /* renamed from: ޟ, reason: contains not printable characters */
    public void m4366() {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4299();
        }
    }

    /* renamed from: ޠ, reason: contains not printable characters */
    public final void m4367() {
        if (o3.m7669().m7672() || o3.m7669().m7673()) {
            C4008.m12876(this.f4319.f12304, 1.0f, 100, null);
        } else {
            C4008.m12876(this.f4319.f12304, 0.0f, 100, null);
        }
    }

    /* renamed from: ޡ, reason: contains not printable characters */
    public final void m4368() {
        if (this.f4321.getEquipmentType() != 1) {
            if (this.f4319.f12303.getAlpha() != 1.0f) {
                C4008.m12876(this.f4319.f12303, 1.0f, 100, null);
                this.f4319.f12303.setEnabled(true);
                return;
            }
            return;
        }
        boolean zMachineCanUse = FinderManager.getInstance().machineCanUse("1");
        boolean zMachineCanUse2 = FinderManager.getInstance().machineCanUse("2");
        boolean zMachineCanUse3 = FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_C);
        boolean zMachineCanUse4 = FinderManager.getInstance().machineCanUse(FinderManager.MACHINE_D);
        float alpha = this.f4319.f12303.getAlpha();
        if (zMachineCanUse || zMachineCanUse2 || zMachineCanUse3 || zMachineCanUse4) {
            if (alpha != 1.0f) {
                C4008.m12876(this.f4319.f12303, 1.0f, 100, null);
                this.f4319.f12303.setEnabled(true);
                return;
            }
            return;
        }
        if (o3.m7669().m7672() || o3.m7669().m7673() || alpha == 0.2f) {
            return;
        }
        C4008.m12876(this.f4319.f12303, 0.2f, 100, null);
        this.f4319.f12303.setEnabled(false);
    }

    /* renamed from: ޢ, reason: contains not printable characters */
    public final void m4369() {
        if (this.f4326) {
            return;
        }
        this.f4319.f12305.setText(getWifiInfoOffline());
    }

    /* renamed from: ޣ, reason: contains not printable characters */
    public final void m4370() {
        if (this.f4329.size() > 1) {
            for (int i = 0; i < this.f4329.size(); i++) {
                if (i > 0) {
                    this.f4329.remove(i);
                }
            }
            this.f4319.f12293.setVisibility(8);
            this.f4328.notifyDataSetChanged();
        }
    }

    /* renamed from: ޤ, reason: contains not printable characters */
    public void m4371() {
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4275();
        }
    }

    /* renamed from: ޥ, reason: contains not printable characters */
    public final void m4372(int i, C3891 c3891) {
        this.f4319.f12292.setVisibility(0);
        this.f4319.f12292.setAlpha(0.0f);
        this.f4319.f12292.m2908(i, c3891);
        C4008.m12876(this.f4319.f12292, 1.0f, 100, null);
    }

    /* renamed from: ޱ, reason: contains not printable characters */
    public final void m4373() {
        if (TransmitHelper.hasCheckBluetoothPermission()) {
            m4374();
            return;
        }
        SettingHintDialog settingHintDialog = this.f4319.f12292;
        settingHintDialog.m2906(38);
        settingHintDialog.setOnButtonClick(new C1635(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(38, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, new C1637());
    }

    /* renamed from: ߾, reason: contains not printable characters */
    public final void m4374() {
        SettingHintDialog settingHintDialog = this.f4319.f12292;
        settingHintDialog.m2906(39);
        settingHintDialog.setOnButtonClick(new C1623(settingHintDialog));
        settingHintDialog.setAlpha(0.0f);
        settingHintDialog.m2908(39, null);
        C4008.m12876(settingHintDialog, 1.0f, 100, new C1625());
    }

    /* renamed from: ߿, reason: contains not printable characters */
    public void m4375() {
        setVisibility(0);
        C4008.m12876(this.f4319.f12299, 0.0f, 200, null);
        TransmitSettingPag1 transmitSettingPag1 = this.f4321;
        if (transmitSettingPag1 != null) {
            transmitSettingPag1.m4301();
        }
        if (o3.m7669().m7672()) {
            m4367();
            int iM7670 = o3.m7669().m7670();
            this.f4323 = iM7670;
            this.f4319.f12295.setCurrentItem(iM7670, false);
            m4339();
            this.f4321.m4298(o3.m7669().m7672());
        }
        this.f4327 = true;
        this.f4320 = false;
    }

    /* renamed from: ࡠ, reason: contains not printable characters */
    public final void m4376(int i) {
    }

    public TransmitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4325 = new NetInfoBean();
        this.f4330 = new ArrayList();
        m4345();
    }

    public TransmitSettingView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4325 = new NetInfoBean();
        this.f4330 = new ArrayList();
        m4345();
    }
}
