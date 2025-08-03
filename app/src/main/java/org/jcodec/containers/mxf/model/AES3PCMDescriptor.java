package org.jcodec.containers.mxf.model;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import org.jcodec.common.logging.Logger;

/* loaded from: classes2.dex */
public class AES3PCMDescriptor extends WaveAudioDescriptor {
    private byte auxBitsMode;
    private short blockStartOffset;
    private ByteBuffer channelStatusMode;
    private byte emphasis;
    private ByteBuffer fixedChannelStatusData;
    private ByteBuffer fixedUserData;
    private ByteBuffer userDataMode;

    public AES3PCMDescriptor(UL ul) {
        super(ul);
    }

    public byte getAuxBitsMode() {
        return this.auxBitsMode;
    }

    public short getBlockStartOffset() {
        return this.blockStartOffset;
    }

    public ByteBuffer getChannelStatusMode() {
        return this.channelStatusMode;
    }

    public byte getEmphasis() {
        return this.emphasis;
    }

    public ByteBuffer getFixedChannelStatusData() {
        return this.fixedChannelStatusData;
    }

    public ByteBuffer getFixedUserData() {
        return this.fixedUserData;
    }

    public ByteBuffer getUserDataMode() {
        return this.userDataMode;
    }

    @Override // org.jcodec.containers.mxf.model.WaveAudioDescriptor, org.jcodec.containers.mxf.model.GenericSoundEssenceDescriptor, org.jcodec.containers.mxf.model.FileDescriptor, org.jcodec.containers.mxf.model.GenericDescriptor, org.jcodec.containers.mxf.model.MXFInterchangeObject
    public void read(Map<Integer, ByteBuffer> map) {
        super.read(map);
        Iterator<Map.Entry<Integer, ByteBuffer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ByteBuffer> next = it.next();
            ByteBuffer value = next.getValue();
            int iIntValue = next.getKey().intValue();
            if (iIntValue == 15624) {
                this.auxBitsMode = value.get();
            } else if (iIntValue != 15629) {
                switch (iIntValue) {
                    case 15631:
                        this.blockStartOffset = value.getShort();
                        break;
                    case 15632:
                        this.channelStatusMode = value;
                        break;
                    case 15633:
                        this.fixedChannelStatusData = value;
                        break;
                    case 15634:
                        this.userDataMode = value;
                        break;
                    case 15635:
                        this.fixedUserData = value;
                        break;
                    default:
                        Logger.warn(String.format("Unknown tag [ " + this.ul + "]: %04x", next.getKey()));
                        continue;
                }
            } else {
                this.emphasis = value.get();
            }
            it.remove();
        }
    }
}
