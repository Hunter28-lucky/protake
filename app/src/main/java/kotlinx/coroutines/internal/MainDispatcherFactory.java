package kotlinx.coroutines.internal;

import defpackage.AbstractC3847;
import java.util.List;

/* compiled from: MainDispatcherFactory.kt */
/* loaded from: classes2.dex */
public interface MainDispatcherFactory {
    AbstractC3847 createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
