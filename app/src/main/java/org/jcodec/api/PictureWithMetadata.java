package org.jcodec.api;

import org.jcodec.common.DemuxerTrackMeta;
import org.jcodec.common.model.Picture;

/* loaded from: classes2.dex */
public class PictureWithMetadata {
    private double duration;
    private DemuxerTrackMeta.Orientation orientation;
    private Picture picture;
    private double timestamp;

    public PictureWithMetadata(Picture picture, double d, double d2, DemuxerTrackMeta.Orientation orientation) {
        this.picture = picture;
        this.timestamp = d;
        this.duration = d2;
        this.orientation = orientation;
    }

    public static PictureWithMetadata createPictureWithMetadata(Picture picture, double d, double d2) {
        return new PictureWithMetadata(picture, d, d2, DemuxerTrackMeta.Orientation.D_0);
    }

    public double getDuration() {
        return this.duration;
    }

    public DemuxerTrackMeta.Orientation getOrientation() {
        return this.orientation;
    }

    public Picture getPicture() {
        return this.picture;
    }

    public double getTimestamp() {
        return this.timestamp;
    }
}
