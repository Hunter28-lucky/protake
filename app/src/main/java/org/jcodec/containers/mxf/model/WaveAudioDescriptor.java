package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class WaveAudioDescriptor extends GenericSoundEssenceDescriptor {
    private int avgBps;
    private short blockAlign;
    private UL channelAssignment;
    private int peakChannels;
    private int peakEnvelopeBlockSize;
    private ByteBuffer peakEnvelopeData;
    private int peakEnvelopeFormat;
    private ByteBuffer peakEnvelopeTimestamp;
    private int peakEnvelopeVersion;
    private int peakFrames;
    private ByteBuffer peakOfPeaksPosition;
    private int pointsPerPeakValue;
    private byte sequenceOffset;

    public WaveAudioDescriptor(UL ul) {
        super(ul);
    }

    public int getAvgBps() {
        return this.avgBps;
    }

    public short getBlockAlign() {
        return this.blockAlign;
    }

    public UL getChannelAssignment() {
        return this.channelAssignment;
    }

    public int getPeakChannels() {
        return this.peakChannels;
    }

    public int getPeakEnvelopeBlockSize() {
        return this.peakEnvelopeBlockSize;
    }

    public ByteBuffer getPeakEnvelopeData() {
        return this.peakEnvelopeData;
    }

    public int getPeakEnvelopeFormat() {
        return this.peakEnvelopeFormat;
    }

    public ByteBuffer getPeakEnvelopeTimestamp() {
        return this.peakEnvelopeTimestamp;
    }

    public int getPeakEnvelopeVersion() {
        return this.peakEnvelopeVersion;
    }

    public int getPeakFrames() {
        return this.peakFrames;
    }

    public ByteBuffer getPeakOfPeaksPosition() {
        return this.peakOfPeaksPosition;
    }

    public int getPointsPerPeakValue() {
        return this.pointsPerPeakValue;
    }

    public byte getSequenceOffset() {
        return this.sequenceOffset;
    }

    @Override // org.jcodec.containers.mxf.model.GenericSoundEssenceDescriptor, org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            switch (iIntValue) {
                case 15625:
                    this.avgBps = value.getInt();
                    it.remove();
                    break;
                case 15626:
                    this.blockAlign = value.getShort();
                    it.remove();
                    break;
                case 15627:
                    this.sequenceOffset = value.get();
                    it.remove();
                    break;
                default:
                    switch (iIntValue) {
                        case 15657:
                            this.peakEnvelopeVersion = value.getInt();
                            break;
                        case 15658:
                            this.peakEnvelopeFormat = value.getInt();
                            break;
                        case 15659:
                            this.pointsPerPeakValue = value.getInt();
                            break;
                        case 15660:
                            this.peakEnvelopeBlockSize = value.getInt();
                            break;
                        case 15661:
                            this.peakChannels = value.getInt();
                            break;
                        case 15662:
                            this.peakFrames = value.getInt();
                            break;
                        case 15663:
                            this.peakOfPeaksPosition = value;
                            break;
                        case 15664:
                            this.peakEnvelopeTimestamp = value;
                            break;
                        case 15665:
                            this.peakEnvelopeData = value;
                            break;
                        case 15666:
                            this.channelAssignment = UL.read(value);
                            break;
                        default:
                            System.out.println(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                            continue;
                    }
                    it.remove();
                    break;
            }
        }
    }
}
