package org.jcodec.codecs.vpx.vp9;

import org.jcodec.codecs.vpx.VPXBooleanDecoder;

/* loaded from: classes2.dex */
public class ModeInfo {
    private int segmentId;
    private boolean skip;
    private int subModes;
    private int txSize;
    private int uvMode;
    private int yMode;

    public ModeInfo() {
    }

    public static int readSegmentId(VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        return vPXBooleanDecoder.readTree(Consts.TREE_SEGMENT_ID, decodingContext.getSegmentationTreeProbs());
    }

    public static int vect4(int i, int i2, int i3, int i4) {
        return i | (i2 << 8) | (i3 << 16) | (i4 << 24);
    }

    public static int vect4get(int i, int i2) {
        return (i >> (i2 << 3)) & 255;
    }

    public int getSegmentId() {
        return this.segmentId;
    }

    public int getSubModes() {
        return this.subModes;
    }

    public int getTxSize() {
        return this.txSize;
    }

    public int getUvMode() {
        return this.uvMode;
    }

    public int getYMode() {
        return this.yMode;
    }

    public boolean isInter() {
        return false;
    }

    public boolean isSkip() {
        return this.skip;
    }

    public ModeInfo read(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        int kfIntraMode;
        int kfIntraModeSub = 0;
        int segmentId = (decodingContext.isSegmentationEnabled() && decodingContext.isUpdateSegmentMap()) ? readSegmentId(vPXBooleanDecoder, decodingContext) : 0;
        boolean skipFlag = decodingContext.isSegmentFeatureActive(segmentId, 3) ? true : readSkipFlag(i, i2, i3, vPXBooleanDecoder, decodingContext);
        int txSize = readTxSize(i, i2, i3, true, vPXBooleanDecoder, decodingContext);
        if (i3 >= 3) {
            kfIntraMode = readKfIntraMode(i, i2, i3, vPXBooleanDecoder, decodingContext);
        } else {
            kfIntraModeSub = readKfIntraModeSub(i, i2, i3, vPXBooleanDecoder, decodingContext);
            kfIntraMode = kfIntraModeSub & 255;
        }
        int i4 = kfIntraMode;
        return new ModeInfo(segmentId, skipFlag, txSize, i4, kfIntraModeSub, readInterIntraUvMode(i4, vPXBooleanDecoder, decodingContext));
    }

    public int readInterIntraUvMode(int i, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        return vPXBooleanDecoder.readTree(Consts.TREE_INTRA_MODE, decodingContext.getKfUVModeProbs()[i]);
    }

    public int readKfIntraMode(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        boolean z = i2 > 0;
        boolean z2 = i > decodingContext.getMiTileStartCol();
        int[] aboveModes = decodingContext.getAboveModes();
        int[] leftModes = decodingContext.getLeftModes();
        int tree = vPXBooleanDecoder.readTree(Consts.TREE_INTRA_MODE, decodingContext.getKfYModeProbs()[z ? aboveModes[i] : 0][z2 ? leftModes[i2 % 8] : 0]);
        aboveModes[i] = tree;
        leftModes[i2 % 8] = tree;
        return tree;
    }

