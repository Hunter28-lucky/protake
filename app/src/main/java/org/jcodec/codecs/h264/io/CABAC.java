package org.jcodec.codecs.h264.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import java.lang.reflect.Array;
import org.jcodec.codecs.common.biari.MDecoder;
import org.jcodec.codecs.common.biari.MEncoder;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils2;
import org.jcodec.codecs.h264.decode.CABACContst;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mps.MPSUtils;

/* loaded from: classes2.dex */
public class CABAC {
    private int[] chromaPredModeTop;
    private int[][] codedBlkDCTop;
    private int[][] codedBlkTop;
    private int[][][] mvdLeft;
    private int[][][] mvdTop;
    private int prevCBP;
    private int prevMbQpDelta;
    private int[][] refIdxLeft;
    private int[][] refIdxTop;
    private boolean skipFlagLeft;
    private boolean[] skipFlagsTop;
    public int[] tmp = new int[16];
    private int chromaPredModeLeft = 0;
    private int[][] codedBlkLeft = {new int[4], new int[2], new int[2]};
    private int[] codedBlkDCLeft = new int[3];

    public static final class BlockType {
        public int codedBlockCtxOff;
        public int coeffAbsLevelAdjust;
        public int coeffAbsLevelCtxOff;
        public int lastSigCoeffCtxOff;
        public int lastSigCoeffFldCtxOff;
        public int sigCoeffFlagCtxOff;
        public int sigCoeffFlagFldCtxOff;
        public static final BlockType LUMA_16_DC = new BlockType(85, 105, 166, 277, 338, JpegConst.APP3, 0);
        public static final BlockType LUMA_15_AC = new BlockType(89, 120, MPEGConst.EXTENSION_START_CODE, 292, 353, JpegConst.APPD, 0);
        public static final BlockType LUMA_16 = new BlockType(93, 134, JpegConst.SOF3, 306, 367, 247, 0);
        public static final BlockType CHROMA_DC = new BlockType(97, 149, JpegConst.RST2, 321, 382, 257, 1);
        public static final BlockType CHROMA_AC = new BlockType(101, 152, JpegConst.RST5, 324, 385, 266, 0);
        public static final BlockType LUMA_64 = new BlockType(PointerIconCompat.TYPE_NO_DROP, TypedValues.CycleType.TYPE_VISIBILITY, 417, 436, 451, 426, 0);
        public static final BlockType CB_16_DC = new BlockType(460, 484, 572, 776, 864, 952, 0);
        public static final BlockType CB_15x16_AC = new BlockType(464, 499, 587, 791, 879, 962, 0);
        public static final BlockType CB_16 = new BlockType(468, InputDeviceCompat.SOURCE_DPAD, 601, 805, 893, 972, 0);
        public static final BlockType CB_64 = new BlockType(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, 660, 690, 675, 699, 708, 0);
        public static final BlockType CR_16_DC = new BlockType(472, 528, 616, 820, 908, 982, 0);
        public static final BlockType CR_15x16_AC = new BlockType(476, 543, 631, 835, 923, 992, 0);
        public static final BlockType CR_16 = new BlockType(MPSUtils.VIDEO_MIN, 557, 645, 849, 937, 1002, 0);
        public static final BlockType CR_64 = new BlockType(PointerIconCompat.TYPE_GRAB, 718, 748, 733, 757, 766, 0);

        private BlockType(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.codedBlockCtxOff = i;
            this.sigCoeffFlagCtxOff = i2;
            this.lastSigCoeffCtxOff = i3;
            this.sigCoeffFlagFldCtxOff = i4;
            this.lastSigCoeffFldCtxOff = i4;
            this.coeffAbsLevelCtxOff = i6;
            this.coeffAbsLevelAdjust = i7;
        }
    }

    public CABAC(int i) {
        this.chromaPredModeTop = new int[i];
        int i2 = i << 2;
        int i3 = i << 1;
        this.codedBlkTop = new int[][]{new int[i2], new int[i3], new int[i3]};
        Class cls = Integer.TYPE;
        this.codedBlkDCTop = (int[][]) Array.newInstance((Class<?>) cls, 3, i);
        this.refIdxLeft = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
        this.refIdxTop = (int[][]) Array.newInstance((Class<?>) cls, 2, i2);
        this.skipFlagsTop = new boolean[i];
        this.mvdTop = (int[][][]) Array.newInstance((Class<?>) cls, 2, 2, i2);
        this.mvdLeft = (int[][][]) Array.newInstance((Class<?>) cls, 2, 2, 4);
    }

