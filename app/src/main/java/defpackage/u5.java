package defpackage;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import defpackage.C4238;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class u5<T> implements InterfaceC3907<T, Bitmap> {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final C4238<Long> f8615 = C4238.m13339("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new C2289());

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C4238<Integer> f8616 = C4238.m13339("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new C2290());

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2292 f8617 = new C2292();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC2293<T> f8618;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC2731 f8619;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2292 f8620;

    /* compiled from: VideoDecoder.java */
    /* renamed from: u5$Ϳ, reason: contains not printable characters */
    public class C2289 implements C4238.InterfaceC4240<Long> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ByteBuffer f8621 = ByteBuffer.allocate(8);

        @Override // defpackage.C4238.InterfaceC4240
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo8352(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f8621) {
                this.f8621.position(0);
                messageDigest.update(this.f8621.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: u5$Ԩ, reason: contains not printable characters */
    public class C2290 implements C4238.InterfaceC4240<Integer> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ByteBuffer f8622 = ByteBuffer.allocate(4);

        @Override // defpackage.C4238.InterfaceC4240
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo8352(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f8622) {
                this.f8622.position(0);
                messageDigest.update(this.f8622.putInt(num.intValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: u5$Ԫ, reason: contains not printable characters */
    public static final class C2291 implements InterfaceC2293<AssetFileDescriptor> {
        public C2291() {
        }

        public /* synthetic */ C2291(C2289 c2289) {
            this();
        }

        @Override // defpackage.u5.InterfaceC2293
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo8355(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: u5$Ԭ, reason: contains not printable characters */
    public static class C2292 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public MediaMetadataRetriever m8357() {
            return new MediaMetadataRetriever();
        }
    }

    /* compiled from: VideoDecoder.java */
    @VisibleForTesting
    /* renamed from: u5$Ԯ, reason: contains not printable characters */
    public interface InterfaceC2293<T> {
        /* renamed from: Ϳ */
        void mo8355(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: u5$ՠ, reason: contains not printable characters */
    public static final class C2294 implements InterfaceC2293<ParcelFileDescriptor> {
        @Override // defpackage.u5.InterfaceC2293
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void mo8355(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) throws IllegalArgumentException {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public u5(InterfaceC2731 interfaceC2731, InterfaceC2293<T> interfaceC2293) {
        this(interfaceC2731, interfaceC2293, f8617);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static InterfaceC3907<AssetFileDescriptor, Bitmap> m8347(InterfaceC2731 interfaceC2731) {
        return new u5(interfaceC2731, new C2291(null));
    }

    @Nullable
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static Bitmap m8348(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmapM8350 = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f5362) ? null : m8350(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return bitmapM8350 == null ? m8349(mediaMetadataRetriever, j, i) : bitmapM8350;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Bitmap m8349(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    @TargetApi(27)
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static Bitmap m8350(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fMo4989 = downsampleStrategy.mo4989(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fMo4989), Math.round(fMo4989 * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static InterfaceC3907<ParcelFileDescriptor, Bitmap> m8351(InterfaceC2731 interfaceC2731) {
        return new u5(interfaceC2731, new C2294());
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ϳ */
    public boolean mo5017(@NonNull T t, @NonNull C3475 c3475) {
        return true;
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԩ */
    public InterfaceC4536<Bitmap> mo5018(@NonNull T t, int i, int i2, @NonNull C3475 c3475) throws IOException {
        long jLongValue = ((Long) c3475.m11329(f8615)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) c3475.m11329(f8616);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) c3475.m11329(DownsampleStrategy.f5364);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.f5363;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverM8357 = this.f8620.m8357();
        try {
            try {
                this.f8618.mo8355(mediaMetadataRetrieverM8357, t);
                Bitmap bitmapM8348 = m8348(mediaMetadataRetrieverM8357, jLongValue, num.intValue(), i, i2, downsampleStrategy2);
                mediaMetadataRetrieverM8357.release();
                return C2739.m9994(bitmapM8348, this.f8619);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverM8357.release();
            throw th;
        }
    }

    @VisibleForTesting
    public u5(InterfaceC2731 interfaceC2731, InterfaceC2293<T> interfaceC2293, C2292 c2292) {
        this.f8619 = interfaceC2731;
        this.f8618 = interfaceC2293;
        this.f8620 = c2292;
    }
}
