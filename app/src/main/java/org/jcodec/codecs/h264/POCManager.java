package org.jcodec.codecs.h264;

import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.SliceHeader;

/* loaded from: classes2.dex */
public class POCManager {
    private int prevPOCLsb;
    private int prevPOCMsb;

    private int calcPOC0(SliceHeader sliceHeader, NALUnit nALUnit) {
        if (nALUnit.type == NALUnitType.IDR_SLICE) {
            this.prevPOCLsb = 0;
            this.prevPOCMsb = 0;
        }
        int i = 1 << (sliceHeader.sps.log2MaxPicOrderCntLsbMinus4 + 3);
        int i2 = i << 1;
        int i3 = sliceHeader.picOrderCntLsb;
        int i4 = this.prevPOCLsb;
        int i5 = (i3 >= i4 || i4 - i3 < i) ? (i3 <= i4 || i3 - i4 <= i) ? this.prevPOCMsb : this.prevPOCMsb - i2 : this.prevPOCMsb + i2;
        int i6 = i5 + i3;
        if (nALUnit.nal_ref_idc > 0) {
            if (hasMMCO5(sliceHeader, nALUnit)) {
                this.prevPOCMsb = 0;
                this.prevPOCLsb = i6;
            } else {
                this.prevPOCMsb = i5;
                this.prevPOCLsb = i3;
            }
        }
        return i6;
    }

    private int calcPOC1(SliceHeader sliceHeader, NALUnit nALUnit) {
        return sliceHeader.frameNum << 1;
    }

    private int calcPOC2(SliceHeader sliceHeader, NALUnit nALUnit) {
        return sliceHeader.frameNum << 1;
    }

    private boolean hasMMCO5(SliceHeader sliceHeader, NALUnit nALUnit) {
        RefPicMarking refPicMarking;
        if (nALUnit.type != NALUnitType.IDR_SLICE && (refPicMarking = sliceHeader.refPicMarkingNonIDR) != null) {
            for (RefPicMarking.Instruction instruction : refPicMarking.getInstructions()) {
                if (instruction.getType() == RefPicMarking.InstrType.CLEAR) {
                    return true;
                }
            }
        }
        return false;
    }

    public int calcPOC(SliceHeader sliceHeader, NALUnit nALUnit) {
        int i = sliceHeader.sps.picOrderCntType;
        if (i == 0) {
            return calcPOC0(sliceHeader, nALUnit);
        }
        if (i == 1) {
            return calcPOC1(sliceHeader, nALUnit);
        }
        if (i == 2) {
            return calcPOC2(sliceHeader, nALUnit);
        }
        throw new RuntimeException("POC no!!!");
    }
}
