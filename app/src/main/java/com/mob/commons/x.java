package com.mob.commons;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class x {
    private static final String a = o.a("002%eifk");
    private static final String b = o.a("0058elec8edTdk");
    private static final String c = o.a("005.elec^eh7dk");
    private static final String d = o.a("016Tglgkjcjiheieihgjhhfedffcdg=hHfhde");

    /* renamed from: e, reason: collision with root package name */
    private static x f17689e;
    private String f;
    private Context g = MobSDK.getContext();
    private TreeMap<String, Object> h;

    private x() {
    }

    public static x a() {
        if (f17689e == null) {
            synchronized (x.class) {
                if (f17689e == null) {
                    f17689e = new x();
                }
            }
        }
        return f17689e;
    }

    private String d() {
        this.h = new TreeMap<>();
        String strA = null;
        try {
            String strE = e();
            boolean zA = a(f());
            if (TextUtils.isEmpty(strE)) {
                strA = a(this.h);
            } else {
                MobLog.getInstance().d("[%s] %s", a, "tk status: " + zA);
                strA = !zA ? strE : a(this.h);
            }
            f17689e.f = strA;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return strA;
    }

    private String e() throws IOException {
        DataInputStream dataInputStream;
        String utf;
        DataInputStream dataInputStream2 = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.g, b);
            if (dataCacheFile == null || !dataCacheFile.exists()) {
                utf = null;
            } else {
                dataInputStream = new DataInputStream(new FileInputStream(dataCacheFile));
                try {
                    utf = dataInputStream.readUTF();
                    dataInputStream2 = dataInputStream;
                } catch (Throwable th) {
                    th = th;
                    try {
                        MobLog.getInstance().d(th);
                        C5340r.a(dataInputStream);
                        return null;
                    } catch (Throwable th2) {
                        C5340r.a(dataInputStream);
                        throw th2;
                    }
                }
            }
            C5340r.a(dataInputStream2);
            return utf;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
        }
    }

    private HashMap<String, Object> f() {
        FileChannel channel;
        HashMap<String, Object> mapA;
        FileChannel fileChannel = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.g, c);
            if (dataCacheFile == null || !dataCacheFile.exists()) {
                mapA = null;
            } else {
                channel = new FileInputStream(dataCacheFile).getChannel();
                try {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                    while (channel.read(byteBufferAllocate) > 0) {
                    }
                    mapA = a(d, byteBufferAllocate.array());
                    fileChannel = channel;
                } catch (Throwable th) {
                    th = th;
                    try {
                        MobLog.getInstance().d(th);
                        C5340r.a(channel);
                        return null;
                    } catch (Throwable th2) {
                        C5340r.a(channel);
                        throw th2;
                    }
                }
            }
            C5340r.a(fileChannel);
            return mapA;
        } catch (Throwable th3) {
            th = th3;
            channel = null;
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f)) {
            synchronized (x.class) {
                if (TextUtils.isEmpty(this.f)) {
                    return d();
                }
            }
        }
        return this.f;
    }

    public String c() {
        return this.f;
    }

    private boolean a(HashMap<String, Object> map) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final String[] strArr = new String[1];
        DH.requester(MobSDK.getContext()).getDeviceKey().request(new DH.DHResponder() { // from class: com.mob.commons.x.1
            @Override // com.mob.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                strArr[0] = dHResponse.getDeviceKey();
                countDownLatch.countDown();
            }
        });
        try {
            this.h.put(o.a("007*fhdfdgNd3ecdhdi"), DH.SyncMtd.getManufacturer());
            this.h.put(o.a("005l(ec hiZed"), DH.SyncMtd.getModel());
            this.h.put(o.a("006WfgdifgIjiDdh"), Integer.valueOf(DH.SyncMtd.getOSVersionInt()));
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            String str = strArr[0];
            if (!TextUtils.isEmpty(str)) {
                this.h.put(o.a("008hij6dedg!i5eg+h"), str);
            }
            this.h.put(o.a("004hSdcde6h"), e.a((MobProduct) null));
            String strMD5 = Data.MD5(new JSONObject(this.h).toString());
            TreeMap<String, Object> treeMap = new TreeMap<>();
            treeMap.put(o.a("010XffKiPdkWi=dhdfedgiUhPhe"), strMD5);
            b(treeMap);
            if (map == null || map.isEmpty() || !strMD5.equals((String) map.get(o.a("010-ffIiYdkGi%dhdfedgiQh2he")))) {
                return true;
            }
            MobLog.getInstance().d("[%s] %s", a, "No changes");
            return false;
        } catch (Throwable th) {
            MobLog.getInstance().e(th);
            return false;
        }
    }

    private void b(String str) {
        DataOutputStream dataOutputStream = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.g, b);
            if (dataCacheFile != null) {
                DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(dataCacheFile));
                try {
                    dataOutputStream2.writeUTF(str);
                    dataOutputStream2.flush();
                    dataOutputStream = dataOutputStream2;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    try {
                        MobLog.getInstance().d(th);
                        C5340r.a(dataOutputStream);
                        return;
                    } catch (Throwable th2) {
                        C5340r.a(dataOutputStream);
                        throw th2;
                    }
                }
            }
            C5340r.a(dataOutputStream);
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void b(TreeMap<String, Object> treeMap) {
        FileChannel channel = null;
        try {
            File dataCacheFile = ResHelper.getDataCacheFile(this.g, c);
            byte[] bArrA = a(d, treeMap);
            if (bArrA != null && bArrA.length > 0) {
                channel = new FileOutputStream(dataCacheFile).getChannel();
                channel.write(ByteBuffer.wrap(bArrA));
                channel.force(true);
            }
            C5340r.a(channel);
        } catch (Throwable th) {
            try {
                MobLog.getInstance().d(th);
                C5340r.a(channel);
            } catch (Throwable th2) {
                C5340r.a(channel);
                throw th2;
            }
        }
    }

    private String a(TreeMap<String, Object> treeMap) {
        HashMap map;
        String str = null;
        if (!b.c() || treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        try {
            HashMap map2 = new HashMap();
            map2.put(o.a("007TfhdfdgKdEecdhdi"), treeMap.get(o.a("007TfhdfdgKdEecdhdi")));
            map2.put(o.a("005l ec>hi4ed"), treeMap.get(o.a("005l ec>hi4ed")));
            map2.put(o.a("006QfgdifgGji(dh"), treeMap.get(o.a("006QfgdifgGji(dh")));
            map2.put(o.a("008hij0dedgRiEeg^h"), treeMap.get(o.a("008hij0dedgRiEeg^h")));
            map2.put(o.a("004h8dcde!h"), treeMap.get(o.a("004h8dcde!h")));
            HashMap<String, Object> map3 = new HashMap<>();
            map3.put(o.a("0068df]ee;djGi2di"), MobSDK.getAppkey());
            map3.put("m", a(HashonHelper.fromHashMap(map2)));
            HashMap<String, String> map4 = new HashMap<>();
            map4.put(o.a("013DeefgEiZdhhieg7hi'dk^d[de=dUdi"), v.c());
            map4.put(o.a("004lXecde:h"), com.mob.tools.a.c.a(MobSDK.getContext()).b().aY());
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            HashMap mapFromJson = HashonHelper.fromJson(new NetworkHelper().httpPostNew(c.a(c.c) + o.a("007g@ecTei9dkdeIh"), map3, map4, networkTimeOut));
            if (!"200".equals(String.valueOf(mapFromJson.get(o.a("0042dgecKhi")))) || (map = (HashMap) mapFromJson.get(o.a("004hBdf_d:df"))) == null) {
                return null;
            }
            String str2 = (String) map.get(o.a("005d4ecdj i'dk"));
            try {
                f17689e.f = str2;
                b(str2);
                return str2;
            } catch (Throwable th) {
                th = th;
                str = str2;
                MobLog.getInstance().e(th);
                return str;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(String str) throws Throwable {
        DataOutputStream dataOutputStream;
        BufferedOutputStream bufferedOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = null;
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
                DataOutputStream dataOutputStream3 = new DataOutputStream(byteArrayOutputStream3);
                try {
                    dataOutputStream3.writeInt(bArrEncode.length);
                    dataOutputStream3.write(bArrEncode);
                    dataOutputStream3.writeInt(bArrAES128Encode.length);
                    dataOutputStream3.write(bArrAES128Encode);
                    dataOutputStream3.flush();
                    C5340r.a(dataOutputStream3);
                    return Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
                } catch (Throwable th3) {
                    C5340r.a(dataOutputStream3);
                    throw th3;
                }
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream2 = bufferedOutputStream;
                C5340r.a(dataOutputStream2);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            dataOutputStream2 = dataOutputStream;
            C5340r.a(dataOutputStream2);
            throw th;
        }
    }

    private byte[] a(String str, TreeMap<String, Object> treeMap) {
        try {
            return Data.AES128Encode(str, new JSONObject(treeMap).toString());
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    private HashMap<String, Object> a(String str, byte[] bArr) {
        try {
            return HashonHelper.fromJson(Data.AES128Decode(str, bArr));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return new HashMap<>();
        }
    }
}
