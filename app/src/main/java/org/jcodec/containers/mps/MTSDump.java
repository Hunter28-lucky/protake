package org.jcodec.containers.mps;

import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.IntIntMap;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.psi.PATSection;
import org.jcodec.containers.mps.psi.PMTSection;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MTSDump extends MPSDump {
    private static final MainUtils.Flag[] ALL_FLAGS;
    private static final MainUtils.Flag DUMP_FROM;
    private static final MainUtils.Flag STOP_AT;
    private ByteBuffer buf;
    private int globalPayload;
    private int guid;
    private int[] nums;
    private int[] payloads;
    private int[] prevNums;
    private int[] prevPayloads;
    private ByteBuffer tsBuf;
    private int tsNo;

    static {
        MainUtils.Flag flag = MainUtils.Flag.flag("dump-from", null, "Stop reading at timestamp");
        DUMP_FROM = flag;
        MainUtils.Flag flag2 = MainUtils.Flag.flag("stop-at", null, "Start dumping from timestamp");
        STOP_AT = flag2;
        ALL_FLAGS = new MainUtils.Flag[]{flag, flag2};
    }

    public MTSDump(ReadableByteChannel readableByteChannel, int i) {
        super(readableByteChannel);
        this.buf = ByteBuffer.allocate(192512);
        this.tsBuf = ByteBuffer.allocate(TsConstants.TS_PACKET_SIZE);
        this.guid = i;
        ByteBuffer byteBuffer = this.buf;
        byteBuffer.position(byteBuffer.limit());
        ByteBuffer byteBuffer2 = this.tsBuf;
        byteBuffer2.position(byteBuffer2.limit());
    }

    private static void dumpProgramPids(ReadableByteChannel readableByteChannel) throws IOException {
        HashSet hashSet = new HashSet();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1925120);
        readableByteChannel.read(byteBufferAllocate);
        byteBufferAllocate.flip();
        byteBufferAllocate.limit(byteBufferAllocate.limit() - (byteBufferAllocate.limit() % TsConstants.TS_PACKET_SIZE));
        int i = -1;
        while (byteBufferAllocate.hasRemaining()) {
            ByteBuffer byteBuffer = NIOUtils.read(byteBufferAllocate, TsConstants.TS_PACKET_SIZE);
            Preconditions.checkState(71 == (byteBuffer.get() & ExifInterface.MARKER));
            int i2 = ((byteBuffer.get() & ExifInterface.MARKER) << 8) | (byteBuffer.get() & ExifInterface.MARKER);
            int i3 = i2 & 8191;
            System.out.println(i3);
            if (i3 != 0) {
                hashSet.add(Integer.valueOf(i3));
            }
            if (i3 == 0 || i3 == i) {
                int i4 = (i2 >> 14) & 1;
                if ((byteBuffer.get() & ExifInterface.MARKER & 32) != 0) {
                    NIOUtils.skip(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
                }
                if (i4 == 1) {
                    NIOUtils.skip(byteBuffer, byteBuffer.get() & ExifInterface.MARKER);
                }
                if (i3 == 0) {
                    PATSection pat = PATSection.parsePAT(byteBuffer);
                    int i5 = pat.getPrograms().values()[0];
                    printPat(pat);
                    i = i5;
                } else if (i3 == i) {
                    printPmt(PMTSection.parsePMT(byteBuffer));
                    return;
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            System.out.println((Integer) it.next());
        }
    }

    public static void main2(String[] strArr) throws IOException {
        try {
            MainUtils.Flag[] flagArr = ALL_FLAGS;
            MainUtils.Cmd arguments = MainUtils.parseArguments(strArr, flagArr);
            String[] strArr2 = arguments.args;
            if (strArr2.length < 1) {
                MainUtils.printHelp(flagArr, Arrays.asList("file name", "guid"));
                return;
            }
            if (strArr2.length == 1) {
                System.out.println("MTS programs:");
                dumpProgramPids(NIOUtils.readableChannel(new File(arguments.args[0])));
                return;
            }
            FileChannelWrapper fileChannelWrapper = NIOUtils.readableChannel(new File(arguments.args[0]));
            new MTSDump(fileChannelWrapper, Integer.parseInt(arguments.args[1])).dump(arguments.getLongFlag(DUMP_FROM), arguments.getLongFlag(STOP_AT));
            NIOUtils.closeQuietly(fileChannelWrapper);
        } finally {
            NIOUtils.closeQuietly(null);
        }
    }

    private int mapPos(long j) {
        int i = this.globalPayload;
        for (int length = this.payloads.length - 1; length >= 0; length--) {
            i -= this.payloads[length];
            if (i <= j) {
                return this.nums[length];
            }
        }
        int[] iArr = this.prevPayloads;
        if (iArr == null) {
            return -1;
        }
        for (int length2 = iArr.length - 1; length2 >= 0; length2--) {
            i -= this.prevPayloads[length2];
            if (i <= j) {
                return this.prevNums[length2];
            }
        }
        return -1;
    }

    private static void printPat(PATSection pATSection) {
        IntIntMap programs = pATSection.getPrograms();
        System.out.print("PAT: ");
        for (int i : programs.keys()) {
            System.out.print(i + Constants.COLON_SEPARATOR + programs.get(i) + ", ");
        }
        System.out.println();
    }

    private static void printPmt(PMTSection pMTSection) {
        System.out.print("PMT: ");
        for (PMTSection.PMTStream pMTStream : pMTSection.getStreams()) {
            System.out.print(pMTStream.getPid() + Constants.COLON_SEPARATOR + pMTStream.getStreamTypeTag() + ", ");
            Iterator<MPSUtils.MPEGMediaDescriptor> it = pMTStream.getDesctiptors().iterator();
            while (it.hasNext()) {
                System.out.println(Platform.toJSON(it.next()));
            }
        }
        System.out.println();
    }

    @Override // org.jcodec.containers.mps.MPSDump
    public int fillBuffer(ByteBuffer byteBuffer) throws IOException {
        IntArrayList intArrayListCreateIntArrayList = IntArrayList.createIntArrayList();
        IntArrayList intArrayListCreateIntArrayList2 = IntArrayList.createIntArrayList();
        int iRemaining = byteBuffer.remaining();
        try {
            byteBuffer.put(NIOUtils.read(this.tsBuf, Math.min(byteBuffer.remaining(), this.tsBuf.remaining())));
            while (byteBuffer.hasRemaining()) {
                if (!this.buf.hasRemaining()) {
                    ByteBuffer byteBufferDuplicate = this.buf.duplicate();
                    byteBufferDuplicate.clear();
                    if (this.ch.read(byteBufferDuplicate) == -1) {
                        return byteBuffer.remaining() != iRemaining ? iRemaining - byteBuffer.remaining() : -1;
                    }
                    byteBufferDuplicate.flip();
                    byteBufferDuplicate.limit(byteBufferDuplicate.limit() - (byteBufferDuplicate.limit() % TsConstants.TS_PACKET_SIZE));
                    this.buf = byteBufferDuplicate;
                }
                ByteBuffer byteBuffer2 = NIOUtils.read(this.buf, TsConstants.TS_PACKET_SIZE);
                this.tsBuf = byteBuffer2;
                Preconditions.checkState(71 == (byteBuffer2.get() & ExifInterface.MARKER));
                this.tsNo++;
                if (((((this.tsBuf.get() & ExifInterface.MARKER) << 8) | (this.tsBuf.get() & ExifInterface.MARKER)) & 8191) == this.guid) {
                    if ((this.tsBuf.get() & ExifInterface.MARKER & 32) != 0) {
                        ByteBuffer byteBuffer3 = this.tsBuf;
                        NIOUtils.skip(byteBuffer3, byteBuffer3.get() & ExifInterface.MARKER);
                    }
                    this.globalPayload += this.tsBuf.remaining();
                    intArrayListCreateIntArrayList.add(this.tsBuf.remaining());
                    intArrayListCreateIntArrayList2.add(this.tsNo - 1);
                    byteBuffer.put(NIOUtils.read(this.tsBuf, Math.min(byteBuffer.remaining(), this.tsBuf.remaining())));
                }
            }
            this.prevPayloads = this.payloads;
            this.payloads = intArrayListCreateIntArrayList.toArray();
            this.prevNums = this.nums;
            this.nums = intArrayListCreateIntArrayList2.toArray();
            return iRemaining - byteBuffer.remaining();
        } finally {
            this.prevPayloads = this.payloads;
            this.payloads = intArrayListCreateIntArrayList.toArray();
            this.prevNums = this.nums;
            this.nums = intArrayListCreateIntArrayList2.toArray();
        }
    }

    @Override // org.jcodec.containers.mps.MPSDump
    public void logPes(PESPacket pESPacket, int i, ByteBuffer byteBuffer) {
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append(pESPacket.streamId);
        sb.append("(");
        sb.append(pESPacket.streamId >= 224 ? "video" : "audio");
        sb.append(") [ts#");
        sb.append(mapPos(pESPacket.pos));
        sb.append(", ");
        sb.append(byteBuffer.remaining() + i);
        sb.append("b], pts: ");
        sb.append(pESPacket.pts);
        sb.append(", dts: ");
        sb.append(pESPacket.dts);
        printStream.println(sb.toString());
    }
}
