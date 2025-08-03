package com.mob.commons;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetCommunicator;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.ResHelper;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class a {
    private boolean a = false;
    private final byte[] b = new byte[0];

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f() {
        w wVarA = w.a();
        String str = w.a;
        long jB = wVarA.b(str, -1L);
        if (jB != -1) {
            return System.currentTimeMillis() >= jB + (((Long) com.mob.commons.b.a(o.a("005h7deffdfHe"), 2592000L)).longValue() * 1000);
        }
        w.a().a(str, System.currentTimeMillis());
        return false;
    }

    private String c() {
        return o.a("0165fgPh@djeldgecBll=ecdkdfNe elfg.hEdj");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File d() {
        return ResHelper.getDataCacheFile(MobSDK.getContext(), j.b, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, Object> e() {
        try {
            return a(d());
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public synchronized String b() {
        String strA;
        Throwable th;
        String strC = null;
        byte b2 = 0;
        try {
            strA = a();
        } catch (Throwable th2) {
            strA = strC;
            th = th2;
        }
        try {
        } catch (Throwable th3) {
            th = th3;
            MobLog.getInstance().d(th);
            return strA;
        }
        if (!TextUtils.isEmpty(strA) && !TextUtils.equals("null", strA)) {
            return strA;
        }
        C1885a c1885aA = new b().a();
        if (c1885aA != null) {
            strC = c1885aA.c();
            HashMap<String, Object> map = new HashMap<>();
            map.put(o.a("004h7dcdeKh"), strC);
            a(map);
            strA = strC;
        }
        return strA;
    }

    public static class b {
        private static final List<String> a = Arrays.asList("4c5f81a0-4728-476f-a57f-b46fa44f07d3", "f6af99e2-2b64-4eb6-aba6-4d44fb935939", "00000000-0000-0000-0000-000000000000");
        private static final List<String> b = Arrays.asList("0", "867731020001006", "00000000", "012345678912345", "1152", "000000000000000");
        private static final List<String> c = Arrays.asList("D01EB0A014660Q99", "ZTEBA611T", "C1330", "ZTEBA610T", "28Y67IJ7T3", "HMN5S1FLOQ", "01234567890123456789", o.a("007Hdcdkdjdkecfddk"), "1234567890ABCDEF", "SY58S62YHN", "ACKRZJFKSN", "ZTEBA910", "LenovoTAB2A8", "ZTEBA520", "0123456789ABCDEF", "ZTEBA510");
        private static final List<String> d = Arrays.asList("14:63:18:3D:AB:18", "00:81:df:d5:a6:a5", "080027C446C0", "08:00:27:a9:d5:97", "00:02:00:00:00:00", o.a("017$fegkEf7fefe;fDfefeIfNfefeEfJfefeRf$fefe"), "ff:ff:ff:ff:ff:ff", "00:81:3c:75:32:e1", "A6:C0:80:E4:1A:50", o.a("017=fefe4f;fefe fAfefe!fDfefe'fGfefe^fXfefe"), "58:02:03:04:05:06", "00:90:4c:11:22:33", "08:00:27:b2:8b:50", "90:67:1c:e6:4d:55");

        /* renamed from: e, reason: collision with root package name */
        private static final List<String> f17666e = Arrays.asList("00000000-0000-0000-0000-000000000000", "00000000000000000000000000000000");
        private List<String> f;
        private List<String> g;
        private List<String> h;
        private List<String> i;
        private List<String> j;

        private b() {
        }

        private void c() {
            c cVarD = MobSDK.SDK_VERSION_CODE + 30 >= d() ? w.a().d() : e();
            if (cVarD != null) {
                if (cVarD.c() != null) {
                    this.f = cVarD.c();
                }
                if (cVarD.d() != null) {
                    this.g = cVarD.d();
                }
                if (cVarD.e() != null) {
                    this.h = cVarD.e();
                }
                if (cVarD.f() != null) {
                    this.i = cVarD.f();
                }
                if (cVarD.g() != null) {
                    this.j = cVarD.g();
                }
            }
            if (this.f == null) {
                this.f = a;
            }
            if (this.g == null) {
                this.g = b;
            }
            if (this.h == null) {
                this.h = c;
            }
            if (this.i == null) {
                this.i = d;
            }
            if (this.j == null) {
                this.j = f17666e;
            }
        }

        private int d() {
            try {
                return Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return 0;
            }
        }

        private c e() {
            try {
                NetworkHelper networkHelper = new NetworkHelper();
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.connectionTimeout = 2000;
                networkTimeOut.readTimout = 5000;
                String strHttpPostNew = networkHelper.httpPostNew(com.mob.commons.c.a(com.mob.commons.c.f17670e) + "/getDuidBlacklist", null, null, networkTimeOut);
                HashMap mapFromJson = HashonHelper.fromJson(strHttpPostNew);
                if (mapFromJson != null && !mapFromJson.isEmpty()) {
                    if (!"200".equals(String.valueOf(mapFromJson.get(o.a("006Efg<d'df<d8dcfg"))))) {
                        throw new Throwable("RS is illegal: " + strHttpPostNew);
                    }
                    String strValueOf = String.valueOf(mapFromJson.get(o.a("004hGdf!dOdf")));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        c cVarA = c.a(Data.AES128Decode(f(), Base64.decode(strValueOf, 0)));
                        w.a().a(cVarA);
                        return cVarA;
                    }
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
            return null;
        }

        private String f() {
            String[] strArr = {"QvxJJ", "FYsAX", "cvWe", "MqlWJL"};
            return strArr[1] + strArr[3] + new String[]{"akuRE", "wbMqR", "uBs", "CDpnc"}[3];
        }

        public C1885a a() {
            try {
                c();
                return b();
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return null;
            }
        }

        public C1885a b() {
            String strByteToHex;
            try {
                final String[] strArr = new String[1];
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                DH.requester(MobSDK.getContext()).getAdvertisingID().request(new DH.DHResponder() { // from class: com.mob.commons.a.b.1
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        try {
                            strArr[0] = dHResponse.getAdvertisingID();
                        } finally {
                            try {
                            } finally {
                            }
                        }
                    }
                });
                countDownLatch.await(150L, TimeUnit.MILLISECONDS);
                String strA = (TextUtils.isEmpty(strArr[0]) || this.f.contains(strArr[0])) ? null : strArr[0];
                if (TextUtils.isEmpty(strA)) {
                    strA = a(SystemClock.elapsedRealtime());
                }
                try {
                    strByteToHex = !TextUtils.isEmpty(strA) ? Data.byteToHex(Data.SHA1(strA)) : null;
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                    strByteToHex = null;
                }
                C1885a c1885a = new C1885a(strByteToHex, System.currentTimeMillis(), "client", 0L, Base64.encodeToString(strA.getBytes(), 2));
                w.a().a(c1885a);
                return c1885a;
            } catch (Throwable th2) {
                MobLog.getInstance().e(th2);
                return null;
            }
        }

        private String a(long j) {
            try {
                String string = UUID.randomUUID().toString();
                return TextUtils.isEmpty(string) ? b(j) : string;
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return null;
            }
        }

        private String b(long j) {
            DataOutputStream dataOutputStream;
            long jNextLong;
            long jCurrentTimeMillis;
            ByteArrayOutputStream byteArrayOutputStream;
            String strByteToHex = null;
            try {
                try {
                    jNextLong = new SecureRandom().nextLong();
                    jCurrentTimeMillis = j + System.currentTimeMillis();
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = null;
                }
            } catch (Throwable th2) {
                MobLog.getInstance().d(th2);
            }
            try {
                dataOutputStream.writeLong(jNextLong);
                dataOutputStream.writeLong(jCurrentTimeMillis);
                strByteToHex = Data.byteToHex(byteArrayOutputStream.toByteArray());
                dataOutputStream.flush();
                dataOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    MobLog.getInstance().d(th);
                    if (dataOutputStream != null) {
                        dataOutputStream.flush();
                        dataOutputStream.close();
                    }
                    return strByteToHex;
                } catch (Throwable th4) {
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.flush();
                            dataOutputStream.close();
                        } catch (Throwable th5) {
                            MobLog.getInstance().d(th5);
                        }
                    }
                    throw th4;
                }
            }
            return strByteToHex;
        }
    }

    public static class c {
        private List<String> a;
        private List<String> b;
        private List<String> c;
        private List<String> d;

        /* renamed from: e, reason: collision with root package name */
        private List<String> f17668e;

        public c(List<String> list, List<String> list2, List<String> list3, List<String> list4, List<String> list5) {
            this.a = list;
            this.b = list2;
            this.c = list3;
            this.d = list4;
            this.f17668e = list5;
        }

        public static c a(String str) {
            List<String> list;
            List<String> list2;
            List<String> list3;
            List<String> list4;
            List<String> list5;
            List<String> listB;
            List<String> listB2;
            List<String> listB3;
            List<String> listB4;
            List<String> listB5;
            if (!TextUtils.isEmpty(str)) {
                try {
                    HashMap mapFromJson = HashonHelper.fromJson(str);
                    Object obj = mapFromJson.get("idfas");
                    if (obj == null) {
                        list = null;
                    } else {
                        if (obj instanceof String) {
                            listB5 = b((String) obj);
                        } else {
                            if (obj instanceof List) {
                                listB5 = (List) obj;
                            }
                            list = null;
                        }
                        list = listB5;
                    }
                    Object obj2 = mapFromJson.get("ieid");
                    if (obj2 == null) {
                        list2 = null;
                    } else {
                        if (obj2 instanceof String) {
                            listB4 = b((String) obj2);
                        } else {
                            if (obj2 instanceof List) {
                                listB4 = (List) obj2;
                            }
                            list2 = null;
                        }
                        list2 = listB4;
                    }
                    Object obj3 = mapFromJson.get("snid");
                    if (obj3 == null) {
                        list3 = null;
                    } else {
                        if (obj3 instanceof String) {
                            listB3 = b((String) obj3);
                        } else {
                            if (obj3 instanceof List) {
                                listB3 = (List) obj3;
                            }
                            list3 = null;
                        }
                        list3 = listB3;
                    }
                    Object obj4 = mapFromJson.get("mcid");
                    if (obj4 == null) {
                        list4 = null;
                    } else {
                        if (obj4 instanceof String) {
                            listB2 = b((String) obj4);
                        } else {
                            if (obj4 instanceof List) {
                                listB2 = (List) obj4;
                            }
                            list4 = null;
                        }
                        list4 = listB2;
                    }
                    Object obj5 = mapFromJson.get("oiid");
                    if (obj5 == null) {
                        list5 = null;
                    } else {
                        if (obj5 instanceof String) {
                            listB = b((String) obj5);
                        } else {
                            if (obj5 instanceof List) {
                                listB = (List) obj5;
                            }
                            list5 = null;
                        }
                        list5 = listB;
                    }
                    return new c(list, list2, list3, list4, list5);
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
            return null;
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> map = new HashMap<>();
            map.put("idfas", this.a);
            map.put("ieid", this.b);
            map.put("snid", this.c);
            map.put("mcid", this.d);
            map.put("oiid", this.f17668e);
            return map;
        }

        public List<String> c() {
            return this.a;
        }

        public List<String> d() {
            return this.b;
        }

        public List<String> e() {
            return this.c;
        }

        public List<String> f() {
            return this.d;
        }

        public List<String> g() {
            return this.f17668e;
        }

        private static List<String> b(String str) {
            String[] strArrSplit;
            ArrayList arrayList = new ArrayList();
            try {
                return (TextUtils.isEmpty(str) || (strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) == null || strArrSplit.length <= 0) ? arrayList : new ArrayList(Arrays.asList(strArrSplit));
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return arrayList;
            }
        }

        public String a() {
            return HashonHelper.fromHashMap(b());
        }
    }

    public synchronized String a() {
        String strC;
        strC = null;
        try {
            C1885a c1885aE = w.a().e();
            if (c1885aE != null && !TextUtils.isEmpty(c1885aE.c())) {
                strC = c1885aE.c();
            } else {
                HashMap<String, Object> mapE = e();
                if (mapE != null) {
                    strC = (String) mapE.get(o.a("004hHdcde0h"));
                }
            }
        } finally {
            return strC;
        }
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(File file, HashMap<String, Object> map) {
        FileOutputStream fileOutputStream;
        try {
            byte[] bArrA = a(DH.SyncMtd.getModel(), map);
            ResHelper.deleteFileAndFolder(file);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileChannel channel = null;
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                channel = fileOutputStream.getChannel();
                channel.write(ByteBuffer.wrap(bArrA));
                channel.force(true);
                C5340r.a(channel, fileOutputStream);
            } catch (Throwable th2) {
                th = th2;
                C5340r.a(channel, fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            MobLog.getInstance().d(th3);
        }
    }

    public void a(final MobProduct mobProduct, final com.mob.tools.utils.b<Void> bVar) {
        MobLog.getInstance().d("di init", new Object[0]);
        DH.requester(MobSDK.getContext()).getAdvertisingID().getSimSerialNumber().getIMEI().getIMSI().getSerialno().getCarrier().getMemoryInfo().getSizeInfo().queryIMSI().queryIMEI().cx().isRooted().getDeviceType().checkPad().getScreenSize().getDetailNetworkTypeForStatic().getODH().getOD().getAppLastUpdateTime().getMIUIVersion().request(new DH.DHResponder() { // from class: com.mob.commons.a.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                boolean z;
                boolean z2;
                try {
                    synchronized (a.this.b) {
                        String strA = a.this.a(e.a, dHResponse);
                        HashMap mapE = a.this.e();
                        boolean z3 = true;
                        if (strA != null) {
                            z2 = !TextUtils.equals(strA, (String) mapE.get(o.a("004hLdcde=h")));
                            mapE.put(o.a("004hCdcde]h"), strA);
                            z = true;
                        } else {
                            z = false;
                            z2 = false;
                        }
                        boolean zA = a.this.a((HashMap<String, Object>) mapE, z2, dHResponse);
                        boolean zF = a.this.f();
                        MobLog.getInstance().d("map: " + mapE + "\nisCh: " + zA + "\nisG: " + zF, new Object[0]);
                        a.this.a = zA || zF;
                        if (a.this.a) {
                            a.this.a((HashMap<String, Object>) mapE, dHResponse);
                            z = true;
                        }
                        if (!a.this.a((HashMap<String, Object>) mapE, mobProduct, dHResponse)) {
                            z3 = z;
                        }
                        if (a.this.a) {
                            a.this.a((HashMap<String, Object>) mapE, (String) mapE.get(o.a("004hPdcde(h")), dHResponse);
                        }
                        if (z3) {
                            a.this.a((HashMap<String, Object>) mapE);
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        });
    }

    /* renamed from: com.mob.commons.a$a, reason: collision with other inner class name */
    public static class C1885a {
        private String a;
        private long b;
        private String c;
        private long d;

        /* renamed from: e, reason: collision with root package name */
        private String f17664e;

        public C1885a(String str, long j, String str2, long j2, String str3) {
            this.a = str;
            this.b = j;
            this.c = str2;
            this.d = j2;
            this.f17664e = str3;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.mob.commons.a.C1885a a(java.lang.String r12) {
            /*
                boolean r0 = android.text.TextUtils.isEmpty(r12)
                r1 = 0
                if (r0 != 0) goto Laa
                java.util.HashMap r12 = com.mob.tools.utils.HashonHelper.fromJson(r12)     // Catch: java.lang.Throwable -> La2
                java.lang.String r0 = "004hPdcde)h"
                java.lang.String r0 = com.mob.commons.o.a(r0)     // Catch: java.lang.Throwable -> La2
                java.lang.Object r0 = r12.get(r0)     // Catch: java.lang.Throwable -> La2
                java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> La2
                boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> La2
                java.lang.String r3 = "null"
                if (r2 != 0) goto L26
                boolean r2 = android.text.TextUtils.equals(r3, r0)     // Catch: java.lang.Throwable -> La2
                if (r2 != 0) goto L26
                goto L27
            L26:
                r0 = r1
            L27:
                java.lang.String r2 = "genType"
                java.lang.Object r2 = r12.get(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> La2
                boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La2
                if (r4 != 0) goto L3d
                boolean r4 = android.text.TextUtils.equals(r3, r2)     // Catch: java.lang.Throwable -> La2
                if (r4 != 0) goto L3d
                r6 = r2
                goto L3e
            L3d:
                r6 = r1
            L3e:
                java.lang.String r2 = "gp"
                java.lang.Object r2 = r12.get(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> La2
                boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> La2
                if (r4 != 0) goto L54
                boolean r3 = android.text.TextUtils.equals(r3, r2)     // Catch: java.lang.Throwable -> La2
                if (r3 != 0) goto L54
                r9 = r2
                goto L55
            L54:
                r9 = r1
            L55:
                java.lang.String r2 = "gt"
                java.lang.Object r2 = r12.get(r2)     // Catch: java.lang.Throwable -> La2
                r3 = 0
                if (r2 == 0) goto L76
                boolean r5 = r2 instanceof java.lang.Long     // Catch: java.lang.Throwable -> La2
                if (r5 == 0) goto L6a
                java.lang.Long r2 = (java.lang.Long) r2     // Catch: java.lang.Throwable -> La2
                long r7 = r2.longValue()     // Catch: java.lang.Throwable -> La2
                goto L77
            L6a:
                boolean r5 = r2 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> La2
                if (r5 == 0) goto L76
                java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: java.lang.Throwable -> La2
                int r2 = r2.intValue()     // Catch: java.lang.Throwable -> La2
                long r7 = (long) r2     // Catch: java.lang.Throwable -> La2
                goto L77
            L76:
                r7 = r3
            L77:
                java.lang.String r2 = "expTime"
                java.lang.Object r12 = r12.get(r2)     // Catch: java.lang.Throwable -> La2
                if (r12 == 0) goto L97
                boolean r2 = r12 instanceof java.lang.Long     // Catch: java.lang.Throwable -> La2
                if (r2 == 0) goto L8b
                java.lang.Long r12 = (java.lang.Long) r12     // Catch: java.lang.Throwable -> La2
                long r2 = r12.longValue()     // Catch: java.lang.Throwable -> La2
            L89:
                r10 = r2
                goto L98
            L8b:
                boolean r2 = r12 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> La2
                if (r2 == 0) goto L97
                java.lang.Integer r12 = (java.lang.Integer) r12     // Catch: java.lang.Throwable -> La2
                int r12 = r12.intValue()     // Catch: java.lang.Throwable -> La2
                long r2 = (long) r12     // Catch: java.lang.Throwable -> La2
                goto L89
            L97:
                r10 = r3
            L98:
                com.mob.commons.a$a r12 = new com.mob.commons.a$a     // Catch: java.lang.Throwable -> La2
                r2 = r12
                r3 = r0
                r4 = r7
                r7 = r10
                r2.<init>(r3, r4, r6, r7, r9)     // Catch: java.lang.Throwable -> La2
                return r12
            La2:
                r12 = move-exception
                com.mob.tools.log.NLog r0 = com.mob.tools.MobLog.getInstance()
                r0.d(r12)
            Laa:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.C1885a.a(java.lang.String):com.mob.commons.a$a");
        }

        public HashMap<String, Object> b() {
            HashMap<String, Object> map = new HashMap<>();
            map.put(o.a("004h$dcde(h"), this.a);
            map.put("gt", Long.valueOf(this.b));
            map.put("genType", this.c);
            map.put("expTime", Long.valueOf(this.d));
            map.put("gp", this.f17664e);
            return map;
        }

        public String c() {
            return this.a;
        }

        public long d() {
            return this.b;
        }

        public String e() {
            return this.c;
        }

        public long f() {
            return this.d;
        }

        public String g() {
            return this.f17664e;
        }

        public String a() {
            try {
                return HashonHelper.fromHashMap(b());
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return null;
            }
        }

        public boolean a(long j) {
            long j2 = this.d;
            return j2 == 0 || j + (j2 * 1000) <= System.currentTimeMillis();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static HashMap<String, Object> b(File file) {
        FileChannel fileChannel;
        FileInputStream fileInputStream;
        if (file.exists()) {
            FileChannel channel = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                channel = fileInputStream.getChannel();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                while (channel.read(byteBufferAllocate) > 0) {
                }
                HashMap<String, Object> mapA = a(DH.SyncMtd.getModel(), byteBufferAllocate.array());
                C5340r.a(channel, fileInputStream);
                return mapA;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = channel;
                channel = fileInputStream;
                try {
                    MobLog.getInstance().d(th);
                    C5340r.a(fileChannel, channel);
                    return new HashMap<>();
                } catch (Throwable th3) {
                    C5340r.a(fileChannel, channel);
                    throw th3;
                }
            }
        }
        return new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, DH.DHResponse dHResponse) {
        try {
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        if (!com.mob.commons.b.c()) {
            return null;
        }
        C1885a c1885aE = w.a().e();
        if (c1885aE != null && !c1885aE.a(w.a().b("key_request_duid_time", 0L)) && !t.a().d()) {
            return null;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put(o.a("004e*eddfOd"), 1);
        map.put("iemt", dHResponse.getIMEI());
        map.put("snmt", dHResponse.getSerialno());
        map.put(o.a("005l!ecGhi7ed"), DH.SyncMtd.getModel());
        map.put(o.a("007;fhdfdgWd7ecdhdi"), DH.SyncMtd.getManufacturer());
        map.put("admt", dHResponse.getAdvertisingID());
        map.put("oamt", com.mob.tools.a.c.a(MobSDK.getContext()).b().aX());
        map.put("ismt", dHResponse.getIMSI());
        map.put("ssnmt", dHResponse.getSimSerialNumber());
        map.put("inpkgt", Long.valueOf(dHResponse.getAppLastUpdateTime()));
        map.put("btt", Long.valueOf(SystemClock.elapsedRealtime()));
        map.put(o.a("004MdhXh9de?h"), t.a().e());
        map.put(am.aE, t.a().b());
        map.put(o.a("004e%dcde-h"), t.a().g());
        map.put(o.a("005hMdhUlHde-h"), t.a().h());
        map.put(o.a("008dGecXeFddVh9dh-l>fg"), t.a().i());
        if (c1885aE == null) {
            map.put(o.a("004hPdcdeHh"), str);
            map.put("genType", "common");
        } else {
            map.put(o.a("004hVdcdePh"), c1885aE.c());
            map.put("gt", Long.valueOf(c1885aE.d()));
            map.put("genType", c1885aE.e());
            map.put("expTime", Long.valueOf(c1885aE.f()));
            map.put("gp", c1885aE.g());
        }
        HashMap map2 = (HashMap) new NetCommunicator(1024, "ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", "191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd").requestSynchronized(map, com.mob.commons.c.a(com.mob.commons.c.f17670e) + "/v3/dgen", false);
        if (map2 != null) {
            w.a().a("key_request_duid_time", System.currentTimeMillis());
            try {
                String str2 = (String) map2.get(o.a("004Ldh(hQdeIh"));
                if (!TextUtils.isEmpty(str2)) {
                    t.a().a(str2);
                }
            } catch (Throwable unused) {
            }
            C1885a c1885aA = C1885a.a(HashonHelper.fromHashMap(map2));
            if (c1885aA != null) {
                w.a().a(c1885aA);
                return c1885aA.c();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map, MobProduct mobProduct, DH.DHResponse dHResponse) {
        if (mobProduct == null) {
            mobProduct = new MobProduct() { // from class: com.mob.commons.Authorizer$2
                @Override // com.mob.commons.MobProduct
                public String getProductTag() {
                    return o.a("0064ggflgigiflef");
                }

                @Override // com.mob.commons.MobProduct
                public int getSdkver() {
                    return MobSDK.SDK_VERSION_CODE;
                }
            };
        }
        boolean z = false;
        try {
            HashMap map2 = (HashMap) map.get(o.a("007)df.eeNegdkfhec"));
            if (map2 == null) {
                map2 = new HashMap();
                map.put(o.a("0079df?eeWegdkfhec"), map2);
                z = true;
            }
            HashMap map3 = (HashMap) map2.get(DH.SyncMtd.getPackageName());
            String str = map3 != null ? (String) map3.get(mobProduct.getProductTag()) : null;
            String appkey = MobSDK.getAppkey();
            if (str == null || !str.equals(appkey)) {
                if (a(mobProduct, map, dHResponse)) {
                    return true;
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return z;
    }

    private boolean a(MobProduct mobProduct, HashMap<String, Object> map, DH.DHResponse dHResponse) throws Throwable {
        if (!com.mob.commons.b.c()) {
            return false;
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put(o.a("007e)dhec6h9dcdg8d"), mobProduct.getProductTag());
        C1885a c1885aE = w.a().e();
        String strC = c1885aE != null ? c1885aE.c() : null;
        String strValueOf = String.valueOf(DH.SyncMtd.getPackageName());
        map2.put(o.a("006^df1eeDdjTi+di"), MobSDK.getAppkey());
        map2.put(o.a("004hLdcdeEh"), strC);
        map2.put(o.a("006+df5eee,djff"), strValueOf);
        map2.put(o.a("006:df[eeji'dh"), String.valueOf(DH.SyncMtd.getAppVersion()));
        map2.put(o.a("006Afg>h2djYjiBdh"), String.valueOf(mobProduct.getSdkver()));
        map2.put(o.a("007<dk8id+fdecdhdj"), String.valueOf(dHResponse.getDetailNetworkTypeForStatic()));
        String str = com.mob.commons.c.a(com.mob.commons.c.f17670e) + o.a("006gh@fgdeffdk");
        HashMap<String, String> map3 = new HashMap<>();
        map3.put(o.a("013CeefgUi]dhhieg(hi%dkRd0de[dYdi"), v.c());
        map3.put(o.a("004l$ecdeNh"), dHResponse.getODH());
        NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
        networkTimeOut.readTimout = ModuleDescriptor.MODULE_VERSION;
        networkTimeOut.connectionTimeout = ModuleDescriptor.MODULE_VERSION;
        HashMap mapFromJson = HashonHelper.fromJson(new NetworkHelper().httpPostNew(str, map2, map3, networkTimeOut));
        if (o.a("004d5dhdc(i").equals(String.valueOf(mapFromJson.get(o.a("004'dhFi dc=e"))))) {
            this.a = true;
        }
        if (!"200".equals(String.valueOf(mapFromJson.get(o.a("0069fgIdZdf=dWdcfg"))))) {
            return false;
        }
        HashMap map4 = (HashMap) map.get(o.a("007Udf,eeBegdkfhec"));
        HashMap map5 = (HashMap) map4.get(strValueOf);
        if (map5 == null) {
            map5 = new HashMap();
        }
        map5.put(mobProduct.getProductTag(), MobSDK.getAppkey());
        map4.put(strValueOf, map5);
        map.put(o.a("007LdfMee5egdkfhec"), map4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HashMap<String, Object> map, String str, DH.DHResponse dHResponse) {
        try {
            if (com.mob.commons.b.c()) {
                a(map, dHResponse);
                HashMap map2 = (HashMap) map.get(o.a("010hijBdedg;i'egdkfhec"));
                HashMap map3 = new HashMap();
                map3.put(o.a("005dXecdjEi)dk"), x.a().b());
                for (Map.Entry entry : map2.entrySet()) {
                    map3.put(entry.getKey(), entry.getValue());
                }
                try {
                    map3.put(o.a("0076dgdfdhdhde,iSdh"), Integer.valueOf(Integer.parseInt(String.valueOf(map3.get(o.a("007Cdgdfdhdhde6iFdh"))))));
                } catch (Throwable unused) {
                }
                map3.put(o.a("004hDdcdeFh"), str);
                String[] strArrQueryIMEI = dHResponse.queryIMEI();
                if (strArrQueryIMEI != null && strArrQueryIMEI.length > 0) {
                    map3.put("iemtarr", strArrQueryIMEI);
                }
                HashMap<String, Long> memoryInfo = dHResponse.getMemoryInfo();
                HashMap<String, HashMap<String, Long>> sizeInfo = dHResponse.getSizeInfo();
                if (memoryInfo != null) {
                    map3.put(o.a("003LdhdfUl"), memoryInfo.get(o.a("005d'ecMd dfed")));
                }
                if (sizeInfo != null) {
                    HashMap<String, Long> map4 = sizeInfo.get(o.a("006+fg,h<dgdfdhIh"));
                    if (map4 != null) {
                        map3.put(o.a("013Lfg1h3dgdfdhThYeh d:ecdhdfffDi"), map4.get(o.a("005d]ecOd_dfed")));
                    }
                    HashMap<String, Long> map5 = sizeInfo.get(o.a("004h(df@dMdf"));
                    if (map5 != null) {
                        map3.put(o.a("011h6dfSd3dfeh%dOecdhdfffIi"), map5.get(o.a("005d0ec d$dfed")));
                    }
                }
                map3.put(o.a("006IdhecXl7eg1l^ff"), dHResponse.getMIUIVersion());
                if (TextUtils.isEmpty((String) map3.get("iemt"))) {
                    map3.put("iemt", com.mob.tools.a.c.a(MobSDK.getContext()).b().a(true));
                }
                if (TextUtils.isEmpty((String) map3.get("ismt"))) {
                    map3.put("ismt", com.mob.tools.a.c.a(MobSDK.getContext()).b().b(true));
                }
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(c(), HashonHelper.fromHashMap(map3)), 2);
                HashMap<String, Object> map6 = new HashMap<>();
                map6.put("m", strEncodeToString);
                NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                networkTimeOut.readTimout = 30000;
                networkTimeOut.connectionTimeout = 30000;
                NetworkHelper networkHelper = new NetworkHelper();
                String str2 = com.mob.commons.c.a(com.mob.commons.c.f17670e) + o.a("006ghMdedkfhec");
                HashMap<String, String> map7 = new HashMap<>();
                map7.put(o.a("0132eefgSiHdhhieg^hi(dk:dKdeUdTdi"), v.c());
                map7.put(o.a("004l,ecdePh"), com.mob.tools.a.c.a(MobSDK.getContext()).b().aY());
                if ("200".equals(String.valueOf(HashonHelper.fromJson(networkHelper.httpPostNew(str2, map6, map7, networkTimeOut)).get(o.a("006NfgWd'dfUd?dcfg"))))) {
                    w.a().a(w.a, System.currentTimeMillis());
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final HashMap<String, Object> map) {
        l.a(l.a(l.c), new k() { // from class: com.mob.commons.a.2
            @Override // com.mob.commons.k
            public boolean a(FileLocker fileLocker) {
                try {
                    a.b(a.this.d(), map);
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().w(th);
                    return false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(HashMap<String, Object> map, boolean z, DH.DHResponse dHResponse) {
        HashMap map2;
        int i;
        boolean z2;
        boolean z3;
        if (map != null && !map.isEmpty() && (map2 = (HashMap) map.get(o.a("010hij,dedg,i5egdkfhec"))) != null && !map2.isEmpty()) {
            Object obj = map2.get("admt");
            String advertisingID = null;
            try {
                advertisingID = dHResponse.getAdvertisingID();
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
            boolean z4 = (advertisingID == null || advertisingID.equals(obj)) ? false : true;
            Object obj2 = map2.get("ssnmt");
            String simSerialNumber = dHResponse.getSimSerialNumber();
            boolean z5 = z4;
            if (simSerialNumber != null) {
                z5 = z4;
                if (!simSerialNumber.equals(obj2)) {
                    z5 = true;
                }
            }
            Object obj3 = map2.get("iemt");
            String imei = dHResponse.getIMEI();
            if (imei == null || imei.equals(obj3)) {
                i = 0;
                z2 = z5;
            } else {
                z2 = true;
                i = 1;
            }
            Object obj4 = map2.get("ismt");
            String imsi = dHResponse.getIMSI();
            boolean z6 = z2;
            if (imsi != null) {
                z6 = z2;
                if (!imsi.equals(obj4)) {
                    i |= 2;
                    z6 = true;
                }
            }
            if (z) {
                i |= 4;
            }
            Object obj5 = map2.get(o.a("004^ecdfde;h"));
            String strAX = com.mob.tools.a.c.a(MobSDK.getContext()).b().aX();
            if ((obj5 == null && !TextUtils.isEmpty(strAX)) || (obj5 != null && !String.valueOf(obj5).equals(strAX))) {
                i |= 8;
                z6 = true;
            }
            Object obj6 = map2.get(o.a("004+dhVh:de-h"));
            String strC = t.a().c();
            if ((obj6 == null && !TextUtils.isEmpty(strC)) || (obj6 != null && !String.valueOf(obj6).equals(strC))) {
                i |= 16;
                z6 = true;
            }
            Object obj7 = map2.get(o.a("005hPdh9lBde<h"));
            String strH = t.a().h();
            if ((obj7 == null && !TextUtils.isEmpty(strH)) || (obj7 != null && !String.valueOf(obj7).equals(strH))) {
                i |= 32;
                z6 = true;
            }
            Object obj8 = map2.get(o.a("004e=dcde@h"));
            String strG = t.a().g();
            if ((obj8 == null && !TextUtils.isEmpty(strG)) || (obj8 != null && !String.valueOf(obj8).equals(strG))) {
                i |= 64;
                z6 = true;
            }
            Object obj9 = map2.get(o.a("004;dcUh=deCh"));
            String ud = dHResponse.getUD();
            if ((obj9 == null && !TextUtils.isEmpty(ud)) || (obj9 != null && !String.valueOf(obj9).equals(ud))) {
                i |= 128;
            }
            Object obj10 = map2.get(am.aE);
            String strB = t.a().b();
            if ((obj10 == null && !TextUtils.isEmpty(strB)) || (obj10 != null && !String.valueOf(obj10).equals(strB))) {
                z6 = true;
            }
            map2.put("cid_modify", Integer.valueOf(i));
            if (z6) {
                return true;
            }
            Object obj11 = map2.get("snmt");
            String serialno = dHResponse.getSerialno();
            if (serialno != null && !serialno.equals(obj11)) {
                return true;
            }
            Object obj12 = map2.get(o.a("005l=ec5hi*ed"));
            String model = DH.SyncMtd.getModel();
            if (model != null && !model.equals(obj12)) {
                return true;
            }
            Object obj13 = map2.get(o.a("007:fhdfdg>d=ecdhdi"));
            String manufacturer = DH.SyncMtd.getManufacturer();
            if (manufacturer != null && !manufacturer.equals(obj13)) {
                return true;
            }
            Object obj14 = map2.get(o.a("007.dgdfdhdhde@iIdh"));
            String carrier = dHResponse.getCarrier();
            if (carrier != null && !carrier.equals(obj14)) {
                return true;
            }
            Object obj15 = map2.get("ismtarr");
            String[] strArrQueryIMSI = dHResponse.queryIMSI();
            if (strArrQueryIMSI != null && strArrQueryIMSI.length > 0) {
                if (obj15 == null) {
                    return true;
                }
                try {
                    ArrayList arrayList = (ArrayList) obj15;
                    if (arrayList.size() != strArrQueryIMSI.length) {
                        return true;
                    }
                    int length = strArrQueryIMSI.length;
                    int i2 = 0;
                    boolean z7 = false;
                    while (i2 < length) {
                        String str = strArrQueryIMSI[i2];
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z3 = true;
                                break;
                            }
                            if (str.equals((String) it.next())) {
                                z3 = false;
                                break;
                            }
                        }
                        i2++;
                        z7 = z3;
                    }
                    if (z7) {
                        return true;
                    }
                } catch (Throwable unused) {
                }
            }
            Object obj16 = map2.get(o.a("006[fgdifg_jiKdh"));
            String oSVersionName = DH.SyncMtd.getOSVersionName();
            if (oSVersionName != null && !oSVersionName.equals(obj16)) {
                return true;
            }
            Object obj17 = map2.get(o.a("0022dl@e"));
            boolean zCx = dHResponse.cx();
            if (obj17 != null && String.valueOf(zCx ? 1 : 0).equals(String.valueOf(obj17))) {
                Object obj18 = map2.get(o.a("007YfcdhCi_dfdjOih"));
                boolean zIsRooted = dHResponse.isRooted();
                return (obj18 == null && zIsRooted) || !(obj18 == null || String.valueOf(obj18).equals(String.valueOf(zIsRooted)));
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01f2 A[Catch: all -> 0x0229, TryCatch #6 {all -> 0x0229, blocks: (B:3:0x0002, B:5:0x0010, B:6:0x001e, B:8:0x0043, B:21:0x0084, B:23:0x008e, B:29:0x00a1, B:31:0x00a7, B:50:0x00f4, B:85:0x0152, B:87:0x015c, B:88:0x0165, B:92:0x017f, B:105:0x01c0, B:107:0x01ca, B:109:0x01d0, B:110:0x01d3, B:112:0x01f2, B:113:0x01fb, B:115:0x0209, B:116:0x0212, B:104:0x01b9, B:100:0x01a3, B:84:0x014b, B:49:0x00ed, B:43:0x00d5, B:37:0x00bd, B:28:0x009a, B:20:0x007d, B:14:0x0061, B:9:0x004c, B:11:0x0056, B:93:0x018c, B:97:0x0194, B:38:0x00c4, B:40:0x00ce, B:101:0x01aa, B:25:0x0094, B:52:0x00f9, B:54:0x00ff, B:79:0x013d, B:81:0x0146, B:44:0x00dc, B:46:0x00e6, B:32:0x00ac, B:34:0x00b6, B:15:0x0068, B:17:0x0072), top: B:133:0x0002, inners: #0, #1, #2, #3, #5, #7, #9, #10, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0209 A[Catch: all -> 0x0229, TryCatch #6 {all -> 0x0229, blocks: (B:3:0x0002, B:5:0x0010, B:6:0x001e, B:8:0x0043, B:21:0x0084, B:23:0x008e, B:29:0x00a1, B:31:0x00a7, B:50:0x00f4, B:85:0x0152, B:87:0x015c, B:88:0x0165, B:92:0x017f, B:105:0x01c0, B:107:0x01ca, B:109:0x01d0, B:110:0x01d3, B:112:0x01f2, B:113:0x01fb, B:115:0x0209, B:116:0x0212, B:104:0x01b9, B:100:0x01a3, B:84:0x014b, B:49:0x00ed, B:43:0x00d5, B:37:0x00bd, B:28:0x009a, B:20:0x007d, B:14:0x0061, B:9:0x004c, B:11:0x0056, B:93:0x018c, B:97:0x0194, B:38:0x00c4, B:40:0x00ce, B:101:0x01aa, B:25:0x0094, B:52:0x00f9, B:54:0x00ff, B:79:0x013d, B:81:0x0146, B:44:0x00dc, B:46:0x00e6, B:32:0x00ac, B:34:0x00b6, B:15:0x0068, B:17:0x0072), top: B:133:0x0002, inners: #0, #1, #2, #3, #5, #7, #9, #10, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0146 A[Catch: all -> 0x014a, TRY_LEAVE, TryCatch #7 {all -> 0x014a, blocks: (B:52:0x00f9, B:54:0x00ff, B:79:0x013d, B:81:0x0146), top: B:135:0x00f9, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x015c A[Catch: all -> 0x0229, TryCatch #6 {all -> 0x0229, blocks: (B:3:0x0002, B:5:0x0010, B:6:0x001e, B:8:0x0043, B:21:0x0084, B:23:0x008e, B:29:0x00a1, B:31:0x00a7, B:50:0x00f4, B:85:0x0152, B:87:0x015c, B:88:0x0165, B:92:0x017f, B:105:0x01c0, B:107:0x01ca, B:109:0x01d0, B:110:0x01d3, B:112:0x01f2, B:113:0x01fb, B:115:0x0209, B:116:0x0212, B:104:0x01b9, B:100:0x01a3, B:84:0x014b, B:49:0x00ed, B:43:0x00d5, B:37:0x00bd, B:28:0x009a, B:20:0x007d, B:14:0x0061, B:9:0x004c, B:11:0x0056, B:93:0x018c, B:97:0x0194, B:38:0x00c4, B:40:0x00ce, B:101:0x01aa, B:25:0x0094, B:52:0x00f9, B:54:0x00ff, B:79:0x013d, B:81:0x0146, B:44:0x00dc, B:46:0x00e6, B:32:0x00ac, B:34:0x00b6, B:15:0x0068, B:17:0x0072), top: B:133:0x0002, inners: #0, #1, #2, #3, #5, #7, #9, #10, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0193  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.HashMap<java.lang.String, java.lang.Object> r12, com.mob.tools.utils.DH.DHResponse r13) {
        /*
            Method dump skipped, instructions count: 562
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.a(java.util.HashMap, com.mob.tools.utils.DH$DHResponse):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0049 A[Catch: all -> 0x0058, TRY_LEAVE, TryCatch #2 {all -> 0x0058, blocks: (B:14:0x0028, B:16:0x002e, B:18:0x003e, B:19:0x0049), top: B:34:0x0028 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.HashMap<java.lang.String, java.lang.Object> a(java.io.File r9) {
        /*
            r8 = this;
            boolean r0 = r9.exists()
            r1 = 0
            if (r0 == 0) goto L75
            boolean r0 = r9.isFile()
            if (r0 == 0) goto L75
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L21
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L21
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L1f
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r3 = r2.readObject()     // Catch: java.lang.Throwable -> L23
            java.util.HashMap r3 = (java.util.HashMap) r3     // Catch: java.lang.Throwable -> L23
            r1 = r3
            goto L23
        L1f:
            r2 = r1
            goto L23
        L21:
            r0 = r1
            r2 = r0
        L23:
            r3 = 1
            r4 = 0
            r5 = 2
            if (r1 == 0) goto L49
            boolean r6 = r1.isEmpty()     // Catch: java.lang.Throwable -> L58
            if (r6 != 0) goto L49
            java.util.Set r6 = r1.keySet()     // Catch: java.lang.Throwable -> L58
            java.lang.String r7 = "004hEdcdeZh"
            java.lang.String r7 = com.mob.commons.o.a(r7)     // Catch: java.lang.Throwable -> L58
            boolean r6 = r6.contains(r7)     // Catch: java.lang.Throwable -> L58
            if (r6 == 0) goto L49
            r9.delete()     // Catch: java.lang.Throwable -> L58
            java.io.File r9 = r8.d()     // Catch: java.lang.Throwable -> L58
            b(r9, r1)     // Catch: java.lang.Throwable -> L58
            goto L4e
        L49:
            java.util.HashMap r9 = b(r9)     // Catch: java.lang.Throwable -> L58
            r1 = r9
        L4e:
            java.io.Closeable[] r9 = new java.io.Closeable[r5]
            r9[r4] = r0
            r9[r3] = r2
            com.mob.commons.C5340r.a(r9)
            goto L75
        L58:
            r9 = move-exception
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L6a
            r6.w(r9)     // Catch: java.lang.Throwable -> L6a
            java.io.Closeable[] r9 = new java.io.Closeable[r5]
            r9[r4] = r0
            r9[r3] = r2
            com.mob.commons.C5340r.a(r9)
            goto L75
        L6a:
            r9 = move-exception
            java.io.Closeable[] r1 = new java.io.Closeable[r5]
            r1[r4] = r0
            r1[r3] = r2
            com.mob.commons.C5340r.a(r1)
            throw r9
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.a.a(java.io.File):java.util.HashMap");
    }

    private static byte[] a(String str, HashMap<String, Object> map) {
        String strFromHashMap = HashonHelper.fromHashMap(map);
        try {
            return Data.AES128Encode(str, strFromHashMap);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return strFromHashMap.getBytes();
        }
    }

    private static HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return HashonHelper.fromJson(Data.AES128Decode(str, bArr));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return new HashMap<>();
        }
    }
}
