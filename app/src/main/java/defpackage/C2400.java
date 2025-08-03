package defpackage;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* renamed from: ż, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2400 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Map<String, C2401> f8973 = new HashMap();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C2402 f8974 = new C2402();

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: ż$Ϳ, reason: contains not printable characters */
    public static class C2401 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Lock f8975 = new ReentrantLock();

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f8976;
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: ż$Ԩ, reason: contains not printable characters */
    public static class C2402 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Queue<C2401> f8977 = new ArrayDeque();

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C2401 m8894() {
            C2401 c2401Poll;
            synchronized (this.f8977) {
                c2401Poll = this.f8977.poll();
            }
            return c2401Poll == null ? new C2401() : c2401Poll;
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public void m8895(C2401 c2401) {
            synchronized (this.f8977) {
                if (this.f8977.size() < 10) {
                    this.f8977.offer(c2401);
                }
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m8892(String str) {
        C2401 c2401M8894;
        synchronized (this) {
            c2401M8894 = this.f8973.get(str);
            if (c2401M8894 == null) {
                c2401M8894 = this.f8974.m8894();
                this.f8973.put(str, c2401M8894);
            }
            c2401M8894.f8976++;
        }
        c2401M8894.f8975.lock();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m8893(String str) {
        C2401 c2401;
        synchronized (this) {
            c2401 = (C2401) C4513.m13867(this.f8973.get(str));
            int i = c2401.f8976;
            if (i < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + c2401.f8976);
            }
            int i2 = i - 1;
            c2401.f8976 = i2;
            if (i2 == 0) {
                C2401 c2401Remove = this.f8973.remove(str);
                if (!c2401Remove.equals(c2401)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + c2401 + ", but actually removed: " + c2401Remove + ", safeKey: " + str);
                }
                this.f8974.m8895(c2401Remove);
            }
        }
        c2401.f8975.unlock();
    }
}
