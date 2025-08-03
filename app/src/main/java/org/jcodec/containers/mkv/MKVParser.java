package org.jcodec.containers.mkv;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.common.io.SeekableByteChannel;
import org.jcodec.containers.mkv.boxes.EbmlBase;
import org.jcodec.containers.mkv.boxes.EbmlBin;
import org.jcodec.containers.mkv.boxes.EbmlMaster;
import org.jcodec.containers.mkv.boxes.EbmlVoid;
import org.jcodec.containers.mkv.util.EbmlUtil;

/* loaded from: classes2.dex */
public class MKVParser {
    private SeekableByteChannel channel;
    private LinkedList<EbmlMaster> trace = new LinkedList<>();

    public MKVParser(SeekableByteChannel seekableByteChannel) {
        this.channel = seekableByteChannel;
    }

    private void closeElem(EbmlMaster ebmlMaster, List<EbmlMaster> list) {
        if (this.trace.peekFirst() == null) {
            list.add(ebmlMaster);
        } else {
            this.trace.peekFirst().add(ebmlMaster);
        }
    }

    private EbmlBase nextElement() throws IOException {
        long jPosition = this.channel.position();
        if (jPosition >= this.channel.size()) {
            return null;
        }
        byte[] ebmlId = readEbmlId(this.channel);
        while (ebmlId == null && !isKnownType(ebmlId) && jPosition < this.channel.size()) {
            jPosition++;
            this.channel.setPosition(jPosition);
            ebmlId = readEbmlId(this.channel);
        }
        long ebmlInt = readEbmlInt(this.channel);
        EbmlBase ebmlBaseCreateById = MKVType.createById(ebmlId, jPosition);
        ebmlBaseCreateById.offset = jPosition;
        ebmlBaseCreateById.typeSizeLength = (int) (this.channel.position() - jPosition);
        ebmlBaseCreateById.dataOffset = this.channel.position();
        ebmlBaseCreateById.dataLen = (int) ebmlInt;
        return ebmlBaseCreateById;
    }

    private void openElem(EbmlBase ebmlBase) {
    }

    private boolean possibleChild(EbmlMaster ebmlMaster, EbmlBase ebmlBase) {
        if (ebmlMaster != null) {
            MKVType mKVType = MKVType.Cluster;
            if (mKVType.equals(ebmlMaster.type) && ebmlBase != null && !mKVType.equals(ebmlBase.type) && !MKVType.Info.equals(ebmlBase.type) && !MKVType.SeekHead.equals(ebmlBase.type) && !MKVType.Tracks.equals(ebmlBase.type) && !MKVType.Cues.equals(ebmlBase.type) && !MKVType.Attachments.equals(ebmlBase.type) && !MKVType.Tags.equals(ebmlBase.type) && !MKVType.Chapters.equals(ebmlBase.type)) {
                return true;
            }
        }
        return MKVType.possibleChild(ebmlMaster, ebmlBase);
    }

    public static byte[] readEbmlId(SeekableByteChannel seekableByteChannel) throws IOException {
        if (seekableByteChannel.position() == seekableByteChannel.size()) {
            return null;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.limit(1);
        seekableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        int iComputeLength = EbmlUtil.computeLength(byteBufferAllocate.get());
        if (iComputeLength == 0) {
            return null;
        }
        if (iComputeLength > 1) {
            byteBufferAllocate.limit(iComputeLength);
            seekableByteChannel.read(byteBufferAllocate);
        }
        byteBufferAllocate.flip();
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(byteBufferAllocate.remaining());
        byteBufferAllocate2.put(byteBufferAllocate);
        return byteBufferAllocate2.array();
    }

    public static long readEbmlInt(SeekableByteChannel seekableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.limit(1);
        seekableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        byte b = byteBufferAllocate.get();
        int iComputeLength = EbmlUtil.computeLength(b);
        if (iComputeLength == 0) {
            throw new RuntimeException("Invalid ebml integer size.");
        }
        byteBufferAllocate.limit(iComputeLength);
        seekableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.position(1);
        long j = (255 >>> iComputeLength) & b;
        while (true) {
            iComputeLength--;
            if (iComputeLength <= 0) {
                return j;
            }
            j = (j << 8) | (byteBufferAllocate.get() & ExifInterface.MARKER);
        }
    }

    public boolean isKnownType(byte[] bArr) {
        if (this.trace.isEmpty() || !MKVType.Cluster.equals(this.trace.peekFirst().type)) {
            return MKVType.isSpecifiedHeader(bArr);
        }
        return true;
    }

    public List<EbmlMaster> parse() throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            EbmlBase ebmlBaseNextElement = nextElement();
            if (ebmlBaseNextElement == null) {
                while (this.trace.peekFirst() != null) {
                    closeElem(this.trace.removeFirst(), arrayList);
                }
                return arrayList;
            }
            if (!isKnownType(ebmlBaseNextElement.id)) {
                System.err.println("Unspecified header: " + EbmlUtil.toHexString(ebmlBaseNextElement.id) + " at " + ebmlBaseNextElement.offset);
            }
            while (!possibleChild(this.trace.peekFirst(), ebmlBaseNextElement)) {
                closeElem(this.trace.removeFirst(), arrayList);
            }
            openElem(ebmlBaseNextElement);
            if (ebmlBaseNextElement instanceof EbmlMaster) {
                this.trace.push((EbmlMaster) ebmlBaseNextElement);
            } else if (ebmlBaseNextElement instanceof EbmlBin) {
                EbmlBin ebmlBin = (EbmlBin) ebmlBaseNextElement;
                EbmlMaster ebmlMasterPeekFirst = this.trace.peekFirst();
                long j = ebmlMasterPeekFirst.dataOffset;
                int i = ebmlMasterPeekFirst.dataLen;
                if (i + j < ebmlBaseNextElement.dataOffset + ebmlBaseNextElement.dataLen) {
                    this.channel.setPosition(j + i);
                } else {
                    try {
                        ebmlBin.readChannel(this.channel);
                    } catch (OutOfMemoryError e2) {
                        throw new RuntimeException(ebmlBaseNextElement.type + " 0x" + EbmlUtil.toHexString(ebmlBin.id) + " size: " + Long.toHexString(ebmlBin.dataLen) + " offset: 0x" + Long.toHexString(ebmlBaseNextElement.offset), e2);
                    }
                }
                this.trace.peekFirst().add(ebmlBaseNextElement);
            } else {
                if (!(ebmlBaseNextElement instanceof EbmlVoid)) {
                    throw new RuntimeException("Currently there are no elements that are neither Master nor Binary, should never actually get here");
                }
                ((EbmlVoid) ebmlBaseNextElement).skip(this.channel);
            }
        }
    }
}
