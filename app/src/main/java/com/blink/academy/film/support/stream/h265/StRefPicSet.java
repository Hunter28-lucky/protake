package com.blink.academy.film.support.stream.h265;

import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.common.io.BitReader;

/* loaded from: classes.dex */
public class StRefPicSet {
    public int abs_delta_rps_minus1;
    public int delta_idx_minus1;
    public int[] delta_poc_s0_minus1;
    public int[] delta_poc_s1_minus1;
    public int delta_rps_sign;
    public boolean inter_ref_pic_set_prediction_flag;
    public int num_negative_pics;
    public int num_positive_pics;
    public boolean[] use_delta_flag;
    public boolean[] used_by_curr_pic_flag;
    public boolean[] used_by_curr_pic_s0_flag;
    public boolean[] used_by_curr_pic_s1_flag;

    public static StRefPicSet read(int i, int i2, H265SeqParameterSetRBSP h265SeqParameterSetRBSP, BitReader bitReader) {
        StRefPicSet stRefPicSet = new StRefPicSet();
        if (i != 0) {
            stRefPicSet.inter_ref_pic_set_prediction_flag = CAVLCReader.readBool(bitReader, "SPS.StRefPicSet: inter_ref_pic_set_prediction_flag");
        }
        int i3 = 0;
        if (stRefPicSet.inter_ref_pic_set_prediction_flag) {
            if (i == i2) {
                stRefPicSet.delta_idx_minus1 = CAVLCReader.readUEtrace(bitReader, "SPS.StRefPicSet: delta_idx_minus1");
            }
            StRefPicSet stRefPicSet2 = h265SeqParameterSetRBSP.getSt_ref_pic_set()[i - (stRefPicSet.delta_idx_minus1 + 1)];
            int i4 = stRefPicSet2.num_negative_pics + stRefPicSet2.num_positive_pics;
            stRefPicSet.delta_rps_sign = CAVLCReader.readU(bitReader, 1, "SPS.StRefPicSet: delta_rps_sign");
            stRefPicSet.abs_delta_rps_minus1 = CAVLCReader.readUEtrace(bitReader, "SPS.StRefPicSet: abs_delta_rps_minus1");
            while (i3 <= i4) {
                stRefPicSet.used_by_curr_pic_flag[i3] = CAVLCReader.readBool(bitReader, "SPS.StRefPicSet: used_by_curr_pic_flag");
                if (!stRefPicSet.used_by_curr_pic_flag[i3]) {
                    stRefPicSet.use_delta_flag[i3] = CAVLCReader.readBool(bitReader, "SPS.StRefPicSet: use_delta_flag");
                }
                i3++;
            }
        } else {
            stRefPicSet.num_negative_pics = CAVLCReader.readUEtrace(bitReader, "SPS.StRefPicSet: num_negative_pics");
            stRefPicSet.num_positive_pics = CAVLCReader.readUEtrace(bitReader, "SPS.StRefPicSet: num_positive_pics");
            int i5 = stRefPicSet.num_negative_pics;
            stRefPicSet.delta_poc_s0_minus1 = new int[i5];
            stRefPicSet.used_by_curr_pic_s0_flag = new boolean[i5];
            for (int i6 = 0; i6 < stRefPicSet.num_negative_pics; i6++) {
                stRefPicSet.delta_poc_s0_minus1[i6] = CAVLCReader.readUEtrace(bitReader, "SPS.StRefPicSet: delta_poc_s0_minus1");
                stRefPicSet.used_by_curr_pic_s0_flag[i6] = CAVLCReader.readBool(bitReader, "SPS.StRefPicSet: used_by_curr_pic_s0_flag");
            }
            int i7 = stRefPicSet.num_positive_pics;
            stRefPicSet.delta_poc_s1_minus1 = new int[i7];
            stRefPicSet.used_by_curr_pic_s1_flag = new boolean[i7];
            while (i3 < stRefPicSet.num_positive_pics) {
                stRefPicSet.delta_poc_s1_minus1[i3] = CAVLCReader.readUEtrace(bitReader, "SPS.StRefPicSet: delta_poc_s1_minus1");
                stRefPicSet.used_by_curr_pic_s1_flag[i3] = CAVLCReader.readBool(bitReader, "SPS.StRefPicSet: used_by_curr_pic_s1_flag");
                i3++;
            }
        }
        return stRefPicSet;
    }
}
