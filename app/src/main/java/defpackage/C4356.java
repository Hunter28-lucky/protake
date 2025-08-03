package defpackage;

import java.lang.reflect.Array;

/* compiled from: FFT.java */
/* renamed from: પ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4356 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final float[][] f14911 = {new float[]{1.0f, -0.0f}, new float[]{0.99879545f, -0.049067676f}, new float[]{0.9951847f, -0.09801714f}, new float[]{0.9891765f, -0.14673047f}, new float[]{0.98078525f, -0.19509032f}, new float[]{0.97003126f, -0.24298018f}, new float[]{0.95694035f, -0.29028466f}, new float[]{0.94154406f, -0.33688986f}, new float[]{0.9238795f, -0.38268343f}, new float[]{0.9039893f, -0.42755508f}, new float[]{0.8819213f, -0.47139674f}, new float[]{0.8577286f, -0.51410276f}, new float[]{0.8314696f, -0.55557024f}, new float[]{0.8032075f, -0.5956993f}, new float[]{0.77301043f, -0.6343933f}, new float[]{0.7409511f, -0.671559f}, new float[]{0.70710677f, -0.70710677f}, new float[]{0.671559f, -0.7409511f}, new float[]{0.6343933f, -0.77301043f}, new float[]{0.5956993f, -0.8032075f}, new float[]{0.55557024f, -0.8314696f}, new float[]{0.51410276f, -0.8577286f}, new float[]{0.47139674f, -0.8819213f}, new float[]{0.42755508f, -0.9039893f}, new float[]{0.38268343f, -0.9238795f}, new float[]{0.33688986f, -0.94154406f}, new float[]{0.29028466f, -0.95694035f}, new float[]{0.24298018f, -0.97003126f}, new float[]{0.19509032f, -0.98078525f}, new float[]{0.14673047f, -0.9891765f}, new float[]{0.09801714f, -0.9951847f}, new float[]{0.049067676f, -0.99879545f}, new float[]{6.123234E-17f, -1.0f}, new float[]{-0.049067676f, -0.99879545f}, new float[]{-0.09801714f, -0.9951847f}, new float[]{-0.14673047f, -0.9891765f}, new float[]{-0.19509032f, -0.98078525f}, new float[]{-0.24298018f, -0.97003126f}, new float[]{-0.29028466f, -0.95694035f}, new float[]{-0.33688986f, -0.94154406f}, new float[]{-0.38268343f, -0.9238795f}, new float[]{-0.42755508f, -0.9039893f}, new float[]{-0.47139674f, -0.8819213f}, new float[]{-0.51410276f, -0.8577286f}, new float[]{-0.55557024f, -0.8314696f}, new float[]{-0.5956993f, -0.8032075f}, new float[]{-0.6343933f, -0.77301043f}, new float[]{-0.671559f, -0.7409511f}, new float[]{-0.70710677f, -0.70710677f}, new float[]{-0.7409511f, -0.671559f}, new float[]{-0.77301043f, -0.6343933f}, new float[]{-0.8032075f, -0.5956993f}, new float[]{-0.8314696f, -0.55557024f}, new float[]{-0.8577286f, -0.51410276f}, new float[]{-0.8819213f, -0.47139674f}, new float[]{-0.9039893f, -0.42755508f}, new float[]{-0.9238795f, -0.38268343f}, new float[]{-0.94154406f, -0.33688986f}, new float[]{-0.95694035f, -0.29028466f}, new float[]{-0.97003126f, -0.24298018f}, new float[]{-0.98078525f, -0.19509032f}, new float[]{-0.9891765f, -0.14673047f}, new float[]{-0.9951847f, -0.09801714f}, new float[]{-0.99879545f, -0.049067676f}};

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final float[][] f14912 = {new float[]{1.0f, -0.0f}, new float[]{0.9238795f, -0.38268343f}, new float[]{0.70710677f, -0.70710677f}, new float[]{0.38268343f, -0.9238795f}, new float[]{6.123234E-17f, -1.0f}, new float[]{-0.38268343f, -0.9238795f}, new float[]{-0.70710677f, -0.70710677f}, new float[]{-0.9238795f, -0.38268343f}};

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m13511(float[][] fArr, int i) {
        int iRound = (int) Math.round(Math.log(i) / Math.log(2.0d));
        float[][] fArr2 = i == 128 ? f14911 : f14912;
        int i2 = 2;
        float[][] fArr3 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            float[] fArr4 = fArr3[i4];
            float[] fArr5 = fArr[i3];
            fArr4[0] = fArr5[0];
            fArr4[1] = fArr5[1];
            int i5 = i >> 1;
            while (i3 >= i5 && i5 > 0) {
                i3 -= i5;
                i5 >>= 1;
            }
            i3 += i5;
        }
        for (int i6 = 0; i6 < i; i6++) {
            float[] fArr6 = fArr[i6];
            float[] fArr7 = fArr3[i6];
            fArr6[0] = fArr7[0];
            fArr6[1] = fArr7[1];
        }
        int i7 = i / 2;
        float[] fArr8 = new float[2];
        for (int i8 = 0; i8 < iRound; i8++) {
            int i9 = i2 / 2;
            int i10 = 0;
            int i11 = i9;
            for (int i12 = 0; i12 < i7; i12++) {
                int i13 = 0;
                for (int i14 = 0; i14 < i9; i14++) {
                    float[] fArr9 = fArr[i11];
                    float f = fArr9[0];
                    float[] fArr10 = fArr2[i13];
                    float f2 = f * fArr10[0];
                    float f3 = fArr9[1];
                    float f4 = fArr10[1];
                    float f5 = f2 - (f3 * f4);
                    fArr8[0] = f5;
                    float f6 = (fArr9[0] * f4) + (f3 * fArr10[0]);
                    fArr8[1] = f6;
                    float[] fArr11 = fArr[i10];
                    fArr9[0] = fArr11[0] - f5;
                    fArr9[1] = fArr11[1] - f6;
                    fArr11[0] = fArr11[0] + fArr8[0];
                    fArr11[1] = fArr11[1] + fArr8[1];
                    i13 += i7;
                    i10++;
                    i11++;
                }
                i10 += i9;
                i11 += i9;
            }
            i7 /= 2;
            i2 *= 2;
        }
    }
}
