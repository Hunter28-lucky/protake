package defpackage;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class ic {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String f6777;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f6778;

    public ic(String str, String str2) {
        this.f6777 = str;
        this.f6778 = str2;
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f6777, this.f6778);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m6287() {
        return this.f6778;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m6288() {
        return this.f6777;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public JSONObject m6289() {
        if (TextUtils.isEmpty(this.f6778)) {
            return null;
        }
        try {
            return new JSONObject(this.f6778);
        } catch (Exception e2) {
            hf.m6205(e2);
            return null;
        }
    }
}
