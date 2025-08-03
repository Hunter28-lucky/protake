package defpackage;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: Challenge.kt */
/* renamed from: ʔ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2671 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<String, String> f9925;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f9926;

    public C2671(String str, Map<String, String> map) {
        String lowerCase;
        C3921.m12667(str, "scheme");
        C3921.m12667(map, "authParams");
        this.f9926 = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key != null) {
                Locale locale = Locale.US;
                C3921.m12663(locale, "US");
                lowerCase = key.toLowerCase(locale);
                C3921.m12663(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, value);
        }
        Map<String, String> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        C3921.m12663(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f9925 = mapUnmodifiableMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2671) {
            C2671 c2671 = (C2671) obj;
            if (C3921.m12662(c2671.f9926, this.f9926) && C3921.m12662(c2671.f9925, this.f9925)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f9926.hashCode()) * 31) + this.f9925.hashCode();
    }

    public String toString() {
        return this.f9926 + " authParams=" + this.f9925;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Charset m9812() {
        String str = this.f9925.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                C3921.m12663(charsetForName, "Charset.forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        C3921.m12663(charset, "ISO_8859_1");
        return charset;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m9813() {
        return this.f9925.get("realm");
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String m9814() {
        return this.f9926;
    }
}
