package com.mob.tools.b;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.mob.MobSDK;
import com.mob.tools.MobLog;
import com.mob.tools.a.c;
import com.mob.tools.a.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class a {
    public static ThreadLocal<Boolean> a = new ThreadLocal<>();
    public static ThreadLocal<Boolean> b = new ThreadLocal<>();
    public static ThreadLocal<Boolean> c = new ThreadLocal<>();
    private static final List<String> d = Arrays.asList("bgmdl", "gmnft", "gbrd", "govsit", "govsnm", "golgu", "gocnty", "galgu", "gtmne", "gsnmd", "gpgnm", "gpnmmt", "gpvsnm", "gpvsme", "cinmnps", "ckpmsi", "gaplcn", "gpgif", "gpgiffist", "gbrdm", "unrgrcv", "rgrcv", "gcrtpcnm", "gscpt", "cird", "cknavbl", "ipgist", "ckua", "ubenbl", "dvenbl", "vnmt", "iwpxy", "cx", "degb", "istvdv", "gdtlnktpfs", "gpgiffcin", "gpgifstrg", "gtaif", "gtaifprm", "rsaciy", "gisi", "gsnmdfp", "gcrie", "gcriefce", "gdvk", "gdvkfc", "gssn", "gpsavlb");

    @b
    public static Object a(String str, ArrayList<Object> arrayList) {
        try {
            return b(str, arrayList);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    private static Object b(String str, ArrayList<Object> arrayList) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.mob.tools.a.a aVarA = a(str);
        if ("cird".equals(str)) {
            return Boolean.valueOf(aVarA.a());
        }
        if ("cx".equals(str)) {
            return Boolean.valueOf(aVarA.b());
        }
        if ("ckpd".equals(str)) {
            return Boolean.valueOf(aVarA.c());
        }
        if ("degb".equals(str)) {
            return Boolean.valueOf(aVarA.d());
        }
        if ("vnmt".equals(str)) {
            return Boolean.valueOf(aVarA.e());
        }
        if ("ckua".equals(str)) {
            return Boolean.valueOf(aVarA.f());
        }
        if ("dvenbl".equals(str)) {
            return Boolean.valueOf(aVarA.g());
        }
        if ("ubenbl".equals(str)) {
            return Boolean.valueOf(aVarA.h());
        }
        if ("iwpxy".equals(str)) {
            return Boolean.valueOf(aVarA.i());
        }
        if ("ismlt".equals(str)) {
            return Boolean.valueOf(aVarA.j());
        }
        if ("ifkps".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return Boolean.valueOf(aVarA.a((String) arrayList.get(0)));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("istvdv".equals(str)) {
            return Boolean.valueOf(aVarA.k());
        }
        if ("gsrln".equals(str)) {
            return aVarA.l();
        }
        if ("gavti".equals(str)) {
            return aVarA.m();
        }
        if ("gimi".equals(str)) {
            return aVarA.n();
        }
        if ("gimip".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.a(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gimimem".equals(str)) {
            return aVarA.o();
        }
        if ("gisi".equals(str)) {
            return aVarA.p();
        }
        if ("gisip".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.b(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("qryisi".equals(str)) {
            return aVarA.q();
        }
        if ("gsimt".equals(str)) {
            return aVarA.r();
        }
        if ("gbsi".equals(str)) {
            return aVarA.s();
        }
        if ("gcrie".equals(str)) {
            return aVarA.t();
        }
        if ("gcriefce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.c(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gcrnmfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.d(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gcrnm".equals(str)) {
            return aVarA.u();
        }
        if ("gssn".equals(str)) {
            return aVarA.v();
        }
        if ("gmivsn".equals(str)) {
            return aVarA.w();
        }
        if ("godmt".equals(str)) {
            return aVarA.x();
        }
        if ("bgmdl".equals(str)) {
            return aVarA.y();
        }
        if ("gmnft".equals(str)) {
            return aVarA.z();
        }
        if ("gbrd".equals(str)) {
            return aVarA.A();
        }
        if ("gdvtp".equals(str)) {
            return aVarA.B();
        }
        if ("qriei".equals(str)) {
            return aVarA.C();
        }
        if ("gbhnm".equals(str)) {
            return aVarA.D();
        }
        if ("gcld".equals(str)) {
            return Integer.valueOf(aVarA.E());
        }
        if ("gcllc".equals(str)) {
            return Integer.valueOf(aVarA.F());
        }
        if ("gpcmt".equals(str)) {
            return Integer.valueOf(aVarA.G());
        }
        if ("gcmlt".equals(str)) {
            return Integer.valueOf(aVarA.H());
        }
        if ("gcmln".equals(str)) {
            return Integer.valueOf(aVarA.I());
        }
        if ("gcmbd".equals(str)) {
            return Integer.valueOf(aVarA.J());
        }
        if ("gcmsd".equals(str)) {
            return Integer.valueOf(aVarA.K());
        }
        if ("gcmnd".equals(str)) {
            return Integer.valueOf(aVarA.L());
        }
        if ("gnbclin".equals(str)) {
            return aVarA.M();
        }
        if ("wmcwi".equals(str)) {
            return aVarA.N();
        }
        if ("gavlwls".equals(str)) {
            return aVarA.O();
        }
        if ("scwls".equals(str)) {
            return Boolean.valueOf(aVarA.P());
        }
        if ("govsit".equals(str)) {
            return Integer.valueOf(aVarA.Q());
        }
        if ("govsnm".equals(str)) {
            return aVarA.R();
        }
        if ("golgu".equals(str)) {
            return aVarA.S();
        }
        if ("gocnty".equals(str)) {
            return aVarA.T();
        }
        if ("gcuin".equals(str)) {
            return aVarA.U();
        }
        if ("gtydvin".equals(str)) {
            return aVarA.V();
        }
        if ("gbtrstt".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                aVarA.a((Handler.Callback) arrayList.get(0));
                return null;
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gsnbtns".equals(str)) {
            return Integer.valueOf(aVarA.W());
        }
        if ("gsnbtmd".equals(str)) {
            return Integer.valueOf(aVarA.X());
        }
        if ("gqmkn".equals(str)) {
            return aVarA.Y();
        }
        if ("gszin".equals(str)) {
            return aVarA.Z();
        }
        if ("gmrin".equals(str)) {
            return aVarA.aa();
        }
        if ("gabct".equals(str)) {
            return Integer.valueOf(aVarA.ab());
        }
        if ("galgu".equals(str)) {
            return aVarA.ac();
        }
        if ("gscsz".equals(str)) {
            return aVarA.ad();
        }
        if ("gneyp".equals(str)) {
            return aVarA.ae();
        }
        if ("gneypfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.e(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gnktpfs".equals(str)) {
            return aVarA.af();
        }
        if ("gdtlnktpfs".equals(str)) {
            return aVarA.ag();
        }
        if ("cknavbl".equals(str)) {
            return Boolean.valueOf(aVarA.ah());
        }
        if ("gdntp".equals(str)) {
            return Integer.valueOf(aVarA.ai());
        }
        if ("gcrslt".equals(str)) {
            return aVarA.aj();
        }
        if ("gtmne".equals(str)) {
            return aVarA.ak();
        }
        if ("gspt".equals(str)) {
            return aVarA.al();
        }
        if ("gcfre".equals(str)) {
            return aVarA.am();
        }
        if ("gctp".equals(str)) {
            return aVarA.an();
        }
        if ("gflv".equals(str)) {
            return aVarA.ao();
        }
        if ("gtrc".equals(str)) {
            return aVarA.ap();
        }
        if ("gbsbd".equals(str)) {
            return aVarA.aq();
        }
        if ("gbfspy".equals(str)) {
            return aVarA.ar();
        }
        if ("gbplfo".equals(str)) {
            return aVarA.as();
        }
        if ("gdvmua".equals(str)) {
            return aVarA.at();
        }
        if ("giads".equals(str)) {
            return aVarA.au();
        }
        if ("gia".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.f(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gal".equals(str)) {
            return aVarA.av();
        }
        if ("gsl".equals(str)) {
            return aVarA.aw();
        }
        if ("glctn".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return aVarA.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gstmpts".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.b((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gdvci".equals(str)) {
            return aVarA.ax();
        }
        if ("gdvk".equals(str)) {
            return aVarA.ay();
        }
        if ("gdvkfc".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.g(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gdfrspg".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.c((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("grsvps".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.d((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gdltmpg".equals(str)) {
            return aVarA.az();
        }
        if ("gdltm".equals(str)) {
            return aVarA.aA();
        }
        if ("gmlt".equals(str)) {
            return aVarA.aB();
        }
        if ("ipgist".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return Boolean.valueOf(aVarA.e((String) arrayList.get(0)));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gscpt".equals(str)) {
            return aVarA.aC();
        }
        if ("gsnmd".equals(str)) {
            return aVarA.aD();
        }
        if ("gsnmdfp".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.f((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgnm".equals(str)) {
            return aVarA.aE();
        }
        if ("gpnmmt".equals(str)) {
            return aVarA.aF();
        }
        if ("gpnmfp".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return aVarA.g((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpvsnm".equals(str)) {
            return Integer.valueOf(aVarA.aG());
        }
        if ("gpvsme".equals(str)) {
            return aVarA.aH();
        }
        if ("cinmnps".equals(str)) {
            return Boolean.valueOf(aVarA.aI());
        }
        if ("gcrtpcnm".equals(str)) {
            return aVarA.aJ();
        }
        if ("ciafgd".equals(str)) {
            return Boolean.valueOf(aVarA.aK());
        }
        if ("ckpmsi".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return Boolean.valueOf(aVarA.h((String) arrayList.get(0)));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("crtavthd".equals(str)) {
            return aVarA.aL();
        }
        if ("gaplcn".equals(str)) {
            return aVarA.aM();
        }
        if ("qritsvc".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return aVarA.a((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("rsaciy".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return aVarA.b((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgif".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return aVarA.a(false, 0, (String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgiffcin".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return aVarA.a(((Boolean) arrayList.get(0)).booleanValue(), 0, (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgifstrg".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return aVarA.a(false, ((Integer) arrayList.get(0)).intValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgiffist".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return aVarA.a(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("hdstipu".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                aVarA.a((View) arrayList.get(0));
                return null;
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("swstin".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                aVarA.b((View) arrayList.get(0));
                return null;
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gdvda".equals(str)) {
            return aVarA.aN();
        }
        if ("gdvdtnas".equals(str)) {
            return aVarA.aO();
        }
        if ("bsasm".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return aVarA.a((String) arrayList.get(0), (String) arrayList.get(1));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("galtut".equals(str)) {
            return Long.valueOf(aVarA.aP());
        }
        if ("gbrdm".equals(str)) {
            return aVarA.aQ();
        }
        if ("gdvme".equals(str)) {
            return aVarA.aR();
        }
        if ("gdpyd".equals(str)) {
            return aVarA.aS();
        }
        if ("gfgrnt".equals(str)) {
            return aVarA.aT();
        }
        if ("grivsn".equals(str)) {
            return aVarA.aU();
        }
        if ("gcrup".equals(str)) {
            return aVarA.aV();
        }
        if ("gcifm".equals(str)) {
            return aVarA.aW();
        }
        if ("godm".equals(str)) {
            return aVarA.aX();
        }
        if ("godhm".equals(str)) {
            return aVarA.aY();
        }
        if ("gadm".equals(str)) {
            return aVarA.aZ();
        }
        if ("gvdm".equals(str)) {
            return aVarA.ba();
        }
        if ("gudm".equals(str)) {
            return aVarA.bb();
        }
        if ("galdm".equals(str)) {
            return aVarA.bc();
        }
        if ("unrgrcv".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                aVarA.a((BroadcastReceiver) arrayList.get(0));
                return null;
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("rgrcv".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                aVarA.a((BroadcastReceiver) arrayList.get(0), (IntentFilter) arrayList.get(1));
                return null;
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("rgwsr".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                aVarA.a((BlockingQueue<Boolean>) arrayList.get(0));
                return null;
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gtaif".equals(str)) {
            return aVarA.bd();
        }
        if ("gtaifok".equals(str)) {
            return aVarA.be();
        }
        if (!"gtaifprm".equals(str)) {
            if ("gpsavlb".equals(str)) {
                return Boolean.valueOf(aVarA.bf());
            }
            return null;
        }
        if (arrayList != null && arrayList.size() == 2) {
            return aVarA.a((String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
        }
        throw new Throwable("array illegal: " + arrayList);
    }

    private static com.mob.tools.a.a a(String str) {
        CountDownLatch countDownLatchC;
        CountDownLatch countDownLatchC2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            MobLog.getInstance().w("WARNING: Call in main: key = " + str);
            b();
        }
        if (!(a.get() == null ? false : a.get().booleanValue())) {
            if (!d.contains(str) && !d.b() && (countDownLatchC2 = d.a(MobSDK.getContext()).c()) != null) {
                try {
                    MobLog.getInstance().d("dhs_ivkr k: " + str + ", cdl: " + countDownLatchC2, new Object[0]);
                    countDownLatchC2.await(3500L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        } else {
            boolean zBooleanValue = b.get() == null ? false : b.get().booleanValue();
            boolean zBooleanValue2 = c.get() == null ? false : c.get().booleanValue();
            if (zBooleanValue) {
                MobLog.getInstance().d("isGCFThread true", new Object[0]);
            }
            if (!zBooleanValue && !zBooleanValue2 && !d.b() && (countDownLatchC = d.a(MobSDK.getContext()).c()) != null) {
                try {
                    MobLog.getInstance().d("dhs_ivkr_new k: " + str + ", cdl: " + countDownLatchC, new Object[0]);
                    countDownLatchC.await(3500L, TimeUnit.MILLISECONDS);
                } catch (Throwable th2) {
                    MobLog.getInstance().d(th2);
                }
            }
        }
        return a();
    }

    private static com.mob.tools.a.a a() {
        if (d.b()) {
            return c.a(MobSDK.getContext()).f();
        }
        return c.a(MobSDK.getContext()).a();
    }

    private static void b() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                String str = "";
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        str = str + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + Constants.COLON_SEPARATOR + stackTraceElement.getLineNumber() + ")\n";
                    }
                }
                MobLog.getInstance().d(str, new Object[0]);
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }
}
