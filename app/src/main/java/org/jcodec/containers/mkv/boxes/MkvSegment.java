package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.jcodec.containers.mkv.util.EbmlUtil;
import org.jcodec.containers.mxf.model.BER;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MkvSegment extends EbmlMaster {
    public static final byte[] SEGMENT_ID = {24, 83, BER.ASN_LONG_LEN, 103};
    public int headerSize;

    public MkvSegment(byte[] bArr) {
        super(bArr);
        this.headerSize = 0;
    }

    public static MkvSegment createMkvSegment() {
        return new MkvSegment(SEGMENT_ID);
    }

    public ByteBuffer getHeader() {
        long headerSize = getHeaderSize();
        if (headerSize > 2147483647L) {
            System.out.println("MkvSegment.getHeader: id.length " + this.id.length + "  Element.getEbmlSize(" + this.dataLen + "): " + EbmlUtil.ebmlLength(this.dataLen) + " size: " + this.dataLen);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) headerSize);
        byteBufferAllocate.put(this.id);
        byteBufferAllocate.put(EbmlUtil.ebmlEncode(getDataLen()));
        ArrayList<EbmlBase> arrayList = this.children;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<EbmlBase> it = this.children.iterator();
            while (it.hasNext()) {
                EbmlBase next = it.next();
                if (!Platform.arrayEqualsByte(EbmlMaster.CLUSTER_ID, next.type.id)) {
                    byteBufferAllocate.put(next.getData());
                }
            }
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public long getHeaderSize() {
        long length = this.id.length + EbmlUtil.ebmlLength(getDataLen());
        ArrayList<EbmlBase> arrayList = this.children;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<EbmlBase> it = this.children.iterator();
            while (it.hasNext()) {
                EbmlBase next = it.next();
                if (!Platform.arrayEqualsByte(EbmlMaster.CLUSTER_ID, next.type.id)) {
                    length += next.size();
                }
            }
        }
        return length;
    }
}
