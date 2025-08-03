package defpackage;

import android.app.Activity;
import com.blink.academy.film.FilmApp;
import com.umeng.analytics.pro.am;
import com.zhiyun.sdk.DeviceManager;
import com.zhiyun.sdk.ZYDeviceSDK;
import com.zhiyun.sdk.device.Device;
import com.zhiyun.sdk.util.BTUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: ZhiyunManager.java */
/* loaded from: classes.dex */
public class c9 {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final String f186 = "c9";

    /* renamed from: ֏, reason: contains not printable characters */
    public static c9 f187;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f190;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public InterfaceC0056 f193;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InterfaceC0057 f194;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public InterfaceC0058 f195;

    /* renamed from: ԯ, reason: contains not printable characters */
    public InterfaceC0055 f196;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Device f197;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public List<Device> f188 = new ArrayList();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public List<C3760> f189 = new ArrayList();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Map<Integer, Integer> f191 = new HashMap();

    /* renamed from: ԫ, reason: contains not printable characters */
    public Device.KeyListener f192 = new C0052();

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$Ϳ, reason: contains not printable characters */
    public class C0052 implements Device.KeyListener {
        public C0052() {
        }

        @Override // com.zhiyun.sdk.device.Device.KeyListener
        public void onKeyEvent(int i, int i2, int i3) {
            String str = c9.this.m240(i) + "  " + c9.this.m239(i2);
            C4638.m14099(c9.f186, "onKeyEvent:" + str);
            if (c9.this.f195 != null) {
                c9.this.f195.mo273();
            }
            if (c9.this.f194 != null) {
                c9.this.f194.mo264();
            }
            if (c9.this.f197 != null && !c9.this.f197.getModelName().contains("Smooth4")) {
                if (i == 2566 || i == 2576) {
                    i = 2576;
                } else if (i == 2569 || i == 2577) {
                    i = 2577;
                } else if (i != 2570 && i != 2578) {
                    return;
                } else {
                    i = 2578;
                }
            }
            if (!(i == 2569 || i == 2570 || i == 2578 || i == 2577)) {
                if (i2 == 2819) {
                    if (c9.this.f197 == null) {
                        return;
                    }
                    if (!"SMOOTH-X_448D-2".equalsIgnoreCase(c9.this.f197.getModelName())) {
                        c9.this.f191.put(Integer.valueOf(i), Integer.valueOf(i2));
                        return;
                    }
                } else if (i2 == 2820) {
                    c9.this.f191.remove(Integer.valueOf(i));
                } else if (i2 == 2818) {
                    if (!c9.this.f191.containsKey(Integer.valueOf(i))) {
                        return;
                    } else {
                        c9.this.f191.remove(Integer.valueOf(i));
                    }
                }
            }
            if (c9.this.f194 != null) {
                c9.this.m221(i, i2);
            } else if (c9.this.f195 != null) {
                c9.this.m223(i, i2);
            } else if (c9.this.f196 != null) {
                c9.this.m222(i, i2);
            }
        }
    }

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$Ԩ, reason: contains not printable characters */
    public class C0053 implements DeviceManager.ScanCallback {
        public C0053() {
        }

        @Override // com.zhiyun.sdk.DeviceManager.ScanCallback
        public void onCallback(Device device) {
            if (!c9.this.f188.contains(device)) {
                C4638.m14099(c9.f186, "find new device......");
                c9.this.f188.add(device);
                C3760 c3760 = new C3760();
                c3760.m12045(device);
                c9.this.m236(c3760);
                device.setKeyListener(c9.this.f192);
                c9.this.f189.add(c3760);
            }
            if (c9.this.f193 != null) {
                c9.this.f193.mo260();
            }
            String strM9569 = C2618.m9569("gimbal_his_sp", "");
            if (!c9.this.m229() && r1.m8143(strM9569) && strM9569.equals(device.getModelName())) {
                if (c9.this.f190 == 0) {
                    c9.this.f190 = 1;
                }
                device.connect();
            }
        }
    }

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$Ԫ, reason: contains not printable characters */
    public class C0054 implements Device.StatusListener {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ C3760 f200;

        public C0054(C3760 c3760) {
            this.f200 = c3760;
        }

