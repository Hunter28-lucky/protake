package org.jcodec.codecs.mjpeg.tools;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;

/* loaded from: classes2.dex */
public class Asserts {
    public static void assertEpsilonEquals(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length != bArr2.length) {
            throw new AssertionException("arrays of different size");
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = (bArr[i2] & ExifInterface.MARKER) - (bArr2[i2] & ExifInterface.MARKER);
            if (Math.abs(i3) > i) {
                throw new AssertionException("array element out of expected diff range: " + Math.abs(i3));
            }
        }
    }

    public static void assertEpsilonEqualsInt(int[] iArr, int[] iArr2, int i) {
        if (iArr.length != iArr2.length) {
            throw new AssertionException("arrays of different size");
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            int i4 = iArr2[i2];
            if (Math.abs(i3 - i4) > i) {
                throw new AssertionException("array element " + i2 + MyUTIL.white_space + i3 + " != " + i4 + " out of expected diff range " + i);
            }
        }
    }

    public static void assertEquals(int i, int i2) {
        if (i == i2) {
            return;
        }
        throw new AssertionException("assert failed: " + i + " != " + i2);
    }

    public static void assertInRange(String str, int i, int i2, int i3) {
        if (i3 < i || i3 > i2) {
            throw new AssertionException(str);
        }
    }
}
