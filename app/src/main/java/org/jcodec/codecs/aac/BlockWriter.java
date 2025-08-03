package org.jcodec.codecs.aac;

import org.jcodec.codecs.aac.blocks.Block;
import org.jcodec.common.io.BitWriter;

/* loaded from: classes2.dex */
public class BlockWriter {
    public void nextBlock(BitWriter bitWriter, Block block) {
        bitWriter.writeNBit(block.getType().ordinal(), 3);
        block.getType();
        BlockType blockType = BlockType.TYPE_SCE;
    }
}
