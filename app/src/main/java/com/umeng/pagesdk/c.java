package com.umeng.pagesdk;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.ProcessUtil;

/* loaded from: classes2.dex */
public final class c {
    public static boolean a(Context context) {
        try {
            String currentProcessName = ProcessUtil.getCurrentProcessName();
            String packageName = context.getApplicationContext().getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
