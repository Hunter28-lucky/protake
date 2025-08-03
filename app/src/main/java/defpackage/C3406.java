package defpackage;

import org.jcodec.codecs.vpx.vp9.Consts;

/* compiled from: DCT.java */
/* renamed from: ץ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3406 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final float[] f11747 = {1.0f, 0.98078525f, 0.9238795f, 0.8314696f, 0.70710677f, 0.5555702f, 0.3826834f, 0.19509028f, 0.0f, -0.19509037f, -0.3826835f, -0.5555703f, -0.7071068f, -0.83146966f, -0.92387956f, -0.9807853f};

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final float[] f11748 = {0.0f, -0.19509032f, -0.38268346f, -0.55557024f, -0.70710677f, -0.83146966f, -0.92387956f, -0.9807853f, -1.0f, -0.98078525f, -0.9238795f, -0.8314696f, -0.7071067f, -0.5555702f, -0.38268337f, -0.19509023f};

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final float[] f11749 = {0.9999247f, 0.9981181f, 0.993907f, 0.9873014f, 0.9783174f, 0.96697646f, 0.953306f, 0.937339f, 0.9191139f, 0.8986745f, 0.8760701f, 0.8513552f, 0.82458925f, 0.7958369f, 0.76516724f, 0.7326543f, 0.69837624f, 0.66241574f, 0.62485945f, 0.58579785f, 0.545325f, 0.5035384f, 0.46053872f, 0.41642955f, 0.37131715f, 0.32531023f, 0.2785196f, 0.23105814f, 0.18303989f, 0.13458069f, 0.08579727f, 0.036807165f, -1.0121963f, -1.0594388f, -1.1041292f, -1.1461595f, -1.1854287f, -1.2218422f, -1.255312f, -1.2857577f, -1.313106f, -1.3372908f, -1.3582538f, -1.3759449f, -1.390321f, -1.4013479f, -1.4089987f, -1.4132552f, -1.4141071f, -1.4115522f, -1.4055967f, -1.396255f, -1.3835497f, -1.3675113f, -1.3481784f, -1.3255975f, -1.2998233f, -1.2709177f, -1.2389501f, -1.2039981f, -1.1661453f, -1.1254834f, -1.0821099f, -1.0361296f, -0.9876532f, -0.9367974f, -0.88368475f, -0.8284433f, -0.771206f, -0.71211076f, -0.6513001f, -0.58892035f, -0.5251218f, -0.46005824f, -0.39388633f, -0.32676548f, -0.25885743f, -0.19032592f, -0.121335685f, -0.052053273f, 0.017354608f, 0.086720645f, 0.15587783f, 0.22465932f, 0.29289973f, 0.3604344f, 0.42710093f, 0.49273846f, 0.5571889f, 0.62029713f, 0.681911f, 0.74188185f, 0.8000656f, 0.856322f, 0.91051537f, 0.96251523f, 1.0f, 0.99879545f, 0.9951847f, 0.9891765f, 0.98078525f, 0.97003126f, 0.95694035f, 0.94154406f, 0.9238795f, 0.9039893f, 0.88192123f, 0.8577286f, 0.8314696f, 0.8032075f, 0.77301043f, 0.7409511f, 0.70710677f, 0.6715589f, 0.6343933f, 0.5956993f, 0.5555702f, 0.5141027f, 0.47139665f, 0.4275551f, 0.38268343f, 0.33688983f, 0.29028463f, 0.24298012f, 0.19509023f, 0.1467305f, 0.098017134f, 0.04906765f, -1.0f, -1.0478631f, -1.0932019f, -1.1359069f, -1.1758755f, -1.2130115f, -1.247225f, -1.2784339f, -1.3065629f, -1.3315444f, -1.353318f, -1.3718314f, -1.3870399f, -1.3989068f, -1.4074037f, -1.4125102f, 0.0f, -1.4125102f, -1.4074037f, -1.3989068f, -1.3870399f, -1.3718314f, -1.353318f, -1.3315444f, -1.3065629f, -1.2784339f, -1.247225f, -1.2130114f, -1.1758755f, -1.135907f, -1.0932019f, -1.0478631f, -1.0f, -0.9497278f, -0.89716756f, -0.842446f, -0.78569496f, -0.7270511f, -0.66665566f, -0.6046542f, -0.54119605f, -0.47643423f, -0.4105245f, -0.34362584f, -0.27589935f, -0.2075082f, -0.1386171f, -0.069392145f, 0.0f, 0.069392264f, 0.13861716f, 0.2075082f, 0.27589947f, 0.34362596f, 0.41052464f, 0.4764342f, 0.5411961f, 0.6046542f, 0.6666557f, 0.72705114f, 0.7856951f, 0.842446f, 0.89716756f, 0.9497278f};

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final int[] f11750 = {0, 16, 8, 24, 4, 20, 12, 28, 2, 18, 10, 26, 6, 22, 14, 30, 1, 17, 9, 25, 5, 21, 13, 29, 3, 19, 11, 27, 7, 23, 15, 31};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m11176(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        for (int i = 0; i < 32; i++) {
            float f = fArr[i];
            float f2 = fArr2[i];
            float[] fArr5 = f11749;
            float f3 = (f + f2) * fArr5[i];
            fArr[i] = (f2 * fArr5[i + 64]) + f3;
            fArr2[i] = (f * fArr5[i + 32]) + f3;
        }
        m11177(fArr, fArr2);
        for (int i2 = 0; i2 < 16; i2++) {
            int i3 = f11750[i2];
            float f4 = fArr[i3];
            float f5 = fArr2[i3];
            float[] fArr6 = f11749;
            float f6 = (f4 + f5) * fArr6[i2 + 96];
            fArr3[i2] = (f5 * fArr6[i2 + Consts.BORDERINPIXELS]) + f6;
            fArr4[i2] = (f4 * fArr6[i2 + 128]) + f6;
        }
        float f7 = fArr2[1];
        float f8 = fArr[1];
        float f9 = f11749[112];
        fArr4[16] = (f7 - f8) * f9;
        fArr3[16] = (f8 + f7) * f9;
        for (int i4 = 17; i4 < 32; i4++) {
            int i5 = f11750[i4];
            float f10 = fArr[i5];
            float f11 = fArr2[i5];
            float[] fArr7 = f11749;
            float f12 = (f10 + f11) * fArr7[i4 + 96];
            fArr3[i4] = (f11 * fArr7[i4 + Consts.BORDERINPIXELS]) + f12;
            fArr4[i4] = (f10 * fArr7[i4 + 128]) + f12;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m11177(float[] fArr, float[] fArr2) {
        int i;
        for (int i2 = 0; i2 < 16; i2++) {
            float f = fArr[i2];
            float f2 = fArr2[i2];
            int i3 = i2 + 16;
            float f3 = fArr[i3];
            float f4 = fArr2[i3];
            float f5 = f11747[i2];
            float f6 = f11748[i2];
            float f7 = f - f3;
            float f8 = f2 - f4;
            fArr[i2] = f + f3;
            fArr2[i2] = fArr2[i2] + f4;
            fArr[i3] = (f7 * f5) - (f8 * f6);
            fArr2[i3] = (f7 * f6) + (f8 * f5);
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= 8) {
                break;
            }
            float f9 = f11747[i5];
            float f10 = f11748[i5];
            float f11 = fArr[i4];
            float f12 = fArr2[i4];
            int i6 = i4 + 8;
            float f13 = fArr[i6];
            float f14 = fArr2[i6];
            float f15 = f11 - f13;
            float f16 = f12 - f14;
            fArr[i4] = f11 + f13;
            fArr2[i4] = fArr2[i4] + f14;
            fArr[i6] = (f15 * f9) - (f16 * f10);
            fArr2[i6] = (f15 * f10) + (f16 * f9);
            int i7 = i4 + 16;
            float f17 = fArr[i7];
            float f18 = fArr2[i7];
            int i8 = i7 + 8;
            float f19 = fArr[i8];
            float f20 = fArr2[i8];
            float f21 = f17 - f19;
            float f22 = f18 - f20;
            fArr[i7] = f17 + f19;
            fArr2[i7] = fArr2[i7] + f20;
            fArr[i8] = (f21 * f9) - (f22 * f10);
            fArr2[i8] = (f21 * f10) + (f22 * f9);
            i4++;
            i5 += 2;
        }
        for (int i9 = 0; i9 < 32; i9 += 8) {
            int i10 = i9 + 4;
            float f23 = fArr[i9];
            float f24 = fArr2[i9];
            float f25 = fArr[i10];
            float f26 = fArr2[i10];
            fArr[i9] = f23 + f25;
            fArr2[i9] = fArr2[i9] + f26;
            fArr[i10] = f23 - f25;
            fArr2[i10] = f24 - f26;
        }
        float f27 = f11747[4];
        for (int i11 = 1; i11 < 32; i11 += 8) {
            int i12 = i11 + 4;
            float f28 = fArr[i11];
            float f29 = fArr2[i11];
            float f30 = fArr[i12];
            float f31 = fArr2[i12];
            float f32 = f28 - f30;
            float f33 = f29 - f31;
            fArr[i11] = f28 + f30;
            fArr2[i11] = fArr2[i11] + f31;
            fArr[i12] = (f32 + f33) * f27;
            fArr2[i12] = (f33 - f32) * f27;
        }
        for (i = 2; i < 32; i += 8) {
            int i13 = i + 4;
            float f34 = fArr[i];
            float f35 = fArr2[i];
            float f36 = fArr[i13];
            float f37 = fArr2[i13];
            fArr[i] = f34 + f36;
            fArr2[i] = fArr2[i] + f37;
            fArr[i13] = f35 - f37;
            fArr2[i13] = f36 - f34;
        }
        float f38 = f11747[12];
        for (int i14 = 3; i14 < 32; i14 += 8) {
            int i15 = i14 + 4;
            float f39 = fArr[i14];
            float f40 = fArr2[i14];
            float f41 = fArr[i15];
            float f42 = fArr2[i15];
            float f43 = f39 - f41;
            float f44 = f40 - f42;
            fArr[i14] = f39 + f41;
            fArr2[i14] = fArr2[i14] + f42;
            fArr[i15] = (f43 - f44) * f38;
            fArr2[i15] = (f43 + f44) * f38;
        }
        for (int i16 = 0; i16 < 32; i16 += 4) {
            int i17 = i16 + 2;
            float f45 = fArr[i16];
            float f46 = fArr2[i16];
            float f47 = fArr[i17];
            float f48 = fArr2[i17];
            fArr[i16] = f45 + f47;
            fArr2[i16] = fArr2[i16] + f48;
            fArr[i17] = f45 - f47;
            fArr2[i17] = f46 - f48;
        }
        for (int i18 = 1; i18 < 32; i18 += 4) {
            int i19 = i18 + 2;
            float f49 = fArr[i18];
            float f50 = fArr2[i18];
            float f51 = fArr[i19];
            float f52 = fArr2[i19];
            fArr[i18] = f49 + f51;
            fArr2[i18] = fArr2[i18] + f52;
            fArr[i19] = f50 - f52;
            fArr2[i19] = f51 - f49;
        }
        for (int i20 = 0; i20 < 32; i20 += 2) {
            int i21 = i20 + 1;
            float f53 = fArr[i20];
            float f54 = fArr2[i20];
            float f55 = fArr[i21];
            float f56 = fArr2[i21];
            fArr[i20] = f53 + f55;
            fArr2[i20] = fArr2[i20] + f56;
            fArr[i21] = f53 - f55;
            fArr2[i21] = f54 - f56;
        }
    }
}
