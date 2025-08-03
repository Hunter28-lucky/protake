package defpackage;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* renamed from: Ⴘ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C5227 implements InterfaceC3734 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Map<String, List<InterfaceC4234>> f17332;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public volatile Map<String, String> f17333;

    /* compiled from: LazyHeaders.java */
    /* renamed from: Ⴘ$Ϳ, reason: contains not printable characters */
    public static final class C5228 {

        /* renamed from: Ԫ, reason: contains not printable characters */
        public static final String f17334;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final Map<String, List<InterfaceC4234>> f17335;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f17336 = true;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public Map<String, List<InterfaceC4234>> f17337 = f17335;

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean f17338 = true;

        static {
            String strM15247 = m15247();
            f17334 = strM15247;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strM15247)) {
                map.put(HttpHeaders.HEAD_KEY_USER_AGENT, Collections.singletonList(new C5229(strM15247)));
            }
            f17335 = Collections.unmodifiableMap(map);
        }

        @VisibleForTesting
        /* renamed from: Ԩ, reason: contains not printable characters */
        public static String m15247() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C5227 m15248() {
            this.f17336 = true;
            return new C5227(this.f17337);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* renamed from: Ⴘ$Ԩ, reason: contains not printable characters */
    public static final class C5229 implements InterfaceC4234 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final String f17339;

        public C5229(String str) {
            this.f17339 = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C5229) {
                return this.f17339.equals(((C5229) obj).f17339);
            }
            return false;
        }

        public int hashCode() {
            return this.f17339.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f17339 + "'}";
        }

        @Override // defpackage.InterfaceC4234
        /* renamed from: Ϳ */
        public String mo13331() {
            return this.f17339;
        }
    }

    public C5227(Map<String, List<InterfaceC4234>> map) {
        this.f17332 = Collections.unmodifiableMap(map);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C5227) {
            return this.f17332.equals(((C5227) obj).f17332);
        }
        return false;
    }

    public int hashCode() {
        return this.f17332.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f17332 + '}';
    }

    @Override // defpackage.InterfaceC3734
    /* renamed from: Ϳ */
    public Map<String, String> mo11967() {
        if (this.f17333 == null) {
            synchronized (this) {
                if (this.f17333 == null) {
                    this.f17333 = Collections.unmodifiableMap(m15246());
                }
            }
        }
        return this.f17333;
    }

    @NonNull
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m15245(@NonNull List<InterfaceC4234> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strMo13331 = list.get(i).mo13331();
            if (!TextUtils.isEmpty(strMo13331)) {
                sb.append(strMo13331);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Map<String, String> m15246() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<InterfaceC4234>> entry : this.f17332.entrySet()) {
            String strM15245 = m15245(entry.getValue());
            if (!TextUtils.isEmpty(strM15245)) {
                map.put(entry.getKey(), strM15245);
            }
        }
        return map;
    }
}
