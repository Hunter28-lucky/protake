package org.jcodec.codecs.h264.io.model;

import androidx.core.view.InputDeviceCompat;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.model.VUIParameters;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class SeqParameterSet {
    public int bitDepthChromaMinus8;
    public int bitDepthLumaMinus8;
    public ColorSpace chromaFormatIdc;
    public boolean constraintSet0Flag;
    public boolean constraintSet1Flag;
    public boolean constraintSet2Flag;
    public boolean constraintSet3Flag;
    public boolean constraintSet4Flag;
    public boolean constraintSet5Flag;
    public boolean deltaPicOrderAlwaysZeroFlag;
    public boolean direct8x8InferenceFlag;
    public boolean fieldPicFlag;
    public int frameCropBottomOffset;
    public int frameCropLeftOffset;
    public int frameCropRightOffset;
    public int frameCropTopOffset;
    public boolean frameCroppingFlag;
    public boolean frameMbsOnlyFlag;
    public boolean gapsInFrameNumValueAllowedFlag;
    public int levelIdc;
    public int log2MaxFrameNumMinus4;
    public int log2MaxPicOrderCntLsbMinus4;
    public boolean mbAdaptiveFrameFieldFlag;
    public int numRefFrames;
    public int numRefFramesInPicOrderCntCycle;
    public int offsetForNonRefPic;
    public int[] offsetForRefFrame;
    public int offsetForTopToBottomField;
    public int picHeightInMapUnitsMinus1;
    public int picOrderCntType;
    public int picWidthInMbsMinus1;
    public int profileIdc;
    public boolean qpprimeYZeroTransformBypassFlag;
    public int[][] scalingMatrix;
    public boolean separateColourPlaneFlag;
    public int seqParameterSetId;
    public VUIParameters vuiParams;

    public static int fromColor(ColorSpace colorSpace) {
        if (colorSpace == ColorSpace.MONO) {
            return 0;
        }
        if (colorSpace == ColorSpace.YUV420J) {
            return 1;
        }
        if (colorSpace == ColorSpace.YUV422) {
            return 2;
        }
        if (colorSpace == ColorSpace.YUV444) {
            return 3;
        }
        throw new RuntimeException("Colorspace not supported");
    }

    public static ColorSpace getColor(int i) {
        if (i == 0) {
            return ColorSpace.MONO;
        }
        if (i == 1) {
            return ColorSpace.YUV420J;
        }
        if (i == 2) {
            return ColorSpace.YUV422;
        }
        if (i == 3) {
            return ColorSpace.YUV444;
        }
        throw new RuntimeException("Colorspace not supported");
    }

    public static int getPicHeightInMbs(SeqParameterSet seqParameterSet) {
        return (seqParameterSet.picHeightInMapUnitsMinus1 + 1) << (!seqParameterSet.frameMbsOnlyFlag ? 1 : 0);
    }

    public static SeqParameterSet read(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        SeqParameterSet seqParameterSet = new SeqParameterSet();
        seqParameterSet.profileIdc = CAVLCReader.readNBit(bitReaderCreateBitReader, 8, "SPS: profile_idc");
        seqParameterSet.constraintSet0Flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: constraint_set_0_flag");
        seqParameterSet.constraintSet1Flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: constraint_set_1_flag");
        seqParameterSet.constraintSet2Flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: constraint_set_2_flag");
        seqParameterSet.constraintSet3Flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: constraint_set_3_flag");
        seqParameterSet.constraintSet4Flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: constraint_set_4_flag");
        seqParameterSet.constraintSet5Flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: constraint_set_5_flag");
        CAVLCReader.readNBit(bitReaderCreateBitReader, 2, "SPS: reserved_zero_2bits");
        seqParameterSet.levelIdc = CAVLCReader.readNBit(bitReaderCreateBitReader, 8, "SPS: level_idc");
        seqParameterSet.seqParameterSetId = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: seq_parameter_set_id");
        int i = seqParameterSet.profileIdc;
        if (i == 100 || i == 110 || i == 122 || i == 144) {
            ColorSpace color = getColor(CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: chroma_format_idc"));
            seqParameterSet.chromaFormatIdc = color;
            if (color == ColorSpace.YUV444) {
                seqParameterSet.separateColourPlaneFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: separate_colour_plane_flag");
            }
            seqParameterSet.bitDepthLumaMinus8 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: bit_depth_luma_minus8");
            seqParameterSet.bitDepthChromaMinus8 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: bit_depth_chroma_minus8");
            seqParameterSet.qpprimeYZeroTransformBypassFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: qpprime_y_zero_transform_bypass_flag");
            if (CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: seq_scaling_matrix_present_lag")) {
                readScalingListMatrix(bitReaderCreateBitReader, seqParameterSet);
            }
        } else {
            seqParameterSet.chromaFormatIdc = ColorSpace.YUV420J;
        }
        seqParameterSet.log2MaxFrameNumMinus4 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_max_frame_num_minus4");
        int uEtrace = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: pic_order_cnt_type");
        seqParameterSet.picOrderCntType = uEtrace;
        if (uEtrace == 0) {
            seqParameterSet.log2MaxPicOrderCntLsbMinus4 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (uEtrace == 1) {
            seqParameterSet.deltaPicOrderAlwaysZeroFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: delta_pic_order_always_zero_flag");
            seqParameterSet.offsetForNonRefPic = CAVLCReader.readSE(bitReaderCreateBitReader, "SPS: offset_for_non_ref_pic");
            seqParameterSet.offsetForTopToBottomField = CAVLCReader.readSE(bitReaderCreateBitReader, "SPS: offset_for_top_to_bottom_field");
            int uEtrace2 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: num_ref_frames_in_pic_order_cnt_cycle");
            seqParameterSet.numRefFramesInPicOrderCntCycle = uEtrace2;
            seqParameterSet.offsetForRefFrame = new int[uEtrace2];
            for (int i2 = 0; i2 < seqParameterSet.numRefFramesInPicOrderCntCycle; i2++) {
                seqParameterSet.offsetForRefFrame[i2] = CAVLCReader.readSE(bitReaderCreateBitReader, "SPS: offsetForRefFrame [" + i2 + "]");
            }
        }
        seqParameterSet.numRefFrames = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: num_ref_frames");
        seqParameterSet.gapsInFrameNumValueAllowedFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: gaps_in_frame_num_value_allowed_flag");
        seqParameterSet.picWidthInMbsMinus1 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: pic_width_in_mbs_minus1");
        seqParameterSet.picHeightInMapUnitsMinus1 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: pic_height_in_map_units_minus1");
        boolean bool = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: frame_mbs_only_flag");
        seqParameterSet.frameMbsOnlyFlag = bool;
        if (!bool) {
            seqParameterSet.mbAdaptiveFrameFieldFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: mb_adaptive_frame_field_flag");
        }
        seqParameterSet.direct8x8InferenceFlag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: direct_8x8_inference_flag");
        boolean bool2 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: frame_cropping_flag");
        seqParameterSet.frameCroppingFlag = bool2;
        if (bool2) {
            seqParameterSet.frameCropLeftOffset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: frame_crop_left_offset");
            seqParameterSet.frameCropRightOffset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: frame_crop_right_offset");
            seqParameterSet.frameCropTopOffset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: frame_crop_top_offset");
            seqParameterSet.frameCropBottomOffset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: frame_crop_bottom_offset");
        }
        if (CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: vui_parameters_present_flag")) {
            seqParameterSet.vuiParams = readVUIParameters(bitReaderCreateBitReader);
        }
        return seqParameterSet;
    }

    private static HRDParameters readHRDParameters(BitReader bitReader) {
        HRDParameters hRDParameters = new HRDParameters();
        hRDParameters.cpbCntMinus1 = CAVLCReader.readUEtrace(bitReader, "SPS: cpb_cnt_minus1");
        hRDParameters.bitRateScale = CAVLCReader.readNBit(bitReader, 4, "HRD: bit_rate_scale");
        hRDParameters.cpbSizeScale = CAVLCReader.readNBit(bitReader, 4, "HRD: cpb_size_scale");
        int i = hRDParameters.cpbCntMinus1;
        hRDParameters.bitRateValueMinus1 = new int[i + 1];
        hRDParameters.cpbSizeValueMinus1 = new int[i + 1];
        hRDParameters.cbrFlag = new boolean[i + 1];
        for (int i2 = 0; i2 <= hRDParameters.cpbCntMinus1; i2++) {
            hRDParameters.bitRateValueMinus1[i2] = CAVLCReader.readUEtrace(bitReader, "HRD: bit_rate_value_minus1");
            hRDParameters.cpbSizeValueMinus1[i2] = CAVLCReader.readUEtrace(bitReader, "HRD: cpb_size_value_minus1");
            hRDParameters.cbrFlag[i2] = CAVLCReader.readBool(bitReader, "HRD: cbr_flag");
        }
        hRDParameters.initialCpbRemovalDelayLengthMinus1 = CAVLCReader.readNBit(bitReader, 5, "HRD: initial_cpb_removal_delay_length_minus1");
        hRDParameters.cpbRemovalDelayLengthMinus1 = CAVLCReader.readNBit(bitReader, 5, "HRD: cpb_removal_delay_length_minus1");
        hRDParameters.dpbOutputDelayLengthMinus1 = CAVLCReader.readNBit(bitReader, 5, "HRD: dpb_output_delay_length_minus1");
        hRDParameters.timeOffsetLength = CAVLCReader.readNBit(bitReader, 5, "HRD: time_offset_length");
        return hRDParameters;
    }

    public static int[] readScalingList(BitReader bitReader, int i) {
        int[] iArr = new int[i];
        int se = 8;
        int i2 = 8;
        for (int i3 = 0; i3 < i; i3++) {
            if (se != 0) {
                se = ((CAVLCReader.readSE(bitReader, "deltaScale") + i2) + 256) % 256;
                if (i3 == 0 && se == 0) {
                    return null;
                }
            }
            if (se != 0) {
                i2 = se;
            }
            iArr[i3] = i2;
        }
        return iArr;
    }

    private static void readScalingListMatrix(BitReader bitReader, SeqParameterSet seqParameterSet) {
        seqParameterSet.scalingMatrix = new int[8][];
        int i = 0;
        while (i < 8) {
            if (CAVLCReader.readBool(bitReader, "SPS: seqScalingListPresentFlag")) {
                seqParameterSet.scalingMatrix[i] = readScalingList(bitReader, i < 6 ? 16 : 64);
            }
            i++;
        }
    }

    private static VUIParameters readVUIParameters(BitReader bitReader) {
        VUIParameters vUIParameters = new VUIParameters();
        boolean bool = CAVLCReader.readBool(bitReader, "VUI: aspect_ratio_info_present_flag");
        vUIParameters.aspectRatioInfoPresentFlag = bool;
        if (bool) {
            AspectRatio aspectRatioFromValue = AspectRatio.fromValue(CAVLCReader.readNBit(bitReader, 8, "VUI: aspect_ratio"));
            vUIParameters.aspectRatio = aspectRatioFromValue;
            if (aspectRatioFromValue == AspectRatio.Extended_SAR) {
                vUIParameters.sarWidth = CAVLCReader.readNBit(bitReader, 16, "VUI: sar_width");
                vUIParameters.sarHeight = CAVLCReader.readNBit(bitReader, 16, "VUI: sar_height");
            }
        }
        boolean bool2 = CAVLCReader.readBool(bitReader, "VUI: overscan_info_present_flag");
        vUIParameters.overscanInfoPresentFlag = bool2;
        if (bool2) {
            vUIParameters.overscanAppropriateFlag = CAVLCReader.readBool(bitReader, "VUI: overscan_appropriate_flag");
        }
        boolean bool3 = CAVLCReader.readBool(bitReader, "VUI: video_signal_type_present_flag");
        vUIParameters.videoSignalTypePresentFlag = bool3;
        if (bool3) {
            vUIParameters.videoFormat = CAVLCReader.readNBit(bitReader, 3, "VUI: video_format");
            vUIParameters.videoFullRangeFlag = CAVLCReader.readBool(bitReader, "VUI: video_full_range_flag");
            boolean bool4 = CAVLCReader.readBool(bitReader, "VUI: colour_description_present_flag");
            vUIParameters.colourDescriptionPresentFlag = bool4;
            if (bool4) {
                vUIParameters.colourPrimaries = CAVLCReader.readNBit(bitReader, 8, "VUI: colour_primaries");
                vUIParameters.transferCharacteristics = CAVLCReader.readNBit(bitReader, 8, "VUI: transfer_characteristics");
                vUIParameters.matrixCoefficients = CAVLCReader.readNBit(bitReader, 8, "VUI: matrix_coefficients");
            }
        }
        boolean bool5 = CAVLCReader.readBool(bitReader, "VUI: chroma_loc_info_present_flag");
        vUIParameters.chromaLocInfoPresentFlag = bool5;
        if (bool5) {
            vUIParameters.chromaSampleLocTypeTopField = CAVLCReader.readUEtrace(bitReader, "VUI chroma_sample_loc_type_top_field");
            vUIParameters.chromaSampleLocTypeBottomField = CAVLCReader.readUEtrace(bitReader, "VUI chroma_sample_loc_type_bottom_field");
        }
        boolean bool6 = CAVLCReader.readBool(bitReader, "VUI: timing_info_present_flag");
        vUIParameters.timingInfoPresentFlag = bool6;
        if (bool6) {
            vUIParameters.numUnitsInTick = CAVLCReader.readNBit(bitReader, 32, "VUI: num_units_in_tick");
            vUIParameters.timeScale = CAVLCReader.readNBit(bitReader, 32, "VUI: time_scale");
            vUIParameters.fixedFrameRateFlag = CAVLCReader.readBool(bitReader, "VUI: fixed_frame_rate_flag");
        }
        boolean bool7 = CAVLCReader.readBool(bitReader, "VUI: nal_hrd_parameters_present_flag");
        if (bool7) {
            vUIParameters.nalHRDParams = readHRDParameters(bitReader);
        }
        boolean bool8 = CAVLCReader.readBool(bitReader, "VUI: vcl_hrd_parameters_present_flag");
        if (bool8) {
            vUIParameters.vclHRDParams = readHRDParameters(bitReader);
        }
        if (bool7 || bool8) {
            vUIParameters.lowDelayHrdFlag = CAVLCReader.readBool(bitReader, "VUI: low_delay_hrd_flag");
        }
        vUIParameters.picStructPresentFlag = CAVLCReader.readBool(bitReader, "VUI: pic_struct_present_flag");
        if (CAVLCReader.readBool(bitReader, "VUI: bitstream_restriction_flag")) {
            VUIParameters.BitstreamRestriction bitstreamRestriction = new VUIParameters.BitstreamRestriction();
            vUIParameters.bitstreamRestriction = bitstreamRestriction;
            bitstreamRestriction.motionVectorsOverPicBoundariesFlag = CAVLCReader.readBool(bitReader, "VUI: motion_vectors_over_pic_boundaries_flag");
            vUIParameters.bitstreamRestriction.maxBytesPerPicDenom = CAVLCReader.readUEtrace(bitReader, "VUI max_bytes_per_pic_denom");
            vUIParameters.bitstreamRestriction.maxBitsPerMbDenom = CAVLCReader.readUEtrace(bitReader, "VUI max_bits_per_mb_denom");
            vUIParameters.bitstreamRestriction.log2MaxMvLengthHorizontal = CAVLCReader.readUEtrace(bitReader, "VUI log2_max_mv_length_horizontal");
            vUIParameters.bitstreamRestriction.log2MaxMvLengthVertical = CAVLCReader.readUEtrace(bitReader, "VUI log2_max_mv_length_vertical");
            vUIParameters.bitstreamRestriction.numReorderFrames = CAVLCReader.readUEtrace(bitReader, "VUI num_reorder_frames");
            vUIParameters.bitstreamRestriction.maxDecFrameBuffering = CAVLCReader.readUEtrace(bitReader, "VUI max_dec_frame_buffering");
        }
        return vUIParameters;
    }

    private void writeHRDParameters(HRDParameters hRDParameters, BitWriter bitWriter) {
        CAVLCWriter.writeUEtrace(bitWriter, hRDParameters.cpbCntMinus1, "HRD: cpb_cnt_minus1");
        CAVLCWriter.writeNBit(bitWriter, hRDParameters.bitRateScale, 4, "HRD: bit_rate_scale");
        CAVLCWriter.writeNBit(bitWriter, hRDParameters.cpbSizeScale, 4, "HRD: cpb_size_scale");
        for (int i = 0; i <= hRDParameters.cpbCntMinus1; i++) {
            CAVLCWriter.writeUEtrace(bitWriter, hRDParameters.bitRateValueMinus1[i], "HRD: ");
            CAVLCWriter.writeUEtrace(bitWriter, hRDParameters.cpbSizeValueMinus1[i], "HRD: ");
            CAVLCWriter.writeBool(bitWriter, hRDParameters.cbrFlag[i], "HRD: ");
        }
        CAVLCWriter.writeNBit(bitWriter, hRDParameters.initialCpbRemovalDelayLengthMinus1, 5, "HRD: initial_cpb_removal_delay_length_minus1");
        CAVLCWriter.writeNBit(bitWriter, hRDParameters.cpbRemovalDelayLengthMinus1, 5, "HRD: cpb_removal_delay_length_minus1");
        CAVLCWriter.writeNBit(bitWriter, hRDParameters.dpbOutputDelayLengthMinus1, 5, "HRD: dpb_output_delay_length_minus1");
        CAVLCWriter.writeNBit(bitWriter, hRDParameters.timeOffsetLength, 5, "HRD: time_offset_length");
    }

    public static void writeScalingList(BitWriter bitWriter, int[][] iArr, int i) {
        boolean zArrayEqualsInt;
        switch (i) {
            case 0:
                zArrayEqualsInt = Platform.arrayEqualsInt(iArr[i], H264Const.defaultScalingList4x4Intra);
                break;
            case 1:
            case 2:
                zArrayEqualsInt = Platform.arrayEqualsInt(iArr[i], iArr[0]);
                break;
            case 3:
                zArrayEqualsInt = Platform.arrayEqualsInt(iArr[i], H264Const.defaultScalingList4x4Inter);
                break;
            case 4:
            case 5:
                zArrayEqualsInt = Platform.arrayEqualsInt(iArr[i], iArr[3]);
                break;
            case 6:
                zArrayEqualsInt = Platform.arrayEqualsInt(iArr[i], H264Const.defaultScalingList8x8Intra);
                break;
            case 7:
                zArrayEqualsInt = Platform.arrayEqualsInt(iArr[i], H264Const.defaultScalingList8x8Inter);
                break;
            default:
                zArrayEqualsInt = false;
                break;
        }
        int[] iArr2 = iArr[i];
        if (zArrayEqualsInt) {
            CAVLCWriter.writeSEtrace(bitWriter, -8, "SPS: ");
            return;
        }
        int i2 = 8;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            CAVLCWriter.writeSEtrace(bitWriter, (iArr2[i3] - i2) + InputDeviceCompat.SOURCE_ANY, "SPS: ");
            i2 = iArr2[i3];
        }
    }

    private void writeVUIParameters(VUIParameters vUIParameters, BitWriter bitWriter) {
        CAVLCWriter.writeBool(bitWriter, vUIParameters.aspectRatioInfoPresentFlag, "VUI: aspect_ratio_info_present_flag");
        if (vUIParameters.aspectRatioInfoPresentFlag) {
            CAVLCWriter.writeNBit(bitWriter, vUIParameters.aspectRatio.getValue(), 8, "VUI: aspect_ratio");
            if (vUIParameters.aspectRatio == AspectRatio.Extended_SAR) {
                CAVLCWriter.writeNBit(bitWriter, vUIParameters.sarWidth, 16, "VUI: sar_width");
                CAVLCWriter.writeNBit(bitWriter, vUIParameters.sarHeight, 16, "VUI: sar_height");
            }
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.overscanInfoPresentFlag, "VUI: overscan_info_present_flag");
        if (vUIParameters.overscanInfoPresentFlag) {
            CAVLCWriter.writeBool(bitWriter, vUIParameters.overscanAppropriateFlag, "VUI: overscan_appropriate_flag");
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.videoSignalTypePresentFlag, "VUI: video_signal_type_present_flag");
        if (vUIParameters.videoSignalTypePresentFlag) {
            CAVLCWriter.writeNBit(bitWriter, vUIParameters.videoFormat, 3, "VUI: video_format");
            CAVLCWriter.writeBool(bitWriter, vUIParameters.videoFullRangeFlag, "VUI: video_full_range_flag");
            CAVLCWriter.writeBool(bitWriter, vUIParameters.colourDescriptionPresentFlag, "VUI: colour_description_present_flag");
            if (vUIParameters.colourDescriptionPresentFlag) {
                CAVLCWriter.writeNBit(bitWriter, vUIParameters.colourPrimaries, 8, "VUI: colour_primaries");
                CAVLCWriter.writeNBit(bitWriter, vUIParameters.transferCharacteristics, 8, "VUI: transfer_characteristics");
                CAVLCWriter.writeNBit(bitWriter, vUIParameters.matrixCoefficients, 8, "VUI: matrix_coefficients");
            }
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.chromaLocInfoPresentFlag, "VUI: chroma_loc_info_present_flag");
        if (vUIParameters.chromaLocInfoPresentFlag) {
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.chromaSampleLocTypeTopField, "VUI: chroma_sample_loc_type_top_field");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.chromaSampleLocTypeBottomField, "VUI: chroma_sample_loc_type_bottom_field");
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.timingInfoPresentFlag, "VUI: timing_info_present_flag");
        if (vUIParameters.timingInfoPresentFlag) {
            CAVLCWriter.writeNBit(bitWriter, vUIParameters.numUnitsInTick, 32, "VUI: num_units_in_tick");
            CAVLCWriter.writeNBit(bitWriter, vUIParameters.timeScale, 32, "VUI: time_scale");
            CAVLCWriter.writeBool(bitWriter, vUIParameters.fixedFrameRateFlag, "VUI: fixed_frame_rate_flag");
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.nalHRDParams != null, "VUI: ");
        HRDParameters hRDParameters = vUIParameters.nalHRDParams;
        if (hRDParameters != null) {
            writeHRDParameters(hRDParameters, bitWriter);
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.vclHRDParams != null, "VUI: ");
        HRDParameters hRDParameters2 = vUIParameters.vclHRDParams;
        if (hRDParameters2 != null) {
            writeHRDParameters(hRDParameters2, bitWriter);
        }
        if (vUIParameters.nalHRDParams != null || vUIParameters.vclHRDParams != null) {
            CAVLCWriter.writeBool(bitWriter, vUIParameters.lowDelayHrdFlag, "VUI: low_delay_hrd_flag");
        }
        CAVLCWriter.writeBool(bitWriter, vUIParameters.picStructPresentFlag, "VUI: pic_struct_present_flag");
        CAVLCWriter.writeBool(bitWriter, vUIParameters.bitstreamRestriction != null, "VUI: ");
        VUIParameters.BitstreamRestriction bitstreamRestriction = vUIParameters.bitstreamRestriction;
        if (bitstreamRestriction != null) {
            CAVLCWriter.writeBool(bitWriter, bitstreamRestriction.motionVectorsOverPicBoundariesFlag, "VUI: motion_vectors_over_pic_boundaries_flag");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.bitstreamRestriction.maxBytesPerPicDenom, "VUI: max_bytes_per_pic_denom");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.bitstreamRestriction.maxBitsPerMbDenom, "VUI: max_bits_per_mb_denom");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.bitstreamRestriction.log2MaxMvLengthHorizontal, "VUI: log2_max_mv_length_horizontal");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.bitstreamRestriction.log2MaxMvLengthVertical, "VUI: log2_max_mv_length_vertical");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.bitstreamRestriction.numReorderFrames, "VUI: num_reorder_frames");
            CAVLCWriter.writeUEtrace(bitWriter, vUIParameters.bitstreamRestriction.maxDecFrameBuffering, "VUI: max_dec_frame_buffering");
        }
    }

    public SeqParameterSet copy() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2048);
        write(byteBufferAllocate);
        byteBufferAllocate.flip();
        return read(byteBufferAllocate);
    }

    public int getBitDepthChromaMinus8() {
        return this.bitDepthChromaMinus8;
    }

    public int getBitDepthLumaMinus8() {
        return this.bitDepthLumaMinus8;
    }

    public ColorSpace getChromaFormatIdc() {
        return this.chromaFormatIdc;
    }

    public int getFrameCropBottomOffset() {
        return this.frameCropBottomOffset;
    }

    public int getFrameCropLeftOffset() {
        return this.frameCropLeftOffset;
    }

    public int getFrameCropRightOffset() {
        return this.frameCropRightOffset;
    }

    public int getFrameCropTopOffset() {
        return this.frameCropTopOffset;
    }

    public int getLevelIdc() {
        return this.levelIdc;
    }

    public int getLog2MaxFrameNumMinus4() {
        return this.log2MaxFrameNumMinus4;
    }

    public int getLog2MaxPicOrderCntLsbMinus4() {
        return this.log2MaxPicOrderCntLsbMinus4;
    }

    public int getNumRefFrames() {
        return this.numRefFrames;
    }

    public int getNumRefFramesInPicOrderCntCycle() {
        return this.numRefFramesInPicOrderCntCycle;
    }

    public int getOffsetForNonRefPic() {
        return this.offsetForNonRefPic;
    }

    public int[] getOffsetForRefFrame() {
        return this.offsetForRefFrame;
    }

    public int getOffsetForTopToBottomField() {
        return this.offsetForTopToBottomField;
    }

    public int getPicHeightInMapUnitsMinus1() {
        return this.picHeightInMapUnitsMinus1;
    }

    public int getPicOrderCntType() {
        return this.picOrderCntType;
    }

    public int getPicWidthInMbsMinus1() {
        return this.picWidthInMbsMinus1;
    }

    public int getProfileIdc() {
        return this.profileIdc;
    }

    public int[][] getScalingMatrix() {
        return this.scalingMatrix;
    }

    public int getSeqParameterSetId() {
        return this.seqParameterSetId;
    }

    public VUIParameters getVuiParams() {
        return this.vuiParams;
    }

    public boolean isConstraintSet0Flag() {
        return this.constraintSet0Flag;
    }

    public boolean isConstraintSet1Flag() {
        return this.constraintSet1Flag;
    }

    public boolean isConstraintSet2Flag() {
        return this.constraintSet2Flag;
    }

    public boolean isConstraintSet3Flag() {
        return this.constraintSet3Flag;
    }

    public boolean isConstraintSet4Flag() {
        return this.constraintSet4Flag;
    }

    public boolean isConstraintSet5Flag() {
        return this.constraintSet5Flag;
    }

    public boolean isDeltaPicOrderAlwaysZeroFlag() {
        return this.deltaPicOrderAlwaysZeroFlag;
    }

    public boolean isDirect8x8InferenceFlag() {
        return this.direct8x8InferenceFlag;
    }

    public boolean isFieldPicFlag() {
        return this.fieldPicFlag;
    }

    public boolean isFrameCroppingFlag() {
        return this.frameCroppingFlag;
    }

    public boolean isFrameMbsOnlyFlag() {
        return this.frameMbsOnlyFlag;
    }

    public boolean isGapsInFrameNumValueAllowedFlag() {
        return this.gapsInFrameNumValueAllowedFlag;
    }

    public boolean isMbAdaptiveFrameFieldFlag() {
        return this.mbAdaptiveFrameFieldFlag;
    }

    public boolean isQpprimeYZeroTransformBypassFlag() {
        return this.qpprimeYZeroTransformBypassFlag;
    }

    public boolean isResidualColorTransformFlag() {
        return this.separateColourPlaneFlag;
    }

    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        CAVLCWriter.writeNBit(bitWriter, this.profileIdc, 8, "SPS: profile_idc");
        CAVLCWriter.writeBool(bitWriter, this.constraintSet0Flag, "SPS: constraint_set_0_flag");
        CAVLCWriter.writeBool(bitWriter, this.constraintSet1Flag, "SPS: constraint_set_1_flag");
        CAVLCWriter.writeBool(bitWriter, this.constraintSet2Flag, "SPS: constraint_set_2_flag");
        CAVLCWriter.writeBool(bitWriter, this.constraintSet3Flag, "SPS: constraint_set_3_flag");
        CAVLCWriter.writeBool(bitWriter, this.constraintSet4Flag, "SPS: constraint_set_4_flag");
        CAVLCWriter.writeBool(bitWriter, this.constraintSet5Flag, "SPS: constraint_set_5_flag");
        CAVLCWriter.writeNBit(bitWriter, 0L, 2, "SPS: reserved");
        CAVLCWriter.writeNBit(bitWriter, this.levelIdc, 8, "SPS: level_idc");
        CAVLCWriter.writeUEtrace(bitWriter, this.seqParameterSetId, "SPS: seq_parameter_set_id");
        int i = this.profileIdc;
        if (i == 100 || i == 110 || i == 122 || i == 144) {
            CAVLCWriter.writeUEtrace(bitWriter, fromColor(this.chromaFormatIdc), "SPS: chroma_format_idc");
            if (this.chromaFormatIdc == ColorSpace.YUV444) {
                CAVLCWriter.writeBool(bitWriter, this.separateColourPlaneFlag, "SPS: residual_color_transform_flag");
            }
            CAVLCWriter.writeUEtrace(bitWriter, this.bitDepthLumaMinus8, "SPS: ");
            CAVLCWriter.writeUEtrace(bitWriter, this.bitDepthChromaMinus8, "SPS: ");
            CAVLCWriter.writeBool(bitWriter, this.qpprimeYZeroTransformBypassFlag, "SPS: qpprime_y_zero_transform_bypass_flag");
            CAVLCWriter.writeBool(bitWriter, this.scalingMatrix != null, "SPS: ");
            if (this.scalingMatrix != null) {
                for (int i2 = 0; i2 < 8; i2++) {
                    CAVLCWriter.writeBool(bitWriter, this.scalingMatrix[i2] != null, "SPS: ");
                    int[][] iArr = this.scalingMatrix;
                    if (iArr[i2] != null) {
                        writeScalingList(bitWriter, iArr, i2);
                    }
                }
            }
        }
        CAVLCWriter.writeUEtrace(bitWriter, this.log2MaxFrameNumMinus4, "SPS: log2_max_frame_num_minus4");
        CAVLCWriter.writeUEtrace(bitWriter, this.picOrderCntType, "SPS: pic_order_cnt_type");
        int i3 = this.picOrderCntType;
        if (i3 == 0) {
            CAVLCWriter.writeUEtrace(bitWriter, this.log2MaxPicOrderCntLsbMinus4, "SPS: log2_max_pic_order_cnt_lsb_minus4");
        } else if (i3 == 1) {
            CAVLCWriter.writeBool(bitWriter, this.deltaPicOrderAlwaysZeroFlag, "SPS: delta_pic_order_always_zero_flag");
            CAVLCWriter.writeSEtrace(bitWriter, this.offsetForNonRefPic, "SPS: offset_for_non_ref_pic");
            CAVLCWriter.writeSEtrace(bitWriter, this.offsetForTopToBottomField, "SPS: offset_for_top_to_bottom_field");
            CAVLCWriter.writeUEtrace(bitWriter, this.offsetForRefFrame.length, "SPS: ");
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.offsetForRefFrame;
                if (i4 >= iArr2.length) {
                    break;
                }
                CAVLCWriter.writeSEtrace(bitWriter, iArr2[i4], "SPS: ");
                i4++;
            }
        }
        CAVLCWriter.writeUEtrace(bitWriter, this.numRefFrames, "SPS: num_ref_frames");
        CAVLCWriter.writeBool(bitWriter, this.gapsInFrameNumValueAllowedFlag, "SPS: gaps_in_frame_num_value_allowed_flag");
        CAVLCWriter.writeUEtrace(bitWriter, this.picWidthInMbsMinus1, "SPS: pic_width_in_mbs_minus1");
        CAVLCWriter.writeUEtrace(bitWriter, this.picHeightInMapUnitsMinus1, "SPS: pic_height_in_map_units_minus1");
        CAVLCWriter.writeBool(bitWriter, this.frameMbsOnlyFlag, "SPS: frame_mbs_only_flag");
        if (!this.frameMbsOnlyFlag) {
            CAVLCWriter.writeBool(bitWriter, this.mbAdaptiveFrameFieldFlag, "SPS: mb_adaptive_frame_field_flag");
        }
        CAVLCWriter.writeBool(bitWriter, this.direct8x8InferenceFlag, "SPS: direct_8x8_inference_flag");
        CAVLCWriter.writeBool(bitWriter, this.frameCroppingFlag, "SPS: frame_cropping_flag");
        if (this.frameCroppingFlag) {
            CAVLCWriter.writeUEtrace(bitWriter, this.frameCropLeftOffset, "SPS: frame_crop_left_offset");
            CAVLCWriter.writeUEtrace(bitWriter, this.frameCropRightOffset, "SPS: frame_crop_right_offset");
            CAVLCWriter.writeUEtrace(bitWriter, this.frameCropTopOffset, "SPS: frame_crop_top_offset");
            CAVLCWriter.writeUEtrace(bitWriter, this.frameCropBottomOffset, "SPS: frame_crop_bottom_offset");
        }
        CAVLCWriter.writeBool(bitWriter, this.vuiParams != null, "SPS: ");
        VUIParameters vUIParameters = this.vuiParams;
        if (vUIParameters != null) {
            writeVUIParameters(vUIParameters, bitWriter);
        }
        CAVLCWriter.writeTrailingBits(bitWriter);
    }
}
