package org.jcodec.codecs.common.biari;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class MQDecoder {
    private int availableBits;
    private int decodedBytes;
    private InputStream is;
    private int lastByte;
    private int range = 32768;
    private int value = 0;

    public MQDecoder(InputStream inputStream) throws IOException {
        this.is = inputStream;
        fetchByte();
        this.value <<= 8;
        fetchByte();
        this.value <<= this.availableBits - 1;
        this.availableBits = 1;
    }

    private void fetchByte() throws IOException {
        this.availableBits = 8;
        if (this.decodedBytes > 0 && this.lastByte == 255) {
            this.availableBits = 7;
        }
        int i = this.is.read();
        this.lastByte = i;
        this.value += i << (8 - this.availableBits);
        this.decodedBytes++;
    }

    private void renormalize() throws IOException {
        this.value <<= 1;
        this.range = (this.range << 1) & 65535;
        int i = this.availableBits - 1;
        this.availableBits = i;
        if (i == 0) {
            fetchByte();
        }
    }

    public int decode(Context context) throws IOException {
        int i = MQConst.pLps[context.getState()];
        int i2 = this.value;
        if (i2 <= i) {
            this.range = i;
            while (this.range < 32768) {
                renormalize();
            }
            if (MQConst.mpsSwitch[context.getState()] != 0) {
                context.setMps(1 - context.getMps());
            }
            context.setState(MQConst.transitLPS[context.getState()]);
            return 1 - context.getMps();
        }
        int i3 = this.range - i;
        this.range = i3;
        this.value = i2 - i;
        if (i3 < 32768) {
            while (this.range < 32768) {
                renormalize();
            }
            context.setState(MQConst.transitMPS[context.getState()]);
        }
        return context.getMps();
    }
}
