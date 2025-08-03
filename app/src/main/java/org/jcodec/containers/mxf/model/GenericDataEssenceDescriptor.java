package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class GenericDataEssenceDescriptor extends FileDescriptor {
    private UL dataEssenceCoding;

    public GenericDataEssenceDescriptor(UL ul) {
        super(ul);
    }

    public UL getDataEssenceCoding() {
        return this.dataEssenceCoding;
    }

    @Override // org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            if (next.getKey().intValue() != 15873) {
                Logger.warn(String.format("Unknown tag [ FileDescriptor: " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.dataEssenceCoding = UL.read(value);
                it.remove();
            }
        }
    }
}
