package org.jcodec.containers.imgseq;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.Codec;
import org.jcodec.common.Demuxer;
import org.jcodec.common.DemuxerTrack;
import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.TrackType;
import org.jcodec.common.io.NIOUtils;
import org.jcodec.common.logging.Logger;
import org.jcodec.common.model.Packet;

/* loaded from: classes2.dex */
public class ImageSequenceDemuxer implements Demuxer, DemuxerTrack {
    private static final int MAX_MAX = 5184000;
    private static final int VIDEO_FPS = 25;
    private Codec codec;
    private int frameNo;
    private int maxFrames;
    private String namePattern;
    private String prevName;
    private int maxAvailableFrame = -1;
    private Packet curFrame = loadFrame();

    public ImageSequenceDemuxer(String str, int i) throws IOException {
        this.namePattern = str;
        this.maxFrames = i;
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(".png")) {
            this.codec = Codec.PNG;
        } else if (lowerCase.endsWith(".jpg") || lowerCase.endsWith(".jpeg")) {
            this.codec = Codec.JPEG;
        }
    }

    private Packet loadFrame() throws IOException {
        File file;
        int i;
        int i2;
        if (this.frameNo > this.maxFrames) {
            return null;
        }
        do {
            String str = String.format(this.namePattern, Integer.valueOf(this.frameNo));
            if (str.equals(this.prevName)) {
                return null;
            }
            this.prevName = str;
            file = new File(str);
            if (file.exists() || (i = this.frameNo) > 0) {
                break;
            }
            i2 = i + 1;
            this.frameNo = i2;
        } while (i2 < 2);
        if (!file.exists()) {
            return null;
        }
        ByteBuffer byteBufferFetchFromFile = NIOUtils.fetchFromFile(file);
        int i3 = this.frameNo;
        Packet packet = new Packet(byteBufferFetchFromFile, i3, 25, 1L, i3, Packet.FrameType.KEY, null, i3);
        this.frameNo++;
        return packet;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getAudioTracks() {
        return new ArrayList();
    }

    public int getMaxAvailableFrame() {
        if (this.maxAvailableFrame == -1) {
            int i = MAX_MAX;
            while (true) {
                if (i <= 0) {
                    i = 0;
                    break;
                }
                if (new File(String.format(this.namePattern, Integer.valueOf(i))).exists()) {
                    break;
                }
                i /= 2;
            }
            for (int i2 = i / 2; i2 > 1; i2 /= 2) {
                int i3 = i + i2;
                if (new File(String.format(this.namePattern, Integer.valueOf(i3))).exists()) {
                    i = i3;
                }
            }
            this.maxAvailableFrame = i;
            Logger.info("Max frame found: " + this.maxAvailableFrame);
        }
        return Math.min(this.maxAvailableFrame, this.maxFrames);
    }

    @Override // org.jcodec.common.DemuxerTrack
    public DemuxerTrackMeta getMeta() {
        return new DemuxerTrackMeta(TrackType.VIDEO, this.codec, r7 * 25, null, getMaxAvailableFrame() + 1, null, null, null);
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getTracks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        return arrayList;
    }

    @Override // org.jcodec.common.Demuxer
    public List<? extends DemuxerTrack> getVideoTracks() {
        return getTracks();
    }

    @Override // org.jcodec.common.DemuxerTrack
    public Packet nextFrame() throws IOException {
        try {
            return this.curFrame;
        } finally {
            this.curFrame = loadFrame();
        }
    }
}
