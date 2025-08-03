package net.sourceforge.jaad.aac;

/* loaded from: classes2.dex */
public class SampleBuffer {
    private double bitrate;
    private double encodedBitrate;
    private double length;
    private byte[] data = new byte[0];
    private int sampleRate = 0;
    private int channels = 0;
    private int bitsPerSample = 0;
    private boolean bigEndian = true;

    public double getBitrate() {
        return this.bitrate;
    }

    public int getBitsPerSample() {
        return this.bitsPerSample;
    }

    public int getChannels() {
        return this.channels;
    }

    public byte[] getData() {
        return this.data;
    }

    public double getEncodedBitrate() {
        return this.encodedBitrate;
    }

    public double getLength() {
        return this.length;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public void setBigEndian(boolean z) {
        if (z == this.bigEndian) {
            return;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                this.bigEndian = z;
                return;
            }
            byte b = bArr[i];
            int i2 = i + 1;
            bArr[i] = bArr[i2];
            bArr[i2] = b;
            i += 2;
        }
    }

    public void setData(byte[] bArr, int i, int i2, int i3, int i4) {
        this.data = bArr;
        this.sampleRate = i;
        this.channels = i2;
        this.bitsPerSample = i3;
        if (i == 0) {
            this.length = 0.0d;
            this.bitrate = 0.0d;
            this.encodedBitrate = 0.0d;
        } else {
            double length = (bArr.length / ((i3 / 8) * i2)) / i;
            this.length = length;
            this.bitrate = ((r5 * i3) * i2) / length;
            this.encodedBitrate = i4 / length;
        }
    }
}
