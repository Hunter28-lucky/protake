package defpackage;

/* compiled from: RecordTimer.java */
/* renamed from: ಞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4621 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static long f15742 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean f15743 = true;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static long f15744 = 0;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static long f15745 = 0;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static float f15746 = 1.0f;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static long m14076() {
        return (long) (((System.nanoTime() - f15745) - f15742) * f15746);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static long m14077(long j) {
        return (long) (((j - f15745) - f15742) * f15746);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m14078() {
        f15745 = System.nanoTime();
        f15744 = 0L;
        f15742 = 0L;
        f15743 = false;
        f15746 = 1.0f;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m14079(float f) {
        f15746 = f;
    }
}
