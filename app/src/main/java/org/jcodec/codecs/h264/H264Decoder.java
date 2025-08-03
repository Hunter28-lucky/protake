package org.jcodec.codecs.h264;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.decode.DeblockerInput;
import org.jcodec.codecs.h264.decode.FrameReader;
import org.jcodec.codecs.h264.decode.SliceDecoder;
import org.jcodec.codecs.h264.decode.SliceHeaderReader;
import org.jcodec.codecs.h264.decode.SliceReader;
import org.jcodec.codecs.h264.decode.deblock.DeblockingFilter;
import org.jcodec.codecs.h264.io.model.Frame;
import org.jcodec.codecs.h264.io.model.NALUnit;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.RefPicMarking;
import org.jcodec.codecs.h264.io.model.RefPicMarkingIDR;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.io.model.SliceHeader;
import org.jcodec.codecs.h264.io.model.SliceType;
import org.jcodec.common.IntObjectMap;
import org.jcodec.common.UsedViaReflection;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.VideoDecoder;
import org.jcodec.common.io.BitReader;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Rect;
import org.jcodec.common.tools.MathUtil;

/* loaded from: classes2.dex */
public class H264Decoder extends VideoDecoder {
    private IntObjectMap<Frame> lRefs;
    private List<Frame> pictureBuffer = new ArrayList();
    private POCManager poc = new POCManager();
    private FrameReader reader;
    private Frame[] sRefs;
    private boolean threaded;
    private ExecutorService tp;

