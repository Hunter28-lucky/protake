package org.jcodec.codecs.mpeg12;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class SegmentReader {
    private ByteBuffer buf;
    private int bufferIncrement = 32768;
    private int bytesInMarker = 4;
    private ReadableByteChannel channel;
    public int curMarker;
    public boolean done;
    private int fetchSize;
    private long pos;

    public enum State {
        MORE_DATA,
        DONE,
        STOP
    }

    public SegmentReader(ReadableByteChannel readableByteChannel, int i) throws IOException {
        this.channel = readableByteChannel;
        this.fetchSize = i;
        this.buf = NIOUtils.fetchFromChannel(readableByteChannel, 4);
        this.pos = r3.remaining();
        this.curMarker = this.buf.getInt();
    }

    public final long curPos() {
        return (this.pos - this.buf.remaining()) - 4;
    }

    public int getBufferIncrement() {
        return this.bufferIncrement;
    }

    public final boolean read(ByteBuffer byteBuffer, int i) throws IOException {
        if (this.done) {
            return false;
        }
        while (true) {
            if (this.buf.hasRemaining()) {
                int i2 = i - 1;
                if (i == 0) {
                    return true;
                }
                byteBuffer.put((byte) (this.curMarker >>> 24));
                this.curMarker = (this.curMarker << 8) | (this.buf.get() & ExifInterface.MARKER);
                i = i2;
            } else {
                this.buf = NIOUtils.fetchFromChannel(this.channel, this.fetchSize);
                this.pos += r0.remaining();
                if (!this.buf.hasRemaining()) {
                    byteBuffer.putInt(this.curMarker);
                    this.done = true;
                    return false;
                }
            }
        }
    }

    public final boolean readToNextMarker(ByteBuffer byteBuffer) throws IOException {
        State toNextMarkerPartial = readToNextMarkerPartial(byteBuffer);
        if (toNextMarkerPartial != State.MORE_DATA) {
            return toNextMarkerPartial == State.DONE;
        }
        throw new BufferOverflowException();
    }

    public void readToNextMarkerBuffers(List<ByteBuffer> list) throws IOException {
        State toNextMarkerPartial;
        do {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.bufferIncrement);
            toNextMarkerPartial = readToNextMarkerPartial(byteBufferAllocate);
            byteBufferAllocate.flip();
            list.add(byteBufferAllocate);
        } while (toNextMarkerPartial == State.MORE_DATA);
    }

    public ByteBuffer readToNextMarkerNewBuffer() throws IOException {
        if (this.done) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        readToNextMarkerBuffers(arrayList);
        return NIOUtils.combineBuffers(arrayList);
    }

    public final State readToNextMarkerPartial(ByteBuffer byteBuffer) throws IOException {
        int i;
        if (this.done) {
            return State.STOP;
        }
        int i2 = this.curMarker;
        int i3 = (i2 < 256 || i2 > 511) ? 0 : 1;
        int iPosition = byteBuffer.position();
        while (true) {
            if (this.buf.hasRemaining()) {
                int i4 = this.curMarker;
                if (i4 >= 256 && i4 <= 511) {
                    if (i3 == 0) {
                        return State.DONE;
                    }
                    i3--;
                }
                if (!byteBuffer.hasRemaining()) {
                    return State.MORE_DATA;
                }
                byteBuffer.put((byte) (this.curMarker >>> 24));
                this.curMarker = (this.curMarker << 8) | (this.buf.get() & ExifInterface.MARKER);
            } else {
                this.buf = NIOUtils.fetchFromChannel(this.channel, this.fetchSize);
                this.pos += r5.remaining();
                if (!this.buf.hasRemaining()) {
                    if (byteBuffer.position() - iPosition > 0 && (i = this.curMarker) >= 256 && i <= 511) {
                        return State.DONE;
                    }
                    while (this.bytesInMarker > 0 && byteBuffer.hasRemaining()) {
                        byteBuffer.put((byte) (this.curMarker >>> 24));
                        int i5 = this.curMarker << 8;
                        this.curMarker = i5;
                        this.bytesInMarker--;
                        if (i5 >= 256 && i5 <= 511) {
                            return State.DONE;
                        }
                    }
                    if (this.bytesInMarker != 0) {
                        return State.MORE_DATA;
                    }
                    this.done = true;
                    return State.STOP;
                }
            }
        }
    }

    public void setBufferIncrement(int i) {
        this.bufferIncrement = i;
    }

    public final boolean skipToMarker() throws IOException {
        if (this.done) {
            return false;
        }
        while (true) {
            if (this.buf.hasRemaining()) {
                int i = (this.curMarker << 8) | (this.buf.get() & ExifInterface.MARKER);
                this.curMarker = i;
                if (i >= 256 && i <= 511) {
                    return true;
                }
            } else {
                this.buf = NIOUtils.fetchFromChannel(this.channel, this.fetchSize);
                this.pos += r0.remaining();
                if (!this.buf.hasRemaining()) {
                    this.done = true;
                    return false;
                }
            }
        }
    }
}
