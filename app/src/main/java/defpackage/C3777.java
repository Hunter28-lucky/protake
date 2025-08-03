package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: R8$$SyntheticClass */
/* renamed from: ހ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final /* synthetic */ class C3777 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static /* synthetic */ boolean m12082(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
