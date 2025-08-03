package org.jcodec.api.transcode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jcodec.api.transcode.PixelStore;
import org.jcodec.api.transcode.filters.ColorTransformFilter;
import org.jcodec.common.AudioCodecMeta;
import org.jcodec.common.IntArrayList;
import org.jcodec.common.VideoCodecMeta;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class Transcoder {
    public static final int REORDER_BUFFER_SIZE = 7;
    private Mapping[] audioMappings;
    private List<Filter>[] extraFilters;
    private int[] maxFrames;
    private int[] seekFrames;
    private Sink[] sinks;
    private Source[] sources;
    private Mapping[] videoMappings;

    public static class Mapping {
        private boolean copy;
        private int source;

        public Mapping(int i, boolean z) {
            this.source = i;
            this.copy = z;
        }
    }

    public static class Stream {
        private AudioCodecMeta audioCodecMeta;
        private boolean audioCopy;
        private List<Filter> extraFilters;
        private List<Filter> filters;
        private PixelStore pixelStore;
        private Sink sink;
        private VideoCodecMeta videoCodecMeta;
        private boolean videoCopy;
        private LinkedList<VideoFrameWithPacket> videoQueue = new LinkedList<>();
        private LinkedList<AudioFrameWithPacket> audioQueue = new LinkedList<>();

        public Stream(Sink sink, boolean z, boolean z2, List<Filter> list, PixelStore pixelStore) {
            this.sink = sink;
            this.videoCopy = z;
            this.audioCopy = z2;
            this.extraFilters = list;
            this.pixelStore = pixelStore;
        }

        private PixelStore.LoanerPicture filterFrame(VideoFrameWithPacket videoFrameWithPacket) {
            PixelStore.LoanerPicture frame = videoFrameWithPacket.getFrame();
            Iterator<Filter> it = this.filters.iterator();
            while (it.hasNext()) {
                PixelStore.LoanerPicture loanerPictureFilter = it.next().filter(frame.getPicture(), this.pixelStore);
                if (loanerPictureFilter != null) {
                    this.pixelStore.putBack(frame);
                    frame = loanerPictureFilter;
                }
            }
            return frame;
        }

        private List<Filter> initColorTransform(ColorSpace colorSpace, List<Filter> list, Sink sink) {
            ArrayList arrayList = new ArrayList();
            for (Filter filter : list) {
                ColorSpace inputColor = filter.getInputColor();
                if (!colorSpace.matches(inputColor)) {
                    arrayList.add(new ColorTransformFilter(inputColor));
                }
                arrayList.add(filter);
                if (filter.getOutputColor() != ColorSpace.SAME) {
                    colorSpace = filter.getOutputColor();
                }
            }
            ColorSpace inputColor2 = sink.getInputColor();
            if (inputColor2 != null && inputColor2 != colorSpace) {
                arrayList.add(new ColorTransformFilter(inputColor2));
            }
            return arrayList;
        }

        public void addAudioPacket(AudioFrameWithPacket audioFrameWithPacket, AudioCodecMeta audioCodecMeta) {
            this.audioQueue.add(audioFrameWithPacket);
            this.audioCodecMeta = audioCodecMeta;
        }

        public void addVideoPacket(VideoFrameWithPacket videoFrameWithPacket, VideoCodecMeta videoCodecMeta) {
            if (videoFrameWithPacket.getFrame() != null) {
                this.pixelStore.retake(videoFrameWithPacket.getFrame());
            }
            this.videoQueue.add(videoFrameWithPacket);
            this.videoCodecMeta = videoCodecMeta;
            if (this.filters == null) {
                this.filters = initColorTransform(videoCodecMeta.getColor(), this.extraFilters, this.sink);
            }
        }

        public void finalFlushQueues() throws IOException {
            Iterator<VideoFrameWithPacket> it = this.videoQueue.iterator();
            VideoFrameWithPacket videoFrameWithPacket = null;
            while (it.hasNext()) {
                VideoFrameWithPacket next = it.next();
                if (videoFrameWithPacket == null || next.getPacket().getPtsD() >= videoFrameWithPacket.getPacket().getPtsD()) {
                    videoFrameWithPacket = next;
                }
            }
            if (videoFrameWithPacket == null) {
                Iterator<AudioFrameWithPacket> it2 = this.audioQueue.iterator();
                while (it2.hasNext()) {
                    AudioFrameWithPacket next2 = it2.next();
                    if (this.audioCopy) {
                        Sink sink = this.sink;
                        if (sink instanceof PacketSink) {
                            ((PacketSink) sink).outputAudioPacket(next2.getPacket(), this.audioCodecMeta);
                        }
                    }
                    this.sink.outputAudioFrame(next2);
                }
                return;
            }
            Iterator<AudioFrameWithPacket> it3 = this.audioQueue.iterator();
            while (it3.hasNext()) {
                AudioFrameWithPacket next3 = it3.next();
                if (next3.getPacket().getPtsD() > videoFrameWithPacket.getPacket().getPtsD()) {
                    break;
                }
                if (this.audioCopy) {
                    Sink sink2 = this.sink;
                    if (sink2 instanceof PacketSink) {
                        ((PacketSink) sink2).outputAudioPacket(next3.getPacket(), this.audioCodecMeta);
                    }
                }
                this.sink.outputAudioFrame(next3);
            }
            Iterator<VideoFrameWithPacket> it4 = this.videoQueue.iterator();
            while (it4.hasNext()) {
                VideoFrameWithPacket next4 = it4.next();
                if (next4 != null) {
                    if (this.videoCopy) {
                        Sink sink3 = this.sink;
                        if (sink3 instanceof PacketSink) {
                            ((PacketSink) sink3).outputVideoPacket(next4.getPacket(), this.videoCodecMeta);
                        }
                    }
                    PixelStore.LoanerPicture loanerPictureFilterFrame = filterFrame(next4);
                    this.sink.outputVideoFrame(new VideoFrameWithPacket(next4.getPacket(), loanerPictureFilterFrame));
                    this.pixelStore.putBack(loanerPictureFilterFrame);
                }
            }
        }

        public boolean hasLeadingAudio() {
            VideoFrameWithPacket videoFrameWithPacket = this.videoQueue.get(0);
            Iterator<AudioFrameWithPacket> it = this.audioQueue.iterator();
            while (it.hasNext()) {
                if (it.next().getPacket().getPtsD() >= videoFrameWithPacket.getPacket().getPtsD() + 0.2d) {
                    return true;
                }
            }
            return false;
        }

        public boolean needsVideoFrame() {
            if (this.videoQueue.size() <= 0) {
                return true;
            }
            return this.videoCopy && this.videoQueue.size() < 5;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x009a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void tryFlushQueues() throws java.io.IOException {
            /*
                r11 = this;
                java.util.LinkedList<org.jcodec.api.transcode.VideoFrameWithPacket> r0 = r11.videoQueue
                int r0 = r0.size()
                if (r0 > 0) goto L9
                return
            L9:
                boolean r0 = r11.videoCopy
                if (r0 == 0) goto L17
                java.util.LinkedList<org.jcodec.api.transcode.VideoFrameWithPacket> r0 = r11.videoQueue
                int r0 = r0.size()
                r1 = 5
                if (r0 >= r1) goto L17
                return
            L17:
                boolean r0 = r11.hasLeadingAudio()
                if (r0 != 0) goto L1e
                return
            L1e:
                java.util.LinkedList<org.jcodec.api.transcode.VideoFrameWithPacket> r0 = r11.videoQueue
                r1 = 0
                java.lang.Object r0 = r0.get(r1)
                org.jcodec.api.transcode.VideoFrameWithPacket r0 = (org.jcodec.api.transcode.VideoFrameWithPacket) r0
                boolean r2 = r11.videoCopy
                if (r2 == 0) goto L53
                java.util.LinkedList<org.jcodec.api.transcode.VideoFrameWithPacket> r2 = r11.videoQueue
                java.util.Iterator r2 = r2.iterator()
            L31:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L53
                java.lang.Object r3 = r2.next()
                org.jcodec.api.transcode.VideoFrameWithPacket r3 = (org.jcodec.api.transcode.VideoFrameWithPacket) r3
                org.jcodec.common.model.Packet r4 = r3.getPacket()
                long r4 = r4.getFrameNo()
                org.jcodec.common.model.Packet r6 = r0.getPacket()
                long r6 = r6.getFrameNo()
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 >= 0) goto L31
                r0 = r3
                goto L31
            L53:
                java.util.LinkedList<org.jcodec.api.transcode.AudioFrameWithPacket> r2 = r11.audioQueue
                int r2 = r2.size()
                r3 = r1
            L5a:
                if (r3 >= r2) goto La2
                java.util.LinkedList<org.jcodec.api.transcode.AudioFrameWithPacket> r4 = r11.audioQueue
                java.lang.Object r4 = r4.get(r1)
                org.jcodec.api.transcode.AudioFrameWithPacket r4 = (org.jcodec.api.transcode.AudioFrameWithPacket) r4
                org.jcodec.common.model.Packet r5 = r4.getPacket()
                double r5 = r5.getPtsD()
                org.jcodec.common.model.Packet r7 = r0.getPacket()
                double r7 = r7.getPtsD()
                r9 = 4596373779694328218(0x3fc999999999999a, double:0.2)
                double r7 = r7 + r9
                int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r5 < 0) goto L7f
                goto La2
            L7f:
                java.util.LinkedList<org.jcodec.api.transcode.AudioFrameWithPacket> r5 = r11.audioQueue
                r5.remove(r1)
                boolean r5 = r11.audioCopy
                if (r5 == 0) goto L9a
                org.jcodec.api.transcode.Sink r5 = r11.sink
                boolean r6 = r5 instanceof org.jcodec.api.transcode.PacketSink
                if (r6 == 0) goto L9a
                org.jcodec.api.transcode.PacketSink r5 = (org.jcodec.api.transcode.PacketSink) r5
                org.jcodec.common.model.Packet r4 = r4.getPacket()
                org.jcodec.common.AudioCodecMeta r6 = r11.audioCodecMeta
                r5.outputAudioPacket(r4, r6)
                goto L9f
            L9a:
                org.jcodec.api.transcode.Sink r5 = r11.sink
                r5.outputAudioFrame(r4)
            L9f:
                int r3 = r3 + 1
                goto L5a
            La2:
                java.util.LinkedList<org.jcodec.api.transcode.VideoFrameWithPacket> r1 = r11.videoQueue
                r1.remove(r0)
                boolean r1 = r11.videoCopy
                if (r1 == 0) goto Lbd
                org.jcodec.api.transcode.Sink r1 = r11.sink
                boolean r2 = r1 instanceof org.jcodec.api.transcode.PacketSink
                if (r2 == 0) goto Lbd
                org.jcodec.api.transcode.PacketSink r1 = (org.jcodec.api.transcode.PacketSink) r1
                org.jcodec.common.model.Packet r0 = r0.getPacket()
                org.jcodec.common.VideoCodecMeta r2 = r11.videoCodecMeta
                r1.outputVideoPacket(r0, r2)
                goto Ld4
            Lbd:
                org.jcodec.api.transcode.PixelStore$LoanerPicture r1 = r11.filterFrame(r0)
                org.jcodec.api.transcode.Sink r2 = r11.sink
                org.jcodec.api.transcode.VideoFrameWithPacket r3 = new org.jcodec.api.transcode.VideoFrameWithPacket
                org.jcodec.common.model.Packet r0 = r0.getPacket()
                r3.<init>(r0, r1)
                r2.outputVideoFrame(r3)
                org.jcodec.api.transcode.PixelStore r0 = r11.pixelStore
                r0.putBack(r1)
            Ld4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jcodec.api.transcode.Transcoder.Stream.tryFlushQueues():void");
        }
    }

    public static class TranscoderBuilder {
        private List<Source> source = new ArrayList();
        private List<Sink> sink = new ArrayList();
        private List<List<Filter>> filters = new ArrayList();
        private IntArrayList seekFrames = new IntArrayList(20);
        private IntArrayList maxFrames = new IntArrayList(20);
        private List<Mapping> videoMappings = new ArrayList();
        private List<Mapping> audioMappings = new ArrayList();

        public TranscoderBuilder addFilter(int i, Filter filter) {
            this.filters.get(i).add(filter);
            return this;
        }

        public TranscoderBuilder addSink(Sink sink) {
            this.sink.add(sink);
            this.videoMappings.add(new Mapping(0, false));
            this.audioMappings.add(new Mapping(0, false));
            this.filters.add(new ArrayList());
            return this;
        }

        public TranscoderBuilder addSource(Source source) {
            this.source.add(source);
            this.seekFrames.add(0);
            this.maxFrames.add(Integer.MAX_VALUE);
            return this;
        }

        public Transcoder create() {
            return new Transcoder((Source[]) this.source.toArray(new Source[0]), (Sink[]) this.sink.toArray(new Sink[0]), (Mapping[]) this.videoMappings.toArray(new Mapping[0]), (Mapping[]) this.audioMappings.toArray(new Mapping[0]), (List[]) this.filters.toArray(new List[0]), this.seekFrames.toArray(), this.maxFrames.toArray());
        }

        public TranscoderBuilder setAudioMapping(int i, int i2, boolean z) {
            this.audioMappings.set(i2, new Mapping(i, z));
            return this;
        }

        public TranscoderBuilder setMaxFrames(int i, int i2) {
            this.maxFrames.set(i, i2);
            return this;
        }

        public TranscoderBuilder setSeekFrames(int i, int i2) {
            this.seekFrames.set(i, i2);
            return this;
        }

        public TranscoderBuilder setVideoMapping(int i, int i2, boolean z) {
            this.videoMappings.set(i2, new Mapping(i, z));
            return this;
        }
    }

    public static TranscoderBuilder newTranscoder() {
        return new TranscoderBuilder();
    }

    private void printLegend(int i, int i2, Packet packet) {
        if (i % 100 == 0) {
            System.out.print(String.format("[%6d]\r", Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x01bd A[Catch: all -> 0x02bf, TryCatch #0 {all -> 0x02bf, blocks: (B:32:0x0130, B:34:0x0135, B:38:0x013f, B:39:0x0145, B:41:0x014b, B:43:0x0157, B:45:0x015d, B:50:0x0166, B:53:0x016b, B:55:0x0173, B:71:0x01b9, B:73:0x01bd, B:74:0x01c3, B:76:0x01c9, B:79:0x01d4, B:81:0x01e2, B:84:0x01ee, B:85:0x01f4, B:87:0x01fa, B:88:0x0208, B:90:0x020e, B:92:0x0219, B:94:0x0221, B:96:0x0225, B:99:0x022a, B:101:0x0233, B:107:0x0248, B:108:0x024e, B:110:0x0254, B:112:0x0264, B:102:0x0237, B:103:0x023e, B:105:0x0244, B:111:0x0262, B:57:0x0178, B:59:0x017c, B:62:0x0181, B:64:0x018a, B:66:0x0193, B:65:0x018d, B:67:0x0199, B:69:0x019f, B:70:0x01a2, B:116:0x0272, B:118:0x027f, B:120:0x0284, B:124:0x0292), top: B:146:0x0130 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ee A[Catch: all -> 0x02bf, TryCatch #0 {all -> 0x02bf, blocks: (B:32:0x0130, B:34:0x0135, B:38:0x013f, B:39:0x0145, B:41:0x014b, B:43:0x0157, B:45:0x015d, B:50:0x0166, B:53:0x016b, B:55:0x0173, B:71:0x01b9, B:73:0x01bd, B:74:0x01c3, B:76:0x01c9, B:79:0x01d4, B:81:0x01e2, B:84:0x01ee, B:85:0x01f4, B:87:0x01fa, B:88:0x0208, B:90:0x020e, B:92:0x0219, B:94:0x0221, B:96:0x0225, B:99:0x022a, B:101:0x0233, B:107:0x0248, B:108:0x024e, B:110:0x0254, B:112:0x0264, B:102:0x0237, B:103:0x023e, B:105:0x0244, B:111:0x0262, B:57:0x0178, B:59:0x017c, B:62:0x0181, B:64:0x018a, B:66:0x0193, B:65:0x018d, B:67:0x0199, B:69:0x019f, B:70:0x01a2, B:116:0x0272, B:118:0x027f, B:120:0x0284, B:124:0x0292), top: B:146:0x0130 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void transcode() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 735
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jcodec.api.transcode.Transcoder.transcode():void");
    }

    private Transcoder(Source[] sourceArr, Sink[] sinkArr, Mapping[] mappingArr, Mapping[] mappingArr2, List<Filter>[] listArr, int[] iArr, int[] iArr2) {
        this.extraFilters = listArr;
        this.videoMappings = mappingArr;
        this.audioMappings = mappingArr2;
        this.seekFrames = iArr;
        this.maxFrames = iArr2;
        this.sources = sourceArr;
        this.sinks = sinkArr;
    }
}
