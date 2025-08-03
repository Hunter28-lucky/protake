package com.blink.academy.film.zxing;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import defpackage.C3867;
import defpackage.C4091;
import defpackage.s7;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
public final class CaptureActivityHandler extends Handler {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f4963 = CaptureActivityHandler.class.getSimpleName();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final CaptureActivity f4964;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3867 f4965;

    /* renamed from: ԩ, reason: contains not printable characters */
    public State f4966;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C4091 f4967;

    public enum State {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public CaptureActivityHandler(CaptureActivity captureActivity, Collection<BarcodeFormat> collection, Map<DecodeHintType, ?> map, String str, C4091 c4091) {
        this.f4964 = captureActivity;
        C3867 c3867 = new C3867(captureActivity, collection, map, str, new s7(captureActivity.m4742()));
        this.f4965 = c3867;
        c3867.start();
        this.f4966 = State.SUCCESS;
        this.f4967 = c4091;
        c4091.m13038();
        m4755();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ActivityInfo activityInfo;
        Bitmap bitmapCopy = null;
        str = null;
        String str = null;
        switch (message.what) {
            case 102:
                this.f4966 = State.PREVIEW;
                this.f4967.m13034(this.f4965.m12315(), 101);
                break;
            case 103:
                this.f4966 = State.SUCCESS;
                Bundle data = message.getData();
                float f = 1.0f;
                if (data != null) {
                    byte[] byteArray = data.getByteArray("barcode_bitmap");
                    bitmapCopy = byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, null).copy(Bitmap.Config.ARGB_8888, true) : null;
                    f = data.getFloat("barcode_scaled_factor");
                }
                this.f4964.m4743((Result) message.obj, bitmapCopy, f);
                break;
            case 104:
                String str2 = (String) message.obj;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(524288);
                intent.setData(Uri.parse(str2));
                ResolveInfo resolveInfoResolveActivity = this.f4964.getPackageManager().resolveActivity(intent, 65536);
                if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                    str = activityInfo.packageName;
                    Log.d(f4963, "Using browser in package " + str);
                }
                if (str != null && (str.equals("com.android.browser") || str.equals("com.android.chrome"))) {
                    intent.setPackage(str);
                    intent.addFlags(268435456);
                    intent.putExtra("com.android.browser.application_id", str);
                }
                try {
                    this.f4964.startActivity(intent);
                    break;
                } catch (ActivityNotFoundException unused) {
                    Log.w(f4963, "Can't find anything to handle VIEW of URI");
                    return;
                }
            case 106:
                m4755();
                break;
            case 107:
                this.f4964.setResult(-1, (Intent) message.obj);
                this.f4964.finish();
                break;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4754() {
        this.f4966 = State.DONE;
        this.f4967.m13039();
        Message.obtain(this.f4965.m12315(), 105).sendToTarget();
        try {
            this.f4965.join(500L);
        } catch (InterruptedException unused) {
        }
        removeMessages(103);
        removeMessages(102);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m4755() {
        if (this.f4966 == State.SUCCESS) {
            this.f4966 = State.PREVIEW;
            this.f4967.m13034(this.f4965.m12315(), 101);
            this.f4964.m4738();
        }
    }
}
