package org.jcodec.codecs.common.biari;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class MDecoder {
    private ByteBuffer _in;
    private int[][] cm;
    private int code;
    private int nBitsPending;
    private int range = TypedValues.PositionType.TYPE_POSITION_TYPE;

    public MDecoder(ByteBuffer byteBuffer, int[][] iArr) {
        this._in = byteBuffer;
        this.cm = iArr;
        initCodeRegister();
    }

    private void renormalize() {
        while (true) {
            int i = this.range;
            if (i >= 256) {
                return;
            }
            this.range = i << 1;
            this.code = (this.code << 1) & 131071;
            int i2 = this.nBitsPending - 1;
            this.nBitsPending = i2;
            if (i2 <= 0) {
                readOneByte();
            }
        }
    }

    public int decodeBin(int i) {
        int i2 = this.range;
        int[] iArr = MConst.rangeLPS[(i2 >> 6) & 3];
        int[] iArr2 = this.cm[0];
        int i3 = iArr2[i];
        int i4 = iArr[i3];
        int i5 = i2 - i4;
        this.range = i5;
        int i6 = i5 << 8;
        int i7 = this.code;
        if (i7 < i6) {
            if (i3 < 62) {
                iArr2[i] = i3 + 1;
            }
            renormalize();
            return this.cm[1][i];
        }
        this.range = i4;
        this.code = i7 - i6;
        renormalize();
        int[][] iArr3 = this.cm;
        int[] iArr4 = iArr3[1];
        int i8 = iArr4[i];
        int i9 = 1 - i8;
        int[] iArr5 = iArr3[0];
        if (iArr5[i] == 0) {
            iArr4[i] = 1 - i8;
        }
        iArr5[i] = MConst.transitLPS[iArr5[i]];
        return i9;
    }

    public int decodeBinBypass() {
        this.code <<= 1;
        int i = this.nBitsPending - 1;
        this.nBitsPending = i;
        if (i <= 0) {
            readOneByte();
        }
        int i2 = this.code - (this.range << 8);
        if (i2 < 0) {
            return 0;
        }
        this.code = i2;
        return 1;
    }

    public int decodeFinalBin() {
        int i = this.range - 2;
        this.range = i;
        if (this.code >= (i << 8)) {
            return 1;
        }
        renormalize();
        return 0;
    }

    public void initCodeRegister() {
        readOneByte();
        if (this.nBitsPending != 8) {
            throw new RuntimeException("Empty stream");
        }
        this.code <<= 8;
        readOneByte();
        this.code <<= 1;
        this.nBitsPending -= 9;
    }

    public void readOneByte() {
        if (this._in.hasRemaining()) {
            this.code = (this._in.get() & ExifInterface.MARKER) | this.code;
            this.nBitsPending += 8;
        }
    }
}
