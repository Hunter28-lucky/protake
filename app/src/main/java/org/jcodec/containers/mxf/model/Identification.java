package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class Identification extends MXFInterchangeObject {
    private String companyName;
    private Date modificationDate;
    private String platform;
    private String productName;
    private UL productUID;
    private UL thisGenerationUID;
    private short versionString;

    public Identification(UL ul) {
        super(ul);
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getProductName() {
        return this.productName;
    }

    public UL getProductUID() {
        return this.productUID;
    }

    public UL getThisGenerationUID() {
        return this.thisGenerationUID;
    }

    public short getVersionString() {
        return this.versionString;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 15361:
                    this.companyName = readUtf16String(value);
                    break;
                case 15362:
                    this.productName = readUtf16String(value);
                    break;
                case 15363:
                case 15367:
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
                case 15364:
                    this.versionString = value.getShort();
                    break;
                case 15365:
                    this.productUID = UL.read(value);
                    break;
                case 15366:
                    this.modificationDate = MXFMetadata.readDate(value);
                    break;
                case 15368:
                    this.platform = readUtf16String(value);
                    break;
                case 15369:
                    this.thisGenerationUID = UL.read(value);
                    break;
            }
            it.remove();
        }
    }
}
