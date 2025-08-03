package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class J2KPictureDescriptor extends MXFInterchangeObject {
    private short csiz;
    private short rsiz;
    private int xOsiz;
    private int xTOsiz;
    private int xTsiz;
    private int xsiz;
    private int yOsiz;
    private int yTOsiz;
    private int yTsiz;
    private int ysiz;

    public J2KPictureDescriptor(UL ul) {
        super(ul);
    }

    public short getCsiz() {
        return this.csiz;
    }

    public short getRsiz() {
        return this.rsiz;
    }

    public int getXsiz() {
        return this.xsiz;
    }

    public int getYsiz() {
        return this.ysiz;
    }

    public int getxOsiz() {
        return this.xOsiz;
    }

    public int getxTOsiz() {
        return this.xTOsiz;
    }

    public int getxTsiz() {
        return this.xTsiz;
    }

    public int getyOsiz() {
        return this.yOsiz;
    }

    public int getyTOsiz() {
        return this.yTOsiz;
    }

    public int getyTsiz() {
        return this.yTsiz;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 24836:
                    this.rsiz = value.getShort();
                    break;
                case 24837:
                    this.xsiz = value.getInt();
                    break;
                case 24838:
                    this.ysiz = value.getInt();
                    break;
                case 24839:
                    this.xOsiz = value.getInt();
                    break;
                case 24840:
                    this.yOsiz = value.getInt();
                    break;
                case 24841:
                    this.xTsiz = value.getInt();
                    break;
                case 24842:
                    this.yTsiz = value.getInt();
                    break;
                case 24843:
                    this.xTOsiz = value.getInt();
                    break;
                case 24844:
                    this.yTOsiz = value.getInt();
                    break;
                case 24845:
                    this.csiz = value.getShort();
                    break;
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
            }
            it.remove();
        }
    }
}
