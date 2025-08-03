package com.blink.academy.film.support.stream.h265;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class H265NalUnitHeader {
    public byte forbidden_zero_bit;
    public byte nal_unit_type;
    public byte nal_unit_type2;
    public byte nuh_reserved_zero_6bits;
    public byte nuh_temporal_id_plus1;

    private H265NalUnitHeader() {
    }

    public static H265NalUnitHeader read(ByteBuffer byteBuffer) {
        H265NalUnitHeader h265NalUnitHeader = new H265NalUnitHeader();
        int i = byteBuffer.get() & ExifInterface.MARKER;
        int i2 = byteBuffer.get() & ExifInterface.MARKER;
        h265NalUnitHeader.forbidden_zero_bit = (byte) ((i >> 7) & 1);
        h265NalUnitHeader.nal_unit_type = (byte) ((i >> 1) & 63);
        h265NalUnitHeader.nal_unit_type2 = (byte) ((i & 126) >> 1);
        h265NalUnitHeader.nuh_reserved_zero_6bits = (byte) (((i & 1) << 5) | ((i2 >> 3) & 31));
        h265NalUnitHeader.nuh_temporal_id_plus1 = (byte) (i2 & 7);
        return h265NalUnitHeader;
    }

    public byte getForbidden_zero_bit() {
        return this.forbidden_zero_bit;
    }

    public byte getNal_unit_type() {
        return this.nal_unit_type;
    }

    public byte getNuh_reserved_zero_6bits() {
        return this.nuh_reserved_zero_6bits;
    }

    public byte getNuh_temporal_id_plus1() {
        return this.nuh_temporal_id_plus1;
    }

    public boolean isFrame() {
        byte b;
        return isIFrame() || (b = this.nal_unit_type) == 0 || b == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 6 || b == 7 || b == 8 || b == 9;
    }

    public boolean isIFrame() {
        byte b = this.nal_unit_type;
        return b == 19 || b == 16 || b == 17 || b == 18 || b == 20 || b == 21;
    }

    public String toString() {
        return "H265NalUnitHeader{forbidden_zero_bit=" + ((int) this.forbidden_zero_bit) + ", nal_unit_type=" + ((int) this.nal_unit_type) + ", nal_unit_type2=" + ((int) this.nal_unit_type2) + ", nuh_reserved_zero_6bits=" + ((int) this.nuh_reserved_zero_6bits) + ", nuh_temporal_id_plus1=" + ((int) this.nuh_temporal_id_plus1) + '}';
    }

    public void writeTo(byte[] bArr, int i) {
        int i2 = ((this.forbidden_zero_bit & ExifInterface.MARKER) << 7) | ((this.nal_unit_type * ExifInterface.MARKER) << 1);
        byte b = this.nuh_reserved_zero_6bits;
        int i3 = i2 | (b & 7);
        int i4 = (b & 510) | (this.nuh_temporal_id_plus1 & ExifInterface.MARKER);
        bArr[i] = (byte) (i3 & 255);
        bArr[i + 1] = (byte) (i4 & 255);
    }

    public H265NalUnitHeader(int i, int i2, int i3, int i4) {
        this.forbidden_zero_bit = (byte) (i * 255);
        this.nal_unit_type = (byte) (i2 * 255);
        this.nuh_reserved_zero_6bits = (byte) (i3 * 255);
        this.nuh_temporal_id_plus1 = (byte) (i4 & 255);
    }

    public H265NalUnitHeader(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        this.forbidden_zero_bit = (byte) ((b >> 7) & 1);
        this.nal_unit_type = (byte) ((b >> 1) & 63);
        this.nal_unit_type2 = (byte) ((b & 126) >> 1);
        this.nuh_reserved_zero_6bits = (byte) (((b & 1) << 5) | ((b2 >> 3) & 31));
        this.nuh_temporal_id_plus1 = (byte) (b2 & 7);
    }
}
