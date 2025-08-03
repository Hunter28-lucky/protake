package org.jcodec.codecs.mpeg12;

/* loaded from: classes2.dex */
public class MPEGPredQuad extends MPEGPredOct {
    public MPEGPredQuad(MPEGPred mPEGPred) {
        super(mPEGPred);
    }

    @Override // org.jcodec.codecs.mpeg12.MPEGPredOct, org.jcodec.codecs.mpeg12.MPEGPred
    public void predictPlane(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, int i10) {
        super.predictPlane(bArr, i, i2, i3, i4, i5, i6, iArr, i7, i8 << 1, i9 << 1, i10);
    }
}
