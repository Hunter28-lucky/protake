package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class TrackFragmentBaseMediaDecodeTimeBox extends FullBox {
    private long baseMediaDecodeTime;

    public static class Factory {
        private TrackFragmentBaseMediaDecodeTimeBox box;

        public Factory(TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox) {
            TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBoxCreateTrackFragmentBaseMediaDecodeTimeBox = TrackFragmentBaseMediaDecodeTimeBox.createTrackFragmentBaseMediaDecodeTimeBox(trackFragmentBaseMediaDecodeTimeBox.baseMediaDecodeTime);
            this.box = trackFragmentBaseMediaDecodeTimeBoxCreateTrackFragmentBaseMediaDecodeTimeBox;
            trackFragmentBaseMediaDecodeTimeBoxCreateTrackFragmentBaseMediaDecodeTimeBox.version = trackFragmentBaseMediaDecodeTimeBox.version;
            trackFragmentBaseMediaDecodeTimeBoxCreateTrackFragmentBaseMediaDecodeTimeBox.flags = trackFragmentBaseMediaDecodeTimeBox.flags;
        }

        public Factory baseMediaDecodeTime(long j) {
            this.box.baseMediaDecodeTime = j;
            return this;
        }

        public TrackFragmentBaseMediaDecodeTimeBox create() {
            try {
                return this.box;
            } finally {
                this.box = null;
            }
        }
    }

    public TrackFragmentBaseMediaDecodeTimeBox(Header header) {
        super(header);
    }

    public static Factory copy(TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox) {
        return new Factory(trackFragmentBaseMediaDecodeTimeBox);
    }

    public static TrackFragmentBaseMediaDecodeTimeBox createTrackFragmentBaseMediaDecodeTimeBox(long j) {
        TrackFragmentBaseMediaDecodeTimeBox trackFragmentBaseMediaDecodeTimeBox = new TrackFragmentBaseMediaDecodeTimeBox(new Header(fourcc()));
        trackFragmentBaseMediaDecodeTimeBox.baseMediaDecodeTime = j;
        if (j > 2147483647L) {
            trackFragmentBaseMediaDecodeTimeBox.version = (byte) 1;
        }
        return trackFragmentBaseMediaDecodeTimeBox;
    }

    public static String fourcc() {
        return "tfdt";
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void doWrite(ByteBuffer byteBuffer) {
        super.doWrite(byteBuffer);
        byte b = this.version;
        if (b == 0) {
            byteBuffer.putInt((int) this.baseMediaDecodeTime);
        } else {
            if (b != 1) {
                throw new RuntimeException("Unsupported tfdt version");
            }
            byteBuffer.putLong(this.baseMediaDecodeTime);
        }
    }

    @Override // org.jcodec.containers.mp4.boxes.Box
    public int estimateSize() {
        return 20;
    }

    public long getBaseMediaDecodeTime() {
        return this.baseMediaDecodeTime;
    }

    @Override // org.jcodec.containers.mp4.boxes.FullBox, org.jcodec.containers.mp4.boxes.Box
    public void parse(ByteBuffer byteBuffer) {
        super.parse(byteBuffer);
        byte b = this.version;
        if (b == 0) {
            this.baseMediaDecodeTime = byteBuffer.getInt();
        } else {
            if (b != 1) {
                throw new RuntimeException("Unsupported tfdt version");
            }
            this.baseMediaDecodeTime = byteBuffer.getLong();
        }
    }

    public void setBaseMediaDecodeTime(long j) {
        this.baseMediaDecodeTime = j;
    }
}
