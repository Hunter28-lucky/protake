package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class Sequence extends MXFStructuralComponent {
    private UL[] structuralComponentsRefs;

    public Sequence(UL ul) {
        super(ul);
    }

    public UL[] getStructuralComponentsRefs() {
        return this.structuralComponentsRefs;
    }

    @Override // org.jcodec.containers.mxf.model.MXFStructuralComponent, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            if (next.getKey().intValue() != 4097) {
                Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.structuralComponentsRefs = MXFMetadata.readULBatch(next.getValue());
                it.remove();
            }
        }
    }
}
