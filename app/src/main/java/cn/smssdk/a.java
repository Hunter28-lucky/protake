package cn.smssdk;

/* compiled from: InitConfig.java */
/* loaded from: classes.dex */
public class a {
    private static a a;

    private a() {
    }

    public static synchronized a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }
}
