package com.blink.academy.film.support.stream.h265;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.common.io.BitReader;

/* loaded from: classes.dex */
public class H265SeqParameterSetRBSP {
    public int SubHeightC;
    public int SubWidthC;
    public boolean amp_enabled_flag;
    public int bit_depth_chroma_minus8;
    public int bit_depth_luma_minus8;
    public int chroma_format_idc;
    public int conf_win_bottom_offset;
    public int conf_win_left_offset;
    public int conf_win_right_offset;
    public int conf_win_top_offset;
    public boolean conformance_window_flag;
    public int log2_diff_max_min_luma_coding_block_size;
    public int log2_diff_max_min_luma_transform_block_size;
    public int log2_diff_max_min_pcm_luma_coding_block_size;
    public int log2_max_pic_order_cnt_lsb_minus4;
    public int log2_min_luma_coding_block_size_minus3;
    public int log2_min_luma_transform_block_size_minus2;
    public int log2_min_pcm_luma_coding_block_size_minus3;
    public boolean long_term_ref_pics_present_flag;
    public int[] lt_ref_pic_poc_lsb_sps;
    public int max_transform_hierarchy_depth_inter;
    public int max_transform_hierarchy_depth_intra;
    public int num_long_term_ref_pics_sps;
    public int num_short_term_ref_pic_sets;
    public boolean pcm_enabled_flag;
    public boolean pcm_loop_filter_disabled_flag;
    public int pcm_sample_bit_depth_chroma_minus1;
    public int pcm_sample_bit_depth_luma_minus1;
    public int pic_height_in_luma_samples;
    public int pic_width_in_luma_samples;
    public ProfileTierLevel profile_tier_level;
    public boolean sample_adaptive_offset_enabled_flag;
    public ScalingListData scaling_list_data;
    public boolean scaling_list_enabled_flag;
    public boolean separate_colour_plane_flag;
    public boolean sps_3d_extension_flag;
    public int sps_extension_4bits;
    public boolean sps_extension_data_flag;
    public boolean sps_extension_present_flag;
    public int[] sps_max_dec_pic_buffering_minus1;
    public int[] sps_max_latency_increase_plus1;
    public int[] sps_max_num_reorder_pics;
    public int sps_max_sub_layers_minus1;
    public boolean sps_multilayer_extension_flag;
    public boolean sps_range_extension_flag;
    public boolean sps_scaling_list_data_present_flag;
    public boolean sps_scc_extension_flag;
    public int sps_seq_parameter_set_id;
    public boolean sps_sub_layer_ordering_info_present_flag;
    public boolean sps_temporal_id_nesting_flag;
    public boolean sps_temporal_mvp_enabled_flag;
    public int sps_video_parameter_set_id;
    public StRefPicSet[] st_ref_pic_set;
    public boolean strong_intra_smoothing_enabled_flag;
    public boolean[] used_by_curr_pic_lt_sps_flag;
    public VUIParameters vui_parameters;
    public boolean vui_parameters_present_flag;

