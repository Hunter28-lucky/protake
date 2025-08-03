package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import defpackage.AbstractC4585;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ScanPreconditionsVerifierApi24 implements ScanPreconditionsVerifier {
    private static final long EXCESSIVE_SCANNING_PERIOD = TimeUnit.SECONDS.toMillis(30);
    private static final int SCANS_LENGTH = 5;
    private final long[] previousChecks = new long[5];
    private final ScanPreconditionsVerifierApi18 scanPreconditionVerifierApi18;
    private final AbstractC4585 timeScheduler;

    public ScanPreconditionsVerifierApi24(ScanPreconditionsVerifierApi18 scanPreconditionsVerifierApi18, AbstractC4585 abstractC4585) {
        this.scanPreconditionVerifierApi18 = scanPreconditionsVerifierApi18;
        this.timeScheduler = abstractC4585;
    }

    private int getOldestCheckTimestampIndex() {
        long j = Long.MAX_VALUE;
        int i = -1;
        for (int i2 = 0; i2 < 5; i2++) {
            long j2 = this.previousChecks[i2];
            if (j2 < j) {
                i = i2;
                j = j2;
            }
        }
        return i;
    }

    @Override // com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier
    public void verify(boolean z) {
        this.scanPreconditionVerifierApi18.verify(z);
        int oldestCheckTimestampIndex = getOldestCheckTimestampIndex();
        long j = this.previousChecks[oldestCheckTimestampIndex];
        long jM14050 = this.timeScheduler.m14050(TimeUnit.MILLISECONDS);
        long j2 = jM14050 - j;
        long j3 = EXCESSIVE_SCANNING_PERIOD;
        if (j2 < j3) {
            throw new BleScanException(BleScanException.UNDOCUMENTED_SCAN_THROTTLE, new Date(j + j3));
        }
        this.previousChecks[oldestCheckTimestampIndex] = jM14050;
    }
}
