package defpackage;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* compiled from: MainDispatchers.kt */
/* renamed from: ɗ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2575 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final boolean f9584 = true;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C4907 m9431(Throwable th, String str) throws Throwable {
        if (f9584) {
            return new C4907(th, str);
        }
        if (th != null) {
            throw th;
        }
        m9433();
        throw new KotlinNothingValueException();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ C4907 m9432(Throwable th, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return m9431(th, str);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final Void m9433() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final AbstractC3847 m9434(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return m9431(th, mainDispatcherFactory.hintOnError());
        }
    }
}
