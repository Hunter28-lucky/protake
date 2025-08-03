package com.mob.tools.network;

import com.mob.tools.proguard.EverythingKeeper;

@Deprecated
/* loaded from: classes2.dex */
public abstract class FileDownloadListener implements EverythingKeeper {
    private boolean isCanceled = false;

    public void cancel() {
        this.isCanceled = true;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public abstract void onProgress(int i, long j, long j2);
}
