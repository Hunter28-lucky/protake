package com.blink.academy.film.zxing;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import defpackage.SharedPreferencesOnSharedPreferenceChangeListenerC4069;

/* loaded from: classes.dex */
public final class PreferencesActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getFragmentManager().beginTransaction().replace(R.id.content, new SharedPreferencesOnSharedPreferenceChangeListenerC4069()).commit();
    }
}
