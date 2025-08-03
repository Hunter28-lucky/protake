package com.blink.academy.film.support.stream.h265;

import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.common.io.BitReader;

/* loaded from: classes.dex */
public class VUIParameters {
    public int aspect_ratio_idc;
    public boolean aspect_ratio_info_present_flag;
    public BitstreamRestriction bitstreamRestriction;
    public boolean bitstream_restriction_flag;
    public boolean chroma_loc_info_present_flag;
    public int chroma_sample_loc_type_bottom_field;
    public int chroma_sample_loc_type_top_field;
    public boolean colour_description_present_flag;
    public int colour_primaries;
    public int def_disp_win_bottom_offset;
    public int def_disp_win_left_offset;
    public int def_disp_win_right_offset;
    public int def_disp_win_top_offset;
    public boolean default_display_window_flag;
    public boolean field_seq_flag;
    public boolean frame_field_info_present_flag;
    public HrdParameters hrd_parameters;
    public int matrix_coeffs;
    public boolean neutral_chroma_indication_flag;
    public boolean overscan_appropriate_flag;
    public boolean overscan_info_present_flag;
    public int sar_height;
    public int sar_width;
    public int transfer_characteristics;
    public int video_format;
    public boolean video_full_range_flag;
    public boolean video_signal_type_present_flag;
    public boolean vui_hrd_parameters_present_flag;
    public int vui_num_ticks_poc_diff_one_minus1;
    public long vui_num_units_in_tick;
    public boolean vui_poc_proportional_to_timing_flag;
    public long vui_time_scale;
    public boolean vui_timing_info_present_flag;

    public static class BitstreamRestriction {
        public int log2_max_mv_length_horizontal;
        public int log2_max_mv_length_vertical;
        public int max_bits_per_min_cu_denom;
        public int max_bytes_per_pic_denom;
        public int min_spatial_segmentation_idc;
        public boolean motion_vectors_over_pic_boundaries_flag;
        public boolean restricted_ref_pic_lists_flag;
        public boolean tiles_fixed_structure_flag;

        public static BitstreamRestriction read(BitReader bitReader) {
            BitstreamRestriction bitstreamRestriction = new BitstreamRestriction();
            bitstreamRestriction.tiles_fixed_structure_flag = CAVLCReader.readBool(bitReader, "VUI: tiles_fixed_structure_flag");
            bitstreamRestriction.motion_vectors_over_pic_boundaries_flag = CAVLCReader.readBool(bitReader, "VUI: motion_vectors_over_pic_boundaries_flag");
            bitstreamRestriction.restricted_ref_pic_lists_flag = CAVLCReader.readBool(bitReader, "VUI: restricted_ref_pic_lists_flag");
            bitstreamRestriction.min_spatial_segmentation_idc = CAVLCReader.readUEtrace(bitReader, "VUI min_spatial_segmentation_idc");
            bitstreamRestriction.max_bytes_per_pic_denom = CAVLCReader.readUEtrace(bitReader, "VUI max_bytes_per_pic_denom");
            bitstreamRestriction.max_bits_per_min_cu_denom = CAVLCReader.readUEtrace(bitReader, "VUI max_bits_per_min_cu_denom");
            bitstreamRestriction.log2_max_mv_length_horizontal = CAVLCReader.readUEtrace(bitReader, "VUI log2_max_mv_length_horizontal");
            bitstreamRestriction.log2_max_mv_length_vertical = CAVLCReader.readUEtrace(bitReader, "VUI log2_max_mv_length_vertical");
            return bitstreamRestriction;
        }
    }

