package com.blink.academy.film.support.stream.ts;

import androidx.exifinterface.media.ExifInterface;
import defpackage.C4638;

/* loaded from: classes.dex */
class TsAdaptationField {
    public static final String TAG = "TsAdaptationField";
    public static boolean VERBOSE = false;
    public int OPCR_flag;
    public int OPCR_reserved;
    public int PCR_flag;
    public int PCR_reserved;
    public int adaptation_field_extension_flag;
    public int adaptation_field_extension_length;
    public int adaptation_field_extension_length_reserved;
    public int adaptation_field_length;
    public int discontinuity_indicator;
    public int elementary_stream_priority_indicator;
    public int ltw_flag;
    public int ltw_offset;
    public int ltw_valid_flag;
    public long original_program_clock_reference_base;
    public int original_program_clock_reference_extension;
    public long pcr;
    public int pcr_flag;
    public int piecewise_rate;
    public int piecewise_rate_flag;
    public int piecewise_rate_reserved;
    public int[] private_data_byte;
    public long program_clock_reference_base;
    public int program_clock_reference_extension;
    public int random_access_indicator;
    public int seamless_splice_flag;
    public int splice_countdown;
    public int splice_type;
    public int splicing_point_flag;
    public int stuffing_length;
    public int transport_private_data_flag;
    public int transport_private_data_length;

    public TsAdaptationField(byte[] bArr, int i) {
        int i2 = bArr[i] & ExifInterface.MARKER;
        this.adaptation_field_length = i2;
        if (i2 > 0) {
            int i3 = bArr[i + 1] & ExifInterface.MARKER;
            this.pcr_flag = i3;
            int i4 = (i3 >> 4) & 1;
            this.PCR_flag = i4;
            if (i4 == 1) {
                long j = (bArr[i + 2] & 255) << 25;
                long j2 = (bArr[i + 3] & 255) << 17;
                long j3 = (bArr[i + 4] & 255) << 9;
                long j4 = (bArr[i + 5] & 255) << 1;
                long j5 = (bArr[i + 6] >> 7) & 1;
                if (VERBOSE) {
                    C4638.m14099(TAG, String.format("t1 : %s , t2 : %s , t3 : %s , t4 : %s , t5 : %s ", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)));
                }
                long j6 = (bArr[r1] & 1) << 8;
                long j7 = bArr[i + 7] & 255;
                if (VERBOSE) {
                    C4638.m14099(TAG, String.format("t6 : %s , t7 : %s ", Long.valueOf(j6), Long.valueOf(j7)));
                }
                long j8 = j | j2 | j3 | j4 | j5;
                long j9 = j6 | j7;
                if (VERBOSE) {
                    C4638.m14099(TAG, String.format("pcr_high : %s , pcr_low : %s ", Long.valueOf(j8), Long.valueOf(j9)));
                }
                this.pcr = (j8 * 300) + j9;
                this.stuffing_length = this.adaptation_field_length - 7;
            } else {
                this.stuffing_length = i2 - 1;
            }
        } else {
            this.stuffing_length = 0;
        }
        if (VERBOSE) {
            C4638.m14099(TAG, toString());
        }
    }

    public String toString() {
        return "TsAdaptationField{adaptation_field_length=" + this.adaptation_field_length + ", flag=" + this.pcr_flag + ", pcr=" + this.pcr + ", stuffing_length=" + this.stuffing_length + '}';
    }

    public void writeTo(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.adaptation_field_length;
        bArr[i] = (byte) (i3 & 255);
        if (i3 > 0) {
            int i4 = i2 + 1;
            int i5 = this.pcr_flag;
            bArr[i2] = (byte) (i5 & 255);
            if (i5 == 80) {
                long j = this.pcr;
                long j2 = j % 300;
                long j3 = j / 300;
                int i6 = i4 + 1;
                bArr[i4] = (byte) ((j3 >> 25) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) ((j3 >> 17) & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((j3 >> 9) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((j3 >> 1) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((j3 << 7) | (j2 >> 8) | 126) & 255);
                i4 = i10 + 1;
                bArr[i10] = (byte) (j2 & 255);
            }
            int i11 = 0;
            while (i11 < this.stuffing_length) {
                bArr[i4] = -1;
                i11++;
                i4++;
            }
        }
    }

    public TsAdaptationField(int i, int i2, long j) {
        this.adaptation_field_length = i;
        this.pcr_flag = i2;
        this.pcr = j;
        if (i2 == 80) {
            this.stuffing_length = i - 7;
        } else {
            this.stuffing_length = i - 1;
        }
    }
}
