package com.google.zxing.datamatrix.encoder;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.mlkit.common.MlKitException;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.vpx.vp9.Consts;

/* loaded from: classes2.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{JpegConst.APP4, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, JpegConst.COM}, new int[]{28, 24, 185, 166, 223, 248, 116, 255, 110, 61}, new int[]{MPEGConst.SLICE_START_CODE_LAST, 138, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 12, JpegConst.SOF2, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, JpegConst.RST5, 97, MPEGConst.USER_DATA_START_CODE, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, JpegConst.SOF3, 100, 39, TsConstants.TS_PACKET_SIZE, 75, 66, 61, 241, JpegConst.RST5, 109, 129, 94, JpegConst.COM, JpegConst.APP1, 48, 90, TsConstants.TS_PACKET_SIZE}, new int[]{15, JpegConst.SOF3, H264Const.PROFILE_HIGH_444, 9, JpegConst.APP9, 71, 168, 2, TsConstants.TS_PACKET_SIZE, Consts.BORDERINPIXELS, 153, 145, 253, 79, 108, 82, 27, 174, 186, 172}, new int[]{52, 190, 88, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 109, 39, 176, 21, 155, 197, 251, 223, 155, 21, 5, 172, JpegConst.COM, 124, 12, MPEGConst.EXTENSION_START_CODE, MPEGConst.GROUP_START_CODE, 96, 50, JpegConst.SOF1}, new int[]{JpegConst.RST3, JpegConst.APP7, 43, 97, 71, 96, 103, 174, 37, 151, 170, 53, 75, 34, 249, 121, 17, 138, 110, JpegConst.RST5, 141, 136, 120, 151, JpegConst.APP9, 168, 93, 255}, new int[]{245, 127, 242, JpegConst.SOS, 130, 250, 162, MPEGConst.EXTENSION_START_CODE, 102, 120, 84, MPEGConst.SEQUENCE_HEADER_CODE, 220, 251, 80, 182, JpegConst.APP5, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, MPEGConst.SLICE_START_CODE_LAST, MPEGConst.GROUP_START_CODE, 59, 25, JpegConst.APP1, 98, 81, 112}, new int[]{77, JpegConst.SOF1, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, MPEGConst.SLICE_START_CODE_LAST, 95, 100, 9, 167, 105, JpegConst.RST6, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 69, 50, 150, 177, JpegConst.APP2, 5, 9, 5}, new int[]{245, 132, 172, 223, 96, 32, 117, 22, JpegConst.APPE, 133, JpegConst.APPE, JpegConst.APP7, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, TsConstants.TS_PACKET_SIZE, JpegConst.APPD, 87, 191, 106, 16, 147, 118, 23, 37, 90, 170, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, 187, 147, Consts.BORDERINPIXELS, MPEGConst.SLICE_START_CODE_LAST, 69, JpegConst.RST5, 92, 253, JpegConst.APP1, 19}, new int[]{MPEGConst.SLICE_START_CODE_LAST, 9, 223, JpegConst.APPE, 12, 17, 220, JpegConst.RST0, 100, 29, MPEGConst.SLICE_START_CODE_LAST, 170, JpegConst.APP6, 192, JpegConst.RST7, JpegConst.APPB, 150, 159, 36, 223, 38, 200, 132, 54, JpegConst.APP4, 146, JpegConst.SOS, JpegConst.APPA, 117, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 29, JpegConst.APP8, 144, JpegConst.APPE, 22, 150, 201, 117, 62, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 164, 13, 137, 245, 127, 67, 247, 28, 155, 43, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 107, JpegConst.APP9, 53, 143, 46}, new int[]{242, 93, 169, 50, 144, JpegConst.RST2, 39, 118, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, TsConstants.TS_PACKET_SIZE, 201, 189, 143, 108, JpegConst.DHT, 37, 185, 112, 134, JpegConst.APP6, 245, 63, 197, 190, 250, 106, 185, JpegConst.DRI, MPEGConst.SLICE_START_CODE_LAST, 64, 114, 71, 161, 44, 147, 6, 27, JpegConst.SOS, 51, 63, 87, 10, 40, 130, TsConstants.TS_PACKET_SIZE, 17, 163, 31, 176, 170, 4, 107, JpegConst.APP8, 7, 94, 166, 224, 124, 86, 47, 11, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{220, JpegConst.APP4, 173, 89, 251, 149, 159, 56, 89, 33, 147, H264Const.PROFILE_HIGH_444, 154, 36, 73, 127, JpegConst.RST5, 136, 248, MPEGConst.SEQUENCE_ERROR_CODE, JpegConst.APPA, 197, 158, 177, 68, 122, 93, JpegConst.RST5, 15, Consts.BORDERINPIXELS, JpegConst.APP3, JpegConst.APPC, 66, 139, 153, 185, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 167, MPEGConst.SEQUENCE_HEADER_CODE, 25, 220, JpegConst.APP8, 96, JpegConst.RST2, JpegConst.APP7, 136, 223, JpegConst.APPF, MPEGConst.EXTENSION_START_CODE, 241, 59, 52, 172, 25, 49, JpegConst.APP8, JpegConst.RST3, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        return createECCBlock(charSequence, 0, charSequence.length(), i);
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int[] iArr3 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                iArr3[i] = 0;
                if (i > 0) {
                    iArr3[i] = iArr3[i - 1] + iArr[i];
                }
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i5, strCreateECCBlock.charAt(i6));
                    i5 += interleavedBlockCount;
                    i6++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i6 >= iArr.length) {
                i6 = -1;
                break;
            }
            if (iArr[i6] == i3) {
                break;
            }
            i6++;
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i3);
        }
        int[] iArr2 = FACTORS[i6];
        char[] cArr = new char[i3];
        for (int i7 = 0; i7 < i3; i7++) {
            cArr[i7] = 0;
        }
        for (int i8 = i; i8 < i + i2; i8++) {
            int i9 = i3 - 1;
            int iCharAt = cArr[i9] ^ charSequence.charAt(i8);
            while (i9 > 0) {
                if (iCharAt == 0 || (i5 = iArr2[i9]) == 0) {
                    cArr[i9] = cArr[i9 - 1];
                } else {
                    char c = cArr[i9 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i9] = (char) (iArr3[(iArr4[iCharAt] + iArr4[i5]) % 255] ^ c);
                }
                i9--;
            }
            if (iCharAt == 0 || (i4 = iArr2[0]) == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[i4]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        for (int i10 = 0; i10 < i3; i10++) {
            cArr2[i10] = cArr[(i3 - i10) - 1];
        }
        return String.valueOf(cArr2);
    }
}
