package com.mob.commons;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.MobSDK;
import com.mob.commons.a;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.HashonHelper;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class w {
    private static w A;
    private SharePrefrenceHelper B;
    private static final String v = o.a("011lVecfcdddgecXllFecdkfg");
    public static final String a = o.a("009 dj^i@diddJh]deffdf%e");
    public static final String b = o.a("010[dj?i9didd<hWdcMeh0dg)h");
    public static final String c = o.a("010_dj7i<didddkdcJeBdhdg+h");
    public static final String d = o.a("0091djNi6didddkdceddfed");

    /* renamed from: e, reason: collision with root package name */
    public static final String f17688e = o.a("010'dj6i0diddfgdkdceddfed");
    public static final String f = o.a("0100dj7i'didddkdced(eQedFd");
    public static final String g = o.a("018Jdj>i@didddfdh4d)dddk!iNdlOd@dd1d0ec_d9dfed");
    public static final String h = o.a("011_dj?iEdidd=ee>dddkdgfgdi");
    public static final String i = o.a("0110dj,i[didd*eeWddffdh=dh");
    public static final String j = o.a("0312djGiRdidddk'iDdlEd4dddcTeNedecdf1hDdddf9ee)dddfdgTdAdeLji'ddKdYde2li");
    public static final String k = o.a("012Mdj@i6didd^iCdl'dOdddedkfhec");
    public static final String l = o.a("033?djEiUdidddkUi0dlAdHddHhijAddZi1dlXd9dddedkfhecdddc@e%edecdf$hJdd=d!deDli");
    public static final String m = o.a("032(djNi1didddkViHdlGdQdd9hij,dd:iZdl:dRdd4jAdfdhdddc4e!edecdfPhKdd<dUde@li");
    public static final String n = o.a("025=dj-iDdiddfcdcfhfhJiWdhIihSddedecdgdf%d deecdkdd.lhPhe");
    public static final String o = o.a("038,dj)i)didddk)iBdl$dDdddcJeFedecdfIh]ddfcdcfhfh1iVdhWihCddedecdgdfSdUdeecdkdd'd$deWli");
    public static final String p = o.a("0228dj$iCdiddfgdeXlXdceddfQdXecdhdddedkfhecdd]lh2he");
    public static final String q = o.a("014$fddefhdeddeddffg(dAdddedkfhec");
    public static final String r = o.a("0180dj4i-diddfddefhdeddeddefgUd4dd$c0dffg8c");
    public static final String s = o.a("030Adj$iSdidddk,i,dl'd3dddc)e2edecdfRh ddfddefhdeddeddefgTdTddNd'deUli");
    public static final String t = o.a("012Idj3iAdiddfgfdde1d^dg2ciNfg");
    public static final String u = o.a("022Bdj.iAdiddfgfddeLd,dg%ciPfgdd7d3deUliTfgTdEdf)le");
    private static final String w = o.a("019Bdj9i?didddf>ee)dddfdgDdPde_ji%dd'dNde5li");
    private static final String x = o.a("012Kdj8i)didddg_cPdfdkdkQi2edfg");
    private static AtomicBoolean y = new AtomicBoolean(false);
    private static AtomicBoolean z = new AtomicBoolean(false);

    private w() {
        if (this.B == null) {
            SharePrefrenceHelper sharePrefrenceHelper = new SharePrefrenceHelper(MobSDK.getContext());
            this.B = sharePrefrenceHelper;
            sharePrefrenceHelper.open(v, 1);
        }
    }

    public static synchronized w a() {
        if (A == null) {
            A = new w();
        }
        return A;
    }

    public static void f() {
        h();
    }

    private static String g() {
        return Data.MD5(DeviceHelper.getInstance(MobSDK.getContext()).getModel());
    }

    private static void h() {
        if (z.compareAndSet(false, true)) {
            new com.mob.tools.utils.f("DS-W") { // from class: com.mob.commons.w.1
                @Override // com.mob.tools.utils.f
                public void a() {
                    Object obj = l.i;
                    synchronized (obj) {
                        try {
                            obj.wait();
                            ConcurrentHashMap<String, Object> concurrentHashMapE = b.e();
                            ArrayList arrayList = (ArrayList) concurrentHashMapE.get(o.a("0027ed>d"));
                            concurrentHashMapE.clear();
                            d.a((ArrayList<HashMap<String, Object>>) arrayList, new com.mob.tools.utils.b<Void>() { // from class: com.mob.commons.w.1.1
                                @Override // com.mob.tools.utils.b
                                public void a(Void r1) {
                                }
                            });
                        } finally {
                        }
                    }
                }
            }.start();
        }
    }

    public long b(String str, long j2) {
        return this.B.getLong(str, j2);
    }

    public HashMap<String, Object> c() {
        String strB = b(x, (String) null);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return HashonHelper.fromJson(strB);
    }

    public void d(String str, String str2) {
        a(o.a("011Qdj>i2didd6hYecIl4dfdedkdd") + str, str2);
    }

    public a.C1885a e() {
        try {
            String strB = b("key_duid_entity", (String) null);
            if (!TextUtils.isEmpty(strB)) {
                return a.C1885a.a(Data.AES128Decode(DeviceHelper.getInstance(MobSDK.getContext()).getModel(), Base64.decode(strB, 0)));
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return null;
    }

    public int b(String str, int i2) {
        return this.B.getInt(str, i2);
    }

    public a.c d() {
        return a.c.a(b("key_duid_param_blacklist", (String) null));
    }

    public String b(String str, String str2) {
        return this.B.getString(str, str2);
    }

    public void a(String str, long j2) {
        this.B.putLong(str, Long.valueOf(j2));
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                str = Base64.encodeToString(Data.AES128Encode(g(), str), 0);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
        }
        a(t, str);
    }

    public String c(String str, String str2) {
        return b(o.a("011DdjGi6didd.hAec<l_dfdedkdd") + str, str2);
    }

    public void a(String str, int i2) {
        this.B.putInt(str, Integer.valueOf(i2));
    }

    public boolean a(String str, boolean z2) {
        return this.B.getBoolean(str, z2);
    }

    public void a(String str, String str2) {
        if (str2 == null) {
            this.B.remove(str);
        } else {
            this.B.putString(str, str2);
        }
    }

    public void a(String str, Object obj) {
        this.B.put(str, obj);
    }

    public Object a(String str) {
        return this.B.get(str);
    }

    public String b() {
        String strB = b(t, (String) null);
        if (TextUtils.isEmpty(strB)) {
            return strB;
        }
        try {
            return Data.AES128Decode(g(), Base64.decode(strB, 0));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return strB;
        }
    }

    public void a(HashMap<String, Object> map) {
        a(x, HashonHelper.fromHashMap(map));
    }

    public void a(a.c cVar) {
        a("key_duid_param_blacklist", cVar != null ? cVar.a() : null);
    }

    public void a(a.C1885a c1885a) {
        String strA = null;
        if (c1885a != null) {
            try {
                strA = c1885a.a();
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return;
            }
        }
        a("key_duid_entity", Base64.encodeToString(Data.AES128Encode(DeviceHelper.getInstance(MobSDK.getContext()).getModel(), strA), 0));
    }
}
