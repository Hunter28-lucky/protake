package com.blink.academy.film.support.stream.ts;

import com.umeng.analytics.pro.cb;
import defpackage.C4638;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jcodec.codecs.mjpeg.JpegConst;

/* loaded from: classes.dex */
public class PmtPacket {
    public static ContinuityCounter PmtCounter = new ContinuityCounter();
    public static boolean VERBOSE = false;
    public long CRC32;
    public int PCR_PID;
    public byte current_next_indicator;
    public byte last_section_number;
    public List<Stream> mStreams;
    public int program_info_length;
    public int program_number;
    public byte reserved1;
    public byte reserved2;
    public byte reserved3;
    public byte reserved4;
    public int section_length;
    public byte section_number;
    public byte section_syntax_indicator;
    public byte table_id;
    public byte version_number;
    public byte zero;

    public static class Stream {
        public int ES_info_length;
        public int elementary_PID;
        public byte reserved1;
        public byte reserved2;
        public byte stream_type;

        public String toString() {
            return "Stream{stream_type=" + ((int) this.stream_type) + ", reserved1=" + ((int) this.reserved1) + ", elementary_PID=" + this.elementary_PID + ", reserved2=" + ((int) this.reserved2) + ", ES_info_length=" + this.ES_info_length + '}';
        }
    }

    public PmtPacket(byte[] bArr, int i) {
        if (bArr == null || i < 0 || i > bArr.length) {
            throw new RuntimeException("PmtPacket error");
        }
        this.table_id = bArr[i];
        byte b = bArr[i + 1];
        this.section_syntax_indicator = (byte) ((b >> 7) & 1);
        this.zero = (byte) ((b >> 6) & 1);
        this.reserved1 = (byte) ((b >> 4) & 3);
        this.section_length = ((b & cb.m) << 8) | bArr[i + 2];
        this.program_number = (bArr[i + 3] << 8) | bArr[i + 4];
        byte b2 = bArr[i + 5];
        this.reserved2 = (byte) ((b2 >> 6) & 3);
        this.version_number = (byte) ((b2 >> 1) & 31);
        this.current_next_indicator = (byte) (b2 & 1);
        this.section_number = bArr[i + 6];
        this.last_section_number = bArr[i + 7];
        byte b3 = bArr[i + 8];
        this.reserved3 = (byte) ((b3 >> 5) & 7);
        this.PCR_PID = ((b3 & 31) << 8) | bArr[i + 9];
        byte b4 = bArr[i + 10];
        this.reserved4 = (byte) ((b4 >> 4) & 15);
        this.program_info_length = ((b4 & cb.m) << 8) | bArr[i + 11];
        this.mStreams = new ArrayList();
        int i2 = (this.section_length - 13) / 5;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Stream stream = new Stream();
            int i5 = i4 * 5;
            stream.stream_type = bArr[i + 12 + i5];
            byte b5 = bArr[i + 13 + i5];
            stream.reserved1 = (byte) ((b5 >> 5) & 7);
            stream.elementary_PID = ((b5 & 31) << 8) | bArr[i + 14 + i5];
            byte b6 = bArr[i + 15 + i5];
            stream.reserved2 = (byte) ((b6 >> 4) & 15);
            stream.ES_info_length = ((b6 & cb.m) << 8) | bArr[i + 16 + i5];
            this.mStreams.add(stream);
            i3 = i4;
        }
        int i6 = i3 * 5;
        this.CRC32 = bArr[i + 20 + i6] | (bArr[(i + 17) + i6] << 24) | (bArr[(i + 18) + i6] << 16) | (bArr[(i + 19) + i6] << 8);
        if (VERBOSE) {
            C4638.m14099("PmtPacket", toString());
        }
    }

    public static byte[] PMTPacket() {
        return PMTPacket(TsConstants.ACESType_h264);
    }

    public String toString() {
        return "PmtPacket{table_id=" + ((int) this.table_id) + ", section_syntax_indicator=" + ((int) this.section_syntax_indicator) + ", zero=" + ((int) this.zero) + ", reserved1=" + ((int) this.reserved1) + ", section_length=" + this.section_length + ", program_number=" + this.program_number + ", reserved2=" + ((int) this.reserved2) + ", version_number=" + ((int) this.version_number) + ", current_next_indicator=" + ((int) this.current_next_indicator) + ", section_number=" + ((int) this.section_number) + ", last_section_number=" + ((int) this.last_section_number) + ", reserved3=" + ((int) this.reserved3) + ", PCR_PID=" + this.PCR_PID + ", reserved4=" + ((int) this.reserved4) + ", program_info_length=" + this.program_info_length + ", mStreams=" + this.mStreams + ", CRC32=" + this.CRC32 + '}';
    }

    public static byte[] PMTPacket(byte b) {
        int iSimple;
        byte[] bArr = new byte[TsConstants.TS_PACKET_SIZE];
        Arrays.fill(bArr, (byte) -1);
        bArr[0] = 71;
        bArr[1] = (byte) 112;
        bArr[2] = (byte) 0;
        bArr[3] = (byte) ((PmtCounter.incrementAndGetVideo() & 15) | 16);
        bArr[4] = 0;
        bArr[5] = 2;
        bArr[6] = (byte) 176;
        bArr[7] = (byte) 23;
        bArr[8] = 0;
        bArr[9] = 1;
        bArr[10] = -63;
        bArr[11] = 0;
        bArr[12] = 0;
        byte b2 = (byte) 224;
        bArr[13] = b2;
        byte b3 = (byte) 33;
        bArr[14] = b3;
        byte b4 = (byte) 240;
        bArr[15] = b4;
        byte b5 = (byte) 0;
        bArr[16] = b5;
        bArr[17] = b;
        bArr[18] = b2;
        bArr[19] = b3;
        bArr[20] = b4;
        bArr[21] = b5;
        bArr[22] = TsConstants.ACESType_data;
        bArr[23] = (byte) JpegConst.APP1;
        bArr[24] = (byte) 2;
        bArr[25] = b4;
        bArr[26] = b5;
        byte[] bArr2 = new byte[22];
        System.arraycopy(bArr, 5, bArr2, 0, 22);
        try {
            iSimple = Crc32.simple(bArr2);
        } catch (IOException e2) {
            e2.printStackTrace();
            iSimple = 0;
        }
        long j = iSimple;
        if (VERBOSE) {
            C4638.m14099("CRC32", String.format("compute : %s ", Integer.valueOf(iSimple)));
        }
        bArr[27] = (byte) ((j >> 24) & 255);
        bArr[28] = (byte) ((j >> 16) & 255);
        bArr[29] = (byte) ((j >> 8) & 255);
        bArr[30] = (byte) (j & 255);
        return bArr;
    }
}
