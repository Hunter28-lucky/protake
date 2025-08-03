package org.jcodec.codecs.aac;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class ADTSParser {

    public static class Header {
        private int chanConfig;
        private int crcAbsent;
        private int numAACFrames;
        private int objectType;
        private int samples;
        private int samplingIndex;
        private int size;

        public Header(int i, int i2, int i3, int i4, int i5, int i6) {
            this.objectType = i;
            this.chanConfig = i2;
            this.crcAbsent = i3;
            this.numAACFrames = i4;
            this.samplingIndex = i5;
            this.size = i6;
        }

        public int getChanConfig() {
            return this.chanConfig;
        }

        public int getCrcAbsent() {
            return this.crcAbsent;
        }

        public int getNumAACFrames() {
            return this.numAACFrames;
        }

        public int getObjectType() {
            return this.objectType;
        }

        public int getSampleRate() {
            return AACConts.AAC_SAMPLE_RATES[this.samplingIndex];
        }

        public int getSamples() {
            return this.samples;
        }

        public int getSamplingIndex() {
            return this.samplingIndex;
        }

        public int getSize() {
            return this.size;
        }
    }

    public static ByteBuffer adtsToStreamInfo(Header header) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        BitWriter bitWriter = new BitWriter(byteBufferAllocate);
        bitWriter.writeNBit(header.getObjectType(), 5);
        bitWriter.writeNBit(header.getSamplingIndex(), 4);
        bitWriter.writeNBit(header.getChanConfig(), 4);
        bitWriter.flush();
        byteBufferAllocate.clear();
        return byteBufferAllocate;
    }

    public static Header read(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBufferDuplicate);
        if (bitReaderCreateBitReader.readNBit(12) != 4095) {
            return null;
        }
        bitReaderCreateBitReader.read1Bit();
        bitReaderCreateBitReader.readNBit(2);
        int i = bitReaderCreateBitReader.read1Bit();
        int nBit = bitReaderCreateBitReader.readNBit(2);
        int nBit2 = bitReaderCreateBitReader.readNBit(4);
        bitReaderCreateBitReader.read1Bit();
        int nBit3 = bitReaderCreateBitReader.readNBit(3);
        bitReaderCreateBitReader.read1Bit();
        bitReaderCreateBitReader.read1Bit();
        bitReaderCreateBitReader.read1Bit();
        bitReaderCreateBitReader.read1Bit();
        int nBit4 = bitReaderCreateBitReader.readNBit(13);
        if (nBit4 < 7) {
            return null;
        }
        bitReaderCreateBitReader.readNBit(11);
        int nBit5 = bitReaderCreateBitReader.readNBit(2);
        bitReaderCreateBitReader.stop();
        byteBuffer.position(byteBufferDuplicate.position());
        return new Header(nBit + 1, nBit3, i, nBit5 + 1, nBit2, nBit4);
    }

    public static ByteBuffer write(Header header, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        BitWriter bitWriter = new BitWriter(byteBufferDuplicate);
        bitWriter.writeNBit(4095, 12);
        bitWriter.write1Bit(1);
        bitWriter.writeNBit(0, 2);
        bitWriter.write1Bit(header.getCrcAbsent());
        bitWriter.writeNBit(header.getObjectType() - 1, 2);
        bitWriter.writeNBit(header.getSamplingIndex(), 4);
        bitWriter.write1Bit(0);
        bitWriter.writeNBit(header.getChanConfig(), 3);
        bitWriter.write1Bit(0);
        bitWriter.write1Bit(0);
        bitWriter.write1Bit(0);
        bitWriter.write1Bit(0);
        bitWriter.writeNBit(header.getSize(), 13);
        bitWriter.writeNBit(0, 11);
        bitWriter.writeNBit(header.getNumAACFrames() - 1, 2);
        bitWriter.flush();
        byteBufferDuplicate.flip();
        return byteBufferDuplicate;
    }
}
