package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class QuantMatrixExtension implements MPEGHeader {
    public static final int Quant_Matrix_Extension = 3;
    public int[] chroma_intra_quantiser_matrix;
    public int[] chroma_non_intra_quantiser_matrix;
    public int[] intra_quantiser_matrix;
    public int[] non_intra_quantiser_matrix;

    public static QuantMatrixExtension read(BitReader bitReader) {
        QuantMatrixExtension quantMatrixExtension = new QuantMatrixExtension();
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.intra_quantiser_matrix = readQMat(bitReader);
        }
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.non_intra_quantiser_matrix = readQMat(bitReader);
        }
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.chroma_intra_quantiser_matrix = readQMat(bitReader);
        }
        if (bitReader.read1Bit() != 0) {
            quantMatrixExtension.chroma_non_intra_quantiser_matrix = readQMat(bitReader);
        }
        return quantMatrixExtension;
    }

    private static int[] readQMat(BitReader bitReader) {
        int[] iArr = new int[64];
        for (int i = 0; i < 64; i++) {
            iArr[i] = bitReader.readNBit(8);
        }
        return iArr;
    }

    private void writeQMat(int[] iArr, BitWriter bitWriter) {
        for (int i = 0; i < 64; i++) {
            bitWriter.writeNBit(iArr[i], 8);
        }
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(3, 4);
        bitWriter.write1Bit(this.intra_quantiser_matrix != null ? 1 : 0);
        int[] iArr = this.intra_quantiser_matrix;
        if (iArr != null) {
            writeQMat(iArr, bitWriter);
        }
        bitWriter.write1Bit(this.non_intra_quantiser_matrix != null ? 1 : 0);
        int[] iArr2 = this.non_intra_quantiser_matrix;
        if (iArr2 != null) {
            writeQMat(iArr2, bitWriter);
        }
        bitWriter.write1Bit(this.chroma_intra_quantiser_matrix != null ? 1 : 0);
        int[] iArr3 = this.chroma_intra_quantiser_matrix;
        if (iArr3 != null) {
            writeQMat(iArr3, bitWriter);
        }
        bitWriter.write1Bit(this.chroma_non_intra_quantiser_matrix == null ? 0 : 1);
        int[] iArr4 = this.chroma_non_intra_quantiser_matrix;
        if (iArr4 != null) {
            writeQMat(iArr4, bitWriter);
        }
        bitWriter.flush();
    }
}
