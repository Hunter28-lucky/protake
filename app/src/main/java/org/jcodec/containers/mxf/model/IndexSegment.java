package org.jcodec.containers.mxf.model;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class IndexSegment extends MXFInterchangeObject {
    private int bodySID;
    private DeltaEntries deltaEntries;
    private int editUnitByteCount;
    private IndexEntries ie;
    private long indexDuration;
    private int indexEditRateDen;
    private int indexEditRateNum;
    private int indexSID;
    private long indexStartPosition;
    private UL instanceUID;
    private int posTableCount;
    private int sliceCount;

    public IndexSegment(UL ul) {
        super(ul);
    }

    public int getBodySID() {
        return this.bodySID;
    }

    public DeltaEntries getDeltaEntries() {
        return this.deltaEntries;
    }

    public int getEditUnitByteCount() {
        return this.editUnitByteCount;
    }

    public IndexEntries getIe() {
        return this.ie;
    }

    public long getIndexDuration() {
        return this.indexDuration;
    }

    public int getIndexEditRateDen() {
        return this.indexEditRateDen;
    }

    public int getIndexEditRateNum() {
        return this.indexEditRateNum;
    }

    public int getIndexSID() {
        return this.indexSID;
    }

    public long getIndexStartPosition() {
        return this.indexStartPosition;
    }

    public UL getInstanceUID() {
        return this.instanceUID;
    }

    public int getPosTableCount() {
        return this.posTableCount;
    }

    public int getSliceCount() {
        return this.sliceCount;
    }

    @Override // org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue != 15370) {
                switch (iIntValue) {
                    case 16133:
                        this.editUnitByteCount = value.getInt();
                        break;
                    case 16134:
                        this.indexSID = value.getInt();
                        break;
                    case 16135:
                        this.bodySID = value.getInt();
                        break;
                    case 16136:
                        this.sliceCount = value.get() & ExifInterface.MARKER;
                        break;
                    case 16137:
                        this.deltaEntries = DeltaEntries.read(value);
                        break;
                    case 16138:
                        this.ie = IndexEntries.read(value);
                        break;
                    case 16139:
                        this.indexEditRateNum = value.getInt();
                        this.indexEditRateDen = value.getInt();
                        break;
                    case 16140:
                        this.indexStartPosition = value.getLong();
                        break;
                    case 16141:
                        this.indexDuration = value.getLong();
                        break;
                    case 16142:
                        this.posTableCount = value.get() & ExifInterface.MARKER;
                        break;
                    default:
                        Logger.warn(String.format("Unknown tag [" + this.ul + "]: %04x", next.getKey()));
                        continue;
                }
            } else {
                this.instanceUID = UL.read(value);
            }
            it.remove();
        }
    }
}