    public int readKfIntraModeSub(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        boolean z = i2 > 0;
        boolean z2 = i > decodingContext.getMiTileStartCol();
        int[] aboveModes = decodingContext.getAboveModes();
        int[] leftModes = decodingContext.getLeftModes();
        int[][][] kfYModeProbs = decodingContext.getKfYModeProbs();
        int i4 = z ? aboveModes[i] : 0;
        int i5 = z2 ? leftModes[i2 & 7] : 0;
        int[] iArr = Consts.TREE_INTRA_MODE;
        int tree = vPXBooleanDecoder.readTree(iArr, kfYModeProbs[i4][i5]);
        if (i3 == 0) {
            int tree2 = vPXBooleanDecoder.readTree(iArr, kfYModeProbs[i4][tree]);
            int tree3 = vPXBooleanDecoder.readTree(iArr, kfYModeProbs[tree][i5]);
            int tree4 = vPXBooleanDecoder.readTree(iArr, kfYModeProbs[tree2][tree3]);
            aboveModes[i] = tree3;
            leftModes[i2 & 7] = tree2;
            return vect4(tree, tree2, tree3, tree4);
        }
        if (i3 == 1) {
            int tree5 = vPXBooleanDecoder.readTree(iArr, kfYModeProbs[i4][tree]);
            aboveModes[i] = tree;
            leftModes[i2 & 7] = tree5;
            return vect4(tree, tree5, tree, tree5);
        }
        if (i3 != 2) {
            return 0;
        }
        int tree6 = vPXBooleanDecoder.readTree(iArr, kfYModeProbs[tree][i5]);
        aboveModes[i] = tree6;
        leftModes[i2 & 7] = tree;
        return vect4(tree, tree, tree6, tree6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean readSkipFlag(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        byte b = i2 > 0;
        byte b2 = i > decodingContext.getMiTileStartCol();
        boolean[] aboveSkipped = decodingContext.getAboveSkipped();
        boolean[] leftSkipped = decodingContext.getLeftSkipped();
        int i4 = b != false ? (aboveSkipped[i] ? 1 : 0) + 0 : 0;
        if (b2 != false) {
            i4 += leftSkipped[i2 & 7] ? 1 : 0;
        }
        System.out.println("SKIP CTX: " + i4);
        boolean z = vPXBooleanDecoder.readBit(decodingContext.getSkipProbs()[i4]) == 1;
        for (int i5 = 0; i5 < Consts.blH[i3]; i5++) {
            leftSkipped[(i5 + i2) & 7] = z;
        }
        for (int i6 = 0; i6 < Consts.blW[i3]; i6++) {
            aboveSkipped[i6 + i] = z;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readTxSize(int r9, int r10, int r11, boolean r12, org.jcodec.codecs.vpx.VPXBooleanDecoder r13, org.jcodec.codecs.vpx.vp9.DecodingContext r14) {
        /*
            r8 = this;
            r0 = 3
            r1 = 0
            if (r11 >= r0) goto L5
            return r1
        L5:
            int[] r2 = org.jcodec.codecs.vpx.vp9.Consts.maxTxLookup
            r2 = r2[r11]
            int r3 = r14.getTxMode()
            java.lang.Math.min(r2, r3)
            if (r12 == 0) goto L82
            int r12 = r14.getTxMode()
            r3 = 4
            if (r12 != r3) goto L82
            r12 = 1
            if (r10 <= 0) goto L1e
            r3 = r12
            goto L1f
        L1e:
            r3 = r1
        L1f:
            int r4 = r14.getMiTileStartCol()
            if (r9 <= r4) goto L27
            r4 = r12
            goto L28
        L27:
            r4 = r1
        L28:
            if (r3 == 0) goto L39
            boolean[] r5 = r14.getAboveSkipped()
            boolean r5 = r5[r9]
            if (r5 != 0) goto L39
            int[] r5 = r14.getAboveTxSizes()
            r5 = r5[r9]
            goto L3a
        L39:
            r5 = r2
        L3a:
            if (r4 == 0) goto L4d
            boolean[] r6 = r14.getLeftSkipped()
            r7 = r10 & 7
            boolean r6 = r6[r7]
            if (r6 != 0) goto L4d
            int[] r6 = r14.getLeftTxSizes()
            r6 = r6[r7]
            goto L4e
        L4d:
            r6 = r2
        L4e:
            if (r4 != 0) goto L51
            r6 = r5
        L51:
            if (r3 != 0) goto L54
            r5 = r6
        L54:
            int r5 = r5 + r6
            if (r5 <= r2) goto L59
            r3 = r12
            goto L5a
        L59:
            r3 = r1
        L5a:
            if (r2 == r12) goto L73
            r12 = 2
            if (r2 == r12) goto L6e
            if (r2 != r0) goto L66
            int[][] r12 = r14.getTx32x32Probs()
            goto L77
        L66:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.String r10 = "Shouldn't happen"
            r9.<init>(r10)
            throw r9
        L6e:
            int[][] r12 = r14.getTx16x16Probs()
            goto L77
        L73:
            int[][] r12 = r14.getTx8x8Probs()
        L77:
            int[][] r0 = org.jcodec.codecs.vpx.vp9.Consts.TREE_TX_SIZE
            r0 = r0[r2]
            r12 = r12[r3]
            int r12 = r13.readTree(r0, r12)
            goto L8a
        L82:
            int r12 = r14.getTxMode()
            int r12 = java.lang.Math.min(r2, r12)
        L8a:
            r13 = r1
        L8b:
            int[] r0 = org.jcodec.codecs.vpx.vp9.Consts.blH
            r0 = r0[r11]
            if (r13 >= r0) goto L9e
            int[] r0 = r14.getLeftTxSizes()
            int r2 = r10 + r13
            r2 = r2 & 7
            r0[r2] = r12
            int r13 = r13 + 1
            goto L8b
        L9e:
            int[] r10 = org.jcodec.codecs.vpx.vp9.Consts.blW
            r10 = r10[r11]
            if (r1 >= r10) goto Lb1
            int[] r10 = r14.getAboveTxSizes()
            int r13 = r9 + r1
            r13 = r13 & 7
            r10[r13] = r12
            int r1 = r1 + 1
            goto L9e
        Lb1:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.ModeInfo.readTxSize(int, int, int, boolean, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):int");
    }

    public ModeInfo(int i, boolean z, int i2, int i3, int i4, int i5) {
        this.segmentId = i;
        this.skip = z;
        this.txSize = i2;
        this.yMode = i3;
        this.subModes = i4;
        this.uvMode = i5;
    }
}
