package org.jcodec.codecs.aac.blocks;

import org.jcodec.codecs.aac.BlockType;
import org.jcodec.codecs.aac.blocks.BlockICS;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.VLC;

/* loaded from: classes2.dex */
public class BlockCCE extends Block {
    public static VLC vlc = new VLC(AACTab.ff_aac_scalefactor_code, AACTab.ff_aac_scalefactor_bits);
    private BlockICS.BandType[] bandType;
    private BlockICS blockICS;
    private Object[] cce_scale;
    private int[] ch_select;
    private int coupling_point;
    private int[] id_select;
    private int num_coupled;
    private Object scale;
    private int sign;
    private BlockType[] type;

    public enum CouplingPoint {
        BEFORE_TNS,
        BETWEEN_TNS_AND_IMDCT,
        UNDEF,
        AFTER_IMDCT
    }

    public BlockCCE(BlockICS.BandType[] bandTypeArr) {
        this.bandType = bandTypeArr;
    }

    @Override // org.jcodec.codecs.aac.blocks.Block
    public void parse(BitReader bitReader) {
        int i;
        this.coupling_point = bitReader.read1Bit() * 2;
        this.num_coupled = bitReader.readNBit(3);
        int i2 = 0;
        for (int i3 = 0; i3 <= this.num_coupled; i3++) {
            i2++;
            this.type[i3] = bitReader.read1Bit() != 0 ? BlockType.TYPE_CPE : BlockType.TYPE_SCE;
            this.id_select[i3] = bitReader.readNBit(4);
            if (this.type[i3] == BlockType.TYPE_CPE) {
                this.ch_select[i3] = bitReader.readNBit(2);
                if (this.ch_select[i3] == 3) {
                    i2++;
                }
            } else {
                this.ch_select[i3] = 2;
            }
        }
        this.coupling_point += bitReader.read1Bit() | (this.coupling_point >> 1);
        this.sign = bitReader.read1Bit();
        this.scale = this.cce_scale[bitReader.readNBit(2)];
        BlockICS blockICS = new BlockICS();
        this.blockICS = blockICS;
        blockICS.parse(bitReader);
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 != 0) {
                i = this.coupling_point == CouplingPoint.AFTER_IMDCT.ordinal() ? 1 : bitReader.read1Bit();
                if (i != 0) {
                    vlc.readVLC(bitReader);
                }
            } else {
                i = 1;
            }
            if (this.coupling_point != CouplingPoint.AFTER_IMDCT.ordinal()) {
                int i5 = 0;
                for (int i6 = 0; i6 < this.blockICS.num_window_groups; i6++) {
                    int i7 = 0;
                    while (i7 < this.blockICS.maxSfb) {
                        if (this.bandType[i5] != BlockICS.BandType.ZERO_BT && i == 0) {
                            vlc.readVLC(bitReader);
                        }
                        i7++;
                        i5++;
                    }
                }
            }
        }
    }
}
