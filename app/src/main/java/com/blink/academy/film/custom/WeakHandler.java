package com.blink.academy.film.custom;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class WeakHandler {
    private final Handler.Callback mCallback;
    private final HandlerC0117 mExec;
    private Lock mLock;

    @VisibleForTesting
    public final C0116 mRunnables;

    /* renamed from: com.blink.academy.film.custom.WeakHandler$Ϳ, reason: contains not printable characters */
    public static class C0116 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        @Nullable
        public C0116 f402;

        /* renamed from: Ԩ, reason: contains not printable characters */
        @Nullable
        public C0116 f403;

        /* renamed from: ԩ, reason: contains not printable characters */
        @NonNull
        public final Runnable f404;

        /* renamed from: Ԫ, reason: contains not printable characters */
        @NonNull
        public final RunnableC0118 f405;

        /* renamed from: ԫ, reason: contains not printable characters */
        @NonNull
        public Lock f406;

        public C0116(@NonNull Lock lock, @NonNull Runnable runnable) {
            this.f404 = runnable;
            this.f406 = lock;
            this.f405 = new RunnableC0118(new WeakReference(runnable), new WeakReference(this));
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m502(@NonNull C0116 c0116) {
            this.f406.lock();
            try {
                C0116 c01162 = this.f402;
                if (c01162 != null) {
                    c01162.f403 = c0116;
                }
                c0116.f402 = c01162;
                this.f402 = c0116;
                c0116.f403 = this;
            } finally {
                this.f406.unlock();
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public RunnableC0118 m503() {
            this.f406.lock();
            try {
                C0116 c0116 = this.f403;
                if (c0116 != null) {
                    c0116.f402 = this.f402;
                }
                C0116 c01162 = this.f402;
                if (c01162 != null) {
                    c01162.f403 = c0116;
                }
                this.f403 = null;
                this.f402 = null;
                this.f406.unlock();
                return this.f405;
            } catch (Throwable th) {
                this.f406.unlock();
                throw th;
            }
        }

        @Nullable
        /* renamed from: ԩ, reason: contains not printable characters */
        public RunnableC0118 m504(Runnable runnable) {
            this.f406.lock();
            try {
                for (C0116 c0116 = this.f402; c0116 != null; c0116 = c0116.f402) {
                    if (c0116.f404 == runnable) {
                        return c0116.m503();
                    }
                }
                this.f406.unlock();
                return null;
            } finally {
                this.f406.unlock();
            }
        }
    }

    /* renamed from: com.blink.academy.film.custom.WeakHandler$Ԫ, reason: contains not printable characters */
    public static class RunnableC0118 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final WeakReference<Runnable> f408;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final WeakReference<C0116> f409;

        public RunnableC0118(WeakReference<Runnable> weakReference, WeakReference<C0116> weakReference2) {
            this.f408 = weakReference;
            this.f409 = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.f408.get();
            C0116 c0116 = this.f409.get();
            if (c0116 != null) {
                c0116.m503();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public WeakHandler() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new C0116(reentrantLock, null);
        this.mCallback = null;
        this.mExec = new HandlerC0117();
    }

    private RunnableC0118 wrapRunnable(@NonNull Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("Runnable can't be null");
        }
        C0116 c0116 = new C0116(this.mLock, runnable);
        this.mRunnables.m502(c0116);
        return c0116.f405;
    }

    public final Looper getLooper() {
        return this.mExec.getLooper();
    }

    public final boolean hasMessages(int i) {
        return this.mExec.hasMessages(i);
    }

    public final boolean post(@NonNull Runnable runnable) {
        return this.mExec.post(wrapRunnable(runnable));
    }

    public final boolean postAtFrontOfQueue(Runnable runnable) {
        return this.mExec.postAtFrontOfQueue(wrapRunnable(runnable));
    }

    public final boolean postAtTime(@NonNull Runnable runnable, long j) {
        return this.mExec.postAtTime(wrapRunnable(runnable), j);
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return this.mExec.postDelayed(wrapRunnable(runnable), j);
    }

    public final void removeCallbacks(Runnable runnable) {
        RunnableC0118 runnableC0118M504 = this.mRunnables.m504(runnable);
        if (runnableC0118M504 != null) {
            this.mExec.removeCallbacks(runnableC0118M504);
        }
    }

    public final void removeCallbacksAndMessages(Object obj) {
        this.mExec.removeCallbacksAndMessages(obj);
    }

    public final void removeMessages(int i) {
        this.mExec.removeMessages(i);
    }

    public final boolean sendEmptyMessage(int i) {
        return this.mExec.sendEmptyMessage(i);
    }

    public final boolean sendEmptyMessageAtTime(int i, long j) {
        return this.mExec.sendEmptyMessageAtTime(i, j);
    }

    public final boolean sendEmptyMessageDelayed(int i, long j) {
        return this.mExec.sendEmptyMessageDelayed(i, j);
    }

    public final boolean sendMessage(Message message) {
        return this.mExec.sendMessage(message);
    }

    public final boolean sendMessageAtFrontOfQueue(Message message) {
        return this.mExec.sendMessageAtFrontOfQueue(message);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        return this.mExec.sendMessageAtTime(message, j);
    }

    public final boolean sendMessageDelayed(Message message, long j) {
        return this.mExec.sendMessageDelayed(message, j);
    }

    /* renamed from: com.blink.academy.film.custom.WeakHandler$Ԩ, reason: contains not printable characters */
    public static class HandlerC0117 extends Handler {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final WeakReference<Handler.Callback> f407;

        public HandlerC0117() {
            this.f407 = null;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Handler.Callback callback;
            WeakReference<Handler.Callback> weakReference = this.f407;
            if (weakReference == null || (callback = weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }

        public HandlerC0117(WeakReference<Handler.Callback> weakReference) {
            this.f407 = weakReference;
        }

        public HandlerC0117(Looper looper) {
            super(looper);
            this.f407 = null;
        }

        public HandlerC0117(Looper looper, WeakReference<Handler.Callback> weakReference) {
            super(looper);
            this.f407 = weakReference;
        }
    }

    public final boolean hasMessages(int i, Object obj) {
        return this.mExec.hasMessages(i, obj);
    }

    public final boolean postAtTime(Runnable runnable, Object obj, long j) {
        return this.mExec.postAtTime(wrapRunnable(runnable), obj, j);
    }

    public final void removeMessages(int i, Object obj) {
        this.mExec.removeMessages(i, obj);
    }

    public final void removeCallbacks(Runnable runnable, Object obj) {
        RunnableC0118 runnableC0118M504 = this.mRunnables.m504(runnable);
        if (runnableC0118M504 != null) {
            this.mExec.removeCallbacks(runnableC0118M504, obj);
        }
    }

    public WeakHandler(@Nullable Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new C0116(reentrantLock, null);
        this.mCallback = callback;
        this.mExec = new HandlerC0117((WeakReference<Handler.Callback>) new WeakReference(callback));
    }

    public WeakHandler(@NonNull Looper looper) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new C0116(reentrantLock, null);
        this.mCallback = null;
        this.mExec = new HandlerC0117(looper);
    }

    public WeakHandler(@NonNull Looper looper, @NonNull Handler.Callback callback) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mLock = reentrantLock;
        this.mRunnables = new C0116(reentrantLock, null);
        this.mCallback = callback;
        this.mExec = new HandlerC0117(looper, new WeakReference(callback));
    }
}
