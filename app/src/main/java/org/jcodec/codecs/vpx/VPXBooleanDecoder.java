package org.jcodec.codecs.vpx;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class VPXBooleanDecoder {
    public int bit_count;
    public long callCounter = 0;
    private String debugName;
    public ByteBuffer input;
    public int offset;
    public int range;
    public int value;

    public VPXBooleanDecoder(ByteBuffer byteBuffer, int i) {
        this.input = byteBuffer;
        this.offset = i;
        initBoolDecoder();
    }

    public static int getBitInBytes(byte[] bArr, int i) {
        return (bArr[i >> 3] >> (7 - (i & 7))) & 1;
    }

    public static int getBitsInBytes(byte[] bArr, int i, int i2) {
        int bitInBytes = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            bitInBytes = (bitInBytes << 1) | getBitInBytes(bArr, i + i3);
        }
        return bitInBytes;
    }

    public static int leadingZeroCountInByte(byte b) {
        int i = b & ExifInterface.MARKER;
        if (i >= 128 || i == 0) {
            return 0;
        }
        return Integer.numberOfLeadingZeros(b) - 24;
    }

    public int decodeInt(int i) {
        int bit = 0;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return bit;
            }
            bit = readBit(128) | (bit << 1);
            i = i2;
        }
    }

    public void initBoolDecoder() {
        this.value = 0;
        this.value = (this.input.get() & ExifInterface.MARKER) << 8;
        this.offset++;
        this.range = 255;
        this.bit_count = 0;
    }

    public int readBit(int i) {
        int i2;
        int i3 = this.range;
        int i4 = this.value;
        int i5 = (((i3 - 1) * i) >> 8) + 1;
        int i6 = i5 << 8;
        this.callCounter++;
        if (i4 >= i6) {
            i5 = i3 - i5;
            i4 -= i6;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i7 = this.bit_count;
        int iLeadingZeroCountInByte = leadingZeroCountInByte((byte) i5);
        int i8 = i5 << iLeadingZeroCountInByte;
        int i9 = i4 << iLeadingZeroCountInByte;
        int i10 = i7 - iLeadingZeroCountInByte;
        if (i10 <= 0) {
            i9 |= (this.input.get() & ExifInterface.MARKER) << (-i10);
            this.offset++;
            i10 += 8;
        }
        this.bit_count = i10;
        this.value = i9;
        this.range = i8;
        return i2;
    }

    public int readBitEq() {
        return readBit(128);
    }

    public int readTree(int[] iArr, int[] iArr2) {
        int i = 0;
        do {
            i = iArr[i + readBit(iArr2[i >> 1])];
        } while (i > 0);
        return -i;
    }

    public int readTree3(int[] iArr, int i, int i2) {
        int i3 = iArr[readBit(i) + 0];
        if (i3 > 0) {
            do {
                i3 = iArr[i3 + readBit(i2)];
            } while (i3 > 0);
        }
        return -i3;
    }

    public int readTreeSkip(int[] iArr, int[] iArr2, int i) {
        int i2 = i * 2;
        do {
            i2 = iArr[i2 + readBit(iArr2[i2 >> 1])];
        } while (i2 > 0);
        return -i2;
    }

    public void seek() {
        this.input.position(this.offset);
    }

    public String toString() {
        return "bc: " + this.value;
    }

    public VPXBooleanDecoder() {
    }
}
