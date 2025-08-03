package kotlinx.coroutines.android;

import android.os.Looper;
import defpackage.AbstractC3847;
import defpackage.C3266;
import defpackage.C3277;
import java.util.List;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes2.dex */
public final class AndroidDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public /* bridge */ /* synthetic */ AbstractC3847 createDispatcher(List list) {
        return createDispatcher((List<? extends MainDispatcherFactory>) list);
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return 1073741823;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public C3277 createDispatcher(List<? extends MainDispatcherFactory> list) {
        return new C3277(C3266.m10935(Looper.getMainLooper(), true), null, 2, null);
    }
}
