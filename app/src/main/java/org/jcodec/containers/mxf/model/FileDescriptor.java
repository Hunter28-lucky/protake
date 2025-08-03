package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

/* loaded from: classes2.dex */
public class FileDescriptor extends GenericDescriptor {
    private UL codec;
    private long containerDuration;
    private UL essenceContainer;
    private int linkedTrackId;
    private Rational sampleRate;

    public FileDescriptor(UL ul) {
        super(ul);
    }

    public UL getCodec() {
        return this.codec;
    }

    public long getContainerDuration() {
        return this.containerDuration;
    }

    public UL getEssenceContainer() {
        return this.essenceContainer;
    }

    public int getLinkedTrackId() {
        return this.linkedTrackId;
    }

    public Rational getSampleRate() {
        return this.sampleRate;
    }

    @Override // org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            switch (next.getKey().intValue()) {
                case 12289:
                    this.sampleRate = new Rational(value.getInt(), value.getInt());
                    break;
                case 12290:
                    this.containerDuration = value.getLong();
                    break;
                case 12291:
                default:
                    Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                    continue;
                case 12292:
                    this.essenceContainer = UL.read(value);
                    break;
                case 12293:
                    this.codec = UL.read(value);
                    break;
                case 12294:
                    this.linkedTrackId = value.getInt();
                    break;
            }
            it.remove();
        }
    }
}
