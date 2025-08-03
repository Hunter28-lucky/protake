package defpackage;

/* compiled from: SystemProps.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class v0 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int f8659 = Runtime.getRuntime().availableProcessors();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int m8459() {
        return f8659;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String m8460(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
