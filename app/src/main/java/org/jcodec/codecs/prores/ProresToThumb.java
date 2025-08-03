package org.jcodec.codecs.prores;

import androidx.core.view.PointerIconCompat;
import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class ProresToThumb extends ProresDecoder {
    private void _putChroma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + i3 + ((i4 << 1) * i2);
        int i9 = i8;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            bArr[i9] = (byte) (MathUtil.clip((iArr[i10] + 2) >> 2, 1, 255) - 128);
            int i12 = i9 + i2;
            bArr[i12] = (byte) (MathUtil.clip((iArr[i10 + 1] + 2) >> 2, 1, 255) - 128);
            i9 = i12 + (1 - i2);
            i10 += 2;
        }
        if (bArr2 != null) {
            int i13 = 0;
            for (int i14 = 0; i14 < i5; i14++) {
                bArr2[i8] = (byte) (MathUtil.clip(iArr[i13], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i13] + 2) >> 2, 1, 255) << 2));
                int i15 = i8 + i2;
                int i16 = i13 + 1;
                bArr2[i15] = (byte) (MathUtil.clip(iArr[i16], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i16] + 2) >> 2, 1, 255) << 2));
                i8 = i15 + (1 - i2);
                i13 += 2;
            }
        }
    }

    private void _putLuma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 1) + ((i4 << 1) * i2);
        int i9 = i8;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            bArr[i9] = (byte) (MathUtil.clip((iArr[i10] + 2) >> 2, 1, 255) - 128);
            bArr[i9 + 1] = (byte) (MathUtil.clip((iArr[i10 + 1] + 2) >> 2, 1, 255) - 128);
            int i12 = i9 + i2;
            bArr[i12] = (byte) (MathUtil.clip((iArr[i10 + 2] + 2) >> 2, 1, 255) - 128);
            bArr[i12 + 1] = (byte) (MathUtil.clip((iArr[i10 + 3] + 2) >> 2, 1, 255) - 128);
            i9 = i12 + (2 - i2);
            i10 += 4;
        }
        if (bArr2 != null) {
            int i13 = 0;
            for (int i14 = 0; i14 < i5; i14++) {
                bArr2[i8] = (byte) (MathUtil.clip(iArr[i13], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i13] + 2) >> 2, 1, 255) << 2));
                int i15 = i13 + 1;
                bArr2[i8 + 1] = (byte) (MathUtil.clip(iArr[i15], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i15] + 2) >> 2, 1, 255) << 2));
                int i16 = i8 + i2;
                int i17 = i13 + 2;
                bArr2[i16] = (byte) (MathUtil.clip(iArr[i17], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i17] + 2) >> 2, 1, 255) << 2));
                int i18 = i13 + 3;
                bArr2[i16 + 1] = (byte) (MathUtil.clip(iArr[i18], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i18] + 2) >> 2, 1, 255) << 2));
                i8 = i16 + (2 - i2);
                i13 += 4;
            }
        }
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public Picture decodeFrameHiBD(ByteBuffer byteBuffer, byte[][] bArr, byte[][] bArr2) {
        ProresConsts.FrameHeader frameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        int i = ((frameHeader.width + 15) & (-16)) >> 3;
        int i2 = ((frameHeader.height + 15) & (-16)) >> 3;
        int i3 = i * i2;
        int i4 = i3 >> 1;
        if (bArr == null || bArr[0].length < i3 || bArr[1].length < i4 || bArr[2].length < i4) {
            throw new RuntimeException("Provided output picture won't fit into provided buffer");
        }
        if (frameHeader.frameType == 0) {
            decodePicture(byteBuffer, bArr, bArr2, i, i2, i >> 1, frameHeader.qMatLuma, frameHeader.qMatChroma, new int[]{0}, 0, frameHeader.chromaType);
        } else {
            int i5 = i2 >> 1;
            int i6 = i >> 1;
            decodePicture(byteBuffer, bArr, bArr2, i, i5, i6, frameHeader.qMatLuma, frameHeader.qMatChroma, new int[]{0}, frameHeader.topFieldFirst ? 1 : 2, frameHeader.chromaType);
            decodePicture(byteBuffer, bArr, bArr2, i, i5, i6, frameHeader.qMatLuma, frameHeader.qMatChroma, new int[]{0}, frameHeader.topFieldFirst ? 2 : 1, frameHeader.chromaType);
        }
        ColorSpace colorSpace = frameHeader.chromaType == 2 ? ColorSpace.YUV422 : ColorSpace.YUV444;
        return new Picture(i, i2, bArr, bArr2, colorSpace, bArr2 == null ? 0 : 2, new Rect(0, 0, (frameHeader.width >> 3) & colorSpace.getWidthMask(), (frameHeader.height >> 3) & colorSpace.getHeightMask()));
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public void decodeOnePlane(BitReader bitReader, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        try {
            ProresDecoder.readDCCoeffs(bitReader, iArr2, iArr, i, 1);
        } catch (RuntimeException unused) {
            System.err.println("Suppressing slice error at [" + i2 + ", " + i3 + "].");
        }
        for (int i5 = 0; i5 < i; i5++) {
            iArr[i5] = iArr[i5] >> 3;
        }
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public void putSlice(byte[][] bArr, byte[][] bArr2, int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int i4, int i5, int i6, int i7) {
        int i8 = i >> 1;
        int i9 = i5 * i;
        int i10 = i << i4;
        _putLuma(bArr[0], bArr2 != null ? bArr2[0] : null, i9, i10, i2, i3, iArr, i7, i4, i5);
        if (i6 != 2) {
            _putLuma(bArr[1], bArr2 != null ? bArr2[1] : null, i9, i10, i2, i3, iArr2, i7, i4, i5);
            _putLuma(bArr[2], bArr2 != null ? bArr2[2] : null, i9, i10, i2, i3, iArr3, i7, i4, i5);
        } else {
            int i11 = i5 * i8;
            int i12 = i8 << i4;
            _putChroma(bArr[1], bArr2 != null ? bArr2[1] : null, i11, i12, i2, i3, iArr2, i7, i4, i5);
            _putChroma(bArr[2], bArr2 != null ? bArr2[2] : null, i11, i12, i2, i3, iArr3, i7, i4, i5);
        }
    }
}
