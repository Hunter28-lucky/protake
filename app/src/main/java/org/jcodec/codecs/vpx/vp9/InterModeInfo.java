package org.jcodec.codecs.vpx.vp9;

import org.jcodec.codecs.common.biari.Packed4BitList;
import org.jcodec.codecs.vpx.VPXBooleanDecoder;

/* loaded from: classes2.dex */
public class InterModeInfo extends ModeInfo {
    private long mvl0;
    private long mvl1;
    private long mvl2;
    private long mvl3;

    public InterModeInfo() {
    }

    private static int clampMvCol(int i, int i2, DecodingContext decodingContext, int i3) {
        return clip3((-(i << 6)) - 128, (((decodingContext.getMiFrameWidth() - Consts.blW[i2]) - i) << 6) + 128, i3);
    }

    private static int clampMvRow(int i, int i2, DecodingContext decodingContext, int i3) {
        return clip3((-(i << 6)) - 128, (((decodingContext.getMiFrameHeight() - Consts.blH[i2]) - i) << 6) + 128, i3);
    }

    private static long clampMvs(int i, int i2, int i3, DecodingContext decodingContext, long j) {
        int i4 = MVList.get(j, 0);
        int i5 = MVList.get(j, 1);
        return MVList.create(MV.create(clampMvCol(i, i3, decodingContext, MV.x(i4)), clampMvRow(i2, i3, decodingContext, MV.y(i4)), MV.ref(i4)), MV.create(clampMvCol(i, i3, decodingContext, MV.x(i5)), clampMvRow(i2, i3, decodingContext, MV.y(i5)), MV.ref(i5)));
    }

    private static long clearHp(DecodingContext decodingContext, long j) {
        int iCreate = MVList.get(j, 0);
        if (!decodingContext.isAllowHpMv() || largeMv(iCreate)) {
            iCreate = MV.create(MV.x(iCreate) & (-2), MV.y(iCreate) & (-2), MV.ref(iCreate));
        }
        int iCreate2 = MVList.get(j, 1);
        if (!decodingContext.isAllowHpMv() || largeMv(iCreate2)) {
            iCreate2 = MV.create(MV.x(iCreate2) & (-2), MV.y(iCreate2) & (-2), MV.ref(iCreate2));
        }
        return MVList.create(iCreate, iCreate2);
    }

    private static int clip3(int i, int i2, int i3) {
        return i3 < i ? i : i3 > i2 ? i2 : i3;
    }

    public static long findBestMv(int i, int i2, int i3, int i4, int i5, DecodingContext decodingContext, boolean z) {
        long j;
        long[][] leftMVs = decodingContext.getLeftMVs();
        long[][] aboveMVs = decodingContext.getAboveMVs();
        long[][] aboveLeftMVs = decodingContext.getAboveLeftMVs();
        long[] left4x4MVs = decodingContext.getLeft4x4MVs();
        long[] above4x4MVs = decodingContext.getAbove4x4MVs();
        int[] iArr = Consts.mv_ref_blocks[i3];
        int i6 = iArr[0];
        int i7 = iArr[1];
        long mv = getMV(leftMVs, aboveMVs, aboveLeftMVs, i6, i2, i, decodingContext);
        long mv2 = getMV(leftMVs, aboveMVs, aboveLeftMVs, i7, i2, i, decodingContext);
        int i8 = 2;
        if (i5 == 1) {
            mv = mv != -1 ? left4x4MVs[i2 % 8] : -1L;
        } else if (i5 == 2) {
            mv2 = mv2 == -1 ? -1L : above4x4MVs[i];
        }
        long j2 = mv;
        boolean z2 = (j2 != 0) | (mv2 != 0);
        int i9 = 2;
        long jProcessCandidate = processCandidate(i4, processCandidate(i4, 0L, j2), mv2);
        while (true) {
            int[][] iArr2 = Consts.mv_ref_blocks;
            if (i9 >= iArr2[i3].length || MVList.size(jProcessCandidate) >= i8) {
                break;
            }
            int i10 = i9;
            long j3 = jProcessCandidate;
            long mv3 = getMV(leftMVs, aboveMVs, aboveLeftMVs, iArr2[i3][i9], i2, i, decodingContext);
            z2 |= mv3 != 0;
            jProcessCandidate = processCandidate(i4, j3, mv3);
            i9 = i10 + 1;
            i8 = 2;
        }
        long j4 = jProcessCandidate;
        long jProcessCandidate2 = (MVList.size(j4) >= 2 || !decodingContext.isUsePrevFrameMvs()) ? j4 : processCandidate(i4, j4, decodingContext.getPrevFrameMv()[i][i2]);
        if (MVList.size(jProcessCandidate2) >= 2 || !z2) {
            j = jProcessCandidate2;
        } else {
            long jProcessNECandidate = jProcessCandidate2;
            int i11 = 0;
            while (true) {
                int[][] iArr3 = Consts.mv_ref_blocks;
                if (i11 >= iArr3[i3].length || MVList.size(jProcessNECandidate) >= 2) {
                    break;
                }
                jProcessNECandidate = processNECandidate(i4, decodingContext, jProcessNECandidate, getMV(leftMVs, aboveMVs, aboveLeftMVs, iArr3[i3][i11], i2, i, decodingContext));
                i11++;
            }
            j = jProcessNECandidate;
        }
        long jClampMvs = clampMvs(i, i2, i3, decodingContext, (MVList.size(j) >= 2 || !decodingContext.isUsePrevFrameMvs()) ? j : processNECandidate(i4, decodingContext, j, decodingContext.getPrevFrameMv()[i][i2]));
        return z ? clearHp(decodingContext, jClampMvs) : jClampMvs;
    }

