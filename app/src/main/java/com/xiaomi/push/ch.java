package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.jcodec.platform.Platform;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ch {
    public static Context a;

    /* renamed from: a, reason: collision with other field name */
    private static a f5660a;

    /* renamed from: a, reason: collision with other field name */
    private static ch f5661a;
    private static String c;
    private static String d;

    /* renamed from: a, reason: collision with other field name */
    private long f5663a;

    /* renamed from: a, reason: collision with other field name */
    private cg f5664a;

    /* renamed from: a, reason: collision with other field name */
    public b f5665a;

    /* renamed from: a, reason: collision with other field name */
    private String f5666a;

    /* renamed from: a, reason: collision with other field name */
    public final Map<String, ce> f5667a;

    /* renamed from: b, reason: collision with other field name */
    private final long f5668b;

    /* renamed from: b, reason: collision with other field name */
    private String f5669b;

    /* renamed from: c, reason: collision with other field name */
    private long f5670c;
    public static final Map<String, cd> b = new HashMap();

    /* renamed from: a, reason: collision with other field name */
    public static boolean f5662a = false;

    public interface a {
        ch a(Context context, cg cgVar, b bVar, String str);
    }

    public interface b {
        String a(String str);
    }

    public ch(Context context, cg cgVar, b bVar, String str) {
        this(context, cgVar, bVar, str, null, null);
    }

    public static synchronized ch a() {
        ch chVar;
        chVar = f5661a;
        if (chVar == null) {
            throw new IllegalStateException("the host manager is not initialized yet.");
        }
        return chVar;
    }

    private String f() {
        return "host_fallbacks";
    }

    private String g() throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 16384);
            return packageInfo != null ? packageInfo.versionName : "0";
        } catch (Exception unused) {
            return "0";
        }
    }

    public cd b(String str) {
        return a(str, true);
    }

    public String b() {
        return "resolver.msg.xiaomi.net";
    }

    public cd c(String str) {
        ce ceVar;
        cd cdVarA;
        synchronized (this.f5667a) {
            m5298a();
            ceVar = this.f5667a.get(str);
        }
        if (ceVar == null || (cdVarA = ceVar.a()) == null) {
            return null;
        }
        return cdVarA;
    }

    public cd d(String str) {
        cd cdVar;
        Map<String, cd> map = b;
        synchronized (map) {
            cdVar = map.get(str);
        }
        return cdVar;
    }

    public cd e(String str) {
        if (System.currentTimeMillis() - this.f5670c <= this.f5663a * 60 * 1000) {
            return null;
        }
        this.f5670c = System.currentTimeMillis();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        cd cdVar = a(arrayList).get(0);
        if (cdVar != null) {
            this.f5663a = 0L;
            return cdVar;
        }
        long j = this.f5663a;
        if (j >= 15) {
            return null;
        }
        this.f5663a = j + 1;
        return null;
    }

    public ch(Context context, cg cgVar, b bVar, String str, String str2, String str3) {
        this.f5667a = new HashMap();
        this.f5666a = "0";
        this.f5663a = 0L;
        this.f5668b = 15L;
        this.f5670c = 0L;
        this.f5669b = "isp_prov_city_country_ip";
        this.f5665a = bVar;
        if (cgVar == null) {
            this.f5664a = new cg() { // from class: com.xiaomi.push.ch.1
                @Override // com.xiaomi.push.cg
                public boolean a(String str4) {
                    return true;
                }
            };
        } else {
            this.f5664a = cgVar;
        }
        this.f5666a = str;
        c = str2 == null ? context.getPackageName() : str2;
        d = str3 == null ? g() : str3;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5299b() throws JSONException {
        ArrayList<String> arrayList;
        synchronized (this.f5667a) {
            m5298a();
            arrayList = new ArrayList<>(this.f5667a.keySet());
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ce ceVar = this.f5667a.get(arrayList.get(size));
                if (ceVar != null && ceVar.a() != null) {
                    arrayList.remove(size);
                }
            }
        }
        ArrayList<cd> arrayListA = a(arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayListA.get(i) != null) {
                a(arrayList.get(i), arrayListA.get(i));
            }
        }
    }

    public static synchronized void a(a aVar) {
        f5660a = aVar;
        f5661a = null;
    }

    public String d() throws IOException {
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        File file;
        try {
            file = new File(a.getFilesDir(), f());
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            fileInputStream = null;
        }
        if (file.isFile()) {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
                try {
                    String str = new String(h.a(m5293a(), x.a((InputStream) bufferedInputStream)), StandardCharsets.UTF_8);
                    com.xiaomi.channel.commonutils.logger.b.b("load host fallbacks = " + str);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.xiaomi.channel.commonutils.logger.b.m5113a("load host exception " + th.getMessage());
                        return null;
                    } finally {
                        x.a((Closeable) bufferedInputStream);
                        x.a((Closeable) fileInputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        } else {
            x.a((Closeable) null);
            x.a((Closeable) null);
            return null;
        }
    }

    public static synchronized void a(Context context, cg cgVar, b bVar, String str, String str2, String str3) {
        Context applicationContext = context.getApplicationContext();
        a = applicationContext;
        if (applicationContext == null) {
            a = context;
        }
        if (f5661a == null) {
            a aVar = f5660a;
            if (aVar == null) {
                f5661a = new ch(context, cgVar, bVar, str, str2, str3);
            } else {
                f5661a = aVar.a(context, cgVar, bVar, str);
            }
        }
    }

    public String c() {
        StringBuilder sb = new StringBuilder();
        synchronized (this.f5667a) {
            for (Map.Entry<String, ce> entry : this.f5667a.entrySet()) {
                sb.append(entry.getKey());
                sb.append(":\n");
                sb.append(entry.getValue().toString());
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String e() {
        if ("com.xiaomi.xmsf".equals(c)) {
            return c;
        }
        return c + ":pushservice";
    }

    /* renamed from: e, reason: collision with other method in class */
    public void m5303e() {
        String next;
        synchronized (this.f5667a) {
            Iterator<ce> it = this.f5667a.values().iterator();
            while (it.hasNext()) {
                it.next().a(true);
            }
            while (true) {
                for (boolean z = false; !z; z = true) {
                    Iterator<String> it2 = this.f5667a.keySet().iterator();
                    while (it2.hasNext()) {
                        next = it2.next();
                        if (this.f5667a.get(next).m5288a().isEmpty()) {
                            break;
                        }
                    }
                }
                this.f5667a.remove(next);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public static String m5292a() {
        if (a == null) {
            return "unknown";
        }
        try {
            aw awVarM5209a = av.m5209a();
            if (awVarM5209a == null) {
                return "unknown";
            }
            if (awVarM5209a.a() == 1) {
                return "WIFI-UNKNOWN";
            }
            return awVarM5209a.m5219a() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + awVarM5209a.m5221b();
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m5300b(String str) {
        synchronized (this.f5667a) {
            this.f5667a.clear();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("ver") == 2) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("data");
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        ce ceVarA = new ce().a(jSONArrayOptJSONArray.getJSONObject(i));
                        this.f5667a.put(ceVarA.m5287a(), ceVarA);
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("reserved");
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObject2 = jSONArrayOptJSONArray2.getJSONObject(i2);
                        String strOptString = jSONObject2.optString("host");
                        if (!TextUtils.isEmpty(strOptString)) {
                            try {
                                cd cdVarA = new cd(strOptString).a(jSONObject2);
                                b.put(cdVarA.f5657b, cdVarA);
                                com.xiaomi.channel.commonutils.logger.b.m5113a("load local reserved host for " + cdVarA.f5657b);
                            } catch (JSONException unused) {
                                com.xiaomi.channel.commonutils.logger.b.m5113a("parse reserved host fail.");
                            }
                        }
                    }
                }
            } else {
                throw new JSONException("Bad version");
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public cd m5294a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return a(new URL(str).getHost(), true);
        }
        throw new IllegalArgumentException("the url is empty");
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m5301c() {
        FileOutputStream fileOutputStreamOpenFileOutput;
        Closeable closeable;
        BufferedOutputStream bufferedOutputStream;
        Exception e2;
        synchronized (this.f5667a) {
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                try {
                    String string = m5295a().toString();
                    com.xiaomi.channel.commonutils.logger.b.b("persist host fallbacks = " + string);
                    if (TextUtils.isEmpty(string)) {
                        fileOutputStreamOpenFileOutput = null;
                    } else {
                        fileOutputStreamOpenFileOutput = a.openFileOutput(f(), 0);
                        try {
                            bufferedOutputStream = new BufferedOutputStream(fileOutputStreamOpenFileOutput);
                        } catch (Exception e3) {
                            e = e3;
                            bufferedOutputStream = null;
                            e2 = e;
                            com.xiaomi.channel.commonutils.logger.b.m5113a("persist bucket failure: " + e2.getMessage());
                            x.a(bufferedOutputStream);
                            x.a(fileOutputStreamOpenFileOutput);
                        } catch (Throwable th) {
                            th = th;
                            closeable = null;
                            th = th;
                            x.a(closeable);
                            x.a(fileOutputStreamOpenFileOutput);
                            throw th;
                        }
                        try {
                            bufferedOutputStream.write(h.b(m5293a(), string.getBytes(StandardCharsets.UTF_8)));
                            bufferedOutputStream.flush();
                            bufferedOutputStream2 = bufferedOutputStream;
                        } catch (Exception e4) {
                            e2 = e4;
                            com.xiaomi.channel.commonutils.logger.b.m5113a("persist bucket failure: " + e2.getMessage());
                            x.a(bufferedOutputStream);
                            x.a(fileOutputStreamOpenFileOutput);
                        }
                    }
                    x.a(bufferedOutputStream2);
                } catch (Exception e5) {
                    e = e5;
                    fileOutputStreamOpenFileOutput = null;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStreamOpenFileOutput = null;
                    closeable = null;
                }
                x.a(fileOutputStreamOpenFileOutput);
            } catch (Throwable th3) {
                th = th3;
                x.a(closeable);
                x.a(fileOutputStreamOpenFileOutput);
                throw th;
            }
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m5302d() {
        String strE = e();
        try {
            File file = new File(a.getFilesDir(), strE);
            if (file.exists()) {
                boolean zDelete = file.delete();
                StringBuilder sb = new StringBuilder();
                sb.append("Delete old host fallbacks file ");
                sb.append(strE);
                sb.append(zDelete ? " successful." : " failed.");
                com.xiaomi.channel.commonutils.logger.b.m5113a(sb.toString());
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("Old host fallbacks file " + strE + " does not exist.");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("Delete old host fallbacks file " + strE + " error: " + e2.getMessage());
        }
    }

    public cd a(String str, boolean z) {
        cd cdVarE;
        com.xiaomi.channel.commonutils.logger.b.b("HostManager", "-->getFallbacksByHost(): host=", str, ", fetchRemoteIfNeed=", Boolean.valueOf(z));
        if (!TextUtils.isEmpty(str)) {
            if (!this.f5664a.a(str)) {
                return null;
            }
            cd cdVarC = c(str);
            return (cdVarC == null || !cdVarC.b()) ? (z && av.m5216a(a) && (cdVarE = e(str)) != null) ? cdVarE : new cd(str, cdVarC) { // from class: com.xiaomi.push.ch.2
                public cd a;
                public final /* synthetic */ cd b;

                {
                    this.b = cdVarC;
                    this.a = cdVarC;
                    ((cd) this).f5657b = ((cd) this).f5657b;
                    if (cdVarC != null) {
                        this.f = cdVarC.f;
                    }
                }

                @Override // com.xiaomi.push.cd
                public synchronized ArrayList<String> a(boolean z2) {
                    ArrayList<String> arrayList;
                    arrayList = new ArrayList<>();
                    cd cdVar = this.a;
                    if (cdVar != null) {
                        arrayList.addAll(cdVar.a(true));
                    }
                    Map<String, cd> map = ch.b;
                    synchronized (map) {
                        cd cdVar2 = map.get(((cd) this).f5657b);
                        if (cdVar2 != null) {
                            Iterator<String> it = cdVar2.a(true).iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                if (arrayList.indexOf(next) == -1) {
                                    arrayList.add(next);
                                }
                            }
                            arrayList.remove(((cd) this).f5657b);
                            arrayList.add(((cd) this).f5657b);
                        }
                    }
                    return arrayList;
                }

                @Override // com.xiaomi.push.cd
                public boolean b() {
                    return false;
                }

                @Override // com.xiaomi.push.cd
                public synchronized void a(String str2, cc ccVar) {
                    cd cdVar = this.a;
                    if (cdVar != null) {
                        cdVar.a(str2, ccVar);
                    }
                }
            } : cdVarC;
        }
        throw new IllegalArgumentException("the host is empty");
    }

    private ArrayList<cd> a(ArrayList<String> arrayList) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        m5303e();
        synchronized (this.f5667a) {
            m5298a();
            for (String str : this.f5667a.keySet()) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        Map<String, cd> map = b;
        synchronized (map) {
            for (Object obj : map.values().toArray()) {
                cd cdVar = (cd) obj;
                if (!cdVar.b()) {
                    b.remove(cdVar.f5657b);
                }
            }
        }
        if (!arrayList.contains(b())) {
            arrayList.add(b());
        }
        ArrayList<cd> arrayList2 = new ArrayList<>(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(null);
        }
        try {
            String str2 = av.d(a) ? NetworkUtil.NETWORK_TYPE_WIFI : "wap";
            String strA = a(arrayList, str2, this.f5666a, true);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject3 = new JSONObject(strA);
                com.xiaomi.channel.commonutils.logger.b.b(strA);
                if ("OK".equalsIgnoreCase(jSONObject3.getString(ExifInterface.LATITUDE_SOUTH))) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("R");
                    String string = jSONObject4.getString("province");
                    String string2 = jSONObject4.getString("city");
                    String string3 = jSONObject4.getString("isp");
                    String string4 = jSONObject4.getString("ip");
                    String string5 = jSONObject4.getString(com.umeng.analytics.pro.am.O);
                    JSONObject jSONObject5 = jSONObject4.getJSONObject(str2);
                    com.xiaomi.channel.commonutils.logger.b.c("get bucket: net=" + string3 + ", hosts=" + jSONObject5.toString());
                    int i2 = 0;
                    while (i2 < arrayList.size()) {
                        String str3 = arrayList.get(i2);
                        JSONArray jSONArrayOptJSONArray = jSONObject5.optJSONArray(str3);
                        if (jSONArrayOptJSONArray == null) {
                            com.xiaomi.channel.commonutils.logger.b.m5113a("no bucket found for " + str3);
                            jSONObject = jSONObject5;
                        } else {
                            cd cdVar2 = new cd(str3);
                            int i3 = 0;
                            while (i3 < jSONArrayOptJSONArray.length()) {
                                String string6 = jSONArrayOptJSONArray.getString(i3);
                                if (TextUtils.isEmpty(string6)) {
                                    jSONObject2 = jSONObject5;
                                } else {
                                    jSONObject2 = jSONObject5;
                                    cdVar2.a(new ck(string6, jSONArrayOptJSONArray.length() - i3));
                                }
                                i3++;
                                jSONObject5 = jSONObject2;
                            }
                            jSONObject = jSONObject5;
                            arrayList2.set(i2, cdVar2);
                            cdVar2.g = string5;
                            cdVar2.c = string;
                            cdVar2.f17844e = string3;
                            cdVar2.f = string4;
                            cdVar2.d = string2;
                            if (jSONObject4.has("stat-percent")) {
                                cdVar2.a(jSONObject4.getDouble("stat-percent"));
                            }
                            if (jSONObject4.has("stat-domain")) {
                                cdVar2.b(jSONObject4.getString("stat-domain"));
                            }
                            if (jSONObject4.has("ttl")) {
                                cdVar2.a(jSONObject4.getInt("ttl") * 1000);
                            }
                            m5297a(cdVar2.a());
                        }
                        i2++;
                        jSONObject5 = jSONObject;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject4.optJSONObject("reserved");
                    if (jSONObjectOptJSONObject != null) {
                        long j = jSONObject4.has("reserved-ttl") ? jSONObject4.getInt("reserved-ttl") * 1000 : 604800000L;
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(next);
                            if (jSONArrayOptJSONArray2 == null) {
                                com.xiaomi.channel.commonutils.logger.b.m5113a("no bucket found for " + next);
                            } else {
                                cd cdVar3 = new cd(next);
                                cdVar3.a(j);
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    String string7 = jSONArrayOptJSONArray2.getString(i4);
                                    if (!TextUtils.isEmpty(string7)) {
                                        cdVar3.a(new ck(string7, jSONArrayOptJSONArray2.length() - i4));
                                    }
                                }
                                Map<String, cd> map2 = b;
                                synchronized (map2) {
                                    if (this.f5664a.a(next)) {
                                        map2.put(next, cdVar3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m5113a("failed to get bucket " + e2.getMessage());
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            cd cdVar4 = arrayList2.get(i5);
            if (cdVar4 != null) {
                a(arrayList.get(i5), cdVar4);
            }
        }
        m5301c();
        return arrayList2;
    }

    public String a(ArrayList<String> arrayList, String str, String str2, boolean z) throws IOException, NumberFormatException {
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList<au> arrayList3 = new ArrayList();
        arrayList3.add(new as("type", str));
        if (str.equals("wap")) {
            arrayList3.add(new as("conpt", a(av.m5212a(a))));
        }
        if (z) {
            arrayList3.add(new as("reserved", "1"));
        }
        arrayList3.add(new as("uuid", str2));
        arrayList3.add(new as("list", bc.a(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP)));
        arrayList3.add(new as("countrycode", com.xiaomi.push.service.b.a(a).b()));
        arrayList3.add(new as("push_sdk_vc", String.valueOf(BuildConfig.VERSION_CODE)));
        String strB = b();
        cd cdVarC = c(strB);
        String str3 = String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", strB);
        if (cdVarC == null) {
            arrayList2.add(str3);
            Map<String, cd> map = b;
            synchronized (map) {
                cd cdVar = map.get(strB);
                if (cdVar != null) {
                    Iterator<String> it = cdVar.a(true).iterator();
                    while (it.hasNext()) {
                        arrayList2.add(String.format(Locale.US, "https://%1$s/gslb/?ver=5.0", it.next()));
                    }
                }
            }
        } else {
            arrayList2 = cdVarC.a(str3);
        }
        Iterator<String> it2 = arrayList2.iterator();
        IOException e2 = null;
        while (it2.hasNext()) {
            Uri.Builder builderBuildUpon = Uri.parse(it2.next()).buildUpon();
            for (au auVar : arrayList3) {
                builderBuildUpon.appendQueryParameter(auVar.a(), auVar.b());
            }
            try {
                b bVar = this.f5665a;
                if (bVar == null) {
                    return av.a(a, new URL(builderBuildUpon.toString()));
                }
                return bVar.a(builderBuildUpon.toString());
            } catch (IOException e3) {
                e2 = e3;
            }
        }
        if (e2 == null) {
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m5113a("network exception: " + e2.getMessage());
        throw e2;
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5296a() {
        synchronized (this.f5667a) {
            this.f5667a.clear();
        }
    }

    public void a(String str, cd cdVar) {
        if (!TextUtils.isEmpty(str) && cdVar != null) {
            if (this.f5664a.a(str)) {
                synchronized (this.f5667a) {
                    m5298a();
                    if (this.f5667a.containsKey(str)) {
                        this.f5667a.get(str).a(cdVar);
                    } else {
                        ce ceVar = new ce(str);
                        ceVar.a(cdVar);
                        this.f5667a.put(str, ceVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the argument is invalid " + str + ", " + cdVar);
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m5298a() {
        synchronized (this.f5667a) {
            if (f5662a) {
                return true;
            }
            f5662a = true;
            this.f5667a.clear();
            try {
                String strD = d();
                if (!TextUtils.isEmpty(strD)) {
                    m5300b(strD);
                    com.xiaomi.channel.commonutils.logger.b.b("loading the new hosts succeed");
                    return true;
                }
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.m5113a("load bucket failure: " + th.getMessage());
            }
            return false;
        }
    }

    public static void a(String str, String str2) {
        Map<String, cd> map = b;
        cd cdVar = map.get(str);
        synchronized (map) {
            if (cdVar == null) {
                cd cdVar2 = new cd(str);
                cdVar2.a(604800000L);
                cdVar2.m5285a(str2);
                map.put(str, cdVar2);
            } else {
                cdVar.m5285a(str2);
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    private byte[] m5293a() {
        return bb.m5241a(a.getPackageName() + "_key_salt");
    }

    public static String a(String str) throws UnsupportedEncodingException {
        try {
            int length = str.length();
            byte[] bytes = str.getBytes(Platform.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                byte b2 = bytes[i];
                int i2 = b2 & 240;
                if (i2 != 240) {
                    bytes[i] = (byte) (((b2 & com.umeng.analytics.pro.cb.m) ^ ((byte) (((b2 >> 4) + length) & 15))) | i2);
                }
            }
            return new String(bytes);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m5297a(String str) {
        this.f5669b = str;
    }

    /* renamed from: a, reason: collision with other method in class */
    public JSONObject m5295a() {
        JSONObject jSONObject;
        synchronized (this.f5667a) {
            jSONObject = new JSONObject();
            jSONObject.put("ver", 2);
            JSONArray jSONArray = new JSONArray();
            Iterator<ce> it = this.f5667a.values().iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().m5289a());
            }
            jSONObject.put("data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            Iterator<cd> it2 = b.values().iterator();
            while (it2.hasNext()) {
                jSONArray2.put(it2.next().m5284a());
            }
            jSONObject.put("reserved", jSONArray2);
        }
        return jSONObject;
    }
}
