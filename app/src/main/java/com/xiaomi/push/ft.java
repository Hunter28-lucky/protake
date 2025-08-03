package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ft {
    private int a;

    /* renamed from: a, reason: collision with other field name */
    private String f5943a;

    /* renamed from: a, reason: collision with other field name */
    private List<fm> f5944a;
    private String b;
    private String c;
    private String d;

    public static class a {
        public static final a a = new a("internal-server-error");
        public static final a b = new a("forbidden");
        public static final a c = new a("bad-request");
        public static final a d = new a("conflict");

        /* renamed from: e, reason: collision with root package name */
        public static final a f17868e = new a("feature-not-implemented");
        public static final a f = new a("gone");
        public static final a g = new a("item-not-found");
        public static final a h = new a("jid-malformed");
        public static final a i = new a("not-acceptable");
        public static final a j = new a("not-allowed");
        public static final a k = new a("not-authorized");
        public static final a l = new a("payment-required");
        public static final a m = new a("recipient-unavailable");
        public static final a n = new a("redirect");
        public static final a o = new a("registration-required");
        public static final a p = new a("remote-server-error");
        public static final a q = new a("remote-server-not-found");
        public static final a r = new a("remote-server-timeout");
        public static final a s = new a("resource-constraint");
        public static final a t = new a("service-unavailable");
        public static final a u = new a("subscription-required");
        public static final a v = new a("undefined-condition");
        public static final a w = new a("unexpected-request");
        public static final a x = new a("request-timeout");

        /* renamed from: a, reason: collision with other field name */
        private String f5945a;

        public a(String str) {
            this.f5945a = str;
        }

        public String toString() {
            return this.f5945a;
        }
    }

    public ft(a aVar) {
        this.f5944a = null;
        a(aVar);
        this.d = null;
    }

    private void a(a aVar) {
        this.b = aVar.f5945a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        if (str != null) {
            sb.append(str);
        }
        sb.append("(");
        sb.append(this.a);
        sb.append(")");
        if (this.d != null) {
            sb.append(MyUTIL.white_space);
            sb.append(this.d);
        }
        return sb.toString();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f5943a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.a);
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<fm> list = this.f5944a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            Iterator<fm> it = this.f5944a.iterator();
            while (it.hasNext()) {
                Bundle bundleA = it.next().a();
                if (bundleA != null) {
                    bundleArr[i] = bundleA;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public ft(int i, String str, String str2, String str3, String str4, List<fm> list) {
        this.a = i;
        this.f5943a = str;
        this.c = str2;
        this.b = str3;
        this.d = str4;
        this.f5944a = list;
    }

    public ft(Bundle bundle) {
        this.f5944a = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f5943a = bundle.getString("ext_err_type");
        }
        this.b = bundle.getString("ext_err_cond");
        this.c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f5944a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fm fmVarA = fm.a((Bundle) parcelable);
                if (fmVarA != null) {
                    this.f5944a.add(fmVarA);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m5500a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.a);
        sb.append("\"");
        if (this.f5943a != null) {
            sb.append(" type=\"");
            sb.append(this.f5943a);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" reason=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(">");
        if (this.b != null) {
            sb.append("<");
            sb.append(this.b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        Iterator<fm> it = m5501a().iterator();
        while (it.hasNext()) {
            sb.append(it.next().d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized List<fm> m5501a() {
        List<fm> list = this.f5944a;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }
}