    public static class ProfileTierLevel {
        public boolean general_frame_only_constraint_flag;
        public boolean general_inbld_flag;
        public boolean general_interlaced_source_flag;
        public boolean general_intra_constraint_flag;
        public int general_level_idc;
        public boolean general_lower_bit_rate_constraint_flag;
        public boolean general_max_10bit_constraint_flag;
        public boolean general_max_12bit_constraint_flag;
        public boolean general_max_14bit_constraint_flag;
        public boolean general_max_420chroma_constraint_flag;
        public boolean general_max_422chroma_constraint_flag;
        public boolean general_max_8bit_constraint_flag;
        public boolean general_max_monochrome_constraint_flag;
        public boolean general_non_packed_constraint_flag;
        public boolean general_one_picture_only_constraint_flag;
        public boolean[] general_profile_compatibility_flag;
        public int general_profile_idc;
        public int general_profile_space;
        public boolean general_progressive_source_flag;
        public long general_reserved_zero_33bits;
        public long general_reserved_zero_34bits;
        public long general_reserved_zero_35bits;
        public long general_reserved_zero_43bits;
        public int general_reserved_zero_7bits;
        public boolean general_reserved_zero_bit;
        public boolean general_tier_flag;
        public int[] reserved_zero_2bits;
        public boolean[] sub_layer_frame_only_constraint_flag;
        public boolean[] sub_layer_inbld_flag;
        public boolean[] sub_layer_interlaced_source_flag;
        public boolean[] sub_layer_intra_constraint_flag;
        public int[] sub_layer_level_idc;
        public boolean[] sub_layer_level_present_flag;
        public boolean[] sub_layer_lower_bit_rate_constraint_flag;
        public boolean[] sub_layer_max_10bit_constraint_flag;
        public boolean[] sub_layer_max_12bit_constraint_flag;
        public boolean[] sub_layer_max_14bit_constraint_flag;
        public boolean[] sub_layer_max_420chroma_constraint_flag;
        public boolean[] sub_layer_max_422chroma_constraint_flag;
        public boolean[] sub_layer_max_8bit_constraint_flag;
        public boolean[] sub_layer_max_monochrome_constraint_flag;
        public boolean[] sub_layer_non_packed_constraint_flag;
        public boolean[] sub_layer_one_picture_only_constraint_flag;
        public boolean[][] sub_layer_profile_compatibility_flag;
        public int[] sub_layer_profile_idc;
        public boolean[] sub_layer_profile_present_flag;
        public int[] sub_layer_profile_space;
        public boolean[] sub_layer_progressive_source_flag;
        public long[] sub_layer_reserved_zero_33bits;
        public long[] sub_layer_reserved_zero_34bits;
        public long[] sub_layer_reserved_zero_35bits;
        public long[] sub_layer_reserved_zero_43bits;
        public int[] sub_layer_reserved_zero_7bits;
        public boolean[] sub_layer_reserved_zero_bit;
        public boolean[] sub_layer_tier_flag;

