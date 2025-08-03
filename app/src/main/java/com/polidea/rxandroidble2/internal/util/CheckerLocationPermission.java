package com.polidea.rxandroidble2.internal.util;

import android.content.Context;
import android.os.Process;
import com.polidea.rxandroidble2.ClientScope;

@ClientScope
/* loaded from: classes2.dex */
public class CheckerLocationPermission {
    private final Context context;
    private final String[] scanPermissions;

    public CheckerLocationPermission(Context context, String[] strArr) {
        this.context = context;
        this.scanPermissions = strArr;
    }

    private boolean isPermissionGranted(String str) {
        if (str != null) {
            return this.context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        }
        throw new IllegalArgumentException("permission is null");
    }

    public String[] getRecommendedScanRuntimePermissions() {
        return this.scanPermissions;
    }

    public boolean isScanRuntimePermissionGranted() {
        for (String str : this.scanPermissions) {
            if (isPermissionGranted(str)) {
                return true;
            }
        }
        return this.scanPermissions.length == 0;
    }
}
