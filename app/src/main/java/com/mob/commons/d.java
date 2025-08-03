package com.mob.commons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.mob.MobSDK;
import com.mob.tools.MDP;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* loaded from: classes2.dex */
public class d {
    private static d a;
    private static volatile SQLiteHelper.SingleTableDB b;

    public static class b implements Runnable {
        private static final b[] a = new b[3];
        private long b;
        private HashMap<String, Object> c;

        private b(long j, HashMap<String, Object> map) {
            this.b = j;
            this.c = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                l.a(l.a(l.b), new k() { // from class: com.mob.commons.d.b.1
                    @Override // com.mob.commons.k
                    public boolean a(FileLocker fileLocker) {
                        DH.requester(MobSDK.getContext()).getNetworkType().request(new DH.DHResponder() { // from class: com.mob.commons.d.b.1.1
                            @Override // com.mob.tools.utils.DH.DHResponder
                            public void onResponse(DH.DHResponse dHResponse) {
                                c cVarB;
                                try {
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put(o.a("004dQdeXli"), String.valueOf(b.this.b));
                                    if (b.this.c != null) {
                                        b.this.c.put(o.a("006Ddf=ee4djHi>di"), MobSDK.getAppkey());
                                        b.this.c.put(o.a("006FdfSeeeLdjff"), DH.SyncMtd.getPackageName());
                                        b.this.c.put(o.a("006QdfNeeji=dh"), DH.SyncMtd.getAppVersionName());
                                        long jLongValue = ((Long) com.mob.commons.b.a(o.a("0105fg.d[dhdfIdiWffdiegTh"), 0L)).longValue();
                                        if (jLongValue != 0) {
                                            b.this.c.put(o.a("010MfgVd<dhdfFdiJffdieg'h"), Long.valueOf(jLongValue));
                                        }
                                    }
                                    contentValues.put(o.a("004hXdf(dZdf"), Base64.encodeToString(Data.AES128Encode(Data.rawMD5(DH.SyncMtd.getManufacturer()), HashonHelper.fromHashMap(b.this.c).getBytes("utf-8")), 2));
                                    SQLiteHelper.insert(d.b, contentValues);
                                    long jLongValue2 = ((Long) com.mob.commons.b.a(o.a("004hiXdc]e"), 2L)).longValue();
                                    String networkType = dHResponse.getNetworkType();
                                    if (networkType == null || o.a("004IdkecdkLi").equals(networkType)) {
                                        jLongValue2 = 120;
                                    }
                                    if (!com.mob.commons.b.c() || (cVarB = c.b()) == null) {
                                        return;
                                    }
                                    if (jLongValue2 <= 0) {
                                        cVarB.run();
                                    } else {
                                        if (com.mob.commons.a.d.a().a(jLongValue2, cVarB)) {
                                            return;
                                        }
                                        cVarB.c();
                                    }
                                } catch (Throwable th) {
                                    MobLog.getInstance().w(th);
                                }
                            }
                        });
                        return false;
                    }
                });
            } finally {
                try {
                } finally {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b b(long j, HashMap<String, Object> map) {
            b[] bVarArr = a;
            synchronized (bVarArr) {
                for (int i = 0; i < 3; i++) {
                    b bVar = bVarArr[i];
                    if (bVar != null) {
                        bVar.b = j;
                        HashMap<String, Object> map2 = bVar.c;
                        if (map2 != null) {
                            map2.clear();
                        }
                        bVar.c = map;
                        bVarArr[i] = null;
                        return bVar;
                    }
                }
                return new b(j, map);
            }
        }

        private void a() {
            try {
                b[] bVarArr = a;
                synchronized (bVarArr) {
                    for (int i = 0; i < 3; i++) {
                        if (bVarArr[i] == null) {
                            this.b = 0L;
                            HashMap<String, Object> map = this.c;
                            if (map != null) {
                                map.clear();
                            }
                            this.c = null;
                            bVarArr[i] = this;
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static class c implements Runnable {
        private static final c[] b = {new c()};
        public boolean a = false;

        /* JADX INFO: Access modifiers changed from: private */
        public static c b() {
            c[] cVarArr = b;
            synchronized (cVarArr) {
                c cVar = cVarArr[0];
                if (cVar == null) {
                    return null;
                }
                cVarArr[0] = null;
                if (cVar.a) {
                    cVar.a = false;
                }
                return cVar;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            try {
                c[] cVarArr = b;
                synchronized (cVarArr) {
                    if (cVarArr[0] == null) {
                        cVarArr[0] = this;
                    }
                }
                this.a = false;
            } catch (Throwable unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            DH.requester(MobSDK.getContext()).getDeviceKey().getIMEI().getSerialno().getDetailNetworkTypeForStatic().getDataNtType().request(new DH.DHResponder() { // from class: com.mob.commons.d.c.1
                /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
                
                    com.mob.commons.a.d.a().b();
                 */
                @Override // com.mob.tools.utils.DH.DHResponder
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResponse(com.mob.tools.utils.DH.DHResponse r6) {
                    /*
                        r5 = this;
                        r0 = 50
                        java.lang.String[][] r1 = new java.lang.String[r0][]     // Catch: java.lang.Throwable -> L3b
                        com.mob.commons.d$c r2 = com.mob.commons.d.c.this     // Catch: java.lang.Throwable -> L3b
                        int r2 = com.mob.commons.d.c.a(r2, r1)     // Catch: java.lang.Throwable -> L3b
                    La:
                        if (r2 <= 0) goto L43
                        com.mob.commons.d$c r3 = com.mob.commons.d.c.this     // Catch: java.lang.Throwable -> L3b
                        android.util.SparseArray r3 = com.mob.commons.d.c.a(r3, r1, r2, r6)     // Catch: java.lang.Throwable -> L3b
                        int r4 = r3.size()     // Catch: java.lang.Throwable -> L3b
                        if (r4 != 0) goto L26
                        com.mob.commons.d$c r4 = com.mob.commons.d.c.this     // Catch: java.lang.Throwable -> L3b
                        boolean r4 = r4.a     // Catch: java.lang.Throwable -> L3b
                        if (r4 == 0) goto L26
                        com.mob.commons.a.d r6 = com.mob.commons.a.d.a()     // Catch: java.lang.Throwable -> L3b
                        r6.b()     // Catch: java.lang.Throwable -> L3b
                        goto L43
                    L26:
                        int r4 = r3.size()     // Catch: java.lang.Throwable -> L3b
                        if (r4 <= 0) goto L31
                        com.mob.commons.d$c r4 = com.mob.commons.d.c.this     // Catch: java.lang.Throwable -> L3b
                        com.mob.commons.d.c.a(r4, r3)     // Catch: java.lang.Throwable -> L3b
                    L31:
                        if (r2 >= r0) goto L34
                        goto L43
                    L34:
                        com.mob.commons.d$c r2 = com.mob.commons.d.c.this     // Catch: java.lang.Throwable -> L3b
                        int r2 = com.mob.commons.d.c.a(r2, r1)     // Catch: java.lang.Throwable -> L3b
                        goto La
                    L3b:
                        r6 = move-exception
                        com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L49
                        r0.d(r6)     // Catch: java.lang.Throwable -> L49
                    L43:
                        com.mob.commons.d$c r6 = com.mob.commons.d.c.this
                        com.mob.commons.d.c.a(r6)
                        return
                    L49:
                        r6 = move-exception
                        com.mob.commons.d$c r0 = com.mob.commons.d.c.this
                        com.mob.commons.d.c.a(r0)
                        throw r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.d.c.AnonymousClass1.onResponse(com.mob.tools.utils.DH$DHResponse):void");
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(String[][] strArr) {
            Cursor cursorQuery = null;
            int i = 0;
            try {
                cursorQuery = SQLiteHelper.query(d.b, new String[]{o.a("004d6deDli"), o.a("004hEdfKd4df")}, null, null, null);
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable unused) {
                        }
                    }
                    return 0;
                }
                if (!cursorQuery.moveToFirst()) {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                    return 0;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i2 = 0;
                try {
                    do {
                        try {
                            String[] strArr2 = {cursorQuery.getString(0), cursorQuery.getString(1)};
                            long j = -1;
                            try {
                                j = Long.parseLong(strArr2[0]);
                            } catch (Throwable unused3) {
                            }
                            if (j <= jCurrentTimeMillis) {
                                strArr[i2] = strArr2;
                                i2++;
                            }
                            if (i2 < strArr.length) {
                            }
                            cursorQuery.close();
                            return i2;
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            try {
                                MobLog.getInstance().w(th);
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                return i;
                            } catch (Throwable th2) {
                                if (cursorQuery != null) {
                                    try {
                                        cursorQuery.close();
                                    } catch (Throwable unused5) {
                                    }
                                }
                                throw th2;
                            }
                        }
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return i2;
                } catch (Throwable unused6) {
                    return i2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a(SparseArray<String> sparseArray) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append('\'');
                    sb.append(sparseArray.valueAt(i));
                    sb.append('\'');
                }
                try {
                    return SQLiteHelper.delete(d.b, "time in (" + sb.toString() + ")", null);
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return SQLiteHelper.delete(d.b, "time in (" + sb.toString() + ")", null);
                }
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
                return 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SparseArray<String> a(String[][] strArr, int i, DH.DHResponse dHResponse) {
            HashMap map;
            ArrayList arrayList;
            SparseArray<String> sparseArray = new SparseArray<>();
            try {
                map = new HashMap();
                map.put(o.a("004e?eddfSd"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
                map.put(o.a("006hij;dedg0i"), dHResponse.getDeviceKey());
                map.put(o.a("005l+ec,hiIed"), DH.SyncMtd.getModel());
                map.put(o.a("004h6dcdePh"), e.a((MobProduct) null));
                map.put("iemt", dHResponse.getIMEI());
                map.put("snmt", dHResponse.getSerialno());
                map.put(o.a("011.dkQidSfdecdhdj+d5diRei"), dHResponse.getDetailNetworkTypeForStatic());
                map.put(o.a("015hMdf*dAdfef]idBfdecdhdjeidi ei"), Integer.valueOf(dHResponse.getDataNtType()));
                arrayList = new ArrayList();
                byte[] bArrRawMD5 = Data.rawMD5(DH.SyncMtd.getManufacturer());
                for (int i2 = 0; i2 < i; i2++) {
                    String[] strArr2 = strArr[i2];
                    try {
                        HashMap mapFromJson = HashonHelper.fromJson(new String(Data.AES128Decode(bArrRawMD5, Base64.decode(strArr2[1], 2)), "utf-8").trim());
                        sparseArray.put(i2, strArr2[0]);
                        arrayList.add(mapFromJson);
                    } catch (Throwable th) {
                        MobLog.getInstance().w(th);
                    }
                }
            } catch (Throwable th2) {
                MobLog.getInstance().w(th2);
            }
            if (arrayList.isEmpty()) {
                return new SparseArray<>();
            }
            map.put(o.a("005hLdf%d8dffg"), arrayList);
            map.put(o.a("005d!ecdj=i?dk"), x.a().b());
            HashMap<String, String> map2 = new HashMap<>();
            map2.put(o.a("0130eefg,i dhhiegDhi3dk4dFde_d9di"), v.c());
            map2.put(o.a("004l*ecde?h"), com.mob.tools.a.c.a(MobSDK.getContext()).b().aY());
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            if (!"200".equals(String.valueOf(HashonHelper.fromJson(new NetworkHelper().httpPostWithBytes(com.mob.commons.c.a(com.mob.commons.c.c) + "/v6/gcl", a(HashonHelper.fromHashMap(map)), map2, networkTimeOut)).get(o.a("006>fg<d0df+d>dcfg"))))) {
                sparseArray.clear();
            }
            return sparseArray;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static byte[] a(String str) throws Throwable {
            DataOutputStream dataOutputStream;
            BufferedOutputStream bufferedOutputStream;
            DataOutputStream dataOutputStream2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream3 = null;
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                SecureRandom secureRandom = new SecureRandom();
                dataOutputStream.writeLong(secureRandom.nextLong());
                dataOutputStream.writeLong(secureRandom.nextLong());
                dataOutputStream.flush();
                C5340r.a(dataOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new GZIPOutputStream(byteArrayOutputStream2));
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    bufferedOutputStream.write(str.getBytes("utf-8"));
                    bufferedOutputStream.flush();
                    C5340r.a(bufferedOutputStream);
                    byte[] bArrAES128Encode = Data.AES128Encode(byteArray, byteArrayOutputStream2.toByteArray());
                    byte[] bArrEncode = new MobRSA(1024).encode(byteArray, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
                    ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                    try {
                        dataOutputStream2 = new DataOutputStream(byteArrayOutputStream3);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        dataOutputStream2.writeInt(bArrEncode.length);
                        dataOutputStream2.write(bArrEncode);
                        dataOutputStream2.writeInt(bArrAES128Encode.length);
                        dataOutputStream2.write(bArrAES128Encode);
                        dataOutputStream2.flush();
                        C5340r.a(dataOutputStream2);
                        return byteArrayOutputStream3.toByteArray();
                    } catch (Throwable th4) {
                        th = th4;
                        dataOutputStream = dataOutputStream2;
                        C5340r.a(dataOutputStream);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    dataOutputStream3 = bufferedOutputStream;
                    C5340r.a(dataOutputStream3);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                dataOutputStream3 = dataOutputStream;
                C5340r.a(dataOutputStream3);
                throw th;
            }
        }
    }

    private d() {
        try {
            Context context = MobSDK.getContext();
            String str = j.a;
            File dataCacheFile = ResHelper.getDataCacheFile(context, str, true);
            if (dataCacheFile.exists() && dataCacheFile.length() > 209715200) {
                dataCacheFile.delete();
                dataCacheFile = ResHelper.getDataCacheFile(MobSDK.getContext(), str, true);
            }
            b = SQLiteHelper.getDatabase(dataCacheFile.getAbsolutePath(), o.a("008WfidfWdYdfhdWi6df_e") + "_1");
            b.addField(o.a("004d!de5li"), o.a("004di+dl0d"), true);
            b.addField(o.a("004hYdfYdGdf"), o.a("004di6dl.d"), true);
            c cVarB = c.b();
            if (cVarB != null) {
                com.mob.commons.a.d.a().a(0L, MPEGConst.SEQUENCE_ERROR_CODE, cVarB);
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
    }

    public static synchronized d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public static class a implements Runnable {
        public boolean a = false;
        private String b;
        private byte[] c;
        private String d;

        public a(String str, String str2) {
            this.b = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = null;
                boolean z = false;
                for (Method method2 : com.mob.tools.b.a.class.getMethods()) {
                    Annotation[] annotations = method2.getAnnotations();
                    if (annotations != null) {
                        int length = annotations.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Annotation annotation = annotations[i];
                            if (annotation != null && annotation.annotationType() == com.mob.tools.b.b.class) {
                                z = true;
                                method = method2;
                                break;
                            }
                            i++;
                        }
                        if (z) {
                            break;
                        }
                    }
                }
                if (this.a) {
                    com.mob.commons.cc.a.a(MobSDK.getContext(), this.c, this.d, method);
                } else {
                    com.mob.commons.cc.a.a(MobSDK.getContext(), this.b, this.d, method);
                }
            } catch (Throwable th) {
                try {
                    f.a().a(6, th);
                    MobLog.getInstance().d(th);
                } catch (Throwable unused) {
                }
            }
        }

        public a(byte[] bArr, String str) {
            this.c = bArr;
            this.d = str;
        }
    }

    public void a(long j, HashMap<String, Object> map) {
        boolean zA = com.mob.commons.b.a();
        MobLog.getInstance().d("DH PD: " + map.get(o.a("004d^di*ei")) + ", to: " + zA, new Object[0]);
        if (zA) {
            u.d.execute(b.b(j, map));
        }
    }

    public static void a(final ArrayList<HashMap<String, Object>> arrayList, final com.mob.tools.utils.b<Void> bVar) throws Throwable {
        if (arrayList != null && !arrayList.isEmpty()) {
            final File file = new File(MobSDK.getContext().getFilesDir(), o.a("003Zfgfced"));
            DH.requester(MobSDK.getContext()).getDeviceKey().getIMEI().getIMSI().getSerialno().getSimSerialNumber().getMIUIVersion().getAdvertisingID().getBssid().request(new DH.DHResponder() { // from class: com.mob.commons.d.1
                @Override // com.mob.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    ByteArrayOutputStream byteArrayOutputStream;
                    FileOutputStream fileOutputStream;
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            HashMap map = (HashMap) it.next();
                            Boolean bool = (Boolean) map.get(o.a("002(dffg"));
                            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
                            String str = (String) map.get(o.a("002Wfhed"));
                            String str2 = (String) map.get("m");
                            String str3 = (String) map.get("args");
                            Object obj = map.get(o.a("002(de[h"));
                            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                                String strA = e.a((MobProduct) null);
                                HashMap map2 = new HashMap();
                                map2.put(o.a("004hTdcdeLh"), strA);
                                map2.put(o.a("005dXecdj=iEdk"), x.a().b());
                                map2.put(o.a("004l,ecdeEh"), com.mob.tools.a.c.a(MobSDK.getContext()).b().aX());
                                map2.put(o.a("010;fgSh[djgfFi(dhfgdeecdk"), Integer.valueOf(MobSDK.SDK_VERSION_CODE));
                                map2.put(o.a("006NdfVee2dj=i5di"), MobSDK.getAppkey());
                                map2.put(o.a("009Udf2ee@eh2i$dgdhIid"), MobSDK.getAppSecret());
                                map2.put(o.a("006h:ecSl+dfdedk"), MobSDK.getDomain().getDomain());
                                map2.put(o.a("010Hfhecdhdg<iHhd;ddeJfg"), Boolean.valueOf(MobSDK.checkForceHttps()));
                                map2.put(o.a("004iXdg^iVdl"), Long.valueOf(((Long) com.mob.commons.b.a(o.a("004iLdg+iNdl"), 5L)).longValue()));
                                map2.put(o.a("002=dgZh"), (String) com.mob.commons.b.a(o.a("002?dg$h"), o.a("0067gkgkglglglgl")));
                                map2.put("usridt", v.d());
                                map2.put(o.a("002UdeBh"), obj);
                                if (!TextUtils.isEmpty(str3)) {
                                    map2.put("args", HashonHelper.fromJson(str3));
                                }
                                map2.put(o.a("008hij8dedg>i-egIh"), dHResponse.getDeviceKey());
                                map2.put(o.a("004VdeSliWde"), dHResponse.getIMEI());
                                map2.put(o.a("004UdeEl8fgde"), dHResponse.getIMSI());
                                map2.put("sno", dHResponse.getSerialno());
                                map2.put("ssno", dHResponse.getSimSerialNumber());
                                map2.put("miui", dHResponse.getMIUIVersion());
                                map2.put(o.a("005l=ecRhi>ed"), DH.SyncMtd.getModel());
                                map2.put(o.a("007AfhdfdgYdCecdhdi"), DH.SyncMtd.getManufacturer());
                                map2.put(o.a("005$fcdhdfdk.h"), DH.SyncMtd.getBrand());
                                map2.put(o.a("005QdfQh0fgde)h"), dHResponse.getAdvertisingID());
                                map2.put(o.a("0064dfHeeji?dh"), DH.SyncMtd.getAppVersionName());
                                map2.put("appVerCode", Integer.valueOf(DH.SyncMtd.getAppVersion()));
                                map2.put(o.a("011e<dfdgdjdfffTi=efdf-li"), DH.SyncMtd.getPackageName());
                                map2.put(o.a("005'fcfgfgdeUh"), dHResponse.getBssid());
                                map2.put("osint", Integer.valueOf(DH.SyncMtd.getOSVersionInt()));
                                map2.put("osname", DH.SyncMtd.getOSVersionName());
                                map2.put("mdpName", MDP.class.getName());
                                String strFromHashMap = HashonHelper.fromHashMap(map2);
                                String strCheckHttpRequestUrl = NetCommunicator.checkHttpRequestUrl(str);
                                if (zBooleanValue) {
                                    try {
                                        File file2 = new File(file, str2);
                                        if (file2.exists() && str2.equals(Data.MD5(file2))) {
                                            new Thread(new a(file2.getAbsolutePath(), strFromHashMap)).start();
                                        } else {
                                            if (file2.exists()) {
                                                file2.delete();
                                            }
                                            file.mkdirs();
                                            try {
                                                fileOutputStream = new FileOutputStream(file2);
                                            } catch (Throwable th) {
                                                th = th;
                                                fileOutputStream = null;
                                            }
                                            try {
                                                new NetworkHelper().download(strCheckHttpRequestUrl, fileOutputStream, null);
                                                C5340r.a(fileOutputStream);
                                                if (file2.length() > 0 && TextUtils.equals(str2, Data.MD5(file2))) {
                                                    new Thread(new a(file2.getAbsolutePath(), strFromHashMap)).start();
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                C5340r.a(fileOutputStream);
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        f.a().a(5, th3);
                                        MobLog.getInstance().d(th3);
                                    }
                                } else {
                                    File file3 = new File(file, str2);
                                    if (file3.exists()) {
                                        file3.delete();
                                    }
                                    final byte[][] bArr = new byte[1][];
                                    final int[] iArr = new int[1];
                                    try {
                                        byteArrayOutputStream = new ByteArrayOutputStream() { // from class: com.mob.commons.d.1.1
                                            @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                                            public void close() throws IOException {
                                                super.close();
                                                bArr[0] = ((ByteArrayOutputStream) this).buf;
                                                iArr[0] = ((ByteArrayOutputStream) this).count;
                                            }
                                        };
                                    } catch (Throwable th4) {
                                        th = th4;
                                        byteArrayOutputStream = null;
                                    }
                                    try {
                                        new NetworkHelper().download(strCheckHttpRequestUrl, byteArrayOutputStream, null);
                                        C5340r.a(byteArrayOutputStream);
                                        new Thread(new a(byteArrayOutputStream.toByteArray(), strFromHashMap)).start();
                                    } catch (Throwable th5) {
                                        th = th5;
                                        C5340r.a(byteArrayOutputStream);
                                        throw th;
                                    }
                                }
                            }
                            return;
                        }
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            });
        } else {
            bVar.a(null);
        }
    }

    public static String a(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < s.e().length()) {
                sb.append((char) (r2.charAt(iArr[i]) - 2));
            }
        }
        return sb.toString();
    }
}
