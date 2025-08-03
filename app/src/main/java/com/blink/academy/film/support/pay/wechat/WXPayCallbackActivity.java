package com.blink.academy.film.support.pay.wechat;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import defpackage.C4638;
import defpackage.t7;

/* loaded from: classes.dex */
public class WXPayCallbackActivity extends AppCompatActivity implements IWXAPIEventHandler {
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (t7.m8288() != null) {
            t7.m8288().m8293().handleIntent(getIntent(), this);
        } else {
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (t7.m8288() != null) {
            t7.m8288().m8293().handleIntent(intent, this);
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(BaseReq baseReq) {
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(BaseResp baseResp) {
        if (baseResp.getType() != 5 || t7.m8288() == null) {
            return;
        }
        if (baseResp.errStr != null) {
            C4638.m14099("WXPayCallbackActivity", "errstr=" + baseResp.errStr);
        }
        t7.m8288().m8294(baseResp.errCode);
        finish();
    }
}
