package org.jcodec.containers.mp4;

import java.nio.ByteBuffer;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Header;
import org.jcodec.containers.mp4.boxes.NodeBox;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class BoxUtil {
    public static <T extends Box> T as(Class<T> cls, Box.LeafBox leafBox) {
        try {
            T t = (T) Platform.newInstance(cls, new Object[]{leafBox.getHeader()});
            t.parse(leafBox.getData().duplicate());
            return t;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean containsBox(NodeBox nodeBox, String str) {
        return NodeBox.findFirstPath(nodeBox, Box.class, new String[]{str}) != null;
    }

    public static boolean containsBox2(NodeBox nodeBox, String str, String str2) {
        return NodeBox.findFirstPath(nodeBox, Box.class, new String[]{str, str2}) != null;
    }

    public static Box parseBox(ByteBuffer byteBuffer, Header header, IBoxFactory iBoxFactory) {
        Box boxNewBox = iBoxFactory.newBox(header);
        if (header.getBodySize() >= 134217728) {
            return new Box.LeafBox(Header.createHeader("free", 8L));
        }
        boxNewBox.parse(byteBuffer);
        return boxNewBox;
    }

    public static Box parseChildBox(ByteBuffer byteBuffer, IBoxFactory iBoxFactory) {
        Header header;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBuffer.remaining() >= 4 && byteBufferDuplicate.getInt() == 0) {
            byteBuffer.getInt();
        }
        if (byteBuffer.remaining() >= 4 && (header = Header.read(byteBuffer)) != null && byteBuffer.remaining() >= header.getBodySize()) {
            return parseBox(NIOUtils.read(byteBuffer, (int) header.getBodySize()), header, iBoxFactory);
        }
        return null;
    }
}
