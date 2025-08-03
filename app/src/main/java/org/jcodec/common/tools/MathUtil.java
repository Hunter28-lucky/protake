package org.jcodec.common.tools;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.mlkit.common.MlKitException;
import com.google.zxing.oned.Code39Reader;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.vpx.vp9.Consts;

/* loaded from: classes2.dex */
public class MathUtil {
    private static final int[] logTab = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
    private static final int[] reverseTab = {0, 128, 64, 192, 32, Consts.BORDERINPIXELS, 96, 224, 16, 144, 80, JpegConst.RST0, 48, 176, 112, 240, 8, 136, 72, 200, 40, 168, 104, JpegConst.APP8, 24, 152, 88, JpegConst.SOI, 56, MPEGConst.GROUP_START_CODE, 120, 248, 4, 132, 68, JpegConst.DHT, 36, 164, 100, JpegConst.APP4, 20, Code39Reader.ASTERISK_ENCODING, 84, JpegConst.RST4, 52, MPEGConst.SEQUENCE_ERROR_CODE, 116, H264Const.PROFILE_HIGH_444, 12, 140, 76, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 44, 172, 108, JpegConst.APPC, 28, 156, 92, 220, 60, TsConstants.TS_PACKET_SIZE, 124, 252, 2, 130, 66, JpegConst.SOF2, 34, 162, 98, JpegConst.APP2, 18, 146, 82, JpegConst.RST2, 50, MPEGConst.USER_DATA_START_CODE, 114, 242, 10, 138, 74, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 42, 170, 106, JpegConst.APPA, 26, 154, 90, JpegConst.SOS, 58, 186, 122, 250, 6, 134, 70, 198, 38, 166, 102, JpegConst.APP6, 22, 150, 86, JpegConst.RST6, 54, 182, 118, 246, 14, 142, 78, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 46, 174, 110, JpegConst.APPE, 30, 158, 94, 222, 62, 190, 126, JpegConst.COM, 1, 129, 65, JpegConst.SOF1, 33, 161, 97, JpegConst.APP1, 17, 145, 81, JpegConst.RST1, 49, 177, 113, 241, 9, 137, 73, 201, 41, 169, 105, JpegConst.APP9, 25, 153, 89, JpegConst.EOI, 57, 185, 121, 249, 5, 133, 69, 197, 37, 165, 101, JpegConst.APP5, 21, 149, 85, JpegConst.RST5, 53, MPEGConst.EXTENSION_START_CODE, 117, 245, 13, 141, 77, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 45, 173, 109, JpegConst.APPD, 29, 157, 93, JpegConst.DRI, 61, 189, 125, 253, 3, 131, 67, JpegConst.SOF3, 35, 163, 99, JpegConst.APP3, 19, 147, 83, JpegConst.RST3, 51, MPEGConst.SEQUENCE_HEADER_CODE, 115, 243, 11, 139, 75, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 43, 171, 107, JpegConst.APPB, 27, 155, 91, JpegConst.DQT, 59, 187, 123, 251, 7, 135, 71, 199, 39, 167, 103, JpegConst.APP7, 23, 151, 87, JpegConst.RST7, 55, MPEGConst.SEQUENCE_END_CODE, 119, 247, 15, 143, 79, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 47, MPEGConst.SLICE_START_CODE_LAST, 111, JpegConst.APPF, 31, 159, 95, 223, 63, 191, 127, 255};

    public static final int abs(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    public static final int clip(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static final int clipMax(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public static int cubeRoot(int i) {
        return 0;
    }

    public static int gcd(int i, int i2) {
        return i2 != 0 ? gcd(i2, i % i2) : i;
    }

    public static long gcdLong(long j, long j2) {
        return j2 != 0 ? gcdLong(j2, j % j2) : j;
    }

    public static final int golomb(int i) {
        if (i == 0) {
            return 0;
        }
        return (abs(i) << 1) - ((~i) >>> 31);
    }

    public static int log2(int i) {
        int i2;
        if (((-65536) & i) != 0) {
            i >>= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if ((65280 & i) != 0) {
            i >>= 8;
            i2 += 8;
        }
        return i2 + logTab[i];
    }

    public static int log2Slow(int i) {
        int i2 = 0;
        while ((Integer.MIN_VALUE & i) == 0) {
            i <<= 1;
            i2++;
        }
        return 31 - i2;
    }

    public static int log2l(long j) {
        int i = 32;
        if (((-4294967296L) & j) != 0) {
            j >>= 32;
        } else {
            i = 0;
        }
        if ((4294901760L & j) != 0) {
            j >>= 16;
            i += 16;
        }
        if ((65280 & j) != 0) {
            j >>= 8;
            i += 8;
        }
        return i + logTab[(int) j];
    }

    public static int max3(int i, int i2, int i3) {
        return Math.max(Math.max(i, i2), i3);
    }

    public static int nextPowerOfTwo(int i) {
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public static final int reverse(int i) {
        return reverseTab[i & 255];
    }

    public static final int sign(int i) {
        return -(i >> 31);
    }

    public static final int toSigned(int i, int i2) {
        return (i ^ i2) - i2;
    }

    public static int wrap(int i, int i2) {
        return i < 0 ? i + i2 : i >= i2 ? i - i2 : i;
    }
}
