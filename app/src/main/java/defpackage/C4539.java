package defpackage;

import com.blink.academy.film.http.okhttp.model.HttpHeaders;
import com.google.android.gms.common.internal.ImagesContract;
import defpackage.C5207;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.C2138;

/* compiled from: Request.kt */
/* renamed from: థ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4539 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C2789 f15546;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3573 f15547;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f15548;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C5207 f15549;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final AbstractC2613 f15550;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final Map<Class<?>, Object> f15551;

    public C4539(C3573 c3573, String str, C5207 c5207, AbstractC2613 abstractC2613, Map<Class<?>, ? extends Object> map) {
        C3921.m12667(c3573, ImagesContract.URL);
        C3921.m12667(str, "method");
        C3921.m12667(c5207, "headers");
        C3921.m12667(map, "tags");
        this.f15547 = c3573;
        this.f15548 = str;
        this.f15549 = c5207;
        this.f15550 = abstractC2613;
        this.f15551 = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f15548);
        sb.append(", url=");
        sb.append(this.f15547);
        if (this.f15549.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.f15549) {
                int i2 = i + 1;
                if (i < 0) {
                    C3131.m10719();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strM7207 = pair2.m7207();
                String strM7208 = pair2.m7208();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(strM7207);
                sb.append(':');
                sb.append(strM7208);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.f15551.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.f15551);
        }
        sb.append('}');
        String string = sb.toString();
        C3921.m12663(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AbstractC2613 m13916() {
        return this.f15550;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2789 m13917() {
        C2789 c2789 = this.f15546;
        if (c2789 != null) {
            return c2789;
        }
        C2789 c2789M10097 = C2789.f10162.m10097(this.f15549);
        this.f15546 = c2789M10097;
        return c2789M10097;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Map<Class<?>, Object> m13918() {
        return this.f15551;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final String m13919(String str) {
        C3921.m12667(str, "name");
        return this.f15549.m15182(str);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final C5207 m13920() {
        return this.f15549;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final List<String> m13921(String str) {
        C3921.m12667(str, "name");
        return this.f15549.m15186(str);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean m13922() {
        return this.f15547.m11533();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final String m13923() {
        return this.f15548;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final C4540 m13924() {
        return new C4540(this);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final C3573 m13925() {
        return this.f15547;
    }

    /* compiled from: Request.kt */
    /* renamed from: థ$Ϳ, reason: contains not printable characters */
    public static class C4540 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C3573 f15552;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public String f15553;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C5207.C5208 f15554;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public AbstractC2613 f15555;

        /* renamed from: ԫ, reason: contains not printable characters */
        public Map<Class<?>, Object> f15556;

        public C4540() {
            this.f15556 = new LinkedHashMap();
            this.f15553 = "GET";
            this.f15554 = new C5207.C5208();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C4540 m13926(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            this.f15554.m15187(str, str2);
            return this;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C4539 m13927() {
            C3573 c3573 = this.f15552;
            if (c3573 != null) {
                return new C4539(c3573, this.f15553, this.f15554.m15191(), this.f15555, i5.m6272(this.f15556));
            }
            throw new IllegalStateException("url == null".toString());
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public C4540 m13928(C2789 c2789) {
            C3921.m12667(c2789, "cacheControl");
            String string = c2789.toString();
            return string.length() == 0 ? m13933(HttpHeaders.HEAD_KEY_CACHE_CONTROL) : m13929(HttpHeaders.HEAD_KEY_CACHE_CONTROL, string);
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public C4540 m13929(String str, String str2) {
            C3921.m12667(str, "name");
            C3921.m12667(str2, "value");
            this.f15554.m15195(str, str2);
            return this;
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public C4540 m13930(C5207 c5207) {
            C3921.m12667(c5207, "headers");
            this.f15554 = c5207.m15184();
            return this;
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C4540 m13931(String str, AbstractC2613 abstractC2613) {
            C3921.m12667(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (abstractC2613 == null) {
                if (!(true ^ C3737.m11970(str))) {
                    throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                }
            } else if (!C3737.m11969(str)) {
                throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
            }
            this.f15553 = str;
            this.f15555 = abstractC2613;
            return this;
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public C4540 m13932(AbstractC2613 abstractC2613) {
            C3921.m12667(abstractC2613, "body");
            return m13931("POST", abstractC2613);
        }

        /* renamed from: Ԯ, reason: contains not printable characters */
        public C4540 m13933(String str) {
            C3921.m12667(str, "name");
            this.f15554.m15194(str);
            return this;
        }

        /* renamed from: ԯ, reason: contains not printable characters */
        public C4540 m13934(C3573 c3573) {
            C3921.m12667(c3573, ImagesContract.URL);
            this.f15552 = c3573;
            return this;
        }

        /* renamed from: ՠ, reason: contains not printable characters */
        public C4540 m13935(String str) {
            C3921.m12667(str, ImagesContract.URL);
            if (e0.m5978(str, "ws:", true)) {
                StringBuilder sb = new StringBuilder();
                sb.append("http:");
                String strSubstring = str.substring(3);
                C3921.m12663(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sb.append(strSubstring);
                str = sb.toString();
            } else if (e0.m5978(str, "wss:", true)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("https:");
                String strSubstring2 = str.substring(4);
                C3921.m12663(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sb2.append(strSubstring2);
                str = sb2.toString();
            }
            return m13934(C3573.f12453.m11582(str));
        }

        public C4540(C4539 c4539) {
            Map<Class<?>, Object> mapM7241;
            C3921.m12667(c4539, "request");
            this.f15556 = new LinkedHashMap();
            this.f15552 = c4539.m13925();
            this.f15553 = c4539.m13923();
            this.f15555 = c4539.m13916();
            if (c4539.m13918().isEmpty()) {
                mapM7241 = new LinkedHashMap<>();
            } else {
                mapM7241 = C2138.m7241(c4539.m13918());
            }
            this.f15556 = mapM7241;
            this.f15554 = c4539.m13920().m15184();
        }
    }
}
