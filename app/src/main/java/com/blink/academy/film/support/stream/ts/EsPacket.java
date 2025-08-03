package com.blink.academy.film.support.stream.ts;

import com.blink.academy.film.support.stream.h265.H265NalUnit;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class EsPacket {
    private static final String TAG = "EsPacket";
    private boolean VERBOSE = false;
    public byte[] data;
    public long presentationTimeUs;

    @EsType
    public int type;

    public @interface EsType {
        public static final int Type_DATA = 11;
        public static final int Type_I = 5;
        public static final int Type_PPS = 8;
        public static final int Type_P_B = 1;
        public static final int Type_SPS = 7;
        public static final int Type_SPS_PPS = 2;
    }

    public EsPacket(@EsType int i, long j, byte[] bArr) {
        this.type = i;
        this.presentationTimeUs = j;
        this.data = bArr;
    }

    public EsPacket appendData(byte[] bArr) {
        byte[] content = H265NalUnit.buildDataTypeNalUnit(bArr).getContent();
        byte[] bArr2 = this.data;
        byte[] bArr3 = new byte[bArr2.length + content.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(content, 0, bArr3, this.data.length, content.length);
        this.data = bArr3;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EsPacket esPacket = (EsPacket) obj;
        return this.type == esPacket.type && this.presentationTimeUs == esPacket.presentationTimeUs && Arrays.equals(this.data, esPacket.data);
    }

    public byte[] getData() {
        return this.data;
    }

    public byte[] getDataTypeContent() {
        int i = this.type == 11 ? 5 : 6;
        byte[] bArr = this.data;
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    public long getPresentationTimeUs() {
        return this.presentationTimeUs;
    }

    @EsType
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (Objects.hash(Integer.valueOf(this.type), Long.valueOf(this.presentationTimeUs)) * 31) + Arrays.hashCode(this.data);
    }

    public EsPacket setData(byte[] bArr) {
        this.data = bArr;
        return this;
    }

    public EsPacket setPresentationTimeUs(long j) {
        this.presentationTimeUs = j;
        return this;
    }

    public EsPacket setType(int i) {
        this.type = i;
        return this;
    }
}
