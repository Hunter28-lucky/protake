package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.Point;

/* loaded from: classes2.dex */
public class PictureDisplayExtension implements MPEGHeader {
    public static final int Picture_Display_Extension = 7;
    public Point[] frame_centre_offsets;

    private static int numberOfFrameCentreOffsets(SequenceExtension sequenceExtension, PictureCodingExtension pictureCodingExtension) {
        if (sequenceExtension == null || pictureCodingExtension == null) {
            throw new IllegalArgumentException("PictureDisplayExtension requires SequenceExtension and PictureCodingExtension to be present");
        }
        if (sequenceExtension.progressive_sequence == 1) {
            if (pictureCodingExtension.repeat_first_field == 1) {
                return pictureCodingExtension.top_field_first == 1 ? 3 : 2;
            }
            return 1;
        }
        if (pictureCodingExtension.picture_structure != 3) {
            return 1;
        }
        return pictureCodingExtension.repeat_first_field == 1 ? 3 : 2;
    }

    public static PictureDisplayExtension read(BitReader bitReader, SequenceExtension sequenceExtension, PictureCodingExtension pictureCodingExtension) {
        PictureDisplayExtension pictureDisplayExtension = new PictureDisplayExtension();
        pictureDisplayExtension.frame_centre_offsets = new Point[numberOfFrameCentreOffsets(sequenceExtension, pictureCodingExtension)];
        for (int i = 0; i < pictureDisplayExtension.frame_centre_offsets.length; i++) {
            int nBit = bitReader.readNBit(16);
            bitReader.read1Bit();
            int nBit2 = bitReader.readNBit(16);
            bitReader.read1Bit();
            pictureDisplayExtension.frame_centre_offsets[i] = new Point(nBit, nBit2);
        }
        return pictureDisplayExtension;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(7, 4);
        int i = 0;
        while (true) {
            Point[] pointArr = this.frame_centre_offsets;
            if (i >= pointArr.length) {
                bitWriter.flush();
                return;
            }
            Point point = pointArr[i];
            bitWriter.writeNBit(point.getX(), 16);
            bitWriter.writeNBit(point.getY(), 16);
            i++;
        }
    }
}
