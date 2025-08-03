package org.jcodec.codecs.common.biari;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.FrameMetricsAggregator;
import java.nio.ByteBuffer;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class MEncoder {
    private int bitsInOutReg;
    private int[][] models;
    private int offset;
    private int onesOutstanding;
    private ByteBuffer out;
    private int outReg;
    private int range = TypedValues.PositionType.TYPE_POSITION_TYPE;
    private boolean zeroBorrowed;

    public MEncoder(ByteBuffer byteBuffer, int[][] iArr) {
        this.models = iArr;
        this.out = byteBuffer;
    }

    private void flushOutstanding(int i) {
        if (this.zeroBorrowed) {
            putBit(i);
        }
        int i2 = 1 - i;
        while (this.onesOutstanding > 0) {
            putBit(i2);
            this.onesOutstanding--;
        }
        this.zeroBorrowed = true;
    }

    private void putBit(int i) {
        int i2 = i | (this.outReg << 1);
        this.outReg = i2;
        int i3 = this.bitsInOutReg + 1;
        this.bitsInOutReg = i3;
        if (i3 == 8) {
            this.out.put((byte) i2);
            this.outReg = 0;
            this.bitsInOutReg = 0;
        }
    }

    private void renormalize() {
        while (this.range < 256) {
            int i = this.offset;
            if (i < 256) {
                flushOutstanding(0);
            } else if (i < 512) {
                this.offset = i & 255;
                this.onesOutstanding++;
            } else {
                this.offset = i & FrameMetricsAggregator.EVERY_DURATION;
                flushOutstanding(1);
            }
            this.range <<= 1;
            this.offset <<= 1;
        }
    }

    private void stuffBits() {
        int i = this.bitsInOutReg;
        if (i == 0) {
            this.out.put(BER.ASN_LONG_LEN);
            return;
        }
        int i2 = ((this.outReg << 1) | 1) << (8 - (i + 1));
        this.outReg = i2;
        this.out.put((byte) i2);
        this.outReg = 0;
        this.bitsInOutReg = 0;
    }

    public void encodeBin(int i, int i2) {
        int i3 = this.range;
        int[] iArr = MConst.rangeLPS[(i3 >> 6) & 3];
        int[][] iArr2 = this.models;
        int[] iArr3 = iArr2[0];
        int i4 = iArr3[i];
        int i5 = iArr[i4];
        int i6 = i3 - i5;
        this.range = i6;
        int[] iArr4 = iArr2[1];
        int i7 = iArr4[i];
        if (i2 != i7) {
            this.offset += i6;
            this.range = i5;
            if (i4 == 0) {
                iArr4[i] = 1 - i7;
            }
            iArr3[i] = MConst.transitLPS[iArr3[i]];
        } else if (i4 < 62) {
            iArr3[i] = i4 + 1;
        }
        renormalize();
    }

    public void encodeBinBypass(int i) {
        int i2 = this.offset << 1;
        this.offset = i2;
        if (i == 1) {
            this.offset = i2 + this.range;
        }
        int i3 = this.offset;
        if ((i3 & 1024) != 0) {
            flushOutstanding(1);
            this.offset &= 1023;
        } else if ((i3 & 512) == 0) {
            flushOutstanding(0);
        } else {
            this.offset = i3 & FrameMetricsAggregator.EVERY_DURATION;
            this.onesOutstanding++;
        }
    }

    public void encodeBinFinal(int i) {
        int i2 = this.range - 2;
        this.range = i2;
        if (i == 0) {
            renormalize();
            return;
        }
        this.offset += i2;
        this.range = 2;
        renormalize();
    }

    public void finishEncoding() {
        flushOutstanding((this.offset >> 9) & 1);
        putBit((this.offset >> 8) & 1);
        stuffBits();
    }
}
