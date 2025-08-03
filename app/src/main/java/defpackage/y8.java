package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class y8 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static /* synthetic */ boolean m8628(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
