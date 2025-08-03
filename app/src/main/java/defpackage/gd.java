package defpackage;

import android.text.TextUtils;

/* loaded from: classes.dex */
public class gd {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f6660;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Boolean f6661;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m6095(boolean z) {
        this.f6661 = Boolean.valueOf(z);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean m6096() {
        return this.f6661 != null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m6097(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f6660, str);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m6098(String str) {
        this.f6660 = str;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m6099() {
        Boolean bool = this.f6661;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
