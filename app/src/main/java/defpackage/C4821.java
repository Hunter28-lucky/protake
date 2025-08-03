package defpackage;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: SizeConfigStrategy.java */
@RequiresApi(19)
/* renamed from: ඬ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4821 implements InterfaceC4483 {

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final Bitmap.Config[] f16310;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Bitmap.Config[] f16311;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final Bitmap.Config[] f16312;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Bitmap.Config[] f16313;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final Bitmap.Config[] f16314;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4824 f16315 = new C4824();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3467<C4823, Bitmap> f16316 = new C3467<>();

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f16317 = new HashMap();

    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: ඬ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C4822 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f16318;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f16318 = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16318[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16318[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16318[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: ඬ$Ԩ, reason: contains not printable characters */
    public static final class C4823 implements InterfaceC2902 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C4824 f16319;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f16320;

        /* renamed from: ԩ, reason: contains not printable characters */
        public Bitmap.Config f16321;

        public C4823(C4824 c4824) {
            this.f16319 = c4824;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4823)) {
                return false;
            }
            C4823 c4823 = (C4823) obj;
            return this.f16320 == c4823.f16320 && j5.m7086(this.f16321, c4823.f16321);
        }

        public int hashCode() {
            int i = this.f16320 * 31;
            Bitmap.Config config = this.f16321;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return C4821.m14544(this.f16320, this.f16321);
        }

        @Override // defpackage.InterfaceC2902
        /* renamed from: Ϳ */
        public void mo9486() {
            this.f16319.m15089(this);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m14549(int i, Bitmap.Config config) {
            this.f16320 = i;
            this.f16321 = config;
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: ඬ$Ԫ, reason: contains not printable characters */
    public static class C4824 extends AbstractC5163<C4823> {
        @Override // defpackage.AbstractC5163
        /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public C4823 mo9488() {
            return new C4823(this);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public C4823 m14551(int i, Bitmap.Config config) {
            C4823 c4823M15088 = m15088();
            c4823M15088.m14549(i, config);
            return c4823M15088;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f16310 = configArr;
        f16311 = configArr;
        f16312 = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f16313 = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f16314 = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static String m14544(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static Bitmap.Config[] m14545(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f16311;
        }
        int i = C4822.f16318[config.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new Bitmap.Config[]{config} : f16314 : f16313 : f16312 : f16310;
    }

    @Override // defpackage.InterfaceC4483
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapM11304 = this.f16316.m11304();
        if (bitmapM11304 != null) {
            m14546(Integer.valueOf(j5.m7090(bitmapM11304)), bitmapM11304);
        }
        return bitmapM11304;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f16316);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f16317.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f16317.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    @Override // defpackage.InterfaceC4483
    /* renamed from: Ϳ */
    public String mo13742(int i, int i2, Bitmap.Config config) {
        return m14544(j5.m7089(i, i2, config), config);
    }

    @Override // defpackage.InterfaceC4483
    /* renamed from: Ԩ */
    public int mo13743(Bitmap bitmap) {
        return j5.m7090(bitmap);
    }

    @Override // defpackage.InterfaceC4483
    /* renamed from: ԩ */
    public void mo13744(Bitmap bitmap) {
        C4823 c4823M14551 = this.f16315.m14551(j5.m7090(bitmap), bitmap.getConfig());
        this.f16316.m11303(c4823M14551, bitmap);
        NavigableMap<Integer, Integer> navigableMapM14548 = m14548(bitmap.getConfig());
        Integer num = navigableMapM14548.get(Integer.valueOf(c4823M14551.f16320));
        navigableMapM14548.put(Integer.valueOf(c4823M14551.f16320), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // defpackage.InterfaceC4483
    @Nullable
    /* renamed from: Ԫ */
    public Bitmap mo13745(int i, int i2, Bitmap.Config config) {
        C4823 c4823M14547 = m14547(j5.m7089(i, i2, config), config);
        Bitmap bitmapM11300 = this.f16316.m11300(c4823M14547);
        if (bitmapM11300 != null) {
            m14546(Integer.valueOf(c4823M14547.f16320), bitmapM11300);
            bitmapM11300.reconfigure(i, i2, bitmapM11300.getConfig() != null ? bitmapM11300.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return bitmapM11300;
    }

    @Override // defpackage.InterfaceC4483
    /* renamed from: ԫ */
    public String mo13746(Bitmap bitmap) {
        return m14544(j5.m7090(bitmap), bitmap.getConfig());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m14546(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapM14548 = m14548(bitmap.getConfig());
        Integer num2 = navigableMapM14548.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapM14548.remove(num);
                return;
            } else {
                navigableMapM14548.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + mo13746(bitmap) + ", this: " + this);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final C4823 m14547(int i, Bitmap.Config config) {
        C4823 c4823M14551 = this.f16315.m14551(i, config);
        for (Bitmap.Config config2 : m14545(config)) {
            Integer numCeilingKey = m14548(config2).ceilingKey(Integer.valueOf(i));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i * 8) {
                if (numCeilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return c4823M14551;
                        }
                    } else if (config2.equals(config)) {
                        return c4823M14551;
                    }
                }
                this.f16315.m15089(c4823M14551);
                return this.f16315.m14551(numCeilingKey.intValue(), config2);
            }
        }
        return c4823M14551;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final NavigableMap<Integer, Integer> m14548(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f16317.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f16317.put(config, treeMap);
        return treeMap;
    }
}
