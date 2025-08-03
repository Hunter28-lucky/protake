package org.jcodec.containers.mps.index;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jcodec.common.ArrayUtil;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.LongArrayList;
import org.jcodec.common.RunLength;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mps.MPSUtils;
import org.jcodec.containers.mps.PESPacket;
import org.jcodec.containers.mps.index.MPSIndex;

/* loaded from: classes2.dex */
public abstract class BaseIndexer extends MPSUtils.PESReader {
    private Map<Integer, BaseAnalyser> analyzers = new HashMap();
    private LongArrayList tokens = LongArrayList.createLongArrayList();
    private RunLength.Integer streams = new RunLength.Integer();

    public static abstract class BaseAnalyser {
        public IntArrayList pts = new IntArrayList(250000);
        public IntArrayList dur = new IntArrayList(250000);

        public int estimateSize() {
            return (this.pts.size() << 2) + 4;
        }

        public abstract void finishAnalyse();

        public abstract void pkt(ByteBuffer byteBuffer, PESPacket pESPacket);

        public abstract MPSIndex.MPSStreamIndex serialize(int i);
    }

    public static class GenericAnalyser extends BaseAnalyser {
        private int knownDuration;
        private long lastPts;
        private IntArrayList sizes = new IntArrayList(250000);

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public int estimateSize() {
            return super.estimateSize() + (this.sizes.size() << 2) + 32;
        }

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public void finishAnalyse() {
        }

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public void pkt(ByteBuffer byteBuffer, PESPacket pESPacket) {
            this.sizes.add(byteBuffer.remaining());
            long j = pESPacket.pts;
            if (j == -1) {
                pESPacket.pts = this.lastPts + this.knownDuration;
            } else {
                this.knownDuration = (int) (j - this.lastPts);
                this.lastPts = j;
            }
            this.pts.add((int) pESPacket.pts);
            this.dur.add(this.knownDuration);
        }

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public MPSIndex.MPSStreamIndex serialize(int i) {
            return new MPSIndex.MPSStreamIndex(i, this.sizes.toArray(), this.pts.toArray(), this.dur.toArray(), new int[0]);
        }
    }

    public static class MPEGVideoAnalyser extends BaseAnalyser {
        private int frameNo;
        private boolean inFrameData;
        private Frame lastFrame;
        private Frame lastFrameOfLastGop;
        private long position;
        private int marker = -1;
        private long phPos = -1;
        private IntArrayList sizes = new IntArrayList(250000);
        private IntArrayList keyFrames = new IntArrayList(20000);
        private List<Frame> curGop = new ArrayList();

        public static class Frame {
            public long offset;
            public int pts;
            public int size;
            public int tempRef;

            private Frame() {
            }
        }

        private void fixPts(List<Frame> list) {
            Frame[] frameArr = (Frame[]) list.toArray(new Frame[0]);
            Arrays.sort(frameArr, new Comparator<Frame>() { // from class: org.jcodec.containers.mps.index.BaseIndexer.MPEGVideoAnalyser.1
                @Override // java.util.Comparator
                public int compare(Frame frame, Frame frame2) {
                    int i = frame.tempRef;
                    int i2 = frame2.tempRef;
                    if (i > i2) {
                        return 1;
                    }
                    return i == i2 ? 0 : -1;
                }
            });
            for (int i = 0; i < 3; i++) {
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                int i5 = -1;
                for (int i6 = 0; i6 < frameArr.length; i6++) {
                    Frame frame = frameArr[i6];
                    if (frame.pts == -1 && i2 != -1 && i3 != -1) {
                        frame.pts = ((i2 - i3) / MathUtil.abs(i4 - i5)) + i2;
                    }
                    Frame frame2 = frameArr[i6];
                    int i7 = frame2.pts;
                    if (i7 != -1) {
                        i5 = i4;
                        i4 = frame2.tempRef;
                        i3 = i2;
                        i2 = i7;
                    }
                }
                ArrayUtil.reverse(frameArr);
            }
            Frame frame3 = this.lastFrameOfLastGop;
            if (frame3 != null) {
                this.dur.add(frameArr[0].pts - frame3.pts);
            }
            for (int i8 = 1; i8 < frameArr.length; i8++) {
                this.dur.add(frameArr[i8].pts - frameArr[i8 - 1].pts);
            }
            this.lastFrameOfLastGop = frameArr[frameArr.length - 1];
        }

