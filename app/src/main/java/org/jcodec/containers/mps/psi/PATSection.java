package org.jcodec.containers.mps.psi;

import java.nio.ByteBuffer;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.IntIntMap;

/* loaded from: classes2.dex */
public class PATSection extends PSISection {
    private int[] networkPids;
    private IntIntMap programs;

    public PATSection(PSISection pSISection, int[] iArr, IntIntMap intIntMap) {
        super(pSISection.tableId, pSISection.specificId, pSISection.versionNumber, pSISection.currentNextIndicator, pSISection.sectionNumber, pSISection.lastSectionNumber);
        this.networkPids = iArr;
        this.programs = intIntMap;
    }

    public static PATSection parsePAT(ByteBuffer byteBuffer) {
        PSISection psi = PSISection.parsePSI(byteBuffer);
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        IntIntMap intIntMap = new IntIntMap();
        while (byteBuffer.remaining() > 4) {
            int i = byteBuffer.getShort() & 65535;
            int i2 = byteBuffer.getShort() & 8191;
            if (i == 0) {
                intArrayListCreateIntArrayList.add(i2);
            } else {
                intIntMap.put(i, i2);
            }
        }
        return new PATSection(psi, intArrayListCreateIntArrayList.toArray(), intIntMap);
    }

    public int[] getNetworkPids() {
        return this.networkPids;
    }

    public IntIntMap getPrograms() {
        return this.programs;
    }
}
