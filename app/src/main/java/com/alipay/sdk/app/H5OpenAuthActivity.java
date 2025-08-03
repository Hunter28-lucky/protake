package com.alipay.sdk.app;

import android.content.Intent;
import android.net.Uri;
import defpackage.pa;
import defpackage.q9;

/* loaded from: classes.dex */
public class H5OpenAuthActivity extends H5PayActivity {

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f228 = false;

    @Override // com.alipay.sdk.app.H5PayActivity, android.app.Activity
    public void onDestroy() {
        if (this.f228) {
            try {
                pa paVarM7964 = pa.C2227.m7964(getIntent());
                if (paVarM7964 != null) {
                    q9.m8092(this, paVarM7964, "", paVarM7964.f8291);
                }
            } catch (Throwable unused) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            pa paVarM7964 = pa.C2227.m7964(intent);
            try {
                super.startActivity(intent);
                Uri data = intent != null ? intent.getData() : null;
                if (data == null || !data.toString().startsWith("alipays://platformapi/startapp")) {
                    return;
                }
                finish();
            } catch (Throwable th) {
                String string = (intent == null || intent.getData() == null) ? "null" : intent.getData().toString();
                if (paVarM7964 != null) {
                    q9.m8088(paVarM7964, "biz", "StartActivityEx", th, string);
                }
                this.f228 = true;
                throw th;
            }
        } catch (Throwable unused) {
            finish();
        }
    }

    @Override // com.alipay.sdk.app.H5PayActivity
    /* renamed from: Ϳ */
    public void mo316() {
    }
}
