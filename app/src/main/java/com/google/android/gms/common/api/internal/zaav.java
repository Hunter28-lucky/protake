package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
abstract class zaav implements Runnable {
    public final /* synthetic */ zaaw zab;

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        this.zab.zab.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    zaa();
                }
            } catch (RuntimeException e2) {
                this.zab.zaa.zam(e2);
            }
        } finally {
            this.zab.zab.unlock();
        }
    }

    @WorkerThread
    public abstract void zaa();
}
