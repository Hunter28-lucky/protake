package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class EssenceContainerData extends MXFInterchangeObject {
    private int bodySID;
    private int indexSID;
    private UL linkedPackageUID;

    public EssenceContainerData(UL ul) {
        super(ul);
    }

    public int getBodySID() {
        return this.bodySID;
    }

    public int getIndexSID() {
        return this.indexSID;
    }

    public UL getLinkedPackageUID() {
        return this.linkedPackageUID;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 9985) {
                this.linkedPackageUID = UL.read(value);
            } else if (iIntValue == 16134) {
                this.indexSID = value.getInt();
            } else if (iIntValue != 16135) {
                Logger.warn(String.format("Unknown tag [ EssenceContainerData: " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.bodySID = value.getInt();
            }
            it.remove();
        }
    }
}
