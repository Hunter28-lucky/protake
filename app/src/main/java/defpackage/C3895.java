package defpackage;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserModel;

/* compiled from: MemorySizeCalculator.java */
/* renamed from: ࠊ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3895 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f13479;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int f13480;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Context f13481;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f13482;

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: ࠊ$Ϳ, reason: contains not printable characters */
    public static final class C3896 {

        /* renamed from: ԯ, reason: contains not printable characters */
        public static final int f13483;

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Context f13484;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public ActivityManager f13485;

        /* renamed from: ԩ, reason: contains not printable characters */
        public InterfaceC3898 f13486;

        /* renamed from: ԫ, reason: contains not printable characters */
        public float f13488;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float f13487 = 2.0f;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public float f13489 = 0.4f;

        /* renamed from: ԭ, reason: contains not printable characters */
        public float f13490 = 0.33f;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public int f13491 = 4194304;

        static {
            f13483 = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public C3896(Context context) {
            this.f13488 = f13483;
            this.f13484 = context;
            this.f13485 = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            this.f13486 = new C3897(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !C3895.m12567(this.f13485)) {
                return;
            }
            this.f13488 = 0.0f;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C3895 m12572() {
            return new C3895(this);
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: ࠊ$Ԩ, reason: contains not printable characters */
    public static final class C3897 implements InterfaceC3898 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final DisplayMetrics f13492;

        public C3897(DisplayMetrics displayMetrics) {
            this.f13492 = displayMetrics;
        }

        @Override // defpackage.C3895.InterfaceC3898
        /* renamed from: Ϳ, reason: contains not printable characters */
        public int mo12573() {
            return this.f13492.heightPixels;
        }

        @Override // defpackage.C3895.InterfaceC3898
        /* renamed from: Ԩ, reason: contains not printable characters */
        public int mo12574() {
            return this.f13492.widthPixels;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: ࠊ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC3898 {
        /* renamed from: Ϳ */
        int mo12573();

        /* renamed from: Ԩ */
        int mo12574();
    }

    public C3895(C3896 c3896) {
        this.f13481 = c3896.f13484;
        int i = m12567(c3896.f13485) ? c3896.f13491 / 2 : c3896.f13491;
        this.f13482 = i;
        int iM12566 = m12566(c3896.f13485, c3896.f13489, c3896.f13490);
        float fMo12574 = c3896.f13486.mo12574() * c3896.f13486.mo12573() * 4;
        int iRound = Math.round(c3896.f13488 * fMo12574);
        int iRound2 = Math.round(fMo12574 * c3896.f13487);
        int i2 = iM12566 - i;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.f13480 = iRound2;
            this.f13479 = iRound;
        } else {
            float f = i2;
            float f2 = c3896.f13488;
            float f3 = c3896.f13487;
            float f4 = f / (f2 + f3);
            this.f13480 = Math.round(f3 * f4);
            this.f13479 = Math.round(f4 * c3896.f13488);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(m12571(this.f13480));
            sb.append(", pool size: ");
            sb.append(m12571(this.f13479));
            sb.append(", byte array size: ");
            sb.append(m12571(i));
            sb.append(", memory class limited? ");
            sb.append(i3 > iM12566);
            sb.append(", max size: ");
            sb.append(m12571(iM12566));
            sb.append(", memoryClass: ");
            sb.append(c3896.f13485.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(m12567(c3896.f13485));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m12566(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (m12567(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    @TargetApi(19)
    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m12567(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m12568() {
        return this.f13482;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int m12569() {
        return this.f13479;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m12570() {
        return this.f13480;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String m12571(int i) {
        return Formatter.formatFileSize(this.f13481, i);
    }
}
