package defpackage;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* renamed from: წ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5300 implements InterfaceC2731 {

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final Bitmap.Config f17493 = Bitmap.Config.ARGB_8888;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4483 f17494;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Set<Bitmap.Config> f17495;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final long f17496;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final InterfaceC5301 f17497;

    /* renamed from: ԫ, reason: contains not printable characters */
    public long f17498;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public long f17499;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f17500;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f17501;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f17502;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f17503;

    /* compiled from: LruBitmapPool.java */
    /* renamed from: წ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC5301 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void mo15359(Bitmap bitmap);

        /* renamed from: Ԩ, reason: contains not printable characters */
        void mo15360(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: წ$Ԩ, reason: contains not printable characters */
    public static final class C5302 implements InterfaceC5301 {
        @Override // defpackage.C5300.InterfaceC5301
        /* renamed from: Ϳ */
        public void mo15359(Bitmap bitmap) {
        }

        @Override // defpackage.C5300.InterfaceC5301
        /* renamed from: Ԩ */
        public void mo15360(Bitmap bitmap) {
        }
    }

    public C5300(long j, InterfaceC4483 interfaceC4483, Set<Bitmap.Config> set) {
        this.f17496 = j;
        this.f17498 = j;
        this.f17494 = interfaceC4483;
        this.f17495 = set;
        this.f17497 = new C5302();
    }

    @TargetApi(26)
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static void m15347(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    /* renamed from: ԭ, reason: contains not printable characters */
    public static Bitmap m15348(int i, int i2, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f17493;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @TargetApi(26)
    /* renamed from: ֈ, reason: contains not printable characters */
    public static Set<Bitmap.Config> m15349() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i = Build.VERSION.SDK_INT;
        hashSet.add(null);
        if (i >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static InterfaceC4483 m15350() {
        return new C4821();
    }

    @TargetApi(19)
    /* renamed from: ހ, reason: contains not printable characters */
    public static void m15351(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static void m15352(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        m15351(bitmap);
    }

    @Override // defpackage.InterfaceC2731
    @SuppressLint({"InlinedApi"})
    /* renamed from: Ϳ */
    public void mo9980(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 40) {
            mo9981();
        } else if (i >= 20 || i == 15) {
            m15358(m15357() / 2);
        }
    }

    @Override // defpackage.InterfaceC2731
    /* renamed from: Ԩ */
    public void mo9981() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m15358(0L);
    }

    @Override // defpackage.InterfaceC2731
    /* renamed from: ԩ */
    public synchronized void mo9428(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isRecycled()) {
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            if (bitmap.isMutable() && this.f17494.mo13743(bitmap) <= this.f17498 && this.f17495.contains(bitmap.getConfig())) {
                int iMo13743 = this.f17494.mo13743(bitmap);
                this.f17494.mo13744(bitmap);
                this.f17497.mo15360(bitmap);
                this.f17502++;
                this.f17499 += iMo13743;
                if (Log.isLoggable("LruBitmapPool", 2)) {
                    Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f17494.mo13746(bitmap));
                }
                m15353();
                m15355();
                return;
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f17494.mo13746(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f17495.contains(bitmap.getConfig()));
            }
            bitmap.recycle();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.InterfaceC2731
    @NonNull
    /* renamed from: Ԫ */
    public Bitmap mo9982(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapM15356 = m15356(i, i2, config);
        if (bitmapM15356 == null) {
            return m15348(i, i2, config);
        }
        bitmapM15356.eraseColor(0);
        return bitmapM15356;
    }

    @Override // defpackage.InterfaceC2731
    @NonNull
    /* renamed from: ԫ */
    public Bitmap mo9983(int i, int i2, Bitmap.Config config) {
        Bitmap bitmapM15356 = m15356(i, i2, config);
        return bitmapM15356 == null ? m15348(i, i2, config) : bitmapM15356;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m15353() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m15354();
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m15354() {
        Log.v("LruBitmapPool", "Hits=" + this.f17500 + ", misses=" + this.f17501 + ", puts=" + this.f17502 + ", evictions=" + this.f17503 + ", currentSize=" + this.f17499 + ", maxSize=" + this.f17498 + "\nStrategy=" + this.f17494);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m15355() {
        m15358(this.f17498);
    }

    @Nullable
    /* renamed from: ׯ, reason: contains not printable characters */
    public final synchronized Bitmap m15356(int i, int i2, @Nullable Bitmap.Config config) {
        Bitmap bitmapMo13745;
        m15347(config);
        bitmapMo13745 = this.f17494.mo13745(i, i2, config != null ? config : f17493);
        if (bitmapMo13745 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f17494.mo13742(i, i2, config));
            }
            this.f17501++;
        } else {
            this.f17500++;
            this.f17499 -= this.f17494.mo13743(bitmapMo13745);
            this.f17497.mo15359(bitmapMo13745);
            m15352(bitmapMo13745);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f17494.mo13742(i, i2, config));
        }
        m15353();
        return bitmapMo13745;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public long m15357() {
        return this.f17498;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final synchronized void m15358(long j) {
        while (this.f17499 > j) {
            Bitmap bitmapRemoveLast = this.f17494.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    m15354();
                }
                this.f17499 = 0L;
                return;
            }
            this.f17497.mo15359(bitmapRemoveLast);
            this.f17499 -= this.f17494.mo13743(bitmapRemoveLast);
            this.f17503++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f17494.mo13746(bitmapRemoveLast));
            }
            m15353();
            bitmapRemoveLast.recycle();
        }
    }

    public C5300(long j) {
        this(j, m15350(), m15349());
    }
}
