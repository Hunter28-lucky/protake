package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class SequenceHeader implements MPEGHeader {
    private static boolean _hasExtensions;
    public int aspect_ratio_information;
    public int bit_rate;
    public int constrained_parameters_flag;
    public int frame_rate_code;
    public int horizontal_size;
    public int[] intra_quantiser_matrix;
    public int[] non_intra_quantiser_matrix;
    public SequenceDisplayExtension sequenceDisplayExtension;
    public SequenceExtension sequenceExtension;
    public SequenceScalableExtension sequenceScalableExtension;
    public int vbv_buffer_size_value;
    public int vertical_size;

    private SequenceHeader() {
    }

    public static SequenceHeader createSequenceHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        SequenceHeader sequenceHeader = new SequenceHeader();
        sequenceHeader.horizontal_size = i;
        sequenceHeader.vertical_size = i2;
        sequenceHeader.aspect_ratio_information = i3;
        sequenceHeader.frame_rate_code = i4;
        sequenceHeader.bit_rate = i5;
        sequenceHeader.vbv_buffer_size_value = i6;
        sequenceHeader.constrained_parameters_flag = i7;
        sequenceHeader.intra_quantiser_matrix = iArr;
        sequenceHeader.non_intra_quantiser_matrix = iArr2;
        return sequenceHeader;
    }

    public static SequenceHeader read(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        SequenceHeader sequenceHeader = new SequenceHeader();
        sequenceHeader.horizontal_size = bitReaderCreateBitReader.readNBit(12);
        sequenceHeader.vertical_size = bitReaderCreateBitReader.readNBit(12);
        sequenceHeader.aspect_ratio_information = bitReaderCreateBitReader.readNBit(4);
        sequenceHeader.frame_rate_code = bitReaderCreateBitReader.readNBit(4);
        sequenceHeader.bit_rate = bitReaderCreateBitReader.readNBit(18);
        bitReaderCreateBitReader.read1Bit();
        sequenceHeader.vbv_buffer_size_value = bitReaderCreateBitReader.readNBit(10);
        sequenceHeader.constrained_parameters_flag = bitReaderCreateBitReader.read1Bit();
        if (bitReaderCreateBitReader.read1Bit() != 0) {
            sequenceHeader.intra_quantiser_matrix = new int[64];
            for (int i = 0; i < 64; i++) {
                sequenceHeader.intra_quantiser_matrix[i] = bitReaderCreateBitReader.readNBit(8);
            }
        }
        if (bitReaderCreateBitReader.read1Bit() != 0) {
            sequenceHeader.non_intra_quantiser_matrix = new int[64];
            for (int i2 = 0; i2 < 64; i2++) {
                sequenceHeader.non_intra_quantiser_matrix[i2] = bitReaderCreateBitReader.readNBit(8);
            }
        }
        return sequenceHeader;
    }

    public static void readExtension(ByteBuffer byteBuffer, SequenceHeader sequenceHeader) {
        _hasExtensions = true;
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        int nBit = bitReaderCreateBitReader.readNBit(4);
        if (nBit == 1) {
            sequenceHeader.sequenceExtension = SequenceExtension.read(bitReaderCreateBitReader);
            return;
        }
        if (nBit == 2) {
            sequenceHeader.sequenceDisplayExtension = SequenceDisplayExtension.read(bitReaderCreateBitReader);
        } else {
            if (nBit == 5) {
                sequenceHeader.sequenceScalableExtension = SequenceScalableExtension.read(bitReaderCreateBitReader);
                return;
            }
            throw new RuntimeException("Unsupported extension: " + nBit);
        }
    }

    private void writeExtensions(ByteBuffer byteBuffer) {
        if (this.sequenceExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.sequenceExtension.write(byteBuffer);
        }
        if (this.sequenceScalableExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.sequenceScalableExtension.write(byteBuffer);
        }
        if (this.sequenceDisplayExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.sequenceDisplayExtension.write(byteBuffer);
        }
    }

    public void copyExtensions(SequenceHeader sequenceHeader) {
        this.sequenceExtension = sequenceHeader.sequenceExtension;
        this.sequenceScalableExtension = sequenceHeader.sequenceScalableExtension;
        this.sequenceDisplayExtension = sequenceHeader.sequenceDisplayExtension;
    }

    public boolean hasExtensions() {
        return _hasExtensions;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(this.horizontal_size, 12);
        bitWriter.writeNBit(this.vertical_size, 12);
        bitWriter.writeNBit(this.aspect_ratio_information, 4);
        bitWriter.writeNBit(this.frame_rate_code, 4);
        bitWriter.writeNBit(this.bit_rate, 18);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.vbv_buffer_size_value, 10);
        bitWriter.write1Bit(this.constrained_parameters_flag);
        bitWriter.write1Bit(this.intra_quantiser_matrix != null ? 1 : 0);
        if (this.intra_quantiser_matrix != null) {
            for (int i = 0; i < 64; i++) {
                bitWriter.writeNBit(this.intra_quantiser_matrix[i], 8);
            }
        }
        bitWriter.write1Bit(this.non_intra_quantiser_matrix == null ? 0 : 1);
        if (this.non_intra_quantiser_matrix != null) {
            for (int i2 = 0; i2 < 64; i2++) {
                bitWriter.writeNBit(this.non_intra_quantiser_matrix[i2], 8);
            }
        }
        bitWriter.flush();
        writeExtensions(byteBuffer);
    }
}
