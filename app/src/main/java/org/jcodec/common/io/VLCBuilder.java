package org.jcodec.common.io;

import org.jcodec.common.IntArrayList;
import org.jcodec.common.IntIntMap;

/* loaded from: classes2.dex */
public class VLCBuilder {
    private IntIntMap forward = new IntIntMap();
    private IntIntMap inverse = new IntIntMap();
    private IntArrayList codes = IntArrayList.createIntArrayList();
    private IntArrayList codesSizes = IntArrayList.createIntArrayList();

    public static VLCBuilder createVLCBuilder(int[] iArr, int[] iArr2, int[] iArr3) {
        VLCBuilder vLCBuilder = new VLCBuilder();
        for (int i = 0; i < iArr.length; i++) {
            vLCBuilder.setInt(iArr[i], iArr2[i], iArr3[i]);
        }
        return vLCBuilder;
    }

    public VLC getVLC() {
        return new VLC(this.codes.toArray(), this.codesSizes.toArray()) { // from class: org.jcodec.common.io.VLCBuilder.1
            @Override // org.jcodec.common.io.VLC
            public int readVLC(BitReader bitReader) {
                return this.inverse.get(super.readVLC(bitReader));
            }

            @Override // org.jcodec.common.io.VLC
            public int readVLC16(BitReader bitReader) {
                return this.inverse.get(super.readVLC16(bitReader));
            }

            @Override // org.jcodec.common.io.VLC
            public void writeVLC(BitWriter bitWriter, int i) {
                super.writeVLC(bitWriter, this.forward.get(i));
            }
        };
    }

    public VLCBuilder set(int i, String str) {
        setInt(Integer.parseInt(str, 2), str.length(), i);
        return this;
    }

    public VLCBuilder setInt(int i, int i2, int i3) {
        this.codes.add(i << (32 - i2));
        this.codesSizes.add(i2);
        this.forward.put(i3, this.codes.size() - 1);
        this.inverse.put(this.codes.size() - 1, i3);
        return this;
    }
}
