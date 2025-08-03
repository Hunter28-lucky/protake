package org.jcodec.codecs.aac.blocks;

import org.jcodec.common.io.BitReader;

/* loaded from: classes2.dex */
public class BlockFil extends Block {
    @Override // org.jcodec.codecs.aac.blocks.Block
    public void parse(BitReader bitReader) {
        int nBit = bitReader.readNBit(4);
        if (nBit == 15) {
            nBit += bitReader.readNBit(8) - 1;
        }
        if (nBit > 0) {
            int i = nBit * 8;
            if (bitReader.skip(i) != i) {
                throw new RuntimeException("Overread");
            }
        }
    }
}
