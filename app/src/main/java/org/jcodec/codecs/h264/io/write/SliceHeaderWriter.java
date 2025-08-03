package org.jcodec.codecs.h264.io.write;

import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.RefPicMarkingIDR;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.ColorSpace;

/* loaded from: classes2.dex */
public class SliceHeaderWriter {

    /* renamed from: org.jcodec.codecs.h264.io.write.SliceHeaderWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType;

        static {
            int[] iArr = new int[RefPicMarking.InstrType.values().length];
            $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType = iArr;
            try {
                iArr[RefPicMarking.InstrType.REMOVE_SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.REMOVE_LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.CONVERT_INTO_LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.TRUNK_LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.CLEAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.MARK_LONG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private SliceHeaderWriter() {
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

    public static void write(SliceHeader sliceHeader, boolean z, int i, BitWriter bitWriter) {
        int i2;
        SliceType sliceType;
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        PictureParameterSet pictureParameterSet = sliceHeader.pps;
        CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.firstMbInSlice, "SH: first_mb_in_slice");
        CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.sliceType.ordinal() + (sliceHeader.sliceTypeRestr ? 5 : 0), "SH: slice_type");
        CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.picParameterSetId, "SH: pic_parameter_set_id");
        int i3 = sliceHeader.frameNum;
        int i4 = seqParameterSet.log2MaxFrameNumMinus4;
        if (i3 > (1 << (i4 + 4))) {
            throw new IllegalArgumentException("frame_num > " + (1 << (seqParameterSet.log2MaxFrameNumMinus4 + 4)));
        }
        CAVLCWriter.writeUtrace(bitWriter, i3, i4 + 4, "SH: frame_num");
        if (!seqParameterSet.frameMbsOnlyFlag) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.fieldPicFlag, "SH: field_pic_flag");
            if (sliceHeader.fieldPicFlag) {
                CAVLCWriter.writeBool(bitWriter, sliceHeader.bottomFieldFlag, "SH: bottom_field_flag");
            }
        }
        if (z) {
            CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.idrPicId, "SH: idr_pic_id");
        }
        if (seqParameterSet.picOrderCntType == 0) {
            int i5 = sliceHeader.picOrderCntLsb;
            int i6 = seqParameterSet.log2MaxPicOrderCntLsbMinus4;
            if (i5 > (1 << (i6 + 4))) {
                throw new IllegalArgumentException("pic_order_cnt_lsb > " + (1 << (seqParameterSet.log2MaxPicOrderCntLsbMinus4 + 4)));
            }
            CAVLCWriter.writeU(bitWriter, i5, i6 + 4);
            if (pictureParameterSet.picOrderPresentFlag && !seqParameterSet.fieldPicFlag) {
                CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.deltaPicOrderCntBottom, "SH: delta_pic_order_cnt_bottom");
            }
        }
        if (seqParameterSet.picOrderCntType == 1 && !seqParameterSet.deltaPicOrderAlwaysZeroFlag) {
            CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.deltaPicOrderCnt[0], "SH: delta_pic_order_cnt");
            if (pictureParameterSet.picOrderPresentFlag && !seqParameterSet.fieldPicFlag) {
                CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.deltaPicOrderCnt[1], "SH: delta_pic_order_cnt");
            }
        }
        if (pictureParameterSet.redundantPicCntPresentFlag) {
            CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.redundantPicCnt, "SH: redundant_pic_cnt");
        }
        SliceType sliceType2 = sliceHeader.sliceType;
        SliceType sliceType3 = SliceType.B;
        if (sliceType2 == sliceType3) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.directSpatialMvPredFlag, "SH: direct_spatial_mv_pred_flag");
        }
        SliceType sliceType4 = sliceHeader.sliceType;
        SliceType sliceType5 = SliceType.P;
        if (sliceType4 == sliceType5 || sliceType4 == SliceType.SP || sliceType4 == sliceType3) {
            CAVLCWriter.writeBool(bitWriter, sliceHeader.numRefIdxActiveOverrideFlag, "SH: num_ref_idx_active_override_flag");
            if (sliceHeader.numRefIdxActiveOverrideFlag) {
                CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.numRefIdxActiveMinus1[0], "SH: num_ref_idx_l0_active_minus1");
                if (sliceHeader.sliceType == sliceType3) {
                    CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.numRefIdxActiveMinus1[1], "SH: num_ref_idx_l1_active_minus1");
                }
            }
        }
        writeRefPicListReordering(sliceHeader, bitWriter);
        if ((pictureParameterSet.weightedPredFlag && ((sliceType = sliceHeader.sliceType) == sliceType5 || sliceType == SliceType.SP)) || (pictureParameterSet.weightedBipredIdc == 1 && sliceHeader.sliceType == sliceType3)) {
            writePredWeightTable(sliceHeader, bitWriter);
        }
        if (i != 0) {
            writeDecRefPicMarking(sliceHeader, z, bitWriter);
        }
        if (pictureParameterSet.entropyCodingModeFlag && sliceHeader.sliceType.isInter()) {
            CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.cabacInitIdc, "SH: cabac_init_idc");
        }
        CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.sliceQpDelta, "SH: slice_qp_delta");
        SliceType sliceType6 = sliceHeader.sliceType;
        SliceType sliceType7 = SliceType.SP;
        if (sliceType6 == sliceType7 || sliceType6 == SliceType.SI) {
            if (sliceType6 == sliceType7) {
                CAVLCWriter.writeBool(bitWriter, sliceHeader.spForSwitchFlag, "SH: sp_for_switch_flag");
            }
            CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.sliceQsDelta, "SH: slice_qs_delta");
        }
        if (pictureParameterSet.deblockingFilterControlPresentFlag) {
            CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.disableDeblockingFilterIdc, "SH: disable_deblocking_filter_idc");
            if (sliceHeader.disableDeblockingFilterIdc != 1) {
                CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.sliceAlphaC0OffsetDiv2, "SH: slice_alpha_c0_offset_div2");
                CAVLCWriter.writeSEtrace(bitWriter, sliceHeader.sliceBetaOffsetDiv2, "SH: slice_beta_offset_div2");
            }
        }
        if (pictureParameterSet.numSliceGroupsMinus1 <= 0 || (i2 = pictureParameterSet.sliceGroupMapType) < 3 || i2 > 5) {
            return;
        }
        int i7 = seqParameterSet.picHeightInMapUnitsMinus1;
        int i8 = seqParameterSet.picWidthInMbsMinus1;
        int i9 = pictureParameterSet.sliceGroupChangeRateMinus1;
        int i10 = ((i7 + 1) * (i8 + 1)) / (i9 + 1);
        if (((i7 + 1) * (i8 + 1)) % (i9 + 1) > 0) {
            i10++;
        }
        CAVLCWriter.writeU(bitWriter, sliceHeader.sliceGroupChangeCycle, CeilLog2(i10 + 1));
    }

    private static void writeDecRefPicMarking(SliceHeader sliceHeader, boolean z, BitWriter bitWriter) {
        if (z) {
            RefPicMarkingIDR refPicMarkingIDR = sliceHeader.refPicMarkingIDR;
            CAVLCWriter.writeBool(bitWriter, refPicMarkingIDR.isDiscardDecodedPics(), "SH: no_output_of_prior_pics_flag");
            CAVLCWriter.writeBool(bitWriter, refPicMarkingIDR.isUseForlongTerm(), "SH: long_term_reference_flag");
            return;
        }
        CAVLCWriter.writeBool(bitWriter, sliceHeader.refPicMarkingNonIDR != null, "SH: adaptive_ref_pic_marking_mode_flag");
        RefPicMarking refPicMarking = sliceHeader.refPicMarkingNonIDR;
        if (refPicMarking != null) {
            for (RefPicMarking.Instruction instruction : refPicMarking.getInstructions()) {
                switch (AnonymousClass1.$SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[instruction.getType().ordinal()]) {
                    case 1:
                        CAVLCWriter.writeUEtrace(bitWriter, 1, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUEtrace(bitWriter, instruction.getArg1() - 1, "SH: difference_of_pic_nums_minus1");
                        break;
                    case 2:
                        CAVLCWriter.writeUEtrace(bitWriter, 2, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUEtrace(bitWriter, instruction.getArg1(), "SH: long_term_pic_num");
                        break;
                    case 3:
                        CAVLCWriter.writeUEtrace(bitWriter, 3, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUEtrace(bitWriter, instruction.getArg1() - 1, "SH: difference_of_pic_nums_minus1");
                        CAVLCWriter.writeUEtrace(bitWriter, instruction.getArg2(), "SH: long_term_frame_idx");
                        break;
                    case 4:
                        CAVLCWriter.writeUEtrace(bitWriter, 4, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUEtrace(bitWriter, instruction.getArg1() + 1, "SH: max_long_term_frame_idx_plus1");
                        break;
                    case 5:
                        CAVLCWriter.writeUEtrace(bitWriter, 5, "SH: memory_management_control_operation");
                        break;
                    case 6:
                        CAVLCWriter.writeUEtrace(bitWriter, 6, "SH: memory_management_control_operation");
                        CAVLCWriter.writeUEtrace(bitWriter, instruction.getArg1(), "SH: long_term_frame_idx");
                        break;
                }
            }
            CAVLCWriter.writeUEtrace(bitWriter, 0, "SH: memory_management_control_operation");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void writeOffsetWeight(org.jcodec.codecs.h264.io.model.SliceHeader r10, org.jcodec.common.io.BitWriter r11, int r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.codecs.h264.io.write.SliceHeaderWriter.writeOffsetWeight(org.jcodec.codecs.h264.io.model.SliceHeader, org.jcodec.common.io.BitWriter, int):void");
    }

    private static void writePredWeightTable(SliceHeader sliceHeader, BitWriter bitWriter) {
        SeqParameterSet seqParameterSet = sliceHeader.sps;
        CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.predWeightTable.lumaLog2WeightDenom, "SH: luma_log2_weight_denom");
        if (seqParameterSet.chromaFormatIdc != ColorSpace.MONO) {
            CAVLCWriter.writeUEtrace(bitWriter, sliceHeader.predWeightTable.chromaLog2WeightDenom, "SH: chroma_log2_weight_denom");
        }
        writeOffsetWeight(sliceHeader, bitWriter, 0);
        if (sliceHeader.sliceType == SliceType.B) {
            writeOffsetWeight(sliceHeader, bitWriter, 1);
        }
    }

    private static void writeRefPicListReordering(SliceHeader sliceHeader, BitWriter bitWriter) {
        boolean z = false;
        if (sliceHeader.sliceType.isInter()) {
            int[][][] iArr = sliceHeader.refPicReordering;
            boolean z2 = (iArr == null || iArr[0] == null) ? false : true;
            CAVLCWriter.writeBool(bitWriter, z2, "SH: ref_pic_list_reordering_flag_l0");
            if (z2) {
                writeReorderingList(sliceHeader.refPicReordering[0], bitWriter);
            }
        }
        if (sliceHeader.sliceType == SliceType.B) {
            int[][][] iArr2 = sliceHeader.refPicReordering;
            if (iArr2 != null && iArr2[1] != null) {
                z = true;
            }
            CAVLCWriter.writeBool(bitWriter, z, "SH: ref_pic_list_reordering_flag_l1");
            if (z) {
                writeReorderingList(sliceHeader.refPicReordering[1], bitWriter);
            }
        }
    }

    private static void writeReorderingList(int[][] iArr, BitWriter bitWriter) {
        if (iArr == null) {
            return;
        }
        int i = 0;
        while (true) {
            int[] iArr2 = iArr[0];
            if (i >= iArr2.length) {
                CAVLCWriter.writeUEtrace(bitWriter, 3, "SH: reordering_of_pic_nums_idc");
                return;
            } else {
                CAVLCWriter.writeUEtrace(bitWriter, iArr2[i], "SH: reordering_of_pic_nums_idc");
                CAVLCWriter.writeUEtrace(bitWriter, iArr[1][i], "SH: abs_diff_pic_num_minus1");
                i++;
            }
        }
    }
}
