package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Rational;

/* loaded from: classes2.dex */
public class GenericSoundEssenceDescriptor extends FileDescriptor {
    private byte audioRefLevel;
    private Rational audioSamplingRate;
    private int channelCount;
    private byte dialNorm;
    private byte electroSpatialFormulation;
    private byte locked;
    private int quantizationBits;
    private UL soundEssenceCompression;

    public GenericSoundEssenceDescriptor(UL ul) {
        super(ul);
    }

    public byte getAudioRefLevel() {
        return this.audioRefLevel;
    }

    public Rational getAudioSamplingRate() {
        return this.audioSamplingRate;
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    public byte getDialNorm() {
        return this.dialNorm;
    }

    public byte getElectroSpatialFormulation() {
        return this.electroSpatialFormulation;
    }

    public byte getLocked() {
        return this.locked;
    }

    public int getQuantizationBits() {
        return this.quantizationBits;
    }

    public UL getSoundEssenceCompression() {
        return this.soundEssenceCompression;
    }

    @Override // org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue != 15628) {
                switch (iIntValue) {
                    case 15617:
                        this.quantizationBits = value.getInt();
                        break;
                    case 15618:
                        this.locked = value.get();
                        break;
                    case 15619:
                        this.audioSamplingRate = new Rational(value.getInt(), value.getInt());
                        break;
                    case 15620:
                        this.audioRefLevel = value.get();
                        break;
                    case 15621:
                        this.electroSpatialFormulation = value.get();
                        break;
                    case 15622:
                        this.soundEssenceCompression = UL.read(value);
                        break;
                    case 15623:
                        this.channelCount = value.getInt();
                        break;
                    default:
                        Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                        continue;
                }
            } else {
                this.dialNorm = value.get();
            }
            it.remove();
        }
    }
}
