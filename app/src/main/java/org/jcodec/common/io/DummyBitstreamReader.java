package org.jcodec.common.io;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class DummyBitstreamReader {
    public static int bitsRead;
    public int cnt = 0;
    private int curByte;
    private InputStream is;
    public int nBit;
    private int nextByte;
    private int secondByte;

    public DummyBitstreamReader(InputStream inputStream) throws IOException {
        this.is = inputStream;
        this.curByte = inputStream.read();
        this.nextByte = inputStream.read();
        this.secondByte = inputStream.read();
    }

    private final void advance() throws IOException {
        advance1();
        this.nBit = 0;
    }

    private final void advance1() throws IOException {
        this.curByte = this.nextByte;
        this.nextByte = this.secondByte;
        this.secondByte = this.is.read();
    }

    public int align() throws IOException {
        int i = this.nBit;
        int i2 = (8 - i) & 7;
        skip((8 - i) & 7);
        return i2;
    }

    public int checkNBit(int i) throws IOException {
        return peakNextBits(i);
    }

    public void close() throws IOException {
        this.is.close();
    }

    public int curBit() {
        return this.nBit;
    }

    public long getBitPosition() {
        return (bitsRead * 8) + (this.nBit % 8);
    }

    public int getCurBit() {
        return this.nBit;
    }

    public boolean isByteAligned() {
        return this.nBit % 8 == 0;
    }

    public boolean lastByte() throws IOException {
        return this.nextByte == -1 && this.secondByte == -1;
    }

    public boolean moreData() throws IOException {
        if (this.nBit == 8) {
            advance();
        }
        int i = this.curByte;
        if (i == -1) {
            return false;
        }
        int i2 = this.nextByte;
        return ((i2 == -1 || (i2 == 0 && this.secondByte == -1)) && (i & ((1 << (8 - this.nBit)) - 1)) == 0) ? false : true;
    }

    public boolean moreRBSPData() throws IOException {
        if (this.nBit == 8) {
            advance();
        }
        int i = 1 << ((8 - this.nBit) - 1);
        int i2 = this.curByte;
        return (i2 == -1 || (this.nextByte == -1 && ((((i << 1) - 1) & i2) == i))) ? false : true;
    }

    public int peakNextBits(int i) throws IOException {
        if (i > 8) {
            throw new IllegalArgumentException("N should be less then 8");
        }
        if (this.nBit == 8) {
            advance();
            if (this.curByte == -1) {
                return -1;
            }
        }
        int i2 = this.nBit;
        int[] iArr = new int[16 - i2];
        int i3 = 0;
        while (i2 < 8) {
            iArr[i3] = (this.curByte >> (7 - i2)) & 1;
            i2++;
            i3++;
        }
        int i4 = 0;
        while (i4 < 8) {
            iArr[i3] = (this.nextByte >> (7 - i4)) & 1;
            i4++;
            i3++;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < i; i6++) {
            i5 = (i5 << 1) | iArr[i6];
        }
        return i5;
    }

    public int read1Bit() throws IOException {
        return read1BitInt();
    }

    public int read1BitInt() throws IOException {
        if (this.nBit == 8) {
            advance();
            if (this.curByte == -1) {
                return -1;
            }
        }
        int i = this.curByte;
        int i2 = this.nBit;
        int i3 = (i >> (7 - i2)) & 1;
        this.nBit = i2 + 1;
        bitsRead++;
        return i3;
    }

    public int readByte() throws IOException {
        if (this.nBit > 0) {
            advance();
        }
        int i = this.curByte;
        advance();
        return i;
    }

    public int readNBit(int i) throws IOException {
        if (i > 32) {
            throw new IllegalArgumentException("Can not read more then 32 bit");
        }
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 << 1) | read1BitInt();
        }
        return i2;
    }

    public long readRemainingByte() throws IOException {
        return readNBit(8 - this.nBit);
    }

    public final int skip(int i) throws IOException {
        int i2;
        int i3 = this.nBit + i;
        this.nBit = i3;
        while (true) {
            i2 = this.nBit;
            if (i2 < 8 || this.curByte == -1) {
                break;
            }
            advance1();
            this.nBit -= 8;
        }
        return i3 - i2;
    }
}
