package com.mob.commons;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.face.ModuleDescriptor;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.a;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.MobRSA;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes2.dex */
public class m {
    public static volatile boolean a = false;
    private static m b;
    private File c;
    private BigInteger d;

    /* renamed from: e, reason: collision with root package name */
    private BigInteger f17682e;

    public static class a implements Runnable {
        private static final a[] a = new a[2];
        private int b;
        private int c;
        private String d;

        /* renamed from: e, reason: collision with root package name */
        private String f17683e;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a b() {
            a[] aVarArr = a;
            synchronized (aVarArr) {
                for (int i = 0; i < 2; i++) {
                    a aVar = aVarArr[i];
                    if (aVar != null) {
                        aVarArr[i] = null;
                        return aVar;
                    }
                }
                return new a();
            }
        }

        private void c() {
            try {
                a[] aVarArr = a;
                synchronized (aVarArr) {
                    for (int i = 0; i < 2; i++) {
                        if (aVarArr[i] == null) {
                            aVarArr[i] = this;
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b(this.b, this.c, this.d, this.f17683e);
            } finally {
                try {
                } finally {
                }
            }
        }

        public a a(int i, int i2, String str, String str2) {
            this.b = i;
            this.c = i2;
            this.d = str;
            this.f17683e = str2;
            return this;
        }

        private void b(final int i, final int i2, final String str, final String str2) {
            if (m.a().a(new com.mob.tools.utils.e() { // from class: com.mob.commons.m.a.1
                @Override // com.mob.tools.utils.e
                public void a() {
                    try {
                        HashMap map = new HashMap();
                        map.put(n.b("010>efZg]cifeQhKcgefcddbcj"), Integer.valueOf(i));
                        map.put(n.b("006_ef0gFcidhceee"), str);
                        map.put(n.b("004cJch7dh"), Integer.valueOf(i2));
                        map.put(n.b("005hHcgcgceXc"), Long.valueOf(System.currentTimeMillis()));
                        map.put(n.b("003k;efee"), Base64.encodeToString(str2.getBytes("utf-8"), 2));
                        map.put(n.b("005cFcd'khJef"), 1);
                        m.b(i2).a(HashonHelper.fromHashMap(map));
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                }
            })) {
                u.c.execute(c.b());
            }
        }
    }

    public static class c implements Runnable {
        private static final c[] a = new c[2];
        private Runnable b = new com.mob.tools.utils.e() { // from class: com.mob.commons.m.c.1
            @Override // com.mob.tools.utils.e
            public void a() {
                m.b(1).a(new b());
            }
        };
        private Runnable c = new com.mob.tools.utils.e() { // from class: com.mob.commons.m.c.2
            @Override // com.mob.tools.utils.e
            public void a() {
                m.b(2).a(new b());
            }
        };

        private c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.mob.commons.b.c()) {
                DH.requester(MobSDK.getContext()).getDetailNetworkTypeForStatic().request(new DH.DHResponder() { // from class: com.mob.commons.m.c.3
                    @Override // com.mob.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        try {
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        if (n.b("004<cjdbcjIh").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                            return;
                        }
                        if (((Integer) com.mob.commons.b.a(n.b("004*cfJh=cgcg"), 1)).intValue() == 1) {
                            m.a().a(c.this.b);
                        } else {
                            m.b(1).a(((Long) com.mob.commons.b.a("cerr_max", 104857600L)).longValue());
                        }
                        if (((Integer) com.mob.commons.b.a(n.b("004ZefGhCcgcg"), 0)).intValue() == 1) {
                            m.a().a(c.this.c);
                        } else {
                            m.b(2).a(((Long) com.mob.commons.b.a("serr_max", 20971520L)).longValue());
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c b() {
            c[] cVarArr = a;
            synchronized (cVarArr) {
                for (int i = 0; i < 2; i++) {
                    c cVar = cVarArr[i];
                    if (cVar != null) {
                        cVarArr[i] = null;
                        return cVar;
                    }
                }
                return new c();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            try {
                c[] cVarArr = a;
                synchronized (cVarArr) {
                    for (int i = 0; i < 2; i++) {
                        if (cVarArr[i] == null) {
                            cVarArr[i] = this;
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private m() {
    }

    private byte[] c() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                SecureRandom secureRandom = new SecureRandom();
                dataOutputStream2.writeLong(secureRandom.nextLong());
                dataOutputStream2.writeLong(secureRandom.nextLong());
                dataOutputStream2.flush();
                C5340r.a(dataOutputStream2);
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
                C5340r.a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void b() {
        u.c.execute(c.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.mob.tools.a b(int i) {
        return new com.mob.tools.a(n.b("005<dk0k$cfdcee"), n.b("005<dk0k$cfdcee") + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i, 50);
    }

    public static synchronized m a() {
        if (b == null) {
            b = new m();
        }
        return b;
    }

    public static class b implements a.InterfaceC1902a {
        public ArrayList<HashMap<String, Object>> a;
        public int b;
        public String c;

        private b() {
            this.a = new ArrayList<>();
            this.b = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private String b(String str) throws Throwable {
            ByteArrayInputStream byteArrayInputStream;
            Throwable th;
            byte[] bytes;
            GZIPOutputStream gZIPOutputStream;
            Throwable th2;
            try {
                bytes = str.getBytes();
                byteArrayInputStream = new ByteArrayInputStream(bytes);
            } catch (Throwable th3) {
                byteArrayInputStream = null;
                th = th3;
                bytes = null;
            }
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    } catch (Throwable th4) {
                        gZIPOutputStream = null;
                        th2 = th4;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = byteArrayInputStream.read(bArr, 0, 1024);
                            if (i != -1) {
                                gZIPOutputStream.write(bArr, 0, i);
                            } else {
                                try {
                                    break;
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        gZIPOutputStream.flush();
                        C5340r.a(gZIPOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.flush();
                        String strEncodeToString = Base64.encodeToString(byteArray, 2);
                        C5340r.a(byteArrayOutputStream, byteArrayInputStream);
                        return strEncodeToString;
                    } catch (Throwable th5) {
                        th2 = th5;
                        C5340r.a(gZIPOutputStream);
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    bytes = null;
                    C5340r.a(bytes, byteArrayInputStream);
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                C5340r.a(bytes, byteArrayInputStream);
                throw th;
            }
        }

        @Override // com.mob.tools.a.InterfaceC1902a
        public void a(String str) {
            HashMap<String, Object> mapFromJson = HashonHelper.fromJson(str);
            try {
                this.b = Integer.parseInt(String.valueOf(mapFromJson.get(n.b("010BefAg'cifeShWcgefcddbcj"))));
            } catch (Throwable unused) {
            }
            this.c = (String) mapFromJson.get(n.b("006FefOgCcidhceee"));
            this.a.add(mapFromJson);
        }

        @Override // com.mob.tools.a.InterfaceC1902a
        public boolean a(DH.DHResponse dHResponse) {
            HashMap<String, Object> mapA = a(dHResponse, this.b, this.c);
            mapA.put(n.b("006hCcgcgDk^efee"), this.a);
            try {
                String strFromHashMap = HashonHelper.fromHashMap(mapA);
                this.a.clear();
                String strB = b(strFromHashMap);
                if (!n.b("004AcjdbcjLh").equals(dHResponse.getDetailNetworkTypeForStatic())) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put("m", strB);
                    NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
                    networkTimeOut.readTimout = ModuleDescriptor.MODULE_VERSION;
                    networkTimeOut.connectionTimeout = ModuleDescriptor.MODULE_VERSION;
                    String str = com.mob.commons.c.a(com.mob.commons.c.d) + "/errlog";
                    MobLog.getInstance().d(String.format("Response(%s): %s", str, new NetworkHelper().httpPostNew(str, map, null, networkTimeOut)), new Object[0]);
                    return true;
                }
                throw new IllegalStateException("network is disconnected!");
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return false;
            }
        }

        private HashMap<String, Object> a(DH.DHResponse dHResponse, int i, String str) {
            HashMap<String, Object> map = new HashMap<>();
            map.put(n.b("003Nci^h'ch"), MobSDK.getAppkey());
            map.put(n.b("004d<dcce(c"), Integer.valueOf(DH.SyncMtd.getPlatformCode()));
            map.put(n.b("003BefJg_ci"), str);
            map.put(n.b("0068ef!gFciTih1cg"), Integer.valueOf(i));
            map.put(n.b("007HceKddMcjce<kh"), dHResponse.getAppName());
            map.put(n.b("006'ce1ddd7ciee"), DH.SyncMtd.getPackageName());
            map.put(n.b("006[ceWddih-cg"), String.valueOf(DH.SyncMtd.getAppVersion()));
            map.put(n.b("005kHdb!ghBdc"), DH.SyncMtd.getModel());
            if (com.mob.commons.b.b()) {
                map.put(n.b("008ghi4cdcfNhMcd.g"), dHResponse.getDeviceKey());
                map.put(n.b("0048cbSgJcdIg"), dHResponse.getDeviceId());
            }
            map.put(n.b("006+efchefNih*cg"), String.valueOf(DH.SyncMtd.getOSVersionInt()));
            map.put(n.b("0113cj>hcOecdbcgci4c2ch4dh"), dHResponse.getDetailNetworkTypeForStatic());
            return map;
        }
    }

    public void a(int i, String str, int i2, String str2) {
        if (i == 1) {
            a.b().a(i2, i, str, str2).run();
        } else {
            u.c.execute(a.b().a(i2, i, str, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(final Runnable runnable) {
        if (this.c == null) {
            File file = new File(MobSDK.getContext().getFilesDir(), n.b("005:dkdcdbcfci"));
            this.c = file;
            if (!file.exists()) {
                try {
                    this.c.createNewFile();
                } catch (Throwable unused) {
                }
            }
        }
        return l.a(this.c, new k() { // from class: com.mob.commons.m.1
            @Override // com.mob.commons.k
            public boolean a(FileLocker fileLocker) {
                try {
                    runnable.run();
                    return false;
                } catch (Throwable th) {
                    MobLog.getInstance().i(th);
                    return false;
                }
            }
        });
    }

    public int a(int i, String str) {
        if (MobSDK.getContextSafely() == null || !a) {
            return 0;
        }
        try {
            Intent intent = new Intent();
            intent.setPackage(n.b("015Pcfcjdkef>b8cecgTh(efSgVcidkdcdbee"));
            intent.putExtra(n.b("007d6cecfciceeeIh"), MobSDK.getContext().getPackageName());
            intent.putExtra(n.b("008dGcgcddbcgcd>c!ch"), i);
            intent.putExtra("ver", MobSDK.SDK_VERSION_CODE);
            intent.putExtra(n.b("003k]efee"), a(str));
            MobSDK.getContextSafely().sendBroadcast(intent);
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    private String a(String str) {
        DataOutputStream dataOutputStream;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (this.d == null) {
                this.d = new BigInteger("f53c224aefb38daa0825c1b8ea691b16d2e16db10880548afddd780c6670a091a11dafa954ea4a9483797fda1045d2693a08daa48cf9cedce1e8733b857304cb", 16);
                this.f17682e = new BigInteger("27749621e6ca022469645faed16e8261acf6af822467382d55c24bb9bc02356ab16e76ddc799dc8ba6b4f110411996eeb63505c9dcf969d3fc085d712f0f1a9713b67aa1128d7cc41bda363afb0ec7ade60e542a4e22869395331cc0096de412034551e98bb2629ae1b7168b8bc82006d064ab335d8567283e70beb6a49e9423", 16);
            }
            byte[] bArrC = c();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            } catch (Throwable th) {
                th = th;
                dataOutputStream = null;
            }
            try {
                byte[] bArrEncode = new MobRSA(1024).encode(bArrC, this.d, this.f17682e);
                dataOutputStream.writeInt(bArrEncode.length);
                dataOutputStream.write(bArrEncode);
                byte[] bArrAES128Encode = Data.AES128Encode(bArrC, str.getBytes("utf-8"));
                dataOutputStream.writeInt(bArrAES128Encode.length);
                dataOutputStream.write(bArrAES128Encode);
                dataOutputStream.flush();
                C5340r.a(dataOutputStream);
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            } catch (Throwable th2) {
                th = th2;
                C5340r.a(dataOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            MobLog.getInstance().d(th3);
            return null;
        }
    }
}
