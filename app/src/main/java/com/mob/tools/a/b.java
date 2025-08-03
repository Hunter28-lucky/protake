package com.mob.tools.a;

import android.app.ActivityManager;
import android.app.Application;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.blink.academy.film.stream.FinderManager;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.mob.MobSDK;
import com.mob.commons.C5340r;
import com.mob.commons.n;
import com.mob.commons.q;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.NtFetcher;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.umeng.umcrash.BuildConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class b {
    private static b b;
    private Context a;

    /* renamed from: e, reason: collision with root package name */
    private String f17711e;
    private long c = 0;
    private String d = null;
    private int f = -1;

    public class a implements ServiceConnection {
        public boolean a;
        private final BlockingQueue<IBinder> c;

        private a() {
            this.a = false;
            this.c = new LinkedBlockingQueue();
        }

        public IBinder a() throws InterruptedException {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.c.poll(1500L, TimeUnit.MILLISECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private b(Context context) {
        this.a = context.getApplicationContext();
    }

    public static Object V() {
        return C5340r.c();
    }

    public static Context W() {
        return C5340r.b();
    }

    private boolean aZ() {
        try {
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        if (new File(n.b("025fKefchef*chkf>ce8ddfIdgcbCdh(cgcbef_h[cgdkceHd;ci")).exists()) {
            return true;
        }
        String[] strArr = {n.b("012fgBce3cUce0f,dcdbcfcedcLf"), n.b("016fgQce0cMce_f]dcdbcfcedc]fAebcdcj6f"), n.b("017fgZceUc6ce^f2dcdbcfcedc0f@ckebcdcj2f"), n.b("006fNefebcdcjCf"), n.b("008f7efcbIfTebcdcj@f"), n.b("012f>efchefCchkfSebcdcjLf"), n.b("017f@efchefDchkfXebcdcj(f>dkYh'ck,cf"), n.b("021fRefchef9chkf0ebcdcj;f@egcecddcefceegLhf"), n.b("016f%efchef6chkfSefHgf0ckebcdcj$f"), n.b("025fPefchefNchkf*cbefcgGf,ec0h3ghcj:hhgEghcgdbdbPcf"), n.b("013fIefchefAchkfWckebcdcj$f"), n.b("013fLefchef?chkf4efebcdcjEf"), n.b("012fih,cjZg*dbcgDf?ebcdcjFf"), n.b("006f(cfcecf,bh"), n.b("005fg ceVc8ce"), n.b("004fghi")};
        for (int i = 0; i < 16; i++) {
            if (new File(strArr[i], n.b("002Lefcb")).exists()) {
                return true;
            }
        }
        for (int i2 = 0; i2 < 16; i2++) {
            if (new File(strArr[i2], n.b("007%ebcbefchebdbck")).exists()) {
                return true;
            }
        }
        for (int i3 = 0; i3 < 16; i3++) {
            if (new File(strArr[i3], n.b("006kSceeecdefci")).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ba() throws Throwable {
        String strI = I();
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        return Data.byteToHex(Data.SHA1(strI));
    }

    public String A() {
        return a(false);
    }

    public boolean B() {
        if (this.f == -1) {
            try {
            } catch (Throwable th) {
                MobLog.getInstance().d(th);
            }
            int i = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this.a) == 0 ? 1 : 0;
            this.f = i;
        }
        return this.f == 1;
    }

    public String C() {
        return this.a.getPackageName();
    }

    public String D() {
        try {
            ApplicationInfo applicationInfo = this.a.getApplicationInfo();
            String str = applicationInfo.name;
            if (str != null) {
                if (Build.VERSION.SDK_INT < 25 || str.endsWith(".*")) {
                    return str;
                }
                try {
                    ReflectHelper.importClass(str);
                    str = null;
                } catch (Throwable unused) {
                }
            }
            int i = applicationInfo.labelRes;
            if (i <= 0) {
                return String.valueOf(applicationInfo.nonLocalizedLabel);
            }
            try {
                return this.a.getString(i);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                return str;
            }
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return "";
        }
    }

    public int E() {
        try {
            PackageInfo packageInfoA = c.a(this.a).b().a(false, 0, C(), 0);
            return Build.VERSION.SDK_INT >= 28 ? (int) packageInfoA.getLongVersionCode() : packageInfoA.versionCode;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 0;
        }
    }

    public String F() {
        try {
            return c.a(this.a).b().a(false, 0, C(), 0).versionName;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return BuildConfig.VERSION_NAME;
        }
    }

    public ArrayList<String> G() {
        return new ArrayList<>();
    }

    public String H() {
        try {
            return (Build.VERSION.SDK_INT < 29 || this.a.getApplicationInfo().targetSdkVersion < 29 || !"mounted".equals(Environment.getExternalStorageState())) ? this.a.getFilesDir().getAbsolutePath() : this.a.getExternalFilesDir(null).getAbsolutePath();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String I() throws Throwable {
        if (q.a) {
            return null;
        }
        MobLog.getInstance().d(n.b("002Nce(g"), new Object[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Throwable("Do not call this function from the main thread !");
        }
        Intent intent = new Intent(n.b("051Xcfdb9k?dkeedbdbeedc-h2dkcecj7g;cgdbcdCgBdkee^k$efdkceAgOefdkcdJgh4cjYcAcdegcd<h4cgdkef[h(cgIiGcdcfHh=dkdgdhdifddh"));
        intent.setPackage(n.b("022_cfdb[k*dkeedbdbeedcKh%dkcecjQg>cgdbcd(gHdkeePk.ef"));
        a aVar = new a();
        try {
            this.a.bindService(intent, aVar, 1);
            IBinder iBinderA = aVar.a();
            if (iBinderA != null) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken(n.b("068 cfdb3kZdkeedbdbeedc*hDdkcecj1g!cgdbcd:g?dkeePk?efdkce8g1efdkcd(gh3cjWcEcdegcd!h=cgdkcdcjLch0cgcjcedcdkdfdiDgihMcg^c>cdefcdcjeedfNgLdg;h_cg'iKcdcf*h"));
                iBinderA.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public synchronized String J() {
        return null;
    }

    public synchronized String[] K() {
        return null;
    }

    public int L() {
        return -1;
    }

    public int M() {
        return -1;
    }

    public int N() {
        return -1;
    }

    public int O() {
        return -1;
    }

    public int P() {
        return -1;
    }

    public int Q() {
        return -1;
    }

    public int R() {
        return -1;
    }

    public int S() {
        return -1;
    }

    public ArrayList<HashMap<String, Object>> T() {
        return null;
    }

    public String U() {
        String strB = n.b("0096dddeehfcejdfdefceh");
        try {
            UiModeManager uiModeManager = (UiModeManager) d("uimode");
            if (uiModeManager != null) {
                switch (uiModeManager.getCurrentModeType()) {
                    case 1:
                        strB = n.b("005 deekccdddf");
                        break;
                    case 2:
                        strB = n.b("004Fehfcdggi");
                        break;
                    case 3:
                        strB = n.b("003Tffdifd");
                        break;
                    case 4:
                        strB = n.b("010-dhfcdjfcfedfdgdfekde");
                        break;
                    case 5:
                        strB = n.b("009Odifgfgdjdfdidefffc");
                        break;
                    case 6:
                        strB = n.b("005Rgbdidhffgc");
                        break;
                    case 7:
                        strB = n.b("009Bfefdgcfcdiehdgfcdh");
                        break;
                    default:
                        strB = n.b("009Rdddeehfcejdfdefceh");
                        break;
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return strB;
    }

    public HashMap<String, Object> X() {
        return null;
    }

    public ArrayList<HashMap<String, Object>> Y() {
        return null;
    }

    public boolean Z() {
        return false;
    }

    public String aA() {
        try {
            return b(n.b("0176cgdbdkebdbcecgKg[dkNdTdcceRcBegdbcgLk"));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public int aB() {
        return NtFetcher.getInstance(this.a).getDtNtType();
    }

    public String aC() {
        try {
            String string = Settings.Secure.getString(this.a.getContentResolver(), "default_input_method");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            return string.split(n.b("001f"))[0];
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public HashMap<String, Object> aD() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            String strAC = aC();
            map.put(n.b("004RcjceTkh"), e(strAC));
            map.put(n.b("003d5ciee"), strAC);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return map;
    }

    public ArrayList<HashMap<String, Object>> aE() {
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        try {
            for (InputMethodInfo inputMethodInfo : ((InputMethodManager) d("input_method")).getInputMethodList()) {
                if (inputMethodInfo != null) {
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(n.b("004Scjce2kh"), inputMethodInfo.loadLabel(this.a.getPackageManager()));
                    map.put(n.b("003d ciee"), inputMethodInfo.getPackageName());
                    arrayList.add(map);
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return arrayList;
    }

    public String aF() {
        return Build.BRAND;
    }

    public boolean aG() {
        com.mob.tools.utils.g gVar;
        int i;
        try {
            gVar = new com.mob.tools.utils.g();
            i = gVar.a(this.a) == 1 ? 1 : 0;
            if (gVar.b(this.a) == 1) {
                i++;
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (i >= 2) {
            return true;
        }
        if (gVar.c(this.a) == 1) {
            i++;
        }
        if (i >= 2) {
            return true;
        }
        if (gVar.d(this.a) == 1) {
            i++;
        }
        if (i >= 2) {
            return true;
        }
        if (gVar.e(this.a) == 1) {
            i++;
        }
        if (i >= 2 || i >= 2) {
            return true;
        }
        if (gVar.f(this.a) == 1) {
            i++;
        }
        if (i >= 2) {
            return true;
        }
        if (gVar.g(this.a) == 1) {
            i++;
        }
        if (i >= 2) {
            return true;
        }
        if (gVar.a() == 1) {
            i++;
        }
        return i >= 2 || i >= 2;
    }

    public HashMap<String, Object> aH() {
        BufferedReader bufferedReader;
        Throwable th;
        HashMap<String, Object> map = new HashMap<>();
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(n.b("013fd!cgdbcf?fkhkKcdcjegdb")));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        String[] strArrSplit = line.split("\\s+");
                        if (strArrSplit != null && strArrSplit.length > 1) {
                            String str = strArrSplit[0];
                            long j = Long.parseLong(strArrSplit[1]) * ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS;
                            if ("MemTotal:".equals(str)) {
                                map.put(n.b("015cKdb%c@cedcfh+hk:dbcgchdgcdfb'h"), Long.valueOf(j));
                            } else if (n.b("008Ffh2hk]ejcg.hhe").equals(str)) {
                                map.put(n.b("014<egcg hhIfhNhk1dbcgchdgcdfb:h"), Long.valueOf(j));
                            } else if (n.b("013Ifh,hkOdiSi5cecddcceebdc;he").equals(str)) {
                                map.put(n.b("019Gce^iBcecddcceebdc3h!fhVhk8dbcgchdgcdfbVh"), Long.valueOf(j));
                            } else if (n.b("007:dicf]c>cdVihe").equals(str)) {
                                map.put(n.b("016Kcecf%c$cd(ih=fh?hk8dbcgchdgcdfbHh"), Long.valueOf(j));
                            } else if ("Inactive:".equals(str)) {
                                map.put(n.b("018YcdcjcecfAc(cd+ih;fh-hkTdbcgchdgcdfb(h"), Long.valueOf(j));
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            MobLog.getInstance().d(th);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return map;
                        } catch (Throwable th3) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th4) {
                                    MobLog.getInstance().d(th4);
                                }
                            }
                            throw th3;
                        }
                    }
                }
                bufferedReader.close();
            } catch (Throwable th5) {
                bufferedReader = null;
                th = th5;
            }
        } catch (Throwable th6) {
            MobLog.getInstance().d(th6);
        }
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean aI() {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = r6.e()     // Catch: java.lang.Throwable -> L36
            java.lang.String r2 = r6.ah()     // Catch: java.lang.Throwable -> L36
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L36
            r4 = 1
            if (r3 != 0) goto L25
            int r3 = r2.length()     // Catch: java.lang.Throwable -> L36
            r5 = 3
            if (r3 < r5) goto L25
            java.lang.String r2 = r2.substring(r4)     // Catch: java.lang.Throwable -> L36
            int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Throwable -> L25
            r3 = 12
            if (r2 < r3) goto L25
            r2 = r4
            goto L26
        L25:
            r2 = r0
        L26:
            java.lang.String r3 = "006-ckcdcedb-kEcd"
            java.lang.String r3 = com.mob.commons.n.b(r3)     // Catch: java.lang.Throwable -> L36
            boolean r1 = r3.equalsIgnoreCase(r1)     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L48
            if (r2 == 0) goto L48
            r0 = r4
            goto L48
        L36:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            if (r1 != 0) goto L3f
            java.lang.String r1 = ""
        L3f:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            java.lang.Object[] r3 = new java.lang.Object[r0]
            r2.d(r1, r3)
        L48:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.a.b.aI():boolean");
    }

    public boolean aJ() {
        return b(this.a) != 0;
    }

    public String aK() {
        String processName = "";
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
            } else {
                Method declaredMethod = Class.forName(n.b("026FcecjWgAcgdbcd!gBdkce>dd%dkdicf5c!cdBiLcd!c[chdh1bVcg.hCce]g"), false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(null, new Object[0]);
                if (objInvoke instanceof String) {
                    processName = (String) objInvoke;
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d("MobPush getProcessName: " + th, new Object[0]);
        }
        return processName;
    }

    public long aL() {
        try {
            return c.a(this.a).b().a(false, 0, C(), 0).lastUpdateTime;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return 0L;
        }
    }

    public String aM() {
        return Build.BOARD;
    }

    public String aN() {
        return Build.DEVICE;
    }

    public String aO() {
        return Build.DISPLAY;
    }

    public String aP() {
        return Build.FINGERPRINT;
    }

    public String aQ() {
        return Build.getRadioVersion();
    }

    public String aR() {
        Object objA;
        try {
            try {
                objA = a(n.b("0214cfce:c?hbIfd-cgdbcf[f>ef!h_dceg<fJcfeecgdbcb>d"));
            } catch (Throwable th) {
                th = th;
                objA = null;
            }
        } catch (Throwable unused) {
        }
        try {
            InputStream inputStream = (InputStream) ReflectHelper.invokeInstanceMethod(objA, n.b("014BeeYhc>dfcj$d=cbGcOdgFcDcg^hRceXk"), new Object[0]);
            line = inputStream != null ? new BufferedReader(new InputStreamReader(inputStream)).readLine() : null;
        } catch (Throwable th2) {
            th = th2;
            try {
                MobLog.getInstance().d(th);
                if (objA != null) {
                    ReflectHelper.invokeInstanceMethod(objA, n.b("007gh0efZcQcgdbch"), new Object[0]);
                }
                return line;
            } catch (Throwable th3) {
                if (objA != null) {
                    try {
                        ReflectHelper.invokeInstanceMethod(objA, n.b("007gh0efZcQcgdbch"), new Object[0]);
                    } catch (Throwable unused2) {
                    }
                }
                throw th3;
            }
        }
        if (objA != null) {
            ReflectHelper.invokeInstanceMethod(objA, n.b("007gh0efZcQcgdbch"), new Object[0]);
        }
        return line;
    }

    public String aS() {
        Object objA = null;
        try {
            try {
                objA = a(n.b("017Kcfce@cThbLfd*cgdbcf[f'cfQd:cbcdcjegdb"));
                InputStream inputStream = (InputStream) ReflectHelper.invokeInstanceMethod(objA, n.b("014Dee7hc[dfcjYdRcbUc<dg[cEcgIhYce'k"), new Object[0]);
                if (inputStream == null) {
                    if (objA == null) {
                        return "";
                    }
                    ReflectHelper.invokeInstanceMethod(objA, n.b("007gh-efAcScgdbch"), new Object[0]);
                    return "";
                }
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    stringBuffer.append(line);
                }
                bufferedReader.close();
                String lowerCase = stringBuffer.toString().toLowerCase();
                if (objA != null) {
                    try {
                        ReflectHelper.invokeInstanceMethod(objA, n.b("007gh-efAcScgdbch"), new Object[0]);
                    } catch (Throwable unused) {
                    }
                }
                return lowerCase;
            } catch (Throwable unused2) {
                return "";
            }
        } catch (Throwable th) {
            try {
                MobLog.getInstance().d(th);
                if (objA == null) {
                    return "";
                }
                ReflectHelper.invokeInstanceMethod(objA, n.b("007gh-efAcScgdbch"), new Object[0]);
                return "";
            } catch (Throwable th2) {
                if (objA != null) {
                    try {
                        ReflectHelper.invokeInstanceMethod(objA, n.b("007gh-efAcScgdbch"), new Object[0]);
                    } catch (Throwable unused3) {
                    }
                }
                throw th2;
            }
        }
    }

    public String aT() {
        return com.mob.commons.b.b.c(this.a);
    }

    public String aU() {
        return com.mob.commons.b.b.d(this.a);
    }

    public String aV() {
        return com.mob.commons.b.b.e(this.a);
    }

    public String aW() {
        return com.mob.commons.b.b.g(this.a);
    }

    public String aX() {
        return com.mob.commons.b.b.f(this.a);
    }

    public HashMap<String, Object> aY() {
        return com.mob.commons.b.b.a(this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
    
        r3.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
    
        if (r5 == null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> aa() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "013fdWcgdbcf)fFcf?d*cbcdcjegdb"
            java.lang.String r2 = com.mob.commons.n.b(r2)     // Catch: java.lang.Throwable -> L87
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L87
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L87
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L87
            r3.<init>()     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = "010dScgdbcfShDefefdbcgef"
            java.lang.String r4 = com.mob.commons.n.b(r4)     // Catch: java.lang.Throwable -> L87
            r0.put(r4, r3)     // Catch: java.lang.Throwable -> L87
            r4 = 0
        L24:
            r5 = r4
        L25:
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> L87
            if (r6 == 0) goto L80
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> L87
            if (r7 == 0) goto L37
            if (r5 == 0) goto L24
            r3.add(r5)     // Catch: java.lang.Throwable -> L87
            goto L24
        L37:
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L87
            java.lang.String r7 = "009dUcgdbcf:hOefefdbcg"
            java.lang.String r7 = com.mob.commons.n.b(r7)     // Catch: java.lang.Throwable -> L87
            boolean r7 = r6.startsWith(r7)     // Catch: java.lang.Throwable -> L87
            if (r7 == 0) goto L51
            if (r5 == 0) goto L4c
            r3.add(r5)     // Catch: java.lang.Throwable -> L87
        L4c:
            java.util.HashMap r5 = new java.util.HashMap     // Catch: java.lang.Throwable -> L87
            r5.<init>()     // Catch: java.lang.Throwable -> L87
        L51:
            java.lang.String r7 = ":"
            java.lang.String[] r6 = r6.split(r7)     // Catch: java.lang.Throwable -> L87
            if (r6 == 0) goto L25
            int r7 = r6.length     // Catch: java.lang.Throwable -> L87
            r8 = 1
            if (r7 <= r8) goto L25
            r7 = 0
            if (r5 != 0) goto L70
            r7 = r6[r7]     // Catch: java.lang.Throwable -> L87
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Throwable -> L87
            r6 = r6[r8]     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L87
            r0.put(r7, r6)     // Catch: java.lang.Throwable -> L87
            goto L25
        L70:
            r7 = r6[r7]     // Catch: java.lang.Throwable -> L87
            java.lang.String r7 = r7.trim()     // Catch: java.lang.Throwable -> L87
            r6 = r6[r8]     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.trim()     // Catch: java.lang.Throwable -> L87
            r5.put(r7, r6)     // Catch: java.lang.Throwable -> L87
            goto L25
        L80:
            r2.close()     // Catch: java.lang.Throwable -> L87
            r1.close()     // Catch: java.lang.Throwable -> L87
            goto L8f
        L87:
            r1 = move-exception
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
            r2.d(r1)
        L8f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.a.b.aa():java.util.HashMap");
    }

    public ArrayList<ArrayList<String>> ab() {
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT < 28) {
            try {
                FileReader fileReader = new FileReader(n.b("017fd>cgdbcf$fcc5chLfgGcgcd5ih1cgef"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!TextUtils.isEmpty(line)) {
                        String[] strArrSplit = line.trim().split(MyUTIL.white_space);
                        if (strArrSplit.length > 1) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            for (String str : strArrSplit) {
                                if (!TextUtils.isEmpty(str)) {
                                    arrayList2.add(str.trim());
                                }
                            }
                            arrayList.add(arrayList2);
                        }
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (Throwable th) {
                MobLog.getInstance().d(th.getMessage(), new Object[0]);
            }
        }
        return arrayList;
    }

    public int ac() {
        try {
            return Settings.System.getInt(this.a.getContentResolver(), "screen_brightness");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    public int ad() {
        try {
            return Settings.System.getInt(this.a.getContentResolver(), "screen_brightness_mode");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return -1;
        }
    }

    public String ae() {
        String strA = k.a(this.a).a().a(n.b("014<cgdbdkci*h(cgcj<h6dcdkTjhk4cb"), "0");
        return strA == null ? "0" : strA;
    }

    public HashMap<String, HashMap<String, Long>> af() {
        HashMap<String, HashMap<String, Long>> map = new HashMap<>();
        String[] strArr = {n.b("006WefZgIcfcecgSg"), n.b("004gPceLc8ce")};
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            HashMap<String, Long> map2 = new HashMap<>();
            map2.put("available", -1L);
            map2.put(n.b("004SegcgHhh"), -1L);
            map2.put(n.b("005c_db!c cedc"), -1L);
            map.put(str, map2);
        }
        HashMap map3 = new HashMap();
        try {
            String strH = H();
            if (strH != null) {
                map3.put(n.b("006Sef(gYcfcecgMg"), new StatFs(strH));
            }
        } catch (Throwable unused) {
        }
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory != null) {
                map3.put(n.b("004gBce:cLce"), new StatFs(dataDirectory.getPath()));
            }
        } catch (Throwable unused2) {
        }
        for (Map.Entry entry : map3.entrySet()) {
            StatFs statFs = (StatFs) entry.getValue();
            long availableBlocksLong = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            long freeBlocksLong = statFs.getFreeBlocksLong() * statFs.getBlockSizeLong();
            long blockCountLong = statFs.getBlockCountLong() * statFs.getBlockSizeLong();
            HashMap<String, Long> map4 = map.get(entry.getKey());
            map4.put("available", Long.valueOf(availableBlocksLong));
            map4.put(n.b("004^egcg-hh"), Long.valueOf(freeBlocksLong));
            map4.put(n.b("005c dbNc-cedc"), Long.valueOf(blockCountLong));
        }
        return map;
    }

    public HashMap<String, Long> ag() {
        HashMap<String, Long> map = new HashMap<>();
        map.put("available", -1L);
        map.put(n.b("005c*dbNc_cedc"), -1L);
        map.put(n.b("0050cdefdjdbec"), -1L);
        map.put(n.b("009cb+cgXhTefNbWdbdc-g"), -1L);
        try {
            Object objD = d(n.b("008%cecfHcHcdOi1cd?cHch"));
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ReflectHelper.invokeInstanceMethod(objD, n.b("0133ee?hcAfh*hkDdbcgchdfcjegdb"), memoryInfo);
            map.put("available", Long.valueOf(memoryInfo.availMem));
            map.put(n.b("005c-db:c2cedc"), Long.valueOf(memoryInfo.totalMem));
            map.put(n.b("005Scdefdjdbec"), Long.valueOf(memoryInfo.lowMemory ? 1L : 0L));
            map.put(n.b("009cbZcgFhXefMb^dbdc8g"), Long.valueOf(memoryInfo.threshold));
        } catch (Throwable unused) {
        }
        return map;
    }

    public String ah() {
        return com.mob.tools.utils.d.a().b();
    }

    public int ai() {
        return -1;
    }

    public boolean aj() throws IOException {
        BufferedReader bufferedReader;
        Throwable th;
        String[] strArr = {n.b("0202cfdbXk,dk$cTdb8d)gedb4b:cjeccbdk[k$ceeecdefci"), n.b("032ghJdkcgdbeb;i!dkcecjTg0cgdbcd_gSdkck5d1dbef9hgVdkcdcjef*c4cedcdc=h0cg"), n.b("028_dbcgeedk[kh'dbeccfce.c7dkXhgXck+d=dbef4hg5dk8kAcecjceee7h.cg"), n.b("027k-dbGhMdkef^b9cdfbcbcicbdkcg@hg;cdcgOh!cf?cHef c>dbcgceeeEh")};
        for (int i = 0; i < 4; i++) {
            if (k.a(this.a).a().b(strArr[i], 0) != null) {
                return true;
            }
        }
        try {
            throw new Exception("test");
        } catch (Throwable th2) {
            for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                if (stackTraceElement.getClassName().contains(n.b("035gh%dkcgdbebIi!dkcecj5g'cgdbcd2g,dkck,d@dbefZhg6dkgf<d!dbefPhgKeicgcdIgNeeEh"))) {
                    return true;
                }
            }
            try {
                try {
                    ClassLoader.getSystemClassLoader().loadClass(n.b("036ghXdkcgdbeb(iOdkcecjZg2cgdbcd,g:dkck$dQdbef9hgQdkgfZd^dbefZhg gcYh6dcEdh[cgef")).newInstance();
                    try {
                        ClassLoader.getSystemClassLoader().loadClass(n.b("035gh=dkcgdbebZiPdkcecj@g@cgdbcdWg9dkck9d!dbef hgQdkgf_d8dbef^hgXeicgcdEg5eeFh")).newInstance();
                    } catch (IllegalAccessException | InstantiationException unused) {
                    }
                    return true;
                } catch (Throwable unused2) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(n.b("006fd1cgdbcfDf") + Process.myPid() + n.b("005fkOce:d<ef")));
                        boolean zContains = false;
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null || zContains) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e2) {
                                        MobLog.getInstance().d(e2);
                                    }
                                    return zContains;
                                }
                                zContains = line.toLowerCase().contains(n.b("006Xck-d6dbef]hg"));
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    MobLog.getInstance().d(th);
                                    return false;
                                } finally {
                                    if (bufferedReader != null) {
                                        try {
                                            bufferedReader.close();
                                        } catch (IOException e3) {
                                            MobLog.getInstance().d(e3);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        bufferedReader = null;
                        th = th4;
                    }
                }
            } catch (IllegalAccessException | InstantiationException unused3) {
                return true;
            }
        }
    }

    public boolean ak() {
        return (this.a.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public boolean al() {
        try {
            return Settings.Secure.getInt(this.a.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean am() {
        try {
            return Settings.Secure.getInt(this.a.getContentResolver(), "development_settings_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean an() {
        try {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
            return (Build.VERSION.SDK_INT < 33 ? (Intent) ReflectHelper.invokeInstanceMethod(this.a, n.b("016Ucg;hZeecdef;ch[cgfdUhQcfBhEcdQihJcg"), new Object[]{null, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class}) : (Intent) ReflectHelper.invokeInstanceMethod(this.a, n.b("0168cg4h eecdef chKcgfd(hGcf3h7cd[ih7cg"), new Object[]{null, intentFilter, 4}, new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE})).getIntExtra("plugged", -1) == 2;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public boolean ao() {
        return false;
    }

    public boolean ap() {
        try {
            return (c.a(this.a).b().a(false, 0, this.a.getPackageName(), 1).applicationInfo.flags & 2) != 0;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public boolean aq() {
        int i;
        try {
            String property = System.getProperty(n.b("014bccd7dk*dXcgdbckchgcdbef?c"));
            String property2 = System.getProperty(n.b("014bccdFdk+d7cgdbckchfgdbcg;c"));
            if (property2 == null) {
                property2 = FinderManager.MACHINE_NOT_VALID;
            }
            try {
                i = Integer.parseInt(property2);
            } catch (Throwable unused) {
                i = -1;
            }
            return (TextUtils.isEmpty(property) || i == -1) ? false : true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public ArrayList<HashMap<String, String>> ar() {
        return null;
    }

    public String as() {
        try {
            String id = TimeZone.getDefault().getID();
            if (!TextUtils.isEmpty(id)) {
                return id;
            }
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            Settings.System.getConfiguration(this.a.getContentResolver(), configuration);
            Locale locale = configuration.locale;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            Calendar calendar = Calendar.getInstance(locale);
            return calendar != null ? calendar.getTimeZone().getID() : id;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public HashMap<String, Object> at() {
        HashMap<String, Object> map = new HashMap<>();
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager != null) {
                try {
                    map.put("mbmt", Boolean.valueOf(packageManager.hasSystemFeature(n.b("026Icecj=g>cgdbcdFg1dkGbUcecgTgWeccecg]h5dk<ch^dcChdb)dbcjch"))));
                } catch (Throwable unused) {
                }
                try {
                    map.put("wmt", Boolean.valueOf(packageManager.hasSystemFeature(n.b("021?cecjGg7cgdbcd^gOdk7bAcecgSgIeccecg7h@dkeccdegcd"))));
                } catch (Throwable unused2) {
                }
                try {
                    map.put("gmt", Boolean.valueOf(packageManager.hasSystemFeature(n.b("029LcecjYgScgdbcd@g8dk$b*cecg2g8eccecg$h!dkdcdbcfceAc cddbcjdkeeNd8ef"))));
                } catch (Throwable unused3) {
                }
                try {
                    map.put("nmt", Boolean.valueOf(packageManager.hasSystemFeature(n.b("020DcecjPg_cgdbcdHgJdk3b8cecg:g:eccecgDh?dkcjegcf"))));
                } catch (Throwable unused4) {
                }
                map.put(n.b("003;db[cPee"), Boolean.valueOf(packageManager.hasSystemFeature(n.b("025 cecjBg[cgdbcd9gUdkEb_cecg[g2eccecgOh'dkcbefebdk]bEdbefCc"))));
            }
        } catch (Throwable unused5) {
        }
        return map;
    }

    public HashMap<String, String> au() {
        HashMap<String, String> map = new HashMap<>();
        String strI = i(n.b("053fQefchefQfghi>cdcf!h=efMf:efchef$chkf^cf dWcb?f@cfRd@cbed^f=cfQdGcbegcgJhjf[efcfcedccdcjeecccfcbcgccegcg;hj"));
        if (!TextUtils.isEmpty(strI)) {
            map.put(n.b("012Hcfcbcgcg_h3cj>c^ff)d cbgcfb"), strI);
        }
        String strI2 = i(n.b("053fWefchef@fghi_cdcf+h%efNfJefchef@chkf<cf*d@cb+f<cf<dJcbedIf1cf1dXcbegcg)hjf'cf5dScbcdcjegdbcc'k[cdcjccegcgLhj"));
        if (!TextUtils.isEmpty(strI2)) {
            map.put(n.b("008kTcdcjffMd9cbgcfb"), strI2);
        }
        String strI3 = i(n.b("053f$efchefAfghiVcdcf]h?ef]f.efchef9chkf*cf%d[cb.f4cf_dLcbedCf.cf8d=cbegcg5hjfDcfKdMcbcdcjegdbcc2kMceckccegcgChj"));
        if (!TextUtils.isEmpty(strI3)) {
            map.put(n.b("008kQceckffLdHcbgcfb"), strI3);
        }
        return map;
    }

    public String av() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public String aw() {
        try {
            return b(n.b("015@cgdbdkebcbcddc<gHdkegdcceSiUdbcg"));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00a3 -> B:47:0x00bb). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.HashMap<java.lang.String, java.lang.Object> ax() {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.a.b.ax():java.util.HashMap");
    }

    public String ay() {
        try {
            return b(n.b("0204eeefKkGdk<ih'cgefcddbcjdkebceef0h@ebcecj^g"));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public String az() {
        try {
            return b(n.b("016;cgdbdk2dGcgdb7gLcbcf+cCdkebdbcecg g"));
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public synchronized String b() {
        return null;
    }

    public synchronized String c() {
        return null;
    }

    public String d() {
        String str = Build.MODEL;
        return !TextUtils.isEmpty(str) ? str.trim() : str;
    }

    public String e() {
        return Build.MANUFACTURER;
    }

    public String f() {
        String strG = g();
        return TextUtils.isEmpty(strG) ? i() : strG;
    }

    public synchronized String g() {
        return null;
    }

    public String g(String str) {
        return null;
    }

    public synchronized String[] h() {
        return null;
    }

    public String i() {
        return null;
    }

    public String i(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(str);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String strTrim = line.trim();
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strTrim);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return sb.toString();
    }

    public String j() {
        try {
            String str = c.a(this.a).b().y() + "|" + l() + "|" + e() + "|" + r() + "|" + q();
            String strA = A();
            if (strA == null) {
                strA = "";
            } else if (strA.length() > 16) {
                strA = strA.substring(0, 16);
            }
            return a(str, strA);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return "";
        }
    }

    public String k() {
        return c.a(this.a).b().y() + "|" + l() + "|" + e() + "|" + r() + "|" + q();
    }

    public int l() {
        return Build.VERSION.SDK_INT;
    }

    public String m() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String n() {
        return Locale.getDefault().getLanguage();
    }

    public String o() {
        return this.a.getResources().getConfiguration().locale.getLanguage();
    }

    public String p() {
        return Locale.getDefault().getCountry();
    }

    public String q() {
        int[] screenSize = ResHelper.getScreenSize(this.a);
        if (this.a.getResources().getConfiguration().orientation == 1) {
            return screenSize[0] + "x" + screenSize[1];
        }
        return screenSize[1] + "x" + screenSize[0];
    }

    public String r() {
        try {
            Object objD = d("phone");
            if (objD == null) {
                return FinderManager.MACHINE_NOT_VALID;
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(objD, n.b("014-ee]hc1dgcdDkNekDdh8cgceTc?dbcg"), new Object[0]);
            return TextUtils.isEmpty(str) ? FinderManager.MACHINE_NOT_VALID : str;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return FinderManager.MACHINE_NOT_VALID;
        }
    }

    public String s() {
        Object objD = d("phone");
        if (objD == null) {
            return null;
        }
        try {
            if (f(n.b("035^cecj1g7cgdbcd)g dk>dhVcg?kKcdefefcddbcjdkfdfcdiehccfggcekdefcccdgdhdidhfc"))) {
                String str = (String) ReflectHelper.invokeInstanceMethod(objD, n.b("018<ee;hc4dgcd7k^ekLdhDcgceCcYdbcgdece+kh"), new Object[0]);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return str;
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
        }
        return null;
    }

    public String t() {
        return FinderManager.MACHINE_NOT_VALID;
    }

    public String u() {
        return null;
    }

    public String v() {
        try {
            return Data.MD5(c.a(this.a).b().a(false, 0, C(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return null;
        }
    }

    public String w() {
        return NtFetcher.getInstance(this.a).getNtType();
    }

    public boolean x() {
        try {
            String strZ = z();
            if (!n.b("004Yeccdegcd").equals(strZ) && !n.b("002>gdee").equals(strZ) && !n.b("0025ihee").equals(strZ) && !n.b("002=ibee").equals(strZ)) {
                if (!n.b("002Gfjee").equals(strZ)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public String y() {
        String lowerCase = w().toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || n.b("004%cjdbcjYh").equals(lowerCase)) ? n.b("004Pcjdbcj2h") : (lowerCase.startsWith(n.b("0028gdee")) || lowerCase.startsWith(n.b("002Fihee")) || lowerCase.startsWith(n.b("0021ibee")) || lowerCase.startsWith(n.b("002Jfjee"))) ? n.b("004_cf'h)dcdc") : lowerCase.startsWith(n.b("004Weccdegcd")) ? n.b("0040eccdegcd") : n.b("005GdbVcbhZcg");
    }

    public String z() {
        try {
            String lowerCase = w().toLowerCase();
            if (!TextUtils.isEmpty(lowerCase) && !n.b("0044cjdbcj,h").equals(lowerCase)) {
                return lowerCase.startsWith(n.b("004Weccdegcd")) ? n.b("004Peccdegcd") : lowerCase.startsWith(n.b("002Cgdee")) ? n.b("002Pgdee") : lowerCase.startsWith(n.b("002=ihee")) ? n.b("002Bihee") : lowerCase.startsWith(n.b("002%ibee")) ? n.b("002<ibee") : lowerCase.startsWith(n.b("002Sfjee")) ? n.b("002;fjee") : lowerCase.startsWith(n.b("009Mebdccb=hcNdbdb4cb")) ? n.b("009Rebdccb@hc)dbdb8cb") : lowerCase;
            }
            return n.b("004UcjdbcjYh");
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return n.b("004Ccjdbcj=h");
        }
    }

    public String b(String str) {
        return k.a(this.a).a().a(str);
    }

    public String c(String str) {
        try {
            return Data.MD5(c.a(this.a).b().a(false, 0, str, 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            MobLog.getInstance().w(e2);
            return null;
        }
    }

    public String e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return c.a(this.a).b().a(false, 0, str, 1).applicationInfo.loadLabel(this.a.getPackageManager()).toString();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public boolean h(String str) {
        try {
            return c.a(this.a).b().a(true, 0, str, 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static synchronized b a(Context context) {
        if (b == null && context != null) {
            b = new b(context);
        }
        return b;
    }

    public void b(View view) {
        Object objD = d("input_method");
        if (objD == null) {
            return;
        }
        ((InputMethodManager) objD).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
    }

    public Object d(String str) {
        try {
            return this.a.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public boolean f(String str) throws Throwable {
        int iIntValue = -1;
        try {
            ReflectHelper.importClass(n.b("023(cecj-g7cgdbcd9g5dkcfdbcjSch4cjGc<dkffdbcj%ch%ck*c"));
            Integer num = (Integer) ReflectHelper.invokeInstanceMethod(this.a, n.b("019GcfNbhAcfcidg!h.dcegfgAhMcg9k?cdefefcddbcj"), str);
            if (num != null) {
                iIntValue = num.intValue();
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        return iIntValue == 0;
    }

    private int b(Context context) {
        try {
            String strAK = aK();
            if (TextUtils.isEmpty(strAK)) {
                return -1;
            }
            return strAK.equals(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).processName) ? 1 : 0;
        } catch (Throwable th) {
            MobLog.getInstance().d("MobPush checkIsInMainProcess: " + th, new Object[0]);
            return -1;
        }
    }

    public boolean a() {
        String str = Build.TAGS;
        return (str != null && str.contains(n.b("009chMefOc?ghciPhRchef"))) || aZ();
    }

    public static Object a(String str) throws Throwable {
        return ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(n.b("017RgeceEi+cedkdccecjeedkfdcbcj7c'cd(kh")), n.b("0103ee^hc2fdcbcjRc^cd%kh"), new Object[0]), n.b("004hRckOh4cf"), new Object[]{str}, new Class[]{String.class});
    }

    public boolean j(String str) {
        try {
            String strImportClass = ReflectHelper.importClass(n.b("037ScecjVg_cgdbcd=g@ckdkcfdbcgPh>dkceYdd]dkdi2ddOek$d0effhcecjceeeTh8cgffdb4kdHce>c"));
            return ((Integer) ReflectHelper.invokeStaticMethod(strImportClass, n.b("011Rcjdb.chWfgcgdbckchek d"), this.a, (String) ReflectHelper.invokeStaticMethod(strImportClass, n.b("014dh*cg3k]cdefefcddbcjdhdbek-d"), str), C())).intValue() == 1;
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return false;
        }
    }

    public String a(String str, String str2) {
        try {
            String strEncodeToString = Base64.encodeToString(Data.AES128Encode(str2, str), 0);
            return strEncodeToString.contains("\n") ? strEncodeToString.replace("\n", "") : strEncodeToString;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public String a(boolean z) {
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        String strA = null;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            if (!TextUtils.isEmpty(this.f17711e)) {
                return this.f17711e;
            }
            String strA2 = a(40);
            this.f17711e = strA2;
            new Thread(new Runnable() { // from class: com.mob.tools.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b bVar = b.this;
                        bVar.d = bVar.ba();
                    } catch (Throwable th) {
                        MobLog.getInstance().d(th);
                    }
                }
            }).start();
            return strA2;
        }
        try {
            strA = ba();
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
        if (TextUtils.isEmpty(strA)) {
            strA = a(40);
        }
        this.d = strA;
        return strA;
    }

    public String a(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jCurrentTimeMillis);
        SecureRandom secureRandom = new SecureRandom();
        for (int i2 = 0; i2 < i; i2++) {
            if (n.b("004*cf5bAcecg").equalsIgnoreCase(n.b(secureRandom.nextInt(2) % 2 == 0 ? "004%cfLb0cecg" : "003JcjcbEk"))) {
                stringBuffer.insert(i2 + 1, (char) (secureRandom.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), secureRandom.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    public ArrayList<HashMap<String, String>> a(boolean z, boolean z2, boolean z3) {
        return new ArrayList<>();
    }

    public void a(View view) {
        Object objD = d("input_method");
        if (objD == null) {
            return;
        }
        ((InputMethodManager) objD).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public Location a(int i, int i2, boolean z) {
        try {
            if (!f(n.b("039=cecj0g*cgdbcdHg=dk^dhMcg6k;cdefefcddbcjdkdifffffcdgdgccejdfdefcccdjekffdidhdfekde")) && (Build.VERSION.SDK_INT < 29 || !f(n.b("045.cecj(g4cgdbcdLg3dkBdh<cgCk[cdefefcddbcjdkdifffffcdgdgcceidiffgigjfdekdddeehccdjekffdidhdfekde")))) {
                return null;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return com.mob.tools.utils.c.a().a(this.a, i, i2, z);
            }
            throw new Throwable("Method 'getLocation' can not be called from Main Thread");
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public void a(final Handler.Callback callback) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.mob.tools.a.b.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    HashMap map = new HashMap();
                    for (String str : intent.getExtras().keySet()) {
                        map.put(str, intent.getExtras().get(str));
                    }
                    if (callback != null) {
                        Message messageObtain = Message.obtain();
                        messageObtain.obj = map;
                        callback.handleMessage(messageObtain);
                    }
                    try {
                        ReflectHelper.invokeInstanceMethod(context, n.b("018@cbcjcgRhYeecdef,chXcgfd;h:cfRh2cd1ih cg"), new Object[]{this}, new Class[]{BroadcastReceiver.class});
                    } catch (Throwable unused) {
                    }
                }
            };
            if (Build.VERSION.SDK_INT < 33) {
                ReflectHelper.invokeInstanceMethod(this.a, n.b("0169cg2hHeecdefAchQcgfdVhBcfKh2cd4ihJcg"), new Object[]{broadcastReceiver, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class});
            } else {
                ReflectHelper.invokeInstanceMethod(this.a, n.b("016QcgHhYeecdefVch5cgfdBhDcf=h;cdKih=cg"), new Object[]{broadcastReceiver, intentFilter, 4}, new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            if (callback != null) {
                callback.handleMessage(Message.obtain());
            }
        }
    }

    private void a(String str, String str2, long[] jArr) {
        try {
            int iIndexOf = str.indexOf(str2);
            if (iIndexOf != -1) {
                Matcher matcher = Pattern.compile(" \\d+ ").matcher(str.substring(iIndexOf));
                int i = 0;
                while (matcher.find()) {
                    if (i == 0) {
                        jArr[0] = Long.parseLong(matcher.group().trim());
                    } else if (i == 8) {
                        jArr[1] = Long.parseLong(matcher.group().trim());
                        return;
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public void a(BroadcastReceiver broadcastReceiver) throws Throwable {
        try {
            ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), n.b("018Dcbcjcg,hYeecdefKchZcgfdAhNcfDhRcdSihAcg"), new Object[]{broadcastReceiver}, new Class[]{BroadcastReceiver.class});
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public void a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) throws Throwable {
        try {
            if (Build.VERSION.SDK_INT < 33) {
                ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), n.b("016Ccg_hJeecdef1ch4cgfdRh0cf]h0cdNih3cg"), new Object[]{broadcastReceiver, intentFilter}, new Class[]{BroadcastReceiver.class, IntentFilter.class});
            } else {
                ReflectHelper.invokeInstanceMethod(MobSDK.getContext(), n.b("016=cgLhQeecdef2chMcgfdOh*cfSh8cd3ih1cg"), new Object[]{broadcastReceiver, intentFilter, 4}, new Class[]{BroadcastReceiver.class, IntentFilter.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }

    public void a(final BlockingQueue<Boolean> blockingQueue) {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.mob.tools.a.b.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    b.this.a(this);
                    if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                        blockingQueue.put(Boolean.TRUE);
                    }
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
            a(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
        }
    }
}
