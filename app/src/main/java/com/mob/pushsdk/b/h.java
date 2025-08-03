package com.mob.pushsdk.b;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import com.mob.MobSDK;
import com.mob.pushsdk.MobPush;
import com.mob.pushsdk.base.PLog;
import com.mob.tools.utils.ReflectHelper;
import java.util.List;

/* loaded from: classes2.dex */
public class h {
    private static h a;
    private static String b;
    private static Context c;

    private h() {
    }

    public static synchronized h a() {
        if (a == null) {
            a = new h();
            c = MobSDK.getContext();
            b = Build.BRAND;
            b();
        }
        return a;
    }

    public static String b() {
        if (MobPush.Channels.HUAWEI.equalsIgnoreCase(b)) {
            String strA = a("ro.build.version.emui");
            if (!TextUtils.isEmpty(strA)) {
                b = MobPush.Channels.HUAWEI;
                return strA;
            }
        } else if (MobPush.Channels.XIAOMI.equalsIgnoreCase(b)) {
            String strA2 = a("ro.miui.ui.version.name");
            if (!TextUtils.isEmpty(strA2)) {
                b = MobPush.Channels.XIAOMI;
                return strA2;
            }
        } else if (MobPush.Channels.MEIZU.equalsIgnoreCase(b)) {
            if (!TextUtils.isEmpty(a("ro.meizu.product.model"))) {
                b = MobPush.Channels.MEIZU;
                return a("ro.build.display.id");
            }
        } else if (MobPush.Channels.OPPO.equalsIgnoreCase(b)) {
            String strA3 = a("ro.build.version.opporom");
            if (!TextUtils.isEmpty(strA3)) {
                b = MobPush.Channels.OPPO;
                return strA3;
            }
        } else if (MobPush.Channels.VIVO.equalsIgnoreCase(b)) {
            String strA4 = a("ro.vivo.os.version");
            if (!TextUtils.isEmpty(strA4)) {
                b = MobPush.Channels.VIVO;
                return strA4;
            }
        }
        String strA5 = a("ro.build.version.emui");
        if (!TextUtils.isEmpty(strA5)) {
            b = MobPush.Channels.HUAWEI;
            return strA5;
        }
        String strA6 = a("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(strA6)) {
            b = MobPush.Channels.XIAOMI;
            return strA6;
        }
        if (!TextUtils.isEmpty(a("ro.meizu.product.model"))) {
            b = MobPush.Channels.MEIZU;
            return a("ro.build.display.id");
        }
        String strA7 = a("ro.build.version.opporom");
        if (!TextUtils.isEmpty(strA7)) {
            b = MobPush.Channels.OPPO;
            return strA7;
        }
        String strA8 = a("ro.vivo.os.version");
        if (!TextUtils.isEmpty(strA8)) {
            b = MobPush.Channels.VIVO;
        }
        return strA8;
    }

    public String c() {
        return (b.equals(MobPush.Channels.HUAWEI) || b.equals(MobPush.Channels.XIAOMI) || b.equals(MobPush.Channels.MEIZU) || b.equals(MobPush.Channels.OPPO) || b.equals(MobPush.Channels.VIVO)) ? b : "";
    }

    public boolean d() {
        List<ActivityManager.RunningAppProcessInfo> list;
        String str = null;
        try {
            list = (List) ReflectHelper.invokeInstanceMethod((ActivityManager) c.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY), "getRunningAppProcesses", new Object[0]);
        } catch (Throwable th) {
            PLog.getInstance().e(th);
        }
        if (list == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            try {
                if (runningAppProcessInfo.pid == Process.myPid()) {
                    str = runningAppProcessInfo.processName;
                }
            } catch (Throwable th2) {
                PLog.getInstance().e(th2);
            }
        }
        boolean z = str != null && str.equalsIgnoreCase(c.getPackageName());
        PLog.getInstance().d("MobPush isInMainProcess process:" + str + ",res:" + z, new Object[0]);
        return z;
    }

    public boolean e() {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((NotificationManager) c.getSystemService("notification")).areNotificationsEnabled();
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) c.getSystemService("appops");
            ApplicationInfo applicationInfo = c.getApplicationInfo();
            String packageName = c.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            int iIntValue = Integer.valueOf(cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(Integer.valueOf(cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class).toString()).intValue()), Integer.valueOf(i), packageName).toString()).intValue();
            PLog.getInstance().d("isNotificationEnabled:" + iIntValue, new Object[0]);
            return iIntValue == 0;
        } catch (Throwable th) {
            PLog.getInstance().d(th);
            return true;
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String strSubstring = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            if (str.equalsIgnoreCase("ro.build.version.emui")) {
                strSubstring = strSubstring.substring(strSubstring.lastIndexOf("_") + 1, strSubstring.length());
            }
            if (str.equalsIgnoreCase("ro.miui.ui.version.name") && strSubstring.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                strSubstring = strSubstring.substring(1);
            }
            if (str.equalsIgnoreCase("ro.build.display.id")) {
                strSubstring = strSubstring.substring(6, strSubstring.lastIndexOf(".") + 2);
            }
            if (str.equalsIgnoreCase("ro.build.version.opporom") && strSubstring.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
                strSubstring = strSubstring.substring(1);
            }
            PLog.getInstance().d("MobPush System UI Version:" + strSubstring, new Object[0]);
            return strSubstring;
        } catch (Throwable th) {
            PLog.getInstance().d(th);
            return null;
        }
    }
}
