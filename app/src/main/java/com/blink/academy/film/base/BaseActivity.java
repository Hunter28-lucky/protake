package com.blink.academy.film.base;

import androidx.appcompat.app.AppCompatActivity;
import com.umeng.analytics.MobclickAgent;
import defpackage.y0;

/* loaded from: classes.dex */
public class BaseActivity extends AppCompatActivity {
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m462() {
        y0.m8615(this);
    }
}
