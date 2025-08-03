package defpackage;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: AlipayResult.java */
/* renamed from: ࢮ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3984 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String f13929;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f13930;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f13931;

    public C3984(Map<String, String> map) {
        if (map == null) {
            return;
        }
        C4638.m14098(map.toString());
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, "resultStatus")) {
                this.f13929 = map.get(str);
            } else if (TextUtils.equals(str, "result")) {
                this.f13930 = map.get(str);
            } else if (TextUtils.equals(str, "memo")) {
                this.f13931 = map.get(str);
            }
        }
    }

    public String toString() {
        return "resultStatus={" + this.f13929 + "};memo={" + this.f13931 + "};result={" + this.f13930 + "}";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public String m12844() {
        return this.f13931;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String m12845() {
        return this.f13930;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m12846() {
        return this.f13929;
    }
}
