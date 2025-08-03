package org.jcodec.scale;

import androidx.exifinterface.media.ExifInterface;
import com.uc.crashsdk.export.LogType;
import java.nio.ByteBuffer;
import org.jcodec.codecs.mjpeg.JpegConst;

/* loaded from: classes2.dex */
public class ImageConvert {
    private static final int CROP = 1024;
    private static final int ONE_HALF = 512;
    private static final int SCALEBITS = 10;
    private static final int FIX_0_71414 = FIX(0.71414d);
    private static final int FIX_1_772 = FIX(1.772d);
    private static final int _FIX_0_34414 = -FIX(0.34414d);
    private static final int FIX_1_402 = FIX(1.402d);
    private static final byte[] cropTable = new byte[LogType.UNEXP_LOW_MEMORY];
    private static final int[] intCropTable = new int[LogType.UNEXP_LOW_MEMORY];
    private static final byte[] _y_ccir_to_jpeg = new byte[256];
    private static final byte[] _y_jpeg_to_ccir = new byte[256];

    static {
        int i;
        int i2 = -1024;
        while (true) {
            if (i2 >= 0) {
                break;
            }
            int i3 = i2 + 1024;
            cropTable[i3] = 0;
            intCropTable[i3] = 0;
            i2++;
        }
        for (int i4 = 0; i4 < 256; i4++) {
            int i5 = i4 + 1024;
            cropTable[i5] = (byte) i4;
            intCropTable[i5] = i4;
        }
        for (int i6 = 256; i6 < 1024; i6++) {
            int i7 = i6 + 1024;
            cropTable[i7] = -1;
            intCropTable[i7] = 255;
        }
        for (i = 0; i < 256; i++) {
            _y_ccir_to_jpeg[i] = crop(Y_CCIR_TO_JPEG(i));
            _y_jpeg_to_ccir[i] = crop(Y_JPEG_TO_CCIR(i));
        }
    }

    private static final int FIX(double d) {
        return (int) ((d * 1024.0d) + 0.5d);
    }

    public static byte RGB888toU4(int i, int i2, int i3) {
        return crop((((((i * (-38)) - (i2 * 74)) + (i3 * 112)) + 128) >> 8) + 128);
    }

    public static byte RGB888toV4(int i, int i2, int i3) {
        return crop((((((i * 112) - (i2 * 94)) - (i3 * 18)) + 128) >> 8) + 128);
    }

    public static byte RGB888toY4(int i, int i2, int i3) {
        return crop((((((i * 66) + (i2 * 129)) + (i3 * 25)) + 128) >> 8) + 16);
    }

    public static void RGB888toYUV444(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, ByteBuffer byteBuffer4) {
        int i = byteBuffer.get() & ExifInterface.MARKER;
        int i2 = byteBuffer.get() & ExifInterface.MARKER;
        int i3 = byteBuffer.get() & ExifInterface.MARKER;
        int i4 = (i * 66) + (i2 * 129) + (i3 * 25);
        int i5 = ((i * (-38)) - (i2 * 74)) + (i3 * 112);
        byteBuffer2.put(crop(((i4 + 128) >> 8) + 16));
        byteBuffer3.put(crop(((i5 + 128) >> 8) + 128));
        byteBuffer4.put(crop((((((i * 112) - (i2 * 94)) - (i3 * 18)) + 128) >> 8) + 128));
    }

    public static void YUV444toRGB888(int i, int i2, int i3, ByteBuffer byteBuffer) {
        int i4 = i2 - 128;
        int i5 = i3 - 128;
        int i6 = (i - 16) * 298;
        int i7 = (((i5 * 409) + i6) + 128) >> 8;
        int i8 = (((i6 - (i4 * 100)) - (i5 * JpegConst.RST0)) + 128) >> 8;
        byteBuffer.put(crop(i7));
        byteBuffer.put(crop(i8));
        byteBuffer.put(crop(((i6 + (i4 * 516)) + 128) >> 8));
    }

    public static final int Y_CCIR_TO_JPEG(int i) {
        return ((i * FIX(1.1643835616438356d)) + (512 - (FIX(1.1643835616438356d) * 16))) >> 10;
    }

    public static final int Y_JPEG_TO_CCIR(int i) {
        return ((i * FIX(0.8588235294117647d)) + 16896) >> 10;
    }

    public static final byte crop(int i) {
        return cropTable[i + 1024];
    }

    public static final int icrop(int i) {
        return intCropTable[i + 1024];
    }

    public static final byte y_ccir_to_jpeg(byte b) {
        return _y_ccir_to_jpeg[b & ExifInterface.MARKER];
    }

    public static final byte y_jpeg_to_ccir(byte b) {
        return _y_jpeg_to_ccir[b & ExifInterface.MARKER];
    }

    public static final int ycbcr_to_rgb24(int i, int i2, int i3) {
        int i4 = i << 10;
        int i5 = i2 - 128;
        int i6 = i3 - 128;
        int i7 = (FIX_1_402 * i6) + 512;
        int i8 = ((_FIX_0_34414 * i5) - (FIX_0_71414 * i6)) + 512;
        int i9 = (FIX_1_772 * i5) + 512;
        int i10 = (i7 + i4) >> 10;
        int i11 = (i8 + i4) >> 10;
        int i12 = (i4 + i9) >> 10;
        byte bCrop = crop(i10);
        byte bCrop2 = crop(i11);
        return (crop(i12) & ExifInterface.MARKER) | ((bCrop & ExifInterface.MARKER) << 16) | ((bCrop2 & ExifInterface.MARKER) << 8);
    }
}
