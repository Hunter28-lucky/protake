package org.jcodec.codecs.vpx;

import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class VPXBooleanEncoder {
    private ByteBuffer out;
    private int lowvalue = 0;
    private int range = 255;
    private int count = -24;

    public VPXBooleanEncoder(ByteBuffer byteBuffer) {
        this.out = byteBuffer;
    }

    public int position() {
        return this.out.position() + ((this.count + 24) >> 3);
    }

    public void stop() {
        for (int i = 0; i < 32; i++) {
            writeBit(128, 0);
        }
    }

    public void writeBit(int i, int i2) {
        int i3 = this.range;
        int i4 = (((i3 - 1) * i) >> 8) + 1;
        if (i2 != 0) {
            this.lowvalue += i4;
            this.range = i3 - i4;
        } else {
            this.range = i4;
        }
        int[] iArr = VPXConst.vp8Norm;
        int i5 = this.range;
        int i6 = iArr[i5];
        this.range = i5 << i6;
        int i7 = this.count + i6;
        this.count = i7;
        if (i7 >= 0) {
            int i8 = i6 - i7;
            if (((this.lowvalue << (i8 - 1)) & Integer.MIN_VALUE) != 0) {
                int iPosition = this.out.position() - 1;
                while (iPosition >= 0 && this.out.get(iPosition) == -1) {
                    this.out.put(iPosition, (byte) 0);
                    iPosition--;
                }
                ByteBuffer byteBuffer = this.out;
                byteBuffer.put(iPosition, (byte) ((byteBuffer.get(iPosition) & ExifInterface.MARKER) + 1));
            }
            this.out.put((byte) (this.lowvalue >> (24 - i8)));
            int i9 = this.lowvalue << i8;
            int i10 = this.count;
            this.lowvalue = i9 & ViewCompat.MEASURED_SIZE_MASK;
            this.count = i10 - 8;
            i6 = i10;
        }
        this.lowvalue <<= i6;
    }
}
