package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class PictureHeader implements MPEGHeader {
    private boolean _hasExtensions;
    public int backward_f_code;
    public CopyrightExtension copyrightExtension;
    public int forward_f_code;
    public int full_pel_backward_vector;
    public int full_pel_forward_vector;
    public PictureCodingExtension pictureCodingExtension;
    public PictureDisplayExtension pictureDisplayExtension;
    public PictureSpatialScalableExtension pictureSpatialScalableExtension;
    public PictureTemporalScalableExtension pictureTemporalScalableExtension;
    public int picture_coding_type;
    public QuantMatrixExtension quantMatrixExtension;
    public int temporal_reference;
    public int vbv_delay;

    private PictureHeader() {
    }

    public static PictureHeader createPictureHeader(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        PictureHeader pictureHeader = new PictureHeader();
        pictureHeader.temporal_reference = i;
        pictureHeader.picture_coding_type = i2;
        pictureHeader.vbv_delay = i3;
        pictureHeader.full_pel_forward_vector = i4;
        pictureHeader.forward_f_code = i5;
        pictureHeader.full_pel_backward_vector = i6;
        pictureHeader.backward_f_code = i7;
        return pictureHeader;
    }

    public static PictureHeader read(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        PictureHeader pictureHeader = new PictureHeader();
        pictureHeader.temporal_reference = bitReaderCreateBitReader.readNBit(10);
        pictureHeader.picture_coding_type = bitReaderCreateBitReader.readNBit(3);
        pictureHeader.vbv_delay = bitReaderCreateBitReader.readNBit(16);
        int i = pictureHeader.picture_coding_type;
        if (i == 2 || i == 3) {
            pictureHeader.full_pel_forward_vector = bitReaderCreateBitReader.read1Bit();
            pictureHeader.forward_f_code = bitReaderCreateBitReader.readNBit(3);
        }
        if (pictureHeader.picture_coding_type == 3) {
            pictureHeader.full_pel_backward_vector = bitReaderCreateBitReader.read1Bit();
            pictureHeader.backward_f_code = bitReaderCreateBitReader.readNBit(3);
        }
        while (bitReaderCreateBitReader.read1Bit() == 1) {
            bitReaderCreateBitReader.readNBit(8);
        }
        return pictureHeader;
    }

    public static void readExtension(ByteBuffer byteBuffer, PictureHeader pictureHeader, SequenceHeader sequenceHeader) {
        pictureHeader._hasExtensions = true;
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        int nBit = bitReaderCreateBitReader.readNBit(4);
        if (nBit == 3) {
            pictureHeader.quantMatrixExtension = QuantMatrixExtension.read(bitReaderCreateBitReader);
            return;
        }
        if (nBit == 4) {
            pictureHeader.copyrightExtension = CopyrightExtension.read(bitReaderCreateBitReader);
            return;
        }
        if (nBit == 7) {
            pictureHeader.pictureDisplayExtension = PictureDisplayExtension.read(bitReaderCreateBitReader, sequenceHeader.sequenceExtension, pictureHeader.pictureCodingExtension);
            return;
        }
        if (nBit == 8) {
            pictureHeader.pictureCodingExtension = PictureCodingExtension.read(bitReaderCreateBitReader);
            return;
        }
        if (nBit == 9) {
            pictureHeader.pictureSpatialScalableExtension = PictureSpatialScalableExtension.read(bitReaderCreateBitReader);
        } else {
            if (nBit == 16) {
                pictureHeader.pictureTemporalScalableExtension = PictureTemporalScalableExtension.read(bitReaderCreateBitReader);
                return;
            }
            throw new RuntimeException("Unsupported extension: " + nBit);
        }
    }

    private void writeExtensions(ByteBuffer byteBuffer) {
        if (this.quantMatrixExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.quantMatrixExtension.write(byteBuffer);
        }
        if (this.copyrightExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.copyrightExtension.write(byteBuffer);
        }
        if (this.pictureCodingExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureCodingExtension.write(byteBuffer);
        }
        if (this.pictureDisplayExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureDisplayExtension.write(byteBuffer);
        }
        if (this.pictureSpatialScalableExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureSpatialScalableExtension.write(byteBuffer);
        }
        if (this.pictureTemporalScalableExtension != null) {
            byteBuffer.putInt(MPEGConst.EXTENSION_START_CODE);
            this.pictureTemporalScalableExtension.write(byteBuffer);
        }
    }

    public boolean hasExtensions() {
        return this._hasExtensions;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(this.temporal_reference, 10);
        bitWriter.writeNBit(this.picture_coding_type, 3);
        bitWriter.writeNBit(this.vbv_delay, 16);
        int i = this.picture_coding_type;
        if (i == 2 || i == 3) {
            bitWriter.write1Bit(this.full_pel_forward_vector);
            bitWriter.write1Bit(this.forward_f_code);
        }
        if (this.picture_coding_type == 3) {
            bitWriter.write1Bit(this.full_pel_backward_vector);
            bitWriter.writeNBit(this.backward_f_code, 3);
        }
        bitWriter.write1Bit(0);
        bitWriter.flush();
        writeExtensions(byteBuffer);
    }
}
