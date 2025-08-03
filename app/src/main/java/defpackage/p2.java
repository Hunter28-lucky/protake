package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: TimerRecord.java */
/* loaded from: classes.dex */
public abstract class p2 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public HashMap<String, List<Long>> f8238;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public HashMap<String, Long> f8239;

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean f8240;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f8241;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f8242;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f8243;

    public p2() {
        this(30, true, true);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m7886(String str) {
        if (this.f8240) {
            this.f8239.put(str, Long.valueOf(System.nanoTime()));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public abstract void mo7887(String str, double d, int i);

    /* renamed from: ԩ, reason: contains not printable characters */
    public abstract void mo7888(String str, long j);

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m7889(boolean z) {
        this.f8240 = z;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m7890(String str) {
        if (this.f8240) {
            Long l = this.f8239.get(str);
            if (l == null) {
                Log.i("TimerRecord", String.format("call record() with tag %s first", str));
                return;
            }
            long jNanoTime = System.nanoTime() - l.longValue();
            if (this.f8238.get(str) == null) {
                this.f8238.put(str, new ArrayList(this.f8241));
            }
            ArrayList arrayList = (ArrayList) this.f8238.get(str);
            arrayList.add(Long.valueOf(jNanoTime));
            if (this.f8242) {
                mo7888(str, jNanoTime);
            }
            if (arrayList.size() == this.f8241) {
                if (this.f8243) {
                    double dLongValue = 0.0d;
                    while (arrayList.iterator().hasNext()) {
                        dLongValue += ((Long) r3.next()).longValue();
                    }
                    int i = this.f8241;
                    mo7887(str, dLongValue / i, i);
                }
                arrayList.clear();
            }
        }
    }

    public p2(int i, boolean z, boolean z2) {
        this.f8238 = new HashMap<>();
        this.f8239 = new HashMap<>();
        this.f8240 = true;
        this.f8241 = i;
        this.f8242 = z;
        this.f8243 = z2;
    }
}
