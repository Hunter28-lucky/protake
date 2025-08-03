package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.blink.academy.film.FilmApp;
import com.mob.pushsdk.plugins.huawei.compat.PushHuaWeiCompat;
import java.util.Arrays;

/* compiled from: DeviceInfo.java */
/* renamed from: ε, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2813 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String[] f10258 = {"OS105", "OC105", "MI 8", "MI 9", "PBCM30", "SM-G6200"};

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final String[] f10259 = {"HMA-L09", "HMA-L29", "HMA-AL00", "HMA-TL00", "LYA-L0C", "LYA-L29", "LYA-AL00", "LYA-AL10", "LYA-L09", "LYA-TL00", "TAS-AN00", "TAS-TN00", "TAS-AL00", "TAS-TL00", "LIO-AN00", "LIO-TN00", "LIO-AL00", "LIO-TL00", "EML-AL00", "EML-L09", "EML-L29", "EML-TL00", "EML-L09C", "HW-01K", "CLT-AL00", "CLT-AL00l", "CLT-AL01", "CLT-L04", "CLT-L09", "CLT-L29", "CLT-TL00", "CLT-TL01", "CLT-L29C", "CLT-L09C", "ELE-AL00", "ELE-L04", "ELE-L09", "ELE-L14", "ELE-L29", "ELE-L39", "ELE-L49", "ELE-TL00", "HW-02L", "VOG-AL00", "VOG-AL10", "VOG-L04", "VOG-L09", "VOG-L29", "VOG-TL00", "LIO-AN00P", "NEY-AN00", "FRO-AN00", "ELS-AN00"};

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean f10260 = false;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean f10261 = true;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String f10262 = "";

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static long f10263 = 0;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static String f10264 = "10.0.0";

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean f10265 = false;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static boolean f10266 = false;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String f10267 = "";

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String f10268 = "";

    /* renamed from: ֏, reason: contains not printable characters */
    public static String f10269 = Build.MODEL;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static String f10270 = Build.MANUFACTURER;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static String f10271 = Build.DEVICE;

    /* renamed from: ހ, reason: contains not printable characters */
    public static String f10272 = Build.PRODUCT;

    /* renamed from: ށ, reason: contains not printable characters */
    public static boolean f10273 = false;

    /* renamed from: ނ, reason: contains not printable characters */
    public static boolean f10274 = false;

    /* renamed from: ރ, reason: contains not printable characters */
    public static boolean f10275 = false;

    /* renamed from: ބ, reason: contains not printable characters */
    public static boolean f10276 = false;

    /* renamed from: ޅ, reason: contains not printable characters */
    public static boolean f10277 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m10148() {
        String strM9303 = C2514.m9301().m9303("ro.board.platform", "");
        f10267 = strM9303;
        C4638.m14099("BuildProperties", String.format("%s : %s ", "ro.board.platform", strM9303));
        if (TextUtils.isEmpty(f10267)) {
            String strM9302 = C2514.m9301().m9302("ro.board.platform");
            f10267 = strM9302;
            C4638.m14099("BuildProperties", String.format("info platform : %s ", strM9302));
        }
        String strM93032 = C2514.m9301().m9303("ro.build.product", "");
        f10268 = strM93032;
        C4638.m14099("BuildProperties", String.format("%s : %s ", "ro.build.product", strM93032));
        if (TextUtils.isEmpty(f10268)) {
            String strM93022 = C2514.m9301().m9302("ro.build.product");
            f10268 = strM93022;
            C4638.m14099("BuildProperties", String.format("info product : %s ", strM93022));
        }
        String strM93033 = C2514.m9301().m9303("ro.build.version.emui", "");
        f10264 = strM93033;
        C4638.m14099("BuildProperties", String.format("%s : %s ", "ro.build.version.emui", strM93033));
        if (TextUtils.isEmpty(f10264)) {
            String strM93023 = C2514.m9301().m9302("ro.build.version.emui");
            f10264 = strM93023;
            C4638.m14099("BuildProperties", String.format("info emui : %s ", strM93023));
        }
        if (!TextUtils.isEmpty(f10264)) {
            String[] strArrSplit = f10264.split("_");
            C4638.m14099("BuildProperties", String.format("split : %s ", Arrays.toString(strArrSplit)));
            if (strArrSplit.length > 1) {
                String str = strArrSplit[1];
                boolean zM10149 = m10149(str, "10.0.99");
                f10265 = zM10149;
                C4638.m14099("BuildProperties", String.format("s1 : %s , isSupportHwCameraSdk : %s ", str, Boolean.valueOf(zM10149)));
            }
        }
        f10262 = C4665.m14150(FilmApp.m405().getApplicationContext());
        String str2 = Build.MANUFACTURER;
        f10260 = PushHuaWeiCompat.NAME.equalsIgnoreCase(str2);
        f10277 = "Samsung".equalsIgnoreCase(str2);
        C4638.m14099("BuildProperties", String.format("model : %s , manufacturer : %s , device : %s , product : %s , roBuildProduct : %s , roBoardPlatform : %s ", f10269, f10270, f10271, f10272, f10268, f10267));
        String[] strArr = f10258;
        if (r1.m8142(strArr)) {
            for (String str3 : strArr) {
                if (str3.equalsIgnoreCase(Build.MODEL)) {
                    f10273 = true;
                }
            }
        }
        if (f10260) {
            for (String str4 : f10259) {
                if (str4.equalsIgnoreCase(Build.MODEL)) {
                    f10274 = true;
                }
            }
            String str5 = Build.MODEL;
            if ("NEY-AN00".equalsIgnoreCase(str5) || "FRO-AN00".equalsIgnoreCase(str5) || "ELS-AN00".equalsIgnoreCase(str5)) {
                f10276 = true;
            }
            if (f10265) {
                if ("ELS-AN00".equalsIgnoreCase(str5) || "LIO-AL00".equalsIgnoreCase(str5)) {
                    f10266 = true;
                }
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static boolean m10149(String str, String str2) {
        boolean z;
        if (str.equals(str2)) {
            return false;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        int length = strArrSplit.length < strArrSplit2.length ? strArrSplit.length : strArrSplit2.length;
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(strArrSplit2[i]) < Integer.parseInt(strArrSplit[i])) {
                z = true;
                break;
            }
            if (Integer.parseInt(strArrSplit2[i]) > Integer.parseInt(strArrSplit[i])) {
                break;
            }
        }
        z = false;
        C4638.m14099("BuildProperties", String.format("version : %s , compareToVersion : %s , result : %s ", str, str2, Boolean.valueOf(z)));
        return z;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static boolean m10150() {
        return Build.VERSION.SDK_INT >= 26;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m10151() {
        return Build.VERSION.SDK_INT >= 29;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m10152(String str) {
        if ("LIO-AL00".equalsIgnoreCase(f10269) || "LIO-TN00".equalsIgnoreCase(f10269) || "TAS-AN00".equalsIgnoreCase(f10269) || "TAS-TN00".equalsIgnoreCase(f10269) || "TAS-AL00".equalsIgnoreCase(f10269) || "TAS-TL00".equalsIgnoreCase(f10269) || "LIO-AN00".equalsIgnoreCase(f10269) || "LIO-TL00".equalsIgnoreCase(f10269) || "LIO-AN00P".equalsIgnoreCase(f10269)) {
            return "0".equalsIgnoreCase(str) || "2".equalsIgnoreCase(str);
        }
        return false;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean m10153() {
        String str = Build.MODEL;
        return "INE-AL00".equalsIgnoreCase(str) || "JAT-AL00".equalsIgnoreCase(str) || "JSN-AL00a".equalsIgnoreCase(str) || "POT-AL00a".equalsIgnoreCase(str) || "JKM-AL00a".equalsIgnoreCase(str) || "DRA-AL00".equalsIgnoreCase(str) || "TRT-AL00".equalsIgnoreCase(str) || "COR-AL00".equalsIgnoreCase(str);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean m10154() {
        String str = Build.MODEL;
        return "YAL-AL10".equalsIgnoreCase(str) || "TNY-AL00".equalsIgnoreCase(str) || "BKL-AL00".equalsIgnoreCase(str) || "COR-AL00".equalsIgnoreCase(str) || "HWI-AL00".equalsIgnoreCase(str) || "HWI-TL00".equalsIgnoreCase(str) || "MAR-AL00".equalsIgnoreCase(str) || "MAR-TL00".equalsIgnoreCase(str);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean m10155() {
        return "BKL-AL00".equalsIgnoreCase(f10269) || "COL-AL00".equalsIgnoreCase(f10269) || "COL-AL10".equalsIgnoreCase(f10269) || "COR-L29".equalsIgnoreCase(f10269) || "COR-TL10".equalsIgnoreCase(f10269) || "BKL-AL20".equalsIgnoreCase(f10269) || "COL-TL00".equalsIgnoreCase(f10269) || "COL-TL10".equalsIgnoreCase(f10269) || "COR-AL00".equalsIgnoreCase(f10269) || "PAR-AL00".equalsIgnoreCase(f10269) || "PAR-TL00".equalsIgnoreCase(f10269) || "PAR-TL20".equalsIgnoreCase(f10269) || "PAR-L21".equalsIgnoreCase(f10269) || "PAR-L29".equalsIgnoreCase(f10269) || "PAR-LX1".equalsIgnoreCase(f10269) || "PAR-LX1M".equalsIgnoreCase(f10269) || "PAR-LX90".equalsIgnoreCase(f10269) || "HWI-AL00".equalsIgnoreCase(f10269) || "HWI-TL00".equalsIgnoreCase(f10269) || "JNY-AL10".equalsIgnoreCase(f10269);
    }
}
