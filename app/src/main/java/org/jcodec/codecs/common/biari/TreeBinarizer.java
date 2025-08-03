package org.jcodec.codecs.common.biari;

import java.io.IOException;

/* loaded from: classes2.dex */
public class TreeBinarizer {
    private Context[] models;

    public TreeBinarizer() {
        initContextModels();
    }

    private void initContextModels() {
        this.models = new Context[255];
        for (int i = 0; i < 255; i++) {
            this.models[i] = new Context(0, 0);
        }
    }

    public void binarize(int i, MQEncoder mQEncoder) throws IOException {
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = (i >> (7 - i5)) & 1;
            mQEncoder.encode(i6, this.models[i2]);
            i3 |= i6 << i5;
            i4 += 1 << i5;
            i2 = i4 + i3;
        }
    }

    public int debinarize(MQDecoder mQDecoder) throws IOException {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int iDecode = mQDecoder.decode(this.models[i2]);
            i |= iDecode << (7 - i5);
            i3 |= iDecode << i5;
            i4 += 1 << i5;
            i2 = i4 + i3;
        }
        return i;
    }
}
