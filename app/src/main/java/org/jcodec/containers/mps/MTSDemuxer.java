package org.jcodec.containers.mps;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.Preconditions;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.io.SeekableByteChannel;

/* loaded from: classes2.dex */
public class MTSDemuxer {
    private SeekableByteChannel channel;
    private Map<Integer, ProgramChannel> programs = new HashMap();

    public static class MTSPacket {
        public ByteBuffer payload;
        public boolean payloadStart;
        public int pid;

        public MTSPacket(int i, boolean z, ByteBuffer byteBuffer) {
            this.pid = i;
            this.payloadStart = z;
            this.payload = byteBuffer;
        }
    }

    public static class ProgramChannel implements ReadableByteChannel {
        private boolean closed;
        private List<ByteBuffer> data = new ArrayList();
        private final MTSDemuxer demuxer;

        public ProgramChannel(MTSDemuxer mTSDemuxer) {
            this.demuxer = mTSDemuxer;
        }

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            this.data.clear();
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return !this.closed && this.demuxer.channel.isOpen();
        }

        @Override // java.nio.channels.ReadableByteChannel
        public int read(ByteBuffer byteBuffer) throws IOException {
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                while (this.data.size() == 0) {
                    if (!this.demuxer.readAndDispatchNextTSPacket()) {
                        if (i > 0) {
                            return i;
                        }
                        return -1;
                    }
                }
                ByteBuffer byteBuffer2 = this.data.get(0);
                int iMin = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
                byteBuffer.put(NIOUtils.read(byteBuffer2, iMin));
                if (!byteBuffer2.hasRemaining()) {
                    this.data.remove(0);
                }
                i += iMin;
            }
            return i;
        }

        public void storePacket(MTSPacket mTSPacket) {
            if (this.closed) {
                return;
            }
            this.data.add(mTSPacket.payload);
        }
    }

    public MTSDemuxer(SeekableByteChannel seekableByteChannel) throws IOException {
        this.channel = seekableByteChannel;
        Iterator<Integer> it = findPrograms(seekableByteChannel).iterator();
        while (it.hasNext()) {
            this.programs.put(Integer.valueOf(it.next().intValue()), new ProgramChannel(this));
        }
        seekableByteChannel.setPosition(0L);
    }

    public static MTSPacket parsePacket(ByteBuffer byteBuffer) {
        Preconditions.checkState(71 == (byteBuffer.get() & ExifInterface.MARKER));
        short s = byteBuffer.getShort();
        int i = s & 8191;
        int i2 = (s >> 14) & 1;
        int i3 = byteBuffer.get() & ExifInterface.MARKER;
        if ((i3 & 32) != 0) {
            NIOUtils.skip(byteBuffer, ((byteBuffer.get() & ExifInterface.MARKER) + 1) - 1);
        }
        boolean z = i2 == 1;
        if ((i3 & 16) == 0) {
            byteBuffer = null;
        }
        return new MTSPacket(i, z, byteBuffer);
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        MTSPacket packet;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        IntObjectMap intObjectMap = new IntObjectMap();
        while (true) {
            try {
                ByteBuffer byteBuffer2 = NIOUtils.read(byteBufferDuplicate, TsConstants.TS_PACKET_SIZE);
                if (byteBuffer2.remaining() >= 188 && (packet = parsePacket(byteBuffer2)) != null) {
                    List arrayList = (List) intObjectMap.get(packet.pid);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        intObjectMap.put(packet.pid, arrayList);
                    }
                    ByteBuffer byteBuffer3 = packet.payload;
                    if (byteBuffer3 != null) {
                        arrayList.add(byteBuffer3);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        int i = 0;
        for (int i2 : intObjectMap.keys()) {
            List list = (List) intObjectMap.get(i2);
            int iProbe = MPSDemuxer.probe(NIOUtils.combineBuffers(list));
            if (iProbe > i) {
                i = (list.size() > 20 ? 50 : 0) + iProbe;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean readAndDispatchNextTSPacket() throws IOException {
        MTSPacket packet = readPacket(this.channel);
        if (packet == null) {
            return false;
        }
        ProgramChannel programChannel = this.programs.get(Integer.valueOf(packet.pid));
        if (programChannel == null) {
            return true;
        }
        programChannel.storePacket(packet);
        return true;
    }

    public static MTSPacket readPacket(ReadableByteChannel readableByteChannel) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(TsConstants.TS_PACKET_SIZE);
        if (NIOUtils.readFromChannel(readableByteChannel, byteBufferAllocate) != 188) {
            return null;
        }
        byteBufferAllocate.flip();
        return parsePacket(byteBufferAllocate);
    }

    public Set<Integer> findPrograms(SeekableByteChannel seekableByteChannel) throws IOException {
        MTSPacket packet;
        long jPosition = seekableByteChannel.position();
        HashSet hashSet = new HashSet();
        int i = 0;
        while (true) {
            if ((hashSet.size() != 0 && i >= hashSet.size() * 500) || (packet = readPacket(seekableByteChannel)) == null) {
                break;
            }
            ByteBuffer byteBuffer = packet.payload;
            if (byteBuffer != null && !hashSet.contains(Integer.valueOf(packet.pid)) && (byteBuffer.duplicate().getInt() & InputDeviceCompat.SOURCE_ANY) == 256) {
                hashSet.add(Integer.valueOf(packet.pid));
            }
            i++;
        }
        seekableByteChannel.setPosition(jPosition);
        return hashSet;
    }

    public ReadableByteChannel getProgram(int i) {
        return this.programs.get(Integer.valueOf(i));
    }

    public Set<Integer> getPrograms() {
        return this.programs.keySet();
    }
}
