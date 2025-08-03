package org.jcodec.algo;

import androidx.exifinterface.media.ExifInterface;
import org.jcodec.api.NotSupportedException;

/* loaded from: classes2.dex */
public class DataConvert {
    public static int[] from16BE(byte[] bArr) {
        int length = bArr.length >> 1;
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            iArr[i] = ((bArr[i2] & ExifInterface.MARKER) << 8) | (bArr[i3] & ExifInterface.MARKER);
            i++;
            i2 = i3 + 1;
        }
        return iArr;
    }

    public static int[] from16LE(byte[] bArr) {
        int length = bArr.length >> 1;
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            iArr[i] = (bArr[i2] & ExifInterface.MARKER) | ((bArr[i3] & ExifInterface.MARKER) << 8);
            i++;
            i2 = i3 + 1;
        }
        return iArr;
    }

    public static int[] from24BE(byte[] bArr) {
        int length = bArr.length / 3;
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            iArr[i] = ((bArr[i2] & ExifInterface.MARKER) << 16) | ((bArr[i3] & ExifInterface.MARKER) << 8) | (bArr[i4] & ExifInterface.MARKER);
            i++;
            i2 = i4 + 1;
        }
        return iArr;
    }

    public static int[] from24LE(byte[] bArr) {
        int length = bArr.length / 3;
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            iArr[i] = (bArr[i2] & ExifInterface.MARKER) | ((bArr[i3] & ExifInterface.MARKER) << 8) | ((bArr[i4] & ExifInterface.MARKER) << 16);
            i++;
            i2 = i4 + 1;
        }
        return iArr;
    }

    public static int[] fromByte(byte[] bArr, int i, boolean z) {
        if (i == 24) {
            return z ? from24BE(bArr) : from24LE(bArr);
        }
        if (i == 16) {
            return z ? from16BE(bArr) : from16LE(bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Conversion from ");
        sb.append(i);
        sb.append("bit ");
        sb.append(z ? "big endian" : "little endian");
        sb.append(" is not supported.");
        throw new NotSupportedException(sb.toString());
    }

    public static byte[] to16BE(int[] iArr) {
        byte[] bArr = new byte[iArr.length << 1];
        int i = 0;
        for (int i2 : iArr) {
            int i3 = i + 1;
            bArr[i] = (byte) ((i2 >> 8) & 255);
            i = i3 + 1;
            bArr[i3] = (byte) (i2 & 255);
        }
        return bArr;
    }

    public static byte[] to16LE(int[] iArr) {
        byte[] bArr = new byte[iArr.length << 1];
        int i = 0;
        for (int i2 : iArr) {
            int i3 = i + 1;
            bArr[i] = (byte) (i2 & 255);
            i = i3 + 1;
            bArr[i3] = (byte) ((i2 >> 8) & 255);
        }
        return bArr;
    }

    public static byte[] to24BE(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 3];
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = iArr[i];
            bArr[i2] = (byte) ((i4 >> 16) & 255);
            int i5 = i3 + 1;
            bArr[i3] = (byte) ((i4 >> 8) & 255);
            bArr[i5] = (byte) (i4 & 255);
            i++;
            i2 = i5 + 1;
        }
        return bArr;
    }

    public static byte[] to24LE(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 3];
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            int i3 = i2 + 1;
            int i4 = iArr[i];
            bArr[i2] = (byte) (i4 & 255);
            int i5 = i3 + 1;
            bArr[i3] = (byte) ((i4 >> 8) & 255);
            bArr[i5] = (byte) ((i4 >> 16) & 255);
            i++;
            i2 = i5 + 1;
        }
        return bArr;
    }

    public static byte[] toByte(int[] iArr, int i, boolean z) {
        if (i == 24) {
            return z ? to24BE(iArr) : to24LE(iArr);
        }
        if (i == 16) {
            return z ? to16BE(iArr) : to16LE(iArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Conversion to ");
        sb.append(i);
        sb.append("bit ");
        sb.append(z ? "big endian" : "little endian");
        sb.append(" is not supported.");
        throw new NotSupportedException(sb.toString());
    }
}
