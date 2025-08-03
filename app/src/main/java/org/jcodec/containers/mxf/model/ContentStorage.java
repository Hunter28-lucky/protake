package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class ContentStorage extends MXFInterchangeObject {
    private UL[] essenceContainerData;
    private UL[] packageRefs;

    public ContentStorage(UL ul) {
        super(ul);
    }

    public UL[] getEssenceContainerData() {
        return this.essenceContainerData;
    }

    public UL[] getPackageRefs() {
        return this.packageRefs;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 6401) {
                this.packageRefs = MXFMetadata.readULBatch(value);
            } else if (iIntValue != 6402) {
                Logger.warn(String.format("Unknown tag [ ContentStorage: " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.essenceContainerData = MXFMetadata.readULBatch(value);
            }
            it.remove();
        }
    }
}
