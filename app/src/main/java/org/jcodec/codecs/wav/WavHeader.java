package org.jcodec.codecs.wav;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import org.jcodec.api.UnhandledStateException;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.JCodecUtil2;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.model.ChannelLabel;

/* loaded from: classes2.dex */
public class WavHeader {
    public static final int WAV_HEADER_SIZE = 44;
    public static ChannelLabel[] mapping;
    public String chunkId;
    public int chunkSize;
    public int dataOffset;
    public long dataSize;
    public FmtChunk fmt;
    public String format;

    public static class FmtChunk {
        public short audioFormat;
        public short bitsPerSample;
        public short blockAlign;
        public int byteRate;
        public short numChannels;
        public int sampleRate;

        public FmtChunk(short s, short s2, int i, int i2, short s3, short s4) {
            this.audioFormat = s;
            this.numChannels = s2;
            this.sampleRate = i;
            this.byteRate = i2;
            this.blockAlign = s3;
            this.bitsPerSample = s4;
        }

        public static FmtChunk get(ByteBuffer byteBuffer) throws IOException {
            ByteOrder byteOrderOrder = byteBuffer.order();
            try {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                return new FmtChunk(byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getInt(), byteBuffer.getInt(), byteBuffer.getShort(), byteBuffer.getShort());
            } finally {
                byteBuffer.order(byteOrderOrder);
            }
        }

        public void put(ByteBuffer byteBuffer) throws IOException {
            ByteOrder byteOrderOrder = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort(this.audioFormat);
            byteBuffer.putShort(this.numChannels);
            byteBuffer.putInt(this.sampleRate);
            byteBuffer.putInt(this.byteRate);
            byteBuffer.putShort(this.blockAlign);
            byteBuffer.putShort(this.bitsPerSample);
            byteBuffer.order(byteOrderOrder);
        }

        public int size() {
            return 16;
        }
    }

    public static class FmtChunkExtended extends FmtChunk {
        public short bitsPerCodedSample;
        public short cbSize;
        public int channelLayout;
        public int guid;

        public FmtChunkExtended(FmtChunk fmtChunk, short s, short s2, int i, int i2) {
            super(fmtChunk.audioFormat, fmtChunk.numChannels, fmtChunk.sampleRate, fmtChunk.byteRate, fmtChunk.blockAlign, fmtChunk.bitsPerSample);
            this.cbSize = s;
            this.bitsPerCodedSample = s2;
            this.channelLayout = i;
            this.guid = i2;
        }

        public static FmtChunk read(ByteBuffer byteBuffer) throws IOException {
            FmtChunk fmtChunk = FmtChunk.get(byteBuffer);
            ByteOrder byteOrderOrder = byteBuffer.order();
            try {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                return new FmtChunkExtended(fmtChunk, byteBuffer.getShort(), byteBuffer.getShort(), byteBuffer.getInt(), byteBuffer.getInt());
            } finally {
                byteBuffer.order(byteOrderOrder);
            }
        }

        public ChannelLabel[] getLabels() {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                ChannelLabel[] channelLabelArr = WavHeader.mapping;
                if (i >= channelLabelArr.length) {
                    return (ChannelLabel[]) arrayList.toArray(new ChannelLabel[0]);
                }
                if ((this.channelLayout & (1 << i)) != 0) {
                    arrayList.add(channelLabelArr[i]);
                }
                i++;
            }
        }

        @Override // org.jcodec.codecs.wav.WavHeader.FmtChunk
        public void put(ByteBuffer byteBuffer) throws IOException {
            super.put(byteBuffer);
            ByteOrder byteOrderOrder = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.putShort(this.cbSize);
            byteBuffer.putShort(this.bitsPerCodedSample);
            byteBuffer.putInt(this.channelLayout);
            byteBuffer.putInt(this.guid);
            byteBuffer.order(byteOrderOrder);
        }

