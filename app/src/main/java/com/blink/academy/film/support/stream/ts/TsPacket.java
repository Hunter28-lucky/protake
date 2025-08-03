package com.blink.academy.film.support.stream.ts;

/* loaded from: classes.dex */
public class TsPacket {
    public byte[] mBytes;
    public TsAdaptationField mTsAdaptationField;
    public TsHeader mTsHeader;

    public TsPacket(byte[] bArr) {
        this.mBytes = bArr;
        this.mTsHeader = new TsHeader(this.mBytes);
    }

    public byte[] getBytes() {
        return this.mBytes;
    }

    public void refreshHeader() {
        this.mTsHeader = new TsHeader(this.mBytes);
    }

    public TsPacket() {
    }
}
