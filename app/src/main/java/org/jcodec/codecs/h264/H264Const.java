package org.jcodec.codecs.h264;

import com.google.mlkit.common.MlKitException;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import java.util.Arrays;
import org.jcodec.codecs.h264.io.model.MBType;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.common.io.VLC;
import org.jcodec.common.io.VLCBuilder;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class H264Const {
    public static final int[][] ARRAY;
    public static final int[][] BLK8x8_BLOCKS;
    public static final int[] BLK_4x4_MB_OFF_LUMA;
    public static final int[] BLK_8x8_IND;
    public static final int[] BLK_8x8_MB_OFF_CHROMA;
    public static final int[] BLK_8x8_MB_OFF_LUMA;
    public static final int[] BLK_8x8_X;
    public static final int[] BLK_8x8_Y;
    public static final int[] BLK_INV_MAP;
    public static final int[] BLK_X;
    public static final int[] BLK_Y;
    public static final int[] CHROMA_BLOCK_LUT;
    public static final int[] CHROMA_POS_LUT;
    public static final int[] CODED_BLOCK_PATTERN_INTER_COLOR;
    public static final int[] CODED_BLOCK_PATTERN_INTER_COLOR_INV;
    public static final int[] CODED_BLOCK_PATTERN_INTRA_COLOR;
    public static final int[][] COMP_BLOCK_4x4_LUT;
    public static final int[][] COMP_BLOCK_8x8_LUT;
    public static final int[][] COMP_POS_4x4_LUT;
    public static final int[][] COMP_POS_8x8_LUT;
    public static final VLC[] CoeffToken;
    public static final int[] LUMA_4x4_BLOCK_LUT;
    public static final int[] LUMA_4x4_POS_LUT;
    public static final int[] LUMA_8x8_BLOCK_LUT;
    public static final int[] LUMA_8x8_POS_LUT;
    public static final int[] MB_BLK_OFF_LEFT;
    public static final int[] MB_BLK_OFF_TOP;
    public static final Picture NO_PIC;
    public static final int[][] PIX_MAP_SPLIT_2x2;
    public static final int[][] PIX_MAP_SPLIT_4x4;
    public static final int PROFILE_BASELINE = 66;
    public static final int PROFILE_CAVLC_INTRA = 44;
    public static final int PROFILE_EXTENDED = 88;
    public static final int PROFILE_HIGH = 100;
    public static final int PROFILE_HIGH_10 = 110;
    public static final int PROFILE_HIGH_422 = 122;
    public static final int PROFILE_HIGH_444 = 244;
    public static final int PROFILE_MAIN = 77;
    public static final int[] QP_SCALE_CR;
    public static final MBType[] bMbTypes;
    public static final int[] bPartH;
    public static final PartPred[] bPartPredModes;
    public static final int[] bPartW;
    public static final PartPred[][] bPredModes;
    public static final int[] bSubMbTypes;
    public static final int[] coded_block_pattern_inter_monochrome;
    public static final int[] coded_block_pattern_intra_monochrome;
    public static final VLC coeffTokenChromaDCY420;
    public static final VLC coeffTokenChromaDCY422;
    public static final int[] defaultScalingList4x4Inter;
    public static final int[] defaultScalingList4x4Intra;
    public static final int[] defaultScalingList8x8Inter;
    public static final int[] defaultScalingList8x8Intra;
    public static final int[] identityMapping16;
    public static final int[] identityMapping4;
    public static final int[] last_sig_coeff_map_8x8;
    public static final VLC[] run;
    public static final int[] sig_coeff_map_8x8;
    public static final int[] sig_coeff_map_8x8_mbaff;
    public static final VLC[] totalZeros16;
    public static final VLC[] totalZeros4;
    public static final VLC[] totalZeros8;

    public enum PartPred {
        L0,
        L1,
        Bi,
        Direct
    }

    static {
        VLC[] vlcArr = new VLC[10];
        CoeffToken = vlcArr;
        VLCBuilder vLCBuilder = new VLCBuilder();
        vLCBuilder.set(0, "1");
        vLCBuilder.set(coeffToken(1, 0), "000101");
        vLCBuilder.set(coeffToken(1, 1), "01");
        vLCBuilder.set(coeffToken(2, 0), "00000111");
        vLCBuilder.set(coeffToken(2, 1), "000100");
        vLCBuilder.set(coeffToken(2, 2), PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY);
        vLCBuilder.set(coeffToken(3, 0), "000000111");
        vLCBuilder.set(coeffToken(3, 1), "00000110");
        vLCBuilder.set(coeffToken(3, 2), "0000101");
        vLCBuilder.set(coeffToken(3, 3), "00011");
        vLCBuilder.set(coeffToken(4, 0), "0000000111");
        vLCBuilder.set(coeffToken(4, 1), "000000110");
        vLCBuilder.set(coeffToken(4, 2), "00000101");
        vLCBuilder.set(coeffToken(4, 3), "000011");
        vLCBuilder.set(coeffToken(5, 0), "00000000111");
        vLCBuilder.set(coeffToken(5, 1), "0000000110");
        vLCBuilder.set(coeffToken(5, 2), "000000101");
        vLCBuilder.set(coeffToken(5, 3), "0000100");
        vLCBuilder.set(coeffToken(6, 0), "0000000001111");
        vLCBuilder.set(coeffToken(6, 1), "00000000110");
        vLCBuilder.set(coeffToken(6, 2), "0000000101");
        vLCBuilder.set(coeffToken(6, 3), "00000100");
        vLCBuilder.set(coeffToken(7, 0), "0000000001011");
        vLCBuilder.set(coeffToken(7, 1), "0000000001110");
        vLCBuilder.set(coeffToken(7, 2), "00000000101");
        vLCBuilder.set(coeffToken(7, 3), "000000100");
        vLCBuilder.set(coeffToken(8, 0), "0000000001000");
        vLCBuilder.set(coeffToken(8, 1), "0000000001010");
        vLCBuilder.set(coeffToken(8, 2), "0000000001101");
        vLCBuilder.set(coeffToken(8, 3), "0000000100");
        vLCBuilder.set(coeffToken(9, 0), "00000000001111");
        vLCBuilder.set(coeffToken(9, 1), "00000000001110");
        vLCBuilder.set(coeffToken(9, 2), "0000000001001");
        vLCBuilder.set(coeffToken(9, 3), "00000000100");
        vLCBuilder.set(coeffToken(10, 0), "00000000001011");
        vLCBuilder.set(coeffToken(10, 1), "00000000001010");
        vLCBuilder.set(coeffToken(10, 2), "00000000001101");
        vLCBuilder.set(coeffToken(10, 3), "0000000001100");
        vLCBuilder.set(coeffToken(11, 0), "000000000001111");
        vLCBuilder.set(coeffToken(11, 1), "000000000001110");
        vLCBuilder.set(coeffToken(11, 2), "00000000001001");
        vLCBuilder.set(coeffToken(11, 3), "00000000001100");
        vLCBuilder.set(coeffToken(12, 0), "000000000001011");
        vLCBuilder.set(coeffToken(12, 1), "000000000001010");
        vLCBuilder.set(coeffToken(12, 2), "000000000001101");
        vLCBuilder.set(coeffToken(12, 3), "00000000001000");
        vLCBuilder.set(coeffToken(13, 0), "0000000000001111");
        vLCBuilder.set(coeffToken(13, 1), "000000000000001");
        vLCBuilder.set(coeffToken(13, 2), "000000000001001");
        vLCBuilder.set(coeffToken(13, 3), "000000000001100");
        vLCBuilder.set(coeffToken(14, 0), "0000000000001011");
        vLCBuilder.set(coeffToken(14, 1), "0000000000001110");
        vLCBuilder.set(coeffToken(14, 2), "0000000000001101");
        vLCBuilder.set(coeffToken(14, 3), "000000000001000");
        vLCBuilder.set(coeffToken(15, 0), "0000000000000111");
        vLCBuilder.set(coeffToken(15, 1), "0000000000001010");
        vLCBuilder.set(coeffToken(15, 2), "0000000000001001");
        vLCBuilder.set(coeffToken(15, 3), "0000000000001100");
        vLCBuilder.set(coeffToken(16, 0), "0000000000000100");
        vLCBuilder.set(coeffToken(16, 1), "0000000000000110");
        vLCBuilder.set(coeffToken(16, 2), "0000000000000101");
        vLCBuilder.set(coeffToken(16, 3), "0000000000001000");
        VLC vlc = vLCBuilder.getVLC();
        vlcArr[1] = vlc;
        vlcArr[0] = vlc;
        VLCBuilder vLCBuilder2 = new VLCBuilder();
        vLCBuilder2.set(coeffToken(0, 0), "11");
        vLCBuilder2.set(coeffToken(1, 0), "001011");
        vLCBuilder2.set(coeffToken(1, 1), "10");
        vLCBuilder2.set(coeffToken(2, 0), "000111");
        vLCBuilder2.set(coeffToken(2, 1), "00111");
        vLCBuilder2.set(coeffToken(2, 2), "011");
        vLCBuilder2.set(coeffToken(3, 0), "0000111");
        vLCBuilder2.set(coeffToken(3, 1), "001010");
        vLCBuilder2.set(coeffToken(3, 2), "001001");
        vLCBuilder2.set(coeffToken(3, 3), "0101");
        vLCBuilder2.set(coeffToken(4, 0), "00000111");
        vLCBuilder2.set(coeffToken(4, 1), "000110");
        vLCBuilder2.set(coeffToken(4, 2), "000101");
        vLCBuilder2.set(coeffToken(4, 3), "0100");
        vLCBuilder2.set(coeffToken(5, 0), "00000100");
        vLCBuilder2.set(coeffToken(5, 1), "0000110");
        vLCBuilder2.set(coeffToken(5, 2), "0000101");
        vLCBuilder2.set(coeffToken(5, 3), "00110");
        vLCBuilder2.set(coeffToken(6, 0), "000000111");
        vLCBuilder2.set(coeffToken(6, 1), "00000110");
        vLCBuilder2.set(coeffToken(6, 2), "00000101");
        vLCBuilder2.set(coeffToken(6, 3), "001000");
        vLCBuilder2.set(coeffToken(7, 0), "00000001111");
        vLCBuilder2.set(coeffToken(7, 1), "000000110");
        vLCBuilder2.set(coeffToken(7, 2), "000000101");
        vLCBuilder2.set(coeffToken(7, 3), "000100");
        vLCBuilder2.set(coeffToken(8, 0), "00000001011");
        vLCBuilder2.set(coeffToken(8, 1), "00000001110");
        vLCBuilder2.set(coeffToken(8, 2), "00000001101");
        vLCBuilder2.set(coeffToken(8, 3), "0000100");
        vLCBuilder2.set(coeffToken(9, 0), "000000001111");
        vLCBuilder2.set(coeffToken(9, 1), "00000001010");
        vLCBuilder2.set(coeffToken(9, 2), "00000001001");
        vLCBuilder2.set(coeffToken(9, 3), "000000100");
        vLCBuilder2.set(coeffToken(10, 0), "000000001011");
        vLCBuilder2.set(coeffToken(10, 1), "000000001110");
        vLCBuilder2.set(coeffToken(10, 2), "000000001101");
        vLCBuilder2.set(coeffToken(10, 3), "00000001100");
        vLCBuilder2.set(coeffToken(11, 0), "000000001000");
        vLCBuilder2.set(coeffToken(11, 1), "000000001010");
        vLCBuilder2.set(coeffToken(11, 2), "000000001001");
        vLCBuilder2.set(coeffToken(11, 3), "00000001000");
        vLCBuilder2.set(coeffToken(12, 0), "0000000001111");
        vLCBuilder2.set(coeffToken(12, 1), "0000000001110");
        vLCBuilder2.set(coeffToken(12, 2), "0000000001101");
        vLCBuilder2.set(coeffToken(12, 3), "000000001100");
        vLCBuilder2.set(coeffToken(13, 0), "0000000001011");
        vLCBuilder2.set(coeffToken(13, 1), "0000000001010");
        vLCBuilder2.set(coeffToken(13, 2), "0000000001001");
        vLCBuilder2.set(coeffToken(13, 3), "0000000001100");
        vLCBuilder2.set(coeffToken(14, 0), "0000000000111");
        vLCBuilder2.set(coeffToken(14, 1), "00000000001011");
        vLCBuilder2.set(coeffToken(14, 2), "0000000000110");
        vLCBuilder2.set(coeffToken(14, 3), "0000000001000");
        vLCBuilder2.set(coeffToken(15, 0), "00000000001001");
        vLCBuilder2.set(coeffToken(15, 1), "00000000001000");
        vLCBuilder2.set(coeffToken(15, 2), "00000000001010");
        vLCBuilder2.set(coeffToken(15, 3), "0000000000001");
        vLCBuilder2.set(coeffToken(16, 0), "00000000000111");
        vLCBuilder2.set(coeffToken(16, 1), "00000000000110");
        vLCBuilder2.set(coeffToken(16, 2), "00000000000101");
        vLCBuilder2.set(coeffToken(16, 3), "00000000000100");
        VLC vlc2 = vLCBuilder2.getVLC();
        vlcArr[3] = vlc2;
        vlcArr[2] = vlc2;
        VLCBuilder vLCBuilder3 = new VLCBuilder();
        vLCBuilder3.set(coeffToken(0, 0), "1111");
        vLCBuilder3.set(coeffToken(1, 0), "001111");
        vLCBuilder3.set(coeffToken(1, 1), "1110");
        vLCBuilder3.set(coeffToken(2, 0), "001011");
        vLCBuilder3.set(coeffToken(2, 1), "01111");
        vLCBuilder3.set(coeffToken(2, 2), "1101");
        vLCBuilder3.set(coeffToken(3, 0), "001000");
        vLCBuilder3.set(coeffToken(3, 1), "01100");
        vLCBuilder3.set(coeffToken(3, 2), "01110");
        vLCBuilder3.set(coeffToken(3, 3), "1100");
        vLCBuilder3.set(coeffToken(4, 0), "0001111");
        vLCBuilder3.set(coeffToken(4, 1), "01010");
        vLCBuilder3.set(coeffToken(4, 2), "01011");
        vLCBuilder3.set(coeffToken(4, 3), "1011");
        vLCBuilder3.set(coeffToken(5, 0), "0001011");
        vLCBuilder3.set(coeffToken(5, 1), "01000");
        vLCBuilder3.set(coeffToken(5, 2), "01001");
        vLCBuilder3.set(coeffToken(5, 3), "1010");
        vLCBuilder3.set(coeffToken(6, 0), "0001001");
        vLCBuilder3.set(coeffToken(6, 1), "001110");
        vLCBuilder3.set(coeffToken(6, 2), "001101");
        vLCBuilder3.set(coeffToken(6, 3), "1001");
        vLCBuilder3.set(coeffToken(7, 0), "0001000");
        vLCBuilder3.set(coeffToken(7, 1), "001010");
        vLCBuilder3.set(coeffToken(7, 2), "001001");
        vLCBuilder3.set(coeffToken(7, 3), "1000");
        vLCBuilder3.set(coeffToken(8, 0), "00001111");
        vLCBuilder3.set(coeffToken(8, 1), "0001110");
        vLCBuilder3.set(coeffToken(8, 2), "0001101");
        vLCBuilder3.set(coeffToken(8, 3), "01101");
        vLCBuilder3.set(coeffToken(9, 0), "00001011");
        vLCBuilder3.set(coeffToken(9, 1), "00001110");
        vLCBuilder3.set(coeffToken(9, 2), "0001010");
        vLCBuilder3.set(coeffToken(9, 3), "001100");
        vLCBuilder3.set(coeffToken(10, 0), "000001111");
        vLCBuilder3.set(coeffToken(10, 1), "00001010");
        vLCBuilder3.set(coeffToken(10, 2), "00001101");
        vLCBuilder3.set(coeffToken(10, 3), "0001100");
        vLCBuilder3.set(coeffToken(11, 0), "000001011");
        vLCBuilder3.set(coeffToken(11, 1), "000001110");
        vLCBuilder3.set(coeffToken(11, 2), "00001001");
        vLCBuilder3.set(coeffToken(11, 3), "00001100");
        vLCBuilder3.set(coeffToken(12, 0), "000001000");
        vLCBuilder3.set(coeffToken(12, 1), "000001010");
        vLCBuilder3.set(coeffToken(12, 2), "000001101");
        vLCBuilder3.set(coeffToken(12, 3), "00001000");
        vLCBuilder3.set(coeffToken(13, 0), "0000001101");
        vLCBuilder3.set(coeffToken(13, 1), "000000111");
        vLCBuilder3.set(coeffToken(13, 2), "000001001");
        vLCBuilder3.set(coeffToken(13, 3), "000001100");
        vLCBuilder3.set(coeffToken(14, 0), "0000001001");
        vLCBuilder3.set(coeffToken(14, 1), "0000001100");
        vLCBuilder3.set(coeffToken(14, 2), "0000001011");
        vLCBuilder3.set(coeffToken(14, 3), "0000001010");
        vLCBuilder3.set(coeffToken(15, 0), "0000000101");
        vLCBuilder3.set(coeffToken(15, 1), "0000001000");
        vLCBuilder3.set(coeffToken(15, 2), "0000000111");
        vLCBuilder3.set(coeffToken(15, 3), "0000000110");
        vLCBuilder3.set(coeffToken(16, 0), "0000000001");
        vLCBuilder3.set(coeffToken(16, 1), "0000000100");
        vLCBuilder3.set(coeffToken(16, 2), "0000000011");
        vLCBuilder3.set(coeffToken(16, 3), "0000000010");
        VLC vlc3 = vLCBuilder3.getVLC();
        vlcArr[7] = vlc3;
        vlcArr[6] = vlc3;
        vlcArr[5] = vlc3;
        vlcArr[4] = vlc3;
        VLCBuilder vLCBuilder4 = new VLCBuilder();
        vLCBuilder4.set(coeffToken(0, 0), "000011");
        vLCBuilder4.set(coeffToken(1, 0), "000000");
        vLCBuilder4.set(coeffToken(1, 1), "000001");
        vLCBuilder4.set(coeffToken(2, 0), "000100");
        vLCBuilder4.set(coeffToken(2, 1), "000101");
        vLCBuilder4.set(coeffToken(2, 2), "000110");
        vLCBuilder4.set(coeffToken(3, 0), "001000");
        vLCBuilder4.set(coeffToken(3, 1), "001001");
        vLCBuilder4.set(coeffToken(3, 2), "001010");
        vLCBuilder4.set(coeffToken(3, 3), "001011");
        vLCBuilder4.set(coeffToken(4, 0), "001100");
        vLCBuilder4.set(coeffToken(4, 1), "001101");
        vLCBuilder4.set(coeffToken(4, 2), "001110");
        vLCBuilder4.set(coeffToken(4, 3), "001111");
        vLCBuilder4.set(coeffToken(5, 0), "010000");
        vLCBuilder4.set(coeffToken(5, 1), "010001");
        vLCBuilder4.set(coeffToken(5, 2), "010010");
        vLCBuilder4.set(coeffToken(5, 3), "010011");
        vLCBuilder4.set(coeffToken(6, 0), "010100");
        vLCBuilder4.set(coeffToken(6, 1), "010101");
        vLCBuilder4.set(coeffToken(6, 2), "010110");
        vLCBuilder4.set(coeffToken(6, 3), "010111");
        vLCBuilder4.set(coeffToken(7, 0), "011000");
        vLCBuilder4.set(coeffToken(7, 1), "011001");
        vLCBuilder4.set(coeffToken(7, 2), "011010");
        vLCBuilder4.set(coeffToken(7, 3), "011011");
        vLCBuilder4.set(coeffToken(8, 0), "011100");
        vLCBuilder4.set(coeffToken(8, 1), "011101");
        vLCBuilder4.set(coeffToken(8, 2), "011110");
        vLCBuilder4.set(coeffToken(8, 3), "011111");
        vLCBuilder4.set(coeffToken(9, 0), "100000");
        vLCBuilder4.set(coeffToken(9, 1), "100001");
        vLCBuilder4.set(coeffToken(9, 2), "100010");
        vLCBuilder4.set(coeffToken(9, 3), "100011");
        vLCBuilder4.set(coeffToken(10, 0), "100100");
        vLCBuilder4.set(coeffToken(10, 1), "100101");
        vLCBuilder4.set(coeffToken(10, 2), "100110");
        vLCBuilder4.set(coeffToken(10, 3), "100111");
        vLCBuilder4.set(coeffToken(11, 0), "101000");
        vLCBuilder4.set(coeffToken(11, 1), "101001");
        vLCBuilder4.set(coeffToken(11, 2), "101010");
        vLCBuilder4.set(coeffToken(11, 3), "101011");
        vLCBuilder4.set(coeffToken(12, 0), "101100");
        vLCBuilder4.set(coeffToken(12, 1), "101101");
        vLCBuilder4.set(coeffToken(12, 2), "101110");
        vLCBuilder4.set(coeffToken(12, 3), "101111");
        vLCBuilder4.set(coeffToken(13, 0), "110000");
        vLCBuilder4.set(coeffToken(13, 1), "110001");
        vLCBuilder4.set(coeffToken(13, 2), "110010");
        vLCBuilder4.set(coeffToken(13, 3), "110011");
        vLCBuilder4.set(coeffToken(14, 0), "110100");
        vLCBuilder4.set(coeffToken(14, 1), "110101");
        vLCBuilder4.set(coeffToken(14, 2), "110110");
        vLCBuilder4.set(coeffToken(14, 3), "110111");
        vLCBuilder4.set(coeffToken(15, 0), "111000");
        vLCBuilder4.set(coeffToken(15, 1), "111001");
        vLCBuilder4.set(coeffToken(15, 2), "111010");
        vLCBuilder4.set(coeffToken(15, 3), "111011");
        vLCBuilder4.set(coeffToken(16, 0), "111100");
        vLCBuilder4.set(coeffToken(16, 1), "111101");
        vLCBuilder4.set(coeffToken(16, 2), "111110");
        vLCBuilder4.set(coeffToken(16, 3), "111111");
        vlcArr[8] = vLCBuilder4.getVLC();
        VLCBuilder vLCBuilder5 = new VLCBuilder();
        vLCBuilder5.set(coeffToken(0, 0), "01");
        vLCBuilder5.set(coeffToken(1, 0), "000111");
        vLCBuilder5.set(coeffToken(1, 1), "1");
        vLCBuilder5.set(coeffToken(2, 0), "000100");
        vLCBuilder5.set(coeffToken(2, 1), "000110");
        vLCBuilder5.set(coeffToken(2, 2), PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY);
        vLCBuilder5.set(coeffToken(3, 0), "000011");
        vLCBuilder5.set(coeffToken(3, 1), "0000011");
        vLCBuilder5.set(coeffToken(3, 2), "0000010");
        vLCBuilder5.set(coeffToken(3, 3), "000101");
        vLCBuilder5.set(coeffToken(4, 0), "000010");
        vLCBuilder5.set(coeffToken(4, 1), "00000011");
        vLCBuilder5.set(coeffToken(4, 2), "00000010");
        vLCBuilder5.set(coeffToken(4, 3), "0000000");
        coeffTokenChromaDCY420 = vLCBuilder5.getVLC();
        VLCBuilder vLCBuilder6 = new VLCBuilder();
        vLCBuilder6.set(coeffToken(0, 0), "1");
        vLCBuilder6.set(coeffToken(1, 0), "0001111");
        vLCBuilder6.set(coeffToken(1, 1), "01");
        vLCBuilder6.set(coeffToken(2, 0), "0001110");
        vLCBuilder6.set(coeffToken(2, 1), "0001101");
        vLCBuilder6.set(coeffToken(2, 2), PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY);
        vLCBuilder6.set(coeffToken(3, 0), "000000111");
        vLCBuilder6.set(coeffToken(3, 1), "0001100");
        vLCBuilder6.set(coeffToken(3, 2), "0001011");
        vLCBuilder6.set(coeffToken(3, 3), "00001");
        vLCBuilder6.set(coeffToken(4, 0), "000000110");
        vLCBuilder6.set(coeffToken(4, 1), "000000101");
        vLCBuilder6.set(coeffToken(4, 2), "0001010");
        vLCBuilder6.set(coeffToken(4, 3), "000001");
        vLCBuilder6.set(coeffToken(5, 0), "0000000111");
        vLCBuilder6.set(coeffToken(5, 1), "0000000110");
        vLCBuilder6.set(coeffToken(5, 2), "000000100");
        vLCBuilder6.set(coeffToken(5, 3), "0001001");
        vLCBuilder6.set(coeffToken(6, 0), "00000000111");
        vLCBuilder6.set(coeffToken(6, 1), "00000000110");
        vLCBuilder6.set(coeffToken(6, 2), "0000000101");
        vLCBuilder6.set(coeffToken(6, 3), "0001000");
        vLCBuilder6.set(coeffToken(7, 0), "000000000111");
        vLCBuilder6.set(coeffToken(7, 1), "000000000110");
        vLCBuilder6.set(coeffToken(7, 2), "00000000101");
        vLCBuilder6.set(coeffToken(7, 3), "0000000100");
        vLCBuilder6.set(coeffToken(8, 0), "0000000000111");
        vLCBuilder6.set(coeffToken(8, 1), "000000000101");
        vLCBuilder6.set(coeffToken(8, 2), "000000000100");
        vLCBuilder6.set(coeffToken(8, 3), "00000000100");
        coeffTokenChromaDCY422 = vLCBuilder6.getVLC();
        run = new VLC[]{new VLCBuilder().set(0, "1").set(1, "0").getVLC(), new VLCBuilder().set(0, "1").set(1, "01").set(2, "00").getVLC(), new VLCBuilder().set(0, "11").set(1, "10").set(2, "01").set(3, "00").getVLC(), new VLCBuilder().set(0, "11").set(1, "10").set(2, "01").set(3, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(4, "000").getVLC(), new VLCBuilder().set(0, "11").set(1, "10").set(2, "011").set(3, "010").set(4, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(5, "000").getVLC(), new VLCBuilder().set(0, "11").set(1, "000").set(2, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(3, "011").set(4, "010").set(5, "101").set(6, "100").getVLC(), new VLCBuilder().set(0, "111").set(1, "110").set(2, "101").set(3, "100").set(4, "011").set(5, "010").set(6, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(7, "0001").set(8, "00001").set(9, "000001").set(10, "0000001").set(11, "00000001").set(12, "000000001").set(13, "0000000001").set(14, "00000000001").getVLC()};
        totalZeros16 = new VLC[]{new VLCBuilder().set(0, "1").set(1, "011").set(2, "010").set(3, "0011").set(4, "0010").set(5, "00011").set(6, "00010").set(7, "000011").set(8, "000010").set(9, "0000011").set(10, "0000010").set(11, "00000011").set(12, "00000010").set(13, "000000011").set(14, "000000010").set(15, "000000001").getVLC(), new VLCBuilder().set(0, "111").set(1, "110").set(2, "101").set(3, "100").set(4, "011").set(5, "0101").set(6, "0100").set(7, "0011").set(8, "0010").set(9, "00011").set(10, "00010").set(11, "000011").set(12, "000010").set(13, "000001").set(14, "000000").getVLC(), new VLCBuilder().set(0, "0101").set(1, "111").set(2, "110").set(3, "101").set(4, "0100").set(5, "0011").set(6, "100").set(7, "011").set(8, "0010").set(9, "00011").set(10, "00010").set(11, "000001").set(12, "00001").set(13, "000000").getVLC(), new VLCBuilder().set(0, "00011").set(1, "111").set(2, "0101").set(3, "0100").set(4, "110").set(5, "101").set(6, "100").set(7, "0011").set(8, "011").set(9, "0010").set(10, "00010").set(11, "00001").set(12, "00000").getVLC(), new VLCBuilder().set(0, "0101").set(1, "0100").set(2, "0011").set(3, "111").set(4, "110").set(5, "101").set(6, "100").set(7, "011").set(8, "0010").set(9, "00001").set(10, "0001").set(11, "00000").getVLC(), new VLCBuilder().set(0, "000001").set(1, "00001").set(2, "111").set(3, "110").set(4, "101").set(5, "100").set(6, "011").set(7, "010").set(8, "0001").set(9, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(10, "000000").getVLC(), new VLCBuilder().set(0, "000001").set(1, "00001").set(2, "101").set(3, "100").set(4, "011").set(5, "11").set(6, "010").set(7, "0001").set(8, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(9, "000000").getVLC(), new VLCBuilder().set(0, "000001").set(1, "0001").set(2, "00001").set(3, "011").set(4, "11").set(5, "10").set(6, "010").set(7, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(8, "000000").getVLC(), new VLCBuilder().set(0, "000001").set(1, "000000").set(2, "0001").set(3, "11").set(4, "10").set(5, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(6, "01").set(7, "00001").getVLC(), new VLCBuilder().set(0, "00001").set(1, "00000").set(2, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(3, "11").set(4, "10").set(5, "01").set(6, "0001").getVLC(), new VLCBuilder().set(0, "0000").set(1, "0001").set(2, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(3, "010").set(4, "1").set(5, "011").getVLC(), new VLCBuilder().set(0, "0000").set(1, "0001").set(2, "01").set(3, "1").set(4, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).getVLC(), new VLCBuilder().set(0, "000").set(1, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(2, "1").set(3, "01").getVLC(), new VLCBuilder().set(0, "00").set(1, "01").set(2, "1").getVLC(), new VLCBuilder().set(0, "0").set(1, "1").getVLC()};
        totalZeros4 = new VLC[]{new VLCBuilder().set(0, "1").set(1, "01").set(2, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(3, "000").getVLC(), new VLCBuilder().set(0, "1").set(1, "01").set(2, "00").getVLC(), new VLCBuilder().set(0, "1").set(1, "0").getVLC()};
        totalZeros8 = new VLC[]{new VLCBuilder().set(0, "1").set(1, "010").set(2, "011").set(3, "0010").set(4, "0011").set(5, "0001").set(6, "00001").set(7, "00000").getVLC(), new VLCBuilder().set(0, "000").set(1, "01").set(2, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(3, "100").set(4, "101").set(5, "110").set(6, "111").getVLC(), new VLCBuilder().set(0, "000").set(1, PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY).set(2, "01").set(3, "10").set(4, "110").set(5, "111").getVLC(), new VLCBuilder().set(0, "110").set(1, "00").set(2, "01").set(3, "10").set(4, "111").getVLC(), new VLCBuilder().set(0, "00").set(1, "01").set(2, "10").set(3, "11").getVLC(), new VLCBuilder().set(0, "00").set(1, "01").set(2, "1").getVLC(), new VLCBuilder().set(0, "0").set(1, "1").getVLC()};
        PartPred partPred = PartPred.L0;
        PartPred partPred2 = PartPred.L1;
        PartPred partPred3 = PartPred.Bi;
        bPredModes = new PartPred[][]{null, new PartPred[]{partPred}, new PartPred[]{partPred2}, new PartPred[]{partPred3}, new PartPred[]{partPred, partPred}, new PartPred[]{partPred, partPred}, new PartPred[]{partPred2, partPred2}, new PartPred[]{partPred2, partPred2}, new PartPred[]{partPred, partPred2}, new PartPred[]{partPred, partPred2}, new PartPred[]{partPred2, partPred}, new PartPred[]{partPred2, partPred}, new PartPred[]{partPred, partPred3}, new PartPred[]{partPred, partPred3}, new PartPred[]{partPred2, partPred3}, new PartPred[]{partPred2, partPred3}, new PartPred[]{partPred3, partPred}, new PartPred[]{partPred3, partPred}, new PartPred[]{partPred3, partPred2}, new PartPred[]{partPred3, partPred2}, new PartPred[]{partPred3, partPred3}, new PartPred[]{partPred3, partPred3}};
        bMbTypes = new MBType[]{MBType.B_Direct_16x16, MBType.B_L0_16x16, MBType.B_L1_16x16, MBType.B_Bi_16x16, MBType.B_L0_L0_16x8, MBType.B_L0_L0_8x16, MBType.B_L1_L1_16x8, MBType.B_L1_L1_8x16, MBType.B_L0_L1_16x8, MBType.B_L0_L1_8x16, MBType.B_L1_L0_16x8, MBType.B_L1_L0_8x16, MBType.B_L0_Bi_16x8, MBType.B_L0_Bi_8x16, MBType.B_L1_Bi_16x8, MBType.B_L1_Bi_8x16, MBType.B_Bi_L0_16x8, MBType.B_Bi_L0_8x16, MBType.B_Bi_L1_16x8, MBType.B_Bi_L1_8x16, MBType.B_Bi_Bi_16x8, MBType.B_Bi_Bi_8x16, MBType.B_8x8};
        bPartW = new int[]{0, 16, 16, 16, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8};
        bPartH = new int[]{0, 16, 16, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16, 8, 16};
        BLK_X = new int[]{0, 4, 0, 4, 8, 12, 8, 12, 0, 4, 0, 4, 8, 12, 8, 12};
        BLK_Y = new int[]{0, 0, 4, 4, 0, 0, 4, 4, 8, 8, 12, 12, 8, 8, 12, 12};
        BLK_8x8_X = new int[]{0, 8, 0, 8};
        BLK_8x8_Y = new int[]{0, 0, 8, 8};
        BLK_INV_MAP = new int[]{0, 1, 4, 5, 2, 3, 6, 7, 8, 9, 12, 13, 10, 11, 14, 15};
        MB_BLK_OFF_LEFT = new int[]{0, 1, 0, 1, 2, 3, 2, 3, 0, 1, 0, 1, 2, 3, 2, 3};
        MB_BLK_OFF_TOP = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 3, 3};
        QP_SCALE_CR = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 29, 30, 31, 32, 32, 33, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 38, 39, 39, 39, 39};
        NO_PIC = Picture.createPicture(0, 0, null, null);
        BLK_8x8_MB_OFF_LUMA = new int[]{0, 8, 128, 136};
        BLK_8x8_MB_OFF_CHROMA = new int[]{0, 4, 32, 36};
        BLK_4x4_MB_OFF_LUMA = new int[]{0, 4, 8, 12, 64, 68, 72, 76, 128, 132, 136, 140, 192, JpegConst.DHT, 200, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS};
        BLK_8x8_IND = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 2, 2, 3, 3, 2, 2, 3, 3};
        BLK8x8_BLOCKS = new int[][]{new int[]{0, 1, 4, 5}, new int[]{2, 3, 6, 7}, new int[]{8, 9, 12, 13}, new int[]{10, 11, 14, 15}};
        ARRAY = new int[][]{new int[]{0}, new int[]{1}, new int[]{2}, new int[]{3}};
        CODED_BLOCK_PATTERN_INTRA_COLOR = new int[]{47, 31, 15, 0, 23, 27, 29, 30, 7, 11, 13, 14, 39, 43, 45, 46, 16, 3, 5, 10, 12, 19, 21, 26, 28, 35, 37, 42, 44, 1, 2, 4, 8, 17, 18, 20, 24, 6, 9, 22, 25, 32, 33, 34, 36, 40, 38, 41};
        coded_block_pattern_intra_monochrome = new int[]{15, 0, 7, 11, 13, 14, 3, 5, 10, 12, 1, 2, 4, 8, 6, 9};
        int[] iArr = {0, 16, 1, 2, 4, 8, 32, 3, 5, 10, 12, 15, 47, 7, 11, 13, 14, 6, 9, 31, 35, 37, 42, 44, 33, 34, 36, 40, 39, 43, 45, 46, 17, 18, 20, 24, 19, 21, 26, 28, 23, 27, 29, 30, 22, 25, 38, 41};
        CODED_BLOCK_PATTERN_INTER_COLOR = iArr;
        CODED_BLOCK_PATTERN_INTER_COLOR_INV = inverse(iArr);
        coded_block_pattern_inter_monochrome = new int[]{0, 1, 2, 4, 8, 3, 5, 10, 12, 15, 7, 11, 13, 14, 6, 9};
        sig_coeff_map_8x8 = new int[]{0, 1, 2, 3, 4, 5, 5, 4, 4, 3, 3, 4, 4, 4, 5, 5, 4, 4, 4, 4, 3, 3, 6, 7, 7, 7, 8, 9, 10, 9, 8, 7, 7, 6, 11, 12, 13, 11, 6, 7, 8, 9, 14, 10, 9, 8, 6, 11, 12, 13, 11, 6, 9, 14, 10, 9, 11, 12, 13, 11, 14, 10, 12};
        sig_coeff_map_8x8_mbaff = new int[]{0, 1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7, 8, 4, 5, 6, 9, 10, 10, 8, 11, 12, 11, 9, 9, 10, 10, 8, 11, 12, 11, 9, 9, 10, 10, 8, 11, 12, 11, 9, 9, 10, 10, 8, 13, 13, 9, 9, 10, 10, 8, 13, 13, 9, 9, 10, 10, 14, 14, 14, 14, 14};
        last_sig_coeff_map_8x8 = new int[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8};
        identityMapping16 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        identityMapping4 = new int[]{0, 1, 2, 3};
        bPartPredModes = new PartPred[]{PartPred.Direct, partPred, partPred2, partPred3, partPred, partPred, partPred2, partPred2, partPred3, partPred3, partPred, partPred2, partPred3};
        bSubMbTypes = new int[]{0, 0, 0, 0, 1, 2, 1, 2, 1, 2, 3, 3, 3};
        int[] iArr2 = new int[256];
        LUMA_4x4_BLOCK_LUT = iArr2;
        int[] iArr3 = new int[256];
        LUMA_4x4_POS_LUT = iArr3;
        int[] iArr4 = new int[256];
        LUMA_8x8_BLOCK_LUT = iArr4;
        int[] iArr5 = new int[256];
        LUMA_8x8_POS_LUT = iArr5;
        int[] iArr6 = new int[64];
        CHROMA_BLOCK_LUT = iArr6;
        int[] iArr7 = new int[64];
        CHROMA_POS_LUT = iArr7;
        COMP_BLOCK_4x4_LUT = new int[][]{iArr2, iArr6, iArr6};
        COMP_POS_4x4_LUT = new int[][]{iArr3, iArr7, iArr7};
        COMP_BLOCK_8x8_LUT = new int[][]{iArr4, iArr6, iArr6};
        COMP_POS_8x8_LUT = new int[][]{iArr5, iArr7, iArr7};
        int i = 16;
        int[] iArr8 = new int[16];
        int i2 = 0;
        while (i2 < i) {
            int i3 = 0;
            while (i3 < i) {
                iArr8[i3] = i3;
                i3++;
                i = 16;
            }
            int[] iArr9 = BLK_X;
            int i4 = iArr9[i2];
            int[] iArr10 = BLK_Y;
            putBlk(iArr8, i4, iArr10[i2], 4, 4, 16, LUMA_4x4_POS_LUT);
            Arrays.fill(iArr8, i2);
            putBlk(iArr8, iArr9[i2], iArr10[i2], 4, 4, 16, LUMA_4x4_BLOCK_LUT);
            i2++;
            i = 16;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            for (int i6 = 0; i6 < 16; i6++) {
                iArr8[i6] = i6;
            }
            int[] iArr11 = BLK_X;
            int i7 = iArr11[i5];
            int[] iArr12 = BLK_Y;
            putBlk(iArr8, i7, iArr12[i5], 4, 4, 8, CHROMA_POS_LUT);
            Arrays.fill(iArr8, i5);
            putBlk(iArr8, iArr11[i5], iArr12[i5], 4, 4, 8, CHROMA_BLOCK_LUT);
        }
        int[] iArr13 = new int[64];
        for (int i8 = 0; i8 < 4; i8++) {
            for (int i9 = 0; i9 < 64; i9++) {
                iArr13[i9] = i9;
            }
            int[] iArr14 = BLK_8x8_X;
            int i10 = iArr14[i8];
            int[] iArr15 = BLK_8x8_Y;
            putBlk(iArr13, i10, iArr15[i8], 8, 8, 16, LUMA_8x8_POS_LUT);
            Arrays.fill(iArr13, i8);
            putBlk(iArr13, iArr14[i8], iArr15[i8], 8, 8, 16, LUMA_8x8_BLOCK_LUT);
        }
        PIX_MAP_SPLIT_4x4 = buildPixSplitMap4x4();
        PIX_MAP_SPLIT_2x2 = buildPixSplitMap2x2();
        defaultScalingList4x4Intra = new int[]{6, 13, 13, 20, 20, 20, 28, 28, 28, 28, 32, 32, 32, 37, 37, 42};
        defaultScalingList4x4Inter = new int[]{10, 14, 14, 20, 20, 20, 24, 24, 24, 24, 27, 27, 27, 30, 30, 34};
        defaultScalingList8x8Intra = new int[]{6, 10, 10, 13, 11, 13, 16, 16, 16, 16, 18, 18, 18, 18, 18, 23, 23, 23, 23, 23, 23, 25, 25, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 27, 27, 27, 29, 29, 29, 29, 29, 29, 29, 31, 31, 31, 31, 31, 31, 33, 33, 33, 33, 33, 36, 36, 36, 36, 38, 38, 38, 40, 40, 42};
        defaultScalingList8x8Inter = new int[]{9, 13, 13, 15, 13, 15, 17, 17, 17, 17, 19, 19, 19, 19, 19, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25, 25, 25, 25, 25, 27, 27, 27, 27, 27, 27, 28, 28, 28, 28, 28, 30, 30, 30, 30, 32, 32, 32, 33, 33, 35};
    }

    private static int[][] buildPixSplitMap2x2() {
        int[][] iArr = {new int[]{0, 1, 2, 3, 8, 9, 10, 11, 16, 17, 18, 19, 24, 25, 26, 27}, new int[16], new int[16], new int[16]};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 2; i3++) {
            int i4 = 0;
            while (i4 < 2) {
                for (int i5 = 0; i5 < 16; i5++) {
                    iArr[i2][i5] = iArr[0][i5] + i;
                }
                i4++;
                i2++;
                i += 4;
            }
            i += 24;
        }
        return iArr;
    }

    private static int[][] buildPixSplitMap4x4() {
        int[][] iArr = {new int[]{0, 1, 2, 3, 16, 17, 18, 19, 32, 33, 34, 35, 48, 49, 50, 51}, new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16], new int[16]};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = 0;
            while (i4 < 4) {
                for (int i5 = 0; i5 < 16; i5++) {
                    iArr[i2][i5] = iArr[0][i5] + i;
                }
                i4++;
                i2++;
                i += 4;
            }
            i += 48;
        }
        return iArr;
    }

    public static final int coeffToken(int i, int i2) {
        return (i << 4) | i2;
    }

    private static int[] inverse(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[iArr[i]] = i;
        }
        return iArr2;
    }

    private static void putBlk(int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2) {
        int i6 = (i2 * i5) + i;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < i3; i9++) {
                iArr2[i6 + i9] = iArr[i7 + i9];
            }
            i7 += i3;
            i6 += i5;
        }
    }

    public static boolean usesList(PartPred partPred, int i) {
        if (partPred == PartPred.Bi) {
            return true;
        }
        if (partPred == PartPred.L0 && i == 0) {
            return true;
        }
        return partPred == PartPred.L1 && i == 1;
    }
}
