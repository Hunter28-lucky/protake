package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class SourceClip extends MXFStructuralComponent {
    private UL sourcePackageUid;
    private int sourceTrackId;
    private long startPosition;

    public SourceClip(UL ul) {
        super(ul);
    }

    public UL getSourcePackageUid() {
        return this.sourcePackageUid;
    }

    public int getSourceTrackId() {
        return this.sourceTrackId;
    }

    public long getStartPosition() {
        return this.startPosition;
    }

    @Override // org.jcodec.containers.mxf.model.MXFStructuralComponent, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 4353) {
                this.sourcePackageUid = UL.read(value);
            } else if (iIntValue == 4354) {
                this.sourceTrackId = value.getInt();
            } else if (iIntValue != 4609) {
                Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
            } else {
                this.startPosition = value.getLong();
            }
            it.remove();
        }
    }
}
