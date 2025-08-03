package org.jcodec.codecs.h264.io.model;

import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.decode.CAVLCReader;
import org.jcodec.codecs.h264.io.write.CAVLCWriter;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class SeqParameterSetExt {
    public boolean additional_extension_flag;
    public boolean alpha_incr_flag;
    public int alpha_opaque_value;
    public int alpha_transparent_value;
    public int aux_format_idc;
    public int bit_depth_aux_minus8;
    public int seq_parameter_set_id;

    public static SeqParameterSetExt read(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        SeqParameterSetExt seqParameterSetExt = new SeqParameterSetExt();
        seqParameterSetExt.seq_parameter_set_id = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPSE: seq_parameter_set_id");
        int uEtrace = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPSE: aux_format_idc");
        seqParameterSetExt.aux_format_idc = uEtrace;
        if (uEtrace != 0) {
            seqParameterSetExt.bit_depth_aux_minus8 = CAVLCReader.readUEtrace(bitReaderCreateBitReader, "SPSE: bit_depth_aux_minus8");
            seqParameterSetExt.alpha_incr_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPSE: alpha_incr_flag");
            seqParameterSetExt.alpha_opaque_value = CAVLCReader.readU(bitReaderCreateBitReader, seqParameterSetExt.bit_depth_aux_minus8 + 9, "SPSE: alpha_opaque_value");
            seqParameterSetExt.alpha_transparent_value = CAVLCReader.readU(bitReaderCreateBitReader, seqParameterSetExt.bit_depth_aux_minus8 + 9, "SPSE: alpha_transparent_value");
        }
        seqParameterSetExt.additional_extension_flag = CAVLCReader.readBool(bitReaderCreateBitReader, "SPSE: additional_extension_flag");
        return seqParameterSetExt;
    }

    public void write(ByteBuffer byteBuffer) {
        CAVLCWriter.writeTrailingBits(new BitWriter(byteBuffer));
    }
}
