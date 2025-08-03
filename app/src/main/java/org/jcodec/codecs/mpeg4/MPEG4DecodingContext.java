package org.jcodec.codecs.mpeg4;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class MPEG4DecodingContext {
    private static final int GRPOFVOP_START_CODE = 435;
    private static final int SPRITE_GMC = 2;
    private static final int SPRITE_STATIC = 1;
    private static final int USERDATA_START_CODE = 434;
    private static final int VIDOBJLAY_AR_EXTPAR = 15;
    private static final int VIDOBJLAY_SHAPE_BINARY = 1;
    private static final int VIDOBJLAY_SHAPE_BINARY_ONLY = 2;
    private static final int VIDOBJLAY_SHAPE_GRAYSCALE = 3;
    private static final int VIDOBJLAY_SHAPE_RECTANGULAR = 0;
    private static final int VIDOBJLAY_START_CODE = 288;
    private static final int VIDOBJLAY_START_CODE_MASK = 15;
    private static final int VIDOBJ_START_CODE = 256;
    private static final int VIDOBJ_START_CODE_MASK = 31;
    private static final int VISOBJSEQ_START_CODE = 432;
    private static final int VISOBJSEQ_STOP_CODE = 433;
    private static final int VISOBJ_START_CODE = 437;
    private static final int VISOBJ_TYPE_VIDEO = 1;
    private static final int VLC_CODE = 0;
    private static final int VLC_LEN = 1;
    private static final int VOP_START_CODE = 438;
    public boolean alternateVerticalScan;
    public int bframeTs;
    public boolean cartoonMode;
    public int codingType;
    public boolean complexityEstimationDisable;
    public int fcodeBackward;
    public int fcodeForward;
    public int height;
    public int horiz_mc_ref;
    public boolean interlacing;
    public int intraDCThreshold;
    public int lastNonBTime;
    public int lastTimeBase;
    public int mbHeight;
    public int mbWidth;
    public boolean newPredEnable;
    private boolean packedMode;
    public int pframeTs;
    public int quant;
    public int quantBits;
    public boolean quantType;
    public boolean quarterPel;
    public boolean reducedResolutionEnable;
    public boolean rounding;
    public boolean scalability;
    public int shape;
    public boolean spriteBrightnessChange;
    public int spriteEnable;
    public int spriteWarpingPoints;
    public int time;
    public int timeBase;
    public int timeIncrementBits;
    private int timeIncrementResolution;
    public int timestampLSB;
    public int timestampMSB;
    public boolean topFieldFirst;
    public int vert_mc_ref;
    public int volVersionId;
    public int width;
    public int bsVersion = 65535;
    public short[] intraMpegQuantMatrix = new short[64];
    public short[] interMpegQuantMatrix = new short[64];
    public int[][] gmcWarps = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 3, 2);
    public Estimation estimation = new Estimation();

    public static class Estimation {
        public boolean apm;
        public boolean dctCoefs;
        public boolean dctLines;
        public boolean forwBackMcQ;
        public boolean halfpel2;
        public boolean halfpel4;
        public boolean inter4vBlocks;
        public boolean interBlocks;
        public boolean interCae;
        public boolean interpolateMcQ;
        public boolean intraBlocks;
        public boolean intraCae;
        public int method;
        public boolean noUpdate;
        public boolean notCodedBlocks;
        public boolean npm;
        public boolean opaque;
        public boolean quarterpel;
        public boolean sadct;
        public boolean transparent;
        public boolean upsampling;
        public boolean vlcBits;
        public boolean vlcSymbols;

        private Estimation() {
        }
    }

    private void calcSizes() {
        this.mbWidth = (this.width + 15) / 16;
        this.mbHeight = (this.height + 15) / 16;
    }

    public static void getMatrix(BitReader bitReader, short[] sArr) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int nBit = bitReader.readNBit(8);
            i = i3 + 1;
            sArr[MPEG4Consts.SCAN_TABLES[0][i3]] = (short) nBit;
            if (nBit == 0 || i >= 64) {
                break;
            }
            i2 = nBit;
            i3 = i;
        }
        for (int i4 = i - 1; i4 < 64; i4++) {
            sArr[MPEG4Consts.SCAN_TABLES[0][i4]] = (short) i2;
        }
    }

    private int getSpriteTrajectory(BitReader bitReader) {
        for (int i = 0; i < 12; i++) {
            int[][] iArr = MPEG4Consts.SPRITE_TRAJECTORY_LEN;
            int iCheckNBit = bitReader.checkNBit(iArr[i][1]);
            int[] iArr2 = iArr[i];
            if (iCheckNBit == iArr2[0]) {
                bitReader.skip(iArr2[1]);
                return i;
            }
        }
        return -1;
    }

    public static MPEG4DecodingContext readFromHeaders(ByteBuffer byteBuffer) {
        MPEG4DecodingContext mPEG4DecodingContext = new MPEG4DecodingContext();
        if (mPEG4DecodingContext.readHeaders(byteBuffer)) {
            return mPEG4DecodingContext;
        }
        return null;
    }

    private void readVolComplexityEstimationHeader(BitReader bitReader, Estimation estimation) {
        int nBit = bitReader.readNBit(2);
        estimation.method = nBit;
        if (nBit == 0 || nBit == 1) {
            if (!bitReader.readBool()) {
                estimation.opaque = bitReader.readBool();
                estimation.transparent = bitReader.readBool();
                estimation.intraCae = bitReader.readBool();
                estimation.interCae = bitReader.readBool();
                estimation.noUpdate = bitReader.readBool();
                estimation.upsampling = bitReader.readBool();
            }
            if (!bitReader.readBool()) {
                estimation.intraBlocks = bitReader.readBool();
                estimation.interBlocks = bitReader.readBool();
                estimation.inter4vBlocks = bitReader.readBool();
                estimation.notCodedBlocks = bitReader.readBool();
            }
        }
        bitReader.skip(1);
        if (!bitReader.readBool()) {
            estimation.dctCoefs = bitReader.readBool();
            estimation.dctLines = bitReader.readBool();
            estimation.vlcSymbols = bitReader.readBool();
            estimation.vlcBits = bitReader.readBool();
        }
        if (!bitReader.readBool()) {
            estimation.apm = bitReader.readBool();
            estimation.npm = bitReader.readBool();
            estimation.interpolateMcQ = bitReader.readBool();
            estimation.forwBackMcQ = bitReader.readBool();
            estimation.halfpel2 = bitReader.readBool();
            estimation.halfpel4 = bitReader.readBool();
        }
        bitReader.skip(1);
        if (estimation.method != 1 || bitReader.readBool()) {
            return;
        }
        estimation.sadct = bitReader.readBool();
        estimation.quarterpel = bitReader.readBool();
    }

    private void readVopComplexityEstimationHeader(BitReader bitReader, Estimation estimation, int i, int i2) {
        int i3 = estimation.method;
        if (i3 == 0 || i3 == 1) {
            if (i2 == 0) {
                if (estimation.opaque) {
                    bitReader.skip(8);
                }
                if (estimation.transparent) {
                    bitReader.skip(8);
                }
                if (estimation.intraCae) {
                    bitReader.skip(8);
                }
                if (estimation.interCae) {
                    bitReader.skip(8);
                }
                if (estimation.noUpdate) {
                    bitReader.skip(8);
                }
                if (estimation.upsampling) {
                    bitReader.skip(8);
                }
                if (estimation.intraBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.notCodedBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.dctCoefs) {
                    bitReader.skip(8);
                }
                if (estimation.dctLines) {
                    bitReader.skip(8);
                }
                if (estimation.vlcSymbols) {
                    bitReader.skip(8);
                }
                if (estimation.vlcBits) {
                    bitReader.skip(8);
                }
                if (estimation.sadct) {
                    bitReader.skip(8);
                }
            }
            if (i2 == 1) {
                if (estimation.opaque) {
                    bitReader.skip(8);
                }
                if (estimation.transparent) {
                    bitReader.skip(8);
                }
                if (estimation.intraCae) {
                    bitReader.skip(8);
                }
                if (estimation.interCae) {
                    bitReader.skip(8);
                }
                if (estimation.noUpdate) {
                    bitReader.skip(8);
                }
                if (estimation.upsampling) {
                    bitReader.skip(8);
                }
                if (estimation.intraBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.notCodedBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.dctCoefs) {
                    bitReader.skip(8);
                }
                if (estimation.dctLines) {
                    bitReader.skip(8);
                }
                if (estimation.vlcSymbols) {
                    bitReader.skip(8);
                }
                if (estimation.vlcBits) {
                    bitReader.skip(8);
                }
                if (estimation.interBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.inter4vBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.apm) {
                    bitReader.skip(8);
                }
                if (estimation.npm) {
                    bitReader.skip(8);
                }
                if (estimation.forwBackMcQ) {
                    bitReader.skip(8);
                }
                if (estimation.halfpel2) {
                    bitReader.skip(8);
                }
                if (estimation.halfpel4) {
                    bitReader.skip(8);
                }
                if (estimation.sadct) {
                    bitReader.skip(8);
                }
                if (estimation.quarterpel) {
                    bitReader.skip(8);
                }
            }
            if (i2 == 2) {
                if (estimation.opaque) {
                    bitReader.skip(8);
                }
                if (estimation.transparent) {
                    bitReader.skip(8);
                }
                if (estimation.intraCae) {
                    bitReader.skip(8);
                }
                if (estimation.interCae) {
                    bitReader.skip(8);
                }
                if (estimation.noUpdate) {
                    bitReader.skip(8);
                }
                if (estimation.upsampling) {
                    bitReader.skip(8);
                }
                if (estimation.intraBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.notCodedBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.dctCoefs) {
                    bitReader.skip(8);
                }
                if (estimation.dctLines) {
                    bitReader.skip(8);
                }
                if (estimation.vlcSymbols) {
                    bitReader.skip(8);
                }
                if (estimation.vlcBits) {
                    bitReader.skip(8);
                }
                if (estimation.interBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.inter4vBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.apm) {
                    bitReader.skip(8);
                }
                if (estimation.npm) {
                    bitReader.skip(8);
                }
                if (estimation.forwBackMcQ) {
                    bitReader.skip(8);
                }
                if (estimation.halfpel2) {
                    bitReader.skip(8);
                }
                if (estimation.halfpel4) {
                    bitReader.skip(8);
                }
                if (estimation.interpolateMcQ) {
                    bitReader.skip(8);
                }
                if (estimation.sadct) {
                    bitReader.skip(8);
                }
                if (estimation.quarterpel) {
                    bitReader.skip(8);
                }
            }
            if (i2 == 3 && i == 1) {
                if (estimation.intraBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.notCodedBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.dctCoefs) {
                    bitReader.skip(8);
                }
                if (estimation.dctLines) {
                    bitReader.skip(8);
                }
                if (estimation.vlcSymbols) {
                    bitReader.skip(8);
                }
                if (estimation.vlcBits) {
                    bitReader.skip(8);
                }
                if (estimation.interBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.inter4vBlocks) {
                    bitReader.skip(8);
                }
                if (estimation.apm) {
                    bitReader.skip(8);
                }
                if (estimation.npm) {
                    bitReader.skip(8);
                }
                if (estimation.forwBackMcQ) {
                    bitReader.skip(8);
                }
                if (estimation.halfpel2) {
                    bitReader.skip(8);
                }
                if (estimation.halfpel4) {
                    bitReader.skip(8);
                }
                if (estimation.interpolateMcQ) {
                    bitReader.skip(8);
                }
            }
        }
    }

    public boolean getPackedMode() {
        return this.packedMode;
    }

    public int getTimeIncrementBits() {
        return this.timeIncrementBits;
    }

    public int getTimeIncrementResolution() {
        return this.timeIncrementResolution;
    }

    public boolean readHeaders(ByteBuffer byteBuffer) throws NumberFormatException {
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        while (true) {
            if (byteBuffer.remaining() < 4) {
                return false;
            }
            int i = byteBuffer.getInt();
            while ((i & InputDeviceCompat.SOURCE_ANY) != 256 && byteBuffer.hasRemaining()) {
                i = (i << 8) | (byteBuffer.get() & ExifInterface.MARKER);
            }
            if (i == VISOBJSEQ_START_CODE) {
                byteBuffer.get();
            } else if (i == VISOBJSEQ_STOP_CODE) {
                continue;
            } else if (i == VISOBJ_START_CODE) {
                BitReader bitReaderCreateBitReader = BitReader.createBitReader(byteBuffer);
                if (bitReaderCreateBitReader.readBool()) {
                    bitReaderCreateBitReader.readNBit(4);
                    bitReaderCreateBitReader.skip(3);
                }
                if (bitReaderCreateBitReader.readNBit(4) != 1) {
                    return false;
                }
                if (bitReaderCreateBitReader.readBool()) {
                    bitReaderCreateBitReader.skip(3);
                    bitReaderCreateBitReader.skip(1);
                    if (bitReaderCreateBitReader.readBool()) {
                        bitReaderCreateBitReader.skip(8);
                        bitReaderCreateBitReader.skip(8);
                        bitReaderCreateBitReader.skip(8);
                    }
                }
                bitReaderCreateBitReader.terminate();
            } else if ((i & (-32)) == 256) {
                continue;
            } else if ((i & (-16)) == VIDOBJLAY_START_CODE) {
                BitReader bitReaderCreateBitReader2 = BitReader.createBitReader(byteBuffer);
                bitReaderCreateBitReader2.skip(1);
                bitReaderCreateBitReader2.skip(8);
                if (bitReaderCreateBitReader2.readBool()) {
                    this.volVersionId = bitReaderCreateBitReader2.readNBit(4);
                    bitReaderCreateBitReader2.skip(3);
                } else {
                    this.volVersionId = 1;
                }
                if (bitReaderCreateBitReader2.readNBit(4) == 15) {
                    bitReaderCreateBitReader2.readNBit(8);
                    bitReaderCreateBitReader2.readNBit(8);
                }
                if (bitReaderCreateBitReader2.readBool()) {
                    bitReaderCreateBitReader2.skip(2);
                    bitReaderCreateBitReader2.readBool();
                    if (bitReaderCreateBitReader2.readBool()) {
                        bitReaderCreateBitReader2.readNBit(15);
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.readNBit(15);
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.readNBit(15);
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.readNBit(3);
                        bitReaderCreateBitReader2.readNBit(11);
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.readNBit(15);
                        bitReaderCreateBitReader2.skip(1);
                    }
                }
                int nBit = bitReaderCreateBitReader2.readNBit(2);
                this.shape = nBit;
                if (nBit == 3 && this.volVersionId != 1) {
                    bitReaderCreateBitReader2.skip(4);
                }
                bitReaderCreateBitReader2.skip(1);
                int nBit2 = bitReaderCreateBitReader2.readNBit(16);
                this.timeIncrementResolution = nBit2;
                if (nBit2 > 0) {
                    this.timeIncrementBits = Math.max(MathUtil.log2(nBit2 - 1) + 1, 1);
                } else {
                    this.timeIncrementBits = 1;
                }
                bitReaderCreateBitReader2.skip(1);
                if (bitReaderCreateBitReader2.readBool()) {
                    bitReaderCreateBitReader2.skip(this.timeIncrementBits);
                }
                int i2 = this.shape;
                if (i2 != 2) {
                    if (i2 == 0) {
                        bitReaderCreateBitReader2.skip(1);
                        this.width = bitReaderCreateBitReader2.readNBit(13);
                        bitReaderCreateBitReader2.skip(1);
                        this.height = bitReaderCreateBitReader2.readNBit(13);
                        bitReaderCreateBitReader2.skip(1);
                        calcSizes();
                    }
                    this.interlacing = bitReaderCreateBitReader2.readBool();
                    bitReaderCreateBitReader2.readBool();
                    int nBit3 = bitReaderCreateBitReader2.readNBit(this.volVersionId == 1 ? 1 : 2);
                    this.spriteEnable = nBit3;
                    if (nBit3 == 1 || nBit3 == 2) {
                        if (nBit3 != 2) {
                            bitReaderCreateBitReader2.readNBit(13);
                            bitReaderCreateBitReader2.skip(1);
                            bitReaderCreateBitReader2.readNBit(13);
                            bitReaderCreateBitReader2.skip(1);
                            bitReaderCreateBitReader2.readNBit(13);
                            bitReaderCreateBitReader2.skip(1);
                            bitReaderCreateBitReader2.readNBit(13);
                            bitReaderCreateBitReader2.skip(1);
                        }
                        this.spriteWarpingPoints = bitReaderCreateBitReader2.readNBit(6);
                        bitReaderCreateBitReader2.readNBit(2);
                        this.spriteBrightnessChange = bitReaderCreateBitReader2.readBool();
                        if (this.spriteEnable != 2) {
                            bitReaderCreateBitReader2.readNBit(1);
                        }
                    }
                    if (this.volVersionId != 1 && this.shape != 0) {
                        bitReaderCreateBitReader2.skip(1);
                    }
                    if (bitReaderCreateBitReader2.readBool()) {
                        this.quantBits = bitReaderCreateBitReader2.readNBit(4);
                        bitReaderCreateBitReader2.skip(4);
                    } else {
                        this.quantBits = 5;
                    }
                    if (this.shape == 3) {
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.skip(1);
                    }
                    boolean bool = bitReaderCreateBitReader2.readBool();
                    this.quantType = bool;
                    if (bool) {
                        if (bitReaderCreateBitReader2.readBool()) {
                            getMatrix(bitReaderCreateBitReader2, this.intraMpegQuantMatrix);
                        } else {
                            short[] sArr = MPEG4Consts.DEFAULT_INTRA_MATRIX;
                            short[] sArr2 = this.intraMpegQuantMatrix;
                            System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
                        }
                        if (bitReaderCreateBitReader2.readBool()) {
                            getMatrix(bitReaderCreateBitReader2, this.interMpegQuantMatrix);
                        } else {
                            short[] sArr3 = MPEG4Consts.DEFAULT_INTER_MATRIX;
                            short[] sArr4 = this.interMpegQuantMatrix;
                            System.arraycopy(sArr3, 0, sArr4, 0, sArr4.length);
                        }
                        if (this.shape == 3) {
                            return false;
                        }
                    }
                    if (this.volVersionId != 1) {
                        this.quarterPel = bitReaderCreateBitReader2.readBool();
                    } else {
                        this.quarterPel = false;
                    }
                    boolean bool2 = bitReaderCreateBitReader2.readBool();
                    this.complexityEstimationDisable = bool2;
                    if (!bool2) {
                        readVolComplexityEstimationHeader(bitReaderCreateBitReader2, this.estimation);
                    }
                    bitReaderCreateBitReader2.skip(1);
                    if (bitReaderCreateBitReader2.readBool()) {
                        bitReaderCreateBitReader2.skip(1);
                    }
                    if (this.volVersionId != 1) {
                        boolean bool3 = bitReaderCreateBitReader2.readBool();
                        this.newPredEnable = bool3;
                        if (bool3) {
                            bitReaderCreateBitReader2.skip(2);
                            bitReaderCreateBitReader2.skip(1);
                        }
                        this.reducedResolutionEnable = bitReaderCreateBitReader2.readBool();
                    } else {
                        this.newPredEnable = false;
                        this.reducedResolutionEnable = false;
                    }
                    boolean bool4 = bitReaderCreateBitReader2.readBool();
                    this.scalability = bool4;
                    if (bool4) {
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.skip(4);
                        bitReaderCreateBitReader2.skip(1);
                        bitReaderCreateBitReader2.skip(5);
                        bitReaderCreateBitReader2.skip(5);
                        bitReaderCreateBitReader2.skip(5);
                        bitReaderCreateBitReader2.skip(5);
                        bitReaderCreateBitReader2.skip(1);
                        if (this.shape == 1) {
                            bitReaderCreateBitReader2.skip(1);
                            bitReaderCreateBitReader2.skip(1);
                            bitReaderCreateBitReader2.skip(5);
                            bitReaderCreateBitReader2.skip(5);
                            bitReaderCreateBitReader2.skip(5);
                            bitReaderCreateBitReader2.skip(5);
                        }
                        return false;
                    }
                } else {
                    if (this.volVersionId != 1) {
                        boolean bool5 = bitReaderCreateBitReader2.readBool();
                        this.scalability = bool5;
                        if (bool5) {
                            bitReaderCreateBitReader2.skip(4);
                            bitReaderCreateBitReader2.skip(5);
                            bitReaderCreateBitReader2.skip(5);
                            bitReaderCreateBitReader2.skip(5);
                            bitReaderCreateBitReader2.skip(5);
                            return false;
                        }
                    }
                    bitReaderCreateBitReader2.skip(1);
                }
                bitReaderCreateBitReader2.terminate();
            } else if (i == GRPOFVOP_START_CODE) {
                BitReader bitReaderCreateBitReader3 = BitReader.createBitReader(byteBuffer);
                bitReaderCreateBitReader3.readNBit(5);
                bitReaderCreateBitReader3.readNBit(6);
                bitReaderCreateBitReader3.skip(1);
                bitReaderCreateBitReader3.readNBit(6);
                bitReaderCreateBitReader3.skip(1);
                bitReaderCreateBitReader3.skip(1);
                bitReaderCreateBitReader3.terminate();
            } else {
                if (i == VOP_START_CODE) {
                    return true;
                }
                if (i == USERDATA_START_CODE) {
                    byte[] bArr = new byte[256];
                    bArr[0] = byteBuffer.get();
                    int i3 = 1;
                    while (true) {
                        byte b = byteBuffer.get();
                        bArr[i3] = b;
                        if (b == 0) {
                            break;
                        }
                        i3++;
                    }
                    byteBuffer.position(byteBuffer.position() - 1);
                    String str = new String(bArr, 0, i3);
                    if (str.startsWith("XviD")) {
                        if (bArr[str.length() - 1] == 67) {
                            this.bsVersion = Integer.parseInt(str.substring(4, str.length() - 1));
                            this.cartoonMode = true;
                        } else {
                            this.bsVersion = Integer.parseInt(str.substring(4));
                        }
                    }
                    if (str.startsWith("DivX")) {
                        int iIndexOf = str.indexOf("Build");
                        if (iIndexOf == -1) {
                            iIndexOf = str.indexOf(TsConstants.kLinkParam_suffix);
                        }
                        try {
                            Integer.parseInt(str.substring(4, iIndexOf));
                            Integer.parseInt(str.substring(iIndexOf + 1, str.length() - 1));
                            this.packedMode = str.charAt(str.length() - 1) == 'p';
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    Logger.debug("Unknown");
                }
            }
        }
    }

    public boolean readVOPHeader(BitReader bitReader) {
        int nBit;
        int nBit2;
        int i;
        int i2;
        this.rounding = false;
        this.quant = 2;
        this.codingType = bitReader.readNBit(2);
        while (bitReader.readBool()) {
            this.timestampMSB++;
        }
        bitReader.skip(1);
        if (getTimeIncrementBits() != 0) {
            this.timestampLSB = bitReader.readNBit(getTimeIncrementBits());
        }
        bitReader.skip(1);
        if (!bitReader.readBool()) {
            return false;
        }
        if (this.newPredEnable) {
            bitReader.readNBit(Math.min(getTimeIncrementBits() + 3, 15));
            if (bitReader.readBool()) {
                bitReader.readNBit(Math.min(getTimeIncrementBits() + 3, 15));
            }
            bitReader.skip(1);
        }
        if (this.shape != 2 && ((i2 = this.codingType) == 1 || (i2 == 3 && this.spriteEnable == 2))) {
            this.rounding = bitReader.readBool();
        }
        if (this.reducedResolutionEnable && this.shape == 0 && ((i = this.codingType) == 1 || i == 0)) {
            bitReader.readBool();
        }
        if (this.shape != 0) {
            if (this.spriteEnable != 1 || this.codingType != 0) {
                this.width = bitReader.readNBit(13);
                bitReader.skip(1);
                this.height = bitReader.readNBit(13);
                bitReader.skip(1);
                this.horiz_mc_ref = bitReader.readNBit(13);
                bitReader.skip(1);
                this.vert_mc_ref = bitReader.readNBit(13);
                bitReader.skip(1);
                calcSizes();
            }
            bitReader.skip(1);
            if (bitReader.readBool()) {
                bitReader.skip(8);
            }
        }
        Estimation estimation = new Estimation();
        if (this.shape != 2) {
            if (!this.complexityEstimationDisable) {
                readVopComplexityEstimationHeader(bitReader, estimation, this.spriteEnable, this.codingType);
            }
            this.intraDCThreshold = MPEG4Consts.INTRA_DC_THRESHOLD_TABLE[bitReader.readNBit(3)];
            if (this.interlacing) {
                this.topFieldFirst = bitReader.readBool();
                this.alternateVerticalScan = bitReader.readBool();
            }
        }
        int i3 = this.spriteEnable;
        if ((i3 == 1 || i3 == 2) && this.codingType == 3) {
            for (int i4 = 0; i4 < this.spriteWarpingPoints; i4++) {
                int spriteTrajectory = getSpriteTrajectory(bitReader);
                if (spriteTrajectory > 0) {
                    nBit = bitReader.readNBit(spriteTrajectory);
                    if ((nBit >> (spriteTrajectory - 1)) == 0) {
                        nBit = -(((1 << spriteTrajectory) - 1) ^ nBit);
                    }
                } else {
                    nBit = 0;
                }
                bitReader.skip(1);
                int spriteTrajectory2 = getSpriteTrajectory(bitReader);
                if (spriteTrajectory2 > 0) {
                    nBit2 = bitReader.readNBit(spriteTrajectory2);
                    if ((nBit2 >> (spriteTrajectory2 - 1)) == 0) {
                        nBit2 = -(((1 << spriteTrajectory2) - 1) ^ nBit2);
                    }
                } else {
                    nBit2 = 0;
                }
                bitReader.skip(1);
                int[] iArr = this.gmcWarps[i4];
                iArr[0] = nBit;
                iArr[1] = nBit2;
            }
        }
        int nBit3 = bitReader.readNBit(this.quantBits);
        this.quant = nBit3;
        if (nBit3 < 1) {
            this.quant = 1;
        }
        if (this.codingType != 0) {
            this.fcodeForward = bitReader.readNBit(3);
        }
        if (this.codingType == 2) {
            this.fcodeBackward = bitReader.readNBit(3);
        }
        if (!this.scalability && this.shape != 0 && this.codingType != 0) {
            bitReader.skip(1);
        }
        if (this.codingType != 2) {
            int i5 = this.timeBase;
            this.lastTimeBase = i5;
            int i6 = i5 + this.timestampMSB;
            this.timeBase = i6;
            int timeIncrementResolution = (i6 * getTimeIncrementResolution()) + this.timestampLSB;
            this.time = timeIncrementResolution;
            this.pframeTs = timeIncrementResolution - this.lastNonBTime;
            this.lastNonBTime = timeIncrementResolution;
        } else {
            int timeIncrementResolution2 = ((this.lastTimeBase + this.timestampMSB) * getTimeIncrementResolution()) + this.timestampLSB;
            this.time = timeIncrementResolution2;
            this.bframeTs = this.pframeTs - (this.lastNonBTime - timeIncrementResolution2);
        }
        return true;
    }
}
