package net.sourceforge.jaad.aac.syntax;

import androidx.exifinterface.media.ExifInterface;
import net.sourceforge.jaad.aac.AACException;

/* loaded from: classes2.dex */
public class BitStream implements IBitStream {
    private static final int BYTE_MASK = 255;
    private static final int WORD_BITS = 32;
    private static final int WORD_BYTES = 4;
    public int bitsCached;
    private byte[] buffer;
    private int cache;
    private int pos;
    public int position;

    public static BitStream createBitStream(byte[] bArr) {
        BitStream bitStream = new BitStream();
        bitStream.setData(bArr);
        return bitStream;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void byteAlign() throws AACException {
        int i = this.bitsCached & 7;
        if (i > 0) {
            skipBits(i);
        }
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void destroy() {
        reset();
        this.buffer = null;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int getBitsLeft() {
        byte[] bArr = this.buffer;
        if (bArr != null) {
            return ((bArr.length - this.pos) * 8) + this.bitsCached;
        }
        return 0;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int getPosition() {
        return this.position;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int maskBits(int i) {
        if (i == 32) {
            return -1;
        }
        return (1 << i) - 1;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int peekBit() throws AACException {
        int i = this.bitsCached;
        return (i > 0 ? this.cache >> (i - 1) : readCache(true) >> 31) & 1;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int peekBits(int i) throws AACException {
        int i2 = this.bitsCached;
        if (i2 >= i) {
            return maskBits(i) & (this.cache >> (i2 - i));
        }
        int iMaskBits = maskBits(i2) & this.cache;
        int i3 = i - this.bitsCached;
        return (iMaskBits << i3) | ((readCache(true) >> (32 - i3)) & maskBits(i3));
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int readBit() throws AACException {
        int i = this.bitsCached;
        if (i > 0) {
            int i2 = i - 1;
            this.bitsCached = i2;
            int i3 = (this.cache >> i2) & 1;
            this.position++;
            return i3;
        }
        int cache = readCache(false);
        this.cache = cache;
        this.bitsCached = 31;
        this.position++;
        return (cache >> 31) & 1;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int readBits(int i) throws AACException {
        int i2 = this.bitsCached;
        if (i2 >= i) {
            int i3 = i2 - i;
            this.bitsCached = i3;
            int iMaskBits = (this.cache >> i3) & maskBits(i);
            this.position += i;
            return iMaskBits;
        }
        this.position += i;
        int iMaskBits2 = maskBits(i2) & this.cache;
        int i4 = i - this.bitsCached;
        int cache = readCache(false);
        this.cache = cache;
        int i5 = 32 - i4;
        this.bitsCached = i5;
        return ((cache >> i5) & maskBits(i4)) | (iMaskBits2 << i4);
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public boolean readBool() throws AACException {
        return (readBit() & 1) != 0;
    }

    public int readCache(boolean z) throws AACException {
        int i = this.pos;
        byte[] bArr = this.buffer;
        if (i > bArr.length - 4) {
            throw AACException.endOfStream();
        }
        int i2 = (bArr[i + 3] & ExifInterface.MARKER) | ((bArr[i] & ExifInterface.MARKER) << 24) | ((bArr[i + 1] & ExifInterface.MARKER) << 16) | ((bArr[i + 2] & ExifInterface.MARKER) << 8);
        if (!z) {
            this.pos = i + 4;
        }
        return i2;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public final void reset() {
        this.pos = 0;
        this.bitsCached = 0;
        this.cache = 0;
        this.position = 0;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public final void setData(byte[] bArr) {
        int length = (((bArr.length + 4) - 1) / 4) * 4;
        byte[] bArr2 = this.buffer;
        if (bArr2 == null || bArr2.length != length) {
            this.buffer = new byte[length];
        }
        System.arraycopy(bArr, 0, this.buffer, 0, bArr.length);
        reset();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void skipBit() throws AACException {
        this.position++;
        int i = this.bitsCached;
        if (i > 0) {
            this.bitsCached = i - 1;
        } else {
            this.cache = readCache(false);
            this.bitsCached = 31;
        }
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void skipBits(int i) throws AACException {
        this.position += i;
        int i2 = this.bitsCached;
        if (i <= i2) {
            this.bitsCached = i2 - i;
            return;
        }
        int i3 = i - i2;
        while (i3 >= 32) {
            i3 -= 32;
            readCache(false);
        }
        if (i3 > 0) {
            this.cache = readCache(false);
            this.bitsCached = 32 - i3;
        } else {
            this.cache = 0;
            this.bitsCached = 0;
        }
    }
}
