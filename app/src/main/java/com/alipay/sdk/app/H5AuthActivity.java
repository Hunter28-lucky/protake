package com.alipay.sdk.app;

/* loaded from: classes.dex */
public class H5AuthActivity extends H5PayActivity {
    @Override // com.alipay.sdk.app.H5PayActivity
    /* renamed from: Ϳ, reason: contains not printable characters */
    public void mo316() {
        Object obj = AuthTask.c;
        synchronized (obj) {
            try {
                obj.notify();
            } catch (Exception unused) {
            }
        }
    }
}
