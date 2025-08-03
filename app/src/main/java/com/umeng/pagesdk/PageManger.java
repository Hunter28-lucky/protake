package com.umeng.pagesdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.efs.sdk.base.EfsReporter;

/* loaded from: classes2.dex */
public class PageManger {
    public static final String TAG = "PageManger";
    private static Context a = null;
    private static boolean b = false;
    private static EfsReporter c = null;
    private static PageConfigManger d = null;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f17832e = true;
    public static boolean isDebug = true;

    public static Context getApplicationContext() {
        return a;
    }

    public static PageConfigManger getPageConfigManger() {
        return d;
    }

    public static EfsReporter getReporter() {
        return c;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            try {
                if (isDebug) {
                    Log.e("PageManger", "init page manager error! parameter is null!");
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isInit()) {
            if (isDebug) {
                Log.e("PageManger", "invalid init ！");
            }
        } else {
            a = context.getApplicationContext();
            c = efsReporter;
            d = new PageConfigManger(context, efsReporter);
            b = true;
        }
    }

    public static boolean isControlMainThread() {
        return f17832e;
    }

    public static boolean isInit() {
        return b;
    }

    public static void onTracePageBegin(Activity activity, String str) {
        try {
            onTracePageBegin(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageBegin(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!z && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e("PageManger", "tracePageBegin. parameter illegality!");
                            return;
                        }
                        return;
                    } else {
                        if (str.length() <= 10) {
                            if (f17832e && !c.a(activity.getApplicationContext()) && isDebug) {
                                Log.e("PageManger", "tracePageBegin. Non main process !");
                            }
                            b.a(activity.getClass().getName(), str, z);
                            return;
                        }
                        if (isDebug) {
                            Log.e("PageManger", "tracePageBegin. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e("PageManger", "tracePageBegin. parameter null!");
        }
    }

    public static void onTracePageEnd(Activity activity, String str) {
        try {
            onTracePageEnd(activity, str, false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onTracePageEnd(Activity activity, String str, boolean z) {
        if (activity != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!z && (str.equals("onCreate") || str.equals("onStart") || str.equals("onResume") || str.equals("onPause"))) {
                        if (isDebug) {
                            Log.e("PageManger", "tracePageEnd. parameter illegality!");
                            return;
                        }
                        return;
                    } else {
                        if (str.length() <= 10) {
                            if (f17832e && !c.a(activity.getApplicationContext()) && isDebug) {
                                Log.e("PageManger", "tracePageBegin. Non main process !");
                            }
                            b.b(activity.getClass().getName(), str, z);
                            return;
                        }
                        if (isDebug) {
                            Log.e("PageManger", "tracePageEnd. method name is " + str + "method name over length !");
                            return;
                        }
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (isDebug) {
            Log.e("PageManger", "tracePageEnd. parameter null!");
        }
    }

    public static void setControlMainThread(boolean z) {
        f17832e = z;
    }
}
