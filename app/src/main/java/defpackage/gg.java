package defpackage;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class gg {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m6100(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                qd.m8125("parseInt--NumberFormatException" + e2.getMessage());
            }
        }
        return -1;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m6101(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append((char) i);
        }
        return sb.toString();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m6102(Context context, String str) throws PackageManager.NameNotFoundException {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            qd.m8125("isExistPackage NameNotFoundException:" + e2.getMessage());
            return false;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m6103(Context context, String str, String str2) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e2) {
            qd.m8125("isSupportPush NameNotFoundException:" + e2.getMessage());
            applicationInfo = null;
        }
        return applicationInfo != null && applicationInfo.metaData.getBoolean(str2, false);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int m6104(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e2) {
            qd.m8124("getVersionCode--Exception:" + e2.getMessage());
            return 0;
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m6105(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e2) {
            qd.m8124("getVersionName--Exception:" + e2.getMessage());
            return null;
        }
    }
}