    private int _condTerm(boolean z, MBType mBType, int i) {
        return (!z || mBType == MBType.I_PCM || (mBType != null && i == 1)) ? 0 : 1;
    }

    private boolean cbp(int i, int i2, int i3) {
        return ((i >> ((i3 & 2) + (i2 >> 1))) & 1) == 1;
    }

    private int condTermCr0(boolean z, MBType mBType, int i) {
        return (!z || (mBType != MBType.I_PCM && (mBType == null || i == 0))) ? 0 : 1;
    }

    private int condTermCr1(boolean z, MBType mBType, int i) {
        return (!z || (mBType != MBType.I_PCM && (mBType == null || (i & 2) == 0))) ? 0 : 1;
    }

    private int readCoeffAbsLevel(MDecoder mDecoder, BlockType blockType, int i, int i2) {
        int iDecodeBinBypass = 0;
        int iMin = i != 0 ? 0 : Math.min(4, i2 + 1);
        int iMin2 = Math.min(4 - blockType.coeffAbsLevelAdjust, i) + 5;
        int iDecodeBin = mDecoder.decodeBin(blockType.coeffAbsLevelCtxOff + iMin);
        int i3 = 0;
        while (iDecodeBin != 0 && i3 < 13) {
            iDecodeBin = mDecoder.decodeBin(blockType.coeffAbsLevelCtxOff + iMin2);
            i3++;
        }
        int i4 = i3 + iDecodeBin;
        if (i4 != 14) {
            return i4;
        }
        int i5 = -2;
        do {
            i5++;
        } while (mDecoder.decodeBinBypass() != 0);
        int i6 = 0;
        while (i5 >= 0) {
            iDecodeBinBypass |= mDecoder.decodeBinBypass() << i5;
            i6 += 1 << i5;
            i5--;
        }
        return i4 + iDecodeBinBypass + i6;
    }

    private int readIntraP(MDecoder mDecoder, int i) {
        if (mDecoder.decodeBin(i) == 0) {
            return 0;
        }
        if (mDecoder.decodeFinalBin() == 1) {
            return 25;
        }
        return readMBType16x16P(mDecoder, i) + 1;
    }

    private int readMBType16x16(MDecoder mDecoder) {
        int iDecodeBin = mDecoder.decodeBin(6) * 12;
        return mDecoder.decodeBin(7) == 0 ? iDecodeBin + (mDecoder.decodeBin(9) << 1) + mDecoder.decodeBin(10) : iDecodeBin + (mDecoder.decodeBin(8) << 2) + (mDecoder.decodeBin(9) << 1) + mDecoder.decodeBin(10) + 4;
    }

    private int readMBType16x16P(MDecoder mDecoder, int i) {
        int i2 = i + 1;
        int iDecodeBin = mDecoder.decodeBin(i2) * 12;
        int i3 = i2 + 1;
        if (mDecoder.decodeBin(i3) == 0) {
            int i4 = i3 + 1;
            return iDecodeBin + (mDecoder.decodeBin(i4) << 1) + mDecoder.decodeBin(i4);
        }
        int iDecodeBin2 = iDecodeBin + (mDecoder.decodeBin(i3) << 2);
        int i5 = i3 + 1;
        return iDecodeBin2 + (mDecoder.decodeBin(i5) << 1) + mDecoder.decodeBin(i5) + 4;
    }

