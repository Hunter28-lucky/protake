package com.blink.academy.film.support.stream.ts.google.API;

/* loaded from: classes.dex */
public class MyUTIL {
    public static final String white_space = " ";

    public static String toBinaryString(byte b) {
        String str = new String();
        for (int i = 7; i >= 0; i--) {
            str = ((b >> i) & 1) != 0 ? str + "1" : str + "0";
        }
        return str;
    }

    public static String whiteSpaceStr(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        String str = new String();
        for (int i2 = 0; i2 < i; i2++) {
            str = str + white_space;
        }
        return str;
    }

    public static String toBinaryString(byte[] bArr) {
        bArr.getClass();
        String str = new String();
        int i = 0;
        while (i < bArr.length) {
            str = str + toBinaryString(bArr[i]);
            i++;
            if (i < bArr.length) {
                str = str + "_";
            }
        }
        return str;
    }

    public static String toBinaryString(byte[] bArr, int i) {
        bArr.getClass();
        String str = new String();
        int i2 = 0;
        while (i2 < bArr.length) {
            str = str + toBinaryString(bArr[i2]);
            i2++;
            if (i2 < bArr.length) {
                str = str + "_";
            }
            if (i2 % i == 0) {
                str = str + "\n";
            }
        }
        return str;
    }

    public static String toBinaryString(int i) {
        String str = new String();
        for (int i2 = 31; i2 >= 0; i2--) {
            str = ((i >> i2) & 1) != 0 ? str + "1" : str + "0";
        }
        return str;
    }

    public static String toBinaryString(long j) {
        String str = new String();
        for (int i = 63; i >= 0; i--) {
            str = ((j >> i) & 1) != 0 ? str + "1" : str + "0";
        }
        return str;
    }

    public static String toBinaryString(short s) {
        String str = new String();
        for (int i = 15; i >= 0; i--) {
            str = ((s >> i) & 1) != 0 ? str + "1" : str + "0";
        }
        return str;
    }
}
