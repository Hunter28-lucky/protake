package org.jcodec.codecs.mpa;

import java.lang.reflect.Array;

/* loaded from: classes2.dex */
class ChannelSynthesizer {
    private int current;
    private float scalefactor;
    private float[][] v = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 512);
    private int pos = 15;

    public ChannelSynthesizer(int i, float f) {
        this.scalefactor = f;
    }

    private static void distributeSamples(int i, float[] fArr, float[] fArr2, float[] fArr3) {
        for (int i2 = 0; i2 < 16; i2++) {
            fArr[(i2 << 4) + i] = fArr3[i2];
        }
        for (int i3 = 1; i3 < 17; i3++) {
            fArr2[(i3 << 4) + i] = fArr3[i3 + 15];
        }
        fArr[i + 256] = 0.0f;
        fArr2[i + 0] = -fArr3[0];
        for (int i4 = 0; i4 < 15; i4++) {
            fArr[(i4 << 4) + 272 + i] = -fArr3[15 - i4];
        }
        for (int i5 = 0; i5 < 15; i5++) {
            fArr2[(i5 << 4) + 272 + i] = fArr3[30 - i5];
        }
    }

    public void synthesize(float[] fArr, short[] sArr, int i) {
        MpaPqmf.computeButterfly(this.pos, fArr);
        int i2 = this.current;
        int i3 = (~i2) & 1;
        int i4 = this.pos;
        float[][] fArr2 = this.v;
        distributeSamples(i4, fArr2[i2], fArr2[i3], fArr);
        MpaPqmf.computeFilter(this.pos, this.v[this.current], sArr, i, this.scalefactor);
        this.pos = (this.pos + 1) & 15;
        this.current = i3;
    }
}
