package org.jcodec.codecs.vpx;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.mlkit.common.MlKitException;
import com.google.zxing.oned.Code39Reader;
import java.lang.reflect.Array;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.vpx.vp9.Consts;

/* loaded from: classes2.dex */
public class VP8Util {
    public static final int BLOCK_TYPES = 4;
    public static final int COEF_BANDS = 8;
    public static final int MAX_ENTROPY_TOKENS = 12;
    public static final int MAX_MODE_LF_DELTAS = 4;
    public static final int MAX_REF_LF_DELTAS = 4;
    public static final int MB_FEATURE_TREE_PROBS = 3;
    public static final int PREV_COEF_CONTEXTS = 3;
    public static int[] vp8KeyFrameUVModeProb = {142, 114, MPEGConst.SEQUENCE_END_CODE};
    public static int[] vp8UVModeTree = {0, 2, -1, 4, -2, -3};
    public static int[] keyFrameYModeProb = {145, 156, 163, 128};
    public static int[] keyFrameYModeTree = {-4, 2, 4, 6, 0, -1, -2, -3};
    public static int[] segmentTree = {2, 4, 0, -1, -2, -3};
    public static final int[] PRED_BLOCK_127 = {127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127};
    public static final int[] PRED_BLOCK_129 = {129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129, 129};
    private static int[][][][] vp8DefaultCoefProbs = {new int[][][]{new int[][]{new int[]{128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}}, new int[][]{new int[]{253, 136, JpegConst.COM, 255, JpegConst.APP4, JpegConst.DQT, 128, 128, 128, 128, 128}, new int[]{189, 129, 242, 255, JpegConst.APP3, JpegConst.RST5, 255, JpegConst.DQT, 128, 128, 128}, new int[]{106, 126, JpegConst.APP3, 252, JpegConst.RST6, JpegConst.RST1, 255, 255, 128, 128, 128}}, new int[][]{new int[]{1, 98, 248, 255, JpegConst.APPC, JpegConst.APP2, 255, 255, 128, 128, 128}, new int[]{MPEGConst.EXTENSION_START_CODE, 133, JpegConst.APPE, JpegConst.COM, JpegConst.DRI, JpegConst.APPA, 255, 154, 128, 128, 128}, new int[]{78, 134, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 247, 198, MPEGConst.SEQUENCE_ERROR_CODE, 255, JpegConst.DQT, 128, 128, 128}}, new int[][]{new int[]{1, 185, 249, 255, 243, 255, 128, 128, 128, 128, 128}, new int[]{MPEGConst.GROUP_START_CODE, 150, 247, 255, JpegConst.APPC, 224, 128, 128, 128, 128, 128}, new int[]{77, 110, JpegConst.SOI, 255, JpegConst.APPC, JpegConst.APP6, 128, 128, 128, 128, 128}}, new int[][]{new int[]{1, 101, 251, 255, 241, 255, 128, 128, 128, 128, 128}, new int[]{170, 139, 241, 252, JpegConst.APPC, JpegConst.RST1, 255, 255, 128, 128, 128}, new int[]{37, 116, JpegConst.DHT, 243, JpegConst.APP4, 255, 255, 255, 128, 128, 128}}, new int[][]{new int[]{1, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, JpegConst.COM, 255, 245, 255, 128, 128, 128, 128, 128}, new int[]{MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, Consts.BORDERINPIXELS, 250, 255, JpegConst.APPE, 128, 128, 128, 128, 128, 128}, new int[]{102, 103, JpegConst.APP7, 255, JpegConst.RST3, 171, 128, 128, 128, 128, 128}}, new int[][]{new int[]{1, 152, 252, 255, 240, 255, 128, 128, 128, 128, 128}, new int[]{177, 135, 243, 255, JpegConst.APPA, JpegConst.APP1, 128, 128, 128, 128, 128}, new int[]{80, 129, JpegConst.RST3, 255, JpegConst.SOF2, 224, 128, 128, 128, 128, 128}}, new int[][]{new int[]{1, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{246, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{255, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}}}, new int[][][]{new int[][]{new int[]{198, 35, JpegConst.APPD, 223, JpegConst.SOF1, 187, 162, Consts.BORDERINPIXELS, 145, 155, 62}, new int[]{131, 45, 198, JpegConst.DRI, 172, 176, 220, 157, 252, JpegConst.DRI, 1}, new int[]{68, 47, 146, JpegConst.RST0, 149, 167, JpegConst.DRI, 162, 255, 223, 128}}, new int[][]{new int[]{1, 149, 241, 255, JpegConst.DRI, 224, 255, 255, 128, 128, 128}, new int[]{MPEGConst.GROUP_START_CODE, 141, JpegConst.APPA, 253, 222, 220, 255, 199, 128, 128, 128}, new int[]{81, 99, MPEGConst.EXTENSION_START_CODE, 242, 176, 190, 249, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 255, 255, 128}}, new int[][]{new int[]{1, 129, JpegConst.APP8, 253, JpegConst.RST6, 197, 242, JpegConst.DHT, 255, 255, 128}, new int[]{99, 121, JpegConst.RST2, 250, 201, 198, 255, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 128, 128, 128}, new int[]{23, 91, 163, 242, 170, 187, 247, JpegConst.RST2, 255, 255, 128}}, new int[][]{new int[]{1, 200, 246, 255, JpegConst.APPA, 255, 128, 128, 128, 128, 128}, new int[]{109, MPEGConst.USER_DATA_START_CODE, 241, 255, JpegConst.APP7, 245, 255, 255, 128, 128, 128}, new int[]{44, 130, 201, 253, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 192, 255, 255, 128, 128, 128}}, new int[][]{new int[]{1, 132, JpegConst.APPF, 251, JpegConst.DQT, JpegConst.RST1, 255, 165, 128, 128, 128}, new int[]{94, 136, JpegConst.APP1, 251, JpegConst.SOS, 190, 255, 255, 128, 128, 128}, new int[]{22, 100, 174, 245, 186, 161, 255, 199, 128, 128, 128}}, new int[][]{new int[]{1, 182, 249, 255, JpegConst.APP8, JpegConst.APPB, 128, 128, 128, 128, 128}, new int[]{124, 143, 241, 255, JpegConst.APP3, JpegConst.APPA, 128, 128, 128, 128, 128}, new int[]{35, 77, MPEGConst.EXTENSION_START_CODE, 251, JpegConst.SOF1, JpegConst.RST3, 255, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 128, 128, 128}}, new int[][]{new int[]{1, 157, 247, 255, JpegConst.APPC, JpegConst.APP7, 255, 255, 128, 128, 128}, new int[]{121, 141, JpegConst.APPB, 255, JpegConst.APP1, JpegConst.APP3, 255, 255, 128, 128, 128}, new int[]{45, 99, TsConstants.TS_PACKET_SIZE, 251, JpegConst.SOF3, JpegConst.EOI, 255, 224, 128, 128, 128}}, new int[][]{new int[]{1, 1, 251, 255, JpegConst.RST5, 255, 128, 128, 128, 128, 128}, new int[]{MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 1, 248, 255, 255, 128, 128, 128, 128, 128, 128}, new int[]{137, 1, 177, 255, 224, 255, 128, 128, 128, 128, 128}}}, new int[][][]{new int[][]{new int[]{253, 9, 248, 251, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, JpegConst.RST0, 255, 192, 128, 128, 128}, new int[]{MPEGConst.SLICE_START_CODE_LAST, 13, 224, 243, JpegConst.SOF1, 185, 249, 198, 255, 255, 128}, new int[]{73, 17, 171, JpegConst.DRI, 161, MPEGConst.SEQUENCE_HEADER_CODE, JpegConst.APPC, 167, 255, JpegConst.APPA, 128}}, new int[][]{new int[]{1, 95, 247, 253, JpegConst.RST4, MPEGConst.SEQUENCE_END_CODE, 255, 255, 128, 128, 128}, new int[]{JpegConst.APPF, 90, H264Const.PROFILE_HIGH_444, 250, JpegConst.RST3, JpegConst.RST1, 255, 255, 128, 128, 128}, new int[]{155, 77, JpegConst.SOF3, 248, TsConstants.TS_PACKET_SIZE, JpegConst.SOF3, 255, 255, 128, 128, 128}}, new int[][]{new int[]{1, 24, JpegConst.APPF, 251, JpegConst.SOS, JpegConst.DQT, 255, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 128, 128, 128}, new int[]{201, 51, JpegConst.DQT, 255, JpegConst.DHT, 186, 128, 128, 128, 128, 128}, new int[]{69, 46, 190, JpegConst.APPF, 201, JpegConst.SOS, 255, JpegConst.APP4, 128, 128, 128}}, new int[][]{new int[]{1, 191, 251, 255, 255, 128, 128, 128, 128, 128, 128}, new int[]{223, 165, 249, 255, JpegConst.RST5, 255, 128, 128, 128, 128, 128}, new int[]{141, 124, 248, 255, 255, 128, 128, 128, 128, 128, 128}}, new int[][]{new int[]{1, 16, 248, 255, 255, 128, 128, 128, 128, 128, 128}, new int[]{190, 36, JpegConst.APP6, 255, JpegConst.APPC, 255, 128, 128, 128, 128, 128}, new int[]{149, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128}}, new int[][]{new int[]{1, JpegConst.APP2, 255, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{247, 192, 255, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{240, 128, 255, 128, 128, 128, 128, 128, 128, 128, 128}}, new int[][]{new int[]{1, 134, 252, 255, 255, 128, 128, 128, 128, 128, 128}, new int[]{JpegConst.RST5, 62, 250, 255, 255, 128, 128, 128, 128, 128, 128}, new int[]{55, 93, 255, 128, 128, 128, 128, 128, 128, 128, 128}}, new int[][]{new int[]{128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128}}}, new int[][][]{new int[][]{new int[]{MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 24, JpegConst.RST5, JpegConst.APPB, 186, 191, 220, Consts.BORDERINPIXELS, 240, MPEGConst.SLICE_START_CODE_LAST, 255}, new int[]{126, 38, 182, JpegConst.APP8, 169, MPEGConst.GROUP_START_CODE, JpegConst.APP4, 174, 255, 187, 128}, new int[]{61, 46, 138, JpegConst.DQT, 151, MPEGConst.USER_DATA_START_CODE, 240, 170, 255, JpegConst.SOI, 128}}, new int[][]{new int[]{1, 112, JpegConst.APP6, 250, 199, 191, 247, 159, 255, 255, 128}, new int[]{166, 109, JpegConst.APP4, 252, JpegConst.RST3, JpegConst.RST7, 255, 174, 128, 128, 128}, new int[]{39, 77, 162, JpegConst.APP8, 172, MPEGConst.SEQUENCE_ERROR_CODE, 245, MPEGConst.USER_DATA_START_CODE, 255, 255, 128}}, new int[][]{new int[]{1, 52, 220, 246, 198, 199, 249, 220, 255, 255, 128}, new int[]{124, 74, 191, 243, MPEGConst.SEQUENCE_END_CODE, JpegConst.SOF1, 250, JpegConst.DRI, 255, 255, 128}, new int[]{24, 71, 130, JpegConst.DQT, 154, 170, 243, 182, 255, 255, 128}}, new int[][]{new int[]{1, 182, JpegConst.APP1, 249, JpegConst.DQT, 240, 255, 224, 128, 128, 128}, new int[]{149, 150, JpegConst.APP2, 252, JpegConst.SOI, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 255, 171, 128, 128, 128}, new int[]{28, 108, 170, 242, MPEGConst.SEQUENCE_END_CODE, JpegConst.SOF2, JpegConst.COM, 223, 255, 255, 128}}, new int[][]{new int[]{1, 81, JpegConst.APP6, 252, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 255, 192, 128, 128, 128}, new int[]{123, 102, JpegConst.RST1, 247, TsConstants.TS_PACKET_SIZE, JpegConst.DHT, 255, JpegConst.APP9, 128, 128, 128}, new int[]{20, 95, 153, 243, 164, 173, 255, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 128, 128, 128}}, new int[][]{new int[]{1, 222, 248, 255, JpegConst.SOI, JpegConst.RST5, 128, 128, 128, 128, 128}, new int[]{168, MPEGConst.SLICE_START_CODE_LAST, 246, 252, JpegConst.APPB, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 255, 255, 128, 128, 128}, new int[]{47, 116, JpegConst.RST7, 255, JpegConst.RST3, JpegConst.RST4, 255, 255, 128, 128, 128}}, new int[][]{new int[]{1, 121, JpegConst.APPC, 253, JpegConst.RST4, JpegConst.RST6, 255, 255, 128, 128, 128}, new int[]{141, 84, JpegConst.RST5, 252, 201, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 255, JpegConst.DQT, 128, 128, 128}, new int[]{42, 80, Consts.BORDERINPIXELS, 240, 162, 185, 255, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 128, 128, 128}}, new int[][]{new int[]{1, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{H264Const.PROFILE_HIGH_444, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128}, new int[]{JpegConst.APPE, 1, 255, 128, 128, 128, 128, 128, 128, 128, 128}}}};
    public static int[][][][] vp8CoefUpdateProbs = {new int[][][]{new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{176, 246, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{223, 241, 252, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{249, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, H264Const.PROFILE_HIGH_444, 252, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.APPA, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{253, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 246, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.APPF, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 248, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{251, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{251, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, 253, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255}, new int[]{250, 255, JpegConst.COM, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}}, new int[][][]{new int[][]{new int[]{JpegConst.EOI, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.APP1, 252, 241, 253, 255, 255, JpegConst.COM, 255, 255, 255, 255}, new int[]{JpegConst.APPA, 250, 241, 250, 253, 255, 253, JpegConst.COM, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{223, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.APPE, 253, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 248, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{249, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 253, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{247, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{252, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{253, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, 253, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{250, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}}, new int[][][]{new int[][]{new int[]{186, 251, 250, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.APPA, 251, H264Const.PROFILE_HIGH_444, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255}, new int[]{251, 251, 243, 253, JpegConst.COM, 255, JpegConst.COM, 255, 255, 255, 255}}, new int[][]{new int[]{255, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.APPC, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{251, 253, 253, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}}, new int[][][]{new int[][]{new int[]{248, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{250, JpegConst.COM, 252, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255}, new int[]{248, JpegConst.COM, 249, 253, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{246, 253, 253, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{252, JpegConst.COM, 251, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, JpegConst.COM, 252, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{248, JpegConst.COM, 253, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{253, 255, JpegConst.COM, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 251, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{245, 251, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{253, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 251, 253, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{252, 253, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 252, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{249, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 253, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{250, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}, new int[][]{new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{JpegConst.COM, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}, new int[]{255, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255}}}};

    /* renamed from: org.jcodec.codecs.vpx.VP8Util$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jcodec$codecs$vpx$VP8Util$PLANE;

        static {
            int[] iArr = new int[PLANE.values().length];
            $SwitchMap$org$jcodec$codecs$vpx$VP8Util$PLANE = iArr;
            try {
                iArr[PLANE.Y2.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$vpx$VP8Util$PLANE[PLANE.Y1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$vpx$VP8Util$PLANE[PLANE.U.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$vpx$VP8Util$PLANE[PLANE.V.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum PLANE {
        U,
        V,
        Y1,
        Y2
    }

    public static class QuantizationParams {
        public int chromaAC;
        public int chromaDC;
        public int y2AC;
        public int y2DC;
        public int yAC;
        public int yDC;
        public static final int[] dcQLookup = {4, 5, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 15, 16, 17, 17, 18, 19, 20, 20, 21, 21, 22, 22, 23, 23, 24, 25, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 91, 93, 95, 96, 98, 100, 101, 102, 104, 106, 108, 110, 112, 114, 116, 118, 122, 124, 126, 128, 130, 132, 134, 136, 138, 140, 143, 145, Code39Reader.ASTERISK_ENCODING, 151, 154, 157};
        public static final int[] acQLookup = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100, 102, 104, 106, 108, 110, 112, 114, 116, 119, 122, 125, 128, 131, 134, 137, 140, 143, 146, 149, 152, 155, 158, 161, 164, 167, 170, 173, 177, MPEGConst.EXTENSION_START_CODE, 185, 189, JpegConst.SOF1, 197, 201, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, JpegConst.RST1, JpegConst.RST5, JpegConst.EOI, JpegConst.DRI, JpegConst.APP1, JpegConst.APP5, JpegConst.APPA, JpegConst.APPF, 245, 249, JpegConst.COM, 259, 264, 269, 274, 279, 284};

        public QuantizationParams(int i, int i2, int i3, int i4, int i5, int i6) {
            int[] iArr = acQLookup;
            this.yAC = iArr[clip(i, 127)];
            int[] iArr2 = dcQLookup;
            this.yDC = iArr2[clip(i2 + i, 127)];
            this.y2DC = iArr2[clip(i3 + i, 127)] * 2;
            int i7 = (iArr[clip(i4 + i, 127)] * 155) / 100;
            this.y2AC = i7;
            if (i7 < 8) {
                this.y2AC = 8;
            }
            this.chromaDC = iArr2[clip(i5 + i, 127)];
            this.chromaAC = iArr[clip(i + i6, 127)];
        }

        private static int clip(int i, int i2) {
            if (i > i2) {
                return i2;
            }
            if (i < 0) {
                return 0;
            }
            return i;
        }

        public static int clip255(int i) {
            if (i > 255) {
                return 255;
            }
            if (i < 0) {
                return 0;
            }
            return i;
        }
    }

    public static class SubblockConstants {
        public static final int B_DC_PRED = 0;
        public static final int B_HD_PRED = 8;
        public static final int B_HE_PRED = 3;
        public static final int B_HU_PRED = 9;
        public static final int B_LD_PRED = 4;
        public static final int B_PRED = 4;
        public static final int B_RD_PRED = 5;
        public static final int B_TM_PRED = 1;
        public static final int B_VE_PRED = 2;
        public static final int B_VL_PRED = 7;
        public static final int B_VR_PRED = 6;
        public static final int DCT_0 = 0;
        public static final int DCT_1 = 1;
        public static final int DCT_2 = 2;
        public static final int DCT_3 = 3;
        public static final int DCT_4 = 4;
        public static final int DC_PRED = 0;
        public static final int H_PRED = 2;
        public static final int TM_PRED = 3;
        public static final int V_PRED = 1;
        public static final int cat_11_18 = 7;
        public static final int cat_19_34 = 8;
        public static final int cat_35_66 = 9;
        public static final int cat_5_6 = 5;
        public static final int cat_67_2048 = 10;
        public static final int cat_7_10 = 6;
        public static final int dct_eob = 11;
        public static final int[] vp8CoefTree = {-11, 2, 0, 4, -1, 6, 8, 12, -2, 10, -3, -4, 14, 16, -5, -6, 18, 20, -7, -8, -9, -10};
        public static final int[] vp8CoefBands = {0, 1, 2, 3, 6, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 7};
        public static final int[] vp8defaultZigZag1d = {0, 1, 4, 8, 5, 2, 3, 6, 9, 12, 13, 10, 7, 11, 14, 15};
        public static int[] subblockModeTree = {0, 2, -1, 4, -2, 6, 8, 12, -3, 10, -5, -6, -4, 14, -7, 16, -8, -9};
        public static final int[] Pcat1 = {159, 0};
        public static final int[] Pcat2 = {165, 145, 0};
        public static final int[] Pcat3 = {173, Code39Reader.ASTERISK_ENCODING, 140, 0};
        public static final int[] Pcat4 = {176, 155, 140, 135, 0};
        public static final int[] Pcat5 = {MPEGConst.SEQUENCE_ERROR_CODE, 157, 141, 134, 130, 0};
        public static final int[] Pcat6 = {JpegConst.COM, JpegConst.COM, 243, JpegConst.APP6, JpegConst.DHT, 177, 153, 140, 133, 130, 129, 0};
        public static int[][][] keyFrameSubblockModeProb = {new int[][]{new int[]{JpegConst.APP7, 120, 48, 89, 115, 113, 120, 152, 112}, new int[]{152, MPEGConst.SEQUENCE_HEADER_CODE, 64, 126, 170, 118, 46, 70, 95}, new int[]{MPEGConst.SLICE_START_CODE_LAST, 69, 143, 80, 85, 82, 72, 155, 103}, new int[]{56, 58, 10, 171, JpegConst.SOS, 189, 17, 13, 152}, new int[]{144, 71, 10, 38, 171, JpegConst.RST5, 144, 34, 26}, new int[]{114, 26, 17, 163, 44, JpegConst.SOF3, 21, 10, 173}, new int[]{121, 24, 80, JpegConst.SOF3, 26, 62, 44, 64, 85}, new int[]{170, 46, 55, 19, 136, Consts.BORDERINPIXELS, 33, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 71}, new int[]{63, 20, 8, 114, 114, JpegConst.RST0, 12, 9, JpegConst.APP2}, new int[]{81, 40, 11, 96, 182, 84, 29, 16, 36}}, new int[][]{new int[]{134, MPEGConst.SEQUENCE_END_CODE, 89, 137, 98, 101, 106, 165, Code39Reader.ASTERISK_ENCODING}, new int[]{72, 187, 100, 130, 157, 111, 32, 75, 80}, new int[]{66, 102, 167, 99, 74, 62, 40, JpegConst.APPA, 128}, new int[]{41, 53, 9, MPEGConst.USER_DATA_START_CODE, 241, 141, 26, 8, 107}, new int[]{104, 79, 12, 27, JpegConst.EOI, 255, 87, 17, 7}, new int[]{74, 43, 26, 146, 73, 166, 49, 23, 157}, new int[]{65, 38, 105, Consts.BORDERINPIXELS, 51, 52, 31, 115, 128}, new int[]{87, 68, 71, 44, 114, 51, 15, 186, 23}, new int[]{47, 41, 14, 110, 182, MPEGConst.SEQUENCE_END_CODE, 21, 17, JpegConst.SOF2}, new int[]{66, 45, 25, 102, 197, 189, 23, 18, 22}}, new int[][]{new int[]{88, 88, 147, 150, 42, 46, 45, JpegConst.DHT, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, new int[]{43, 97, MPEGConst.SEQUENCE_END_CODE, 117, 85, 38, 35, MPEGConst.SEQUENCE_HEADER_CODE, 61}, new int[]{39, 53, 200, 87, 26, 21, 43, JpegConst.APP8, 171}, new int[]{56, 34, 51, 104, 114, 102, 29, 93, 77}, new int[]{107, 54, 32, 26, 51, 1, 81, 43, 31}, new int[]{39, 28, 85, 171, 58, 165, 90, 98, 64}, new int[]{34, 22, 116, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 23, 34, 43, 166, 73}, new int[]{68, 25, 106, 22, 64, 171, 36, JpegConst.APP1, 114}, new int[]{34, 19, 21, 102, 132, TsConstants.TS_PACKET_SIZE, 16, 76, 124}, new int[]{62, 18, 78, 95, 85, 57, 50, 48, 51}}, new int[][]{new int[]{JpegConst.SOF1, 101, 35, 159, JpegConst.RST7, 111, 89, 46, 111}, new int[]{60, Code39Reader.ASTERISK_ENCODING, 31, 172, JpegConst.DQT, JpegConst.APP4, 21, 18, 111}, new int[]{112, 113, 77, 85, MPEGConst.SEQUENCE_HEADER_CODE, 255, 38, 120, 114}, new int[]{40, 42, 1, JpegConst.DHT, 245, JpegConst.RST1, 10, 25, 109}, new int[]{100, 80, 8, 43, 154, 1, 51, 26, 71}, new int[]{88, 43, 29, 140, 166, JpegConst.RST5, 37, 43, 154}, new int[]{61, 63, 30, 155, 67, 45, 68, 1, JpegConst.RST1}, new int[]{142, 78, 78, 16, 255, 128, 34, 197, 171}, new int[]{41, 40, 5, 102, JpegConst.RST3, MPEGConst.SEQUENCE_END_CODE, 4, 1, JpegConst.DRI}, new int[]{51, 50, 17, 168, JpegConst.RST1, 192, 23, 25, 82}}, new int[][]{new int[]{125, 98, 42, 88, 104, 85, 117, MPEGConst.SLICE_START_CODE_LAST, 82}, new int[]{95, 84, 53, 89, 128, 100, 113, 101, 45}, new int[]{75, 79, 123, 47, 51, 128, 81, 171, 1}, new int[]{57, 17, 5, 71, 102, 57, 53, 41, 49}, new int[]{115, 21, 2, 10, 102, 255, 166, 23, 6}, new int[]{38, 33, 13, 121, 57, 73, 26, 1, 85}, new int[]{41, 10, 67, 138, 77, 110, 90, 47, 114}, new int[]{101, 29, 16, 10, 85, 128, 101, JpegConst.DHT, 26}, new int[]{57, 18, 10, 102, 102, JpegConst.RST5, 34, 20, 43}, new int[]{117, 20, 15, 36, 163, 128, 68, 1, 26}}, new int[][]{new int[]{138, 31, 36, 171, 27, 166, 38, 44, JpegConst.APP5}, new int[]{67, 87, 58, 169, 82, 115, 26, 59, MPEGConst.SEQUENCE_HEADER_CODE}, new int[]{63, 59, 90, MPEGConst.SEQUENCE_ERROR_CODE, 59, 166, 93, 73, 154}, new int[]{40, 40, 21, 116, 143, JpegConst.RST1, 34, 39, MPEGConst.SLICE_START_CODE_LAST}, new int[]{57, 46, 22, 24, 128, 1, 54, 17, 37}, new int[]{47, 15, 16, MPEGConst.SEQUENCE_END_CODE, 34, 223, 49, 45, MPEGConst.SEQUENCE_END_CODE}, new int[]{46, 17, 33, MPEGConst.SEQUENCE_END_CODE, 6, 98, 15, 32, MPEGConst.SEQUENCE_END_CODE}, new int[]{65, 32, 73, 115, 28, 128, 23, 128, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, new int[]{40, 3, 9, 115, 51, 192, 18, 6, 223}, new int[]{87, 37, 9, 115, 59, 77, 64, 21, 47}}, new int[][]{new int[]{104, 55, 44, JpegConst.SOS, 9, 54, 53, 130, JpegConst.APP2}, new int[]{64, 90, 70, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 40, 41, 23, 26, 57}, new int[]{54, 57, 112, MPEGConst.GROUP_START_CODE, 5, 41, 38, 166, JpegConst.RST5}, new int[]{30, 34, 26, 133, 152, 116, 10, 32, 134}, new int[]{75, 32, 12, 51, 192, 255, Consts.BORDERINPIXELS, 43, 51}, new int[]{39, 19, 53, JpegConst.DRI, 26, 114, 32, 73, 255}, new int[]{31, 9, 65, JpegConst.APPA, 2, 15, 1, 118, 73}, new int[]{88, 31, 35, 67, 102, 85, 55, 186, 85}, new int[]{56, 21, 23, 111, 59, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 45, 37, 192}, new int[]{55, 38, 70, 124, 73, 102, 1, 34, 98}}, new int[][]{new int[]{102, 61, 71, 37, 34, 53, 31, 243, 192}, new int[]{69, 60, 71, 38, 73, 119, 28, 222, 37}, new int[]{68, 45, 128, 34, 1, 47, 11, 245, 171}, new int[]{62, 17, 19, 70, 146, 85, 55, 62, 70}, new int[]{75, 15, 9, 9, 64, 255, MPEGConst.GROUP_START_CODE, 119, 16}, new int[]{37, 43, 37, 154, 100, 163, 85, Consts.BORDERINPIXELS, 1}, new int[]{63, 9, 92, 136, 28, 64, 32, 201, 85}, new int[]{86, 6, 28, 5, 64, 255, 25, 248, 1}, new int[]{56, 8, 17, 132, 137, 255, 55, 116, 128}, new int[]{58, 15, 20, 82, 135, 57, 26, 121, 40}}, new int[][]{new int[]{164, 50, 31, 137, 154, 133, 25, 35, JpegConst.SOS}, new int[]{51, 103, 44, 131, 131, 123, 31, 6, 158}, new int[]{86, 40, 64, 135, Code39Reader.ASTERISK_ENCODING, 224, 45, MPEGConst.SEQUENCE_END_CODE, 128}, new int[]{22, 26, 17, 131, 240, 154, 14, 1, JpegConst.RST1}, new int[]{83, 12, 13, 54, 192, 255, 68, 47, 28}, new int[]{45, 16, 21, 91, 64, 222, 7, 1, 197}, new int[]{56, 21, 39, 155, 60, 138, 23, 102, JpegConst.RST5}, new int[]{85, 26, 85, 85, 128, 128, 32, 146, 171}, new int[]{18, 11, 7, 63, 144, 171, 4, 4, 246}, new int[]{35, 27, 10, 146, 174, 171, 12, 26, 128}}, new int[][]{new int[]{190, 80, 35, 99, MPEGConst.SEQUENCE_ERROR_CODE, 80, 126, 54, 45}, new int[]{85, 126, 47, 87, 176, 51, 41, 20, 32}, new int[]{101, 75, 128, 139, 118, 146, 116, 128, 85}, new int[]{56, 41, 15, 176, JpegConst.APPC, 85, 37, 9, 62}, new int[]{146, 36, 19, 30, 171, 255, 97, 27, 20}, new int[]{71, 30, 17, 119, 118, 255, 17, 18, 138}, new int[]{101, 38, 60, 138, 55, 70, 43, 26, 142}, new int[]{138, 45, 61, 62, JpegConst.DQT, 1, 81, TsConstants.TS_PACKET_SIZE, 64}, new int[]{32, 41, 20, 117, 151, 142, 20, 21, 163}, new int[]{112, 19, 12, 61, JpegConst.SOF3, 128, 48, 4, 24}}};
    }

    public static int avg2(int i, int i2) {
        return ((i + i2) + 1) >> 1;
    }

    public static int avg3(int i, int i2, int i3) {
        return ((((i + i2) + i2) + i3) + 2) >> 2;
    }

    public static int delta(VPXBooleanDecoder vPXBooleanDecoder) {
        int iDecodeInt = vPXBooleanDecoder.decodeInt(4);
        return vPXBooleanDecoder.readBitEq() > 0 ? -iDecodeInt : iDecodeInt;
    }

    public static int getBitInBytes(byte[] bArr, int i) {
        return (bArr[i >> 3] >> (i & 7)) & 1;
    }

    public static int getBitsInBytes(byte[] bArr, int i, int i2) {
        int bitInBytes = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            bitInBytes |= getBitInBytes(bArr, i + i3) << i3;
        }
        return bitInBytes;
    }

    public static int[][][][] getDefaultCoefProbs() {
        int[][][][] iArr = vp8DefaultCoefProbs;
        int length = iArr.length;
        int[][][] iArr2 = iArr[0];
        int length2 = iArr2.length;
        int[][] iArr3 = iArr2[0];
        int[][][][] iArr4 = (int[][][][]) Array.newInstance((Class<?>) Integer.TYPE, length, length2, iArr3.length, iArr3[0].length);
        for (int i = 0; i < vp8DefaultCoefProbs.length; i++) {
            for (int i2 = 0; i2 < vp8DefaultCoefProbs[0].length; i2++) {
                for (int i3 = 0; i3 < vp8DefaultCoefProbs[0][0].length; i3++) {
                    int i4 = 0;
                    while (true) {
                        int[][][][] iArr5 = vp8DefaultCoefProbs;
                        if (i4 < iArr5[0][0][0].length) {
                            iArr4[i][i2][i3][i4] = iArr5[i][i2][i3][i4];
                            i4++;
                        }
                    }
                }
            }
        }
        return iArr4;
    }

    public static int getMacroblockCount(int i) {
        int i2 = i & 15;
        if (i2 != 0) {
            i += 16 - i2;
        }
        return i >> 4;
    }

    public static int[] pickDefaultPrediction(int i) {
        return (i == 1 || i == 0 || i == 2 || i == 3 || i == 6 || i == 5 || i == 8) ? PRED_BLOCK_129 : PRED_BLOCK_127;
    }

    public static int planeToType(PLANE plane, Boolean bool) {
        int i = AnonymousClass1.$SwitchMap$org$jcodec$codecs$vpx$VP8Util$PLANE[plane.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 3;
            if (i != 2) {
                return (i == 3 || i == 4) ? 2 : -1;
            }
            if (bool.booleanValue()) {
                return 0;
            }
        }
        return i2;
    }

    public static int[] predictDC(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        int i = 0;
        int i2 = 4;
        do {
            i2 += iArr[i] + iArr2[i];
            i++;
        } while (i < 4);
        int i3 = i2 >> 3;
        for (int i4 = 0; i4 < 4; i4++) {
            for (int i5 = 0; i5 < 4; i5++) {
                iArr3[(i4 * 4) + i5] = i3;
            }
        }
        return iArr3;
    }

    public static int[] predictHD(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr2[3];
        int i3 = iArr2[2];
        int[] iArr3 = {i2, i3, iArr2[1], iArr2[0], i, iArr[0], iArr[1], iArr[2], iArr[3]};
        int iAvg2 = avg2(iArr3[1], iArr3[2]);
        int iAvg3 = avg3(iArr3[1], iArr3[2], iArr3[3]);
        int[] iArr4 = {iAvg2, iAvg3, avg3(iArr3[4], iArr3[5], iArr3[6]), avg3(iArr3[5], iArr3[6], iArr3[7]), iAvg2, iAvg3, iAvg2, iAvg3, iAvg2, iAvg3, iAvg2, iAvg3, avg2(i2, i3), avg3(iArr3[0], iArr3[1], iArr3[2]), iAvg2, iAvg3};
        int iAvg22 = avg2(iArr3[2], iArr3[3]);
        int iAvg32 = avg3(iArr3[2], iArr3[3], iArr3[4]);
        int iAvg23 = avg2(iArr3[3], iArr3[4]);
        int iAvg33 = avg3(iArr3[3], iArr3[4], iArr3[5]);
        return iArr4;
    }

    public static int[] predictHE(int[] iArr, int i) {
        int i2 = iArr[2];
        int i3 = iArr[3];
        avg3(i2, i3, i3);
        int i4 = iArr[2];
        int i5 = iArr[3];
        int iAvg3 = avg3(i4, i5, i5);
        int[] iArr2 = {iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3, iAvg3};
        int iAvg32 = avg3(iArr[1], iArr[2], iArr[3]);
        int iAvg33 = avg3(iArr[0], iArr[1], iArr[2]);
        int iAvg34 = avg3(i, iArr[0], iArr[1]);
        return iArr2;
    }

    public static int[] predictHU(int[] iArr) {
        int iAvg2 = avg2(iArr[1], iArr[2]);
        int iAvg3 = avg3(iArr[1], iArr[2], iArr[3]);
        int iAvg22 = avg2(iArr[2], iArr[3]);
        int i = iArr[2];
        int i2 = iArr[3];
        int iAvg32 = avg3(i, i2, i2);
        int i3 = iArr[3];
        return new int[]{avg2(iArr[0], iArr[1]), avg3(iArr[0], iArr[1], iArr[2]), iAvg2, iAvg3, iAvg2, iAvg3, iAvg22, iAvg32, iAvg22, iAvg32, i3, i3, i3, i3, i3, i3};
    }

    public static int[] predictLD(int[] iArr, int[] iArr2) {
        int iAvg3 = avg3(iArr[1], iArr[2], iArr[3]);
        int iAvg32 = avg3(iArr[2], iArr[3], iArr2[0]);
        int iAvg33 = avg3(iArr[3], iArr2[0], iArr2[1]);
        int iAvg34 = avg3(iArr2[0], iArr2[1], iArr2[2]);
        int iAvg35 = avg3(iArr2[1], iArr2[2], iArr2[3]);
        int i = iArr2[2];
        int i2 = iArr2[3];
        return new int[]{avg3(iArr[0], iArr[1], iArr[2]), iAvg3, iAvg32, iAvg33, iAvg3, iAvg32, iAvg33, iAvg34, iAvg32, iAvg33, iAvg34, iAvg35, iAvg33, iAvg34, iAvg35, avg3(i, i2, i2)};
    }

    public static int[] predictRD(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr2[3];
        int i3 = iArr2[2];
        int i4 = iArr2[1];
        int[] iArr3 = {i2, i3, i4, iArr2[0], i, iArr[0], iArr[1], iArr[2], iArr[3]};
        int iAvg3 = avg3(iArr3[1], iArr3[2], iArr3[3]);
        int iAvg32 = avg3(iArr3[2], iArr3[3], iArr3[4]);
        int iAvg33 = avg3(iArr3[3], iArr3[4], iArr3[5]);
        int[] iArr4 = {iAvg33, iAvg3, iAvg3, avg3(iArr3[6], iArr3[7], iArr3[8]), iAvg32, iAvg33, iAvg3, iAvg3, iAvg3, iAvg32, iAvg33, iAvg3, avg3(i2, i3, i4), iAvg3, iAvg32, iAvg33};
        int iAvg34 = avg3(iArr3[4], iArr3[5], iArr3[6]);
        int iAvg35 = avg3(iArr3[5], iArr3[6], iArr3[7]);
        return iArr4;
    }

    public static int[] predictTM(int[] iArr, int[] iArr2, int i) {
        int[] iArr3 = new int[16];
        for (int i2 = 0; i2 < 4; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                iArr3[(i2 * 4) + i3] = QuantizationParams.clip255((iArr2[i2] + iArr[i3]) - i);
            }
        }
        return iArr3;
    }

    public static int[] predictVE(int[] iArr, int i, int[] iArr2) {
        int iAvg3 = avg3(i, iArr[0], iArr[1]);
        int iAvg32 = avg3(iArr[0], iArr[1], iArr[2]);
        int iAvg33 = avg3(iArr[1], iArr[2], iArr[3]);
        int iAvg34 = avg3(iArr[2], iArr[3], iArr2[0]);
        return new int[]{iAvg3, iAvg32, iAvg33, iAvg34, iAvg3, iAvg32, iAvg33, iAvg34, iAvg3, iAvg32, iAvg33, iAvg34, iAvg3, iAvg32, iAvg33, iAvg34};
    }

    public static int[] predictVL(int[] iArr, int[] iArr2) {
        int iAvg2 = avg2(iArr[1], iArr[2]);
        int iAvg3 = avg3(iArr[1], iArr[2], iArr[3]);
        int iAvg22 = avg2(iArr[2], iArr[3]);
        int iAvg32 = avg3(iArr[2], iArr[3], iArr2[0]);
        int iAvg23 = avg2(iArr[3], iArr2[0]);
        int iAvg33 = avg3(iArr[3], iArr2[0], iArr2[1]);
        return new int[]{avg2(iArr[0], iArr[1]), iAvg2, iAvg22, iAvg23, avg3(iArr[0], iArr[1], iArr[2]), iAvg3, iAvg32, iAvg33, iAvg2, iAvg22, iAvg23, avg3(iArr2[0], iArr2[1], iArr2[2]), iAvg3, iAvg32, iAvg33, avg3(iArr2[1], iArr2[2], iArr2[3])};
    }

    public static int[] predictVR(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr2[2];
        int i3 = iArr2[1];
        int i4 = iArr2[0];
        int[] iArr3 = {iArr2[3], i2, i3, i4, i, iArr[0], iArr[1], iArr[2], iArr[3]};
        int iAvg3 = avg3(iArr3[3], iArr3[4], iArr3[5]);
        int iAvg2 = avg2(iArr3[4], iArr3[5]);
        int iAvg32 = avg3(iArr3[4], iArr3[5], iArr3[6]);
        int iAvg22 = avg2(iArr3[5], iArr3[6]);
        int iAvg33 = avg3(iArr3[5], iArr3[6], iArr3[7]);
        int[] iArr4 = {iAvg2, iAvg22, iAvg2, avg2(iArr3[7], iArr3[8]), iAvg3, iAvg32, iAvg33, avg3(iArr3[6], iArr3[7], iArr3[8]), avg3(iArr3[2], iArr3[3], iArr3[4]), iAvg2, iAvg22, iAvg2, avg3(i2, i3, i4), iAvg3, iAvg32, iAvg33};
        int iAvg23 = avg2(iArr3[6], iArr3[7]);
        return iArr4;
    }
}
