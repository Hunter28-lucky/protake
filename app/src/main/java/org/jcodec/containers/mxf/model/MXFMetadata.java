package org.jcodec.containers.mxf.model;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.Calendar;
import java.util.Date;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public abstract class MXFMetadata {
    public UL uid;
    public UL ul;

    public MXFMetadata(UL ul) {
        this.ul = ul;
    }

    public static Date readDate(ByteBuffer byteBuffer) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, byteBuffer.getShort());
        calendar.set(2, byteBuffer.get());
        calendar.set(5, byteBuffer.get());
        calendar.set(10, byteBuffer.get());
        calendar.set(12, byteBuffer.get());
        calendar.set(13, byteBuffer.get());
        calendar.set(14, (byteBuffer.get() & ExifInterface.MARKER) << 2);
        return calendar.getTime();
    }

    public static int[] readInt32Batch(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = byteBuffer.getInt();
        }
        return iArr;
    }

    public static UL[] readULBatch(ByteBuffer byteBuffer) {
        int i = byteBuffer.getInt();
        byteBuffer.getInt();
        UL[] ulArr = new UL[i];
        for (int i2 = 0; i2 < i; i2++) {
            ulArr[i2] = UL.read(byteBuffer);
        }
        return ulArr;
    }

    public UL getUid() {
        return this.uid;
    }

    public UL getUl() {
        return this.ul;
    }

    public abstract void readBuf(ByteBuffer byteBuffer);

    public String readUtf16String(ByteBuffer byteBuffer) {
        return Platform.stringFromCharset(byteBuffer.getShort(byteBuffer.limit() + (-2)) != 0 ? NIOUtils.toArray(byteBuffer) : NIOUtils.toArray((ByteBuffer) byteBuffer.limit(byteBuffer.limit() - 2)), Platform.UTF_16);
    }
}