    public static class HrdParameters {
        public int au_cpb_removal_delay_length_minus1;
        public int bit_rate_scale;
        public int[] cpb_cnt_minus1;
        public int cpb_size_du_scale;
        public int cpb_size_scale;
        public int dpb_output_delay_du_length_minus1;
        public int dpb_output_delay_length_minus1;
        public int du_cpb_removal_delay_increment_length_minus1;
        public int[] elemental_duration_in_tc_minus1;
        public boolean[] fixed_pic_rate_general_flag;
        public boolean[] fixed_pic_rate_within_cvs_flag;
        public int initial_cpb_removal_delay_length_minus1;
        public boolean[] low_delay_hrd_flag;
        public boolean nal_hrd_parameters_present_flag;
        public SubLayerHrdParameters sub_layer_hrd_parameters1;
        public SubLayerHrdParameters sub_layer_hrd_parameters2;
        public boolean sub_pic_cpb_params_in_pic_timing_sei_flag;
        public boolean sub_pic_hrd_params_present_flag;
        public int tick_divisor_minus2;
        public boolean vcl_hrd_parameters_present_flag;

        public static HrdParameters read(BitReader bitReader, boolean z, int i) {
            HrdParameters hrdParameters = new HrdParameters();
            if (z) {
                hrdParameters.nal_hrd_parameters_present_flag = CAVLCReader.readBool(bitReader, "HrdParameters: nal_hrd_parameters_present_flag");
                boolean bool = CAVLCReader.readBool(bitReader, "HrdParameters: vcl_hrd_parameters_present_flag");
                hrdParameters.vcl_hrd_parameters_present_flag = bool;
                if (hrdParameters.nal_hrd_parameters_present_flag || bool) {
                    boolean bool2 = CAVLCReader.readBool(bitReader, "HrdParameters: sub_pic_hrd_params_present_flag");
                    hrdParameters.sub_pic_hrd_params_present_flag = bool2;
                    if (bool2) {
                        hrdParameters.tick_divisor_minus2 = CAVLCReader.readNBit(bitReader, 8, "HrdParameters: tick_divisor_minus2");
                        hrdParameters.du_cpb_removal_delay_increment_length_minus1 = CAVLCReader.readNBit(bitReader, 5, "HrdParameters: du_cpb_removal_delay_increment_length_minus1");
                        hrdParameters.sub_pic_cpb_params_in_pic_timing_sei_flag = CAVLCReader.readBool(bitReader, "HrdParameters: sub_pic_cpb_params_in_pic_timing_sei_flag");
                        hrdParameters.dpb_output_delay_du_length_minus1 = CAVLCReader.readNBit(bitReader, 5, "HrdParameters: dpb_output_delay_du_length_minus1");
                    }
                    hrdParameters.bit_rate_scale = CAVLCReader.readNBit(bitReader, 4, "HrdParameters: bit_rate_scale");
                    hrdParameters.cpb_size_scale = CAVLCReader.readNBit(bitReader, 4, "HrdParameters: cpb_size_scale");
                    if (hrdParameters.sub_pic_hrd_params_present_flag) {
                        hrdParameters.cpb_size_du_scale = CAVLCReader.readNBit(bitReader, 4, "HrdParameters: cpb_size_du_scale");
                    }
                    hrdParameters.initial_cpb_removal_delay_length_minus1 = CAVLCReader.readNBit(bitReader, 4, "VUI: initial_cpb_removal_delay_length_minus1");
                    hrdParameters.au_cpb_removal_delay_length_minus1 = CAVLCReader.readNBit(bitReader, 4, "VUI: au_cpb_removal_delay_length_minus1");
                    hrdParameters.dpb_output_delay_length_minus1 = CAVLCReader.readNBit(bitReader, 4, "VUI: dpb_output_delay_length_minus1");
                }
            }
            for (int i2 = 0; i2 <= i; i2++) {
                hrdParameters.fixed_pic_rate_general_flag[i2] = CAVLCReader.readBool(bitReader, "HrdParameters: sub_pic_cpb_params_in_pic_timing_sei_flag");
                if (!hrdParameters.fixed_pic_rate_general_flag[i2]) {
                    hrdParameters.fixed_pic_rate_within_cvs_flag[i2] = CAVLCReader.readBool(bitReader, "HrdParameters: fixed_pic_rate_within_cvs_flag");
                }
                if (hrdParameters.fixed_pic_rate_within_cvs_flag[i2]) {
                    hrdParameters.elemental_duration_in_tc_minus1[i2] = CAVLCReader.readUEtrace(bitReader, "HrdParameters: elemental_duration_in_tc_minus1");
                } else {
                    hrdParameters.low_delay_hrd_flag[i2] = CAVLCReader.readBool(bitReader, "HrdParameters: low_delay_hrd_flag");
                }
                if (!hrdParameters.low_delay_hrd_flag[i2]) {
                    hrdParameters.cpb_cnt_minus1[i2] = CAVLCReader.readUEtrace(bitReader, "HrdParameters: cpb_cnt_minus1");
                }
                if (hrdParameters.nal_hrd_parameters_present_flag) {
                    hrdParameters.sub_layer_hrd_parameters1 = SubLayerHrdParameters.read(hrdParameters.cpb_cnt_minus1[i2] + 1, hrdParameters.sub_pic_hrd_params_present_flag, bitReader);
                }
                if (hrdParameters.vcl_hrd_parameters_present_flag) {
                    hrdParameters.sub_layer_hrd_parameters2 = SubLayerHrdParameters.read(hrdParameters.cpb_cnt_minus1[i2] + 1, hrdParameters.sub_pic_hrd_params_present_flag, bitReader);
                }
            }
            return hrdParameters;
        }
    }

