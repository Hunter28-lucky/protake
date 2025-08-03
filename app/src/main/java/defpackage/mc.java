package defpackage;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public class mc {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static mc f7992;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context f7993;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static mc m7550() {
        if (f7992 == null) {
            f7992 = new mc();
        }
        return f7992;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m7551() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ec m7552() {
        return ec.m6005();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m7553(Context context) {
        ec.m6005();
        this.f7993 = context.getApplicationContext();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public Context m7554() {
        return this.f7993;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m7555() {
        return sb.m8225(null, this.f7993);
    }
}
