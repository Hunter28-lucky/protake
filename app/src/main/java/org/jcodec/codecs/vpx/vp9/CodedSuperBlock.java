package org.jcodec.codecs.vpx.vp9;

import java.util.ArrayList;
import java.util.List;
import org.jcodec.codecs.vpx.VPXBooleanDecoder;

/* loaded from: classes2.dex */
public class CodedSuperBlock {
    private CodedBlock[] codedBlocks;

    public CodedSuperBlock(CodedBlock[] codedBlockArr) {
        this.codedBlocks = codedBlockArr;
    }

    private static int calcPartitionContext(int i, int i2, int i3, DecodingContext decodingContext) {
        return (i3 * 4) + (((decodingContext.getLeftPartitionSizes()[i2 % 8] <= i3) || false) ? 2 : 0) + (decodingContext.getAbovePartitionSizes()[i] <= i3 ? 1 : 0);
    }

    public static CodedSuperBlock read(int i, int i2, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        ArrayList arrayList = new ArrayList();
        CodedSuperBlock codedSuperBlock = new CodedSuperBlock();
        codedSuperBlock.readSubPartition(i, i2, 3, vPXBooleanDecoder, decodingContext, arrayList);
        codedSuperBlock.codedBlocks = (CodedBlock[]) arrayList.toArray(CodedBlock.EMPTY_ARR);
        return codedSuperBlock;
    }

    public static int readPartition(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        int[] iArr = decodingContext.getPartitionProbs()[calcPartitionContext(i, i2, i3, decodingContext)];
        int i4 = (1 << i3) >> 1;
        boolean z = i + i4 >= decodingContext.getMiTileWidth();
        boolean z2 = i2 + i4 >= decodingContext.getMiTileHeight();
        if (z && z2) {
            return 3;
        }
        return z ? vPXBooleanDecoder.readBit(iArr[2]) == 1 ? 3 : 2 : z2 ? vPXBooleanDecoder.readBit(iArr[1]) == 1 ? 3 : 1 : vPXBooleanDecoder.readTree(Consts.TREE_PARTITION, iArr);
    }

    private static void saveAboveSizes(int i, int i2, DecodingContext decodingContext) {
        int i3 = 1 << (i2 == 0 ? 0 : i2 - 1);
        int[] abovePartitionSizes = decodingContext.getAbovePartitionSizes();
        for (int i4 = 0; i4 < i3; i4++) {
            abovePartitionSizes[i + i4] = i2;
        }
    }

    private static void saveLeftSizes(int i, int i2, DecodingContext decodingContext) {
        int i3 = 1 << (i2 == 0 ? 0 : i2 - 1);
        int[] leftPartitionSizes = decodingContext.getLeftPartitionSizes();
        for (int i4 = 0; i4 < i3; i4++) {
            leftPartitionSizes[(i % 8) + i4] = i2;
        }
    }

    public CodedBlock[] getCodedBlocks() {
        return this.codedBlocks;
    }

    public CodedBlock readBlock(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext) {
        return CodedBlock.read(i, i2, i3, vPXBooleanDecoder, decodingContext);
    }

    public void readSubPartition(int i, int i2, int i3, VPXBooleanDecoder vPXBooleanDecoder, DecodingContext decodingContext, List<CodedBlock> list) {
        int partition = readPartition(i, i2, i3, vPXBooleanDecoder, decodingContext);
        int i4 = 1;
        int i5 = (1 << i3) >> 1;
        if (i3 <= 0) {
            int i6 = Consts.sub8x8PartitiontoBlockType[partition];
            list.add(readBlock(i, i2, i6, vPXBooleanDecoder, decodingContext));
            int i7 = i3 + 1;
            saveAboveSizes(i, i7 - ((i6 == 0 || i6 == 1) ? 1 : 0), decodingContext);
            if (i6 != 0 && i6 != 2) {
                i4 = 0;
            }
            saveLeftSizes(i2, i7 - i4, decodingContext);
            return;
        }
        if (partition == 0) {
            int i8 = i3 + 1;
            list.add(readBlock(i, i2, Consts.blSizeLookup[i8][i8], vPXBooleanDecoder, decodingContext));
            saveAboveSizes(i, i8, decodingContext);
            saveLeftSizes(i2, i8, decodingContext);
            return;
        }
        if (partition == 1) {
            int[][] iArr = Consts.blSizeLookup;
            int i9 = i3 + 1;
            list.add(readBlock(i, i2, iArr[i9][i3], vPXBooleanDecoder, decodingContext));
            saveAboveSizes(i, i9, decodingContext);
            saveLeftSizes(i2, i3, decodingContext);
            int i10 = i2 + i5;
            if (i10 < decodingContext.getMiTileHeight()) {
                list.add(readBlock(i, i10, iArr[i9][i3], vPXBooleanDecoder, decodingContext));
                saveLeftSizes(i10, i3, decodingContext);
                return;
            }
            return;
        }
        if (partition == 2) {
            int[][] iArr2 = Consts.blSizeLookup;
            int i11 = i3 + 1;
            list.add(readBlock(i, i2, iArr2[i3][i11], vPXBooleanDecoder, decodingContext));
            saveLeftSizes(i2, i11, decodingContext);
            saveAboveSizes(i, i3, decodingContext);
            int i12 = i + i5;
            if (i12 < decodingContext.getMiTileWidth()) {
                list.add(readBlock(i12, i2, iArr2[i3][i11], vPXBooleanDecoder, decodingContext));
                saveAboveSizes(i12, i3, decodingContext);
                return;
            }
            return;
        }
        int i13 = i3 - 1;
        readSubPartition(i, i2, i13, vPXBooleanDecoder, decodingContext, list);
        int i14 = i + i5;
        if (i14 < decodingContext.getMiTileWidth()) {
            readSubPartition(i14, i2, i13, vPXBooleanDecoder, decodingContext, list);
        }
        int i15 = i2 + i5;
        if (i15 < decodingContext.getMiTileHeight()) {
            readSubPartition(i, i15, i13, vPXBooleanDecoder, decodingContext, list);
        }
        if (i14 >= decodingContext.getMiTileWidth() || i15 >= decodingContext.getMiTileHeight()) {
            return;
        }
        readSubPartition(i14, i15, i13, vPXBooleanDecoder, decodingContext, list);
    }

    public CodedSuperBlock() {
    }
}
