package org.jcodec.codecs.prores;

import androidx.core.view.PointerIconCompat;
import java.nio.ByteBuffer;
import org.jcodec.codecs.prores.ProresConsts;
import org.jcodec.common.dct.IDCT4x4;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Picture;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class ProresToThumb4x4 extends ProresDecoder {
    public static int[] progressive_scan_4x4 = {0, 1, 4, 5, 2, 3, 6, 7, 8, 9, 12, 13, 11, 12, 14, 15};
    public static int[] interlaced_scan_4x4 = {0, 4, 1, 5, 8, 12, 9, 13, 2, 6, 3, 7, 10, 14, 11, 15};
    private static final int[] srcIncLuma = {4, 4, 4, 20, 4, 4, 4, 20};

    private void _putChroma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 2) + ((i4 << 3) * i2);
        int i9 = i8;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i5) {
            int i12 = i9;
            for (int i13 = 0; i13 < 8; i13++) {
                for (int i14 = 0; i14 < 4; i14++) {
                    bArr[i12 + i14] = (byte) (MathUtil.clip((iArr[i11 + i14] + 2) >> 2, 1, 255) - 128);
                }
                i11 += 4;
                i12 += i2;
            }
            i10++;
            i9 += 4;
        }
        if (bArr2 != null) {
            int i15 = 0;
            int i16 = 0;
            while (i15 < i5) {
                int i17 = i8;
                for (int i18 = 0; i18 < 8; i18++) {
                    for (int i19 = 0; i19 < 4; i19++) {
                        int i20 = i16 + i19;
                        bArr2[i17 + i19] = (byte) (MathUtil.clip(iArr[i20], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i20] + 2) >> 2, 1, 255) << 2));
                    }
                    i16 += 4;
                    i17 += i2;
                }
                i15++;
                i8 += 4;
            }
        }
    }

    private void _putLuma(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int[] iArr, int i5, int i6, int i7) {
        int i8 = i + (i3 << 3) + ((i4 << 3) * i2);
        int i9 = i8;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i5) {
            int i12 = i9;
            for (int i13 = 0; i13 < 8; i13++) {
                for (int i14 = 0; i14 < 4; i14++) {
                    bArr[i12 + i14] = (byte) (MathUtil.clip((iArr[i11 + i14] + 2) >> 2, 1, 255) - 128);
                }
                for (int i15 = 4; i15 < 8; i15++) {
                    bArr[i12 + i15] = (byte) (MathUtil.clip((iArr[(i11 + i15) + 12] + 2) >> 2, 1, 255) - 128);
                }
                i11 += srcIncLuma[i13];
                i12 += i2;
            }
            i10++;
            i9 += 8;
        }
        if (bArr2 != null) {
            int i16 = 0;
            int i17 = 0;
            while (i16 < i5) {
                int i18 = i8;
                for (int i19 = 0; i19 < 4; i19++) {
                    for (int i20 = 0; i20 < 4; i20++) {
                        int i21 = i17 + i20;
                        bArr2[i18 + i20] = (byte) (MathUtil.clip(iArr[i21], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i21] + 2) >> 2, 1, 255) << 2));
                    }
                    for (int i22 = 4; i22 < 8; i22++) {
                        int i23 = i17 + i22;
                        bArr2[i18 + i22] = (byte) (MathUtil.clip(iArr[i23 + 12], 4, PointerIconCompat.TYPE_ZOOM_OUT) - (MathUtil.clip((iArr[i23] + 2) >> 2, 1, 255) << 2));
                    }
                    i17 += srcIncLuma[i19];
                    i18 += i2;
                }
                i16++;
                i8 += 8;
            }
        }
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public Picture decodeFrameHiBD(ByteBuffer byteBuffer, byte[][] bArr, byte[][] bArr2) {
        int i;
        ProresConsts.FrameHeader frameHeader = ProresDecoder.readFrameHeader(byteBuffer);
        int i2 = ((frameHeader.width + 15) & (-16)) >> 1;
        int i3 = ((frameHeader.height + 15) & (-16)) >> 1;
        int i4 = i2 * i3;
        int i5 = i4 >> 1;
        if (bArr == null || bArr[0].length < i4 || bArr[1].length < i5 || bArr[2].length < i5) {
            throw new RuntimeException("Provided output picture won't fit into provided buffer");
        }
        if (frameHeader.frameType == 0) {
            i = 2;
            decodePicture(byteBuffer, bArr, bArr2, i2, i3, i2 >> 3, frameHeader.qMatLuma, frameHeader.qMatChroma, progressive_scan_4x4, 0, frameHeader.chromaType);
        } else {
            i = 2;
            int i6 = i3 >> 1;
            int i7 = i2 >> 3;
            decodePicture(byteBuffer, bArr, bArr2, i2, i6, i7, frameHeader.qMatLuma, frameHeader.qMatChroma, interlaced_scan_4x4, frameHeader.topFieldFirst ? 1 : 2, frameHeader.chromaType);
            decodePicture(byteBuffer, bArr, bArr2, i2, i6, i7, frameHeader.qMatLuma, frameHeader.qMatChroma, interlaced_scan_4x4, frameHeader.topFieldFirst ? 2 : 1, frameHeader.chromaType);
        }
        ColorSpace colorSpace = frameHeader.chromaType == i ? ColorSpace.YUV422 : ColorSpace.YUV444;
        return new Picture(i2, i3, bArr, bArr2, colorSpace, bArr2 == null ? 0 : i, new Rect(0, 0, (frameHeader.width >> 1) & colorSpace.getWidthMask(), (frameHeader.height >> 1) & colorSpace.getHeightMask()));
    }

    @Override // org.jcodec.codecs.prores.ProresDecoder
    public void decodeOnePlane(BitReader bitReader, int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int i3, int i4) {
        ProresDecoder.readDCCoeffs(bitReader, iArr2, iArr, i, 16);
        ProresDecoder.readACCoeffs(bitReader, iArr2, iArr, i, iArr3, 16, 4);
        for (int i5 = 0; i5 < i; i5++) {
            IDCT4x4.idct(iArr, i5 << 4);
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
