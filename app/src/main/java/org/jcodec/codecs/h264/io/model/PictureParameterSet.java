package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import java.util.Arrays;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class PictureParameterSet {
    public int[] bottomRight;
    public int chromaQpIndexOffset;
    public boolean constrainedIntraPredFlag;
    public boolean deblockingFilterControlPresentFlag;
    public boolean entropyCodingModeFlag;
    public PPSExt extended;
    public int[] numRefIdxActiveMinus1 = new int[2];
    public int numSliceGroupsMinus1;
    public int picInitQpMinus26;
    public int picInitQsMinus26;
    public boolean picOrderPresentFlag;
    public int picParameterSetId;
    public boolean redundantPicCntPresentFlag;
    public int[] runLengthMinus1;
    public int seqParameterSetId;
    public boolean sliceGroupChangeDirectionFlag;
    public int sliceGroupChangeRateMinus1;
    public int[] sliceGroupId;
    public int sliceGroupMapType;
    public int[] topLeft;
    public int weightedBipredIdc;
    public boolean weightedPredFlag;

    public static class PPSExt {
        public int[][] scalingMatrix;
        public int secondChromaQpIndexOffset;
        public boolean transform8x8ModeFlag;

        public int[][] getScalingMatrix() {
            return this.scalingMatrix;
        }

        public int getSecondChromaQpIndexOffset() {
            return this.secondChromaQpIndexOffset;
        }

        public boolean isTransform8x8ModeFlag() {
            return this.transform8x8ModeFlag;
        }
    }

    public static PictureParameterSet read(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        PictureParameterSet pictureParameterSet = new PictureParameterSet();
        pictureParameterSet.picParameterSetId = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: pic_parameter_set_id");
        pictureParameterSet.seqParameterSetId = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: seq_parameter_set_id");
        pictureParameterSet.entropyCodingModeFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: entropy_coding_mode_flag");
        pictureParameterSet.picOrderPresentFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: pic_order_present_flag");
        int uEtrace = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: num_slice_groups_minus1");
        pictureParameterSet.numSliceGroupsMinus1 = uEtrace;
        int i = 0;
        if (uEtrace > 0) {
            int uEtrace2 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: slice_group_map_type");
            pictureParameterSet.sliceGroupMapType = uEtrace2;
            int i2 = pictureParameterSet.numSliceGroupsMinus1;
            pictureParameterSet.topLeft = new int[i2 + 1];
            pictureParameterSet.bottomRight = new int[i2 + 1];
            pictureParameterSet.runLengthMinus1 = new int[i2 + 1];
            if (uEtrace2 == 0) {
                for (int i3 = 0; i3 <= pictureParameterSet.numSliceGroupsMinus1; i3++) {
                    pictureParameterSet.runLengthMinus1[i3] = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: run_length_minus1");
                }
            } else if (uEtrace2 == 2) {
                for (int i4 = 0; i4 < pictureParameterSet.numSliceGroupsMinus1; i4++) {
                    pictureParameterSet.topLeft[i4] = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: top_left");
                    pictureParameterSet.bottomRight[i4] = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: bottom_right");
                }
            } else if (uEtrace2 == 3 || uEtrace2 == 4 || uEtrace2 == 5) {
                pictureParameterSet.sliceGroupChangeDirectionFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: slice_group_change_direction_flag");
                pictureParameterSet.sliceGroupChangeRateMinus1 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: slice_group_change_rate_minus1");
            } else if (uEtrace2 == 6) {
                int i5 = i2 + 1 <= 4 ? i2 + 1 > 2 ? 2 : 1 : 3;
                int uEtrace3 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: pic_size_in_map_units_minus1");
                pictureParameterSet.sliceGroupId = new int[uEtrace3 + 1];
                for (int i6 = 0; i6 <= uEtrace3; i6++) {
                    pictureParameterSet.sliceGroupId[i6] = CAVLCReader.readU(bitReaderCreateBitReader, i5, "PPS: slice_group_id [" + i6 + "]f");
                }
            }
        }
        pictureParameterSet.numRefIdxActiveMinus1 = new int[]{CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: num_ref_idx_l0_active_minus1"), CAVLCReader.readUEtrace(bitReaderCreateBitReader, "PPS: num_ref_idx_l1_active_minus1")};
        pictureParameterSet.weightedPredFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: weighted_pred_flag");
        pictureParameterSet.weightedBipredIdc = CAVLCReader.readNBit(bitReaderCreateBitReader, 2, "PPS: weighted_bipred_idc");
        pictureParameterSet.picInitQpMinus26 = CAVLCReader.readSE(bitReaderCreateBitReader, "PPS: pic_init_qp_minus26");
        pictureParameterSet.picInitQsMinus26 = CAVLCReader.readSE(bitReaderCreateBitReader, "PPS: pic_init_qs_minus26");
        pictureParameterSet.chromaQpIndexOffset = CAVLCReader.readSE(bitReaderCreateBitReader, "PPS: chroma_qp_index_offset");
        pictureParameterSet.deblockingFilterControlPresentFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: deblocking_filter_control_present_flag");
        pictureParameterSet.constrainedIntraPredFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: constrained_intra_pred_flag");
        pictureParameterSet.redundantPicCntPresentFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: redundant_pic_cnt_present_flag");
        if (CAVLCReader.moreRBSPData(bitReaderCreateBitReader)) {
            PPSExt pPSExt = new PPSExt();
            pictureParameterSet.extended = pPSExt;
            pPSExt.transform8x8ModeFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: transform_8x8_mode_flag");
            if (CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: pic_scaling_matrix_present_flag")) {
                pictureParameterSet.extended.scalingMatrix = new int[8][];
                while (i < ((pictureParameterSet.extended.transform8x8ModeFlag ? 1 : 0) * 2) + 6) {
                    int i7 = i < 6 ? 16 : 64;
                    if (CAVLCReader.readBool(bitReaderCreateBitReader, "PPS: pic_scaling_list_present_flag")) {
                        pictureParameterSet.extended.scalingMatrix[i] = SeqParameterSet.readScalingList(bitReaderCreateBitReader, i7);
                    }
                    i++;
                }
            }
            pictureParameterSet.extended.secondChromaQpIndexOffset = CAVLCReader.readSE(bitReaderCreateBitReader, "PPS: second_chroma_qp_index_offset");
        }
        return pictureParameterSet;
    }

    public PictureParameterSet copy() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2048);
        write(byteBufferAllocate);
        byteBufferAllocate.flip();
        return read(byteBufferAllocate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PictureParameterSet pictureParameterSet = (PictureParameterSet) obj;
        if (!Platform.arrayEqualsInt(this.bottomRight, pictureParameterSet.bottomRight) || this.chromaQpIndexOffset != pictureParameterSet.chromaQpIndexOffset || this.constrainedIntraPredFlag != pictureParameterSet.constrainedIntraPredFlag || this.deblockingFilterControlPresentFlag != pictureParameterSet.deblockingFilterControlPresentFlag || this.entropyCodingModeFlag != pictureParameterSet.entropyCodingModeFlag) {
            return false;
        }
        PPSExt pPSExt = this.extended;
        if (pPSExt == null) {
            if (pictureParameterSet.extended != null) {
                return false;
            }
        } else if (!pPSExt.equals(pictureParameterSet.extended)) {
            return false;
        }
        int[] iArr = this.numRefIdxActiveMinus1;
        int i = iArr[0];
        int[] iArr2 = pictureParameterSet.numRefIdxActiveMinus1;
        return i == iArr2[0] && iArr[1] == iArr2[1] && this.numSliceGroupsMinus1 == pictureParameterSet.numSliceGroupsMinus1 && this.picInitQpMinus26 == pictureParameterSet.picInitQpMinus26 && this.picInitQsMinus26 == pictureParameterSet.picInitQsMinus26 && this.picOrderPresentFlag == pictureParameterSet.picOrderPresentFlag && this.picParameterSetId == pictureParameterSet.picParameterSetId && this.redundantPicCntPresentFlag == pictureParameterSet.redundantPicCntPresentFlag && Platform.arrayEqualsInt(this.runLengthMinus1, pictureParameterSet.runLengthMinus1) && this.seqParameterSetId == pictureParameterSet.seqParameterSetId && this.sliceGroupChangeDirectionFlag == pictureParameterSet.sliceGroupChangeDirectionFlag && this.sliceGroupChangeRateMinus1 == pictureParameterSet.sliceGroupChangeRateMinus1 && Platform.arrayEqualsInt(this.sliceGroupId, pictureParameterSet.sliceGroupId) && this.sliceGroupMapType == pictureParameterSet.sliceGroupMapType && Platform.arrayEqualsInt(this.topLeft, pictureParameterSet.topLeft) && this.weightedBipredIdc == pictureParameterSet.weightedBipredIdc && this.weightedPredFlag == pictureParameterSet.weightedPredFlag;
    }

    public int[] getBottomRight() {
        return this.bottomRight;
    }

    public int getChromaQpIndexOffset() {
        return this.chromaQpIndexOffset;
    }

    public PPSExt getExtended() {
        return this.extended;
    }

    public int[] getNumRefIdxActiveMinus1() {
        return this.numRefIdxActiveMinus1;
    }

    public int getNumSliceGroupsMinus1() {
        return this.numSliceGroupsMinus1;
    }

    public int getPicInitQpMinus26() {
        return this.picInitQpMinus26;
    }

    public int getPicInitQsMinus26() {
        return this.picInitQsMinus26;
    }

    public int getPicParameterSetId() {
        return this.picParameterSetId;
    }

    public int[] getRunLengthMinus1() {
        return this.runLengthMinus1;
    }

    public int getSeqParameterSetId() {
        return this.seqParameterSetId;
    }

    public int getSliceGroupChangeRateMinus1() {
        return this.sliceGroupChangeRateMinus1;
    }

    public int[] getSliceGroupId() {
        return this.sliceGroupId;
    }

    public int getSliceGroupMapType() {
        return this.sliceGroupMapType;
    }

    public int[] getTopLeft() {
        return this.topLeft;
    }

    public int getWeightedBipredIdc() {
        return this.weightedBipredIdc;
    }

    public int hashCode() {
        int iHashCode = (((((((((Arrays.hashCode(this.bottomRight) + 31) * 31) + this.chromaQpIndexOffset) * 31) + (this.constrainedIntraPredFlag ? 1231 : 1237)) * 31) + (this.deblockingFilterControlPresentFlag ? 1231 : 1237)) * 31) + (this.entropyCodingModeFlag ? 1231 : 1237)) * 31;
        PPSExt pPSExt = this.extended;
        int iHashCode2 = (iHashCode + (pPSExt == null ? 0 : pPSExt.hashCode())) * 31;
        int[] iArr = this.numRefIdxActiveMinus1;
        return ((((((((((((((((((((((((((((((((iHashCode2 + iArr[0]) * 31) + iArr[1]) * 31) + this.numSliceGroupsMinus1) * 31) + this.picInitQpMinus26) * 31) + this.picInitQsMinus26) * 31) + (this.picOrderPresentFlag ? 1231 : 1237)) * 31) + this.picParameterSetId) * 31) + (this.redundantPicCntPresentFlag ? 1231 : 1237)) * 31) + Arrays.hashCode(this.runLengthMinus1)) * 31) + this.seqParameterSetId) * 31) + (this.sliceGroupChangeDirectionFlag ? 1231 : 1237)) * 31) + this.sliceGroupChangeRateMinus1) * 31) + Arrays.hashCode(this.sliceGroupId)) * 31) + this.sliceGroupMapType) * 31) + Arrays.hashCode(this.topLeft)) * 31) + this.weightedBipredIdc) * 31) + (this.weightedPredFlag ? 1231 : 1237);
    }

    public boolean isConstrainedIntraPredFlag() {
        return this.constrainedIntraPredFlag;
    }

    public boolean isDeblockingFilterControlPresentFlag() {
        return this.deblockingFilterControlPresentFlag;
    }

    public boolean isEntropyCodingModeFlag() {
        return this.entropyCodingModeFlag;
    }

    public boolean isPicOrderPresentFlag() {
        return this.picOrderPresentFlag;
    }

    public boolean isRedundantPicCntPresentFlag() {
        return this.redundantPicCntPresentFlag;
    }

    public boolean isSliceGroupChangeDirectionFlag() {
        return this.sliceGroupChangeDirectionFlag;
    }

    public boolean isWeightedPredFlag() {
        return this.weightedPredFlag;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        CAVLCWriter.writeUEtrace(bitWriter, this.picParameterSetId, "PPS: pic_parameter_set_id");
        CAVLCWriter.writeUEtrace(bitWriter, this.seqParameterSetId, "PPS: seq_parameter_set_id");
        CAVLCWriter.writeBool(bitWriter, this.entropyCodingModeFlag, "PPS: entropy_coding_mode_flag");
        CAVLCWriter.writeBool(bitWriter, this.picOrderPresentFlag, "PPS: pic_order_present_flag");
        CAVLCWriter.writeUEtrace(bitWriter, this.numSliceGroupsMinus1, "PPS: num_slice_groups_minus1");
        if (this.numSliceGroupsMinus1 > 0) {
            CAVLCWriter.writeUEtrace(bitWriter, this.sliceGroupMapType, "PPS: slice_group_map_type");
            int i = this.sliceGroupMapType;
            if (i == 0) {
                for (int i2 = 0; i2 <= this.numSliceGroupsMinus1; i2++) {
                    CAVLCWriter.writeUEtrace(bitWriter, this.runLengthMinus1[i2], "PPS: ");
                }
            } else if (i == 2) {
                for (int i3 = 0; i3 < this.numSliceGroupsMinus1; i3++) {
                    CAVLCWriter.writeUEtrace(bitWriter, this.topLeft[i3], "PPS: ");
                    CAVLCWriter.writeUEtrace(bitWriter, this.bottomRight[i3], "PPS: ");
                }
            } else if (i == 3 || i == 4 || i == 5) {
                CAVLCWriter.writeBool(bitWriter, this.sliceGroupChangeDirectionFlag, "PPS: slice_group_change_direction_flag");
                CAVLCWriter.writeUEtrace(bitWriter, this.sliceGroupChangeRateMinus1, "PPS: slice_group_change_rate_minus1");
            } else if (i == 6) {
                int i4 = this.numSliceGroupsMinus1;
                int i5 = i4 + 1 <= 4 ? i4 + 1 > 2 ? 2 : 1 : 3;
                CAVLCWriter.writeUEtrace(bitWriter, this.sliceGroupId.length, "PPS: ");
                int i6 = 0;
                while (true) {
                    int[] iArr = this.sliceGroupId;
                    if (i6 > iArr.length) {
                        break;
                    }
                    CAVLCWriter.writeU(bitWriter, iArr[i6], i5);
                    i6++;
                }
            }
        }
        CAVLCWriter.writeUEtrace(bitWriter, this.numRefIdxActiveMinus1[0], "PPS: num_ref_idx_l0_active_minus1");
        CAVLCWriter.writeUEtrace(bitWriter, this.numRefIdxActiveMinus1[1], "PPS: num_ref_idx_l1_active_minus1");
        CAVLCWriter.writeBool(bitWriter, this.weightedPredFlag, "PPS: weighted_pred_flag");
        CAVLCWriter.writeNBit(bitWriter, this.weightedBipredIdc, 2, "PPS: weighted_bipred_idc");
        CAVLCWriter.writeSEtrace(bitWriter, this.picInitQpMinus26, "PPS: pic_init_qp_minus26");
        CAVLCWriter.writeSEtrace(bitWriter, this.picInitQsMinus26, "PPS: pic_init_qs_minus26");
        CAVLCWriter.writeSEtrace(bitWriter, this.chromaQpIndexOffset, "PPS: chroma_qp_index_offset");
        CAVLCWriter.writeBool(bitWriter, this.deblockingFilterControlPresentFlag, "PPS: deblocking_filter_control_present_flag");
        CAVLCWriter.writeBool(bitWriter, this.constrainedIntraPredFlag, "PPS: constrained_intra_pred_flag");
        CAVLCWriter.writeBool(bitWriter, this.redundantPicCntPresentFlag, "PPS: redundant_pic_cnt_present_flag");
        PPSExt pPSExt = this.extended;
        if (pPSExt != null) {
            CAVLCWriter.writeBool(bitWriter, pPSExt.transform8x8ModeFlag, "PPS: transform_8x8_mode_flag");
            CAVLCWriter.writeBool(bitWriter, this.extended.scalingMatrix != null, "PPS: scalindMatrix");
            if (this.extended.scalingMatrix != null) {
                int i7 = 0;
                while (true) {
                    PPSExt pPSExt2 = this.extended;
                    if (i7 >= ((pPSExt2.transform8x8ModeFlag ? 1 : 0) * 2) + 6) {
                        break;
                    }
                    CAVLCWriter.writeBool(bitWriter, pPSExt2.scalingMatrix[i7] != null, "PPS: ");
                    int[][] iArr2 = this.extended.scalingMatrix;
                    if (iArr2[i7] != null) {
                        SeqParameterSet.writeScalingList(bitWriter, iArr2, i7);
                    }
                    i7++;
                }
            }
            CAVLCWriter.writeSEtrace(bitWriter, this.extended.secondChromaQpIndexOffset, "PPS: ");
        }
        CAVLCWriter.writeTrailingBits(bitWriter);
    }
}
