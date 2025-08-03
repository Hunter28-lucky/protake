package org.jcodec.codecs.aac.blocks;

import org.jcodec.codecs.aac.ChannelPosition;
import org.jcodec.common.io.BitReader;

/* loaded from: classes2.dex */
public class BlockPCE extends Block {
    private static final int MAX_ELEM_ID = 16;

    /* renamed from: org.jcodec.codecs.aac.blocks.BlockPCE$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jcodec$codecs$aac$ChannelPosition;

        static {
            int[] iArr = new int[ChannelPosition.values().length];
            $SwitchMap$org$jcodec$codecs$aac$ChannelPosition = iArr;
            try {
                iArr[ChannelPosition.AAC_CHANNEL_FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$aac$ChannelPosition[ChannelPosition.AAC_CHANNEL_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$aac$ChannelPosition[ChannelPosition.AAC_CHANNEL_SIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$aac$ChannelPosition[ChannelPosition.AAC_CHANNEL_CC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$aac$ChannelPosition[ChannelPosition.AAC_CHANNEL_LFE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static class ChannelMapping {
        public ChannelPosition position;
        public int someInt;
        public RawDataBlockType syn_ele;
    }

    private void decodeChannelMap(ChannelMapping[] channelMappingArr, int i, ChannelPosition channelPosition, BitReader bitReader, int i2) {
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            RawDataBlockType rawDataBlockType = null;
            int i4 = AnonymousClass1.$SwitchMap$org$jcodec$codecs$aac$ChannelPosition[channelPosition.ordinal()];
            if (i4 == 1 || i4 == 2 || i4 == 3) {
                rawDataBlockType = RawDataBlockType.values()[bitReader.read1Bit()];
            } else if (i4 == 4) {
                bitReader.read1Bit();
                rawDataBlockType = RawDataBlockType.TYPE_CCE;
            } else if (i4 == 5) {
                rawDataBlockType = RawDataBlockType.TYPE_LFE;
            }
            ChannelMapping channelMapping = channelMappingArr[i];
            channelMapping.syn_ele = rawDataBlockType;
            channelMapping.someInt = bitReader.readNBit(4);
            channelMappingArr[i].position = channelPosition;
            i++;
            i2 = i3;
        }
    }

    @Override // org.jcodec.codecs.aac.blocks.Block
    public void parse(BitReader bitReader) {
        bitReader.readNBit(2);
        bitReader.readNBit(4);
        int nBit = bitReader.readNBit(4);
        int nBit2 = bitReader.readNBit(4);
        int nBit3 = bitReader.readNBit(4);
        int nBit4 = bitReader.readNBit(2);
        int nBit5 = bitReader.readNBit(3);
        int nBit6 = bitReader.readNBit(4);
        if (bitReader.read1Bit() != 0) {
            bitReader.readNBit(4);
        }
        if (bitReader.read1Bit() != 0) {
            bitReader.readNBit(4);
        }
        if (bitReader.read1Bit() != 0) {
            bitReader.readNBit(3);
        }
        ChannelMapping[] channelMappingArr = new ChannelMapping[64];
        decodeChannelMap(channelMappingArr, 0, ChannelPosition.AAC_CHANNEL_FRONT, bitReader, nBit);
        decodeChannelMap(channelMappingArr, nBit, ChannelPosition.AAC_CHANNEL_SIDE, bitReader, nBit2);
        int i = nBit + nBit2;
        decodeChannelMap(channelMappingArr, i, ChannelPosition.AAC_CHANNEL_BACK, bitReader, nBit3);
        int i2 = i + nBit3;
        decodeChannelMap(channelMappingArr, i2, ChannelPosition.AAC_CHANNEL_LFE, bitReader, nBit4);
        bitReader.skip(nBit5 * 4);
        decodeChannelMap(channelMappingArr, i2 + nBit4, ChannelPosition.AAC_CHANNEL_CC, bitReader, nBit6);
        bitReader.align();
        bitReader.skip(bitReader.readNBit(8) * 8);
    }
}
