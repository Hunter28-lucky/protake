package org.jcodec.containers.mkv.boxes;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import org.jcodec.containers.mkv.util.EbmlUtil;

/* loaded from: classes2.dex */
public class EbmlMaster extends EbmlBase {
    public static final byte[] CLUSTER_ID = {31, 67, -74, 117};
    public final ArrayList<EbmlBase> children;
    public long usedSize;

    public EbmlMaster(byte[] bArr) {
        super(bArr);
        this.children = new ArrayList<>();
        this.id = bArr;
    }

    public void add(EbmlBase ebmlBase) {
        if (ebmlBase == null) {
            return;
        }
        ebmlBase.parent = this;
        this.children.add(ebmlBase);
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBase
    public ByteBuffer getData() {
        long dataLen = getDataLen();
        if (dataLen > 2147483647L) {
            System.out.println("EbmlMaster.getData: id.length " + this.id.length + "  EbmlUtil.ebmlLength(" + dataLen + "): " + EbmlUtil.ebmlLength(dataLen) + " size: " + dataLen);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) (this.id.length + EbmlUtil.ebmlLength(dataLen) + dataLen));
        byteBufferAllocate.put(this.id);
        byteBufferAllocate.put(EbmlUtil.ebmlEncode(dataLen));
        for (int i = 0; i < this.children.size(); i++) {
            byteBufferAllocate.put(this.children.get(i).getData());
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public long getDataLen() {
        ArrayList<EbmlBase> arrayList = this.children;
        if (arrayList == null || arrayList.isEmpty()) {
            return this.dataLen;
        }
        long size = 0;
        Iterator<EbmlBase> it = this.children.iterator();
        while (it.hasNext()) {
            size += it.next().size();
        }
        return size;
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBase
    public long size() {
        return getDataLen() + EbmlUtil.ebmlLength(r0) + this.id.length;
    }
}
