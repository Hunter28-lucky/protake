package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class ScheduledDirectTask extends AbstractDirectTask implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        } finally {
            lazySet(AbstractDirectTask.f7645);
            this.runner = null;
        }
    }
}
