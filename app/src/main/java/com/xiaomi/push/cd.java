package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import io.jsonwebtoken.Header;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cd {

    /* renamed from: a, reason: collision with other field name */
    private long f5654a;

    /* renamed from: a, reason: collision with other field name */
    public String f5655a;

    /* renamed from: b, reason: collision with other field name */
    public String f5657b;
    public String c;
    public String d;

    /* renamed from: e, reason: collision with root package name */
    public String f17844e;
    public String f;
    public String g;
    public String h;
    private String i;

    /* renamed from: a, reason: collision with other field name */
    private ArrayList<ck> f5656a = new ArrayList<>();
    private double a = 0.1d;
    private String j = "s.mi1.cc";
    private long b = 86400000;

    public cd(String str) {
        this.f5655a = "";
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.f5654a = System.currentTimeMillis();
        this.f5656a.add(new ck(str, -1));
        this.f5655a = ch.m5292a();
        this.f5657b = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5286a() {
        return TextUtils.equals(this.f5655a, ch.m5292a());
    }

    public boolean b() {
        return System.currentTimeMillis() - this.f5654a < this.b;
    }

    public boolean c() {
        long j = this.b;
        if (864000000 >= j) {
            j = 864000000;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = this.f5654a;
        return jCurrentTimeMillis - j2 > j || (jCurrentTimeMillis - j2 > this.b && this.f5655a.startsWith("WIFI-"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5655a);
        sb.append("\n");
        sb.append(a());
        Iterator<ck> it = this.f5656a.iterator();
        while (it.hasNext()) {
            ck next = it.next();
            sb.append("\n");
            sb.append(next.toString());
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean a(cd cdVar) {
        return TextUtils.equals(this.f5655a, cdVar.f5655a);
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void a(long j) {
        if (j > 0) {
            this.b = j;
            return;
        }
        throw new IllegalArgumentException("the duration is invalid " + j);
    }

    public void b(String str, long j, long j2, Exception exc) {
        a(str, -1, j, j2, exc);
    }

    public void b(String str) {
        this.j = str;
    }

    private synchronized void c(String str) {
        Iterator<ck> it = this.f5656a.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f5673a, str)) {
                it.remove();
            }
        }
    }

    public ArrayList<String> a(String str) throws NumberFormatException {
        if (!TextUtils.isEmpty(str)) {
            URL url = new URL(str);
            if (TextUtils.equals(url.getHost(), this.f5657b)) {
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator<String> it = a(true).iterator();
                while (it.hasNext()) {
                    cf cfVarA = cf.a(it.next(), url.getPort());
                    arrayList.add(new URL(url.getProtocol(), cfVarA.m5291a(), cfVarA.a(), url.getFile()).toString());
                }
                return arrayList;
            }
            throw new IllegalArgumentException("the url is not supported by the fallback");
        }
        throw new IllegalArgumentException("the url is empty.");
    }

    public void a(String str, long j, long j2) {
        try {
            b(new URL(str).getHost(), j, j2);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, long j, long j2, Exception exc) {
        try {
            b(new URL(str).getHost(), j, j2, exc);
        } catch (MalformedURLException unused) {
        }
    }

    public void a(String str, int i, long j, long j2, Exception exc) {
        a(str, new cc(i, j, j2, exc));
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        r1.a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(java.lang.String r4, com.xiaomi.push.cc r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.ArrayList<com.xiaomi.push.ck> r0 = r3.f5656a     // Catch: java.lang.Throwable -> L20
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L20
        L7:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L20
            com.xiaomi.push.ck r1 = (com.xiaomi.push.ck) r1     // Catch: java.lang.Throwable -> L20
            java.lang.String r2 = r1.f5673a     // Catch: java.lang.Throwable -> L20
            boolean r2 = android.text.TextUtils.equals(r4, r2)     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto L7
            r1.a(r5)     // Catch: java.lang.Throwable -> L20
        L1e:
            monitor-exit(r3)
            return
        L20:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cd.a(java.lang.String, com.xiaomi.push.cc):void");
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<String> m5283a() {
        return a(false);
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        int size = this.f5656a.size();
        ck[] ckVarArr = new ck[size];
        this.f5656a.toArray(ckVarArr);
        Arrays.sort(ckVarArr);
        arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ck ckVar = ckVarArr[i];
            if (z) {
                arrayList.add(ckVar.f5673a);
            } else {
                int iIndexOf = ckVar.f5673a.indexOf(Constants.COLON_SEPARATOR);
                if (iIndexOf != -1) {
                    arrayList.add(ckVar.f5673a.substring(0, iIndexOf));
                } else {
                    arrayList.add(ckVar.f5673a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m5285a(String str) {
        a(new ck(str));
    }

    public synchronized void a(ck ckVar) {
        c(ckVar.f5673a);
        this.f5656a.add(ckVar);
    }

    public synchronized void a(String[] strArr) {
        int i;
        int size = this.f5656a.size() - 1;
        while (true) {
            i = 0;
            if (size < 0) {
                break;
            }
            int length = strArr.length;
            while (true) {
                if (i < length) {
                    if (TextUtils.equals(this.f5656a.get(size).f5673a, strArr[i])) {
                        this.f5656a.remove(size);
                        break;
                    }
                    i++;
                }
            }
            size--;
        }
        Iterator<ck> it = this.f5656a.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = it.next().a;
            if (i3 > i2) {
                i2 = i3;
            }
        }
        while (i < strArr.length) {
            a(new ck(strArr[i], (strArr.length + i2) - i));
            i++;
        }
    }

    public synchronized String a() {
        if (!TextUtils.isEmpty(this.i)) {
            return this.i;
        }
        if (TextUtils.isEmpty(this.f17844e)) {
            return "hardcode_isp";
        }
        String strA = bc.a(new String[]{this.f17844e, this.c, this.d, this.g, this.f}, "_");
        this.i = strA;
        return strA;
    }

    public void a(double d) {
        this.a = d;
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized JSONObject m5284a() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("net", this.f5655a);
        jSONObject.put("ttl", this.b);
        jSONObject.put("pct", this.a);
        jSONObject.put("ts", this.f5654a);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put(Header.CONTENT_TYPE, this.g);
        jSONObject.put("isp", this.f17844e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.f5657b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator<ck> it = this.f5656a.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public synchronized cd a(JSONObject jSONObject) {
        this.f5655a = jSONObject.optString("net");
        this.b = jSONObject.getLong("ttl");
        this.a = jSONObject.getDouble("pct");
        this.f5654a = jSONObject.getLong("ts");
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString(Header.CONTENT_TYPE);
        this.f17844e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.f5657b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new ck().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }
}
