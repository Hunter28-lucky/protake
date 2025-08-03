package org.jcodec.codecs.vpx;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Size;

/* loaded from: classes2.dex */
public class VP8Decoder extends VideoDecoder {
    private byte[][] segmentationMap;
    private int[] refLoopFilterDeltas = new int[4];
    private int[] modeLoopFilterDeltas = new int[4];

    public static class SegmentBasedAdjustments {
        private int abs;
        private int[] lf;
        private int[] qp;
        private int[] segmentProbs;

        public SegmentBasedAdjustments(int[] iArr, int[] iArr2, int[] iArr3, int i) {
            this.segmentProbs = iArr;
            this.qp = iArr2;
            this.lf = iArr3;
            this.abs = i;
        }
    }

    private int edgeEmu(int i, int i2, int i3) {
        if (i == 1) {
            if (i3 == 0) {
                return 0;
            }
            return i;
        }
        if (i != 2) {
            return i != 3 ? i : edgeEmuTm(i, i2, i3);
        }
        if (i2 == 0) {
            return 0;
        }
        return i;
    }

    private int edgeEmuTm(int i, int i2, int i3) {
        if (i2 == 0) {
            return i3 != 0 ? 1 : 0;
        }
        if (i3 != 0) {
            return i;
        }
        return 2;
    }

    public static String printHexByte(byte b) {
        return "0x" + Integer.toHexString(b & ExifInterface.MARKER);
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        return ((byteBuffer.get(3) & ExifInterface.MARKER) == 157 && (byteBuffer.get(4) & ExifInterface.MARKER) == 1 && (byteBuffer.get(5) & ExifInterface.MARKER) == 42) ? 100 : 0;
    }

    private SegmentBasedAdjustments updateSegmentation(VPXBooleanDecoder vPXBooleanDecoder) {
        int[] iArr;
        int bitEq;
        int bitEq2 = vPXBooleanDecoder.readBitEq();
        int[] iArr2 = null;
        if (vPXBooleanDecoder.readBitEq() != 0) {
            iArr2 = new int[4];
            iArr = new int[4];
            bitEq = vPXBooleanDecoder.readBitEq();
            for (int i = 0; i < 4; i++) {
                if (vPXBooleanDecoder.readBitEq() != 0) {
                    iArr2[i] = vPXBooleanDecoder.decodeInt(7);
                    iArr2[i] = vPXBooleanDecoder.readBitEq() != 0 ? -iArr2[i] : iArr2[i];
                }
            }
            for (int i2 = 0; i2 < 4; i2++) {
                if (vPXBooleanDecoder.readBitEq() != 0) {
                    iArr[i2] = vPXBooleanDecoder.decodeInt(6);
                    iArr[i2] = vPXBooleanDecoder.readBitEq() != 0 ? -iArr[i2] : iArr[i2];
                }
            }
        } else {
            iArr = null;
            bitEq = 0;
        }
        int[] iArr3 = new int[3];
        if (bitEq2 != 0) {
            for (int i3 = 0; i3 < 3; i3++) {
                if (vPXBooleanDecoder.readBitEq() != 0) {
                    iArr3[i3] = vPXBooleanDecoder.decodeInt(8);
                } else {
                    iArr3[i3] = 255;
                }
            }
        }
        return new SegmentBasedAdjustments(iArr3, iArr2, iArr, bitEq);
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x0392  */
    @Override // org.jcodec.common.VideoDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.jcodec.common.model.Picture decodeFrame(java.nio.ByteBuffer r39, byte[][] r40) {
        /*
            Method dump skipped, instructions count: 1091
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.VP8Decoder.decodeFrame(java.nio.ByteBuffer, byte[][]):org.jcodec.common.model.Picture");
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        NIOUtils.skip(byteBuffer, 6);
        return VideoCodecMeta.createSimpleVideoCodecMeta(new Size(((byteBuffer.get() & ExifInterface.MARKER) | ((byteBuffer.get() & ExifInterface.MARKER) << 8)) & 16383, (((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER)) & 16383), ColorSpace.YUV420);
    }
}
