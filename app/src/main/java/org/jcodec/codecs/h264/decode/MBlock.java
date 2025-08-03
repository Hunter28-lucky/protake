package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import java.util.Arrays;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
public class MBlock {
    public int _cbp;
    public int[][][] ac;
    public int chromaPredictionMode;
    public MBType curMbType;
    public int[] dc1;
    public int[] dc2;
    public boolean fieldDecoding;
    public IPCM ipcm;
    public int luma16x16Mode;
    public int[] lumaModes;
    public int mbIdx;
    public int mbQPDelta;
    public int mbType;
    public int[] nCoeff;
    public H264Const.PartPred[] partPreds;
    public MBType prevMbType;
    public boolean skipped;
    public boolean transform8x8Used;
    public H264Utils.MvList x;
    public PB8x8 pb8x8 = new PB8x8();
    public PB16x16 pb16x16 = new PB16x16();
    public PB168x168 pb168x168 = new PB168x168();
    public int[] dc = new int[16];

    public static class IPCM {
        public int[] samplesChroma;
        public int[] samplesLuma = new int[256];

        public IPCM(ColorSpace colorSpace) {
            this.samplesChroma = new int[(16 >> colorSpace.compWidth[1]) * 2 * (16 >> colorSpace.compHeight[1])];
        }

        public void clean() {
            Arrays.fill(this.samplesLuma, 0);
            Arrays.fill(this.samplesChroma, 0);
        }
    }

    public static class PB168x168 {
        public int[] refIdx1 = new int[2];
        public int[] refIdx2 = new int[2];
        public int[] mvdX1 = new int[2];
        public int[] mvdY1 = new int[2];
        public int[] mvdX2 = new int[2];
        public int[] mvdY2 = new int[2];

        public void clean() {
            int[] iArr = this.refIdx1;
            iArr[1] = 0;
            iArr[0] = 0;
            int[] iArr2 = this.refIdx2;
            iArr2[1] = 0;
            iArr2[0] = 0;
            int[] iArr3 = this.mvdX1;
            iArr3[1] = 0;
            iArr3[0] = 0;
            int[] iArr4 = this.mvdY1;
            iArr4[1] = 0;
            iArr4[0] = 0;
            int[] iArr5 = this.mvdX2;
            iArr5[1] = 0;
            iArr5[0] = 0;
            int[] iArr6 = this.mvdY2;
            iArr6[1] = 0;
            iArr6[0] = 0;
        }
    }

    public static class PB16x16 {
        public int[] refIdx = new int[2];
        public int[] mvdX = new int[2];
        public int[] mvdY = new int[2];

        public void clean() {
            int[] iArr = this.refIdx;
            iArr[1] = 0;
            iArr[0] = 0;
            int[] iArr2 = this.mvdX;
            iArr2[1] = 0;
            iArr2[0] = 0;
            int[] iArr3 = this.mvdY;
            iArr3[1] = 0;
            iArr3[0] = 0;
        }
    }

    public static class PB8x8 {
        public int[][] mvdX1;
        public int[][] mvdX2;
        public int[][] mvdX3;
        public int[][] mvdX4;
        public int[][] mvdY1;
        public int[][] mvdY2;
        public int[][] mvdY3;
        public int[][] mvdY4;
        public int[][] refIdx;
        public int[] subMbTypes;

        public PB8x8() {
            Class cls = Integer.TYPE;
            this.refIdx = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.subMbTypes = new int[4];
            this.mvdX1 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdY1 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdX2 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdY2 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdX3 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdY3 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdX4 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
            this.mvdY4 = (int[][]) Array.newInstance((Class<?>) cls, 2, 4);
        }

