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
import android.os.Message;
import android.view.View;
import com.mob.MobSDK;
import com.mob.commons.n;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.ReflectHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public class DeviceHelper implements PublicMemberKeeper {
    private static DeviceHelper a = new DeviceHelper();
    private Context b;

    public static Object currentActivityThread() {
        return com.mob.tools.a.c.a(MobSDK.getContext()).b().aL();
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        DeviceHelper deviceHelper = a;
        if (deviceHelper.b == null && context != null) {
            deviceHelper.b = context.getApplicationContext();
        }
        return a;
    }

    public static Object invokeRuntimeExec(String str) throws Throwable {
        return ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod(ReflectHelper.importClass(n.b("0177gece1iPcedkdccecjeedkfdcbcj2cZcd.kh")), n.b("010NeeJhc]fdcbcj cHcdWkh"), new Object[0]), n.b("004hGck-hQcf"), new Object[]{str}, new Class[]{String.class});
    }

    public String Base64AES(String str, String str2) {
        return com.mob.tools.a.c.a(this.b).b().a(str, str2);
    }

    public boolean checkNetworkAvailable() {
        return com.mob.tools.a.c.a(this.b).b().ah();
    }

    public boolean checkPad() {
        return com.mob.tools.a.c.a(this.b).b().c();
    }

    public boolean checkPermission(String str) throws Throwable {
        return com.mob.tools.a.c.a(this.b).b().h(str);
    }

    public boolean checkUA() {
        return com.mob.tools.a.c.a(this.b).b().f();
    }

    public boolean cx() {
        return com.mob.tools.a.c.a(this.b).b().b();
    }

    public boolean debugable() {
        return com.mob.tools.a.c.a(this.b).b().d();
    }

    public boolean devEnable() {
        return com.mob.tools.a.c.a(this.b).b().g();
    }

    public String getAD() {
        return com.mob.tools.a.c.a(this.b).b().aZ();
    }

    public ApplicationInfo getAInfo() {
        return com.mob.tools.a.c.a(this.b).b().bd();
    }

    public HashMap<String, Object> getALLD() {
        return com.mob.tools.a.c.a(this.b).b().bc();
    }

    public String getAdvertisingID() throws Throwable {
        return com.mob.tools.a.c.a(this.b).b().m();
    }

    public int getAlbumCount() {
        return com.mob.tools.a.c.a(this.b).b().ab();
    }

    public String getAppLanguage() {
        return com.mob.tools.a.c.a(this.b).b().ac();
    }

    public long getAppLastUpdateTime() {
        return com.mob.tools.a.c.a(this.b).b().aP();
    }

    public String getAppName() {
        return com.mob.tools.a.c.a(this.b).b().aF();
    }

    public int getAppVersion() {
        return com.mob.tools.a.c.a(this.b).b().aG();
    }

    public String getAppVersionName() {
        return com.mob.tools.a.c.a(this.b).b().aH();
    }

    public Context getApplication() {
        return com.mob.tools.a.c.a(this.b).b().aM();
    }

    public ArrayList<HashMap<String, Object>> getAvailableWifiList() {
        return com.mob.tools.a.c.a(this.b).b().O();
    }

    public ArrayList<HashMap<String, Object>> getAvailableWifiListOneKey() {
        return com.mob.tools.a.c.a(this.b).b().be();
    }

    public String getBaseband() {
        return com.mob.tools.a.c.a(this.b).b().aq();
    }

    public void getBatteryState(final ReflectHelper.a<HashMap<String, Object>, Void> aVar) {
        if (aVar != null) {
            com.mob.tools.a.c.a(this.b).b().a(new Handler.Callback() { // from class: com.mob.tools.utils.DeviceHelper.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    aVar.a((HashMap) message.obj);
                    return false;
                }
            });
        }
    }

    public String getBluetoothName() {
        return com.mob.tools.a.c.a(this.b).b().D();
    }

    public String getBoard() {
        return com.mob.tools.a.c.a(this.b).b().aQ();
    }

    public String getBoardFromSysProperty() {
        return com.mob.tools.a.c.a(this.b).b().ar();
    }

    public String getBoardPlatform() {
        return com.mob.tools.a.c.a(this.b).b().as();
    }

    public String getBrand() {
        return com.mob.tools.a.c.a(this.b).b().A();
    }

    public String getBssid() {
        return com.mob.tools.a.c.a(this.b).b().s();
    }

    public String getCInfo() {
        return com.mob.tools.a.c.a(this.b).b().aW();
    }

    public HashMap<String, String> getCPUFreq() {
        return com.mob.tools.a.c.a(this.b).b().am();
    }

    public HashMap<String, Object> getCPUInfo() {
        return com.mob.tools.a.c.a(this.b).b().U();
    }

    public String getCPUType() {
        return com.mob.tools.a.c.a(this.b).b().an();
    }

    public ArrayList<HashMap<String, String>> getCamResolution() {
        return com.mob.tools.a.c.a(this.b).b().aj();
    }

    public String getCarrier() {
        return getCarrier(false);
    }

    public String getCarrierName() {
        return getCarrierName(false);
    }

    public int getCdmaBid() {
        return com.mob.tools.a.c.a(this.b).b().J();
    }

    public int getCdmaLat() {
        return com.mob.tools.a.c.a(this.b).b().H();
    }

    public int getCdmaLon() {
        return com.mob.tools.a.c.a(this.b).b().I();
    }

    public int getCdmaNid() {
        return com.mob.tools.a.c.a(this.b).b().L();
    }

    public int getCdmaSid() {
        return com.mob.tools.a.c.a(this.b).b().K();
    }

    public int getCellId() {
        return com.mob.tools.a.c.a(this.b).b().E();
    }

    public int getCellLac() {
        return com.mob.tools.a.c.a(this.b).b().F();
    }

    public String getCgroup() {
        return com.mob.tools.a.c.a(this.b).b().aV();
    }

    public String getCurrentProcessName() {
        return com.mob.tools.a.c.a(this.b).b().aJ();
    }

    public HashMap<String, Object> getCurrentWifiInfo() {
        return com.mob.tools.a.c.a(this.b).b().N();
    }

    public int getDataNtType() {
        return com.mob.tools.a.c.a(this.b).b().ai();
    }

    public HashMap<String, Object> getDefaultIM() {
        return com.mob.tools.a.c.a(this.b).b().aA();
    }

    public String getDefaultIMPkg() {
        return com.mob.tools.a.c.a(this.b).b().az();
    }

    public String getDefaultResolvePkg(String str) {
        return com.mob.tools.a.c.a(this.b).b().c(str);
    }

    public String getDetailNetworkTypeForStatic() {
        return com.mob.tools.a.c.a(this.b).b().ag();
    }

    public String getDeviceData() {
        return com.mob.tools.a.c.a(this.b).b().aN();
    }

    public String getDeviceDataNotAES() {
        return com.mob.tools.a.c.a(this.b).b().aO();
    }

    public String getDeviceId() {
        return com.mob.tools.a.c.a(this.b).b().ax();
    }

    public String getDeviceKey() {
        return com.mob.tools.a.c.a(this.b).b().ay();
    }

    public HashMap<String, Object> getDeviceMemUsage() {
        return com.mob.tools.a.c.a(this.b).b().at();
    }

    public String getDeviceName() {
        return com.mob.tools.a.c.a(this.b).b().aR();
    }

    public String getDeviceType() {
        return com.mob.tools.a.c.a(this.b).b().B();
    }

    public String getDisplayId() {
        return com.mob.tools.a.c.a(this.b).b().aS();
    }

    public String getFingerprint() {
        return com.mob.tools.a.c.a(this.b).b().aT();
    }

    public String getFlavor() {
        return com.mob.tools.a.c.a(this.b).b().ao();
    }

    public ArrayList<HashMap<String, String>> getIA(boolean z) {
        return com.mob.tools.a.c.a(this.b).b().f(z);
    }

    public String getIMEI() {
        return com.mob.tools.a.c.a(this.b).b().n();
    }

    public ArrayList<HashMap<String, Object>> getIMList() {
        return com.mob.tools.a.c.a(this.b).b().aB();
    }

    public String getIMSI() {
        return com.mob.tools.a.c.a(this.b).b().p();
    }

    public String getIPAddress() {
        return com.mob.tools.a.c.a(this.b).b().au();
    }

    public Location getLocation(int i, int i2, boolean z) {
        return com.mob.tools.a.c.a(this.b).b().a(i, i2, z);
    }

    public String getMIUIVersion() {
        return com.mob.tools.a.c.a(this.b).b().w();
    }

    public String getManufacturer() {
        return com.mob.tools.a.c.a(this.b).b().z();
    }

    public HashMap<String, Long> getMemoryInfo() {
        return com.mob.tools.a.c.a(this.b).b().aa();
    }

    public String getModel() {
        return com.mob.tools.a.c.a(this.b).b().y();
    }

    public ArrayList<HashMap<String, Object>> getNeighboringCellInfo() {
        return com.mob.tools.a.c.a(this.b).b().M();
    }

    public String getNetworkType() {
        return com.mob.tools.a.c.a(this.b).b().ae();
    }

    public String getNetworkTypeForStatic() {
        return com.mob.tools.a.c.a(this.b).b().af();
    }

    public String getOD() {
        return com.mob.tools.a.c.a(this.b).b().aX();
    }

    public String getODH() {
        return com.mob.tools.a.c.a(this.b).b().aY();
    }

    public String getOSCountry() {
        return com.mob.tools.a.c.a(this.b).b().T();
    }

    public String getOSLanguage() {
        return com.mob.tools.a.c.a(this.b).b().S();
    }

    public int getOSVersionInt() {
        return com.mob.tools.a.c.a(this.b).b().Q();
    }

    public String getOSVersionName() {
        return com.mob.tools.a.c.a(this.b).b().R();
    }

    public PackageInfo getPInfo(String str, int i) {
        return com.mob.tools.a.c.a(this.b).b().a(false, 0, str, i);
    }

    public String getPackageName() {
        return com.mob.tools.a.c.a(this.b).b().aE();
    }

    public int getPlatformCode() {
        return 1;
    }

    public int getPsc() {
        return com.mob.tools.a.c.a(this.b).b().G();
    }

    public String getQemuKernel() {
        return com.mob.tools.a.c.a(this.b).b().Y();
    }

    public String getRadioVersion() {
        return com.mob.tools.a.c.a(this.b).b().aU();
    }

    public List<String> getResolvePkgs(String str) {
        return com.mob.tools.a.c.a(this.b).b().d(str);
    }

    public ArrayList<HashMap<String, String>> getSA() {
        return com.mob.tools.a.c.a(this.b).b().aw();
    }

    public String getSSID() {
        return com.mob.tools.a.c.a(this.b).b().r();
    }

    public int getScreenBrightness() {
        return com.mob.tools.a.c.a(this.b).b().W();
    }

    public int getScreenBrightnessMode() {
        return com.mob.tools.a.c.a(this.b).b().X();
    }

    public String getScreenSize() {
        return com.mob.tools.a.c.a(this.b).b().ad();
    }

    public String getSdcardPath() {
        return com.mob.tools.a.c.a(this.b).b().aC();
    }

    public boolean getSdcardState() {
        return false;
    }

    public String getSerialno() {
        return com.mob.tools.a.c.a(this.b).b().l();
    }

    public String getSignMD5() {
        return com.mob.tools.a.c.a(this.b).b().aD();
    }

    public String getSimSerialNumber() {
        return com.mob.tools.a.c.a(this.b).b().v();
    }

    public HashMap<String, HashMap<String, Long>> getSizeInfo() {
        return com.mob.tools.a.c.a(this.b).b().Z();
    }

    public HashMap<String, Object> getSupport() {
        return com.mob.tools.a.c.a(this.b).b().al();
    }

    public String getSystemProperties(String str) {
        return com.mob.tools.a.c.a(this.b).b().b(str);
    }

    public Object getSystemServiceSafe(String str) {
        try {
            return this.b.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public ArrayList<ArrayList<String>> getTTYDriversInfo() {
        return com.mob.tools.a.c.a(this.b).b().V();
    }

    public String getTimezone() {
        return com.mob.tools.a.c.a(this.b).b().ak();
    }

    public Activity getTopActivity() {
        return null;
    }

    public HashMap<String, Object> getTraffic() {
        return com.mob.tools.a.c.a(this.b).b().ap();
    }

    public String getUD() {
        return com.mob.tools.a.c.a(this.b).b().bb();
    }

    public String getVD() {
        return com.mob.tools.a.c.a(this.b).b().ba();
    }

    public void hideSoftInput(View view) {
        com.mob.tools.a.c.a(this.b).b().a(view);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) {
        try {
            return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }

    public boolean isFakePass(String str) {
        return com.mob.tools.a.c.a(this.b).b().a(str);
    }

    public boolean isInMainProcess() {
        return com.mob.tools.a.c.a(this.b).b().aI();
    }

    public boolean isPackageInstalled(String str) {
        return com.mob.tools.a.c.a(this.b).b().e(str);
    }

    public boolean isRooted() {
        return com.mob.tools.a.c.a(this.b).b().a();
    }

    public boolean isSensitiveDevice() {
        return com.mob.tools.a.c.a(this.b).b().k();
    }

    public boolean isSmlt() {
        return com.mob.tools.a.c.a(this.b).b().j();
    }

    public boolean isWifiProxy() {
        return com.mob.tools.a.c.a(this.b).b().i();
    }

    public String[] queryIMEI() {
        return com.mob.tools.a.c.a(this.b).b().C();
    }

    public String[] queryIMSI() {
        return com.mob.tools.a.c.a(this.b).b().q();
    }

    public List<ResolveInfo> queryIntentServices(Intent intent, int i) {
        return com.mob.tools.a.c.a(this.b).b().a(intent, i);
    }

    public void regReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) throws Throwable {
        com.mob.tools.a.c.a(this.b).b().a(broadcastReceiver, intentFilter);
    }

    public void registerWifiScanReceiver(BlockingQueue<Boolean> blockingQueue) {
        com.mob.tools.a.c.a(this.b).b().a(blockingQueue);
    }

    public ResolveInfo resolveActivity(Intent intent, int i) {
        return com.mob.tools.a.c.a(this.b).b().b(intent, i);
    }

    public boolean scanWifiList() {
        return com.mob.tools.a.c.a(this.b).b().P();
    }

    public void showSoftInput(View view) {
        com.mob.tools.a.c.a(this.b).b().b(view);
    }

    public void unregReceiver(BroadcastReceiver broadcastReceiver) throws Throwable {
        com.mob.tools.a.c.a(this.b).b().a(broadcastReceiver);
    }

    public boolean usbEnable() {
        return com.mob.tools.a.c.a(this.b).b().h();
    }

    public boolean vpn() {
        return com.mob.tools.a.c.a(this.b).b().e();
    }

    public ApplicationInfo getAInfo(String str, int i) {
        return com.mob.tools.a.c.a(this.b).b().a(str, i);
    }

    public String getAppName(String str) {
        return com.mob.tools.a.c.a(this.b).b().g(str);
    }

    public String getCarrier(boolean z) {
        return com.mob.tools.a.c.a(this.b).b().c(z);
    }

    public String getCarrierName(boolean z) {
        return com.mob.tools.a.c.a(this.b).b().d(z);
    }

    public String getDeviceKey(boolean z) {
        return com.mob.tools.a.c.a(this.b).b().g(z);
    }

    public String getNetworkType(boolean z) {
        return com.mob.tools.a.c.a(this.b).b().e(z);
    }

    public PackageInfo getPInfo(boolean z, String str, int i) {
        return com.mob.tools.a.c.a(this.b).b().a(z, 0, str, i);
    }

    public String getSignMD5(String str) {
        return com.mob.tools.a.c.a(this.b).b().f(str);
    }

    public PackageInfo getPInfo(int i, String str, int i2) {
        return com.mob.tools.a.c.a(this.b).b().a(false, i, str, i2);
    }

    public <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) {
        try {
            return (T) ReflectHelper.invokeInstanceMethod(obj, str, objArr, clsArr);
        } catch (Throwable th) {
            MobLog.getInstance().d(th);
            return null;
        }
    }
}