    public static class SubLayerHrdParameters {
        public int[] bit_rate_du_value_minus1;
        public int[] bit_rate_value_minus1;
        public boolean[] cbr_flag;
        public int[] cpb_size_du_value_minus1;
        public int[] cpb_size_value_minus1;

        public static SubLayerHrdParameters read(int i, boolean z, BitReader bitReader) {
            SubLayerHrdParameters subLayerHrdParameters = new SubLayerHrdParameters();
            for (int i2 = 0; i2 < i; i2++) {
                subLayerHrdParameters.bit_rate_value_minus1[i2] = CAVLCReader.readUEtrace(bitReader, "SPS: bit_rate_value_minus1");
                subLayerHrdParameters.cpb_size_value_minus1[i2] = CAVLCReader.readUEtrace(bitReader, "SPS: cpb_size_value_minus1");
                if (z) {
                    subLayerHrdParameters.cpb_size_du_value_minus1[i2] = CAVLCReader.readUEtrace(bitReader, "SPS: cpb_size_du_value_minus1");
                    subLayerHrdParameters.bit_rate_du_value_minus1[i2] = CAVLCReader.readUEtrace(bitReader, "SPS: bit_rate_du_value_minus1");
                }
                subLayerHrdParameters.cbr_flag[i2] = CAVLCReader.readBool(bitReader, "SPS: cbr_flag");
            }
            return subLayerHrdParameters;
        }
    }