        public void clean() {
            int[][] iArr = this.mvdX1;
            int[] iArr2 = iArr[0];
            iArr2[3] = 0;
            iArr2[2] = 0;
            iArr2[1] = 0;
            iArr2[0] = 0;
            int[][] iArr3 = this.mvdX2;
            int[] iArr4 = iArr3[0];
            iArr4[3] = 0;
            iArr4[2] = 0;
            iArr4[1] = 0;
            iArr4[0] = 0;
            int[][] iArr5 = this.mvdX3;
            int[] iArr6 = iArr5[0];
            iArr6[3] = 0;
            iArr6[2] = 0;
            iArr6[1] = 0;
            iArr6[0] = 0;
            int[][] iArr7 = this.mvdX4;
            int[] iArr8 = iArr7[0];
            iArr8[3] = 0;
            iArr8[2] = 0;
            iArr8[1] = 0;
            iArr8[0] = 0;
            int[][] iArr9 = this.mvdY1;
            int[] iArr10 = iArr9[0];
            iArr10[3] = 0;
            iArr10[2] = 0;
            iArr10[1] = 0;
            iArr10[0] = 0;
            int[][] iArr11 = this.mvdY2;
            int[] iArr12 = iArr11[0];
            iArr12[3] = 0;
            iArr12[2] = 0;
            iArr12[1] = 0;
            iArr12[0] = 0;
            int[][] iArr13 = this.mvdY3;
            int[] iArr14 = iArr13[0];
            iArr14[3] = 0;
            iArr14[2] = 0;
            iArr14[1] = 0;
            iArr14[0] = 0;
            int[][] iArr15 = this.mvdY4;
            int[] iArr16 = iArr15[0];
            iArr16[3] = 0;
            iArr16[2] = 0;
            iArr16[1] = 0;
            iArr16[0] = 0;
            int[] iArr17 = iArr[1];
            iArr17[3] = 0;
            iArr17[2] = 0;
            iArr17[1] = 0;
            iArr17[0] = 0;
            int[] iArr18 = iArr3[1];
            iArr18[3] = 0;
            iArr18[2] = 0;
            iArr18[1] = 0;
            iArr18[0] = 0;
            int[] iArr19 = iArr5[1];
            iArr19[3] = 0;
            iArr19[2] = 0;
            iArr19[1] = 0;
            iArr19[0] = 0;
            int[] iArr20 = iArr7[1];
            iArr20[3] = 0;
            iArr20[2] = 0;
            iArr20[1] = 0;
            iArr20[0] = 0;
            int[] iArr21 = iArr9[1];
            iArr21[3] = 0;
            iArr21[2] = 0;
            iArr21[1] = 0;
            iArr21[0] = 0;
            int[] iArr22 = iArr11[1];
            iArr22[3] = 0;
            iArr22[2] = 0;
            iArr22[1] = 0;
            iArr22[0] = 0;
            int[] iArr23 = iArr13[1];
            iArr23[3] = 0;
            iArr23[2] = 0;
            iArr23[1] = 0;
            iArr23[0] = 0;
            int[] iArr24 = iArr15[1];
            iArr24[3] = 0;
            iArr24[2] = 0;
            iArr24[1] = 0;
            iArr24[0] = 0;
            int[] iArr25 = this.subMbTypes;
            iArr25[3] = 0;
            iArr25[2] = 0;
            iArr25[1] = 0;
            iArr25[0] = 0;
            int[][] iArr26 = this.refIdx;
            int[] iArr27 = iArr26[0];
            iArr27[3] = 0;
            iArr27[2] = 0;
            iArr27[1] = 0;
            iArr27[0] = 0;
            int[] iArr28 = iArr26[1];
            iArr28[3] = 0;
            iArr28[2] = 0;
            iArr28[1] = 0;
            iArr28[0] = 0;
        }
    }

    public MBlock(ColorSpace colorSpace) {
        Class cls = Integer.TYPE;
        this.ac = new int[][][]{(int[][]) Array.newInstance((Class<?>) cls, 16, 64), (int[][]) Array.newInstance((Class<?>) cls, 4, 16), (int[][]) Array.newInstance((Class<?>) cls, 4, 16)};
        this.lumaModes = new int[16];
        this.nCoeff = new int[16];
        int[] iArr = colorSpace.compWidth;
        int i = 16 >> iArr[1];
        int[] iArr2 = colorSpace.compHeight;
        this.dc1 = new int[i >> iArr2[1]];
        this.dc2 = new int[(16 >> iArr[2]) >> iArr2[2]];
        this.ipcm = new IPCM(colorSpace);
        this.x = new H264Utils.MvList(16);
        this.partPreds = new H264Const.PartPred[4];
    }

    public void cbp(int i, int i2) {
        this._cbp = (i & 15) | (i2 << 4);
    }

    public int cbpChroma() {
        return this._cbp >> 4;
    }

    public int cbpLuma() {
        return this._cbp & 15;
    }

    public void clear() {
        this.chromaPredictionMode = 0;
        this.mbQPDelta = 0;
        Arrays.fill(this.dc, 0);
        int i = 0;
        while (true) {
            int[][][] iArr = this.ac;
            if (i >= iArr.length) {
                break;
            }
            for (int[] iArr2 : iArr[i]) {
                Arrays.fill(iArr2, 0);
            }
            i++;
        }
        this.transform8x8Used = false;
        Arrays.fill(this.lumaModes, 0);
        Arrays.fill(this.dc1, 0);
        Arrays.fill(this.dc2, 0);
        Arrays.fill(this.nCoeff, 0);
        this._cbp = 0;
        this.mbType = 0;
        this.pb16x16.clean();
        this.pb168x168.clean();
        this.pb8x8.clean();
        if (this.curMbType == MBType.I_PCM) {
            this.ipcm.clean();
        }
        this.mbIdx = 0;
        this.fieldDecoding = false;
        this.prevMbType = null;
        this.luma16x16Mode = 0;
        this.skipped = false;
        this.curMbType = null;
        this.x.clear();
        H264Const.PartPred[] partPredArr = this.partPreds;
        partPredArr[3] = null;
        partPredArr[2] = null;
        partPredArr[1] = null;
        partPredArr[0] = null;
    }
}
