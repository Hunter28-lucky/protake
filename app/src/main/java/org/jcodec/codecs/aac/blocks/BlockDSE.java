package org.jcodec.codecs.aac.blocks;

import org.jcodec.common.io.BitReader;

/* loaded from: classes2.dex */
public class BlockDSE extends Block {
    @Override // org.jcodec.codecs.aac.blocks.Block
    public void parse(BitReader bitReader) {
        bitReader.readNBit(4);
        int i = bitReader.read1Bit();
        int nBit = bitReader.readNBit(8);
        if (nBit == 255) {
            nBit += bitReader.readNBit(8);
        }
        if (i != 0) {
            bitReader.align();
        }
        int i2 = nBit * 8;
        if (bitReader.skip(i2) != i2) {
            throw new RuntimeException("Overread");
        }
    }
}
