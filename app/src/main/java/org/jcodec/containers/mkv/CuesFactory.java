package org.jcodec.containers.mkv;

import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlUint;
import org.jcodec.containers.mkv.util.EbmlUtil;

/* loaded from: classes2.dex */
public class CuesFactory {
    private final long offsetBase;
    private long videoTrackNr;
    private long currentDataOffset = 0;
    public List<CuePointMock> a = new ArrayList();

    public static class CuePointMock {
        public int cueClusterPositionSize;
        public long elementOffset;
        private byte[] id;
        private long size;
        private long timecode;

        public static CuePointMock doMake(byte[] bArr, long j, long j2) {
            CuePointMock cuePointMock = new CuePointMock();
            cuePointMock.id = bArr;
            cuePointMock.timecode = j;
            cuePointMock.size = j2;
            return cuePointMock;
        }

        public static CuePointMock make(EbmlMaster ebmlMaster) {
            return doMake(ebmlMaster.id, ((EbmlUint) MKVType.findFirst(ebmlMaster, new MKVType[]{MKVType.Cluster, MKVType.Timecode})).getUint(), ebmlMaster.size());
        }
    }

    public CuesFactory(long j, long j2) {
        this.offsetBase = j;
        this.videoTrackNr = j2;
        this.currentDataOffset += j;
    }

    public static int estimateCuePointSize(int i, int i2, int i3) {
        int length = MKVType.CueTime.id.length + EbmlUtil.ebmlLength(i) + i;
        int length2 = MKVType.CueTrack.id.length + EbmlUtil.ebmlLength(i2) + i2 + MKVType.CueClusterPosition.id.length + EbmlUtil.ebmlLength(i3) + i3;
        return MKVType.CuePoint.id.length + EbmlUtil.ebmlLength(length + r3) + length + length2 + MKVType.CueTrackPositions.id.length + EbmlUtil.ebmlLength(length2);
    }

    public void add(CuePointMock cuePointMock) {
        long j = this.currentDataOffset;
        cuePointMock.elementOffset = j;
        cuePointMock.cueClusterPositionSize = EbmlUint.calculatePayloadSize(j);
        this.currentDataOffset += cuePointMock.size;
        this.a.add(cuePointMock);
    }

    public void addFixedSize(CuePointMock cuePointMock) {
        long j = this.currentDataOffset;
        cuePointMock.elementOffset = j;
        cuePointMock.cueClusterPositionSize = 8;
        this.currentDataOffset = j + cuePointMock.size;
        this.a.add(cuePointMock);
    }

    public int computeCuesSize() {
        boolean z;
        int iCalculatePayloadSize;
        int i;
        int iEstimateSize = estimateSize();
        do {
            z = false;
            Iterator<CuePointMock> it = this.a.iterator();
            do {
                if (it.hasNext()) {
                    CuePointMock next = it.next();
                    iCalculatePayloadSize = EbmlUint.calculatePayloadSize(next.elementOffset + iEstimateSize);
                    i = next.cueClusterPositionSize;
                    if (iCalculatePayloadSize > i) {
                        System.out.println(iCalculatePayloadSize + ">" + next.cueClusterPositionSize);
                        System.err.println("Size " + iEstimateSize + " seems too small for element " + EbmlUtil.toHexString(next.id) + " increasing size by one.");
                        next.cueClusterPositionSize = next.cueClusterPositionSize + 1;
                        iEstimateSize++;
                        z = true;
                    }
                }
            } while (iCalculatePayloadSize >= i);
            throw new RuntimeException("Downsizing the index is not well thought through");
        } while (z);
        return iEstimateSize;
    }

    public EbmlMaster createCues() {
        int iComputeCuesSize = computeCuesSize();
        EbmlMaster ebmlMaster = (EbmlMaster) MKVType.createByType(MKVType.Cues);
        for (CuePointMock cuePointMock : this.a) {
            EbmlMaster ebmlMaster2 = (EbmlMaster) MKVType.createByType(MKVType.CuePoint);
            EbmlUint ebmlUint = (EbmlUint) MKVType.createByType(MKVType.CueTime);
            ebmlUint.setUint(cuePointMock.timecode);
            ebmlMaster2.add(ebmlUint);
            EbmlMaster ebmlMaster3 = (EbmlMaster) MKVType.createByType(MKVType.CueTrackPositions);
            EbmlUint ebmlUint2 = (EbmlUint) MKVType.createByType(MKVType.CueTrack);
            ebmlUint2.setUint(this.videoTrackNr);
            ebmlMaster3.add(ebmlUint2);
            EbmlUint ebmlUint3 = (EbmlUint) MKVType.createByType(MKVType.CueClusterPosition);
            ebmlUint3.setUint(cuePointMock.elementOffset + iComputeCuesSize);
            if (ebmlUint3.data.limit() != cuePointMock.cueClusterPositionSize) {
                System.err.println("estimated size of CueClusterPosition differs from the one actually used. ElementId: " + EbmlUtil.toHexString(cuePointMock.id) + MyUTIL.white_space + ebmlUint3.getData().limit() + " vs " + cuePointMock.cueClusterPositionSize);
            }
            ebmlMaster3.add(ebmlUint3);
            ebmlMaster2.add(ebmlMaster3);
            ebmlMaster.add(ebmlMaster2);
        }
        return ebmlMaster;
    }

    public int estimateFixedSize(int i) {
        int i2 = i * 34;
        return i2 + MKVType.Cues.id.length + EbmlUtil.ebmlLength(i2);
    }

    public int estimateSize() {
        int iEstimateCuePointSize = 0;
        for (CuePointMock cuePointMock : this.a) {
            iEstimateCuePointSize += estimateCuePointSize(EbmlUint.calculatePayloadSize(cuePointMock.timecode), EbmlUint.calculatePayloadSize(this.videoTrackNr), EbmlUint.calculatePayloadSize(cuePointMock.elementOffset));
        }
        return iEstimateCuePointSize + MKVType.Cues.id.length + EbmlUtil.ebmlLength(iEstimateCuePointSize);
    }
}
