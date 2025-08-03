package org.jcodec.containers.flv;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.jcodec.codecs.h264.H264Utils;
import org.jcodec.codecs.h264.io.model.PictureParameterSet;
import org.jcodec.codecs.h264.io.model.SeqParameterSet;
import org.jcodec.codecs.h264.mp4.AvcCBox;
import org.jcodec.common.AudioFormat;
import org.jcodec.common.Codec;
import org.jcodec.common.StringUtils;
import org.jcodec.common.io.FileChannelWrapper;
import org.jcodec.common.io.IOUtils;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.tools.MainUtils;
import org.jcodec.containers.flv.FLVTag;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class FLVTool {
    private static final MainUtils.Flag FLAG_MAX_PACKETS;
    private static Map<String, PacketProcessorFactory> processors;

    public static class ClipPacketProcessor implements PacketProcessor {
        private static final MainUtils.Flag FLAG_FROM = MainUtils.Flag.flag(TypedValues.TransitionType.S_FROM, null, "From timestamp (in seconds, i.e 67.49)");
        private static final MainUtils.Flag FLAG_TO = MainUtils.Flag.flag(TypedValues.TransitionType.S_TO, null, "To timestamp");
        private static FLVTag h264Config;
        private boolean copying = false;
        private Double from;
        private Double to;

        public static class Factory implements PacketProcessorFactory {
            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public MainUtils.Flag[] getFlags() {
                return new MainUtils.Flag[]{ClipPacketProcessor.FLAG_FROM, ClipPacketProcessor.FLAG_TO};
            }

            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public PacketProcessor newPacketProcessor(MainUtils.Cmd cmd) {
                return new ClipPacketProcessor(cmd.getDoubleFlag(ClipPacketProcessor.FLAG_FROM), cmd.getDoubleFlag(ClipPacketProcessor.FLAG_TO));
            }
        }

        public ClipPacketProcessor(Double d, Double d2) {
            this.from = d;
            this.to = d2;
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public void finish(FLVWriter fLVWriter) {
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean hasOutput() {
            return true;
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean processPacket(FLVTag fLVTag, FLVWriter fLVWriter) throws IOException {
            FLVTag.Type type = fLVTag.getType();
            FLVTag.Type type2 = FLVTag.Type.VIDEO;
            if (type == type2 && fLVTag.getTagHeader().getCodec() == Codec.H264 && ((FLVTag.AvcVideoTagHeader) fLVTag.getTagHeader()).getAvcPacketType() == 0) {
                h264Config = fLVTag;
                System.out.println("GOT AVCC");
            }
            if (!this.copying && ((this.from == null || fLVTag.getPtsD() > this.from.doubleValue()) && fLVTag.getType() == type2 && fLVTag.isKeyFrame() && h264Config != null)) {
                System.out.println("Starting at packet: " + Platform.toJSON(fLVTag));
                this.copying = true;
                h264Config.setPts(fLVTag.getPts());
                fLVWriter.addPacket(h264Config);
            }
            if (this.to == null || fLVTag.getPtsD() < this.to.doubleValue()) {
                if (this.copying) {
                    fLVWriter.addPacket(fLVTag);
                }
                return true;
            }
            System.out.println("Stopping at packet: " + Platform.toJSON(fLVTag));
            return false;
        }
    }

    public static class FixPtsProcessor implements PacketProcessor {
        private static final double CORRECTION_PACE = 0.33d;
        private int audioTagsInQueue;
        private double lastPtsAudio = 0.0d;
        private double lastPtsVideo = 0.0d;
        private List<FLVTag> tags = new ArrayList();
        private int videoTagsInQueue;

        public static class Factory implements PacketProcessorFactory {
            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public MainUtils.Flag[] getFlags() {
                return new MainUtils.Flag[0];
            }

            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public PacketProcessor newPacketProcessor(MainUtils.Cmd cmd) {
                return new FixPtsProcessor();
            }
        }

        private double audioFrameDuration(FLVTag.AudioTagHeader audioTagHeader) {
            double d;
            int sampleRate;
            if (Codec.AAC == audioTagHeader.getCodec()) {
                d = 1024.0d;
                sampleRate = audioTagHeader.getAudioFormat().getSampleRate();
            } else {
                if (Codec.MP3 != audioTagHeader.getCodec()) {
                    throw new RuntimeException("Audio codec:" + audioTagHeader.getCodec() + " is not supported.");
                }
                d = 1152.0d;
                sampleRate = audioTagHeader.getAudioFormat().getSampleRate();
            }
            return d / sampleRate;
        }

        private void processOneTag(FLVWriter fLVWriter) throws IOException {
            FLVTag fLVTagRemove = this.tags.remove(0);
            if (fLVTagRemove.getType() == FLVTag.Type.AUDIO) {
                fLVTagRemove.setPts((int) Math.round(this.lastPtsAudio * 1000.0d));
                this.lastPtsAudio += audioFrameDuration((FLVTag.AudioTagHeader) fLVTagRemove.getTagHeader());
                this.audioTagsInQueue--;
            } else if (fLVTagRemove.getType() == FLVTag.Type.VIDEO) {
                double d = (this.audioTagsInQueue * 1024.0d) / (this.videoTagsInQueue * 48000);
                fLVTagRemove.setPts((int) Math.round(this.lastPtsVideo * 1000.0d));
                double d2 = this.lastPtsVideo;
                this.lastPtsVideo = d2 + Math.min(1.33d * d, Math.max(0.6699999999999999d * d, d + (Math.min(1.0d, Math.abs(this.lastPtsAudio - d2)) * (this.lastPtsAudio - this.lastPtsVideo))));
                this.videoTagsInQueue--;
                System.out.println(this.lastPtsVideo + " - " + this.lastPtsAudio);
            } else {
                fLVTagRemove.setPts((int) Math.round(this.lastPtsVideo * 1000.0d));
            }
            fLVWriter.addPacket(fLVTagRemove);
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public void finish(FLVWriter fLVWriter) throws IOException {
            while (this.tags.size() > 0) {
                processOneTag(fLVWriter);
            }
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean hasOutput() {
            return true;
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean processPacket(FLVTag fLVTag, FLVWriter fLVWriter) throws IOException {
            this.tags.add(fLVTag);
            if (fLVTag.getType() == FLVTag.Type.AUDIO) {
                this.audioTagsInQueue++;
            } else if (fLVTag.getType() == FLVTag.Type.VIDEO) {
                this.videoTagsInQueue++;
            }
            if (this.tags.size() < 600) {
                return true;
            }
            processOneTag(fLVWriter);
            return true;
        }
    }

    public static class InfoPacketProcessor implements PacketProcessor {
        private boolean checkOnly;
        private FLVTag prevAudioTag;
        private FLVTag prevVideoTag;
        private FLVTag.Type streamType;

        public static class Factory implements PacketProcessorFactory {
            private static final MainUtils.Flag FLAG_CHECK = MainUtils.Flag.flag("check", null, "Check sanity and report errors only, no packet dump will be generated.");
            private static final MainUtils.Flag FLAG_STREAM = MainUtils.Flag.flag("stream", null, "Stream selector, can be one of: ['video', 'audio', 'script'].");

            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public MainUtils.Flag[] getFlags() {
                return new MainUtils.Flag[]{FLAG_CHECK, FLAG_STREAM};
            }

            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public PacketProcessor newPacketProcessor(MainUtils.Cmd cmd) {
                return new InfoPacketProcessor(cmd.getBooleanFlagD(FLAG_CHECK, Boolean.FALSE).booleanValue(), (FLVTag.Type) cmd.getEnumFlagD(FLAG_STREAM, null, FLVTag.Type.class));
            }
        }

        public InfoPacketProcessor(boolean z, FLVTag.Type type) {
            this.checkOnly = z;
            this.streamType = type;
        }

        private void dumpOnePacket(FLVTag fLVTag, int i) {
            FLVMetadata metadata;
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("T=");
            sb.append(typeString(fLVTag.getType()));
            sb.append("|PTS=");
            sb.append(fLVTag.getPts());
            sb.append("|DUR=");
            sb.append(i);
            sb.append("|");
            sb.append(fLVTag.isKeyFrame() ? "K" : MyUTIL.white_space);
            sb.append("|POS=");
            sb.append(fLVTag.getPosition());
            printStream.print(sb.toString());
            if (fLVTag.getTagHeader() instanceof FLVTag.VideoTagHeader) {
                FLVTag.VideoTagHeader videoTagHeader = (FLVTag.VideoTagHeader) fLVTag.getTagHeader();
                System.out.print("|C=" + videoTagHeader.getCodec() + "|FT=" + videoTagHeader.getFrameType());
                if (videoTagHeader instanceof FLVTag.AvcVideoTagHeader) {
                    FLVTag.AvcVideoTagHeader avcVideoTagHeader = (FLVTag.AvcVideoTagHeader) videoTagHeader;
                    System.out.print("|PKT_TYPE=" + ((int) avcVideoTagHeader.getAvcPacketType()) + "|COMP_OFF=" + avcVideoTagHeader.getCompOffset());
                    if (avcVideoTagHeader.getAvcPacketType() == 0) {
                        ByteBuffer byteBufferDuplicate = fLVTag.getData().duplicate();
                        FLVReader.parseVideoTagHeader(byteBufferDuplicate);
                        AvcCBox aVCCFromBuffer = H264Utils.parseAVCCFromBuffer(byteBufferDuplicate);
                        for (SeqParameterSet seqParameterSet : H264Utils.readSPSFromBufferList(aVCCFromBuffer.getSpsList())) {
                            System.out.println();
                            System.out.print("  SPS[" + seqParameterSet.getSeqParameterSetId() + "]:" + Platform.toJSON(seqParameterSet));
                        }
                        for (PictureParameterSet pictureParameterSet : H264Utils.readPPSFromBufferList(aVCCFromBuffer.getPpsList())) {
                            System.out.println();
                            System.out.print("  PPS[" + pictureParameterSet.getPicParameterSetId() + "]:" + Platform.toJSON(pictureParameterSet));
                        }
                    }
                }
            } else if (fLVTag.getTagHeader() instanceof FLVTag.AudioTagHeader) {
                FLVTag.AudioTagHeader audioTagHeader = (FLVTag.AudioTagHeader) fLVTag.getTagHeader();
                AudioFormat audioFormat = audioTagHeader.getAudioFormat();
                System.out.print("|C=" + audioTagHeader.getCodec() + "|SR=" + audioFormat.getSampleRate() + "|SS=" + (audioFormat.getSampleSizeInBits() >> 3) + "|CH=" + audioFormat.getChannels());
            } else if (fLVTag.getType() == FLVTag.Type.SCRIPT && (metadata = FLVReader.parseMetadata(fLVTag.getData().duplicate())) != null) {
                System.out.println();
                System.out.print("  Metadata:" + Platform.toJSON(metadata));
            }
            System.out.println();
        }

        private String typeString(FLVTag.Type type) {
            return type.toString().substring(0, 1);
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public void finish(FLVWriter fLVWriter) throws IOException {
            FLVTag fLVTag = this.prevVideoTag;
            if (fLVTag != null) {
                dumpOnePacket(fLVTag, 0);
            }
            FLVTag fLVTag2 = this.prevAudioTag;
            if (fLVTag2 != null) {
                dumpOnePacket(fLVTag2, 0);
            }
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean hasOutput() {
            return false;
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean processPacket(FLVTag fLVTag, FLVWriter fLVWriter) throws IOException {
            if (this.checkOnly) {
                return true;
            }
            FLVTag.Type type = fLVTag.getType();
            FLVTag.Type type2 = FLVTag.Type.VIDEO;
            if (type == type2) {
                FLVTag.Type type3 = this.streamType;
                if (type3 == type2 || type3 == null) {
                    FLVTag fLVTag2 = this.prevVideoTag;
                    if (fLVTag2 != null) {
                        dumpOnePacket(fLVTag2, fLVTag.getPts() - this.prevVideoTag.getPts());
                    }
                    this.prevVideoTag = fLVTag;
                }
            } else {
                FLVTag.Type type4 = fLVTag.getType();
                FLVTag.Type type5 = FLVTag.Type.AUDIO;
                if (type4 == type5) {
                    FLVTag.Type type6 = this.streamType;
                    if (type6 == type5 || type6 == null) {
                        FLVTag fLVTag3 = this.prevAudioTag;
                        if (fLVTag3 != null) {
                            dumpOnePacket(fLVTag3, fLVTag.getPts() - this.prevAudioTag.getPts());
                        }
                        this.prevAudioTag = fLVTag;
                    }
                } else {
                    dumpOnePacket(fLVTag, 0);
                }
            }
            return true;
        }
    }

    public interface PacketProcessor {
        void finish(FLVWriter fLVWriter) throws IOException;

        boolean hasOutput();

        boolean processPacket(FLVTag fLVTag, FLVWriter fLVWriter) throws IOException;
    }

    public interface PacketProcessorFactory {
        MainUtils.Flag[] getFlags();

        PacketProcessor newPacketProcessor(MainUtils.Cmd cmd);
    }

    public static class ShiftPtsProcessor implements PacketProcessor {
        private static final int HALF_WRAP_AROUND_VALUE = 1073741824;
        private static final long WRAP_AROUND_VALUE = 2147483648L;
        private boolean firstPtsSeen;
        private int prevPts;
        private long ptsDelta;
        private Integer shiftBy;
        private int shiftTo;
        private static final MainUtils.Flag FLAG_TO = MainUtils.Flag.flag(TypedValues.TransitionType.S_TO, null, "Shift first pts to this value, and all subsequent pts accordingly.");
        private static final MainUtils.Flag FLAG_BY = MainUtils.Flag.flag("by", null, "Shift all pts by this value.");
        private static final MainUtils.Flag FLAG_WRAP_AROUND = MainUtils.Flag.flag("wrap-around", null, "Expect wrap around of timestamps.");
        private List<FLVTag> savedTags = new LinkedList();
        private boolean expectWrapAround = true;

        public static class Factory implements PacketProcessorFactory {
            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public MainUtils.Flag[] getFlags() {
                return new MainUtils.Flag[]{ShiftPtsProcessor.FLAG_TO, ShiftPtsProcessor.FLAG_BY, ShiftPtsProcessor.FLAG_WRAP_AROUND};
            }

            @Override // org.jcodec.containers.flv.FLVTool.PacketProcessorFactory
            public PacketProcessor newPacketProcessor(MainUtils.Cmd cmd) {
                return new ShiftPtsProcessor(cmd.getIntegerFlagD(ShiftPtsProcessor.FLAG_TO, 0).intValue(), cmd.getIntegerFlag(ShiftPtsProcessor.FLAG_BY), cmd.getBooleanFlagD(ShiftPtsProcessor.FLAG_WRAP_AROUND, Boolean.FALSE).booleanValue());
            }
        }

        public ShiftPtsProcessor(int i, Integer num, boolean z) {
            this.shiftTo = i;
            this.shiftBy = num;
        }

        private void emptySavedTags(FLVWriter fLVWriter) throws IOException {
            while (this.savedTags.size() > 0) {
                writePacket(this.savedTags.remove(0), fLVWriter);
            }
        }

        private void writePacket(FLVTag fLVTag, FLVWriter fLVWriter) throws IOException {
            long pts = fLVTag.getPts() + this.ptsDelta;
            if (pts < 0) {
                Logger.warn("Preventing negative pts for tag @" + fLVTag.getPosition());
                pts = this.shiftBy != null ? 0L : this.shiftTo;
            } else if (pts >= WRAP_AROUND_VALUE) {
                Logger.warn("PTS wrap around @" + fLVTag.getPosition());
                pts -= WRAP_AROUND_VALUE;
                this.ptsDelta = pts - ((long) fLVTag.getPts());
            }
            fLVTag.setPts((int) pts);
            fLVWriter.addPacket(fLVTag);
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public void finish(FLVWriter fLVWriter) throws IOException {
            emptySavedTags(fLVWriter);
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean hasOutput() {
            return true;
        }

        @Override // org.jcodec.containers.flv.FLVTool.PacketProcessor
        public boolean processPacket(FLVTag fLVTag, FLVWriter fLVWriter) throws IOException {
            boolean z = false;
            boolean z2 = fLVTag.getType() == FLVTag.Type.VIDEO && ((FLVTag.VideoTagHeader) fLVTag.getTagHeader()).getCodec() == Codec.H264 && ((FLVTag.AvcVideoTagHeader) fLVTag.getTagHeader()).getAvcPacketType() == 0;
            boolean z3 = fLVTag.getType() == FLVTag.Type.AUDIO && ((FLVTag.AudioTagHeader) fLVTag.getTagHeader()).getCodec() == Codec.AAC && ((FLVTag.AacAudioTagHeader) fLVTag.getTagHeader()).getPacketType() == 0;
            if (fLVTag.getType() != FLVTag.Type.SCRIPT && !z2 && !z3) {
                z = true;
            }
            if (this.expectWrapAround && z) {
                int pts = fLVTag.getPts();
                int i = this.prevPts;
                if (pts < i && i - fLVTag.getPts() > 1073741824) {
                    Logger.warn("Wrap around detected: " + this.prevPts + " -> " + fLVTag.getPts());
                    if (fLVTag.getPts() < -1073741824) {
                        this.ptsDelta += 4294967296L;
                    } else if (fLVTag.getPts() >= 0) {
                        this.ptsDelta += WRAP_AROUND_VALUE;
                    }
                }
            }
            if (z) {
                this.prevPts = fLVTag.getPts();
            }
            if (this.firstPtsSeen) {
                writePacket(fLVTag, fLVWriter);
            } else if (z) {
                Integer num = this.shiftBy;
                if (num != null) {
                    long jIntValue = num.intValue();
                    this.ptsDelta = jIntValue;
                    if (jIntValue + fLVTag.getPts() < 0) {
                        this.ptsDelta = -fLVTag.getPts();
                    }
                } else {
                    this.ptsDelta = this.shiftTo - fLVTag.getPts();
                }
                this.firstPtsSeen = true;
                emptySavedTags(fLVWriter);
                writePacket(fLVTag, fLVWriter);
            } else {
                this.savedTags.add(fLVTag);
            }
            return true;
        }
    }

    static {
        HashMap map = new HashMap();
        processors = map;
        map.put("clip", new ClipPacketProcessor.Factory());
        processors.put("fix_pts", new FixPtsProcessor.Factory());
        processors.put("info", new InfoPacketProcessor.Factory());
        processors.put("shift_pts", new ShiftPtsProcessor.Factory());
        FLAG_MAX_PACKETS = MainUtils.Flag.flag("max-packets", "m", "Maximum number of packets to process");
    }

    private static PacketProcessor getProcessor(String str, MainUtils.Cmd cmd) {
        PacketProcessorFactory packetProcessorFactory = processors.get(str);
        if (packetProcessorFactory == null) {
            return null;
        }
        return packetProcessorFactory.newPacketProcessor(cmd);
    }

    public static void main1(String[] strArr) throws Throwable {
        FileChannelWrapper fileChannelWrapper;
        if (strArr.length < 1) {
            printGenericHelp();
            return;
        }
        String str = strArr[0];
        PacketProcessorFactory packetProcessorFactory = processors.get(str);
        if (packetProcessorFactory == null) {
            System.err.println("Unknown command: " + str);
            printGenericHelp();
            return;
        }
        MainUtils.Cmd arguments = MainUtils.parseArguments((String[]) Platform.copyOfRangeO(strArr, 1, strArr.length), packetProcessorFactory.getFlags());
        if (arguments.args.length < 1) {
            MainUtils.printHelpCmd(str, packetProcessorFactory.getFlags(), Arrays.asList("file in", "?file out"));
            return;
        }
        PacketProcessor packetProcessorNewPacketProcessor = packetProcessorFactory.newPacketProcessor(arguments);
        int iIntValue = arguments.getIntegerFlagD(FLAG_MAX_PACKETS, Integer.MAX_VALUE).intValue();
        try {
            FileChannelWrapper fileChannelWrapper2 = NIOUtils.readableChannel(new File(arguments.getArg(0)));
            try {
                fileChannelWrapperWritableChannel = packetProcessorNewPacketProcessor.hasOutput() ? NIOUtils.writableChannel(new File(arguments.getArg(1))) : null;
                FLVReader fLVReader = new FLVReader(fileChannelWrapper2);
                FLVWriter fLVWriter = new FLVWriter(fileChannelWrapperWritableChannel);
                for (int i = 0; i < iIntValue; i++) {
                    FLVTag nextPacket = fLVReader.readNextPacket();
                    if (nextPacket == null || !packetProcessorNewPacketProcessor.processPacket(nextPacket, fLVWriter)) {
                        break;
                    }
                }
                packetProcessorNewPacketProcessor.finish(fLVWriter);
                if (packetProcessorNewPacketProcessor.hasOutput()) {
                    fLVWriter.finish();
                }
                IOUtils.closeQuietly(fileChannelWrapper2);
                IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
            } catch (Throwable th) {
                th = th;
                fileChannelWrapper = fileChannelWrapperWritableChannel;
                fileChannelWrapperWritableChannel = fileChannelWrapper2;
                IOUtils.closeQuietly(fileChannelWrapperWritableChannel);
                IOUtils.closeQuietly(fileChannelWrapper);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannelWrapper = null;
        }
    }

    private static void printGenericHelp() {
        System.err.println("Syntax: <command> [flags] <file in> [file out]\nWhere command is: [" + StringUtils.joinS(processors.keySet().toArray(new String[0]), ", ") + "].");
    }
}
