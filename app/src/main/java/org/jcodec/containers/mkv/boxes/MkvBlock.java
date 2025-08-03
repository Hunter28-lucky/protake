package org.jcodec.containers.mkv.boxes;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import org.jcodec.common.ByteArrayList;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mkv.util.EbmlUtil;
import org.jcodec.containers.mxf.model.BER;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MkvBlock extends EbmlBin {
    private static final String EBML = "EBML";
    private static final String FIXED = "Fixed";
    private static final int MAX_BLOCK_HEADER_SIZE = 512;
    private static final String XIPH = "Xiph";
    public boolean _keyFrame;
    public long absoluteTimecode;
    public boolean discardable;
    public int[] frameOffsets;
    public int[] frameSizes;
    public ByteBuffer[] frames;
    public int headerSize;
    public String lacing;
    public boolean lacingPresent;
    public int timecode;
    public long trackNumber;
    public static final byte[] BLOCK_ID = {-95};
    public static final byte[] SIMPLEBLOCK_ID = {-93};

    public MkvBlock(byte[] bArr) {
        super(bArr);
        if (Platform.arrayEqualsByte(SIMPLEBLOCK_ID, bArr) || Platform.arrayEqualsByte(BLOCK_ID, bArr)) {
            return;
        }
        throw new IllegalArgumentException("Block initiated with invalid id: " + EbmlUtil.toHexString(bArr));
    }

    public static long[] calcEbmlLacingDiffs(int[] iArr) {
        int length = iArr.length - 1;
        long[] jArr = new long[length];
        jArr[0] = iArr[0];
        for (int i = 1; i < length; i++) {
            jArr[i] = iArr[i] - iArr[i - 1];
        }
        return jArr;
    }

    public static MkvBlock copy(MkvBlock mkvBlock) {
        MkvBlock mkvBlock2 = new MkvBlock(mkvBlock.id);
        mkvBlock2.trackNumber = mkvBlock.trackNumber;
        mkvBlock2.timecode = mkvBlock.timecode;
        mkvBlock2.absoluteTimecode = mkvBlock.absoluteTimecode;
        mkvBlock2._keyFrame = mkvBlock._keyFrame;
        mkvBlock2.headerSize = mkvBlock.headerSize;
        mkvBlock2.lacing = mkvBlock.lacing;
        mkvBlock2.discardable = mkvBlock.discardable;
        mkvBlock2.lacingPresent = mkvBlock.lacingPresent;
        int[] iArr = new int[mkvBlock.frameOffsets.length];
        mkvBlock2.frameOffsets = iArr;
        mkvBlock2.frameSizes = new int[mkvBlock.frameSizes.length];
        mkvBlock2.dataOffset = mkvBlock.dataOffset;
        mkvBlock2.offset = mkvBlock.offset;
        mkvBlock2.type = mkvBlock.type;
        System.arraycopy(mkvBlock.frameOffsets, 0, iArr, 0, iArr.length);
        int[] iArr2 = mkvBlock.frameSizes;
        int[] iArr3 = mkvBlock2.frameSizes;
        System.arraycopy(iArr2, 0, iArr3, 0, iArr3.length);
        return mkvBlock2;
    }

    public static long ebmlDecode(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int iComputeLength = EbmlUtil.computeLength(b);
        if (iComputeLength == 0) {
            throw new RuntimeException("Invalid ebml integer size.");
        }
        long j = b & (255 >>> iComputeLength);
        while (true) {
            iComputeLength--;
            if (iComputeLength <= 0) {
                return j;
            }
            j = (j << 8) | (byteBuffer.get() & ExifInterface.MARKER);
        }
    }

    public static long ebmlDecodeSigned(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        int iComputeLength = EbmlUtil.computeLength(b);
        if (iComputeLength == 0) {
            throw new RuntimeException("Invalid ebml integer size.");
        }
        long j = b & (255 >>> iComputeLength);
        for (int i = iComputeLength - 1; i > 0; i--) {
            j = (j << 8) | (byteBuffer.get() & ExifInterface.MARKER);
        }
        return j - EbmlSint.signedComplement[iComputeLength];
    }

    public static MkvBlock keyFrame(long j, int i, ByteBuffer byteBuffer) {
        MkvBlock mkvBlock = new MkvBlock(SIMPLEBLOCK_ID);
        mkvBlock.frames = new ByteBuffer[]{byteBuffer};
        mkvBlock.frameSizes = new int[]{byteBuffer.limit()};
        mkvBlock._keyFrame = true;
        mkvBlock.trackNumber = j;
        mkvBlock.timecode = i;
        return mkvBlock;
    }

    public static byte[] muxEbmlLacing(int[] iArr) {
        ByteArrayList byteArrayListCreateByteArrayList = ByteArrayList.createByteArrayList();
        long[] jArrCalcEbmlLacingDiffs = calcEbmlLacingDiffs(iArr);
        byteArrayListCreateByteArrayList.addAll(EbmlUtil.ebmlEncode(jArrCalcEbmlLacingDiffs[0]));
        for (int i = 1; i < jArrCalcEbmlLacingDiffs.length; i++) {
            byteArrayListCreateByteArrayList.addAll(EbmlSint.convertToBytes(jArrCalcEbmlLacingDiffs[i]));
        }
        return byteArrayListCreateByteArrayList.toArray();
    }

    private byte[] muxLacingInfo() {
        if (EBML.equals(this.lacing)) {
            return muxEbmlLacing(this.frameSizes);
        }
        if (XIPH.equals(this.lacing)) {
            return muxXiphLacing(this.frameSizes);
        }
        if (FIXED.equals(this.lacing)) {
            return new byte[0];
        }
        return null;
    }

    public static byte[] muxXiphLacing(int[] iArr) {
        ByteArrayList byteArrayListCreateByteArrayList = ByteArrayList.createByteArrayList();
        for (int i = 0; i < iArr.length - 1; i++) {
            long j = iArr[i];
            while (j >= 255) {
                byteArrayListCreateByteArrayList.add((byte) -1);
                j -= 255;
            }
            byteArrayListCreateByteArrayList.add((byte) j);
        }
        return byteArrayListCreateByteArrayList.toArray();
    }

    public static int readEBMLLaceSizes(ByteBuffer byteBuffer, int[] iArr, int i, int i2) {
        int length = iArr.length - 1;
        iArr[length] = i;
        int iPosition = byteBuffer.position();
        int iEbmlDecode = (int) ebmlDecode(byteBuffer);
        iArr[0] = iEbmlDecode;
        iArr[length] = iArr[length] - iEbmlDecode;
        int iEbmlDecodeSigned = iArr[0];
        for (int i3 = 1; i3 < length; i3++) {
            iEbmlDecodeSigned = (int) (iEbmlDecodeSigned + ebmlDecodeSigned(byteBuffer));
            iArr[i3] = iEbmlDecodeSigned;
            iArr[length] = iArr[length] - iEbmlDecodeSigned;
        }
        int iPosition2 = (byteBuffer.position() - iPosition) + i2;
        iArr[length] = iArr[length] - iPosition2;
        return iPosition2;
    }

    public static int readXiphLaceSizes(ByteBuffer byteBuffer, int[] iArr, int i, int i2) {
        int iPosition = byteBuffer.position();
        int length = iArr.length - 1;
        iArr[length] = i;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = 255;
            while (i4 == 255) {
                i4 = byteBuffer.get() & ExifInterface.MARKER;
                iArr[i3] = iArr[i3] + i4;
            }
            iArr[length] = iArr[length] - iArr[i3];
        }
        int iPosition2 = (byteBuffer.position() - iPosition) + i2;
        iArr[length] = iArr[length] - iPosition2;
        return iPosition2;
    }

    private void turnSizesToFrameOffsets(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        this.frameOffsets = iArr2;
        iArr2[0] = this.headerSize;
        for (int i = 1; i < iArr.length; i++) {
            int[] iArr3 = this.frameOffsets;
            int i2 = i - 1;
            iArr3[i] = iArr3[i2] + iArr[i2];
        }
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBin, org.jcodec.containers.mkv.boxes.EbmlBase
    public ByteBuffer getData() {
        int dataSize = getDataSize();
        long j = dataSize;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(dataSize + EbmlUtil.ebmlLength(j) + this.id.length);
        byteBufferAllocate.put(this.id);
        byteBufferAllocate.put(EbmlUtil.ebmlEncode(j));
        byteBufferAllocate.put(EbmlUtil.ebmlEncode(this.trackNumber));
        byteBufferAllocate.put((byte) ((this.timecode >>> 8) & 255));
        byteBufferAllocate.put((byte) (this.timecode & 255));
        int i = 0;
        byte b = XIPH.equals(this.lacing) ? (byte) 2 : EBML.equals(this.lacing) ? (byte) 6 : FIXED.equals(this.lacing) ? (byte) 4 : (byte) 0;
        if (this.discardable) {
            b = (byte) (b | 1);
        }
        if (this._keyFrame) {
            b = (byte) (b | BER.ASN_LONG_LEN);
        }
        byteBufferAllocate.put(b);
        if ((b & 6) != 0) {
            byteBufferAllocate.put((byte) ((this.frames.length - 1) & 255));
            byteBufferAllocate.put(muxLacingInfo());
        }
        while (true) {
            ByteBuffer[] byteBufferArr = this.frames;
            if (i >= byteBufferArr.length) {
                byteBufferAllocate.flip();
                return byteBufferAllocate;
            }
            byteBufferAllocate.put(byteBufferArr[i]);
            i++;
        }
    }

    public int getDataSize() {
        int length = 0;
        for (int i = 0; i < this.frameSizes.length; i++) {
            length = (int) (length + r0[i]);
        }
        if (this.lacingPresent) {
            length = length + muxLacingInfo().length + 1;
        }
        return length + 3 + EbmlUtil.ebmlLength(this.trackNumber);
    }

    public ByteBuffer[] getFrames(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer[] byteBufferArr = new ByteBuffer[this.frameSizes.length];
        for (int i = 0; i < this.frameSizes.length; i++) {
            if (this.frameOffsets[i] > byteBuffer.limit()) {
                System.err.println("frame offset: " + this.frameOffsets[i] + " limit: " + byteBuffer.limit());
            }
            byteBuffer.position(this.frameOffsets[i]);
            ByteBuffer byteBufferSlice = byteBuffer.slice();
            byteBufferSlice.limit(this.frameSizes[i]);
            byteBufferArr[i] = byteBufferSlice;
        }
        return byteBufferArr;
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBin
    public void read(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        this.trackNumber = ebmlDecode(byteBufferSlice);
        this.timecode = (short) ((((short) (byteBufferSlice.get() & ExifInterface.MARKER)) << 8) | ((short) (byteBufferSlice.get() & ExifInterface.MARKER)));
        int i = byteBufferSlice.get() & ExifInterface.MARKER;
        this._keyFrame = (i & 128) > 0;
        this.discardable = (i & 1) > 0;
        int i2 = i & 6;
        boolean z = i2 != 0;
        this.lacingPresent = z;
        if (!z) {
            this.lacing = "";
            this.frameOffsets = new int[]{byteBufferSlice.position()};
            int iPosition = byteBufferSlice.position();
            this.headerSize = iPosition;
            this.frameSizes = new int[]{this.dataLen - iPosition};
            return;
        }
        int i3 = (byteBufferSlice.get() & ExifInterface.MARKER) + 1;
        int[] iArr = new int[i3];
        this.frameSizes = iArr;
        if (i2 == 2) {
            this.lacing = XIPH;
            this.headerSize = readXiphLaceSizes(byteBufferSlice, iArr, this.dataLen, byteBufferSlice.position());
        } else if (i2 == 6) {
            this.lacing = EBML;
            this.headerSize = readEBMLLaceSizes(byteBufferSlice, iArr, this.dataLen, byteBufferSlice.position());
        } else {
            if (i2 != 4) {
                throw new RuntimeException("Unsupported lacing type flag.");
            }
            this.lacing = FIXED;
            int iPosition2 = byteBufferSlice.position();
            this.headerSize = iPosition2;
            Arrays.fill(this.frameSizes, (this.dataLen - iPosition2) / i3);
        }
        turnSizesToFrameOffsets(this.frameSizes);
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBin
    public void readChannel(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(100);
        seekableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        read(byteBufferAllocate);
        seekableByteChannel.setPosition(this.dataOffset + this.dataLen);
    }

    public void readFrames(ByteBuffer byteBuffer) throws IOException {
        this.frames = getFrames(byteBuffer);
    }

    public void seekAndReadContent(FileChannel fileChannel) throws IOException {
        this.data = ByteBuffer.allocate(this.dataLen);
        fileChannel.position(this.dataOffset);
        fileChannel.read(this.data);
        this.data.flip();
    }

    @Override // org.jcodec.containers.mkv.boxes.EbmlBin, org.jcodec.containers.mkv.boxes.EbmlBase
    public long size() {
        return getDataSize() + EbmlUtil.ebmlLength(r0) + this.id.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{dataOffset: ");
        sb.append(this.dataOffset);
        sb.append(", trackNumber: ");
        sb.append(this.trackNumber);
        sb.append(", timecode: ");
        sb.append(this.timecode);
        sb.append(", keyFrame: ");
        sb.append(this._keyFrame);
        sb.append(", headerSize: ");
        sb.append(this.headerSize);
        sb.append(", lacing: ");
        sb.append(this.lacing);
        for (int i = 0; i < this.frameSizes.length; i++) {
            sb.append(", frame[");
            sb.append(i);
            sb.append("]  offset ");
            sb.append(this.frameOffsets[i]);
            sb.append(" size ");
            sb.append(this.frameSizes[i]);
        }
        sb.append(" }");
        return sb.toString();
    }
}
