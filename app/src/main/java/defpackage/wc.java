package defpackage;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class wc {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static wc f8714 = new wc();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public long f8715 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long f8716 = 0;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f8717 = 0;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public long f8718 = 0;

    /* renamed from: ԫ, reason: contains not printable characters */
    public long f8719 = 0;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public String f8720;

    /* renamed from: ԭ, reason: contains not printable characters */
    public String f8721;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public String f8722;

    /* renamed from: ԯ, reason: contains not printable characters */
    public String f8723;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m8527(long j) {
        return System.currentTimeMillis() - j < 3600000;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m8528(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static wc m8529() {
        return f8714;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String m8530() {
        long availableBlocks;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            availableBlocks = 0;
        }
        return String.valueOf(availableBlocks);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m8531() {
        long blockSize;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            blockSize = statFs.getBlockSize() * statFs.getAvailableBlocks();
        } else {
            blockSize = 0;
        }
        return String.valueOf(blockSize);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        r0 = r6.substring(r6.indexOf(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) + 1, r6.length()).trim();
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0062 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* renamed from: ֈ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m8532() {
        /*
            java.lang.String r0 = "0000000000000000"
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L4f
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L4f
            java.lang.String r4 = "/proc/cpuinfo"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L4f
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L4f
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L4d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L4d
            java.io.LineNumberReader r4 = new java.io.LineNumberReader     // Catch: java.lang.Throwable -> L51
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L51
            r1 = 1
            r5 = r1
        L1b:
            r6 = 100
            if (r5 >= r6) goto L46
            java.lang.String r6 = r4.readLine()     // Catch: java.lang.Throwable -> L44
            if (r6 == 0) goto L46
            java.lang.String r7 = "Serial"
            int r7 = r6.indexOf(r7)     // Catch: java.lang.Throwable -> L44
            if (r7 < 0) goto L41
            java.lang.String r5 = ":"
            int r5 = r6.indexOf(r5)     // Catch: java.lang.Throwable -> L44
            int r5 = r5 + r1
            int r1 = r6.length()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = r6.substring(r5, r1)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L44
            goto L46
        L41:
            int r5 = r5 + 1
            goto L1b
        L44:
            r1 = r4
            goto L51
        L46:
            r4.close()     // Catch: java.lang.Throwable -> L49
        L49:
            r3.close()     // Catch: java.lang.Throwable -> L5d
            goto L5d
        L4d:
            r3 = r1
            goto L51
        L4f:
            r2 = r1
            r3 = r2
        L51:
            if (r1 == 0) goto L56
            r1.close()     // Catch: java.lang.Throwable -> L56
        L56:
            if (r3 == 0) goto L5b
            r3.close()     // Catch: java.lang.Throwable -> L5b
        L5b:
            if (r2 == 0) goto L60
        L5d:
            r2.close()     // Catch: java.lang.Throwable -> L60
        L60:
            if (r0 != 0) goto L64
            java.lang.String r0 = ""
        L64:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.m8532():java.lang.String");
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m8533(Context context) {
        int i = 0;
        try {
            i = Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0);
        } catch (Throwable unused) {
        }
        return i == 1 ? "1" : "0";
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String m8534() {
        String strM8562 = m8562();
        return !ua.m8370(strM8562) ? strM8562 : m8563();
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static String m8535(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            int i = audioManager.getRingerMode() == 0 ? 1 : 0;
            int streamVolume = audioManager.getStreamVolume(0);
            int streamVolume2 = audioManager.getStreamVolume(1);
            int streamVolume3 = audioManager.getStreamVolume(2);
            int streamVolume4 = audioManager.getStreamVolume(3);
            int streamVolume5 = audioManager.getStreamVolume(4);
            jSONObject.put("ringermode", String.valueOf(i));
            jSONObject.put(NotificationCompat.CATEGORY_CALL, String.valueOf(streamVolume));
            jSONObject.put("system", String.valueOf(streamVolume2));
            jSONObject.put("ring", String.valueOf(streamVolume3));
            jSONObject.put("music", String.valueOf(streamVolume4));
            jSONObject.put(NotificationCompat.CATEGORY_ALARM, String.valueOf(streamVolume5));
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static String m8536() {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String[] strArrSplit;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("/proc/cpuinfo");
            try {
                bufferedReader = new BufferedReader(fileReader);
                try {
                    strArrSplit = bufferedReader.readLine().split(":\\s+", 2);
                } catch (Throwable unused) {
                    fileReader2 = fileReader;
                    if (fileReader2 != null) {
                        try {
                            fileReader2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (bufferedReader == null) {
                        return "";
                    }
                    try {
                        bufferedReader.close();
                        return "";
                    } catch (Throwable unused3) {
                        return "";
                    }
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        if (strArrSplit == null || strArrSplit.length <= 1) {
            try {
                fileReader.close();
            } catch (Throwable unused6) {
            }
            bufferedReader.close();
            return "";
        }
        String str = strArrSplit[1];
        try {
            fileReader.close();
        } catch (Throwable unused7) {
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused8) {
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
    /* renamed from: ށ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m8537(android.content.Context r1) {
        /*
            if (r1 == 0) goto L11
            java.lang.String r0 = "phone"
            java.lang.Object r1 = r1.getSystemService(r0)     // Catch: java.lang.Throwable -> L11
            android.telephony.TelephonyManager r1 = (android.telephony.TelephonyManager) r1     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L11
            java.lang.String r1 = r1.getNetworkOperatorName()     // Catch: java.lang.Throwable -> L11
            goto L12
        L11:
            r1 = 0
        L12:
            if (r1 == 0) goto L1c
            java.lang.String r0 = "null"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1e
        L1c:
            java.lang.String r1 = ""
        L1e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.m8537(android.content.Context):java.lang.String");
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static String m8538() {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader2, 8192);
                try {
                    j = bufferedReader.readLine() != null ? Integer.parseInt(r1.split("\\s+")[1]) : 0L;
                    try {
                        fileReader2.close();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    fileReader = fileReader2;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return String.valueOf(j);
                }
            } catch (Throwable unused4) {
                bufferedReader = null;
            }
        } catch (Throwable unused5) {
            bufferedReader = null;
        }
        try {
            bufferedReader.close();
        } catch (Throwable unused6) {
        }
        return String.valueOf(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* renamed from: ރ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m8539(android.content.Context r3) {
        /*
            if (r3 == 0) goto L4d
            java.lang.String r0 = "sensor"
            java.lang.Object r3 = r3.getSystemService(r0)     // Catch: java.lang.Throwable -> L4d
            android.hardware.SensorManager r3 = (android.hardware.SensorManager) r3     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4d
            r0 = -1
            java.util.List r3 = r3.getSensorList(r0)     // Catch: java.lang.Throwable -> L4d
            if (r3 == 0) goto L4d
            int r0 = r3.size()     // Catch: java.lang.Throwable -> L4d
            if (r0 <= 0) goto L4d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4d
        L22:
            boolean r1 = r3.hasNext()     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L44
            java.lang.Object r1 = r3.next()     // Catch: java.lang.Throwable -> L4d
            android.hardware.Sensor r1 = (android.hardware.Sensor) r1     // Catch: java.lang.Throwable -> L4d
            java.lang.String r2 = r1.getName()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            int r2 = r1.getVersion()     // Catch: java.lang.Throwable -> L4d
            r0.append(r2)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = r1.getVendor()     // Catch: java.lang.Throwable -> L4d
            r0.append(r1)     // Catch: java.lang.Throwable -> L4d
            goto L22
        L44:
            java.lang.String r3 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r3 = defpackage.ua.m8376(r3)     // Catch: java.lang.Throwable -> L4d
            goto L4e
        L4d:
            r3 = 0
        L4e:
            if (r3 != 0) goto L52
            java.lang.String r3 = ""
        L52:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.m8539(android.content.Context):java.lang.String");
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static String m8540() {
        long blockCount;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable unused) {
            blockCount = 0;
        }
        return String.valueOf(blockCount);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static String m8541(Context context) {
        List<Sensor> sensorList;
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            try {
                SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(-1)) != null && sensorList.size() > 0) {
                    for (Sensor sensor : sensorList) {
                        if (sensor != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("name", sensor.getName());
                            jSONObject.put(Constants.VERSION, sensor.getVersion());
                            jSONObject.put("vendor", sensor.getVendor());
                            jSONArray.put(jSONObject);
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return jSONArray.toString();
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static String m8542() {
        long blockSize;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            blockSize = statFs.getBlockSize() * statFs.getBlockCount();
        } else {
            blockSize = 0;
        }
        return String.valueOf(blockSize);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static String m8543(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static String m8544() {
        String str;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Throwable unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static String m8545(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.widthPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static String m8546() {
        String string;
        try {
            string = Locale.getDefault().toString();
        } catch (Throwable unused) {
            string = "";
        }
        return string == null ? "" : string;
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static String m8547(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            StringBuilder sb = new StringBuilder();
            sb.append(displayMetrics.heightPixels);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static String m8548() {
        String displayName;
        try {
            displayName = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            displayName = "";
        }
        return displayName == null ? "" : displayName;
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static String m8549(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            string = "";
        }
        return string == null ? "" : string;
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static String m8550() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            StringBuilder sb = new StringBuilder();
            sb.append(jCurrentTimeMillis - (jCurrentTimeMillis % 1000));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static String m8551(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? String.valueOf(telephonyManager.getNetworkType()) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static String m8552() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SystemClock.elapsedRealtime());
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x001f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: ޑ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m8553(android.content.Context r3) {
        /*
            java.lang.String r0 = ""
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo()
            int r3 = r3.targetSdkVersion
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L1f
            r2 = 29
            if (r1 < r2) goto Lf
            goto L1f
        Lf:
            r2 = 26
            if (r1 < r2) goto L1c
            r1 = 28
            if (r3 < r1) goto L1c
            java.lang.String r3 = defpackage.mb.m7549()     // Catch: java.lang.Throwable -> L1f
            goto L20
        L1c:
            java.lang.String r3 = android.os.Build.SERIAL     // Catch: java.lang.Throwable -> L1f
            goto L20
        L1f:
            r3 = r0
        L20:
            if (r3 != 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.m8553(android.content.Context):java.lang.String");
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static String m8554() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd"};
            sb.append("00" + Constants.COLON_SEPARATOR);
            for (int i = 0; i < 7; i++) {
                sb.append(new File(strArr[i]).exists() ? "1" : "0");
            }
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public static String m8555(Context context) {
        try {
            long jMax = 0;
            if (!((KeyguardManager) context.getSystemService("keyguard")).isKeyguardSecure()) {
                return "0:0";
            }
            String[] strArr = {"/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key"};
            for (int i = 0; i < 5; i++) {
                long jLastModified = -1;
                try {
                    jLastModified = new File(strArr[i]).lastModified();
                } catch (Throwable unused) {
                }
                jMax = Math.max(jLastModified, jMax);
            }
            return "1:" + jMax;
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public static String m8556() {
        String[] strArr = {"dalvik.system.Taint"};
        StringBuilder sb = new StringBuilder();
        sb.append("00");
        sb.append(Constants.COLON_SEPARATOR);
        for (int i = 0; i <= 0; i++) {
            try {
                Class.forName(strArr[0]);
                sb.append("1");
            } catch (Throwable unused) {
                sb.append("0");
            }
        }
        return sb.toString();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public static String m8557(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver.getIntExtra("level", -1);
            int intExtra2 = intentRegisterReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            boolean z = intExtra2 == 2 || intExtra2 == 5;
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "1" : "0");
            sb.append(Constants.COLON_SEPARATOR);
            sb.append(intExtra);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public static String m8558() {
        StringBuilder sb = new StringBuilder();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("/system/build.prop", "ro.product.name=sdk");
        linkedHashMap.put("/proc/tty/drivers", "goldfish");
        linkedHashMap.put("/proc/cpuinfo", "goldfish");
        sb.append("00" + Constants.COLON_SEPARATOR);
        for (String str : linkedHashMap.keySet()) {
            LineNumberReader lineNumberReader = null;
            char c = '0';
            try {
                LineNumberReader lineNumberReader2 = new LineNumberReader(new InputStreamReader(new FileInputStream(str)));
                while (true) {
                    try {
                        String line = lineNumberReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        if (line.toLowerCase().contains((CharSequence) linkedHashMap.get(str))) {
                            c = '1';
                            break;
                        }
                    } catch (Throwable unused) {
                        lineNumberReader = lineNumberReader2;
                        sb.append('0');
                        if (lineNumberReader != null) {
                            lineNumberReader.close();
                        }
                    }
                }
                sb.append(c);
                try {
                    lineNumberReader2.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        }
        return sb.toString();
    }

    /* renamed from: ޗ, reason: contains not printable characters */
    public static String m8559(Context context) {
        if (m8528(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return "";
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            int subtype = activeNetworkInfo.getSubtype();
            return (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) ? "2G" : (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) ? "3G" : subtype == 13 ? "4G" : "UNKNOW";
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: ޘ, reason: contains not printable characters */
    public static String m8560() {
        StringBuilder sb = new StringBuilder();
        sb.append("00" + Constants.COLON_SEPARATOR);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("BRAND", "generic");
        linkedHashMap.put("BOARD", "unknown");
        linkedHashMap.put("DEVICE", "generic");
        linkedHashMap.put("HARDWARE", "goldfish");
        linkedHashMap.put("PRODUCT", "sdk");
        linkedHashMap.put("MODEL", "sdk");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            try {
                String str2 = (String) Build.class.getField(str).get(null);
                String str3 = (String) linkedHashMap.get(str);
                String lowerCase = str2 != null ? str2.toLowerCase() : null;
                if (lowerCase != null && lowerCase.contains(str3)) {
                    c = '1';
                }
            } catch (Throwable unused) {
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* renamed from: ޙ, reason: contains not printable characters */
    public static String m8561() {
        StringBuilder sb = new StringBuilder();
        sb.append("00" + Constants.COLON_SEPARATOR);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            String str2 = (String) linkedHashMap.get(str);
            String strM8372 = ua.m8372(str, "");
            if (strM8372 != null && strM8372.contains(str2)) {
                c = '1';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    /* renamed from: ޚ, reason: contains not printable characters */
    public static String m8562() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq");
            try {
                bufferedReader = new BufferedReader(fileReader, 8192);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileReader = null;
        }
        try {
            line = bufferedReader.readLine();
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused4) {
                }
            }
            if (fileReader == null) {
                return "";
            }
            try {
                fileReader.close();
                return "";
            } catch (Throwable unused5) {
                return "";
            }
        }
        if (ua.m8370(line)) {
            try {
                bufferedReader.close();
            } catch (Throwable unused6) {
            }
            fileReader.close();
            return "";
        }
        String strTrim = line.trim();
        try {
            bufferedReader.close();
        } catch (Throwable unused7) {
        }
        try {
            fileReader.close();
        } catch (Throwable unused8) {
        }
        return strTrim;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
    
        r1 = r2[1].trim();
     */
    /* renamed from: ޛ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m8563() {
        /*
            java.lang.String r0 = "/proc/cpuinfo"
            java.lang.String r1 = ""
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L41
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L41
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3e
            r4 = 8192(0x2000, float:1.148E-41)
            r0.<init>(r3, r4)     // Catch: java.lang.Throwable -> L3e
        L11:
            java.lang.String r2 = r0.readLine()     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L3a
            boolean r4 = defpackage.ua.m8370(r2)     // Catch: java.lang.Throwable -> L3f
            if (r4 != 0) goto L11
            java.lang.String r4 = ":"
            java.lang.String[] r2 = r2.split(r4)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L11
            int r4 = r2.length     // Catch: java.lang.Throwable -> L3f
            r5 = 1
            if (r4 <= r5) goto L11
            r4 = 0
            r4 = r2[r4]     // Catch: java.lang.Throwable -> L3f
            java.lang.String r6 = "BogoMIPS"
            boolean r4 = r4.contains(r6)     // Catch: java.lang.Throwable -> L3f
            if (r4 == 0) goto L11
            r2 = r2[r5]     // Catch: java.lang.Throwable -> L3f
            java.lang.String r1 = r2.trim()     // Catch: java.lang.Throwable -> L3f
        L3a:
            r3.close()     // Catch: java.lang.Throwable -> L49
            goto L49
        L3e:
            r0 = r2
        L3f:
            r2 = r3
            goto L42
        L41:
            r0 = r2
        L42:
            if (r2 == 0) goto L47
            r2.close()     // Catch: java.lang.Throwable -> L47
        L47:
            if (r0 == 0) goto L4c
        L49:
            r0.close()     // Catch: java.lang.Throwable -> L4c
        L4c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wc.m8563():java.lang.String");
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final String m8564() {
        try {
            return String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new nd(this)).length);
        } catch (Throwable unused) {
            return "1";
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final synchronized String m8565(Context context) {
        String str;
        if (m8527(this.f8716) && (str = this.f8721) != null) {
            return str;
        }
        if (m8528(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.f8721 = telephonyManager.getDeviceId();
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f8721 == null) {
            this.f8721 = "";
        }
        this.f8716 = System.currentTimeMillis();
        return this.f8721;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final synchronized String m8566(Context context) {
        String str;
        if (m8527(this.f8715) && (str = this.f8720) != null) {
            return str;
        }
        if (m8528(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    this.f8720 = telephonyManager.getSubscriberId();
                }
            } catch (Throwable unused) {
            }
        }
        if (this.f8720 == null) {
            this.f8720 = "";
        }
        this.f8715 = System.currentTimeMillis();
        return this.f8720;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final synchronized String m8567(Context context) {
        String str;
        if (m8527(this.f8717) && (str = this.f8722) != null) {
            return str;
        }
        if (m8528(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            String simSerialNumber = ((TelephonyManager) context.getSystemService("phone")).getSimSerialNumber();
            this.f8722 = simSerialNumber;
            if (simSerialNumber == null || simSerialNumber.length() == 0) {
                this.f8722 = "";
            }
        } catch (Throwable unused) {
        }
        this.f8717 = System.currentTimeMillis();
        return this.f8722;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final String m8568(Context context) {
        try {
            String strM8559 = m8559(context);
            String strM8569 = m8569();
            if (ua.m8373(strM8559) && ua.m8373(strM8569)) {
                return strM8559 + Constants.COLON_SEPARATOR + m8569();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: ޜ, reason: contains not printable characters */
    public final String m8569() {
        String str;
        if (m8527(this.f8719) && (str = this.f8723) != null) {
            return str;
        }
        this.f8723 = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements() && this.f8723 == null) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                            this.f8723 = inetAddressNextElement.getHostAddress().toString();
                            break;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (this.f8723 == null) {
            this.f8723 = "";
        }
        this.f8719 = System.currentTimeMillis();
        return this.f8723;
    }
}