        private boolean profile_compatible(int i) {
            return this.general_profile_idc == i || this.general_profile_compatibility_flag[i];
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x062a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.blink.academy.film.support.stream.h265.H265SeqParameterSetRBSP.ProfileTierLevel read(boolean r16, int r17, org.jcodec.common.io.BitReader r18) {
            /*
                Method dump skipped, instructions count: 1666
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.h265.H265SeqParameterSetRBSP.ProfileTierLevel.read(boolean, int, org.jcodec.common.io.BitReader):com.blink.academy.film.support.stream.h265.H265SeqParameterSetRBSP$ProfileTierLevel");
        }

        private boolean profile_compatible(int i, int i2) {
            return this.sub_layer_profile_idc[i] == i2 || this.sub_layer_profile_compatibility_flag[i][i2];
        }
    }

    public static class ScalingListData {
        public int[][][] ScalingList;
        public int[][] scaling_list_dc_coef_minus8;
        public int[][] scaling_list_pred_matrix_id_delta;
        public boolean[][] scaling_list_pred_mode_flag = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, 4, 6);

        public ScalingListData() {
            Class cls = Integer.TYPE;
            this.scaling_list_pred_matrix_id_delta = (int[][]) Array.newInstance((Class<?>) cls, 4, 6);
            this.scaling_list_dc_coef_minus8 = (int[][]) Array.newInstance((Class<?>) cls, 2, 6);
            this.ScalingList = (int[][][]) Array.newInstance((Class<?>) int[].class, 4, 6);
        }

        public static ScalingListData read(BitReader bitReader) {
            ScalingListData scalingListData = new ScalingListData();
            for (int i = 0; i < 4; i++) {
                int i2 = 0;
                while (i2 < 6) {
                    scalingListData.scaling_list_pred_mode_flag[i][i2] = CAVLCReader.readBool(bitReader, "SPS.ScalingListData: scaling_list_pred_mode_flag");
                    int i3 = 1;
                    if (scalingListData.scaling_list_pred_mode_flag[i][i2]) {
                        int iMin = Math.min(64, 1 << ((i << 1) + 4));
                        int se = 8;
                        if (i > 1) {
                            int i4 = i - 2;
                            scalingListData.scaling_list_dc_coef_minus8[i4][i2] = CAVLCReader.readSE(bitReader, "SPS.ScalingListData: scaling_list_dc_coef_minus8");
                            se = 8 + scalingListData.scaling_list_dc_coef_minus8[i4][i2];
                        }
                        scalingListData.ScalingList[i][i2] = new int[iMin];
                        for (int i5 = 0; i5 < iMin; i5++) {
                            se = ((se + CAVLCReader.readSE(bitReader, "SPS.ScalingListData: scaling_list_delta_coef")) + 256) % 256;
                            scalingListData.ScalingList[i][i2][i5] = se;
                        }
                    } else {
                        scalingListData.scaling_list_pred_matrix_id_delta[i][i2] = CAVLCReader.readUEtrace(bitReader, "SPS.ScalingListData: scaling_list_pred_matrix_id_delta");
                    }
                    if (i == 3) {
                        i3 = 3;
                    }
                    i2 += i3;
                }
            }
            return scalingListData;
        }
    }

    public static H265SeqParameterSetRBSP read(ByteBuffer byteBuffer) {
        H265SeqParameterSetRBSP h265SeqParameterSetRBSP = new H265SeqParameterSetRBSP();
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        h265SeqParameterSetRBSP.sps_video_parameter_set_id = CAVLCReader.readNBit(bitReaderCreateBitReader, 4, "SPS: sps_video_parameter_set_id");
        h265SeqParameterSetRBSP.sps_max_sub_layers_minus1 = CAVLCReader.readNBit(bitReaderCreateBitReader, 3, "SPS: sps_max_sub_layers_minus1");
        h265SeqParameterSetRBSP.sps_temporal_id_nesting_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_temporal_id_nesting_flag");
        int i = 1;
        h265SeqParameterSetRBSP.profile_tier_level = ProfileTierLevel.read(true, h265SeqParameterSetRBSP.sps_max_sub_layers_minus1, bitReaderCreateBitReader);
        h265SeqParameterSetRBSP.sps_seq_parameter_set_id = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: sps_seq_parameter_set_id");
        int uEtrace = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: chroma_format_idc");
        h265SeqParameterSetRBSP.chroma_format_idc = uEtrace;
        if (uEtrace == 3) {
            h265SeqParameterSetRBSP.separate_colour_plane_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: separate_colour_plane_flag");
        }
        int i2 = h265SeqParameterSetRBSP.chroma_format_idc;
        if (i2 == 0 && !h265SeqParameterSetRBSP.separate_colour_plane_flag) {
            h265SeqParameterSetRBSP.SubWidthC = 1;
            h265SeqParameterSetRBSP.SubHeightC = 1;
        } else if (i2 == 1 && !h265SeqParameterSetRBSP.separate_colour_plane_flag) {
            h265SeqParameterSetRBSP.SubWidthC = 2;
            h265SeqParameterSetRBSP.SubHeightC = 2;
        } else if (i2 == 2 && !h265SeqParameterSetRBSP.separate_colour_plane_flag) {
            h265SeqParameterSetRBSP.SubWidthC = 2;
            h265SeqParameterSetRBSP.SubHeightC = 1;
        } else if (i2 == 3 && !h265SeqParameterSetRBSP.separate_colour_plane_flag) {
            h265SeqParameterSetRBSP.SubWidthC = 1;
            h265SeqParameterSetRBSP.SubHeightC = 1;
        } else if (i2 == 3 && h265SeqParameterSetRBSP.separate_colour_plane_flag) {
            h265SeqParameterSetRBSP.SubWidthC = 1;
            h265SeqParameterSetRBSP.SubHeightC = 1;
        } else {
            h265SeqParameterSetRBSP.SubWidthC = ((1 == i2 || 2 == i2) && !h265SeqParameterSetRBSP.separate_colour_plane_flag) ? 2 : 1;
            if (1 == i2 && !h265SeqParameterSetRBSP.separate_colour_plane_flag) {
                i = 2;
            }
            h265SeqParameterSetRBSP.SubHeightC = i;
        }
        h265SeqParameterSetRBSP.pic_width_in_luma_samples = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: pic_width_in_luma_samples");
        h265SeqParameterSetRBSP.pic_height_in_luma_samples = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: pic_height_in_luma_samples");
        boolean bool = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: conformance_window_flag");
        h265SeqParameterSetRBSP.conformance_window_flag = bool;
        if (bool) {
            h265SeqParameterSetRBSP.conf_win_left_offset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: conf_win_left_offset");
            h265SeqParameterSetRBSP.conf_win_right_offset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: conf_win_right_offset");
            h265SeqParameterSetRBSP.conf_win_top_offset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: conf_win_top_offset");
            h265SeqParameterSetRBSP.conf_win_bottom_offset = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: conf_win_bottom_offset");
        }
        h265SeqParameterSetRBSP.bit_depth_luma_minus8 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: bit_depth_luma_minus8");
        h265SeqParameterSetRBSP.bit_depth_chroma_minus8 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: bit_depth_chroma_minus8");
        h265SeqParameterSetRBSP.log2_max_pic_order_cnt_lsb_minus4 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_max_pic_order_cnt_lsb_minus4");
        boolean bool2 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_sub_layer_ordering_info_present_flag");
        h265SeqParameterSetRBSP.sps_sub_layer_ordering_info_present_flag = bool2;
        int i3 = h265SeqParameterSetRBSP.sps_max_sub_layers_minus1;
        h265SeqParameterSetRBSP.sps_max_dec_pic_buffering_minus1 = new int[i3 + 1];
        h265SeqParameterSetRBSP.sps_max_num_reorder_pics = new int[i3 + 1];
        h265SeqParameterSetRBSP.sps_max_latency_increase_plus1 = new int[i3 + 1];
        if (bool2) {
            i3 = 0;
        }
        while (i3 <= h265SeqParameterSetRBSP.sps_max_sub_layers_minus1) {
            h265SeqParameterSetRBSP.sps_max_dec_pic_buffering_minus1[i3] = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: sps_max_dec_pic_buffering_minus1[" + i3 + "]");
            h265SeqParameterSetRBSP.sps_max_num_reorder_pics[i3] = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: sps_max_num_reorder_pics[" + i3 + "]");
            h265SeqParameterSetRBSP.sps_max_latency_increase_plus1[i3] = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: sps_max_latency_increase_plus1[" + i3 + "]");
            i3++;
        }
        h265SeqParameterSetRBSP.log2_min_luma_coding_block_size_minus3 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_min_luma_coding_block_size_minus3");
        h265SeqParameterSetRBSP.log2_diff_max_min_luma_coding_block_size = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_diff_max_min_luma_coding_block_size");
        h265SeqParameterSetRBSP.log2_min_luma_transform_block_size_minus2 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_min_luma_transform_block_size_minus2");
        h265SeqParameterSetRBSP.log2_diff_max_min_luma_transform_block_size = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_diff_max_min_luma_transform_block_size");
        h265SeqParameterSetRBSP.max_transform_hierarchy_depth_inter = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: max_transform_hierarchy_depth_inter");
        h265SeqParameterSetRBSP.max_transform_hierarchy_depth_intra = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: max_transform_hierarchy_depth_intra");
        boolean bool3 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: conformance_window_flag");
        h265SeqParameterSetRBSP.scaling_list_enabled_flag = bool3;
        if (bool3) {
            boolean bool4 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_scaling_list_data_present_flag");
            h265SeqParameterSetRBSP.sps_scaling_list_data_present_flag = bool4;
            if (bool4) {
                h265SeqParameterSetRBSP.scaling_list_data = ScalingListData.read(bitReaderCreateBitReader);
            }
        }
        h265SeqParameterSetRBSP.amp_enabled_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: amp_enabled_flag");
        h265SeqParameterSetRBSP.sample_adaptive_offset_enabled_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sample_adaptive_offset_enabled_flag");
        boolean bool5 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: pcm_enabled_flag");
        h265SeqParameterSetRBSP.pcm_enabled_flag = bool5;
        if (bool5) {
            h265SeqParameterSetRBSP.pcm_sample_bit_depth_luma_minus1 = CAVLCReader.readNBit(bitReaderCreateBitReader, 4, "SPS: pcm_sample_bit_depth_luma_minus1");
            h265SeqParameterSetRBSP.pcm_sample_bit_depth_chroma_minus1 = CAVLCReader.readNBit(bitReaderCreateBitReader, 4, "SPS: pcm_sample_bit_depth_chroma_minus1");
            h265SeqParameterSetRBSP.log2_min_pcm_luma_coding_block_size_minus3 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_min_pcm_luma_coding_block_size_minus3");
            h265SeqParameterSetRBSP.log2_diff_max_min_pcm_luma_coding_block_size = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: log2_diff_max_min_pcm_luma_coding_block_size");
            h265SeqParameterSetRBSP.pcm_loop_filter_disabled_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: pcm_loop_filter_disabled_flag");
        }
        int uEtrace2 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: num_short_term_ref_pic_sets");
        h265SeqParameterSetRBSP.num_short_term_ref_pic_sets = uEtrace2;
        h265SeqParameterSetRBSP.st_ref_pic_set = new StRefPicSet[uEtrace2];
        int i4 = 0;
        while (true) {
            int i5 = h265SeqParameterSetRBSP.num_short_term_ref_pic_sets;
            if (i4 >= i5) {
                break;
            }
            h265SeqParameterSetRBSP.st_ref_pic_set[i4] = StRefPicSet.read(i4, i5, h265SeqParameterSetRBSP, bitReaderCreateBitReader);
            i4++;
        }
        boolean bool6 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: long_term_ref_pics_present_flag");
        h265SeqParameterSetRBSP.long_term_ref_pics_present_flag = bool6;
        if (bool6) {
            int uEtrace3 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPS: num_long_term_ref_pics_sps");
            h265SeqParameterSetRBSP.num_long_term_ref_pics_sps = uEtrace3;
            h265SeqParameterSetRBSP.lt_ref_pic_poc_lsb_sps = new int[uEtrace3];
            h265SeqParameterSetRBSP.used_by_curr_pic_lt_sps_flag = new boolean[uEtrace3];
            for (int i6 = 0; i6 < h265SeqParameterSetRBSP.num_long_term_ref_pics_sps; i6++) {
                h265SeqParameterSetRBSP.lt_ref_pic_poc_lsb_sps[i6] = CAVLCReader.readNBit(bitReaderCreateBitReader, h265SeqParameterSetRBSP.log2_max_pic_order_cnt_lsb_minus4 + 4, "SPS: lt_ref_pic_poc_lsb_sps[" + i6 + "]");
                h265SeqParameterSetRBSP.used_by_curr_pic_lt_sps_flag[i6] = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: used_by_curr_pic_lt_sps_flag[" + i6 + "]");
            }
        }
        h265SeqParameterSetRBSP.sps_temporal_mvp_enabled_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_temporal_mvp_enabled_flag");
        h265SeqParameterSetRBSP.strong_intra_smoothing_enabled_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: strong_intra_smoothing_enabled_flag");
        boolean bool7 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: vui_parameters_present_flag");
        h265SeqParameterSetRBSP.vui_parameters_present_flag = bool7;
        if (bool7) {
            h265SeqParameterSetRBSP.vui_parameters = VUIParameters.read(bitReaderCreateBitReader, h265SeqParameterSetRBSP.sps_max_sub_layers_minus1);
        }
        boolean bool8 = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_extension_present_flag");
        h265SeqParameterSetRBSP.sps_extension_present_flag = bool8;
        if (bool8) {
            h265SeqParameterSetRBSP.sps_range_extension_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_range_extension_flag");
            h265SeqParameterSetRBSP.sps_multilayer_extension_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_multilayer_extension_flag");
            h265SeqParameterSetRBSP.sps_3d_extension_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_3d_extension_flag");
            h265SeqParameterSetRBSP.sps_scc_extension_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPS: sps_scc_extension_flag");
            h265SeqParameterSetRBSP.sps_extension_4bits = CAVLCReader.readNBit(bitReaderCreateBitReader, 4, "SPS: sps_extension_5bits");
        }
        return h265SeqParameterSetRBSP;
    }

    public int getChroma_format_idc() {
        return this.chroma_format_idc;
    }

    public int getConf_win_bottom_offset() {
        return this.conf_win_bottom_offset;
    }

    public int getConf_win_left_offset() {
        return this.conf_win_left_offset;
    }

    public int getConf_win_right_offset() {
        return this.conf_win_right_offset;
    }

    public int getConf_win_top_offset() {
        return this.conf_win_top_offset;
    }

    public int getPic_height_in_luma_samples() {
        return this.pic_height_in_luma_samples;
    }

    public int getPic_width_in_luma_samples() {
        return this.pic_width_in_luma_samples;
    }

    public StRefPicSet[] getSt_ref_pic_set() {
        return this.st_ref_pic_set;
    }

    public int getSubHeightC() {
        return this.SubHeightC;
    }

    public int getSubWidthC() {
        return this.SubWidthC;
    }

    public boolean isConformance_window_flag() {
        return this.conformance_window_flag;
    }

    public boolean isSeparate_colour_plane_flag() {
        return this.separate_colour_plane_flag;
    }
}
