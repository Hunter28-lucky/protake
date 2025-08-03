package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class Preface extends MXFInterchangeObject {
    private UL[] dmSchemes;
    private UL[] essenceContainers;
    private Date lastModifiedDate;
    private int objectModelVersion;
    private UL op;

    public Preface(UL ul) {
        super(ul);
    }

    public UL[] getDmSchemes() {
        return this.dmSchemes;
    }

    public UL[] getEssenceContainers() {
        return this.essenceContainers;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public int getObjectModelVersion() {
        return this.objectModelVersion;
    }

    public UL getOp() {
        return this.op;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 15106) {
                this.lastModifiedDate = MXFMetadata.readDate(value);
            } else if (iIntValue != 15111) {
                switch (iIntValue) {
                    case 15113:
                        this.op = UL.read(value);
                        break;
                    case 15114:
                        this.essenceContainers = MXFMetadata.readULBatch(value);
                        break;
                    case 15115:
                        this.dmSchemes = MXFMetadata.readULBatch(value);
                        break;
                    default:
                        Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                        continue;
                }
            } else {
                this.objectModelVersion = value.getInt();
            }
            it.remove();
        }
    }
}
