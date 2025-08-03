package net.sourceforge.jaad.aac.syntax;

import java.nio.ByteBuffer;
import net.sourceforge.jaad.aac.AACException;
import org.jcodec.common.io.BitReader;

/* loaded from: classes2.dex */
public class NIOBitStream implements IBitStream {
    private BitReader br;

    public NIOBitStream(BitReader bitReader) {
        this.br = bitReader;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void byteAlign() throws AACException {
        this.br.align();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void destroy() {
        reset();
        this.br = null;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int getBitsLeft() {
        return this.br.remaining();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int getPosition() {
        return this.br.position();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int maskBits(int i) {
        if (i == 32) {
            return -1;
        }
        return (1 << i) - 1;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int peekBit() throws AACException {
        return this.br.curBit();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int peekBits(int i) throws AACException {
        return this.br.checkNBit(i);
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int readBit() throws AACException {
        if (this.br.remaining() >= 1) {
            return this.br.read1Bit();
        }
        throw AACException.endOfStream();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public int readBits(int i) throws AACException {
        if (this.br.remaining() >= i) {
            return this.br.readNBit(i);
        }
        throw AACException.endOfStream();
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public boolean readBool() throws AACException {
        return readBit() != 0;
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void reset() {
        throw new RuntimeException("todo");
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void setData(byte[] bArr) {
        this.br = BitReader.createBitReader(ByteBuffer.wrap(bArr));
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void skipBit() throws AACException {
        skipBits(1);
    }

    @Override // net.sourceforge.jaad.aac.syntax.IBitStream
    public void skipBits(int i) throws AACException {
        this.br.skip(i);
    }
}
