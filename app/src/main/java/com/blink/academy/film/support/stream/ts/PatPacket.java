package com.blink.academy.film.support.stream.ts;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import defpackage.C4638;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class PatPacket {
    public static ContinuityCounter PatCounter = new ContinuityCounter();
    public static boolean VERBOSE = false;
    public long CRC32;
    public byte current_next_indicator;
    public byte last_section_number;
    public List<Program> mPrograms;
    public byte reserved1;
    public byte reserved2;
    public int section_length;
    public byte section_number;
    public byte section_syntax_indicator;
    public byte table_id;
    public int transport_stream_id;
    public byte version_number;
    public byte zero;

    public static class Program {
        public int PID;
        public int program_number;
        public byte reserved;

        public String toString() {
            return "Program{program_number=" + this.program_number + ", reserved=" + ((int) this.reserved) + ", PID=" + this.PID + '}';
        }
    }

    public PatPacket(byte[] bArr, int i) {
        if (bArr == null || i < 0 || i > bArr.length) {
            throw new RuntimeException("PatPacket error");
        }
        this.table_id = bArr[i];
        byte b = bArr[i + 1];
        this.section_syntax_indicator = (byte) ((b >> 7) & 1);
        this.zero = (byte) ((b >> 6) & 1);
        this.reserved1 = (byte) ((b >> 4) & 3);
        this.section_length = ((b & cb.m) << 8) | bArr[i + 2];
        this.transport_stream_id = (((bArr[i + 3] & ExifInterface.MARKER) << 8) | (bArr[i + 4] & ExifInterface.MARKER)) & 65535;
        byte b2 = bArr[i + 5];
        this.reserved2 = (byte) ((b2 >> 6) & 3);
        this.version_number = (byte) ((b2 >> 1) & 31);
        this.current_next_indicator = (byte) (b2 & 1);
        this.section_number = bArr[i + 6];
        this.last_section_number = bArr[i + 7];
        this.mPrograms = new ArrayList();
        int i2 = 0;
        for (int i3 = 0; i3 < this.section_number + 1; i3++) {
            Program program = new Program();
            int i4 = i3 * 4;
            program.program_number = (bArr[(i + 8) + i4] << 8) | bArr[i + 9 + i4];
            byte b3 = bArr[i + 10 + i4];
            program.reserved = (byte) ((b3 >> 5) & 7);
            program.PID = ((b3 & 31) << 8) | (bArr[i + 11 + i4] & ExifInterface.MARKER);
            this.mPrograms.add(program);
            i2 = i3;
        }
        int i5 = i2 * 4;
        this.CRC32 = (bArr[i + 15 + i5] & 4294967295L) | ((bArr[(i + 12) + i5] & 4294967295L) << 24) | ((bArr[(i + 13) + i5] & 4294967295L) << 16) | ((bArr[(i + 14) + i5] & 4294967295L) << 8);
        if (VERBOSE) {
            C4638.m14099("PatPacket", toString());
        }
    }

    public static byte[] PatPacket() {
        long jSimple;
        byte[] bArr = new byte[TsConstants.TS_PACKET_SIZE];
        Arrays.fill(bArr, (byte) -1);
        bArr[0] = 71;
        bArr[1] = TsConstants.ACESType_data;
        bArr[2] = 0;
        bArr[3] = (byte) ((PatCounter.incrementAndGetVideo() & 15) | 16);
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = (byte) 176;
        bArr[7] = (byte) 13;
        bArr[8] = 0;
        bArr[9] = 1;
        bArr[10] = -63;
        bArr[11] = 0;
        bArr[12] = 0;
        bArr[13] = 0;
        bArr[14] = 1;
        bArr[15] = (byte) 240;
        bArr[16] = (byte) 0;
        new CRC32().update(bArr, 5, 12);
        System.arraycopy(bArr, 5, new byte[12], 0, 12);
        try {
            jSimple = Crc32.simple(r4) & 4294967295L;
        } catch (IOException e2) {
            e2.printStackTrace();
            jSimple = 0;
        }
        if (VERBOSE) {
            C4638.m14099("CRC32", String.format("compute : %s ", Long.valueOf(jSimple)));
        }
        bArr[17] = (byte) ((jSimple >> 24) & 255);
        bArr[18] = (byte) ((jSimple >> 16) & 255);
        bArr[19] = (byte) ((jSimple >> 8) & 255);
        bArr[20] = (byte) (jSimple & 255);
        return bArr;
    }

    public String toString() {
        return "PatPacket{table_id=" + ((int) this.table_id) + ", section_syntax_indicator=" + ((int) this.section_syntax_indicator) + ", zero=" + ((int) this.zero) + ", reserved1=" + ((int) this.reserved1) + ", section_length=" + this.section_length + ", transport_stream_id=" + this.transport_stream_id + ", reserved2=" + ((int) this.reserved2) + ", version_number=" + ((int) this.version_number) + ", current_next_indicator=" + ((int) this.current_next_indicator) + ", section_number=" + ((int) this.section_number) + ", last_section_number=" + ((int) this.last_section_number) + ", mPrograms=" + this.mPrograms + ", CRC32=" + this.CRC32 + '}';
    }
}
