package defpackage;

import android.os.Environment;
import java.io.File;

/* loaded from: classes.dex */
public final class wd {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8570(String str) {
        try {
            if (!m8571()) {
                return null;
            }
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), str);
            if (!file.exists()) {
                return null;
            }
            file.delete();
            return "";
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m8571() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null || externalStorageState.length() <= 0) {
            return false;
        }
        return (externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null;
    }
}
