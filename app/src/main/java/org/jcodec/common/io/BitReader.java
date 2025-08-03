package org.jcodec.common.io;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class BitReader {
    private ByteBuffer bb;
    private int initPos;
    private int deficit = -1;
    private int curInt = -1;

    private BitReader(ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        this.initPos = byteBuffer.position();
    }

    public static BitReader createBitReader(ByteBuffer byteBuffer) {
        BitReader bitReader = new BitReader(byteBuffer);
        bitReader.curInt = bitReader.readInt();
        bitReader.deficit = 0;
        return bitReader;
    }

    private int nextIgnore() {
        if (this.bb.hasRemaining()) {
            return this.bb.get() & ExifInterface.MARKER;
        }
        return 0;
    }

    private int nextIgnore16() {
        if (this.bb.remaining() > 1) {
            return this.bb.getShort() & 65535;
        }
        if (this.bb.hasRemaining()) {
            return (this.bb.get() & ExifInterface.MARKER) << 8;
        }
        return 0;
    }

    private int readIntSafe() {
        this.deficit -= this.bb.remaining() << 3;
        int i = (this.bb.hasRemaining() ? 0 | (this.bb.get() & ExifInterface.MARKER) : 0) << 8;
        if (this.bb.hasRemaining()) {
            i |= this.bb.get() & ExifInterface.MARKER;
        }
        int i2 = i << 8;
        if (this.bb.hasRemaining()) {
            i2 |= this.bb.get() & ExifInterface.MARKER;
        }
        int i3 = i2 << 8;
        return this.bb.hasRemaining() ? i3 | (this.bb.get() & ExifInterface.MARKER) : i3;
    }

    public int align() {
        int i = this.deficit;
        if ((i & 7) > 0) {
            return skip(8 - (i & 7));
        }
        return 0;
    }

    public int bitsToAlign() {
        int i = this.deficit;
        if ((i & 7) > 0) {
            return 8 - (i & 7);
        }
        return 0;
    }

    public int check16Bits() {
        int i = this.deficit;
        if (i > 16) {
            this.deficit = i - 16;
            this.curInt |= nextIgnore16() << this.deficit;
        }
        return this.curInt >>> 16;
    }

    public int check24Bits() {
        int i = this.deficit;
        if (i > 16) {
            this.deficit = i - 16;
            this.curInt |= nextIgnore16() << this.deficit;
        }
        int i2 = this.deficit;
        if (i2 > 8) {
            this.deficit = i2 - 8;
            this.curInt |= nextIgnore() << this.deficit;
        }
        return this.curInt >>> 8;
    }

    public int checkAllBits() {
        return this.curInt;
    }

    public int checkNBit(int i) {
        if (i <= 24) {
            return checkNBitDontCare(i);
        }
        throw new IllegalArgumentException("Can not check more then 24 bit");
    }

    public int checkNBitDontCare(int i) {
        while (true) {
            int i2 = this.deficit;
            if (i2 + i <= 32) {
                return this.curInt >>> (32 - i);
            }
            this.deficit = i2 - 8;
            this.curInt |= nextIgnore() << this.deficit;
        }
    }

    public int curBit() {
        return this.deficit & 7;
    }

    public BitReader fork() {
        BitReader bitReader = new BitReader(this.bb.duplicate());
        bitReader.initPos = 0;
        bitReader.curInt = this.curInt;
        bitReader.deficit = this.deficit;
        return bitReader;
    }

    public final boolean isByteAligned() {
        return (this.deficit & 7) == 0;
    }

    public boolean lastByte() {
        return (this.bb.remaining() + 4) - (this.deficit >> 3) <= 1;
    }

    public boolean moreData() {
        int iRemaining = (this.bb.remaining() + 4) - ((this.deficit + 7) >> 3);
        if (iRemaining <= 1) {
            return iRemaining == 1 && this.curInt != 0;
        }
        return true;
    }

    public int position() {
        return (((this.bb.position() - this.initPos) - 4) << 3) + this.deficit;
    }

    public int read1Bit() {
        int i = this.curInt;
        int i2 = i >>> 31;
        this.curInt = i << 1;
        int i3 = this.deficit + 1;
        this.deficit = i3;
        if (i3 == 32) {
            this.curInt = readInt();
        }
        return i2;
    }

    public boolean readBool() {
        return read1Bit() == 1;
    }

    public int readFast16(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = this.deficit;
        if (i2 > 16) {
            this.deficit = i2 - 16;
            this.curInt |= nextIgnore16() << this.deficit;
        }
        int i3 = this.curInt;
        int i4 = i3 >>> (32 - i);
        this.deficit += i;
        this.curInt = i3 << i;
        return i4;
    }

    public final int readInt() {
        if (this.bb.remaining() < 4) {
            return readIntSafe();
        }
        this.deficit -= 32;
        return ((this.bb.get() & ExifInterface.MARKER) << 24) | ((this.bb.get() & ExifInterface.MARKER) << 16) | ((this.bb.get() & ExifInterface.MARKER) << 8) | (this.bb.get() & ExifInterface.MARKER);
    }

    public int readNBit(int i) {
        if (i > 32) {
            throw new IllegalArgumentException("Can not read more then 32 bit");
        }
        int i2 = 0;
        int i3 = this.deficit;
        if (i + i3 > 31) {
            i -= 32 - i3;
            i2 = (0 | (this.curInt >>> i3)) << i;
            this.deficit = 32;
            this.curInt = readInt();
        }
        if (i == 0) {
            return i2;
        }
        int i4 = this.curInt;
        int i5 = i2 | (i4 >>> (32 - i));
        this.curInt = i4 << i;
        this.deficit += i;
        return i5;
    }

    public int readNBitSigned(int i) {
        int nBit = readNBit(i);
        return read1Bit() == 0 ? nBit : -nBit;
    }

    public int remaining() {
        return ((this.bb.remaining() << 3) + 32) - this.deficit;
    }

    public int skip(int i) {
        int i2;
        int i3 = this.deficit;
        if (i + i3 > 31) {
            i2 = i - (32 - i3);
            this.deficit = 32;
            if (i2 > 31) {
                int iMin = Math.min(i2 >> 3, this.bb.remaining());
                ByteBuffer byteBuffer = this.bb;
                byteBuffer.position(byteBuffer.position() + iMin);
                i2 -= iMin << 3;
            }
            this.curInt = readInt();
        } else {
            i2 = i;
        }
        this.deficit += i2;
        this.curInt <<= i2;
        return i;
    }

    public int skipFast(int i) {
        this.deficit += i;
        this.curInt <<= i;
        return i;
    }

    public void stop() {
        ByteBuffer byteBuffer = this.bb;
        byteBuffer.position(byteBuffer.position() - ((32 - this.deficit) >> 3));
    }

    public void terminate() {
        int i = (32 - this.deficit) >> 3;
        ByteBuffer byteBuffer = this.bb;
        byteBuffer.position(byteBuffer.position() - i);
    }
}
