package defpackage;

import android.os.Build;
import com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat;

/* compiled from: CameraHelper.java */
/* renamed from: ȑ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2519 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int[] f9339 = {2, 4, 0, 1, 3};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean m9308(int i) {
        if (!m9310()) {
            return false;
        }
        if (m9311(Build.HARDWARE) || m9311(C2813.f10267)) {
            return m9309(i, 0);
        }
        return false;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m9309(int i, int i2) {
        if (i2 == i) {
            return true;
        }
        for (int i3 : f9339) {
            if (i3 == i2) {
                return true;
            }
            if (i3 == i) {
                return false;
            }
        }
        return false;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m9310() {
        return PushHuaWeiCompat.NAME.equalsIgnoreCase(Build.MANUFACTURER);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m9311(String str) {
        if (str == null || "".equals(str)) {
            return false;
        }
        return str.contains("kirin") || "hi3660".equals(str) || "hi3650".equals(str) || "hi6250".equals(str);
    }
}
