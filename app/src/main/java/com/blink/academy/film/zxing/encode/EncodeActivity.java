package com.blink.academy.film.zxing.encode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.blink.academy.protake.R;
import com.google.zxing.WriterException;
import defpackage.C3108;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class EncodeActivity extends Activity {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final String f5043 = "EncodeActivity";

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Pattern f5044 = Pattern.compile("[^A-Za-z0-9]");

    /* renamed from: ԫ, reason: contains not printable characters */
    public C3108 f5045;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String action = intent.getAction();
        if ("com.google.zxing.client.android.ENCODE".equals(action) || "android.intent.action.SEND".equals(action)) {
            setContentView(R.layout.encode);
        } else {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int iMin = (Math.min(point.x, point.y) * 7) / 8;
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        try {
            intent.getBooleanExtra("USE_VCARD", false);
            Bitmap bitmapM10698 = this.f5045.m10698();
            if (bitmapM10698 == null) {
                Log.w(f5043, "Could not encode barcode");
                this.f5045 = null;
                return;
            }
            ((ImageView) findViewById(R.id.image_view)).setImageBitmap(bitmapM10698);
            TextView textView = (TextView) findViewById(R.id.contents_text_view);
            if (intent.getBooleanExtra("ENCODE_SHOW_CONTENTS", true)) {
                textView.setText(this.f5045.m10700());
                setTitle(this.f5045.m10701());
            } else {
                textView.setText("");
                setTitle("");
            }
        } catch (WriterException e2) {
            Log.w(f5043, "Could not encode barcode", e2);
            this.f5045 = null;
        }
    }
}
