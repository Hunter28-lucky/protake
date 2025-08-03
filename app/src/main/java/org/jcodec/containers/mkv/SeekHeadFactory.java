package org.jcodec.containers.mkv;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.util.EbmlUtil;

/* loaded from: classes2.dex */
public class SeekHeadFactory {
    public long currentDataOffset = 0;
    public List<SeekMock> a = new ArrayList();

    public static class SeekMock {
        public long dataOffset;
        public byte[] id;
        public int seekPointerSize;
        public int size;

        public static SeekMock make(EbmlBase ebmlBase) {
            SeekMock seekMock = new SeekMock();
            seekMock.id = ebmlBase.id;
            seekMock.size = (int) ebmlBase.size();
            return seekMock;
        }
    }

    public static int estimeteSeekSize(int i, int i2) {
        int length = MKVType.SeekID.id.length + EbmlUtil.ebmlLength(i) + i;
        return MKVType.Seek.id.length + EbmlUtil.ebmlLength(length + r3) + length + MKVType.SeekPosition.id.length + EbmlUtil.ebmlLength(i2) + i2;
    }

    public void add(EbmlBase ebmlBase) {
        SeekMock seekMockMake = SeekMock.make(ebmlBase);
        long j = this.currentDataOffset;
        seekMockMake.dataOffset = j;
        seekMockMake.seekPointerSize = EbmlUint.calculatePayloadSize(j);
        this.currentDataOffset += seekMockMake.size;
        this.a.add(seekMockMake);
    }

    public int computeSeekHeadSize() {
        boolean z;
        int iCalculatePayloadSize;
        int i;
        int iEstimateSize = estimateSize();
        do {
            z = false;
            Iterator<SeekMock> it = this.a.iterator();
            do {
                if (it.hasNext()) {
                    SeekMock next = it.next();
                    iCalculatePayloadSize = EbmlUint.calculatePayloadSize(next.dataOffset + iEstimateSize);
                    i = next.seekPointerSize;
                    if (iCalculatePayloadSize > i) {
                        System.out.println("Size " + iEstimateSize + " seems too small for element " + EbmlUtil.toHexString(next.id) + " increasing size by one.");
                        next.seekPointerSize = next.seekPointerSize + 1;
                        iEstimateSize++;
                        z = true;
                    }
                }
            } while (iCalculatePayloadSize >= i);
            throw new RuntimeException("Downsizing the index is not well thought through.");
        } while (z);
        return iEstimateSize;
    }

    public int estimateSize() {
        int length = MKVType.SeekHead.id.length + 1 + estimeteSeekSize(this.a.get(0).id.length, 1);
        for (int i = 1; i < this.a.size(); i++) {
            length += estimeteSeekSize(this.a.get(i).id.length, this.a.get(i).seekPointerSize);
        }
        return length;
    }

    public EbmlMaster indexSeekHead() {
        int iComputeSeekHeadSize = computeSeekHeadSize();
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.SeekHead);
        for (SeekMock seekMock : this.a) {
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.Seek);
            EbmlBin ebmlBin = (EbmlBin) MKVType.createByType(MKVType.SeekID);
            ebmlBin.setBuf(ByteBuffer.wrap(seekMock.id));
            ebmlMaster2.add(ebmlBin);
            EbmlUint ebmlUint = (EbmlUint) MKVType.createByType(MKVType.SeekPosition);
            ebmlUint.setUint(seekMock.dataOffset + iComputeSeekHeadSize);
            if (ebmlUint.data.limit() != seekMock.seekPointerSize) {
                System.err.println("estimated size of seekPosition differs from the one actually used. ElementId: " + EbmlUtil.toHexString(seekMock.id) + MyUTIL.white_space + ebmlUint.getData().limit() + " vs " + seekMock.seekPointerSize);
            }
            ebmlMaster2.add(ebmlUint);
            ebmlMaster.add(ebmlMaster2);
        }
        ByteBuffer data = ebmlMaster.getData();
        if (data.limit() != iComputeSeekHeadSize) {
            System.err.println("estimated size of seekHead differs from the one actually used. " + data.limit() + " vs " + iComputeSeekHeadSize);
        }
        return ebmlMaster;
    }
}
