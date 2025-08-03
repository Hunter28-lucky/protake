package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class IndexEntries {
    private byte[] displayOff;
    private long[] fileOff;
    private byte[] flags;
    private byte[] keyFrameOff;

    public IndexEntries(byte[] bArr, byte[] bArr2, byte[] bArr3, long[] jArr) {
        this.displayOff = bArr;
        this.keyFrameOff = bArr2;
        this.flags = bArr3;
        this.fileOff = jArr;
    }

    public static IndexEntries read(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        int i = byteBuffer.getInt();
        int i2 = byteBuffer.getInt();
        int[] iArr = new int[i];
        byte[] bArr = new byte[i];
        long[] jArr = new long[i];
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            iArr[i3] = byteBuffer.get() + i3;
            bArr2[i3] = byteBuffer.get();
            bArr[i3] = byteBuffer.get();
            jArr[i3] = byteBuffer.getLong();
            NIOUtils.skip(byteBuffer, i2 - 11);
        }
        byte[] bArr3 = new byte[i];
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = 0;
            while (true) {
                if (i5 >= i) {
                    break;
                }
                if (iArr[i5] == i4) {
                    bArr3[i4] = (byte) (i5 - i4);
                    break;
                }
                i5++;
            }
        }
        return new IndexEntries(bArr3, bArr2, bArr, jArr);
    }

    public byte[] getDisplayOff() {
        return this.displayOff;
    }

    public long[] getFileOff() {
        return this.fileOff;
    }

    public byte[] getFlags() {
        return this.flags;
    }

    public byte[] getKeyFrameOff() {
        return this.keyFrameOff;
    }
}
