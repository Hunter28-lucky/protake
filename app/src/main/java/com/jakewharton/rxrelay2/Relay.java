package com.jakewharton.rxrelay2;

import defpackage.AbstractC4262;
import defpackage.InterfaceC2857;

/* loaded from: classes2.dex */
public abstract class Relay<T> extends AbstractC4262<T> implements InterfaceC2857<T> {
    public abstract void accept(T t);

    public abstract boolean hasObservers();

    public final Relay<T> toSerialized() {
        return this instanceof SerializedRelay ? this : new SerializedRelay(this);
    }
}
