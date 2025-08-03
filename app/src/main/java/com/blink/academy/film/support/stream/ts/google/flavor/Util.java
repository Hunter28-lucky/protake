package com.blink.academy.film.support.stream.ts.google.flavor;

import java.util.Locale;

/* loaded from: classes.dex */
public class Util {
    public static boolean trace_print_header = true;

    public static void flerror(String str) {
        System.out.println(str);
    }

    public static void trace(int i, int i2, int i3, String str) {
        int[] iArr = {0, 0, 0, 0};
        Locale locale = Locale.ENGLISH;
        if (trace_print_header) {
            System.out.println("   At Bit  Size    Value    Description");
            trace_print_header = false;
        }
        if (i2 > 0) {
            System.out.print(new PrintfFormat(locale, "%9d").sprintf(i));
            System.out.print(new PrintfFormat(locale, ": %4d ").sprintf(i2));
        } else {
            System.out.print(new PrintfFormat(locale, "%9d:      ").sprintf(i));
        }
        iArr[3] = (i3 >> 24) & 255;
        iArr[2] = (i3 >> 16) & 255;
        iArr[1] = (i3 >> 8) & 255;
        iArr[0] = i3 & 255;
        int i4 = i2 != 0 ? ((i2 - 1) / 8) + 1 : 0;
        for (int i5 = 4; i5 > i4; i5--) {
            System.out.print("   ");
        }
        for (int i6 = i4 - 1; i6 >= 0; i6--) {
            System.out.print(new PrintfFormat(locale, "%.2X ").sprintf(iArr[i6]));
        }
        System.out.println(str);
    }

    public static void trace(int i, int i2, long j, String str) {
        long[] jArr = {0, 0, 0, 0, 0, 0, 0, 0};
        Locale locale = Locale.ENGLISH;
        if (trace_print_header) {
            System.out.println("   At Bit  Size    Value    Description");
            trace_print_header = false;
        }
        if (i2 > 0) {
            System.out.print(new PrintfFormat(locale, "%9d").sprintf(i));
            System.out.print(new PrintfFormat(locale, ": %4d ").sprintf(i2));
        } else {
            System.out.print(new PrintfFormat(locale, "%9d:      ").sprintf(i));
        }
        jArr[7] = (j >> 56) & 255;
        jArr[6] = (j >> 48) & 255;
        jArr[5] = (j >> 40) & 255;
        jArr[4] = (j >> 32) & 255;
        jArr[3] = (j >> 24) & 255;
        jArr[2] = (j >> 16) & 255;
        jArr[1] = (j >> 8) & 255;
        jArr[0] = j & 255;
        int i3 = i2 != 0 ? ((i2 - 1) / 8) + 1 : 0;
        for (int i4 = 4; i4 > i3; i4--) {
            System.out.print("   ");
        }
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            System.out.print(new PrintfFormat(locale, "%.2X ").sprintf(jArr[i5]));
        }
        System.out.println(str);
    }

    public static void trace(int i, int i2, double d, String str) {
        Locale locale = Locale.ENGLISH;
        if (trace_print_header) {
            System.out.println("   At Bit  Size    Value    Description");
            trace_print_header = false;
        }
        if (i2 > 0) {
            System.out.print(new PrintfFormat(locale, "%9d").sprintf(i));
            System.out.print(new PrintfFormat(locale, ": %4d").sprintf(i2));
            System.out.print(new PrintfFormat(locale, " %11g ").sprintf(d));
        } else {
            System.out.print(new PrintfFormat(locale, "%9d:      ").sprintf(i));
        }
        System.out.println(str);
    }
}
