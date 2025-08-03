package defpackage;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import com.blink.academy.protake.R;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* compiled from: PreferencesFragment.java */
/* renamed from: झ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class SharedPreferencesOnSharedPreferenceChangeListenerC4069 extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public CheckBoxPreference[] f14156;

    /* compiled from: PreferencesFragment.java */
    /* renamed from: झ$Ԩ, reason: contains not printable characters */
    public final class C4071 implements Preference.OnPreferenceChangeListener {
        public C4071() {
        }

        @Override // android.preference.Preference.OnPreferenceChangeListener
        public boolean onPreferenceChange(Preference preference, Object obj) {
            if (m13008(obj)) {
                return true;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(SharedPreferencesOnSharedPreferenceChangeListenerC4069.this.getActivity());
            builder.setCancelable(true);
            builder.show();
            return false;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final boolean m13008(Object obj) {
            if (obj == null) {
                return true;
            }
            String string = obj.toString();
            if (string.isEmpty()) {
                return true;
            }
            try {
                return new URI(string.replaceAll("%[st]", "").replaceAll("%f(?![0-9a-f])", "")).getScheme() != null;
            } catch (URISyntaxException unused) {
                return false;
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static CheckBoxPreference[] m13006(PreferenceScreen preferenceScreen, String... strArr) {
        CheckBoxPreference[] checkBoxPreferenceArr = new CheckBoxPreference[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            checkBoxPreferenceArr[i] = (CheckBoxPreference) preferenceScreen.findPreference(strArr[i]);
        }
        return checkBoxPreferenceArr;
    }

    @Override // android.preference.PreferenceFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        preferenceScreen.getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        this.f14156 = m13006(preferenceScreen, "preferences_decode_1D_product", "preferences_decode_1D_industrial", "preferences_decode_QR", "preferences_decode_Data_Matrix", "preferences_decode_Aztec", "preferences_decode_PDF417");
        m13007();
        ((EditTextPreference) preferenceScreen.findPreference("preferences_custom_product_search")).setOnPreferenceChangeListener(new C4071());
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        m13007();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m13007() {
        ArrayList arrayList = new ArrayList(this.f14156.length);
        for (CheckBoxPreference checkBoxPreference : this.f14156) {
            if (checkBoxPreference.isChecked()) {
                arrayList.add(checkBoxPreference);
            }
        }
        boolean z = arrayList.size() <= 1;
        for (CheckBoxPreference checkBoxPreference2 : this.f14156) {
            checkBoxPreference2.setEnabled((z && arrayList.contains(checkBoxPreference2)) ? false : true);
        }
    }
}
