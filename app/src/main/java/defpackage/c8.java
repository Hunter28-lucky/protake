package defpackage;

import android.hardware.camera2.params.ColorSpaceTransform;
import android.hardware.camera2.params.RggbChannelVector;
import android.util.Range;

/* compiled from: WhiteBalanceManager.java */
/* loaded from: classes.dex */
public class c8 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int[] f168;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final ColorSpaceTransform f169;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final RggbChannelVector f170;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String f171;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Range<Float> f172;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Range<Float> f173;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final float[] f174;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final float[] f175;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final float[] f176;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final float[] f177;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static ColorSpaceTransform f178;

    /* renamed from: ֏, reason: contains not printable characters */
    public static RggbChannelVector f179;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static float f180;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static float f181;

    /* renamed from: ހ, reason: contains not printable characters */
    public static float f182;

    /* renamed from: ށ, reason: contains not printable characters */
    public static float f183;

    /* renamed from: ނ, reason: contains not printable characters */
    public static int f184;

    /* renamed from: ރ, reason: contains not printable characters */
    public static int f185;

    static {
        int[] iArr = {1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1};
        f168 = iArr;
        ColorSpaceTransform colorSpaceTransform = new ColorSpaceTransform(iArr);
        f169 = colorSpaceTransform;
        RggbChannelVector rggbChannelVector = new RggbChannelVector(2.0f, 1.0f, 1.0f, 2.0f);
        f170 = rggbChannelVector;
        f171 = c8.class.getCanonicalName();
        f172 = new Range<>(Float.valueOf(2000.0f), Float.valueOf(8000.0f));
        f173 = new Range<>(Float.valueOf(-50.0f), Float.valueOf(50.0f));
        f174 = new float[]{0.0f, 127.5f, 0.0f};
        f175 = new float[]{255.0f, 127.5f, 255.0f};
        f176 = new float[]{255.0f, 127.5f, 0.0f};
        f177 = new float[]{0.0f, 127.5f, 255.0f};
        f178 = colorSpaceTransform;
        f179 = rggbChannelVector;
        f180 = 0.5f;
        f181 = 0.5f;
        f182 = 1.0f;
        f183 = 3.0f;
        f184 = 5000;
        f185 = 0;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static RggbChannelVector m192() {
        return f179;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static ColorSpaceTransform m193() {
        return f178;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float m194(float f, float f2, float f3) {
        float fAbs = Math.abs(f - f2) * f3;
        return f > f2 ? f - fAbs : f + fAbs;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static float[] m195(float[] fArr, float[] fArr2, float f) {
        return new float[]{m194(fArr[0], fArr2[0], f), m194(fArr[1], fArr2[1], f), m194(fArr[2], fArr2[2], f)};
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int[] m196(float f, float f2) {
        float f3 = ((f - 1.0f) / 2.0f) * 255.0f;
        float f4 = ((f2 - 1.0f) / 2.0f) * 255.0f;
        return new int[]{(int) (((((((f3 - f4) / 2.0f) * 2.0f) / 255.0f) + 0.5f) * 6000.0f) + 2000.0f), (int) (((((((f3 + f4) / 2.0f) * 2.0f) / 255.0f) - 0.5f) * 100.0f) - 50.0f)};
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static float m197(float f, float f2, float f3, float f4, float f5) {
        return ((f4 - f3) * ((f5 - f) / (f2 - f))) + f3;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m198(float f, float f2) {
        float[] fArrM195 = m195(m195(f177, f176, f), m195(f174, f175, f2), 0.5f);
        float fM197 = m197(0.0f, 255.0f, 1.0f, 3.0f, fArrM195[0]);
        float fM1972 = m197(0.0f, 255.0f, 1.0f, 3.0f, fArrM195[1]) / 2.0f;
        f179 = new RggbChannelVector(fM197, fM1972, fM1972, m197(0.0f, 255.0f, 1.0f, 3.0f, fArrM195[2]));
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static void m199(ColorSpaceTransform colorSpaceTransform) {
        f178 = colorSpaceTransform;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m200(int i, int i2) {
        String str = f171;
        C4638.m14099(str, String.format("temp : %s , tint : %s ", Integer.valueOf(i), Integer.valueOf(i2)));
        f184 = i;
        f185 = i2;
        Range<Float> range = f172;
        f180 = (i - ((Float) range.getLower()).floatValue()) / (((Float) range.getUpper()).floatValue() - ((Float) range.getLower()).floatValue());
        float f = i2;
        Range<Float> range2 = f173;
        f181 = (f - ((Float) range2.getLower()).floatValue()) / (((Float) range2.getUpper()).floatValue() - ((Float) range2.getLower()).floatValue());
        C4638.m14099(str, String.format("colorTemperature : %s , colorTint : %s ", Float.valueOf(f180), Float.valueOf(f181)));
        m198(f180, f181);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int[] m201(RggbChannelVector rggbChannelVector) {
        return m196(rggbChannelVector.getRed(), rggbChannelVector.getBlue());
    }
}
