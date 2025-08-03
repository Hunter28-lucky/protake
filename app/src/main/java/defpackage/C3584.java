package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* compiled from: MainDispatchers.kt */
/* renamed from: ڱ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3584 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3584 f12497;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final boolean f12498;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final AbstractC3847 f12499;

    static {
        C3584 c3584 = new C3584();
        f12497 = c3584;
        f12498 = u0.m8333("kotlinx.coroutines.fast.service.loader", true);
        f12499 = c3584.m11608();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final AbstractC3847 m11608() {
        Object next;
        try {
            List<MainDispatcherFactory> listM12070 = f12498 ? C3770.f13011.m12070() : C4119.m13080(SequencesKt__SequencesKt.m7260(ServiceLoader.load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader()).iterator()));
            Iterator<T> it = listM12070.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return mainDispatcherFactory == null ? C2575.m9432(null, null, 3, null) : C2575.m9434(mainDispatcherFactory, listM12070);
        } catch (Throwable th) {
            return C2575.m9432(th, null, 2, null);
        }
    }
}
