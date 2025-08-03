package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.alipay.sdk.m.x.c;
import com.alipay.sdk.m.x.d;
import com.google.android.gms.common.internal.ImagesContract;
import com.xiaomi.mipush.sdk.Constants;
import defpackage.ac;
import defpackage.hf;
import defpackage.je;
import defpackage.p9;
import defpackage.pa;
import defpackage.q9;
import defpackage.ug;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class H5PayActivity extends Activity {

    /* renamed from: ԫ, reason: contains not printable characters */
    public c f229;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f230;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f231;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f232;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f233;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f234;

    /* renamed from: ֈ, reason: contains not printable characters */
    public String f235;

    /* renamed from: ֏, reason: contains not printable characters */
    public WeakReference<pa> f236;

    @Override // android.app.Activity
    public void finish() {
        mo316();
        super.finish();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1010) {
            je.m7115((pa) ug.m8403(this.f236), i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        c cVar = this.f229;
        if (cVar == null) {
            finish();
            return;
        }
        if (cVar.m347()) {
            cVar.mo348();
            return;
        }
        if (!cVar.mo348()) {
            super.onBackPressed();
        }
        ac.m25(ac.m23());
        finish();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        m317();
        super.onCreate(bundle);
        try {
            pa paVarM7964 = pa.C2227.m7964(getIntent());
            if (paVarM7964 == null) {
                finish();
                return;
            }
            this.f236 = new WeakReference<>(paVarM7964);
            if (p9.m7898().m7935()) {
                setRequestedOrientation(3);
            } else {
                setRequestedOrientation(1);
            }
            try {
                Bundle extras = getIntent().getExtras();
                String string = extras.getString(ImagesContract.URL, null);
                this.f230 = string;
                if (!ug.m8444(string)) {
                    finish();
                    return;
                }
                this.f232 = extras.getString("cookie", null);
                this.f231 = extras.getString("method", null);
                this.f233 = extras.getString("title", null);
                this.f235 = extras.getString(Constants.VERSION, "v1");
                this.f234 = extras.getBoolean("backisexit", false);
                try {
                    d dVar = new d(this, paVarM7964, this.f235);
                    setContentView(dVar);
                    dVar.m364(this.f233, this.f231, this.f234);
                    dVar.m346(this.f230, this.f232);
                    dVar.m362(this.f230);
                    this.f229 = dVar;
                } catch (Throwable th) {
                    q9.m8087(paVarM7964, "biz", "GetInstalledAppEx", th);
                    finish();
                }
            } catch (Exception unused) {
                finish();
            }
        } catch (Exception unused2) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        c cVar = this.f229;
        if (cVar != null) {
            cVar.mo349();
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        try {
            super.setRequestedOrientation(i);
        } catch (Throwable th) {
            try {
                q9.m8087((pa) ug.m8403(this.f236), "biz", "H5PayDataAnalysisError", th);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: Ϳ */
    public void mo316() {
        Object obj = PayTask.h;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m317() {
        try {
            super.requestWindowFeature(1);
            getWindow().addFlags(8192);
        } catch (Throwable th) {
            hf.m6205(th);
        }
    }
}
