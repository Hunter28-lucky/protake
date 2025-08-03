package defpackage;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.blink.academy.film.zxing.CaptureActivity;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: DecodeHandler.java */
/* renamed from: ဝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class HandlerC5124 extends Handler {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final String f17032 = HandlerC5124.class.getSimpleName();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final CaptureActivity f17033;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final MultiFormatReader f17034;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f17035 = true;

    public HandlerC5124(CaptureActivity captureActivity, Map<DecodeHintType, Object> map) {
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        this.f17034 = multiFormatReader;
        multiFormatReader.setHints(map);
        this.f17033 = captureActivity;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m15030(PlanarYUVLuminanceSource planarYUVLuminanceSource, Bundle bundle) {
        int[] iArrRenderThumbnail = planarYUVLuminanceSource.renderThumbnail();
        int thumbnailWidth = planarYUVLuminanceSource.getThumbnailWidth();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArrRenderThumbnail, 0, thumbnailWidth, thumbnailWidth, planarYUVLuminanceSource.getThumbnailHeight(), Bitmap.Config.ARGB_8888);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", thumbnailWidth / planarYUVLuminanceSource.getWidth());
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null || !this.f17035) {
            return;
        }
        int i = message.what;
        if (i == 101) {
            m15031((byte[]) message.obj, message.arg1, message.arg2);
        } else {
            if (i != 105) {
                return;
            }
            this.f17035 = false;
            Looper.myLooper().quit();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m15031(byte[] bArr, int i, int i2) {
        Result resultDecodeWithState;
        long jNanoTime = System.nanoTime();
        PlanarYUVLuminanceSource planarYUVLuminanceSourceM13028 = this.f17033.m4740().m13028(bArr, i, i2);
        if (planarYUVLuminanceSourceM13028 != null) {
            try {
                resultDecodeWithState = this.f17034.decodeWithState(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSourceM13028)));
            } catch (ReaderException unused) {
            } finally {
                this.f17034.reset();
            }
        } else {
            resultDecodeWithState = null;
        }
        Handler handlerM4741 = this.f17033.m4741();
        if (resultDecodeWithState == null) {
            if (handlerM4741 != null) {
                Message.obtain(handlerM4741, 102).sendToTarget();
                return;
            }
            return;
        }
        long jNanoTime2 = System.nanoTime();
        Log.d(f17032, "Found barcode in " + TimeUnit.NANOSECONDS.toMillis(jNanoTime2 - jNanoTime) + " ms");
        if (handlerM4741 != null) {
            Message messageObtain = Message.obtain(handlerM4741, 103, resultDecodeWithState);
            Bundle bundle = new Bundle();
            m15030(planarYUVLuminanceSourceM13028, bundle);
            messageObtain.setData(bundle);
            messageObtain.sendToTarget();
        }
    }
}
