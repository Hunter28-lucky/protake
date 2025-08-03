package defpackage;

import android.os.Build;
import com.blink.academy.film.bean.camera.QrCodeBean;
import com.google.gson.Gson;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.C3410;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: PresetManager.java */
/* renamed from: డ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4535 {

    /* renamed from: ގ, reason: contains not printable characters */
    public static C4535 f15515;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f15516 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f15517 = 1;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int f15518 = 2;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f15519 = 3;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f15520 = 4;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f15521 = 5;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final int f15522 = 6;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final int f15523 = 7;

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int f15524 = 0;

    /* renamed from: ՠ, reason: contains not printable characters */
    public final int f15525 = 1;

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int f15526 = 2;

    /* renamed from: ֏, reason: contains not printable characters */
    public final int f15527 = 3;

    /* renamed from: ׯ, reason: contains not printable characters */
    public final int f15528 = 0;

    /* renamed from: ؠ, reason: contains not printable characters */
    public final int f15529 = 1;

    /* renamed from: ހ, reason: contains not printable characters */
    public final int f15530 = 2;

    /* renamed from: ށ, reason: contains not printable characters */
    public final int f15531 = 3;

    /* renamed from: ނ, reason: contains not printable characters */
    public final float f15532 = 1.25f;

    /* renamed from: ރ, reason: contains not printable characters */
    public final float f15533 = -1.0f;

    /* renamed from: ބ, reason: contains not printable characters */
    public final float f15534 = -0.25f;

    /* renamed from: ޅ, reason: contains not printable characters */
    public final float f15535 = -2.0f;

    /* renamed from: ކ, reason: contains not printable characters */
    public boolean f15536;

    /* renamed from: އ, reason: contains not printable characters */
    public boolean f15537;

    /* renamed from: ވ, reason: contains not printable characters */
    public C3891 f15538;

    /* renamed from: މ, reason: contains not printable characters */
    public List<C3891> f15539;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f15540;

    /* renamed from: ދ, reason: contains not printable characters */
    public int f15541;

    /* renamed from: ތ, reason: contains not printable characters */
    public Map<String, String> f15542;

    /* renamed from: ލ, reason: contains not printable characters */
    public C3891 f15543;

    public C4535() {
        m13898();
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static C4535 m13880() {
        if (f15515 == null) {
            synchronized (C4535.class) {
                if (f15515 == null) {
                    f15515 = new C4535();
                }
            }
        }
        return f15515;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m13881(C3891 c3891) {
        this.f15539.add(0, c3891);
        C3184.m10827().m10828(c3891);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3891 m13882(String str) {
        C3891 c3891 = new C3891();
        c3891.m12544(System.currentTimeMillis());
        c3891.m12516(str);
        m13886(c3891, this.f15538, false);
        m13881(c3891);
        return c3891;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m13883(C3891 c3891) {
        m13881(c3891);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C3891 m13884(QrCodeBean qrCodeBean) throws NumberFormatException {
        int iM9063;
        int i;
        C3891 c3891 = new C3891();
        c3891.m12544(System.currentTimeMillis());
        c3891.m12516(qrCodeBean.getDisplayName());
        c3891.m12517(qrCodeBean.getConfigVersion());
        c3891.m12394(qrCodeBean.getAppVersion());
        c3891.m12536(qrCodeBean.getDeviceNo());
        c3891.m12534(qrCodeBean.getSystemNo());
        c3891.m12345(c3891.m12428());
        c3891.m12357(qrCodeBean.getResolution());
        c3891.m12358((qrCodeBean.getResolution() * 16) / 9);
        c3891.m12348(qrCodeBean.getBitrate());
        c3891.m12354(qrCodeBean.getFPS() / 100);
        c3891.m12395(qrCodeBean.getFPS() / 100);
        c3891.m12436(qrCodeBean.getTimeLapseMode() * 10);
        c3891.m12504(qrCodeBean.getExposureMode() == 0);
        c3891.m12532(qrCodeBean.getOpener() / 100.0f);
        c3891.m12527((c3891.m12416() * 1.0f) / (c3891.m12484() * 360));
        c3891.m12498(qrCodeBean.getAngleMode() == 0);
        c3891.m12530(qrCodeBean.getISO() / 100.0f);
        c3891.m12526(qrCodeBean.getEV() / 1000.0f);
        switch (qrCodeBean.getWB()) {
            case 0:
                c3891.m12392(2);
                break;
            case 1:
                c3891.m12392(9);
                break;
            case 2:
                c3891.m12392(4);
                break;
            case 3:
                c3891.m12392(7);
                break;
            case 4:
                c3891.m12392(8);
                break;
            case 5:
                c3891.m12392(5);
                break;
            case 6:
                c3891.m12392(6);
                break;
            case 7:
                c3891.m12392(1);
                break;
        }
        c3891.m12515(qrCodeBean.getCameraName());
        if (qrCodeBean.getFocus() == -2000.0f) {
            c3891.m12528(-0.25f);
        } else if (qrCodeBean.getFocus() == -1000.0f) {
            c3891.m12528(1.25f);
        } else {
            c3891.m12528(1.0f - (qrCodeBean.getFocus() / 1000.0f));
        }
        c3891.m12533(C3947.m12727().m12753(qrCodeBean.getZoom() / 1000.0f));
        int waveMode = qrCodeBean.getWaveMode();
        if (waveMode == 0) {
            c3891.m12367(1);
        } else if (waveMode == 1) {
            c3891.m12367(0);
        } else if (waveMode == 2) {
            c3891.m12367(3);
        } else if (waveMode == 3) {
            c3891.m12367(2);
        }
        if (qrCodeBean.getAudioLevel() > 1000) {
            c3891.m12500(1.0f);
        } else {
            c3891.m12500(qrCodeBean.getAudioLevel() / 1000.0f);
        }
        c3891.m12353(qrCodeBean.getMic());
        c3891.m12531(qrCodeBean.getMic());
        c3891.m12499(qrCodeBean.getAutoGain() == 1);
        int alwaysOnState = qrCodeBean.getAlwaysOnState();
        if (alwaysOnState == 0) {
            c3891.m12497(-1);
        } else if (alwaysOnState == 1) {
            c3891.m12497(0);
        } else if (alwaysOnState == 2) {
            c3891.m12497(1);
        } else if (alwaysOnState == 3) {
            c3891.m12497(2);
        }
        c3891.m12363(qrCodeBean.getProMode() == 0);
        String cropRation = qrCodeBean.getCropRation();
        if (!r1.m8143(cropRation)) {
            c3891.m12520(16.0f);
            c3891.m12519(9.0f);
        } else if (cropRation.equals("Off")) {
            c3891.m12541(0);
            if (qrCodeBean.getInputModeState() == 0) {
                c3891.m12520(16.0f);
                c3891.m12519(9.0f);
            } else if (qrCodeBean.getInputModeState() == 2) {
                c3891.m12520(2.76f);
                c3891.m12519(1.0f);
            } else {
                c3891.m12520(2.37f);
                c3891.m12519(1.0f);
            }
        } else {
            c3891.m12541(1);
            String[] strArrSplit = cropRation.split(Constants.COLON_SEPARATOR);
            if (r1.m8142(strArrSplit)) {
                c3891.m12520(Float.valueOf(strArrSplit[0]).floatValue());
                c3891.m12519(Float.valueOf(strArrSplit[1]).floatValue());
            }
        }
        c3891.m12556(qrCodeBean.getAreaMode() == 1);
        c3891.m12352(qrCodeBean.getArea());
        int lineState = qrCodeBean.getLineState();
        c3891.m12543(0);
        c3891.m12435(0);
        c3891.m12521(0);
        if (lineState == 1) {
            c3891.m12435(1);
        } else if (lineState == 2) {
            c3891.m12521(1);
        } else if (lineState == 3) {
            c3891.m12435(1);
            c3891.m12521(1);
        } else if (lineState == 4) {
            c3891.m12543(1);
        } else if (lineState == 5) {
            c3891.m12435(1);
            c3891.m12543(1);
        } else if (lineState == 6) {
            c3891.m12521(1);
            c3891.m12543(1);
        } else if (lineState == 7) {
            c3891.m12521(1);
            c3891.m12543(1);
            c3891.m12435(1);
        }
        try {
            iM9063 = Integer.parseInt(qrCodeBean.getLutType());
        } catch (Exception unused) {
            iM9063 = C2462.m9035().m9063(qrCodeBean.getLutType());
        }
        c3891.m12554(iM9063);
        c3891.m12552(qrCodeBean.getStrength() / 1000.0f);
        c3891.m12518(qrCodeBean.getContrast() / 1000.0f);
        c3891.m12514(qrCodeBean.getBrightness() / 1000.0f);
        c3891.m12513(qrCodeBean.getBlackP() / 1000.0f);
        c3891.m12391(qrCodeBean.getWhiteP() / 1000.0f);
        c3891.m12540(qrCodeBean.getFrameDrop());
        if (qrCodeBean.getSystemNo().contains("i")) {
            c3891.m12365(1);
            c3891.m12538(0);
        } else {
            c3891.m12365(qrCodeBean.getNoiseReduction());
            c3891.m12538(qrCodeBean.getEdge());
        }
        if (qrCodeBean.getStabilization() == 0) {
            c3891.m12355(0);
        } else {
            c3891.m12355(1);
        }
        c3891.m12529(qrCodeBean.getCurrentHz());
        c3891.m12388(qrCodeBean.getRecordMode());
        int recordMode = qrCodeBean.getRecordMode();
        if (recordMode == 0) {
            c3891.m12359(0);
        } else if (recordMode == 1) {
            c3891.m12359(1);
        } else if (recordMode == 2) {
            if (C3444.m11227().m11255(c3891.m12456())) {
                c3891.m12359(1);
            } else {
                c3891.m12359(0);
            }
        }
        int iM9039 = C2462.m9035().m9039(qrCodeBean.getCameraUnit()) + 1;
        String reelNumber = qrCodeBean.getReelNumber();
        if (r1.m8143(reelNumber)) {
            try {
                i = Integer.parseInt(reelNumber);
            } catch (Exception unused2) {
                C4638.m14101("contentToPresetBean", "reelNumber change error");
            }
        } else {
            i = 1;
        }
        c3891.m12524((iM9039 * 1000) + i);
        c3891.m12346(qrCodeBean.getRepeatMode());
        c3891.m12550(qrCodeBean.getLeicaMode());
        int videoFormatMode = qrCodeBean.getVideoFormatMode();
        if (videoFormatMode > 1) {
            videoFormatMode = 0;
        }
        c3891.m12343(videoFormatMode);
        c3891.m12545(qrCodeBean.getInputModeState());
        c3891.m12503(r1.m8138(qrCodeBean.getAutoCameraName()) ? "0" : qrCodeBean.getAutoCameraName());
        float autoZoom = qrCodeBean.getAutoZoom() / 1000.0f;
        C3410.C3411 c3411 = C3410.InterfaceC3412.f11765;
        if (autoZoom < c3411.m11187()) {
            C3410.C3411 c34112 = C3410.InterfaceC3412.f11764;
            if (!c34112.m11188()) {
                autoZoom = c3411.m11187();
            } else if (autoZoom < c34112.m11187()) {
                autoZoom = c34112.m11187();
            }
        } else if (autoZoom > c3411.m11187() * 2.0f) {
            C3410.C3411 c34113 = C3410.InterfaceC3412.f11766;
            if (!c34113.m11188()) {
                autoZoom = c3411.m11187();
            } else if (autoZoom > c34113.m11187() * 2.0f) {
                C3410.C3411 c34114 = C3410.InterfaceC3412.f11767;
                if (!c34114.m11188() || autoZoom > c34114.m11187() * 2.0f) {
                    autoZoom = c3411.m11187();
                }
            }
        }
        c3891.m12523(autoZoom);
        c3891.m12347(qrCodeBean.getWB() == 1 ? qrCodeBean.getTemp() > C3444.m11227().m11249() ? C3444.m11227().m11249() : qrCodeBean.getTemp() < C3444.m11227().m11250() ? C3444.m11227().m11250() : qrCodeBean.getTemp() : 5000);
        c3891.m12373(qrCodeBean.getWB() == 1 ? qrCodeBean.getTemp() > C3444.m11227().m11251() ? C3444.m11227().m11251() : qrCodeBean.getTemp() < C3444.m11227().m11250() ? C3444.m11227().m11250() : qrCodeBean.getTint() : 0);
        c3891.m12384(qrCodeBean.getRecBeeperState());
        c3891.m12360(qrCodeBean.getRecFlashState());
        c3891.m12350(qrCodeBean.getVolumeKeyRecordState());
        c3891.m12502(qrCodeBean.getAutoAssistantsState());
        c3891.m12537(qrCodeBean.getDofAdapterState());
        if (qrCodeBean.getAutoFrontZoomPercent() == 0) {
            c3891.m12522(1.0f);
        } else {
            c3891.m12522(qrCodeBean.getAutoFrontZoomPercent() / 1000.0f);
        }
        if (qrCodeBean.getPortraitRes() == 0) {
            c3891.m12439(720);
        } else {
            c3891.m12439(qrCodeBean.getPortraitRes());
        }
        if (qrCodeBean.getPortraitFPS() == 0) {
            c3891.m12440(30);
        } else {
            c3891.m12440(qrCodeBean.getPortraitFPS());
        }
        if (qrCodeBean.getPortraitAperture() == 0.0f) {
            c3891.m12441(1.4f);
        } else {
            c3891.m12441(qrCodeBean.getPortraitAperture());
        }
        if (qrCodeBean.getPortraitAFMode() == 0) {
            c3891.m12362(0);
        } else {
            c3891.m12362(qrCodeBean.getPortraitAFMode());
        }
        c3891.m12364(qrCodeBean.getPortraitAFValue());
        c3891.m12356(qrCodeBean.getPortraitIsLidar());
        c3891.m12542(qrCodeBean.getHdmiCleanState());
        c3891.m12555(qrCodeBean.getSelfieMirrorState());
        c3891.m12368(qrCodeBean.getTimeCodeState());
        c3891.m12361(qrCodeBean.getPerformanceState());
        return c3891;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m13885(C3891 c3891, C3891 c38912) {
        c3891.m12510(c38912.m12389());
        c3891.m12507(c38912.m12385());
        c3891.m12511(c38912.m12390());
        c3891.m12508(c38912.m12386());
        c3891.m12505(c38912.m12382());
        c3891.m12509(c38912.m12387());
        c3891.m12512(c38912.m12396());
        c3891.m12506(c38912.m12383());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m13886(C3891 c3891, C3891 c38912, boolean z) {
        c3891.m12515(c38912.m12399());
        c3891.m12358(c38912.m12463());
        c3891.m12357(c38912.m12462());
        c3891.m12344(c38912.m12481());
        c3891.m12348(c38912.m12482());
        c3891.m12349(c38912.m12479());
        c3891.m12351(c38912.m12480());
        c3891.m12553(c38912.m12483());
        c3891.m12354(c38912.m12456());
        c3891.m12395(c38912.m12484());
        c3891.m12436(c38912.m12471());
        c3891.m12501(c38912.m12378());
        c3891.m12392(c38912.m12488());
        c3891.m12365(c38912.m12446());
        c3891.m12538(c38912.m12422());
        c3891.m12355(c38912.m12466());
        c3891.m12373(c38912.m12473());
        c3891.m12370(c38912.m12474());
        c3891.m12371(c38912.m12475());
        c3891.m12347(c38912.m12469());
        c3891.m12372(c38912.m12467());
        c3891.m12369(c38912.m12468());
        c3891.m12548(c38912.m12432());
        c3891.m12546(c38912.m12430());
        c3891.m12500(c38912.m12377());
        c3891.m12531(c38912.m12415());
        c3891.m12504(c38912.m12381());
        c3891.m12530(c38912.m12414());
        c3891.m12527(c38912.m12411());
        c3891.m12525(c38912.m12409());
        c3891.m12532(c38912.m12416());
        c3891.m12528(c38912.m12412());
        c3891.m12533(c38912.m12417());
        c3891.m12498(c38912.m12376());
        c3891.m12393(c38912.m12490());
        c3891.m12526(c38912.m12410());
        c3891.m12363(c38912.m12457());
        if (!z) {
            c3891.m12524(c38912.m12408());
            c3891.m12384(c38912.m12458());
            c3891.m12360(c38912.m12459());
            c3891.m12350(c38912.m12486());
            c3891.m12540(c38912.m12424());
            c3891.m12529(c38912.m12413());
            c3891.m12545(c38912.m12429());
            c3891.m12537(c38912.m12421());
            c3891.m12502(c38912.m12379());
            c3891.m12346(c38912.m12461());
            c3891.m12551(c38912.m12437());
            c3891.m12543(c38912.m12427());
            c3891.m12521(c38912.m12405());
            c3891.m12435(c38912.m12470());
            c3891.m12497(c38912.m12375());
            c3891.m12352(c38912.m12464());
            c3891.m12520(c38912.m12404());
            c3891.m12519(c38912.m12403());
            c3891.m12556(c38912.m12444());
            c3891.m12391(c38912.m12489());
            c3891.m12513(c38912.m12397());
            c3891.m12514(c38912.m12398());
            c3891.m12518(c38912.m12402());
            c3891.m12552(c38912.m12438());
            c3891.m12554(c38912.m12442());
            c3891.m12367(c38912.m12487());
        }
        c3891.m12388(c38912.m12485());
        c3891.m12359(c38912.m12460());
        c3891.m12366(c38912.m12447());
        c3891.m12394(c38912.m12448());
        c3891.m12536(c38912.m12420());
        c3891.m12535(c38912.m12419());
        c3891.m12534(c38912.m12418());
        c3891.m12517(c38912.m12401());
        c3891.m12550(c38912.m12434());
        c3891.m12343(c38912.m12478());
        c3891.m12541(c38912.m12425());
        c3891.m12523(c38912.m12407());
        c3891.m12522(c38912.m12406());
        c3891.m12549(c38912.m12433());
        c3891.m12503(c38912.m12380());
        c3891.m12353(c38912.m12477());
        c3891.m12555(c38912.m12443());
        c3891.m12439(c38912.m12455());
        c3891.m12440(c38912.m12453());
        c3891.m12441(c38912.m12452());
        c3891.m12362(c38912.m12450());
        c3891.m12364(c38912.m12451());
        c3891.m12356(c38912.m12454());
        c3891.m12542(c38912.m12426());
        c3891.m12368(c38912.m12472());
        c3891.m12361(c38912.m12449());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m13887(C3891 c3891) {
        this.f15539.remove(c3891);
        C3184.m10827().m10840(c3891);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String m13888() {
        return this.f15542.get("android_version");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public List<C3891> m13889() {
        return this.f15539;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public C3891 m13890() {
        return this.f15538;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public C3891 m13891() {
        return this.f15543;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public String m13892() {
        return this.f15542.get("manufacturer");
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public String m13893() {
        return this.f15542.get("model");
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public String m13894() {
        return this.f15542.get("OS");
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public String m13895() {
        return this.f15542.get(Constants.VERSION);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public int m13896() {
        if (this.f15541 == 0) {
            int iM9566 = C2618.m9566("setting_height_sp", 0);
            this.f15541 = iM9566;
            if (iM9566 == 0 && m13890() != null) {
                this.f15541 = m13890().m12462();
            }
        }
        return this.f15541;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public int m13897() {
        if (this.f15540 == 0) {
            int iM9566 = C2618.m9566("setting_width_sp", 0);
            this.f15540 = iM9566;
            if (iM9566 == 0 && m13890() != null) {
                this.f15540 = m13890().m12463();
            }
        }
        return this.f15540;
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final void m13898() {
        m13901();
        m13900();
        m13899();
        this.f15536 = this.f15538.m12426() == 1;
        this.f15537 = C2618.m9565("reverse_wheel_focus_sp", false);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m13899() {
        List<C3891> listM10850 = C3184.m10827().m10850();
        this.f15539 = listM10850;
        if (!r1.m8144(listM10850)) {
            C3891 c3891 = new C3891();
            this.f15538 = c3891;
            c3891.m12547(true);
            m13886(this.f15538, this.f15543, false);
            m13885(this.f15538, this.f15543);
            C3184.m10827().m10828(this.f15538);
            C2618.m9571("preset_version_sp", 11);
            return;
        }
        Iterator<C3891> it = this.f15539.iterator();
        while (it.hasNext()) {
            C3891 next = it.next();
            if (next.m12431()) {
                it.remove();
                this.f15538 = next;
                int iM9566 = C2618.m9566("preset_version_sp", 0);
                if (iM9566 < 4) {
                    C2618.m9571("preset_version_sp", 4);
                    this.f15538.m12523(this.f15543.m12407());
                    if (iM9566 < 3) {
                        this.f15538.m12549(this.f15543.m12433());
                        this.f15538.m12503(this.f15543.m12380());
                        this.f15538.m12388(this.f15543.m12485());
                        ArrayList<v5> arrayListM11248 = C3444.m11227().m11248();
                        int type = 0;
                        for (int i = 0; i < arrayListM11248.size(); i++) {
                            v5 v5Var = arrayListM11248.get(i);
                            if (v5Var.isSelected()) {
                                type = v5Var.getType();
                            }
                        }
                        this.f15538.m12359(type != 2 ? this.f15543.m12460() : 1);
                    }
                }
                int iM95662 = C2618.m9566("preset_version_sp", 0);
                if (iM95662 < 5) {
                    this.f15538.m12347(this.f15543.m12469());
                    this.f15538.m12373(this.f15543.m12473());
                    C2618.m9571("preset_version_sp", 5);
                }
                if (iM95662 < 6) {
                    this.f15538.m12522(this.f15543.m12406());
                }
                if (iM95662 < 7) {
                    this.f15538.m12502(this.f15543.m12379());
                    this.f15538.m12350(this.f15543.m12486());
                    this.f15538.m12537(this.f15543.m12421());
                }
                if (iM95662 < 8) {
                    this.f15538.m12507(5.0f);
                    this.f15538.m12511(4.0f);
                    this.f15538.m12508(3.0f);
                    this.f15538.m12505(3.0f);
                    this.f15538.m12509(6.0f);
                    this.f15538.m12512(6.0f);
                    this.f15538.m12506(10.0f);
                }
                if (iM95662 < 9) {
                    this.f15538.m12555(0);
                }
                if (iM95662 < 10) {
                    this.f15538.m12439(720);
                    this.f15538.m12440(30);
                    this.f15538.m12441(1.4f);
                    this.f15538.m12362(0);
                    this.f15538.m12364(1.0f);
                    this.f15538.m12356(1);
                }
                if (iM95662 < 11) {
                    this.f15538.m12542(1);
                    this.f15538.m12368(0);
                    this.f15538.m12361(1);
                }
                C2618.m9571("preset_version_sp", 11);
            }
        }
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final void m13900() {
        C3891 c3891 = new C3891();
        this.f15543 = c3891;
        c3891.m12515("3");
        C3891 c38912 = this.f15543;
        C2375 c2375 = InterfaceC3860.f13265;
        c38912.m12358(c2375.m8846());
        this.f15543.m12357(c2375.m8843());
        this.f15543.m12520(16.0f);
        this.f15543.m12519(9.0f);
        this.f15543.m12543(0);
        this.f15543.m12521(0);
        this.f15543.m12435(0);
        this.f15543.m12497(-1);
        this.f15543.m12352(100);
        this.f15543.m12348(1);
        this.f15543.m12351(1);
        this.f15543.m12349(1);
        this.f15543.m12344(1);
        this.f15543.m12553("video/avc");
        C3891 c38913 = this.f15543;
        v5 v5Var = InterfaceC3860.f13266;
        c38913.m12354(v5Var.m8464());
        this.f15543.m12395(v5Var.m8464());
        this.f15543.m12436(0);
        this.f15543.m12501(48000);
        this.f15543.m12392(2);
        this.f15543.m12365(1);
        this.f15543.m12538(0);
        this.f15543.m12355(1);
        this.f15543.m12540(0);
        this.f15543.m12529(50.0f);
        this.f15543.m12359(0);
        this.f15543.m12360(0);
        this.f15543.m12384(0);
        this.f15543.m12502(1);
        this.f15543.m12350(1);
        this.f15543.m12537(0);
        this.f15543.m12373(0.0f);
        this.f15543.m12370(0.2f);
        this.f15543.m12371(0.8f);
        this.f15543.m12347(5000.0f);
        this.f15543.m12372(0.2f);
        this.f15543.m12369(0.8f);
        this.f15543.m12391(0.0f);
        this.f15543.m12513(0.0f);
        this.f15543.m12514(0.0f);
        this.f15543.m12518(0.0f);
        this.f15543.m12552(100.0f);
        this.f15543.m12554(0);
        this.f15543.m12556(false);
        this.f15543.m12546(true);
        this.f15543.m12500(1.0f);
        this.f15543.m12531(0);
        this.f15543.m12548(false);
        this.f15543.m12504(false);
        this.f15543.m12533(0.0f);
        this.f15543.m12528(-0.25f);
        this.f15543.m12532(180.0f);
        this.f15543.m12530(400.0f);
        this.f15543.m12525(0);
        this.f15543.m12527(0.020833334f);
        this.f15543.m12498(false);
        this.f15543.m12393(false);
        this.f15543.m12526(0.5f);
        this.f15543.m12363(false);
        this.f15543.m12524(1001);
        this.f15543.m12366(m13894());
        this.f15543.m12394(m13895());
        this.f15543.m12536(m13893());
        this.f15543.m12535(m13892());
        this.f15543.m12534(m13888());
        this.f15543.m12517("0.0.1");
        this.f15543.m12367(2);
        this.f15543.m12346(0);
        this.f15543.m12550(0);
        this.f15543.m12343(0);
        this.f15543.m12541(0);
        this.f15543.m12545(0);
        this.f15543.m12551(0);
        this.f15543.m12523(1.0f);
        this.f15543.m12522(1.0f);
        this.f15543.m12549(true);
        this.f15543.m12503("0");
        this.f15543.m12388(2);
        this.f15543.m12537(0);
        this.f15543.m12353(3);
        this.f15543.m12510(false);
        this.f15543.m12507(5.0f);
        this.f15543.m12511(4.0f);
        this.f15543.m12508(3.0f);
        this.f15543.m12505(3.0f);
        this.f15543.m12509(6.0f);
        this.f15543.m12512(6.0f);
        this.f15543.m12506(10.0f);
        this.f15543.m12555(0);
        this.f15543.m12439(720);
        this.f15543.m12440(30);
        this.f15543.m12441(1.4f);
        this.f15543.m12362(0);
        this.f15543.m12364(1.0f);
        this.f15543.m12356(1);
        this.f15543.m12542(1);
        this.f15543.m12368(0);
        this.f15543.m12361(1);
        this.f15543.m12516("恢复默认设置");
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m13901() {
        HashMap map = new HashMap();
        this.f15542 = map;
        map.put("OS", AnalyticsConstants.SDK_TYPE);
        this.f15542.put(Constants.VERSION, "130");
        this.f15542.put("model", Build.MODEL);
        this.f15542.put("manufacturer", Build.MANUFACTURER);
        this.f15542.put("android_version", Build.VERSION.RELEASE);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public boolean m13902() {
        return this.f15536;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public boolean m13903() {
        return this.f15537;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public String m13904(C3891 c3891) {
        String str;
        String str2;
        String str3;
        QrCodeBean qrCodeBean = new QrCodeBean();
        qrCodeBean.setPresetId(c3891.m12428() + "");
        qrCodeBean.setDisplayName(c3891.m12400());
        qrCodeBean.setConfigVersion(c3891.m12401());
        qrCodeBean.setAppVersion(c3891.m12448());
        qrCodeBean.setDeviceNo(c3891.m12420());
        if (c3891.m12418().contains("i") || c3891.m12418().contains("a")) {
            qrCodeBean.setSystemNo(c3891.m12418());
        } else {
            qrCodeBean.setSystemNo("a_" + c3891.m12418());
        }
        qrCodeBean.setUpdateStam(c3891.m12476() == 0 ? c3891.m12428() : c3891.m12476());
        qrCodeBean.setResolution(Math.min(c3891.m12462(), c3891.m12463()));
        qrCodeBean.setBitrate(c3891.m12482());
        qrCodeBean.setFPS(c3891.m12484() * 100);
        qrCodeBean.setTimeLapseMode(c3891.m12471() / 10);
        qrCodeBean.setExposureMode(!c3891.m12381() ? 1 : 0);
        qrCodeBean.setOpener(Math.round(c3891.m12416() * 100.0f));
        qrCodeBean.setAngelMode(!c3891.m12376() ? 1 : 0);
        qrCodeBean.setISO(Math.round(c3891.m12414() * 100.0f));
        qrCodeBean.setEV(Math.round(c3891.m12410() * 1000.0f));
        switch (c3891.m12488()) {
            case 1:
                qrCodeBean.setWB(7);
                break;
            case 2:
                qrCodeBean.setWB(0);
                break;
            case 4:
                qrCodeBean.setWB(2);
                break;
            case 5:
                qrCodeBean.setWB(5);
                break;
            case 6:
                qrCodeBean.setWB(6);
                break;
            case 7:
                qrCodeBean.setWB(3);
                break;
            case 8:
                qrCodeBean.setWB(4);
                break;
            case 9:
                qrCodeBean.setWB(1);
                break;
        }
        qrCodeBean.setCameraName(c3891.m12399());
        if (c3891.m12412() == -0.25f) {
            qrCodeBean.setFocus(-2000);
        } else if (c3891.m12412() == 1.25f) {
            qrCodeBean.setFocus(-1000);
        } else {
            qrCodeBean.setFocus(Math.round((1.0f - c3891.m12412()) * 1000.0f));
        }
        qrCodeBean.setZoom(Math.round(C3947.m12727().m12754(c3891.m12417()) * 1000.0f));
        int iM12487 = c3891.m12487();
        if (iM12487 == 0) {
            qrCodeBean.setWaveMode(1);
        } else if (iM12487 == 1) {
            qrCodeBean.setWaveMode(0);
        } else if (iM12487 == 2) {
            qrCodeBean.setWaveMode(3);
        } else if (iM12487 == 3) {
            qrCodeBean.setWaveMode(2);
        }
        if (c3891.m12377() > 1.0f) {
            qrCodeBean.setAudioLevel(1000);
        } else {
            qrCodeBean.setAudioLevel(Math.round(c3891.m12377() * 1000.0f));
        }
        qrCodeBean.setMic(c3891.m12477());
        qrCodeBean.setAutoGain(c3891.m12491() ? 1 : 0);
        int iM12375 = c3891.m12375();
        if (iM12375 == -1) {
            qrCodeBean.setAlwaysOnState(0);
        } else if (iM12375 == 0) {
            qrCodeBean.setAlwaysOnState(1);
        } else if (iM12375 == 1) {
            qrCodeBean.setAlwaysOnState(2);
        } else if (iM12375 == 2) {
            qrCodeBean.setAlwaysOnState(3);
        }
        qrCodeBean.setProMode(!c3891.m12495() ? 1 : 0);
        if (c3891.m12425() == 0) {
            qrCodeBean.setCropRation("Off");
        } else {
            float fM12404 = c3891.m12404();
            float fM12403 = c3891.m12403();
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
            qrCodeBean.setCropRation(str + Constants.COLON_SEPARATOR + str2);
        }
        qrCodeBean.setAreaMode(c3891.m12494() ? 1 : 0);
        qrCodeBean.setArea(c3891.m12464());
        int iM12427 = c3891.m12427();
        int iM12405 = c3891.m12405();
        int i3 = c3891.m12470() == 1 ? 1 : 0;
        if (iM12405 == 1) {
            i3 += 2;
        }
        if (iM12427 == 1) {
            i3 += 4;
        }
        qrCodeBean.setLineState(i3);
        qrCodeBean.setLutType(c3891.m12442() + "");
        qrCodeBean.setStrength((int) (c3891.m12438() * 1000.0f));
        qrCodeBean.setContrast((int) (c3891.m12402() * 1000.0f));
        qrCodeBean.setBrightness((int) (c3891.m12398() * 1000.0f));
        qrCodeBean.setBlackP((int) (c3891.m12397() * 1000.0f));
        qrCodeBean.setWhiteP((int) (c3891.m12489() * 1000.0f));
        qrCodeBean.setFrameDrop(c3891.m12424());
        qrCodeBean.setNoiseReduction(c3891.m12446());
        qrCodeBean.setEdge(c3891.m12422());
        if (c3891.m12466() == 0) {
            qrCodeBean.setStabilization(0);
        } else {
            qrCodeBean.setStabilization(1);
        }
        qrCodeBean.setCurrentHz((int) c3891.m12413());
        qrCodeBean.setRecordMode(c3891.m12485());
        int iM12408 = c3891.m12408();
        int i4 = iM12408 - ((iM12408 / 1000) * 1000);
        if (i4 < 10) {
            str3 = "00" + i4;
        } else if (i4 < 100) {
            str3 = "0" + i4;
        } else {
            str3 = i4 + "";
        }
        qrCodeBean.setReelNumber(str3);
        qrCodeBean.setCameraUnit(C2462.m9035().m9038(iM12408));
        qrCodeBean.setRepeatMode(c3891.m12461());
        qrCodeBean.setLeicaMode(c3891.m12434());
        qrCodeBean.setVideoFormatMode(c3891.m12478());
        qrCodeBean.setInputModeState(c3891.m12429());
        qrCodeBean.setAutoCameraName(r1.m8138(c3891.m12380()) ? "0" : c3891.m12380());
        qrCodeBean.setAutoZoom(c3891.m12407() * 1000.0f);
        if (c3891.m12488() == 1) {
            qrCodeBean.setTemp(Math.round(c3891.m12469()));
            qrCodeBean.setTint(Math.round(c3891.m12473()));
        } else {
            qrCodeBean.setTemp(5000);
            qrCodeBean.setTint(0);
        }
        qrCodeBean.setSavePathType(0);
        qrCodeBean.setRecBeeperState(c3891.m12458());
        qrCodeBean.setRecFlashState(c3891.m12459());
        qrCodeBean.setAutoAssistantsState(c3891.m12379());
        qrCodeBean.setVolumeKeyRecordState(c3891.m12486());
        qrCodeBean.setDofAdapterState(c3891.m12421());
        if (c3891.m12406() == 0.0f) {
            qrCodeBean.setAutoFrontZoomPercent(1000);
        } else {
            qrCodeBean.setAutoFrontZoomPercent((int) (c3891.m12406() * 1000.0f));
        }
        if (c3891.m12455() == 0) {
            qrCodeBean.setPortraitRes(720);
        } else {
            qrCodeBean.setPortraitRes(c3891.m12455());
        }
        if (c3891.m12453() == 0) {
            qrCodeBean.setPortraitFPS(30);
        } else {
            qrCodeBean.setPortraitFPS(c3891.m12453());
        }
        if (c3891.m12452() == 0.0f) {
            qrCodeBean.setPortraitAperture(1.4f);
        } else {
            qrCodeBean.setPortraitAperture(c3891.m12452());
        }
        if (c3891.m12450() == 0) {
            qrCodeBean.setPortraitAFMode(0);
        } else {
            qrCodeBean.setPortraitAFMode(c3891.m12450());
        }
        qrCodeBean.setPortraitAFValue(c3891.m12451());
        qrCodeBean.setPortraitIsLidar(c3891.m12454());
        qrCodeBean.setHdmiCleanState(c3891.m12426());
        qrCodeBean.setSelfieMirrorState(c3891.m12443());
        qrCodeBean.setPerformanceState(c3891.m12449());
        qrCodeBean.setTimeCodeState(c3891.m12472());
        return new Gson().toJson(qrCodeBean);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public void m13905(boolean z) {
        if (z) {
            this.f15538.m12552(100.0f);
            this.f15538.m12391(0.0f);
            this.f15538.m12513(0.0f);
            this.f15538.m12514(0.0f);
            this.f15538.m12518(0.0f);
            this.f15538.m12554(0);
        } else {
            if (C4136.m13108().m13113(C4136.m13108().m13112(this.f15538.m12442()))) {
                this.f15538.m12552(100.0f);
                this.f15538.m12391(0.0f);
                this.f15538.m12513(0.0f);
                this.f15538.m12514(0.0f);
                this.f15538.m12518(0.0f);
                this.f15538.m12554(0);
            }
        }
        this.f15538.m12343(C2813.f10275 ? 1 : 0);
        this.f15538.m12551(0);
        this.f15538.m12545(0);
        C3947.m12727().m12776();
        m13880().m13915();
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public void m13906() {
        C3947.m12727().m12774();
        m13886(this.f15538, this.f15543, true);
        this.f15538.m12355(0);
        this.f15538.m12365(0);
        this.f15538.m12343(0);
        C3947.m12727().m12776();
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public void m13907() {
        this.f15538.m12554(0);
        this.f15538.m12552(100.0f);
        m13880().m13915();
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public void m13908(boolean z) {
        this.f15536 = z;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public void m13909(boolean z) {
        this.f15537 = z;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public C4535 m13910(int i) {
        this.f15541 = i;
        return this;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public C4535 m13911(int i) {
        this.f15540 = i;
        return this;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public QrCodeBean m13912(String str) {
        return (QrCodeBean) new Gson().fromJson(str, QrCodeBean.class);
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m13913(C3891 c3891) {
        C3184.m10827().m10864(c3891);
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m13914(C3891 c3891) {
        for (C3891 c38912 : this.f15539) {
            if (c38912.m12428() == c3891.m12428()) {
                c38912.m12374(c3891.m12465());
            }
        }
        C3184.m10827().m10864(c3891);
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m13915() {
        if (this.f15538 != null) {
            C3184.m10827().m10864(this.f15538);
        }
        C2618.m9571("setting_width_sp", this.f15540);
        C2618.m9571("setting_height_sp", this.f15541);
    }
}
