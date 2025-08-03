package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public abstract class MXFInterchangeObject extends MXFMetadata {
    private UL generationUID;
    private UL objectClass;

    public MXFInterchangeObject(UL ul) {
        super(ul);
    }

    public UL getGenerationUID() {
        return this.generationUID;
    }

    public UL getObjectClass() {
        return this.objectClass;
    }

    public abstract void read(Map<Integer, ByteBuffer> map);

    @Override // org.jcodec.containers.mxf.model.MXFMetadata
    public void readBuf(ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        HashMap map = new HashMap();
        while (byteBuffer.hasRemaining()) {
            int i = byteBuffer.getShort() & 65535;
            ByteBuffer byteBuffer2 = NIOUtils.read(byteBuffer, 65535 & byteBuffer.getShort());
            if (i == 257) {
                this.objectClass = UL.read(byteBuffer2);
            } else if (i == 258) {
                this.generationUID = UL.read(byteBuffer2);
            } else if (i != 15370) {
                map.put(Integer.valueOf(i), byteBuffer2);
            } else {
                this.uid = UL.read(byteBuffer2);
            }
        }
        if (map.size() > 0) {
            read(map);
        }
    }
}
