package com.blink.academy.film.support.stream.ts.google.flavor;

import androidx.core.app.FrameMetricsAggregator;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.xiaomi.clientreport.data.Config;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class BuffBitstream implements IBitstream {
    public static final int BUF_LEN = 2048;
    public static int MAX_SIZE_OF_BITS = 32;
    public byte[] buf;
    public int buf_len;
    public boolean close_fd;
    public int cur_bit;
    public int cur_buf;
    public byte[] dbuf;
    public int dbuf_len;
    public int dcur_bit;
    public int dsize;
    public int dtot_bits;
    public boolean eof;
    public byte[] ibuf;
    public int ibuf_len;
    public int icur_bit;
    public InputStream in;
    public int itot_bits;
    public OutputStream out;
    public int tot_bits;
    public int type;
    public static final int[] mask = {0, 1, 3, 7, 15, 31, 63, 127, 255, FrameMetricsAggregator.EVERY_DURATION, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, ViewCompat.MEASURED_SIZE_MASK, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
    public static final int[] cmask = {-1, -2, -4, -8, -16, -32, -64, -128, InputDeviceCompat.SOURCE_ANY, -512, -1024, -2048, -4096, -8192, -16384, -32768, -65536, -131072, -262144, -524288, -1048576, -2097152, -4194304, -8388608, ViewCompat.MEASURED_STATE_MASK, -33554432, -67108864, -134217728, -268435456, -536870912, -1073741824, Integer.MIN_VALUE, 0};
    public static final int[] smask = {0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE};
    public static final long[] clongmask = {-1, -2, -4, -8, -16, -32, -64, -128, -256, -512, -1024, -2048, -4096, -8192, -16384, -32768, -65536, -131072, -262144, -524288, -1048576, -2097152, -4194304, -8388608, -16777216, -33554432, -67108864, -134217728, -268435456, -536870912, -1073741824, -2147483648L, -4294967296L, -8589934592L, -17179869184L, -34359738368L, -68719476736L, -137438953472L, -274877906944L, -549755813888L, -1099511627776L, -2199023255552L, -4398046511104L, -8796093022208L, -17592186044416L, -35184372088832L, -70368744177664L, -140737488355328L, -281474976710656L, -562949953421312L, -1125899906842624L, -2251799813685248L, -4503599627370496L, -9007199254740992L, -18014398509481984L, -36028797018963968L, -72057594037927936L, -144115188075855872L, -288230376151711744L, -576460752303423488L, -1152921504606846976L, -2305843009213693952L, -4611686018427387904L, Long.MIN_VALUE, 0};
    public static final long[] slongmask = {0, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLSX, ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_PDF, 8192, 16384, 32768, 65536, 131072, 262144, 524288, Config.DEFAULT_MAX_FILE_LENGTH, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483648L, 4294967296L, 8589934592L, 17179869184L, 34359738368L, 68719476736L, 137438953472L, 274877906944L, 549755813888L, 1099511627776L, 2199023255552L, 4398046511104L, 8796093022208L, 17592186044416L, 35184372088832L, 70368744177664L, 140737488355328L, 281474976710656L, 562949953421312L, 1125899906842624L, 2251799813685248L, 4503599627370496L, 9007199254740992L, 18014398509481984L, 36028797018963968L, 72057594037927936L, 144115188075855872L, 288230376151711744L, 576460752303423488L, 1152921504606846976L, 2305843009213693952L, 4611686018427387904L, Long.MIN_VALUE};

    public BuffBitstream(String str, int i) throws FlIOException {
        this(str, i, 2048);
    }

    private void fill_buf() throws IOException {
        int i = this.cur_bit >>> 3;
        int i2 = this.buf_len - i;
        byte[] bArr = this.buf;
        System.arraycopy(bArr, i, bArr, 0, i2);
        try {
            int i3 = this.in.read(this.buf, i2, i);
            if (i3 == -1) {
                this.eof = true;
                throw new FlIOException(FlIOException.ENDOFDATA);
            }
            if (i3 < i) {
                this.eof = true;
                this.buf_len = i2 + i3;
            }
            this.cur_bit &= 7;
        } catch (IOException e2) {
            throw new FlIOException(FlIOException.SYSTEMIOFAILED, e2.toString());
        }
    }

    private void flush_buf() throws IOException {
        int i = this.cur_bit >>> 3;
        try {
            this.out.write(this.buf, 0, i);
            int i2 = this.cur_bit & 7;
            this.cur_bit = i2;
            if (i2 != 0) {
                byte[] bArr = this.buf;
                bArr[0] = bArr[i];
            }
        } catch (IOException e2) {
            throw new FlIOException(FlIOException.SYSTEMIOFAILED, e2.toString());
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int align(int i) throws IOException {
        if (i % 8 != 0) {
            throw new FlIOException(FlIOException.INVALIDALIGNMENT);
        }
        int i2 = 0;
        int i3 = this.tot_bits;
        if (i3 % 8 != 0) {
            i2 = 8 - (i3 % 8);
            skipbits(i2);
        }
        while (this.tot_bits % i != 0) {
            i2 += 8;
            skipbits(8);
        }
        return i2;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public boolean atend() {
        return this.eof;
    }

    public void buffer(int i) throws IOException {
        if (this.cur_buf == 1) {
            return;
        }
        align(8);
        int i2 = i * 8;
        if (this.cur_bit + i2 > (this.buf_len << 3)) {
            fill_buf();
        }
        System.arraycopy(this.buf, this.cur_bit >>> 3, this.dbuf, this.dsize, i);
        this.dsize += i;
        skipbits(i2);
    }

    public void close() throws IOException {
        try {
            if (this.type != 1) {
                if (this.close_fd) {
                    this.in.close();
                    this.close_fd = false;
                    return;
                }
                return;
            }
            flushbits();
            if (this.close_fd) {
                this.out.close();
                this.close_fd = false;
            }
        } catch (IOException e2) {
            throw new FlIOException(FlIOException.SYSTEMIOFAILED, e2.toString());
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        close();
    }

    public void flushbits() throws IOException {
        flush_buf();
        if (this.cur_bit == 0) {
            return;
        }
        try {
            this.out.write(this.buf, 0, 1);
            this.buf[0] = 0;
            this.cur_bit = 0;
        } catch (IOException e2) {
            throw new FlIOException(FlIOException.SYSTEMIOFAILED, e2.toString());
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int getbits(int i) throws IOException {
        int iNextbits = nextbits(i);
        this.cur_bit += i;
        this.tot_bits += i;
        return iNextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public double getdouble() throws IOException {
        double dNextdouble = nextdouble();
        skipbits(64);
        return dNextdouble;
    }

    public int getdsize() {
        return this.dsize;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public float getfloat() throws IOException {
        float fNextfloat = nextfloat();
        skipbits(32);
        return fNextfloat;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long getlong(int i) throws IOException {
        long jNextlong = nextlong(i);
        skipbits(i);
        return jNextlong;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int getmode() {
        return this.type;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int getpos() {
        return this.tot_bits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int little_getbits(int i) throws IOException {
        int iLittle_nextbits = little_nextbits(i);
        this.cur_bit += i;
        this.tot_bits += i;
        return iLittle_nextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public double little_getdouble() throws IOException {
        double dLittle_nextdouble = little_nextdouble();
        skipbits(64);
        return dLittle_nextdouble;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public float little_getfloat() throws IOException {
        float fLittle_nextfloat = little_nextfloat();
        skipbits(32);
        return fLittle_nextfloat;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long little_getlong(int i) throws IOException {
        long jLittle_nextlong = little_nextlong(i);
        skipbits(i);
        return jLittle_nextlong;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int little_nextbits(int i) throws IOException {
        int i2 = 0;
        if (i == 0) {
            return 0;
        }
        if (i > MAX_SIZE_OF_BITS || i < 1) {
            throw new FlIOException(FlIOException.INVALIDBITSIZE);
        }
        int i3 = i >>> 3;
        int i4 = i % 8;
        int iNextbits = 0;
        while (i2 < i3) {
            int iNextbits2 = nextbits(8);
            this.cur_bit += 8;
            iNextbits |= iNextbits2 << (i2 * 8);
            i2++;
        }
        if (i4 > 0) {
            iNextbits |= nextbits(i4) << (i2 * 8);
        }
        this.cur_bit -= i2 * 8;
        return iNextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public double little_nextdouble() throws IOException {
        if (this.cur_bit + 64 > (this.buf_len << 3)) {
            fill_buf();
        }
        this.cur_bit -= 64;
        this.tot_bits -= 64;
        return Double.longBitsToDouble(getbits(32) | (little_sgetbits(32) << 32));
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public float little_nextfloat() throws FlIOException {
        return Float.intBitsToFloat(little_nextbits(32));
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long little_nextlong(int i) throws IOException {
        long jNextbits = 0;
        if (i == 0) {
            return 0L;
        }
        if (i > MAX_SIZE_OF_BITS * 2 || i < 1) {
            throw new FlIOException(FlIOException.INVALIDBITSIZE);
        }
        int i2 = i >>> 3;
        int i3 = i % 8;
        int i4 = 0;
        while (i4 < i2) {
            int iNextbits = nextbits(8);
            this.cur_bit += 8;
            jNextbits |= iNextbits << (i4 * 8);
            i4++;
        }
        if (i3 > 0) {
            jNextbits |= nextbits(i3) << (i4 * 8);
        }
        this.cur_bit -= i4 * 8;
        return jNextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int little_putbits(int i, int i2) throws IOException {
        if (i2 == 0) {
            return i;
        }
        if (i2 > MAX_SIZE_OF_BITS || i2 < 1) {
            throw new FlIOException(FlIOException.INVALIDBITSIZE);
        }
        int i3 = i2 >>> 3;
        int i4 = i2 % 8;
        int i5 = 0;
        while (i5 < i3) {
            putbits((i >> (i5 * 8)) & mask[8], 8);
            i5++;
        }
        if (i4 > 0) {
            putbits((i >> (i5 * 8)) & mask[i4], i4);
        }
        return i;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public double little_putdouble(double d) throws IOException {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        little_putbits((int) ((-1) & jDoubleToLongBits), 32);
        little_putbits((int) (jDoubleToLongBits >>> 32), 32);
        return d;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public float little_putfloat(float f) throws IOException {
        little_putbits(Float.floatToIntBits(f), 32);
        return f;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long little_putlong(long j, int i) throws IOException {
        if (i <= 32) {
            return little_putbits((int) j, i);
        }
        little_putbits((int) (j >>> 32), i - 32);
        little_putbits((int) ((-1) & j), 32);
        return j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int little_sgetbits(int i) throws IOException {
        int iLittle_snextbits = little_snextbits(i);
        this.cur_bit += i;
        this.tot_bits += i;
        return iLittle_snextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long little_sgetlong(int i) throws IOException {
        long jLittle_snextlong = little_snextlong(i);
        skipbits(i);
        return jLittle_snextlong;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int little_snextbits(int i) throws IOException {
        int iLittle_nextbits = little_nextbits(i);
        return (i <= 1 || (smask[i] & iLittle_nextbits) == 0) ? iLittle_nextbits : cmask[i] | iLittle_nextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long little_snextlong(int i) throws IOException {
        long jLittle_nextlong = little_nextlong(i);
        return (i <= 1 || (slongmask[i] & jLittle_nextlong) == 0) ? jLittle_nextlong : jLittle_nextlong | clongmask[i];
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int next(int i, int i2, int i3, int i4) throws IOException {
        if (i4 > 0) {
            align(i4);
        }
        if (this.type == 0) {
            return i2 > 0 ? i3 > 0 ? snextbits(i) : nextbits(i) : i3 > 0 ? little_snextbits(i) : little_nextbits(i);
        }
        return 0;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int nextbits(int i) throws IOException {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            return 0;
        }
        if (i > MAX_SIZE_OF_BITS || i < 1) {
            throw new FlIOException(FlIOException.INVALIDBITSIZE);
        }
        if (this.cur_bit + i > (this.buf_len << 3)) {
            fill_buf();
        }
        int i5 = this.buf_len << 3;
        int i6 = this.cur_bit;
        if (i5 - i6 < i) {
            throw new FlIOException(FlIOException.NOTENOUGHDATA);
        }
        int i7 = i6 >>> 3;
        int i8 = ((i6 + i) - 1) >>> 3;
        int i9 = 8 - (i6 % 8);
        if (i9 >= i) {
            return mask[i] & (this.buf[i7] >> (i9 - i));
        }
        int i10 = (i6 + i) % 8;
        int i11 = (this.buf[i7] & mask[i9]) | 0;
        int i12 = i7 + 1;
        while (i12 < i8) {
            i11 = (i11 << 8) | (this.buf[i12] & mask[8]);
            i12++;
        }
        if (i10 > 0) {
            i2 = i11 << i10;
            i3 = this.buf[i12] >> (8 - i10);
            i4 = mask[i10];
        } else {
            i2 = i11 << 8;
            i3 = this.buf[i12];
            i4 = mask[8];
        }
        return i2 | (i3 & i4);
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int nextcode(int i, int i2, int i3) throws IOException {
        int i4 = this.type;
        int i5 = 0;
        if (i4 != 0) {
            if (i4 == 1) {
                return 0 + align(i3);
            }
            return 0;
        }
        if (i3 == 0) {
            while (i != nextbits(i2)) {
                i5++;
                skipbits(1);
            }
            return i5;
        }
        int iAlign = align(i3) + 0;
        while (i != nextbits(i2)) {
            iAlign += i3;
            skipbits(i3);
        }
        return iAlign;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public double nextdouble() throws IOException {
        if (this.cur_bit + 64 > (this.buf_len << 3)) {
            fill_buf();
        }
        this.cur_bit -= 64;
        this.tot_bits -= 64;
        return Double.longBitsToDouble((sgetbits(32) << 32) | getbits(32));
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public float nextfloat() throws FlIOException {
        return Float.intBitsToFloat(nextbits(32));
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long nextlong(int i) throws IOException {
        long j;
        int i2;
        int i3;
        if (i == 0) {
            return 0L;
        }
        if (i > MAX_SIZE_OF_BITS * 2 || i < 1) {
            throw new FlIOException(FlIOException.INVALIDBITSIZE);
        }
        if (this.cur_bit + i > (this.buf_len << 3)) {
            fill_buf();
        }
        if (this.cur_bit + i > (this.buf_len << 3)) {
            fill_buf();
        }
        int i4 = this.buf_len << 3;
        int i5 = this.cur_bit;
        if (i4 - i5 < i) {
            throw new FlIOException(FlIOException.NOTENOUGHDATA);
        }
        int i6 = i5 >>> 3;
        int i7 = ((i5 + i) - 1) >>> 3;
        if (8 - (i5 % 8) >= i) {
            return mask[i] & (this.buf[i6] >> (r6 - i));
        }
        int i8 = (i5 + i) % 8;
        long j2 = 0 | (this.buf[i6] & mask[r6]);
        int i9 = i6 + 1;
        while (i9 < i7) {
            j2 = (j2 << 8) | (this.buf[i9] & mask[8]);
            i9++;
        }
        if (i8 > 0) {
            j = j2 << i8;
            i2 = this.buf[i9] >> (8 - i8);
            i3 = mask[i8];
        } else {
            j = j2 << 8;
            i2 = this.buf[i9];
            i3 = mask[8];
        }
        return j | (i2 & i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0067 -> B:18:0x0061). Please report as a decompilation issue!!! */
    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int putbits(int r10, int r11) throws java.io.IOException {
        /*
            r9 = this;
            if (r11 != 0) goto L3
            return r10
        L3:
            int r0 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.MAX_SIZE_OF_BITS
            if (r11 > r0) goto L97
            r0 = 1
            if (r11 < r0) goto L97
            int r1 = r9.cur_bit
            int r1 = r1 + r11
            int r2 = r9.buf_len
            int r2 = r2 << 3
            if (r1 <= r2) goto L16
            r9.flush_buf()
        L16:
            int r1 = r9.cur_bit
            int r2 = r1 + r11
            int r2 = r2 - r0
            int r0 = r2 >>> 3
            int r2 = r1 >>> 3
            int r3 = r1 % 8
            r4 = 8
            int r3 = 8 - r3
            if (r3 < r11) goto L48
            byte[] r0 = r9.buf
            r4 = r0[r2]
            int[] r5 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.cmask
            r5 = r5[r3]
            r4 = r4 & r5
            byte r4 = (byte) r4
            r0[r2] = r4
            int[] r5 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.mask
            r5 = r5[r3]
            int r3 = r3 - r11
            int r3 = r10 << r3
            r3 = r3 & r5
            r3 = r3 | r4
            byte r3 = (byte) r3
            r0[r2] = r3
            int r1 = r1 + r11
            r9.cur_bit = r1
            int r0 = r9.tot_bits
            int r0 = r0 + r11
            r9.tot_bits = r0
            return r10
        L48:
            int r1 = r11 - r3
            int r1 = r1 % r4
            r5 = 0
            if (r1 <= 0) goto L64
            byte[] r6 = r9.buf
            r6[r0] = r5
            int r7 = 8 - r1
            int r7 = r10 << r7
            int[] r8 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.mask
            r8 = r8[r4]
            r7 = r7 & r8
            r7 = r7 | r5
            byte r7 = (byte) r7
            r6[r0] = r7
            int r1 = r10 >> r1
        L61:
            int r0 = r0 + (-1)
            goto L65
        L64:
            r1 = r10
        L65:
            if (r0 <= r2) goto L77
            byte[] r6 = r9.buf
            r6[r0] = r5
            int[] r7 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.mask
            r7 = r7[r4]
            r7 = r7 & r1
            r7 = r7 | r5
            byte r7 = (byte) r7
            r6[r0] = r7
            int r1 = r1 >>> 8
            goto L61
        L77:
            byte[] r2 = r9.buf
            r4 = r2[r0]
            int[] r5 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.cmask
            r5 = r5[r3]
            r4 = r4 & r5
            byte r4 = (byte) r4
            r2[r0] = r4
            int[] r5 = com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.mask
            r3 = r5[r3]
            r1 = r1 & r3
            r1 = r1 | r4
            byte r1 = (byte) r1
            r2[r0] = r1
            int r0 = r9.cur_bit
            int r0 = r0 + r11
            r9.cur_bit = r0
            int r0 = r9.tot_bits
            int r0 = r0 + r11
            r9.tot_bits = r0
            return r10
        L97:
            com.blink.academy.film.support.stream.ts.google.flavor.FlIOException r10 = new com.blink.academy.film.support.stream.ts.google.flavor.FlIOException
            int r11 = com.blink.academy.film.support.stream.ts.google.flavor.FlIOException.INVALIDBITSIZE
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blink.academy.film.support.stream.ts.google.flavor.BuffBitstream.putbits(int, int):int");
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public double putdouble(double d) throws IOException {
        long jDoubleToLongBits = Double.doubleToLongBits(d);
        putbits((int) (jDoubleToLongBits >>> 32), 32);
        putbits((int) (jDoubleToLongBits & (-1)), 32);
        return d;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public float putfloat(float f) throws IOException {
        putbits(Float.floatToIntBits(f), 32);
        return f;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long putlong(long j, int i) throws IOException {
        if (i <= 32) {
            return putbits((int) j, i);
        }
        putbits((int) (j >>> 32), i - 32);
        putbits((int) ((-1) & j), 32);
        return j;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int sgetbits(int i) throws IOException {
        int iSnextbits = snextbits(i);
        this.cur_bit += i;
        this.tot_bits += i;
        return iSnextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long sgetlong(int i) throws IOException {
        long jSnextlong = snextlong(i);
        skipbits(i);
        return jSnextlong;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public void skipbits(int i) throws IOException {
        int i2 = this.buf_len << 3;
        int i3 = i;
        while (true) {
            int i4 = this.cur_bit;
            if (i4 + i3 <= i2) {
                this.cur_bit = i4 + i3;
                this.tot_bits += i;
                return;
            } else {
                i3 -= i2 - i4;
                this.cur_bit = i2;
                if (this.type == 0) {
                    fill_buf();
                } else {
                    flush_buf();
                }
            }
        }
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public int snextbits(int i) throws IOException {
        int iNextbits = nextbits(i);
        return (i <= 1 || (smask[i] & iNextbits) == 0) ? iNextbits : cmask[i] | iNextbits;
    }

    @Override // com.blink.academy.film.support.stream.ts.google.flavor.IBitstream
    public long snextlong(int i) throws IOException {
        long jNextlong = nextlong(i);
        return (i <= 1 || (slongmask[i] & jNextlong) == 0) ? jNextlong : jNextlong | clongmask[i];
    }

    public void swap() throws FlIOException {
        if (this.cur_buf != 1) {
            this.ibuf_len = this.buf_len;
            this.icur_bit = this.cur_bit;
            this.itot_bits = this.tot_bits;
            this.buf = this.dbuf;
            this.buf_len = this.dbuf_len;
            this.cur_bit = this.dcur_bit;
            this.tot_bits = this.dtot_bits;
            this.cur_buf = 1;
            return;
        }
        int i = this.cur_bit;
        int i2 = i >>> 3;
        if ((i & 7) > 0) {
            i2++;
        }
        int i3 = this.dsize - i2;
        byte[] bArr = this.buf;
        System.arraycopy(bArr, i2, bArr, 0, i3);
        this.dcur_bit = 0;
        this.dtot_bits = this.tot_bits;
        this.dsize = i3;
        this.buf = this.ibuf;
        this.buf_len = this.ibuf_len;
        this.cur_bit = this.icur_bit;
        this.tot_bits = this.itot_bits;
        this.cur_buf = 0;
    }

    public BuffBitstream(String str, int i, int i2) throws FlIOException {
        this.in = null;
        this.out = null;
        this.close_fd = false;
        this.eof = false;
        this.buf_len = 2048;
        this.dbuf_len = 2048;
        this.type = i;
        this.ibuf_len = i2;
        this.icur_bit = 0;
        this.itot_bits = 0;
        byte[] bArr = new byte[i2];
        this.ibuf = bArr;
        this.dbuf_len = i2;
        this.dcur_bit = 0;
        this.dtot_bits = 0;
        this.dsize = 0;
        this.dbuf = new byte[i2];
        this.cur_buf = 0;
        this.buf = bArr;
        this.buf_len = i2;
        this.cur_bit = 0;
        this.tot_bits = 0;
        if (i == 0) {
            try {
                this.in = new BufferedInputStream(new FileInputStream(str));
                this.cur_bit = 16384;
                fill_buf();
            } catch (IOException e2) {
                throw new FlIOException(FlIOException.FILEOPENFAILED, e2.toString());
            }
        } else {
            if (i != 1) {
                throw new FlIOException(FlIOException.INVALIDIOTYPE);
            }
            try {
                this.out = new BufferedOutputStream(new FileOutputStream(str));
            } catch (IOException e3) {
                throw new FlIOException(FlIOException.FILEOPENFAILED, e3.toString());
            }
        }
        this.close_fd = true;
    }
}
