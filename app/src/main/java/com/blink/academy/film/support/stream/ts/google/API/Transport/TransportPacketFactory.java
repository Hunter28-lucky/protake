package com.blink.academy.film.support.stream.ts.google.API.Transport;

import com.blink.academy.film.support.stream.ts.google.API.BitOutputStream;
import com.blink.academy.film.support.stream.ts.google.Core.MPEGTransportPacketImpl;

/* loaded from: classes.dex */
public class TransportPacketFactory {
    public static TransportPacket createEmptyPCRPacket(int i, long j, long j2) {
        MPEGTransportPacketImpl mPEGTransportPacketImpl = new MPEGTransportPacketImpl();
        mPEGTransportPacketImpl.setSyncByte(71);
        mPEGTransportPacketImpl.setTransportErrorIndicator(0);
        mPEGTransportPacketImpl.setPayloadUnitStartIndicator(0);
        mPEGTransportPacketImpl.setTransportPriority(0);
        mPEGTransportPacketImpl.setPID(i);
        mPEGTransportPacketImpl.setTransportScramblingControl(0);
        mPEGTransportPacketImpl.setAdaptationFieldControl(2);
        BitOutputStream bitOutputStream = new BitOutputStream(56);
        bitOutputStream.writeFromLSB(7, 8);
        bitOutputStream.writeFromLSB((byte) ((j >> 25) & 255), 8);
        bitOutputStream.writeFromLSB((byte) ((j >> 17) & 255), 8);
        bitOutputStream.writeFromLSB((byte) ((j >> 9) & 255), 8);
        bitOutputStream.writeFromLSB((byte) ((j >> 1) & 255), 8);
        bitOutputStream.writeFromLSB((byte) (j & 1), 1);
        bitOutputStream.writeFromLSB(0, 6);
        bitOutputStream.writeFromLSB((byte) ((j2 >> 1) & 255), 8);
        bitOutputStream.writeFromLSB((byte) (j2 & 1), 1);
        mPEGTransportPacketImpl.setAdaptationFieldByte(bitOutputStream.toByteArray());
        return mPEGTransportPacketImpl;
    }

    public static TransportPacket createMPEGNullPacket() {
        MPEGTransportPacketImpl mPEGTransportPacketImpl = new MPEGTransportPacketImpl();
        mPEGTransportPacketImpl.setSyncByte(71);
        mPEGTransportPacketImpl.setPayloadUnitStartIndicator(0);
        mPEGTransportPacketImpl.setPID(8191);
        mPEGTransportPacketImpl.setTransportScramblingControl(0);
        mPEGTransportPacketImpl.setAdaptationFieldControl(1);
        return mPEGTransportPacketImpl;
    }

    public static TransportPacket createMPEGPacket(int i) {
        MPEGTransportPacketImpl mPEGTransportPacketImpl = new MPEGTransportPacketImpl();
        mPEGTransportPacketImpl.setSyncByte(71);
        mPEGTransportPacketImpl.setTransportErrorIndicator(0);
        mPEGTransportPacketImpl.setPayloadUnitStartIndicator(0);
        mPEGTransportPacketImpl.setTransportPriority(0);
        mPEGTransportPacketImpl.setPID(i);
        mPEGTransportPacketImpl.setTransportScramblingControl(0);
        mPEGTransportPacketImpl.setAdaptationFieldControl(1);
        mPEGTransportPacketImpl.setContinuityCounter(0);
        return mPEGTransportPacketImpl;
    }

    public static TransportPacket createMPEGStartPacket(int i) {
        TransportPacket transportPacketCreateMPEGPacket = createMPEGPacket(i);
        transportPacketCreateMPEGPacket.setPayloadUnitStartIndicator(1);
        return transportPacketCreateMPEGPacket;
    }
}
