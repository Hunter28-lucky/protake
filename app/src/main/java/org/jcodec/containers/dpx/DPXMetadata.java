package org.jcodec.containers.dpx;

import com.xiaomi.mipush.sdk.Constants;
import org.jcodec.common.StringUtils;

/* loaded from: classes2.dex */
public class DPXMetadata {
    public static final String V1 = "V1.0";
    public static final String V2 = "V2.0";
    public FileHeader file;
    public FilmHeader film;
    public ImageHeader image;
    public ImageSourceHeader imageSource;
    public TelevisionHeader television;
    public String userId;

    private static int bcd2uint(int i) {
        int i2 = i & 15;
        int i3 = i >> 4;
        if (i2 > 9 || i3 > 9) {
            return 0;
        }
        return i2 + (i3 * 10);
    }

    private static String smpteTC(int i, boolean z) {
        int iBcd2uint = bcd2uint(i & 63);
        int iBcd2uint2 = bcd2uint((i >> 8) & 127);
        int iBcd2uint3 = bcd2uint((i >> 16) & 127);
        int iBcd2uint4 = bcd2uint((i >> 24) & 63);
        boolean z2 = ((long) (i & 1073741824)) > 0 && !z;
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.zeroPad2(iBcd2uint4));
        String str = Constants.COLON_SEPARATOR;
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(StringUtils.zeroPad2(iBcd2uint3));
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(StringUtils.zeroPad2(iBcd2uint2));
        if (z2) {
            str = ";";
        }
        sb.append(str);
        sb.append(StringUtils.zeroPad2(iBcd2uint));
        return sb.toString();
    }

    public String getTimecodeString() {
        return smpteTC(this.television.timecode, false);
    }
}
