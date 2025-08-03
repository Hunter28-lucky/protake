package org.jcodec.common;

/* loaded from: classes2.dex */
public class Ints {
    public static int checkedCast(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new IllegalArgumentException("Out of range: " + j);
    }
}
