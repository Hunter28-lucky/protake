package org.jcodec.codecs.vpx.vp9;

import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.mlkit.common.MlKitException;
import com.google.zxing.oned.Code39Reader;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.vpx.VPXBooleanDecoder;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.io.NIOUtils;

/* loaded from: classes2.dex */
public class DecodingContext {
    public boolean[] aboveCompound;
    public int[] aboveInterpFilters;
    public int[] aboveModes;
    public int[][] aboveNonzeroContext;
    public int[] abovePartitionSizes;
    public int[] aboveRefs;
    public boolean[] aboveSkipped;
    public int[] aboveTxSizes;
    private int allowHighPrecisionMv;
    private int baseQIdx;
    public int bitDepth;
    public int[][][][][][] coefProbs;
    private int colorRange;
    private int colorSpace;
    private int compFixedRef;
    private int[] compModeProbs;
    private int[] compRefProbs;
    private int compVarRef0;
    private int compVarRef1;
    private int deltaQUvAc;
    private int deltaQUvDc;
    private int deltaQYDc;
    private int errorResilientMode;
    private int[][] featureData;
    private int[][] featureEnabled;
    private int filterLevel;
    private int frameContextIdx;
    public int frameHeight;
    private int frameIsIntra;
    private int frameParallelDecodingMode;
    private int frameToShowMapIdx;
    private int frameType;
    public int frameWidth;
    public int[][] interModeProbs;
    public int interpFilter;
    public int[][] interpFilterProbs;
    private int intraOnly;
    private int[] isInterProbs;
    public boolean[] leftCompound;
    public int[] leftInterpFilters;
    public int[] leftModes;
    public int[][] leftNonzeroContext;
    public int[] leftPartitionSizes;
    public int[] leftRefs;
    public boolean[] leftSkipped;
    public int[] leftTxSizes;
    private boolean lossless;
    public int miTileStartCol;
    private int[][] mvBitsProbs;
    private int[] mvClass0BitProbs;
    private int[][][] mvClass0FrProbs;
    private int[] mvClass0HpProb;
    private int[][] mvClassProbs;
    private int[][] mvFrProbs;
    private int[] mvHpProbs;
    private int[] mvJointProbs;
    private int[] mvSignProbs;
    public int[][] partitionProbs;
    private int profile;
    public int refMode;
    private int refreshFrameContext;
    private int refreshFrameFlags;
    private int renderHeight;
    private int renderWidth;
    private int resetFrameContext;
    private boolean segmentationEnabled;
    private int sharpnessLevel;
    private int showExistingFrame;
    private int showFrame;
    private int[][] singleRefProbs;
    private int[] skipProbs;
    public int subsamplingX;
    public int subsamplingY;
    private int tileColsLog2;
    public int tileHeight;
    private int tileRowsLog2;
    public int tileWidth;
    public int[][] tx16x16Probs;
    public int[][] tx32x32Probs;
    public int[][] tx8x8Probs;
    public int txMode;
    public int[][] uvModeProbs;
    public int[][] yModeProbs;
    private static final int[] defaultSkipProb = {192, 128, 64};
    private static final int[][] defaultTxProbs8x8 = {new int[]{100}, new int[]{66}};
    private static final int[][] defaultTxProbs16x16 = {new int[]{20, 152}, new int[]{15, 101}};
    private static final int[][] defaultTxProbs32x32 = {new int[]{3, 136, 37}, new int[]{5, 52, 13}};
    public static final int[][][][][][] defaultCoefProbs = {new int[][][][][]{new int[][][][]{new int[][][]{new int[][]{new int[]{JpegConst.SOF3, 29, MPEGConst.SEQUENCE_END_CODE}, new int[]{84, 49, 136}, new int[]{8, 42, 71}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{31, 107, 169}, new int[]{35, 99, 159}, new int[]{17, 82, 140}, new int[]{8, 66, 114}, new int[]{2, 44, 76}, new int[]{1, 19, 32}}, new int[][]{new int[]{40, 132, 201}, new int[]{29, 114, 187}, new int[]{13, 91, 157}, new int[]{7, 75, 127}, new int[]{3, 58, 95}, new int[]{1, 28, 47}}, new int[][]{new int[]{69, 142, JpegConst.DRI}, new int[]{42, 122, 201}, new int[]{15, 91, 159}, new int[]{6, 67, 121}, new int[]{1, 42, 77}, new int[]{1, 17, 31}}, new int[][]{new int[]{102, Code39Reader.ASTERISK_ENCODING, JpegConst.APP4}, new int[]{67, 117, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{17, 82, 154}, new int[]{6, 59, 114}, new int[]{2, 39, 75}, new int[]{1, 15, 29}}, new int[][]{new int[]{156, 57, JpegConst.APP9}, new int[]{119, 57, JpegConst.RST4}, new int[]{58, 48, 163}, new int[]{29, 40, 124}, new int[]{12, 30, 81}, new int[]{3, 12, 31}}}, new int[][][]{new int[][]{new int[]{191, 107, JpegConst.APP2}, new int[]{124, 117, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{25, 99, 155}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{29, Code39Reader.ASTERISK_ENCODING, JpegConst.RST2}, new int[]{37, 126, JpegConst.SOF2}, new int[]{8, 93, 157}, new int[]{2, 68, 118}, new int[]{1, 39, 69}, new int[]{1, 17, 33}}, new int[][]{new int[]{41, 151, JpegConst.RST5}, new int[]{27, 123, JpegConst.SOF1}, new int[]{3, 82, 144}, new int[]{1, 58, 105}, new int[]{1, 32, 60}, new int[]{1, 13, 26}}, new int[][]{new int[]{59, 159, 220}, new int[]{23, 126, 198}, new int[]{4, 88, 151}, new int[]{1, 66, 114}, new int[]{1, 38, 71}, new int[]{1, 18, 34}}, new int[][]{new int[]{114, 136, JpegConst.APP8}, new int[]{51, 114, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD}, new int[]{11, 83, 155}, new int[]{3, 56, 105}, new int[]{1, 33, 65}, new int[]{1, 17, 34}}, new int[][]{new int[]{149, 65, JpegConst.APPA}, new int[]{121, 57, JpegConst.RST7}, new int[]{61, 49, 166}, new int[]{28, 36, 114}, new int[]{12, 25, 76}, new int[]{3, 16, 42}}}}, new int[][][][]{new int[][][]{new int[][]{new int[]{JpegConst.RST6, 49, 220}, new int[]{132, 63, TsConstants.TS_PACKET_SIZE}, new int[]{42, 65, 137}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{85, 137, JpegConst.DRI}, new int[]{104, 131, JpegConst.SOI}, new int[]{49, 111, 192}, new int[]{21, 87, 155}, new int[]{2, 49, 87}, new int[]{1, 16, 28}}, new int[][]{new int[]{89, 163, JpegConst.APP6}, new int[]{90, 137, 220}, new int[]{29, 100, MPEGConst.SEQUENCE_END_CODE}, new int[]{10, 70, 135}, new int[]{2, 42, 81}, new int[]{1, 17, 33}}, new int[][]{new int[]{108, 167, JpegConst.APPD}, new int[]{55, 133, 222}, new int[]{15, 97, MPEGConst.SEQUENCE_HEADER_CODE}, new int[]{4, 72, 135}, new int[]{1, 45, 85}, new int[]{1, 19, 38}}, new int[][]{new int[]{124, 146, 240}, new int[]{66, 124, 224}, new int[]{17, 88, MPEGConst.SLICE_START_CODE_LAST}, new int[]{4, 58, 122}, new int[]{1, 36, 75}, new int[]{1, 18, 37}}, new int[][]{new int[]{141, 79, 241}, new int[]{126, 70, JpegConst.APP3}, new int[]{66, 58, 182}, new int[]{30, 44, 136}, new int[]{12, 34, 96}, new int[]{2, 20, 47}}}, new int[][][]{new int[][]{new int[]{JpegConst.APP5, 99, 249}, new int[]{143, 111, JpegConst.APPB}, new int[]{46, 109, 192}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{82, 158, JpegConst.APPC}, new int[]{94, 146, 224}, new int[]{25, 117, 191}, new int[]{9, 87, 149}, new int[]{3, 56, 99}, new int[]{1, 33, 57}}, new int[][]{new int[]{83, 167, JpegConst.APPD}, new int[]{68, 145, 222}, new int[]{10, 103, 177}, new int[]{2, 72, 131}, new int[]{1, 41, 79}, new int[]{1, 20, 39}}, new int[][]{new int[]{99, 167, JpegConst.APPF}, new int[]{47, 141, 224}, new int[]{10, 104, MPEGConst.USER_DATA_START_CODE}, new int[]{2, 73, 133}, new int[]{1, 44, 85}, new int[]{1, 22, 47}}, new int[][]{new int[]{127, 145, 243}, new int[]{71, 129, JpegConst.APP4}, new int[]{17, 93, 177}, new int[]{3, 61, 124}, new int[]{1, 41, 84}, new int[]{1, 21, 52}}, new int[][]{new int[]{157, 78, H264Const.PROFILE_HIGH_444}, new int[]{140, 72, JpegConst.APP7}, new int[]{69, 58, MPEGConst.GROUP_START_CODE}, new int[]{31, 44, 137}, new int[]{14, 38, 105}, new int[]{8, 23, 61}}}}}, new int[][][][][]{new int[][][][]{new int[][][]{new int[][]{new int[]{125, 34, 187}, new int[]{52, 41, 133}, new int[]{6, 31, 56}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{37, 109, 153}, new int[]{51, 102, 147}, new int[]{23, 87, 128}, new int[]{8, 67, 101}, new int[]{1, 41, 63}, new int[]{1, 19, 29}}, new int[][]{new int[]{31, 154, 185}, new int[]{17, 127, MPEGConst.SLICE_START_CODE_LAST}, new int[]{6, 96, 145}, new int[]{2, 73, 114}, new int[]{1, 51, 82}, new int[]{1, 28, 45}}, new int[][]{new int[]{23, 163, 200}, new int[]{10, 131, 185}, new int[]{2, 93, Code39Reader.ASTERISK_ENCODING}, new int[]{1, 67, 111}, new int[]{1, 41, 69}, new int[]{1, 14, 24}}, new int[][]{new int[]{29, 176, JpegConst.EOI}, new int[]{12, 145, 201}, new int[]{3, 101, 156}, new int[]{1, 69, 111}, new int[]{1, 39, 63}, new int[]{1, 14, 23}}, new int[][]{new int[]{57, 192, JpegConst.APP9}, new int[]{25, 154, JpegConst.RST7}, new int[]{6, 109, 167}, new int[]{3, 78, 118}, new int[]{1, 48, 69}, new int[]{1, 21, 29}}}, new int[][][]{new int[][]{new int[]{MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 105, 245}, new int[]{108, 106, JpegConst.SOI}, new int[]{18, 90, 144}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{33, 172, JpegConst.DQT}, new int[]{64, 149, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR}, new int[]{14, 117, 177}, new int[]{5, 90, 141}, new int[]{2, 61, 95}, new int[]{1, 37, 57}}, new int[][]{new int[]{33, MPEGConst.SEQUENCE_HEADER_CODE, 220}, new int[]{11, 140, 198}, new int[]{1, 89, Code39Reader.ASTERISK_ENCODING}, new int[]{1, 60, 104}, new int[]{1, 33, 57}, new int[]{1, 12, 21}}, new int[][]{new int[]{30, MPEGConst.EXTENSION_START_CODE, JpegConst.DRI}, new int[]{8, 141, 198}, new int[]{1, 87, 145}, new int[]{1, 58, 100}, new int[]{1, 31, 55}, new int[]{1, 12, 20}}, new int[][]{new int[]{32, 186, 224}, new int[]{7, 142, 198}, new int[]{1, 86, 143}, new int[]{1, 58, 100}, new int[]{1, 31, 55}, new int[]{1, 12, 22}}, new int[][]{new int[]{57, 192, JpegConst.APP3}, new int[]{20, 143, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{3, 96, 154}, new int[]{1, 68, 112}, new int[]{1, 42, 69}, new int[]{1, 19, 32}}}}, new int[][][][]{new int[][][]{new int[][]{new int[]{JpegConst.RST4, 35, JpegConst.RST7}, new int[]{113, 47, 169}, new int[]{29, 48, 105}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{74, 129, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE}, new int[]{106, 120, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE}, new int[]{49, 107, MPEGConst.USER_DATA_START_CODE}, new int[]{19, 84, 144}, new int[]{4, 50, 84}, new int[]{1, 15, 25}}, new int[][]{new int[]{71, 172, JpegConst.EOI}, new int[]{44, 141, JpegConst.RST1}, new int[]{15, 102, 173}, new int[]{6, 76, 133}, new int[]{2, 51, 89}, new int[]{1, 24, 42}}, new int[][]{new int[]{64, 185, JpegConst.APP7}, new int[]{31, Code39Reader.ASTERISK_ENCODING, JpegConst.SOI}, new int[]{8, 103, MPEGConst.SLICE_START_CODE_LAST}, new int[]{3, 74, 131}, new int[]{1, 46, 81}, new int[]{1, 18, 30}}, new int[][]{new int[]{65, JpegConst.DHT, JpegConst.APPB}, new int[]{25, 157, JpegConst.DRI}, new int[]{5, 105, 174}, new int[]{1, 67, 120}, new int[]{1, 38, 69}, new int[]{1, 15, 30}}, new int[][]{new int[]{65, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, JpegConst.APPE}, new int[]{30, 156, 224}, new int[]{7, 107, 177}, new int[]{2, 70, 124}, new int[]{1, 42, 73}, new int[]{1, 18, 34}}}, new int[][][]{new int[][]{new int[]{JpegConst.APP1, 86, 251}, new int[]{144, 104, JpegConst.APPB}, new int[]{42, 99, MPEGConst.EXTENSION_START_CODE}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{85, MPEGConst.SLICE_START_CODE_LAST, JpegConst.APPF}, new int[]{112, 165, JpegConst.APP5}, new int[]{29, 136, 200}, new int[]{12, 103, 162}, new int[]{6, 77, 123}, new int[]{2, 53, 84}}, new int[][]{new int[]{75, MPEGConst.SEQUENCE_END_CODE, JpegConst.APPF}, new int[]{30, 155, JpegConst.DRI}, new int[]{3, 106, 171}, new int[]{1, 74, 128}, new int[]{1, 44, 76}, new int[]{1, 17, 28}}, new int[][]{new int[]{73, 185, 240}, new int[]{27, 159, 222}, new int[]{2, 107, 172}, new int[]{1, 75, 127}, new int[]{1, 42, 73}, new int[]{1, 17, 29}}, new int[][]{new int[]{62, 190, JpegConst.APPE}, new int[]{21, 159, 222}, new int[]{2, 107, 172}, new int[]{1, 72, 122}, new int[]{1, 40, 71}, new int[]{1, 18, 32}}, new int[][]{new int[]{61, 199, 240}, new int[]{27, 161, JpegConst.APP2}, new int[]{4, 113, MPEGConst.SEQUENCE_ERROR_CODE}, new int[]{1, 76, 129}, new int[]{1, 46, 80}, new int[]{1, 23, 41}}}}}, new int[][][][][]{new int[][][][]{new int[][][]{new int[][]{new int[]{7, 27, 153}, new int[]{5, 30, 95}, new int[]{1, 16, 30}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{50, 75, 127}, new int[]{57, 75, 124}, new int[]{27, 67, 108}, new int[]{10, 54, 86}, new int[]{1, 33, 52}, new int[]{1, 12, 18}}, new int[][]{new int[]{43, 125, 151}, new int[]{26, 108, Code39Reader.ASTERISK_ENCODING}, new int[]{7, 83, 122}, new int[]{2, 59, 89}, new int[]{1, 38, 60}, new int[]{1, 17, 27}}, new int[][]{new int[]{23, 144, 163}, new int[]{13, 112, 154}, new int[]{2, 75, 117}, new int[]{1, 50, 81}, new int[]{1, 31, 51}, new int[]{1, 14, 23}}, new int[][]{new int[]{18, 162, 185}, new int[]{6, 123, 171}, new int[]{1, 78, 125}, new int[]{1, 51, 86}, new int[]{1, 31, 54}, new int[]{1, 14, 23}}, new int[][]{new int[]{15, 199, JpegConst.APP3}, new int[]{3, 150, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{1, 91, 146}, new int[]{1, 55, 95}, new int[]{1, 30, 53}, new int[]{1, 11, 20}}}, new int[][][]{new int[][]{new int[]{19, 55, 240}, new int[]{19, 59, JpegConst.DHT}, new int[]{3, 52, 105}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{41, 166, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD}, new int[]{104, 153, 199}, new int[]{31, 123, MPEGConst.EXTENSION_START_CODE}, new int[]{14, 101, 152}, new int[]{5, 72, 106}, new int[]{1, 36, 52}}, new int[][]{new int[]{35, 176, JpegConst.RST3}, new int[]{12, 131, 190}, new int[]{2, 88, 144}, new int[]{1, 60, 101}, new int[]{1, 36, 60}, new int[]{1, 16, 28}}, new int[][]{new int[]{28, MPEGConst.SEQUENCE_END_CODE, JpegConst.RST5}, new int[]{8, 134, 191}, new int[]{1, 86, 142}, new int[]{1, 56, 96}, new int[]{1, 30, 53}, new int[]{1, 12, 20}}, new int[][]{new int[]{20, 190, JpegConst.RST7}, new int[]{4, 135, 192}, new int[]{1, 84, 139}, new int[]{1, 53, 91}, new int[]{1, 28, 49}, new int[]{1, 11, 20}}, new int[][]{new int[]{13, JpegConst.DHT, JpegConst.SOI}, new int[]{2, 137, 192}, new int[]{1, 86, 143}, new int[]{1, 57, 99}, new int[]{1, 32, 56}, new int[]{1, 13, 24}}}}, new int[][][][]{new int[][][]{new int[][]{new int[]{JpegConst.RST3, 29, JpegConst.EOI}, new int[]{96, 47, 156}, new int[]{22, 43, 87}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{78, 120, JpegConst.SOF1}, new int[]{111, 116, 186}, new int[]{46, 102, 164}, new int[]{15, 80, 128}, new int[]{2, 49, 76}, new int[]{1, 18, 28}}, new int[][]{new int[]{71, 161, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE}, new int[]{42, 132, 192}, new int[]{10, 98, 150}, new int[]{3, 69, 109}, new int[]{1, 44, 70}, new int[]{1, 18, 29}}, new int[][]{new int[]{57, 186, JpegConst.RST3}, new int[]{30, 140, JpegConst.DHT}, new int[]{4, 93, 146}, new int[]{1, 62, 102}, new int[]{1, 38, 65}, new int[]{1, 16, 27}}, new int[][]{new int[]{47, 199, JpegConst.EOI}, new int[]{14, 145, JpegConst.DHT}, new int[]{1, 88, 142}, new int[]{1, 57, 98}, new int[]{1, 36, 62}, new int[]{1, 15, 26}}, new int[][]{new int[]{26, JpegConst.DQT, JpegConst.APP5}, new int[]{5, 155, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD}, new int[]{1, 94, 151}, new int[]{1, 60, 104}, new int[]{1, 36, 62}, new int[]{1, 16, 28}}}, new int[][][]{new int[][]{new int[]{JpegConst.APP9, 29, 248}, new int[]{146, 47, 220}, new int[]{43, 52, 140}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{100, 163, JpegConst.APP8}, new int[]{MPEGConst.SEQUENCE_HEADER_CODE, 161, 222}, new int[]{63, 142, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{37, 113, 174}, new int[]{26, 89, 137}, new int[]{18, 68, 97}}, new int[][]{new int[]{85, MPEGConst.EXTENSION_START_CODE, JpegConst.APP6}, new int[]{32, 146, JpegConst.RST1}, new int[]{7, 100, 164}, new int[]{3, 71, 121}, new int[]{1, 45, 77}, new int[]{1, 18, 30}}, new int[][]{new int[]{65, 187, JpegConst.APP6}, new int[]{20, Code39Reader.ASTERISK_ENCODING, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD}, new int[]{2, 97, 159}, new int[]{1, 68, 116}, new int[]{1, 40, 70}, new int[]{1, 14, 29}}, new int[][]{new int[]{40, JpegConst.SOF2, JpegConst.APP3}, new int[]{8, 147, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{1, 94, 155}, new int[]{1, 65, 112}, new int[]{1, 39, 66}, new int[]{1, 14, 26}}, new int[][]{new int[]{16, JpegConst.RST0, JpegConst.APP4}, new int[]{3, 151, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD}, new int[]{1, 98, Consts.BORDERINPIXELS}, new int[]{1, 67, 117}, new int[]{1, 41, 74}, new int[]{1, 17, 31}}}}}, new int[][][][][]{new int[][][][]{new int[][][]{new int[][]{new int[]{17, 38, 140}, new int[]{7, 34, 80}, new int[]{1, 17, 29}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{37, 75, 128}, new int[]{41, 76, 128}, new int[]{26, 66, 116}, new int[]{12, 52, 94}, new int[]{2, 32, 55}, new int[]{1, 10, 16}}, new int[][]{new int[]{50, 127, 154}, new int[]{37, 109, 152}, new int[]{16, 82, 121}, new int[]{5, 59, 85}, new int[]{1, 35, 54}, new int[]{1, 13, 20}}, new int[][]{new int[]{40, 142, 167}, new int[]{17, 110, 157}, new int[]{2, 71, 112}, new int[]{1, 44, 72}, new int[]{1, 27, 45}, new int[]{1, 11, 17}}, new int[][]{new int[]{30, MPEGConst.SLICE_START_CODE_LAST, TsConstants.TS_PACKET_SIZE}, new int[]{9, 124, 169}, new int[]{1, 74, 116}, new int[]{1, 48, 78}, new int[]{1, 30, 49}, new int[]{1, 11, 18}}, new int[][]{new int[]{10, 222, 223}, new int[]{2, 150, JpegConst.SOF2}, new int[]{1, 83, 128}, new int[]{1, 48, 79}, new int[]{1, 27, 45}, new int[]{1, 11, 17}}}, new int[][][]{new int[][]{new int[]{36, 41, JpegConst.APPB}, new int[]{29, 36, JpegConst.SOF1}, new int[]{10, 27, 111}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{85, 165, 222}, new int[]{177, 162, JpegConst.RST7}, new int[]{110, 135, JpegConst.SOF3}, new int[]{57, 113, 168}, new int[]{23, 83, 120}, new int[]{10, 49, 61}}, new int[][]{new int[]{85, 190, 223}, new int[]{36, 139, 200}, new int[]{5, 90, 146}, new int[]{1, 60, 103}, new int[]{1, 38, 65}, new int[]{1, 18, 30}}, new int[][]{new int[]{72, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 223}, new int[]{23, 141, 199}, new int[]{2, 86, 140}, new int[]{1, 56, 97}, new int[]{1, 36, 61}, new int[]{1, 16, 27}}, new int[][]{new int[]{55, JpegConst.SOS, JpegConst.APP1}, new int[]{13, 145, 200}, new int[]{1, 86, 141}, new int[]{1, 57, 99}, new int[]{1, 35, 61}, new int[]{1, 13, 22}}, new int[][]{new int[]{15, JpegConst.APPB, JpegConst.RST4}, new int[]{1, 132, MPEGConst.GROUP_START_CODE}, new int[]{1, 84, 139}, new int[]{1, 57, 97}, new int[]{1, 34, 56}, new int[]{1, 14, 23}}}}, new int[][][][]{new int[][][]{new int[][]{new int[]{MPEGConst.EXTENSION_START_CODE, 21, 201}, new int[]{61, 37, 123}, new int[]{10, 38, 71}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{47, 106, 172}, new int[]{95, 104, 173}, new int[]{42, 93, 159}, new int[]{18, 77, 131}, new int[]{4, 50, 81}, new int[]{1, 17, 23}}, new int[][]{new int[]{62, 147, 199}, new int[]{44, 130, 189}, new int[]{28, 102, 154}, new int[]{18, 75, 115}, new int[]{2, 44, 65}, new int[]{1, 12, 19}}, new int[][]{new int[]{55, 153, JpegConst.RST2}, new int[]{24, 130, JpegConst.SOF2}, new int[]{3, 93, 146}, new int[]{1, 61, 97}, new int[]{1, 31, 50}, new int[]{1, 10, 16}}, new int[][]{new int[]{49, 186, 223}, new int[]{17, Code39Reader.ASTERISK_ENCODING, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS}, new int[]{1, 96, 142}, new int[]{1, 53, 83}, new int[]{1, 26, 44}, new int[]{1, 11, 17}}, new int[][]{new int[]{13, JpegConst.EOI, JpegConst.RST4}, new int[]{2, 136, MPEGConst.SEQUENCE_ERROR_CODE}, new int[]{1, 78, 124}, new int[]{1, 50, 83}, new int[]{1, 29, 49}, new int[]{1, 14, 23}}}, new int[][][]{new int[][]{new int[]{197, 13, 247}, new int[]{82, 17, 222}, new int[]{25, 17, 162}, new int[]{0, 0, 0}, new int[]{0, 0, 0}, new int[]{0, 0, 0}}, new int[][]{new int[]{126, 186, 247}, new int[]{JpegConst.APPA, 191, 243}, new int[]{176, 177, JpegConst.APPA}, new int[]{104, 158, 220}, new int[]{66, 128, 186}, new int[]{55, 90, 137}}, new int[][]{new int[]{111, 197, 242}, new int[]{46, 158, JpegConst.DQT}, new int[]{9, 104, 171}, new int[]{2, 65, 125}, new int[]{1, 44, 80}, new int[]{1, 17, 91}}, new int[][]{new int[]{104, JpegConst.RST0, 245}, new int[]{39, 168, 224}, new int[]{3, 109, 162}, new int[]{1, 79, 124}, new int[]{1, 50, 102}, new int[]{1, 43, 102}}, new int[][]{new int[]{84, 220, 246}, new int[]{31, 177, JpegConst.APP7}, new int[]{2, 115, MPEGConst.SEQUENCE_ERROR_CODE}, new int[]{1, 79, 134}, new int[]{1, 55, 77}, new int[]{1, 60, 79}}, new int[][]{new int[]{43, 243, 240}, new int[]{8, MPEGConst.SEQUENCE_ERROR_CODE, JpegConst.EOI}, new int[]{1, 115, 166}, new int[]{1, 84, 121}, new int[]{1, 51, 67}, new int[]{1, 16, 6}}}}}};
    public static final int[] defaultMvJointProbs = {32, 64, 96};
    public static final int[][] defaultMvBitsProb = {new int[]{136, 140, Code39Reader.ASTERISK_ENCODING, Consts.BORDERINPIXELS, 176, 192, 224, JpegConst.APPA, JpegConst.APPA, 240}, new int[]{136, 140, Code39Reader.ASTERISK_ENCODING, Consts.BORDERINPIXELS, 176, 192, 224, JpegConst.APPA, JpegConst.APPA, 240}};
    public static final int[] defaultMvClass0BitProb = {JpegConst.SOI, JpegConst.RST0};
    public static final int[] defaultMvClass0HpProb = {Consts.BORDERINPIXELS, Consts.BORDERINPIXELS};
    public static final int[] defaultMvSignProb = {128, 128};
    public static final int[][] defaultMvClassProbs = {new int[]{224, 144, 192, 168, 192, 176, 192, 198, 198, 245}, new int[]{JpegConst.SOI, 128, 176, Consts.BORDERINPIXELS, 176, 176, 192, 198, 198, JpegConst.RST0}};
    public static final int[][][] defaultMvClass0FrProbs = {new int[][]{new int[]{128, 128, 64}, new int[]{96, 112, 64}}, new int[][]{new int[]{128, 128, 64}, new int[]{96, 112, 64}}};
    public static final int[][] defaultMvFrProbs = {new int[]{64, 96, 64}, new int[]{64, 96, 64}};
    public static final int[] defaultMvHpProb = {128, 128};
    public static final int[][] defaultInterModeProbs = {new int[]{2, 173, 34}, new int[]{7, 145, 85}, new int[]{7, 166, 63}, new int[]{7, 94, 66}, new int[]{8, 64, 46}, new int[]{17, 81, 31}, new int[]{25, 29, 30}};
    public static final int[][] defaultInterpFilterProbs = {new int[]{JpegConst.APPB, 162}, new int[]{36, 255}, new int[]{34, 3}, new int[]{149, 144}};
    public static final int[] defaultIsInterProbs = {9, 102, 187, JpegConst.APP1};
    private static final int[][] defaultPartitionProbs = {new int[]{199, 122, 141}, new int[]{147, 63, 159}, new int[]{Code39Reader.ASTERISK_ENCODING, 133, 118}, new int[]{121, 104, 114}, new int[]{174, 73, 87}, new int[]{92, 41, 83}, new int[]{82, 99, 50}, new int[]{53, 39, 39}, new int[]{177, 58, 59}, new int[]{68, 26, 63}, new int[]{52, 79, 25}, new int[]{17, 14, 12}, new int[]{222, 34, 30}, new int[]{72, 16, 44}, new int[]{58, 32, 12}, new int[]{10, 7, 6}};
    public static final int[][][] kfYmodeProbs = {new int[][]{new int[]{137, 30, 42, Code39Reader.ASTERISK_ENCODING, 151, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 70, 52, 91}, new int[]{92, 45, 102, 136, 116, MPEGConst.SEQUENCE_ERROR_CODE, 74, 90, 100}, new int[]{73, 32, 19, 187, 222, JpegConst.RST7, 46, 34, 100}, new int[]{91, 30, 32, 116, 121, 186, 93, 86, 94}, new int[]{72, 35, 36, 149, 68, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 68, 63, 105}, new int[]{73, 31, 28, 138, 57, 124, 55, 122, 151}, new int[]{67, 23, 21, 140, 126, 197, 40, 37, 171}, new int[]{86, 27, 28, 128, 154, JpegConst.RST4, 45, 43, 53}, new int[]{74, 32, 27, 107, 86, Consts.BORDERINPIXELS, 63, 134, 102}, new int[]{59, 67, 44, 140, 161, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 78, 67, 119}}, new int[][]{new int[]{63, 36, 126, 146, 123, 158, 60, 90, 96}, new int[]{43, 46, 168, 134, 107, 128, 69, 142, 92}, new int[]{44, 29, 68, 159, 201, 177, 50, 57, 77}, new int[]{58, 38, 76, 114, 97, 172, 78, 133, 92}, new int[]{46, 41, 76, 140, 63, MPEGConst.GROUP_START_CODE, 69, 112, 57}, new int[]{38, 32, 85, 140, 46, 112, 54, 151, 133}, new int[]{39, 27, 61, 131, 110, MPEGConst.SLICE_START_CODE_LAST, 44, 75, 136}, new int[]{52, 30, 74, 113, 130, MPEGConst.SLICE_START_CODE_LAST, 51, 64, 58}, new int[]{47, 35, 80, 100, 74, 143, 64, 163, 74}, new int[]{36, 61, 116, 114, 128, 162, 80, 125, 82}}, new int[][]{new int[]{82, 26, 26, 171, JpegConst.RST0, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 44, 32, 105}, new int[]{55, 44, 68, 166, MPEGConst.SEQUENCE_HEADER_CODE, 192, 57, 57, 108}, new int[]{42, 26, 11, 199, 241, JpegConst.APP4, 23, 15, 85}, new int[]{68, 42, 19, 131, Consts.BORDERINPIXELS, 199, 55, 52, 83}, new int[]{58, 50, 25, 139, 115, JpegConst.APP8, 39, 52, 118}, new int[]{50, 35, 33, 153, 104, 162, 64, 59, 131}, new int[]{44, 24, 16, 150, 177, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 33, 19, 156}, new int[]{55, 27, 12, 153, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, JpegConst.SOS, 26, 27, 49}, new int[]{53, 49, 21, 110, 116, 168, 59, 80, 76}, new int[]{38, 72, 19, 168, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, JpegConst.RST4, 50, 50, 107}}, new int[][]{new int[]{103, 26, 36, 129, 132, 201, 83, 80, 93}, new int[]{59, 38, 83, 112, 103, 162, 98, 136, 90}, new int[]{62, 30, 23, 158, 200, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 59, 57, 50}, new int[]{67, 30, 29, 84, 86, 191, 102, 91, 59}, new int[]{60, 32, 33, 112, 71, 220, 64, 89, 104}, new int[]{53, 26, 34, 130, 56, 149, 84, 120, 103}, new int[]{53, 21, 23, 133, 109, JpegConst.RST2, 56, 77, 172}, new int[]{77, 19, 29, 112, 142, JpegConst.APP4, 55, 66, 36}, new int[]{61, 29, 29, 93, 97, 165, 83, MPEGConst.SLICE_START_CODE_LAST, 162}, new int[]{47, 47, 43, 114, 137, MPEGConst.EXTENSION_START_CODE, 100, 99, 95}}, new int[][]{new int[]{69, 23, 29, 128, 83, 199, 46, 44, 101}, new int[]{53, 40, 55, 139, 69, MPEGConst.SEQUENCE_END_CODE, 61, 80, 110}, new int[]{40, 29, 19, 161, MPEGConst.SEQUENCE_ERROR_CODE, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 43, 24, 91}, new int[]{60, 34, 19, 105, 61, 198, 53, 64, 89}, new int[]{52, 31, 22, 158, 40, JpegConst.RST1, 58, 62, 89}, new int[]{44, 31, 29, 147, 46, 158, 56, 102, 198}, new int[]{35, 19, 12, 135, 87, JpegConst.RST1, 41, 45, 167}, new int[]{55, 25, 21, 118, 95, JpegConst.RST7, 38, 39, 66}, new int[]{51, 38, 25, 113, 58, 164, 70, 93, 97}, new int[]{47, 54, 34, 146, 108, MlKitException.CODE_SCANNER_APP_NAME_UNAVAILABLE, 72, 103, 151}}, new int[][]{new int[]{64, 19, 37, 156, 66, 138, 49, 95, 133}, new int[]{46, 27, 80, 150, 55, 124, 55, 121, 135}, new int[]{36, 23, 27, 165, 149, 166, 54, 64, 118}, new int[]{53, 21, 36, 131, 63, 163, 60, 109, 81}, new int[]{40, 26, 35, 154, 40, 185, 51, 97, 123}, new int[]{35, 19, 34, MPEGConst.SEQUENCE_HEADER_CODE, 19, 97, 48, 129, 124}, new int[]{36, 20, 26, 136, 62, 164, 33, 77, 154}, new int[]{45, 18, 32, 130, 90, 157, 40, 79, 91}, new int[]{45, 26, 28, 129, 45, 129, 49, 147, 123}, new int[]{38, 44, 51, 136, 74, 162, 57, 97, 121}}, new int[][]{new int[]{75, 17, 22, 136, 138, 185, 32, 34, 166}, new int[]{56, 39, 58, 133, 117, 173, 48, 53, 187}, new int[]{35, 21, 12, 161, JpegConst.RST4, MlKitException.CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD, 20, 23, 145}, new int[]{56, 29, 19, 117, 109, MPEGConst.EXTENSION_START_CODE, 55, 68, 112}, new int[]{47, 29, 17, 153, 64, 220, 59, 51, 114}, new int[]{46, 16, 24, 136, 76, 147, 41, 64, 172}, new int[]{34, 17, 11, 108, 152, 187, 13, 15, JpegConst.RST1}, new int[]{51, 24, 14, 115, 133, JpegConst.RST1, 32, 26, 104}, new int[]{55, 30, 18, 122, 79, MPEGConst.SEQUENCE_HEADER_CODE, 44, 88, 116}, new int[]{37, 49, 25, 129, 168, 164, 41, 54, Code39Reader.ASTERISK_ENCODING}}, new int[][]{new int[]{82, 22, 32, 127, 143, JpegConst.RST5, 39, 41, 70}, new int[]{62, 44, 61, 123, 105, 189, 48, 57, 64}, new int[]{47, 25, 17, MPEGConst.SLICE_START_CODE_LAST, 222, 220, 24, 30, 86}, new int[]{68, 36, 17, 106, 102, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 59, 74, 74}, new int[]{57, 39, 23, 151, 68, JpegConst.SOI, 55, 63, 58}, new int[]{49, 30, 35, 141, 70, 168, 82, 40, 115}, new int[]{51, 25, 15, 136, 129, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 38, 35, 139}, new int[]{68, 26, 16, 111, 141, JpegConst.RST7, 29, 28, 28}, new int[]{59, 39, 19, 114, 75, MPEGConst.SEQUENCE_ERROR_CODE, 77, 104, 42}, new int[]{40, 61, 26, 126, 152, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 61, 59, 93}}, new int[][]{new int[]{78, 23, 39, 111, 117, 170, 74, 124, 94}, new int[]{48, 34, 86, 101, 92, 146, 78, MPEGConst.SEQUENCE_HEADER_CODE, 134}, new int[]{47, 22, 24, 138, 187, MPEGConst.USER_DATA_START_CODE, 68, 69, 59}, new int[]{56, 25, 33, 105, 112, 187, 95, 177, 129}, new int[]{48, 31, 27, 114, 63, MPEGConst.SEQUENCE_END_CODE, 82, 116, 56}, new int[]{43, 28, 37, 121, 63, 123, 61, 192, 169}, new int[]{42, 17, 24, 109, 97, 177, 56, 76, 122}, new int[]{58, 18, 28, 105, 139, 182, 70, 92, 63}, new int[]{46, 23, 32, 74, 86, 150, 67, MPEGConst.SEQUENCE_END_CODE, 88}, new int[]{36, 38, 48, 92, 122, 165, 88, 137, 91}}, new int[][]{new int[]{65, 70, 60, 155, 159, 199, 61, 60, 81}, new int[]{44, 78, 115, 132, 119, 173, 71, 112, 93}, new int[]{39, 38, 21, MPEGConst.GROUP_START_CODE, JpegConst.APP3, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR, 42, 32, 64}, new int[]{58, 47, 36, 124, 137, JpegConst.SOF1, 80, 82, 78}, new int[]{49, 50, 35, 144, 95, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 63, 78, 59}, new int[]{41, 53, 52, Code39Reader.ASTERISK_ENCODING, 71, 142, 65, 128, 51}, new int[]{40, 36, 28, 143, 143, MlKitException.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED, 40, 55, 137}, new int[]{52, 34, 29, 129, MPEGConst.SEQUENCE_END_CODE, JpegConst.APP3, 42, 35, 43}, new int[]{42, 44, 44, 104, 105, 164, 64, 130, 80}, new int[]{43, 81, 53, 140, 169, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 68, 84, 72}}};
    public static final int[][] kfUvModeProbs = {new int[]{144, 11, 54, 157, JpegConst.SOF3, 130, 46, 58, 108}, new int[]{118, 15, 123, Code39Reader.ASTERISK_ENCODING, 131, 101, 44, 93, 131}, new int[]{113, 12, 23, TsConstants.TS_PACKET_SIZE, JpegConst.APP2, 142, 26, 32, 125}, new int[]{120, 11, 50, 123, 163, 135, 64, 77, 103}, new int[]{113, 9, 36, 155, 111, 157, 32, 44, 161}, new int[]{116, 9, 55, 176, 76, 96, 37, 61, 149}, new int[]{115, 9, 28, 141, 161, 167, 21, 25, JpegConst.SOF1}, new int[]{120, 12, 32, 145, JpegConst.SOF3, 142, 32, 38, 86}, new int[]{116, 12, 64, 120, 140, 125, 49, 115, 121}, new int[]{102, 19, 66, 162, 182, 122, 35, 59, 128}};
    public static final int[][] defaultYModeProbs = {new int[]{65, 32, 18, 144, 162, JpegConst.SOF2, 41, 51, 98}, new int[]{132, 68, 18, 165, JpegConst.EOI, JpegConst.DHT, 45, 40, 78}, new int[]{173, 80, 19, 176, 240, JpegConst.SOF1, 64, 35, 46}, new int[]{JpegConst.DRI, 135, 38, JpegConst.SOF2, 248, 121, 96, 85, 29}};
    public static final int[][] defaultUvModeProbs = {new int[]{120, 7, 76, 176, JpegConst.RST0, 126, 28, 54, 103}, new int[]{48, 12, 154, 155, 139, 90, 34, 117, 119}, new int[]{67, 6, 25, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 243, 158, 13, 21, 96}, new int[]{97, 5, 44, 131, 176, 139, 48, 68, 97}, new int[]{83, 5, 42, 156, 111, 152, 26, 49, 152}, new int[]{80, 5, 58, MPEGConst.USER_DATA_START_CODE, 74, 83, 33, 62, 145}, new int[]{86, 5, 32, 154, 192, 168, 14, 22, 163}, new int[]{85, 5, 32, 156, JpegConst.SOI, Code39Reader.ASTERISK_ENCODING, 19, 29, 73}, new int[]{77, 7, 64, 116, 132, 122, 37, 126, 120}, new int[]{101, 21, 107, MPEGConst.EXTENSION_START_CODE, 192, 103, 19, 67, 125}};
    public static final int[][] defaultSingleRefProb = {new int[]{33, 16}, new int[]{77, 74}, new int[]{142, 142}, new int[]{172, 170}, new int[]{JpegConst.APPE, 247}};
    public static final int[] defaultCompRefProb = {50, 126, 123, JpegConst.DRI, JpegConst.APP2};
    private int[] refFrameWidth = new int[4];
    private int[] refFrameHeight = new int[4];
    private int[] refFrameIdx = new int[3];
    private int[] refFrameSignBias = new int[3];
    private int[] loopFilterRefDeltas = new int[4];
    private int[] loopFilterModeDeltas = new int[2];
    private int[] segmentationTreeProbs = new int[7];
    private int[] segmentationPredProbs = new int[3];

    public DecodingContext() {
        Class cls = Integer.TYPE;
        this.featureEnabled = (int[][]) Array.newInstance((Class<?>) cls, 8, 4);
        this.featureData = (int[][]) Array.newInstance((Class<?>) cls, 8, 4);
        this.tx8x8Probs = (int[][]) Array.newInstance((Class<?>) cls, 2, 1);
        this.tx16x16Probs = (int[][]) Array.newInstance((Class<?>) cls, 2, 2);
        this.tx32x32Probs = (int[][]) Array.newInstance((Class<?>) cls, 2, 3);
        this.skipProbs = new int[3];
        this.interModeProbs = (int[][]) Array.newInstance((Class<?>) cls, 7, 3);
        this.interpFilterProbs = (int[][]) Array.newInstance((Class<?>) cls, 4, 2);
        this.isInterProbs = new int[4];
        this.compModeProbs = new int[5];
        this.singleRefProbs = (int[][]) Array.newInstance((Class<?>) cls, 5, 2);
        this.compRefProbs = new int[5];
        this.yModeProbs = (int[][]) Array.newInstance((Class<?>) cls, 4, 9);
        this.partitionProbs = (int[][]) Array.newInstance((Class<?>) cls, 16, 3);
        this.uvModeProbs = (int[][]) Array.newInstance((Class<?>) cls, 10, 9);
        this.mvJointProbs = new int[3];
        this.mvSignProbs = new int[2];
        this.mvClassProbs = (int[][]) Array.newInstance((Class<?>) cls, 2, 10);
        this.mvClass0BitProbs = new int[2];
        this.mvBitsProbs = (int[][]) Array.newInstance((Class<?>) cls, 2, 10);
        this.mvClass0FrProbs = (int[][][]) Array.newInstance((Class<?>) cls, 2, 2, 3);
        this.mvFrProbs = (int[][]) Array.newInstance((Class<?>) cls, 2, 3);
        this.mvClass0HpProb = new int[2];
        this.mvHpProbs = new int[2];
        ArrayUtil.copy1D(this.skipProbs, defaultSkipProb);
        ArrayUtil.copy2D(this.tx8x8Probs, defaultTxProbs8x8);
        ArrayUtil.copy2D(this.tx16x16Probs, defaultTxProbs16x16);
        ArrayUtil.copy2D(this.tx32x32Probs, defaultTxProbs32x32);
        this.coefProbs = (int[][][][][][]) Array.newInstance((Class<?>) int[][].class, 4, 2, 2, 6);
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                for (int i3 = 0; i3 < 2; i3++) {
                    this.coefProbs[i][i2][i3][0] = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 3);
                    for (int i4 = 1; i4 < 6; i4++) {
                        this.coefProbs[i][i2][i3][i4] = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 3);
                    }
                }
            }
        }
        ArrayUtil.copy6D(this.coefProbs, defaultCoefProbs);
        ArrayUtil.copy1D(this.mvJointProbs, defaultMvJointProbs);
        ArrayUtil.copy1D(this.mvSignProbs, defaultMvSignProb);
        ArrayUtil.copy2D(this.mvClassProbs, defaultMvClassProbs);
        ArrayUtil.copy1D(this.mvClass0BitProbs, defaultMvClass0BitProb);
        ArrayUtil.copy2D(this.mvBitsProbs, defaultMvBitsProb);
        ArrayUtil.copy3D(this.mvClass0FrProbs, defaultMvClass0FrProbs);
        ArrayUtil.copy2D(this.mvFrProbs, defaultMvFrProbs);
        ArrayUtil.copy1D(this.mvClass0HpProb, defaultMvClass0HpProb);
        ArrayUtil.copy1D(this.mvHpProbs, defaultMvHpProb);
        ArrayUtil.copy2D(this.interModeProbs, defaultInterModeProbs);
        ArrayUtil.copy2D(this.interpFilterProbs, defaultInterpFilterProbs);
        ArrayUtil.copy1D(this.isInterProbs, defaultIsInterProbs);
        ArrayUtil.copy2D(this.singleRefProbs, defaultSingleRefProb);
        ArrayUtil.copy2D(this.yModeProbs, defaultYModeProbs);
        ArrayUtil.copy2D(this.uvModeProbs, defaultUvModeProbs);
        ArrayUtil.copy2D(this.partitionProbs, defaultPartitionProbs);
        ArrayUtil.copy1D(this.compRefProbs, defaultCompRefProb);
    }

    public static DecodingContext createFromHeaders(ByteBuffer byteBuffer) {
        DecodingContext decodingContext = new DecodingContext();
        decodingContext.readCompressedHeader(NIOUtils.read(byteBuffer, decodingContext.readUncompressedHeader(byteBuffer)));
        return decodingContext;
    }

    private int decodeTermSubexp(VPXBooleanDecoder vPXBooleanDecoder) {
        if (vPXBooleanDecoder.readBitEq() == 0) {
            return vPXBooleanDecoder.decodeInt(4);
        }
        if (vPXBooleanDecoder.readBitEq() == 0) {
            return vPXBooleanDecoder.decodeInt(4) + 16;
        }
        if (vPXBooleanDecoder.readBitEq() == 0) {
            return vPXBooleanDecoder.decodeInt(5) + 32;
        }
        int iDecodeInt = vPXBooleanDecoder.decodeInt(7);
        if (iDecodeInt < 65) {
            return iDecodeInt + 64;
        }
        return ((iDecodeInt << 1) - 1) + vPXBooleanDecoder.readBitEq();
    }

    private int diffUpdateProb(VPXBooleanDecoder vPXBooleanDecoder, int i) {
        return vPXBooleanDecoder.readBit(252) == 1 ? invRemapProb(decodeTermSubexp(vPXBooleanDecoder), i) : i;
    }

    private void frameReferenceMode(VPXBooleanDecoder vPXBooleanDecoder) {
        boolean z = false;
        for (int i = 1; i < 3; i++) {
            int[] iArr = this.refFrameSignBias;
            if (iArr[i] != iArr[0]) {
                z = true;
            }
        }
        if (!z) {
            this.refMode = 0;
            return;
        }
        if (vPXBooleanDecoder.readBitEq() == 0) {
            this.refMode = 0;
            return;
        }
        if (vPXBooleanDecoder.readBitEq() == 0) {
            this.refMode = 1;
        } else {
            this.refMode = 2;
        }
        setupCompoundReferenceMode();
    }

    private void frameReferenceModeProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        if (this.refMode == 2) {
            for (int i = 0; i < 5; i++) {
                int[] iArr = this.compModeProbs;
                iArr[i] = diffUpdateProb(vPXBooleanDecoder, iArr[i]);
            }
        }
        if (this.refMode != 1) {
            for (int i2 = 0; i2 < 5; i2++) {
                int[] iArr2 = this.singleRefProbs[i2];
                iArr2[0] = diffUpdateProb(vPXBooleanDecoder, iArr2[0]);
                int[] iArr3 = this.singleRefProbs[i2];
                iArr3[1] = diffUpdateProb(vPXBooleanDecoder, iArr3[1]);
            }
        }
        if (this.refMode != 0) {
            for (int i3 = 0; i3 < 5; i3++) {
                int[] iArr4 = this.compRefProbs;
                iArr4[i3] = diffUpdateProb(vPXBooleanDecoder, iArr4[i3]);
            }
        }
    }

    private static void frame_sync_code(BitReader bitReader) {
        bitReader.readNBit(24);
    }

    private int invRecenterNonneg(int i, int i2) {
        return i > i2 * 2 ? i : (i & 1) != 0 ? i2 - ((i + 1) >> 1) : i2 + (i >> 1);
    }

    private int invRemapProb(int i, int i2) {
        int i3 = Consts.INV_REMAP_TABLE[i];
        int i4 = i2 - 1;
        return (i4 << 1) <= 255 ? invRecenterNonneg(i3, i4) + 1 : 255 - invRecenterNonneg(i3, 254 - i4);
    }

    private void mvProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.mvJointProbs;
            iArr[i] = updateMvProb(vPXBooleanDecoder, iArr[i]);
        }
        for (int i2 = 0; i2 < 2; i2++) {
            int[] iArr2 = this.mvSignProbs;
            iArr2[i2] = updateMvProb(vPXBooleanDecoder, iArr2[i2]);
            for (int i3 = 0; i3 < 10; i3++) {
                int[] iArr3 = this.mvClassProbs[i2];
                iArr3[i3] = updateMvProb(vPXBooleanDecoder, iArr3[i3]);
            }
            int[] iArr4 = this.mvClass0BitProbs;
            iArr4[i2] = updateMvProb(vPXBooleanDecoder, iArr4[i2]);
            for (int i4 = 0; i4 < 10; i4++) {
                int[] iArr5 = this.mvBitsProbs[i2];
                iArr5[i4] = updateMvProb(vPXBooleanDecoder, iArr5[i4]);
            }
        }
        for (int i5 = 0; i5 < 2; i5++) {
            for (int i6 = 0; i6 < 2; i6++) {
                for (int i7 = 0; i7 < 3; i7++) {
                    int[] iArr6 = this.mvClass0FrProbs[i5][i6];
                    iArr6[i7] = updateMvProb(vPXBooleanDecoder, iArr6[i7]);
                }
            }
            for (int i8 = 0; i8 < 3; i8++) {
                int[] iArr7 = this.mvFrProbs[i5];
                iArr7[i8] = updateMvProb(vPXBooleanDecoder, iArr7[i8]);
            }
        }
        if (this.allowHighPrecisionMv == 1) {
            for (int i9 = 0; i9 < 2; i9++) {
                int[] iArr8 = this.mvClass0HpProb;
                iArr8[i9] = updateMvProb(vPXBooleanDecoder, iArr8[i9]);
                int[] iArr9 = this.mvHpProbs;
                iArr9[i9] = updateMvProb(vPXBooleanDecoder, iArr9[i9]);
            }
        }
    }

    private void readCoefProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        int i = Consts.tx_mode_to_biggest_tx_size[this.txMode];
        for (int i2 = 0; i2 <= i; i2++) {
            if (vPXBooleanDecoder.readBitEq() == 1) {
                for (int i3 = 0; i3 < 2; i3++) {
                    for (int i4 = 0; i4 < 2; i4++) {
                        int i5 = 0;
                        while (true) {
                            if (i5 < 6) {
                                int i6 = i5 == 0 ? 3 : 6;
                                for (int i7 = 0; i7 < i6; i7++) {
                                    for (int i8 = 0; i8 < 3; i8++) {
                                        int[] iArr = this.coefProbs[i2][i3][i4][i5][i7];
                                        iArr[i8] = diffUpdateProb(vPXBooleanDecoder, iArr[i8]);
                                    }
                                }
                                i5++;
                            }
                        }
                    }
                }
            }
        }
    }

    private void readColorConfig(BitReader bitReader) {
        if (this.profile >= 2) {
            this.bitDepth = bitReader.read1Bit() == 1 ? 12 : 10;
        } else {
            this.bitDepth = 8;
        }
        if (bitReader.readNBit(3) == 7) {
            this.colorRange = 1;
            int i = this.profile;
            if (i == 1 || i == 3) {
                this.subsamplingX = 0;
                this.subsamplingY = 0;
                bitReader.read1Bit();
                return;
            }
            return;
        }
        this.colorRange = bitReader.read1Bit();
        int i2 = this.profile;
        if (i2 != 1 && i2 != 3) {
            this.subsamplingX = 1;
            this.subsamplingY = 1;
        } else {
            this.subsamplingX = bitReader.read1Bit();
            this.subsamplingY = bitReader.read1Bit();
            bitReader.read1Bit();
        }
    }

    private static int readDeltaQ(BitReader bitReader) {
        if (bitReader.read1Bit() == 1) {
            return bitReader.readNBitSigned(4);
        }
        return 0;
    }

    private void readFrameSize(BitReader bitReader) {
        this.frameWidth = bitReader.readNBit(16) + 1;
        this.frameHeight = bitReader.readNBit(16) + 1;
    }

    private void readFrameSizeWithRefs(BitReader bitReader) {
        int i = 0;
        while (true) {
            if (i >= 3) {
                break;
            }
            if (bitReader.read1Bit() == 1) {
                int[] iArr = this.refFrameWidth;
                int i2 = this.refFrameIdx[i];
                this.frameWidth = iArr[i2];
                this.frameHeight = this.refFrameHeight[i2];
                break;
            }
            i++;
        }
        if (i == 3) {
            readFrameSize(bitReader);
        }
        readRenderSize(bitReader);
    }

    private void readInterModeProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 7; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArr = this.interModeProbs[i];
                iArr[i2] = diffUpdateProb(vPXBooleanDecoder, iArr[i2]);
            }
        }
    }

    private void readInterpFilterProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 2; i2++) {
                int[] iArr = this.interpFilterProbs[i];
                iArr[i2] = diffUpdateProb(vPXBooleanDecoder, iArr[i2]);
            }
        }
    }

    private void readInterpolationFilter(BitReader bitReader) {
        this.interpFilter = 3;
        if (bitReader.read1Bit() == 0) {
            this.interpFilter = Consts.LITERAL_TO_FILTER_TYPE[bitReader.readNBit(2)];
        }
    }

    private void readIsInterProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 4; i++) {
            int[] iArr = this.isInterProbs;
            iArr[i] = diffUpdateProb(vPXBooleanDecoder, iArr[i]);
        }
    }

    private void readLoopFilterParams(BitReader bitReader) {
        this.filterLevel = bitReader.readNBit(6);
        this.sharpnessLevel = bitReader.readNBit(3);
        if (bitReader.read1Bit() == 1 && bitReader.read1Bit() == 1) {
            for (int i = 0; i < 4; i++) {
                if (bitReader.read1Bit() == 1) {
                    this.loopFilterRefDeltas[i] = bitReader.readNBitSigned(6);
                }
            }
            for (int i2 = 0; i2 < 2; i2++) {
                if (bitReader.read1Bit() == 1) {
                    this.loopFilterModeDeltas[i2] = bitReader.readNBitSigned(6);
                }
            }
        }
    }

    private void readPartitionProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 16; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                int[] iArr = this.partitionProbs[i];
                iArr[i2] = diffUpdateProb(vPXBooleanDecoder, iArr[i2]);
            }
        }
    }

    private static int readProb(BitReader bitReader) {
        if (bitReader.read1Bit() == 1) {
            return bitReader.readNBit(8);
        }
        return 255;
    }

    private void readQuantizationParams(BitReader bitReader) {
        this.baseQIdx = bitReader.readNBit(8);
        this.deltaQYDc = readDeltaQ(bitReader);
        this.deltaQUvDc = readDeltaQ(bitReader);
        int deltaQ = readDeltaQ(bitReader);
        this.deltaQUvAc = deltaQ;
        this.lossless = this.baseQIdx == 0 && this.deltaQYDc == 0 && this.deltaQUvDc == 0 && deltaQ == 0;
    }

    private void readRenderSize(BitReader bitReader) {
        if (bitReader.read1Bit() == 1) {
            this.renderWidth = bitReader.readNBit(16) + 1;
            this.renderHeight = bitReader.readNBit(16) + 1;
        } else {
            this.renderWidth = this.frameWidth;
            this.renderHeight = this.frameHeight;
        }
    }

    private void readSegmentationParams(BitReader bitReader) {
        boolean z = bitReader.read1Bit() == 1;
        this.segmentationEnabled = z;
        if (z) {
            if (bitReader.read1Bit() == 1) {
                for (int i = 0; i < 7; i++) {
                    this.segmentationTreeProbs[i] = readProb(bitReader);
                }
                int i2 = bitReader.read1Bit();
                for (int i3 = 0; i3 < 3; i3++) {
                    this.segmentationPredProbs[i3] = i2 == 1 ? readProb(bitReader) : 255;
                }
            }
            if (bitReader.read1Bit() == 1) {
                bitReader.read1Bit();
                for (int i4 = 0; i4 < 8; i4++) {
                    for (int i5 = 0; i5 < 4; i5++) {
                        if (bitReader.read1Bit() == 1) {
                            this.featureEnabled[i4][i5] = 1;
                            int nBit = bitReader.readNBit(Consts.SEGMENTATION_FEATURE_BITS[i5]);
                            if (Consts.SEGMENTATION_FEATURE_SIGNED[i5] == 1 && bitReader.read1Bit() == 1) {
                                nBit *= -1;
                            }
                            this.featureData[i4][i5] = nBit;
                        }
                    }
                }
            }
        }
    }

    private void readSkipProb(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 3; i++) {
            int[] iArr = this.skipProbs;
            iArr[i] = diffUpdateProb(vPXBooleanDecoder, iArr[i]);
        }
    }

    private void readTileInfo(BitReader bitReader) {
        int iCalc_min_log2_tile_cols = calc_min_log2_tile_cols();
        int iCalc_max_log2_tile_cols = calc_max_log2_tile_cols();
        this.tileColsLog2 = iCalc_min_log2_tile_cols;
        while (this.tileColsLog2 < iCalc_max_log2_tile_cols && bitReader.read1Bit() == 1) {
            this.tileColsLog2++;
        }
        int i = bitReader.read1Bit();
        this.tileRowsLog2 = i;
        if (i == 1) {
            this.tileRowsLog2 += bitReader.read1Bit();
        }
    }

    private void readTxMode(VPXBooleanDecoder vPXBooleanDecoder) {
        if (this.lossless) {
            this.txMode = 0;
            return;
        }
        int iDecodeInt = vPXBooleanDecoder.decodeInt(2);
        this.txMode = iDecodeInt;
        if (iDecodeInt == 3) {
            this.txMode = iDecodeInt + vPXBooleanDecoder.decodeInt(1);
        }
    }

    private void readTxModeProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 2; i++) {
            for (int i2 = 0; i2 < 1; i2++) {
                int[] iArr = this.tx8x8Probs[i];
                iArr[i2] = diffUpdateProb(vPXBooleanDecoder, iArr[i2]);
            }
        }
        for (int i3 = 0; i3 < 2; i3++) {
            for (int i4 = 0; i4 < 2; i4++) {
                int[] iArr2 = this.tx16x16Probs[i3];
                iArr2[i4] = diffUpdateProb(vPXBooleanDecoder, iArr2[i4]);
            }
        }
        for (int i5 = 0; i5 < 2; i5++) {
            for (int i6 = 0; i6 < 3; i6++) {
                int[] iArr3 = this.tx32x32Probs[i5];
                iArr3[i6] = diffUpdateProb(vPXBooleanDecoder, iArr3[i6]);
            }
        }
    }

    private void readYModeProbs(VPXBooleanDecoder vPXBooleanDecoder) {
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 9; i2++) {
                int[] iArr = this.yModeProbs[i];
                iArr[i2] = diffUpdateProb(vPXBooleanDecoder, iArr[i2]);
            }
        }
    }

    private void setupCompoundReferenceMode() {
        int[] iArr = this.refFrameSignBias;
        int i = iArr[1];
        if (i == iArr[3]) {
            this.compFixedRef = 2;
            this.compVarRef0 = 1;
            this.compVarRef1 = 3;
        } else if (i == iArr[2]) {
            this.compFixedRef = 3;
            this.compVarRef0 = 1;
            this.compVarRef1 = 2;
        } else {
            this.compFixedRef = 1;
            this.compVarRef0 = 3;
            this.compVarRef1 = 2;
        }
    }

    private int updateMvProb(VPXBooleanDecoder vPXBooleanDecoder, int i) {
        return vPXBooleanDecoder.readBit(252) == 1 ? (vPXBooleanDecoder.decodeInt(7) << 1) | 1 : i;
    }

    public int calc_max_log2_tile_cols() {
        int i = 1;
        while ((((this.frameWidth + 63) >> 6) >> i) >= 4) {
            i++;
        }
        return i - 1;
    }

    public int calc_min_log2_tile_cols() {
        int i = 0;
        while ((64 << i) < ((this.frameWidth + 63) >> 6)) {
            i++;
        }
        return i;
    }

    public long[] getAbove4x4MVs() {
        return null;
    }

    public boolean[] getAboveCompound() {
        return this.aboveCompound;
    }

    public int[] getAboveInterpFilters() {
        return this.aboveInterpFilters;
    }

    public long[][] getAboveLeftMVs() {
        return null;
    }

    public long[][] getAboveMVs() {
        return null;
    }

    public int[] getAboveModes() {
        return this.aboveModes;
    }

    public int[][] getAboveNonzeroContext() {
        return this.aboveNonzeroContext;
    }

    public int[] getAbovePartitionSizes() {
        return this.abovePartitionSizes;
    }

    public int[] getAboveRefs() {
        return this.aboveRefs;
    }

    public boolean[] getAboveSegIdPredicted() {
        return null;
    }

    public boolean[] getAboveSkipped() {
        return this.aboveSkipped;
    }

    public int[] getAboveTxSizes() {
        return this.aboveTxSizes;
    }

    public int getBaseQIdx() {
        return this.baseQIdx;
    }

    public int getBitDepth() {
        return this.bitDepth;
    }

    public int[][][][][][] getCoefProbs() {
        return this.coefProbs;
    }

    public int getCompFixedRef() {
        return 0;
    }

    public int[] getCompModeProb() {
        return this.compModeProbs;
    }

    public int[] getCompRefProbs() {
        return this.compRefProbs;
    }

    public int getCompVarRef(int i) {
        return 0;
    }

    public int getDeltaQUvAc() {
        return this.deltaQUvAc;
    }

    public int getDeltaQUvDc() {
        return this.deltaQUvDc;
    }

    public int getDeltaQYDc() {
        return this.deltaQYDc;
    }

    public int getFilterLevel() {
        return this.filterLevel;
    }

    public int getFrameContextIdx() {
        return this.frameContextIdx;
    }

    public int getFrameHeight() {
        return this.frameHeight;
    }

    public int getFrameWidth() {
        return this.frameWidth;
    }

    public int[][] getInterModeProbs() {
        return this.interModeProbs;
    }

    public int getInterpFilter() {
        return this.interpFilter;
    }

    public int[][] getInterpFilterProbs() {
        return this.interpFilterProbs;
    }

    public int[] getIsInterProbs() {
        return this.isInterProbs;
    }

    public int[][] getKfUVModeProbs() {
        return kfUvModeProbs;
    }

    public int[][][] getKfYModeProbs() {
        return kfYmodeProbs;
    }

    public long[] getLeft4x4MVs() {
        return null;
    }

    public boolean[] getLeftCompound() {
        return this.leftCompound;
    }

    public int[] getLeftInterpFilters() {
        return this.leftInterpFilters;
    }

    public long[][] getLeftMVs() {
        return null;
    }

    public int[] getLeftModes() {
        return this.leftModes;
    }

    public int[][] getLeftNonzeroContext() {
        return this.leftNonzeroContext;
    }

    public int[] getLeftPartitionSizes() {
        return this.leftPartitionSizes;
    }

    public int[] getLeftRefs() {
        return this.leftRefs;
    }

    public boolean[] getLeftSegIdPredicted() {
        return null;
    }

    public boolean[] getLeftSkipped() {
        return this.leftSkipped;
    }

    public int[] getLeftTxSizes() {
        return this.leftTxSizes;
    }

    public int getMiFrameHeight() {
        return (this.frameHeight + 7) >> 3;
    }

    public int getMiFrameWidth() {
        return (this.frameWidth + 7) >> 3;
    }

    public int getMiTileHeight() {
        return this.tileHeight;
    }

    public int getMiTileStartCol() {
        return this.miTileStartCol;
    }

    public int getMiTileWidth() {
        return this.tileWidth;
    }

    public int[][] getMvBitsProb() {
        return this.mvBitsProbs;
    }

    public int[] getMvClass0BitProbs() {
        return this.mvClass0BitProbs;
    }

    public int[][][] getMvClass0FrProbs() {
        return this.mvClass0FrProbs;
    }

    public int[] getMvClass0HpProbs() {
        return this.mvClass0HpProb;
    }

    public int[][] getMvClassProbs() {
        return this.mvClassProbs;
    }

    public int[][] getMvFrProbs() {
        return this.mvFrProbs;
    }

    public int[] getMvHpProbs() {
        return this.mvHpProbs;
    }

    public int[] getMvJointProbs() {
        return this.mvJointProbs;
    }

    public int[] getMvSignProb() {
        return this.mvSignProbs;
    }

    public int[][] getPartitionProbs() {
        return this.partitionProbs;
    }

    public long[][] getPrevFrameMv() {
        return null;
    }

    public int[][] getPrevSegmentIds() {
        return null;
    }

    public int getRefMode() {
        return this.refMode;
    }

    public int getSegmentFeature(int i, int i2) {
        return 0;
    }

    public int[] getSegmentationPredProbs() {
        return this.segmentationPredProbs;
    }

    public int[] getSegmentationTreeProbs() {
        return this.segmentationTreeProbs;
    }

    public int getSharpnessLevel() {
        return this.sharpnessLevel;
    }

    public int[][] getSingleRefProbs() {
        return this.singleRefProbs;
    }

    public int[] getSkipProbs() {
        return this.skipProbs;
    }

    public int getSubX() {
        return this.subsamplingX;
    }

    public int getSubY() {
        return this.subsamplingY;
    }

    public int getTileColsLog2() {
        return this.tileColsLog2;
    }

    public int getTileRowsLog2() {
        return this.tileRowsLog2;
    }

    public int[][] getTx16x16Probs() {
        return this.tx16x16Probs;
    }

    public int[][] getTx32x32Probs() {
        return this.tx32x32Probs;
    }

    public int[][] getTx8x8Probs() {
        return this.tx8x8Probs;
    }

    public int getTxMode() {
        return this.txMode;
    }

    public int[][] getUvModeProbs() {
        return this.uvModeProbs;
    }

    public int[][] getYModeProbs() {
        return this.yModeProbs;
    }

    public boolean isAllowHpMv() {
        return false;
    }

    public boolean isKeyIntraFrame() {
        return false;
    }

    public boolean isSegmentFeatureActive(int i, int i2) {
        return false;
    }

    public boolean isSegmentMapConditionalUpdate() {
        return false;
    }

    public boolean isSegmentationEnabled() {
        return this.segmentationEnabled;
    }

    public boolean isUpdateSegmentMap() {
        return false;
    }

    public boolean isUsePrevFrameMvs() {
        return false;
    }

    public void readCompressedHeader(ByteBuffer byteBuffer) {
        VPXBooleanDecoder vPXBooleanDecoder = new VPXBooleanDecoder(byteBuffer, 0);
        if (vPXBooleanDecoder.readBitEq() != 0) {
            throw new RuntimeException("Invalid marker bit");
        }
        readTxMode(vPXBooleanDecoder);
        if (this.txMode == 4) {
            readTxModeProbs(vPXBooleanDecoder);
        }
        readCoefProbs(vPXBooleanDecoder);
        readSkipProb(vPXBooleanDecoder);
        if (this.frameIsIntra == 0) {
            readInterModeProbs(vPXBooleanDecoder);
            if (this.interpFilter == 3) {
                readInterpFilterProbs(vPXBooleanDecoder);
            }
            readIsInterProbs(vPXBooleanDecoder);
            frameReferenceMode(vPXBooleanDecoder);
            frameReferenceModeProbs(vPXBooleanDecoder);
            readYModeProbs(vPXBooleanDecoder);
            readPartitionProbs(vPXBooleanDecoder);
            mvProbs(vPXBooleanDecoder);
        }
    }

    public int readUncompressedHeader(ByteBuffer byteBuffer) {
        BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
        bitReaderCreateBitReader.readNBit(2);
        int i = bitReaderCreateBitReader.read1Bit() | (bitReaderCreateBitReader.read1Bit() << 1);
        this.profile = i;
        if (i == 3) {
            bitReaderCreateBitReader.read1Bit();
        }
        int i2 = bitReaderCreateBitReader.read1Bit();
        this.showExistingFrame = i2;
        if (i2 == 1) {
            this.frameToShowMapIdx = bitReaderCreateBitReader.readNBit(3);
        }
        this.frameType = bitReaderCreateBitReader.read1Bit();
        this.showFrame = bitReaderCreateBitReader.read1Bit();
        this.errorResilientMode = bitReaderCreateBitReader.read1Bit();
        if (this.frameType == 0) {
            frame_sync_code(bitReaderCreateBitReader);
            readColorConfig(bitReaderCreateBitReader);
            readFrameSize(bitReaderCreateBitReader);
            readRenderSize(bitReaderCreateBitReader);
            this.refreshFrameFlags = 255;
            this.frameIsIntra = 1;
        } else {
            this.intraOnly = 0;
            if (this.showFrame == 0) {
                this.intraOnly = bitReaderCreateBitReader.read1Bit();
            }
            this.resetFrameContext = 0;
            if (this.errorResilientMode == 0) {
                this.resetFrameContext = bitReaderCreateBitReader.readNBit(2);
            }
            if (this.intraOnly == 1) {
                frame_sync_code(bitReaderCreateBitReader);
                if (this.profile > 0) {
                    readColorConfig(bitReaderCreateBitReader);
                } else {
                    this.colorSpace = 1;
                    this.subsamplingX = 1;
                    this.subsamplingY = 1;
                    this.bitDepth = 8;
                }
                this.refreshFrameFlags = bitReaderCreateBitReader.readNBit(8);
                readFrameSize(bitReaderCreateBitReader);
                readRenderSize(bitReaderCreateBitReader);
            } else {
                bitReaderCreateBitReader.readNBit(8);
                int i3 = 0;
                while (i3 < 3) {
                    this.refFrameIdx[i3] = bitReaderCreateBitReader.readNBit(3);
                    i3++;
                    this.refFrameSignBias[i3] = bitReaderCreateBitReader.read1Bit();
                }
                readFrameSizeWithRefs(bitReaderCreateBitReader);
                this.allowHighPrecisionMv = bitReaderCreateBitReader.read1Bit();
                readInterpolationFilter(bitReaderCreateBitReader);
            }
        }
        this.refreshFrameContext = 0;
        if (this.errorResilientMode == 0) {
            this.refreshFrameContext = bitReaderCreateBitReader.read1Bit();
            this.frameParallelDecodingMode = bitReaderCreateBitReader.read1Bit();
        }
        this.frameContextIdx = bitReaderCreateBitReader.readNBit(2);
        readLoopFilterParams(bitReaderCreateBitReader);
        readQuantizationParams(bitReaderCreateBitReader);
        readSegmentationParams(bitReaderCreateBitReader);
        readTileInfo(bitReaderCreateBitReader);
        int nBit = bitReaderCreateBitReader.readNBit(16);
        bitReaderCreateBitReader.terminate();
        return nBit;
    }

    public int refFrameSignBias(int i) {
        return 0;
    }
}
