package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;

/* compiled from: DensityUtil.java */
/* renamed from: ɛ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2579 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int f9593 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int f9594 = 0;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int f9595 = 0;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int f9596 = 0;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int f9597 = 0;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int f9598 = 0;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int f9599 = 0;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int f9600 = 0;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static int f9601 = -1;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m9438(float f) {
        float fM14455;
        if (f9597 != 0) {
            fM14455 = C4792.m14375().m14455(1125.0f);
            f *= 3.0f;
        } else {
            fM14455 = Resources.getSystem().getDisplayMetrics().density;
        }
        return (int) ((f * fM14455) + 0.5f);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m9439(Context context) {
        int iMax = Math.max(f9598, f9597);
        f9599 = iMax;
        if (iMax != 0) {
            return iMax;
        }
        C4792.m14375().m14493(context);
        return f9599;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m9440(Context context) {
        int iMin = Math.min(f9598, f9597);
        f9600 = iMin;
        if (iMin != 0) {
            return iMin;
        }
        C4792.m14375().m14493(context);
        return f9600;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static int m9441() {
        return (int) (Resources.getSystem().getDisplayMetrics().density + 0.5f);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static int m9442(Context context) {
        if (context == null) {
            return 0;
        }
        int i = f9593;
        return i != 0 ? i : context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static int m9443(Context context) {
        if (context == null) {
            return 0;
        }
        int i = f9594;
        return i != 0 ? i : context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m9444() {
        int i = f9594;
        int i2 = f9593;
        return i > i2 ? i : i2;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int m9445() {
        int i = f9594;
        int i2 = f9593;
        return i < i2 ? i : i2;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static int m9446(Activity activity) {
        return activity.getRequestedOrientation();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int m9447() {
        return f9601;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int m9448(Context context) {
        if (f9601 == -1) {
            f9601 = 0;
            int iM9445 = m9445();
            int iM9440 = (iM9445 - ((int) (m9440(context) * 0.9f))) / 2;
            if (iM9440 > 0 && iM9440 > C4792.m14375().m14440(context) - 10) {
                f9601 = (iM9445 - m9440(context)) / 2;
            }
        }
        return f9601;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static int m9449(Context context) {
        int i = f9597;
        if (i != 0) {
            return i;
        }
        C4792.m14375().m14493(context);
        return f9597;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static int m9450(Context context) {
        int i = f9598;
        if (i != 0) {
            return i;
        }
        C4792.m14375().m14493(context);
        return f9598;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static boolean m9451(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3 && (((float) Math.max(f9593, f9594)) * 1.0f) / ((float) Math.min(f9593, f9594)) < 1.7777778f;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static boolean m9452(Context context) {
        return m9451(context) && m9448(context) != 0;
    }
}
