package com.blink.academy.film.support.stream.h264;

/* loaded from: classes.dex */
public class H264NalUnit {
    public byte[] content;
    public H264NalUnitHeader mHeader;
    public H264NalUnitStartCode mStartCode;

    public H264NalUnit(byte[] bArr) {
        this.mHeader = new H264NalUnitHeader(bArr[4]);
        this.content = bArr;
    }

    public byte[] getContent() {
        return this.content;
    }

    public H264NalUnitHeader getHeader() {
        return this.mHeader;
    }
}
