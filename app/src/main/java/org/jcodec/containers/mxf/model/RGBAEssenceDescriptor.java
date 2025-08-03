package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class RGBAEssenceDescriptor extends GenericPictureEssenceDescriptor {
    private int alphaMaxRef;
    private int alphaMinRef;
    private int componentMaxRef;
    private int componentMinRef;
    private ByteBuffer palette;
    private ByteBuffer paletteLayout;
    private ByteBuffer pixelLayout;
    private byte scanningDirection;

    public RGBAEssenceDescriptor(UL ul) {
        super(ul);
    }

    public int getAlphaMaxRef() {
        return this.alphaMaxRef;
    }

    public int getAlphaMinRef() {
        return this.alphaMinRef;
    }

    public int getComponentMaxRef() {
        return this.componentMaxRef;
    }

    public int getComponentMinRef() {
        return this.componentMinRef;
    }

    public ByteBuffer getPalette() {
        return this.palette;
    }

    public ByteBuffer getPaletteLayout() {
        return this.paletteLayout;
    }

    public ByteBuffer getPixelLayout() {
        return this.pixelLayout;
    }

    public byte getScanningDirection() {
        return this.scanningDirection;
    }

    @Override // org.jcodec.containers.mxf.model.GenericPictureEssenceDescriptor, org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 13313:
                    this.pixelLayout = value;
                    break;
                case 13314:
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
                case 13315:
                    this.palette = value;
                    break;
                case 13316:
                    this.paletteLayout = value;
                    break;
                case 13317:
                    this.scanningDirection = value.get();
                    break;
                case 13318:
                    this.componentMaxRef = value.getInt();
                    break;
                case 13319:
                    this.componentMinRef = value.getInt();
                    break;
                case 13320:
                    this.alphaMaxRef = value.getInt();
                    break;
                case 13321:
                    this.alphaMinRef = value.getInt();
                    break;
            }
            it.remove();
        }
    }
}
