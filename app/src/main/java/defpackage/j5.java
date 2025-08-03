package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class j5 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final char[] f7737 = "0123456789abcdef".toCharArray();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final char[] f7738 = new char[64];

    /* compiled from: Util.java */
    /* renamed from: j5$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C2122 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f7739;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f7739 = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7739[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7739[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7739[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7739[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m7084() {
        if (!m7099()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m7085(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj instanceof InterfaceC5098 ? ((InterfaceC5098) obj).m14927(obj2) : obj.equals(obj2);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m7086(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public static String m7087(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & ExifInterface.MARKER;
            int i3 = i * 2;
            char[] cArr2 = f7737;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> Queue<T> m7088(int i) {
        return new ArrayDeque(i);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int m7089(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * m7091(config);
    }

    @TargetApi(19)
    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m7090(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getHeight() * bitmap.getRowBytes();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int m7091(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = C2122.f7739[config.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2 || i == 3) {
            return 2;
        }
        return i != 4 ? 4 : 8;
    }

    @NonNull
    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> List<T> m7092(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int m7093(float f) {
        return m7094(f, 17);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int m7094(float f, int i) {
        return m7095(Float.floatToIntBits(f), i);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static int m7095(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static int m7096(@Nullable Object obj, int i) {
        return m7095(obj == null ? 0 : obj.hashCode(), i);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static int m7097(boolean z, int i) {
        return m7095(z ? 1 : 0, i);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static boolean m7098() {
        return !m7099();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static boolean m7099() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static boolean m7100(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static boolean m7101(int i, int i2) {
        return m7100(i) && m7100(i2);
    }

    @NonNull
    /* renamed from: ބ, reason: contains not printable characters */
    public static String m7102(@NonNull byte[] bArr) {
        String strM7087;
        char[] cArr = f7738;
        synchronized (cArr) {
            strM7087 = m7087(bArr, cArr);
        }
        return strM7087;
    }
}
