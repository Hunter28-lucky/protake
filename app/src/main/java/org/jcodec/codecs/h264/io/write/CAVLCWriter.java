package org.jcodec.codecs.h264.io.write;

import org.jcodec.api.NotImplementedException;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.tools.Debug;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class CAVLCWriter {
    private CAVLCWriter() {
    }

    public static void writeBool(BitWriter bitWriter, boolean z, String str) {
        bitWriter.write1Bit(z ? 1 : 0);
        Debug.trace(str, Integer.valueOf(z ? 1 : 0));
    }

    public static void writeNBit(BitWriter bitWriter, long j, int i, String str) {
        for (int i2 = 0; i2 < i; i2++) {
            bitWriter.write1Bit(1 & ((int) (j >> ((i - i2) - 1))));
        }
        Debug.trace(str, Long.valueOf(j));
    }

    public static void writeSE(BitWriter bitWriter, int i) {
        writeUE(bitWriter, MathUtil.golomb(i));
    }

    public static void writeSEtrace(BitWriter bitWriter, int i, String str) {
        writeUE(bitWriter, MathUtil.golomb(i));
        Debug.trace(str, Integer.valueOf(i));
    }

    public static void writeSliceTrailingBits() {
        throw new NotImplementedException("todo");
    }

    public static void writeTE(BitWriter bitWriter, int i, int i2) {
        if (i2 > 1) {
            writeUE(bitWriter, i);
        } else {
            bitWriter.write1Bit((~i) & 1);
        }
    }

    public static void writeTrailingBits(BitWriter bitWriter) {
        bitWriter.write1Bit(1);
        bitWriter.flush();
    }

    public static void writeU(BitWriter bitWriter, int i, int i2) {
        bitWriter.writeNBit(i, i2);
    }

    public static void writeUE(BitWriter bitWriter, int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= 15) {
                i2 = 0;
                break;
            }
            int i4 = (1 << i2) + i3;
            if (i < i4) {
                break;
            }
            i2++;
            i3 = i4;
        }
        bitWriter.writeNBit(0, i2);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(i - i3, i2);
    }

    public static void writeUEtrace(BitWriter bitWriter, int i, String str) {
        writeUE(bitWriter, i);
        Debug.trace(str, Integer.valueOf(i));
    }

    public static void writeUtrace(BitWriter bitWriter, int i, int i2, String str) {
        bitWriter.writeNBit(i, i2);
        Debug.trace(str, Integer.valueOf(i));
    }
}