    private static long getMV(long[][] jArr, long[][] jArr2, long[][] jArr3, int i, int i2, int i3, DecodingContext decodingContext) {
        int miTileHeight = decodingContext.getMiTileHeight();
        int miTileWidth = decodingContext.getMiTileWidth();
        switch (i) {
            case 0:
                if (i3 >= decodingContext.getMiTileStartCol()) {
                    return jArr[0][i2 % 8];
                }
                return 0L;
            case 1:
                if (i2 > 0) {
                    return jArr2[0][i3];
                }
                return 0L;
            case 2:
                if (i3 < decodingContext.getMiTileStartCol() || i2 >= miTileHeight - 1) {
                    return 0L;
                }
                return jArr[0][(i2 % 8) + 1];
            case 3:
                if (i2 <= 0 || i3 >= miTileWidth - 1) {
                    return 0L;
                }
                return jArr2[0][i3 + 1];
            case 4:
                if (i3 < decodingContext.getMiTileStartCol() || i2 >= miTileHeight - 3) {
                    return 0L;
                }
                return jArr[0][(i2 % 8) + 3];
            case 5:
                if (i2 <= 0 || i3 >= miTileWidth - 3) {
                    return 0L;
                }
                return jArr2[0][i3 + 3];
            case 6:
                if (i3 < decodingContext.getMiTileStartCol() || i2 >= miTileHeight - 2) {
                    return 0L;
                }
                return jArr[0][(i2 % 8) + 2];
            case 7:
                if (i2 <= 0 || i3 >= miTileWidth - 2) {
                    return 0L;
                }
                return jArr2[0][i3 + 2];
            case 8:
                if (i3 < decodingContext.getMiTileStartCol() || i2 >= miTileHeight - 4) {
                    return 0L;
                }
                return jArr[0][(i2 % 8) + 4];
            case 9:
                if (i2 <= 0 || i3 >= miTileWidth - 4) {
                    return 0L;
                }
                return jArr2[0][i3 + 4];
            case 10:
                if (i3 < decodingContext.getMiTileStartCol() || i2 >= miTileHeight - 6) {
                    return 0L;
                }
                return jArr[0][(i2 % 8) + 6];
            case 11:
                if (i3 < decodingContext.getMiTileStartCol() || i2 <= 0) {
                    return 0L;
                }
                return jArr3[0][0];
            case 12:
                if (i3 >= decodingContext.getMiTileStartCol() + 1) {
                    return jArr[1][i2 % 8];
                }
                return 0L;
            case 13:
                if (i2 > 1) {
                    return jArr2[1][i3];
                }
                return 0L;
            case 14:
                if (i3 >= decodingContext.getMiTileStartCol() + 2) {
                    return jArr[2][i2 % 8];
                }
                return 0L;
            case 15:
                if (i2 > 2) {
                    return jArr2[2][i3];
                }
                return 0L;
            case 16:
                if (i3 < decodingContext.getMiTileStartCol() + 1 || i2 <= 0) {
                    return 0L;
                }
                return jArr3[0][1];
            case 17:
                if (i3 < decodingContext.getMiTileStartCol() || i2 <= 1) {
                    return 0L;
                }
                return jArr3[1][0];
            case 18:
                if (i3 < decodingContext.getMiTileStartCol() + 1 || i2 <= 1) {
                    return 0L;
                }
                return jArr3[1][1];
            case 19:
                if (i3 < decodingContext.getMiTileStartCol() + 2 || i2 <= 2) {
                    return 0L;
                }
                return jArr3[2][2];
            default:
                return 0L;
        }
    }

    private static int getMode(int[] iArr, int[] iArr2, int i, int i2, int i3, DecodingContext decodingContext) {
        if (i == 0) {
            if (i3 > decodingContext.getMiTileStartCol()) {
                return iArr[i2 % 8];
            }
            return 10;
        }
        if (i == 1) {
            if (i2 > 0) {
                return iArr2[i3];
            }
            return 10;
        }
        if (i == 2) {
            if (i3 <= decodingContext.getMiTileStartCol() || i2 >= decodingContext.getMiFrameHeight() - 1) {
                return 10;
            }
            return iArr[(i2 % 8) + 1];
        }
        if (i == 3) {
            if (i3 >= decodingContext.getMiTileWidth() - 1 || i2 <= 0) {
                return 10;
            }
            return iArr2[i3 + 1];
        }
        if (i == 4) {
            if (i3 <= decodingContext.getMiTileStartCol() || i2 >= decodingContext.getMiFrameHeight() - 3) {
                return 10;
            }
            return iArr[(i2 % 8) + 3];
        }
        if (i == 5 && i3 < decodingContext.getMiTileWidth() - 3 && i2 > 0) {
            return iArr2[i3 + 3];
        }
        return 10;
    }

    public static int getRef(int i, int i2) {
        return i2 == 0 ? i & 3 : (i >> 2) & 3;
    }

    private static boolean largeMv(int i) {
        return (MV.x(i) >= 64 || MV.x(i) <= -64) && (MV.y(i) >= 64 || MV.y(i) <= -64);
    }

    private static int predicSegmentId(int i, int i2, int i3, DecodingContext decodingContext) {
        int iMin = Math.min(decodingContext.getMiTileWidth() - i, Consts.blW[i3]);
        int iMin2 = Math.min(decodingContext.getMiTileHeight() - i2, Consts.blH[i3]);
        int[][] prevSegmentIds = decodingContext.getPrevSegmentIds();
        int iMin3 = 7;
        for (int i4 = 0; i4 < iMin2; i4++) {
            for (int i5 = 0; i5 < iMin; i5++) {
                iMin3 = Math.min(iMin3, prevSegmentIds[i2 + i4][i + i5]);
            }
        }
        return iMin3;
    }

