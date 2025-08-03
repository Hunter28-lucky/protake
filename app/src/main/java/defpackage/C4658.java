package defpackage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: LruCache.java */
/* renamed from: ಸ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4658<T, Y> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<T, Y> f15852 = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final long f15853;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f15854;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public long f15855;

    public C4658(long j) {
        this.f15853 = j;
        this.f15854 = j;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14135() {
        m14141(0L);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m14136() {
        m14141(this.f15854);
    }

    @Nullable
    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized Y m14137(@NonNull T t) {
        return this.f15852.get(t);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public synchronized long m14138() {
        return this.f15854;
    }

    /* renamed from: ԯ */
    public int mo9578(@Nullable Y y) {
        return 1;
    }

    /* renamed from: ՠ */
    public void mo9579(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    /* renamed from: ֈ, reason: contains not printable characters */
    public synchronized Y m14139(@NonNull T t, @Nullable Y y) {
        long jMo9578 = mo9578(y);
        if (jMo9578 >= this.f15854) {
            mo9579(t, y);
            return null;
        }
        if (y != null) {
            this.f15855 += jMo9578;
        }
        Y yPut = this.f15852.put(t, y);
        if (yPut != null) {
            this.f15855 -= mo9578(yPut);
            if (!yPut.equals(y)) {
                mo9579(t, yPut);
            }
        }
        m14136();
        return yPut;
    }

    @Nullable
    /* renamed from: ֏, reason: contains not printable characters */
    public synchronized Y m14140(@NonNull T t) {
        Y yRemove;
        yRemove = this.f15852.remove(t);
        if (yRemove != null) {
            this.f15855 -= mo9578(yRemove);
        }
        return yRemove;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public synchronized void m14141(long j) {
        while (this.f15855 > j) {
            Iterator<Map.Entry<T, Y>> it = this.f15852.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f15855 -= mo9578(value);
            T key = next.getKey();
            it.remove();
            mo9579(key, value);
        }
    }
}