        @Override // com.zhiyun.sdk.device.Device.StatusListener
        public void onStateChanged(int i) {
            if (i == 0) {
                C4638.m14099(c9.f186, "device disconnect ......");
                this.f200.m12044(false);
                if (c9.this.f193 != null) {
                    c9.this.f193.mo260();
                    c9.this.f193.mo259();
                }
                c9.this.f197 = null;
                if (c9.this.f196 != null) {
                    if (c9.this.f195 != null) {
                        if (c9.this.f193 == null) {
                            c9.this.f195.mo271();
                            return;
                        }
                        return;
                    } else {
                        if (c9.this.f194 == null && c9.this.f190 == 0) {
                            c9.this.f196.mo256();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (i == 1) {
                if (c9.this.f193 != null) {
                    c9.this.f193.mo260();
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                C4638.m14099(c9.f186, "TO_BE_MISSED......");
                return;
            }
            C4638.m14099(c9.f186, "device connected......");
            if (c9.this.f190 == 1) {
                c9.this.f190 = 2;
                C4638.m14099(c9.f186, "device auto first disconnected");
                this.f200.m12042().disconnect();
                c9.this.m237();
                return;
            }
            c9.this.f190 = 0;
            this.f200.m12044(false);
            c9.this.f197 = this.f200.m12042();
            if (c9.this.f193 != null) {
                C2618.m9573("gimbal_his_sp", this.f200.m12042().getModelName());
                c9.this.f193.mo260();
                c9.this.f193.mo261();
            }
            if (c9.this.f196 != null) {
                if (c9.this.f195 != null) {
                    if (c9.this.f193 == null) {
                        c9.this.f195.mo272();
                    }
                } else {
                    if (c9.this.f194 != null) {
                        return;
                    }
                    c9.this.f196.mo257();
                }
            }
        }
    }

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$Ԭ, reason: contains not printable characters */
    public interface InterfaceC0055 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo241();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo242();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo243(int i);

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo244();

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo245(boolean z);

        /* renamed from: Ԭ, reason: contains not printable characters */
        int mo246();

        /* renamed from: ԭ, reason: contains not printable characters */
        void mo247();

        /* renamed from: Ԯ, reason: contains not printable characters */
        void mo248();

        /* renamed from: ԯ, reason: contains not printable characters */
        void mo249(boolean z);

        /* renamed from: ՠ, reason: contains not printable characters */
        void mo250();

        /* renamed from: ֈ, reason: contains not printable characters */
        void mo251();

        /* renamed from: ֏, reason: contains not printable characters */
        void mo252();

        /* renamed from: ׯ, reason: contains not printable characters */
        void mo253();

        /* renamed from: ؠ, reason: contains not printable characters */
        void mo254();

        /* renamed from: ހ, reason: contains not printable characters */
        void mo255();

        /* renamed from: ށ, reason: contains not printable characters */
        void mo256();

        /* renamed from: ނ, reason: contains not printable characters */
        void mo257();

        /* renamed from: ރ, reason: contains not printable characters */
        void mo258();
    }

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$Ԯ, reason: contains not printable characters */
    public interface InterfaceC0056 {
        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo259();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo260();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo261();
    }

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$ՠ, reason: contains not printable characters */
    public interface InterfaceC0057 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo262();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo263();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo264();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo265();

        /* renamed from: ԫ, reason: contains not printable characters */
        void mo266(boolean z);

        /* renamed from: ԭ, reason: contains not printable characters */
        void mo267();

        /* renamed from: Ԯ, reason: contains not printable characters */
        void mo268();

        /* renamed from: ԯ, reason: contains not printable characters */
        void mo269(boolean z);
    }

    /* compiled from: ZhiyunManager.java */
    /* renamed from: c9$ֈ, reason: contains not printable characters */
    public interface InterfaceC0058 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo270();

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo271();

        /* renamed from: ԩ, reason: contains not printable characters */
        void mo272();

        /* renamed from: Ԫ, reason: contains not printable characters */
        void mo273();
    }

    public c9() throws Throwable {
        m228();
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static c9 m219() {
        if (f187 == null) {
            synchronized (c9.class) {
                if (f187 == null) {
                    f187 = new c9();
                }
            }
        }
        return f187;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m220() {
        this.f189.clear();
        this.f188.clear();
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m221(int i, int i2) {
        InterfaceC0057 interfaceC0057 = this.f194;
        if (interfaceC0057 != null) {
            if (2818 != i2) {
                if (2819 == i2) {
                    if (i == 2569) {
                        interfaceC0057.mo266(true);
                        return;
                    }
                    if (i == 2570) {
                        interfaceC0057.mo266(false);
                        return;
                    } else if (i == 2577) {
                        interfaceC0057.mo269(true);
                        return;
                    } else {
                        if (i != 2578) {
                            return;
                        }
                        interfaceC0057.mo269(false);
                        return;
                    }
                }
                return;
            }
            if (i == 2562) {
                interfaceC0057.mo268();
                return;
            }
            if (i == 2572) {
                interfaceC0057.mo262();
                return;
            }
            if (i == 2574) {
                interfaceC0057.mo265();
            } else if (i == 2564) {
                interfaceC0057.mo267();
            } else {
                if (i != 2565) {
                    return;
                }
                interfaceC0057.mo263();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0025  */
    /* renamed from: ޅ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m222(int r9, int r10) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c9.m222(int, int):void");
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m223(int i, int i2) {
        InterfaceC0058 interfaceC0058 = this.f195;
        if (interfaceC0058 != null && 2818 == i2 && i == 2572) {
            interfaceC0058.mo270();
        }
    }

    /* renamed from: އ, reason: contains not printable characters */
    public void m224() {
        f187 = null;
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public void m225() {
        if (r1.m8144(this.f189)) {
            for (C3760 c3760 : this.f189) {
                c3760.m12044(false);
                Device deviceM12042 = c3760.m12042();
                if (deviceM12042 != null) {
                    deviceM12042.disconnect();
                }
            }
        }
        this.f197 = null;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public Device m226() {
        return this.f197;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public List<C3760> m227() {
        return this.f189;
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public final void m228() throws Throwable {
        ZYDeviceSDK.init(FilmApp.m402(), "cert.json");
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean m229() {
        if (r1.m8144(this.f189)) {
            Iterator<C3760> it = this.f189.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (it.next().m12042().isConnected()) {
                    z = true;
                }
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m230(C3760 c3760, Activity activity) {
        String str = f186;
        C4638.m14099(str, "device click......");
        if (!this.f188.contains(c3760.m12042())) {
            this.f188.add(c3760.m12042());
            this.f189.add(c3760);
        }
        if (c3760.m12042().isConnected()) {
            C4638.m14099(str, "device disconnect......");
            c3760.m12042().disconnect();
            this.f197 = null;
        } else {
            m236(c3760);
            c3760.m12042().setKeyListener(this.f192);
            c3760.m12042().connect();
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m231() {
        this.f197 = null;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public c9 m232(InterfaceC0055 interfaceC0055) {
        this.f196 = interfaceC0055;
        return this;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public void m233(InterfaceC0056 interfaceC0056) {
        this.f193 = interfaceC0056;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public c9 m234(InterfaceC0057 interfaceC0057) {
        this.f194 = interfaceC0057;
        return this;
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public c9 m235(InterfaceC0058 interfaceC0058) {
        this.f195 = interfaceC0058;
        return this;
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public final void m236(C3760 c3760) {
        c3760.m12042().setStateListener(new C0054(c3760));
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m237() {
        if (!BTUtil.isSupportBle()) {
            C4638.m14099(f186, "Not support ble ");
            return;
        }
        if (!BTUtil.isOpened()) {
            C4638.m14099(f186, "Please turn on Bluetooth ");
            return;
        }
        if (!BTUtil.isLocationProviderOk(FilmApp.m402())) {
            C4638.m14099(f186, "Please open the location service ");
        } else if (!C2749.m10008(FilmApp.m402())) {
            C4638.m14099(f186, "Please grant location permissions ");
        } else {
            DeviceManager.getInstance().setScanCallback(new C0053());
            DeviceManager.getInstance().scan(DeviceManager.DeviceType.BLE);
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public void m238() {
        DeviceManager.getInstance().cancelScan();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public String m239(int i) {
        switch (i) {
            case Device.KEY_EVENT_PRESSED /* 2817 */:
                return "Pressed";
            case Device.KEY_EVENT_RELEASED /* 2818 */:
                return "Released";
            case Device.KEY_EVENT_CLICKED /* 2819 */:
                return "Clicked";
            case Device.KEY_EVENT_PRESS_1S /* 2820 */:
                return "press1s";
            case Device.KEY_EVENT_PRESS_3S /* 2821 */:
                return "press2s";
            default:
                return "Failed";
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public String m240(int i) {
        switch (i) {
            case Device.KEY_TYPE_UP /* 2561 */:
                return "up";
            case Device.KEY_TYPE_DOWN /* 2562 */:
                return "down";
            case Device.KEY_TYPE_MODE /* 2563 */:
                return "mode";
            case Device.KEY_TYPE_LEFT /* 2564 */:
                return "left";
            case Device.KEY_TYPE_RIGHT /* 2565 */:
                return "right";
            case Device.KEY_TYPE_PHOTOS /* 2566 */:
                return "photos";
            case Device.KEY_TYPE_T /* 2567 */:
                return am.aI;
            case Device.KEY_TYPE_W /* 2568 */:
                return "w";
            case Device.KEY_TYPE_CW /* 2569 */:
                return "cw";
            case Device.KEY_TYPE_CCW /* 2570 */:
                return "ccw";
            case Device.KEY_TYPE_FN /* 2571 */:
                return "fn";
            case Device.KEY_TYPE_MENU /* 2572 */:
                return "menu";
            case Device.KEY_TYPE_DISP /* 2573 */:
                return "disp";
            case Device.KEY_TYPE_FLASH /* 2574 */:
                return "flash";
            case Device.KEY_TYPE_SWITCH /* 2575 */:
                return "switch";
            case Device.KEY_TYPE_RECORD /* 2576 */:
                return "record";
            case Device.KEY_TYPE_SIDE_CW /* 2577 */:
                return "side cw";
            case Device.KEY_TYPE_SIDE_CCW /* 2578 */:
                return "side ccw";
            case Device.KEY_TYPE_ZOOM_CW /* 2579 */:
                return "zoom cw";
            case Device.KEY_TYPE_ZOOM_CCW /* 2580 */:
                return "zoom ccw";
            case Device.KEY_TYPE_FOCUS_CW /* 2581 */:
                return "focus cw";
            case Device.KEY_TYPE_FOCUS_CCW /* 2582 */:
                return "focus ccw";
            default:
                return "Failed";
        }
    }
}
