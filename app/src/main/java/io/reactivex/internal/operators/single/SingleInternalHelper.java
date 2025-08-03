package io.reactivex.internal.operators.single;

import defpackage.AbstractC4262;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC3951;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;

/* loaded from: classes2.dex */
public final class SingleInternalHelper {

    public enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    public enum ToFlowable implements InterfaceC2368<InterfaceC3951, Publisher> {
        INSTANCE;

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Publisher apply(InterfaceC3951 interfaceC3951) {
            return new SingleToFlowable(interfaceC3951);
        }
    }

    public enum ToObservable implements InterfaceC2368<InterfaceC3951, AbstractC4262> {
        INSTANCE;

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4262 apply(InterfaceC3951 interfaceC3951) {
            return new SingleToObservable(interfaceC3951);
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> Callable<NoSuchElementException> m6954() {
        return NoSuchElementCallable.INSTANCE;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> InterfaceC2368<InterfaceC3951<? extends T>, Publisher<? extends T>> m6955() {
        return ToFlowable.INSTANCE;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> InterfaceC2368<InterfaceC3951<? extends T>, AbstractC4262<? extends T>> m6956() {
        return ToObservable.INSTANCE;
    }
}
