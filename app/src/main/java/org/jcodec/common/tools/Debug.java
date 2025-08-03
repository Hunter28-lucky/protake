package org.jcodec.common.tools;

import java.nio.ShortBuffer;
import org.jcodec.common.ArrayUtil;

/* loaded from: classes2.dex */
public class Debug {
    public static boolean debug = false;

    public static void print(String str) {
        if (debug) {
            System.out.print(str);
        }
    }

    public static final void print8x8i(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Integer.valueOf(iArr[i]));
                i++;
            }
            System.out.println();
        }
    }

    public static final void print8x8s(short[] sArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Short.valueOf(sArr[i]));
                i++;
            }
            System.out.println();
        }
    }

    public static final void print8x8sb(ShortBuffer shortBuffer) {
        for (int i = 0; i < 8; i++) {
            for (int i2 = 0; i2 < 8; i2++) {
                System.out.printf("%3d, ", Short.valueOf(shortBuffer.get()));
            }
            System.out.println();
        }
    }

    public static void printInt(int i) {
        if (debug) {
            System.out.print(i);
        }
    }

    public static void println(String str) {
        if (debug) {
            System.out.println(str);
        }
    }

    public static void prints(short[] sArr) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            for (int i3 = 0; i3 < 8; i3++) {
                System.out.printf("%3d, ", Short.valueOf(sArr[i]));
                i++;
            }
            System.out.println();
        }
    }

    public static void trace(Object... objArr) {
        if (!debug || objArr.length <= 0) {
            return;
        }
        String str = (String) objArr[0];
        ArrayUtil.shiftLeft1(objArr);
        System.out.printf(str + ": %d\n", objArr);
    }
}
