package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.io.VLC;

/* loaded from: classes2.dex */
public class SequenceScalableExtension implements MPEGHeader {
    public static final int DATA_PARTITIONING = 0;
    public static final int SNR_SCALABILITY = 2;
    public static final int SPATIAL_SCALABILITY = 1;
    public static final int Sequence_Scalable_Extension = 5;
    public static final int TEMPORAL_SCALABILITY = 3;
    public int horizontal_subsampling_factor_m;
    public int horizontal_subsampling_factor_n;
    public int layer_id;
    public int lower_layer_prediction_horizontal_size;
    public int lower_layer_prediction_vertical_size;
    public int mux_to_progressive_sequence;
    public int picture_mux_enable;
    public int picture_mux_factor;
    public int picture_mux_order;
    public int scalable_mode;
    public int vertical_subsampling_factor_m;
    public int vertical_subsampling_factor_n;

    public static MPEGConst.MBType[] mbTypeVal(int i, SequenceScalableExtension sequenceScalableExtension) {
        return (sequenceScalableExtension == null || sequenceScalableExtension.scalable_mode != 2) ? (sequenceScalableExtension == null || sequenceScalableExtension.scalable_mode != 1) ? i == 1 ? MPEGConst.mbTypeValI : i == 2 ? MPEGConst.mbTypeValP : MPEGConst.mbTypeValB : i == 1 ? MPEGConst.mbTypeValISpat : i == 2 ? MPEGConst.mbTypeValPSpat : MPEGConst.mbTypeValBSpat : MPEGConst.mbTypeValSNR;
    }

    public static SequenceScalableExtension read(BitReader bitReader) {
        SequenceScalableExtension sequenceScalableExtension = new SequenceScalableExtension();
        sequenceScalableExtension.scalable_mode = bitReader.readNBit(2);
        sequenceScalableExtension.layer_id = bitReader.readNBit(4);
        if (sequenceScalableExtension.scalable_mode == 1) {
            sequenceScalableExtension.lower_layer_prediction_horizontal_size = bitReader.readNBit(14);
            bitReader.read1Bit();
            sequenceScalableExtension.lower_layer_prediction_vertical_size = bitReader.readNBit(14);
            sequenceScalableExtension.horizontal_subsampling_factor_m = bitReader.readNBit(5);
            sequenceScalableExtension.horizontal_subsampling_factor_n = bitReader.readNBit(5);
            sequenceScalableExtension.vertical_subsampling_factor_m = bitReader.readNBit(5);
            sequenceScalableExtension.vertical_subsampling_factor_n = bitReader.readNBit(5);
        }
        if (sequenceScalableExtension.scalable_mode == 3) {
            int i = bitReader.read1Bit();
            sequenceScalableExtension.picture_mux_enable = i;
            if (i != 0) {
                sequenceScalableExtension.mux_to_progressive_sequence = bitReader.read1Bit();
            }
            sequenceScalableExtension.picture_mux_order = bitReader.readNBit(3);
            sequenceScalableExtension.picture_mux_factor = bitReader.readNBit(3);
        }
        return sequenceScalableExtension;
    }

    public static VLC vlcMBType(int i, SequenceScalableExtension sequenceScalableExtension) {
        return (sequenceScalableExtension == null || sequenceScalableExtension.scalable_mode != 2) ? (sequenceScalableExtension == null || sequenceScalableExtension.scalable_mode != 1) ? i == 1 ? MPEGConst.vlcMBTypeI : i == 2 ? MPEGConst.vlcMBTypeP : MPEGConst.vlcMBTypeB : i == 1 ? MPEGConst.vlcMBTypeISpat : i == 2 ? MPEGConst.vlcMBTypePSpat : MPEGConst.vlcMBTypeBSpat : MPEGConst.vlcMBTypeSNR;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        bitWriter.writeNBit(5, 4);
        bitWriter.writeNBit(this.scalable_mode, 2);
        bitWriter.writeNBit(this.layer_id, 4);
        if (this.scalable_mode == 1) {
            bitWriter.writeNBit(this.lower_layer_prediction_horizontal_size, 14);
            bitWriter.write1Bit(1);
            bitWriter.writeNBit(this.lower_layer_prediction_vertical_size, 14);
            bitWriter.writeNBit(this.horizontal_subsampling_factor_m, 5);
            bitWriter.writeNBit(this.horizontal_subsampling_factor_n, 5);
            bitWriter.writeNBit(this.vertical_subsampling_factor_m, 5);
            bitWriter.writeNBit(this.vertical_subsampling_factor_n, 5);
        }
        if (this.scalable_mode == 3) {
            bitWriter.write1Bit(this.picture_mux_enable);
            if (this.picture_mux_enable != 0) {
                bitWriter.write1Bit(this.mux_to_progressive_sequence);
            }
            bitWriter.writeNBit(this.picture_mux_order, 3);
            bitWriter.writeNBit(this.picture_mux_factor, 3);
        }
        bitWriter.flush();
    }
}