    private static long prepandSubMvBlk12(long j, int i) {
        return MVList.addUniq(MVList.addUniq(MVList.add(0L, i), MVList.get(j, 0)), MVList.get(j, 0));
    }

    private static long prepandSubMvBlk3(long j, int i, int i2, int i3) {
        return MVList.addUniq(MVList.addUniq(MVList.addUniq(MVList.addUniq(MVList.add(0L, i3), i2), i), MVList.get(j, 0)), MVList.get(j, 0));
    }

    private static long processCandidate(int i, long j, long j2) {
        int i2 = MVList.get(j2, 0);
        int i3 = MVList.get(j2, 1);
        return MV.ref(i2) == i ? MVList.addUniq(j, i2) : MV.ref(i3) == i ? MVList.addUniq(j, i3) : j;
    }

    private static long processNECandidate(int i, DecodingContext decodingContext, long j, long j2) {
        boolean z = false;
        int i2 = MVList.get(j2, 0);
        int i3 = MVList.get(j2, 1);
        if (MV.x(i2) == MV.x(i3) && MV.y(i2) == MV.y(i3)) {
            z = true;
        }
        long jProcessNEComponent = processNEComponent(i, decodingContext, j, i2);
        return !z ? processNEComponent(i, decodingContext, jProcessNEComponent, i3) : jProcessNEComponent;
    }

    private static long processNEComponent(int i, DecodingContext decodingContext, long j, int i2) {
        int iRef = MV.ref(i2);
        if (iRef == 0 || iRef == i) {
            return j;
        }
        return MVList.addUniq(j, MV.create(MV.x(i2) * decodingContext.refFrameSignBias(iRef) * decodingContext.refFrameSignBias(i), MV.y(i2), i));
    }

    private static int readDiffMv(VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, long j) {
        int i = MVList.get(j, 0);
        boolean z = decodingContext.isAllowHpMv() && !largeMv(i);
        int tree = vPXBooleanDecoder.readTree(Consts.TREE_MV_JOINT, decodingContext.getMvJointProbs());
        return MV.create(MV.x(i) + ((tree == 2 || tree == 3) ? readMvComponent(vPXBooleanDecoder, decodingContext, 0, z) : 0), MV.y(i) + ((tree == 1 || tree == 3) ? readMvComponent(vPXBooleanDecoder, decodingContext, 1, z) : 0), MV.ref(i));
    }

