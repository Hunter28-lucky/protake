package com.blink.academy.film.support.stream.h264;

import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes.dex */
public class H264NalUnitHeader {
    public byte forbidden_zero_bit;
    public byte nal_ref_idc;
    public byte nal_unit_type;

    public H264NalUnitHeader(byte b) {
        this.forbidden_zero_bit = (byte) ((b & BER.ASN_LONG_LEN) >> 7);
        this.nal_ref_idc = (byte) ((b & 96) >> 5);
        this.nal_unit_type = (byte) (b & 31);
    }

    public String toString() {
        return "H264NalUnitHeader{forbidden_zero_bit=" + ((int) this.forbidden_zero_bit) + ", nal_ref_idc=" + ((int) this.nal_ref_idc) + ", nal_unit_type=" + ((int) this.nal_unit_type) + '}';
    }
}
