package org.jcodec.codecs.mpeg12.bitstream;

import java.nio.ByteBuffer;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.BitWriter;
import org.jcodec.common.model.TapeTimecode;

/* loaded from: classes2.dex */
public class GOPHeader implements MPEGHeader {
    private boolean brokenLink;
    private boolean closedGop;
    private TapeTimecode timeCode;

    public GOPHeader(TapeTimecode tapeTimecode, boolean z, boolean z2) {
        this.timeCode = tapeTimecode;
        this.closedGop = z;
        this.brokenLink = z2;
    }

    public static GOPHeader read(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        boolean z = bitReaderCreateBitReader.read1Bit() == 1;
        short nBit = (short) bitReaderCreateBitReader.readNBit(5);
        byte nBit2 = (byte) bitReaderCreateBitReader.readNBit(6);
        bitReaderCreateBitReader.skip(1);
        return new GOPHeader(new TapeTimecode(nBit, nBit2, (byte) bitReaderCreateBitReader.readNBit(6), (byte) bitReaderCreateBitReader.readNBit(6), z, 0), bitReaderCreateBitReader.read1Bit() == 1, bitReaderCreateBitReader.read1Bit() == 1);
    }

    public TapeTimecode getTimeCode() {
        return this.timeCode;
    }

    public boolean isBrokenLink() {
        return this.brokenLink;
    }

    public boolean isClosedGop() {
        return this.closedGop;
    }

    @Override // org.jcodec.codecs.mpeg12.bitstream.MPEGHeader
    public void write(ByteBuffer byteBuffer) {
        BitWriter bitWriter = new BitWriter(byteBuffer);
        TapeTimecode tapeTimecode = this.timeCode;
        if (tapeTimecode == null) {
            bitWriter.writeNBit(0, 25);
        } else {
            bitWriter.write1Bit(tapeTimecode.isDropFrame() ? 1 : 0);
            bitWriter.writeNBit(this.timeCode.getHour(), 5);
            bitWriter.writeNBit(this.timeCode.getMinute(), 6);
            bitWriter.write1Bit(1);
            bitWriter.writeNBit(this.timeCode.getSecond(), 6);
            bitWriter.writeNBit(this.timeCode.getFrame(), 6);
        }
        bitWriter.write1Bit(this.closedGop ? 1 : 0);
        bitWriter.write1Bit(this.brokenLink ? 1 : 0);
        bitWriter.flush();
    }
}
