package com.umeng.umzid;

/* loaded from: classes2.dex */
public class Spy {
    public static boolean initSuccess = false;

    static {
        try {
            System.loadLibrary("umeng-spy");
            initSuccess = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getID() {
        if (initSuccess) {
            return getNativeID();
        }
        return null;
    }

    public static native String getNativeID();

    public static native String getNativeLibraryVersion();

    public static native String getNativeTag(boolean z, boolean z2);

    /* JADX WARN: Removed duplicated region for block: B:17:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String getTag(android.content.Context r4) {
        /*
            java.lang.Class<com.umeng.umzid.Spy> r0 = com.umeng.umzid.Spy.class
            monitor-enter(r0)
            r1 = 0
            if (r4 == 0) goto L2a
            java.lang.String r2 = "http.proxyHost"
            java.lang.String r2 = java.lang.System.getProperty(r2)     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "http.proxyPort"
            java.lang.String r3 = java.lang.System.getProperty(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L15
            goto L17
        L15:
            java.lang.String r3 = "-1"
        L17:
            int r3 = java.lang.Integer.parseInt(r3)     // Catch: java.lang.Throwable -> L26
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L26
            if (r2 != 0) goto L2a
            r2 = -1
            if (r3 == r2) goto L2a
            r2 = 1
            goto L2b
        L26:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L37
        L2a:
            r2 = r1
        L2b:
            if (r4 == 0) goto L31
            boolean r1 = com.umeng.umzid.d.e(r4)     // Catch: java.lang.Throwable -> L37
        L31:
            java.lang.String r4 = getNativeTag(r2, r1)     // Catch: java.lang.Throwable -> L37
            monitor-exit(r0)
            return r4
        L37:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.umzid.Spy.getTag(android.content.Context):java.lang.String");
    }

    public static String getVersion() {
        if (initSuccess) {
            return getNativeLibraryVersion();
        }
        return null;
    }
}
