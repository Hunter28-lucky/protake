package com.jakewharton.rxrelay2;

import defpackage.InterfaceC5102;

/* loaded from: classes2.dex */
final class SerializedRelay<T> extends Relay<T> {
    private final Relay<T> actual;
    private boolean emitting;
    private AppendOnlyLinkedArrayList<T> queue;

    public SerializedRelay(Relay<T> relay) {
        this.actual = relay;
    }

    private void emitLoop() {
        AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList;
        while (true) {
            synchronized (this) {
                appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    this.emitting = false;
                    return;
                }
                this.queue = null;
            }
            appendOnlyLinkedArrayList.accept(this.actual);
        }
    }

    @Override // com.jakewharton.rxrelay2.Relay, defpackage.InterfaceC2857
    public void accept(T t) {
        synchronized (this) {
            if (!this.emitting) {
                this.emitting = true;
                this.actual.accept(t);
                emitLoop();
            } else {
                AppendOnlyLinkedArrayList<T> appendOnlyLinkedArrayList = this.queue;
                if (appendOnlyLinkedArrayList == null) {
                    appendOnlyLinkedArrayList = new AppendOnlyLinkedArrayList<>(4);
                    this.queue = appendOnlyLinkedArrayList;
                }
                appendOnlyLinkedArrayList.add(t);
            }
        }
    }

    @Override // com.jakewharton.rxrelay2.Relay
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }

    @Override // defpackage.AbstractC4262
    public void subscribeActual(InterfaceC5102<? super T> interfaceC5102) {
        this.actual.subscribe(interfaceC5102);
    }
}
