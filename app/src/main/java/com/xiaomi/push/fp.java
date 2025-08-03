package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public abstract class fp {

    /* renamed from: a, reason: collision with other field name */
    public static final DateFormat f5933a;
    private static long b;
    private static String c;

    /* renamed from: a, reason: collision with other field name */
    public long f5935a;

    /* renamed from: a, reason: collision with other field name */
    private ft f5936a;

    /* renamed from: a, reason: collision with other field name */
    private List<fm> f5937a;

    /* renamed from: a, reason: collision with other field name */
    private final Map<String, Object> f5938a;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private String f17865e;
    private String f;
    private String g;
    private String h;
    private String i;
    public static final String a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: b, reason: collision with other field name */
    private static String f5934b = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f5933a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        c = fy.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        b = 0L;
    }

    public fp() {
        this.d = f5934b;
        this.f17865e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f5937a = new CopyOnWriteArrayList();
        this.f5938a = new HashMap();
        this.f5936a = null;
    }

    public static synchronized String i() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append(c);
        long j = b;
        b = 1 + j;
        sb.append(Long.toString(j));
        return sb.toString();
    }

    public static String q() {
        return a;
    }

    /* renamed from: a, reason: collision with other method in class */
    public ft m5497a() {
        return this.f5936a;
    }

    /* renamed from: a */
    public abstract String mo5496a();

    public synchronized Collection<String> b() {
        if (this.f5938a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f5938a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fp fpVar = (fp) obj;
        ft ftVar = this.f5936a;
        if (ftVar == null ? fpVar.f5936a != null : !ftVar.equals(fpVar.f5936a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? fpVar.g != null : !str.equals(fpVar.g)) {
            return false;
        }
        if (!this.f5937a.equals(fpVar.f5937a)) {
            return false;
        }
        String str2 = this.f17865e;
        if (str2 == null ? fpVar.f17865e != null : !str2.equals(fpVar.f17865e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? fpVar.h != null : !str3.equals(fpVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f5938a;
        if (map == null ? fpVar.f5938a != null : !map.equals(fpVar.f5938a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? fpVar.f != null : !str4.equals(fpVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = fpVar.d;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.d;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f17865e;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int iHashCode5 = (((((iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f5937a.hashCode()) * 31) + this.f5938a.hashCode()) * 31;
        ft ftVar = this.f5936a;
        return iHashCode5 + (ftVar != null ? ftVar.hashCode() : 0);
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.f17865e)) {
            return null;
        }
        if (this.f17865e == null) {
            this.f17865e = i();
        }
        return this.f17865e;
    }

    public void k(String str) {
        this.f17865e = str;
    }

    public void l(String str) {
        this.h = str;
    }

    public void m(String str) {
        this.f = str;
    }

    public void n(String str) {
        this.g = str;
    }

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }

    public void a(ft ftVar) {
        this.f5936a = ftVar;
    }

    public String k() {
        return this.h;
    }

    public String l() {
        return this.f;
    }

    public String m() {
        return this.g;
    }

    public String n() {
        return this.i;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:(4:82|36|86|37)|88|38|103) */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0104 A[EXC_TOP_SPLITTER, PHI: r4
      0x0104: PHI (r4v7 java.io.ByteArrayOutputStream) = (r4v5 java.io.ByteArrayOutputStream), (r4v8 java.io.ByteArrayOutputStream), (r4v8 java.io.ByteArrayOutputStream) binds: [B:54:0x011e, B:73:0x0104, B:37:0x0101] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String o() {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fp.o():java.lang.String");
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Collection<fm> m5499a() {
        if (this.f5937a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f5937a));
    }

    public fm a(String str) {
        return a(str, null);
    }

    public fm a(String str, String str2) {
        for (fm fmVar : this.f5937a) {
            if (str2 == null || str2.equals(fmVar.b())) {
                if (str.equals(fmVar.m5493a())) {
                    return fmVar;
                }
            }
        }
        return null;
    }

    public void a(fm fmVar) {
        this.f5937a.add(fmVar);
    }

    public fp(Bundle bundle) {
        this.d = f5934b;
        this.f17865e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.f5937a = new CopyOnWriteArrayList();
        this.f5938a = new HashMap();
        this.f5936a = null;
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.f17865e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f5937a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fm fmVarA = fm.a((Bundle) parcelable);
                if (fmVarA != null) {
                    this.f5937a.add(fmVarA);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f5936a = new ft(bundle2);
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized Object m5498a(String str) {
        Map<String, Object> map = this.f5938a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.f17865e)) {
            bundle.putString("ext_pkt_id", this.f17865e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        ft ftVar = this.f5936a;
        if (ftVar != null) {
            bundle.putBundle("ext_ERROR", ftVar.a());
        }
        List<fm> list = this.f5937a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            Iterator<fm> it = this.f5937a.iterator();
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
}
