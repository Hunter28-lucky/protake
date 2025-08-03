package com.blink.academy.film.support.stream.ts;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import defpackage.C4638;

/* loaded from: classes.dex */
class PesHeader {
    public static boolean VERBOSE = false;
    public int DSM_trick_mode_flag;
    public int ESCR_flag;
    public int ES_rate_flag;
    public int PES_CRC_flag;
    public int PES_extension_flag;
    public int PES_priority;
    public int PES_scrambling_control;
    public int PTS_DTS_flags;
    public int additional_copy_info_flag;
    public int copyright;
    public int data_alignment_indicator;
    public long dts;
    public int flag1;
    public int flag2;
    public int headerLength;
    public int original_or_copy;
    public int pes_constants_10;
    public byte pes_data_length;
    public int pes_packet_length;
    public int pes_start_code;
    public long pts;
    public int stream_id;

    public PesHeader(byte[] bArr, int i) {
        this.pes_constants_10 = 2;
        this.pes_start_code = (bArr[i] << cb.n) | (bArr[i + 1] << 8) | bArr[i + 2];
        this.stream_id = bArr[i + 3] & ExifInterface.MARKER;
        this.pes_packet_length = ((bArr[i + 4] & ExifInterface.MARKER) << 8) | (bArr[i + 5] & ExifInterface.MARKER);
        this.flag1 = bArr[i + 6] & ExifInterface.MARKER;
        this.flag2 = bArr[i + 7] & ExifInterface.MARKER;
        byte b = bArr[8];
        this.pes_data_length = b;
        this.headerLength = 9;
        if (b >= 5) {
            long j = ((bArr[i + 9] & cb.l) << 29) | ((bArr[i + 10] & 255) << 22) | ((bArr[i + 11] & 254) << 14) | ((255 & bArr[i + 12]) << 7) | ((bArr[i + 13] & 254) >> 1);
            this.pts = j;
            if (VERBOSE) {
                C4638.m14099("TimeConvert", String.format("before revert pts : %s ", Long.valueOf(j)));
            }
            long jRevertTime = PesPacket.revertTime(this.pts, 1000000L);
            this.pts = jRevertTime;
            if (VERBOSE) {
                C4638.m14099("TimeConvert", String.format("after revert pts : %s ", Long.valueOf(jRevertTime)));
            }
            this.headerLength = 14;
            if (this.pes_data_length == 10) {
                long j2 = ((bArr[i + 16] & 254) << 14) | ((bArr[i + 14] & 14) << 29) | (bArr[i + 15] & 1069547520) | (bArr[i + 17] & 32640) | (bArr[i + 18] & 127);
                this.dts = j2;
                this.dts = PesPacket.revertTime(j2, 1000000L);
                this.headerLength = 19;
            }
        }
        if (VERBOSE) {
            C4638.m14099("PesHeader", toString());
        }
    }

    public String toString() {
        return "PesHeader{pes_start_code=" + this.pes_start_code + ", stream_id=" + this.stream_id + ", pes_packet_length=" + this.pes_packet_length + ", flag1=" + this.flag1 + ", flag2=" + this.flag2 + ", pes_data_length=" + ((int) this.pes_data_length) + ", pts=" + this.pts + ", dts=" + this.dts + '}';
    }

    public int writeToPes(byte[] bArr) {
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 1;
        bArr[3] = (byte) (this.stream_id & 255);
        int i = this.pes_packet_length;
        if (i > 65535) {
            i = 0;
        }
        bArr[4] = (byte) ((i >> 8) & 255);
        bArr[5] = (byte) (i & 255);
        bArr[6] = (byte) (this.flag1 & 255);
        bArr[7] = (byte) (this.flag2 & 255);
        bArr[8] = this.pes_data_length;
        long jConvertTime = PesPacket.convertTime(this.pts, 1000000L);
        PesPacket.convertTime(this.dts, 1000000L);
        if (VERBOSE) {
            C4638.m14099("TimeConvert", String.format("this.pts %s , %s ", Long.valueOf(this.pts), Long.valueOf(jConvertTime)));
        }
        bArr[9] = (byte) (33 | ((jConvertTime >> 29) & 14));
        bArr[10] = (byte) ((jConvertTime >> 22) & 255);
        bArr[11] = (byte) (((jConvertTime >> 14) & 254) | 1);
        bArr[12] = (byte) ((jConvertTime >> 7) & 255);
        bArr[13] = (byte) (((jConvertTime << 1) & 254) | 1);
        return 14;
    }

    public PesHeader(int i, int i2, int i3, int i4, byte b, long j, long j2) {
        this.pes_start_code = 1;
        this.pes_constants_10 = 2;
        this.headerLength = 0;
        this.stream_id = i;
        this.pes_packet_length = i2;
        this.flag1 = i3;
        this.flag2 = i4;
        this.pes_data_length = b;
        this.pts = j;
        this.dts = j2;
    }
}
