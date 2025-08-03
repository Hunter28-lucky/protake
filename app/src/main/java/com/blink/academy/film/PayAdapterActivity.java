package com.blink.academy.film;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import defpackage.C4757;
import defpackage.r1;
import defpackage.y0;

/* loaded from: classes.dex */
public class PayAdapterActivity extends AppCompatActivity {

    /* renamed from: ؠ, reason: contains not printable characters */
    public static C4757.InterfaceC4768 f352;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f353;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f354;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f355;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f356;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f357;

    /* renamed from: ՠ, reason: contains not printable characters */
    public String f358;

    /* renamed from: ֈ, reason: contains not printable characters */
    public boolean f359;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f360 = -1;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Handler f361 = new Handler();

    /* renamed from: com.blink.academy.film.PayAdapterActivity$Ϳ, reason: contains not printable characters */
    public class C0102 implements C4757.InterfaceC4768 {
        public C0102() {
        }

        @Override // defpackage.C4757.InterfaceC4768
        public void onFail() {
            C4757.InterfaceC4768 interfaceC4768 = PayAdapterActivity.f352;
            if (interfaceC4768 != null) {
                interfaceC4768.onFail();
            }
            PayAdapterActivity.this.finish();
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo437() {
            C4757.InterfaceC4768 interfaceC4768 = PayAdapterActivity.f352;
            if (interfaceC4768 != null) {
                interfaceC4768.mo437();
            }
            PayAdapterActivity.this.finish();
        }

        @Override // defpackage.C4757.InterfaceC4768
        /* renamed from: Ԩ, reason: contains not printable characters */
        public void mo438() {
            C4757.InterfaceC4768 interfaceC4768 = PayAdapterActivity.f352;
            if (interfaceC4768 != null) {
                interfaceC4768.mo438();
            }
            PayAdapterActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public /* synthetic */ void m435() {
        if (isFinishing()) {
            return;
        }
        finish();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m436(Context context, int i, String str, String str2, String str3, String str4, String str5, boolean z, C4757.InterfaceC4768 interfaceC4768) {
        Intent intent = new Intent(context, (Class<?>) PayAdapterActivity.class);
        intent.putExtra("payType", i);
        intent.putExtra("uid", str);
        intent.putExtra("access_token", str2);
        intent.putExtra("proId", str3);
        intent.putExtra("googleId", str4);
        intent.putExtra("huaweiId", str5);
        intent.putExtra("isSub", z);
        f352 = interfaceC4768;
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).overridePendingTransition(0, 0);
        }
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        Handler handler = this.f361;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f361 = null;
        }
        overridePendingTransition(0, 0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        window.setGravity(51);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        attributes.height = 1;
        attributes.width = 1;
        window.setAttributes(attributes);
        this.f353 = getIntent().getIntExtra("payType", 0);
        this.f354 = getIntent().getStringExtra("uid");
        this.f355 = getIntent().getStringExtra("access_token");
        this.f356 = getIntent().getStringExtra("proId");
        this.f357 = getIntent().getStringExtra("googleId");
        this.f358 = getIntent().getStringExtra("huaweiId");
        this.f359 = getIntent().getBooleanExtra("isSub", true);
        if (!r1.m8138(this.f356) || !r1.m8138(this.f357) || !r1.m8138(this.f358)) {
            C4757.m14304().m14316(this, this.f353, this.f354, this.f355, this.f356, this.f357, this.f358, this.f359, new C0102());
            return;
        }
        C4757.InterfaceC4768 interfaceC4768 = f352;
        if (interfaceC4768 != null) {
            interfaceC4768.onFail();
        }
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        f352 = null;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f360 = 1;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Handler handler;
        super.onResume();
        if (this.f360 != 1 || (handler = this.f361) == null) {
            return;
        }
        handler.postDelayed(new Runnable() { // from class: ழ
            @Override // java.lang.Runnable
            public final void run() {
                this.f15391.m435();
            }
        }, 1500L);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            y0.m8615(this);
        }
    }
}
