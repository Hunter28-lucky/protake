package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* compiled from: TransformationUtils.java */
/* loaded from: classes.dex */
public final class b3 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Paint f108 = new Paint(6);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Paint f109 = new Paint(7);

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Paint f110;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Set<String> f111;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Lock f112;

    /* compiled from: TransformationUtils.java */
    /* renamed from: b3$Ϳ, reason: contains not printable characters */
    public static final class LockC0044 implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @NonNull
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f111 = hashSet;
        f112 = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new LockC0044();
        Paint paint = new Paint(7);
        f110 = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m112(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2, Matrix matrix) {
        Lock lock = f112;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f108);
            m115(canvas);
            lock.unlock();
        } catch (Throwable th) {
            f112.unlock();
            throw th;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Bitmap m113(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2) {
        float width;
        float height;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i2 > bitmap.getHeight() * i) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i / bitmap.getWidth();
            height = (i2 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapMo9982 = interfaceC2731.mo9982(i, i2, m119(bitmap));
        m123(bitmap, bitmapMo9982);
        m112(bitmap, bitmapMo9982, matrix);
        return bitmapMo9982;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static Bitmap m114(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return m116(interfaceC2731, bitmap, i, i2);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m115(Canvas canvas) {
        canvas.setBitmap(null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static Bitmap m116(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmapMo9982 = interfaceC2731.mo9982((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), m119(bitmap));
        m123(bitmap, bitmapMo9982);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapMo9982.getWidth() + "x" + bitmapMo9982.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        m112(bitmap, bitmapMo9982, matrix);
        return bitmapMo9982;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static Lock m117() {
        return f112;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m118(int i) {
        switch (i) {
            case 3:
            case 4:
                return MPEGConst.SEQUENCE_ERROR_CODE;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @NonNull
    /* renamed from: Ԯ, reason: contains not printable characters */
    public static Bitmap.Config m119(@NonNull Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @VisibleForTesting
    /* renamed from: ԯ, reason: contains not printable characters */
    public static void m120(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static boolean m121(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static Bitmap m122(@NonNull InterfaceC2731 interfaceC2731, @NonNull Bitmap bitmap, int i) {
        if (!m121(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        m120(i, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapMo9982 = interfaceC2731.mo9982(Math.round(rectF.width()), Math.round(rectF.height()), m119(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        m112(bitmap, bitmapMo9982, matrix);
        return bitmapMo9982;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static void m123(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
