package org.jcodec.common.dct;

import org.jcodec.api.NotSupportedException;

/* loaded from: classes2.dex */
public abstract class DCT {
    public abstract int[] decode(int[] iArr);

    public void decodeAll(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = decode(iArr[i]);
        }
    }

    public short[] encode(byte[] bArr) {
        throw new NotSupportedException("");
    }
}
