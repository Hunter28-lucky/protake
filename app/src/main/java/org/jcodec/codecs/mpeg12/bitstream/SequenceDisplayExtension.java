package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class SequenceDisplayExtension implements MPEGHeader {
    public static final int Sequence_Display_Extension = 2;
    public ColorDescription colorDescription;
    public int display_horizontal_size;
    public int display_vertical_size;
    public int video_format;

    public static class ColorDescription {
        public int colour_primaries;
        public int matrix_coefficients;
        public int transfer_characteristics;

        public static ColorDescription read(BitReader bitReader) {
            ColorDescription colorDescription = new ColorDescription();
            colorDescription.colour_primaries = bitReader.readNBit(8);
            colorDescription.transfer_characteristics = bitReader.readNBit(8);
            colorDescription.matrix_coefficients = bitReader.readNBit(8);
            return colorDescription;
        }

        public void write(BitWriter bitWriter) {
            bitWriter.writeNBit(this.colour_primaries, 8);
            bitWriter.writeNBit(this.transfer_characteristics, 8);
            bitWriter.writeNBit(this.matrix_coefficients, 8);
        }
    }

    public static SequenceDisplayExtension read(BitReader bitReader) {
        SequenceDisplayExtension sequenceDisplayExtension = new SequenceDisplayExtension();
        sequenceDisplayExtension.video_format = bitReader.readNBit(3);
        if (bitReader.read1Bit() == 1) {
            sequenceDisplayExtension.colorDescription = ColorDescription.read(bitReader);
        }
        sequenceDisplayExtension.display_horizontal_size = bitReader.readNBit(14);
        bitReader.read1Bit();
        sequenceDisplayExtension.display_vertical_size = bitReader.readNBit(14);
        return sequenceDisplayExtension;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(2, 4);
        bitWriter.writeNBit(this.video_format, 3);
        bitWriter.write1Bit(this.colorDescription != null ? 1 : 0);
        ColorDescription colorDescription = this.colorDescription;
        if (colorDescription != null) {
            colorDescription.write(bitWriter);
        }
        bitWriter.writeNBit(this.display_horizontal_size, 14);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(this.display_vertical_size, 14);
        bitWriter.flush();
    }
}
