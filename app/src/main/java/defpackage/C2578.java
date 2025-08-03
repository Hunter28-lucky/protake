package defpackage;

import android.location.Location;
import android.media.audiofx.AutomaticGainControl;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.FinderManager;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.AbstractC2341;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: MetadataUtils.java */
/* renamed from: ɚ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2578 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f9591 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String f9592 = "ɚ";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m9437(AbstractC2341.C2344 c2344, C3891 c3891, String str) {
        int iM12462;
        int iM12463;
        int i;
        boolean z;
        int i2;
        float f;
        int i3;
        StringBuilder sb = new StringBuilder();
        C3828 c3828M11224 = C3444.m11224(c3891.m12495() ? c3891.m12399() : c3891.m12380());
        sb.append("Lens:");
        sb.append(c3828M11224.m12139());
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int iM12460 = c3891.m12460();
        sb.append("RecordMode:");
        sb.append(iM12460);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        C2949 c2949M12803 = C4535.m13880().m13890().m12457() ? C3952.m12801().m12803(c3891.m12399()) : C3952.m12801().m12803(c3891.m12380());
        if (c2949M12803 != null) {
            iM12462 = c2949M12803.m10354();
            iM12463 = c2949M12803.m10355();
        } else {
            iM12462 = c3891.m12462();
            iM12463 = c3891.m12463();
        }
        sb.append("Res:");
        sb.append(iM12463);
        sb.append("*");
        sb.append(iM12462);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int iM12482 = c3891.m12482();
        sb.append("VideoBitrate:");
        sb.append(iM12482);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int iM12456 = c3891.m12456();
        int iM12484 = c3891.m12484();
        int iM12471 = c3891.m12471();
        if (iM12460 == 1 && iM12471 != 0) {
            iM12471 = 0;
        }
        boolean zM12444 = c3891.m12444();
        float fM12404 = c3891.m12404();
        float fM12403 = c3891.m12403();
        sb.append("PreviewFps:");
        sb.append(iM12456);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("Timelapse:");
        sb.append(iM12471);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("NeedCrop:");
        sb.append(zM12444);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("CropRatio:");
        sb.append(fM12404);
        sb.append("*");
        sb.append(fM12403);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        boolean z2 = c3891.m12430() && AutomaticGainControl.isAvailable();
        float fM12377 = c3891.m12377();
        int iM12415 = c3891.m12415();
        sb.append("IsAudioAutoGain:");
        sb.append(z2);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("AudioLevel:");
        sb.append(fM12377);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("MicroPhoneType:");
        sb.append(iM12415);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int iM11253 = C3444.m11227().m11253();
        sb.append("whiteBalanceMode:");
        sb.append(iM11253);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        float fM12414 = c3891.m12414();
        float fM12411 = c3891.m12411();
        float fM12410 = c3891.m12410();
        boolean zM12457 = c3891.m12457();
        boolean zM12381 = c3891.m12381();
        if (zM12381 || !zM12457) {
            i = iM11253;
            fM12414 = 0.0f;
            fM12411 = 0.0f;
        } else {
            i = iM11253;
        }
        sb.append("ProMode:");
        sb.append(zM12457);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("AutoExposure:");
        sb.append(zM12381);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("CurrentISO:");
        sb.append(fM12414);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("CurrentExposureTime:");
        sb.append(fM12411);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("CurrentEV:");
        sb.append(fM12410);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        float fM12412 = c3891.m12412();
        float fM12417 = c3891.m12417();
        if (zM12457) {
            z = z2;
            i2 = iM12471;
            f = fM12417;
        } else {
            i2 = iM12471;
            f = -1.0f;
            fM12412 = -1.0f;
            z = z2;
        }
        sb.append("FocusPercent:");
        sb.append(fM12412);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("ZoomPercent:");
        sb.append(f);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        int iM12466 = c3891.m12466();
        int iM12446 = c3891.m12446();
        int iM12422 = c3891.m12422();
        sb.append("Stabilization:");
        sb.append(iM12466);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("NoiseReductionType:");
        sb.append(iM12446);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append("EdgeEnhancementType:");
        sb.append(iM12422);
        if (f9591) {
            i3 = iM12466;
            C4638.m14099(f9592, String.format("cameraConfigInfo : %s", sb.toString()));
        } else {
            i3 = iM12466;
        }
        c2344.m8790(sb.toString());
        C3286 c3286 = new C3286();
        c3286.m11031(c3828M11224.m12138());
        if (iM12484 == 6) {
            iM12484 = 24;
        }
        c3286.m11038(String.valueOf(iM12484));
        String str2 = "Off";
        if (zM12381) {
            c3286.m11017("On");
            c3286.m11026(String.format(Locale.US, "%.2f", Float.valueOf(((4.0f * fM12410) + 0.0f) - 2.0f)));
        } else {
            c3286.m11017("Off");
            c3286.m11029(String.valueOf((int) fM12414));
            if (fM12411 != 0.0f) {
                c3286.m11041("1/" + Math.round(1.0f / fM12411));
            } else {
                c3286.m11041("0");
            }
        }
        if (zM12457) {
            c3286.m11036("Pro");
        } else {
            c3286.m11036("Auto");
        }
        c3286.m11027(String.valueOf((int) c3891.m12413()));
        int i4 = 1;
        if (iM12460 == 1) {
            c3286.m11028("Direct");
            c3286.m11044(c3286.m11004());
        } else {
            c3286.m11028("Protake");
            Locale locale = Locale.US;
            c3286.m11016(String.format(locale, "%.2f", Float.valueOf(fM12377)));
            c3286.m11035(String.valueOf(C3444.m11227().m11238(iM12415).m14907()));
            if (z) {
                c3286.m11015("On");
            } else {
                c3286.m11015("Off");
            }
            c3286.m11034(C2462.m9035().m9050(c3891.m12442()));
            c3286.m11033(String.valueOf((int) c3891.m12438()));
            c3286.m11025(String.valueOf((int) c3891.m12402()));
            c3286.m11020(String.valueOf((int) c3891.m12398()));
            c3286.m11019(String.valueOf((int) c3891.m12397()));
            c3286.m11045(String.valueOf((int) c3891.m12489()));
            if (i2 == 0) {
                c3286.m11044(c3286.m11004());
                i4 = 1;
            } else {
                i4 = 1;
                c3286.m11044(String.format(locale, "%.2f", Float.valueOf(1000.0f / i2)));
            }
        }
        c3286.m11046(C3444.m11231(i).m8509());
        if (iM12446 == i4) {
            c3286.m11037("On");
        } else {
            c3286.m11037("Off");
        }
        if (iM12422 == i4) {
            c3286.m11040("On");
        } else {
            c3286.m11040("Off");
        }
        if (i3 == i4) {
            c3286.m11042("On");
        } else {
            c3286.m11042("Off");
        }
        c3286.m11021(String.valueOf(C2462.m9035().m9043()));
        c3286.m11039(String.valueOf(C2462.m9035().m9046()));
        c3286.m11022(String.valueOf(C2462.m9035().m9044()));
        c3286.m11043(String.valueOf(C2462.m9035().m9064()));
        c3286.m11023(String.valueOf(C2462.m9035().m9045()));
        c3286.m11018(str);
        c3286.m11024(FinderManager.MACHINE_D);
        c3286.m11014("130");
        if (C2813.f10274) {
            int iM12434 = c3891.m12434();
            if (iM12434 == 1) {
                str2 = "Standard";
            } else if (iM12434 == 2) {
                str2 = "Vivid";
            } else if (iM12434 == 3) {
                str2 = "Smooth";
            }
            c3286.m11030(str2);
        }
        if (c3891.m12437() == 1 && C4112.m13054()) {
            Location locationM10756 = C3151.m10755(FilmApp.m402(), false).m10756();
            C4638.m14099(f9592, String.format("location : %s ", locationM10756));
            if (locationM10756 != null) {
                double latitude = locationM10756.getLatitude();
                double longitude = locationM10756.getLongitude();
                double altitude = locationM10756.getAltitude();
                StringBuilder sb2 = new StringBuilder();
                if (latitude >= 0.0d) {
                    sb2.append("+");
                }
                Locale locale2 = Locale.US;
                sb2.append(String.format(locale2, "%.4f", Double.valueOf(latitude)));
                if (longitude >= 0.0d) {
                    sb2.append("+");
                }
                sb2.append(String.format(locale2, "%.4f", Double.valueOf(longitude)));
                if (altitude != 0.0d) {
                    if (altitude > 0.0d) {
                        sb2.append("+");
                    }
                    sb2.append(String.format(locale2, "%.3f", Double.valueOf(altitude)));
                }
                sb2.append("/");
                c3286.m11032(sb2.toString());
            }
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb3 = new StringBuilder();
        if (c9.m219().m229()) {
            arrayList.add("Zhiyun Gimbals");
        }
        int iM12429 = c3891.m12429();
        if (iM12429 == 1) {
            arrayList.add("Anamorphic Lens (1.33×)");
        } else if (iM12429 == 2) {
            arrayList.add("Anamorphic Lens (1.55×)");
        }
        if (c3891.m12421() == 1) {
            arrayList.add("DOF Adapter");
        }
        int size = arrayList.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                String str3 = (String) arrayList.get(i5);
                if (i5 == 0) {
                    sb3.append(str3);
                } else {
                    sb3.append(", ");
                    sb3.append(str3);
                }
            }
        } else {
            sb3.append("None");
        }
        c3286.m11013(sb3.toString());
        if (f9591) {
            C4638.m14099(f9592, String.format("metadata : %s ", c3286));
        }
        c2344.m8793(c3286);
    }
}
