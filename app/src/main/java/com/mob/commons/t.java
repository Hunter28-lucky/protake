package com.mob.commons;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaDrm;
import android.os.Build;
import android.text.TextUtils;
import com.mob.MobSDK;
import com.mob.commons.a;
import com.mob.tools.MobLog;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class t {

    /* renamed from: e, reason: collision with root package name */
    private static volatile t f17686e;
    private volatile String a = null;
    private volatile String b = null;
    private volatile String c = null;
    private volatile String d = null;
    private HashMap<String, Integer> f;

    private t() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap map = (HashMap) w.a().a("key_drds");
            if (map == null) {
                map = new HashMap();
            }
            if (map.containsKey(str)) {
                int iIntValue = ((Integer) map.get(str)).intValue();
                if (iIntValue < 100000) {
                    map.put(str, Integer.valueOf(iIntValue + 1));
                }
            } else {
                map.put(str, 1);
            }
            ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>() { // from class: com.mob.commons.t.2
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
                    return entry2.getValue().compareTo(entry.getValue());
                }
            });
            for (int size = arrayList.size(); size > 7; size--) {
                arrayList.remove(size - 1);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : arrayList) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            w.a().a("key_drds", linkedHashMap);
            this.f = new LinkedHashMap();
            int iMin = Math.min(3, arrayList.size());
            for (int i = 0; i < iMin; i++) {
                Map.Entry entry2 = (Map.Entry) arrayList.get(i);
                this.f.put(entry2.getKey(), entry2.getValue());
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    private String j() {
        if (!TextUtils.isEmpty(h())) {
            return "12" + c(h());
        }
        if (!TextUtils.isEmpty(g())) {
            return "22" + c(g());
        }
        if (TextUtils.isEmpty(l())) {
            return "42" + c(UUID.randomUUID().toString());
        }
        return "32" + c(this.d);
    }

    private String k() {
        if (TextUtils.isEmpty(h())) {
            return "42" + c(UUID.randomUUID().toString());
        }
        return "12" + c(h());
    }

    private String l() {
        DH.requester(MobSDK.getContext()).getOD().request(new DH.DHResponder() { // from class: com.mob.commons.t.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                String od = dHResponse.getOD();
                List<String> listAsList = Arrays.asList("00000000-0000-0000-0000-000000000000", "00000000000000000000000000000000");
                a.c cVarD = w.a().d();
                if (cVarD != null && cVarD.g() != null) {
                    listAsList = cVarD.g();
                }
                if (TextUtils.isEmpty(od) || listAsList.contains(od)) {
                    return;
                }
                t.this.d = od;
            }
        });
        return this.d;
    }

    private String m() throws Throwable {
        MediaDrm mediaDrm;
        int i = Build.VERSION.SDK_INT;
        final ApplicationInfo[] applicationInfoArr = new ApplicationInfo[1];
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        DH.requester(MobSDK.getContext()).getAInfo().request(new DH.DHResponder() { // from class: com.mob.commons.t.3
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                applicationInfoArr[0] = dHResponse.getAInfo();
                countDownLatch.countDown();
            }
        });
        String strA = j.a("061Ycbbjha;hQgcdcgcFg<dfgfff;gWbecjIhWcbgcdebe4g<dfFf@hgcjbcddbcdagfgchagfehcj)bOddbjbebjfcdabedacjcadeddfc)fJeiejeibegcejejgfgfbeejdc");
        UUID uuid = new UUID(-1301668207276963122L, -6645017420763422227L);
        MediaDrm mediaDrm2 = null;
        String strByteToHex = null;
        try {
            mediaDrm = new MediaDrm(uuid);
        } catch (Throwable th) {
            th = th;
        }
        try {
            countDownLatch.await(80L, TimeUnit.MILLISECONDS);
            if (applicationInfoArr[0] != null) {
                com.mob.tools.a.h.a(MobSDK.getContext(), applicationInfoArr[0].targetSdkVersion).a(mediaDrm.getClass(), mediaDrm, "native_setup", new Class[]{Object.class, byte[].class, String.class}, new Object[]{new WeakReference(mediaDrm), a(uuid), strA});
                byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
                strByteToHex = Data.byteToHex(propertyByteArray, 0, propertyByteArray.length);
            }
            try {
                if (i >= 28) {
                    mediaDrm.close();
                } else {
                    mediaDrm.release();
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
            return strByteToHex;
        } catch (Throwable th3) {
            th = th3;
            mediaDrm2 = mediaDrm;
            try {
                MobLog.getInstance().d(th);
                throw th;
            } catch (Throwable th4) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        if (mediaDrm2 != null) {
                            mediaDrm2.close();
                        }
                    } else if (mediaDrm2 != null) {
                        mediaDrm2.release();
                    }
                } catch (Throwable th5) {
                    MobLog.getInstance().d(th5);
                }
                throw th4;
            }
        }
    }

    private String n() {
        String str = null;
        if (!b.a(j.a("003@bdcbcb"))) {
            return null;
        }
        try {
            String strB = w.a().b("key_pddt", (String) null);
            try {
                if (!TextUtils.isEmpty(strB)) {
                    long jB = w.a().b("key_lgpdt", 0L);
                    long j = 604800000;
                    try {
                        j = Long.parseLong(String.valueOf(b.a(j.a("006@debgdeddbdOc"), 604800))) * 1000;
                    } catch (Throwable unused) {
                    }
                    if (System.currentTimeMillis() - jB < j) {
                        MobLog.getInstance().d("rddd che p useable", new Object[0]);
                        return strB;
                    }
                }
                if (j.a("004hMbcNhJca").equalsIgnoreCase(DH.SyncMtd.getManufacturer()) && Build.VERSION.SDK_INT <= 25) {
                    return null;
                }
                j.a("006aAbabddb.gQbc").equalsIgnoreCase(DH.SyncMtd.getManufacturer());
                List<String> listO = o();
                if (!listO.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    PackageManager packageManager = MobSDK.getContext().getPackageManager();
                    int i = 0;
                    for (int i2 = 0; i2 < listO.size(); i2++) {
                        try {
                            String str2 = listO.get(i2);
                            PackageInfo packageInfo = packageManager.getPackageInfo(str2, 0);
                            if (packageInfo != null && a(packageInfo)) {
                                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str2, 1);
                                sb.append(str2);
                                sb.append(applicationInfo.uid);
                                i++;
                            }
                        } catch (PackageManager.NameNotFoundException e2) {
                            MobLog.getInstance().d(e2);
                        }
                    }
                    if (i > 0) {
                        String str3 = Build.BRAND;
                        Locale locale = Locale.ROOT;
                        sb.append(str3.toUpperCase(locale));
                        sb.append(Build.MODEL.toUpperCase(locale));
                        sb.append(Build.MANUFACTURER.toUpperCase(locale));
                        sb.append(i);
                        strB = Data.MD5(sb.toString());
                        w.a().a("key_pddt", strB);
                        w.a().a("key_lgpdt", System.currentTimeMillis());
                    }
                }
                return strB;
            } catch (Throwable th) {
                th = th;
                str = strB;
                MobLog.getInstance().d(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private List<String> o() {
        ArrayList arrayList = new ArrayList();
        for (String str : com.mob.tools.a.b.a(MobSDK.getContext()).G()) {
            if (!str.contains("com.google.android") && !str.contains("com.miui.packageinstaller")) {
                arrayList.add(str);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public String b() {
        return "2";
    }

    public String c() {
        if (TextUtils.isEmpty(this.b)) {
            String strB = w.a().b("key_rdt2", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                this.b = strB;
            }
        }
        return this.b;
    }

    public boolean d() {
        if (!TextUtils.isEmpty(this.b)) {
            return false;
        }
        synchronized (this) {
            if (!TextUtils.isEmpty(this.b)) {
                return false;
            }
            return TextUtils.isEmpty(w.a().b("key_rdt2", (String) null));
        }
    }

    public synchronized String e() {
        String strC;
        strC = c();
        if (TextUtils.isEmpty(strC)) {
            strC = j();
            this.b = strC;
            if (!TextUtils.isEmpty(strC)) {
                w.a().a("key_rdt2", strC);
            }
        }
        return strC;
    }

    public synchronized String f() {
        String strC;
        strC = c();
        if (TextUtils.isEmpty(strC)) {
            strC = k();
            this.b = strC;
            if (!TextUtils.isEmpty(strC)) {
                w.a().a("key_rdt2", strC);
            }
        }
        return strC;
    }

    public synchronized String g() {
        if (TextUtils.isEmpty(this.c)) {
            this.c = n();
        }
        return this.c;
    }

    public synchronized String h() {
        if (TextUtils.isEmpty(this.a)) {
            try {
                this.a = m();
                b(this.a);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        return this.a;
    }

    public HashMap<String, Integer> i() {
        return this.f;
    }

    public static t a() {
        if (f17686e == null) {
            synchronized (t.class) {
                if (f17686e == null) {
                    f17686e = new t();
                }
            }
        }
        return f17686e;
    }

    private String c(String str) {
        StringBuilder sb = new StringBuilder(str);
        String manufacturer = DH.SyncMtd.getManufacturer();
        String model = DH.SyncMtd.getModel();
        if (!TextUtils.isEmpty(manufacturer)) {
            sb.append(manufacturer.trim().toUpperCase());
        }
        if (!TextUtils.isEmpty(model)) {
            sb.append(model.trim().toUpperCase());
        }
        return Data.MD5(sb.toString());
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.b)) {
            return;
        }
        MobLog.getInstance().d("rddd saveRD pre is " + this.b + " cur is " + str, new Object[0]);
        w.a().a("key_rdt2", str);
    }

    private byte[] a(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        byte[] bArr = new byte[16];
        for (int i = 0; i < 8; i++) {
            int i2 = (7 - i) * 8;
            bArr[i] = (byte) (mostSignificantBits >>> i2);
            bArr[i + 8] = (byte) (leastSignificantBits >>> i2);
        }
        return bArr;
    }

    private boolean a(PackageInfo packageInfo) {
        int i = packageInfo.applicationInfo.flags;
        return ((i & 1) == 1) || ((i & 128) == 1);
    }
}
