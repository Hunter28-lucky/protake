package defpackage;

import com.blink.academy.film.stream.ACHelper;

/* compiled from: TransmitSettingManager.java */
/* loaded from: classes.dex */
public class p3 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static p3 f8244;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f8245;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static p3 m7891() {
        if (f8244 == null) {
            f8244 = new p3();
        }
        return f8244;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m7892(int i) {
        return ACHelper.getInstance().getCameraNameStr(i);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m7893() {
        return this.f8245;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m7894(int i) {
        int i2 = 3;
        if (i == 1) {
            i2 = 0;
        } else if (i == 2) {
            i2 = 1;
        } else if (i == 3) {
            i2 = 2;
        }
        this.f8245 = i2;
    }
}
