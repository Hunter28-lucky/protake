package defpackage;

import defpackage.C4374;

/* renamed from: ট, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4179 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float m13200(C4374.C4375 c4375, C4374.C4375 c43752) {
        return (float) Math.atan2(c43752.f15051 - c4375.f15051, c43752.f15050 - c4375.f15050);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static float m13201(C4374.C4375 c4375, C4374.C4375 c43752) {
        return (float) Math.sqrt(Math.pow(c43752.f15050 - c4375.f15050, 2.0d) + Math.pow(c43752.f15051 - c4375.f15051, 2.0d));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float m13202(String str, C4374.C4375 c4375, C4374.C4375 c43752, int i, int i2) {
        float fMin = Math.min(i, i2);
        float f = (i * 1.0f) / fMin;
        float f2 = (i2 * 1.0f) / fMin;
        return m13201(new C4374.C4375(((c4375.f15050 - 0.5f) * f) + 0.5f, ((c4375.f15051 - 0.5f) * f2) + 0.5f), new C4374.C4375(((c43752.f15050 - 0.5f) * f) + 0.5f, ((c43752.f15051 - 0.5f) * f2) + 0.5f));
    }
}
