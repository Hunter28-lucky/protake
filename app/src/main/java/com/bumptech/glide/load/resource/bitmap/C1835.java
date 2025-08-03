package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1840;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import defpackage.C2422;
import defpackage.C2739;
import defpackage.C3475;
import defpackage.C4238;
import defpackage.C4513;
import defpackage.C4904;
import defpackage.InterfaceC2731;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4950;
import defpackage.b3;
import defpackage.j5;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* compiled from: Downsampler.java */
/* renamed from: com.bumptech.glide.load.resource.bitmap.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C1835 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C4238<DecodeFormat> f5374 = C4238.m13342("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.f5173);

    /* renamed from: ԭ, reason: contains not printable characters */
    @Deprecated
    public static final C4238<DownsampleStrategy> f5375 = DownsampleStrategy.f5364;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C4238<Boolean> f5376 = C4238.m13342("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", Boolean.FALSE);

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final C4238<Boolean> f5377 = C4238.m13341("com.bumtpech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode");

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final Set<String> f5378 = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final InterfaceC1837 f5379 = new C1836();

    /* renamed from: ֏, reason: contains not printable characters */
    public static final Set<ImageHeaderParser.ImageType> f5380 = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final Queue<BitmapFactory.Options> f5381 = j5.m7088(0);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2731 f5382;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final DisplayMetrics f5383;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC4950 f5384;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final List<ImageHeaderParser> f5385;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C2422 f5386 = C2422.m8917();

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.Ϳ$Ϳ, reason: contains not printable characters */
    public class C1836 implements InterfaceC1837 {
        @Override // com.bumptech.glide.load.resource.bitmap.C1835.InterfaceC1837
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo5015() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.C1835.InterfaceC1837
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo5016(InterfaceC2731 interfaceC2731, Bitmap bitmap) {
        }
    }

    /* compiled from: Downsampler.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.Ϳ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC1837 {
        /* renamed from: Ϳ */
        void mo5015();

        /* renamed from: Ԩ */
        void mo5016(InterfaceC2731 interfaceC2731, Bitmap bitmap) throws IOException;
    }

    public C1835(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, InterfaceC2731 interfaceC2731, InterfaceC4950 interfaceC4950) {
        this.f5385 = list;
        this.f5383 = (DisplayMetrics) C4513.m13867(displayMetrics);
        this.f5382 = (InterfaceC2731) C4513.m13867(interfaceC2731);
        this.f5384 = (InterfaceC4950) C4513.m13867(interfaceC4950);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m4993(double d) {
        return m5006((d / (r1 / r0)) * m5006(m4998(d) * d));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m4994(ImageHeaderParser.ImageType imageType, InputStream inputStream, InterfaceC1837 interfaceC1837, InterfaceC2731 interfaceC2731, DownsampleStrategy downsampleStrategy, int i, int i2, int i3, int i4, int i5, BitmapFactory.Options options) throws IOException {
        int i6;
        int iFloor;
        double dFloor;
        int iRound;
        if (i2 <= 0 || i3 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i4 + "x" + i5 + "]");
                return;
            }
            return;
        }
        float fMo4989 = (i == 90 || i == 270) ? downsampleStrategy.mo4989(i3, i2, i4, i5) : downsampleStrategy.mo4989(i2, i3, i4, i5);
        if (fMo4989 <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fMo4989 + " from: " + downsampleStrategy + ", source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "]");
        }
        DownsampleStrategy.SampleSizeRounding sampleSizeRoundingMo4988 = downsampleStrategy.mo4988(i2, i3, i4, i5);
        if (sampleSizeRoundingMo4988 == null) {
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        float f = i2;
        float f2 = i3;
        int iM5006 = i2 / m5006(fMo4989 * f);
        int iM50062 = i3 / m5006(fMo4989 * f2);
        DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
        int iMax = sampleSizeRoundingMo4988 == sampleSizeRounding ? Math.max(iM5006, iM50062) : Math.min(iM5006, iM50062);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 > 23 || !f5378.contains(options.outMimeType)) {
            int iMax2 = Math.max(1, Integer.highestOneBit(iMax));
            i6 = (sampleSizeRoundingMo4988 != sampleSizeRounding || ((float) iMax2) >= 1.0f / fMo4989) ? iMax2 : iMax2 << 1;
        } else {
            i6 = 1;
        }
        options.inSampleSize = i6;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(i6, 8);
            iFloor = (int) Math.ceil(f / fMin);
            iRound = (int) Math.ceil(f2 / fMin);
            int i8 = i6 / 8;
            if (i8 > 0) {
                iFloor /= i8;
                iRound /= i8;
            }
        } else {
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f3 = i6;
                iFloor = (int) Math.floor(f / f3);
                dFloor = Math.floor(f2 / f3);
            } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                if (i7 >= 24) {
                    float f4 = i6;
                    iFloor = Math.round(f / f4);
                    iRound = Math.round(f2 / f4);
                } else {
                    float f5 = i6;
                    iFloor = (int) Math.floor(f / f5);
                    dFloor = Math.floor(f2 / f5);
                }
            } else if (i2 % i6 == 0 && i3 % i6 == 0) {
                iFloor = i2 / i6;
                iRound = i3 / i6;
            } else {
                int[] iArrM4999 = m4999(inputStream, options, interfaceC1837, interfaceC2731);
                iFloor = iArrM4999[0];
                iRound = iArrM4999[1];
            }
            iRound = (int) dFloor;
        }
        double dMo4989 = downsampleStrategy.mo4989(iFloor, iRound, i4, i5);
        options.inTargetDensity = m4993(dMo4989);
        options.inDensity = m4998(dMo4989);
        if (m5001(options)) {
            options.inScaled = true;
        } else {
            options.inTargetDensity = 0;
            options.inDensity = 0;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i2 + "x" + i3 + "], target: [" + i4 + "x" + i5 + "], power of two scaled: [" + iFloor + "x" + iRound + "], exact scale factor: " + fMo4989 + ", power of 2 sample size: " + i6 + ", adjusted scale factor: " + dMo4989 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        throw r1;
     */
    /* renamed from: ԭ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap m4995(java.io.InputStream r6, android.graphics.BitmapFactory.Options r7, com.bumptech.glide.load.resource.bitmap.C1835.InterfaceC1837 r8, defpackage.InterfaceC2731 r9) throws java.io.IOException {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r7.inJustDecodeBounds
            if (r1 == 0) goto Lc
            r1 = 10485760(0xa00000, float:1.469368E-38)
            r6.mark(r1)
            goto Lf
        Lc:
            r8.mo5015()
        Lf:
            int r1 = r7.outWidth
            int r2 = r7.outHeight
            java.lang.String r3 = r7.outMimeType
            java.util.concurrent.locks.Lock r4 = defpackage.b3.m117()
            r4.lock()
            r4 = 0
            android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r6, r4, r7)     // Catch: java.lang.Throwable -> L30 java.lang.IllegalArgumentException -> L32
            java.util.concurrent.locks.Lock r9 = defpackage.b3.m117()
            r9.unlock()
            boolean r7 = r7.inJustDecodeBounds
            if (r7 == 0) goto L2f
            r6.reset()
        L2f:
            return r8
        L30:
            r6 = move-exception
            goto L5f
        L32:
            r5 = move-exception
            java.io.IOException r1 = m5003(r5, r1, r2, r3, r7)     // Catch: java.lang.Throwable -> L30
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L30
            if (r2 == 0) goto L43
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L30
        L43:
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30
            if (r0 == 0) goto L5e
            r6.reset()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r0 = r7.inBitmap     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r9.mo9428(r0)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            r7.inBitmap = r4     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            android.graphics.Bitmap r6 = m4995(r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L5d
            java.util.concurrent.locks.Lock r7 = defpackage.b3.m117()
            r7.unlock()
            return r6
        L5d:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5e:
            throw r1     // Catch: java.lang.Throwable -> L30
        L5f:
            java.util.concurrent.locks.Lock r7 = defpackage.b3.m117()
            r7.unlock()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.C1835.m4995(java.io.InputStream, android.graphics.BitmapFactory$Options, com.bumptech.glide.load.resource.bitmap.Ϳ$Ԩ, ʽ):android.graphics.Bitmap");
    }

    @Nullable
    @TargetApi(19)
    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m4996(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static synchronized BitmapFactory.Options m4997() {
        BitmapFactory.Options optionsPoll;
        Queue<BitmapFactory.Options> queue = f5381;
        synchronized (queue) {
            optionsPoll = queue.poll();
        }
        if (optionsPoll == null) {
            optionsPoll = new BitmapFactory.Options();
            m5005(optionsPoll);
        }
        return optionsPoll;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int m4998(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int[] m4999(InputStream inputStream, BitmapFactory.Options options, InterfaceC1837 interfaceC1837, InterfaceC2731 interfaceC2731) throws IOException {
        options.inJustDecodeBounds = true;
        m4995(inputStream, options, interfaceC1837, interfaceC2731);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m5000(BitmapFactory.Options options) {
        return m4996(options.inBitmap);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static boolean m5001(BitmapFactory.Options options) {
        int i;
        int i2 = options.inTargetDensity;
        return i2 > 0 && (i = options.inDensity) > 0 && i2 != i;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static void m5002(int i, int i2, String str, BitmapFactory.Options options, Bitmap bitmap, int i3, int i4, long j) {
        Log.v("Downsampler", "Decoded " + m4996(bitmap) + " from [" + i + "x" + i2 + "] " + str + " with inBitmap " + m5000(options) + " for [" + i3 + "x" + i4 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + C4904.m14629(j));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static IOException m5003(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i + ", outHeight: " + i2 + ", outMimeType: " + str + ", inBitmap: " + m5000(options), illegalArgumentException);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static void m5004(BitmapFactory.Options options) {
        m5005(options);
        Queue<BitmapFactory.Options> queue = f5381;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static void m5005(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static int m5006(double d) {
        return (int) (d + 0.5d);
    }

    @TargetApi(26)
    /* renamed from: ކ, reason: contains not printable characters */
    public static void m5007(BitmapFactory.Options options, InterfaceC2731 interfaceC2731, int i, int i2) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = interfaceC2731.mo9983(i, i2, config);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m5008(InputStream inputStream, DecodeFormat decodeFormat, boolean z, boolean z2, BitmapFactory.Options options, int i, int i2) {
        if (this.f5386.m8919(i, i2, options, decodeFormat, z, z2)) {
            return;
        }
        if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        boolean zHasAlpha = false;
        try {
            zHasAlpha = C1840.m5022(this.f5385, inputStream, this.f5384).hasAlpha();
        } catch (IOException e2) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e2);
            }
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InterfaceC4536<Bitmap> m5009(InputStream inputStream, int i, int i2, C3475 c3475) throws IOException {
        return m5010(inputStream, i, i2, c3475, f5379);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public InterfaceC4536<Bitmap> m5010(InputStream inputStream, int i, int i2, C3475 c3475, InterfaceC1837 interfaceC1837) throws IOException {
        C4513.m13864(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f5384.mo9474(65536, byte[].class);
        BitmapFactory.Options optionsM4997 = m4997();
        optionsM4997.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) c3475.m11329(f5374);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) c3475.m11329(DownsampleStrategy.f5364);
        boolean zBooleanValue = ((Boolean) c3475.m11329(f5376)).booleanValue();
        C4238<Boolean> c4238 = f5377;
        try {
            return C2739.m9994(m5011(inputStream, optionsM4997, downsampleStrategy, decodeFormat, decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE ? false : c3475.m11329(c4238) != null && ((Boolean) c3475.m11329(c4238)).booleanValue(), i, i2, zBooleanValue, interfaceC1837), this.f5382);
        } finally {
            m5004(optionsM4997);
            this.f5384.put(bArr);
        }
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Bitmap m5011(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean z, int i, int i2, boolean z2, InterfaceC1837 interfaceC1837) throws IOException {
        int i3;
        int iRound;
        int iRound2;
        long jM14630 = C4904.m14630();
        int[] iArrM4999 = m4999(inputStream, options, interfaceC1837, this.f5382);
        int i4 = iArrM4999[0];
        int i5 = iArrM4999[1];
        String str = options.outMimeType;
        boolean z3 = (i4 == -1 || i5 == -1) ? false : z;
        int iM5021 = C1840.m5021(this.f5385, inputStream, this.f5384);
        int iM118 = b3.m118(iM5021);
        boolean zM121 = b3.m121(iM5021);
        int i6 = i == Integer.MIN_VALUE ? i4 : i;
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        ImageHeaderParser.ImageType imageTypeM5022 = C1840.m5022(this.f5385, inputStream, this.f5384);
        m4994(imageTypeM5022, inputStream, interfaceC1837, this.f5382, downsampleStrategy, iM118, i4, i5, i6, i7, options);
        m5008(inputStream, decodeFormat, z3, zM121, options, i6, i7);
        int i8 = options.inSampleSize;
        if (m5014(imageTypeM5022)) {
            if (i4 < 0 || i5 < 0 || !z2) {
                float f = m5001(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i9 = options.inSampleSize;
                float f2 = i9;
                int iCeil = (int) Math.ceil(i4 / f2);
                int iCeil2 = (int) Math.ceil(i5 / f2);
                iRound = Math.round(iCeil * f);
                iRound2 = Math.round(iCeil2 * f);
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculated target [" + iRound + "x" + iRound2 + "] for source [" + i4 + "x" + i5 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f);
                }
            } else {
                iRound = i6;
                iRound2 = i7;
            }
            if (iRound > 0 && iRound2 > 0) {
                m5007(options, this.f5382, iRound, iRound2);
            }
        }
        Bitmap bitmapM4995 = m4995(inputStream, options, interfaceC1837, this.f5382);
        interfaceC1837.mo5016(this.f5382, bitmapM4995);
        if (Log.isLoggable("Downsampler", 2)) {
            i3 = iM5021;
            m5002(i4, i5, str, options, bitmapM4995, i, i2, jM14630);
        } else {
            i3 = iM5021;
        }
        Bitmap bitmapM122 = null;
        if (bitmapM4995 != null) {
            bitmapM4995.setDensity(this.f5383.densityDpi);
            bitmapM122 = b3.m122(this.f5382, bitmapM4995, i3);
            if (!bitmapM4995.equals(bitmapM122)) {
                this.f5382.mo9428(bitmapM4995);
            }
        }
        return bitmapM122;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean m5012(InputStream inputStream) {
        return true;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m5013(ByteBuffer byteBuffer) {
        return true;
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final boolean m5014(ImageHeaderParser.ImageType imageType) {
        return true;
    }
}
