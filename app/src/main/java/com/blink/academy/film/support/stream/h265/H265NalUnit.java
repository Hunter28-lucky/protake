package com.blink.academy.film.support.stream.h265;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class H265NalUnit {
    public byte[] content;
    public H265NalUnitHeader mHeader;

    public H265NalUnit(byte[] bArr) {
        this.mHeader = new H265NalUnitHeader(bArr, 4);
        this.content = bArr;
    }

    public static H265NalUnit buildDataTypeNalUnit(byte[] bArr) {
        H265NalUnitHeader h265NalUnitHeader = new H265NalUnitHeader(0, 52, 0, 0);
        byte[] bArr2 = new byte[bArr.length + 5];
        bArr2[0] = 0;
        bArr2[1] = 0;
        bArr2[2] = 0;
        bArr2[3] = 1;
        h265NalUnitHeader.writeTo(bArr2, 4);
        System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
        return new H265NalUnit(bArr2);
    }

    public static H265NalUnit read(ByteBuffer byteBuffer) {
        H265NalUnit h265NalUnit = new H265NalUnit();
        h265NalUnit.mHeader = H265NalUnitHeader.read(byteBuffer);
        return h265NalUnit;
    }

    public byte[] getContent() {
        return this.content;
    }

    public H265NalUnitHeader getHeader() {
        return this.mHeader;
    }

    private H265NalUnit() {
    }
}
