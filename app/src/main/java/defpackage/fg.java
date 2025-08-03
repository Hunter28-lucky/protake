package defpackage;

/* loaded from: classes.dex */
public class fg {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m6069(String str, String str2) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }
}
