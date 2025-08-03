package com.blink.academy.film.zxing;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.base.BaseActivity;
import com.blink.academy.protake.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import defpackage.AbstractC4012;
import defpackage.AbstractC4118;
import defpackage.C2579;
import defpackage.C2580;
import defpackage.C3088;
import defpackage.C3178;
import defpackage.C3985;
import defpackage.C4008;
import defpackage.C4091;
import defpackage.C4505;
import defpackage.C4535;
import defpackage.C4638;
import defpackage.C4647;
import defpackage.C4792;
import defpackage.C4891;
import defpackage.C4929;
import defpackage.DialogInterfaceOnClickListenerC3870;
import defpackage.r1;
import defpackage.z0;
import java.io.IOException;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback {

    /* renamed from: ގ, reason: contains not printable characters */
    public static final String f4933 = CaptureActivity.class.getSimpleName();

    /* renamed from: ޏ, reason: contains not printable characters */
    public static final Collection<ResultMetadataType> f4934 = EnumSet.of(ResultMetadataType.ISSUE_NUMBER, ResultMetadataType.SUGGESTED_PRICE, ResultMetadataType.ERROR_CORRECTION_LEVEL, ResultMetadataType.POSSIBLE_COUNTRY);

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f4935 = false;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C4091 f4936;

    /* renamed from: ԭ, reason: contains not printable characters */
    public CaptureActivityHandler f4937;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Result f4938;

    /* renamed from: ԯ, reason: contains not printable characters */
    public ViewfinderView f4939;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Result f4940;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f4941;

    /* renamed from: ֏, reason: contains not printable characters */
    public IntentSource f4942;

    /* renamed from: ׯ, reason: contains not printable characters */
    public String f4943;

    /* renamed from: ؠ, reason: contains not printable characters */
    public C4505 f4944;

    /* renamed from: ހ, reason: contains not printable characters */
    public Collection<BarcodeFormat> f4945;

    /* renamed from: ށ, reason: contains not printable characters */
    public Map<DecodeHintType, ?> f4946;

    /* renamed from: ނ, reason: contains not printable characters */
    public String f4947;

    /* renamed from: ރ, reason: contains not printable characters */
    public C4891 f4948;

    /* renamed from: ބ, reason: contains not printable characters */
    public C3985 f4949;

    /* renamed from: ޅ, reason: contains not printable characters */
    public ImageView f4950;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f4951;

    /* renamed from: އ, reason: contains not printable characters */
    public int f4952;

    /* renamed from: ވ, reason: contains not printable characters */
    public SurfaceView f4953;

    /* renamed from: މ, reason: contains not printable characters */
    public int f4954;

    /* renamed from: ފ, reason: contains not printable characters */
    public int f4955;

    /* renamed from: ދ, reason: contains not printable characters */
    public View f4956;

    /* renamed from: ތ, reason: contains not printable characters */
    public boolean f4957;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f4958;

    /* renamed from: com.blink.academy.film.zxing.CaptureActivity$Ϳ, reason: contains not printable characters */
    public class RunnableC1783 implements Runnable {
        public RunnableC1783() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4008.m12876(CaptureActivity.this.f4956, 0.0f, 200, null);
        }
    }

    /* renamed from: com.blink.academy.film.zxing.CaptureActivity$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC1784 implements View.OnClickListener {
        public ViewOnClickListenerC1784() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CaptureActivity.this.setResult(0);
            CaptureActivity.this.m4739();
        }
    }

    /* renamed from: com.blink.academy.film.zxing.CaptureActivity$Ԫ, reason: contains not printable characters */
    public class C1785 extends AbstractC4012 {
        public C1785() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            CaptureActivity.this.finish();
            CaptureActivity.this.overridePendingTransition(0, 0);
        }
    }

    /* renamed from: com.blink.academy.film.zxing.CaptureActivity$Ԭ, reason: contains not printable characters */
    public static /* synthetic */ class C1786 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f4962;

        static {
            int[] iArr = new int[IntentSource.values().length];
            f4962 = iArr;
            try {
                iArr[IntentSource.NATIVE_APP_INTENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4962[IntentSource.PRODUCT_SEARCH_LINK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4962[IntentSource.ZXING_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4962[IntentSource.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static boolean m4735(String str) {
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        getWindow().setBackgroundDrawable(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
        int iM9446 = C2579.m9446(this);
        boolean booleanExtra = getIntent().getBooleanExtra("isPortrait", false);
        this.f4957 = booleanExtra;
        if (booleanExtra && iM9446 != 1) {
            setRequestedOrientation(1);
            this.f4958 = true;
        }
        super.onCreate(bundle);
        C3088.m10679().mo10680(this);
        getWindow().addFlags(128);
        setContentView(R.layout.capture);
        this.f4941 = false;
        this.f4948 = new C4891(this);
        this.f4949 = new C3985(this);
        z0.m8635(this);
        m4748();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.f4948.m14622();
        super.onDestroy();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            IntentSource intentSource = this.f4942;
            if (intentSource == IntentSource.NATIVE_APP_INTENT) {
                setResult(0);
                m4739();
                return true;
            }
            if ((intentSource == IntentSource.NONE || intentSource == IntentSource.ZXING_LINK) && this.f4940 != null) {
                m4752(0L);
                return true;
            }
        } else if (i == 27 || i == 80) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f4958) {
            return;
        }
        CaptureActivityHandler captureActivityHandler = this.f4937;
        if (captureActivityHandler != null) {
            captureActivityHandler.m4754();
            this.f4937 = null;
        }
        this.f4948.m14620();
        this.f4949.m12848();
        this.f4936.m13029();
        if (this.f4941) {
            return;
        }
        ((SurfaceView) findViewById(R.id.preview_view)).getHolder().removeCallback(this);
    }

    @Override // com.blink.academy.film.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        int intExtra;
        super.onResume();
        if (this.f4958) {
            return;
        }
        this.f4936 = new C4091(FilmApp.m402());
        if (this.f4957) {
            this.f4954 = C2579.m9440(this);
            this.f4955 = C2579.m9439(this);
            this.f4951 = C2579.f9593;
            this.f4952 = C2579.f9594;
        } else {
            this.f4954 = C2579.m9440(this);
            this.f4955 = C2579.m9439(this);
            this.f4951 = C2579.f9593;
            this.f4952 = C2579.f9594;
        }
        m4749();
        m4750();
        m4747();
        this.f4937 = null;
        this.f4940 = null;
        m4751();
        this.f4949.m12847(this.f4936);
        this.f4948.m14621();
        Intent intent = getIntent();
        this.f4942 = IntentSource.NONE;
        this.f4943 = null;
        this.f4944 = null;
        this.f4945 = null;
        this.f4947 = null;
        if (intent != null) {
            String action = intent.getAction();
            String dataString = intent.getDataString();
            if ("com.google.zxing.client.android.SCAN".equals(action)) {
                this.f4942 = IntentSource.NATIVE_APP_INTENT;
                this.f4945 = C2580.m9453(intent);
                this.f4946 = C3178.m10786(intent);
                if (intent.hasExtra("SCAN_WIDTH") && intent.hasExtra("SCAN_HEIGHT")) {
                    int intExtra2 = intent.getIntExtra("SCAN_WIDTH", 0);
                    int intExtra3 = intent.getIntExtra("SCAN_HEIGHT", 0);
                    if (intExtra2 > 0 && intExtra3 > 0) {
                        this.f4936.m13036(intExtra2, intExtra3);
                    }
                }
                if (intent.hasExtra("SCAN_CAMERA_ID") && (intExtra = intent.getIntExtra("SCAN_CAMERA_ID", -1)) >= 0) {
                    this.f4936.m13035(intExtra);
                }
                intent.getStringExtra("PROMPT_MESSAGE");
            } else if (m4735(dataString)) {
                this.f4942 = IntentSource.ZXING_LINK;
                this.f4943 = dataString;
                Uri uri = Uri.parse(dataString);
                this.f4944 = new C4505(uri);
                this.f4945 = C2580.m9454(uri);
                this.f4946 = C3178.m10787(uri);
            }
            this.f4947 = intent.getStringExtra("CHARACTER_SET");
        }
        SurfaceHolder holder = this.f4953.getHolder();
        if (this.f4941) {
            m4746(holder);
        } else {
            holder.addCallback(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            m462();
            if (this.f4958) {
                return;
            }
            this.f4956.postDelayed(new RunnableC1783(), 400L);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(f4933, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (this.f4941) {
            return;
        }
        this.f4941 = true;
        m4746(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4941 = false;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m4736(Bitmap bitmap, Result result) {
        CaptureActivityHandler captureActivityHandler = this.f4937;
        if (captureActivityHandler == null) {
            this.f4938 = result;
            return;
        }
        if (result != null) {
            this.f4938 = result;
        }
        Result result2 = this.f4938;
        if (result2 != null) {
            this.f4937.sendMessage(Message.obtain(captureActivityHandler, 103, result2));
        }
        this.f4938 = null;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m4737() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setOnCancelListener(new DialogInterfaceOnClickListenerC3870(this));
        builder.show();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m4738() {
        this.f4939.m4766();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m4739() {
        C4008.m12876(this.f4956, 1.0f, 100, new C1785());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4091 m4740() {
        return this.f4936;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public Handler m4741() {
        return this.f4937;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public ViewfinderView m4742() {
        return this.f4939;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m4743(Result result, Bitmap bitmap, float f) {
        this.f4948.m14619();
        this.f4940 = result;
        AbstractC4118 abstractC4118M14117 = C4647.m14117(this, result);
        boolean z = bitmap != null;
        int i = C1786.f4962[this.f4942.ordinal()];
        if (i == 1 || i == 2) {
            m4744(result, abstractC4118M14117, bitmap);
            return;
        }
        if (i == 3) {
            C4505 c4505 = this.f4944;
            if (c4505 == null || !c4505.m13805()) {
                m4745(result, abstractC4118M14117, bitmap);
                return;
            } else {
                m4744(result, abstractC4118M14117, bitmap);
                return;
            }
        }
        if (i != 4) {
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (z && defaultSharedPreferences.getBoolean("preferences_bulk_mode", false)) {
            m4752(0L);
        } else {
            m4745(result, abstractC4118M14117, bitmap);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m4744(Result result, AbstractC4118 abstractC4118, Bitmap bitmap) {
        C4505 c4505;
        long longExtra = getIntent() != null ? getIntent().getLongExtra("RESULT_DISPLAY_DURATION_MS", 0L) : 0L;
        int i = C1786.f4962[this.f4942.ordinal()];
        int i2 = 0;
        if (i != 1) {
            if (i != 2) {
                if (i == 3 && (c4505 = this.f4944) != null && c4505.m13805()) {
                    Object objM13804 = this.f4944.m13804(result, abstractC4118);
                    this.f4944 = null;
                    m4753(104, objM13804, longExtra);
                    return;
                }
                return;
            }
            m4753(104, this.f4943.substring(0, this.f4943.lastIndexOf("/scan")) + "?q=" + ((Object) abstractC4118.m13062()) + "&source=zxing", longExtra);
            return;
        }
        Intent intent = new Intent(getIntent().getAction());
        intent.addFlags(524288);
        intent.putExtra("SCAN_RESULT", result.toString());
        intent.putExtra("SCAN_RESULT_FORMAT", result.getBarcodeFormat().toString());
        byte[] rawBytes = result.getRawBytes();
        if (rawBytes != null && rawBytes.length > 0) {
            intent.putExtra("SCAN_RESULT_BYTES", rawBytes);
        }
        Map<ResultMetadataType, Object> resultMetadata = result.getResultMetadata();
        if (resultMetadata != null) {
            ResultMetadataType resultMetadataType = ResultMetadataType.UPC_EAN_EXTENSION;
            if (resultMetadata.containsKey(resultMetadataType)) {
                intent.putExtra("SCAN_RESULT_UPC_EAN_EXTENSION", resultMetadata.get(resultMetadataType).toString());
            }
            Number number = (Number) resultMetadata.get(ResultMetadataType.ORIENTATION);
            if (number != null) {
                intent.putExtra("SCAN_RESULT_ORIENTATION", number.intValue());
            }
            String str = (String) resultMetadata.get(ResultMetadataType.ERROR_CORRECTION_LEVEL);
            if (str != null) {
                intent.putExtra("SCAN_RESULT_ERROR_CORRECTION_LEVEL", str);
            }
            Iterable iterable = (Iterable) resultMetadata.get(ResultMetadataType.BYTE_SEGMENTS);
            if (iterable != null) {
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    intent.putExtra("SCAN_RESULT_BYTE_SEGMENTS_" + i2, (byte[]) it.next());
                    i2++;
                }
            }
        }
        m4753(107, intent, longExtra);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m4745(Result result, AbstractC4118 abstractC4118, Bitmap bitmap) {
        if (abstractC4118.m13061() != null) {
            abstractC4118.mo7996(abstractC4118.m13061().intValue());
            return;
        }
        CharSequence charSequenceM13062 = abstractC4118.m13062();
        if (!r1.m8141(charSequenceM13062)) {
            if (this.f4935) {
                C4638.m14098("ScanQrCode: " + ((Object) null));
                return;
            }
            return;
        }
        try {
            if (this.f4935) {
                C4638.m14099("WME", "未解码： " + charSequenceM13062.toString());
            }
            String strM14661 = C4929.m14661(charSequenceM13062.toString());
            if (r1.m8143(strM14661)) {
                if (this.f4935) {
                    C4638.m14099(f4933, "scan qrcode content: " + strM14661);
                }
                Intent intent = new Intent();
                intent.putExtra("qr_result", C4535.m13880().m13912(strM14661));
                setResult(-1, intent);
                m4739();
            }
        } catch (Exception e2) {
            m4752(0L);
            if (this.f4935) {
                C4638.m14098("ScanQrCode: " + e2.toString() + "   " + e2.getMessage());
            }
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m4746(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (this.f4936.m13032()) {
            Log.w(f4933, "initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            this.f4936.m13033(surfaceHolder);
            if (this.f4937 == null) {
                this.f4937 = new CaptureActivityHandler(this, this.f4945, this.f4946, this.f4947, this.f4936);
            }
            m4736(null, null);
        } catch (IOException e2) {
            Log.w(f4933, e2);
            m4737();
        } catch (RuntimeException e3) {
            Log.w(f4933, "Unexpected error initializing camera", e3);
            m4737();
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m4747() {
        this.f4950 = (ImageView) findViewById(R.id.iv_close);
        View viewFindViewById = findViewById(R.id.close);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f4950.getLayoutParams();
        if (this.f4957) {
            int iM14476 = C4792.m14375().m14476(54);
            layoutParams.width = iM14476;
            layoutParams.height = iM14476;
            layoutParams.rightMargin = C4792.m14375().m14449();
        } else {
            int i = this.f4954;
            layoutParams.width = (int) (i * 0.044235926f);
            layoutParams.height = (int) (i * 0.044235926f);
            layoutParams.rightMargin = C4792.m14375().m14470(0);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById.getLayoutParams();
        int i2 = (int) (this.f4954 * 0.14477211f);
        layoutParams2.width = i2;
        layoutParams2.height = i2;
        if (this.f4957) {
            layoutParams2.topMargin = (int) (((C4792.m14375().m14451() - layoutParams2.height) / 2.0f) + C4792.m14375().m14442());
        }
        layoutParams2.rightMargin = layoutParams.rightMargin - ((layoutParams2.width - layoutParams.width) / 2);
        viewFindViewById.setLayoutParams(layoutParams2);
        layoutParams.topMargin = (int) (layoutParams2.topMargin + ((layoutParams2.height - layoutParams.height) / 2.0f));
        this.f4950.setLayoutParams(layoutParams);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC1784());
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m4748() {
        this.f4956 = findViewById(R.id.camera_cover_view);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m4749() {
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        this.f4953 = surfaceView;
        ViewGroup.LayoutParams layoutParams = surfaceView.getLayoutParams();
        layoutParams.width = this.f4952;
        layoutParams.height = this.f4951;
        this.f4953.setLayoutParams(layoutParams);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m4750() {
        ViewfinderView viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.f4939 = viewfinderView;
        viewfinderView.setCameraManager(this.f4936);
        ViewGroup.LayoutParams layoutParams = this.f4939.getLayoutParams();
        layoutParams.width = this.f4952;
        layoutParams.height = this.f4951;
        this.f4939.setLayoutParams(layoutParams);
        this.f4939.setRectWidth(C2579.m9438(250.0f));
        this.f4939.setTopOffset(C2579.m9438(40.0f));
        this.f4939.setToolbarHeight(C2579.m9438(56.0f));
        this.f4939.setTipTextSize(C4792.m14375().m14378());
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final void m4751() {
        this.f4939.setVisibility(0);
        this.f4940 = null;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public void m4752(long j) {
        CaptureActivityHandler captureActivityHandler = this.f4937;
        if (captureActivityHandler != null) {
            captureActivityHandler.sendEmptyMessageDelayed(106, j);
        }
        m4751();
    }

    /* renamed from: އ, reason: contains not printable characters */
    public final void m4753(int i, Object obj, long j) {
        CaptureActivityHandler captureActivityHandler = this.f4937;
        if (captureActivityHandler != null) {
            Message messageObtain = Message.obtain(captureActivityHandler, i, obj);
            if (j > 0) {
                this.f4937.sendMessageDelayed(messageObtain, j);
            } else {
                this.f4937.sendMessage(messageObtain);
            }
        }
    }
}
