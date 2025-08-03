package com.mob.socketservice;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mob.MobSDK;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import java.util.List;

/* loaded from: classes2.dex */
public class c {

    public static class a {
        private static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    public boolean b() {
        List<ActivityManager.RunningAppProcessInfo> list;
        Context context = MobSDK.getContext();
        String str = null;
        try {
            list = (List) ReflectHelper.invokeInstanceMethod((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY), "getRunningAppProcesses", new Object[0]);
        } catch (Throwable th) {
            CLog.getInstance().e(th.toString(), new Object[0]);
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
                th2.printStackTrace();
            }
        }
        boolean z = str != null && str.equalsIgnoreCase(context.getPackageName());
        CLog.getInstance().d(String.format("isInMainProcess %s", Boolean.valueOf(z)), new Object[0]);
        return z;
    }

    public int c() {
        try {
            Context context = MobSDK.getContext();
            return context.getPackageManager().getPackageInfo(DeviceHelper.getInstance(context).getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException unused) {
            CLog.getInstance().d("getIconId NameNotFoundException", new Object[0]);
            return 0;
        } catch (Throwable th) {
            CLog.getInstance().d(th);
            return 0;
        }
    }

    private c() {
    }
}