        private void outGop() {
            fixPts(this.curGop);
            for (Frame frame : this.curGop) {
                this.sizes.add(frame.size);
                this.pts.add(frame.pts);
            }
            this.curGop.clear();
        }

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public void finishAnalyse() {
            Frame frame = this.lastFrame;
            if (frame == null) {
                return;
            }
            frame.size = (int) (this.position - frame.offset);
            this.curGop.add(frame);
            outGop();
        }

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public void pkt(ByteBuffer byteBuffer, PESPacket pESPacket) {
            int i;
            while (byteBuffer.hasRemaining()) {
                int i2 = byteBuffer.get() & ExifInterface.MARKER;
                long j = this.position + 1;
                this.position = j;
                this.marker = (this.marker << 8) | i2;
                long j2 = this.phPos;
                if (j2 != -1) {
                    long j3 = j - j2;
                    if (j3 == 5) {
                        this.lastFrame.tempRef = i2 << 2;
                    } else if (j3 == 6) {
                        int i3 = (i2 >> 3) & 7;
                        Frame frame = this.lastFrame;
                        frame.tempRef = (i2 >> 6) | frame.tempRef;
                        if (i3 == 1) {
                            this.keyFrames.add(this.frameNo - 1);
                            if (this.curGop.size() > 0) {
                                outGop();
                            }
                        }
                    }
                }
                int i4 = this.marker;
                if ((i4 & InputDeviceCompat.SOURCE_ANY) == 256) {
                    boolean z = this.inFrameData;
                    if (z && (i4 == 256 || i4 > 431)) {
                        Frame frame2 = this.lastFrame;
                        frame2.size = (int) ((this.position - 4) - frame2.offset);
                        this.curGop.add(frame2);
                        this.lastFrame = null;
                        this.inFrameData = false;
                    } else if (!z && i4 > 256 && i4 <= 431) {
                        this.inFrameData = true;
                    }
                    if (this.lastFrame == null && ((i = this.marker) == 435 || i == 440 || i == 256)) {
                        Frame frame3 = new Frame();
                        frame3.pts = (int) pESPacket.pts;
                        frame3.offset = this.position - 4;
                        Logger.info(String.format("FRAME[%d]: %012x, %d", Integer.valueOf(this.frameNo), Long.valueOf((pESPacket.pos + byteBuffer.position()) - 4), Long.valueOf(pESPacket.pts)));
                        this.frameNo++;
                        this.lastFrame = frame3;
                    }
                    Frame frame4 = this.lastFrame;
                    if (frame4 != null && frame4.pts == -1 && this.marker == 256) {
                        frame4.pts = (int) pESPacket.pts;
                    }
                    this.phPos = this.marker == 256 ? this.position - 4 : -1L;
                }
            }
        }

        @Override // org.jcodec.containers.mps.index.BaseIndexer.BaseAnalyser
        public MPSIndex.MPSStreamIndex serialize(int i) {
            return new MPSIndex.MPSStreamIndex(i, this.sizes.toArray(), this.pts.toArray(), this.dur.toArray(), this.keyFrames.toArray());
        }
    }

    public int estimateSize() {
        int size = (this.tokens.size() << 3) + this.streams.estimateSize() + 128;
        Iterator<Integer> it = this.analyzers.keySet().iterator();
        while (it.hasNext()) {
            size += this.analyzers.get(it.next()).estimateSize();
        }
        return size;
    }

    public void finishAnalyse() {
        super.finishRead();
        Iterator<BaseAnalyser> it = this.analyzers.values().iterator();
        while (it.hasNext()) {
            it.next().finishAnalyse();
        }
    }

    public BaseAnalyser getAnalyser(int i) {
        if (this.analyzers.get(Integer.valueOf(i)) == null) {
            this.analyzers.put(Integer.valueOf(i), (i < 224 || i > 239) ? new GenericAnalyser() : new MPEGVideoAnalyser());
        }
        return this.analyzers.get(Integer.valueOf(i));
    }

    public void savePESMeta(int i, long j) {
        this.tokens.add(j);
        this.streams.add(i);
    }

    public MPSIndex serialize() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Integer, BaseAnalyser> entry : this.analyzers.entrySet()) {
            arrayList.add(entry.getValue().serialize(entry.getKey().intValue()));
        }
        return new MPSIndex(this.tokens.toArray(), this.streams, (MPSIndex.MPSStreamIndex[]) arrayList.toArray(new MPSIndex.MPSStreamIndex[0]));
    }
}
