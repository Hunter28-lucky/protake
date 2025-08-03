package org.jcodec.codecs.common.biari;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.jcodec.platform.BaseOutputStream;

/* loaded from: classes2.dex */
public class BitIO {

    public interface InputBits {
        int getBit() throws IOException;
    }

    public interface OutputBits {
        void flush() throws IOException;

        void putBit(int i) throws IOException;
    }

    public static class StreamInputBits implements InputBits {
        private InputStream _in;
        private int bit = 8;
        private int cur;

        public StreamInputBits(InputStream inputStream) {
            this._in = inputStream;
        }

        @Override // org.jcodec.codecs.common.biari.BitIO.InputBits
        public int getBit() throws IOException {
            if (this.bit > 7) {
                int i = this._in.read();
                this.cur = i;
                if (i == -1) {
                    return -1;
                }
                this.bit = 0;
            }
            int i2 = this.cur;
            int i3 = this.bit;
            this.bit = i3 + 1;
            return (i2 >> (7 - i3)) & 1;
        }
    }

    public static class StreamOutputBits implements OutputBits {
        private int bit;
        private int cur;
        private OutputStream out;

        public StreamOutputBits(OutputStream outputStream) {
            this.out = outputStream;
        }

        @Override // org.jcodec.codecs.common.biari.BitIO.OutputBits
        public void flush() throws IOException {
            if (this.bit > 0) {
                this.out.write(this.cur);
            }
        }

        @Override // org.jcodec.codecs.common.biari.BitIO.OutputBits
        public void putBit(int i) throws IOException {
            if (this.bit > 7) {
                this.out.write(this.cur);
                this.cur = 0;
                this.bit = 0;
            }
            int i2 = this.cur;
            int i3 = this.bit;
            this.bit = i3 + 1;
            this.cur = ((i & 1) << (7 - i3)) | i2;
        }
    }

    public static byte[] compressBits(int[] iArr) {
        byte[] bArr = new byte[(iArr.length >> 3) + 1];
        OutputBits outputBitsOutputFromArray = outputFromArray(bArr);
        for (int i : iArr) {
            try {
                outputBitsOutputFromArray.putBit(i);
            } catch (IOException unused) {
            }
        }
        return bArr;
    }

    public static int[] decompressBits(byte[] bArr) {
        int[] iArr = new int[bArr.length << 3];
        InputBits inputBitsInputFromArray = inputFromArray(bArr);
        int i = 0;
        while (true) {
            try {
                int bit = inputBitsInputFromArray.getBit();
                if (bit == -1) {
                    break;
                }
                iArr[i] = bit;
                i++;
            } catch (IOException unused) {
            }
        }
        return iArr;
    }

    public static InputBits inputFromArray(byte[] bArr) {
        return new StreamInputBits(new ByteArrayInputStream(bArr));
    }

    public static InputBits inputFromStream(InputStream inputStream) {
        return new StreamInputBits(inputStream);
    }

    public static OutputBits outputFromArray(final byte[] bArr) {
        return new StreamOutputBits(new BaseOutputStream() { // from class: org.jcodec.codecs.common.biari.BitIO.1
            public int ptr;

            @Override // org.jcodec.platform.BaseOutputStream
            public void writeByte(int i) throws IOException {
                int i2 = this.ptr;
                byte[] bArr2 = bArr;
                if (i2 >= bArr2.length) {
                    throw new IOException("Buffer is full");
                }
                this.ptr = i2 + 1;
                bArr2[i2] = (byte) i;
            }
        });
    }

    public static OutputBits outputFromStream(OutputStream outputStream) {
        return new StreamOutputBits(outputStream);
    }
}
