package org.greenrobot.greendao;

import android.util.Log;

/* loaded from: classes2.dex */
public class DaoLog {
    public static int d(String str) {
        return Log.d("greenDAO", str);
    }

    public static int e(String str, Throwable th) {
        return Log.e("greenDAO", str, th);
    }

    public static int i(String str) {
        return Log.i("greenDAO", str);
    }

    public static int w(String str) {
        return Log.w("greenDAO", str);
    }

    public static int i(String str, Throwable th) {
        return Log.i("greenDAO", str, th);
    }

    public static int w(String str, Throwable th) {
        return Log.w("greenDAO", str, th);
    }
}
