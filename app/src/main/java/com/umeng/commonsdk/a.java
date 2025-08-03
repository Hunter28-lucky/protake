package com.umeng.commonsdk;

import android.content.Context;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;

/* compiled from: UMInnerManager.java */
/* loaded from: classes2.dex */
public class a {
    private static Class<?> a;
    private static Method b;

    static {
        try {
            int i = UMInnerImpl.f5464;
            a = UMInnerImpl.class;
            Method declaredMethod = UMInnerImpl.class.getDeclaredMethod("initAndSendInternal", Context.class);
            if (declaredMethod != null) {
                b = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        Method method;
        if (context == null || !UMUtils.isMainProgress(context)) {
            return;
        }
        if (SdkVersion.SDK_TYPE == 1) {
            UMConfigureInternation.sendInternal(context);
            return;
        }
        Class<?> cls = a;
        if (cls == null || (method = b) == null) {
            return;
        }
        try {
            method.invoke(cls, context);
        } catch (Throwable unused) {
        }
    }
}