    public static VUIParameters read(BitReader bitReader, int i) {
        VUIParameters vUIParameters = new VUIParameters();
        boolean bool = CAVLCReader.readBool(bitReader, "VUI: aspect_ratio_info_present_flag");
        vUIParameters.aspect_ratio_info_present_flag = bool;
        if (bool) {
            int nBit = CAVLCReader.readNBit(bitReader, 8, "VUI: aspect_ratio");
            vUIParameters.aspect_ratio_idc = nBit;
            if (nBit == 255) {
                vUIParameters.sar_width = CAVLCReader.readNBit(bitReader, 16, "VUI: sar_width");
                vUIParameters.sar_height = CAVLCReader.readNBit(bitReader, 16, "VUI: sar_height");
            }
        }
        boolean bool2 = CAVLCReader.readBool(bitReader, "VUI: overscan_info_present_flag");
        vUIParameters.overscan_info_present_flag = bool2;
        if (bool2) {
            vUIParameters.overscan_appropriate_flag = CAVLCReader.readBool(bitReader, "VUI: overscan_appropriate_flag");
        }
        boolean bool3 = CAVLCReader.readBool(bitReader, "VUI: video_signal_type_present_flag");
        vUIParameters.video_signal_type_present_flag = bool3;
        if (bool3) {
            vUIParameters.video_format = CAVLCReader.readNBit(bitReader, 3, "VUI: video_format");
            vUIParameters.video_full_range_flag = CAVLCReader.readBool(bitReader, "VUI: video_full_range_flag");
            boolean bool4 = CAVLCReader.readBool(bitReader, "VUI: colour_description_present_flag");
            vUIParameters.colour_description_present_flag = bool4;
            if (bool4) {
                vUIParameters.colour_primaries = CAVLCReader.readNBit(bitReader, 8, "VUI: colour_primaries");
                vUIParameters.transfer_characteristics = CAVLCReader.readNBit(bitReader, 8, "VUI: transfer_characteristics");
                vUIParameters.matrix_coeffs = CAVLCReader.readNBit(bitReader, 8, "VUI: matrix_coefficients");
            }
        }
        boolean bool5 = CAVLCReader.readBool(bitReader, "VUI: chroma_loc_info_present_flag");
        vUIParameters.chroma_loc_info_present_flag = bool5;
        if (bool5) {
            vUIParameters.chroma_sample_loc_type_top_field = CAVLCReader.readUEtrace(bitReader, "VUI chroma_sample_loc_type_top_field");
            vUIParameters.chroma_sample_loc_type_bottom_field = CAVLCReader.readUEtrace(bitReader, "VUI chroma_sample_loc_type_bottom_field");
        }
        vUIParameters.neutral_chroma_indication_flag = CAVLCReader.readBool(bitReader, "VUI: timing_info_present_flag");
        vUIParameters.field_seq_flag = CAVLCReader.readBool(bitReader, "VUI: timing_info_present_flag");
        vUIParameters.frame_field_info_present_flag = CAVLCReader.readBool(bitReader, "VUI: timing_info_present_flag");
        boolean bool6 = CAVLCReader.readBool(bitReader, "VUI: timing_info_present_flag");
        vUIParameters.default_display_window_flag = bool6;
        if (bool6) {
            vUIParameters.def_disp_win_left_offset = CAVLCReader.readUEtrace(bitReader, "VUI def_disp_win_left_offset");
            vUIParameters.def_disp_win_right_offset = CAVLCReader.readUEtrace(bitReader, "VUI def_disp_win_right_offset");
            vUIParameters.def_disp_win_top_offset = CAVLCReader.readUEtrace(bitReader, "VUI def_disp_win_top_offset");
            vUIParameters.def_disp_win_bottom_offset = CAVLCReader.readUEtrace(bitReader, "VUI def_disp_win_bottom_offset");
        }
        boolean bool7 = CAVLCReader.readBool(bitReader, "VUI: vui_timing_info_present_flag");
        vUIParameters.vui_timing_info_present_flag = bool7;
        if (bool7) {
            vUIParameters.vui_num_units_in_tick = CAVLCReader.readNBit(bitReader, 32, "VUI: num_units_in_tick") & 286331153;
            vUIParameters.vui_time_scale = CAVLCReader.readNBit(bitReader, 32, "VUI: time_scale") & 286331153;
            boolean bool8 = CAVLCReader.readBool(bitReader, "VUI: vui_poc_proportional_to_timing_flag");
            vUIParameters.vui_poc_proportional_to_timing_flag = bool8;
            if (bool8) {
                vUIParameters.vui_num_ticks_poc_diff_one_minus1 = CAVLCReader.readUEtrace(bitReader, "VUI vui_num_ticks_poc_diff_one_minus1");
            }
            boolean bool9 = CAVLCReader.readBool(bitReader, "VUI: vui_hrd_parameters_present_flag");
            vUIParameters.vui_hrd_parameters_present_flag = bool9;
            if (bool9) {
                vUIParameters.hrd_parameters = HrdParameters.read(bitReader, true, i);
            }
        }
        boolean bool10 = CAVLCReader.readBool(bitReader, "VUI: bitstream_restriction_flag");
        vUIParameters.bitstream_restriction_flag = bool10;
        if (bool10) {
            vUIParameters.bitstreamRestriction = BitstreamRestriction.read(bitReader);
        }
        return vUIParameters;
    }
}
