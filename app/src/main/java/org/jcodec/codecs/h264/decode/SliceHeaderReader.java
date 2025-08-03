package org.jcodec.codecs.h264.decode;

import java.lang.reflect.Array;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.PredictionWeightTable;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
public class SliceHeaderReader {
    private SliceHeaderReader() {
    }

    private static int CeilLog2(int i) {
        int i2 = i - 1;
        int i3 = 0;
        while (i2 != 0) {
            i2 >>= 1;
            i3++;
        }
        return i3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void readDecoderPicMarking(org.jcodec.codecs.h264.io.model.NALUnit r6, org.jcodec.codecs.h264.io.model.SliceHeader r7, org.jcodec.common.io.BitReader r8) {
        /*
            org.jcodec.codecs.h264.io.model.NALUnitType r6 = r6.type
            org.jcodec.codecs.h264.io.model.NALUnitType r0 = org.jcodec.codecs.h264.io.model.NALUnitType.IDR_SLICE
            if (r6 != r0) goto L1b
            java.lang.String r6 = "SH: no_output_of_prior_pics_flag"
            boolean r6 = org.jcodec.codecs.h264.decode.CAVLCReader.readBool(r8, r6)
            java.lang.String r0 = "SH: long_term_reference_flag"
            boolean r8 = org.jcodec.codecs.h264.decode.CAVLCReader.readBool(r8, r0)
            org.jcodec.codecs.h264.io.model.RefPicMarkingIDR r0 = new org.jcodec.codecs.h264.io.model.RefPicMarkingIDR
            r0.<init>(r6, r8)
            r7.refPicMarkingIDR = r0
            goto L9f
        L1b:
            java.lang.String r6 = "SH: adaptive_ref_pic_marking_mode_flag"
            boolean r6 = org.jcodec.codecs.h264.decode.CAVLCReader.readBool(r8, r6)
            if (r6 == 0) goto L9f
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
        L28:
            java.lang.String r0 = "SH: memory_management_control_operation"
            int r0 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r0)
            r1 = 0
            java.lang.String r2 = "SH: long_term_frame_idx"
            java.lang.String r3 = "SH: difference_of_pic_nums_minus1"
            r4 = 0
            switch(r0) {
                case 1: goto L7c;
                case 2: goto L6e;
                case 3: goto L5c;
                case 4: goto L4c;
                case 5: goto L44;
                case 6: goto L38;
                default: goto L37;
            }
        L37:
            goto L89
        L38:
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction r1 = new org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r3 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.MARK_LONG
            int r2 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r2)
            r1.<init>(r3, r2, r4)
            goto L89
        L44:
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction r1 = new org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r2 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.CLEAR
            r1.<init>(r2, r4, r4)
            goto L89
        L4c:
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction r1 = new org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r2 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.TRUNK_LONG
            java.lang.String r3 = "SH: max_long_term_frame_idx_plus1"
            int r3 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r3)
            int r3 = r3 + (-1)
            r1.<init>(r2, r3, r4)
            goto L89
        L5c:
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction r1 = new org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r5 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.CONVERT_INTO_LONG
            int r3 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r3)
            int r3 = r3 + 1
            int r2 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r2)
            r1.<init>(r5, r3, r2)
            goto L89
        L6e:
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction r1 = new org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r2 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.REMOVE_LONG
            java.lang.String r3 = "SH: long_term_pic_num"
            int r3 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r3)
            r1.<init>(r2, r3, r4)
            goto L89
        L7c:
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction r1 = new org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction
            org.jcodec.codecs.h264.io.model.RefPicMarking$InstrType r2 = org.jcodec.codecs.h264.io.model.RefPicMarking.InstrType.REMOVE_SHORT
            int r3 = org.jcodec.codecs.h264.decode.CAVLCReader.readUEtrace(r8, r3)
            int r3 = r3 + 1
            r1.<init>(r2, r3, r4)
        L89:
            if (r1 == 0) goto L8e
            r6.add(r1)
        L8e:
            if (r0 != 0) goto L28
            org.jcodec.codecs.h264.io.model.RefPicMarking r8 = new org.jcodec.codecs.h264.io.model.RefPicMarking
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction[] r0 = new org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction[r4]
            java.lang.Object[] r6 = r6.toArray(r0)
            org.jcodec.codecs.h264.io.model.RefPicMarking$Instruction[] r6 = (org.jcodec.codecs.h264.io.model.RefPicMarking.Instruction[]) r6
            r8.<init>(r6)
            r7.refPicMarkingNonIDR = r8
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.decode.SliceHeaderReader.readDecoderPicMarking(org.jcodec.codecs.h264.io.model.NALUnit, org.jcodec.codecs.h264.io.model.SliceHeader, org.jcodec.common.io.BitReader):void");
    }

    public static SliceHeader readPart1(BitReader bitReader) {
        SliceHeader sliceHeader = new SliceHeader();
        sliceHeader.firstMbInSlice = CAVLCReader.readUEtrace(bitReader, "SH: first_mb_in_slice");
        int uEtrace = CAVLCReader.readUEtrace(bitReader, "SH: slice_type");
        sliceHeader.sliceType = SliceType.fromValue(uEtrace % 5);
        sliceHeader.sliceTypeRestr = uEtrace / 5 > 0;
        sliceHeader.picParameterSetId = CAVLCReader.readUEtrace(bitReader, "SH: pic_parameter_set_id");
        return sliceHeader;
    }

    public static SliceHeader readPart2(SliceHeader sliceHeader, NALUnit nALUnit, SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, BitReader bitReader) {
        int i;
        SliceType sliceType;
        sliceHeader.pps = pictureParameterSet;
        sliceHeader.sps = seqParameterSet;
        sliceHeader.frameNum = CAVLCReader.readU(bitReader, seqParameterSet.log2MaxFrameNumMinus4 + 4, "SH: frame_num");
        if (!seqParameterSet.frameMbsOnlyFlag) {
            boolean bool = CAVLCReader.readBool(bitReader, "SH: field_pic_flag");
            sliceHeader.fieldPicFlag = bool;
            if (bool) {
                sliceHeader.bottomFieldFlag = CAVLCReader.readBool(bitReader, "SH: bottom_field_flag");
            }
        }
        if (nALUnit.type == NALUnitType.IDR_SLICE) {
            sliceHeader.idrPicId = CAVLCReader.readUEtrace(bitReader, "SH: idr_pic_id");
        }
        if (seqParameterSet.picOrderCntType == 0) {
            sliceHeader.picOrderCntLsb = CAVLCReader.readU(bitReader, seqParameterSet.log2MaxPicOrderCntLsbMinus4 + 4, "SH: pic_order_cnt_lsb");
            if (pictureParameterSet.picOrderPresentFlag && !seqParameterSet.fieldPicFlag) {
                sliceHeader.deltaPicOrderCntBottom = CAVLCReader.readSE(bitReader, "SH: delta_pic_order_cnt_bottom");
            }
        }
        int[] iArr = new int[2];
        sliceHeader.deltaPicOrderCnt = iArr;
        if (seqParameterSet.picOrderCntType == 1 && !seqParameterSet.deltaPicOrderAlwaysZeroFlag) {
            iArr[0] = CAVLCReader.readSE(bitReader, "SH: delta_pic_order_cnt[0]");
            if (pictureParameterSet.picOrderPresentFlag && !seqParameterSet.fieldPicFlag) {
                sliceHeader.deltaPicOrderCnt[1] = CAVLCReader.readSE(bitReader, "SH: delta_pic_order_cnt[1]");
            }
        }
        if (pictureParameterSet.redundantPicCntPresentFlag) {
            sliceHeader.redundantPicCnt = CAVLCReader.readUEtrace(bitReader, "SH: redundant_pic_cnt");
        }
        SliceType sliceType2 = sliceHeader.sliceType;
        SliceType sliceType3 = SliceType.B;
        if (sliceType2 == sliceType3) {
            sliceHeader.directSpatialMvPredFlag = CAVLCReader.readBool(bitReader, "SH: direct_spatial_mv_pred_flag");
        }
        SliceType sliceType4 = sliceHeader.sliceType;
        SliceType sliceType5 = SliceType.P;
        if (sliceType4 == sliceType5 || sliceType4 == SliceType.SP || sliceType4 == sliceType3) {
            boolean bool2 = CAVLCReader.readBool(bitReader, "SH: num_ref_idx_active_override_flag");
            sliceHeader.numRefIdxActiveOverrideFlag = bool2;
            if (bool2) {
                sliceHeader.numRefIdxActiveMinus1[0] = CAVLCReader.readUEtrace(bitReader, "SH: num_ref_idx_l0_active_minus1");
                if (sliceHeader.sliceType == sliceType3) {
                    sliceHeader.numRefIdxActiveMinus1[1] = CAVLCReader.readUEtrace(bitReader, "SH: num_ref_idx_l1_active_minus1");
                }
            }
        }
        readRefPicListReordering(sliceHeader, bitReader);
        if ((pictureParameterSet.weightedPredFlag && ((sliceType = sliceHeader.sliceType) == sliceType5 || sliceType == SliceType.SP)) || (pictureParameterSet.weightedBipredIdc == 1 && sliceHeader.sliceType == sliceType3)) {
            readPredWeightTable(seqParameterSet, pictureParameterSet, sliceHeader, bitReader);
        }
        if (nALUnit.nal_ref_idc != 0) {
            readDecoderPicMarking(nALUnit, sliceHeader, bitReader);
        }
        if (pictureParameterSet.entropyCodingModeFlag && sliceHeader.sliceType.isInter()) {
            sliceHeader.cabacInitIdc = CAVLCReader.readUEtrace(bitReader, "SH: cabac_init_idc");
        }
        sliceHeader.sliceQpDelta = CAVLCReader.readSE(bitReader, "SH: slice_qp_delta");
        SliceType sliceType6 = sliceHeader.sliceType;
        SliceType sliceType7 = SliceType.SP;
        if (sliceType6 == sliceType7 || sliceType6 == SliceType.SI) {
            if (sliceType6 == sliceType7) {
                sliceHeader.spForSwitchFlag = CAVLCReader.readBool(bitReader, "SH: sp_for_switch_flag");
            }
            sliceHeader.sliceQsDelta = CAVLCReader.readSE(bitReader, "SH: slice_qs_delta");
        }
        if (pictureParameterSet.deblockingFilterControlPresentFlag) {
            int uEtrace = CAVLCReader.readUEtrace(bitReader, "SH: disable_deblocking_filter_idc");
            sliceHeader.disableDeblockingFilterIdc = uEtrace;
            if (uEtrace != 1) {
                sliceHeader.sliceAlphaC0OffsetDiv2 = CAVLCReader.readSE(bitReader, "SH: slice_alpha_c0_offset_div2");
                sliceHeader.sliceBetaOffsetDiv2 = CAVLCReader.readSE(bitReader, "SH: slice_beta_offset_div2");
            }
        }
        if (pictureParameterSet.numSliceGroupsMinus1 > 0 && (i = pictureParameterSet.sliceGroupMapType) >= 3 && i <= 5) {
            int picHeightInMbs = (SeqParameterSet.getPicHeightInMbs(seqParameterSet) * (seqParameterSet.picWidthInMbsMinus1 + 1)) / (pictureParameterSet.sliceGroupChangeRateMinus1 + 1);
            if ((SeqParameterSet.getPicHeightInMbs(seqParameterSet) * (seqParameterSet.picWidthInMbsMinus1 + 1)) % (pictureParameterSet.sliceGroupChangeRateMinus1 + 1) > 0) {
                picHeightInMbs++;
            }
            sliceHeader.sliceGroupChangeCycle = CAVLCReader.readU(bitReader, CeilLog2(picHeightInMbs + 1), "SH: slice_group_change_cycle");
        }
        return sliceHeader;
    }

    private static void readPredWeightTable(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, SliceHeader sliceHeader, BitReader bitReader) {
        PredictionWeightTable predictionWeightTable = new PredictionWeightTable();
        sliceHeader.predWeightTable = predictionWeightTable;
        int[] iArr = sliceHeader.numRefIdxActiveOverrideFlag ? sliceHeader.numRefIdxActiveMinus1 : pictureParameterSet.numRefIdxActiveMinus1;
        int[] iArr2 = {iArr[0] + 1, iArr[1] + 1};
        predictionWeightTable.lumaLog2WeightDenom = CAVLCReader.readUEtrace(bitReader, "SH: luma_log2_weight_denom");
        if (seqParameterSet.chromaFormatIdc != ColorSpace.MONO) {
            sliceHeader.predWeightTable.chromaLog2WeightDenom = CAVLCReader.readUEtrace(bitReader, "SH: chroma_log2_weight_denom");
        }
        PredictionWeightTable predictionWeightTable2 = sliceHeader.predWeightTable;
        int i = 1 << predictionWeightTable2.lumaLog2WeightDenom;
        int i2 = 1 << predictionWeightTable2.chromaLog2WeightDenom;
        for (int i3 = 0; i3 < 2; i3++) {
            PredictionWeightTable predictionWeightTable3 = sliceHeader.predWeightTable;
            int[][] iArr3 = predictionWeightTable3.lumaWeight;
            int i4 = iArr2[i3];
            iArr3[i3] = new int[i4];
            predictionWeightTable3.lumaOffset[i3] = new int[i4];
            int[][][] iArr4 = predictionWeightTable3.chromaWeight;
            int[] iArr5 = {2, i4};
            Class cls = Integer.TYPE;
            iArr4[i3] = (int[][]) Array.newInstance((Class<?>) cls, iArr5);
            sliceHeader.predWeightTable.chromaOffset[i3] = (int[][]) Array.newInstance((Class<?>) cls, 2, iArr2[i3]);
            for (int i5 = 0; i5 < iArr2[i3]; i5++) {
                PredictionWeightTable predictionWeightTable4 = sliceHeader.predWeightTable;
                predictionWeightTable4.lumaWeight[i3][i5] = i;
                predictionWeightTable4.lumaOffset[i3][i5] = 0;
                int[][] iArr6 = predictionWeightTable4.chromaWeight[i3];
                iArr6[0][i5] = i2;
                int[][] iArr7 = predictionWeightTable4.chromaOffset[i3];
                iArr7[0][i5] = 0;
                iArr6[1][i5] = i2;
                iArr7[1][i5] = 0;
            }
        }
        readWeightOffset(seqParameterSet, pictureParameterSet, sliceHeader, bitReader, iArr2, 0);
        if (sliceHeader.sliceType == SliceType.B) {
            readWeightOffset(seqParameterSet, pictureParameterSet, sliceHeader, bitReader, iArr2, 1);
        }
    }

    private static void readRefPicListReordering(SliceHeader sliceHeader, BitReader bitReader) {
        sliceHeader.refPicReordering = new int[2][][];
        if (sliceHeader.sliceType.isInter() && CAVLCReader.readBool(bitReader, "SH: ref_pic_list_reordering_flag_l0")) {
            sliceHeader.refPicReordering[0] = readReorderingEntries(bitReader);
        }
        if (sliceHeader.sliceType == SliceType.B && CAVLCReader.readBool(bitReader, "SH: ref_pic_list_reordering_flag_l1")) {
            sliceHeader.refPicReordering[1] = readReorderingEntries(bitReader);
        }
    }

    private static int[][] readReorderingEntries(BitReader bitReader) {
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        IntArrayList intArrayListCreateIntArrayList2 = IntArrayList.createIntArrayList();
        while (true) {
            int uEtrace = CAVLCReader.readUEtrace(bitReader, "SH: reordering_of_pic_nums_idc");
            if (uEtrace == 3) {
                return new int[][]{intArrayListCreateIntArrayList.toArray(), intArrayListCreateIntArrayList2.toArray()};
            }
            intArrayListCreateIntArrayList.add(uEtrace);
            intArrayListCreateIntArrayList2.add(CAVLCReader.readUEtrace(bitReader, "SH: abs_diff_pic_num_minus1"));
        }
    }

    private static void readWeightOffset(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet, SliceHeader sliceHeader, BitReader bitReader, int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr[i]; i2++) {
            if (CAVLCReader.readBool(bitReader, "SH: luma_weight_l0_flag")) {
                sliceHeader.predWeightTable.lumaWeight[i][i2] = CAVLCReader.readSE(bitReader, "SH: weight");
                sliceHeader.predWeightTable.lumaOffset[i][i2] = CAVLCReader.readSE(bitReader, "SH: offset");
            }
            if (seqParameterSet.chromaFormatIdc != ColorSpace.MONO && CAVLCReader.readBool(bitReader, "SH: chroma_weight_l0_flag")) {
                sliceHeader.predWeightTable.chromaWeight[i][0][i2] = CAVLCReader.readSE(bitReader, "SH: weight");
                sliceHeader.predWeightTable.chromaOffset[i][0][i2] = CAVLCReader.readSE(bitReader, "SH: offset");
                sliceHeader.predWeightTable.chromaWeight[i][1][i2] = CAVLCReader.readSE(bitReader, "SH: weight");
                sliceHeader.predWeightTable.chromaOffset[i][1][i2] = CAVLCReader.readSE(bitReader, "SH: offset");
            }
        }
    }
}
