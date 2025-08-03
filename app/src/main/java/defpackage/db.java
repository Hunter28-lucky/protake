package defpackage;

import android.util.Log;
import com.zhiyun.protocol.constants.InteractCode;
import com.zhiyun.sdk.util.ArrayUtil;

/* loaded from: classes2.dex */
public class db {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m5925(int i) {
        return m5932(i, InteractCode.WORK_MODE_CODE_R) ? "获取工作模式" : m5932(i, InteractCode.WORK_MODE_CODE_W) ? "设置工作模式" : m5932(i, InteractCode.LOCATION_POINT_STATE_REGISTER) ? "获取使能状态" : m5932(i, InteractCode.LOCATION_SET_POINT_POWERED) ? "设置使能状态" : m5932(i, InteractCode.LOCATION_POINT_CONTROLLER) ? "设置位置定点" : m5932(i, InteractCode.PITCH_ANGLE_R) ? "读取俯仰角度" : m5932(i, InteractCode.PITCH_ROTATE_ANGLE_CONTROL) ? "设置俯仰角度" : m5932(i, InteractCode.ROLL_ANGLE_R) ? "读取横滚角度" : m5932(i, InteractCode.ROLL_ROTATE_ANGLE_CONTROL) ? "设置横滚角度" : m5932(i, InteractCode.YAW_ANGLE_R) ? "读取航向角度" : m5932(i, InteractCode.YAW_ROTATE_ANGLE_CONTROL) ? "设置航向角度" : m5932(i, InteractCode.POINT_MOTION_TIME_LOW_BIT) ? "设置时间低位" : m5932(i, InteractCode.POINT_MOTION_TIME_HIGH_BIT) ? "设置时间高位" : m5932(i, InteractCode.PHONE_CONTROL_MODE) ? "设置手机控制模式" : "未知指令";
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m5926(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = i3;
        }
        m5928(m5934(i, i2));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m5927(int i, int i2, Throwable th) {
        m5935(m5934(i, i2) + "\n " + th.toString());
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m5928(String str) {
        if (m5933(str)) {
            str = "";
        }
        Log.i("ZYDevice", str);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static void m5929(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append((m5933(th) || m5933(th.getMessage())) ? "" : th.getMessage());
        Log.w("ZYDevice", sb.toString());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m5930(String str, byte[] bArr) {
        Log.v("ZYDevice", str + ":  " + ArrayUtil.bytesToHex(bArr));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static void m5931(Throwable th) {
        Log.w("ZYDevice", (m5933(th) || m5933(th.getMessage())) ? "" : th.getMessage());
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static boolean m5932(int i, int i2) {
        return i == i2;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static boolean m5933(Object obj) {
        return obj == null;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m5934(int i, int i2) {
        String strM5925 = m5925(i);
        if (i2 <= 0) {
            return strM5925;
        }
        return strM5925 + ": " + i2;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m5935(String str) {
        if (m5933(str)) {
            str = "";
        }
        Log.w("ZYDevice", str);
    }
}
