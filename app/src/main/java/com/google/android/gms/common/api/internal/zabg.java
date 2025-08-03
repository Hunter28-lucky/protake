package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.3.0 */
/* loaded from: classes2.dex */
abstract class zabg {
    private final zabf zaa;

    public zabg(zabf zabfVar) {
        this.zaa = zabfVar;
    }

    public abstract void zaa();

    public final void zab(zabi zabiVar) {
        zabiVar.zai.lock();
        try {
            if (zabiVar.zan == this.zaa) {
                zaa();
            }
        } finally {
            zabiVar.zai.unlock();
        }
    }
}
