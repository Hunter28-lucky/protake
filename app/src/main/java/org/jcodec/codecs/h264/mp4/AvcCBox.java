package org.jcodec.codecs.h264.mp4;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8;
import org.jcodec.common.Preconditions;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.containers.mp4.boxes.Box;
import org.jcodec.containers.mp4.boxes.Header;

/* loaded from: classes2.dex */
public class AvcCBox extends Box {
    private int level;
    private int nalLengthSize;
    private List<ByteBuffer> ppsList;
    private int profile;
    private int profileCompat;
    private List<ByteBuffer> spsList;

    public AvcCBox(Header header) {
        super(header);
        this.spsList = new ArrayList();
        this.ppsList = new ArrayList();
    }

    public static AvcCBox createAvcCBox(int i, int i2, int i3, int i4, List<ByteBuffer> list, List<ByteBuffer> list2) {
        AvcCBox avcCBox = new AvcCBox(new Header(fourcc()));
        avcCBox.profile = i;
        avcCBox.profileCompat = i2;
        avcCBox.level = i3;
        avcCBox.nalLengthSize = i4;
        avcCBox.spsList = list;
        avcCBox.ppsList = list2;
        return avcCBox;
    }

    public static AvcCBox createEmpty() {
        return new AvcCBox(new Header(fourcc()));
    }

    public static String fourcc() {
        return "avcC";
    }

    public static AvcCBox parseAvcCBox(ByteBuffer byteBuffer) {
        AvcCBox avcCBox = new AvcCBox(new Header(fourcc()));
        avcCBox.parse(byteBuffer);
        return avcCBox;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) this.profile);
        byteBuffer.put((byte) this.profileCompat);
        byteBuffer.put((byte) this.level);
        byteBuffer.put((byte) -1);
        byteBuffer.put((byte) (this.spsList.size() | 224));
        for (ByteBuffer byteBuffer2 : this.spsList) {
            byteBuffer.putShort((short) (byteBuffer2.remaining() + 1));
            byteBuffer.put((byte) 103);
            NIOUtils.write(byteBuffer, byteBuffer2);
        }
        byteBuffer.put((byte) this.ppsList.size());
        for (ByteBuffer byteBuffer3 : this.ppsList) {
            byteBuffer.putShort((byte) (byteBuffer3.remaining() + 1));
            byteBuffer.put((byte) 104);
            NIOUtils.write(byteBuffer, byteBuffer3);
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        Iterator<ByteBuffer> it = this.spsList.iterator();
        int iRemaining = 17;
        while (it.hasNext()) {
            iRemaining += it.next().remaining() + 3;
        }
        Iterator<ByteBuffer> it2 = this.ppsList.iterator();
        while (it2.hasNext()) {
            iRemaining += it2.next().remaining() + 3;
        }
        return iRemaining;
    }

    public int getLevel() {
        return this.level;
    }

    public int getNalLengthSize() {
        return this.nalLengthSize;
    }

    public List<ByteBuffer> getPpsList() {
        return this.ppsList;
    }

    public int getProfile() {
        return this.profile;
    }

    public int getProfileCompat() {
        return this.profileCompat;
    }

    public List<ByteBuffer> getSpsList() {
        return this.spsList;
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        NIOUtils.skip(byteBuffer, 1);
        this.profile = byteBuffer.get() & ExifInterface.MARKER;
        this.profileCompat = byteBuffer.get() & ExifInterface.MARKER;
        this.level = byteBuffer.get() & ExifInterface.MARKER;
        this.nalLengthSize = (byteBuffer.get() & ExifInterface.MARKER & 3) + 1;
        int i = byteBuffer.get() & 31;
        for (int i2 = 0; i2 < i; i2++) {
            short s = byteBuffer.getShort();
            Preconditions.checkState(39 == (byteBuffer.get() & Utf8.REPLACEMENT_BYTE));
            this.spsList.add(NIOUtils.read(byteBuffer, s - 1));
        }
        int i3 = byteBuffer.get() & ExifInterface.MARKER;
        for (int i4 = 0; i4 < i3; i4++) {
            short s2 = byteBuffer.getShort();
            Preconditions.checkState(40 == (byteBuffer.get() & Utf8.REPLACEMENT_BYTE));
            this.ppsList.add(NIOUtils.read(byteBuffer, s2 - 1));
        }
    }
}
