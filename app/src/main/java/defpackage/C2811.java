package defpackage;

import android.media.CamcorderProfile;
import android.media.MediaCodecInfo;
import android.os.Build;
import com.google.android.gms.common.util.GmsVersion;
import defpackage.C3444;
import java.util.HashMap;
import java.util.List;

/* compiled from: MediaFormatChooser.java */
/* renamed from: β, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2811 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f10249 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String f10250 = "β";

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int[] f10251 = {3, 6, 9, 12};

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int[] f10252 = {6, 12, 18, 24};

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int[] f10253 = {12, 24, 36, 48};

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int[] f10254 = {24, 48, 72, 96};

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int[] f10255 = {32, 64, 96, 128};

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static HashMap<C2375, int[]> f10256;

    static {
        HashMap<C2375, int[]> map = new HashMap<>();
        f10256 = map;
        map.put(C3444.InterfaceC3447.f11881, f10251);
        f10256.put(C3444.InterfaceC3447.f11882, f10252);
        f10256.put(C3444.InterfaceC3447.f11883, f10253);
        f10256.put(C3444.InterfaceC3447.f11884, f10254);
        f10256.put(C3444.InterfaceC3447.f11885, f10255);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m10140() {
        List<MediaCodecInfo> listM14787;
        String str = Build.MODEL;
        if ("PACM00".equalsIgnoreCase(str) || "PCAM10".equalsIgnoreCase(str) || "PCEM00".equalsIgnoreCase(str) || "PACT00".equalsIgnoreCase(str) || "PBBM00".equalsIgnoreCase(str) || "CPH2001".equalsIgnoreCase(str) || "V1831A".equalsIgnoreCase(str) || "1819".equalsIgnoreCase(str) || "V1813BA".equalsIgnoreCase(str) || "PCDM10".equalsIgnoreCase(str)) {
            C2813.f10275 = false;
        } else {
            if (Build.VERSION.SDK_INT < 24 || (listM14787 = C5000.m14787("video/hevc")) == null || listM14787.size() <= 0) {
                return;
            }
            C2813.f10275 = true;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m10141() {
        int i = GmsVersion.VERSION_MANCHEGO;
        try {
            i = CamcorderProfile.get(2004).videoBitRate;
            if (f10249) {
                C4638.m14099(f10250, String.format("videoBitRate : %s ", Integer.valueOf(i)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                i = CamcorderProfile.get(6).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (f10249) {
            C4638.m14099(f10250, String.format("videoBitRate : %s ", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m10142() {
        int i = GmsVersion.VERSION_MANCHEGO;
        try {
            i = CamcorderProfile.get(2005).videoBitRate;
            if (f10249) {
                C4638.m14099(f10250, String.format("videoBitRate : %s ", Integer.valueOf(i)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                i = CamcorderProfile.get(8).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (f10249) {
            C4638.m14099(f10250, String.format("videoBitRate : %s ", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m10143() {
        int i = GmsVersion.VERSION_MANCHEGO;
        try {
            i = CamcorderProfile.get(2003).videoBitRate;
            if (f10249) {
                C4638.m14099(f10250, String.format("videoBitRate : %s ", Integer.valueOf(i)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            try {
                i = CamcorderProfile.get(5).videoBitRate;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (f10249) {
            C4638.m14099(f10250, String.format("videoBitRate : %s ", Integer.valueOf(i)));
        }
        return i;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static float m10144(float f, int i, int i2) {
        return (Math.round(((f * (i2 == 1 ? 0.6666667f : 1.0f)) * (i != 60 ? i != 120 ? i != 240 ? 1.0f : 2.0f : 1.5f : 1.25f)) * 10.0f) * 1.0f) / 10.0f;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int m10145(int i, int i2, int i3, int i4, int i5) {
        return (int) (m10144(m10146(i, i2, i3), i4, i5) * 1000000.0f);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static float m10146(int i, int i2, int i3) {
        if (f10256.get(new C2375(i, i2)) != null) {
            return r2[i3];
        }
        return 6.0f;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int[] m10147(C2375 c2375) {
        return f10256.get(c2375);
    }
}
