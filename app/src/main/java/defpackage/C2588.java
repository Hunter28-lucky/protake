package defpackage;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* compiled from: LruArrayPool.java */
/* renamed from: ɣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2588 implements InterfaceC4950 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C3467<C2589, Object> f9633 = new C3467<>();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2590 f9634 = new C2590();

    /* renamed from: ԩ, reason: contains not printable characters */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f9635 = new HashMap();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Map<Class<?>, InterfaceC4749<?>> f9636 = new HashMap();

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f9637;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f9638;

    /* compiled from: LruArrayPool.java */
    /* renamed from: ɣ$Ϳ, reason: contains not printable characters */
    public static final class C2589 implements InterfaceC2902 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final C2590 f9639;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f9640;

        /* renamed from: ԩ, reason: contains not printable characters */
        public Class<?> f9641;

        public C2589(C2590 c2590) {
            this.f9639 = c2590;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C2589)) {
                return false;
            }
            C2589 c2589 = (C2589) obj;
            return this.f9640 == c2589.f9640 && this.f9641 == c2589.f9641;
        }

        public int hashCode() {
            int i = this.f9640 * 31;
            Class<?> cls = this.f9641;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.f9640 + "array=" + this.f9641 + '}';
        }

        @Override // defpackage.InterfaceC2902
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo9486() {
            this.f9639.m15089(this);
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m9487(int i, Class<?> cls) {
            this.f9640 = i;
            this.f9641 = cls;
        }
    }

    /* compiled from: LruArrayPool.java */
    /* renamed from: ɣ$Ԩ, reason: contains not printable characters */
    public static final class C2590 extends AbstractC5163<C2589> {
        @Override // defpackage.AbstractC5163
        /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public C2589 mo9488() {
            return new C2589(this);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public C2589 m9490(int i, Class<?> cls) {
            C2589 c2589M15088 = m15088();
            c2589M15088.m9487(i, cls);
            return c2589M15088;
        }
    }

    public C2588(int i) {
        this.f9637 = i;
    }

    @Override // defpackage.InterfaceC4950
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        InterfaceC4749<T> interfaceC4749M9479 = m9479(cls);
        int iMo10240 = interfaceC4749M9479.mo10240(t);
        int iMo10238 = interfaceC4749M9479.mo10238() * iMo10240;
        if (m9484(iMo10238)) {
            C2589 c2589M9490 = this.f9634.m9490(iMo10240, cls);
            this.f9633.m11303(c2589M9490, t);
            NavigableMap<Integer, Integer> navigableMapM9482 = m9482(cls);
            Integer num = navigableMapM9482.get(Integer.valueOf(c2589M9490.f9640));
            Integer numValueOf = Integer.valueOf(c2589M9490.f9640);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapM9482.put(numValueOf, Integer.valueOf(iIntValue));
            this.f9638 += iMo10238;
            m9476();
        }
    }

    @Override // defpackage.InterfaceC4950
    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized void mo9471(int i) {
        try {
            if (i >= 40) {
                mo9472();
            } else if (i >= 20 || i == 15) {
                m9477(this.f9637 / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.InterfaceC4950
    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void mo9472() {
        m9477(0);
    }

    @Override // defpackage.InterfaceC4950
    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized <T> T mo9473(int i, Class<T> cls) {
        return (T) m9481(this.f9634.m9490(i, cls), cls);
    }

    @Override // defpackage.InterfaceC4950
    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized <T> T mo9474(int i, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = m9482(cls).ceilingKey(Integer.valueOf(i));
        return (T) m9481(m9485(i, numCeilingKey) ? this.f9634.m9490(numCeilingKey.intValue(), cls) : this.f9634.m9490(i, cls), cls);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m9475(int i, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapM9482 = m9482(cls);
        Integer num = navigableMapM9482.get(Integer.valueOf(i));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapM9482.remove(Integer.valueOf(i));
                return;
            } else {
                navigableMapM9482.put(Integer.valueOf(i), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i + ", this: " + this);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m9476() {
        m9477(this.f9637);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m9477(int i) {
        while (this.f9638 > i) {
            Object objM11304 = this.f9633.m11304();
            C4513.m13867(objM11304);
            InterfaceC4749 interfaceC4749M9478 = m9478(objM11304);
            this.f9638 -= interfaceC4749M9478.mo10240(objM11304) * interfaceC4749M9478.mo10238();
            m9475(interfaceC4749M9478.mo10240(objM11304), objM11304.getClass());
            if (Log.isLoggable(interfaceC4749M9478.mo10239(), 2)) {
                Log.v(interfaceC4749M9478.mo10239(), "evicted: " + interfaceC4749M9478.mo10240(objM11304));
            }
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final <T> InterfaceC4749<T> m9478(T t) {
        return m9479(t.getClass());
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final <T> InterfaceC4749<T> m9479(Class<T> cls) {
        InterfaceC4749<T> c3420 = (InterfaceC4749) this.f9636.get(cls);
        if (c3420 == null) {
            if (cls.equals(int[].class)) {
                c3420 = new C2887();
            } else {
                if (!cls.equals(byte[].class)) {
                    throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
                }
                c3420 = new C3420();
            }
            this.f9636.put(cls, c3420);
        }
        return c3420;
    }

    @Nullable
    /* renamed from: ՠ, reason: contains not printable characters */
    public final <T> T m9480(C2589 c2589) {
        return (T) this.f9633.m11300(c2589);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final <T> T m9481(C2589 c2589, Class<T> cls) {
        InterfaceC4749<T> interfaceC4749M9479 = m9479(cls);
        T t = (T) m9480(c2589);
        if (t != null) {
            this.f9638 -= interfaceC4749M9479.mo10240(t) * interfaceC4749M9479.mo10238();
            m9475(interfaceC4749M9479.mo10240(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Log.isLoggable(interfaceC4749M9479.mo10239(), 2)) {
            Log.v(interfaceC4749M9479.mo10239(), "Allocated " + c2589.f9640 + " bytes");
        }
        return interfaceC4749M9479.newArray(c2589.f9640);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final NavigableMap<Integer, Integer> m9482(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f9635.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9635.put(cls, treeMap);
        return treeMap;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final boolean m9483() {
        int i = this.f9638;
        return i == 0 || this.f9637 / i >= 2;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final boolean m9484(int i) {
        return i <= this.f9637 / 2;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final boolean m9485(int i, Integer num) {
        return num != null && (m9483() || num.intValue() <= i * 8);
    }
}
