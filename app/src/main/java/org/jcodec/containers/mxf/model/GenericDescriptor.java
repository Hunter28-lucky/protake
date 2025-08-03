package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class GenericDescriptor extends MXFInterchangeObject {
    private UL[] locators;
    private UL[] subDescriptors;

    public GenericDescriptor(UL ul) {
        super(ul);
    }

    public UL[] getLocators() {
        return this.locators;
    }

    public UL[] getSubDescriptors() {
        return this.subDescriptors;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 12033) {
                this.locators = MXFMetadata.readULBatch(value);
            } else if (iIntValue != 16129) {
                Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.subDescriptors = MXFMetadata.readULBatch(value);
            }
            it.remove();
        }
    }
}
