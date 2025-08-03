package org.jcodec.common.io;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class BitWriter {
    private int _curBit;
    private final ByteBuffer buf;
    private int curInt;
    private int initPos;

    public BitWriter(ByteBuffer byteBuffer) {
        this.buf = byteBuffer;
        this.initPos = byteBuffer.position();
    }

    private final void putInt(int i) {
        this.buf.put((byte) (i >>> 24));
        this.buf.put((byte) (i >> 16));
        this.buf.put((byte) (i >> 8));
        this.buf.put((byte) i);
    }

    public int curBit() {
        return this._curBit & 7;
    }

    public void flush() {
        int i = (this._curBit + 7) >> 3;
        for (int i2 = 0; i2 < i; i2++) {
            this.buf.put((byte) (this.curInt >>> 24));
            this.curInt <<= 8;
        }
    }

    public BitWriter fork() {
        BitWriter bitWriter = new BitWriter(this.buf.duplicate());
        bitWriter._curBit = this._curBit;
        bitWriter.curInt = this.curInt;
        bitWriter.initPos = this.initPos;
        return bitWriter;
    }

    public ByteBuffer getBuffer() {
        return this.buf;
    }

    public int position() {
        return ((this.buf.position() - this.initPos) << 3) + this._curBit;
    }

    public void write1Bit(int i) {
        int i2 = this.curInt;
        int i3 = this._curBit;
        int i4 = (i << ((32 - i3) - 1)) | i2;
        this.curInt = i4;
        int i5 = i3 + 1;
        this._curBit = i5;
        if (i5 == 32) {
            putInt(i4);
            this._curBit = 0;
            this.curInt = 0;
        }
    }

    public final void writeNBit(int i, int i2) {
        if (i2 > 32) {
            throw new IllegalArgumentException("Max 32 bit to write");
        }
        if (i2 == 0) {
            return;
        }
        int i3 = i & ((-1) >>> (32 - i2));
        int i4 = this._curBit;
        if (32 - i4 < i2) {
            int i5 = i2 - (32 - i4);
            int i6 = this.curInt | (i3 >>> i5);
            this.curInt = i6;
            putInt(i6);
            this.curInt = i3 << (32 - i5);
            this._curBit = i5;
            return;
        }
        int i7 = (i3 << ((32 - i4) - i2)) | this.curInt;
        this.curInt = i7;
        int i8 = i4 + i2;
        this._curBit = i8;
        if (i8 == 32) {
            putInt(i7);
            this._curBit = 0;
            this.curInt = 0;
        }
    }
}
