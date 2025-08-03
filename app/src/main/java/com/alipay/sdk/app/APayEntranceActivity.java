package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.ac;
import defpackage.pa;
import defpackage.q9;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class APayEntranceActivity extends Activity {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final ConcurrentHashMap<String, InterfaceC0071> f218 = new ConcurrentHashMap<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f219;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f220;

    /* renamed from: ԭ, reason: contains not printable characters */
    public pa f221;

    /* renamed from: com.alipay.sdk.app.APayEntranceActivity$Ϳ, reason: contains not printable characters */
    public interface InterfaceC0071 {
        void a(String str);
    }

    @Override // android.app.Activity
    public void finish() {
        String str = this.f220;
        q9.m8086(this.f221, "biz", "BSAFinish", str + "|" + TextUtils.isEmpty(this.f219));
        if (TextUtils.isEmpty(this.f219)) {
            this.f219 = ac.m23();
            pa paVar = this.f221;
            if (paVar != null) {
                paVar.m7953(true);
            }
        }
        if (str != null) {
            InterfaceC0071 interfaceC0071Remove = f218.remove(str);
            if (interfaceC0071Remove != null) {
                interfaceC0071Remove.a(this.f219);
            } else {
                q9.m8091(this.f221, "wr", "refNull", "session=" + str);
            }
        }
        try {
            super.finish();
        } catch (Throwable th) {
            q9.m8087(this.f221, "wr", "APStartFinish", th);
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        q9.m8086(this.f221, "biz", "BSAOnAR", this.f220 + "|" + i + Constants.ACCEPT_TIME_SEPARATOR_SP + i2);
        if (i == 1000) {
            if (intent != null) {
                try {
                    this.f219 = intent.getStringExtra("result");
                } catch (Throwable unused) {
                }
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            String string = extras.getString("ap_order_info");
            String string2 = extras.getString("ap_target_packagename");
            this.f220 = extras.getString("ap_session");
            String string3 = extras.getString("ap_local_info", "{}");
            if (!TextUtils.isEmpty(this.f220)) {
                pa paVarM7965 = pa.C2227.m7965(this.f220);
                this.f221 = paVarM7965;
                q9.m8086(paVarM7965, "biz", "BSAEntryCreate", this.f220 + "|" + SystemClock.elapsedRealtime());
            }
            Intent intent = new Intent();
            intent.putExtra("order_info", string);
            intent.putExtra("localInfo", string3);
            intent.setClassName(string2, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            try {
                startActivityForResult(intent, 1000);
            } catch (Throwable th) {
                q9.m8087(this.f221, "wr", "APStartEx", th);
                finish();
            }
            if (this.f221 != null) {
                Context applicationContext = getApplicationContext();
                pa paVar = this.f221;
                q9.m8090(applicationContext, paVar, string, paVar.f8291);
                this.f221.m7949(true);
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
