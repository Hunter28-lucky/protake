package defpackage;

import androidx.core.view.PointerIconCompat;
import com.blink.academy.film.support.stream.ts.TsConstants;
import com.umeng.analytics.pro.cb;
import java.io.IOException;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* compiled from: Huffman.kt */
/* renamed from: ē, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2322 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final int[] f8829;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final byte[] f8830;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final C2323 f8831;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C2322 f8832;

    static {
        C2322 c2322 = new C2322();
        f8832 = c2322;
        f8829 = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, 250, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] bArr = {cb.k, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, cb.k, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, cb.m, 6, 12, 10, cb.k, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, cb.k, 19, cb.k, cb.l, 6, cb.m, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, cb.m, 11, cb.l, cb.k, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, TsConstants.ACESType_h264, TsConstants.ACESType_h264, 26, 24, 25, 19, 21, 26, TsConstants.ACESType_h264, TsConstants.ACESType_h264, 26, TsConstants.ACESType_h264, 24, 21, 21, 26, 26, 28, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, TsConstants.ACESType_h264, 26, 26, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, 28, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, TsConstants.ACESType_h264, 26};
        f8830 = bArr;
        f8831 = new C2323();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            c2322.m8722(i, f8829[i], f8830[i]);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m8722(int i, int i2, int i3) {
        C2323 c2323 = new C2323(i, i3);
        C2323 c23232 = f8831;
        while (i3 > 8) {
            i3 -= 8;
            int i4 = (i2 >>> i3) & 255;
            C2323[] c2323ArrM8726 = c23232.m8726();
            if (c2323ArrM8726 == null) {
                C3921.m12675();
            }
            C2323 c23233 = c2323ArrM8726[i4];
            if (c23233 == null) {
                c23233 = new C2323();
                c2323ArrM8726[i4] = c23233;
            }
            c23232 = c23233;
        }
        int i5 = 8 - i3;
        int i6 = (i2 << i5) & 255;
        int i7 = 1 << i5;
        C2323[] c2323ArrM87262 = c23232.m8726();
        if (c2323ArrM87262 == null) {
            C3921.m12675();
        }
        C4955.m14732(c2323ArrM87262, c2323, i6, i7 + i6);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m8723(BufferedSource bufferedSource, long j, BufferedSink bufferedSink) throws IOException {
        C3921.m12667(bufferedSource, "source");
        C3921.m12667(bufferedSink, "sink");
        C2323 c2323 = f8831;
        int iM6232 = 0;
        int iM8728 = 0;
        for (long j2 = 0; j2 < j; j2++) {
            iM6232 = (iM6232 << 8) | i5.m6232(bufferedSource.readByte(), 255);
            iM8728 += 8;
            while (iM8728 >= 8) {
                int i = iM8728 - 8;
                int i2 = (iM6232 >>> i) & 255;
                C2323[] c2323ArrM8726 = c2323.m8726();
                if (c2323ArrM8726 == null) {
                    C3921.m12675();
                }
                c2323 = c2323ArrM8726[i2];
                if (c2323 == null) {
                    C3921.m12675();
                }
                if (c2323.m8726() == null) {
                    bufferedSink.writeByte(c2323.m8727());
                    iM8728 -= c2323.m8728();
                    c2323 = f8831;
                } else {
                    iM8728 = i;
                }
            }
        }
        while (iM8728 > 0) {
            int i3 = (iM6232 << (8 - iM8728)) & 255;
            C2323[] c2323ArrM87262 = c2323.m8726();
            if (c2323ArrM87262 == null) {
                C3921.m12675();
            }
            C2323 c23232 = c2323ArrM87262[i3];
            if (c23232 == null) {
                C3921.m12675();
            }
            if (c23232.m8726() != null || c23232.m8728() > iM8728) {
                return;
            }
            bufferedSink.writeByte(c23232.m8727());
            iM8728 -= c23232.m8728();
            c2323 = f8831;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m8724(ByteString byteString, BufferedSink bufferedSink) throws IOException {
        C3921.m12667(byteString, "source");
        C3921.m12667(bufferedSink, "sink");
        int size = byteString.size();
        long j = 0;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int iM6232 = i5.m6232(byteString.getByte(i2), 255);
            int i3 = f8829[iM6232];
            byte b = f8830[iM6232];
            j = (j << b) | i3;
            i += b;
            while (i >= 8) {
                i -= 8;
                bufferedSink.writeByte((int) (j >> i));
            }
        }
        if (i > 0) {
            bufferedSink.writeByte((int) ((j << (8 - i)) | (255 >>> i)));
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m8725(ByteString byteString) {
        C3921.m12667(byteString, "bytes");
        long j = 0;
        for (int i = 0; i < byteString.size(); i++) {
            j += f8830[i5.m6232(byteString.getByte(i), 255)];
        }
        return (int) ((j + 7) >> 3);
    }

    /* compiled from: Huffman.kt */
    /* renamed from: ē$Ϳ, reason: contains not printable characters */
    public static final class C2323 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2323[] f8833;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int f8834;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final int f8835;

        public C2323() {
            this.f8833 = new C2323[256];
            this.f8834 = 0;
            this.f8835 = 0;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2323[] m8726() {
            return this.f8833;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int m8727() {
            return this.f8834;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final int m8728() {
            return this.f8835;
        }

        public C2323(int i, int i2) {
            this.f8833 = null;
            this.f8834 = i;
            int i3 = i2 & 7;
            this.f8835 = i3 == 0 ? 8 : i3;
        }
    }
}