    private void writeCoeffAbsLevel(MEncoder mEncoder, BlockType blockType, int i, int i2, int i3) {
        int iMin = i != 0 ? 0 : Math.min(4, i2 + 1);
        int iMin2 = Math.min(4 - blockType.coeffAbsLevelAdjust, i) + 5;
        if (i3 == 0) {
            mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + iMin, 0);
            return;
        }
        mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + iMin, 1);
        if (i3 < 14) {
            for (int i4 = 1; i4 < i3; i4++) {
                mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + iMin2, 1);
            }
            mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + iMin2, 0);
            return;
        }
        for (int i5 = 1; i5 < 14; i5++) {
            mEncoder.encodeBin(blockType.coeffAbsLevelCtxOff + iMin2, 1);
        }
        int i6 = i3 - 14;
        int i7 = 0;
        int i8 = 1;
        while (i6 >= i8) {
            mEncoder.encodeBinBypass(1);
            i6 -= i8;
            i7++;
            i8 = 1 << i7;
        }
        mEncoder.encodeBinBypass(0);
        while (true) {
            i7--;
            if (i7 < 0) {
                return;
            } else {
                mEncoder.encodeBinBypass((i6 >> i7) & 1);
            }
        }
    }

    private void writeMBType16x16(MEncoder mEncoder, int i) {
        if (i < 12) {
            mEncoder.encodeBin(6, 0);
        } else {
            mEncoder.encodeBin(6, 1);
            i -= 12;
        }
        if (i < 4) {
            mEncoder.encodeBin(7, 0);
            mEncoder.encodeBin(9, i >> 1);
            mEncoder.encodeBin(10, i & 1);
        } else {
            int i2 = i - 4;
            mEncoder.encodeBin(7, 1);
            mEncoder.encodeBin(8, i2 >> 2);
            mEncoder.encodeBin(9, (i2 >> 1) & 1);
            mEncoder.encodeBin(10, i2 & 1);
        }
    }

    public int codedBlockPatternIntra(MDecoder mDecoder, boolean z, boolean z2, int i, int i2, MBType mBType, MBType mBType2) {
        int iDecodeBin = mDecoder.decodeBin(_condTerm(z, mBType, (i >> 1) & 1) + 73 + (_condTerm(z2, mBType2, (i2 >> 2) & 1) * 2));
        int i3 = 1 - iDecodeBin;
        int iDecodeBin2 = mDecoder.decodeBin(i3 + 73 + (_condTerm(z2, mBType2, (i2 >> 3) & 1) * 2));
        int iDecodeBin3 = mDecoder.decodeBin(_condTerm(z, mBType, (i >> 3) & 1) + 73 + (i3 * 2));
        int iDecodeBin4 = mDecoder.decodeBin((1 - iDecodeBin3) + 73 + ((1 - iDecodeBin2) * 2));
        int i4 = i >> 4;
        int i5 = i2 >> 4;
        int iDecodeBin5 = mDecoder.decodeBin(condTermCr0(z, mBType, i4) + 77 + (condTermCr0(z2, mBType2, i5) * 2));
        return ((iDecodeBin5 != 0 ? mDecoder.decodeBin((condTermCr1(z, mBType, i4) + 81) + (condTermCr1(z2, mBType2, i5) * 2)) : 0) << 5) | (iDecodeBin2 << 1) | iDecodeBin | (iDecodeBin3 << 2) | (iDecodeBin4 << 3) | (iDecodeBin5 << 4);
    }

    public int condTerm(MBType mBType, boolean z, MBType mBType2, boolean z2, int i) {
        if (!z) {
            return mBType.isIntra() ? 1 : 0;
        }
        if (mBType2 == MBType.I_PCM) {
            return 1;
        }
        if (z2) {
            return i;
        }
        return 0;
    }

    public void initModels(int[][] iArr, SliceType sliceType, int i, int i2) {
        int[] iArr2 = sliceType.isIntra() ? CABACContst.cabac_context_init_I_A : CABACContst.cabac_context_init_PB_A[i];
        int[] iArr3 = sliceType.isIntra() ? CABACContst.cabac_context_init_I_B : CABACContst.cabac_context_init_PB_B[i];
        for (int i3 = 0; i3 < 1024; i3++) {
            int iClip = MathUtil.clip(((iArr2[i3] * MathUtil.clip(i2, 0, 51)) >> 4) + iArr3[i3], 1, 126);
            if (iClip <= 63) {
                iArr[0][i3] = 63 - iClip;
                iArr[1][i3] = 0;
            } else {
                iArr[0][i3] = iClip - 64;
                iArr[1][i3] = 1;
            }
        }
    }

    public boolean prev4x4PredModeFlag(MDecoder mDecoder) {
        return mDecoder.decodeBin(68) == 1;
    }

    public int readCodedBlockFlagChromaAC(MDecoder mDecoder, int i, int i2, int i3, MBType mBType, MBType mBType2, boolean z, boolean z2, int i4, int i5, MBType mBType3) {
        int iCondTerm;
        int iCondTerm2;
        int i6 = i2 & 1;
        if ((i & 1) == 0) {
            iCondTerm = condTerm(mBType3, z, mBType, (mBType == null || mBType == MBType.I_PCM || (i4 & 2) == 0) ? false : true, this.codedBlkLeft[i3][i6]);
        } else {
            iCondTerm = condTerm(mBType3, true, mBType3, true, this.codedBlkLeft[i3][i6]);
        }
        int i7 = iCondTerm;
        if (i6 == 0) {
            iCondTerm2 = condTerm(mBType3, z2, mBType2, (mBType2 == null || mBType2 == MBType.I_PCM || (i5 & 2) == 0) ? false : true, this.codedBlkTop[i3][i]);
        } else {
            iCondTerm2 = condTerm(mBType3, true, mBType3, true, this.codedBlkTop[i3][i]);
        }
        int iDecodeBin = mDecoder.decodeBin(BlockType.CHROMA_AC.codedBlockCtxOff + i7 + (iCondTerm2 * 2));
        this.codedBlkLeft[i3][i6] = iDecodeBin;
        this.codedBlkTop[i3][i] = iDecodeBin;
        return iDecodeBin;
    }

    public int readCodedBlockFlagChromaDC(MDecoder mDecoder, int i, int i2, MBType mBType, MBType mBType2, boolean z, boolean z2, int i3, int i4, MBType mBType3) {
        int iDecodeBin = mDecoder.decodeBin(BlockType.CHROMA_DC.codedBlockCtxOff + condTerm(mBType3, z, mBType, (mBType == null || i3 == 0) ? false : true, this.codedBlkDCLeft[i2]) + (condTerm(mBType3, z2, mBType2, (mBType2 == null || i4 == 0) ? false : true, this.codedBlkDCTop[i2][i]) * 2));
        this.codedBlkDCLeft[i2] = iDecodeBin;
        this.codedBlkDCTop[i2][i] = iDecodeBin;
        return iDecodeBin;
    }

    public int readCodedBlockFlagLuma64(MDecoder mDecoder, int i, int i2, int i3, MBType mBType, MBType mBType2, boolean z, boolean z2, int i4, int i5, int i6, MBType mBType3, boolean z3, boolean z4) {
        int iCondTerm;
        int iCondTerm2;
        int i7 = i & 3;
        int i8 = i2 & 3;
        if (i7 == 0) {
            iCondTerm = condTerm(mBType3, z, mBType, mBType != null && mBType != MBType.I_PCM && z3 && cbp(i4, 3, i8), this.codedBlkLeft[i3][i8]);
        } else {
            iCondTerm = condTerm(mBType3, true, mBType3, cbp(i6, i7 - 1, i8), this.codedBlkLeft[i3][i8]);
        }
        int i9 = iCondTerm;
        if (i8 == 0) {
            iCondTerm2 = condTerm(mBType3, z2, mBType2, mBType2 != null && mBType2 != MBType.I_PCM && z4 && cbp(i5, i7, 3), this.codedBlkTop[i3][i]);
        } else {
            iCondTerm2 = condTerm(mBType3, true, mBType3, cbp(i6, i7, i8 - 1), this.codedBlkTop[i3][i]);
        }
        int iDecodeBin = mDecoder.decodeBin(BlockType.LUMA_64.codedBlockCtxOff + i9 + (iCondTerm2 * 2));
        this.codedBlkLeft[i3][i8] = iDecodeBin;
        this.codedBlkTop[i3][i] = iDecodeBin;
        return iDecodeBin;
    }

    public int readCodedBlockFlagLumaAC(MDecoder mDecoder, BlockType blockType, int i, int i2, int i3, MBType mBType, MBType mBType2, boolean z, boolean z2, int i4, int i5, int i6, MBType mBType3) {
        int iCondTerm;
        int iCondTerm2;
        int i7 = i & 3;
        int i8 = i2 & 3;
        if (i7 == 0) {
            iCondTerm = condTerm(mBType3, z, mBType, (mBType == null || mBType == MBType.I_PCM || !cbp(i4, 3, i8)) ? false : true, this.codedBlkLeft[i3][i8]);
        } else {
            iCondTerm = condTerm(mBType3, true, mBType3, cbp(i6, i7 - 1, i8), this.codedBlkLeft[i3][i8]);
        }
        int i9 = iCondTerm;
        if (i8 == 0) {
            iCondTerm2 = condTerm(mBType3, z2, mBType2, (mBType2 == null || mBType2 == MBType.I_PCM || !cbp(i5, i7, 3)) ? false : true, this.codedBlkTop[i3][i]);
        } else {
            iCondTerm2 = condTerm(mBType3, true, mBType3, cbp(i6, i7, i8 - 1), this.codedBlkTop[i3][i]);
        }
        int iDecodeBin = mDecoder.decodeBin(blockType.codedBlockCtxOff + i9 + (iCondTerm2 * 2));
        this.codedBlkLeft[i3][i8] = iDecodeBin;
        this.codedBlkTop[i3][i] = iDecodeBin;
        return iDecodeBin;
    }

    public int readCodedBlockFlagLumaDC(MDecoder mDecoder, int i, MBType mBType, MBType mBType2, boolean z, boolean z2, MBType mBType3) {
        MBType mBType4 = MBType.I_16x16;
        int iDecodeBin = mDecoder.decodeBin(BlockType.LUMA_16_DC.codedBlockCtxOff + condTerm(mBType3, z, mBType, mBType == mBType4, this.codedBlkDCLeft[0]) + (condTerm(mBType3, z2, mBType2, mBType2 == mBType4, this.codedBlkDCTop[0][i]) * 2));
        this.codedBlkDCLeft[0] = iDecodeBin;
        this.codedBlkDCTop[0][i] = iDecodeBin;
        return iDecodeBin;
    }

    public int readCoeffs(MDecoder mDecoder, BlockType blockType, int[] iArr, int i, int i2, int[] iArr2, int[] iArr3, int[] iArr4) {
        boolean[] zArr = new boolean[i2];
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2 - 1) {
            boolean z = mDecoder.decodeBin(blockType.sigCoeffFlagCtxOff + iArr3[i4]) == 1;
            zArr[i4] = z;
            if (z && mDecoder.decodeBin(blockType.lastSigCoeffCtxOff + iArr4[i4]) == 1) {
                break;
            }
            i4++;
        }
        zArr[i4] = true;
        int i5 = 0;
        for (int i6 = (i4 + 1) - 1; i6 >= 0; i6--) {
            if (zArr[i6]) {
                int coeffAbsLevel = readCoeffAbsLevel(mDecoder, blockType, i3, i5);
                if (coeffAbsLevel == 0) {
                    i5++;
                } else {
                    i3++;
                }
                iArr[iArr2[i6 + i]] = MathUtil.toSigned(coeffAbsLevel + 1, -mDecoder.decodeBinBypass());
            }
        }
        return i3 + i5;
    }

    public int readIntraChromaPredMode(MDecoder mDecoder, int i, MBType mBType, MBType mBType2, boolean z, boolean z2) {
        int i2 = 1;
        if (mDecoder.decodeBin(64 + ((!z || mBType == null || !mBType.isIntra() || this.chromaPredModeLeft == 0) ? 0 : 1) + ((!z2 || mBType2 == null || !mBType2.isIntra() || this.chromaPredModeTop[i] == 0) ? 0 : 1)) == 0) {
            i2 = 0;
        } else if (mDecoder.decodeBin(67) != 0) {
            i2 = mDecoder.decodeBin(67) == 0 ? 2 : 3;
        }
        this.chromaPredModeTop[i] = i2;
        this.chromaPredModeLeft = i2;
        return i2;
    }

    public int readMBQpDelta(MDecoder mDecoder, MBType mBType) {
        int i = 0;
        if (mDecoder.decodeBin(60 + ((mBType == null || mBType == MBType.I_PCM || (mBType != MBType.I_16x16 && this.prevCBP == 0) || this.prevMbQpDelta == 0) ? 0 : 1)) == 1) {
            if (mDecoder.decodeBin(62) == 1) {
                i = 2;
                while (mDecoder.decodeBin(63) == 1) {
                    i++;
                }
            } else {
                i = 1;
            }
        }
        int iGolomb2Signed = H264Utils2.golomb2Signed(i);
        this.prevMbQpDelta = iGolomb2Signed;
        return iGolomb2Signed;
    }

    public boolean readMBSkipFlag(MDecoder mDecoder, SliceType sliceType, boolean z, boolean z2, int i) {
        boolean z3 = mDecoder.decodeBin(((sliceType == SliceType.P ? 11 : 24) + ((!z || this.skipFlagLeft) ? 0 : 1)) + ((!z2 || this.skipFlagsTop[i]) ? 0 : 1)) == 1;
        this.skipFlagsTop[i] = z3;
        this.skipFlagLeft = z3;
        return z3;
    }

    public int readMBTypeB(MDecoder mDecoder, MBType mBType, MBType mBType2, boolean z, boolean z2) {
        if (mDecoder.decodeBin(27 + ((!z || mBType == null || mBType == MBType.B_Direct_16x16) ? 0 : 1) + ((!z2 || mBType2 == null || mBType2 == MBType.B_Direct_16x16) ? 0 : 1)) == 0) {
            return 0;
        }
        if (mDecoder.decodeBin(30) == 0) {
            return mDecoder.decodeBin(32) + 1;
        }
        if (mDecoder.decodeBin(31) == 0) {
            return (mDecoder.decodeBin(32) | (mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << 1)) + 3;
        }
        if (mDecoder.decodeBin(32) == 0) {
            return (mDecoder.decodeBin(32) | (mDecoder.decodeBin(32) << 2) | (mDecoder.decodeBin(32) << 1)) + 12;
        }
        int iDecodeBin = (mDecoder.decodeBin(32) << 1) + mDecoder.decodeBin(32);
        if (iDecodeBin == 0) {
            return mDecoder.decodeBin(32) + 20;
        }
        if (iDecodeBin == 1) {
            return readIntraP(mDecoder, 32) + 23;
        }
        if (iDecodeBin != 2) {
            return iDecodeBin != 3 ? 0 : 22;
        }
        return 11;
    }

    public int readMBTypeI(MDecoder mDecoder, MBType mBType, MBType mBType2, boolean z, boolean z2) {
        if (mDecoder.decodeBin(3 + ((!z || mBType == MBType.I_NxN) ? 0 : 1) + ((!z2 || mBType2 == MBType.I_NxN) ? 0 : 1)) == 0) {
            return 0;
        }
        if (mDecoder.decodeFinalBin() == 1) {
            return 25;
        }
        return readMBType16x16(mDecoder) + 1;
    }

    public int readMBTypeP(MDecoder mDecoder) {
        return mDecoder.decodeBin(14) == 1 ? readIntraP(mDecoder, 17) + 5 : mDecoder.decodeBin(15) == 0 ? mDecoder.decodeBin(16) == 0 ? 0 : 3 : mDecoder.decodeBin(17) == 0 ? 2 : 1;
    }

    public int readMVD(MDecoder mDecoder, int i, boolean z, boolean z2, MBType mBType, MBType mBType2, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i2, int i3, int i4, int i5, int i6, int i7) {
        H264Const.PartPred partPred4;
        H264Const.PartPred partPred5;
        int i8 = i == 0 ? 40 : 47;
        int i9 = 2;
        int i10 = (i2 << 2) + i3;
        int iAbs = ((!z || mBType == null || mBType.isIntra() || !(partPred != null && partPred != H264Const.PartPred.Direct && (partPred == (partPred5 = H264Const.PartPred.Bi) || partPred == partPred3 || (partPred3 == partPred5 && H264Const.usesList(partPred, i7))))) ? 0 : Math.abs(this.mvdLeft[i7][i][i4])) + ((!z2 || mBType2 == null || mBType2.isIntra() || !(partPred2 != null && partPred2 != H264Const.PartPred.Direct && (partPred2 == (partPred4 = H264Const.PartPred.Bi) || partPred2 == partPred3 || (partPred3 == partPred4 && H264Const.usesList(partPred2, i7))))) ? 0 : Math.abs(this.mvdTop[i7][i][i10]));
        int iDecodeBin = mDecoder.decodeBin((iAbs < 3 ? 0 : iAbs > 32 ? 2 : 1) + i8);
        int i11 = 0;
        while (iDecodeBin != 0 && i11 < 8) {
            iDecodeBin = mDecoder.decodeBin(Math.min(i8 + i11 + 3, i8 + 6));
            i11++;
        }
        int signed = i11 + iDecodeBin;
        if (signed != 0) {
            if (signed == 9) {
                int i12 = 0;
                int i13 = 0;
                while (true) {
                    i12 += i13;
                    i9++;
                    int i14 = 1 << i9;
                    if (mDecoder.decodeBinBypass() == 0) {
                        break;
                    }
                    i13 = i14;
                }
                int iDecodeBinBypass = 0;
                for (int i15 = i9 - 1; i15 >= 0; i15--) {
                    iDecodeBinBypass |= mDecoder.decodeBinBypass() << i15;
                }
                signed += iDecodeBinBypass + i12;
            }
            signed = MathUtil.toSigned(signed, -mDecoder.decodeBinBypass());
        }
        for (int i16 = 0; i16 < i5; i16++) {
            this.mvdTop[i7][i][i10 + i16] = signed;
        }
        for (int i17 = 0; i17 < i6; i17++) {
            this.mvdLeft[i7][i][i4 + i17] = signed;
        }
        return signed;
    }

    public int readRefIdx(MDecoder mDecoder, boolean z, boolean z2, MBType mBType, MBType mBType2, H264Const.PartPred partPred, H264Const.PartPred partPred2, H264Const.PartPred partPred3, int i, int i2, int i3, int i4, int i5, int i6) {
        H264Const.PartPred partPred4;
        H264Const.PartPred partPred5;
        int i7 = 2;
        int i8 = (i << 2) + i2;
        int i9 = 1;
        if (mDecoder.decodeBin(((!z || mBType == null || mBType.isIntra() || !(partPred != null && partPred != H264Const.PartPred.Direct && (partPred == (partPred5 = H264Const.PartPred.Bi) || partPred == partPred3 || (partPred3 == partPred5 && H264Const.usesList(partPred, i6)))) || this.refIdxLeft[i6][i3] == 0) ? 0 : 1) + 54 + (((!z2 || mBType2 == null || mBType2.isIntra() || !(partPred2 != null && partPred2 != H264Const.PartPred.Direct && (partPred2 == (partPred4 = H264Const.PartPred.Bi) || partPred2 == partPred3 || (partPred3 == partPred4 && H264Const.usesList(partPred2, i6)))) || this.refIdxTop[i6][i8] == 0) ? 0 : 1) * 2)) == 0) {
            i9 = 0;
        } else if (mDecoder.decodeBin(58) != 0) {
            while (mDecoder.decodeBin(59) == 1) {
                i7++;
            }
            i9 = i7;
        }
        for (int i10 = 0; i10 < i4; i10++) {
            this.refIdxTop[i6][i8 + i10] = i9;
        }
        for (int i11 = 0; i11 < i5; i11++) {
            this.refIdxLeft[i6][i3 + i11] = i9;
        }
        return i9;
    }

    public int readSubMbTypeB(MDecoder mDecoder) {
        int iDecodeBin;
        int iDecodeBin2;
        if (mDecoder.decodeBin(36) == 0) {
            return 0;
        }
        if (mDecoder.decodeBin(37) == 0) {
            return mDecoder.decodeBin(39) + 1;
        }
        if (mDecoder.decodeBin(38) == 0) {
            iDecodeBin = (mDecoder.decodeBin(39) << 1) + 3;
            iDecodeBin2 = mDecoder.decodeBin(39);
        } else {
            if (mDecoder.decodeBin(39) != 0) {
                return mDecoder.decodeBin(39) + 11;
            }
            iDecodeBin = (mDecoder.decodeBin(39) << 1) + 7;
            iDecodeBin2 = mDecoder.decodeBin(39);
        }
        return iDecodeBin + iDecodeBin2;
    }

    public int readSubMbTypeP(MDecoder mDecoder) {
        if (mDecoder.decodeBin(21) == 1) {
            return 0;
        }
        if (mDecoder.decodeBin(22) == 0) {
            return 1;
        }
        return mDecoder.decodeBin(23) == 1 ? 2 : 3;
    }

    public boolean readTransform8x8Flag(MDecoder mDecoder, boolean z, boolean z2, MBType mBType, MBType mBType2, boolean z3, boolean z4) {
        return mDecoder.decodeBin((399 + ((!z || mBType == null || !z3) ? 0 : 1)) + ((!z2 || mBType2 == null || !z4) ? 0 : 1)) == 1;
    }

    public int rem4x4PredMode(MDecoder mDecoder) {
        return (mDecoder.decodeBin(69) << 2) | mDecoder.decodeBin(69) | (mDecoder.decodeBin(69) << 1);
    }

    public void setCodedBlock(int i, int i2) {
        this.codedBlkTop[0][i] = 1;
        this.codedBlkLeft[0][i2 & 3] = 1;
    }

    public void setPrevCBP(int i) {
        this.prevCBP = i;
    }

    public void writeCoeffs(MEncoder mEncoder, BlockType blockType, int[] iArr, int i, int i2, int[] iArr2) {
        for (int i3 = 0; i3 < i2; i3++) {
            this.tmp[i3] = iArr[iArr2[i + i3]];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (this.tmp[i5] != 0) {
                i4 = i5 + 1;
            }
        }
        int i6 = 0;
        while (true) {
            if (i6 >= Math.min(i4, i2 - 1)) {
                break;
            }
            if (this.tmp[i6] != 0) {
                mEncoder.encodeBin(blockType.sigCoeffFlagCtxOff + i6, 1);
                mEncoder.encodeBin(blockType.lastSigCoeffCtxOff + i6, i6 != i4 + (-1) ? 0 : 1);
            } else {
                mEncoder.encodeBin(blockType.sigCoeffFlagCtxOff + i6, 0);
            }
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i4 - 1; i9 >= 0; i9--) {
            int i10 = this.tmp[i9];
            if (i10 != 0) {
                int iAbs = MathUtil.abs(i10) - 1;
                writeCoeffAbsLevel(mEncoder, blockType, i7, i8, iAbs);
                if (iAbs == 0) {
                    i8++;
                } else {
                    i7++;
                }
                mEncoder.encodeBinBypass(MathUtil.sign(this.tmp[i9]));
            }
        }
    }

    public void writeIntraChromaPredMode(MEncoder mEncoder, int i, MBType mBType, MBType mBType2, boolean z, boolean z2, int i2) {
        int i3 = 64 + ((z && mBType.isIntra() && this.chromaPredModeLeft != 0) ? 1 : 0) + ((z2 && mBType2.isIntra() && this.chromaPredModeTop[i] != 0) ? 1 : 0);
        int i4 = i2 - 1;
        mEncoder.encodeBin(i3, i2 == 0 ? 0 : 1);
        int i5 = 0;
        while (i4 >= 0 && i5 < 2) {
            int i6 = i4 - 1;
            mEncoder.encodeBin(67, i4 == 0 ? 0 : 1);
            i5++;
            i4 = i6;
        }
        this.chromaPredModeTop[i] = i4;
        this.chromaPredModeLeft = i4;
    }

    public void writeMBQpDelta(MEncoder mEncoder, MBType mBType, int i) {
        int i2 = 60 + ((mBType == null || mBType == MBType.I_PCM || (mBType != MBType.I_16x16 && this.prevCBP == 0) || this.prevMbQpDelta == 0) ? 0 : 1);
        this.prevMbQpDelta = i;
        int i3 = i - 1;
        if (i == 0) {
            mEncoder.encodeBin(i2, 0);
            return;
        }
        mEncoder.encodeBin(i2, 1);
        int i4 = i3 - 1;
        if (i3 == 0) {
            mEncoder.encodeBin(62, 0);
            return;
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                mEncoder.encodeBin(63, 0);
                return;
            } else {
                mEncoder.encodeBin(63, 1);
                i4 = i5;
            }
        }
    }

    public void writeMBTypeI(MEncoder mEncoder, MBType mBType, MBType mBType2, boolean z, boolean z2, int i) {
        int i2 = 3 + ((!z || mBType == MBType.I_NxN) ? 0 : 1) + ((!z2 || mBType2 == MBType.I_NxN) ? 0 : 1);
        if (i == 0) {
            mEncoder.encodeBin(i2, 0);
            return;
        }
        mEncoder.encodeBin(i2, 1);
        if (i == 25) {
            mEncoder.encodeBinFinal(1);
        } else {
            mEncoder.encodeBinFinal(0);
            writeMBType16x16(mEncoder, i - 1);
        }
    }
}
