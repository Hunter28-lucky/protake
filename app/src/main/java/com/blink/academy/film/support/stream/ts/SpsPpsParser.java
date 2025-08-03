package com.blink.academy.film.support.stream.ts;

import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;

/* loaded from: classes.dex */
class SpsPpsParser {
    public PictureParameterSet pps;
    public SeqParameterSet sps;

    public SpsPpsParser(byte[] bArr) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
        byteBufferAllocate.put(bArr);
        byteBufferAllocate.position(0);
        while (true) {
            byteBufferAllocate.mark();
            ByteBuffer byteBufferNextNALUnit = H264Utils.nextNALUnit(byteBufferAllocate);
            if (byteBufferNextNALUnit == null) {
                return;
            }
            NALUnitType nALUnitType = NALUnit.read(byteBufferNextNALUnit).type;
            if (nALUnitType != NALUnitType.IDR_SLICE && nALUnitType != NALUnitType.NON_IDR_SLICE) {
                if (nALUnitType == NALUnitType.PPS) {
                    this.pps = PictureParameterSet.read(byteBufferNextNALUnit);
                } else if (nALUnitType == NALUnitType.SPS) {
                    this.sps = SeqParameterSet.read(byteBufferNextNALUnit);
                }
            }
        }
    }

    public PictureParameterSet getPps() {
        return this.pps;
    }

    public SeqParameterSet getSps() {
        return this.sps;
    }
}
