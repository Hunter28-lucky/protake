package com.blink.academy.film.support.stream.ts.google.API;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.umeng.analytics.pro.cb;
import okio.Utf8;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes.dex */
public class BitOutputStream {
    private static final byte[][] mask = {new byte[]{BER.ASN_LONG_LEN, -64, -32, -16, -8, -4, -2, -1}, new byte[]{0, TsConstants.ACESType_data, 96, 112, 120, 124, 126, Byte.MAX_VALUE}, new byte[]{0, 0, 32, 48, 56, 60, 62, Utf8.REPLACEMENT_BYTE}, new byte[]{0, 0, 0, cb.n, 24, 28, 30, 31}, new byte[]{0, 0, 0, 0, 8, 12, cb.l, cb.m}, new byte[]{0, 0, 0, 0, 0, 4, 6, 7}, new byte[]{0, 0, 0, 0, 0, 0, 2, 3}, new byte[]{0, 0, 0, 0, 0, 0, 0, 1}};
    private byte[] byte_array;
    private int current_bit_pos;
    private int mark_bit_pos;
    private int total_bits;

    public BitOutputStream(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.total_bits = i;
        if ((i & 7) != 0) {
            this.byte_array = new byte[(i >> 3) + 1];
        } else {
            this.byte_array = new byte[i >> 3];
        }
        init();
    }

    private void init() {
        this.current_bit_pos = 0;
        this.mark_bit_pos = -1;
    }

    public int getPos() {
        return this.current_bit_pos;
    }

    public int getSize() {
        return this.total_bits;
    }

    public void mark() {
        this.mark_bit_pos = this.current_bit_pos;
    }

    public boolean markSupported() {
        return true;
    }

    public void reset() {
        int i = this.mark_bit_pos;
        if (i != -1) {
            this.current_bit_pos = i;
        }
        this.mark_bit_pos = -1;
    }

    public int skip(int i) {
        if (i < 0) {
            return 0;
        }
        int i2 = this.total_bits;
        int i3 = this.current_bit_pos;
        if (i > i2 - i3) {
            i = i2 - i3;
        }
        this.current_bit_pos = i3 + i;
        return i;
    }

    public byte[] toByteArray() {
        return this.byte_array;
    }

    public String toString() {
        new String();
        String str = "(size[" + this.total_bits + "],pos[" + this.current_bit_pos + "]: ";
        if (this.byte_array == null) {
            str = str + "EMPTY";
        } else {
            int i = 0;
            for (int i2 = 0; i2 < this.byte_array.length; i2++) {
                for (int i3 = 7; i3 >= 0; i3--) {
                    str = ((this.byte_array[i2] >> i3) & 1) != 0 ? str + "1" : str + "0";
                    i++;
                    if (i >= this.total_bits) {
                        break;
                    }
                }
                if (i >= this.total_bits) {
                    break;
                }
                str = str + "_";
            }
        }
        return str + ")";
    }

    public int write(byte b, int i, int i2) {
        if (i < 0 || i2 < 0 || i > i2) {
            throw new IllegalArgumentException();
        }
        int i3 = this.current_bit_pos;
        int i4 = this.total_bits;
        if (i3 >= i4) {
            return -1;
        }
        int i5 = i3 & 7;
        int i6 = (i2 - i) + 1;
        if (i4 - i3 < i6) {
            i6 = i4 - i3;
            i2 = (i + i6) - 1;
        }
        if (i >= i5) {
            byte[] bArr = this.byte_array;
            int i7 = i3 >> 3;
            bArr[i7] = (byte) (((b & mask[i][i2]) << (i - i5)) | bArr[i7]);
            this.current_bit_pos = i3 + i6;
        } else {
            byte[] bArr2 = this.byte_array;
            int i8 = i3 >> 3;
            bArr2[i8] = (byte) (bArr2[i8] | (((mask[i][i2] & b) & 255) >>> (i5 - i)));
            int iMin = Math.min(i6, 8 - i5);
            this.current_bit_pos += iMin;
            if (iMin < i6) {
                write(b, i + iMin, i2);
            }
        }
        return i6;
    }

    public int writeFromLSB(byte b, int i) {
        return write(b, 8 - i, 7);
    }

    public int writeFromMSB(byte b, int i) {
        return write(b, 0, i - 1);
    }

    public int writeFromLSB(int i, int i2) {
        return writeFromMSB(i << (32 - i2), i2);
    }

    public int writeFromMSB(short s, int i) {
        int iWrite;
        int i2 = 8;
        int i3 = 0;
        while (i >= 8) {
            int iWrite2 = write((byte) ((s >>> i2) & 255), 0, 7);
            if (iWrite2 < 0) {
                return i3;
            }
            i3 += iWrite2;
            i -= 8;
            i2 -= 8;
        }
        return (i <= 0 || (iWrite = write((byte) ((s >>> i2) & 255), 0, i + (-1))) < 0) ? i3 : i3 + iWrite;
    }

    public int writeFromLSB(short s, int i) {
        return writeFromLSB((short) (s << (16 - i)), i);
    }

    public int writeFromMSB(int i, int i2) {
        int iWrite;
        int i3 = 24;
        int i4 = 0;
        while (i2 >= 8) {
            int iWrite2 = write((byte) ((i >>> i3) & 255), 0, 7);
            if (iWrite2 < 0) {
                return i4;
            }
            i4 += iWrite2;
            i2 -= 8;
            i3 -= 8;
        }
        return (i2 <= 0 || (iWrite = write((byte) ((i >>> i3) & 255), 0, i2 + (-1))) < 0) ? i4 : i4 + iWrite;
    }

    public BitOutputStream(byte[] bArr) {
        bArr.getClass();
        this.total_bits = bArr.length << 3;
        this.byte_array = bArr;
        init();
    }

    public int write(byte b) {
        return write(b, 0, 7);
    }

    public int write(byte[] bArr) {
        int iWrite;
        bArr.getClass();
        int i = 0;
        for (int i2 = 0; i2 < bArr.length && (iWrite = write(bArr[i2])) >= 0; i2++) {
            i += iWrite;
        }
        return i;
    }

    public int write(char c) {
        byte b = (byte) ((65280 & c) >> 8);
        byte b2 = (byte) (c & 255);
        int iWrite = write(b);
        if (iWrite < 0) {
            return -1;
        }
        int iWrite2 = write(b2);
        return iWrite2 < 0 ? iWrite : iWrite + iWrite2;
    }

    public int write(short s) {
        byte b = (byte) ((65280 & s) >> 8);
        byte b2 = (byte) (s & 255);
        int iWrite = write(b);
        if (iWrite < 0) {
            return -1;
        }
        int iWrite2 = write(b2);
        return iWrite2 < 0 ? iWrite : iWrite + iWrite2;
    }

    public int write(int i) {
        short s = (short) (((-65536) & i) >> 16);
        short s2 = (short) (i & 65535);
        int iWrite = write(s);
        if (iWrite < 0) {
            return -1;
        }
        int iWrite2 = write(s2);
        return iWrite2 < 0 ? iWrite : iWrite + iWrite2;
    }
}
