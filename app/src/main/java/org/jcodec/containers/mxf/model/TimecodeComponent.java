package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class TimecodeComponent extends MXFStructuralComponent {
    private int base;
    private int dropFrame;
    private long start;

    public TimecodeComponent(UL ul) {
        super(ul);
    }

    public int getBase() {
        return this.base;
    }

    public int getDropFrame() {
        return this.dropFrame;
    }

    public long getStart() {
        return this.start;
    }

    @Override // org.jcodec.containers.mxf.model.MXFStructuralComponent, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 5377:
                    this.start = value.getLong();
                    break;
                case 5378:
                    this.base = value.getShort();
                    break;
                case 5379:
                    this.dropFrame = value.get();
                    break;
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
            }
            it.remove();
        }
    }
}
