package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class CDCIEssenceDescriptor extends GenericPictureEssenceDescriptor {
    private int alphaSampleDepth;
    private int blackRefLevel;
    private int colorRange;
    private byte colorSiting;
    private int componentDepth;
    private int horizontalSubsampling;
    private short paddingBits;
    private byte reversedByteOrder;
    private int verticalSubsampling;
    private int whiteReflevel;

    public CDCIEssenceDescriptor(UL ul) {
        super(ul);
    }

    public int getAlphaSampleDepth() {
        return this.alphaSampleDepth;
    }

    public int getBlackRefLevel() {
        return this.blackRefLevel;
    }

    public int getColorRange() {
        return this.colorRange;
    }

    public byte getColorSiting() {
        return this.colorSiting;
    }

    public int getComponentDepth() {
        return this.componentDepth;
    }

    public int getHorizontalSubsampling() {
        return this.horizontalSubsampling;
    }

    public short getPaddingBits() {
        return this.paddingBits;
    }

    public byte getReversedByteOrder() {
        return this.reversedByteOrder;
    }

    public int getVerticalSubsampling() {
        return this.verticalSubsampling;
    }

    public int getWhiteReflevel() {
        return this.whiteReflevel;
    }

    @Override // org.jcodec.containers.mxf.model.GenericPictureEssenceDescriptor, org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 13057:
                    this.componentDepth = value.getInt();
                    break;
                case 13058:
                    this.horizontalSubsampling = value.getInt();
                    break;
                case 13059:
                    this.colorSiting = value.get();
                    break;
                case 13060:
                    this.blackRefLevel = value.getInt();
                    break;
                case 13061:
                    this.whiteReflevel = value.getInt();
                    break;
                case 13062:
                    this.colorRange = value.getInt();
                    break;
                case 13063:
                    this.paddingBits = value.getShort();
                    break;
                case 13064:
                    this.verticalSubsampling = value.getInt();
                    break;
                case 13065:
                    this.alphaSampleDepth = value.getInt();
                    break;
                case 13066:
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
                case 13067:
                    this.reversedByteOrder = value.get();
                    break;
            }
            it.remove();
        }
    }
}
