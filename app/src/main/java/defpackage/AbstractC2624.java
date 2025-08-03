package defpackage;

import org.reactivestreams.Publisher;

/* compiled from: ParallelFlowable.java */
/* renamed from: ɶ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2624<T> {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> AbstractC2624<T> m9583(Publisher<? extends T> publisher) {
        return m9585(publisher, Runtime.getRuntime().availableProcessors(), AbstractC3630.bufferSize());
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> AbstractC2624<T> m9584(Publisher<? extends T> publisher, int i) {
        return m9585(publisher, i, AbstractC3630.bufferSize());
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> AbstractC2624<T> m9585(Publisher<? extends T> publisher, int i, int i2) {
        C4246.m13353(publisher, "source");
        C4246.m13354(i, "parallelism");
        C4246.m13354(i2, "prefetch");
        return C3671.m11799(new C3942(publisher, i, i2));
    }
}
