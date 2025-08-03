package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class GenericPackage extends MXFInterchangeObject {
    private String name;
    private Date packageCreationDate;
    private Date packageModifiedDate;
    private UL packageUID;
    private UL[] tracks;

    public GenericPackage(UL ul) {
        super(ul);
    }

    public String getName() {
        return this.name;
    }

    public Date getPackageCreationDate() {
        return this.packageCreationDate;
    }

    public Date getPackageModifiedDate() {
        return this.packageModifiedDate;
    }

    public UL getPackageUID() {
        return this.packageUID;
    }

    public UL[] getTracks() {
        return this.tracks;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 17409:
                    this.packageUID = UL.read(value);
                    break;
                case 17410:
                    this.name = readUtf16String(value);
                    break;
                case 17411:
                    this.tracks = MXFMetadata.readULBatch(value);
                    break;
                case 17412:
                    this.packageModifiedDate = MXFMetadata.readDate(value);
                    break;
                case 17413:
                    this.packageCreationDate = MXFMetadata.readDate(value);
                    break;
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
            }
            it.remove();
        }
    }
}
