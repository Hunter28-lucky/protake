package net.sourceforge.jaad.aac.transport;

import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.PCE;

/* loaded from: classes2.dex */
public final class ADIFHeader {
    private static final long ADIF_ID = 1094994246;
    private int[] adifBufferFullness;
    private int bitrate;
    private boolean bitstreamType;
    private byte[] copyrightID = new byte[9];
    private boolean copyrightIDPresent;
    private boolean home;
    private long id;
    private boolean originalCopy;
    private int pceCount;
    private PCE[] pces;

    private ADIFHeader() {
    }

    private void decode(IBitStream iBitStream) throws AACException {
        this.id = iBitStream.readBits(32);
        boolean bool = iBitStream.readBool();
        this.copyrightIDPresent = bool;
        if (bool) {
            for (int i = 0; i < 9; i++) {
                this.copyrightID[i] = (byte) iBitStream.readBits(8);
            }
        }
        this.originalCopy = iBitStream.readBool();
        this.home = iBitStream.readBool();
        this.bitstreamType = iBitStream.readBool();
        this.bitrate = iBitStream.readBits(23);
        int bits = iBitStream.readBits(4) + 1;
        this.pceCount = bits;
        this.pces = new PCE[bits];
        this.adifBufferFullness = new int[bits];
        for (int i2 = 0; i2 < this.pceCount; i2++) {
            if (this.bitstreamType) {
                this.adifBufferFullness[i2] = -1;
            } else {
                this.adifBufferFullness[i2] = iBitStream.readBits(20);
            }
            this.pces[i2] = new PCE();
            this.pces[i2].decode(iBitStream);
        }
    }

    public static boolean isPresent(IBitStream iBitStream) throws AACException {
        return ((long) iBitStream.peekBits(32)) == ADIF_ID;
    }

    public static ADIFHeader readHeader(IBitStream iBitStream) throws AACException {
        ADIFHeader aDIFHeader = new ADIFHeader();
        aDIFHeader.decode(iBitStream);
        return aDIFHeader;
    }

    public PCE getFirstPCE() {
        return this.pces[0];
    }
}