    private InterModeInfo readInterInterMode(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i4, boolean z, int i5) {
        int refFrames = readRefFrames(i, i2, i3, i4, vPXBooleanDecoder, decodingContext);
        int interMode = (decodingContext.isSegmentFeatureActive(i4, 3) || i3 < 3) ? 12 : readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext);
        if (decodingContext.getInterpFilter() == 3) {
            readInterpFilter(i, i2, i3, vPXBooleanDecoder, decodingContext);
        }
        if (i3 >= 3) {
            return new InterModeInfo(i4, z, i5, interMode, 0, interMode, readMV8x8AndAbove(i, i2, i3, vPXBooleanDecoder, decodingContext, refFrames, interMode), 0L, 0L, 0L);
        }
        if (i3 == 0) {
            long[] mV4x4 = readMV4x4(i, i2, i3, vPXBooleanDecoder, decodingContext, refFrames);
            return new InterModeInfo(i4, z, i5, -1, 0, -1, mV4x4[0], mV4x4[1], mV4x4[2], mV4x4[3]);
        }
        long[] mvSub8x8 = readMvSub8x8(i, i2, i3, vPXBooleanDecoder, decodingContext, refFrames);
        return new InterModeInfo(i4, z, i5, 0, 0, 0, mvSub8x8[0], mvSub8x8[1], 0L, 0L);
    }

    private InterModeInfo readInterIntraMode(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i4, boolean z, int i5) {
        int interIntraModeSub;
        int interIntraMode;
        if (i3 >= 3) {
            interIntraMode = readInterIntraMode(i, i2, i3, vPXBooleanDecoder, decodingContext);
            interIntraModeSub = 0;
        } else {
            interIntraModeSub = readInterIntraModeSub(i, i2, i3, vPXBooleanDecoder, decodingContext);
            interIntraMode = interIntraModeSub & 255;
        }
        int i6 = interIntraMode;
        return new InterModeInfo(i4, z, i5, i6, interIntraModeSub, readKfUvMode(i6, vPXBooleanDecoder, decodingContext), 0L, 0L, 0L, 0L);
    }

    private static int readMvComponent(VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i, boolean z) {
        int bit;
        boolean z2 = vPXBooleanDecoder.readBitEq() == 1;
        int tree = vPXBooleanDecoder.readTree(Consts.MV_CLASS_TREE, decodingContext.getMvClassProbs()[i]);
        if (tree == 0) {
            int bit2 = vPXBooleanDecoder.readBit(decodingContext.getMvClass0BitProbs()[i]);
            bit = ((z ? vPXBooleanDecoder.readBit(decodingContext.getMvClass0HpProbs()[i]) : 1) | (bit2 << 3) | (vPXBooleanDecoder.readTree(Consts.MV_FR_TREE, decodingContext.getMvClass0FrProbs()[i][bit2]) << 1)) + 1;
        } else {
            int bit3 = 0;
            for (int i2 = 0; i2 < tree; i2++) {
                bit3 |= vPXBooleanDecoder.readBit(decodingContext.getMvBitsProb()[i][i2]) << i2;
            }
            bit = ((z ? vPXBooleanDecoder.readBit(decodingContext.getMvHpProbs()[i]) : 1) | (bit3 << 3) | (vPXBooleanDecoder.readTree(Consts.MV_FR_TREE, decodingContext.getMvFrProbs()[i]) << 1)) + 1 + (2 << (tree + 2));
        }
        return z2 ? -bit : bit;
    }

    private static long readMvSub3(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, long j, long j2, long j3, int i4, int i5) {
        long j4;
        long jFindBestMv;
        int diffMv;
        int diffMv2;
        long j5;
        int i6 = Packed4BitList.get(i5, 0);
        int i7 = Packed4BitList.get(i5, 1);
        boolean z = Packed4BitList.get(i5, 2) == 1;
        long jFindBestMv2 = findBestMv(i, i2, i3, i6, 0, decodingContext, true);
        long jPrepandSubMvBlk3 = 0;
        if (z) {
            j4 = jFindBestMv2;
            jFindBestMv = findBestMv(i, i2, i3, i7, 0, decodingContext, true);
        } else {
            j4 = jFindBestMv2;
            jFindBestMv = 0;
        }
        if (i4 == 13) {
            diffMv2 = readDiffMv(vPXBooleanDecoder, decodingContext, j4);
            diffMv = z ? readDiffMv(vPXBooleanDecoder, decodingContext, jFindBestMv) : 0;
        } else if (i4 != 12) {
            long jPrepandSubMvBlk32 = prepandSubMvBlk3(findBestMv(i, i2, i3, i6, 3, decodingContext, false), MVList.get(j, 0), MVList.get(j2, 0), MVList.get(j3, 0));
            if (z) {
                j5 = jPrepandSubMvBlk32;
                jPrepandSubMvBlk3 = prepandSubMvBlk3(findBestMv(i, i2, i3, i7, 3, decodingContext, false), MVList.get(j, 1), MVList.get(j2, 1), MVList.get(j3, 1));
            } else {
                j5 = jPrepandSubMvBlk32;
            }
            int i8 = i4 - 10;
            diffMv2 = MVList.get(j5, i8);
            diffMv = MVList.get(jPrepandSubMvBlk3, i8);
        } else {
            diffMv = 0;
            diffMv2 = 0;
        }
        return MVList.create(diffMv2, diffMv);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    private int readRefFrames(int i, int i2, int i3, int i4, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        boolean z;
        int segmentFeature = decodingContext.getSegmentFeature(i4, 2);
        int i5 = 0;
        if (decodingContext.isSegmentFeatureActive(i4, 2)) {
            z = 0;
        } else {
            int refMode = decodingContext.getRefMode();
            boolean refMode2 = refMode == 1;
            if (refMode == 2) {
                refMode2 = readRefMode(i, i2, vPXBooleanDecoder, decodingContext);
            }
            boolean z2 = refMode2;
            if (z2) {
                int compRef = readCompRef(i, i2, i3, vPXBooleanDecoder, decodingContext);
                int compFixedRef = decodingContext.getCompFixedRef();
                if (decodingContext.refFrameSignBias(compFixedRef) == 0) {
                    i5 = compRef;
                    segmentFeature = compFixedRef;
                } else {
                    segmentFeature = compRef;
                    i5 = compFixedRef;
                }
            } else {
                segmentFeature = readSingleRef(i, i2, vPXBooleanDecoder, decodingContext);
            }
            z = z2;
        }
        updateRefFrameLineBuffers(i, i2, i3, decodingContext, segmentFeature, i5, z);
        return Packed4BitList._3(segmentFeature, i5, z);
    }

    private static boolean readSegIdPredicted(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        boolean[] aboveSegIdPredicted = decodingContext.getAboveSegIdPredicted();
        boolean[] leftSegIdPredicted = decodingContext.getLeftSegIdPredicted();
        boolean z = vPXBooleanDecoder.readBit(decodingContext.getSegmentationPredProbs()[(aboveSegIdPredicted[i2] ? 1 : 0) + (leftSegIdPredicted[i] ? 1 : 0)]) == 1;
        for (int i4 = 0; i4 < Consts.blH[i3]; i4++) {
            aboveSegIdPredicted[i + i4] = z;
        }
        for (int i5 = 0; i5 < Consts.blW[i3]; i5++) {
            leftSegIdPredicted[i2 + i5] = z;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b7 A[PHI: r1
      0x00b7: PHI (r1v27 int) = (r1v23 int), (r1v30 int) binds: [B:82:0x00d6, B:65:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9 A[PHI: r1
      0x00b9: PHI (r1v25 int) = (r1v23 int), (r1v30 int) binds: [B:82:0x00d6, B:65:0x00b5] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean readSingRefBin(int r16, int r17, int r18, org.jcodec.codecs.vpx.VPXBooleanDecoder r19, org.jcodec.codecs.vpx.vp9.DecodingContext r20) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.InterModeInfo.readSingRefBin(int, int, int, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):boolean");
    }

    private static long readSub0(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i4, int i5) {
        int diffMv;
        int i6 = Packed4BitList.get(i5, 0);
        int i7 = Packed4BitList.get(i5, 1);
        boolean z = Packed4BitList.get(i5, 2) == 1;
        long jFindBestMv = findBestMv(i, i2, i3, i6, 0, decodingContext, true);
        long jFindBestMv2 = z ? findBestMv(i, i2, i3, i7, 0, decodingContext, true) : 0L;
        if (i4 == 13) {
            int diffMv2 = readDiffMv(vPXBooleanDecoder, decodingContext, jFindBestMv);
            diffMv = z ? readDiffMv(vPXBooleanDecoder, decodingContext, jFindBestMv2) : 0;
            i = diffMv2;
        } else if (i4 != 12) {
            int i8 = i4 - 10;
            i = MVList.get(jFindBestMv, i8);
            diffMv = MVList.get(jFindBestMv2, i8);
        } else {
            diffMv = 0;
        }
        return MVList.create(i, diffMv);
    }

    private static long readSub12(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, long j, int i4, int i5, int i6) {
        int i7;
        long j2;
        long jFindBestMv;
        int diffMv;
        int i8 = Packed4BitList.get(i6, 0);
        int i9 = Packed4BitList.get(i6, 1);
        boolean z = Packed4BitList.get(i6, 2) == 1;
        long jFindBestMv2 = findBestMv(i, i2, i3, i8, 0, decodingContext, true);
        if (z) {
            i7 = i9;
            j2 = jFindBestMv2;
            jFindBestMv = findBestMv(i, i2, i3, i9, 0, decodingContext, true);
        } else {
            i7 = i9;
            j2 = jFindBestMv2;
            jFindBestMv = 0;
        }
        if (i4 == 13) {
            int diffMv2 = readDiffMv(vPXBooleanDecoder, decodingContext, j2);
            diffMv = z ? readDiffMv(vPXBooleanDecoder, decodingContext, jFindBestMv) : 0;
            i = diffMv2;
        } else if (i4 != 12) {
            long jPrepandSubMvBlk12 = prepandSubMvBlk12(findBestMv(i, i2, i3, i8, i5, decodingContext, false), MVList.get(j, 0));
            long jPrepandSubMvBlk122 = z ? prepandSubMvBlk12(findBestMv(i, i2, i3, i7, i5, decodingContext, false), MVList.get(j, 1)) : 0L;
            int i10 = i4 - 10;
            i = MVList.get(jPrepandSubMvBlk12, i10);
            diffMv = MVList.get(jPrepandSubMvBlk122, i10);
        } else {
            diffMv = 0;
        }
        return MVList.create(i, diffMv);
    }

    public static int ref(int i, int i2) {
        return ((i & 3) << 2) | (i2 & 3);
    }

    private static void updateMVLineBuffers(int i, int i2, int i3, DecodingContext decodingContext, long j) {
        long[][] leftMVs = decodingContext.getLeftMVs();
        long[][] aboveMVs = decodingContext.getAboveMVs();
        long[][] aboveLeftMVs = decodingContext.getAboveLeftMVs();
        for (int i4 = 0; i4 < Math.max(3, Consts.blW[i3]); i4++) {
            long[] jArr = aboveLeftMVs[2];
            long[] jArr2 = aboveLeftMVs[1];
            jArr[i4] = jArr2[i4];
            long[] jArr3 = aboveLeftMVs[0];
            jArr2[i4] = jArr3[i4];
            jArr3[i4] = aboveMVs[i4][i + i4];
        }
        for (int i5 = 0; i5 < Math.max(3, Consts.blH[i3]); i5++) {
            long[] jArr4 = aboveLeftMVs[i5];
            jArr4[2] = jArr4[1];
            jArr4[1] = jArr4[0];
            jArr4[0] = leftMVs[i5][(i2 + i5) % 8];
        }
        for (int i6 = 0; i6 < Math.max(3, Consts.blH[i3]); i6++) {
            for (int i7 = 0; i7 < Consts.blW[i3]; i7++) {
                int i8 = i + i7;
                long[] jArr5 = aboveMVs[2];
                long[] jArr6 = aboveMVs[1];
                jArr5[i8] = jArr6[i8];
                long[] jArr7 = aboveMVs[0];
                jArr6[i8] = jArr7[i8];
                jArr7[i8] = j;
            }
        }
        for (int i9 = 0; i9 < Math.max(3, Consts.blW[i3]); i9++) {
            for (int i10 = 0; i10 < Consts.blH[i3]; i10++) {
                int i11 = (i2 + i10) % 8;
                long[] jArr8 = leftMVs[2];
                long[] jArr9 = leftMVs[1];
                jArr8[i11] = jArr9[i11];
                long[] jArr10 = leftMVs[0];
                jArr9[i11] = jArr10[i11];
                jArr10[i11] = j;
            }
        }
    }

    private static void updateMVLineBuffers4x4(int i, int i2, int i3, DecodingContext decodingContext, long j, long j2) {
        long[] left4x4MVs = decodingContext.getLeft4x4MVs();
        decodingContext.getAbove4x4MVs()[i] = j2;
        left4x4MVs[i2 % 8] = j;
    }

    private static void updateRefFrameLineBuffers(int i, int i2, int i3, DecodingContext decodingContext, int i4, int i5, boolean z) {
        boolean[] aboveCompound = decodingContext.getAboveCompound();
        boolean[] leftCompound = decodingContext.getLeftCompound();
        for (int i6 = 0; i6 < Consts.blW[i3]; i6++) {
            aboveCompound[i6 + i] = z;
        }
        for (int i7 = 0; i7 < Consts.blH[i3]; i7++) {
            leftCompound[(i2 + i7) & 7] = z;
        }
        for (int i8 = 0; i8 < Consts.blW[i3]; i8++) {
            decodingContext.getAboveRefs()[i8] = ref(i4, i5);
        }
        for (int i9 = 0; i9 < Consts.blH[i3]; i9++) {
            decodingContext.getLeftRefs()[i9 & 7] = ref(i4, i5);
        }
    }

    public long getMvl0() {
        return this.mvl0;
    }

    public long getMvl1() {
        return this.mvl1;
    }

    public long getMvl2() {
        return this.mvl2;
    }

    public long getMvl3() {
        return this.mvl3;
    }

    @Override // org.jcodec.codecs.vpx.vp9.ModeInfo
    public boolean isInter() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readCompRef(int r20, int r21, int r22, org.jcodec.codecs.vpx.VPXBooleanDecoder r23, org.jcodec.codecs.vpx.vp9.DecodingContext r24) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.InterModeInfo.readCompRef(int, int, int, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):int");
    }

    public int readInterIntraModeSub(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        int[][] yModeProbs = decodingContext.getYModeProbs();
        int[] iArr = Consts.TREE_INTRA_MODE;
        return ModeInfo.vect4(vPXBooleanDecoder.readTree(iArr, yModeProbs[0]), vPXBooleanDecoder.readTree(iArr, yModeProbs[0]), vPXBooleanDecoder.readTree(iArr, yModeProbs[0]), vPXBooleanDecoder.readTree(iArr, yModeProbs[0]));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readInterMode(int r17, int r18, int r19, org.jcodec.codecs.vpx.VPXBooleanDecoder r20, org.jcodec.codecs.vpx.vp9.DecodingContext r21) {
        /*
            r16 = this;
            int[][] r0 = org.jcodec.codecs.vpx.vp9.Consts.mv_ref_blocks_sm
            r0 = r0[r19]
            r1 = 0
            r4 = r0[r1]
            r8 = 1
            r11 = r0[r8]
            int[] r0 = r21.getLeftModes()
            int[] r15 = r21.getAboveModes()
            r2 = r0
            r3 = r15
            r5 = r18
            r6 = r17
            r7 = r21
            int r2 = getMode(r2, r3, r4, r5, r6, r7)
            r9 = r0
            r10 = r15
            r12 = r18
            r13 = r17
            r14 = r21
            int r3 = getMode(r9, r10, r11, r12, r13, r14)
            r4 = 5
            r5 = 13
            r6 = 12
            r7 = 11
            r9 = 3
            r10 = 10
            if (r2 == r7) goto L5a
            if (r2 != r10) goto L39
            goto L5a
        L39:
            if (r2 != r6) goto L49
            if (r3 == r7) goto L47
            if (r3 != r10) goto L40
            goto L47
        L40:
            if (r3 != r5) goto L43
            goto L61
        L43:
            if (r3 != r6) goto L67
            r4 = r1
            goto L67
        L47:
            r4 = r8
            goto L67
        L49:
            if (r2 != r5) goto L54
            if (r3 == r7) goto L61
            if (r3 != r10) goto L50
            goto L61
        L50:
            if (r3 != r5) goto L61
            r4 = 4
            goto L67
        L54:
            if (r3 < r10) goto L57
            goto L67
        L57:
            r2 = 6
            r4 = r2
            goto L67
        L5a:
            if (r3 == r7) goto L66
            if (r3 != r10) goto L5f
            goto L66
        L5f:
            if (r3 != r5) goto L63
        L61:
            r4 = r9
            goto L67
        L63:
            if (r3 != r6) goto L67
            goto L47
        L66:
            r4 = 2
        L67:
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.Object[] r3 = new java.lang.Object[r8]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            r3[r1] = r5
            java.lang.String r5 = "inter_mode_ctx: %d\n"
            java.lang.String r3 = java.lang.String.format(r5, r3)
            r2.println(r3)
            int[][] r2 = r21.getInterModeProbs()
            int[] r3 = org.jcodec.codecs.vpx.vp9.Consts.TREE_INTER_MODE
            r2 = r2[r4]
            r4 = r20
            int r2 = r4.readTree(r3, r2)
            int r2 = r2 + r10
            r3 = r1
        L8a:
            int[] r4 = org.jcodec.codecs.vpx.vp9.Consts.blW
            r4 = r4[r19]
            if (r3 >= r4) goto L97
            int r4 = r17 + r3
            r15[r4] = r2
            int r3 = r3 + 1
            goto L8a
        L97:
            int[] r3 = org.jcodec.codecs.vpx.vp9.Consts.blH
            r3 = r3[r19]
            if (r1 >= r3) goto La6
            int r3 = r18 + r1
            int r3 = r3 % 8
            r0[r3] = r2
            int r1 = r1 + 1
            goto L97
        La6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.InterModeInfo.readInterMode(int, int, int, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int readInterpFilter(int r10, int r11, int r12, org.jcodec.codecs.vpx.VPXBooleanDecoder r13, org.jcodec.codecs.vpx.vp9.DecodingContext r14) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            if (r11 <= 0) goto L6
            r2 = r0
            goto L7
        L6:
            r2 = r1
        L7:
            int r3 = r14.getMiTileStartCol()
            if (r10 <= r3) goto Le
            goto Lf
        Le:
            r0 = r1
        Lf:
            int[] r3 = r14.getAboveRefs()
            int[] r4 = r14.getLeftRefs()
            r3 = r3[r10]
            int r3 = getRef(r3, r1)
            r5 = r11 & 7
            r4 = r4[r5]
            int r4 = getRef(r4, r1)
            int[] r6 = r14.getLeftInterpFilters()
            int[] r7 = r14.getAboveInterpFilters()
            r8 = 3
            if (r0 == 0) goto L35
            if (r4 <= 0) goto L35
            r0 = r6[r5]
            goto L36
        L35:
            r0 = r8
        L36:
            if (r2 == 0) goto L3d
            if (r3 <= 0) goto L3d
            r2 = r7[r10]
            goto L3e
        L3d:
            r2 = r8
        L3e:
            if (r0 != r2) goto L41
            goto L4b
        L41:
            if (r0 != r8) goto L47
            if (r2 == r8) goto L47
            r8 = r2
            goto L4c
        L47:
            if (r0 == r8) goto L4c
            if (r2 != r8) goto L4c
        L4b:
            r8 = r0
        L4c:
            int[][] r14 = r14.getInterpFilterProbs()
            int[] r0 = org.jcodec.codecs.vpx.vp9.Consts.TREE_INTERP_FILTER
            r14 = r14[r8]
            int r13 = r13.readTree(r0, r14)
            r14 = r1
        L59:
            int[] r0 = org.jcodec.codecs.vpx.vp9.Consts.blW
            r0 = r0[r12]
            if (r14 >= r0) goto L66
            int r0 = r10 + r14
            r7[r0] = r13
            int r14 = r14 + 1
            goto L59
        L66:
            int[] r10 = org.jcodec.codecs.vpx.vp9.Consts.blH
            r10 = r10[r12]
            if (r1 >= r10) goto L75
            int r10 = r11 + r1
            r10 = r10 & 7
            r6[r10] = r13
            int r1 = r1 + 1
            goto L66
        L75:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.InterModeInfo.readInterpFilter(int, int, int, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean readIsInter(int r5, int r6, int r7, org.jcodec.codecs.vpx.VPXBooleanDecoder r8, org.jcodec.codecs.vpx.vp9.DecodingContext r9) {
        /*
            r4 = this;
            r7 = 1
            r0 = 0
            if (r6 <= 0) goto L6
            r1 = r7
            goto L7
        L6:
            r1 = r0
        L7:
            int r2 = r9.getMiTileStartCol()
            if (r5 <= r2) goto Lf
            r2 = r7
            goto L10
        Lf:
            r2 = r0
        L10:
            int[] r3 = r9.getAboveRefs()
            r5 = r3[r5]
            int r5 = getRef(r5, r0)
            int[] r3 = r9.getLeftRefs()
            r6 = r6 & 7
            r6 = r3[r6]
            int r6 = getRef(r6, r0)
            if (r2 == 0) goto L2d
            if (r6 > 0) goto L2b
            goto L2d
        L2b:
            r6 = r0
            goto L2e
        L2d:
            r6 = r7
        L2e:
            if (r1 == 0) goto L35
            if (r5 > 0) goto L33
            goto L35
        L33:
            r5 = r0
            goto L36
        L35:
            r5 = r7
        L36:
            if (r1 == 0) goto L46
            if (r2 == 0) goto L46
            if (r6 == 0) goto L40
            if (r5 == 0) goto L40
            r5 = 3
            goto L59
        L40:
            if (r6 != 0) goto L44
            if (r5 == 0) goto L4b
        L44:
            r5 = r7
            goto L59
        L46:
            if (r1 != 0) goto L4d
            if (r2 == 0) goto L4b
            goto L4d
        L4b:
            r5 = r0
            goto L59
        L4d:
            if (r1 == 0) goto L52
            if (r5 == 0) goto L56
            goto L54
        L52:
            if (r6 == 0) goto L56
        L54:
            r5 = r7
            goto L57
        L56:
            r5 = r0
        L57:
            int r5 = r5 * 2
        L59:
            int[] r6 = r9.getIsInterProbs()
            r5 = r6[r5]
            int r5 = r8.readBit(r5)
            if (r5 != r7) goto L66
            goto L67
        L66:
            r7 = r0
        L67:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.InterModeInfo.readIsInter(int, int, int, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):boolean");
    }

    public int readKfUvMode(int i, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        return vPXBooleanDecoder.readTree(Consts.TREE_INTRA_MODE, decodingContext.getUvModeProbs()[i]);
    }

    public long[] readMV4x4(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i4) {
        long sub0 = readSub0(i, i2, i3, vPXBooleanDecoder, decodingContext, readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext), i4);
        long sub12 = readSub12(i, i2, i3, vPXBooleanDecoder, decodingContext, sub0, readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext), 1, i4);
        long sub122 = readSub12(i, i2, i3, vPXBooleanDecoder, decodingContext, sub0, readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext), 2, i4);
        long mvSub3 = readMvSub3(i, i2, i3, vPXBooleanDecoder, decodingContext, sub0, sub12, sub122, readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext), i4);
        updateMVLineBuffers(i, i2, i3, decodingContext, mvSub3);
        updateMVLineBuffers4x4(i, i2, i3, decodingContext, sub12, sub122);
        return new long[]{sub0, sub12, sub122, mvSub3};
    }

    public long readMV8x8AndAbove(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i4, int i5) {
        long sub0 = readSub0(i, i2, i3, vPXBooleanDecoder, decodingContext, i5, i4);
        updateMVLineBuffers(i, i2, i3, decodingContext, sub0);
        updateMVLineBuffers4x4(i, i2, i3, decodingContext, sub0, sub0);
        return sub0;
    }

    public long[] readMvSub8x8(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, int i4) {
        long sub0 = readSub0(i, i2, i3, vPXBooleanDecoder, decodingContext, readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext), i4);
        long sub12 = readSub12(i, i2, i3, vPXBooleanDecoder, decodingContext, sub0, readInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext), i3 == 1 ? 1 : 2, i4);
        if (i3 == 1) {
            updateMVLineBuffers4x4(i, i2, i3, decodingContext, sub12, sub0);
        } else {
            updateMVLineBuffers4x4(i, i2, i3, decodingContext, sub0, sub12);
        }
        updateMVLineBuffers(i, i2, i3, decodingContext, sub12);
        return new long[]{sub0, sub12};
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean readRefMode(int r11, int r12, org.jcodec.codecs.vpx.VPXBooleanDecoder r13, org.jcodec.codecs.vpx.vp9.DecodingContext r14) {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            if (r12 <= 0) goto L6
            r2 = r1
            goto L7
        L6:
            r2 = r0
        L7:
            int r3 = r14.getMiTileStartCol()
            if (r11 <= r3) goto Lf
            r3 = r1
            goto L10
        Lf:
            r3 = r0
        L10:
            boolean[] r4 = r14.getAboveCompound()
            boolean[] r5 = r14.getLeftCompound()
            int[] r6 = r14.getAboveRefs()
            r6 = r6[r11]
            int r6 = getRef(r6, r0)
            int[] r7 = r14.getLeftRefs()
            r8 = r12 & 7
            r7 = r7[r8]
            int r7 = getRef(r7, r0)
            int r8 = r14.getCompFixedRef()
            boolean r11 = r4[r11]
            r11 = r11 ^ r1
            int r12 = r12 % 8
            boolean r12 = r5[r12]
            r12 = r12 ^ r1
            if (r6 > 0) goto L3e
            r4 = r1
            goto L3f
        L3e:
            r4 = r0
        L3f:
            if (r7 > 0) goto L43
            r5 = r1
            goto L44
        L43:
            r5 = r0
        L44:
            r9 = 3
            if (r2 == 0) goto L71
            if (r3 == 0) goto L71
            if (r11 == 0) goto L5a
            if (r12 == 0) goto L5a
            if (r6 != r8) goto L51
            r11 = r1
            goto L52
        L51:
            r11 = r0
        L52:
            if (r7 != r8) goto L56
            r12 = r1
            goto L57
        L56:
            r12 = r0
        L57:
            r9 = r11 ^ r12
            goto L81
        L5a:
            r2 = 2
            if (r11 == 0) goto L68
            if (r6 == r8) goto L64
            if (r4 == 0) goto L62
            goto L64
        L62:
            r11 = r0
            goto L65
        L64:
            r11 = r1
        L65:
            int r9 = r2 + r11
            goto L81
        L68:
            if (r12 == 0) goto L6f
            if (r7 == r8) goto L64
            if (r5 == 0) goto L62
            goto L64
        L6f:
            r9 = 4
            goto L81
        L71:
            if (r2 == 0) goto L7a
            if (r11 == 0) goto L81
            if (r6 != r8) goto L78
            goto L80
        L78:
            r9 = r0
            goto L81
        L7a:
            if (r3 == 0) goto L80
            if (r12 == 0) goto L81
            if (r7 != r8) goto L78
        L80:
            r9 = r1
        L81:
            int[] r11 = r14.getCompModeProb()
            r11 = r11[r9]
            int r11 = r13.readBit(r11)
            if (r11 != r1) goto L8e
            r0 = r1
        L8e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.vpx.vp9.InterModeInfo.readRefMode(int, int, org.jcodec.codecs.vpx.VPXBooleanDecoder, org.jcodec.codecs.vpx.vp9.DecodingContext):boolean");
    }

    public int readSingleRef(int i, int i2, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        if (readSingRefBin(0, i, i2, vPXBooleanDecoder, decodingContext)) {
            return readSingRefBin(2, i, i2, vPXBooleanDecoder, decodingContext) ? 2 : 3;
        }
        return 1;
    }

    public InterModeInfo(int i, boolean z, int i2, int i3, int i4, int i5) {
        super(i, z, i2, i3, i4, i5);
    }

    @Override // org.jcodec.codecs.vpx.vp9.ModeInfo
    public InterModeInfo read(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        int i4;
        if (decodingContext.isSegmentationEnabled()) {
            int iPredicSegmentId = predicSegmentId(i, i2, i3, decodingContext);
            if (decodingContext.isUpdateSegmentMap() && (!decodingContext.isSegmentMapConditionalUpdate() || !readSegIdPredicted(i, i2, i3, vPXBooleanDecoder, decodingContext))) {
                iPredicSegmentId = ModeInfo.readSegmentId(vPXBooleanDecoder, decodingContext);
            }
            i4 = iPredicSegmentId;
        } else {
            i4 = 0;
        }
        boolean skipFlag = !decodingContext.isSegmentFeatureActive(i4, 3) ? readSkipFlag(i, i2, i3, vPXBooleanDecoder, decodingContext) : true;
        boolean isInter = decodingContext.getSegmentFeature(i4, 2) != 0;
        if (!decodingContext.isSegmentFeatureActive(i4, 2)) {
            isInter = readIsInter(i, i2, i3, vPXBooleanDecoder, decodingContext);
        }
        boolean z = isInter;
        int txSize = readTxSize(i, i2, i3, (skipFlag && z) ? false : true, vPXBooleanDecoder, decodingContext);
        return !z ? readInterIntraMode(i, i2, i3, vPXBooleanDecoder, decodingContext, i4, skipFlag, txSize) : readInterInterMode(i, i2, i3, vPXBooleanDecoder, decodingContext, i4, skipFlag, txSize);
    }

    public InterModeInfo(int i, boolean z, int i2, int i3, int i4, int i5, long j, long j2, long j3, long j4) {
        super(i, z, i2, i3, i4, i5);
        this.mvl0 = j;
        this.mvl1 = j2;
        this.mvl2 = j3;
        this.mvl3 = j4;
    }

    public int readInterIntraMode(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        return vPXBooleanDecoder.readTree(Consts.TREE_INTRA_MODE, decodingContext.getYModeProbs()[Consts.size_group_lookup[i3]]);
    }
}
