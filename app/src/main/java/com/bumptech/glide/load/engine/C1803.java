package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.C1824;
import defpackage.C4513;
import defpackage.InterfaceC3773;
import defpackage.InterfaceC4536;
import defpackage.j5;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ActiveResources.java */
/* renamed from: com.bumptech.glide.load.engine.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C1803 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean f5235;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Handler f5236 = new Handler(Looper.getMainLooper(), new C1804());

    /* renamed from: ԩ, reason: contains not printable characters */
    @VisibleForTesting
    public final Map<InterfaceC3773, C1807> f5237 = new HashMap();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C1824.InterfaceC1825 f5238;

    /* renamed from: ԫ, reason: contains not printable characters */
    @Nullable
    public ReferenceQueue<C1824<?>> f5239;

    /* renamed from: Ԭ, reason: contains not printable characters */
    @Nullable
    public Thread f5240;

    /* renamed from: ԭ, reason: contains not printable characters */
    public volatile boolean f5241;

    /* renamed from: Ԯ, reason: contains not printable characters */
    @Nullable
    public volatile InterfaceC1806 f5242;

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.Ϳ$Ϳ, reason: contains not printable characters */
    public class C1804 implements Handler.Callback {
        public C1804() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            C1803.this.m4909((C1807) message.obj);
            return true;
        }
    }

    /* compiled from: ActiveResources.java */
    /* renamed from: com.bumptech.glide.load.engine.Ϳ$Ԩ, reason: contains not printable characters */
    public class RunnableC1805 implements Runnable {
        public RunnableC1805() {
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            C1803.this.m4908();
        }
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.Ϳ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC1806 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m4914();
    }

    /* compiled from: ActiveResources.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.Ϳ$Ԭ, reason: contains not printable characters */
    public static final class C1807 extends WeakReference<C1824<?>> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC3773 f5245;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final boolean f5246;

        /* renamed from: ԩ, reason: contains not printable characters */
        @Nullable
        public InterfaceC4536<?> f5247;

        public C1807(@NonNull InterfaceC3773 interfaceC3773, @NonNull C1824<?> c1824, @NonNull ReferenceQueue<? super C1824<?>> referenceQueue, boolean z) {
            super(c1824, referenceQueue);
            this.f5245 = (InterfaceC3773) C4513.m13867(interfaceC3773);
            this.f5247 = (c1824.m4980() && z) ? (InterfaceC4536) C4513.m13867(c1824.m4979()) : null;
            this.f5246 = c1824.m4980();
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m4915() {
            this.f5247 = null;
            clear();
        }
    }

    public C1803(boolean z) {
        this.f5235 = z;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m4907(InterfaceC3773 interfaceC3773, C1824<?> c1824) {
        C1807 c1807Put = this.f5237.put(interfaceC3773, new C1807(interfaceC3773, c1824, m4912(), this.f5235));
        if (c1807Put != null) {
            c1807Put.m4915();
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m4908() {
        while (!this.f5241) {
            try {
                this.f5236.obtainMessage(1, (C1807) this.f5239.remove()).sendToTarget();
                InterfaceC1806 interfaceC1806 = this.f5242;
                if (interfaceC1806 != null) {
                    interfaceC1806.m4914();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m4909(@NonNull C1807 c1807) {
        InterfaceC4536<?> interfaceC4536;
        j5.m7084();
        this.f5237.remove(c1807.f5245);
        if (!c1807.f5246 || (interfaceC4536 = c1807.f5247) == null) {
            return;
        }
        C1824<?> c1824 = new C1824<>(interfaceC4536, true, false);
        c1824.m4982(c1807.f5245, this.f5238);
        this.f5238.mo4948(c1807.f5245, c1824);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m4910(InterfaceC3773 interfaceC3773) {
        C1807 c1807Remove = this.f5237.remove(interfaceC3773);
        if (c1807Remove != null) {
            c1807Remove.m4915();
        }
    }

    @Nullable
    /* renamed from: ԫ, reason: contains not printable characters */
    public C1824<?> m4911(InterfaceC3773 interfaceC3773) {
        C1807 c1807 = this.f5237.get(interfaceC3773);
        if (c1807 == null) {
            return null;
        }
        C1824<?> c1824 = c1807.get();
        if (c1824 == null) {
            m4909(c1807);
        }
        return c1824;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final ReferenceQueue<C1824<?>> m4912() {
        if (this.f5239 == null) {
            this.f5239 = new ReferenceQueue<>();
            Thread thread = new Thread(new RunnableC1805(), "glide-active-resources");
            this.f5240 = thread;
            thread.start();
        }
        return this.f5239;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m4913(C1824.InterfaceC1825 interfaceC1825) {
        this.f5238 = interfaceC1825;
    }
}
