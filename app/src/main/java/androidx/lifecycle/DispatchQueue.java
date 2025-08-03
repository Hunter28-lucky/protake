package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.umeng.analytics.pro.d;
import defpackage.AbstractC3847;
import defpackage.C2888;
import defpackage.C3921;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;

/* compiled from: DispatchQueue.kt */
/* loaded from: classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void enqueue(Runnable runnable) {
        if (!this.queue.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
        drainQueue();
    }

    @MainThread
    public final boolean canRun() {
        return this.finished || !this.paused;
    }

    @AnyThread
    @SuppressLint({"WrongThread"})
    public final void dispatchAndEnqueue(CoroutineContext coroutineContext, final Runnable runnable) {
        C3921.m12666(coroutineContext, d.R);
        C3921.m12666(runnable, "runnable");
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        if (abstractC3847Mo10951.isDispatchNeeded(coroutineContext) || canRun()) {
            abstractC3847Mo10951.dispatch(coroutineContext, new Runnable() { // from class: androidx.lifecycle.DispatchQueue$dispatchAndEnqueue$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.enqueue(runnable);
                }
            });
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while ((!this.queue.isEmpty()) && canRun()) {
                Runnable runnablePoll = this.queue.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (!(!this.finished)) {
                throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.paused = false;
            drainQueue();
        }
    }
}
