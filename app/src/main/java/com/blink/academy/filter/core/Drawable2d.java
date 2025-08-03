package com.blink.academy.filter.core;

import defpackage.C3624;
import defpackage.C4625;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class Drawable2d {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final float[] f5046;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final float[] f5047;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final FloatBuffer f5048;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final FloatBuffer f5049;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final float[] f5050;

    /* renamed from: ހ, reason: contains not printable characters */
    public static final float[] f5051;

    /* renamed from: ށ, reason: contains not printable characters */
    public static final FloatBuffer f5052;

    /* renamed from: ނ, reason: contains not printable characters */
    public static final FloatBuffer f5053;

    /* renamed from: ރ, reason: contains not printable characters */
    public static final float[] f5054;

    /* renamed from: ބ, reason: contains not printable characters */
    public static final float[] f5055;

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final float[] f5056;

    /* renamed from: ކ, reason: contains not printable characters */
    public static final float[] f5057;

    /* renamed from: އ, reason: contains not printable characters */
    public static final FloatBuffer f5058;

    /* renamed from: ވ, reason: contains not printable characters */
    public static final FloatBuffer f5059;

    /* renamed from: މ, reason: contains not printable characters */
    public static final FloatBuffer f5060;

    /* renamed from: ފ, reason: contains not printable characters */
    public static final FloatBuffer f5061;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float[] f5062;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float[] f5063;

    /* renamed from: ԩ, reason: contains not printable characters */
    public FloatBuffer f5064;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public FloatBuffer f5065;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f5066;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f5067;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f5068;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f5069;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Prefab f5070;

    public enum Prefab {
        f5071,
        f5072,
        f5073,
        f5074,
        f5075
    }

    /* renamed from: com.blink.academy.filter.core.Drawable2d$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C1787 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f5077;

        static {
            int[] iArr = new int[Prefab.values().length];
            f5077 = iArr;
            try {
                iArr[Prefab.f5071.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5077[Prefab.f5072.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5077[Prefab.f5073.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5077[Prefab.f5074.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5077[Prefab.f5075.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f5046 = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f5047 = fArr2;
        f5048 = C3624.m11698(fArr);
        f5049 = C3624.m11698(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        f5050 = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f5051 = fArr4;
        f5052 = C3624.m11698(fArr3);
        f5053 = C3624.m11698(fArr4);
        float[] fArr5 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f5054 = fArr5;
        float[] fArr6 = {-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
        f5055 = fArr6;
        float[] fArr7 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f5056 = fArr7;
        float[] fArr8 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f5057 = fArr8;
        f5058 = C3624.m11698(fArr5);
        f5059 = C3624.m11698(fArr6);
        f5060 = C3624.m11698(fArr7);
        f5061 = C3624.m11698(fArr8);
    }

    public Drawable2d() {
        this(Prefab.f5073);
    }

    public Drawable2d(Prefab prefab) {
        int length;
        int i = C1787.f5077[prefab.ordinal()];
        if (i == 1) {
            this.f5064 = f5048;
            this.f5065 = f5049;
            this.f5067 = 2;
            this.f5068 = 8;
            length = f5046.length;
        } else if (i == 2) {
            this.f5064 = f5052;
            this.f5065 = f5053;
            this.f5067 = 2;
            this.f5068 = 8;
            length = f5050.length;
        } else if (i == 3) {
            float[] fArr = f5054;
            this.f5062 = fArr;
            this.f5064 = f5058;
            this.f5063 = f5056;
            this.f5065 = f5060;
            this.f5067 = 2;
            this.f5068 = 8;
            length = fArr.length;
        } else if (i == 4) {
            float[] fArr2 = f5054;
            this.f5062 = fArr2;
            this.f5064 = f5058;
            this.f5063 = f5057;
            this.f5065 = f5061;
            this.f5067 = 2;
            this.f5068 = 8;
            length = fArr2.length;
        } else {
            if (i != 5) {
                throw new RuntimeException(C4625.m14082("GwEGAT8FAVQSAwRCVhM=") + prefab);
            }
            this.f5062 = f5055;
            this.f5064 = f5059;
            this.f5063 = f5057;
            this.f5065 = f5061;
            this.f5067 = 2;
            this.f5068 = 8;
            length = f5054.length;
        }
        this.f5066 = length / 2;
        this.f5069 = 8;
        this.f5070 = prefab;
    }

    public String toString() {
        if (this.f5070 == null) {
            return C4625.m14082("FSsfDicTDRgEWQEIEx0dYDI=");
        }
        return C4625.m14082("FSsfDicTDRgEWQEIEw==") + this.f5070 + C4625.m14082("Ew==");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m4774() {
        return this.f5067;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public FloatBuffer m4775() {
        return this.f5065;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m4776() {
        return this.f5069;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public FloatBuffer m4777() {
        return this.f5064;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m4778() {
        return this.f5066;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m4779() {
        return this.f5068;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4780(float[] fArr) {
        this.f5065 = C3624.m11698(fArr);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m4781(float[] fArr) {
        this.f5064 = C3624.m11698(fArr);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m4782(int i) {
        this.f5066 = i;
    }
}
