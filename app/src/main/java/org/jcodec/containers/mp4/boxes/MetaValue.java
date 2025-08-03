package org.jcodec.containers.mp4.boxes;

import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class MetaValue {
    public static final int TYPE_BMP = 27;
    public static final int TYPE_FLOAT_32 = 23;
    public static final int TYPE_FLOAT_64 = 24;
    public static final int TYPE_INT_16 = 66;
    public static final int TYPE_INT_32 = 67;
    public static final int TYPE_INT_8 = 65;
    public static final int TYPE_INT_V = 22;
    public static final int TYPE_JPEG = 13;
    public static final int TYPE_PNG = 13;
    public static final int TYPE_STRING_UTF16 = 2;
    public static final int TYPE_STRING_UTF8 = 1;
    public static final int TYPE_UINT_V = 21;
    private byte[] data;
    private int locale;
    private int type;

    private MetaValue(int i, int i2, byte[] bArr) {
        this.type = i;
        this.locale = i2;
        this.data = bArr;
    }

    public static MetaValue createFloat(float f) {
        return new MetaValue(23, 0, fromFloat(f));
    }

    public static MetaValue createInt(int i) {
        return new MetaValue(21, 0, fromInt(i));
    }

    public static MetaValue createOther(int i, byte[] bArr) {
        return new MetaValue(i, 0, bArr);
    }

    public static MetaValue createOtherWithLocale(int i, int i2, byte[] bArr) {
        return new MetaValue(i, i2, bArr);
    }

    public static MetaValue createString(String str) {
        return new MetaValue(1, 0, Platform.getBytesForCharset(str, Platform.UTF_8));
    }

    private static byte[] fromFloat(float f) {
        byte[] bArr = new byte[4];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        byteBufferWrap.putFloat(f);
        return bArr;
    }

    private static byte[] fromInt(int i) {
        byte[] bArr = new byte[4];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        byteBufferWrap.putInt(i);
        return bArr;
    }

    private double toDouble(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getDouble();
    }

    private float toFloat(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getFloat();
    }

    private int toInt16(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getShort();
    }

    private int toInt24(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return (byteBufferWrap.get() & ExifInterface.MARKER) | ((byteBufferWrap.getShort() & 65535) << 8);
    }

    private int toInt32(byte[] bArr) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getInt();
    }

    public byte[] getData() {
        return this.data;
    }

    public double getFloat() {
        int i = this.type;
        if (i == 23) {
            return toFloat(this.data);
        }
        if (i == 24) {
            return toDouble(this.data);
        }
        return 0.0d;
    }

    public int getInt() {
        int i = this.type;
        if (i == 21 || i == 22) {
            byte[] bArr = this.data;
            int length = bArr.length;
            if (length == 1) {
                return bArr[0];
            }
            if (length == 2) {
                return toInt16(bArr);
            }
            if (length == 3) {
                return toInt24(bArr);
            }
            if (length == 4) {
                return toInt32(bArr);
            }
        }
        if (i == 65) {
            return this.data[0];
        }
        if (i == 66) {
            return toInt16(this.data);
        }
        if (i == 67) {
            return toInt32(this.data);
        }
        return 0;
    }

    public int getLocale() {
        return this.locale;
    }

    public String getString() {
        int i = this.type;
        if (i == 1) {
            return Platform.stringFromCharset(this.data, Platform.UTF_8);
        }
        if (i == 2) {
            return Platform.stringFromCharset(this.data, Platform.UTF_16BE);
        }
        return null;
    }

    public int getType() {
        return this.type;
    }

    public boolean isBlob() {
        return (isFloat() || isInt() || isString()) ? false : true;
    }

    public boolean isFloat() {
        int i = this.type;
        return i == 23 || i == 24;
    }

    public boolean isInt() {
        int i = this.type;
        return i == 21 || i == 22 || i == 65 || i == 66 || i == 67;
    }

    public boolean isString() {
        int i = this.type;
        return i == 1 || i == 2;
    }

    public String toString() {
        return isInt() ? String.valueOf(getInt()) : isFloat() ? String.valueOf(getFloat()) : isString() ? String.valueOf(getString()) : "BLOB";
    }
}
