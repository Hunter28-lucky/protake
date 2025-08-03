package kotlinx.coroutines;

import defpackage.AbstractC3175;
import defpackage.C4184;
import defpackage.InterfaceC2392;
import java.io.Closeable;
import kotlin.coroutines.CoroutineContext;

/* compiled from: Executors.kt */
/* loaded from: classes2.dex */
public abstract class ExecutorCoroutineDispatcher extends CoroutineDispatcher implements Closeable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final Key f7862 = new Key(null);

    /* compiled from: Executors.kt */
    public static final class Key extends AbstractC3175<CoroutineDispatcher, ExecutorCoroutineDispatcher> {
        public Key() {
            super(CoroutineDispatcher.Key, new InterfaceC2392<CoroutineContext.InterfaceC2140, ExecutorCoroutineDispatcher>() { // from class: kotlinx.coroutines.ExecutorCoroutineDispatcher.Key.1
                @Override // defpackage.InterfaceC2392
                /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
                public final ExecutorCoroutineDispatcher invoke(CoroutineContext.InterfaceC2140 interfaceC2140) {
                    if (interfaceC2140 instanceof ExecutorCoroutineDispatcher) {
                        return (ExecutorCoroutineDispatcher) interfaceC2140;
                    }
                    return null;
                }
            });
        }

        public /* synthetic */ Key(C4184 c4184) {
            this();
        }
    }
}
