package org.jcodec.codecs.h264.decode;

import org.jcodec.codecs.h264.H264Utils2;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.tools.Debug;

/* loaded from: classes2.dex */
public class CAVLCReader {
    private CAVLCReader() {
    }

    public static boolean moreRBSPData(BitReader bitReader) {
        return (bitReader.remaining() < 32 && bitReader.checkNBit(1) == 1 && (bitReader.checkNBit(24) << 9) == 0) ? false : true;
    }

    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public static boolean readBool(BitReader bitReader, String str) {
        ?? r3 = bitReader.read1Bit() == 0 ? 0 : 1;
        Debug.trace(str, Integer.valueOf((int) r3));
        return r3;
    }

    public static int readME(BitReader bitReader, String str) {
        return readUEtrace(bitReader, str);
    }

    public static int readNBit(BitReader bitReader, int i, String str) {
        int nBit = bitReader.readNBit(i);
        Debug.trace(str, Integer.valueOf(nBit));
        return nBit;
    }

    public static int readSE(BitReader bitReader, String str) {
        int iGolomb2Signed = H264Utils2.golomb2Signed(readUE(bitReader));
        Debug.trace(str, Integer.valueOf(iGolomb2Signed));
        return iGolomb2Signed;
    }

    public static int readTE(BitReader bitReader, int i) {
        return i > 1 ? readUE(bitReader) : (~bitReader.read1Bit()) & 1;
    }

    public static int readU(BitReader bitReader, int i, String str) {
        return readNBit(bitReader, i, str);
    }

    public static int readUE(BitReader bitReader) {
        int i = 0;
        while (bitReader.read1Bit() == 0 && i < 32) {
            i++;
        }
        if (i <= 0) {
            return 0;
        }
        return (int) (((1 << i) - 1) + bitReader.readNBit(i));
    }

    public static int readUEtrace(BitReader bitReader, String str) {
        int ue = readUE(bitReader);
        Debug.trace(str, Integer.valueOf(ue));
        return ue;
    }

    public static int readZeroBitCount(BitReader bitReader, String str) {
        int i = 0;
        while (bitReader.read1Bit() == 0 && i < 32) {
            i++;
        }
        if (Debug.debug) {
            Debug.trace(str, String.valueOf(i));
        }
        return i;
    }
}
