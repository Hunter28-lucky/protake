package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* renamed from: ݵ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3764 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static boolean f12994 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static float[] f12995 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float[] f12996 = new float[1024];

    /* renamed from: ݵ$Ϳ, reason: contains not printable characters */
    public static class C3765 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public Bitmap f12997;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float[] f12998;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C3765 m12050(float[] fArr) {
            this.f12998 = fArr;
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public Bitmap m12051() {
            return this.f12997;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m12052(Bitmap bitmap) {
            this.f12997 = bitmap;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float[] m12053() {
            return this.f12998;
        }
    }

    static {
        for (int i = 0; i < 64; i++) {
            System.arraycopy(f12995, 0, f12996, i * 16, 16);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C3765 m12047(byte[] bArr) {
        long jNanoTime = System.nanoTime();
        byte[] bArrM12049 = m12049(bArr);
        long jNanoTime2 = System.nanoTime();
        if (f12994) {
            Log.d(C4625.m14082("PAoMCwMGHQYECgg="), String.format(C4625.m14082("OwEuAD0CHRESGEVRXEBHf09XT3UBTw=="), Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
        }
        return m12048(bArrM12049);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C3765 m12048(byte[] bArr) {
        long jNanoTime = System.nanoTime();
        long jNanoTime2 = System.nanoTime();
        int length = bArr.length;
        byte[] bArr2 = new byte[1048576];
        int i = 0;
        System.arraycopy(bArr, 0, bArr2, 0, 1048576);
        int[] iArr = new int[262144];
        int i2 = 0;
        while (true) {
            if (i2 >= 64) {
                break;
            }
            int i3 = i;
            for (int i4 = 4096; i3 < i4; i4 = 4096) {
                int i5 = (i2 * 4096) + i3;
                int i6 = i5 * 4;
                iArr[i5] = Color.argb(bArr2[i6 + 3] & ExifInterface.MARKER, bArr2[i6 + 2] & ExifInterface.MARKER, bArr2[i6 + 1] & ExifInterface.MARKER, bArr2[i6] & ExifInterface.MARKER);
                i3++;
            }
            i2++;
            i = 0;
        }
        long jNanoTime3 = System.nanoTime();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, 4096, 64, Bitmap.Config.ARGB_8888);
        float[] fArr = new float[4];
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, length - 16, bArr3, 0, 16);
        int i7 = 0;
        for (int i8 = 4; i7 < i8; i8 = 4) {
            int i9 = i7 * 4;
            fArr[i7] = Float.intBitsToFloat(((bArr3[i9 + 3] & ExifInterface.MARKER) << 24) | ((bArr3[i9 + 2] & ExifInterface.MARKER) << 16) | ((bArr3[i9 + 1] & ExifInterface.MARKER) << 8) | (bArr3[i9] & ExifInterface.MARKER));
            i7++;
        }
        if (f12994) {
            Log.d(C4625.m14082("PAoMCwMGHQYECgg="), String.format(C4625.m14082("KgYAHHBIT1ESSw=="), Arrays.toString(fArr)));
        }
        long jNanoTime4 = System.nanoTime();
        C3765 c3765 = new C3765();
        c3765.m12052(bitmapCreateBitmap);
        c3765.m12050(fArr);
        long jNanoTime5 = System.nanoTime();
        if (f12994) {
            Log.d(C4625.m14082("PAoMCwMGHQYECgg="), String.format(C4625.m14082("OwEuAD0CHRESGEVRXEBHf09XT3UBT1hBCApBRwETdE9IHHBeTxcOGBEBCRMWPU9BTyMXGzkAHxYSCRMWPU8="), Long.valueOf((jNanoTime2 - jNanoTime) / 1000000), Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000), Long.valueOf((jNanoTime4 - jNanoTime3) / 1000000), Long.valueOf((jNanoTime5 - jNanoTime4) / 1000000)));
        }
        return c3765;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m12049(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        byte[] bArr2 = new byte[256];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        while (!inflater.finished()) {
            try {
                try {
                    byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                } catch (DataFormatException e2) {
                    e2.printStackTrace();
                    inflater.end();
                    return null;
                }
            } catch (Throwable th) {
                inflater.end();
                throw th;
            }
        }
        inflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
