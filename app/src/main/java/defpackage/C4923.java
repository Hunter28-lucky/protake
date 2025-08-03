package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.C1840;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.InterfaceC3507;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* compiled from: ByteBufferGifDecoder.java */
/* renamed from: ำ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4923 implements InterfaceC3907<ByteBuffer, C3465> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C4924 f16607 = new C4924();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C4925 f16608 = new C4925();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f16609;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final List<ImageHeaderParser> f16610;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C4925 f16611;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C4924 f16612;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C4426 f16613;

    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: ำ$Ϳ, reason: contains not printable characters */
    public static class C4924 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public InterfaceC3507 m14656(InterfaceC3507.InterfaceC3508 interfaceC3508, C2883 c2883, ByteBuffer byteBuffer, int i) {
            return new h(interfaceC3508, c2883, byteBuffer, i);
        }
    }

    /* compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    /* renamed from: ำ$Ԩ, reason: contains not printable characters */
    public static class C4925 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Queue<C2512> f16614 = j5.m7088(0);

        /* renamed from: Ϳ, reason: contains not printable characters */
        public synchronized C2512 m14657(ByteBuffer byteBuffer) {
            C2512 c2512Poll;
            c2512Poll = this.f16614.poll();
            if (c2512Poll == null) {
                c2512Poll = new C2512();
            }
            return c2512Poll.m9279(byteBuffer);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public synchronized void m14658(C2512 c2512) {
            c2512.m9264();
            this.f16614.offer(c2512);
        }
    }

    public C4923(Context context, List<ImageHeaderParser> list, InterfaceC2731 interfaceC2731, InterfaceC4950 interfaceC4950) {
        this(context, list, interfaceC2731, interfaceC4950, f16608, f16607);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int m14652(C2883 c2883, int i, int i2) {
        int iMin = Math.min(c2883.m10232() / i2, c2883.m10235() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + c2883.m10235() + "x" + c2883.m10232() + "]");
        }
        return iMax;
    }

    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters */
    public final C2855 m14653(ByteBuffer byteBuffer, int i, int i2, C2512 c2512, C3475 c3475) {
        long jM14630 = C4904.m14630();
        try {
            C2883 c2883M9266 = c2512.m9266();
            if (c2883M9266.m10233() > 0 && c2883M9266.m10234() == 0) {
                Bitmap.Config config = c3475.m11329(C3605.f12533) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                InterfaceC3507 interfaceC3507M14656 = this.f16612.m14656(this.f16613, c2883M9266, byteBuffer, m14652(c2883M9266, i, i2));
                interfaceC3507M14656.mo6110(config);
                interfaceC3507M14656.mo6107();
                Bitmap bitmapMo6106 = interfaceC3507M14656.mo6106();
                if (bitmapMo6106 == null) {
                    return null;
                }
                C2855 c2855 = new C2855(new C3465(this.f16609, interfaceC3507M14656, n4.m7625(), i, i2, bitmapMo6106));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C4904.m14629(jM14630));
                }
                return c2855;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C4904.m14629(jM14630));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + C4904.m14629(jM14630));
            }
        }
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C2855 mo5018(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull C3475 c3475) {
        C2512 c2512M14657 = this.f16611.m14657(byteBuffer);
        try {
            return m14653(byteBuffer, i, i2, c2512M14657, c3475);
        } finally {
            this.f16611.m14658(c2512M14657);
        }
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull ByteBuffer byteBuffer, @NonNull C3475 c3475) throws IOException {
        return !((Boolean) c3475.m11329(C3605.f12534)).booleanValue() && C1840.m5023(this.f16610, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @VisibleForTesting
    public C4923(Context context, List<ImageHeaderParser> list, InterfaceC2731 interfaceC2731, InterfaceC4950 interfaceC4950, C4925 c4925, C4924 c4924) {
        this.f16609 = context.getApplicationContext();
        this.f16610 = list;
        this.f16612 = c4924;
        this.f16613 = new C4426(interfaceC2731, interfaceC4950);
        this.f16611 = c4925;
    }
}
