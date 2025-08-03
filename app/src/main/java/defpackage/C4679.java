package defpackage;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import java.util.HashMap;

/* renamed from: ഌ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4679 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int f15880;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int f15881;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f15879 = C4625.m14082("HAoeACUADBE1GQRRWFZBKAYBGzUA");

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static HashMap<Integer, C4680> f15882 = new HashMap<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static HashMap<Integer, C4680> f15883 = new HashMap<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static HashMap<Integer, C4680> f15884 = new HashMap<>();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static HashMap<Integer, C4680> f15885 = new HashMap<>();

    /* renamed from: ഌ$Ϳ, reason: contains not printable characters */
    public static final class C4680 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public StackTraceElement[] f15886;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f15887;

        /* renamed from: ԩ, reason: contains not printable characters */
        public String f15888;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f15889;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f15890;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int f15891;
    }

    @TargetApi(17)
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m14181() {
        if (EGL14.eglGetCurrentContext() == null) {
            throw new RuntimeException(C4625.m14082("ACBNORE+JjBBKCp8Z3ZrGk85IHA0PTEkSzd3YHxmHCwoPHE="));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static synchronized void m14182(int i) {
        C2584.m9460();
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        C4680 c4680 = f15882.get(Integer.valueOf(i));
        if (c4680 == null) {
            throw new RuntimeException(String.format(C4625.m14082("OgoVGyUAClQID18XQBNaPU8DACRSGgcED0VWRkFaIAhNCSIXCg=="), Integer.valueOf(i)));
        }
        f15882.remove(Integer.valueOf(i));
        f15880--;
        f15881 -= (c4680.f15889 * c4680.f15890) * c4680.f15891;
        m14184();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static synchronized void m14183(int i, String str, int i2, int i3, int i4) {
        m14181();
        if (f15882.get(Integer.valueOf(i)) != null) {
            throw new RuntimeException(String.format(C4625.m14082("OgoVGyUAClQID18XVxNaPU8MAyIXDhAYSxBBVlcTKhofBj4VTxUNBwpRUkdaIQE="), Integer.valueOf(i)));
        }
        C4680 c4680 = new C4680();
        c4680.f15888 = str;
        c4680.f15887 = i;
        c4680.f15886 = Thread.currentThread().getStackTrace();
        c4680.f15889 = i2;
        c4680.f15890 = i3;
        c4680.f15891 = i4;
        f15882.put(Integer.valueOf(i), c4680);
        f15880++;
        f15881 += i2 * i3 * i4;
        m14184();
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m14184() {
    }
}
