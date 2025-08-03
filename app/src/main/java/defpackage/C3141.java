package defpackage;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ExifOrientationStream.java */
/* renamed from: ԇ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3141 extends FilterInputStream {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final byte[] f11152;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final int f11153;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final int f11154;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final byte f11155;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f11156;

    static {
        byte[] bArr = {-1, ExifInterface.MARKER_APP1, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f11152 = bArr;
        int length = bArr.length;
        f11153 = length;
        f11154 = length + 2;
    }

    public C3141(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.f11155 = (byte) i;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i;
        int i2 = this.f11156;
        int i3 = (i2 < 2 || i2 > (i = f11154)) ? super.read() : i2 == i ? this.f11155 : f11152[i2 - 2] & ExifInterface.MARKER;
        if (i3 != -1) {
            this.f11156++;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = super.skip(j);
        if (jSkip > 0) {
            this.f11156 = (int) (this.f11156 + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3;
        int i4 = this.f11156;
        int i5 = f11154;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.f11155;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int iMin = Math.min(i5 - i4, i2);
            System.arraycopy(f11152, this.f11156 - 2, bArr, i, iMin);
            i3 = iMin;
        }
        if (i3 > 0) {
            this.f11156 += i3;
        }
        return i3;
    }
}