        @Override // org.jcodec.codecs.wav.WavHeader.FmtChunk
        public int size() {
            return super.size() + 12;
        }
    }

    static {
        ChannelLabel channelLabel = ChannelLabel.FRONT_LEFT;
        ChannelLabel channelLabel2 = ChannelLabel.FRONT_RIGHT;
        ChannelLabel channelLabel3 = ChannelLabel.CENTER;
        ChannelLabel channelLabel4 = ChannelLabel.REAR_LEFT;
        ChannelLabel channelLabel5 = ChannelLabel.REAR_RIGHT;
        ChannelLabel channelLabel6 = ChannelLabel.REAR_CENTER;
        mapping = new ChannelLabel[]{channelLabel, channelLabel2, channelLabel3, ChannelLabel.LFE, channelLabel4, channelLabel5, ChannelLabel.FRONT_CENTER_LEFT, ChannelLabel.FRONT_CENTER_RIGHT, channelLabel6, ChannelLabel.SIDE_LEFT, ChannelLabel.SIDE_RIGHT, channelLabel3, channelLabel, channelLabel3, channelLabel2, channelLabel4, channelLabel6, channelLabel5, ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
    }

    public WavHeader(String str, int i, String str2, FmtChunk fmtChunk, int i2, long j) {
        this.chunkId = str;
        this.chunkSize = i;
        this.format = str2;
        this.fmt = fmtChunk;
        this.dataOffset = i2;
        this.dataSize = j;
    }

    public static long calcDataSize(int i, int i2, long j) {
        return j * i * i2;
    }

    private static FmtChunk copyFmt(FmtChunk fmtChunk) {
        if (!(fmtChunk instanceof FmtChunkExtended)) {
            return new FmtChunk(fmtChunk.audioFormat, fmtChunk.numChannels, fmtChunk.sampleRate, fmtChunk.byteRate, fmtChunk.blockAlign, fmtChunk.bitsPerSample);
        }
        FmtChunkExtended fmtChunkExtended = (FmtChunkExtended) fmtChunk;
        return new FmtChunkExtended(fmtChunkExtended, fmtChunkExtended.cbSize, fmtChunkExtended.bitsPerCodedSample, fmtChunkExtended.channelLayout, fmtChunkExtended.guid);
    }

    public static WavHeader copyWithChannels(WavHeader wavHeader, int i) {
        WavHeader wavHeader2 = new WavHeader(wavHeader.chunkId, wavHeader.chunkSize, wavHeader.format, copyFmt(wavHeader.fmt), wavHeader.dataOffset, wavHeader.dataSize);
        wavHeader2.fmt.numChannels = (short) i;
        return wavHeader2;
    }

    public static WavHeader copyWithRate(WavHeader wavHeader, int i) {
        WavHeader wavHeader2 = new WavHeader(wavHeader.chunkId, wavHeader.chunkSize, wavHeader.format, copyFmt(wavHeader.fmt), wavHeader.dataOffset, wavHeader.dataSize);
        wavHeader2.fmt.sampleRate = i;
        return wavHeader2;
    }

    public static WavHeader create(AudioFormat audioFormat, int i) {
        WavHeader wavHeaderEmptyWavHeader = emptyWavHeader();
        wavHeaderEmptyWavHeader.dataSize = i;
        newFmtChunk();
        int sampleSizeInBits = audioFormat.getSampleSizeInBits();
        int i2 = sampleSizeInBits / 8;
        audioFormat.getSampleRate();
        FmtChunk fmtChunk = wavHeaderEmptyWavHeader.fmt;
        fmtChunk.bitsPerSample = (short) sampleSizeInBits;
        fmtChunk.blockAlign = audioFormat.getFrameSize();
        wavHeaderEmptyWavHeader.fmt.byteRate = audioFormat.getFrameRate() * audioFormat.getFrameSize();
        wavHeaderEmptyWavHeader.fmt.numChannels = (short) audioFormat.getChannels();
        wavHeaderEmptyWavHeader.fmt.sampleRate = audioFormat.getSampleRate();
        return wavHeaderEmptyWavHeader;
    }

    public static WavHeader createWavHeader(AudioFormat audioFormat, int i) {
        return new WavHeader("RIFF", 40, "WAVE", new FmtChunk((short) 1, (short) audioFormat.getChannels(), audioFormat.getSampleRate(), audioFormat.getSampleRate() * audioFormat.getChannels() * (audioFormat.getSampleSizeInBits() >> 3), (short) (audioFormat.getChannels() * (audioFormat.getSampleSizeInBits() >> 3)), (short) audioFormat.getSampleSizeInBits()), 44, calcDataSize(audioFormat.getChannels(), audioFormat.getSampleSizeInBits() >> 3, i));
    }

    public static WavHeader emptyWavHeader() {
        return new WavHeader("RIFF", 40, "WAVE", newFmtChunk(), 44, 0L);
    }

    public static WavHeader mono48k(long j) {
        return new WavHeader("RIFF", 40, "WAVE", new FmtChunk((short) 1, (short) 1, 48000, 96000, (short) 2, (short) 16), 44, calcDataSize(1, 2, j));
    }

    public static WavHeader multiChannelWav(WavHeader[] wavHeaderArr) {
        WavHeader wavHeaderEmptyWavHeader = emptyWavHeader();
        int i = 0;
        for (WavHeader wavHeader : wavHeaderArr) {
            i = (int) (i + wavHeader.dataSize);
        }
        wavHeaderEmptyWavHeader.dataSize = i;
        FmtChunk fmtChunk = wavHeaderArr[0].fmt;
        short s = fmtChunk.bitsPerSample;
        int i2 = s / 8;
        int i3 = fmtChunk.sampleRate;
        FmtChunk fmtChunk2 = wavHeaderEmptyWavHeader.fmt;
        fmtChunk2.bitsPerSample = s;
        fmtChunk2.blockAlign = (short) (wavHeaderArr.length * i2);
        fmtChunk2.byteRate = wavHeaderArr.length * i2 * i3;
        fmtChunk2.numChannels = (short) wavHeaderArr.length;
        fmtChunk2.sampleRate = i3;
        return wavHeaderEmptyWavHeader;
    }

    public static WavHeader multiChannelWavFromFiles(File[] fileArr) throws IOException {
        WavHeader[] wavHeaderArr = new WavHeader[fileArr.length];
        for (int i = 0; i < fileArr.length; i++) {
            wavHeaderArr[i] = read(fileArr[i]);
        }
        return multiChannelWav(wavHeaderArr);
    }

    private static FmtChunk newFmtChunk() {
        return new FmtChunk((short) 1, (short) 0, 0, 0, (short) 0, (short) 0);
    }

    public static WavHeader read(File file) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        try {
            fileChannelWrapper = NIOUtils.readableChannel(file);
        } catch (Throwable th) {
            th = th;
            fileChannelWrapper = null;
        }
        try {
            WavHeader channel = readChannel(fileChannelWrapper);
            IOUtils.closeQuietly(fileChannelWrapper);
            return channel;
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(fileChannelWrapper);
            throw th;
        }
    }

    public static WavHeader readChannel(ReadableByteChannel readableByteChannel) throws IOException {
        String string;
        int i;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        readableByteChannel.read(byteBufferAllocate);
        if (byteBufferAllocate.remaining() > 0) {
            throw new IOException("Incomplete wav header found");
        }
        byteBufferAllocate.flip();
        String string2 = NIOUtils.readString(byteBufferAllocate, 4);
        int i2 = byteBufferAllocate.getInt();
        String string3 = NIOUtils.readString(byteBufferAllocate, 4);
        FmtChunk fmtChunk = null;
        if (!"RIFF".equals(string2) || !"WAVE".equals(string3)) {
            return null;
        }
        do {
            string = NIOUtils.readString(byteBufferAllocate, 4);
            i = byteBufferAllocate.getInt();
            if (!"fmt ".equals(string) || i < 14 || i > 1048576) {
                if (!"data".equals(string)) {
                    NIOUtils.skip(byteBufferAllocate, i);
                }
            } else if (i == 16) {
                fmtChunk = FmtChunk.get(byteBufferAllocate);
            } else if (i == 18) {
                fmtChunk = FmtChunk.get(byteBufferAllocate);
                NIOUtils.skip(byteBufferAllocate, 2);
            } else if (i == 28) {
                fmtChunk = FmtChunk.get(byteBufferAllocate);
            } else {
                if (i != 40) {
                    throw new UnhandledStateException("Don't know how to handle fmt size: " + i);
                }
                fmtChunk = FmtChunk.get(byteBufferAllocate);
                NIOUtils.skip(byteBufferAllocate, 12);
            }
        } while (!"data".equals(string));
        return new WavHeader(string2, i2, string3, fmtChunk, byteBufferAllocate.position(), i);
    }

    public static WavHeader stereo48k() {
        return stereo48kWithSamples(0L);
    }

    public static WavHeader stereo48kWithSamples(long j) {
        return new WavHeader("RIFF", 40, "WAVE", new FmtChunk((short) 1, (short) 2, 48000, 192000, (short) 4, (short) 16), 44, calcDataSize(2, 2, j));
    }

    public ChannelLabel[] getChannelLabels() {
        FmtChunk fmtChunk = this.fmt;
        if (fmtChunk instanceof FmtChunkExtended) {
            return ((FmtChunkExtended) fmtChunk).getLabels();
        }
        int i = fmtChunk.numChannels;
        switch (i) {
            case 1:
                return new ChannelLabel[]{ChannelLabel.MONO};
            case 2:
                return new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
            case 3:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_CENTER};
            case 4:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            case 5:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            case 6:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
            case 7:
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.REAR_CENTER};
            case 8:
                ChannelLabel channelLabel = ChannelLabel.REAR_LEFT;
                ChannelLabel channelLabel2 = ChannelLabel.REAR_RIGHT;
                return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE, channelLabel, channelLabel2, channelLabel, channelLabel2};
            default:
                ChannelLabel[] channelLabelArr = new ChannelLabel[i];
                Arrays.fill(channelLabelArr, ChannelLabel.MONO);
                return channelLabelArr;
        }
    }

    public AudioFormat getFormat() {
        FmtChunk fmtChunk = this.fmt;
        return new AudioFormat(fmtChunk.sampleRate, fmtChunk.bitsPerSample, fmtChunk.numChannels, true, false);
    }

    public void write(WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(44);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        long j = this.dataSize;
        long j2 = j <= 4294967295L ? j + 36 : 40L;
        byteBufferAllocate.put(JCodecUtil2.asciiString("RIFF"));
        byteBufferAllocate.putInt((int) j2);
        byteBufferAllocate.put(JCodecUtil2.asciiString("WAVE"));
        byteBufferAllocate.put(JCodecUtil2.asciiString("fmt "));
        byteBufferAllocate.putInt(this.fmt.size());
        this.fmt.put(byteBufferAllocate);
        byteBufferAllocate.put(JCodecUtil2.asciiString("data"));
        long j3 = this.dataSize;
        if (j3 <= 4294967295L) {
            byteBufferAllocate.putInt((int) j3);
        } else {
            byteBufferAllocate.putInt(0);
        }
        byteBufferAllocate.flip();
        writableByteChannel.write(byteBufferAllocate);
    }
}
