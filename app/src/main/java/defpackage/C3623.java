package defpackage;

import java.util.Locale;

/* renamed from: ۄ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3623 extends t3 {

    /* renamed from: ރ, reason: contains not printable characters */
    public float f12576;

    public C3623(float f) {
        this(f, m11694(f), m11692(f));
    }

    public C3623(float f, String str, String str2) {
        super(str, str2, str, str2);
        this.f12576 = f;
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static String m11692(float f) {
        int i;
        int iRound = Math.round(f);
        if (iRound >= 1) {
            double d = iRound;
            int iFloor = (int) Math.floor(Math.sqrt(Math.pow(d, 2.0d) * (-2.0d) * Math.log(Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d) * 0.00390625d)));
            i = iFloor + (iFloor % 2);
        } else {
            i = 0;
        }
        return m11693(i, iRound);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static String m11693(int i, double d) {
        int i2 = i + 1;
        double[] dArr = new double[i2];
        double d2 = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            double dSqrt = (1.0d / Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i3, 2.0d)) / (Math.pow(d, 2.0d) * 2.0d));
            dArr[i3] = dSqrt;
            if (i3 != 0) {
                dSqrt *= 2.0d;
            }
            d2 += dSqrt;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            dArr[i4] = dArr[i4] / d2;
        }
        int i5 = (i / 2) + (i % 2);
        int iMin = Math.min(i5, 7);
        StringBuilder sb = new StringBuilder();
        Locale locale = Locale.US;
        sb.append(String.format(locale, C4625.m14082("OwEECT8AAlQSCghCX1ZBfCtNBj4CGgAoBgRVVmdWNhsYHTVJZQEPAgNdQV4TJgYKByBSCRgOChESR1ZLKwM6BjQGBzsHDRZXRwg5OwEECT8AAlQJAgJaQxNVIgAMG3AGCgwEBy1XWlRbOiALCSMXG09rHQRASlpdKU8FBjcaH1QXDgYAE1FfOx0uAD8ACx0PChFXQGgWKjJWZSYdBhBBBgRbXRsaRBRnAz8FH1QXDgYGE0BGI09QTyYXDEBJW0sCGgg5"), Integer.valueOf((iMin * 2) + 1)));
        sb.append(String.format(locale, C4625.m14082("PRoAT3tPTwAEExFHQVYBCkcEASAHGz0MCgJXZ1ZLOhofCnxSDRgUGSZdXEFXJwEMGzUBNEQ8QkUYExZVdWU="), Double.valueOf(dArr[0])));
        for (int i6 = 0; i6 < iMin; i6++) {
            int i7 = i6 * 2;
            int i8 = i7 + 1;
            int i9 = i7 + 2;
            float f = ((float) dArr[i8]) + ((float) dArr[i9]);
            Locale locale2 = Locale.US;
            sb.append(String.format(locale2, C4625.m14082("PRoAT3tPTwAEExFHQVYBCkcEASAHGz0MCgJXZ1ZLOhofCnxSDRgUGSZdXEFXJwEMGzUBNFEFNkwSGRMWKFRn"), Integer.valueOf(i8), Float.valueOf(f)));
            sb.append(String.format(locale2, C4625.m14082("PRoAT3tPTwAEExFHQVYBCkcEASAHGz0MCgJXZ1ZLOhofCnxSDRgUGSZdXEFXJwEMGzUBNFEFNkwSGRMWKFRn"), Integer.valueOf(i9), Float.valueOf(f)));
        }
        if (i5 > iMin) {
            sb.append(C4625.m14082("JgYKByBSGRECWUVBWl1UIgo+GzUCIBIHGABGEw4TOAoOXXgGCgwEBzJbV0dbAQkLHDUGQ1QVDh1XX3tWJwgFGx8UCQcEH0wJOQ=="));
            while (iMin < i5) {
                int i10 = iMin * 2;
                int i11 = i10 + 1;
                float f2 = (float) dArr[i11];
                int i12 = i10 + 2;
                float f3 = (float) dArr[i12];
                float f4 = f2 + f3;
                float f5 = ((f2 * i11) + (f3 * i12)) / f4;
                Locale locale3 = Locale.US;
                sb.append(String.format(locale3, C4625.m14082("PRoAT3tPTwAEExFHQVYBCkcEASAHGz0MCgJXZ1ZLOhofCnxSDRgUGSZdXEFXJwEMGzUBNEQ8S04SQFpdKQMIPCQXHzsHDRZXRxMZbkoLRnBYT1EHUG8="), Float.valueOf(f5), Float.valueOf(f4)));
                sb.append(String.format(locale3, C4625.m14082("PRoAT3tPTwAEExFHQVYBCkcEASAHGz0MCgJXZ1ZLOhofCnxSDRgUGSZdXEFXJwEMGzUBNEQ8S0gSQFpdKQMIPCQXHzsHDRZXRxMZbkoLRnBYT1EHUG8="), Float.valueOf(f5), Float.valueOf(f4)));
                iMin++;
            }
        }
        sb.append(C4625.m14082("KQMyKSITCDcOBwpAEw4TPRoAVFoPZQ=="));
        return sb.toString();
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static String m11694(float f) {
        int i;
        int iRound = Math.round(f);
        if (iRound >= 1) {
            double d = iRound;
            int iFloor = (int) Math.floor(Math.sqrt(Math.pow(d, 2.0d) * (-2.0d) * Math.log(Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d) * 0.00390625d)));
            i = iFloor + (iFloor % 2);
        } else {
            i = 0;
        }
        return m11695(i, iRound);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static String m11695(int i, double d) {
        int i2 = i + 1;
        double[] dArr = new double[i2];
        double d2 = 0.0d;
        for (int i3 = 0; i3 < i2; i3++) {
            double dSqrt = (1.0d / Math.sqrt(Math.pow(d, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i3, 2.0d)) / (Math.pow(d, 2.0d) * 2.0d));
            dArr[i3] = dSqrt;
            if (i3 != 0) {
                dSqrt *= 2.0d;
            }
            d2 += dSqrt;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            dArr[i4] = dArr[i4] / d2;
        }
        int iMin = Math.min((i / 2) + (i % 2), 7);
        float[] fArr = new float[iMin];
        for (int i5 = 0; i5 < iMin; i5++) {
            int i6 = i5 * 2;
            int i7 = i6 + 1;
            float f = (float) dArr[i7];
            int i8 = i6 + 2;
            float f2 = (float) dArr[i8];
            fArr[i5] = ((f * i7) + (f2 * i8)) / (f + f2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.US, C4625.m14082("LxsZHTkQGgAESxNXUAcTPgAeBiQbABpaYQRGR0FaLBoZCnAEChdVSwxcQ0ZHGgoVGyUACjcOBBdWWl1SOgpWZSUcBhIOGQgSW1pUJh9NCTwdDgBBHwBKVl9kJwsZBx8UCQcEH144Rl1aKAAfAnAaBhMJG0VUX1xSOk8ZCigXAzwEAgJaR3xVKBwIG2t4GRUTEgxcVBNbJwgFH3AEChdTSwdeRkFwIQAfCzkcDgAEGD4XV24IRBkCBjRSAhUIBU0bOUg5bk9NCDwtPxsSAhFbXF0Tc08dACMbGx0OBV44ExMTOAoOXXABBhoGBwBhR1ZDAQkLHDUGT0lBHQBRARtHKxcIAwcbCwAJJANUQFZHYk8ZCigXAzwEAgJaR3xVKBwIG3lJZQ=="), Integer.valueOf((iMin * 2) + 1)));
        sb.append(C4625.m14082("bk9NTzIeGgYiBApAV1pdLxsIHAtCMlRcSwxcQ0ZHGgoVGyUACjcOBBdWWl1SOgpDFylJZQ=="));
        for (int i9 = 0; i9 < iMin; i9++) {
            int i10 = i9 * 2;
            sb.append(String.format(Locale.US, C4625.m14082("bk9NDTwHHTcOBBdWWl1SOgoeNHUWMlRcSwxcQ0ZHGgoVGyUACjcOBBdWWl1SOgpDFylSRFQSAgtVX1ZgOgodIDYUHBEVS08SFlUIRE9NTzIeGgYiBApAV1pdLxsIHAtXCylBVkVbXUNGOjsIFyQHHREiBApAV1pdLxsIQSgLT1lBGAxcVF9WHRsIHx8UCQcEH0UYExZVdWU="), Integer.valueOf(i10 + 1), Float.valueOf(fArr[i9]), Integer.valueOf(i10 + 2), Float.valueOf(fArr[i9])));
        }
        sb.append(C4625.m14082("M2U="));
        return sb.toString();
    }
}
