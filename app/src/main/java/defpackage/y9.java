package defpackage;

import androidx.exifinterface.media.ExifInterface;

/* loaded from: classes.dex */
public class y9 extends w9 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final /* synthetic */ boolean f8764 = true;

    public y9(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static y9 m8629(String str, long j, yb ybVar, short s, lf lfVar) throws Exception {
        byte[] bArrM299 = ce.m299((byte) 1);
        boolean z = f8764;
        if (!z && bArrM299.length != 1) {
            throw new AssertionError();
        }
        byte[] bArrM300 = ce.m300(str.charAt(0), str.charAt(1));
        if (!z && bArrM300.length != 2) {
            throw new AssertionError();
        }
        byte[] bArrM301 = ce.m301(j);
        if (!z && bArrM301.length != 8) {
            throw new AssertionError();
        }
        byte[] bArrM304 = ce.m304();
        if (!z && bArrM304.length != 2) {
            throw new AssertionError();
        }
        ybVar.mo6027();
        byte[] bArrM2992 = ce.m299(ybVar.f8766);
        if (!z && bArrM2992.length != 1) {
            throw new AssertionError();
        }
        byte[] bArrM2993 = ce.m299(ybVar.f8767);
        if (!z && bArrM2993.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr = (byte[]) ybVar.f8768.clone();
        if (!z && bArr.length != (ybVar.f8767 & ExifInterface.MARKER)) {
            throw new AssertionError();
        }
        byte[] bArrM302 = ce.m302(s);
        if (!z && bArrM302.length != 2) {
            throw new AssertionError();
        }
        byte[] bArrM3042 = ce.m304();
        if (!z && bArrM3042.length != 2) {
            throw new AssertionError();
        }
        lfVar.mo7507();
        byte[] bArrM2994 = ce.m299(lfVar.f7957);
        if (!z && bArrM2994.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr2 = (byte[]) lfVar.f7958.clone();
        if (!z && bArr2.length != (lfVar.f7957 & ExifInterface.MARKER)) {
            throw new AssertionError();
        }
        byte[] bArrM305 = ce.m305();
        if (z || bArrM305.length == 4) {
            return new y9(ce.m303(bArrM299, bArrM300, bArrM301, bArrM304, bArrM2992, bArrM2993, bArr, bArrM302, bArrM3042, bArrM2994, bArr2, bArrM305));
        }
        throw new AssertionError();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static y9 m8630() {
        try {
            return m8629("EX", 0L, new fd(""), (short) 0, new vf());
        } catch (Exception unused) {
            return null;
        }
    }
}
