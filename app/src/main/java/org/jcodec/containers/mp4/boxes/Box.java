package org.jcodec.containers.mp4.boxes;

import io.jsonwebtoken.JwtParser;
import java.nio.ByteBuffer;
import org.jcodec.common.Preconditions;
import org.jcodec.common.StringUtils;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.IBoxFactory;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public abstract class Box {
    public static final int MAX_BOX_SIZE = 134217728;
    public Header header;

    public static class LeafBox extends Box {
        public ByteBuffer data;

        public LeafBox(Header header) {
            super(header);
        }

        @Override // org.jcodec.containers.mp4.boxes.Box
        public void doWrite(ByteBuffer byteBuffer) {
            NIOUtils.write(byteBuffer, this.data);
        }

        @Override // org.jcodec.containers.mp4.boxes.Box
        public int estimateSize() {
            return this.data.remaining() + Header.estimateHeaderSize(this.data.remaining());
        }

        public ByteBuffer getData() {
            return this.data.duplicate();
        }

        @Override // org.jcodec.containers.mp4.boxes.Box
        public void parse(ByteBuffer byteBuffer) {
            this.data = NIOUtils.read(byteBuffer, (int) this.header.getBodySize());
        }
    }

    @UsedViaReflection
    public Box(Header header) {
        this.header = header;
    }

    public static <T extends Box> T asBox(Class<T> cls, Box box) {
        try {
            T t = (T) Platform.newInstance(cls, new Object[]{box.getHeader()});
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) box.getHeader().getBodySize());
            box.doWrite(byteBufferAllocate);
            byteBufferAllocate.flip();
            t.parse(byteBufferAllocate);
            return t;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static LeafBox createLeafBox(Header header, ByteBuffer byteBuffer) {
        LeafBox leafBox = new LeafBox(header);
        leafBox.data = byteBuffer;
        return leafBox;
    }

    public static Box parseBox(ByteBuffer byteBuffer, Header header, IBoxFactory iBoxFactory) {
        Box boxNewBox = iBoxFactory.newBox(header);
        if (header.getBodySize() >= 134217728) {
            return new LeafBox(Header.createHeader("free", 8L));
        }
        boxNewBox.parse(byteBuffer);
        return boxNewBox;
    }

    public static String[] path(String str) {
        return StringUtils.splitC(str, JwtParser.SEPARATOR_CHAR);
    }

    public static Box terminatorAtom() {
        return createLeafBox(new Header(Platform.stringFromBytes(new byte[4])), ByteBuffer.allocate(0));
    }

    public abstract void doWrite(ByteBuffer byteBuffer);

    public void dump(StringBuilder sb) {
        sb.append("{\"tag\":\"" + this.header.getFourcc() + "\"}");
    }

    public abstract int estimateSize();

    public String getFourcc() {
        return this.header.getFourcc();
    }

    public Header getHeader() {
        return this.header;
    }

    public abstract void parse(ByteBuffer byteBuffer);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        dump(sb);
        return sb.toString();
    }

    public void write(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        NIOUtils.skip(byteBuffer, 8);
        doWrite(byteBuffer);
        this.header.setBodySize((byteBuffer.position() - byteBufferDuplicate.position()) - 8);
        Preconditions.checkState(this.header.headerSize() == 8);
        this.header.write(byteBufferDuplicate);
    }
}