    /* renamed from: org.jcodec.codecs.h264.H264Decoder$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType;

        static {
            int[] iArr = new int[RefPicMarking.InstrType.values().length];
            $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType = iArr;
            try {
                iArr[RefPicMarking.InstrType.REMOVE_SHORT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.REMOVE_LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.CONVERT_INTO_LONG.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.TRUNK_LONG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.CLEAR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[RefPicMarking.InstrType.MARK_LONG.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class FrameDecoder {
        private SeqParameterSet activeSps;
        private H264Decoder dec;
        private DeblockerInput di;
        private DeblockingFilter filter;
        private NALUnit firstNu;
        private SliceHeader firstSliceHeader;

        public FrameDecoder(H264Decoder h264Decoder) {
            this.dec = h264Decoder;
        }

        private void convert(int i, int i2) {
            SliceHeader sliceHeader = this.firstSliceHeader;
            int iWrap = MathUtil.wrap(sliceHeader.frameNum - i, 1 << (sliceHeader.sps.log2MaxFrameNumMinus4 + 4));
            releaseRef((Frame) this.dec.lRefs.get(i2));
            this.dec.lRefs.put(i2, this.dec.sRefs[iWrap]);
            this.dec.sRefs[iWrap] = null;
            ((Frame) this.dec.lRefs.get(i2)).setShortTerm(false);
        }

        private Frame init(SliceReader sliceReader, byte[][] bArr) {
            this.firstNu = sliceReader.getNALUnit();
            SliceHeader sliceHeader = sliceReader.getSliceHeader();
            this.firstSliceHeader = sliceHeader;
            SeqParameterSet seqParameterSet = sliceHeader.sps;
            this.activeSps = seqParameterSet;
            validateSupportedFeatures(seqParameterSet, sliceHeader.pps);
            int i = this.activeSps.picWidthInMbsMinus1 + 1;
            if (this.dec.sRefs == null) {
                this.dec.sRefs = new Frame[1 << (this.firstSliceHeader.sps.log2MaxFrameNumMinus4 + 4)];
                this.dec.lRefs = new IntObjectMap();
            }
            DeblockerInput deblockerInput = new DeblockerInput(this.activeSps);
            this.di = deblockerInput;
            SeqParameterSet seqParameterSet2 = this.activeSps;
            SliceHeader sliceHeader2 = this.firstSliceHeader;
            Frame frameCreateFrame = H264Decoder.createFrame(seqParameterSet2, bArr, sliceHeader2.frameNum, sliceHeader2.sliceType, deblockerInput.mvs, deblockerInput.refsUsed, this.dec.poc.calcPOC(this.firstSliceHeader, this.firstNu));
            this.filter = new DeblockingFilter(i, this.activeSps.bitDepthChromaMinus8 + 8, this.di);
            return frameCreateFrame;
        }

        private void releaseRef(Frame frame) {
            if (frame != null) {
                this.dec.pictureBuffer.add(frame);
            }
        }

        private void saveLong(Frame frame, int i) {
            Frame frame2 = (Frame) this.dec.lRefs.get(i);
            if (frame2 != null) {
                releaseRef(frame2);
            }
            frame.setShortTerm(false);
            this.dec.lRefs.put(i, frame);
        }

        private Frame saveRef(Frame frame) {
            Frame frameCreateFrame = this.dec.pictureBuffer.size() > 0 ? (Frame) this.dec.pictureBuffer.remove(0) : Frame.createFrame(frame);
            frameCreateFrame.copyFromFrame(frame);
            return frameCreateFrame;
        }

        private void saveShort(Frame frame) {
            this.dec.sRefs[this.firstSliceHeader.frameNum] = frame;
        }

        private void truncateLongTerm(int i) {
            int[] iArrKeys = this.dec.lRefs.keys();
            for (int i2 = 0; i2 < iArrKeys.length; i2++) {
                if (iArrKeys[i2] > i) {
                    releaseRef((Frame) this.dec.lRefs.get(iArrKeys[i2]));
                    this.dec.lRefs.remove(iArrKeys[i2]);
                }
            }
        }

        private void unrefLongTerm(int i) {
            releaseRef((Frame) this.dec.lRefs.get(i));
            this.dec.lRefs.remove(i);
        }

        private void unrefShortTerm(int i) {
            SliceHeader sliceHeader = this.firstSliceHeader;
            int iWrap = MathUtil.wrap(sliceHeader.frameNum - i, 1 << (sliceHeader.sps.log2MaxFrameNumMinus4 + 4));
            releaseRef(this.dec.sRefs[iWrap]);
            this.dec.sRefs[iWrap] = null;
        }

        private int unwrap(int i, int i2, int i3) {
            return i2 > i ? i2 - i3 : i2;
        }

        private void updateReferences(Frame frame) {
            NALUnit nALUnit = this.firstNu;
            if (nALUnit.nal_ref_idc != 0) {
                if (nALUnit.type == NALUnitType.IDR_SLICE) {
                    performIDRMarking(this.firstSliceHeader.refPicMarkingIDR, frame);
                } else {
                    performMarking(this.firstSliceHeader.refPicMarkingNonIDR, frame);
                }
            }
        }

        private void validateSupportedFeatures(SeqParameterSet seqParameterSet, PictureParameterSet pictureParameterSet) {
            if (seqParameterSet.mbAdaptiveFrameFieldFlag) {
                throw new RuntimeException("Unsupported h264 feature: MBAFF.");
            }
            if (seqParameterSet.bitDepthLumaMinus8 != 0 || seqParameterSet.bitDepthChromaMinus8 != 0) {
                throw new RuntimeException("Unsupported h264 feature: High bit depth.");
            }
            if (seqParameterSet.chromaFormatIdc != ColorSpace.YUV420J) {
                throw new RuntimeException("Unsupported h264 feature: " + seqParameterSet.chromaFormatIdc + " color.");
            }
            if (!seqParameterSet.frameMbsOnlyFlag || seqParameterSet.fieldPicFlag) {
                throw new RuntimeException("Unsupported h264 feature: interlace.");
            }
            if (pictureParameterSet.constrainedIntraPredFlag) {
                throw new RuntimeException("Unsupported h264 feature: constrained intra prediction.");
            }
            if (seqParameterSet.qpprimeYZeroTransformBypassFlag) {
                throw new RuntimeException("Unsupported h264 feature: qprime zero transform bypass.");
            }
            int i = seqParameterSet.profileIdc;
            if (i == 66 || i == 77 || i == 100) {
                return;
            }
            throw new RuntimeException("Unsupported h264 feature: " + seqParameterSet.profileIdc + " profile.");
        }

        private void waitForSure(Future<?> future) throws ExecutionException, InterruptedException {
            try {
                future.get();
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }

        public void clearAll() {
            for (int i = 0; i < this.dec.sRefs.length; i++) {
                releaseRef(this.dec.sRefs[i]);
                this.dec.sRefs[i] = null;
            }
            for (int i2 : this.dec.lRefs.keys()) {
                releaseRef((Frame) this.dec.lRefs.get(i2));
            }
            this.dec.lRefs.clear();
        }

        public Frame decodeFrame(List<ByteBuffer> list, byte[][] bArr) throws ExecutionException, InterruptedException {
            List<SliceReader> frame = this.dec.reader.readFrame(list);
            if (frame == null || frame.size() == 0) {
                return null;
            }
            Frame frameInit = init(frame.get(0), bArr);
            if (!this.dec.threaded || frame.size() <= 1) {
                Iterator<SliceReader> it = frame.iterator();
                while (it.hasNext()) {
                    new SliceDecoder(this.activeSps, this.dec.sRefs, this.dec.lRefs, this.di, frameInit).decodeFromReader(it.next());
                }
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator<SliceReader> it2 = frame.iterator();
                while (it2.hasNext()) {
                    arrayList.add(this.dec.tp.submit(new SliceDecoderRunnable(this, it2.next(), frameInit)));
                }
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    waitForSure((Future) it3.next());
                }
            }
            this.filter.deblockFrame(frameInit);
            updateReferences(frameInit);
            return frameInit;
        }

        public void performIDRMarking(RefPicMarkingIDR refPicMarkingIDR, Frame frame) {
            clearAll();
            this.dec.pictureBuffer.clear();
            Frame frameSaveRef = saveRef(frame);
            if (!refPicMarkingIDR.isUseForlongTerm()) {
                this.dec.sRefs[this.firstSliceHeader.frameNum] = frameSaveRef;
            } else {
                this.dec.lRefs.put(0, frameSaveRef);
                frameSaveRef.setShortTerm(false);
            }
        }

        public void performMarking(RefPicMarking refPicMarking, Frame frame) {
            Frame frameSaveRef = saveRef(frame);
            if (refPicMarking != null) {
                for (RefPicMarking.Instruction instruction : refPicMarking.getInstructions()) {
                    switch (AnonymousClass2.$SwitchMap$org$jcodec$codecs$h264$io$model$RefPicMarking$InstrType[instruction.getType().ordinal()]) {
                        case 1:
                            unrefShortTerm(instruction.getArg1());
                            break;
                        case 2:
                            unrefLongTerm(instruction.getArg1());
                            break;
                        case 3:
                            convert(instruction.getArg1(), instruction.getArg2());
                            break;
                        case 4:
                            truncateLongTerm(instruction.getArg1() - 1);
                            break;
                        case 5:
                            clearAll();
                            break;
                        case 6:
                            saveLong(frameSaveRef, instruction.getArg1());
                            frameSaveRef = null;
                            break;
                    }
                }
            }
            if (frameSaveRef != null) {
                saveShort(frameSaveRef);
            }
            SeqParameterSet seqParameterSet = this.activeSps;
            int i = 1 << (seqParameterSet.log2MaxFrameNumMinus4 + 4);
            if (refPicMarking == null) {
                int iMax = Math.max(1, seqParameterSet.numRefFrames - this.dec.lRefs.size());
                int i2 = Integer.MAX_VALUE;
                int i3 = 0;
                int frameNo = 0;
                for (int i4 = 0; i4 < this.dec.sRefs.length; i4++) {
                    if (this.dec.sRefs[i4] != null) {
                        int iUnwrap = unwrap(this.firstSliceHeader.frameNum, this.dec.sRefs[i4].getFrameNo(), i);
                        if (iUnwrap < i2) {
                            frameNo = this.dec.sRefs[i4].getFrameNo();
                            i2 = iUnwrap;
                        }
                        i3++;
                    }
                }
                if (i3 > iMax) {
                    releaseRef(this.dec.sRefs[frameNo]);
                    this.dec.sRefs[frameNo] = null;
                }
            }
        }
    }

    public static final class SliceDecoderRunnable implements Runnable {
        private FrameDecoder fdec;
        private final Frame result;
        private final SliceReader sliceReader;

        @Override // java.lang.Runnable
        public void run() {
            new SliceDecoder(this.fdec.activeSps, this.fdec.dec.sRefs, this.fdec.dec.lRefs, this.fdec.di, this.result).decodeFromReader(this.sliceReader);
        }

        private SliceDecoderRunnable(FrameDecoder frameDecoder, SliceReader sliceReader, Frame frame) {
            this.fdec = frameDecoder;
            this.sliceReader = sliceReader;
            this.result = frame;
        }
    }

    public H264Decoder() {
        boolean z = Runtime.getRuntime().availableProcessors() > 1;
        this.threaded = z;
        if (z) {
            this.tp = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new ThreadFactory() { // from class: org.jcodec.codecs.h264.H264Decoder.1
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread threadNewThread = Executors.defaultThreadFactory().newThread(runnable);
                    threadNewThread.setDaemon(true);
                    return threadNewThread;
                }
            });
        }
        this.reader = new FrameReader();
    }

    public static Frame createFrame(SeqParameterSet seqParameterSet, byte[][] bArr, int i, SliceType sliceType, H264Utils.MvList2D mvList2D, Frame[][][] frameArr, int i2) {
        Rect rect;
        int i3 = (seqParameterSet.picWidthInMbsMinus1 + 1) << 4;
        int picHeightInMbs = SeqParameterSet.getPicHeightInMbs(seqParameterSet) << 4;
        if (seqParameterSet.frameCroppingFlag) {
            int i4 = seqParameterSet.frameCropLeftOffset << 1;
            int i5 = seqParameterSet.frameCropTopOffset << 1;
            rect = new Rect(i4, i5, (i3 - (seqParameterSet.frameCropRightOffset << 1)) - i4, (picHeightInMbs - (seqParameterSet.frameCropBottomOffset << 1)) - i5);
        } else {
            rect = null;
        }
        return new Frame(i3, picHeightInMbs, bArr, ColorSpace.YUV420, rect, i, sliceType, mvList2D, frameArr, i2);
    }

    public static H264Decoder createH264DecoderFromCodecPrivate(ByteBuffer byteBuffer) {
        H264Decoder h264Decoder = new H264Decoder();
        for (ByteBuffer byteBuffer2 : H264Utils.splitFrame(byteBuffer.duplicate())) {
            NALUnitType nALUnitType = NALUnit.read(byteBuffer2).type;
            if (nALUnitType == NALUnitType.SPS) {
                h264Decoder.reader.addSps(byteBuffer2);
            } else if (nALUnitType == NALUnitType.PPS) {
                h264Decoder.reader.addPps(byteBuffer2);
            }
        }
        return h264Decoder;
    }

    @UsedViaReflection
    public static int probe(ByteBuffer byteBuffer) {
        boolean zValidSh;
        boolean zValidSps = false;
        boolean zValidPps = false;
        for (ByteBuffer byteBuffer2 : H264Utils.splitFrame(byteBuffer.duplicate())) {
            NALUnitType nALUnitType = NALUnit.read(byteBuffer2).type;
            if (nALUnitType == NALUnitType.IDR_SLICE || nALUnitType == NALUnitType.NON_IDR_SLICE) {
                zValidSh = validSh(SliceHeaderReader.readPart1(BitReader.createBitReader(byteBuffer2)));
                break;
            }
            if (nALUnitType == NALUnitType.SPS) {
                zValidSps = validSps(SeqParameterSet.read(byteBuffer2));
            } else if (nALUnitType == NALUnitType.PPS) {
                zValidPps = validPps(PictureParameterSet.read(byteBuffer2));
            }
        }
        zValidSh = false;
        return (zValidSh ? 60 : 0) + (zValidSps ? 20 : 0) + (zValidPps ? 20 : 0);
    }

    private static boolean validPps(PictureParameterSet pictureParameterSet) {
        return pictureParameterSet.picInitQpMinus26 <= 26 && pictureParameterSet.seqParameterSetId <= 2 && pictureParameterSet.picParameterSetId <= 2;
    }

    private static boolean validSh(SliceHeader sliceHeader) {
        return sliceHeader.firstMbInSlice == 0 && sliceHeader.sliceType != null && sliceHeader.picParameterSetId < 2;
    }

    private static boolean validSps(SeqParameterSet seqParameterSet) {
        return seqParameterSet.bitDepthChromaMinus8 < 4 && seqParameterSet.bitDepthLumaMinus8 < 4 && seqParameterSet.chromaFormatIdc != null && seqParameterSet.seqParameterSetId < 2 && seqParameterSet.picOrderCntType <= 2;
    }

    public void addPps(List<ByteBuffer> list) {
        this.reader.addPpsList(list);
    }

    public void addSps(List<ByteBuffer> list) {
        this.reader.addSpsList(list);
    }

    public Frame decodeFrameFromNals(List<ByteBuffer> list, byte[][] bArr) {
        return new FrameDecoder(this).decodeFrame(list, bArr);
    }

    @Override // org.jcodec.common.VideoDecoder
    public VideoCodecMeta getCodecMeta(ByteBuffer byteBuffer) {
        List<ByteBuffer> rawSPS = H264Utils.getRawSPS(byteBuffer.duplicate());
        H264Utils.getRawPPS(byteBuffer.duplicate());
        if (rawSPS.size() != 0) {
            return VideoCodecMeta.createSimpleVideoCodecMeta(H264Utils.getPicSize(SeqParameterSet.read(rawSPS.get(0))), ColorSpace.YUV420);
        }
        Logger.warn("Can not extract metadata from the packet not containing an SPS.");
        return null;
    }

    @Override // org.jcodec.common.VideoDecoder
    public Frame decodeFrame(ByteBuffer byteBuffer, byte[][] bArr) {
        return decodeFrameFromNals(H264Utils.splitFrame(byteBuffer), bArr);
    }
}
