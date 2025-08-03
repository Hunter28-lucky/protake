package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.Boxes;
import org.jcodec.containers.mp4.IBoxFactory;

/* loaded from: classes2.dex */
public class IListBox extends Box {
    private static final String FOURCC = "ilst";
    private IBoxFactory factory;
    private Map<Integer, List<Box>> values;

    public static class LocalBoxes extends Boxes {
        public LocalBoxes() {
            this.mappings.put(DataBox.fourcc(), DataBox.class);
        }
    }

    public IListBox(Header header) {
        super(header);
        this.factory = new SimpleBoxFactory(new LocalBoxes());
        this.values = new LinkedHashMap();
    }

    public static IListBox createIListBox(Map<Integer, List<Box>> map) {
        IListBox iListBox = new IListBox(Header.createHeader(FOURCC, 0L));
        iListBox.values = map;
        return iListBox;
    }

    public static String fourcc() {
        return FOURCC;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        for (Map.Entry<Integer, List<Box>> entry : this.values.entrySet()) {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBuffer.putInt(0);
            byteBuffer.putInt(entry.getKey().intValue());
            Iterator<Box> it = entry.getValue().iterator();
            while (it.hasNext()) {
                it.next().write(byteBuffer);
            }
            byteBufferDuplicate.putInt(byteBuffer.position() - byteBufferDuplicate.position());
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        Iterator<Map.Entry<Integer, List<Box>>> it = this.values.entrySet().iterator();
        int iEstimateSize = 8;
        while (it.hasNext()) {
            Iterator<Box> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                iEstimateSize += it2.next().estimateSize() + 8;
            }
        }
        return iEstimateSize;
    }

    public Map<Integer, List<Box>> getValues() {
        return this.values;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= 4) {
            ByteBuffer byteBuffer2 = NIOUtils.read(byteBuffer, byteBuffer.getInt() - 4);
            int i = byteBuffer2.getInt();
            ArrayList arrayList = new ArrayList();
            this.values.put(Integer.valueOf(i), arrayList);
            while (byteBuffer2.hasRemaining()) {
                Header header = Header.read(byteBuffer2);
                if (header != null && byteBuffer2.remaining() >= header.getBodySize()) {
                    arrayList.add(Box.parseBox(NIOUtils.read(byteBuffer2, (int) header.getBodySize()), header, this.factory));
                }
            }
        }
    }
}
