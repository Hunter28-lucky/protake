package org.jcodec.codecs.aac.blocks;

import org.jcodec.common.io.BitReader;

/* loaded from: classes2.dex */
public class BlockCPE extends BlockICS {
    private int[] ms_mask;

    private void decodeMidSideStereo(BitReader bitReader, int i, int i2, int i3) {
        if (i == 1) {
            for (int i4 = 0; i4 < i2 * i3; i4++) {
                this.ms_mask[i4] = bitReader.read1Bit();
            }
        }
    }

    @Override // org.jcodec.codecs.aac.blocks.BlockICS, org.jcodec.codecs.aac.blocks.Block
    public void parse(BitReader bitReader) {
        if (bitReader.read1Bit() != 0) {
            parseICSInfo(bitReader);
            int nBit = bitReader.readNBit(2);
            if (nBit == 3) {
                throw new RuntimeException("ms_present = 3 is reserved.");
            }
            if (nBit != 0) {
                decodeMidSideStereo(bitReader, nBit, 0, 0);
            }
        }
        new BlockICS().parse(bitReader);
        new BlockICS().parse(bitReader);
    }
}
