package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class MXFStructuralComponent extends MXFInterchangeObject {
    private UL dataDefinitionUL;
    private long duration;

    public MXFStructuralComponent(UL ul) {
        super(ul);
    }

    public UL getDataDefinitionUL() {
        return this.dataDefinitionUL;
    }

    public long getDuration() {
        return this.duration;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 513) {
                this.dataDefinitionUL = UL.read(next.getValue());
            } else if (iIntValue != 514) {
                Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.duration = next.getValue().getLong();
            }
            it.remove();
        }
    }
}
