package org.jcodec.codecs.mpa;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
class MpaHeader {
    public int bitrateIndex;
    public boolean copyright;
    public int frameBytes;
    public int framesize;
    public int intensityStereoBound;
    public int layer;
    public int mode;
    public int modeExtension;
    public int numSubbands;
    public boolean original;
    public int paddingBit;
    public int protectionBit;
    public int sampleFreq;
    public int version;

    public static void calculateFramesize(MpaHeader mpaHeader) {
        int i = mpaHeader.layer;
        if (i == 1) {
            int[][][] iArr = MpaConst.bitrates;
            int i2 = mpaHeader.version;
            int i3 = (iArr[i2][0][mpaHeader.bitrateIndex] * 12) / MpaConst.frequencies[i2][mpaHeader.sampleFreq];
            mpaHeader.framesize = i3;
            if (mpaHeader.paddingBit != 0) {
                mpaHeader.framesize = i3 + 1;
            }
            mpaHeader.framesize <<= 2;
            mpaHeader.frameBytes = 0;
        } else {
            int[][][] iArr2 = MpaConst.bitrates;
            int i4 = mpaHeader.version;
            int i5 = (iArr2[i4][i - 1][mpaHeader.bitrateIndex] * 144) / MpaConst.frequencies[i4][mpaHeader.sampleFreq];
            mpaHeader.framesize = i5;
            if (i4 == 0 || i4 == 2) {
                mpaHeader.framesize = i5 >> 1;
            }
            if (mpaHeader.paddingBit != 0) {
                mpaHeader.framesize++;
            }
            if (i == 3) {
                if (i4 == 1) {
                    mpaHeader.frameBytes = ((mpaHeader.framesize - (mpaHeader.mode != 3 ? 32 : 17)) - (mpaHeader.protectionBit != 0 ? 0 : 2)) - 4;
                } else {
                    mpaHeader.frameBytes = ((mpaHeader.framesize - (mpaHeader.mode == 3 ? 9 : 17)) - (mpaHeader.protectionBit != 0 ? 0 : 2)) - 4;
                }
            } else {
                mpaHeader.frameBytes = 0;
            }
        }
        mpaHeader.framesize -= 4;
    }

    public static MpaHeader read_header(ByteBuffer byteBuffer) {
        MpaHeader mpaHeader = new MpaHeader();
        int i = byteBuffer.getInt();
        int i2 = (i >>> 19) & 1;
        mpaHeader.version = i2;
        if (((i >>> 20) & 1) == 0) {
            if (i2 != 0) {
                throw new RuntimeException("UNKNOWN_ERROR");
            }
            mpaHeader.version = 2;
        }
        int i3 = (i >>> 10) & 3;
        mpaHeader.sampleFreq = i3;
        if (i3 == 3) {
            throw new RuntimeException("UNKNOWN_ERROR");
        }
        int i4 = (4 - (i >>> 17)) & 3;
        mpaHeader.layer = i4;
        mpaHeader.protectionBit = (i >>> 16) & 1;
        int i5 = (i >>> 12) & 15;
        mpaHeader.bitrateIndex = i5;
        mpaHeader.paddingBit = (i >>> 9) & 1;
        int i6 = (i >>> 6) & 3;
        mpaHeader.mode = i6;
        int i7 = (i >>> 4) & 3;
        mpaHeader.modeExtension = i7;
        if (i6 == 1) {
            mpaHeader.intensityStereoBound = (i7 << 2) + 4;
        } else {
            mpaHeader.intensityStereoBound = 0;
        }
        if (((i >>> 3) & 1) == 1) {
            mpaHeader.copyright = true;
        }
        if (((i >>> 2) & 1) == 1) {
            mpaHeader.original = true;
        }
        if (i4 == 1) {
            mpaHeader.numSubbands = 32;
        } else {
            if (i6 != 3) {
                i5 = i5 == 4 ? 1 : i5 - 4;
            }
            if (i5 == 1 || i5 == 2) {
                if (i3 == 2) {
                    mpaHeader.numSubbands = 12;
                } else {
                    mpaHeader.numSubbands = 8;
                }
            } else if (i3 == 1 || (i5 >= 3 && i5 <= 5)) {
                mpaHeader.numSubbands = 27;
            } else {
                mpaHeader.numSubbands = 30;
            }
        }
        int i8 = mpaHeader.intensityStereoBound;
        int i9 = mpaHeader.numSubbands;
        if (i8 > i9) {
            mpaHeader.intensityStereoBound = i9;
        }
        calculateFramesize(mpaHeader);
        return mpaHeader;
    }
}
