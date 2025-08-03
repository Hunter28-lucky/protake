package org.jcodec.common.model;

import com.xiaomi.mipush.sdk.Constants;
import org.jcodec.common.StringUtils;

/* loaded from: classes2.dex */
public class TapeTimecode {
    public static final TapeTimecode ZERO_TAPE_TIMECODE = new TapeTimecode(0, (byte) 0, (byte) 0, (byte) 0, false, 0);
    private final boolean dropFrame;
    private final byte frame;
    private final short hour;
    private final byte minute;
    private final byte second;
    private final int tapeFps;

    public TapeTimecode(short s, byte b, byte b2, byte b3, boolean z, int i) {
        this.hour = s;
        this.minute = b;
        this.second = b2;
        this.frame = b3;
        this.dropFrame = z;
        this.tapeFps = i;
    }

    public static TapeTimecode tapeTimecode(long j, boolean z, int i) {
        if (z) {
            j += ((j / 17982) * 18) + ((((j % 17982) - 2) / 1798) * 2);
        }
        long j2 = j / i;
        return new TapeTimecode((short) (j2 / 3600), (byte) ((j2 / 60) % 60), (byte) (j2 % 60), (byte) (j % r0), z, i);
    }

    public byte getFrame() {
        return this.frame;
    }

    public short getHour() {
        return this.hour;
    }

    public byte getMinute() {
        return this.minute;
    }

    public byte getSecond() {
        return this.second;
    }

    public int getTapeFps() {
        return this.tapeFps;
    }

    public boolean isDropFrame() {
        return this.dropFrame;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.zeroPad2(this.hour));
        String str = Constants.COLON_SEPARATOR;
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(StringUtils.zeroPad2(this.minute));
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(StringUtils.zeroPad2(this.second));
        if (this.dropFrame) {
            str = ";";
        }
        sb.append(str);
        sb.append(StringUtils.zeroPad2(this.frame));
        return sb.toString();
    }
}
