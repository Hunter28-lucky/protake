package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

/* loaded from: classes2.dex */
public class TimelineTrack extends GenericTrack {
    private Rational editRate;
    private long origin;

    public TimelineTrack(UL ul) {
        super(ul);
    }

    public Rational getEditRate() {
        return this.editRate;
    }

    public long getOrigin() {
        return this.origin;
    }

    @Override // org.jcodec.containers.mxf.model.GenericTrack, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 19201) {
                this.editRate = new Rational(value.getInt(), value.getInt());
            } else if (iIntValue != 19202) {
                Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.origin = value.getLong();
            }
            it.remove();
        }
    }
}
