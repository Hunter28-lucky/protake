package net.sourceforge.jaad.aac;

/* loaded from: classes2.dex */
public final class ChannelConfiguration {
    private final int chCount;
    private final String descr;
    public static final ChannelConfiguration CHANNEL_CONFIG_UNSUPPORTED = new ChannelConfiguration(-1, "invalid");
    public static final ChannelConfiguration CHANNEL_CONFIG_NONE = new ChannelConfiguration(0, "No channel");
    public static final ChannelConfiguration CHANNEL_CONFIG_MONO = new ChannelConfiguration(1, "Mono");
    public static final ChannelConfiguration CHANNEL_CONFIG_STEREO = new ChannelConfiguration(2, "Stereo");
    public static final ChannelConfiguration CHANNEL_CONFIG_STEREO_PLUS_CENTER = new ChannelConfiguration(3, "Stereo+Center");
    public static final ChannelConfiguration CHANNEL_CONFIG_STEREO_PLUS_CENTER_PLUS_REAR_MONO = new ChannelConfiguration(4, "Stereo+Center+Rear");
    public static final ChannelConfiguration CHANNEL_CONFIG_FIVE = new ChannelConfiguration(5, "Five channels");
    public static final ChannelConfiguration CHANNEL_CONFIG_FIVE_PLUS_ONE = new ChannelConfiguration(6, "Five channels+LF");
    public static final ChannelConfiguration CHANNEL_CONFIG_SEVEN_PLUS_ONE = new ChannelConfiguration(8, "Seven channels+LF");

    private ChannelConfiguration(int i, String str) {
        this.chCount = i;
        this.descr = str;
    }

    public static ChannelConfiguration forInt(int i) {
        switch (i) {
            case 0:
                return CHANNEL_CONFIG_NONE;
            case 1:
                return CHANNEL_CONFIG_MONO;
            case 2:
                return CHANNEL_CONFIG_STEREO;
            case 3:
                return CHANNEL_CONFIG_STEREO_PLUS_CENTER;
            case 4:
                return CHANNEL_CONFIG_STEREO_PLUS_CENTER_PLUS_REAR_MONO;
            case 5:
                return CHANNEL_CONFIG_FIVE;
            case 6:
                return CHANNEL_CONFIG_FIVE_PLUS_ONE;
            case 7:
            case 8:
                return CHANNEL_CONFIG_SEVEN_PLUS_ONE;
            default:
                return CHANNEL_CONFIG_UNSUPPORTED;
        }
    }

    public int getChannelCount() {
        return this.chCount;
    }

    public String getDescription() {
        return this.descr;
    }

    public String toString() {
        return this.descr;
    }
}
