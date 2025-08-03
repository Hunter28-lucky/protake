package cn.smssdk.utils;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.mob.MobSDK;
import com.mob.tools.utils.ResHelper;

/* loaded from: classes.dex */
public class SmsResHelper extends ResHelper {
    private static String a = "SmsResHelper";
    private static Resources b;

    public static int getColor(int i) {
        if (b == null) {
            b = MobSDK.getContext().getResources();
        }
        return b.getColor(i);
    }

    public static int getColorSafe(int i, int i2) {
        if (i > 0) {
            try {
                return getColor(i);
            } catch (Resources.NotFoundException unused) {
                SMSLog.getInstance().w(SMSLog.FORMAT, a, "getColorSafe", "Color resource not found. id: " + i);
            }
        }
        return getColor(i2);
    }

    public static int getDimen(int i) {
        if (b == null) {
            b = MobSDK.getContext().getResources();
        }
        return (int) b.getDimension(i);
    }

    public static int getDimenDpSize(int i) {
        return ResHelper.pxToDip(MobSDK.getContext(), getDimenPixelSize(i));
    }

    public static int getDimenDpSizeSafe(int i, int i2) {
        if (i > 0) {
            try {
                return getDimenDpSize(i);
            } catch (Resources.NotFoundException unused) {
                SMSLog.getInstance().w(SMSLog.FORMAT, a, "getDimenDpSizeSafe", "Dimen resource not found. id: " + i);
            }
        }
        return getDimenDpSize(i2);
    }

    public static int getDimenPixelSize(int i) {
        if (b == null) {
            b = MobSDK.getContext().getResources();
        }
        return b.getDimensionPixelSize(i);
    }

    public static int getDimenRes(String str) {
        return ResHelper.getResId(MobSDK.getContext(), "dimen", str);
    }

    public static int getDimenSafe(int i, int i2) {
        if (i > 0) {
            try {
                return getDimen(i);
            } catch (Resources.NotFoundException unused) {
                SMSLog.getInstance().w(SMSLog.FORMAT, a, "getDimenSafe", "Dimen resource not found. id: " + i);
            }
        }
        return getDimen(i2);
    }

    public static int getIconIdSafe(int i) {
        try {
            return MobSDK.getContext().getPackageManager().getApplicationInfo(MobSDK.getContext().getPackageName(), 0).icon;
        } catch (PackageManager.NameNotFoundException unused) {
            SMSLog.getInstance().w(SMSLog.FORMAT, a, "getIconIdSafe", "No icon found");
            try {
                return ResHelper.getBitmapRes(MobSDK.getContext(), "ic_launcher");
            } catch (Throwable unused2) {
                SMSLog.getInstance().w(SMSLog.FORMAT, a, "getIconIdSafe", "No icon named 'ic_launcher' found");
                return i;
            }
        }
    }

    public static String getString(int i) {
        if (b == null) {
            b = MobSDK.getContext().getResources();
        }
        return b.getString(i);
    }

    public static String getStringSafe(int i, int i2) {
        if (i > 0) {
            try {
                return getString(i);
            } catch (Throwable unused) {
                SMSLog.getInstance().w(SMSLog.FORMAT, a, "getStringSafe", "String resource not found. id: " + i);
            }
        }
        return getString(i2);
    }
}
