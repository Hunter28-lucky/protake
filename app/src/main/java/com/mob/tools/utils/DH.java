package com.mob.tools.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.blink.academy.film.stream.FinderManager;
import com.mob.MobSDK;
import com.mob.commons.u;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class DH {

    public interface DHResponder {
        void onResponse(DHResponse dHResponse);
    }

    public static class DHResponse {
        private boolean A;
        private String B;
        private String C;
        private int D;
        private String E;
        private LinkedList<String> F;
        private String G;
        private String H;
        private LinkedList<String> I;
        private int J;
        private String K;
        private LinkedList<ArrayList<HashMap<String, String>>> L;
        private ArrayList<HashMap<String, String>> M;
        private LinkedList<Boolean> N;
        private boolean O;
        private String P;
        private String Q;
        private String R;
        private String[] S;
        private LinkedList<Location> T;
        private int U;
        private int V;
        private int W;
        private int X;
        private int Y;
        private int Z;
        private boolean a;
        private boolean aA;
        private boolean aB;
        private boolean aC;
        private ArrayList<HashMap<String, String>> aD;
        private String aE;
        private HashMap<String, Object> aF;
        private HashMap<String, String> aG;
        private String aH;
        private String aI;
        private HashMap<String, Object> aJ;
        private String aK;
        private String aL;
        private String aM;
        private int aN;
        private String aO;
        private HashMap<String, Object> aP;
        private ArrayList<HashMap<String, Object>> aQ;
        private String aR;
        private boolean aS;
        private HashMap<String, Object> aT;
        private LinkedList<Boolean> aU;
        private boolean aV;
        private boolean aW;
        private String aX;
        private Void aY;
        private Void aZ;
        private int aa;
        private int ab;
        private ArrayList<HashMap<String, Object>> ac;
        private String ad;
        private LinkedList<String> ae;
        private LinkedList<List<String>> af;
        private Activity ag;
        private HashMap<String, Object> ah;
        private ArrayList<HashMap<String, Object>> ai;
        private boolean aj;
        private LinkedList<Boolean> ak;
        private HashMap<String, Object> al;
        private ArrayList<ArrayList<String>> am;
        private HashMap<String, Object> an;
        private int ao;
        private int ap;
        private String aq;
        private HashMap<String, HashMap<String, Long>> ar;
        private HashMap<String, Long> as;
        private String at;
        private int au;
        private boolean av;
        private boolean aw;
        private boolean ax;
        private boolean ay;
        private boolean az;
        private String b;
        private String bA;
        private String bB;
        private HashMap<String, Object> bC;
        private ApplicationInfo bD;
        private ArrayList<HashMap<String, Object>> bE;
        private LinkedList<ApplicationInfo> bF;
        private Void ba;
        private LinkedList<Object> bb;
        private Context bc;
        private LinkedList<List<ResolveInfo>> bd;
        private LinkedList<ResolveInfo> be;
        private LinkedList<PackageInfo> bf;
        private LinkedList<PackageInfo> bg;
        private LinkedList<PackageInfo> bh;
        private String bi;
        private Void bj;
        private Void bk;
        private String bl;
        private String bm;
        private LinkedList<String> bn;
        private Object bo;
        private long bp;
        private String bq;
        private String br;
        private String bs;
        private String bt;
        private String bu;
        private String bv;
        private String bw;
        private String bx;
        private String by;
        private String bz;
        private String c;
        private String d;

        /* renamed from: e, reason: collision with root package name */
        private String f17721e;
        public Error errors = new Error();
        private String f;
        private String g;
        private String[] h;
        private LinkedList<String> i;
        private String j;
        private int k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private String q;
        private LinkedList<String> r;
        private String s;
        private LinkedList<String> t;
        private String u;
        private String v;
        private String w;
        private LinkedList<String> x;
        private String y;
        private LinkedList<String> z;

        public class Error {
            private Throwable A;
            private LinkedList<Throwable> B;
            private Throwable C;
            private LinkedList<Throwable> D;
            private Throwable E;
            private Throwable F;
            private Throwable G;
            private Throwable H;
            private Throwable I;
            private LinkedList<Throwable> J;
            private Throwable K;
            private Throwable L;
            private LinkedList<Throwable> M;
            private Throwable N;
            private Throwable O;
            private LinkedList<Throwable> P;
            private Throwable Q;
            private LinkedList<Throwable> R;
            private Throwable S;
            private Throwable T;
            private Throwable U;
            private Throwable V;
            private Throwable W;
            private LinkedList<Throwable> X;
            private Throwable Y;
            private Throwable Z;
            private Throwable aA;
            private Throwable aB;
            private Throwable aC;
            private Throwable aD;
            private Throwable aE;
            private Throwable aF;
            private Throwable aG;
            private Throwable aH;
            private Throwable aI;
            private Throwable aJ;
            private Throwable aK;
            private Throwable aL;
            private Throwable aM;
            private Throwable aN;
            private Throwable aO;
            private Throwable aP;
            private Throwable aQ;
            private Throwable aR;
            private Throwable aS;
            private Throwable aT;
            private Throwable aU;
            private Throwable aV;
            private Throwable aW;
            private Throwable aX;
            private LinkedList<Throwable> aY;
            private Throwable aZ;
            private Throwable aa;
            private Throwable ab;
            private Throwable ac;
            private Throwable ad;
            private Throwable ae;
            private Throwable af;
            private Throwable ag;
            private Throwable ah;
            private LinkedList<Throwable> ai;
            private Throwable aj;
            private Throwable ak;
            private Throwable al;
            private Throwable am;
            private Throwable an;
            private LinkedList<Throwable> ao;
            private Throwable ap;
            private Throwable aq;
            private Throwable ar;
            private Throwable as;
            private Throwable at;
            private Throwable au;
            private Throwable av;
            private Throwable aw;
            private Throwable ax;
            private Throwable ay;
            private Throwable az;
            private Throwable bA;
            private Throwable bB;
            private Throwable bC;
            private Throwable bD;
            private Throwable bE;
            private Throwable bF;
            private Throwable bG;
            private Throwable bH;
            private Throwable bI;
            private LinkedList<Throwable> bJ;
            private Throwable ba;
            private Throwable bb;
            private Throwable bc;
            private Throwable bd;
            private Throwable be;
            private LinkedList<Throwable> bf;
            private Throwable bg;
            private LinkedList<Throwable> bh;
            private LinkedList<Throwable> bi;
            private LinkedList<Throwable> bj;
            private LinkedList<Throwable> bk;
            private LinkedList<Throwable> bl;
            private Throwable bm;
            private Throwable bn;
            private Throwable bo;
            private Throwable bp;
            private Throwable bq;
            private LinkedList<Throwable> br;
            private Throwable bs;
            private Throwable bt;
            private Throwable bu;
            private Throwable bv;
            private Throwable bw;
            private Throwable bx;
            private Throwable by;
            private Throwable bz;
            private Throwable d;

            /* renamed from: e, reason: collision with root package name */
            private Throwable f17722e;
            private Throwable f;
            private Throwable g;
            private Throwable h;
            private Throwable i;
            private Throwable j;
            private Throwable k;
            private Throwable l;
            private LinkedList<Throwable> m;
            private Throwable n;
            private Throwable o;
            private Throwable p;
            private Throwable q;
            private Throwable r;
            private Throwable s;
            private Throwable t;
            private Throwable u;
            private LinkedList<Throwable> v;
            private Throwable w;
            private LinkedList<Throwable> x;
            private Throwable y;
            private Throwable z;
            private boolean b = false;
            private boolean c = false;

            public Error() {
            }

            public Throwable checkNetworkAvailable() {
                return this.E;
            }

            public Throwable checkPad() {
                return this.aA;
            }

            public Throwable checkUA() {
                return this.aD;
            }

            public Throwable cx() {
                return this.az;
            }

            public Throwable debugable() {
                return this.aF;
            }

            public Throwable devEnable() {
                return this.aC;
            }

            public Throwable getAD() {
                return this.bD;
            }

            public Throwable getAInfo() {
                return this.bH;
            }

            public Throwable getAInfoForPkg(int... iArr) {
                return (Throwable) DHResponse.b(this.bJ, null, iArr);
            }

            public Throwable getALLD() {
                return this.bG;
            }

            public Throwable getAdvertisingID() {
                return this.U;
            }

            public Throwable getAlbumCount() {
                return this.ay;
            }

            public Throwable getAppLanguage() {
                return this.r;
            }

            public Throwable getAppLastUpdateTime() {
                return this.bt;
            }

            public Throwable getAppName() {
                return this.L;
            }

            public Throwable getAppNameForPkg(int... iArr) {
                return (Throwable) DHResponse.b(this.M, null, iArr);
            }

            public Throwable getApplication() {
                return this.bg;
            }

            public Throwable getAvailableWifiList() {
                return this.am;
            }

            public Throwable getAvailableWifiListOneKey() {
                return this.bI;
            }

            public Throwable getBaseband() {
                return this.aO;
            }

            public Throwable getBatteryState() {
                return this.ar;
            }

            public Throwable getBluetoothName() {
                return this.z;
            }

            public Throwable getBoard() {
                return this.bu;
            }

            public Throwable getBoardFromSysProperty() {
                return this.aP;
            }

            public Throwable getBoardPlatform() {
                return this.aQ;
            }

            public Throwable getBrand() {
                return this.aV;
            }

            public Throwable getBssid() {
                return this.g;
            }

            public Throwable getCInfo() {
                return this.bA;
            }

            public Throwable getCPUFreq() {
                return this.aK;
            }

            public Throwable getCPUInfo() {
                return this.ap;
            }

            public Throwable getCPUType() {
                return this.aL;
            }

            public Throwable getCamResolution() {
                return this.aH;
            }

            public Throwable getCarrier() {
                return this.u;
            }

            public Throwable getCarrierForce(int... iArr) {
                return (Throwable) DHResponse.b(this.v, null, iArr);
            }

            public Throwable getCarrierName() {
                return this.w;
            }

            public Throwable getCarrierNameForce(int... iArr) {
                return (Throwable) DHResponse.b(this.x, null, iArr);
            }

            public Throwable getCdmaBid() {
                return this.ad;
            }

            public Throwable getCdmaLat() {
                return this.ab;
            }

            public Throwable getCdmaLon() {
                return this.ac;
            }

            public Throwable getCdmaNid() {
                return this.af;
            }

            public Throwable getCdmaSid() {
                return this.ae;
            }

            public Throwable getCellId() {
                return this.Y;
            }

            public Throwable getCellLac() {
                return this.Z;
            }

            public Throwable getCgroup() {
                return this.bz;
            }

            public Throwable getCurrentWifiInfo() {
                return this.al;
            }

            public Throwable getDataNtType() {
                return this.aR;
            }

            public Throwable getDefaultIM() {
                return this.aT;
            }

            public Throwable getDefaultIMPkg() {
                return this.aS;
            }

            public Throwable getDefaultResolvePkg(int... iArr) {
                return (Throwable) DHResponse.b(this.ai, null, iArr);
            }

            public Throwable getDetailNetworkTypeForStatic() {
                return this.G;
            }

            public Throwable getDeviceData() {
                return this.bp;
            }

            public Throwable getDeviceDataNotAES() {
                return this.bq;
            }

            public Throwable getDeviceId() {
                return this.j;
            }

            public Throwable getDeviceKey() {
                return this.I;
            }

            public Throwable getDeviceKeyFromCache(int... iArr) {
                return (Throwable) DHResponse.b(this.J, null, iArr);
            }

            public Throwable getDeviceMemUsage() {
                return this.aX;
            }

            public Throwable getDeviceName() {
                return this.bv;
            }

            public Throwable getDeviceType() {
                return this.ah;
            }

            public Throwable getDisplayId() {
                return this.bw;
            }

            public Throwable getFingerprint() {
                return this.bx;
            }

            public Throwable getFlavor() {
                return this.aM;
            }

            public Throwable getGlobal() {
                return this.d;
            }

            public Throwable getIA(int... iArr) {
                return (Throwable) DHResponse.b(this.P, null, iArr);
            }

            public Throwable getIMEI() {
                return this.k;
            }

            public Throwable getIMList() {
                return this.aU;
            }

            public Throwable getIMSI() {
                return this.V;
            }

            public Throwable getIPAddress() {
                return this.bm;
            }

            public Throwable getLocation(int... iArr) {
                return (Throwable) DHResponse.b(this.R, null, iArr);
            }

            public Throwable getMIUIVersion() {
                return this.ax;
            }

            public Throwable getManufacturer() {
                return this.i;
            }

            public Throwable getMemoryInfo() {
                return this.aw;
            }

            public Throwable getModel() {
                return this.h;
            }

            public Throwable getNeighboringCellInfo() {
                return this.ag;
            }

            public Throwable getNetworkType() {
                return this.C;
            }

            public Throwable getNetworkTypeForStatic() {
                return this.F;
            }

            public Throwable getNetworkTypeForce(int... iArr) {
                return (Throwable) DHResponse.b(this.D, null, iArr);
            }

            public Throwable getOD() {
                return this.bB;
            }

            public Throwable getODH() {
                return this.bC;
            }

            public Throwable getOSCountry() {
                return this.s;
            }

            public Throwable getOSLanguage() {
                return this.q;
            }

            public Throwable getOSVersionInt() {
                return this.o;
            }

            public Throwable getOSVersionName() {
                return this.p;
            }

            public Throwable getPInfo(int... iArr) {
                return (Throwable) DHResponse.b(this.bj, null, iArr);
            }

            public Throwable getPInfoForce(int... iArr) {
                return (Throwable) DHResponse.b(this.bk, null, iArr);
            }

            public Throwable getPInfoStrategy(int... iArr) {
                return (Throwable) DHResponse.b(this.bl, null, iArr);
            }

            public Throwable getPsc() {
                return this.aa;
            }

            public Throwable getQemuKernel() {
                return this.au;
            }

            public Throwable getRadioVersion() {
                return this.by;
            }

            public Throwable getResolvePkgs() {
                return this.aj;
            }

            public Throwable getSA() {
                return this.Q;
            }

            public Throwable getSSID() {
                return this.f;
            }

            public Throwable getScreenBrightness() {
                return this.as;
            }

            public Throwable getScreenBrightnessMode() {
                return this.at;
            }

            public Throwable getScreenSize() {
                return this.t;
            }

            public Throwable getSdcardState() {
                return this.S;
            }

            public Throwable getSerialno() {
                return this.n;
            }

            public Throwable getSignMD5() {
                return this.A;
            }

            public Throwable getSignMD5ForPkg(int... iArr) {
                return (Throwable) DHResponse.b(this.B, null, iArr);
            }

            public Throwable getSimSerialNumber() {
                return this.y;
            }

            public Throwable getSizeInfo() {
                return this.av;
            }

            public Throwable getSupport() {
                return this.aJ;
            }

            public Throwable getSystemProperties(int... iArr) {
                return (Throwable) DHResponse.b(this.m, null, iArr);
            }

            public Throwable getTTYDriversInfo() {
                return this.aq;
            }

            public Throwable getTimezone() {
                return this.aI;
            }

            public Throwable getTopActivity() {
                return this.ak;
            }

            public Throwable getTraffic() {
                return this.aN;
            }

            public Throwable getUD() {
                return this.bF;
            }

            public Throwable getVD() {
                return this.bE;
            }

            public boolean hasError() {
                return this.c;
            }

            public boolean hasGlobalError() {
                return this.b;
            }

            public Throwable hideSoftInput() {
                return this.bn;
            }

            public Throwable isFakePass(int... iArr) {
                return (Throwable) DHResponse.b(this.aY, null, iArr);
            }

            public Throwable isPackageInstalled(int... iArr) {
                return (Throwable) DHResponse.b(this.ao, null, iArr);
            }

            public Throwable isRooted() {
                return this.f17722e;
            }

            public Throwable isSensitiveDevice() {
                return this.aZ;
            }

            public Throwable isSmlt() {
                return this.aW;
            }

            public Throwable isWifiProxy() {
                return this.aG;
            }

            public Throwable queryIMEI() {
                return this.l;
            }

            public Throwable queryIMSI() {
                return this.W;
            }

            public Throwable queryIntentServices(int... iArr) {
                return (Throwable) DHResponse.b(this.bh, null, iArr);
            }

            public Throwable registerWifiScanReceiver() {
                return this.be;
            }

            public Throwable resolveActivity(int... iArr) {
                return (Throwable) DHResponse.b(this.bi, null, iArr);
            }

            public Throwable scanWifiList() {
                return this.an;
            }

            public Throwable showSoftInput() {
                return this.bo;
            }

            public Throwable usbEnable() {
                return this.aB;
            }

            public Throwable vpn() {
                return this.aE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(String str, Throwable th) {
                if ("glberr".equals(str)) {
                    this.b = true;
                } else if (th != null) {
                    this.c = true;
                }
                if ("glberr".equals(str)) {
                    this.d = th;
                    return;
                }
                if ("cird".equals(str)) {
                    this.f17722e = th;
                    return;
                }
                if ("gsimt".equals(str)) {
                    this.f = th;
                    return;
                }
                if ("gbsi".equals(str)) {
                    this.g = th;
                    return;
                }
                if ("bgmdl".equals(str)) {
                    this.h = th;
                    return;
                }
                if ("gmnft".equals(str)) {
                    this.i = th;
                    return;
                }
                if ("gdvci".equals(str)) {
                    this.j = th;
                    return;
                }
                if ("gimi".equals(str)) {
                    this.k = th;
                    return;
                }
                if ("qriei".equals(str)) {
                    this.l = th;
                    return;
                }
                if ("gstmpts".equals(str)) {
                    if (this.m == null) {
                        this.m = new LinkedList<>();
                    }
                    this.m.add(th);
                    return;
                }
                if ("gsrln".equals(str)) {
                    this.n = th;
                    return;
                }
                if ("govsit".equals(str)) {
                    this.o = th;
                    return;
                }
                if ("govsnm".equals(str)) {
                    this.p = th;
                    return;
                }
                if ("golgu".equals(str)) {
                    this.q = th;
                    return;
                }
                if ("galgu".equals(str)) {
                    this.r = th;
                    return;
                }
                if ("gocnty".equals(str)) {
                    this.s = th;
                    return;
                }
                if ("gscsz".equals(str)) {
                    this.t = th;
                    return;
                }
                if ("gcrie".equals(str)) {
                    this.u = th;
                    return;
                }
                if ("gcriefce".equals(str)) {
                    if (this.v == null) {
                        this.v = new LinkedList<>();
                    }
                    this.v.add(th);
                    return;
                }
                if ("gcrnm".equals(str)) {
                    this.w = th;
                    return;
                }
                if ("gcrnmfce".equals(str)) {
                    if (this.x == null) {
                        this.x = new LinkedList<>();
                    }
                    this.x.add(th);
                    return;
                }
                if ("gssn".equals(str)) {
                    this.y = th;
                    return;
                }
                if ("gbhnm".equals(str)) {
                    this.z = th;
                    return;
                }
                if ("gsnmd".equals(str)) {
                    this.A = th;
                    return;
                }
                if ("gsnmdfp".equals(str)) {
                    if (this.B == null) {
                        this.B = new LinkedList<>();
                    }
                    this.B.add(th);
                    return;
                }
                if ("gneyp".equals(str)) {
                    this.C = th;
                    return;
                }
                if ("gneypfce".equals(str)) {
                    if (this.D == null) {
                        this.D = new LinkedList<>();
                    }
                    this.D.add(th);
                    return;
                }
                if ("cknavbl".equals(str)) {
                    this.E = th;
                    return;
                }
                if ("gnktpfs".equals(str)) {
                    this.F = th;
                    return;
                }
                if ("gdtlnktpfs".equals(str)) {
                    this.G = th;
                    return;
                }
                if ("pltfcd".equals(str)) {
                    this.H = th;
                    return;
                }
                if ("gdvk".equals(str)) {
                    this.I = th;
                    return;
                }
                if ("gdvkfc".equals(str)) {
                    if (this.J == null) {
                        this.J = new LinkedList<>();
                    }
                    this.J.add(th);
                    return;
                }
                if ("gpgnm".equals(str)) {
                    this.K = th;
                    return;
                }
                if ("gpnmmt".equals(str)) {
                    this.L = th;
                    return;
                }
                if ("gpnmfp".equals(str)) {
                    if (this.M == null) {
                        this.M = new LinkedList<>();
                    }
                    this.M.add(th);
                    return;
                }
                if ("gpvsnm".equals(str)) {
                    this.N = th;
                    return;
                }
                if ("gpvsme".equals(str)) {
                    this.O = th;
                    return;
                }
                if ("gia".equals(str)) {
                    if (this.P == null) {
                        this.P = new LinkedList<>();
                    }
                    this.P.add(th);
                    return;
                }
                if ("gsl".equals(str)) {
                    this.Q = th;
                    return;
                }
                if ("ckpmsi".equals(str)) {
                    if (this.R == null) {
                        this.R = new LinkedList<>();
                    }
                    this.R.add(th);
                    return;
                }
                if ("sdcsta".equals(str)) {
                    this.S = th;
                    return;
                }
                if ("gscpt".equals(str)) {
                    this.T = th;
                    return;
                }
                if ("gavti".equals(str)) {
                    this.U = th;
                    return;
                }
                if ("gisi".equals(str)) {
                    this.V = th;
                    return;
                }
                if ("qryisi".equals(str)) {
                    this.W = th;
                    return;
                }
                if ("glctn".equals(str)) {
                    if (this.X == null) {
                        this.X = new LinkedList<>();
                    }
                    this.X.add(th);
                    return;
                }
                if ("gcld".equals(str)) {
                    this.Y = th;
                    return;
                }
                if ("gcllc".equals(str)) {
                    this.Z = th;
                    return;
                }
                if ("gpcmt".equals(str)) {
                    this.aa = th;
                    return;
                }
                if ("gcmlt".equals(str)) {
                    this.ab = th;
                    return;
                }
                if ("gcmln".equals(str)) {
                    this.ac = th;
                    return;
                }
                if ("gcmbd".equals(str)) {
                    this.ad = th;
                    return;
                }
                if ("gcmsd".equals(str)) {
                    this.ae = th;
                    return;
                }
                if ("gcmnd".equals(str)) {
                    this.af = th;
                    return;
                }
                if ("gnbclin".equals(str)) {
                    this.ag = th;
                    return;
                }
                if ("gdvtp".equals(str)) {
                    this.ah = th;
                    return;
                }
                if ("gdfrspg".equals(str)) {
                    if (this.ai == null) {
                        this.ai = new LinkedList<>();
                    }
                    this.ai.add(th);
                    return;
                }
                if ("grsvps".equals(str)) {
                    this.aj = th;
                    return;
                }
                if ("tpact".equals(str)) {
                    this.ak = th;
                    return;
                }
                if ("wmcwi".equals(str)) {
                    this.al = th;
                    return;
                }
                if ("gavlwls".equals(str)) {
                    this.am = th;
                    return;
                }
                if ("scwls".equals(str)) {
                    this.an = th;
                    return;
                }
                if ("ipgist".equals(str)) {
                    if (this.ao == null) {
                        this.ao = new LinkedList<>();
                    }
                    this.ao.add(th);
                    return;
                }
                if ("gcuin".equals(str)) {
                    this.ap = th;
                    return;
                }
                if ("gtydvin".equals(str)) {
                    this.aq = th;
                    return;
                }
                if ("gbtrstt".equals(str)) {
                    this.ar = th;
                    return;
                }
                if ("gsnbtns".equals(str)) {
                    this.as = th;
                    return;
                }
                if ("gsnbtmd".equals(str)) {
                    this.at = th;
                    return;
                }
                if ("gqmkn".equals(str)) {
                    this.au = th;
                    return;
                }
                if ("gszin".equals(str)) {
                    this.av = th;
                    return;
                }
                if ("gmrin".equals(str)) {
                    this.aw = th;
                    return;
                }
                if ("gmivsn".equals(str)) {
                    this.ax = th;
                    return;
                }
                if ("gabct".equals(str)) {
                    this.ay = th;
                    return;
                }
                if ("cx".equals(str)) {
                    this.az = th;
                    return;
                }
                if ("ckpd".equals(str)) {
                    this.aA = th;
                    return;
                }
                if ("ubenbl".equals(str)) {
                    this.aB = th;
                    return;
                }
                if ("dvenbl".equals(str)) {
                    this.aC = th;
                    return;
                }
                if ("ckua".equals(str)) {
                    this.aD = th;
                    return;
                }
                if ("vnmt".equals(str)) {
                    this.aE = th;
                    return;
                }
                if ("degb".equals(str)) {
                    this.aF = th;
                    return;
                }
                if ("iwpxy".equals(str)) {
                    this.aG = th;
                    return;
                }
                if ("gcrslt".equals(str)) {
                    this.aH = th;
                    return;
                }
                if ("gtmne".equals(str)) {
                    this.aI = th;
                    return;
                }
                if ("gspt".equals(str)) {
                    this.aJ = th;
                    return;
                }
                if ("gcfre".equals(str)) {
                    this.aK = th;
                    return;
                }
                if ("gctp".equals(str)) {
                    this.aL = th;
                    return;
                }
                if ("gflv".equals(str)) {
                    this.aM = th;
                    return;
                }
                if ("gtrc".equals(str)) {
                    this.aN = th;
                    return;
                }
                if ("gbsbd".equals(str)) {
                    this.aO = th;
                    return;
                }
                if ("gbfspy".equals(str)) {
                    this.aP = th;
                    return;
                }
                if ("gbplfo".equals(str)) {
                    this.aQ = th;
                    return;
                }
                if ("gdntp".equals(str)) {
                    this.aR = th;
                    return;
                }
                if ("gdltmpg".equals(str)) {
                    this.aS = th;
                    return;
                }
                if ("gdltm".equals(str)) {
                    this.aT = th;
                    return;
                }
                if ("gmlt".equals(str)) {
                    this.aU = th;
                    return;
                }
                if ("gbrd".equals(str)) {
                    this.aV = th;
                    return;
                }
                if ("ismlt".equals(str)) {
                    this.aW = th;
                    return;
                }
                if ("gdvmua".equals(str)) {
                    this.aX = th;
                    return;
                }
                if ("ifkps".equals(str)) {
                    if (this.aY == null) {
                        this.aY = new LinkedList<>();
                    }
                    this.aY.add(th);
                    return;
                }
                if ("istvdv".equals(str)) {
                    this.aZ = th;
                    return;
                }
                if ("cinmnps".equals(str)) {
                    this.ba = th;
                    return;
                }
                if ("gcrtpcnm".equals(str)) {
                    this.bb = th;
                    return;
                }
                if ("unrgrcv".equals(str)) {
                    this.bc = th;
                    return;
                }
                if ("rgrcv".equals(str)) {
                    this.bd = th;
                    return;
                }
                if ("rgwsr".equals(str)) {
                    this.be = th;
                    return;
                }
                if ("sysvsaf".equals(str)) {
                    if (this.bf == null) {
                        this.bf = new LinkedList<>();
                    }
                    this.bf.add(th);
                    return;
                }
                if ("gaplcn".equals(str)) {
                    this.bg = th;
                    return;
                }
                if ("qritsvc".equals(str)) {
                    if (this.bh == null) {
                        this.bh = new LinkedList<>();
                    }
                    this.bh.add(th);
                    return;
                }
                if ("rsaciy".equals(str)) {
                    if (this.bi == null) {
                        this.bi = new LinkedList<>();
                    }
                    this.bi.add(th);
                    return;
                }
                if ("gpgif".equals(str)) {
                    if (this.bj == null) {
                        this.bj = new LinkedList<>();
                    }
                    this.bj.add(th);
                    return;
                }
                if ("gpgiffcin".equals(str)) {
                    if (this.bk == null) {
                        this.bk = new LinkedList<>();
                    }
                    this.bk.add(th);
                    return;
                }
                if ("gpgifstrg".equals(str)) {
                    if (this.bl == null) {
                        this.bl = new LinkedList<>();
                    }
                    this.bl.add(th);
                    return;
                }
                if ("giads".equals(str)) {
                    this.bm = th;
                    return;
                }
                if ("hdstipu".equals(str)) {
                    this.bn = th;
                    return;
                }
                if ("swstin".equals(str)) {
                    this.bo = th;
                    return;
                }
                if ("gdvda".equals(str)) {
                    this.bp = th;
                    return;
                }
                if ("gdvdtnas".equals(str)) {
                    this.bq = th;
                    return;
                }
                if ("bsasm".equals(str)) {
                    if (this.br == null) {
                        this.br = new LinkedList<>();
                    }
                    this.br.add(th);
                    return;
                }
                if ("crtavthd".equals(str)) {
                    this.bs = th;
                    return;
                }
                if ("galtut".equals(str)) {
                    this.bt = th;
                    return;
                }
                if ("gbrdm".equals(str)) {
                    this.bu = th;
                    return;
                }
                if ("gdvme".equals(str)) {
                    this.bv = th;
                    return;
                }
                if ("gdpyd".equals(str)) {
                    this.bw = th;
                    return;
                }
                if ("gfgrnt".equals(str)) {
                    this.bx = th;
                    return;
                }
                if ("grivsn".equals(str)) {
                    this.by = th;
                    return;
                }
                if ("gcrup".equals(str)) {
                    this.bz = th;
                    return;
                }
                if ("gcifm".equals(str)) {
                    this.bA = th;
                    return;
                }
                if ("godm".equals(str)) {
                    this.bB = th;
                    return;
                }
                if ("godhm".equals(str)) {
                    this.bC = th;
                    return;
                }
                if ("gadm".equals(str)) {
                    this.bD = th;
                    return;
                }
                if ("gvdm".equals(str)) {
                    this.bE = th;
                    return;
                }
                if ("gudm".equals(str)) {
                    this.bF = th;
                    return;
                }
                if ("galdm".equals(str)) {
                    this.bG = th;
                    return;
                }
                if ("gtaif".equals(str)) {
                    this.bH = th;
                    return;
                }
                if ("gtaifok".equals(str)) {
                    this.bI = th;
                    return;
                }
                if ("gtaifprm".equals(str)) {
                    if (this.bJ == null) {
                        this.bJ = new LinkedList<>();
                    }
                    this.bJ.add(th);
                    return;
                }
                MobLog.getInstance().d("Unknown name to set: " + str + ", t: " + th.getMessage(), new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T b(LinkedList<T> linkedList, T t, int... iArr) {
            if (linkedList != null) {
                if (iArr.length == 0) {
                    return linkedList.get(0);
                }
                if (iArr[0] < linkedList.size()) {
                    return linkedList.get(iArr[0]);
                }
                MobLog.getInstance().w("WARNING: " + iArr[0] + " out of bound, size: " + linkedList.size());
            }
            return t;
        }

        public boolean checkNetworkAvailable() {
            return this.A;
        }

        public boolean checkPad() {
            return this.aw;
        }

        public boolean checkUA() {
            return this.az;
        }

        public boolean cx() {
            return this.av;
        }

        public boolean debugable() {
            return this.aB;
        }

        public boolean devEnable() {
            return this.ay;
        }

        public String getAD() {
            return this.bz;
        }

        public ApplicationInfo getAInfo() {
            return this.bD;
        }

        public ApplicationInfo getAInfoForPkg(int... iArr) {
            return (ApplicationInfo) b(this.bF, null, iArr);
        }

        public HashMap<String, Object> getALLD() {
            return this.bC;
        }

        public String getAdvertisingID() {
            return this.Q;
        }

        public int getAlbumCount() {
            return this.au;
        }

        public String getAppLanguage() {
            return this.n;
        }

        public long getAppLastUpdateTime() {
            return this.bp;
        }

        public String getAppName() {
            return this.H;
        }

        public String getAppNameForPkg(int... iArr) {
            return (String) b(this.I, null, iArr);
        }

        public Context getApplication() {
            return this.bc;
        }

        public ArrayList<HashMap<String, Object>> getAvailableWifiList() {
            return this.ai;
        }

        public ArrayList<HashMap<String, Object>> getAvailableWifiListOneKey() {
            return this.bE;
        }

        public String getBaseband() {
            return this.aK;
        }

        public HashMap<String, Object> getBatteryState() {
            return this.an;
        }

        public String getBluetoothName() {
            return this.v;
        }

        public String getBoard() {
            return this.bq;
        }

        public String getBoardFromSysProperty() {
            return this.aL;
        }

        public String getBoardPlatform() {
            return this.aM;
        }

        public String getBssid() {
            return this.c;
        }

        public String getCInfo() {
            return this.bw;
        }

        public HashMap<String, String> getCPUFreq() {
            return this.aG;
        }

        public HashMap<String, Object> getCPUInfo() {
            return this.al;
        }

        public String getCPUType() {
            return this.aH;
        }

        public ArrayList<HashMap<String, String>> getCamResolution() {
            return this.aD;
        }

        public String getCarrier() {
            return this.q;
        }

        public String getCarrierForce(int... iArr) {
            return (String) b(this.r, FinderManager.MACHINE_NOT_VALID, iArr);
        }

        public String getCarrierName() {
            return this.s;
        }

        public String getCarrierNameForce(int... iArr) {
            return (String) b(this.t, null, iArr);
        }

        public int getCdmaBid() {
            return this.Z;
        }

        public int getCdmaLat() {
            return this.X;
        }

        public int getCdmaLon() {
            return this.Y;
        }

        public int getCdmaNid() {
            return this.ab;
        }

        public int getCdmaSid() {
            return this.aa;
        }

        public int getCellId() {
            return this.U;
        }

        public int getCellLac() {
            return this.V;
        }

        public String getCgroup() {
            return this.bv;
        }

        public HashMap<String, Object> getCurrentWifiInfo() {
            return this.ah;
        }

        public int getDataNtType() {
            return this.aN;
        }

        public HashMap<String, Object> getDefaultIM() {
            return this.aP;
        }

        public String getDefaultIMPkg() {
            return this.aO;
        }

        public String getDefaultResolvePkg(int... iArr) {
            return (String) b(this.ae, null, iArr);
        }

        public String getDetailNetworkTypeForStatic() {
            return this.C;
        }

        public String getDeviceData() {
            return this.bl;
        }

        public String getDeviceDataNotAES() {
            return this.bm;
        }

        public String getDeviceId() {
            return this.f;
        }

        public String getDeviceKey() {
            return this.E;
        }

        public String getDeviceKeyFromCache(int... iArr) {
            return (String) b(this.F, null, iArr);
        }

        public HashMap<String, Object> getDeviceMemUsage() {
            return this.aT;
        }

        public String getDeviceName() {
            return this.br;
        }

        public String getDeviceType() {
            return this.ad;
        }

        public String getDisplayId() {
            return this.bs;
        }

        public String getFingerprint() {
            return this.bt;
        }

        public String getFlavor() {
            return this.aI;
        }

        public ArrayList<HashMap<String, String>> getIA(int... iArr) {
            return (ArrayList) b(this.L, new ArrayList(), iArr);
        }

        public String getIMEI() {
            return this.g;
        }

        public ArrayList<HashMap<String, Object>> getIMList() {
            return this.aQ;
        }

        public String getIMSI() {
            return this.R;
        }

        public String getIPAddress() {
            return this.bi;
        }

        public Location getLocation(int... iArr) {
            return (Location) b(this.T, null, iArr);
        }

        public String getMIUIVersion() {
            return this.at;
        }

        public HashMap<String, Long> getMemoryInfo() {
            return this.as;
        }

        public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
            return this.ac;
        }

        public String getNetworkType() {
            return this.y;
        }

        public String getNetworkTypeForStatic() {
            return this.B;
        }

        public String getNetworkTypeForce(int... iArr) {
            return (String) b(this.z, com.mob.commons.a.d.a("004Relfdel]j"), iArr);
        }

        public String getOD() {
            return this.bx;
        }

        public String getODH() {
            return this.by;
        }

        public PackageInfo getPInfo(int... iArr) {
            return (PackageInfo) b(this.bf, null, iArr);
        }

        public PackageInfo getPInfoForce(int... iArr) {
            return (PackageInfo) b(this.bg, null, iArr);
        }

        public PackageInfo getPInfoStrategy(int... iArr) {
            return (PackageInfo) b(this.bh, null, iArr);
        }

        public int getPsc() {
            return this.W;
        }

        public String getQemuKernel() {
            return this.aq;
        }

        public String getRadioVersion() {
            return this.bu;
        }

        public List<String> getResolvePkgs(int... iArr) {
            return (List) b(this.af, null, iArr);
        }

        public ArrayList<HashMap<String, String>> getSA() {
            return this.M;
        }

        public String getSSID() {
            return this.b;
        }

        public int getScreenBrightness() {
            return this.ao;
        }

        public int getScreenBrightnessMode() {
            return this.ap;
        }

        public String getScreenSize() {
            return this.p;
        }

        public boolean getSdcardState() {
            return this.O;
        }

        public String getSerialno() {
            return this.j;
        }

        public String getSignMD5() {
            return this.w;
        }

        public String getSignMD5ForPkg(int... iArr) {
            return (String) b(this.x, null, iArr);
        }

        public String getSimSerialNumber() {
            return this.u;
        }

        public HashMap<String, HashMap<String, Long>> getSizeInfo() {
            return this.ar;
        }

        public HashMap<String, Object> getSupport() {
            return this.aF;
        }

        public String getSystemProperties(int... iArr) {
            return (String) b(this.i, null, iArr);
        }

        public ArrayList<ArrayList<String>> getTTYDriversInfo() {
            return this.am;
        }

        public Activity getTopActivity() {
            return this.ag;
        }

        public HashMap<String, Object> getTraffic() {
            return this.aJ;
        }

        public String getUD() {
            return this.bB;
        }

        public String getVD() {
            return this.bA;
        }

        public Void hideSoftInput() {
            return this.bj;
        }

        public boolean isFakePass(int... iArr) {
            return ((Boolean) b(this.aU, Boolean.FALSE, iArr)).booleanValue();
        }

        public boolean isPackageInstalled(int... iArr) {
            return ((Boolean) b(this.ak, Boolean.FALSE, iArr)).booleanValue();
        }

        public boolean isRooted() {
            return this.a;
        }

        public boolean isSmlt() {
            return this.aS;
        }

        public boolean isWifiProxy() {
            return this.aC;
        }

        public String[] queryIMEI() {
            return this.h;
        }

        public String[] queryIMSI() {
            return this.S;
        }

        public List<ResolveInfo> queryIntentServices(int... iArr) {
            return (List) b(this.bd, null, iArr);
        }

        public Void regReceiver() {
            return this.aZ;
        }

        public Void registerWifiScanReceiver() {
            return this.ba;
        }

        public ResolveInfo resolveActivity(int... iArr) {
            return (ResolveInfo) b(this.be, null, iArr);
        }

        public boolean scanWifiList() {
            return this.aj;
        }

        public Void showSoftInput() {
            return this.bk;
        }

        public Void unregReceiver() {
            return this.aY;
        }

        public boolean usbEnable() {
            return this.ax;
        }

        public boolean vpn() {
            return this.aA;
        }

        public void a(String str, Object obj) throws Throwable {
            a(str, obj, false);
        }

        public void a(String str, Object obj, boolean z) throws Throwable {
            if ("cird".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.a = ((Boolean) obj).booleanValue();
                return;
            }
            if ("gsimt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.b = (String) obj;
                return;
            }
            if ("gbsi".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.c = (String) obj;
                return;
            }
            if ("bgmdl".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.d = (String) obj;
                return;
            }
            if ("gmnft".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.f17721e = (String) obj;
                return;
            }
            if ("gdvci".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.f = (String) obj;
                return;
            }
            if ("gimi".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.g = (String) obj;
                return;
            }
            if ("qriei".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.h = (String[]) obj;
                return;
            }
            if ("gstmpts".equals(str)) {
                if (this.i == null) {
                    this.i = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.i.add((String) obj);
                return;
            }
            if ("gsrln".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.j = (String) obj;
                return;
            }
            if ("govsit".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.k = ((Integer) obj).intValue();
                return;
            }
            if ("govsnm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.l = (String) obj;
                return;
            }
            if ("golgu".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.m = (String) obj;
                return;
            }
            if ("galgu".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.n = (String) obj;
                return;
            }
            if ("gocnty".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.o = (String) obj;
                return;
            }
            if ("gscsz".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.p = (String) obj;
                return;
            }
            if ("gcrie".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.q = (String) obj;
                return;
            }
            if ("gcriefce".equals(str)) {
                if (this.r == null) {
                    this.r = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.r.add((String) obj);
                return;
            }
            if ("gcrnm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.s = (String) obj;
                return;
            }
            if ("gcrnmfce".equals(str)) {
                if (this.t == null) {
                    this.t = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.t.add((String) obj);
                return;
            }
            if ("gssn".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.u = (String) obj;
                return;
            }
            if ("gbhnm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.v = (String) obj;
                return;
            }
            if ("gsnmd".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.w = (String) obj;
                return;
            }
            if ("gsnmdfp".equals(str)) {
                if (this.x == null) {
                    this.x = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.x.add((String) obj);
                return;
            }
            if ("gneyp".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.y = (String) obj;
                return;
            }
            if ("gneypfce".equals(str)) {
                if (this.z == null) {
                    this.z = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.z.add((String) obj);
                return;
            }
            if ("cknavbl".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.A = ((Boolean) obj).booleanValue();
                return;
            }
            if ("gnktpfs".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.B = (String) obj;
                return;
            }
            if ("gdtlnktpfs".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.C = (String) obj;
                return;
            }
            if ("pltfcd".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.D = ((Integer) obj).intValue();
                return;
            }
            if ("gdvk".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.E = (String) obj;
                return;
            }
            if ("gdvkfc".equals(str)) {
                if (this.F == null) {
                    this.F = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.F.add((String) obj);
                return;
            }
            if ("gpgnm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.G = (String) obj;
                return;
            }
            if ("gpnmmt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.H = (String) obj;
                return;
            }
            if ("gpnmfp".equals(str)) {
                if (this.I == null) {
                    this.I = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.I.add((String) obj);
                return;
            }
            if ("gpvsnm".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.J = ((Integer) obj).intValue();
                return;
            }
            if ("gpvsme".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.K = (String) obj;
                return;
            }
            if ("gia".equals(str)) {
                if (this.L == null) {
                    this.L = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.L.add((ArrayList) obj);
                return;
            }
            if ("gsl".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.M = (ArrayList) obj;
                return;
            }
            if ("ckpmsi".equals(str)) {
                if (this.N == null) {
                    this.N = new LinkedList<>();
                }
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.N.add((Boolean) obj);
                return;
            }
            if ("sdcsta".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.O = ((Boolean) obj).booleanValue();
                return;
            }
            if ("gscpt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.P = (String) obj;
                return;
            }
            if ("gavti".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.Q = (String) obj;
                return;
            }
            if ("gisi".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.R = (String) obj;
                return;
            }
            if ("qryisi".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.S = (String[]) obj;
                return;
            }
            if ("glctn".equals(str)) {
                if (this.T == null) {
                    this.T = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.T.add((Location) obj);
                return;
            }
            if ("gcld".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.U = ((Integer) obj).intValue();
                return;
            }
            if ("gcllc".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.V = ((Integer) obj).intValue();
                return;
            }
            if ("gpcmt".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.W = ((Integer) obj).intValue();
                return;
            }
            if ("gcmlt".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.X = ((Integer) obj).intValue();
                return;
            }
            if ("gcmln".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.Y = ((Integer) obj).intValue();
                return;
            }
            if ("gcmbd".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.Z = ((Integer) obj).intValue();
                return;
            }
            if ("gcmsd".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.aa = ((Integer) obj).intValue();
                return;
            }
            if ("gcmnd".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.ab = ((Integer) obj).intValue();
                return;
            }
            if ("gnbclin".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ac = (ArrayList) obj;
                return;
            }
            if ("gdvtp".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ad = (String) obj;
                return;
            }
            if ("gdfrspg".equals(str)) {
                if (this.ae == null) {
                    this.ae = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.ae.add((String) obj);
                return;
            }
            if ("grsvps".equals(str)) {
                if (this.af == null) {
                    this.af = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.af.add((List) obj);
                return;
            }
            if ("tpact".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ag = (Activity) obj;
                return;
            }
            if ("wmcwi".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ah = (HashMap) obj;
                return;
            }
            if ("gavlwls".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ai = (ArrayList) obj;
                return;
            }
            if ("scwls".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aj = ((Boolean) obj).booleanValue();
                return;
            }
            if ("ipgist".equals(str)) {
                if (this.ak == null) {
                    this.ak = new LinkedList<>();
                }
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.ak.add((Boolean) obj);
                return;
            }
            if ("gcuin".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.al = (HashMap) obj;
                return;
            }
            if ("gtydvin".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.am = (ArrayList) obj;
                return;
            }
            if ("gbtrstt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.an = (HashMap) obj;
                return;
            }
            if ("gsnbtns".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.ao = ((Integer) obj).intValue();
                return;
            }
            if ("gsnbtmd".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.ap = ((Integer) obj).intValue();
                return;
            }
            if ("gqmkn".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aq = (String) obj;
                return;
            }
            if ("gszin".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ar = (HashMap) obj;
                return;
            }
            if ("gmrin".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.as = (HashMap) obj;
                return;
            }
            if ("gmivsn".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.at = (String) obj;
                return;
            }
            if ("gabct".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.au = ((Integer) obj).intValue();
                return;
            }
            if ("cx".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.av = ((Boolean) obj).booleanValue();
                return;
            }
            if ("ckpd".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aw = ((Boolean) obj).booleanValue();
                return;
            }
            if ("ubenbl".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.ax = ((Boolean) obj).booleanValue();
                return;
            }
            if ("dvenbl".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.ay = ((Boolean) obj).booleanValue();
                return;
            }
            if ("ckua".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.az = ((Boolean) obj).booleanValue();
                return;
            }
            if ("vnmt".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aA = ((Boolean) obj).booleanValue();
                return;
            }
            if ("degb".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aB = ((Boolean) obj).booleanValue();
                return;
            }
            if ("iwpxy".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aC = ((Boolean) obj).booleanValue();
                return;
            }
            if ("gcrslt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aD = (ArrayList) obj;
                return;
            }
            if ("gtmne".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aE = (String) obj;
                return;
            }
            if ("gspt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aF = (HashMap) obj;
                return;
            }
            if ("gcfre".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aG = (HashMap) obj;
                return;
            }
            if ("gctp".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aH = (String) obj;
                return;
            }
            if ("gflv".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aI = (String) obj;
                return;
            }
            if ("gtrc".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aJ = (HashMap) obj;
                return;
            }
            if ("gbsbd".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aK = (String) obj;
                return;
            }
            if ("gbfspy".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aL = (String) obj;
                return;
            }
            if ("gbplfo".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aM = (String) obj;
                return;
            }
            if ("gdntp".equals(str)) {
                if (z) {
                    obj = 0;
                }
                this.aN = ((Integer) obj).intValue();
                return;
            }
            if ("gdltmpg".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aO = (String) obj;
                return;
            }
            if ("gdltm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aP = (HashMap) obj;
                return;
            }
            if ("gmlt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aQ = (ArrayList) obj;
                return;
            }
            if ("gbrd".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aR = (String) obj;
                return;
            }
            if ("ismlt".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aS = ((Boolean) obj).booleanValue();
                return;
            }
            if ("gdvmua".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aT = (HashMap) obj;
                return;
            }
            if ("ifkps".equals(str)) {
                if (this.aU == null) {
                    this.aU = new LinkedList<>();
                }
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aU.add((Boolean) obj);
                return;
            }
            if ("istvdv".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aV = ((Boolean) obj).booleanValue();
                return;
            }
            if ("cinmnps".equals(str)) {
                if (z) {
                    obj = Boolean.FALSE;
                }
                this.aW = ((Boolean) obj).booleanValue();
                return;
            }
            if ("gcrtpcnm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aX = (String) obj;
                return;
            }
            if ("unrgrcv".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aY = (Void) obj;
                return;
            }
            if ("rgrcv".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.aZ = (Void) obj;
                return;
            }
            if ("rgwsr".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.ba = (Void) obj;
                return;
            }
            if ("sysvsaf".equals(str)) {
                if (this.bb == null) {
                    this.bb = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.bb.add(obj);
                return;
            }
            if ("gaplcn".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bc = (Context) obj;
                return;
            }
            if ("qritsvc".equals(str)) {
                if (this.bd == null) {
                    this.bd = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.bd.add((List) obj);
                return;
            }
            if ("rsaciy".equals(str)) {
                if (this.be == null) {
                    this.be = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.be.add((ResolveInfo) obj);
                return;
            }
            if ("gpgif".equals(str)) {
                if (this.bf == null) {
                    this.bf = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.bf.add((PackageInfo) obj);
                return;
            }
            if ("gpgiffcin".equals(str)) {
                if (this.bg == null) {
                    this.bg = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.bg.add((PackageInfo) obj);
                return;
            }
            if ("gpgifstrg".equals(str)) {
                if (this.bh == null) {
                    this.bh = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.bh.add((PackageInfo) obj);
                return;
            }
            if ("giads".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bi = (String) obj;
                return;
            }
            if ("hdstipu".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bj = (Void) obj;
                return;
            }
            if ("swstin".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bk = (Void) obj;
                return;
            }
            if ("gdvda".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bl = (String) obj;
                return;
            }
            if ("gdvdtnas".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bm = (String) obj;
                return;
            }
            if ("bsasm".equals(str)) {
                if (this.bn == null) {
                    this.bn = new LinkedList<>();
                }
                if (z) {
                    obj = null;
                }
                this.bn.add((String) obj);
                return;
            }
            if ("crtavthd".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bo = obj;
                return;
            }
            if ("galtut".equals(str)) {
                if (z) {
                    obj = 0L;
                }
                this.bp = ((Long) obj).longValue();
                return;
            }
            if ("gbrdm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bq = (String) obj;
                return;
            }
            if ("gdvme".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.br = (String) obj;
                return;
            }
            if ("gdpyd".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bs = (String) obj;
                return;
            }
            if ("gfgrnt".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bt = (String) obj;
                return;
            }
            if ("grivsn".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bu = (String) obj;
                return;
            }
            if ("gcrup".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bv = (String) obj;
                return;
            }
            if ("gcifm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bw = (String) obj;
                return;
            }
            if ("godm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bx = (String) obj;
                return;
            }
            if ("godhm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.by = (String) obj;
                return;
            }
            if ("gadm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bz = (String) obj;
                return;
            }
            if ("gvdm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bA = (String) obj;
                return;
            }
            if ("gudm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bB = (String) obj;
                return;
            }
            if ("galdm".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bC = (HashMap) obj;
                return;
            }
            if ("gtaif".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bD = (ApplicationInfo) obj;
                return;
            }
            if ("gtaifok".equals(str)) {
                if (z) {
                    obj = null;
                }
                this.bE = (ArrayList) obj;
            } else {
                if ("gtaifprm".equals(str)) {
                    if (this.bF == null) {
                        this.bF = new LinkedList<>();
                    }
                    if (z) {
                        obj = null;
                    }
                    this.bF.add((ApplicationInfo) obj);
                    return;
                }
                throw new Throwable("Unknown name to set: " + str + ", value: " + obj);
            }
        }
    }

    public static class RequestBuilder {
        private Context a;
        private LinkedList<a> b;

        public class a {
            public final String a;
            public final Object[] b;

            private a(String str, Object... objArr) {
                this.a = str;
                this.b = objArr;
            }
        }

        public RequestBuilder checkNetworkAvailable() {
            this.b.add(new a("cknavbl", new Object[0]));
            return this;
        }

        public RequestBuilder checkPad() {
            this.b.add(new a("ckpd", new Object[0]));
            return this;
        }

        public RequestBuilder checkUA() {
            this.b.add(new a("ckua", new Object[0]));
            return this;
        }

        public RequestBuilder cx() {
            this.b.add(new a("cx", new Object[0]));
            return this;
        }

        public RequestBuilder debugable() {
            this.b.add(new a("degb", new Object[0]));
            return this;
        }

        public RequestBuilder devEnable() {
            this.b.add(new a("dvenbl", new Object[0]));
            return this;
        }

        public RequestBuilder getAD() {
            this.b.add(new a("gadm", new Object[0]));
            return this;
        }

        public RequestBuilder getAInfo() {
            this.b.add(new a("gtaif", new Object[0]));
            return this;
        }

        public RequestBuilder getAInfoForPkg(String str, int i) {
            this.b.add(new a("gtaifprm", new Object[]{str, Integer.valueOf(i)}));
            return this;
        }

        public RequestBuilder getALLD() {
            this.b.add(new a("galdm", new Object[0]));
            return this;
        }

        public RequestBuilder getAdvertisingID() {
            this.b.add(new a("gavti", new Object[0]));
            return this;
        }

        public RequestBuilder getAlbumCount() {
            this.b.add(new a("gabct", new Object[0]));
            return this;
        }

        public RequestBuilder getAppLastUpdateTime() {
            this.b.add(new a("galtut", new Object[0]));
            return this;
        }

        public RequestBuilder getAppName() {
            this.b.add(new a("gpnmmt", new Object[0]));
            return this;
        }

        public RequestBuilder getAppNameForPkg(String str) {
            this.b.add(new a("gpnmfp", new Object[]{str}));
            return this;
        }

        public RequestBuilder getAvailableWifiList() {
            this.b.add(new a("gavlwls", new Object[0]));
            return this;
        }

        public RequestBuilder getAvailableWifiListOneKey() {
            this.b.add(new a("gtaifok", new Object[0]));
            return this;
        }

        public RequestBuilder getBaseband() {
            this.b.add(new a("gbsbd", new Object[0]));
            return this;
        }

        public RequestBuilder getBatteryState() {
            this.b.add(new a("gbtrstt", new Object[0]));
            return this;
        }

        public RequestBuilder getBluetoothName() {
            this.b.add(new a("gbhnm", new Object[0]));
            return this;
        }

        public RequestBuilder getBoard() {
            this.b.add(new a("gbrdm", new Object[0]));
            return this;
        }

        public RequestBuilder getBoardFromSysProperty() {
            this.b.add(new a("gbfspy", new Object[0]));
            return this;
        }

        public RequestBuilder getBoardPlatform() {
            this.b.add(new a("gbplfo", new Object[0]));
            return this;
        }

        public RequestBuilder getBssid() {
            this.b.add(new a("gbsi", new Object[0]));
            return this;
        }

        public RequestBuilder getCInfo() {
            this.b.add(new a("gcifm", new Object[0]));
            return this;
        }

        public RequestBuilder getCPUFreq() {
            this.b.add(new a("gcfre", new Object[0]));
            return this;
        }

        public RequestBuilder getCPUInfo() {
            this.b.add(new a("gcuin", new Object[0]));
            return this;
        }

        public RequestBuilder getCPUType() {
            this.b.add(new a("gctp", new Object[0]));
            return this;
        }

        public RequestBuilder getCamResolution() {
            this.b.add(new a("gcrslt", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrier() {
            this.b.add(new a("gcrie", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrierForce(boolean z) {
            this.b.add(new a("gcriefce", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public RequestBuilder getCarrierName() {
            this.b.add(new a("gcrnm", new Object[0]));
            return this;
        }

        public RequestBuilder getCarrierNameForce(boolean z) {
            this.b.add(new a("gcrnmfce", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public RequestBuilder getCdmaBid() {
            this.b.add(new a("gcmbd", new Object[0]));
            return this;
        }

        public RequestBuilder getCdmaLat() {
            this.b.add(new a("gcmlt", new Object[0]));
            return this;
        }

        public RequestBuilder getCdmaLon() {
            this.b.add(new a("gcmln", new Object[0]));
            return this;
        }

        public RequestBuilder getCdmaNid() {
            this.b.add(new a("gcmnd", new Object[0]));
            return this;
        }

        public RequestBuilder getCdmaSid() {
            this.b.add(new a("gcmsd", new Object[0]));
            return this;
        }

        public RequestBuilder getCellId() {
            this.b.add(new a("gcld", new Object[0]));
            return this;
        }

        public RequestBuilder getCellLac() {
            this.b.add(new a("gcllc", new Object[0]));
            return this;
        }

        public RequestBuilder getCgroup() {
            this.b.add(new a("gcrup", new Object[0]));
            return this;
        }

        public RequestBuilder getCurrentWifiInfo() {
            this.b.add(new a("wmcwi", new Object[0]));
            return this;
        }

        public RequestBuilder getDataNtType() {
            this.b.add(new a("gdntp", new Object[0]));
            return this;
        }

        public RequestBuilder getDefaultIM() {
            this.b.add(new a("gdltm", new Object[0]));
            return this;
        }

        public RequestBuilder getDefaultIMPkg() {
            this.b.add(new a("gdltmpg", new Object[0]));
            return this;
        }

        public RequestBuilder getDefaultResolvePkg(String str) {
            this.b.add(new a("gdfrspg", new Object[]{str}));
            return this;
        }

        public RequestBuilder getDetailNetworkTypeForStatic() {
            this.b.add(new a("gdtlnktpfs", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceData() {
            this.b.add(new a("gdvda", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceDataNotAES() {
            this.b.add(new a("gdvdtnas", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceId() {
            this.b.add(new a("gdvci", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceKey() {
            this.b.add(new a("gdvk", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceKeyFromCache(boolean z) {
            this.b.add(new a("gdvkfc", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public RequestBuilder getDeviceMemUsage() {
            this.b.add(new a("gdvmua", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceName() {
            this.b.add(new a("gdvme", new Object[0]));
            return this;
        }

        public RequestBuilder getDeviceType() {
            this.b.add(new a("gdvtp", new Object[0]));
            return this;
        }

        public RequestBuilder getDisplayId() {
            this.b.add(new a("gdpyd", new Object[0]));
            return this;
        }

        public RequestBuilder getFingerprint() {
            this.b.add(new a("gfgrnt", new Object[0]));
            return this;
        }

        public RequestBuilder getFlavor() {
            this.b.add(new a("gflv", new Object[0]));
            return this;
        }

        public RequestBuilder getIA(boolean z) {
            this.b.add(new a("gia", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public RequestBuilder getIMEI() {
            this.b.add(new a("gimi", new Object[0]));
            return this;
        }

        public RequestBuilder getIMList() {
            this.b.add(new a("gmlt", new Object[0]));
            return this;
        }

        public RequestBuilder getIMSI() {
            this.b.add(new a("gisi", new Object[0]));
            return this;
        }

        public RequestBuilder getIPAddress() {
            this.b.add(new a("giads", new Object[0]));
            return this;
        }

        public RequestBuilder getLocation(int i, int i2, boolean z) {
            this.b.add(new a("glctn", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}));
            return this;
        }

        public RequestBuilder getMIUIVersion() {
            this.b.add(new a("gmivsn", new Object[0]));
            return this;
        }

        public RequestBuilder getMemoryInfo() {
            this.b.add(new a("gmrin", new Object[0]));
            return this;
        }

        public RequestBuilder getNeighboringCellInfo() {
            this.b.add(new a("gnbclin", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkType() {
            this.b.add(new a("gneyp", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkTypeForStatic() {
            this.b.add(new a("gnktpfs", new Object[0]));
            return this;
        }

        public RequestBuilder getNetworkTypeForce(boolean z) {
            this.b.add(new a("gneypfce", new Object[]{Boolean.valueOf(z)}));
            return this;
        }

        public RequestBuilder getOD() {
            this.b.add(new a("godm", new Object[0]));
            return this;
        }

        public RequestBuilder getODH() {
            this.b.add(new a("godhm", new Object[0]));
            return this;
        }

        public RequestBuilder getPInfo(String str, int i) {
            this.b.add(new a("gpgif", new Object[]{str, Integer.valueOf(i)}));
            return this;
        }

        public RequestBuilder getPInfoForce(boolean z, String str, int i) {
            this.b.add(new a("gpgiffcin", new Object[]{Boolean.valueOf(z), str, Integer.valueOf(i)}));
            return this;
        }

        public RequestBuilder getPInfoStrategy(int i, String str, int i2) {
            this.b.add(new a("gpgifstrg", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)}));
            return this;
        }

        public RequestBuilder getPsc() {
            this.b.add(new a("gpcmt", new Object[0]));
            return this;
        }

        public RequestBuilder getQemuKernel() {
            this.b.add(new a("gqmkn", new Object[0]));
            return this;
        }

        public RequestBuilder getRadioVersion() {
            this.b.add(new a("grivsn", new Object[0]));
            return this;
        }

        public RequestBuilder getResolvePkgs(String str) {
            this.b.add(new a("grsvps", new Object[]{str}));
            return this;
        }

        public RequestBuilder getSA() {
            this.b.add(new a("gsl", new Object[0]));
            return this;
        }

        public RequestBuilder getSSID() {
            this.b.add(new a("gsimt", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenBrightness() {
            this.b.add(new a("gsnbtns", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenBrightnessMode() {
            this.b.add(new a("gsnbtmd", new Object[0]));
            return this;
        }

        public RequestBuilder getScreenSize() {
            this.b.add(new a("gscsz", new Object[0]));
            return this;
        }

        public RequestBuilder getSdcardState() {
            this.b.add(new a("sdcsta", new Object[0]));
            return this;
        }

        public RequestBuilder getSerialno() {
            this.b.add(new a("gsrln", new Object[0]));
            return this;
        }

        public RequestBuilder getSignMD5() {
            this.b.add(new a("gsnmd", new Object[0]));
            return this;
        }

        public RequestBuilder getSignMD5ForPkg(String str) {
            this.b.add(new a("gsnmdfp", new Object[]{str}));
            return this;
        }

        public RequestBuilder getSimSerialNumber() {
            this.b.add(new a("gssn", new Object[0]));
            return this;
        }

        public RequestBuilder getSizeInfo() {
            this.b.add(new a("gszin", new Object[0]));
            return this;
        }

        public RequestBuilder getSupport() {
            this.b.add(new a("gspt", new Object[0]));
            return this;
        }

        public RequestBuilder getSystemProperties(String str) {
            this.b.add(new a("gstmpts", new Object[]{str}));
            return this;
        }

        public RequestBuilder getTTYDriversInfo() {
            this.b.add(new a("gtydvin", new Object[0]));
            return this;
        }

        public RequestBuilder getTopActivity() {
            this.b.add(new a("tpact", new Object[0]));
            return this;
        }

        public RequestBuilder getTraffic() {
            this.b.add(new a("gtrc", new Object[0]));
            return this;
        }

        public RequestBuilder getUD() {
            this.b.add(new a("gudm", new Object[0]));
            return this;
        }

        public RequestBuilder getVD() {
            this.b.add(new a("gvdm", new Object[0]));
            return this;
        }

        public RequestBuilder isFakePass(String str) {
            this.b.add(new a("ifkps", new Object[]{str}));
            return this;
        }

        public RequestBuilder isPackageInstalled(String str) {
            this.b.add(new a("ipgist", new Object[]{str}));
            return this;
        }

        public RequestBuilder isRooted() {
            this.b.add(new a("cird", new Object[0]));
            return this;
        }

        public RequestBuilder isSmlt() {
            this.b.add(new a("ismlt", new Object[0]));
            return this;
        }

        public RequestBuilder isWifiProxy() {
            this.b.add(new a("iwpxy", new Object[0]));
            return this;
        }

        public RequestBuilder queryIMEI() {
            this.b.add(new a("qriei", new Object[0]));
            return this;
        }

        public RequestBuilder queryIMSI() {
            this.b.add(new a("qryisi", new Object[0]));
            return this;
        }

        public RequestBuilder queryIntentServices(Intent intent, int i) {
            this.b.add(new a("qritsvc", new Object[]{intent, Integer.valueOf(i)}));
            return this;
        }

        public RequestBuilder registerWifiScanReceiver(BlockingQueue<Boolean> blockingQueue) {
            this.b.add(new a("rgwsr", new Object[]{blockingQueue}));
            return this;
        }

        public void request(final DHResponder dHResponder) {
            try {
                boolean z = Looper.getMainLooper() == Looper.myLooper();
                final Boolean bool = com.mob.tools.b.a.b.get();
                final Boolean bool2 = com.mob.tools.b.a.c.get();
                final boolean z2 = z;
                Runnable runnable = new Runnable() { // from class: com.mob.tools.utils.DH.RequestBuilder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.mob.tools.b.a.a.set(Boolean.TRUE);
                            com.mob.tools.b.a.b.set(bool);
                            com.mob.tools.b.a.c.set(bool2);
                            final DHResponse dHResponseA = RequestBuilder.this.a();
                            DHResponder dHResponder2 = dHResponder;
                            if (dHResponder2 != null) {
                                if (z2) {
                                    UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: com.mob.tools.utils.DH.RequestBuilder.1.1
                                        @Override // android.os.Handler.Callback
                                        public boolean handleMessage(Message message) {
                                            try {
                                                dHResponder.onResponse(dHResponseA);
                                            } catch (Throwable th) {
                                                MobLog.getInstance().d(th, "Error from caller", new Object[0]);
                                            }
                                            return false;
                                        }
                                    });
                                } else {
                                    try {
                                        dHResponder2.onResponse(dHResponseA);
                                    } catch (Throwable th) {
                                        MobLog.getInstance().d(th, "Error from caller", new Object[0]);
                                    }
                                }
                            }
                            ThreadLocal<Boolean> threadLocal = com.mob.tools.b.a.a;
                            Boolean bool3 = Boolean.FALSE;
                            threadLocal.set(bool3);
                            com.mob.tools.b.a.b.set(bool3);
                            com.mob.tools.b.a.c.set(bool3);
                        } catch (Throwable th2) {
                            MobLog.getInstance().d(th2);
                            DHResponder dHResponder3 = dHResponder;
                            if (dHResponder3 != null) {
                                dHResponder3.onResponse(new DHResponse());
                            }
                        }
                    }
                };
                if (z) {
                    u.g.execute(runnable);
                } else {
                    runnable.run();
                }
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                if (dHResponder != null) {
                    dHResponder.onResponse(new DHResponse());
                }
            }
        }

        public RequestBuilder resolveActivity(Intent intent, int i) {
            this.b.add(new a("rsaciy", new Object[]{intent, Integer.valueOf(i)}));
            return this;
        }

        public RequestBuilder scanWifiList() {
            this.b.add(new a("scwls", new Object[0]));
            return this;
        }

        public RequestBuilder usbEnable() {
            this.b.add(new a("ubenbl", new Object[0]));
            return this;
        }

        public RequestBuilder vpn() {
            this.b.add(new a("vnmt", new Object[0]));
            return this;
        }

        private RequestBuilder(Context context) {
            this.a = context;
            this.b = new LinkedList<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DHResponse a() {
            DHResponse dHResponse = new DHResponse();
            for (int i = 0; i < this.b.size(); i++) {
                a aVar = this.b.get(i);
                try {
                    String str = aVar.a;
                    dHResponse.a(str, a(str, aVar.b));
                    dHResponse.errors.a(aVar.a, null);
                } finally {
                    try {
                    } catch (Throwable th) {
                    }
                }
            }
            return dHResponse;
        }

        private Object a(String str, Object[] objArr) throws Throwable {
            if ("cird".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().a());
            }
            if ("gsimt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().r();
            }
            if ("gbsi".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().s();
            }
            if ("bgmdl".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().y();
            }
            if ("gmnft".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().z();
            }
            if ("gdvci".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ax();
            }
            if ("gimi".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().n();
            }
            if ("qriei".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().C();
            }
            if ("gstmpts".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().b((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gsrln".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().l();
            }
            if ("govsit".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().Q());
            }
            if ("govsnm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().R();
            }
            if ("golgu".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().S();
            }
            if ("galgu".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ac();
            }
            if ("gocnty".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().T();
            }
            if ("gscsz".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ad();
            }
            if ("gcrie".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().t();
            }
            if ("gcriefce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().c(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gcrnm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().u();
            }
            if ("gcrnmfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().d(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gssn".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().v();
            }
            if ("gbhnm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().D();
            }
            if ("gsnmd".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aD();
            }
            if ("gsnmdfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().f((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gneyp".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ae();
            }
            if ("gneypfce".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().e(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("cknavbl".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().ah());
            }
            if ("gnktpfs".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().af();
            }
            if ("gdtlnktpfs".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ag();
            }
            if ("pltfcd".equals(str)) {
                return 1;
            }
            if ("gdvk".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ay();
            }
            if ("gdvkfc".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().g(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpgnm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aE();
            }
            if ("gpnmmt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aF();
            }
            if ("gpnmfp".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().g((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpvsnm".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().aG());
            }
            if ("gpvsme".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aH();
            }
            if ("gia".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().f(((Boolean) objArr[0]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gsl".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aw();
            }
            if ("ckpmsi".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().h((String) objArr[0]));
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("sdcsta".equals(str)) {
                return Boolean.FALSE;
            }
            if ("gscpt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aC();
            }
            if ("gavti".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().m();
            }
            if ("gisi".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().p();
            }
            if ("qryisi".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().q();
            }
            if ("glctn".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return com.mob.tools.a.c.a(this.a).b().a(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gcld".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().E());
            }
            if ("gcllc".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().F());
            }
            if ("gpcmt".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().G());
            }
            if ("gcmlt".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().H());
            }
            if ("gcmln".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().I());
            }
            if ("gcmbd".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().J());
            }
            if ("gcmsd".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().K());
            }
            if ("gcmnd".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().L());
            }
            if ("gnbclin".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().M();
            }
            if ("gdvtp".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().B();
            }
            if ("gdfrspg".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().c((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("grsvps".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return com.mob.tools.a.c.a(this.a).b().d((String) objArr[0]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("tpact".equals(str)) {
                return null;
            }
            if ("wmcwi".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().N();
            }
            if ("gavlwls".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().O();
            }
            if ("scwls".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().P());
            }
            if ("ipgist".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().e((String) objArr[0]));
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gcuin".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().U();
            }
            if ("gtydvin".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().V();
            }
            if ("gbtrstt".equals(str)) {
                final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                com.mob.tools.a.c.a(this.a).b().a(new Handler.Callback() { // from class: com.mob.tools.utils.DH.RequestBuilder.2
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        try {
                            linkedBlockingQueue.offer((HashMap) message.obj);
                            return false;
                        } catch (Throwable th) {
                            MobLog.getInstance().d(th);
                            return false;
                        }
                    }
                });
                return linkedBlockingQueue.poll(5000L, TimeUnit.MILLISECONDS);
            }
            if ("gsnbtns".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().W());
            }
            if ("gsnbtmd".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().X());
            }
            if ("gqmkn".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().Y();
            }
            if ("gszin".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().Z();
            }
            if ("gmrin".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aa();
            }
            if ("gmivsn".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().w();
            }
            if ("gabct".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().ab());
            }
            if ("cx".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().b());
            }
            if ("ckpd".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().c());
            }
            if ("ubenbl".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().h());
            }
            if ("dvenbl".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().g());
            }
            if ("ckua".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().f());
            }
            if ("vnmt".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().e());
            }
            if ("degb".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().d());
            }
            if ("iwpxy".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().i());
            }
            if ("gcrslt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aj();
            }
            if ("gtmne".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ak();
            }
            if ("gspt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().al();
            }
            if ("gcfre".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().am();
            }
            if ("gctp".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().an();
            }
            if ("gflv".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ao();
            }
            if ("gtrc".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ap();
            }
            if ("gbsbd".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aq();
            }
            if ("gbfspy".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ar();
            }
            if ("gbplfo".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().as();
            }
            if ("gdntp".equals(str)) {
                return Integer.valueOf(com.mob.tools.a.c.a(this.a).b().ai());
            }
            if ("gdltmpg".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().az();
            }
            if ("gdltm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aA();
            }
            if ("gmlt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aB();
            }
            if ("gbrd".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().A();
            }
            if ("ismlt".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().j());
            }
            if ("gdvmua".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().at();
            }
            if ("ifkps".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().a((String) objArr[0]));
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("istvdv".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().k());
            }
            if ("cinmnps".equals(str)) {
                return Boolean.valueOf(com.mob.tools.a.c.a(this.a).b().aI());
            }
            if ("gcrtpcnm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aJ();
            }
            if ("unrgrcv".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    com.mob.tools.a.c.a(this.a).b().a((BroadcastReceiver) objArr[0]);
                    return null;
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("rgrcv".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    com.mob.tools.a.c.a(this.a).b().a((BroadcastReceiver) objArr[0], (IntentFilter) objArr[1]);
                    return null;
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("rgwsr".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    com.mob.tools.a.c.a(this.a).b().a((BlockingQueue<Boolean>) objArr[0]);
                    return null;
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("sysvsaf".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    try {
                        return this.a.getSystemService((String) objArr[0]);
                    } catch (Throwable th) {
                        MobLog.getInstance().w(th);
                        return null;
                    }
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gaplcn".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aM();
            }
            if ("qritsvc".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return com.mob.tools.a.c.a(this.a).b().a((Intent) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("rsaciy".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return com.mob.tools.a.c.a(this.a).b().b((Intent) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpgif".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return com.mob.tools.a.c.a(this.a).b().a(false, 0, (String) objArr[0], ((Integer) objArr[1]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpgiffcin".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return com.mob.tools.a.c.a(this.a).b().a(((Boolean) objArr[0]).booleanValue(), 0, (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gpgifstrg".equals(str)) {
                if (objArr != null && objArr.length == 3) {
                    return com.mob.tools.a.c.a(this.a).b().a(false, ((Integer) objArr[0]).intValue(), (String) objArr[1], ((Integer) objArr[2]).intValue());
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("giads".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().au();
            }
            if ("hdstipu".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    com.mob.tools.a.c.a(this.a).b().a((View) objArr[0]);
                    return null;
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("swstin".equals(str)) {
                if (objArr != null && objArr.length == 1) {
                    com.mob.tools.a.c.a(this.a).b().b((View) objArr[0]);
                    return null;
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("gdvda".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aN();
            }
            if ("gdvdtnas".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aO();
            }
            if ("bsasm".equals(str)) {
                if (objArr != null && objArr.length == 2) {
                    return com.mob.tools.a.c.a(this.a).b().a((String) objArr[0], (String) objArr[1]);
                }
                throw new Throwable("params illegal: " + objArr);
            }
            if ("crtavthd".equals(str)) {
                return com.mob.tools.a.c.a(MobSDK.getContext()).b().aL();
            }
            if ("galtut".equals(str)) {
                return Long.valueOf(com.mob.tools.a.c.a(this.a).b().aP());
            }
            if ("gbrdm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aQ();
            }
            if ("gdvme".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aR();
            }
            if ("gdpyd".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aS();
            }
            if ("gfgrnt".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aT();
            }
            if ("grivsn".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aU();
            }
            if ("gcrup".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aV();
            }
            if ("gcifm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aW();
            }
            if ("godm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aX();
            }
            if ("godhm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aY();
            }
            if ("gadm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().aZ();
            }
            if ("gvdm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().ba();
            }
            if ("gudm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().bb();
            }
            if ("galdm".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().bc();
            }
            if ("gtaif".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().bd();
            }
            if ("gtaifok".equals(str)) {
                return com.mob.tools.a.c.a(this.a).b().be();
            }
            if (!"gtaifprm".equals(str)) {
                return null;
            }
            if (objArr != null && objArr.length == 2) {
                return com.mob.tools.a.c.a(this.a).b().a((String) objArr[0], ((Integer) objArr[1]).intValue());
            }
            throw new Throwable("params illegal: " + objArr);
        }
    }

    public static RequestBuilder requester(Context context) {
        return new RequestBuilder(context);
    }

    public static class SyncMtd {
        public static String Base64AES(String str, String str2) {
            return com.mob.tools.a.b.a(MobSDK.getContext()).a(str, str2);
        }

        public static boolean checkPermission(String str) throws Throwable {
            return com.mob.tools.a.b.a(MobSDK.getContext()).f(str);
        }

        public static Object currentActivityThread() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aL();
        }

        public static String getAppLanguage() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().ac();
        }

        public static int getAppVersion() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aG();
        }

        public static String getAppVersionName() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aH();
        }

        public static Context getApplication() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aM();
        }

        public static String getBrand() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().A();
        }

        public static String getCurrentProcessName() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aJ();
        }

        public static String getManufacturer() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().z();
        }

        public static String getModel() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().y();
        }

        public static String getOSCountry() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().T();
        }

        public static String getOSLanguage() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().S();
        }

        public static int getOSVersionInt() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().Q();
        }

        public static String getOSVersionName() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().R();
        }

        public static String getPackageName() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aE();
        }

        public static int getPlatformCode() {
            return 1;
        }

        public static String getSandboxPath() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aC();
        }

        public static Object getSystemServiceSafe(String str) {
            try {
                return MobSDK.getContext().getSystemService(str);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                return null;
            }
        }

        public static String getTimezone() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().ak();
        }

        public static void hideSoftInput(View view) {
            Object systemServiceSafe = getSystemServiceSafe("input_method");
            if (systemServiceSafe == null) {
                return;
            }
            ((InputMethodManager) systemServiceSafe).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
            try {
                return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return null;
            }
        }

        public static Object invokeRuntimeExec(String str) throws Throwable {
            return ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(com.mob.commons.a.d.a("017Jigeg3k>egfmfeegelggfmhfedelQe[efNmj")), com.mob.commons.a.d.a("010_gg7je.hfedel(e4efWmj"), new Object[0]), com.mob.commons.a.d.a("004j em4j'eh"), new Object[]{str}, new Class[]{String.class});
        }

        public static boolean isGooglePlayServicesAvailable() {
            return com.mob.tools.a.b.a(MobSDK.getContext()).B();
        }

        public static boolean isInMainProcess() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().aI();
        }

        public static boolean isSensitiveDevice() {
            return com.mob.tools.a.c.a(MobSDK.getContext()).b().k();
        }

        public static void regReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) throws Throwable {
            com.mob.tools.a.b.a(MobSDK.getContext()).a(broadcastReceiver, intentFilter);
        }

        public static void showSoftInput(View view) {
            Object systemServiceSafe = getSystemServiceSafe("input_method");
            if (systemServiceSafe == null) {
                return;
            }
            ((InputMethodManager) systemServiceSafe).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
        }

        public static void unregReceiver(BroadcastReceiver broadcastReceiver) throws Throwable {
            com.mob.tools.a.b.a(MobSDK.getContext()).a(broadcastReceiver);
        }

        public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
            try {
                return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
                return null;
            }
        }
    }
}
