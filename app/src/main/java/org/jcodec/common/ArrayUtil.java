package org.jcodec.common;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.lang.reflect.Array;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class ArrayUtil {
    public static int[] addAllInt(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return cloneInt(iArr2);
        }
        if (iArr2 == null) {
            return cloneInt(iArr);
        }
        int[] iArr3 = new int[iArr.length + iArr2.length];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static long[] addAllLong(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return cloneLong(jArr2);
        }
        if (jArr2 == null) {
            return cloneLong(jArr);
        }
        long[] jArr3 = new long[jArr.length + jArr2.length];
        System.arraycopy(jArr, 0, jArr3, 0, jArr.length);
        System.arraycopy(jArr2, 0, jArr3, jArr.length, jArr2.length);
        return jArr3;
    }

    public static Object[] addAllObj(Object[] objArr, Object[] objArr2) {
        if (objArr == null) {
            return cloneObj(objArr2);
        }
        if (objArr2 == null) {
            return cloneObj(objArr);
        }
        Object[] objArr3 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + objArr2.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        return objArr3;
    }

    public static void addInt(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    public static int[] cloneInt(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static long[] cloneLong(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static Object[] cloneObj(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        return (Object[]) objArr.clone();
    }

    public static void copy1D(int[] iArr, int[] iArr2) {
        for (int i = 0; i < Math.min(iArr.length, iArr2.length); i++) {
            iArr[i] = iArr2[i];
        }
    }

    public static void copy2D(int[][] iArr, int[][] iArr2) {
        for (int i = 0; i < Math.min(iArr.length, iArr2.length); i++) {
            copy1D(iArr[i], iArr2[i]);
        }
    }

    public static void copy3D(int[][][] iArr, int[][][] iArr2) {
        for (int i = 0; i < Math.min(iArr.length, iArr2.length); i++) {
            copy2D(iArr[i], iArr2[i]);
        }
    }

    public static void copy4D(int[][][][] iArr, int[][][][] iArr2) {
        for (int i = 0; i < Math.min(iArr.length, iArr2.length); i++) {
            copy3D(iArr[i], iArr2[i]);
        }
    }

    public static void copy5D(int[][][][][] iArr, int[][][][][] iArr2) {
        for (int i = 0; i < Math.min(iArr.length, iArr2.length); i++) {
            copy4D(iArr[i], iArr2[i]);
        }
    }

    public static void copy6D(int[][][][][][] iArr, int[][][][][][] iArr2) {
        for (int i = 0; i < Math.min(iArr.length, iArr2.length); i++) {
            copy5D(iArr[i], iArr2[i]);
        }
    }

    public static byte[][] create2D(int i, int i2) {
        byte[][] bArr = new byte[i2][];
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i3] = new byte[i];
        }
        return bArr;
    }

    public static int fill1D(int[] iArr, int[] iArr2, int i) {
        int i2 = 0;
        while (i2 < iArr.length) {
            iArr[i2] = iArr2[i];
            i2++;
            i++;
        }
        return i;
    }

    public static int fill2D(int[][] iArr, int[] iArr2, int i) {
        for (int[] iArr3 : iArr) {
            i = fill1D(iArr3, iArr2, i);
        }
        return i;
    }

    public static int fill3D(int[][][] iArr, int[] iArr2, int i) {
        for (int[][] iArr3 : iArr) {
            i = fill2D(iArr3, iArr2, i);
        }
        return i;
    }

    public static int fill4D(int[][][][] iArr, int[] iArr2, int i) {
        for (int[][][] iArr3 : iArr) {
            i = fill3D(iArr3, iArr2, i);
        }
        return i;
    }

    public static int fill5D(int[][][][][] iArr, int[] iArr2, int i) {
        for (int[][][][] iArr3 : iArr) {
            i = fill4D(iArr3, iArr2, i);
        }
        return i;
    }

    public static int fill6D(int[][][][][][] iArr, int[] iArr2, int i) {
        for (int[][][][][] iArr3 : iArr) {
            i = fill5D(iArr3, iArr2, i);
        }
        return i;
    }

    private static void flatten1DL(int[] iArr, IntArrayList intArrayList) {
        for (int i : iArr) {
            intArrayList.add(i);
        }
    }

    public static int[] flatten2D(int[][] iArr) {
        IntArrayList intArrayList = new IntArrayList(128);
        flatten2DL(iArr, intArrayList);
        return intArrayList.toArray();
    }

    private static void flatten2DL(int[][] iArr, IntArrayList intArrayList) {
        for (int[] iArr2 : iArr) {
            flatten1DL(iArr2, intArrayList);
        }
    }

    public static int[] flatten3D(int[][][] iArr) {
        IntArrayList intArrayList = new IntArrayList(128);
        flatten3DL(iArr, intArrayList);
        return intArrayList.toArray();
    }

    private static void flatten3DL(int[][][] iArr, IntArrayList intArrayList) {
        for (int[][] iArr2 : iArr) {
            flatten2DL(iArr2, intArrayList);
        }
    }

    public static int[] flatten4D(int[][][][] iArr) {
        IntArrayList intArrayList = new IntArrayList(128);
        flatten4DL(iArr, intArrayList);
        return intArrayList.toArray();
    }

    private static void flatten4DL(int[][][][] iArr, IntArrayList intArrayList) {
        for (int[][][] iArr2 : iArr) {
            flatten3DL(iArr2, intArrayList);
        }
    }

    public static int[] flatten5D(int[][][][][] iArr) {
        IntArrayList intArrayList = new IntArrayList(128);
        flatten5DL(iArr, intArrayList);
        return intArrayList.toArray();
    }

    private static void flatten5DL(int[][][][][] iArr, IntArrayList intArrayList) {
        for (int[][][][] iArr2 : iArr) {
            flatten4DL(iArr2, intArrayList);
        }
    }

    public static int max(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public static byte[] padLeft(byte[] bArr, int i) {
        int length = bArr.length + i;
        byte[] bArr2 = new byte[length];
        for (int i2 = i; i2 < length; i2++) {
            bArr2[i2] = bArr[i2 - i];
        }
        return bArr2;
    }

    public static void printMatrix(int[] iArr, String str, int i) {
        int length = iArr.length;
        String[] strArr = new String[length];
        int iMax = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            String str2 = String.format(str, Integer.valueOf(iArr[i2]));
            strArr[i2] = str2;
            iMax = Math.max(iMax, str2.length());
        }
        int i3 = 0;
        while (i3 < length) {
            StringBuilder sb = new StringBuilder();
            int i4 = 0;
            while (i4 < i && i3 < length) {
                for (int i5 = 0; i5 < (iMax - strArr[i3].length()) + 1; i5++) {
                    sb.append(MyUTIL.white_space);
                }
                sb.append(strArr[i3]);
                i4++;
                i3++;
            }
            System.out.println(sb);
        }
    }

    public static void printMatrixBytes(byte[] bArr, String str, int i) {
        int length = bArr.length;
        String[] strArr = new String[length];
        int iMax = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            String str2 = String.format(str, Byte.valueOf(bArr[i2]));
            strArr[i2] = str2;
            iMax = Math.max(iMax, str2.length());
        }
        int i3 = 0;
        while (i3 < length) {
            StringBuilder sb = new StringBuilder();
            int i4 = 0;
            while (i4 < i && i3 < length) {
                for (int i5 = 0; i5 < (iMax - strArr[i3].length()) + 1; i5++) {
                    sb.append(MyUTIL.white_space);
                }
                sb.append(strArr[i3]);
                i4++;
                i3++;
            }
            System.out.println(sb);
        }
    }

    public static void quickSort(int[] iArr, int i, int i2, int[] iArr2) {
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        int i4 = i + 1;
        if (i3 == 2) {
            if (iArr[i] > iArr[i4]) {
                swap(iArr, i, i4);
                if (iArr2 != null) {
                    swap(iArr2, i, i4);
                    return;
                }
                return;
            }
            return;
        }
        if (i3 == 3) {
            if (iArr[i] > iArr[i4]) {
                swap(iArr, i, i4);
                if (iArr2 != null) {
                    swap(iArr2, i, i4);
                }
            }
            int i5 = i + 2;
            if (iArr[i4] > iArr[i5]) {
                swap(iArr, i4, i5);
                if (iArr2 != null) {
                    swap(iArr2, i4, i5);
                }
            }
            if (iArr[i] > iArr[i4]) {
                swap(iArr, i, i4);
                if (iArr2 != null) {
                    swap(iArr2, i, i4);
                }
            }
        }
        int i6 = iArr[0];
        int i7 = i2 - 1;
        int i8 = i7;
        while (i7 >= i) {
            if (iArr[i7] > i6) {
                swap(iArr, i7, i8);
                if (iArr2 != null) {
                    swap(iArr2, i7, i8);
                }
                i8--;
            }
            i7--;
        }
        swap(iArr, i, i8);
        if (iArr2 != null) {
            swap(iArr2, i, i8);
        }
        quickSort(iArr, i, i8, iArr2);
        quickSort(iArr, i8 + 1, i2, iArr2);
    }

    public static byte[] randomByteArray(int i, byte b, byte b2) {
        byte b3 = (byte) (b2 - b);
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            double d = b3;
            bArr[i2] = (byte) (((Math.random() * d) % d) + b);
        }
        return bArr;
    }

    public static int[] randomIntArray(int i, int i2, int i3) {
        int i4 = i3 - i2;
        int[] iArr = new int[i];
        for (int i5 = 0; i5 < i; i5++) {
            double d = i4;
            iArr[i5] = ((int) ((Math.random() * d) % d)) + i2;
        }
        return iArr;
    }

    public static <T> void reverse(T[] tArr) {
        int length = tArr.length - 1;
        int i = 0;
        while (i < (tArr.length >> 1)) {
            T t = tArr[i];
            tArr[i] = tArr[length];
            tArr[length] = t;
            i++;
            length--;
        }
    }

    public static int[][] rotate(int[][] iArr) {
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iArr[0].length, iArr.length);
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[0].length; i2++) {
                iArr2[i2][i] = iArr[i][i2];
            }
        }
        return iArr2;
    }

    public static <T> void shiftLeft1(T[] tArr) {
        int i = 0;
        while (i < tArr.length - 1) {
            int i2 = i + 1;
            tArr[i] = tArr[i2];
            i = i2;
        }
        tArr[tArr.length - 1] = null;
    }

    public static <T> void shiftLeft2(T[] tArr, int i) {
        shiftLeft3(tArr, i, tArr.length);
    }

    public static <T> void shiftLeft3(T[] tArr, int i, int i2) {
        while (true) {
            int i3 = i2 - 1;
            if (i >= i3) {
                tArr[i3] = null;
                return;
            } else {
                int i4 = i + 1;
                tArr[i] = tArr[i4];
                i = i4;
            }
        }
    }

    public static <T> void shiftRight1(T[] tArr) {
        for (int i = 1; i < tArr.length; i++) {
            tArr[i] = tArr[i - 1];
        }
        tArr[0] = null;
    }

    public static <T> void shiftRight2(T[] tArr, int i) {
        shiftRight3(tArr, 0, i);
    }

    public static <T> void shiftRight3(T[] tArr, int i, int i2) {
        for (int i3 = i2 - 1; i3 > i; i3--) {
            tArr[i3] = tArr[i3 - 1];
        }
        tArr[i] = null;
    }

    public static final int sumByte(byte[] bArr) {
        int i = 0;
        for (byte b : bArr) {
            i += b;
        }
        return i;
    }

    public static int sumByte3(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 += bArr[i4];
        }
        return i3;
    }

    public static final int sumInt(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }

    public static int sumInt3(int[] iArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public static final void swap(int[] iArr, int i, int i2) {
        if (i == i2) {
            return;
        }
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static byte[] toByteArray(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return bArr;
    }

    public static byte[] toByteArrayShifted(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) (iArr[i] - 128);
        }
        return bArr;
    }

    public static byte[][] toByteArrayShifted2(int[][] iArr) {
        byte[][] bArr = new byte[iArr.length][];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = toByteArrayShifted(iArr[i]);
        }
        return bArr;
    }

    public static int[] toIntArray(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = bArr[i];
        }
        return iArr;
    }

    public static int[] toIntArrayUnshifted(byte[] bArr) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = (byte) (bArr[i] + BER.ASN_LONG_LEN);
        }
        return iArr;
    }

    public static int[] toUnsignedIntArray(byte[] bArr) {
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i] & ExifInterface.MARKER;
        }
        return iArr;
    }
}
