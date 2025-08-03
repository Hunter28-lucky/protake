package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: R8$$SyntheticClass */
/* renamed from: ย, reason: contains not printable characters */
/* loaded from: classes.dex */
public final /* synthetic */ class C4905 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static /* synthetic */ boolean m14631(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
