package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class SequenceExtension implements MPEGHeader {
    public static final int Chroma420 = 1;
    public static final int Chroma422 = 2;
    public static final int Chroma444 = 3;
    public static final int Sequence_Extension = 1;
    public int bit_rate_extension;
    public int chroma_format;
    public int frame_rate_extension_d;
    public int frame_rate_extension_n;
    public int horizontal_size_extension;
    public int low_delay;
    public int profile_and_level;
    public int progressive_sequence;
    public int vbv_buffer_size_extension;
    public int vertical_size_extension;

    private SequenceExtension() {
    }

    public static SequenceExtension createSequenceExtension(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        SequenceExtension sequenceExtension = new SequenceExtension();
        sequenceExtension.profile_and_level = i;
        sequenceExtension.progressive_sequence = i2;
        sequenceExtension.chroma_format = i3;
        sequenceExtension.horizontal_size_extension = i4;
        sequenceExtension.vertical_size_extension = i5;
        sequenceExtension.bit_rate_extension = i6;
        sequenceExtension.vbv_buffer_size_extension = i7;
        sequenceExtension.low_delay = i8;
        sequenceExtension.frame_rate_extension_n = i9;
        sequenceExtension.frame_rate_extension_d = i10;
        return sequenceExtension;
    }

    public static SequenceExtension read(BitReader bitReader) {
        SequenceExtension sequenceExtension = new SequenceExtension();
        sequenceExtension.profile_and_level = bitReader.readNBit(8);
        sequenceExtension.progressive_sequence = bitReader.read1Bit();
        sequenceExtension.chroma_format = bitReader.readNBit(2);
        sequenceExtension.horizontal_size_extension = bitReader.readNBit(2);
        sequenceExtension.vertical_size_extension = bitReader.readNBit(2);
        sequenceExtension.bit_rate_extension = bitReader.readNBit(12);
        sequenceExtension.vbv_buffer_size_extension = bitReader.readNBit(8);
        sequenceExtension.low_delay = bitReader.read1Bit();
        sequenceExtension.frame_rate_extension_n = bitReader.readNBit(2);
        sequenceExtension.frame_rate_extension_d = bitReader.readNBit(5);
        return sequenceExtension;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(1, 4);
        bitWriter.writeNBit(this.profile_and_level, 8);
        bitWriter.write1Bit(this.progressive_sequence);
        bitWriter.writeNBit(this.chroma_format, 2);
        bitWriter.writeNBit(this.horizontal_size_extension, 2);
        bitWriter.writeNBit(this.vertical_size_extension, 2);
        bitWriter.writeNBit(this.bit_rate_extension, 12);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.vbv_buffer_size_extension, 8);
        bitWriter.write1Bit(this.low_delay);
        bitWriter.writeNBit(this.frame_rate_extension_n, 2);
        bitWriter.writeNBit(this.frame_rate_extension_d, 5);
        bitWriter.flush();
    }
}
