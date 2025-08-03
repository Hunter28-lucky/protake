package org.jcodec.codecs.h264.io.model;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class NALUnit {
    public int nal_ref_idc;
    public NALUnitType type;

    public NALUnit(NALUnitType nALUnitType, int i) {
        this.type = nALUnitType;
        this.nal_ref_idc = i;
    }

    public static NALUnit read(ByteBuffer byteBuffer) {
        int i = byteBuffer.get() & ExifInterface.MARKER;
        return new NALUnit(NALUnitType.fromValue(i & 31), (i >> 5) & 3);
    }

    public void write(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) (this.type.getValue() | (this.nal_ref_idc << 5)));
    }
}
