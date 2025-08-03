package defpackage;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.blink.academy.film.zxing.CaptureActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.ResultPointCallback;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: DecodeThread.java */
/* renamed from: ߧ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3867 extends Thread {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final CaptureActivity f13303;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Map<DecodeHintType, Object> f13304;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Handler f13305;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final CountDownLatch f13306 = new CountDownLatch(1);

    public C3867(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, ResultPointCallback resultPointCallback) {
        this.f13303 = captureActivity;
        EnumMap enumMap = new EnumMap(DecodeHintType.class);
        this.f13304 = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(captureActivity);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(C2580.f9603);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(C2580.f9604);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(C2580.f9606);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(C2580.f9607);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(C2580.f9608);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(C2580.f9609);
            }
        }
        enumMap.put((EnumMap) DecodeHintType.POSSIBLE_FORMATS, (DecodeHintType) collection);
        if (str != null) {
            enumMap.put((EnumMap) DecodeHintType.CHARACTER_SET, (DecodeHintType) str);
        }
        enumMap.put((EnumMap) DecodeHintType.NEED_RESULT_POINT_CALLBACK, (DecodeHintType) resultPointCallback);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f13305 = new HandlerC5124(this.f13303, this.f13304);
        this.f13306.countDown();
        Looper.loop();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Handler m12315() throws InterruptedException {
        try {
            this.f13306.await();
        } catch (InterruptedException unused) {
        }
        return this.f13305;
    }
}
