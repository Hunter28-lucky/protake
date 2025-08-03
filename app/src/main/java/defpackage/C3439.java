package defpackage;

import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import jp.co.cyberagent.android.gpuimage.RenderException;

/* compiled from: FramebufferCache.java */
/* renamed from: ث, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3439 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static boolean f11830 = false;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static C3439 f11831 = new C3439();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f11832 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long f11833 = 1000000000;

    /* renamed from: ԩ, reason: contains not printable characters */
    public long f11834 = 838860800;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Queue<C3440> f11835 = new LinkedList();

    /* renamed from: ԫ, reason: contains not printable characters */
    public Queue<C3440> f11836 = new LinkedList();

    /* compiled from: FramebufferCache.java */
    /* renamed from: ث$Ϳ, reason: contains not printable characters */
    public static final class C3440 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f11837;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f11838;

        /* renamed from: ԩ, reason: contains not printable characters */
        public C2390 f11839;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean f11840;

        /* renamed from: ԫ, reason: contains not printable characters */
        public int f11841;

        public C3440(C2390 c2390, int i, boolean z) {
            this.f11839 = c2390;
            this.f11838 = i;
            this.f11840 = z;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m11216() {
            this.f11837 = System.nanoTime();
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized void m11206(C2390 c2390) {
        this.f11835.add(new C3440(c2390, this.f11832, true));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m11207(long j) {
        long jNanoTime = System.nanoTime();
        Iterator<C3440> it = this.f11836.iterator();
        while (it.hasNext()) {
            C3440 next = it.next();
            C2390 c2390 = next.f11839;
            if (c2390.f8950 == j && jNanoTime - next.f11837 > this.f11833) {
                Log.i("FramebufferCache", String.format("garbage collection removed framebuffer %dx%d", Integer.valueOf(c2390.f8945), Integer.valueOf(c2390.f8946)));
                it.remove();
                c2390.m8880();
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized void m11208() {
        m11209(this.f11835);
        m11209(this.f11836);
        if (f11830) {
            Log.d("FramebufferCache", String.format("destroyAllOnCurrentContext: remaining: %d used, %d free", Integer.valueOf(this.f11835.size()), Integer.valueOf(this.f11836.size())));
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m11209(Queue<C3440> queue) {
        long jM14125 = C4650.m14125();
        Iterator<C3440> it = queue.iterator();
        while (it.hasNext()) {
            C3440 next = it.next();
            if (next.f11839.f8950 == jM14125) {
                it.remove();
                next.f11839.m8880();
            }
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized void m11210() {
        m11207(C4650.m14125());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public synchronized boolean m11211(C2390 c2390) {
        Iterator<C3440> it = this.f11835.iterator();
        while (it.hasNext()) {
            if (it.next().f11839 == c2390) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized void m11212(C2390 c2390) {
        for (C3440 c3440 : this.f11835) {
            if (c3440.f11839 == c2390) {
                c3440.f11841++;
            }
        }
        throw new RenderException("framebuffer not found in used list");
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public synchronized void m11213(C2390 c2390) {
        Iterator<C3440> it = this.f11835.iterator();
        while (it.hasNext()) {
            C3440 next = it.next();
            if (next.f11839 == c2390) {
                if (next.f11841 > 0) {
                    return;
                }
                it.remove();
                if (next.f11840) {
                    return;
                }
                if (next.f11838 != this.f11832) {
                    c2390.m8880();
                    return;
                } else {
                    next.m11216();
                    this.f11836.add(next);
                    return;
                }
            }
        }
        throw new RenderException("framebuffer offered but it's unknown");
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public synchronized C2390 m11214(int i, int i2, int i3) {
        long jM14125 = C4650.m14125();
        Iterator<C3440> it = this.f11836.iterator();
        while (it.hasNext()) {
            C3440 next = it.next();
            C2390 c2390 = next.f11839;
            if (c2390.f8945 == i && c2390.f8946 == i2 && c2390.f8947 == i3 && c2390.f8950 == jM14125) {
                it.remove();
                next.f11838 = this.f11832;
                this.f11835.add(next);
                return c2390;
            }
        }
        C2390 c23902 = new C2390(i, i2, i3);
        this.f11835.add(new C3440(c23902, this.f11832, false));
        return c23902;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public synchronized void m11215(C2390 c2390) {
        Iterator<C3440> it = this.f11835.iterator();
        while (it.hasNext()) {
            if (it.next().f11839 == c2390) {
                r1.f11841--;
            }
        }
        throw new RenderException("framebuffer not found in used list");
    }
}
