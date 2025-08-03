package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.jcodec.platform.Platform;

/* compiled from: DefaultImageHeaderParser.java */
/* renamed from: ƨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2452 implements ImageHeaderParser {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final byte[] f9143 = "Exif\u0000\u0000".getBytes(Charset.forName(Platform.UTF_8));

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int[] f9144 = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: ƨ$Ϳ, reason: contains not printable characters */
    public static final class C2453 implements InterfaceC2455 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ByteBuffer f9145;

        public C2453(ByteBuffer byteBuffer) {
            this.f9145 = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // defpackage.C2452.InterfaceC2455
        public long skip(long j) {
            int iMin = (int) Math.min(this.f9145.remaining(), j);
            ByteBuffer byteBuffer = this.f9145;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: Ϳ, reason: contains not printable characters */
        public int mo9024() {
            return ((mo9027() << 8) & 65280) | (mo9027() & 255);
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: Ԩ, reason: contains not printable characters */
        public int mo9025(byte[] bArr, int i) {
            int iMin = Math.min(i, this.f9145.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f9145.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: ԩ, reason: contains not printable characters */
        public short mo9026() {
            return (short) (mo9027() & 255);
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: Ԫ, reason: contains not printable characters */
        public int mo9027() {
            if (this.f9145.remaining() < 1) {
                return -1;
            }
            return this.f9145.get();
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: ƨ$Ԩ, reason: contains not printable characters */
    public static final class C2454 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ByteBuffer f9146;

        public C2454(byte[] bArr, int i) {
            this.f9146 = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public short m9028(int i) {
            if (m9030(i, 2)) {
                return this.f9146.getShort(i);
            }
            return (short) -1;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int m9029(int i) {
            if (m9030(i, 4)) {
                return this.f9146.getInt(i);
            }
            return -1;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public final boolean m9030(int i, int i2) {
            return this.f9146.remaining() - i >= i2;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int m9031() {
            return this.f9146.remaining();
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m9032(ByteOrder byteOrder) {
            this.f9146.order(byteOrder);
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: ƨ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC2455 {
        long skip(long j) throws IOException;

        /* renamed from: Ϳ */
        int mo9024() throws IOException;

        /* renamed from: Ԩ */
        int mo9025(byte[] bArr, int i) throws IOException;

        /* renamed from: ԩ */
        short mo9026() throws IOException;

        /* renamed from: Ԫ */
        int mo9027() throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: ƨ$Ԭ, reason: contains not printable characters */
    public static final class C2456 implements InterfaceC2455 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InputStream f9147;

        public C2456(InputStream inputStream) {
            this.f9147 = inputStream;
        }

        @Override // defpackage.C2452.InterfaceC2455
        public long skip(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.f9147.skip(j2);
                if (jSkip <= 0) {
                    if (this.f9147.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: Ϳ */
        public int mo9024() throws IOException {
            return ((this.f9147.read() << 8) & 65280) | (this.f9147.read() & 255);
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: Ԩ */
        public int mo9025(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int i3 = this.f9147.read(bArr, i - i2, i2);
                if (i3 == -1) {
                    break;
                }
                i2 -= i3;
            }
            return i - i2;
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: ԩ */
        public short mo9026() throws IOException {
            return (short) (this.f9147.read() & 255);
        }

        @Override // defpackage.C2452.InterfaceC2455
        /* renamed from: Ԫ */
        public int mo9027() throws IOException {
            return this.f9147.read();
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m9016(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean m9017(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int m9018(C2454 c2454) {
        ByteOrder byteOrder;
        short sM9028 = c2454.m9028(6);
        if (sM9028 != 18761) {
            if (sM9028 != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sM9028));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        c2454.m9032(byteOrder);
        int iM9029 = c2454.m9029(10) + 6;
        short sM90282 = c2454.m9028(iM9029);
        for (int i = 0; i < sM90282; i++) {
            int iM9016 = m9016(iM9029, i);
            short sM90283 = c2454.m9028(iM9016);
            if (sM90283 == 274) {
                short sM90284 = c2454.m9028(iM9016 + 2);
                if (sM90284 >= 1 && sM90284 <= 12) {
                    int iM90292 = c2454.m9029(iM9016 + 4);
                    if (iM90292 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) sM90283) + " formatCode=" + ((int) sM90284) + " componentCount=" + iM90292);
                        }
                        int i2 = iM90292 + f9144[sM90284];
                        if (i2 <= 4) {
                            int i3 = iM9016 + 8;
                            if (i3 >= 0 && i3 <= c2454.m9031()) {
                                if (i2 >= 0 && i2 + i3 <= c2454.m9031()) {
                                    return c2454.m9028(i3);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sM90283));
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) sM90283));
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sM90284));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) sM90284));
                }
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: Ϳ */
    public ImageHeaderParser.ImageType mo4850(@NonNull ByteBuffer byteBuffer) throws IOException {
        return m9020(new C2453((ByteBuffer) C4513.m13867(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    /* renamed from: Ԩ */
    public ImageHeaderParser.ImageType mo4851(@NonNull InputStream inputStream) throws IOException {
        return m9020(new C2456((InputStream) C4513.m13867(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    /* renamed from: ԩ */
    public int mo4852(@NonNull InputStream inputStream, @NonNull InterfaceC4950 interfaceC4950) throws IOException {
        return m9019(new C2456((InputStream) C4513.m13867(inputStream)), (InterfaceC4950) C4513.m13867(interfaceC4950));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int m9019(InterfaceC2455 interfaceC2455, InterfaceC4950 interfaceC4950) throws IOException {
        int iMo9024 = interfaceC2455.mo9024();
        if (!m9017(iMo9024)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iMo9024);
            }
            return -1;
        }
        int iM9022 = m9022(interfaceC2455);
        if (iM9022 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) interfaceC4950.mo9474(iM9022, byte[].class);
        try {
            return m9023(interfaceC2455, bArr, iM9022);
        } finally {
            interfaceC4950.put(bArr);
        }
    }

    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public final ImageHeaderParser.ImageType m9020(InterfaceC2455 interfaceC2455) throws IOException {
        int iMo9024 = interfaceC2455.mo9024();
        if (iMo9024 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int iMo90242 = ((iMo9024 << 16) & (-65536)) | (interfaceC2455.mo9024() & 65535);
        if (iMo90242 == -1991225785) {
            interfaceC2455.skip(21L);
            return interfaceC2455.mo9027() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        }
        if ((iMo90242 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        }
        if (iMo90242 != 1380533830) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        interfaceC2455.skip(4L);
        if ((((interfaceC2455.mo9024() << 16) & (-65536)) | (interfaceC2455.mo9024() & 65535)) != 1464156752) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iMo90243 = ((interfaceC2455.mo9024() << 16) & (-65536)) | (interfaceC2455.mo9024() & 65535);
        if ((iMo90243 & InputDeviceCompat.SOURCE_ANY) != 1448097792) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int i = iMo90243 & 255;
        if (i == 88) {
            interfaceC2455.skip(4L);
            return (interfaceC2455.mo9027() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        }
        if (i != 76) {
            return ImageHeaderParser.ImageType.WEBP;
        }
        interfaceC2455.skip(4L);
        return (interfaceC2455.mo9027() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final boolean m9021(byte[] bArr, int i) {
        boolean z = bArr != null && i > f9143.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = f9143;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final int m9022(InterfaceC2455 interfaceC2455) throws IOException {
        short sMo9026;
        int iMo9024;
        long j;
        long jSkip;
        do {
            short sMo90262 = interfaceC2455.mo9026();
            if (sMo90262 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sMo90262));
                }
                return -1;
            }
            sMo9026 = interfaceC2455.mo9026();
            if (sMo9026 == 218) {
                return -1;
            }
            if (sMo9026 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iMo9024 = interfaceC2455.mo9024() - 2;
            if (sMo9026 == 225) {
                return iMo9024;
            }
            j = iMo9024;
            jSkip = interfaceC2455.skip(j);
        } while (jSkip == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sMo9026) + ", wanted to skip: " + iMo9024 + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int m9023(InterfaceC2455 interfaceC2455, byte[] bArr, int i) throws IOException {
        int iMo9025 = interfaceC2455.mo9025(bArr, i);
        if (iMo9025 == i) {
            if (m9021(bArr, i)) {
                return m9018(new C2454(bArr, i));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + iMo9025);
        }
        return -1;
    }
}
