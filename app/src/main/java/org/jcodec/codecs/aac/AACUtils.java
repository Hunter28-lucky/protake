package org.jcodec.codecs.aac;

import java.nio.ByteBuffer;
import org.jcodec.codecs.aac.ADTSParser;
import org.jcodec.codecs.mpeg4.mp4.EsdsBox;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.model.ChannelLabel;
import org.jcodec.containers.mp4.BoxUtil;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.containers.mp4.boxes.SampleEntry;

/* loaded from: classes2.dex */
public class AACUtils {
    private static ChannelLabel[][] AAC_DEFAULT_CONFIGS;

    public static class AACMetadata {
        private AudioFormat format;
        private ChannelLabel[] labels;

        public AACMetadata(AudioFormat audioFormat, ChannelLabel[] channelLabelArr) {
            this.format = audioFormat;
            this.labels = channelLabelArr;
        }

        public AudioFormat getFormat() {
            return this.format;
        }

        public ChannelLabel[] getLabels() {
            return this.labels;
        }
    }

    static {
        ChannelLabel[] channelLabelArr = {ChannelLabel.MONO};
        ChannelLabel[] channelLabelArr2 = {ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
        ChannelLabel channelLabel = ChannelLabel.CENTER;
        ChannelLabel channelLabel2 = ChannelLabel.FRONT_LEFT;
        ChannelLabel channelLabel3 = ChannelLabel.FRONT_RIGHT;
        ChannelLabel[] channelLabelArr3 = {channelLabel, channelLabel2, channelLabel3, ChannelLabel.REAR_CENTER};
        ChannelLabel channelLabel4 = ChannelLabel.REAR_LEFT;
        ChannelLabel channelLabel5 = ChannelLabel.REAR_RIGHT;
        ChannelLabel channelLabel6 = ChannelLabel.LFE;
        AAC_DEFAULT_CONFIGS = new ChannelLabel[][]{null, channelLabelArr, channelLabelArr2, new ChannelLabel[]{channelLabel, channelLabel2, channelLabel3}, channelLabelArr3, new ChannelLabel[]{channelLabel, channelLabel2, channelLabel3, channelLabel4, channelLabel5}, new ChannelLabel[]{channelLabel, channelLabel2, channelLabel3, channelLabel4, channelLabel5, channelLabel6}, new ChannelLabel[]{channelLabel, channelLabel2, channelLabel3, ChannelLabel.SIDE_LEFT, ChannelLabel.SIDE_RIGHT, channelLabel4, channelLabel5, channelLabel6}};
    }

    public static ByteBuffer getCodecPrivate(SampleEntry sampleEntry) {
        Box.LeafBox leafBox = (Box.LeafBox) NodeBox.findFirst(sampleEntry, Box.LeafBox.class, "esds");
        if (leafBox == null) {
            leafBox = (Box.LeafBox) NodeBox.findFirstPath(sampleEntry, Box.LeafBox.class, new String[]{null, "esds"});
        }
        if (leafBox == null) {
            return null;
        }
        return ((EsdsBox) BoxUtil.as(EsdsBox.class, leafBox)).getStreamInfo();
    }

    public static AACMetadata getMetadata(SampleEntry sampleEntry) {
        if (!"mp4a".equals(sampleEntry.getFourcc())) {
            throw new IllegalArgumentException("Not mp4a sample entry");
        }
        ByteBuffer codecPrivate = getCodecPrivate(sampleEntry);
        if (codecPrivate == null) {
            return null;
        }
        return parseAudioInfo(codecPrivate);
    }

    private static int getObjectType(BitReader bitReader) {
        int nBit = bitReader.readNBit(5);
        return nBit == ObjectType.AOT_ESCAPE.ordinal() ? bitReader.readNBit(6) + 32 : nBit;
    }

    public static AACMetadata parseAudioInfo(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        getObjectType(bitReaderCreateBitReader);
        int nBit = bitReaderCreateBitReader.readNBit(4);
        int nBit2 = nBit == 15 ? bitReaderCreateBitReader.readNBit(24) : AACConts.AAC_SAMPLE_RATES[nBit];
        int nBit3 = bitReaderCreateBitReader.readNBit(4);
        if (nBit3 == 0) {
            return null;
        }
        ChannelLabel[][] channelLabelArr = AAC_DEFAULT_CONFIGS;
        if (nBit3 >= channelLabelArr.length) {
            return null;
        }
        ChannelLabel[] channelLabelArr2 = channelLabelArr[nBit3];
        return new AACMetadata(new AudioFormat(nBit2, 16, channelLabelArr2.length, true, false), channelLabelArr2);
    }

    public static ADTSParser.Header streamInfoToADTS(ByteBuffer byteBuffer, boolean z, int i, int i2) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer.duplicate());
        int nBit = bitReaderCreateBitReader.readNBit(5);
        int nBit2 = bitReaderCreateBitReader.readNBit(4);
        return new ADTSParser.Header(nBit, bitReaderCreateBitReader.readNBit(4), z ? 1 : 0, i, nBit2, i2 + 7);
    }
}
