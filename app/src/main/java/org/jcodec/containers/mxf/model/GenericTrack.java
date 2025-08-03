package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class GenericTrack extends MXFInterchangeObject {
    private String name;
    private UL sequenceRef;
    private int trackId;
    private int trackNumber;

    public GenericTrack(UL ul) {
        super(ul);
    }

    public String getName() {
        return this.name;
    }

    public UL getSequenceRef() {
        return this.sequenceRef;
    }

    public int getTrackId() {
        return this.trackId;
    }

    public int getTrackNumber() {
        return this.trackNumber;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 18433:
                    this.trackId = value.getInt();
                    break;
                case 18434:
                    this.name = readUtf16String(value);
                    break;
                case 18435:
                    this.sequenceRef = UL.read(value);
                    break;
                case 18436:
                    this.trackNumber = value.getInt();
                    break;
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
            }
            it.remove();
        }
    }
}
