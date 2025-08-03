package com.blink.academy.film.support.stream.ts;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import defpackage.C4638;
import org.mp4parser.tools.Hex;

/* loaded from: classes.dex */
class TsHeader {
    public static boolean VERBOSE = false;
    public int adaptation_field_control;
    public int continuity_counter;
    public int payload_unit_start_indicator;
    public int pid;
    public int sync_byte;
    public int transport_error_indicator;
    public int transport_priority;
    public int transport_scrambling_control;

    public TsHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.sync_byte = i;
        this.transport_error_indicator = i2;
        this.payload_unit_start_indicator = i3;
        this.transport_priority = i4;
        this.pid = i5;
        this.transport_scrambling_control = i6;
        this.adaptation_field_control = i7;
        this.continuity_counter = i8;
    }

    public String toString() {
        return "TsHeader{sync_byte=" + this.sync_byte + ", transport_error_indicator=" + this.transport_error_indicator + ", payload_unit_start_indicator=" + this.payload_unit_start_indicator + ", transport_priority=" + this.transport_priority + ", pid=" + this.pid + ", transport_scrambling_control=" + this.transport_scrambling_control + ", adaptation_field_control=" + this.adaptation_field_control + ", continuity_counter=" + this.continuity_counter + '}';
    }

    public int writeToTs(byte[] bArr) {
        bArr[0] = (byte) (this.sync_byte & 255);
        int i = ((this.transport_error_indicator & 1) << 7) | ((this.payload_unit_start_indicator & 1) << 6) | ((this.transport_priority & 1) << 5);
        int i2 = this.pid;
        bArr[1] = (byte) (i | ((i2 >> 8) & 31));
        bArr[2] = (byte) (i2 & 255);
        bArr[3] = (byte) (((this.transport_scrambling_control & 3) << 6) | ((this.adaptation_field_control & 3) << 4) | (this.continuity_counter & 15));
        if (VERBOSE) {
            C4638.m14099("TsHeader", "data=" + Hex.encodeHex(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]}));
        }
        return 4;
    }

    public TsHeader(byte[] bArr) {
        this.sync_byte = 71;
        if (bArr != null && bArr.length >= 4) {
            if (VERBOSE) {
                C4638.m14099("TsHeader", "data=" + Hex.encodeHex(new byte[]{bArr[0], bArr[1], bArr[2], bArr[3]}));
            }
            this.sync_byte = bArr[0];
            byte b = bArr[1];
            this.transport_error_indicator = (b >> 7) & 1;
            this.payload_unit_start_indicator = (b >> 6) & 1;
            this.transport_priority = (b >> 5) & 1;
            this.pid = ((b & 31) << 8) | (bArr[2] & ExifInterface.MARKER);
            byte b2 = bArr[3];
            this.transport_scrambling_control = (b2 >> 6) & 3;
            this.adaptation_field_control = (b2 >> 4) & 3;
            this.continuity_counter = b2 & cb.m;
            if (VERBOSE) {
                C4638.m14099("TsHeader", toString());
                return;
            }
            return;
        }
        throw new RuntimeException("TsHeader 4 byte not enough !");
    }
}
