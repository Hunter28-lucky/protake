package org.jcodec.codecs.mpeg12;

import java.io.File;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class FixHLSTimestamps extends FixTimestamp {
    private long[] lastPts = new long[256];

    private void doIt(String str, int i) throws Throwable {
        Arrays.fill(this.lastPts, -1L);
        while (true) {
            File file = new File(String.format(str, Integer.valueOf(i)));
            System.out.println(file.getAbsolutePath());
            if (!file.exists()) {
                return;
            }
            fix(file);
            i++;
        }
    }

    public static void main1(String[] strArr) throws Throwable {
        new FixHLSTimestamps().doIt(strArr[0], Integer.parseInt(strArr[1]));
    }

    @Override // org.jcodec.codecs.mpeg12.FixTimestamp
    public long doWithTimestamp(int i, long j, boolean z) {
        if (!z) {
            return j;
        }
        long[] jArr = this.lastPts;
        if (jArr[i] == -1) {
            jArr[i] = j;
            return j;
        }
        if (isVideo(i)) {
            long[] jArr2 = this.lastPts;
            long j2 = jArr2[i] + 3003;
            jArr2[i] = j2;
            return j2;
        }
        if (!isAudio(i)) {
            throw new RuntimeException("Unexpected!!!");
        }
        long[] jArr3 = this.lastPts;
        long j3 = jArr3[i] + 1920;
        jArr3[i] = j3;
        return j3;
    }
}
