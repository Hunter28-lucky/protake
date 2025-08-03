package org.jcodec.codecs.prores;

import androidx.core.view.PointerIconCompat;
import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.dct.IDCT2x2;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class ProresToThumb2x2 extends ProresDecoder {
    private void _putChroma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 1) + ((i4 << 2) * i2);
        int i9 = i8;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            int i12 = 0;
            int i13 = i9;
            while (i12 < 4) {
                int iClip = MathUtil.clip((iArr[i10] + 2) >> 2, 1, 255);
                int iClip2 = MathUtil.clip((iArr[i10 + 1] + 2) >> 2, 1, 255);
                bArr[i13] = (byte) (iClip - 128);
                bArr[i13 + 1] = (byte) (iClip2 - 128);
                i12++;
                i13 += i2;
                i10 += 2;
            }
            i9 += 2;
        }
        if (bArr2 != null) {
            int i14 = 0;
            for (int i15 = 0; i15 < i5; i15++) {
                int i16 = i8;
                int i17 = 0;
                while (i17 < 4) {
                    int iClip3 = MathUtil.clip(iArr[i14], 4, PointerIconCompat.TYPE_ZOOM_OUT);
                    int i18 = i14 + 1;
                    int iClip4 = MathUtil.clip(iArr[i18], 4, PointerIconCompat.TYPE_ZOOM_OUT);
                    int iClip5 = MathUtil.clip((iArr[i14] + 2) >> 2, 1, 255);
                    int iClip6 = MathUtil.clip((iArr[i18] + 2) >> 2, 1, 255);
                    bArr2[i16] = (byte) (iClip3 - (iClip5 << 2));
                    bArr2[i16 + 1] = (byte) (iClip4 - (iClip6 << 2));
                    i17++;
                    i16 += i2;
                    i14 += 2;
                }
                i8 += 2;
            }
        }
    }

    private void _putLuma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 2) + ((i4 << 2) * i2);
        int i9 = i2 * 3;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            putGroup(bArr, bArr2, i8, iArr, i10);
            int i12 = i8 + i2;
            putGroup(bArr, bArr2, i12, iArr, i10 + 2);
            int i13 = i12 + i2;
            putGroup(bArr, bArr2, i13, iArr, i10 + 8);
            int i14 = i13 + i2;
            putGroup(bArr, bArr2, i14, iArr, i10 + 10);
            i8 = i14 + (4 - i9);
            i10 += 16;
        }
    }

    private void putGroup(byte[] bArr, byte[] bArr2, int i, int[] iArr, int i2) {
        int iClip = MathUtil.clip((iArr[i2] + 2) >> 2, 1, 255);
        int i3 = i2 + 1;
        int iClip2 = MathUtil.clip((iArr[i3] + 2) >> 2, 1, 255);
        int i4 = i2 + 4;
        int iClip3 = MathUtil.clip((iArr[i4] + 2) >> 2, 1, 255);
        int i5 = i2 + 5;
        int iClip4 = MathUtil.clip((iArr[i5] + 2) >> 2, 1, 255);
        bArr[i] = (byte) (iClip - 128);
        int i6 = i + 1;
        bArr[i6] = (byte) (iClip2 - 128);
        int i7 = i + 2;
        bArr[i7] = (byte) (iClip3 - 128);
        int i8 = i + 3;
        bArr[i8] = (byte) (iClip4 - 128);
        if (bArr2 != null) {
            int iClip5 = MathUtil.clip(iArr[i2], 4, PointerIconCompat.TYPE_ZOOM_OUT);
            int iClip6 = MathUtil.clip(iArr[i3], 4, PointerIconCompat.TYPE_ZOOM_OUT);
            int iClip7 = MathUtil.clip(iArr[i4], 4, PointerIconCompat.TYPE_ZOOM_OUT);
            int iClip8 = MathUtil.clip(iArr[i5], 4, PointerIconCompat.TYPE_ZOOM_OUT);
            bArr2[i] = (byte) (iClip5 - (iClip << 2));
            bArr2[i6] = (byte) (iClip6 - (iClip2 << 2));
            bArr2[i7] = (byte) (iClip7 - (iClip3 << 2));
            bArr2[i8] = (byte) (iClip8 - (iClip4 << 2));
        }
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public Picture decodeFrameHiBD(ByteBuffer byteBuffer, byte[][] bArr, byte[][] bArr2) {
        ProresConsts.FrameHeader frameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        int i = ((frameHeader.width + 15) & (-16)) >> 2;
        int i2 = ((frameHeader.height + 15) & (-16)) >> 2;
        int i3 = i * i2;
        int i4 = i3 >> 1;
        if (bArr == null || bArr[0].length < i3 || bArr[1].length < i4 || bArr[2].length < i4) {
            throw new RuntimeException("Provided output picture won't fit into provided buffer");
        }
        if (frameHeader.frameType == 0) {
            decodePicture(byteBuffer, bArr, bArr2, i, i2, i >> 2, frameHeader.qMatLuma, frameHeader.qMatChroma, new int[]{0, 1, 2, 3}, 0, frameHeader.chromaType);
        } else {
            int i5 = i2 >> 1;
            int i6 = i >> 2;
            decodePicture(byteBuffer, bArr, bArr2, i, i5, i6, frameHeader.qMatLuma, frameHeader.qMatChroma, new int[]{0, 2, 1, 3}, frameHeader.topFieldFirst ? 1 : 2, frameHeader.chromaType);
            decodePicture(byteBuffer, bArr, bArr2, i, i5, i6, frameHeader.qMatLuma, frameHeader.qMatChroma, new int[]{0, 2, 1, 3}, frameHeader.topFieldFirst ? 2 : 1, frameHeader.chromaType);
        }
        ColorSpace colorSpace = frameHeader.chromaType == 2 ? ColorSpace.YUV422 : ColorSpace.YUV444;
        return new Picture(i, i2, bArr, bArr2, colorSpace, bArr2 == null ? 0 : 2, new Rect(0, 0, (frameHeader.width >> 2) & colorSpace.getWidthMask(), (frameHeader.height >> 2) & colorSpace.getHeightMask()));
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public void decodeOnePlane(BitReader bitReader, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        ProresDecoder.readDCCoeffs(bitReader, iArr2, iArr, i, 4);
        ProresDecoder.readACCoeffs(bitReader, iArr2, iArr, i, iArr3, 4, 2);
        for (int i5 = 0; i5 < i; i5++) {
            IDCT2x2.idct(iArr, i5 << 2);
        }
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public void putSlice(byte[][] bArr, byte[][] bArr2, int i, int i2, int i3, int[] iArr, int[] iArr2, int[] iArr3, int i4, int i5, int i6, int i7) {
        int i8 = i >> 1;
        int i9 = i5 * i;
        int i10 = i << i4;
        _putLuma(bArr[0], bArr2 == null ? null : bArr2[0], i9, i10, i2, i3, iArr, i7, i4, i5);
        if (i6 != 2) {
            _putLuma(bArr[1], bArr2 == null ? null : bArr2[1], i9, i10, i2, i3, iArr2, i7, i4, i5);
            _putLuma(bArr[2], bArr2 == null ? null : bArr2[2], i9, i10, i2, i3, iArr3, i7, i4, i5);
        } else {
            int i11 = i5 * i8;
            int i12 = i8 << i4;
            _putChroma(bArr[1], bArr2 == null ? null : bArr2[1], i11, i12, i2, i3, iArr2, i7, i4, i5);
            _putChroma(bArr[2], bArr2 == null ? null : bArr2[2], i11, i12, i2, i3, iArr3, i7, i4, i5);
        }
    }
}
