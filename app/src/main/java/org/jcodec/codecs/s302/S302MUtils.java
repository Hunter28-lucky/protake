package org.jcodec.codecs.s302;

import org.jcodec.common.model.ChannelLabel;

/* loaded from: classes2.dex */
public class S302MUtils {
    public static ChannelLabel[] labels(int i) {
        if (i == 1) {
            return new ChannelLabel[]{ChannelLabel.MONO};
        }
        if (i == 2) {
            return new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT};
        }
        if (i == 4) {
            return new ChannelLabel[]{ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT};
        }
        if (i != 8) {
            return null;
        }
        return new ChannelLabel[]{ChannelLabel.STEREO_LEFT, ChannelLabel.STEREO_RIGHT, ChannelLabel.FRONT_LEFT, ChannelLabel.FRONT_RIGHT, ChannelLabel.REAR_LEFT, ChannelLabel.REAR_RIGHT, ChannelLabel.CENTER, ChannelLabel.LFE};
    }

    public static String name(int i) {
        if (i == 1) {
            return "Mono";
        }
        if (i == 2) {
            return "Stereo 2.0";
        }
        if (i == 4) {
            return "Surround 4.0";
        }
        if (i != 8) {
            return null;
        }
        return "Stereo 2.0 + Surround 5.1";
    }
}
