package defpackage;

import android.content.Context;

/* compiled from: NotchUtils.java */
/* renamed from: ற, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4482 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f15390 = "ற";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int[] m13738(Context context) {
        int[] iArr = {0, 0};
        try {
            try {
                try {
                    Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
                } catch (ClassNotFoundException unused) {
                    C4638.m14101(f15390, "getNotchSize ClassNotFoundException");
                    return iArr;
                } catch (NoSuchMethodException unused2) {
                    C4638.m14101(f15390, "getNotchSize NoSuchMethodException");
                    return iArr;
                }
            } catch (Exception unused3) {
                C4638.m14101(f15390, "getNotchSize Exception");
                return iArr;
            }
        } catch (Throwable unused4) {
            return iArr;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m13739(Context context) {
        try {
            try {
                try {
                    Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
                } catch (NoSuchMethodException unused) {
                    C4638.m14101(f15390, "hasNotchInScreen NoSuchMethodException");
                    return false;
                } catch (Exception unused2) {
                    C4638.m14101(f15390, "hasNotchInScreen Exception");
                    return false;
                }
            } catch (ClassNotFoundException unused3) {
                C4638.m14101(f15390, "hasNotchInScreen ClassNotFoundException");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m13740(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m13741(Context context) {
        try {
            try {
                try {
                    Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                    return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
                } catch (NoSuchMethodException unused) {
                    C4638.m14101(f15390, "hasNotchInScreen NoSuchMethodException");
                    return false;
                } catch (Exception unused2) {
                    C4638.m14101(f15390, "hasNotchInScreen Exception");
                    return false;
                }
            } catch (ClassNotFoundException unused3) {
                C4638.m14101(f15390, "hasNotchInScreen ClassNotFoundException");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }
}
