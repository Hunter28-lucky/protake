package defpackage;

import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public final class te {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static te f8611 = new te();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static te m8309() {
        return f8611;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static String m8310(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0055 A[RETURN] */
    /* renamed from: ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m8311(android.content.Context r7) {
        /*
            r0 = 0
            java.lang.String r1 = android.os.Build.HARDWARE     // Catch: java.lang.Exception -> L66
            java.lang.String r2 = "goldfish"
            boolean r1 = r1.contains(r2)     // Catch: java.lang.Exception -> L66
            r2 = 1
            if (r1 != 0) goto L65
            java.lang.String r1 = android.os.Build.PRODUCT     // Catch: java.lang.Exception -> L66
            java.lang.String r3 = "sdk"
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Exception -> L66
            if (r1 != 0) goto L65
            java.lang.String r1 = android.os.Build.FINGERPRINT     // Catch: java.lang.Exception -> L66
            java.lang.String r3 = "generic"
            boolean r1 = r1.contains(r3)     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L21
            goto L65
        L21:
            java.lang.String r1 = "phone"
            java.lang.Object r1 = r7.getSystemService(r1)     // Catch: java.lang.Exception -> L66
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L56
            java.lang.String r1 = r1.getDeviceId()     // Catch: java.lang.Exception -> L66
            if (r1 == 0) goto L52
            int r3 = r1.length()     // Catch: java.lang.Exception -> L66
            if (r3 != 0) goto L38
            goto L52
        L38:
            r4 = r0
        L39:
            if (r4 >= r3) goto L52
            char r5 = r1.charAt(r4)     // Catch: java.lang.Exception -> L66
            boolean r5 = java.lang.Character.isWhitespace(r5)     // Catch: java.lang.Exception -> L66
            if (r5 != 0) goto L4f
            char r5 = r1.charAt(r4)     // Catch: java.lang.Exception -> L66
            r6 = 48
            if (r5 == r6) goto L4f
            r1 = r0
            goto L53
        L4f:
            int r4 = r4 + 1
            goto L39
        L52:
            r1 = r2
        L53:
            if (r1 == 0) goto L56
            return r2
        L56:
            android.content.ContentResolver r7 = r7.getContentResolver()     // Catch: java.lang.Exception -> L66
            java.lang.String r1 = "android_id"
            java.lang.String r7 = android.provider.Settings.Secure.getString(r7, r1)     // Catch: java.lang.Exception -> L66
            boolean r7 = defpackage.ua.m8370(r7)     // Catch: java.lang.Exception -> L66
            return r7
        L65:
            return r2
        L66:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.te.m8311(android.content.Context):boolean");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m8312() {
        return "android";
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m8313() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i = 0; i < 5; i++) {
            try {
                if (new File(strArr[i] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static String m8314() {
        return Build.BOARD;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m8315() {
        return Build.BRAND;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m8316() {
        return Build.DEVICE;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m8317() {
        return Build.DISPLAY;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m8318() {
        return Build.VERSION.INCREMENTAL;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m8319() {
        return Build.MANUFACTURER;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m8320() {
        return Build.MODEL;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m8321() {
        return Build.PRODUCT;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static String m8322() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static String m8323() {
        return Build.VERSION.SDK;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static String m8324() {
        return Build.TAGS;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static String m8325() {
        return m8310("ro.kernel.qemu", "0");
    }
}
