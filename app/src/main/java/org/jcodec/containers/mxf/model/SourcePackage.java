package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class SourcePackage extends GenericPackage {
    private UL descriptorRef;
    private UL[] trackRefs;

    public SourcePackage(UL ul) {
        super(ul);
    }

    public UL getDescriptorRef() {
        return this.descriptorRef;
    }

    public UL[] getTrackRefs() {
        return this.trackRefs;
    }

    @Override // org.jcodec.containers.mxf.model.GenericPackage, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            if (next.getKey().intValue() != 18177) {
                Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.descriptorRef = UL.read(value);
                it.remove();
            }
        }
    }
}
