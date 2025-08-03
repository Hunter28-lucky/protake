package defpackage;

import java.io.File;

/* loaded from: classes.dex */
public final class yc {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m8631(String str) {
        String strM306;
        try {
            strM306 = cg.m306(str);
        } catch (Throwable unused) {
            strM306 = "";
        }
        if (!ua.m8370(strM306)) {
            return strM306;
        }
        return wd.m8570(".SystemConfig" + File.separator + str);
    }
}
