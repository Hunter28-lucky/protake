package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bumptech.glide.load.DecodeFormat;
import java.io.File;

/* compiled from: HardwareConfigState.java */
/* renamed from: ƙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2422 {

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final File f9019 = new File("/proc/self/fd");

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static volatile C2422 f9020;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public volatile int f9021;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public volatile boolean f9022 = true;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static C2422 m8917() {
        if (f9020 == null) {
            synchronized (C2422.class) {
                if (f9020 == null) {
                    f9020 = new C2422();
                }
            }
        }
        return f9020;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final synchronized boolean m8918() {
        boolean z = true;
        int i = this.f9021 + 1;
        this.f9021 = i;
        if (i >= 50) {
            this.f9021 = 0;
            int length = f9019.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f9022 = z;
            if (!this.f9022 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + TypedValues.TransitionType.TYPE_DURATION);
            }
        }
        return this.f9022;
    }

    @TargetApi(26)
    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m8919(int i, int i2, BitmapFactory.Options options, DecodeFormat decodeFormat, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || decodeFormat == DecodeFormat.PREFER_ARGB_8888_DISALLOW_HARDWARE || z2) {
            return false;
        }
        boolean z3 = i >= 128 && i2 >= 128 && m8918();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
