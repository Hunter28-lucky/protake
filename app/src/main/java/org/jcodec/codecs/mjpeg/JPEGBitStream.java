package org.jcodec.codecs.mjpeg;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

/* loaded from: classes2.dex */
public class JPEGBitStream {
    private BitReader _in;
    private int[] dcPredictor = new int[3];
    private VLC[] huff;
    private int lumaLen;

    public JPEGBitStream(ByteBuffer byteBuffer, VLC[] vlcArr, int i) {
        this._in = BitReader.createBitReader(byteBuffer);
        this.huff = vlcArr;
        this.lumaLen = i;
    }

    public void readACValues(int[] iArr, VLC vlc) {
        int i = 1;
        do {
            int vlc2 = vlc.readVLC(this._in);
            if (vlc2 == 240) {
                i += 16;
            } else if (vlc2 > 0) {
                int i2 = i + (vlc2 >> 4);
                int i3 = vlc2 & 15;
                iArr[i2] = toValue(this._in.readNBit(i3), i3);
                i = i2 + 1;
            }
            if (vlc2 == 0) {
                return;
            }
        } while (i < 64);
    }

    public int readDCValue(int i, VLC vlc) {
        int vlc2 = vlc.readVLC(this._in);
        return vlc2 != 0 ? i + toValue(this._in.readNBit(vlc2), vlc2) : i;
    }

    public void readMCU(int[][] iArr) {
        int i = 0;
        int i2 = 0;
        while (i < this.lumaLen) {
            int[] iArr2 = this.dcPredictor;
            int[] iArr3 = iArr[i2];
            int dCValue = readDCValue(iArr2[0], this.huff[0]);
            iArr3[0] = dCValue;
            iArr2[0] = dCValue;
            readACValues(iArr[i2], this.huff[2]);
            i++;
            i2++;
        }
        int[] iArr4 = this.dcPredictor;
        int[] iArr5 = iArr[i2];
        int dCValue2 = readDCValue(iArr4[1], this.huff[1]);
        iArr5[0] = dCValue2;
        iArr4[1] = dCValue2;
        readACValues(iArr[i2], this.huff[3]);
        int i3 = i2 + 1;
        int[] iArr6 = this.dcPredictor;
        int[] iArr7 = iArr[i3];
        int dCValue3 = readDCValue(iArr6[2], this.huff[1]);
        iArr7[0] = dCValue3;
        iArr6[2] = dCValue3;
        readACValues(iArr[i3], this.huff[3]);
    }

    public final int toValue(int i, int i2) {
        return (i2 < 1 || i >= (1 << (i2 + (-1)))) ? i : i + (-(1 << i2)) + 1;
    }
}
