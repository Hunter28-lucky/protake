package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* loaded from: classes.dex */
final class c {
    public final String activity;
    public final String bg;
    public final long n;
    public final long o;
    public final long p;
    public final long q;
    public final float r;
    public final long s;
    public final long t;

    public c(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        }
        this.bg = UMMemoryMonitor.get().isForeground() ? "fg" : "bg";
        this.n = memoryInfo.getTotalPss() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        this.o = memoryInfo.dalvikPss * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        this.p = memoryInfo.nativePss * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        this.s = f.a(memoryInfo) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        long jFreeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.q = jFreeMemory;
        long jMaxMemory = Runtime.getRuntime().maxMemory();
        if (jMaxMemory != 0) {
            this.r = (jFreeMemory * 1.0f) / jMaxMemory;
        } else {
            this.r = 1.0f;
        }
        this.t = f.a() * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
