package defpackage;

import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.exifinterface.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: LutUtils.java */
/* renamed from: ࡈ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3927 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float[] f13554 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static float[] f13555 = new float[1024];

    /* compiled from: LutUtils.java */
    /* renamed from: ࡈ$Ϳ, reason: contains not printable characters */
    public static class C3928 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public Bitmap f13556;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float[] f13557;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public Bitmap m12689() {
            return this.f13556;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float[] m12690() {
            return this.f13557;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public void m12691(Bitmap bitmap) {
            this.f13556 = bitmap;
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C3928 m12692(float[] fArr) {
            this.f13557 = fArr;
            return this;
        }
    }

    static {
        for (int i = 0; i < 64; i++) {
            System.arraycopy(f13554, 0, f13555, i * 16, 16);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C3928 m12686(byte[] bArr) {
        long jNanoTime = System.nanoTime();
        byte[] bArrM12688 = m12688(bArr);
        C4638.m14099("readStrream", String.format("unCompress cost1 : %s ", Long.valueOf((System.nanoTime() - jNanoTime) / 1000000)));
        return m12687(bArrM12688);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static C3928 m12687(byte[] bArr) {
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
        C4638.m14099("readStrream", String.format("dims : %s ", Arrays.toString(fArr)));
        long jNanoTime4 = System.nanoTime();
        C3928 c3928 = new C3928();
        c3928.m12691(bitmapCreateBitmap);
        c3928.m12692(fArr);
        C4638.m14099("readStrream", String.format("unCompress cost1 : %s , cost2 : %s , cost3: %s , setMats : %s ", Long.valueOf((jNanoTime2 - jNanoTime) / 1000000), Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000), Long.valueOf((jNanoTime4 - jNanoTime3) / 1000000), Long.valueOf((System.nanoTime() - jNanoTime4) / 1000000)));
        return c3928;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static byte[] m12688(byte[] bArr) {
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
