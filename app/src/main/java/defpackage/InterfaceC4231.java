package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.google.mlkit.common.MlKitException;
import com.google.zxing.oned.Code39Reader;
import com.google.zxing.pdf417.PDF417Common;
import net.sourceforge.jaad.aac.syntax.SyntaxConstants;
import org.jcodec.codecs.h264.H264Const;
import org.jcodec.codecs.mjpeg.JpegConst;
import org.jcodec.codecs.mpeg12.MPEGConst;
import org.jcodec.codecs.vpx.vp9.Consts;
import org.jcodec.containers.mps.MPSUtils;

/* compiled from: ScaleFactorBands.java */
/* renamed from: ਈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public interface InterfaceC4231 {

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final int[] f14541 = {41, 41, 47, 49, 49, 51, 47, 47, 43, 43, 43, 40};

    /* renamed from: ކ, reason: contains not printable characters */
    public static final int[] f14542;

    /* renamed from: އ, reason: contains not printable characters */
    public static final int[] f14543;

    /* renamed from: ވ, reason: contains not printable characters */
    public static final int[] f14544;

    /* renamed from: މ, reason: contains not printable characters */
    public static final int[] f14545;

    /* renamed from: ފ, reason: contains not printable characters */
    public static final int[] f14546;

    /* renamed from: ދ, reason: contains not printable characters */
    public static final int[] f14547;

    /* renamed from: ތ, reason: contains not printable characters */
    public static final int[] f14548;

    /* renamed from: ލ, reason: contains not printable characters */
    public static final int[][] f14549;

    /* renamed from: ގ, reason: contains not printable characters */
    public static final int[] f14550;

    /* renamed from: ޏ, reason: contains not printable characters */
    public static final int[] f14551;

    /* renamed from: ސ, reason: contains not printable characters */
    public static final int[] f14552;

    /* renamed from: ޑ, reason: contains not printable characters */
    public static final int[] f14553;

    /* renamed from: ޒ, reason: contains not printable characters */
    public static final int[] f14554;

    /* renamed from: ޓ, reason: contains not printable characters */
    public static final int[] f14555;

    /* renamed from: ޔ, reason: contains not printable characters */
    public static final int[] f14556;

    /* renamed from: ޕ, reason: contains not printable characters */
    public static final int[][] f14557;

    static {
        int[] iArr = {0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56, 64, 72, 80, 88, 96, 108, 120, 132, 144, 156, 172, TsConstants.TS_PACKET_SIZE, JpegConst.RST4, 240, 276, 320, 384, MPSUtils.AUDIO_MIN, 512, 576, 640, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 768, 832, 896, SyntaxConstants.WINDOW_SMALL_LEN_LONG, 1024, -1};
        f14542 = iArr;
        int[] iArr2 = {0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 48, 52, 56, 64, 72, 80, 88, 100, 112, 124, 140, 156, 172, 192, JpegConst.SOI, 240, 268, 304, 344, 384, TypedValues.CycleType.TYPE_WAVE_OFFSET, 464, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, 544, 584, 624, 664, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 744, 784, 824, 864, TypedValues.Custom.TYPE_BOOLEAN, 944, 984, 1024, -1};
        f14543 = iArr2;
        int[] iArr3 = {0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 48, 56, 64, 72, 80, 88, 96, 108, 120, 132, 144, Consts.BORDERINPIXELS, 176, JpegConst.DHT, JpegConst.SOI, 240, 264, 292, 320, 352, 384, TypedValues.CycleType.TYPE_PATH_ROTATE, MPSUtils.AUDIO_MIN, MPSUtils.VIDEO_MIN, 512, 544, 576, TypedValues.MotionType.TYPE_DRAW_PATH, 640, 672, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 736, 768, 800, 832, 864, 896, PDF417Common.MAX_CODEWORDS_IN_BARCODE, 1024, -1};
        f14544 = iArr3;
        int[] iArr4 = {0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 48, 56, 64, 72, 80, 88, 96, 108, 120, 132, 144, Consts.BORDERINPIXELS, 176, JpegConst.DHT, JpegConst.SOI, 240, 264, 292, 320, 352, 384, TypedValues.CycleType.TYPE_PATH_ROTATE, MPSUtils.AUDIO_MIN, MPSUtils.VIDEO_MIN, 512, 544, 576, TypedValues.MotionType.TYPE_DRAW_PATH, 640, 672, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 736, 768, 800, 832, 864, 896, PDF417Common.MAX_CODEWORDS_IN_BARCODE, SyntaxConstants.WINDOW_SMALL_LEN_LONG, 992, 1024, -1};
        f14545 = iArr4;
        int[] iArr5 = {0, 4, 8, 12, 16, 20, 24, 28, 32, 36, 40, 44, 52, 60, 68, 76, 84, 92, 100, 108, 116, 124, 136, Code39Reader.ASTERISK_ENCODING, Consts.BORDERINPIXELS, 172, TsConstants.TS_PACKET_SIZE, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 220, 240, 260, 284, 308, 336, 364, 396, 432, 468, TypedValues.PositionType.TYPE_CURVE_FIT, 552, 600, 652, TypedValues.TransitionType.TYPE_AUTO_TRANSITION, 768, 832, 896, SyntaxConstants.WINDOW_SMALL_LEN_LONG, 1024, -1};
        f14546 = iArr5;
        int[] iArr6 = {0, 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 100, 112, 124, 136, Code39Reader.ASTERISK_ENCODING, Consts.BORDERINPIXELS, 172, MPEGConst.GROUP_START_CODE, JpegConst.DHT, JpegConst.RST4, JpegConst.APP4, H264Const.PROFILE_HIGH_444, 260, 280, 300, 320, 344, 368, 396, TypedValues.CycleType.TYPE_WAVE_OFFSET, 456, 492, 532, 572, 616, 664, 716, 772, 832, 896, SyntaxConstants.WINDOW_SMALL_LEN_LONG, 1024, -1};
        f14547 = iArr6;
        int[] iArr7 = {0, 12, 24, 36, 48, 60, 72, 84, 96, 108, 120, 132, 144, 156, 172, TsConstants.TS_PACKET_SIZE, MlKitException.CODE_SCANNER_TASK_IN_PROGRESS, 220, JpegConst.APPC, 252, 268, 288, 308, 328, 348, 372, 396, TypedValues.CycleType.TYPE_EASING, MPSUtils.AUDIO_MIN, 476, TypedValues.PositionType.TYPE_CURVE_FIT, 544, 580, 620, 664, 712, 764, 820, 880, 944, 1024, -1};
        f14548 = iArr7;
        f14549 = new int[][]{iArr, iArr, iArr2, iArr3, iArr3, iArr4, iArr5, iArr5, iArr6, iArr6, iArr6, iArr7};
        f14550 = new int[]{12, 12, 12, 14, 14, 14, 15, 15, 15, 15, 15, 15};
        int[] iArr8 = {0, 4, 8, 12, 16, 20, 24, 32, 40, 48, 64, 92, 128, -1};
        f14551 = iArr8;
        int[] iArr9 = {0, 4, 8, 12, 16, 20, 24, 32, 40, 48, 64, 92, 128, -1};
        f14552 = iArr9;
        int[] iArr10 = {0, 4, 8, 12, 16, 20, 28, 36, 44, 56, 68, 80, 96, 112, 128, -1};
        f14553 = iArr10;
        int[] iArr11 = {0, 4, 8, 12, 16, 20, 24, 28, 36, 44, 52, 64, 76, 92, 108, 128, -1};
        f14554 = iArr11;
        int[] iArr12 = {0, 4, 8, 12, 16, 20, 24, 28, 32, 40, 48, 60, 72, 88, 108, 128, -1};
        f14555 = iArr12;
        int[] iArr13 = {0, 4, 8, 12, 16, 20, 24, 28, 36, 44, 52, 60, 72, 88, 108, 128, -1};
        f14556 = iArr13;
        f14557 = new int[][]{iArr8, iArr8, iArr9, iArr10, iArr10, iArr10, iArr11, iArr11, iArr12, iArr12, iArr12, iArr13};
    }
}
