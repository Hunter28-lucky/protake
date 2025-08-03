package org.jcodec.containers.mp4.boxes;

import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.containers.mp4.IBoxFactory;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class NodeBox extends Box {
    public List<Box> boxes;
    public IBoxFactory factory;

    public NodeBox(Header header) {
        super(header);
        this.boxes = new LinkedList();
    }

    public static Box cloneBox(Box box, int i, IBoxFactory iBoxFactory) {
        return doCloneBox(box, i, iBoxFactory);
    }

    public static Box doCloneBox(Box box, int i, IBoxFactory iBoxFactory) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        box.write(byteBufferAllocate);
        byteBufferAllocate.flip();
        return parseChildBox(byteBufferAllocate, iBoxFactory);
    }

    public static <T extends Box> T[] findAll(Box box, Class<T> cls, String str) {
        return (T[]) findAllPath(box, cls, new String[]{str});
    }

    public static <T extends Box> T[] findAllPath(Box box, Class<T> cls, String[] strArr) {
        LinkedList linkedList = new LinkedList();
        findBox(box, new ArrayList(Arrays.asList(strArr)), linkedList);
        ListIterator listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            Box box2 = (Box) listIterator.next();
            if (box2 == null) {
                listIterator.remove();
            } else if (!Platform.isAssignableFrom(cls, box2.getClass())) {
                try {
                    listIterator.set(Box.asBox(cls, box2));
                } catch (Exception e2) {
                    Logger.warn("Failed to reinterpret box: " + box2.getFourcc() + " as: " + cls.getName() + "." + e2.getMessage());
                    listIterator.remove();
                }
            }
        }
        return (T[]) ((Box[]) linkedList.toArray((Box[]) Array.newInstance((Class<?>) cls, 0)));
    }

    public static void findBox(Box box, List<String> list, Collection<Box> collection) {
        if (list.size() <= 0) {
            collection.add(box);
            return;
        }
        String strRemove = list.remove(0);
        if (box instanceof NodeBox) {
            for (Box box2 : ((NodeBox) box).getBoxes()) {
                if (strRemove == null || strRemove.equals(box2.header.getFourcc())) {
                    findBox(box2, list, collection);
                }
            }
        }
        list.add(0, strRemove);
    }

    public static <T extends Box> T[] findDeep(Box box, Class<T> cls, String str) {
        ArrayList arrayList = new ArrayList();
        findDeepInner(box, cls, str, arrayList);
        return (T[]) ((Box[]) arrayList.toArray((Box[]) Array.newInstance((Class<?>) cls, 0)));
    }

    public static <T extends Box> void findDeepInner(Box box, Class<T> cls, String str, List<T> list) {
        if (box == null) {
            return;
        }
        if (str.equals(box.getHeader().getFourcc())) {
            list.add(box);
        } else if (box instanceof NodeBox) {
            Iterator<Box> it = ((NodeBox) box).getBoxes().iterator();
            while (it.hasNext()) {
                findDeepInner(it.next(), cls, str, list);
            }
        }
    }

    public static <T extends Box> T findFirst(NodeBox nodeBox, Class<T> cls, String str) {
        return (T) findFirstPath(nodeBox, cls, new String[]{str});
    }

    public static <T extends Box> T findFirstPath(NodeBox nodeBox, Class<T> cls, String[] strArr) {
        Box[] boxArrFindAllPath = findAllPath(nodeBox, cls, strArr);
        if (boxArrFindAllPath.length > 0) {
            return (T) boxArrFindAllPath[0];
        }
        return null;
    }

    public static Box parseChildBox(ByteBuffer byteBuffer, IBoxFactory iBoxFactory) {
        Header header;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        while (byteBuffer.remaining() >= 4 && byteBufferDuplicate.getInt() == 0) {
            byteBuffer.getInt();
        }
        if (byteBuffer.remaining() >= 4 && (header = Header.read(byteBuffer)) != null && byteBuffer.remaining() >= header.getBodySize()) {
            return Box.parseBox(NIOUtils.read(byteBuffer, (int) header.getBodySize()), header, iBoxFactory);
        }
        return null;
    }

    public void add(Box box) {
        this.boxes.add(box);
    }

    public void addFirst(MovieHeaderBox movieHeaderBox) {
        this.boxes.add(0, movieHeaderBox);
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        Iterator<Box> it = this.boxes.iterator();
        while (it.hasNext()) {
            it.next().write(byteBuffer);
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void dump(StringBuilder sb) {
        sb.append("{\"tag\":\"" + this.header.getFourcc() + "\",");
        sb.append("\"boxes\": [");
        dumpBoxes(sb);
        sb.append("]");
        sb.append("}");
    }

    public void dumpBoxes(StringBuilder sb) {
        for (int i = 0; i < this.boxes.size(); i++) {
            this.boxes.get(i).dump(sb);
            if (i < this.boxes.size() - 1) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        Iterator<Box> it = this.boxes.iterator();
        int iEstimateSize = 0;
        while (it.hasNext()) {
            iEstimateSize += it.next().estimateSize();
        }
        return iEstimateSize + Header.estimateHeaderSize(iEstimateSize);
    }

    public List<Box> getBoxes() {
        return this.boxes;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        while (byteBuffer.remaining() >= 8) {
            Box childBox = parseChildBox(byteBuffer, this.factory);
            if (childBox != null) {
                this.boxes.add(childBox);
            }
        }
    }

    public void removeChildren(String[] strArr) {
        Iterator<Box> it = this.boxes.iterator();
        while (it.hasNext()) {
            String fourcc = it.next().getFourcc();
            int i = 0;
            while (true) {
                if (i >= strArr.length) {
                    break;
                }
                if (strArr[i].equals(fourcc)) {
                    it.remove();
                    break;
                }
                i++;
            }
        }
    }

    public void replace(String str, Box box) {
        removeChildren(new String[]{str});
        add(box);
    }

    public void replaceBox(Box box) {
        removeChildren(new String[]{box.getFourcc()});
        add(box);
    }

    public void setFactory(IBoxFactory iBoxFactory) {
        this.factory = iBoxFactory;
    }
}
